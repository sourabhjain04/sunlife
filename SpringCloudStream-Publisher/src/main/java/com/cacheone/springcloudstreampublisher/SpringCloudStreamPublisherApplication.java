package com.cacheone.springcloudstreampublisher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class SpringCloudStreamPublisherApplication {

    private final StreamBridge streamBridge;

    public SpringCloudStreamPublisherApplication(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    @PostMapping("/publish")
    public Book publishEvent(@RequestBody Book book) {
        Message<Book> message = MessageBuilder.withPayload(book).build();
        streamBridge.send("output-out-0", message);  // Use binding name here
        return book;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudStreamPublisherApplication.class, args);
    }
}

