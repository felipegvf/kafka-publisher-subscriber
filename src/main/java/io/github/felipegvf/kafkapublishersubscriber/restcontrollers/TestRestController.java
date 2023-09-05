package io.github.felipegvf.kafkapublishersubscriber.restcontrollers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestRestController {

    @GetMapping
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("Hello");
    }

}
