package com.softserve.edu.magento.pages.admin.menu.customers;

import com.softserve.edu.magento.pages.admin.VerticalMenu;
import com.softserve.edu.magento.tools.Search;
import org.openqa.selenium.WebElement;

/**
 * Created by Mickle on 8/23/2016.
 */
public class RegistrationNewCustomerErrorFieldsPage extends VerticalMenu{
    public final static String ERROR_MESSAGE_FIRSTNAME = "Please enter less or equal than 255 symbols.";
    public final static String ERROR_MESSAGE_LASTNAME = "Please enter less or equal than 255 symbols.";
    public final static String ERROR_MESSAGE_EMAIL = "Please enter a valid email address (Ex: johndoe@domain.com).";
    private WebElement firstnameErrorLabel;
    private WebElement lastnameErrorLabel;
    private WebElement emailErrorLabel;

    public RegistrationNewCustomerErrorFieldsPage(){
        this.firstnameErrorLabel= Search.xpath(".//*[@id='container']//fieldset/div[3]/div/label");
        this.lastnameErrorLabel= Search.xpath(".//*[@id='container']//fieldset/div[5]/div/label");
        this.emailErrorLabel= Search.xpath(".//*[@id='container']//fieldset/div[7]/div/label");
    }

    public String getFirstnameErrorLabelText(){
        System.out.println("++++++++++Label was found, assert works!!!!!");
        return firstnameErrorLabel.getText();

    }
    public String getLastnameErrorLabelText(){
        System.out.println("++++++++++Label was found, assert works!!!!!");
        return lastnameErrorLabel.getText();

    }
    public String getEmailErrorLabelText(){
        System.out.println("++++++++++Label was found, assert works!!!!!");
        return emailErrorLabel.getText();

    }
}
