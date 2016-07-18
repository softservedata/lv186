package com.softserve.edu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage extends VerticalMenu {
	//Fields
	private WebElement title;
	private WebElement lifeTimeSales;
	private WebElement lifeTimeSalesValue;
	private WebElement averageOrder;
	private WebElement averageOrderValue;
	private WebElement lastOrdersTitle;
	private WebElement lastOrders;
	//Elements
	//private StoreViewComponent storeView;
	

	protected DashboardPage(WebDriver driver) {
		super(driver);

	}

}
