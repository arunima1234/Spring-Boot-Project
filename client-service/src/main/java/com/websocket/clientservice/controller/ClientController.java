package com.websocket.clientservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class ClientController {

	@Autowired
	WebClient.Builder webClientBuilder;

	@SuppressWarnings("unchecked")
	@GetMapping("/loan-details/{customer_id}")
	public ResponseEntity<List<LoanDetailsResponse>> fetchLoanDetails(@PathVariable("customer_id") int customerId) {
		List<LoanDetailsResponse> loanDetailsResponseList = new ArrayList<>();

		loanDetailsResponseList = webClientBuilder.build().get().uri("http://localhost:8081/loan-details/" + customerId)
				.retrieve().bodyToMono(ArrayList.class).block();
		return new ResponseEntity<>(loanDetailsResponseList, HttpStatus.OK);
	}

	@GetMapping("/recent-loan-details")
	public ResponseEntity<LoanDetailsResponse> fetchMostRecentLoanDetails() {
		LoanDetailsResponse loanDetailsResponse = new LoanDetailsResponse();
		loanDetailsResponse = webClientBuilder.build().get().uri("http://localhost:8081/recent-loan-details").retrieve()
				.bodyToMono(LoanDetailsResponse.class).block();
		return new ResponseEntity<>(loanDetailsResponse, HttpStatus.OK);
	}

}
