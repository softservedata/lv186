package com.softserve.edu.magento.pages.admin.menu.sales;

import com.softserve.edu.magento.data.admin.products.IProduct;
import com.softserve.edu.magento.data.admin.products.ProductRepository;
import com.softserve.edu.magento.data.customer.user.ICustomerUser;
import com.softserve.edu.magento.pages.admin.VerticalMenu;
import com.softserve.edu.magento.tools.Search;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.softserve.edu.magento.pages.admin.menu.sales.CreateOrderSelectCustomerPage.DATA_NOT_FOUND_MESSAGE;

/**
 * Created by bohdan on 16.08.16.
 */
public class CreateOrderFillInformationPage extends VerticalMenu {

    // ----------------------------
    private class ProductsComponent {

        public WebElement searchedProductName;
        public final WebElement searchByProductName;
        public final WebElement searchById;
        public final WebElement addProductsToOrder;
        public final WebElement searchButton;

        public ProductsComponent() {
            searchButton = Search.cssSelector("[onclick='sales_order_create_search_gridJsObject.doFilter()']");
            searchByProductName = Search.cssSelector("#sales_order_create_search_grid_filter_name");
            searchById = Search.cssSelector("#sales_order_create_search_grid_filter_entity_id");
            addProductsToOrder = Search.cssSelector("[onclick='order.productGridAddSelected()']");
        }
    }

    private class ItemsOrderedComponent {

        public final WebElement updateItems;
        public final WebElement tableOfProducts;

        public ItemsOrderedComponent() {
            updateItems = Search.cssSelector("[onclick='order.itemsUpdate()']");
            tableOfProducts = Search.cssSelector("#order-items_grid > table");
        }
    }

    private class ShippingMethodComponent {
        public final WebElement fixedRate;
        //public final WebElement tableRate;

        public ShippingMethodComponent() {
            this.fixedRate = Search.cssSelector("[for='s_method_flatrate_flatrate']");
           // this.tableRate = Search.cssSelector("[for='s_method_tablerate_bestway']");
        }
    }

    //Elements

    private WebElement cancel;
    private WebElement submitOrder;
    private WebElement addProducts;
    private WebElement billingAdressCustomerAdresses;
    private WebElement billingAdressFirstName;
    private WebElement billingAdressLastName;
    private WebElement billingAdressStreetAddress;
    private WebElement billingAdressCity;
    private WebElement billingAdressCountry;
    private WebElement billingAdressStateElement;
    private WebElement billingAdressStateSelect;
    private WebElement billingAdressPostalCode;
    private WebElement billingAdressPhoneNumber;
    private WebElement shippingMethod;
    private WebElement shippingAdressCustomerAdresses;
    private WebElement shippingAdressFirstName;
    private WebElement shippingAdressLastName;
    private WebElement shippingAdressStreetAddress;
    private WebElement shippingAdressCity;
    private WebElement shippingAdressCountry;
    private WebElement shippingAdressStateElement;
    private WebElement shippingAdressStateSelect;
    private WebElement shippingAdressPostalCode;
    private WebElement shippingAdressPhoneNumber;

    //Components
    private ProductsComponent productsComponent;
    private ItemsOrderedComponent itemsOrderedComponent;
    private ShippingMethodComponent shippingMethodComponent;

    public CreateOrderFillInformationPage() {
        cancel = Search.cssSelector("#reset_order_top_button");
        submitOrder = Search.cssSelector("#submit_order_top_button");
        addProducts = Search.cssSelector("[class='action-secondary action-add']");
        billingAdressCustomerAdresses = Search.cssSelector("#order-billing_address_customer_address_id");
        billingAdressFirstName = Search.cssSelector("#order-billing_address_firstname");
        billingAdressLastName = Search.cssSelector("#order-billing_address_lastname");
        billingAdressStreetAddress = Search.cssSelector("#order-billing_address_street0");
        billingAdressCity = Search.cssSelector("#order-billing_address_city");
        billingAdressCountry = Search.cssSelector("#order-billing_address_country_id");
        billingAdressStateElement = Search.cssSelector("#order-billing_address_region");
        billingAdressStateSelect = Search.cssSelector("#order-billing_address_region_id");
        billingAdressPostalCode = Search.cssSelector("#order-billing_address_postcode");
        billingAdressPhoneNumber = Search.cssSelector("#order-billing_address_telephone");
        shippingAdressCustomerAdresses = Search.cssSelector("#order-shipping_address_customer_address_id");
        shippingAdressFirstName = Search.cssSelector("#order-shipping_address_firstname");
        shippingAdressLastName = Search.cssSelector("#order-shipping_address_lastname");
        shippingAdressStreetAddress = Search.cssSelector("#order-shipping_address_street0");
        shippingAdressCity = Search.cssSelector("#order-shipping_address_city");
        shippingAdressCountry = Search.cssSelector("#order-shipping_address_country_id");
        shippingAdressStateElement = Search.cssSelector("#order-shipping_address_region");
        shippingAdressStateSelect = Search.cssSelector("#order-shipping_address_region_id");
        shippingAdressPostalCode = Search.cssSelector("#order-shipping_address_postcode");
        shippingAdressPhoneNumber = Search.cssSelector("#order-shipping_address_telephone");
        if (Search.checkDOMForText("Get shipping methods and rates")) {
            shippingMethod = Search.linkText("Get shipping methods and rates");
        }
        shippingAdressCustomerAdresses = Search.cssSelector("#order-shipping_address_customer_address_id");
    }

