//Main Method

package com.capgemini.xyz.ui;

import java.util.Scanner;

import com.capgemini.xyz.bean.Customer;
import com.capgemini.xyz.bean.Loan;
import com.capgemini.xyz.exceptions.UserNotGeneratedException;
import com.capgemini.xyz.service.ILoanService;
import com.capgemini.xyz.service.LoanService;

public class ExecuterMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ILoanService service = new LoanService();
		Customer cust = new Customer();
		Loan loan = new Loan();
		while (true) {
			int choice, innerChoice;
			System.out.println("XYZ Finance Company welcomes you\n 1. Register Customer \n 2. Exit");
			choice = scan.nextInt();

			switch (choice) {
			case 1: // take data from user
				System.out.println("1. Register Customer");
				System.out.println("Enter Customer Name");
				cust.setCustName(scan.next());
				System.out.println("Enter Address");
				cust.setAddress(scan.next());
				System.out.println("Enter Email");
				cust.setEmail(scan.next());
				System.out.println("Enter Mobile");
				cust.setMobile(scan.nextLong());
				// calling insertion method for customer
				long generatedId = service.insertCust(cust);
				if (generatedId == 0) {
					try {
						throw new UserNotGeneratedException();
					} catch (UserNotGeneratedException e) {
						e.printStackTrace();
					}
				} else {
					System.out.println("Customer information saved successfully \n Your Customer Id is " + generatedId);
				}
				System.out.println("Do you with to apply for a loan \n 1.Yes 2.No");
				innerChoice = scan.nextInt();
				switch (innerChoice) {
				case 1:
					System.out.println("Enter the loan amount");
					loan.setLoanAmount(scan.nextDouble());
					System.out.println("Enter the loan duration");
					loan.setDuration(scan.nextInt());
					// getting emi value to be paid
					double emiValue = service.calculateEMI(loan.getLoanAmount(), loan.getDuration());

					System.out.println("For loan amount " + loan.getLoanAmount() + " and " + loan.getDuration()
							+ "years duration\n Your emi per month will be " + emiValue);
					System.out.println("do you want to apply for loan now\n 1. Yes 2. No");
					int newChoice = scan.nextInt();
					switch (newChoice) {
					case 1:
						long generatedLoanId = service.applyLoan(loan); // applying for loan
						loan.setCustId(cust.getCustId());
						System.out.println("Your Loan request is generated \n Your loan id is " + generatedLoanId);
						System.out.println("Your Details\n Name " + cust.getCustName() + "\n Id " + cust.getCustId()
								+ "\n email " + cust.getEmail() + "\n Loan Id " + loan.getLoanId() + "\n Loan Amount "
								+ loan.getLoanAmount() + "\n Loan duration years " + loan.getDuration() + "\n");
						break;
					}
					break;
				case 2: // getting customer details when no loan is applied
					System.out.println("Customer Details\n " + "\n Id " + cust.getCustId() + "\n Name "
							+ cust.getCustName() + "\n Address " + cust.getAddress()+"\n Email "+cust.getEmail()+"\n Mobile "+cust.getMobile()+"\n");
					break;
				}
				break;
			case 2:
				System.out.println("Thank You");
				System.exit(0);
				break;
			}

		}

	}

}