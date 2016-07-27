package com.softserve.edu.magento.pages.admin;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import com.softserve.edu.magento.data.ApplicationSources;
import com.softserve.edu.magento.tools.Application;

public class ApplicationAdmin extends Application<AdminLoginPage> {
    private static final HashMap<Long, ApplicationAdmin> allApplicationSources = new HashMap<Long, ApplicationAdmin>();

    protected ApplicationAdmin(ApplicationSources applicationSources) {
        super(applicationSources);
    }

    public static ApplicationAdmin get(ApplicationSources applicationSources) {
        ApplicationAdmin instance = new ApplicationAdmin(applicationSources);
        allApplicationSources.put(Thread.currentThread().getId(), instance);
        return instance;
    }

    public static ApplicationSources getCurrentApplicationSources() {
        ApplicationSources result = null;
        if (allApplicationSources.get(Thread.currentThread().getId()) != null) {
            result = allApplicationSources.get(Thread.currentThread().getId()).getApplicationSources();
        }
        return result;
                
    }

    public static void signout() {
        if (allApplicationSources.get(Thread.currentThread().getId()) != null) {
            allApplicationSources.get(Thread.currentThread().getId()).logout();
            getCurrentApplicationSources().setLogoutUrl(new String());
        }
    }

    @Override
    protected AdminLoginPage getStartPage(WebDriver driver) {
        return new AdminLoginPage(driver);
    }

    @Override
    public AdminLoginPage logout() {
        AdminLoginPage result = super.logout();
        getApplicationSources().setLogoutUrl(new String());
        return result;
    }

}
