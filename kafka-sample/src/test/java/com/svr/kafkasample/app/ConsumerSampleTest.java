package com.svr.kafkasample.app;

import com.svr.kafkasample.app.constants.IKafkaConstants;
import com.svr.kafkasample.app.consumer.ConsumerSample;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.junit.Test;


public class ConsumerSampleTest {
    @Test
    public void testConsumer() {
        ConsumerSample consumerSample = new ConsumerSample();
        KafkaConsumer kafkaConsumer = consumerSample.createConsumer();
        consumerSample.consumeFromKafkaTopic(kafkaConsumer, IKafkaConstants.PRODUCER_TOPIC_A);
    }

}