    // Page Object
    //  Data PageObject

    public WebElement getFixedRate() {
        return shippingMethodComponent.fixedRate;
    }

//    public WebElement getTableRate() {
//        return shippingMethodComponent.tableRate;
//    }

    public WebElement getUpdateItems() {
        return itemsOrderedComponent.updateItems;
    }

    public WebElement getTableOfProducts() {
        return itemsOrderedComponent.tableOfProducts;
    }

    public WebElement getSearchedProductName() {
        return productsComponent.searchedProductName;
    }

    public WebElement getSearchByProductName() {
        return productsComponent.searchByProductName;
    }

    public WebElement getSearchById() {
        return productsComponent.searchById;
    }

    public WebElement getSearchButton() {
        return productsComponent.searchButton;
    }

    public WebElement getAddProductsToOrder() {
        return productsComponent.addProductsToOrder;
    }

    public WebElement getCancel() {
        return cancel;
    }

    public WebElement getSubmitOrder() {
        return submitOrder;
    }

    public WebElement getAddProducts() {
        return addProducts;
    }

    public WebElement getBillingAdressCustomerAdresses() {
        return billingAdressCustomerAdresses;
    }

    public WebElement getBillingAdressFirstName() {
        return billingAdressFirstName;
    }

    public WebElement getBillingAdressLastName() {
        return billingAdressLastName;
    }

    public WebElement getBillingAdressStreetAddress() {
        return billingAdressStreetAddress;
    }

    public WebElement getBillingAdressCity() {
        return billingAdressCity;
    }

    public WebElement getBillingAdressCountry() {
        return billingAdressCountry;
    }

    public WebElement getBillingAdressStateElement() {
        return billingAdressStateElement;
    }

    public WebElement getBillingAdressStateSelect() {
        return billingAdressStateSelect;
    }

    public WebElement getBillingAdressPostalCode() {
        return billingAdressPostalCode;
    }

    public WebElement getBillingAdressPhoneNumber() {
        return billingAdressPhoneNumber;
    }

    public WebElement getShippingMethod() {
        return shippingMethod;
    }

    public WebElement getShippingAdressCustomerAdresses() {
        return shippingAdressCustomerAdresses;
    }

    public WebElement getShippingAdressFirstName() {
        return shippingAdressFirstName;
    }

    public WebElement getShippingAdressLastName() {
        return shippingAdressLastName;
    }

    public WebElement getShippingAdressStreetAddress() {
        return shippingAdressStreetAddress;
    }

    public WebElement getShippingAdressCity() {
        return shippingAdressCity;
    }

    public WebElement getShippingAdressCountry() {
        return shippingAdressCountry;
    }

    public WebElement getShippingAdressStateElement() {
        return shippingAdressStateElement;
    }

    public WebElement getShippingAdressStateSelect() {
        return shippingAdressStateSelect;
    }

    public WebElement getShippingAdressPostalCode() {
        return shippingAdressPostalCode;
    }

    public WebElement getShippingAdressPhoneNumber() {
        return shippingAdressPhoneNumber;
    }

    // set Data PageObject

    public void clickFixedRate() {
        Search.moveToElement(getFixedRate());
        getFixedRate().click();
        Search.stalenessOf(getFixedRate());
        new CreateOrderFillInformationPage();
    }

//    public void clickTableRate() {
//        Search.moveToElement(getTableRate());
//        getTableRate().click();
//        Search.stalenessOf(getTableRate());
//        new CreateOrderFillInformationPage();
//    }

    public void clickUpdateItems() {
        Search.moveToElement(getUpdateItems());
        getUpdateItems().click();
    }

    public void clickTableOfProducts() {
        Search.moveToElement(getTableOfProducts());
        getTableOfProducts().click();
    }

