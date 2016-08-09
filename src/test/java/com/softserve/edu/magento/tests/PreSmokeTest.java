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
import org.testng.asserts.SoftAssert;

import com.softserve.edu.magento.data.ApplicationSources;
import com.softserve.edu.magento.data.ApplicationSourcesRepository;
import com.softserve.edu.magento.data.admin.AdminUserRepository;
import com.softserve.edu.magento.data.admin.IAdminUser;
import com.softserve.edu.magento.data.admin.products.ProductRepository;
import com.softserve.edu.magento.data.customer.user.CustomerUserRepository;
import com.softserve.edu.magento.pages.admin.AdminLoginPage;
import com.softserve.edu.magento.pages.admin.AdminLoginSearchPage;
import com.softserve.edu.magento.pages.admin.ApplicationAdmin;
import com.softserve.edu.magento.pages.admin.menu.customers.AllCustomersPage;
import com.softserve.edu.magento.pages.admin.menu.customers.RegistrationNewCustomerPage;
import com.softserve.edu.magento.pages.admin.menu.dashboard.DashboardPage;
import com.softserve.edu.magento.pages.admin.menu.products.ProductCatalogPage;
import com.softserve.edu.magento.pages.customer.ApplicationCustomer;
import com.softserve.edu.magento.pages.customer.HomePageLogout;
import com.softserve.edu.magento.tools.ListUtils;
import com.softserve.edu.magento.tools.ParameterUtils;

public class PreSmokeTest {

	//@Test//(dataProvider = "driverParameters")
	public void checkAdminLogon1() throws Exception { // (BrowsersList browser)
	    System.out.println("Class PreSmokeTest, method checkAdminLogon1() test START");
		// Precondition
		// WebDriver driver = browser.getWebDriver();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://192.168.195.210/magento/admin");
		Thread.sleep(1000);
		System.out.println("Class PreSmokeTest, method checkAdminLogon1() driver START");
		//
		// Test Steps
		// AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
		// DashboardPage dashboardPage =
		// adminLoginPage.successAdminLogin(AdminUserRepository.get().adminBohdan());
		DashboardPage dashboardPage = new AdminLoginPage(driver)
				.successAdminLogin(AdminUserRepository.get().adminBohdan());
		Thread.sleep(1000);
		// Check
		Assert.assertEquals(dashboardPage.getPageTitleText(), DashboardPage.PAGE_TITLE);
		Assert.assertEquals(dashboardPage.getLifeTimeSalesValueText(), "$900.00");
		System.out.println("Class PreSmokeTest, method checkAdminLogon1() first assert DONE");
		//
		// Test Steps
		ProductCatalogPage catalogPage = dashboardPage.gotoProductCatalogPage();
		Thread.sleep(1000);
		// Check
		//Assert.assertEquals(catalogPage.getPageTitleText(), ProductCatalogPage.PAGE_TITLE);
//		Assert.assertEquals(catalogPage.getRowWithProductName(ProductRepository.VALID_PRODUCT_NAME), ProductRepository.VALID_PRODUCT_NAME); 
		//Assert.assertEquals(catalogPage.getFirstProductNameText(), "Gigabyte"); // Read
																				// name
																				// from
																				// ProductRepository
		// Return to Previous State
		//catalogPage.logout();
		Thread.sleep(2000);
		driver.quit();
	}

	@DataProvider//(parallel = true)
	public Object[][] smokeParameters(ITestContext context) {
		// return new Object[][] {
		// { ParameterUtils.get().updateParametersAll(
		// ApplicationSourcesRepository.getFirefoxLocalhostAdmin(), context),
		// AdminUserRepository.get().adminMykhaylo() },
		// { ParameterUtils.get().updateParametersAll(
		// ApplicationSourcesRepository.getChromeLocalhostAdmin(), context),
		// AdminUserRepository.get().adminMykhaylo() }
		// };
		return ListUtils.get()
				.toMultiArray(ParameterUtils.get()
						.updateParametersAll(ApplicationSourcesRepository.getFirefoxLocalhostAdmin(), context),
						AdminUserRepository.get().adminAndrii());
	}

