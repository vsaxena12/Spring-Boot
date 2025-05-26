package com.jdbc.hibernate.jpaDao;

import com.jdbc.hibernate.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    // Custom method by query derivation
    List<Student> findByLastName(String lastName);

    // Optionally define custom delete
    long deleteByLastName(String lastName); // example
}