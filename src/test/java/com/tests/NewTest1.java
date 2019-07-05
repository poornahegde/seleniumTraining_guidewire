package com.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import drivers.GetDrivers;

public class NewTest1 {
	WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod() {
		driver= GetDrivers.utilityDriver("chrome");
		driver.manage().window().maximize();
		driver.get("www.google.com");
	}
	
	@Test
	public void test1() {
		System.out.println("test1");
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.close();
		System.out.println("After Method");
	}

}
