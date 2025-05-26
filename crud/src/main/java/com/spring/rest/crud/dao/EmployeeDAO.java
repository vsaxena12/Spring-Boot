package com.spring.rest.crud.dao;

import com.spring.rest.crud.entity.EmployeeJPAEntity;

import java.util.List;

public interface EmployeeDAO {
    public List<EmployeeJPAEntity> findAll();
    public EmployeeJPAEntity findById(int theId);
    public EmployeeJPAEntity save(EmployeeJPAEntity theEmployee);
    public void deleteById(int theId);
}
