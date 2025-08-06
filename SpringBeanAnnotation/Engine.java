package com.SpringBeanAnnotation;

public class Engine {
    private String model = "V8";

    public Engine() {}

    public Engine(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Engine{" + "model='" + model + '\'' + '}';
    }
}
