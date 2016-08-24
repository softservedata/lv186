package com.softserve.edu.magento.pages.admin.menu.sales;

import com.softserve.edu.magento.tools.Search;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by bohdan on 16.08.16.
 */
public class CreateOrderFillInformationPage {

    // ----------------------------
    private class ProductsComponent {
        public final WebElement listOfProducts;
        public final WebElement searchByProductName;
        public final WebElement searchById;
        public final WebElement addProductsToOrder;

        public ProductsComponent() {
            this.listOfProducts = Search.cssSelector("#sales_order_create_search_grid_table > tbody");
            this.searchByProductName = Search.cssSelector("#sales_order_create_search_grid_filter_name");
            this.searchById = Search.cssSelector("#sales_order_create_search_grid_filter_entity_id");
            this.addProductsToOrder = Search.cssSelector("[onclick='order.productGridAddSelected()']");
        }
    }

    private class ItemsOrderedComponent {
        public final WebElement updateItems;
        public final WebElement tableOfProducts;

        public ItemsOrderedComponent() {
            this.updateItems = Search.cssSelector("[onclick='order.itemsUpdate()']");
            this.tableOfProducts = Search.cssSelector("#order-items_grid > table");
        }
    }

    private WebElement cancel;
    private WebElement submitOrder;
    private WebElement addProducts;
    private Select billingAdressCustomerAdresses;
    private WebElement billingAdressPrefix;
    private WebElement billingAdressFirstName;
    private WebElement billingAdressLastName;
    private WebElement billingAdressStreetAddress;
    private WebElement billingAdressCity;
    private Select billingAdressCountry;
    private WebElement billingAdressStateElement;
    private Select billingAdressStateSelect;
    private WebElement billingAdressPostalCode;
    private WebElement billingAdressPhoneNumber;
    private WebElement shippingMethod;
    private Select shippingAdressCustomerAdresses;
    private WebElement shippingAdressPrefix;
    private WebElement shippingAdressFirstName;
    private WebElement shippingAdressLastName;
    private WebElement shippingAdressStreetAddress;
    private WebElement shippingAdressCity;
    private Select shippingAdressCountry;
    private WebElement shippingAdressStateElement;
    private Select shippingAdressStateSelect;
    private WebElement shippingAdressPostalCode;
    private WebElement shippingAdressPhoneNumber;
    private WebElement subTotal;
    private WebElement shippingAndHandling;

}
