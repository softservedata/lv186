package com.softserve.edu.magento.pages.admin.menu.sales;

import com.softserve.edu.magento.pages.admin.VerticalMenu;
import com.softserve.edu.magento.tools.Search;
import org.openqa.selenium.WebElement;

/**
 * Created by bohdan on 15.08.16.
 */
public class OrdersPage extends VerticalMenu {
    private WebElement createNewOrder;
    private WebElement ordersRecords;


    public OrdersPage() {
        createNewOrder = Search.id("add");
        ordersRecords = Search.cssSelector("#container > div > div.admin__data-grid-wrap > table > tbody");
    }

    // Page Object
    // Get Data PageObject

    public WebElement getCreateNewOrder() {
        return createNewOrder;
    }

    public WebElement getOrdersRecords() {
        return ordersRecords;
    }

    // set Data PageObject

    public void clickCreateNewOrder() {
        getCreateNewOrder().click();
    }

    // Business Logic

    public CreateOrderSelectCustomerPage gotoCreateOrderSelectCustomerPage(){
        clickCreateNewOrder();
        return new CreateOrderSelectCustomerPage();
    }
}
