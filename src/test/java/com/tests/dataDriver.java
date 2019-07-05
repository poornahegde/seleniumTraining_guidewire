package com.tests;

import java.util.concurrent.TimeUnit;
import com.excel.DataSource;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import drivers.GetDrivers;

public class dataDriver {
	WebDriver driver;
	
	@BeforeTest
	@Parameters("browser")
	public void beforeTest() {
		driver = GetDrivers.utilityDriver("firefox");
		driver.manage().window().maximize();
		driver.get("http://demowebshop.tricentis.com/login");
	}
	
	@Test(dataProvider="dp1", dataProviderClass=DataSource.class)
	public void loginPage(String username, String password) throws InterruptedException {
		driver.findElement(By.id("Email")).sendKeys(username);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.cssSelector("input[value='Log in']")).click();
		
		String email = driver.findElement(By.className("account")).getText();
		if(email.equals(username)) {
			
			Assert.assertTrue(true);
			driver.findElement(By.linkText("Log out")).click();
			Thread.sleep(300);
			driver.findElement(By.linkText("Log in")).click();
			Thread.sleep(300);
			
		} else {
			
			driver.findElement(By.id("Email")).clear();
			Assert.assertTrue(false);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}		
	}
	  
	@AfterTest
  	public void afterTest() {
		driver.close();
	}
}
