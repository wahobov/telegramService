package com.example.telegramservice.bot;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

@RabbitListener(queues = "telegram")
@RequiredArgsConstructor
public class Tut1Receiver {

    @Autowired
    private BotService botService;

    @RabbitHandler
    public void receive(String a) {
        System.out.println(" [x] Received '" + a + "'");
        botService.sendText(a, "-705484004");
    }
}
