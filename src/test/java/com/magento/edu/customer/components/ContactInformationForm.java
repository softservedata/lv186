package com.magento.edu.customer.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactInformationForm {
	protected WebDriver driver;
	
	public WebElement nameEmail_contactInf;
	public WebElement editLink_contactInf;
	public WebElement changePass_contactInf;
	
	public WebElement inform_Newsletters;
	public WebElement editLink_Newsletters;
	
	public ContactInformationForm(WebDriver driver) {
		this.driver = driver;
		
		WebElement box_information =  driver.findElement(By.className("box box-information"));
		this.nameEmail_contactInf = box_information.findElement(By.className("box-content"));
		this.editLink_contactInf = box_information.findElement(By.className("action edit"));
		this.changePass_contactInf = box_information.findElement(By.className("action change-password"));
		
		WebElement box_newsletters =  driver.findElement(By.className("box box-newsletter"));
		this.inform_Newsletters = box_newsletters.findElement(By.className("box-content"));
		this.editLink_Newsletters = box_newsletters.findElement(By.className("action edit"));
	}
//getters
	public WebElement getNameEmail_contactInf() {
		return nameEmail_contactInf;
	}

	public WebElement getEditLink_contactInf() {
		return editLink_contactInf;
	}

	public WebElement getChangePass_contactInf() {
		return changePass_contactInf;
	}

	public WebElement getInform_Newsletters() {
		return inform_Newsletters;
	}

	public WebElement getEditLink_Newsletters() {
		return editLink_Newsletters;
	}
//business logic
//get text	
	public String getNameEmaiText() {
		return this.getNameEmail_contactInf().getText();
	}
	public String getInform_NewslettersText() {
		return this.getInform_Newsletters().getText();
	}
//click links
	public void clickEditLink_contactInf() {
		this.getEditLink_contactInf().click();
	}
	public void clickChangePass_contactInf() {
		this.getChangePass_contactInf().click();
	}
	public void clickEditLink_Newsletters() {
		this.getChangePass_contactInf().click();
	}
}
