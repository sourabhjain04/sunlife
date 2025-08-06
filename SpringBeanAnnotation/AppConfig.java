package com.SpringBeanAnnotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Engine engine() {
        // You can customize bean creation here
        return new Engine("V8");
    }

    @Bean
    public Car car() {

        return new Car();
    }
}
