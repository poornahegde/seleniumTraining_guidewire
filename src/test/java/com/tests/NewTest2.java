package com.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class NewTest2 {
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before test");
	}
	
	@Test(priority=1)
		public void testRegistration() {
		System.out.println("Registration");
	}
	  
	@Test(priority = 2)
	public void testLogin() {
		System.out.println("Login");
		SoftAssert S = new SoftAssert();
		S.assertEquals(10, 20);
		S.assertAll();
	}
	  
	  @Test(priority = 3)
	  public void testLogout() {
		 System.out.println("Logout");
	  }
	  	  
	  @AfterTest
	  public void afterTest() {
		  System.out.println("After Test");
	  }
  
}
