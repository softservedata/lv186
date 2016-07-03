package com.softserve.edu.homeTestCase6;

import org.testng.annotations.DataProvider;

public class Providers {
	@DataProvider(name = "differentUrls")
	public static Object[][] difUrl() {
		Object[][] values = { 
				{ "http://comments.azurewebsites.net" },
				{ "http://commentssprintone.azurewebsites.net/" } };
		return values;
	}
}
