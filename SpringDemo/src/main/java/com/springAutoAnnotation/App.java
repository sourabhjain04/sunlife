package com.springAutoAnnotation;

import com.SpringAuto.Emp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);


        Car car = (Car) context.getBean("car");
        System.out.println(car);


    }
}
