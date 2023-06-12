package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

public class MyBot extends TelegramLongPollingBot {

    Random random = new Random();

    @Override
    public void onUpdateReceived(Update update) {
        try {
            if (update.hasMessage()) {
                Message message = update.getMessage();

                System.out.println(LocalTime.now());
                System.out.println(message.getFrom());
                System.out.println();

                if (message.hasText()) {
                    String result;
                    String text = message.getText();
                    if (text.matches("\\d+\\s+\\d+")) {
                        String[] split = text.split("\\s+");
                        int begin = Integer.parseInt(split[0]);
                        int end = Integer.parseInt(split[1]) + 1;
                        int randomNumber = random.nextInt(begin, end);
                        result = String.valueOf(randomNumber);
                    } else {
                        result = message.getFrom().getFirstName() + """
                                
                                This bot return random number between two numbers.
                                Pattern to enter: number space number
                                For example: 15 93""";
                    }

                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setChatId(message.getChatId());
                    sendMessage.setText(result);
                    execute(sendMessage);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "Random7802Bot";
    }

    @Override
    public String getBotToken() {
        return "5850849036:AAEuYqDnuOZuuPj9zSKy0y_1FwsEcabWYNo";
    }
}
