package com.springwithmysqldemo.sqlspringdemo.service;

import com.springwithmysqldemo.sqlspringdemo.model.Employee;
import com.springwithmysqldemo.sqlspringdemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    public void save(List<Employee> employeeList){
        employeeRepository.saveAll(employeeList);
    }
    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }
}
