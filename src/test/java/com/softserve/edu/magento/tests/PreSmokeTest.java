package com.softserve.edu.magento.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.softserve.edu.magento.data.AdminUserRepository;
import com.softserve.edu.magento.pages.AdminLoginPage;
import com.softserve.edu.magento.pages.CatalogPage;
import com.softserve.edu.magento.pages.DashboardPage;

public class PreSmokeTest {
    
//    @DataProvider//(parallel = true)
//    public Object[][] driverParameters(ITestContext context) {
//        return ListUtils.get().toMultiArray(BrowserManager.get().prepareBrowser(context));
//        return new Object[][] {
//            { BrowsersList.HTMLUNIT_TEMPORARY },
//            //{ BrowsersList.FIREFOX_TEMPORARY },
//            //{ BrowsersList.CHROME_TEMPORARY }
//            };
//    }

    @Test//(dataProvider = "driverParameters")
    public void checkAdminLogon1() throws Exception { //(BrowsersList browser)
        // Precondition
        //WebDriver driver = browser.getWebDriver();
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://192.168.195.210/magento/admin");
        Thread.sleep(1000);
        //
        // Test Steps
        //AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
        //DashboardPage dashboardPage = adminLoginPage.successAdminLogin(AdminUserRepository.get().adminBohdan());
        DashboardPage dashboardPage = new AdminLoginPage(driver)
                .successAdminLogin(AdminUserRepository.get().adminBohdan());
        Thread.sleep(1000);
        // Check
        Assert.assertEquals(dashboardPage.getPageTitleText(), DashboardPage.PAGE_TITLE);
        Assert.assertEquals(dashboardPage.getLifeTimeSalesValueText(), "$0.00");
        //
        // Test Steps
        CatalogPage catalogPage = dashboardPage.gotoCatalogPage();
        Thread.sleep(1000);
        // Check
        Assert.assertEquals(catalogPage.getPageTitleText(), CatalogPage.PAGE_TITLE);
        Assert.assertEquals(catalogPage.getFirstProductNameText(), "Gigabyte"); // Read name from ProductRepository
        // Return to Previous State
        catalogPage.logout();
        Thread.sleep(2000);
        driver.quit();
    }

}
