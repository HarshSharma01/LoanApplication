//DAO Implementation

package com.capgemini.xyz.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.capgemini.xyz.bean.Customer;
import com.capgemini.xyz.bean.Loan;

public class LoanDao implements ILoanDao {
	private Map<Long, Customer> customerEntry = null;
	private Map<Long,Loan> loanEntry = null;
	//add loan data here 
	public long applyLoan(Loan loan) {
		Random random=new Random();
		long generatedLoanId=Math.abs(random.nextLong());
		loan.setLoanId(generatedLoanId);
		loanEntry=new HashMap<Long, Loan>();
		loanEntry.put(loan.getCustId(),new Loan(loan.getLoanAmount(),loan.getCustId(),loan.getDuration()));
		return loan.getLoanId();
	}
//Adding customer data
	public long insertCust(Customer cust) {
		Random random=new Random();
		long generatedId=Math.abs(random.nextLong());
		cust.setCustId(generatedId);
		customerEntry=new HashMap<Long, Customer>();
		customerEntry.put(cust.getCustId(),new Customer(cust.getCustName(),cust.getAddress(),cust.getEmail(),cust.getMobile()));
		return cust.getCustId();
	}
}
