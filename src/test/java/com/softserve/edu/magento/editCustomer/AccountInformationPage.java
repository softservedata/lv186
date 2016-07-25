package com.softserve.edu.magento.editCustomer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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
	
	public AccountInformationPage (WebDriver driver) {
		super(driver);
		this.associateToWebsite = new Select(driver.findElement(By.cssSelector("select[name='customer[website_id]']")));
		this.group = new Select(driver.findElement(By.cssSelector("select[name='customer[group_id]']")));
		this.chekboxForGroup = driver.findElement(By.xpath("//label[contains(text(),'Disable Automatic ')]"));
		this.prefix = driver.findElement(By.cssSelector("input[name='customer[prefix]']"));
		this.firstname = driver.findElement(By.cssSelector("input[name='customer[firstname]']"));
		this.middlename = driver.findElement(By.cssSelector("input[name='customer[middlename]']"));
		this.lastname = driver.findElement(By.cssSelector("input[name='customer[lastname]']"));
		this.suffix = driver.findElement(By.cssSelector("input[name='customer[suffix]']"));
		this.email = driver.findElement(By.cssSelector("input[name='customer[email]']"));
		this.dateOfBirth = new Select(driver.findElement(By.cssSelector("input[name='customer[dob]']")));
		this.tax = driver.findElement(By.cssSelector("input[name='customer[taxvat]']"));
		this.gender = new Select(driver.findElement(By.cssSelector("select[name='customer[gender]']")));
		this.sendWelcomeEmailFrom = new Select(driver.findElement(By.cssSelector("select[name='customer[sendemail_store_id]']")));
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
