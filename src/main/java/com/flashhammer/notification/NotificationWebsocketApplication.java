package com.flashhammer.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class NotificationWebsocketApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotificationWebsocketApplication.class, args);
    }

}
