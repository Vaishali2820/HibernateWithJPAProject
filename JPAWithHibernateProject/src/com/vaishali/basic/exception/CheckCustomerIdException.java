package com.vaishali.basic.exception;

public class CheckCustomerIdException extends RuntimeException{
	 
	@Override
	public String toString()  {
		return "Customer can not start with zero";
	}
}
