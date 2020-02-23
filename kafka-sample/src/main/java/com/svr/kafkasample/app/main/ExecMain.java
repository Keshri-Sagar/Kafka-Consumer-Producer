package com.svr.kafkasample.app.main;

import com.svr.kafkasample.app.consumer.ConsumerSample;
import com.svr.kafkasample.app.producer.ProducerSample;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ExecMain {
    private static final Logger LOGGER = LogManager.getLogger(ExecMain.class.getName());
    public static void main(String args[]) {

        ProducerSample producerSample = new ProducerSample();
        KafkaProducer producer = producerSample.createProducer();
        String message = "messgae";
        System.out.println("Start Producing messages");
        LOGGER.info("Start Producing messages");
        for (int i = 0; i < 100; i++) {

            producerSample.produceRecord(producer, message+ Integer.toString(i));
        }


    }

}
