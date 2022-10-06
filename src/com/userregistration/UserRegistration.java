package com.userregistration;

import java.util.Scanner;
import java.util.regex.Pattern;

public class UserRegistration {

	public static void main(String[] args) {
		System.out.println("Welcome to user registration program");
		Scanner scanner = new Scanner(System.in);
		
		// Name start with capital letter and have minimum 3 characters
		// its first character will be in range from A to Z (i.e. [A-Z])
		// after first character all characters will be in range from a - z (i.e. [a-z])
		// length should be minimum 3 characters (i.e. first character is capital and minimum 2 small letter character - {2,})
		Pattern namePattern = Pattern.compile("[A-Z][a-z]{2,}");

		// First name validation according to name pattern
		System.out.print("Enter first name : ");
		String firstName = scanner.nextLine();
		System.out.print("Validation for first name '"+firstName+"' is : ");
		if(namePattern.matcher(firstName).matches()) {
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}
		
		// Last name validation according to name pattern
		System.out.print("Enter last name : ");
		String lastName = scanner.nextLine();
		System.out.print("Validation for last name '"+lastName+"' is : ");
		if(namePattern.matcher(lastName).matches()) {
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}
		
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

		// Email validation according to email pattern
		System.out.print("Enter email : ");
		String email = scanner.nextLine();
		System.out.print("Validation for email '"+email+"' is : ");
		if(emailPattern.matcher(email).matches()) {
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}
		
		// Mobile format is like two digits country code then space character after that ten digit mobile number
		// for two digit country code we used [0-9]{2}
		// then space character
		// for ten digit mobile number we used [0-9]{10}
		Pattern mobilePattern = Pattern.compile("[0-9]{2} [0-9]{10}");

		// Mobile validation according to mobile pattern
		System.out.print("Enter mobile : ");
		String mobile = scanner.nextLine();
		System.out.print("Validation for mobile '"+mobile+"' is : ");
		if(mobilePattern.matcher(mobile).matches()) {
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}
		
		// Password should have contain minimum 8 characters
		Pattern passwordPattern = Pattern.compile(".{8,}");
		
		// Password validation according to password pattern
		System.out.print("Enter password : ");
		String password = scanner.nextLine();
		System.out.print("Validation for password '"+password+"' is : ");
		if(passwordPattern.matcher(password).matches()) {
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}
	}

}
