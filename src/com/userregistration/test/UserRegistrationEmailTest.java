/**
 * 
 */
package com.userregistration.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.userregistration.UserInputException;
import com.userregistration.UserRegistration;

/**
 * @author Deepraj Devikar
 *
 */
@RunWith(Parameterized.class)
public class UserRegistrationEmailTest {
	private String email;
	private boolean isValid;
	
	private UserRegistration userRegistration;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		userRegistration = new UserRegistration();
	}
	
	public UserRegistrationEmailTest(String email, boolean isValid) {
		this.email = email;
		this.isValid = isValid;
	}
	
	@Parameterized.Parameters
	public static Collection testEmails() {
		return Arrays.asList(new Object[][] {
			{"abc@yahoo.com", true},
			{"abc-100@yahoo.com", true},
			{"abc.100@yahoo.com", true},
			{"abc111@abc.com", true},
			{"abc-100@abc.net", true},
			{"abc.100@abc.com.au", true},
			{"abc@1.com", true},
			{"abc@gmail.com.com", true},
			{"abc+100@gmail.com", true},
			{"abc", false},
			{"abc@.com.my", false},
			{"abc123@gmail.a", false},
			{"abc123@.com", false},
			{"abc123@.com.com", false},
			{".abc@abc.com", false},
			{"abc()*@gmail.com", false},
			{"abc@%*.com", false},
			{"abc..2002@gmail.com", false},
			{"abc.@gmail.com", false},
			{"abc@abc@gmail.com", false},
			{"abc@gmail.com.1a", false},
			{"abc@gmail.com.aa.au", false},
		});
	}

	@Test
	public void test() {
		try {
			Assert.assertEquals(userRegistration.validate(userRegistration.EMAIL_TYPE, email), isValid);
		} catch (UserInputException e) {
			System.out.println(e);
		}
	}

}
