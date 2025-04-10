package edu.du.redis.controller;

import edu.du.redis.dto.RedisUser;
import edu.du.redis.dto.Reservation;
import edu.du.redis.dto.Token;
import edu.du.redis.service.RedisService;
import edu.du.redis.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.JobKOctets;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/test")
public class checkTokenController {
    private final RedisTemplate<Object, Object> redisTemplate;
    @Autowired
    private RedisService redisService;
    private final JwtUtil jwtUtil;

    public checkTokenController(JwtUtil jwtUtil, RedisTemplate<Object, Object> redisTemplate) {
        this.jwtUtil = jwtUtil;
        this.redisTemplate = redisTemplate;
    }

    @PostMapping("/info")
    public Reservation getUserInfo(@RequestBody @RequestParam String key) {
        return redisService.extractUserInfo(key);
    }





//    @GetMapping("/read")
//    public String readToken(@RequestParam String email) {
//        Optional<String> tokenOptional = redisService.getTokenFromRedis(email);
//        if (tokenOptional.isEmpty()) {
//            return "해당 이메일의 토큰이 Redis에 존재하지 않습니다.";
//        }
//
//        String token = tokenOptional.get();
//        Map<String, Object> claims = jwtUtil.extractClaims(token);
//        return claims.toString();
//    }


}
