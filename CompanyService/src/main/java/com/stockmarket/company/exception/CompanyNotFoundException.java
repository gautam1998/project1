package com.stockmarket.company.exception;

public class CompanyNotFoundException extends Throwable{

	private String message;

	public CompanyNotFoundException(String message) {
		super(message);
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
