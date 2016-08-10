package com.softserve.edu.magento.pages.admin.menu.customers.editCustomer;


import org.openqa.selenium.WebElement;

import com.softserve.edu.magento.tools.Search;

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
	
	
	public CustomerViewPage() {

		this.LastLoggedInfo = Search
				.xpath("//th[contains(text(), '"+ Labels.FIRST_FIELD.toString()+"')]//following-sibling::td");
		this.AccountLockedInInfo = Search
				.xpath("//th[contains(text(), '"+ Labels.SECOND_FIELD.toString()+"')]//following-sibling::td");
		this.ConfirmedEmailInfo = Search
				.xpath("//th[contains(text(), '"+ Labels.THIRD_FIELD.toString()+"')]//following-sibling::td");
		this.AccountCreatedInfo = Search
				.xpath("//th[contains(text(), '"+ Labels.FOURTH_FIELD.toString()+"')]//following-sibling::td");
		this.AccountCreatedInInfo = Search
				.xpath("//th[contains(text(), '"+ Labels.FIFTH_FIELD.toString()+"')]//following-sibling::td");
		this.CustomerGroupInfo = Search
				.xpath("//th[contains(text(), '"+ Labels.SIXTH_FIELD.toString()+"')]//following-sibling::td");
		// TODO
		this.CustomerGroupInfo = Search
				.xpath("//th[contains(text(), '"+ Labels.SIXTH_FIELD.toString()+"')]//following-sibling::td");
	}
	
}
