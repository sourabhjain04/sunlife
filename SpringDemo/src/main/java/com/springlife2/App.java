package com.springlife2;

import com.springlifecycle.Pepsi;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {

        System.out.println("Hello World");
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("com/springlife2/config.xml");

     Example example = (Example) context.getBean("example");


        System.out.println(example);
        context.registerShutdownHook();

    }
}
