package com.websocket.microservice.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.websocket.microservice.model.Account;
import com.websocket.microservice.model.Customer;

public interface AccountRepository extends JpaRepository<Account, Integer>{
	public List<Account> findByCustomer(Customer customer);

	public Account findById(int accountId);
}
