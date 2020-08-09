package com.websocket.microservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websocket.microservice.beans.BaseResponse;
import com.websocket.microservice.beans.LoanDetailsRequest;
import com.websocket.microservice.beans.LoanDetailsResponse;
import com.websocket.microservice.model.Account;
import com.websocket.microservice.model.Customer;
import com.websocket.microservice.model.LoanDetails;
import com.websocket.microservice.repository.AccountRepository;
import com.websocket.microservice.repository.CustomerRepository;
import com.websocket.microservice.repository.LoanDetailsRepository;

@Service
public class LoanDetailsServiceImpl implements LoanDetailsService {

	@Autowired
	LoanDetailsRepository loanDetailsRepository;

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public BaseResponse createLoanDetailsRecord(LoanDetailsRequest loanDetailsRequest) {
		BaseResponse baseResponse = new BaseResponse();
		if (loanDetailsRequest != null) {
			LoanDetails loanDetails = new LoanDetails();
			loanDetails.setAccount(loanDetailsRequest.getAccount());
			loanDetails.setInterestRate(loanDetailsRequest.getInterestRate());
			loanDetails.setLoanAmt(loanDetailsRequest.getLoanAmt());
			loanDetails.setLoanId(loanDetailsRequest.getLoanId());
			loanDetailsRepository.save(loanDetails);
			baseResponse.setMessage("Successfully created Loan Details record!");
			baseResponse.setStatus("Success");
			return baseResponse;
		}
		baseResponse.setMessage("Error occured in creating Loan Details record!");
		baseResponse.setStatus("Failure");
		return baseResponse;
	}

	@Override
	public List<LoanDetailsResponse> fetchLoanDetailsRecord(int customerId) {
		Customer customer = customerRepository.findById(customerId);
		List<Account> accounts = accountRepository.findByCustomer(customer);
		List<LoanDetailsResponse> loanDetailsList = new ArrayList<>();
		for (Account account : accounts) {
			for (LoanDetails loanDetails : account.getLoanDetails()) {
				LoanDetailsResponse loanDetailResponse = new LoanDetailsResponse();
				loanDetailResponse.setAccountId(account.getId());
				loanDetailResponse.setInterestRate(loanDetails.getInterestRate());
				loanDetailResponse.setLoanAmt(loanDetails.getLoanAmt());
				loanDetailResponse.setLoanId(loanDetails.getLoanId());
				loanDetailsList.add(loanDetailResponse);
			}
		}
		return loanDetailsList;
	}

	@Override
	public LoanDetailsResponse fetchMostRecentLoanDetailsRecord() {
		LoanDetailsResponse loanDetailsResponse = new LoanDetailsResponse();
		LoanDetails mostRecentLoanDetails = loanDetailsRepository.findMostRecentRecord();
		if (mostRecentLoanDetails != null) {
			loanDetailsResponse.setAccountId(mostRecentLoanDetails.getAccount().getId());
			loanDetailsResponse.setInterestRate(mostRecentLoanDetails.getInterestRate());
			loanDetailsResponse.setLoanAmt(mostRecentLoanDetails.getLoanAmt());
			loanDetailsResponse.setLoanId(mostRecentLoanDetails.getLoanId());
		}
		return loanDetailsResponse;
	}

}
