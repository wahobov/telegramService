package com.example.telegramservice.bot;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Tut1Config {

    @Bean
    public Queue hello() {
        return new Queue("telegram");
    }

    @Bean
    public Tut1Receiver receiver() {
        return new Tut1Receiver();
    }

}
