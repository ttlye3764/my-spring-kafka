package com.springkafka.listener;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.AcknowledgingConsumerAwareMessageListener;
import org.springframework.kafka.support.Acknowledgment;

public class MyAcknowledgingConsumerAwareMessageListener implements AcknowledgingConsumerAwareMessageListener<String, String> {

    @Override
    public void onMessage(ConsumerRecord<String, String> data, Acknowledgment acknowledgment, Consumer<?, ?> consumer) {
        System.out.println("Received message: " + data.value());
        acknowledgment.acknowledge(); // Manually acknowledge the message
        // Access consumer information if needed
    }
}