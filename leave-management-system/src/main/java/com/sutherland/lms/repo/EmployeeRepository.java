package com.sutherland.lms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sutherland.lms.entity.Employee;
import com.sutherland.lms.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    // JpaRepository gives you save(), findById(), findAll(), deleteById(), etc.
}
