package com.flashhammer.notification.configuration;

import com.flashhammer.notification.service.WebFluxWebSocketHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import java.util.Map;

@Configuration
public class ReactiveWebSocketConfiguration {

    private final WebFluxWebSocketHandler handler;

    public ReactiveWebSocketConfiguration(WebFluxWebSocketHandler handler) {
        this.handler = handler;
    }

    @Bean
    public HandlerMapping handlerMapping(){
        Map<String, WebFluxWebSocketHandler> handlerMap = Map.of(
                "/uppercase", handler
        );
        return new SimpleUrlHandlerMapping(handlerMap, 1);
    }

}
