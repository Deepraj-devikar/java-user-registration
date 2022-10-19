package com.userregistration;

@FunctionalInterface
public interface Validator {
	public boolean isValid(String type, String value);
}
