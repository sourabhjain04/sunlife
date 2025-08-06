package com.springAutoAnnotation;

import org.springframework.stereotype.Component;

@Component
public class Engine {
    private String model = "V8";
    @Override
    public String toString() { return "Engine{" + "model='" + model + '\'' + '}'; }
}
