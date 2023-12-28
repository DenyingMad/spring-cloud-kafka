package com.example.springcloudkafka.fw;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class StreamConfiguration {
    @Value("${spring.cloud.stream.bindings.decisioningRequestListener-in-0.destination}")
    private String decisioningRequestDestination;

    @Value("${spring.cloud.stream.bindings.decisioningResponseSender-out-0.destination}")
    private String decisioningResponseDestination;

    @Value("${spring.cloud.stream.bindings.scoringRequestSender-out-0.destination}")
    private String scoringRequestDestination;


    @Value("${spring.cloud.stream.bindings.scoringResponseListener-in-0.destination}")
    private String scoringResponseDestination;


}
