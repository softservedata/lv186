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
    private WebElement shippingAdressFirstName;
    private WebElement shippingAdressLastName;
    private WebElement shippingAdressStreetAddress;
    private WebElement shippingAdressCity;
    private Select shippingAdressCountry;
    private WebElement shippingAdressStateElement;
    private Select shippingAdressStateSelect;
    private WebElement shippingAdressPostalCode;
    private WebElement shippingAdressPhoneNumber;

    public CreateOrderFillInformationPage() {
        this.cancel = Search.cssSelector("#reset_order_top_button");
        this.submitOrder = Search.cssSelector("#submit_order_top_button");
        this.addProducts = Search.cssSelector("[class='action-secondary action-add']");
        this.billingAdressCustomerAdresses = new Select(Search.cssSelector("#order-billing_address_customer_address_id"));
        this.billingAdressFirstName = Search.cssSelector("#order-billing_address_firstname");
        this.billingAdressLastName = Search.cssSelector("#order-billing_address_lastname");
        this.billingAdressStreetAddress = Search.cssSelector("#order-billing_address_street0");
        this.billingAdressCity = Search.cssSelector("#order-billing_address_city");
        this.billingAdressCountry = new Select(Search.cssSelector("#order-billing_address_country_id"));
        this.billingAdressStateElement = Search.cssSelector("#order-billing_address_region");
        this.billingAdressStateSelect = new Select(Search.cssSelector("#order-billing_address_region_id"));
        this.billingAdressPostalCode = Search.cssSelector("#order-billing_address_postcode");
        this.billingAdressPhoneNumber = Search.cssSelector("#order-billing_address_telephone");
        this.shippingMethod = Search.cssSelector("#order-shipping-method-summary > a");
        this.shippingAdressCustomerAdresses = new Select(Search.cssSelector("#order-shipping_address_customer_address_id"));
        this.shippingAdressFirstName = Search.cssSelector("#order-shipping_address_firstname");
        this.shippingAdressLastName = Search.cssSelector("#order-shipping_address_lastname");
        this.shippingAdressStreetAddress = Search.cssSelector("#order-shipping_address_street0");
        this.shippingAdressCity = Search.cssSelector("#order-shipping_address_city");
        this.shippingAdressCountry = new Select(Search.cssSelector("#order-shipping_address_country_id"));
        this.shippingAdressStateElement = Search.cssSelector("#order-shipping_address_region");
        this.shippingAdressStateSelect = new Select(Search.cssSelector("#order-shipping_address_region_id"));
        this.shippingAdressPostalCode = Search.cssSelector("#order-shipping_address_postcode");
        this.shippingAdressPhoneNumber = Search.cssSelector("#order-shipping_address_telephone");
        this.shippingMethod = Search.cssSelector("#order-shipping-method-summary > a");
        this.shippingAdressCustomerAdresses = new Select(Search.cssSelector("#order-shipping_address_customer_address_id"));
    }
}
