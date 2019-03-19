//Service Implementation Class

package com.capgemini.xyz.service;

import com.capgemini.xyz.bean.Customer;
import com.capgemini.xyz.bean.Loan;
import com.capgemini.xyz.dao.ILoanDao;
import com.capgemini.xyz.dao.LoanDao;
public class LoanService implements ILoanService {

	///to apply for loan
	public long applyLoan(Loan loan) {
		ILoanDao loanDao = new LoanDao();
		long generatedLoanId = loanDao.applyLoan(loan);
		return generatedLoanId;
	}
//Validation of user
	public Customer validateCustomer(Customer customer) {
		if (customer.getCustName().matches(("^[a-z][A-Z]*$"))) {
			return customer;
		}
		if(customer.getAddress().matches(("^[a-z][A-Z]*$"))) {
			return customer;	
		}
		else
		return null;
	}
	//insertion to dao
	public long insertCust(Customer cust) {
		ILoanDao loanDao = new LoanDao();
		Customer customer =new Customer();
		customer.setCustName(cust.getCustName());
		customer=validateCustomer(cust);
		long generatedId = loanDao.insertCust(cust);
		return generatedId;
	}

	//to calculate emi
	public double calculateEMI(double amount, int duration) {
		double r = 9.5;
		int n = duration * 12;
		double emiValue = amount * r * (1 + r) * n / ((1 + r) * n - 1);
		return emiValue;
	}
}
