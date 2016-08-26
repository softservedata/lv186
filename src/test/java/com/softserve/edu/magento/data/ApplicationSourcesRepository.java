package com.softserve.edu.magento.data;

import java.util.ArrayList;
import java.util.List;

public final class ApplicationSourcesRepository {

    private ApplicationSourcesRepository() {
    }

    public static ApplicationSources getFirefoxLocalhostAdmin() {
        return new ApplicationSources("FirefoxDriverTemporary", new String(), 5L, 5L, "Implicit", // "Explicit",
                "http://192.168.195.210/magento/admin", new String());
    }

    public static ApplicationSources getChromeLocalhostAdmin() {
        return new ApplicationSources("ChromeDriverTemporary",
                "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe", 5L, 5L, "Implicit",
                "http://192.168.195.210/magento/admin",
                new String());
    }
    public static ApplicationSources getChromeLocalhostMacAdmin() {
        return new ApplicationSources("ChromeDriverTemporary",
                "/Applications/Google Chrome.app/Contents/chromedriver", 30L, 30L, "Implicit",
                "http://192.168.195.210/magento/admin",
                new String());
    }
    public static ApplicationSources getChromeLocalhostAdminLinux() {
        return new ApplicationSources("ChromeDriverTemporary",
                "/home/bohdan/Downloads/chromedriver", 5L, 5L, "Implicit",
                "http://192.168.195.210/magento/admin",
                new String());
    }
//    public static ApplicationSources getIELocalhostAdmin() { }
//    public static ApplicationSources getHtmlUnitLocalhostAdmin() { }

    public static ApplicationSources getPhantomJSLocalhostWindowsAdmin() {
        return new ApplicationSources("PhantomJSTemporary",
                "C:\\Program Files (x86)\\PhantomJS\\phantomjs.exe", 5L, 5L, "Implicit",
                "http://192.168.195.210/magento/admin",
                new String());
    }

    public static List<ApplicationSources> getListBrowsersLocalhostAdmin() {
        List<ApplicationSources> result = new ArrayList<ApplicationSources>();
        result.add(getFirefoxLocalhostAdmin());
        result.add(getChromeLocalhostAdmin());
        return result; 
    }

    public static ApplicationSources getFirefoxLocalhostCustomer() {
        return new ApplicationSources("FirefoxDriverTemporary", new String(), 5L, 5L, "Implicit",
                "http://192.168.195.210/magento",
                "http://192.168.195.210/magento/customer/account/logout/");
    }

    public static ApplicationSources getChromeLocalhostCustomer() {
        return new ApplicationSources("ChromeDriverTemporary",
        		"/Applications/Google Chrome.app/Contents/chromedriver", 5L, 5L, "Implicit",
                "http://192.168.195.210/magento",
                "http://192.168.195.210/magento/customer/account/logout/");
    }
    public static ApplicationSources getChromeJSDisableLocalhostCustomer() {
        return new ApplicationSources("ChromeDriverJSDisable",
                "/Applications/Google Chrome.app/Contents/chromedriver", 5L, 5L, "Implicit",
                "http://192.168.195.210/magento",
                "http://192.168.195.210/magento/customer/account/logout/");
    }


    public static ApplicationSources getChromeLocalhostCustomerLinux() {
        return new ApplicationSources("ChromeDriverTemporary",
                "/home/bohdan/Downloads/chromedriver", 5L, 5L, "Implicit",
                "http://192.168.195.210/magento",
                "http://192.168.195.210/magento/customer/account/logout/");
    }

    public static ApplicationSources getChromeYuliaHostAdmin() {
        return new ApplicationSources("ChromeDriverTemporary",
                "C:\\Program Files (x86)\\Google\\Chrome\\chromedriver.exe", 5L, 5L, "Explicit",
                "http://127.0.0.1/Magento/admin/",
                new String());
    }

    public static ApplicationSources getChromeRemoteAdmin() {
        return new ApplicationSources("ChromeDriverTemporary",
                "C:\\Users\\ynevitc\\Downloads\\chromedriver.exe", 5L, 5L, "Implicit",
                "http://192.168.195.210/magento/admin",
                new String());
    }

    public static List<ApplicationSources> getListBrowsersLocalhostCustomer() {
        List<ApplicationSources> result = new ArrayList<ApplicationSources>();
        result.add(getFirefoxLocalhostCustomer());
        return result; 
    }
    public static ApplicationSources getChromeMyHostAdminLinux() {
        return new ApplicationSources("ChromeDriverTemporary",
                "home/bohdan/Downloads/chromedriver", 5L, 5L, "Implicit",
                "http://localhost/magento2/admin",
                new String());
    }

    public static ApplicationSources getChromeMyHostCustomerLinux() {
        return new ApplicationSources("ChromeDriverTemporary",
                "/home/bohdan/Downloads/chromedriver", 5L, 5L, "Implicit",
                "http://localhost/magento2",
                "http://localhost/magento2/customer/account/logout/");
    }

    public static ApplicationSources getChromeHomeHostAdmin() {
        return new ApplicationSources("ChromeDriverTemporary",
                "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe", 10L, 5L, "Implicit",
                "http://127.0.0.1/Magento/admin",
                new String());
    }
}
