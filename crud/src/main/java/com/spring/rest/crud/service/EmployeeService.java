package com.spring.rest.crud.service;

import com.spring.rest.crud.entity.EmployeeJPAEntity;

import java.util.List;

public interface EmployeeService {
    public List<EmployeeJPAEntity> findAllEmployees();
    public EmployeeJPAEntity findById(int theId);
    public EmployeeJPAEntity save(EmployeeJPAEntity theEmployee);
    public void deleteById(int theId);
}
