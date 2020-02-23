package com.svr.kafkasample.app.consumer;

import com.svr.kafkasample.app.constants.IKafkaConstants;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.serialization.StringDeserializer;


import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class ConsumerSample {
    public KafkaConsumer createConsumer() {
        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, IKafkaConstants.BOOTSTRAP_SERVER);
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, IKafkaConstants.CONSUMER_AUTO_OFFSET_RESET);
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, IKafkaConstants.CONSUMER_GRP_ID);

        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<String, String>(properties);
        return kafkaConsumer;
    }

    public String consumeFromKafkaTopic(KafkaConsumer kafkaConsumer,String topicName) {
        kafkaConsumer.subscribe(Arrays.asList(IKafkaConstants.CONSUMER_TOPIC_A));
        while (true) {
            ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofMillis(500));
            records.forEach(record -> {
                System.out.println("key: " + record.key() + " topic: " + record.topic() + "value: " + record.value() +
                        "partition: " + record.partition() + "offset: " + record.offset());
            });
        }

    }

}
