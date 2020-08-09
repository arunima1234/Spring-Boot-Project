package com.websocket.microservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.websocket.microservice.beans.BaseResponse;
import com.websocket.microservice.beans.LoanDetailsRequest;
import com.websocket.microservice.beans.LoanDetailsResponse;

@Service
public interface LoanDetailsService {

	BaseResponse createLoanDetailsRecord(LoanDetailsRequest loanDetailsRequest);

	List<LoanDetailsResponse> fetchLoanDetailsRecord(int customerId);

	LoanDetailsResponse fetchMostRecentLoanDetailsRecord();

}
