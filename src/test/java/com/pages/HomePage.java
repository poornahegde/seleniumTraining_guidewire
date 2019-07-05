package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {
	WebDriver driver;
	
	@FindBy(how=How.LINK_TEXT, using="Register")
	WebElement register;
	
	@FindBy(how=How.LINK_TEXT, using="Log in")
	WebElement login;
	
	public String clickRegister() {
		register.click();
		return driver.getTitle();
	}
	
	public String clickLogin() {
		login.click();
		return driver.getTitle();
	}

	public HomePage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
}
