package com.springwithmysqldemo.sqlspringdemo.model;

import javax.persistence.*;

@Entity
@Table(name="employee")
public class Employee {
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @Id
    private String empId;
    private String firstName;
    //private String lastName;
    //private String gender;
    //private String email;
    //private String phoneNumber;

    public Employee() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


}
