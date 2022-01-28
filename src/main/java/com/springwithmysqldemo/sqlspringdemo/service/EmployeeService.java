package com.springwithmysqldemo.sqlspringdemo.service;

import com.springwithmysqldemo.sqlspringdemo.model.Employee;
import com.springwithmysqldemo.sqlspringdemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.*;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    public void save(List<Employee> employeeList){
        Future<String> future=null;
        ExecutorService executorService= Executors.newFixedThreadPool(10);
        Callable<String> callableTask = () -> {
            employeeRepository.saveAll(employeeList);
            return "Task's execution";
        };
        for(int i=0;i<=100;i++){
            future=executorService.submit(callableTask);
        }
        String result = null;
        try {
            result = future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("Thread name : "+ Thread.currentThread().getName());
        executorService.shutdown();
    }


    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }
}

