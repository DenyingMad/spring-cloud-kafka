package com.example.springcloudkafka.adapter;

import com.example.springcloudkafka.adapter.kafka.DecisioningResponseSender;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/test")
public class TestController {
    private final DecisioningResponseSender sender;

    @PostMapping
    public ResponseEntity<Void> test(@RequestBody String body) {
        sender.send(body);
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }
}
