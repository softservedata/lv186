package com.softserve.edu.magento.pages.admin.menu.customers.editCustomer;


import org.openqa.selenium.WebElement;

import com.softserve.edu.magento.pages.admin.VerticalMenu;
import com.softserve.edu.magento.tools.Search;

abstract class ACustomerPageHead extends VerticalMenu {

	protected UIMapperForAbstracts find;
	
	protected WebElement back;
	protected WebElement deleteCustomer;
	protected WebElement reset;
	protected WebElement createOrder;
	protected WebElement resetPassword;
	protected WebElement forceSignIn;
	protected WebElement saveAndContinueEdit;
	protected WebElement saveCustomer;
	
	protected ACustomerPageHead(){
		this.back = Search.id("back");
		this.deleteCustomer = Search.id("customer-edit-delete-button");
		this.reset = Search.id("reset");
		this.createOrder = Search.id("order");
		this.resetPassword = Search.id("resetPassword");
		this.forceSignIn = Search.id("invalidateToken");
		this.saveAndContinueEdit = Search.id("save_and_continue");
		this.saveCustomer = Search.id("save");
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
