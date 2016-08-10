package com.softserve.edu.magento.pages.admin.menu.customers.editCustomer;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.softserve.edu.magento.tools.Search;

public class AccountInformationPage extends ACustomPageSideMenu {
	private Select associateToWebsite;
	private Select group;
	private WebElement chekboxForGroup;
	private WebElement prefix;
	private WebElement firstname;
	private WebElement middlename;
	private WebElement lastname;
	private WebElement suffix;
	private WebElement email;
	private Select dateOfBirth;
	private WebElement tax;
	private Select gender;
	private Select sendWelcomeEmailFrom;
	
	public enum AssosieteWebsites {
		MAIN_WEBSITE("Main Website");
		private String websiteId;
		private AssosieteWebsites (String websiteId){
			this.websiteId = websiteId;
		}
		@Override
		public String toString () {
			return this.websiteId;
		}
	}
	
	public AccountInformationPage () {

		this.associateToWebsite = new Select(Search.cssSelector("select[name='customer[website_id]']"));
		this.group = new Select(Search.cssSelector("select[name='customer[group_id]']"));
		this.chekboxForGroup = Search.xpath("//label[contains(text(),'Disable Automatic ')]");
		this.prefix = Search.cssSelector("input[name='customer[prefix]']");
		this.firstname = Search.cssSelector("input[name='customer[firstname]']");
		this.middlename = Search.cssSelector("input[name='customer[middlename]']");
		this.lastname = Search.cssSelector("input[name='customer[lastname]']");
		this.suffix = Search.cssSelector("input[name='customer[suffix]']");
		this.email = Search.cssSelector("input[name='customer[email]']");
		this.dateOfBirth = new Select(Search.cssSelector("input[name='customer[dob]']"));
		this.tax = Search.cssSelector("input[name='customer[taxvat]']");
		this.gender = new Select(Search.cssSelector("select[name='customer[gender]']"));
		this.sendWelcomeEmailFrom = new Select(Search.cssSelector("select[name='customer[sendemail_store_id]']"));
	}

	public Select getAssociateToWebsite() {
		return this.associateToWebsite;
	}

	public Select getGroup() {
		return this.group;
	}

	public WebElement getChekboxForGroup() {
		return this.chekboxForGroup;
	}

	public WebElement getPrefix() {
		return this.prefix;
	}

	public WebElement getFirstname() {
		return this.firstname;
	}

	public WebElement getMiddlename() {
		return this.middlename;
	}

	public WebElement getLastname() {
		return this.lastname;
	}

	public WebElement getSuffix() {
		return this.suffix;
	}

	public WebElement getEmail() {
		return this.email;
	}

	public Select getDateOfBirth() {
		return this.dateOfBirth;
	}

	public WebElement getTax() {
		return this.tax;
	}

	public Select getGender() {
		return this.gender;
	}

	public Select getSendWelcomeEmailFrom() {
		return this.sendWelcomeEmailFrom;
	}
	
	
}
