package com.websocket.microservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.websocket.microservice.model.LoanDetails;

@Repository
public interface LoanDetailsRepository extends JpaRepository<LoanDetails, Integer> {
	public List<LoanDetails> findByAccount();

	@Query(value = "SELECT TOP 1 * FROM loan_details ORDER BY id DESC", nativeQuery = true)
	public LoanDetails findMostRecentRecord();
}
