package com.example.springcloudkafka;

import com.example.springcloudkafka.adapter.kafka.DecisioningResponseSender;
import com.example.springcloudkafka.adapter.kafka.ScoringRequestSender;
import com.example.springcloudkafka.fw.SpringCloudKafkaApplication;
import com.example.springcloudkafka.fw.StreamConfiguration;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.function.cloudevent.CloudEventMessageBuilder;
import org.springframework.cloud.stream.binder.test.InputDestination;
import org.springframework.cloud.stream.binder.test.OutputDestination;
import org.springframework.cloud.stream.binder.test.TestChannelBinderConfiguration;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {SpringCloudKafkaApplication.class, TestChannelBinderConfiguration.class})
class SpringCloudKafkaApplicationTests {
    @Autowired
    private InputDestination inputDestination;
    @Autowired
    private OutputDestination outputDestination;
    @Autowired
    private StreamConfiguration streamConfiguration;
    @MockBean
    private StreamBridge streamBridge;
    @Autowired
    private ScoringRequestSender scoringRequestSender;

    @Test
    void testRequestReply() {
        Message<String> message = CloudEventMessageBuilder.withData("message").build();
        inputDestination.send(message, streamConfiguration.getDecisioningRequestDestination());

        Message<byte[]> messageReceived = outputDestination.receive(5000, streamConfiguration.getDecisioningResponseDestination());
        assertEquals(new String(messageReceived.getPayload()), "4510e36f-81bc-4038-9a95-c42e43ab9aba");
    }

    @Test
    void mockTest() {
        when(streamBridge.send(eq(streamConfiguration.getScoringRequestDestination()), any()))
            .then(invocationOnMock -> {
                inputDestination.send(MessageBuilder.withPayload(invocationOnMock.getArgument(1)).build(),
                    streamConfiguration.getScoringResponseDestination());
                return true;
            });

        scoringRequestSender.send("some message");

        outputDestination.receive(0, streamConfiguration.getScoringResponseDestination());
    }
}




