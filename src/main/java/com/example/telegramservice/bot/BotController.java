package com.example.telegramservice.bot;

import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.concurrent.CompletableFuture;

@Controller
public class BotController extends TelegramLongPollingBot implements BotService{

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

        System.out.println(update);

        if (update.getMessage().getText().equals("/start")) {

            SendMessage sendMessage = new SendMessage();

            sendMessage.setChatId(String.valueOf(update.getMessage().getChatId()));

            sendMessage.setText("HELLO");

            execute(sendMessage);
        }
    }

    @Override
    public void sendText(String text, String chatId) {
        CompletableFuture.runAsync(() -> {
            SendMessage sendMessage = new SendMessage(chatId, text);
            try {
                if (text.length() > 4096) {
                    sendMessage.setText(text.substring(0, 4096));
                }
                sendApiMethod(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        });
    }
}
