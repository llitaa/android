package com.example.simplebindingdemo;

public class Person {
    public String name;
    public Classification classification;

    public Person(String name, Classification classification) {
        this.name = name;
        this.classification = classification;
    }

    public enum Classification {
        EMPLOYEE,
        CONTRACTOR,
        VENDOR
    }
}
