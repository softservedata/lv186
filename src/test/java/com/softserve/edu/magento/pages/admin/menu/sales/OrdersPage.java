package com.softserve.edu.magento.pages.admin.menu.sales;

import com.softserve.edu.magento.controls.ITable;
import com.softserve.edu.magento.pages.admin.VerticalMenu;
import com.softserve.edu.magento.tools.Search;
import org.openqa.selenium.WebElement;
import ss.af.reporting.annotations.ServiceReport;

/**
 * Created by bohdan on 15.08.16.
 */
public class OrdersPage extends VerticalMenu {
    private WebElement createNewOrder;
    private WebElement ordersRecords;
    private ITable tableOrders;
    public OrdersPage() {
        this.createNewOrder = Search.id("add");
        this.ordersRecords = Search.cssSelector("#container > div > div.admin__data-grid-wrap > table > tbody");
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
    @ServiceReport
    public CreateOrderSelectCustomerPage gotoCreateOrderSelectCustomerPage() {
        clickCreateNewOrder();
        return new CreateOrderSelectCustomerPage();
    }
}
