package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @GetMapping
    public String sayHello(@RequestParam(defaultValue = "World") String name) {
        log.trace("TRACE: Processing request for {}", name);
        log.debug("DEBUG: Input name={}", name);
        log.info("INFO: Saying hello to {}", name);
        log.warn("WARN: Just a sample warning for {}", name);
        log.error("ERROR: Example error log for {}", name);
        return "Hello, " + name + "!";
    }
}
