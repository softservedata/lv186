package com.softserve.edu.magento.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.magento.edu.customer.pages.HomePageLogout;
import com.softserve.edu.magento.data.AdminUserRepository;
import com.softserve.edu.magento.data.ApplicationSources;
import com.softserve.edu.magento.data.ApplicationSourcesRepository;
import com.softserve.edu.magento.data.IAdminUser;
import com.softserve.edu.magento.pages.AdminLoginPage;
import com.softserve.edu.magento.pages.ApplicationAdmin;
import com.softserve.edu.magento.pages.ApplicationCustomer;
import com.softserve.edu.magento.pages.menu.customers.AllCustomersPage;
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

    @DataProvider(parallel = true)
    public Object[][] smokeParameters(ITestContext context) {
        return new Object[][] {
            { ParameterUtils.get().updateParametersAll(
                    ApplicationSourcesRepository.getFirefoxLocalhostAdmin(), context),
                AdminUserRepository.get().adminBohdan() },
            { ParameterUtils.get().updateParametersAll(
                    ApplicationSourcesRepository.getChromeLocalhostAdmin(), context),
                AdminUserRepository.get().adminBohdan() }
                };
//        return ListUtils.get().toMultiArray(
//                ParameterUtils.get().updateParametersAll(
//                        ApplicationSourcesRepository.getChromeLocalhostAdmin(), context),
//                AdminUserRepository.get().adminBohdan());
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
        Assert.assertEquals(dashboardPage.getLifeTimeSalesValueText(), "$900.00");
        //
        // Test Steps
        CatalogPage catalogPage = dashboardPage.gotoCatalogPage();
        Thread.sleep(1000);
        // Check
        Assert.assertEquals(catalogPage.getPageTitleText(), CatalogPage.PAGE_TITLE);
        Assert.assertEquals(catalogPage.getFirstProductNameText(), "Gigabyte"); // Read name from ProductRepository
        // Return to Previous State
        //System.out.println("Logout URL1 = " + ApplicationAdmin.getCurrentApplicationSources().getLogoutUrl());
        catalogPage.logout();
        //applicationAdmin.logout();
        //System.out.println("Logout URL2 = " + ApplicationAdmin.getCurrentApplicationSources().getLogoutUrl());
        Thread.sleep(2000);
        ApplicationCustomer applicationCustomer = ApplicationCustomer.get(ApplicationSourcesRepository.getFirefoxLocalhostCustomer());
        HomePageLogout homePageLogout = applicationCustomer.load();
        Thread.sleep(2000);
        //applicationAdmin.quit();
    }
    
    //@Test(dataProvider = "smokeParameters")
	public void goToCustomerPage(ApplicationSources applicationSources, IAdminUser adminUser) throws Exception {
		// Precondition
		ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
		Thread.sleep(1000);
		DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
		Thread.sleep(1000);
		AllCustomersPage acp = dashboardPage.gotoAllCustomersPage();
		dashboardPage.clickMenuCustomers();
		dashboardPage.clickMenuCustomersAllCustomers();
		
		Thread.sleep(1000);
		//Assert.assertEquals(acp.getPageTitle(), acp.PAGE_TITLE);
		//Assert.assertEquals(rncp.getPageTitleText(), rncp.PAGE_TITLE);

		Thread.sleep(1000);
		Thread.sleep(2000);
		applicationAdmin.quit();
	}

    @AfterMethod
    public void afterMethod() {
        ApplicationAdmin.signout();
        //ApplicationAdmin.quitAll();
    }

    @AfterClass
    void tearDown() throws Exception {
        ApplicationAdmin.quitAll();
    }

}