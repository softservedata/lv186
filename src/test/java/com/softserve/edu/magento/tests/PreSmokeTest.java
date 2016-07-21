package com.softserve.edu.magento.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.magento.data.AdminUserRepository;
import com.softserve.edu.magento.data.ApplicationSources;
import com.softserve.edu.magento.data.ApplicationSourcesRepository;
import com.softserve.edu.magento.data.IAdminUser;
import com.softserve.edu.magento.pages.AdminLoginPage;
import com.softserve.edu.magento.pages.ApplicationAdmin;
import com.softserve.edu.magento.pages.menu.dashboard.DashboardPage;
import com.softserve.edu.magento.pages.menu.products.CatalogPage;
import com.softserve.edu.magento.tools.ListUtils;
import com.softserve.edu.magento.tools.ParameterUtils;

public class PreSmokeTest {
    
    //@Test//(dataProvider = "driverParameters")
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

    @DataProvider //(parallel = true)
    public Object[][] smokeParameters(ITestContext context) {
        return ListUtils.get().toMultiArray(
                ParameterUtils.get().updateParametersAll(
                        ApplicationSourcesRepository.getChromeLocalhostAdmin(), context),
                AdminUserRepository.get().adminBohdan());
    }

    @Test(dataProvider = "smokeParameters")
    public void checkAdminLogon2(ApplicationSources applicationSources, IAdminUser adminUser) throws Exception {
        // Precondition
        ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
        Thread.sleep(1000);
        //
        // Test Steps
        //AdminLoginPage adminLoginPage = applicationAdmin.load();
        //DashboardPage dashboardPage = adminLoginPage.successAdminLogin(AdminUserRepository.get().adminBohdan());
        DashboardPage dashboardPage = applicationAdmin.load()
                .successAdminLogin(adminUser);
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
        applicationAdmin.quit();
    }

    @AfterClass
    void tearDown() throws Exception {
        ApplicationAdmin.quitAll();
    }

}
