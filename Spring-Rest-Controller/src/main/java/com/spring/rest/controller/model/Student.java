package com.spring.rest.controller.model;

public class Student {
    private String id;
    private String firstName;
    private String lastName;
    private boolean active;

    public Student(String id, String firstName, String lastName, boolean active) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.active = active;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Student{id='" + id + "', firstName='" + firstName + "', lastName='" + lastName + "', active=" + active + "}";
    }
}
