package com.springJdbcToJPA.spring_jdbc_to_jpa.entity;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class Person {
    private int id;
    private String namedata;
    private Timestamp timestamp;

    public Person() {

    }

    public Person(int id, String name, Timestamp timestamp) {
        this.id = id;
        this.namedata = name;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return namedata;
    }

    public void setName(String name) {
        this.namedata = name;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + namedata + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
