package com.svr.kafkasample.app;

import com.svr.kafkasample.app.producer.ProducerSample;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.junit.Test;

public class ProducerSampleTest {

    @Test
    public void testProducer() {
        ProducerSample producerSample = new ProducerSample();
        KafkaProducer<String, String> kafkaProducer = producerSample.createProducer();
        producerSample.produceRecord(kafkaProducer, "Sagar-Keshri");

    }
}
