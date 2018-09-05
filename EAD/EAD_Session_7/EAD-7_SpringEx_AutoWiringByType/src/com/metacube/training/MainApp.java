package com.metacube.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    @SuppressWarnings("resource")
    public static void main(String args[]) {
        
        TextEditor textEditor;
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        textEditor = (TextEditor) applicationContext.getBean("textEditor");
        textEditor.spellCheck();
    }
}
