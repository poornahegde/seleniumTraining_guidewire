package com.excel;

import org.testng.annotations.DataProvider;

public class DataSource {
	@DataProvider(name="dp1")
	public Object[][] getData() {
		Object[][] obj = {
						  {"kannan1@gmail.com","test1234"},
						  {"tester2@gmail.com","tester2"},
						  {"kannan1@gmail.com","test1234"}
				  		};
		return obj;
	}
}