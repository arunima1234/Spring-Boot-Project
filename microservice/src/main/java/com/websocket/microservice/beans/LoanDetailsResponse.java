package com.websocket.microservice.beans;

public class LoanDetailsResponse {
	
	private int id;

	private String loanId;

	private int accountId;
	
	private String loanAmt;
	
	private String interestRate;

	public LoanDetailsResponse(int accountId2, String interestRate2, String loanAmt2, String loanId2) {
		this.accountId = accountId2;
		this.interestRate = interestRate2;
		this.loanAmt = loanAmt2;
		this.loanId = loanId2;
	}

	public LoanDetailsResponse() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoanId() {
		return loanId;
	}

	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getLoanAmt() {
		return loanAmt;
	}

	public void setLoanAmt(String loanAmt) {
		this.loanAmt = loanAmt;
	}

	public String getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(String interestRate) {
		this.interestRate = interestRate;
	}
}
