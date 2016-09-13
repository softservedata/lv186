package com.softserve.edu.magento.pages.admin.menu.customers;

import com.softserve.edu.magento.pages.admin.VerticalMenu;
import com.softserve.edu.magento.tools.Search;
import org.openqa.selenium.WebElement;

/**
 * Created by Mickle on 8/19/2016.
 */
public class RegistrationNewCustomerErrorPage extends VerticalMenu{
    public final static String ERROR_MESSAGE_EMAIL_EXIST = "A customer with the same email already exists in an associated website.";
    private WebElement existEmailErrorLabel;
    public RegistrationNewCustomerErrorPage(){
        this.existEmailErrorLabel= Search.xpath(".//*[@id='messages']/div/div/div");
    }

    public String getExistEmailErrorTextLabel(){
        return existEmailErrorLabel.getText();

    }

}
