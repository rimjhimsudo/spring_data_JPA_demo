package com.springwithmysqldemo.sqlspringdemo.repository;

import com.springwithmysqldemo.sqlspringdemo.model.CustomerModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@Repository
public interface CustomerRepository extends CrudRepository<CustomerModel,Integer> {
}
