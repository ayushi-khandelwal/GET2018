package com.metacube.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String args[]) {
        
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        try {
            Person person = (Person) applicationContext.getBean("person");
            person.checkName();
        }
        finally {
            ((AbstractApplicationContext) applicationContext).close();
        }
    }
}
