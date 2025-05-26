package com.jdbc.hibernate;

import com.jdbc.hibernate.entity.Student;
import com.jdbc.hibernate.dao.StudentDAO;
import com.jdbc.hibernate.jpaDao.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class HibernateApplication {

	private Student student;

	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(HibernateApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runnner -> {
			System.out.println("Hello World! - Creating student");
			createStudent(studentDAO);
//			findById(studentDAO);
//			findAll(studentDAO);
//			findByLastName(studentDAO);
//			update(studentDAO);
//			delete(studentDAO);
//			deleteAll(studentDAO);

			jpaTest();
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating student");
		student = new Student("Brittany", "Backburn", "bb@gmail.com");

		System.out.println("Saving student");
		studentDAO.save(student);

		System.out.println("Student: " + student);
	}

	private void findById(StudentDAO studentDAO) {
		System.out.println("Find student by id");
		student = studentDAO.findById(student.getId());
		System.out.println("Student: " + student);
	}

	private void findAll(StudentDAO studentDAO) {
		System.out.println("Find all student");
		List<Student> theStudent = studentDAO.findAll();
		for (Student tempStudent : theStudent) {
			System.out.println("Student: " + tempStudent);
		}
	}

	private void findByLastName(StudentDAO studentDAO) {
		System.out.println("Find student by last name");
		List<Student> theStudent = studentDAO.findByLastName("Blackburn");
		for (Student tempStudent : theStudent) {
			System.out.println("Student: " + tempStudent);
		}
	}

	private void update(StudentDAO studentDAO) {
		System.out.println("Update student");
		List<Student> theStudent = studentDAO.findByLastName("Backburn");
		for (Student tempStudent : theStudent) {
			tempStudent.setLastName("Saxena");
			studentDAO.update(tempStudent);
		}
		System.out.println("Student: " + student);
	}

	private void delete(StudentDAO studentDAO) {
		System.out.println("Delete student");
		studentDAO.deleteStudent(student.getId());
	}

	private void deleteAll(StudentDAO studentDAO) {
		System.out.println("Delete all student");
		studentDAO.deleteAll();
	}

	private void jpaTest() {
		Student s = studentRepository.findById(1).orElse(null);
		studentRepository.save(new Student("Varun", "Saxena", "vs@gmail.com"));
		List<Student> all = studentRepository.findAll();
		List<Student> byLast = studentRepository.findByLastName("Smith");
		//studentRepository.deleteAll();
	}

}
