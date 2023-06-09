package com.course.kafka.kafkaconsumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;
@Service
public class KeyConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KeyConsumer.class);
    //ConsumeRecord representation of a message
    @KafkaListener(topics = "t-multipartition", concurrency = "3")
    public void consume(ConsumerRecord<String, String> consumerRecord) throws InterruptedException {
        LOGGER.info("Key : {}, Partition : {}, Message : {}", consumerRecord.key(), consumerRecord.partition(),
                consumerRecord.value());
        TimeUnit.SECONDS.sleep(1);
    }
}
