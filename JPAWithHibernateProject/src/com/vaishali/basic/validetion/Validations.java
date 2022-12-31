package com.vaishali.basic.validetion;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.vaishali.basic.exception.CheckCustomerIdException;

public class Validations {
	static Boolean msg;
	public static Boolean checkNameLength(String name)
	{
		if(name.length()<15)
		{
			msg = true;
		}
		else
		{
			msg = false;
		}
		return msg;
	}
	public static Boolean checkValidName(String name)
	{
		Boolean result=null;
		char arr[] = name.toCharArray();
		for(int i=0;i<arr.length;i++)
		{
			if((arr[i]>=65 && arr[i]<=90)|(arr[i]>=97 && arr[i]<=122))
			{
				result = true;
			}
			else{
				result=false;
				break;
			}
		}
		return result;
	}
	public static boolean checkEmail(String email)
	{
		String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";  
		
		Pattern pattern = Pattern.compile(regex);
		if (email == null)
		return false;
		
		return pattern.matcher(email).matches();	
	}
	public static boolean checkMobileNumber(String s)
	{ 
	        Pattern p = Pattern.compile( "^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$");

	        Matcher m = p.matcher(s);
	 
	       return (m.matches());
	}
	public static Boolean checkSalary(Double salary)
	{
		if(salary>=20000 && salary<=80000)
		{
			msg = true;
		}
		else
		{
			msg = false;
		}
		return msg;
	}
	@SuppressWarnings("deprecation")	
	public static Boolean checkDate(String targetDate,Date currentDate)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
					
		Date newDate = new Date(formatter.format(currentDate));
		Date tDate = new Date(formatter.format(new Date(targetDate)));
			
		if(tDate.after(newDate)==false)
			return true;
		else	
			return false;
	}
	public static Boolean checkId(Integer customerId)
	{
		String num = Integer.toString(customerId);
		if(num.length()>4)
		
			throw new CheckCustomerIdException();	
		
		else
			return true;	
		/*String regex=Integer.toString(customerId);
		if (regex != "^[1-9]+")  
			throw new CheckCustomerIdException();
		else
			return true;*/
		/*if(customerId>4)
		{
			throw new CheckCustomerIdException("NO");
		}
		else
			return true;*/
	}
}

