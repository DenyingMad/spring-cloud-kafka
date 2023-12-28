package com.example.springcloudkafka.adapter.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Slf4j
@Component
public class ScoringResponseListener implements Consumer<String> {
    @Override
    public void accept(String s) {
        log.info("Scoring response received -> {}", s);
    }
}
