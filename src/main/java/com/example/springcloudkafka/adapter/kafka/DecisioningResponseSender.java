package com.example.springcloudkafka.adapter.kafka;

import com.example.springcloudkafka.fw.StreamConfiguration;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DecisioningResponseSender {
    private final StreamConfiguration streamConfiguration;
    private final StreamBridge streamBridge;

    public void send(String data) {
        boolean isSuccess = streamBridge.send(streamConfiguration.getDecisioningResponseDestination(), data);
        if (!isSuccess) {
            throw new IllegalArgumentException();
        }
        log.info("Message was sent");
    }
}
