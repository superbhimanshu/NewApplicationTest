package com.dto;

import java.util.List;

/**
 * @author Imran Chowdry
 * @version v1.0
 * Created 19 April 2011
 */
public class AirBookRequest {
	private static final long serialVersionUID      = 5207767362051745293L;
	

	private List<Customer> customers                       = null;
	private boolean allowSimilarTravel              = false;
	private boolean validateOnly                    = false;
	private Long offerNumber                        = null;
	private String offerType = null;
	
	private Customer cust = null;
	
	
	
	
	
	


	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

	public String getOfferType() {
		return offerType;
	}

	public void setOfferType(String offerType) {
		this.offerType = offerType;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public boolean isAllowSimilarTravel() {
		return allowSimilarTravel;
	}

	public void setAllowSimilarTravel(boolean allowSimilarTravel) {
		this.allowSimilarTravel = allowSimilarTravel;
	}
	

	public boolean isValidateOnly() {
		return validateOnly;
	}

	
	public void setValidateOnly(boolean validateOnly) {
		this.validateOnly = validateOnly;
	}


	public Long getOfferNumber() {
		return offerNumber;
	}

	public void setOfferNumber(Long offerNumber) {
		this.offerNumber = offerNumber;
	}

}