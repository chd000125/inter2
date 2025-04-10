package com.example.ticket.service;

import com.example.ticket.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RedisService {

    private final RedisTemplate<String, String> redisTemplate;
    // key -> value
    private final JwtUtil jwtUtil;

    // Redis에서 토큰 가져오기
    public Optional<String> getTokenFromRedis(String userId) {
        String redisKey = "JWT_TOKEN:" + userId;
        String token = redisTemplate.opsForValue().get(redisKey);
        return Optional.ofNullable(token);
    }

    // Redis에서 토큰 가져와 검증하고 클레임 추출
    public Optional<Map<String, Object>> resolveUserClaims(String userId) {
        return getTokenFromRedis(userId)
                .filter(jwtUtil::validateToken)
                .map(jwtUtil::extractClaims);
    }

    //토큰 값, 레빗MQ받아와서 DTO로 값 합쳐서 반환
    public ReservationDTO engraftReservationDTO(String token) {
        Claims bodyClaims = jwtUtil.extractClaims(token);
        Long uId = bodyClaims.get("id", Number.class).longValue();
        String uName = bodyClaims.get("name", String.class);

        // 2. RabbitMQ로 받은 예매 데이터
        Reservation mqReservation = RabbitMQSERVICE.getReservationByUserId(uId);

        // 3. 병합
        return ReservationDTO.builder()
                .uId(bodyClaims.get("id", Number.class).longValue())
                .uName(bodyClaims.get("name", String.class))
                .pId(mqReservation.getPId())
                .pTitle(mqReservation.getPTitle())
                .pPlace(mqReservation.getPPlace())
                .pDate(String.valueOf(mqReservation.getPDate()))
                .pPrice(mqReservation.getPPrice())
                .pAllSpot(mqReservation.getPAllSpot())
                // rId, rSpot 등은 설정하지 않음 (null 그대로 유지)
                .build();
    }


}
