package com.softserve.edu.magento.pages;

import org.openqa.selenium.WebDriver;

import com.softserve.edu.magento.data.ApplicationSources;
import com.softserve.edu.magento.tools.Application;

public class ApplicationCustomer extends Application<AdminLoginPage> {

    protected ApplicationCustomer(ApplicationSources applicationSources) {
        super(applicationSources);
    }

    public static ApplicationCustomer get(ApplicationSources applicationSources) {
        ApplicationCustomer instance = new ApplicationCustomer(applicationSources);
        return instance;
    }

    // TODO
    protected AdminLoginPage getStartPage(WebDriver driver) {
        return new AdminLoginPage(driver);
    }

}