    public void clickSearchedProductName() {
        if (Search.stalenessOf(getSearchedProductName())) {
            productsComponent.searchedProductName = Search.cssSelector("#sales_order_create_search_grid_table > tbody > tr > td.col-name");
        }
        Search.moveToElement(getSearchedProductName());
        getSearchedProductName().click();
    }

    public void clickSearchByProductName() {
        Search.moveToElement(getSearchByProductName());
        getSearchByProductName().click();
    }

    public void clickSearchById() {
        Search.moveToElement(getSearchById());
        getSearchById().click();
    }

    public void clickSearchButton() {
        Search.moveToElement((getSearchButton()));
        getSearchButton().click();
    }

    public void clickAddProductsToOrder() {
        Search.moveToElement(getAddProductsToOrder());
        getAddProductsToOrder().click();
        itemsOrderedComponent = new ItemsOrderedComponent();
        new CreateOrderFillInformationPage();
    }

    public void clickCancel() {
        new CreateOrderFillInformationPage();
        Search.moveToElement(getCancel());
        getCancel().click();
    }

    public void clickSubmitOrder() {
        submitOrder = Search.cssSelector("[class='action-default scalable save primary']");
        Search.moveToElement(getSubmitOrder());
        getSubmitOrder().click();
    }

    public void clickAddProducts() {
        new CreateOrderFillInformationPage();
        addProducts = Search.cssSelector("[class='action-secondary action-add']");
        Search.moveToElement(getAddProducts());
        getAddProducts().click();
        this.productsComponent = new ProductsComponent();
    }

    public void clickBillingAdressCustomerAdresses() {
        Search.moveToElement(getBillingAdressCustomerAdresses());
        getBillingAdressCustomerAdresses().click();
    }

    public void clickBillingAdressFirstName() {
        Search.moveToElement(getBillingAdressFirstName());
        getBillingAdressFirstName().click();
    }

    public void clickBillingAdressLastName() {
        Search.moveToElement(getBillingAdressLastName());
        getBillingAdressLastName().click();
    }

    public void clickBillingAdressStreetAddress() {
        Search.moveToElement(getBillingAdressStreetAddress());
        getBillingAdressStreetAddress().click();
    }

    public void clickBillingAdressCity() {
        Search.moveToElement(getBillingAdressCity());
        getBillingAdressCity().click();
    }

    public void clickBillingAdressCountry() {
        Search.moveToElement(getBillingAdressCountry());
        getBillingAdressCountry().click();
    }

    public void clickBillingAdressStateElement() {
        Search.moveToElement(getBillingAdressStateElement());
        getBillingAdressStateElement().click();
    }

    public void clickBillingAdressStateSelect() {
        Search.moveToElement(getBillingAdressStateSelect());
        getBillingAdressStateSelect().click();
    }

    public void clickBillingAdressPostalCode() {
        Search.moveToElement(getBillingAdressPostalCode());
        getBillingAdressPostalCode().click();
    }

    public void clickBillingAdressPhoneNumber() {
        Search.moveToElement(getBillingAdressPhoneNumber());
        getBillingAdressPhoneNumber().click();
    }

    public void clickShippingMethod() {
        new CreateOrderFillInformationPage();
        shippingMethod = Search.linkText("Get shipping methods and rates");
        Search.moveToElement(getShippingMethod());
        getShippingMethod().click();
        if (Search.checkDOMForText("Get shipping methods and rates")) {
            Search.stalenessOf(getShippingMethod());
            new CreateOrderFillInformationPage();
            shippingMethod = Search.linkText("Get shipping methods and rates");
            getShippingMethod().click();
        }
        shippingMethodComponent = new ShippingMethodComponent();
    }

    public void clickShippingAdressCustomerAdresses() {
        Search.moveToElement(getShippingAdressCustomerAdresses());
        getShippingAdressCustomerAdresses().click();
    }

    public void clickShippingAdressFirstName() {
        Search.moveToElement(getShippingAdressFirstName());
        getShippingAdressFirstName().click();
    }

    public void clickShippingAdressLastName() {
        Search.moveToElement(getShippingAdressLastName());
        getShippingAdressLastName().click();
    }

    public void clickShippingAdressStreetAddress() {
        Search.moveToElement(getShippingAdressStreetAddress());
        getShippingAdressStreetAddress().click();
    }

    public void clickShippingAdressCity() {
        Search.moveToElement(getShippingAdressCity());
        getShippingAdressCity().click();
    }

    public void clickShippingAdressCountry() {
        Search.moveToElement(getShippingAdressCountry());
        getShippingAdressCountry().click();
    }

    public void clickShippingAdressStateElement() {
        Search.moveToElement(getShippingAdressStateElement());
        getShippingAdressStateElement().click();
    }

