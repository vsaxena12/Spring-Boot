package com.jdbc.hibernate.dao;

import com.jdbc.hibernate.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);
    Student findById(Integer id);
    List<Student> findAll();
    List<Student> findByLastName(String lastName);
    void update(Student student);
    void deleteStudent(Integer id);
    int deleteAll();
}
