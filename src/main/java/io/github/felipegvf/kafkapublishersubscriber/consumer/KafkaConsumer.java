package io.github.felipegvf.kafkapublishersubscriber.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "baeldung", groupId = "foo")
    public void listenGroupFoo(String message){
        System.out.println("Received Message in group foo: " + message);
    }

    @KafkaListener(topics = "baeldung", groupId = "bar")
    public void listenGroupBar(String message){
        System.out.println("Received Message in group bar: " + message);
    }

}
