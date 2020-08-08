package com.websocket.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.websocket.microservice.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	public Customer findById(int id); 
}

