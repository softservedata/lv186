package com.softserve.edu.magento.pages.admin.menu.sales;

import com.softserve.edu.magento.data.customer.user.ICustomerUser;
import com.softserve.edu.magento.tools.Search;
import org.openqa.selenium.WebElement;

/**
 * Created by bohdan on 15.08.16.
 */
public class CreateOrderSelectCustomerPage {
    private WebElement createNewCustomer;
    private WebElement customerFilterName;
    private WebElement back;
    private WebElement searchedUser;
    private WebElement searchButton;

    public CreateOrderSelectCustomerPage() {
        this.createNewCustomer = Search.cssSelector("[title='Create New Customer']");
        this.customerFilterName = Search.cssSelector("#sales_order_create_customer_grid_filter_name");
        this.back = Search.id("back_order_top_button");
        this.searchButton = Search.cssSelector("[onclick='sales_order_create_customer_gridJsObject.doFilter()']");
    }

    // Page Object
    // Get Data PageObject

    public WebElement getCreateNewCustomer() {
        return createNewCustomer;
    }

    public WebElement getCustomerFilterName() {
        return customerFilterName;
    }

    public WebElement getBack() {
        return back;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }
    // set Data PageObject

    public void clickCustomerFilterName() {
        getCustomerFilterName().click();
    }

    public void clickCreateNewCustomer() {
        getCreateNewCustomer().click();
    }

    public void clickBack() {
        getBack().click();
    }

    public void clickSearchButton() {
        getSearchButton().click();
    }
    // Business Logic

    public CreateOrderFillInformationPage gotoCreateOrderFillInformationPage() {
        clickCreateNewCustomer();
        return new CreateOrderFillInformationPage();
    }

    public CreateOrderFillInformationPage gotoCreateOrderFillInformationPage(ICustomerUser user) {
        clickCustomerFilterName();
        String fullName = user.getPersonalInfo().getFirstname() + " " + user.getPersonalInfo().getLastname();
        getCustomerFilterName().sendKeys(fullName);
        //clickSearchButton();
        //searchedUser = Search.cssSelector("._clickable  td.col-name");
        if (searchedUser.getText().equals(fullName)) {
            return new CreateOrderFillInformationPage();
        }
        return gotoCreateOrderFillInformationPage();
    }

    public OrdersPage gotoOrdersPage() {
        clickBack();
        return new OrdersPage();
    }
}
