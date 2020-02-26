package com.svr.kafkasample.app.constants;

public interface IKafkaConstants {
    String ACKS_ALL = "all";
    String BOOTSTRAP_SERVER = "127.0.0.1:9092";
    String PRODUCER_TOPIC_A = "topic-producer-for-sample-project";
    String CONSUMER_TOPIC_A = "topic-producer-for-sample-project";
    String CONSUMER_AUTO_OFFSET_RESET = "latest";
    String CONSUMER_GRP_ID = "consumer-sample";
    char FLAG = 'C';   ///'C' For consumer and 'P' for Producer.
}
