package com.example.springcloudkafka.adapter.kafka;

import com.example.springcloudkafka.app.api.DecisioningService;
import com.example.springcloudkafka.domain.Decisioning;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.Consumer;

@Slf4j
@Component
@RequiredArgsConstructor
public class DecisioningRequestListener implements Consumer<String> {
    private final DecisioningService decisioningService;

    @Override
    public void accept(String message) {
        log.info("Received incoming message. Message : {}", message);
        decisioningService.makeDecision(new Decisioning(UUID.randomUUID(), message));
    }
}
