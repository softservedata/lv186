package com.softserve.edu.homeTestCase5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageBase extends ConciseAPI{
	
private WebDriver driver;
	
	public PageBase(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@Override
	public WebDriver getWebDriver() {
		// TODO Auto-generated method stub
		return driver;
	}
}
