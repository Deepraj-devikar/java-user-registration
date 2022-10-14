package com.userregistration;

import java.util.Scanner;
import java.util.regex.Pattern;

public class UserRegistration {
	// Name start with capital letter and have minimum 3 characters
	// its first character will be in range from A to Z (i.e. [A-Z])
	// after first character all characters will be in range from a - z (i.e. [a-z])
	// length should be minimum 3 characters (i.e. first character is capital and minimum 2 small letter character - {2,})
	Pattern namePattern = Pattern.compile("[A-Z][a-z]{2,}");
	
	// Email should compulsory contains three parts that are username, domain, top level domain
	// email address will like this username@domain.top level domain
	// -----------------------------------------------------------------------------
	// Formation of username :- ^(?!.*\\.\\.)[^.][a-zA-Z0-9+_.-]+[^.]
	// username dose not contains double dots it is solved with (?!.*\\.\\.)
	// username dose not start with dot it is solved with [^.] as first character
	// username should contain small letters, capital letters, digits, underscore, dot, dash only is done with [a-zA-Z0-9+_.-]
	// + is use to reffer occurs once or more times
	// username dose not end with dot it is solved with [^.] as last character
	// after username email will contain @ and after @ sign domain will start
	// -------------------------------------------------------------------------------
	// Formation of domain :- [a-zA-Z0-9&&[^.]][a-zA-Z0-9.]*
	// domain should contains small letters, capital letters, digits and domains first character can not be dot
	// we use [a-zA-Z0-9&&[^.]] in domain as first character which means first character can be
	// small letter, capital letter, digit and not be dot
	// [a-zA-Z0-9.]* it means small letter, capital letter, digit, dot any character in between these with occurrence of zero or more times
	// after domain email will contain dot sign and after dot sign top level domain will start
	// dot is mentioned in pattern as [\\.]{1} (i.e. one occurrence of dot)
	// ----------------------------------------------------------------------------------
	// Formation of top level domain :- [a-zA-z]{2,}
	// top level domain will contain small letters, capital letters with length 2 or more than 2
	Pattern emailPattern = Pattern.compile("^(?!.*\\.\\.)[^.][a-zA-Z0-9+_.-]+[^.]@[a-zA-Z0-9&&[^.]][a-zA-Z0-9.]*[\\.]{1}[a-zA-z]{2,}$");
	
	// Mobile format is like two digits country code then space character after that ten digit mobile number
	// for two digit country code we used [0-9]{2}
	// then space character
	// for ten digit mobile number we used [0-9]{10}
	Pattern mobilePattern = Pattern.compile("[0-9]{2} [0-9]{10}");
	
	// Password should have contain minimum 8 characters
	// Password should contain at least one upper case character we done it with (?=.*[A-Z])
	// Password should contain at least one numeric character we done it with (?=.*[0-9])
	// Password should contain exactly one special character we done it with (?=[^@#$%^&-+=()]*[@#$%^&-+=()][^@#$%^&-+=()]*$)
	Pattern passwordPattern = Pattern.compile("^(?=.*[0-9])(?=.*[A-Z])(?=[^@#$%^&-+=()]*[@#$%^&-+=()][^@#$%^&-+=()]*$).{8,}$");
	
	// for choosing which validation have to apply
	public final String NAME_TYPE = "NAME";
	public final String EMAIL_TYPE = "EMAIL";
	public final String MOBILE_TYPE = "MOBILE";
	public final String PASSWORD_TYPE = "PASSWORD";
	
	/**
	 * validate value according to type of value
	 * if invalid input then throws UserInputException
	 * 
	 * @param type
	 * @param value
	 * @return true if validation correct otherwise false
	 * @throws UserInputException 
	 */
	public boolean validate(String type, String value) throws UserInputException {
		boolean isValid = false;
		switch(type) {
		case NAME_TYPE:
			isValid = namePattern.matcher(value).matches();
			break;
		case EMAIL_TYPE:
			isValid = emailPattern.matcher(value).matches();
			break;
		case MOBILE_TYPE:
			isValid = mobilePattern.matcher(value).matches();
			break;
		case PASSWORD_TYPE:
			isValid = passwordPattern.matcher(value).matches();
			break;
		}
		if (isValid) {
			return isValid;
		} else {
			throw new UserInputException(" "+type+" ");
		}
	}
	
