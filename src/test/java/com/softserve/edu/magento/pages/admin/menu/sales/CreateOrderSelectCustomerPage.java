package com.softserve.edu.magento.pages.admin.menu.sales;

import com.softserve.edu.magento.tools.Search;
import org.openqa.selenium.WebElement;

/**
 * Created by bohdan on 15.08.16.
 */
public class CreateOrderSelectCustomerPage {
    private WebElement createNewCustomer;
    private WebElement customersTable;

    public CreateOrderSelectCustomerPage() {
        this.createNewCustomer = Search.cssSelector("[title='Create New Customer']");
        this.customersTable = Search.cssSelector("#sales_order_create_customer_grid_table > tbody");
    }

    // Page Object
    // Get Data PageObject

    public WebElement getCreateNewCustomer() {
        return createNewCustomer;
    }

    public WebElement getCustomersTable() {
        return customersTable;
    }

    // set Data PageObject
}
