package com.SpringAuto;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("com/springAuto/config.xml");

        Emp emp1 = (Emp) context.getBean("emp1");
        System.out.println(emp1);


    }
}
