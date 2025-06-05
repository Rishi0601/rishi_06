package com.EmployeeMgmtUsingSpringMVCandThymeleaf.CustomExceptions;

public class EmployeeNotFoundException extends Exception{
	public EmployeeNotFoundException(String msg)
	{
		super(msg);
	}
}