	/**
	 * validate users all details according to correct type
	 * if invalid any input then throws UserInputException
	 * 
	 * @param user
	 * @return true if all validations of user is correct otherwise false
	 * @throws UserInputException 
	 */
	public boolean validate(User user) throws UserInputException {
		String invalidTypes = "";
		try {
			validate(NAME_TYPE, user.getFirstName());
		} catch (UserInputException e) {
			invalidTypes += " FIRST "+NAME_TYPE+", ";
		}
		try {
			validate(NAME_TYPE, user.getLastName());
		} catch (UserInputException e) {
			invalidTypes += " LAST "+NAME_TYPE+", ";
		}
		try {
			validate(EMAIL_TYPE, user.getEmail());
		} catch (UserInputException e) {
			invalidTypes += " "+EMAIL_TYPE+", ";
		}
		try {
			validate(MOBILE_TYPE, user.getMobile());
		} catch (UserInputException e) {
			invalidTypes += " "+MOBILE_TYPE+", ";
		}
		try {
			validate(PASSWORD_TYPE, user.getPassword());
		} catch (UserInputException e) {
			invalidTypes += " "+PASSWORD_TYPE+" ";
		}
		if(invalidTypes.isBlank()) {
			return true;
		} else {
			throw new UserInputException(invalidTypes);
		}
	}

	public static void main(String[] args) {
		System.out.println("Welcome to user registration program");
		Scanner scanner = new Scanner(System.in);
		
		UserRegistration userRegistration = new UserRegistration();
		
		// First name validation according to name pattern
		System.out.print("Enter first name : ");
		String firstName = scanner.nextLine();
		System.out.print("Validation for first name '"+firstName+"' is : ");
		try {
			if(userRegistration.validate(userRegistration.NAME_TYPE, firstName)) {
				System.out.println("PASS");
			} else {
				System.out.println("FAIL");
			}
		} catch (UserInputException e) {
			System.out.println(e);
		}
		
		// Last name validation according to name pattern
		System.out.print("Enter last name : ");
		String lastName = scanner.nextLine();
		System.out.print("Validation for last name '"+lastName+"' is : ");
		try {
			if(userRegistration.validate(userRegistration.NAME_TYPE, lastName)) {
				System.out.println("PASS");
			} else {
				System.out.println("FAIL");
			}
		} catch (UserInputException e) {
			System.out.println(e);
		}
		
		// Email validation according to email pattern
		System.out.print("Enter email : ");
		String email = scanner.nextLine();
		System.out.print("Validation for email '"+email+"' is : ");
		try {
			if(userRegistration.validate(userRegistration.EMAIL_TYPE, email)) {
				System.out.println("PASS");
			} else {
				System.out.println("FAIL");
			}
		} catch (UserInputException e) {
			System.out.println(e);
		}
		
		// Mobile validation according to mobile pattern
		System.out.print("Enter mobile : ");
		String mobile = scanner.nextLine();
		System.out.print("Validation for mobile '"+mobile+"' is : ");
		try {
			if(userRegistration.validate(userRegistration.MOBILE_TYPE, mobile)) {
				System.out.println("PASS");
			} else {
				System.out.println("FAIL");
			}
		} catch (UserInputException e) {
			System.out.println(e);
		}
		
		// Password validation according to password pattern
		System.out.print("Enter password : ");
		String password = scanner.nextLine();
		System.out.print("Validation for password '"+password+"' is : ");
		try {
			if(userRegistration.validate(userRegistration.PASSWORD_TYPE, password)) {
				System.out.println("PASS");
			} else {
				System.out.println("FAIL");
			}
		} catch (UserInputException e) {
			System.out.println(e);
		}
		
		scanner.close();
		
		System.out.println("\nCheck email pattern against sample emails to test : ");
		String[] sampleEmails = {
			"abc@yahoo.com",
			"abc-100@yahoo.com",
			"abc.100@yahoo.com",
			"abc111@abc.com",
			"abc-100@abc.net",
			"abc.100@abc.com.au",
			"abc@1.com",
			"abc@gmail.com.com",
			"abc+100@gmail.com",
			"abc",
			"abc@.com.my",
			"abc123@gmail.a",
			"abc123@.com",
			"abc123@.com.com",
			".abc@abc.com",
			"abc()*@gmail.com",
			"abc@%*.com",
			"abc..2002@gmail.com",
			"abc.@gmail.com",
			"abc@abc@gmail.com",
			"abc@gmail.com.1a",
			"abc@gmail.com.aa.au",
		};
		
		for(int i = 0; i < sampleEmails.length; i++) {
			System.out.print("Validation for email '"+sampleEmails[i]+"' is : ");
			try {
				if(userRegistration.validate(userRegistration.EMAIL_TYPE, sampleEmails[i])) {
					System.out.println("PASS");
				} else {
					System.out.println("FAIL");
				}
			} catch (UserInputException e) {
				System.out.println(e);
			}	
		}
	}

}
