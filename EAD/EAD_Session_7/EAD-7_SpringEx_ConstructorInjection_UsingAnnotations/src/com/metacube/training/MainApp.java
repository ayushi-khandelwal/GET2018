package com.metacube.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MainApp {
    public static void main(String args[]) {
        
        TextEditor textEditor;
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TextEditorConfig.class);
        try {
            textEditor = (TextEditor) applicationContext.getBean(TextEditor.class);
            textEditor.checkSpelling();
        }
        finally {
            ((AbstractApplicationContext) applicationContext).close();
        }
    }
}
