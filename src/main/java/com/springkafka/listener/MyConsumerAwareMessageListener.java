package com.springkafka.listener;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.ConsumerAwareMessageListener;

public class MyConsumerAwareMessageListener implements ConsumerAwareMessageListener<String, String> {


    @Override
    public void onMessage(ConsumerRecord<String, String> data, Consumer<?, ?> consumer) {
        System.out.println("Received message: " + data.value());
        // Access consumer information if needed
    }
}
