package com.springJdbcToJPA.spring_jdbc_to_jpa.personDAO;

import com.springJdbcToJPA.spring_jdbc_to_jpa.entity.Person;

import java.util.List;

public interface PersonDAOInterface {
    void save(Person person);
    List<Person> findAll();
    List<Person> findAllByName(String name);
    Person find(int id);
    Person update(int id);
    void delete(int id);
    int deleteAll();
}
