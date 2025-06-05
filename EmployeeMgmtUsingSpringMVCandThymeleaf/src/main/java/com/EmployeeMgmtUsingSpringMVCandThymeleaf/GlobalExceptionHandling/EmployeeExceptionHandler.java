package com.EmployeeMgmtUsingSpringMVCandThymeleaf.GlobalExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.EmployeeMgmtUsingSpringMVCandThymeleaf.CustomExceptions.EmployeeNotFoundException;
import com.EmployeeMgmtUsingSpringMVCandThymeleaf.CustomExceptions.ErrorResponse;

@ControllerAdvice
public class EmployeeExceptionHandler {
	
    @ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(EmployeeNotFoundException ex)
	{
		ErrorResponse error=new ErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setErrorMsg(ex.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
    @ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(Exception ex)
	{
		ErrorResponse error=new ErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setErrorMsg(ex.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}

}
