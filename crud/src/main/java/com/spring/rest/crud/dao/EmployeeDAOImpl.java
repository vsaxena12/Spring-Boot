package com.spring.rest.crud.dao;

import com.spring.rest.crud.entity.EmployeeJPAEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<EmployeeJPAEntity> findAll() {
        TypedQuery<EmployeeJPAEntity> theQuery = entityManager.createQuery("from EmployeeJPAEntity", EmployeeJPAEntity.class);
        List<EmployeeJPAEntity> employees = theQuery.getResultList();
        return employees;
    }

    @Override
    public EmployeeJPAEntity findById(int theId) {
        TypedQuery<EmployeeJPAEntity> theQuery = entityManager.createQuery("from EmployeeJPAEntity where id=:employeeId",
                EmployeeJPAEntity.class);
        theQuery.setParameter("employeeId", theId);
        EmployeeJPAEntity theEmployee = theQuery.getSingleResult();
        return theEmployee;
    }

    @Override
    public EmployeeJPAEntity save(EmployeeJPAEntity theEmployee) {
        EmployeeJPAEntity dbEmployee = entityManager.merge(theEmployee);
        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {
        entityManager.remove(findById(theId));
    }


}
