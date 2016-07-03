package com.softserve.edu.homeTestCase6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class ConciseAPI {
	public abstract WebDriver getWebDriver();
	
	public void open(String url) {
		getWebDriver().get(url);
	}
	
}
