package com.example.telegramservice.bot;

import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Controller
public class BotController extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "@message_broker_bot";
    }

    @Override
    public String getBotToken() {
        return "5436861978:AAEr_Tjvp7sOem8-x12Hpe3gAm3QtOjgcjk";
    }

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {

        if (update.getMessage().getText().equals("/start")) {

            SendMessage sendMessage = new SendMessage();

            sendMessage.setChatId(String.valueOf(update.getMessage().getChatId()));

            sendMessage.setText("HELLO");

            execute(sendMessage);
        }
    }
}
