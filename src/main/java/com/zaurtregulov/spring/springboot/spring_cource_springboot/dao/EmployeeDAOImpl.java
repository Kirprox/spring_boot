package com.zaurtregulov.spring.springboot.spring_cource_springboot.dao;

import com.zaurtregulov.spring.springboot.spring_cource_springboot.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getAllEmployees() {
//        Session session = entityManager.unwrap(Session.class);
//        Query query = session.createQuery("from Employee", Employee.class);
//        List<Employee> allEmployees = query.getResultList();
        Query query = entityManager.createQuery("from Employee ");
        List<Employee> allEmployees = query.getResultList();
        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee) {
//        Session session = entityManager.unwrap(Session.class);
//        session.saveOrUpdate(employee);
        Employee newemployee = entityManager.merge(employee);
        employee.setId(newemployee.getId());
    }

    @Override
    public Employee getEmployee(int id) {
//        Session session = entityManager.unwrap(Session.class);
        Employee employee = entityManager.find(Employee.class,id);
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
//        Session session = entityManager.unwrap(Session.class);
//        Query query = session.createQuery("delete from Employee " +
//                "where id = :employeeid");
//        query.setParameter("employeeid", id);
//        query.executeUpdate();
        Query query = entityManager.createQuery("delete from Employee " +
                "where id = :employeeid");
        query.setParameter("employeeid", id);
        query.executeUpdate();
    }
}
