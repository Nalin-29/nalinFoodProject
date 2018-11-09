package com.ntl.pos.service.impl;

import java.util.regex.Pattern;

import com.ntl.pos.service.ValidateData;

public class ValidateDataImpl implements ValidateData {
	
	//@Override
	public boolean validateEmail(String email){
		
		 
		 String emaill = "[A-Za-z]{10}"; 
        Pattern pat = Pattern.compile(emaill); 
		 return pat.matcher(email).matches();
	}
	
	//@Override
	public boolean validatePassword(String pass){
		 
		 String passs = "[A-Za-z]{5,10}"; 
        Pattern pat = Pattern.compile(passs); 
		 boolean b = pat.matcher(pass).matches();
		 return b;
	}
	
	//@Override
	public boolean validateName(String name){
	 
		 String passs = "[A-Za-z]{5,10}"; 
		 boolean b=Pattern.matches(passs, name);
		 
		// System.out.println(b);
		 return b;
	}
	
	//@Override
	public boolean validateLong(String Lname){
		
		 String passs = "[A-Za-z]{8,15}"; 
        Pattern pat = Pattern.compile(passs); 
		 boolean b= pat.matcher(Lname).matches();
		 return b;
	}
	
	public boolean validategender(String Lname){
		
		 String passs = "[A-Za-z]{4,10}"; 
       Pattern pat = Pattern.compile(passs); 
		 boolean b= pat.matcher(Lname).matches();
		 return b;
		 
	}
	
	public boolean validateNum(String num){
		
		 String numm = "[1-9]{8,10}"; 
      Pattern pat = Pattern.compile(numm); 
		 boolean b= pat.matcher(num).matches();
		 return b;
	}


}
