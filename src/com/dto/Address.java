package com.dto;

import java.util.List;

public class Address {

	private String city = null;
	private String country = null;
	private List<String> addressLine = null;
	private String zip = null;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public List<String> getAddressLine() {
		return addressLine;
	}
	public void setAddressLine(List<String> addressLine) {
		this.addressLine = addressLine;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	
}
