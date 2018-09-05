package com.metacube.training;

public class Person {

    String name;
    
    public Person() {
        System.out.println("Person constructor is called");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void checkName() {
        System.out.println("Person function is called");
    }
}
