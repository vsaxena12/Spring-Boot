package com.springJdbcToJPA.spring_jdbc_to_jpa.dao;

import com.springJdbcToJPA.spring_jdbc_to_jpa.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.parser.Entity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@Transactional
public class PersonDAO {

    @PersistenceContext
    EntityManager entityManager;

    public Person findById(int id) {
        return entityManager.find(Person.class,id);
    }

    public Person insert(Person person) {
        return entityManager.merge(person);
    }

    public void update(int id, String name) {
        Person person = entityManager.find(Person.class, id);
        if(person != null){
            person.setName(name);
        } else{
            System.out.println("Not Fixed");
        }

    }

    public void deleteById(int id) {
        Person person = entityManager.find(Person.class, id);
        if (person != null) {
            entityManager.remove(person);
        } else {
            System.out.println("No person found with ID: " + id);
        }
    }


    public List<Person> findAll() {
        TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
        return namedQuery.getResultList();
    }


}
