package com.softserve.edu.magento.pages;

import org.openqa.selenium.WebDriver;

import com.softserve.edu.magento.data.ApplicationSources;
import com.softserve.edu.magento.tools.Application;

public class ApplicationAdmin extends Application<AdminLoginPage> {

    protected ApplicationAdmin(ApplicationSources applicationSources) {
        super(applicationSources);
    }

    public static ApplicationAdmin get(ApplicationSources applicationSources) {
        ApplicationAdmin instance = new ApplicationAdmin(applicationSources);
        return instance;
    }

    protected AdminLoginPage getStartPage(WebDriver driver) {
        return new AdminLoginPage(driver);
    }

}
