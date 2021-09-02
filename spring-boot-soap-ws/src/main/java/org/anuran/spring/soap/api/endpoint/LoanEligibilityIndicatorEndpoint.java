package org.anuran.spring.soap.api.endpoint;

import org.anuran.spring.soap.api.loaneligibility.Acknowledgement;
import org.anuran.spring.soap.api.loaneligibility.CustomerRequest;
import org.anuran.spring.soap.api.service.LoanEligibilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class LoanEligibilityIndicatorEndpoint {

	private static final String NAMESPACE = "http://www.anuran.org/spring/soap/api/loanEligibility";
	
	@Autowired
	LoanEligibilityService service;
	
	@PayloadRoot(namespace = NAMESPACE, localPart = "CustomerRequest")
	@ResponsePayload
	public Acknowledgement getLoanStatus(@RequestPayload CustomerRequest request) {
		return service.checkLoanEligibility(request);
	}
}
