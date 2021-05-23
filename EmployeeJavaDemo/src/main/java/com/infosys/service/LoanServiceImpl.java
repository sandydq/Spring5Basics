package com.infosys.service;


import org.springframework.beans.factory.annotation.Autowired;

import com.infosys.domain.Loan;
import com.infosys.exception.ServiceException;
import com.infosys.repository.LoanRepository;
import com.infosys.repository.LoanRepositoryImpl;

/**
 * The Class LoanServiceImpl.
 */

public class LoanServiceImpl implements LoanService {

	/** The loan repository. */

	LoanRepository loanRepository;

	

	public LoanRepository getLoanRepository() {
		return loanRepository;
	}



	public void setLoanRepository(LoanRepository loanRepository) {
		System.out.println("Inside loanRepository setter mehtod");
		this.loanRepository = loanRepository;
	}



	public LoanServiceImpl() {
		super();
	}


	@Autowired
	public LoanServiceImpl(LoanRepository loanRepository) {
		super();
		this.loanRepository = loanRepository;
	}



	/*
	 * (non-Javadoc)
	 * 
	 * @see com.infosys.service.LoanService#isEligibleForLoan(int)
	 */
	public boolean isEligibleForLoan(int empId) throws ServiceException  {
		Loan loan = loanRepository.getLoan(empId);
		boolean flag=false;
		if((loan == null) || (!(loan.getStatus().equalsIgnoreCase("open")))){
			flag= true;			
		}

			return flag;
	}
}
