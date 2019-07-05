package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(how=How.ID, using="Email")
	WebElement email;
	
	@FindBy(how=How.ID, using="Password")
	WebElement password;
	
	@FindBy(how=How.CSS, using="input[value='Log in']")
	WebElement loginButton;
		
	public String loginPage() {
		email.sendKeys("kannan1@gmail.com");
		password.sendKeys("Test1234");
		loginButton.click();
		return driver.getTitle();
	}

	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
	}	
}
