package com.example.springcloudkafka.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class Decisioning {
    private UUID id;
    private String details;
}
