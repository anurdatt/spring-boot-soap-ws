package org.anuran.spring.soap.api.service;

import java.util.List;

import org.anuran.spring.soap.api.loaneligibility.Acknowledgement;
import org.anuran.spring.soap.api.loaneligibility.CustomerRequest;
import org.springframework.stereotype.Service;

@Service
public class LoanEligibilityService {
	
	public Acknowledgement checkLoanEligibility(CustomerRequest request) {
		Acknowledgement acknowledgement = new Acknowledgement();
		List<String> mismatchCriteriaList = acknowledgement.getCriteriaMismatch();
		
		if (!(request.getAge() >= 30 && request.getAge()<=60)) {
			mismatchCriteriaList.add("Person age should be in between 30 to 60");
		}
		
		if (!(request.getYearlyIncome() > 200000)) {
			mismatchCriteriaList.add("Minimum income should be more than 2L");
		}
		
		if (!(request.getCibilScore() > 500)) {
			mismatchCriteriaList.add("Low CIBIL Score please try after 6 months");
		}
		
		if (mismatchCriteriaList.size() > 0) {
			acknowledgement.setApprovedAmount(0);
			acknowledgement.setIsEligible(false);
		} else {
			acknowledgement.setApprovedAmount(500000);
			acknowledgement.setIsEligible(true);
		}
		return acknowledgement;
	}

}
