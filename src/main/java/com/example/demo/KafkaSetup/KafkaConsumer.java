package com.example.demo.KafkaSetup;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @KafkaListener(topics = "test-listen-topic-1")
    public void listen_topic_1(String message) {
        System.out.println("Received message: " + message);
    }

    @KafkaListener(topics = "test-listen-topic-2")
    public void listen_topic_2(String message) {
        System.out.println("Received message: " + message);
    }
}