    public void clickShippingAdressStateSelect() {
        Search.moveToElement(getShippingAdressStateSelect());
        getShippingAdressStateSelect().click();
    }

    public void clickShippingAdressPostalCode() {
        Search.moveToElement(getShippingAdressPostalCode());
        getShippingAdressPostalCode().click();
    }

    public void clickShippingAdressPhoneNumber() {
        Search.moveToElement(getShippingAdressPhoneNumber());
        getShippingAdressPhoneNumber().click();
    }
    //  Set data Business Logic

    public void typeSearchForProductByName(String name) {
        clickSearchByProductName();
        getSearchByProductName().clear();
        getSearchByProductName().sendKeys(name);
    }


    public void typeBillingAdressFirstName(String name) {
        new CreateOrderFillInformationPage();
        new CreateOrderFillInformationPage();
        clickBillingAdressFirstName();
        new CreateOrderFillInformationPage();
        getBillingAdressFirstName().clear();
        getBillingAdressFirstName().sendKeys(name);
    }

    public void typeBillingAdressLastName(String name) {
        new CreateOrderFillInformationPage();
        new CreateOrderFillInformationPage();
        clickBillingAdressLastName();
        new CreateOrderFillInformationPage();
        getBillingAdressLastName().clear();
        getBillingAdressLastName().sendKeys(name);
    }

    public void typeBillingAdressStreetAddress(String name) {
        new CreateOrderFillInformationPage();
        new CreateOrderFillInformationPage();
        clickBillingAdressStreetAddress();
        new CreateOrderFillInformationPage();
        getBillingAdressStreetAddress().clear();
        getBillingAdressStreetAddress().sendKeys(name);
    }

    public void typeBillingAdressCity(String name) {
        new CreateOrderFillInformationPage();
        new CreateOrderFillInformationPage();
        clickBillingAdressCity();
        new CreateOrderFillInformationPage();
        getBillingAdressCity().clear();
        getBillingAdressCity().sendKeys(name);
    }

    public void typeBillingAdressCountry(String name) {
        new CreateOrderFillInformationPage();
        new CreateOrderFillInformationPage();
        clickBillingAdressCountry();
        new CreateOrderFillInformationPage();
        billingAdressCountry.findElement(By.xpath("//select[@id='order-billing_address_country_id']/option[text()='"+name+"']")).click();
        new CreateOrderFillInformationPage();
    }

    public void typeBillingAdressState(String name) {
        new CreateOrderFillInformationPage();
        new CreateOrderFillInformationPage();
        clickBillingAdressStateElement();
        new CreateOrderFillInformationPage();
        getBillingAdressStateElement().clear();
        getBillingAdressStateElement().sendKeys(name);
    }

    public void typeBillingAdressPostalCode(String name) {
        new CreateOrderFillInformationPage();
        new CreateOrderFillInformationPage();
        clickBillingAdressPostalCode();
        new CreateOrderFillInformationPage();
        getBillingAdressPostalCode().clear();
        getBillingAdressPostalCode().sendKeys(name);
    }

    public void typeBillingAdressPhoneNumber(String name) {
        new CreateOrderFillInformationPage();
        new CreateOrderFillInformationPage();
        clickBillingAdressPhoneNumber();
        new CreateOrderFillInformationPage();
        getBillingAdressPhoneNumber().clear();
        getBillingAdressPhoneNumber().sendKeys(name);
    }
    //  Business Logic

    public void addProducts(List<IProduct> productList) {
        clickAddProducts();
        for (IProduct product : productList) {
            typeSearchForProductByName(product.getProductName());
            clickSearchButton();
            if (!Search.checkDOMForText(DATA_NOT_FOUND_MESSAGE)) {
                productsComponent.searchedProductName = Search.cssSelector("#sales_order_create_search_grid_table > tbody > tr > td.col-name");
                clickSearchedProductName();
            }
        }
    }

    public void fillUserRequiredInformation(ICustomerUser customerUser) {
        typeBillingAdressFirstName(customerUser.getPersonalInfo().getFirstname());
        typeBillingAdressLastName(customerUser.getPersonalInfo().getLastname());
        typeBillingAdressStreetAddress(customerUser.getContactInfo().getStreetAddress());
        typeBillingAdressCity(customerUser.getContactInfo().getCity());
        typeBillingAdressCountry(customerUser.getContactInfo().getCountry());
        typeBillingAdressState(customerUser.getContactInfo().getState());
        typeBillingAdressPostalCode(customerUser.getContactInfo().getPostalCode());
        typeBillingAdressPhoneNumber(customerUser.getContactInfo().getPhoneNumber());
    }
}
