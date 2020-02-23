package com.svr.kafkasample.app.producer;

import com.svr.kafkasample.app.constants.IKafkaConstants;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Properties;


public class ProducerSample {
    private static final Logger LOGGER = LogManager.getLogger(ProducerSample.class.getName());

    public KafkaProducer createProducer() {
        //create producer properties

        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, IKafkaConstants.BOOTSTRAP_SERVER);
        properties.setProperty(ProducerConfig.ACKS_CONFIG, IKafkaConstants.ACKS_ALL);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        LOGGER.info("Creating  Producer to publish messages ");
        //create the producer
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<String, String>(properties);

        LOGGER.info("Producer Created");

        return kafkaProducer;
    }

    public void produceRecord(KafkaProducer kafkaProducer, String messageToSend) {


        //create producer record

        ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>(IKafkaConstants.TOPIC_A, "hello-world");


        //send data

        kafkaProducer.send(producerRecord);
    }


}
