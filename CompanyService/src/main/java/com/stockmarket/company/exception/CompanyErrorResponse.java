package com.stockmarket.company.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyErrorResponse {
	
	private String errorMessage;
	private int statusCode;
	private long exceptionTime;
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public long getExceptionTime() {
		return exceptionTime;
	}
	public void setExceptionTime(long exceptionTime) {
		this.exceptionTime = exceptionTime;
	}
	public CompanyErrorResponse(String errorMessage, int statusCode, long exceptionTime) {
		super();
		this.errorMessage = errorMessage;
		this.statusCode = statusCode;
		this.exceptionTime = exceptionTime;
	}
	public CompanyErrorResponse() {
		super();
	}
	
	
}
