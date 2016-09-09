package com.softserve.edu.magento.data.customer.user;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by ayaremctc on 09.09.2016.
 */
public interface IAdresses {
    public WebElement getAddNewAddresses();
    public WebElement getAddress();
    public WebElement getDeleteButton();
    public WebElement getDefaultBillingCHK();
    public WebElement getDefaultShippingCHK();
    public WebElement getPrefix();
    public WebElement getFirstname();
    public WebElement getMiddlename();
    public WebElement getLastname();
    public WebElement getSuffix();
    public WebElement getCompany();
    public WebElement getStreetAdressFirst();
    public WebElement getStreetAdressSecond();
    public WebElement getCity();
    public Select getCountry();
    public Select getState();
    public WebElement getZip();
    public WebElement getPhone();
    public WebElement getVat();
}
