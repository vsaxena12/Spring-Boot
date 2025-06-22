package com.springJdbcToJPA.spring_jdbc_to_jpa;

import com.springJdbcToJPA.spring_jdbc_to_jpa.dao.PersonDAO;
import com.springJdbcToJPA.spring_jdbc_to_jpa.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

@SpringBootApplication
public class SpringJdbcToJpaApplication {

	@Autowired
	private PersonDAO personDAO;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcToJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return runner -> {
			System.out.println(personDAO.findAll());
			System.out.println(personDAO.findById(1001));
			System.out.println(personDAO.deleteById(1006));
			System.out.println(personDAO.insert(new Person(1008, "Var", new Timestamp(System.currentTimeMillis()))));
			System.out.println(personDAO.update(new Person(1008, "Varun", new Timestamp(System.currentTimeMillis()))));

		};
	}

}
