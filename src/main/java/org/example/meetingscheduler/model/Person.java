package org.example.meetingscheduler.model;

public class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }

    public void email(String message) {
        System.out.println("Email sent to " + name + " for " + message);
    }
}
