package com.softserve.edu.magento.data.customer.user;

import com.softserve.edu.magento.tools.Search;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by ayaremctc on 09.09.2016.
 */
public class CustomerAddressesInfo implements IAdresses {
    private WebElement addNewAddresses;
    private WebElement address;
    private WebElement deleteButton;
    private WebElement defaultBillingCHK;
    private WebElement defaultShippingCHK;
    private WebElement prefix;
    private WebElement firstname;
    private WebElement middlename;
    private WebElement lastname;
    private WebElement suffix;
    private WebElement company;
    private WebElement streetAdressFirst;
    private WebElement streetAdressSecond;
    private WebElement city;
    private Select country;
    private Select state;
    private WebElement zip;
    private WebElement phone;
    private WebElement vat;

    /**
     * Constructor.
     */
    public CustomerAddressesInfo() {
        this.addNewAddresses = Search
                .xpath("//span[contains(text(),'Add New Addresses')]/parent::button");
			/*
			 * Initialization depends on customer information.
			 */
        if (!Search.cssSelectors("address").get(0).isDisplayed()) {
            addNewAddresses.click();
        }
        this.address = Search.cssSelector("address");
        this.deleteButton = Search
                .cssSelector(".action-delete");
        this.defaultBillingCHK = Search
                .xpath("//input[@class='admin__control-checkbox']/following::label[contains(text(), 'Default Billing Address')]");
        this.defaultShippingCHK = Search
                .xpath("//input[@class='admin__control-checkbox']/following::label[contains(text(), 'Default Shipping Address')]");
        this.prefix = Search
                .xpath("//span[contains(text(), 'Prefix')]/parent::label/following-sibling::div/input[1]");
        this.firstname = Search
                .xpath("//span[contains(text(), 'First Name')]/parent::label/following-sibling::div/input[1]");
        this.middlename = Search
                .xpath("//span[contains(text(), 'Initial')]/parent::label/following-sibling::div/input[1]");
        this.lastname = Search
                .xpath("//span[contains(text(), 'Last Name')]/parent::label/following-sibling::div/input[1]");
        this.suffix = Search
                .xpath("//span[contains(text(), 'Suffix')]/parent::label/following-sibling::div/input[1]");
        this.company = Search
                .xpath("//span[contains(text(), 'Company')]/parent::label/following-sibling::div/input");
        this.streetAdressFirst = Search
                .xpath("//span[contains(text(), 'Street Address')]/parent::legend/following-sibling::div/div/div/input");
        this.streetAdressSecond = Search
                .xpath("//span[contains(text(), 'Street Address')]/parent::legend/following-sibling::div/div/div/input[1]");
        this.city = Search
                .xpath("//span[contains(text(), 'City')]/parent::label/following-sibling::div/input");
        this.country = new Select(Search
                .xpath("//span[contains(text(), 'Country')]/parent::label/following-sibling::div/select"));
        this.state = new Select(Search
                .xpath("//span[contains(text(), 'State')]/parent::label/following-sibling::div/select"));
        this.zip = Search
                .xpath("//span[contains(text(), 'Zip')]/parent::label/following-sibling::div/input");
        this.phone = Search
                .xpath("//span[contains(text(), 'Phone')]/parent::label/following-sibling::div/input");
        this.vat = Search
                .xpath("//span[contains(text(), 'VAT')]/parent::label/following-sibling::div/input");
    }

    public WebElement getAddNewAddresses() {
        return addNewAddresses;
    }

    public WebElement getAddress() {
        return address;
    }

    public WebElement getDeleteButton() {
        return deleteButton;
    }

    public WebElement getDefaultBillingCHK() {
        return defaultBillingCHK;
    }

    public WebElement getDefaultShippingCHK() {
        return defaultShippingCHK;
    }

    public WebElement getPrefix() {
        return prefix;
    }

    public WebElement getFirstname() {
        return firstname;
    }

    public WebElement getMiddlename() {
        return middlename;
    }

    public WebElement getLastname() {
        return lastname;
    }

    public WebElement getSuffix() {
        return suffix;
    }

    public WebElement getCompany() {
        return company;
    }

    public WebElement getStreetAdressFirst() {
        return streetAdressFirst;
    }

    public WebElement getStreetAdressSecond() {
        return streetAdressSecond;
    }

    public WebElement getCity() {
        return city;
    }

    public Select getCountry() {
        return country;
    }

    public Select getState() {
        return state;
    }

    public WebElement getZip() {
        return zip;
    }

    public WebElement getPhone() {
        return phone;
    }

    public WebElement getVat() {
        return vat;
    }

}
