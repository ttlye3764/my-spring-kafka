package com.springkafka.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.BatchMessageListener;

import java.util.List;

public class MyBatchMessageListener implements BatchMessageListener<String, String> {

    @Override
    public void onMessage(List<ConsumerRecord<String, String>> data) {
        for (ConsumerRecord<String, String> record : data) {
            System.out.println("Received message: " + record.value());
        }
    }
}