package com.springlifecycle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {

        System.out.println("Hello World");
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("com/springlifecycle/config.xml");

        Pepsi p2 = (Pepsi) context.getBean("p2");

        System.out.println(p2);
        context.registerShutdownHook();
        System.out.println(p2);
    }
}
