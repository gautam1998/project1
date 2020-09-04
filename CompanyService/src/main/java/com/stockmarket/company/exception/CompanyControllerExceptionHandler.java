package com.stockmarket.company.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CompanyControllerExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<CompanyErrorResponse> handleException(CompanyNotFoundException cnfe){
	
		CompanyErrorResponse companyErrorResponse = new CompanyErrorResponse(
														cnfe.getMessage(), 
														HttpStatus.NOT_FOUND.value(), 
														System.currentTimeMillis()
														);
		
		return new ResponseEntity<>(companyErrorResponse, HttpStatus.NOT_FOUND);
				
	}
}
