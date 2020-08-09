package com.websocket.microservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.websocket.microservice.beans.BaseResponse;
import com.websocket.microservice.beans.LoanDetailsRequest;
import com.websocket.microservice.beans.LoanDetailsResponse;
import com.websocket.microservice.service.LoanDetailsService;

@RestController
public class LoanDetailsController {

	@Autowired
	LoanDetailsService loanDetailsService;

	@PostMapping("/loan-details")
	public ResponseEntity<BaseResponse> createLoanDetails(@RequestBody LoanDetailsRequest loanDetailsRequest) {
		BaseResponse baseResponse = new BaseResponse();
		baseResponse = loanDetailsService.createLoanDetailsRecord(loanDetailsRequest);
		return new ResponseEntity<>(baseResponse, HttpStatus.OK);
	}

	@GetMapping("/loan-details/{customer_id}")
	public ResponseEntity<List<LoanDetailsResponse>> fetchLoanDetails(@PathVariable("customer_id") int customerId) {
		List<LoanDetailsResponse> loanDetailsResponseList = new ArrayList<LoanDetailsResponse>();
		loanDetailsResponseList = loanDetailsService.fetchLoanDetailsRecord(customerId);
		return new ResponseEntity<>(loanDetailsResponseList, HttpStatus.OK);
	}

	@GetMapping("/recent-loan-details")
	public ResponseEntity<LoanDetailsResponse> fetchMostRecentLoanDetails() {
		LoanDetailsResponse loanDetailsResponse = loanDetailsService.fetchMostRecentLoanDetailsRecord();
		return new ResponseEntity<>(loanDetailsResponse, HttpStatus.OK);
	}
}
