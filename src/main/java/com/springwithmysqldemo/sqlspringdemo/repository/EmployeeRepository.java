package com.springwithmysqldemo.sqlspringdemo.repository;

import com.springwithmysqldemo.sqlspringdemo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
