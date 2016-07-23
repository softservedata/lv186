package com.softserve.edu.magento.editCustomer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class OrdersPage extends ACustomPageSideMenu {
	// TODO move to other class
	private WebElement search = driver.findElement(By.cssSelector("button[title='Search']"));
	private WebElement restFilter;
	private WebElement recordsFound;
	//
	private WebElement orderSort;
	private WebElement purchasedSort;
	private WebElement bill_toSort;
	private WebElement ship_toSort;
	private WebElement totalSort;
	private WebElement storeSort;
	private WebElement orderFilter;
	private WebElement purchaseDateFilterFrom;
	private WebElement purchaseDateFilterTo;
	private WebElement bill_toFilter;
	private WebElement ship_toFilter;
	private WebElement totalFilterFrom;
	private WebElement totalFilterTo;
	private Select storeSelect;
	private WebElement result;
	
	public OrdersPage (WebDriver driver) {
		super(driver);
		this.orderSort = driver.findElement(By.cssSelector("th[data-sort='increment_id']"));
		this.purchasedSort = driver.findElement(By.cssSelector("th[data-sort='created_at']"));
		this.bill_toSort = driver.findElement(By.cssSelector("th[data-sort='billing_name']"));
		this.ship_toSort = driver.findElement(By.cssSelector("th[data-sort='shipping_name']"));
		this.totalSort = driver.findElement(By.cssSelector("th[data-sort='grand_total']"));
		this.storeSort = driver.findElement(By.cssSelector("th[data-sort='store_id']"));
		this.orderFilter = driver.findElement(By.cssSelector("input[name='increment_id']"));
		// TODO
		this.purchaseDateFilterFrom = driver.findElement(By.cssSelector("td[data-column='created_at'] input[name='created_at[from]']"));
		this.purchaseDateFilterTo = driver.findElement(By.cssSelector("td[data-column='created_at'] input[name='created_at[to]']")); 
		//
		this.bill_toFilter = driver.findElement(By.cssSelector("input[name='billing_name']"));
		this.ship_toFilter = driver.findElement(By.cssSelector("input[name='shipping_name']"));
		this.totalFilterFrom = driver.findElement(By.cssSelector("td[data-column='grand_total'] input[name='grand_total[from]']"));
		this.totalFilterTo = driver.findElement(By.cssSelector("td[data-column='grand_total'] input[name='grand_total[to]']"));
		this.storeSelect = new Select(driver.findElement(By.cssSelector("select[name='store_id']")));
		if (driver.findElement(By.className("empty-text")).isDisplayed()){
			this.result = driver.findElement(By.className("empty-text"));
		}
	//	else this.result = 
	}
}
