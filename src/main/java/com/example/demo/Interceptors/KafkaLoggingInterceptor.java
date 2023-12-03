package com.example.demo.Interceptors;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.TopicPartition;
import org.springframework.stereotype.Component;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.consumer.ConsumerInterceptor;


import java.util.Map;

@Component
@Slf4j
public class KafkaLoggingInterceptor implements ProducerInterceptor<String, String>, ConsumerInterceptor<String, String> {

    @Override
    public void configure(Map<String, ?> configs) {

        log.info("Configuring KafkaLoggingInterceptor with configs: {}", configs);
    }

    @Override
    public ProducerRecord<String, String> onSend(ProducerRecord<String, String> producerRecord) {

        log.info("ProducerInterceptor - Sending message to topic: {}, key: {}, value: {}", producerRecord.topic(), producerRecord.key(), producerRecord.value());
        return producerRecord;
    }

    @Override
    public ConsumerRecords<String, String> onConsume(ConsumerRecords<String, String> records) {

        for (ConsumerRecord<String, String> record : records) {
            log.info("Received message on topic: {}, partition: {}, offset: {}, key: {}, value: {}", record.topic(), record.partition(), record.offset(), record.key(), record.value());
        }
        return records;
    }

    @Override
    public void onAcknowledgement(RecordMetadata recordMetadata, Exception exception) {
        if (recordMetadata != null) {
            log.info("ProducerInterceptor - Message sent successfully to topic: {}, partition: {}, offset: {}", recordMetadata.topic(), recordMetadata.partition(), recordMetadata.offset());
        } else {
            log.error("ProducerInterceptor - Error sending message: {}", exception.getMessage());
        }
    }

    @Override
    public void onCommit(Map<TopicPartition, OffsetAndMetadata> map) {

    }

    @Override
    public void close() {
        log.info("Kafka Shutdown");
    }
}
