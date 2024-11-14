package com.learnwithifte.springBootCrud.repository;

import com.learnwithifte.springBootCrud.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
