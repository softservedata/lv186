package com.softserve.edu.magento.pages;

import org.openqa.selenium.WebDriver;

import com.magento.edu.customer.pages.HomePageLogout;
import com.softserve.edu.magento.data.ApplicationSources;
import com.softserve.edu.magento.tools.Application;

public class ApplicationCustomer extends Application<HomePageLogout> {

    protected ApplicationCustomer(ApplicationSources applicationSources) {
        super(applicationSources);
    }

    public static ApplicationCustomer get(ApplicationSources applicationSources) {
        ApplicationCustomer instance = new ApplicationCustomer(applicationSources);
        return instance;
    }

    @Override
    protected HomePageLogout getStartPage(WebDriver driver) {
        return new HomePageLogout(driver);
    }

}
