package com.softserve.edu.TestFieldsInApp;

import org.testng.annotations.DataProvider;

import com.softserve.edu.TestFieldsInApp.IBrowser.BrowsersList;
public class Providers {
	@DataProvider
	public Object[][] browsersAndUrls() {
		return new Object[][] { { "http://comments.azurewebsites.net", BrowsersList.FIREFOX_TEMPORARY },
				{ "http://comments.azurewebsites.net", BrowsersList.CHROME_TEMPORARY },
				{ "http://comments.azurewebsites.net", BrowsersList.IE_TEMPORARY },
				{ "http://commentssprintone.azurewebsites.net/", BrowsersList.FIREFOX_TEMPORARY },
				{ "http://commentssprintone.azurewebsites.net/", BrowsersList.CHROME_TEMPORARY },
				{ "http://commentssprintone.azurewebsites.net/", BrowsersList.IE_TEMPORARY } };
	}
	
	@DataProvider
	public Object[][] browsersAndUrlsAndSymbols() {
		return new Object[][] { { "http://comments.azurewebsites.net", BrowsersList.FIREFOX_TEMPORARY, "=" },
			{ "http://commentssprintone.azurewebsites.net/", BrowsersList.CHROME_TEMPORARY, "=" },
			{ "http://comments.azurewebsites.net", BrowsersList.FIREFOX_TEMPORARY, "/" },
			{ "http://commentssprintone.azurewebsites.net/", BrowsersList.CHROME_TEMPORARY, "/" },
			{ "http://comments.azurewebsites.net", BrowsersList.FIREFOX_TEMPORARY, "|" },
			{ "http://commentssprintone.azurewebsites.net/", BrowsersList.CHROME_TEMPORARY, "|" },
			{ "http://comments.azurewebsites.net", BrowsersList.FIREFOX_TEMPORARY, "*" },
			{ "http://commentssprintone.azurewebsites.net/", BrowsersList.CHROME_TEMPORARY, "*" },
			{ "http://comments.azurewebsites.net", BrowsersList.FIREFOX_TEMPORARY, "(" },
			{ "http://commentssprintone.azurewebsites.net/", BrowsersList.CHROME_TEMPORARY, "(" },
			{ "http://comments.azurewebsites.net", BrowsersList.FIREFOX_TEMPORARY, ")" },
			{ "http://commentssprintone.azurewebsites.net/", BrowsersList.CHROME_TEMPORARY, ")" },
			{ "http://comments.azurewebsites.net", BrowsersList.FIREFOX_TEMPORARY, "_" },
			{ "http://commentssprintone.azurewebsites.net/", BrowsersList.CHROME_TEMPORARY, "_" },
			{ "http://comments.azurewebsites.net", BrowsersList.FIREFOX_TEMPORARY, ":" },
			{ "http://commentssprintone.azurewebsites.net/", BrowsersList.CHROME_TEMPORARY, ":" },
			{ "http://comments.azurewebsites.net", BrowsersList.FIREFOX_TEMPORARY, ";" },
			{ "http://commentssprintone.azurewebsites.net/", BrowsersList.CHROME_TEMPORARY, ";" },
			{ "http://comments.azurewebsites.net", BrowsersList.FIREFOX_TEMPORARY, "#" },
			{ "http://commentssprintone.azurewebsites.net/", BrowsersList.CHROME_TEMPORARY, "#" },
			{ "http://comments.azurewebsites.net", BrowsersList.FIREFOX_TEMPORARY, "%" },
			{ "http://commentssprintone.azurewebsites.net/", BrowsersList.CHROME_TEMPORARY, "%" },
			{ "http://comments.azurewebsites.net", BrowsersList.FIREFOX_TEMPORARY, "^" },
			{ "http://commentssprintone.azurewebsites.net/", BrowsersList.CHROME_TEMPORARY, "^" },
			{ "http://comments.azurewebsites.net", BrowsersList.FIREFOX_TEMPORARY, "?" },
			{ "http://commentssprintone.azurewebsites.net/", BrowsersList.CHROME_TEMPORARY, "?" },
			{ "http://comments.azurewebsites.net", BrowsersList.FIREFOX_TEMPORARY, "[" },
			{ "http://commentssprintone.azurewebsites.net/", BrowsersList.CHROME_TEMPORARY, "[" },
			{ "http://comments.azurewebsites.net", BrowsersList.FIREFOX_TEMPORARY, "]" },
			{ "http://commentssprintone.azurewebsites.net/", BrowsersList.CHROME_TEMPORARY, "]" } 
			};

			
	}
}
