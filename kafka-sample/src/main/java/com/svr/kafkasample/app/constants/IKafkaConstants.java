package com.svr.kafkasample.app.constants;

/**
 * Hello world!
 *
 */
public class IKafkaConstants 
{
    public static final String ACKS_ALL="all";
    public static final String BOOTSTRAP_SERVER="127.0.0.1:9092";
    public static final String PRODUCER_TOPIC_A ="topic-producer-for-sample-project";
    public static final String CONSUMER_TOPIC_A="topic-producer-for-sample-project";
    public static final String CONSUMER_AUTO_OFFSET_RESET="earliest";
    public static final String CONSUMER_GRP_ID="consumer-sample";
    public static final char FLAG='C';   ///'C' For consumer and 'P' for Producer.

}
