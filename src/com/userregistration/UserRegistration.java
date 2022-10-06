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
	}

}
