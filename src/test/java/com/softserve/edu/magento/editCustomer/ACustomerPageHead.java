package com.softserve.edu.magento.editCustomer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.magento.pages.VerticalMenu;

abstract class ACustomerPageHead extends VerticalMenu {
	protected WebDriver driver;
	protected UIMapperForAbstracts find;
	
	protected WebElement back;
	protected WebElement deleteCustomer;
	protected WebElement reset;
	protected WebElement createOrder;
	protected WebElement resetPassword;
	protected WebElement forceSignIn;
	protected WebElement saveAndContinueEdit;
	protected WebElement saveCustomer;
	
	protected ACustomerPageHead(WebDriver driver){
		super(driver);
		this.driver = driver;
		this.back = driver.findElement(By.id("back"));
		this.deleteCustomer = driver.findElement(By.id("customer-edit-delete-button"));
		this.reset = driver.findElement(By.id("reset"));
		this.createOrder = driver.findElement((By.id("order")));
		this.resetPassword = driver.findElement((By.id("resetPassword")));
		this.forceSignIn = driver.findElement((By.id("invalidateToken")));
		this.saveAndContinueEdit = driver.findElement((By.id("save_and_continue")));
		this.saveCustomer = driver.findElement((By.id("save")));
	}

	public WebDriver getDriver() {
		return driver;
	}

	public UIMapperForAbstracts getFind() {
		return find;
	}

	public WebElement getBack() {
		return back;
	}

	public WebElement getDeleteCustomer() {
		return deleteCustomer;
	}

	public WebElement getReset() {
		return reset;
	}

	public WebElement getCreateOrder() {
		return createOrder;
	}

	public WebElement getResetPassword() {
		return resetPassword;
	}

	public WebElement getForceSignIn() {
		return forceSignIn;
	}

	public WebElement getSaveAndContinueEdit() {
		return saveAndContinueEdit;
	}

	public WebElement getSaveCustomer() {
		return saveCustomer;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void setFind(UIMapperForAbstracts find) {
		this.find = find;
	}

	public void setBack(WebElement back) {
		this.back = back;
	}

	public void setDeleteCustomer(WebElement deleteCustomer) {
		this.deleteCustomer = deleteCustomer;
	}

	public void setReset(WebElement reset) {
		this.reset = reset;
	}

	public void setCreateOrder(WebElement createOrder) {
		this.createOrder = createOrder;
	}

	public void setResetPassword(WebElement resetPassword) {
		this.resetPassword = resetPassword;
	}

	public void setForceSignIn(WebElement forceSignIn) {
		this.forceSignIn = forceSignIn;
	}

	public void setSaveAndContinueEdit(WebElement saveAndContinueEdit) {
		this.saveAndContinueEdit = saveAndContinueEdit;
	}

	public void setSaveCustomer(WebElement saveCustomer) {
		this.saveCustomer = saveCustomer;
	}
	
	
}
