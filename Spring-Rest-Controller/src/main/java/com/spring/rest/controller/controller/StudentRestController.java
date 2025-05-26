package com.spring.rest.controller.controller;

import com.spring.rest.controller.model.Student;
import com.spring.rest.controller.model.StudentErrorResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class StudentRestController {

    private List<Student> theStudents;

    /**
     * @define @PostConstructor to load student data
     * Called only once when the bean is constructed
     */
    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();
        theStudents.add(new Student("1", "John", "Doe", true));
        theStudents.add(new Student("2", "Jane", "Doe", false));
    }

    /**
     * Returns the list of students
     * @return student list
     */
    @GetMapping("/students")
    public List<Student> getStudentList() {
        return theStudents;
    }

    /**
     * Returns the string directly
     * @param studentId
     * @return student
     */
    @GetMapping("/student/{studentId}")
    public String getStudent(@PathVariable int studentId) {
        return String.valueOf(theStudents.get(studentId-1));
    }

    /**
     * Returns the object directly
     * @param studentId
     * @return student
     */
    @GetMapping("/studentObject/{studentId}")
    public Student getStudentObject(@PathVariable int studentId) {
        if (studentId > theStudents.size() || studentId < 1) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        return theStudents.get(studentId-1);
    }

//    /**
//     * MAKING USE OF GLOBAL EXCEPTION HANDLER
//     * Returns the object directly
//     * @param studentId
//     * @return student
//     */
//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
//        StudentErrorResponse error = new StudentErrorResponse();
//        error.setCode(String.valueOf(HttpStatus.NOT_FOUND.value()));
//        error.setMessage(exc.getMessage());
//        error.setTimestamp(String.valueOf(System.currentTimeMillis()));
//        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {
//        StudentErrorResponse error = new StudentErrorResponse();
//        error.setCode(String.valueOf(HttpStatus.BAD_REQUEST.value()));
//        error.setMessage(exc.getMessage());
//        error.setTimestamp(String.valueOf(System.currentTimeMillis()));
//        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//    }



}
