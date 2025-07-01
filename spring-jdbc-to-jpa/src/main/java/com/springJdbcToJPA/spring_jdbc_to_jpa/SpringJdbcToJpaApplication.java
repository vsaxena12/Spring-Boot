package com.springJdbcToJPA.spring_jdbc_to_jpa;

import com.springJdbcToJPA.spring_jdbc_to_jpa.entity.Person;
import com.springJdbcToJPA.spring_jdbc_to_jpa.personDAO.PersonDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringJdbcToJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcToJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(PersonDAO personDAO) {
		return runner -> {
			Person person = new Person();
//			person.setId(1002);
			person.setName("Varun");
			person.setEmail("varun@gmail.com");
			personDAO.save(person);

			List<Person> list = personDAO.findAll();
			System.out.println("List: "+ list);

			List<Person> listById = personDAO.findAllByName("Varun");
			System.out.println("ListById: "+ listById);

			Person findPerson = personDAO.find(1001);
			System.out.println("Person: "+findPerson);

			Person updatePerson = personDAO.update(1006);
			System.out.println("Update Person: "+updatePerson);

			personDAO.delete(1006);
			if(personDAO.find(1006) == null){
				System.out.println("Deleted Person Successfully");
			}

			int numOfRows = personDAO.deleteAll();
			System.out.println("Deleted Person Successfully: "+numOfRows);

		};
	}
}
