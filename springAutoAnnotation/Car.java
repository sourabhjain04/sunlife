package com.springAutoAnnotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
    @Autowired
    private Engine engine;

    @Override
    public String toString() {
        return "Car{"
                + "engine=" + engine + '}';
    }
}