	@Test(dataProvider = "smokeParameters")
	public void checkAdminLogon2(ApplicationSources applicationSources, IAdminUser adminUser) throws Exception {
        System.out.println("Class PreSmokeTest, method checkAdminLogon2(...) test START");
		// Precondition
	    SoftAssert softAssert = new SoftAssert(); 
		ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
		Thread.sleep(1000);
		System.out.println("Class PreSmokeTest, method checkAdminLogon2(...) driver START");
		//
		// Test Steps
		// AdminLoginPage adminLoginPage = applicationAdmin.load();
		// DashboardPage dashboardPage =
		// adminLoginPage.successAdminLogin(AdminUserRepository.get().adminBohdan());
		DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
		Thread.sleep(1000);
		System.out.println("Class PreSmokeTest, method checkAdminLogon2(...) successAdminLogin() DONE");
		// Check
		softAssert.assertEquals(dashboardPage.getPageTitleText(), DashboardPage.PAGE_TITLE);
		softAssert.assertEquals(dashboardPage.getLifeTimeSalesValueText(), "$900.00");
		System.out.println("Class PreSmokeTest, method checkAdminLogon2(...) first assert DONE");
		//
		// Test Steps
		//ProductCatalogPage catalogPage = dashboardPage.gotoProductCatalogPage();
		Thread.sleep(1000);
		System.out.println("Class PreSmokeTest, method checkAdminLogon2(...) gotoProductCatalogPage() DONE");
		// Check
		//Assert.assertEquals(catalogPage.getPageTitleText(), ProductCatalogPage.PAGE_TITLE);
		//softAssert.assertEquals(catalogPage.getRowWithProductName(ProductRepository.VALID_PRODUCT_NAME), ProductRepository.VALID_PRODUCT_NAME);																				// name
		//Assert.assertEquals(catalogPage.getFirstProductNameText(), "Gigabyte"); // Read
		
																				// name
																				// from
																				// ProductRepository
		// Return to Previous State
		// System.out.println("Logout URL1 = " +
		// ApplicationAdmin.getCurrentApplicationSources().getLogoutUrl());
		//catalogPage.logout();
		// applicationAdmin.logout();
		// System.out.println("Logout URL2 = " +
		// ApplicationAdmin.getCurrentApplicationSources().getLogoutUrl());
		Thread.sleep(2000);
		ApplicationCustomer applicationCustomer = ApplicationCustomer
				.get(ApplicationSourcesRepository.getFirefoxLocalhostCustomer());
		HomePageLogout homePageLogout = applicationCustomer.load();
		Thread.sleep(2000);
		System.out.println("Class PreSmokeTest, method checkAdminLogon2(...) gapplicationCustomer.load() DONE");
		// applicationAdmin.quit();
        //System.out.println("+++Test Done");
		System.out.println("Class PreSmokeTest, method checkAdminLogon2(...) test DONE");
		softAssert.assertAll();
	}

   //@Test(dataProvider = "smokeParameters")
   public void checkAdminLogon3(ApplicationSources applicationSources, IAdminUser adminUser) throws Exception {
        // Precondition
        SoftAssert softAssert = new SoftAssert(); 
        ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
        Thread.sleep(1000);
        //
        // Test Steps
        applicationAdmin.load();
        AdminLoginSearchPage adminLoginPage = new AdminLoginSearchPage();
        adminLoginPage.setLoginInput(adminUser.getUsername());
        adminLoginPage.setPasswordInput(adminUser.getPassword());
        Thread.sleep(3000);
    }

	//@Test(dataProvider = "smokeParameters")
	public void goToCustomerPage(ApplicationSources applicationSources, IAdminUser adminUser) throws Exception {
		// Precondition
		ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
		Thread.sleep(1000);
		DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
		Thread.sleep(1000);
		AllCustomersPage acp = dashboardPage.gotoAllCustomersPage();
		Thread.sleep(1000);
		Assert.assertEquals(acp.getCustomersLabelText(), acp.PAGE_TITLE);
		RegistrationNewCustomerPage regNewCust = acp.goToRegistrationNewCustomerPage();
		Assert.assertEquals(regNewCust.getFromNewCustomerLabelText(), regNewCust.PAGE_TITLE);
		regNewCust.setCustomerDataInLoginForm(CustomerUserRepository.get().NewCustomerRegistrationFromAdminSide());
		Thread.sleep(5000);
		applicationAdmin.quit();
	}
	
<<<<<<< HEAD
	//@Test(dataProvider = "smokeParameters") 
	public void goToEditCustomer(ApplicationSources applicationSources, IAdminUser adminUser) throws Exception {
		// Precondition
		ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);

		DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
		System.out.println("luck dashboard");
	
		EditCustomerPage ecp = dashboardPage.gotoAllCustomersPage().getEditCustomerPage();
		System.out.println("luck editcustomer");

		ecp.navToAccountInfo();
		Assert.assertTrue(ecp.compareFields(ecp.getCustomerAllData().get(8)));
		applicationAdmin.quit();
	}
=======
>>>>>>> branch 'development' of https://github.com/softservedata/lv186.git

	@AfterMethod
	public void afterMethod() {
		ApplicationAdmin.signout();
		// ApplicationAdmin.quitAll();
	}

	@AfterClass
	void tearDown() throws Exception {
		ApplicationAdmin.quitAll();
	}

}
