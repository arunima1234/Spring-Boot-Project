package com.websocket.microservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.websocket.microservice.model.Account;
import com.websocket.microservice.model.LoanDetails;

@Repository
public interface LoanDetailsRepository extends JpaRepository<LoanDetails, Integer> {
	public List<LoanDetails> findByAccount(Account account);

	@Query(value = "SELECT * FROM banking_db.loan_details ORDER BY id DESC LIMIT 1", nativeQuery = true)
	public LoanDetails findMostRecentRecord();
}
