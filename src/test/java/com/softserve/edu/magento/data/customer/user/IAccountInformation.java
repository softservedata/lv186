package com.softserve.edu.magento.data.customer.user;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by ayaremctc on 09.09.2016.
 */
public interface IAccountInformation {
    public Select getAssociateToWebsite();
    public Select getGroup();
    public WebElement getChekboxForGroup();
    public WebElement getLastname();
    public WebElement getSelectedWebsite();
    public WebElement getSelectGroup();
    public WebElement getPrefix();
    public WebElement getFirstname();
    public WebElement getMiddlename();
    public WebElement geLastname();
    public WebElement getSuffix();
    public WebElement getEmail();
    public WebElement getDateOfBirth();
    public Select getGender();
    public Select getSendWelcomeEmailFrom();
    public WebElement getTax();
}
