package edu.du.tokki.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitMQ 설정 클래스: 큐, 익스체인지, 바인딩을 설정
 */
@Configuration
public class RabbitMQConfig {

    // 공연 정보를 전달받을 큐를 생성 (이름: performance.queue)
    @Bean
    public Queue performanceQueue() {
        return new Queue("performance.queue", true); // durable = true (서버 재시작 후에도 유지)
    }

    // 공연 정보를 전달할 토픽 익스체인지를 생성
    @Bean
    public TopicExchange performanceExchange() {
        return new TopicExchange("performance.exchange");
    }

    // 큐와 익스체인지를 바인딩 (routing key: performance.key)
    @Bean
    public Binding performanceBinding(Queue performanceQueue, TopicExchange performanceExchange) {
        return BindingBuilder.bind(performanceQueue).to(performanceExchange).with("performance.key");
    }
}
