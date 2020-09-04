package com.stockmarket.company.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class IpoNotFoundExceptionhandler {
	
	@ExceptionHandler
	public ResponseEntity<IpoErrorResponse> handleException (IpoNotFoundException infe){
		IpoErrorResponse errorResponse = new IpoErrorResponse(infe.getMessage(), 
											HttpStatus.NOT_FOUND.value(), 
											System.currentTimeMillis());
		
		return new ResponseEntity <>(errorResponse, HttpStatus.NOT_FOUND);
	}

}
