package com.springkafka.config;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.kafka.listener.CompositeBatchInterceptor;
import org.springframework.stereotype.Component;

@Component
public class CustomConsumerCompositeBatchInterceptor extends CompositeBatchInterceptor<String, String> {

    @Override
    public ConsumerRecords<String, String> intercept(ConsumerRecords<String, String> records, Consumer<String, String> consumer) {
        return super.intercept(records, consumer);
    }

    @Override
    public void success(ConsumerRecords<String, String> records, Consumer<String, String> consumer) {
        super.success(records, consumer);
    }

    @Override
    public void failure(ConsumerRecords<String, String> records, Exception exception, Consumer<String, String> consumer) {
        super.failure(records, exception, consumer);
    }
}
