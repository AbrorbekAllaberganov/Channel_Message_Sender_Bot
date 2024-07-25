package com.example.GoogleProject;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class AdminBotApplication extends TelegramLongPollingBot {
    @Override
    public String getBotToken() {
        return "TOKEN";
    }

    @Override
    public String getBotUsername() {
        return "BOT_USERNAME";
    }

    @Override
    public void onUpdateReceived(Update update) {

    }
}
