package com.SpringBeanAnnotation;

import org.springframework.beans.factory.annotation.Autowired;

public class Car {
    @Autowired
    private Engine engine;

    public Car() {}

    public Car(Engine engine) {
        this.engine = engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" + "engine=" + engine + '}';
    }
}
