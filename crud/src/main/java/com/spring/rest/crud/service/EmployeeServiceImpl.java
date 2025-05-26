package com.spring.rest.crud.service;

import com.spring.rest.crud.dao.EmployeeDAO;
import com.spring.rest.crud.entity.EmployeeJPAEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<EmployeeJPAEntity> findAllEmployees() {
        List<EmployeeJPAEntity> employees = employeeDAO.findAll();
        return employees;
    }

    @Override
    public EmployeeJPAEntity findById(int theId) {
        EmployeeJPAEntity theEmployee = employeeDAO.findById(theId);
        return theEmployee;
    }

    @Override
    @Transactional
    public EmployeeJPAEntity save(EmployeeJPAEntity theEmployee) {
        EmployeeJPAEntity dbEmployee = employeeDAO.save(theEmployee);
        return dbEmployee;
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        employeeDAO.deleteById(theId);
    }
}
