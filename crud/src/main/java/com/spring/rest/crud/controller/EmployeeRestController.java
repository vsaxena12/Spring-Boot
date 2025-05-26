package com.spring.rest.crud.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.rest.crud.dao.EmployeeDAO;
import com.spring.rest.crud.entity.EmployeeJPAEntity;
import com.spring.rest.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

//    private EmployeeDAO employeeDAO;

    private final EmployeeService employeeService;
    private final ObjectMapper objectMapper;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService, ObjectMapper objectMapper) {
        this.employeeService = employeeService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/employees")
    public List<EmployeeJPAEntity> getAllEmployees() {
        return employeeService.findAllEmployees();
    }

    @GetMapping("/employee/{id}")
    public EmployeeJPAEntity getEmployee(@PathVariable int id) {
        EmployeeJPAEntity theEmployee = employeeService.findById(id);
        if(theEmployee == null) {
            throw new RuntimeException("id must be greater than 0");
        }
        return theEmployee;
    }

    @PostMapping("/employee")
    public EmployeeJPAEntity saveEmployee(@RequestBody EmployeeJPAEntity theEmployee) {
        theEmployee.setId(0);
        return employeeService.save(theEmployee); //Explicitly telling Hibernate that this is a new object, not an update. Insert a new row in the database.
    }

    /**
     * Put does complete update
     * @param theEmployee
     * @param id
     * @return complete updated employee
     */
    @PutMapping("/employee/{id}")
    public EmployeeJPAEntity updateEmployee(@RequestBody EmployeeJPAEntity theEmployee, @PathVariable int id) {
        EmployeeJPAEntity dbEmployee = employeeService.findById(id);
        if(dbEmployee == null) {
            throw new RuntimeException("id must be greater than 0");
        }
        dbEmployee.setFirstName(dbEmployee.getFirstName());
        dbEmployee.setLastName(dbEmployee.getLastName());
        dbEmployee.setEmail(dbEmployee.getEmail());
        return employeeService.save(theEmployee);
    }

    /**
     * Patch does partial update
     * @param theEmployee
     * @param id
     * @return partial updated employee
     */
    @PatchMapping("/employee/{id}")
    public EmployeeJPAEntity patchEmployee(@RequestBody EmployeeJPAEntity theEmployee, @PathVariable int id) {
        EmployeeJPAEntity dbEmployee = employeeService.findById(id);
        if(dbEmployee == null) {
            throw new RuntimeException("id must be greater than 0");
        }
        if(theEmployee.getFirstName() != null) {
            dbEmployee.setFirstName(theEmployee.getFirstName());
        }
        if(theEmployee.getLastName() != null) {
            dbEmployee.setLastName(theEmployee.getLastName());
        }
        if(theEmployee.getEmail() != null) {
            dbEmployee.setEmail(theEmployee.getEmail());
        }
        return employeeService.save(theEmployee);
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable int id) {
        EmployeeJPAEntity theEmployee = employeeService.findById(id);
        if(theEmployee == null) {
            throw new RuntimeException("id must be greater than 0");
        }
        employeeService.deleteById(id);
        return "Deleted employee: " + id;
    }
}
