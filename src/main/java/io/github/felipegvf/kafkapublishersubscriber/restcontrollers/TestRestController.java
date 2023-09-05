package io.github.felipegvf.kafkapublishersubscriber.restcontrollers;

import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/test")
public class TestRestController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public TestRestController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping
    public ResponseEntity<String> hello() {

        String message = "teste";

        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send("baeldung", message);

        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Sent message=[" + message + "] with offset=[" + result.getRecordMetadata().offset() + "]");
            } else {
                System.out.println("Unable to send message=[" + message + "] due to : " + ex.getMessage());
            }
        });

        return ResponseEntity.ok("Hello");
    }

}
