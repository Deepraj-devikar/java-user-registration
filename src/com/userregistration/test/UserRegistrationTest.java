package com.userregistration.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import com.userregistration.User;
import com.userregistration.UserRegistration;

public class UserRegistrationTest {
	private ArrayList<User> happyTestCases = new ArrayList<>();
	private ArrayList<User> sadTestCases = new ArrayList<>();
	
	private UserRegistration userRegistration = new UserRegistration();
	
	public UserRegistrationTest() {
		User user1 = new User();
		user1.setFirstName("Deepraj");
		user1.setLastName("Devikar");
		user1.setEmail("deepraj@gmail.com");
		user1.setMobile("91 8605641525");
		user1.setPassword("Check@6547");
		happyTestCases.add(user1);
		
		User user2 = new User();
		user2.setFirstName("Rajesh");
		user2.setLastName("Prakash");
		user2.setEmail("rajesh.prakash@gmail.com");
		user2.setMobile("10 9876543210");
		user2.setPassword("@cheKing543");
		happyTestCases.add(user2);
		
		User user3 = new User();
		user3.setFirstName("Subrrahamhanyam");
		user3.setLastName("Parrellal");
		user3.setEmail("subrrahamhanyam_parrellal@gmail.com.co");
		user3.setMobile("91 5423698515");
		user3.setPassword("Longsubrr@hamhanyam20");
		happyTestCases.add(user3);
		
		User user4 = new User();
		user4.setFirstName("Bhaskar");
		user4.setLastName("Jadhav");
		user4.setEmail("jadhavbhaskar@gmail.com");
		user4.setMobile("91 1478523690");
		user4.setPassword("Jadhav@456");
		happyTestCases.add(user4);
		
		User user5 = new User();
		user5.setFirstName("Deepraj");
		user5.setLastName("Devikar");
		user5.setEmail("deepraj@devikar@gmail.com");
		user5.setMobile("+10 9876543210");
		user5.setPassword("Check6547");
		sadTestCases.add(user5);
		
		User user6 = new User();
		user6.setFirstName("Rajesh");
		user6.setLastName("Prakash");
		user6.setEmail("rajesh.prakash@gmail.com");
		user6.setMobile("91 8605641525");
		user6.setPassword("Check@654@7");
		sadTestCases.add(user6);
		
		User user7 = new User();
		user7.setFirstName("Bhaskar");
		user7.setLastName("Jadhav");
		user7.setEmail("jadhavbhaskar@gmail.com");
		user7.setMobile("91 1478523690");
		user7.setPassword("jadhav@456");
		sadTestCases.add(user7);
		
		User user8 = new User();
		user8.setFirstName("rakesh");
		user8.setLastName("chauvan");
		user8.setEmail("rakesh@gmail.com");
		user8.setMobile("91 1478523690");
		user8.setPassword("rakEsh@456");
		sadTestCases.add(user8);
	}
	
	@Test
	public void test() {
		for (User user : happyTestCases) {
			Assert.assertTrue(userRegistration.validate(user));
		}
		for (User user : sadTestCases) {
			Assert.assertFalse(userRegistration.validate(user));
		}
	}

}
