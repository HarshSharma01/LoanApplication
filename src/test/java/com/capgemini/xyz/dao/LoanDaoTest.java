package com.capgemini.xyz.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.capgemini.xyz.bean.Customer;
import com.capgemini.xyz.bean.Loan;

class LoanDaoTest {

	@Test
	void testApplyLoan() {
		ILoanDao loanDao=new LoanDao();
		Loan loan=new Loan();
		loan.setDuration(5);
		loan.setLoanAmount(10000);
		loanDao.applyLoan(loan);
		assertEquals(10000,loan.getLoanAmount()); //checking loan amount is correct or not 
	}

	@Test
	void testInsertCust() {
		ILoanDao dao=new LoanDao();
		Customer cust=new Customer();
		cust.setCustName("John");
		cust.setAddress("Hyd");
		cust.setEmail("john@capgemini.com");
		cust.setMobile(1234567890);
		dao.insertCust(cust);
		assertEquals("John", cust.getCustName()); //checking name is correct or not
	}

}
