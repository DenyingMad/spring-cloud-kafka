package com.example.springcloudkafka.adapter.kafka;

import com.example.springcloudkafka.app.api.DecisioningService;
import com.example.springcloudkafka.domain.Decisioning;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;
import java.util.function.Consumer;

@RequiredArgsConstructor
@Slf4j
@Configuration
public class ListenerConfig {
    private final DecisioningService decisioningService;

    @Bean
    public Consumer<String> consume() {
        return message -> {
            log.info("ReceivedMessage");
            decisioningService.makeDecision(new Decisioning(UUID.randomUUID(), message));
        };
    }
}
