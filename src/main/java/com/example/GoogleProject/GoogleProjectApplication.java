package com.example.GoogleProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class GoogleProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoogleProjectApplication.class, args);
	}
//
//	@Bean
//	public TelegramBotsApi telegramBotsApi(AdminBotApplication myTelegramBot) {
//		try {
//			TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
//			botsApi.registerBot(myTelegramBot);
//			return botsApi;
//		} catch (TelegramApiException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}

}
