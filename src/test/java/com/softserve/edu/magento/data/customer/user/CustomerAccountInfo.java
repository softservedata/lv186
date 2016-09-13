package com.softserve.edu.magento.data.customer.user;

import com.softserve.edu.magento.tools.Search;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by ayaremctc on 09.09.2016.
 */
public class CustomerAccountInfo implements IAccountInformation {
    private Select associateToWebsite;
    private Select group;
    private WebElement chekboxForGroup;
    private WebElement prefix;
    private WebElement firstname;
    private WebElement middlename;
    private WebElement lastname;
    private WebElement suffix;
    private WebElement email;
    private WebElement dateOfBirth;
    private WebElement tax;
    private Select gender;
    private Select sendWelcomeEmailFrom;

    /**
     * Constructor.
     */
    public CustomerAccountInfo() {
        this.associateToWebsite = new Select(Search
                .cssSelector("select[name='customer[website_id]']"));
        this.group = new Select(Search
                .cssSelector("select[name='customer[group_id]']"));
        this.chekboxForGroup = Search
                .cssSelector("input[name='customer[disable_auto_group_change]'");
        this.prefix =Search
                .cssSelector("input[name='customer[prefix]']");
        this.firstname = Search
                .cssSelector("input[name='customer[firstname]']");
        this.middlename = Search
                .cssSelector("input[name='customer[middlename]']");
        this.lastname = Search
                .cssSelector("input[name='customer[lastname]']");
        this.suffix = Search
                .cssSelector("input[name='customer[suffix]']");
        this.email = Search
                .cssSelector("input[name='customer[email]']");
        this.dateOfBirth = Search
                .cssSelector("input[name='customer[dob]']");
        this.tax = Search
                .cssSelector("input[name='customer[taxvat]']");
        this.gender = new Select(Search
                .cssSelector("select[name='customer[gender]']"));
        this.sendWelcomeEmailFrom = new Select(
                Search
                        .cssSelector("select[name='customer[sendemail_store_id]']"));
    }

    public Select getAssociateToWebsite() {
        return associateToWebsite;
    }

    public Select getGroup() {
        return group;
    }

    public WebElement getChekboxForGroup() {
        return chekboxForGroup;
    }

    public WebElement getLastname() {
        return lastname;
    }

    public WebElement getSelectedWebsite() {
        return this.associateToWebsite.getFirstSelectedOption();
    }

    public WebElement getSelectGroup() {
        return this.group.getFirstSelectedOption();
    }

    public WebElement getPrefix() {
        return this.prefix;
    }

    public WebElement getFirstname() {
        return this.firstname;
    }

    public WebElement getMiddlename() {
        return this.middlename;
    }

    public WebElement geLastname() {
        return this.lastname;
    }

    public WebElement getSuffix() {
        return this.suffix;
    }

    public WebElement getEmail() {
        return this.email;
    }

    public WebElement getDateOfBirth() {
        return this.dateOfBirth;
    }

    public Select getGender() {
        return this.gender;
    }

    public Select getSendWelcomeEmailFrom() {
        return this.sendWelcomeEmailFrom;
    }

    public WebElement getTax() {
        return this.tax;
    }

}
