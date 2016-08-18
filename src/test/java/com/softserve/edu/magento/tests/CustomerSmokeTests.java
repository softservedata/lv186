package com.softserve.edu.magento.tests;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.magento.data.ApplicationSources;
import com.softserve.edu.magento.data.ApplicationSourcesRepository;
import com.softserve.edu.magento.data.admin.AdminUserRepository;
import com.softserve.edu.magento.data.admin.IAdminUser;
import com.softserve.edu.magento.data.customer.user.CustomerUserRepository;
import com.softserve.edu.magento.data.customer.user.CustomerUserRepositoryForAdmin;
import com.softserve.edu.magento.pages.admin.ApplicationAdmin;
import com.softserve.edu.magento.pages.admin.menu.customers.AllCustomersPage;
import com.softserve.edu.magento.pages.admin.menu.customers.AllCustomersPageAfterSuccesRegistration;
import com.softserve.edu.magento.pages.admin.menu.customers.RegistrationNewCustomerPage;
import com.softserve.edu.magento.pages.admin.menu.dashboard.DashboardPage;
import com.softserve.edu.magento.tools.ListUtils;
import com.softserve.edu.magento.tools.ParameterUtils;

public class CustomerSmokeTests extends TestBase{
	@DataProvider
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
				.toMultiArray(
						ParameterUtils.get()
								.updateParametersAll(ApplicationSourcesRepository.getChromeLocalhostAdmin(), context),
						AdminUserRepository.get().adminMykhaylo());
	}

	//@Test(dataProvider = "smokeParameters", priority = 1)
	public void findSortedColumnNameInCustomerList(ApplicationSources applicationSources, IAdminUser adminUser)
			throws Exception {
		// Precondition
		// login and go to DashboardPage
		ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
		DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
		// go to AllCustomersPage
		AllCustomersPage acp = dashboardPage.gotoAllCustomersPage();
		// Verify that AllCustomersPage is opened
		Assert.assertEquals(acp.getCustomersLabelText(), acp.PAGE_TITLE);
		// check fields if sorted
		Assert.assertTrue(acp.sortedNameField(), "Names Aren't sorted!");
		// Sign Out Admin
		applicationAdmin.quit();
	}

	@Test(dataProvider = "smokeParameters", priority = 2)
	public void validRegistrationNewCustomerAndFindInTheTable(ApplicationSources applicationSources,
			IAdminUser adminUser) throws Exception {
		// Precondition
		// login and go to DashboardPage
		ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
		DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
		// go to AllCustomersPage
		AllCustomersPage acp = dashboardPage.gotoAllCustomersPage();
		// Verify that AllCustomersPage is opened
		Assert.assertEquals(acp.getCustomersLabelText(), acp.PAGE_TITLE);
		// go to RegistrationNewCustomerPage
		RegistrationNewCustomerPage regNewCust = acp.goToRegistrationNewCustomerPage();
		// Verify that RegistrationNewCustomerPage is opened
		Assert.assertEquals(regNewCust.getFromNewCustomerLabelText(), regNewCust.PAGE_TITLE);
		// setting data to login form
		AllCustomersPageAfterSuccesRegistration allCustAfter = regNewCust
				.setCustomerDataInLoginForm(CustomerUserRepositoryForAdmin.get().NewCustomerRegistrationFromAdminSide());
		// Verify that new Customer was registered
		Assert.assertEquals(allCustAfter.getRegisteredNewCustomerLabelgetText(),
				allCustAfter.REGISTERED_CUSTOMER_TITLE);
		// Try to find registered customer in Customer page
		Assert.assertTrue(allCustAfter
				.findCustomerInTheList(CustomerUserRepositoryForAdmin.get().NewCustomerRegistrationFromAdminSide()));
		// deleting registered Customer
		allCustAfter.deleteCustomerUser(CustomerUserRepositoryForAdmin.get().NewCustomerRegistrationFromAdminSide());
		Thread.sleep(2000);
		allCustAfter.clickClearAllButton();
		Thread.sleep(2000);
		// Sign Out Admin
		applicationAdmin.quit();
	}

	//@Test(dataProvider = "smokeParameters", priority = 3)
	public void searchCustomerInTable(ApplicationSources applicationSources, IAdminUser adminUser) throws Exception {
		// Precondition
		// login and go to DashboardPage
		ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
		DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
		//go to AllCustomersPAge
		AllCustomersPage acp = dashboardPage.gotoAllCustomersPage();
		// Verify that AllCustomersPage is opened
		Assert.assertEquals(acp.getCustomersLabelText(), acp.PAGE_TITLE);
		//find and verify customer
		Assert.assertTrue(acp.findCustomerInTheListAfterSearch(CustomerUserRepositoryForAdmin.get().SteveRinger()));
		// Sign Out Admin
		applicationAdmin.quit();
	}

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
