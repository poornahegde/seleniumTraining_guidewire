package com.demo;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import drivers.GetDrivers;

public class Ddfc_demo {

	WebDriver driver;
	@BeforeTest
	@Parameters("browser")
	public void beforeTest() {
		driver = GetDrivers.utilityDriver("chrome");
		driver.manage().window().maximize();
		driver.get("https://www.hdfcbank.com/assets/popuppages/netbanking.htm");
	}	
	
	@Test(priority=1)
	public void hdfcCheck() {
		driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[1]/a")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.switchTo().frame("login_page");
		driver.findElement(By.name("fldLoginUserId")).sendKeys("111111");
		
		driver.switchTo().parentFrame();
		driver.switchTo().frame(1);
		driver.findElement(By.linkText("Privacy Policy")).click();
		
		driver.getWindowHandle();							//returns address of current window
		Set<String> window = driver.getWindowHandles();		// returns address of all windows
		
		for(String s:window) {
			driver.switchTo().window(s);
		}
		
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Personal")).click();
	}
	
	
	@Test(priority=2) 
	public void alerthandle() {
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.findElement(By.name("proceed")).click();
		Alert a = driver.switchTo().alert();
		System.out.println(a.getText());
		a.accept();
	}
	
	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
