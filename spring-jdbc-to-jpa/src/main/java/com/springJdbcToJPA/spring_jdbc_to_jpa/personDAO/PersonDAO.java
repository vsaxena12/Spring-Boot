package com.springJdbcToJPA.spring_jdbc_to_jpa.personDAO;

import com.springJdbcToJPA.spring_jdbc_to_jpa.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDAO implements PersonDAOInterface {

    private final EntityManager entityManager;

    @Autowired
    public PersonDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Person person) {
        entityManager.persist(person);
    }

    @Override
    public List<Person> findAll() {
        TypedQuery<Person> typedQuery = entityManager.createQuery("from Person", Person.class);
        return typedQuery.getResultList();

    }

    @Override
    public List<Person> findAllByName(String name) {
        TypedQuery<Person> typedQuery = entityManager.createQuery("from Person where name=:name", Person.class);
        typedQuery.setParameter("name", name);
        return typedQuery.getResultList();

    }

    @Override
    public Person find(int id) {
        return entityManager.find(Person.class, id);
    }

    @Override
    @Transactional
    public Person update(int id) {
        Person person = entityManager.find(Person.class, id);
        person.setName("Mihir");
        person.setEmail("mihir@yahoo.com");
        return entityManager.merge(person);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Person person = entityManager.find(Person.class, id);
        entityManager.remove(person);
    }

    @Override
    @Transactional
    public int deleteAll() {
        return entityManager.createQuery("DELETE from Person").executeUpdate();
    }
}
