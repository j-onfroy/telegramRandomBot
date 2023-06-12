package org.example;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) {
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            MyBot myBot = new MyBot();
            telegramBotsApi.registerBot(myBot);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}