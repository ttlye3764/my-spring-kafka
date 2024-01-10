package com.springkafka.config;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.CompositeRecordInterceptor;
import org.springframework.stereotype.Component;

@Component
public class CustomConsumerCompositeRecordInterceptor extends CompositeRecordInterceptor<String, String> {

    @Override
    public ConsumerRecord<String, String> intercept(ConsumerRecord<String, String> record, Consumer<String, String> consumer) {
        // 메시지 처리 전에 수행할 로직
        System.out.println("Before processing record...");

        // 실제로는 ConsumerRecord를 수정하거나 새로운 ConsumerRecord를 반환할 수 있습니다.
        // 여기서는 원본 record를 그대로 반환합니다.
        return record;
    }

    @Override
    public void success(ConsumerRecord<String, String> record, Consumer<String, String> consumer) {
        super.success(record, consumer);
    }

    @Override
    public void failure(ConsumerRecord<String, String> record, Exception exception, Consumer<String, String> consumer) {
        super.failure(record, exception, consumer);
    }
}
