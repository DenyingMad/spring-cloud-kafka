package com.example.springcloudkafka.app.impl;

import com.example.springcloudkafka.app.api.DecisioningService;
import com.example.springcloudkafka.domain.Decisioning;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DecisioningServiceImpl implements DecisioningService {
    private final CompleteDecisioningTransactionScript completeDecisioning;

    @Override
    public void makeDecision(Decisioning decisioning) {
        // some async process starts
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("Making decision");
        completeDecisioning.execute(decisioning);
    }
}
