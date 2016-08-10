package com.softserve.edu.magento.pages.admin.menu.customers.editCustomer;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.softserve.edu.magento.tools.Search;

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
	
	public BillingAgreementsPage (){
		this.idSort = Search.cssSelector("th[data-sort='agreement_id']");
		this.referenceIdSort = Search.cssSelector("th[data-sort='reference_id']");
		this.statusSort = Search.cssSelector("th[data-sort='status']");
		this.createdSort = Search.cssSelector("th[data-sort='created_at']");
		this.updatedSort = Search.cssSelector("th[data-sort='updated_at']");
		this.idFilter = Search.cssSelector("input[name='agreement_id']");
		this.referenceIdFilter = Search.cssSelector("input[name='reference_id']"); 
		this.statusFilter = new Select(Search.id("customer_edit_tab_agreements_filter_status"));
		// TODO
		this.createdFilterFrom = Search.cssSelector("th[data-sort='created_at']");
		this.updatedSort = Search.cssSelector("th[data-sort='updated_at']");
	}

}
