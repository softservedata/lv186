package com.softserve.edu.magento.data;

import java.util.ArrayList;
import java.util.List;

public final class ApplicationSourcesRepository {

    private ApplicationSourcesRepository() {
    }

    public static ApplicationSources getFirefoxLocalhostAdmin() {
        return new ApplicationSources("FirefoxDriverTemporary", new String(), 5L,
                "http://192.168.195.210/magento/admin", new String());
    }

    public static ApplicationSources getChromeLocalhostAdmin() {
        return new ApplicationSources("ChromeDriverTemporary",
                "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe", 5L,
                "http://192.168.195.210/magento/admin",
                new String());
    }

//    public static ApplicationSources getIELocalhostAdmin() { }
//    public static ApplicationSources getHtmlUnitLocalhostAdmin() { }

    public static List<ApplicationSources> getListBrowsersLocalhostAdmin() {
        List<ApplicationSources> result = new ArrayList<ApplicationSources>();
        result.add(getFirefoxLocalhostAdmin());
        result.add(getChromeLocalhostAdmin());
        return result; 
    }

    public static ApplicationSources getFirefoxLocalhostCustomer() {
        return new ApplicationSources("FirefoxDriverTemporary", new String(), 5L,
                "http://192.168.195.210/magento",
                "http://192.168.195.210/magento/customer/account/logout/");
    }
    public static List<ApplicationSources> getListBrowsersLocalhostCustomer() {
        List<ApplicationSources> result = new ArrayList<ApplicationSources>();
        result.add(getFirefoxLocalhostCustomer());
        return result; 
    }

}