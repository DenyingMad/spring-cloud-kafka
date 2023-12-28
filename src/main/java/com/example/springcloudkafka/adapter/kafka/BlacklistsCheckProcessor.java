package com.example.springcloudkafka.adapter.kafka;

import com.example.springcloudkafka.domain.Decisioning;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.Function;

@Component
public class BlacklistsCheckProcessor implements Function<String, Decisioning> {
    @Override
    public Decisioning apply(String s) {
        return new Decisioning(UUID.randomUUID(), s);
    }
}
