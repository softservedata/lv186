package com.softserve.edu.magento.pages.admin.menu.customers.editCustomer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.softserve.edu.magento.tools.Search;

public class OrdersPage extends ACustomPageSideMenu {
	// TODO move to other class
	private WebElement search = Search.cssSelector("button[title='Search']");
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
	
	public OrdersPage () {

		this.orderSort = Search.cssSelector("th[data-sort='increment_id']");
		this.purchasedSort = Search.cssSelector("th[data-sort='created_at']");
		this.bill_toSort = Search.cssSelector("th[data-sort='billing_name']");
		this.ship_toSort = Search.cssSelector("th[data-sort='shipping_name']");
		this.totalSort = Search.cssSelector("th[data-sort='grand_total']");
		this.storeSort = Search.cssSelector("th[data-sort='store_id']");
		this.orderFilter = Search.cssSelector("input[name='increment_id']");
		// TODO
		this.purchaseDateFilterFrom = Search.cssSelector("td[data-column='created_at'] input[name='created_at[from]']");
		this.purchaseDateFilterTo = Search.cssSelector("td[data-column='created_at'] input[name='created_at[to]']"); 
		//
		this.bill_toFilter = Search.cssSelector("input[name='billing_name']");
		this.ship_toFilter = Search.cssSelector("input[name='shipping_name']");
		this.totalFilterFrom = Search.cssSelector("td[data-column='grand_total'] input[name='grand_total[from]']");
		this.totalFilterTo = Search.cssSelector("td[data-column='grand_total'] input[name='grand_total[to]']");
		this.storeSelect = new Select(Search.cssSelector("select[name='store_id']"));
		if (Search.className("empty-text").isDisplayed()){
			this.result = Search.className("empty-text");
		}
	//	else this.result = 
	}
}
