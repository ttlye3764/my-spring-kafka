package com.springkafka.config;

import com.springkafka.listener.MyAcknowledgingMessageListener;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.support.TopicPartitionOffset;

import java.util.HashMap;
import java.util.Map;

public class KafkaConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Value("${spring.kafka.consumer.group-id}")
    private String groupId;

    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        return new DefaultKafkaConsumerFactory<>(props);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        factory.setConcurrency(3); // 병렬로 메시지를 처리할 수 있는 스레드 수 지정
        factory.setRecordInterceptor(new CustomConsumerCompositeRecordInterceptor());
        factory.set
        return factory;
    }

    @Bean
    public ConcurrentMessageListenerContainer<String, String> concurrentMessageListenerContainer() {

        /**
         * ConcurrentMessageListenerContainer
         * 생성자로 ConsumerFactory<K,V> consumerFactory, ContainerPropperties containerPropperties 를 가짐.
         */

        ContainerProperties containerProps = new ContainerProperties("your_topic_name");
        containerProps.setMessageListener(new MyAcknowledgingMessageListener());
        return new ConcurrentMessageListenerContainer<>(consumerFactory(), containerProps);
    }
}
