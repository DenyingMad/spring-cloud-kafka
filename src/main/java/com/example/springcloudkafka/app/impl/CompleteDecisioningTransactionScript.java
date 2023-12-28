package com.example.springcloudkafka.app.impl;

import com.example.springcloudkafka.adapter.kafka.DecisioningResponseSender;
import com.example.springcloudkafka.domain.Decisioning;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CompleteDecisioningTransactionScript {
    private final DecisioningResponseSender decisioningResponseSender;

    public void execute(Decisioning decisioning) {
        decisioningResponseSender.send(decisioning.getId().toString());
    }
}
