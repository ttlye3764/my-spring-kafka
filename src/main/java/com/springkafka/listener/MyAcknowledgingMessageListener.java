package com.springkafka.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.AcknowledgingMessageListener;
import org.springframework.kafka.support.Acknowledgment;

public class MyAcknowledgingMessageListener implements AcknowledgingMessageListener<String, String> {

    @Override
    public void onMessage(ConsumerRecord<String, String> data, Acknowledgment acknowledgment) {
        System.out.println("Received message: " + data.value());
        acknowledgment.acknowledge(); // Manually acknowledge the message
    }
}
