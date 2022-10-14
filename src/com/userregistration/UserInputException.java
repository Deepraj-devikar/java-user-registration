package com.userregistration;

public class UserInputException extends Exception{
	public UserInputException(String inputType) {
		super("invalid"+inputType+"input occur");
	}
}
