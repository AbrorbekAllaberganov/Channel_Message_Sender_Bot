package com.example.GoogleProject;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class AdminBotApplication extends TelegramLongPollingBot {
    @Override
    public String getBotToken() {
        return "7396366908:AAFN3OLVXpf1YWGs5SutbSGHC3oVK9IJD6Q";
    }

    @Override
    public String getBotUsername() {
        return "self_project_bot";
    }

    @Override
    public void onUpdateReceived(Update update) {

    }
}
