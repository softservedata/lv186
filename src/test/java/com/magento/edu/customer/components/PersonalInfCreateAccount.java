package com.magento.edu.customer.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.magento.edu.customer.data.user.IPersonalInfo_User;

public class PersonalInfCreateAccount {
	
	public WebElement firstNameField;
	public WebElement labelFirstNameField;
	public WebElement lastNameField;
	public WebElement labelLastNameField;
	public WebElement signUpNewsletterCheckBox;
	public WebElement labelSignUpNewsletterCheckBox;
	
	public PersonalInfCreateAccount(WebDriver driver) {
		this.firstNameField = driver.findElement(By.id("firstname"));
		this.labelFirstNameField = driver.findElement(By.xpath("//label[@for='firstname']"));
		this.lastNameField = driver.findElement(By.id("lastname"));
		this.labelLastNameField = driver.findElement(By.xpath("//label[@for='lastname']"));
		this.signUpNewsletterCheckBox = driver.findElement(By.id("is_subscribed"));
		this.labelSignUpNewsletterCheckBox = driver.findElement(By.xpath("//label[@for='is_subscribed']"));
	}

	
	public WebElement getFirstNameField() {
		return firstNameField;
	}


	public WebElement getLabelFirstNameField() {
		return labelFirstNameField;
	}


	public WebElement getLastNameField() {
		return lastNameField;
	}


	public WebElement getLabelLastNameField() {
		return labelLastNameField;
	}


	public WebElement getSignUpNewsletterCheckBox() {
		return signUpNewsletterCheckBox;
	}


	public WebElement getLabelSignUpNewsletterCheckBox() {
		return labelSignUpNewsletterCheckBox;
	}


	//business logic
	
	public String getFirstNameText() {
		return getFirstNameField().getText();
	}
	public String getLastNameText() {
		return getLastNameField().getText();
	}
	public void clickLabelSignUpNewsletter() {
		getLabelSignUpNewsletterCheckBox().click();
	}
	public void clickSignUpNewsletterCheckBox() {
		this.getSignUpNewsletterCheckBox().click();
	}
	//clear fields
	public void clearFirstNameField() {
		getFirstNameField().clear();
	}
	public void clearLastNameField() {
		getLastNameField().clear();
	}
	//input data
	public void typeFirstName(String firstname) {
		getFirstNameField().sendKeys(firstname);
	}
	public void typeLastName(String lastname) {
		getLastNameField().sendKeys(lastname);
	}
	public void clearTypeFirstName(String firstname) {
		clearFirstNameField();
		typeFirstName(firstname);
	}
	public void clearTypeLastName(String lastname) {
		clearLastNameField();
		typeLastName(lastname);
	}
	//input form personal inform
	public void input_Personal_inform(IPersonalInfo_User personalInfo_User) {
		clearTypeFirstName(personalInfo_User.getFirstname());
		clearTypeLastName(personalInfo_User.getLastname());
		if ( personalInfo_User.getSignUpNewsletter() == true ) {
			clickSignUpNewsletterCheckBox();
		}
	}
	
}
