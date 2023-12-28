package com.example.springcloudkafka.fw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example")
public class SpringCloudKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudKafkaApplication.class, args);
	}

}
