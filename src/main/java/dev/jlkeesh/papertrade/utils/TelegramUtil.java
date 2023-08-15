package dev.jlkeesh.papertrade.utils;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class TelegramUtil {
    private final TelegramBot bot;
    private final String chatId;

    public TelegramUtil(@Value("${telegram.bot.token}") String token, @Value("${telegram.bot.chatID}") String chatId) {
        this.bot = new TelegramBot(token);
        this.chatId = chatId;
    }

    @Async
    public void sendMessage(String message) {
        bot.execute(new SendMessage(chatId, message));
    }

}
