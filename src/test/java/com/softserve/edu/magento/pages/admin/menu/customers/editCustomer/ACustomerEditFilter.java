package com.softserve.edu.magento.pages.admin.menu.customers.editCustomer;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Represents the filter info header 
 * and provides pagination.
 */
abstract class ACustomerEditFilter {
	protected WebElement search;
	protected WebElement resetFilter;
	protected WebElement recordsFound;
	protected Select perPage;
	protected List<WebElement> pagination;
	
	public enum OrdersGridPageLimit{
		TWENTY("20"),
		THIRTY("30"),
		FIFTY("50"),
		HUNDRED("100"),
		TWO_HUNDRED("200");
		private String amount;
		private OrdersGridPageLimit (String amount){
			this.amount = amount;
		}
		
		@Override
		public String toString () {
			return this.amount;
		}
	}
}

