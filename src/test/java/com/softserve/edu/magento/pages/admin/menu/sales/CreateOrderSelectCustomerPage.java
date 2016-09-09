package com.softserve.edu.magento.pages.admin.menu.sales;

import com.softserve.edu.magento.data.customer.user.ICustomerUser;
import com.softserve.edu.magento.pages.admin.VerticalMenu;
import com.softserve.edu.magento.tools.Search;
import org.openqa.selenium.WebElement;
import ss.af.reporting.annotations.ServiceReport;

/**
 * Created by bohdan on 15.08.16.
 */
public class CreateOrderSelectCustomerPage extends VerticalMenu {
    //Fields
    public final static String DATA_NOT_FOUND_MESSAGE = "We couldn't find any records.";

    // Elements
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

    public WebElement getSearchedUser() {
        return searchedUser;
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

    public void clickSearchedUser() {
        getSearchedUser().click();
    }

    // Business Logic

    public boolean findCustomer(ICustomerUser user) {
        if (!Search.checkDOMForText(DATA_NOT_FOUND_MESSAGE)) {
            searchedUser = Search.cssSelector("#sales_order_create_customer_grid_table > tbody > tr > td.col-name");
            clickCustomerFilterName();
            String fullName = user.getPersonalInfo().getFirstname() + " " + user.getPersonalInfo().getLastname();
            getCustomerFilterName().sendKeys(fullName);
            clickSearchButton();
            if (!Search.checkDOMForText(DATA_NOT_FOUND_MESSAGE)) {
                if (Search.stalenessOf(searchedUser)) {
                    searchedUser = Search.cssSelector("#sales_order_create_customer_grid_table > tbody > tr > td.col-name");
                }
                if (searchedUser.getText().equals(fullName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public CreateOrderFillInformationPage gotoCreateOrderFillInformationPage() {
        clickCreateNewCustomer();
        return new CreateOrderFillInformationPage();
    }

    @ServiceReport
    public CreateOrderFillInformationPage gotoCreateOrderFillInformationPage(ICustomerUser user) {
        if (findCustomer(user)) {
            clickSearchedUser();
            return new CreateOrderFillInformationPage();
        }
        return gotoCreateOrderFillInformationPage();
    }

    @ServiceReport
    public OrdersPage gotoOrdersPage() {
        clickBack();
        return new OrdersPage();
    }
}
