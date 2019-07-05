package com.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.LoginPage;

import drivers.GetDrivers;

public class TestNgClass {
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeTest
	public void beforeTest() {
		driver = GetDrivers.utilityDriver("chrome");
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		homePage = PageFactory.initElements(driver, HomePage.class);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demowebshop.tricentis.com/");
	}
	
	@AfterTest
	public void afterTest() {
		driver.close();
		loginPage = null;
		homePage = null;
	}
	
	@Test(priority = 1)
	public void test1() {
		String s1 = homePage.clickLogin();
		Assert.assertTrue(s1.contains("Login"));
	}
	
	@Test(priority = 2)
	public void test2() {
		String s2 = loginPage.loginPage();
		Assert.assertEquals(s2, "Demo Web Shop. Login");
	}
}
