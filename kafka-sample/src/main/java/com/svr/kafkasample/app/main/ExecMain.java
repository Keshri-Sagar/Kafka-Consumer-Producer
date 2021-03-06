package com.svr.kafkasample.app.main;

import com.svr.kafkasample.app.constants.IKafkaConstants;
import com.svr.kafkasample.app.consumer.ConsumerSample;
import com.svr.kafkasample.app.producer.ProducerSample;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ExecMain {
    private static final Logger logger = LoggerFactory.getLogger(ExecMain.class);


    public static void main(String args[]) {
       /* if (IKafkaConstants.FLAG == 'C') {
            runConsumer();
        } else if (IKafkaConstants.FLAG == 'P') {
            runProducer();
        } else {
            throw new IllegalArgumentException("This process only used for either Consumer or Producer");
        }*/
        //runProducer();
        runConsumer();
    }

    public static void runProducer() {

        ProducerSample producerSample = new ProducerSample();
        KafkaProducer producer = producerSample.createProducer();
        String message = "messgae";
        logger.info("Start Producing messages");
        int count = 0;
        while (true) {
            count++;
            logger.info("Inside Producer loop");
            producerSample.produceRecord(producer, message + Integer.toString(count));
        }
    }


    public static void runConsumer() {
        logger.info("Inside Consumer Block");
        ConsumerSample consumerSample = new ConsumerSample();
        KafkaConsumer consumer = consumerSample.createConsumer();

        consumerSample.consumeFromKafkaTopic(consumer, IKafkaConstants.CONSUMER_TOPIC_A);

    }

}
