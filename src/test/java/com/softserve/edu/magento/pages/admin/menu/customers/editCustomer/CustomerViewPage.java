package com.softserve.edu.magento.pages.admin.menu.customers.editCustomer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerViewPage extends ACustomPageSideMenu {

	public enum Labels {
		FIRST_FIELD("Last Logged In:"), 
		SECOND_FIELD("Account Lock:"), 
		THIRD_FIELD("Confirmed email:"), 
		FOURTH_FIELD("Account Created:"), 
		FIFTH_FIELD("Account Created in:"), 
		SIXTH_FIELD("Customer Group:");
		private String fieldName;

		private Labels(String fieldName) {
			this.fieldName = fieldName;
		}

		@Override
		public String toString() {
			return this.fieldName;
		}
	}

	private WebElement LastLoggedInfo;
	private WebElement AccountLockedInInfo;
	private WebElement ConfirmedEmailInfo;
	private WebElement AccountCreatedInfo;
	private WebElement AccountCreatedInInfo;
	private WebElement CustomerGroupInfo;
	private WebElement DefaultBillingAddress;
	
	
	public CustomerViewPage(WebDriver driver) {
		super(driver);
		this.LastLoggedInfo = driver.findElement(By
				.xpath("//th[contains(text(), '"+ Labels.FIRST_FIELD.toString()+"')]//following-sibling::td"));
		this.AccountLockedInInfo = driver.findElement(By
				.xpath("//th[contains(text(), '"+ Labels.SECOND_FIELD.toString()+"')]//following-sibling::td"));
		this.ConfirmedEmailInfo = driver.findElement(By
				.xpath("//th[contains(text(), '"+ Labels.THIRD_FIELD.toString()+"')]//following-sibling::td"));
		this.AccountCreatedInfo = driver.findElement(By
				.xpath("//th[contains(text(), '"+ Labels.FOURTH_FIELD.toString()+"')]//following-sibling::td"));
		this.AccountCreatedInInfo = driver.findElement(By
				.xpath("//th[contains(text(), '"+ Labels.FIFTH_FIELD.toString()+"')]//following-sibling::td"));
		this.CustomerGroupInfo = driver.findElement(By
				.xpath("//th[contains(text(), '"+ Labels.SIXTH_FIELD.toString()+"')]//following-sibling::td"));
		// TODO
		this.CustomerGroupInfo = driver.findElement(By
				.xpath("//th[contains(text(), '"+ Labels.SIXTH_FIELD.toString()+"')]//following-sibling::td"));
	}
	
}
