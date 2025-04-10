package edu.du.tokki.listener;

import edu.du.tokki.config.RabbitMQConfig;
import edu.du.tokki.dto.PerformanceDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
public class RabbitMQListener {

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)

    public void receive(PerformanceDTO dto) {
        System.out.println("받은공연아이디: " + dto.getPId());
        System.out.println("받은공연장르: " + dto.getPGenre());
        System.out.println("받은공연제목: " + dto.getPTitle());
        System.out.println("받은공연날짜: " + dto.getPDate());
        System.out.println(("받은공연끝시간: " + dto.getPEndTime()));
        System.out.println("받은공연가격: " + dto.getPPrice());
        System.out.println("받은공연장소: " + dto.getPPlace());
        System.out.println("받은공연이미지: " + dto.getPImg());
    }
}
