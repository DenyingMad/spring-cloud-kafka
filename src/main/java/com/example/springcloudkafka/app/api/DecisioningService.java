package com.example.springcloudkafka.app.api;

import com.example.springcloudkafka.domain.Decisioning;

public interface DecisioningService {
    void makeDecision(Decisioning decisioning);
}
