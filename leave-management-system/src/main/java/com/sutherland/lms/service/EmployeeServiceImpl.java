package com.sutherland.lms.service;

import com.sutherland.lms.entity.Employee;
import com.sutherland.lms.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public Employee addEmployee(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public Optional<Employee> getEmployeeById(String empId) {
        return repository.findById(empId);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }
}
