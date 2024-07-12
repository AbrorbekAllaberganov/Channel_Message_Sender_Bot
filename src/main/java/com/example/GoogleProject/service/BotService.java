package com.example.GoogleProject.service;

import com.example.GoogleProject.data.BotInfo;
import com.example.GoogleProject.entity.Post;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
public class BotService {

    public int sendMessage(Post post) {
        try {
            String encodedMessage = URLEncoder.encode(post.getTitle() + "\n" + post.getBody(), StandardCharsets.UTF_8);
            String url = String.format(
                    "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s",
                    BotInfo.BOT_TOKEN,
                    BotInfo.CHANNEL_ID,
                    encodedMessage
            );

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(responseBody);

            return jsonNode.path("result").path("message_id").asInt();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
    public boolean editMessage(Long messageId, Post post) {
        try {
            String encodedMessage = URLEncoder.encode(post.getTitle() + "\n" + post.getBody(), StandardCharsets.UTF_8);

            String url = String.format(
                    "https://api.telegram.org/bot%s/editMessageText?chat_id=%s&message_id=%d&text=%s",
                    BotInfo.BOT_TOKEN,
                    BotInfo.CHANNEL_ID,
                    messageId,
                    encodedMessage
            );

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(responseBody);
            boolean isSuccess = jsonNode.path("ok").asBoolean();
            System.out.println(isSuccess);
            return isSuccess;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
