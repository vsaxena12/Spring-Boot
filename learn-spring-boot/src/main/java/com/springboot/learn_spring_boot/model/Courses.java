package com.springboot.learn_spring_boot.model;

public class Courses {
    private int id;
    private String courseName;
    private String author;

    public Courses(int id, String courseName, String author) {
        this.id = id;
        this.courseName = courseName;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
