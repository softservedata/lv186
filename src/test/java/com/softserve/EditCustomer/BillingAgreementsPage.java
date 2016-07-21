package com.softserve.EditCustomer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BillingAgreementsPage extends ACustomPageSideMenu {
	private WebElement idSort;
	private WebElement referenceIdSort;
	private WebElement statusSort;
	private WebElement createdSort;
	private WebElement updatedSort;
	private WebElement idFilter;
	private WebElement referenceIdFilter;;
	private Select statusFilter;
	private WebElement createdFilterFrom;
	private WebElement createdFilterTo;
	private WebElement updatedFilterFrom;
	private WebElement updatedFilterTo;
	private WebElement result;
	
	public BillingAgreementsPage (WebDriver driver){
		super(driver);
		this.idSort = driver.findElement(By.cssSelector("th[data-sort='agreement_id']"));
		this.referenceIdSort = driver.findElement(By.cssSelector("th[data-sort='reference_id']"));
		this.statusSort = driver.findElement(By.cssSelector("th[data-sort='status']"));
		this.createdSort = driver.findElement(By.cssSelector("th[data-sort='created_at']"));
		this.updatedSort = driver.findElement(By.cssSelector("th[data-sort='updated_at']"));
		this.idFilter = driver.findElement(By.cssSelector("input[name='agreement_id']"));
		this.referenceIdFilter = driver.findElement(By.cssSelector("input[name='reference_id']")); 
		this.statusFilter = new Select(driver.findElement(By.id("customer_edit_tab_agreements_filter_status")));
		// TODO
		this.createdFilterFrom = driver.findElement(By.cssSelector("th[data-sort='created_at']"));
		this.updatedSort = driver.findElement(By.cssSelector("th[data-sort='updated_at']"));
	}

}
