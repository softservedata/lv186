package com.softserve.edu.magento.tests;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.magento.data.AdminUserRepository;
import com.softserve.edu.magento.data.ApplicationSources;
import com.softserve.edu.magento.data.ApplicationSourcesRepository;
import com.softserve.edu.magento.data.IAdminUser;
import com.softserve.edu.magento.data.customer.user.CustomerUserRepository;
import com.softserve.edu.magento.pages.ApplicationAdmin;
import com.softserve.edu.magento.pages.menu.customers.AllCustomersPage;
import com.softserve.edu.magento.pages.menu.customers.AllCustomersPageAfterSuccesRegistration;
import com.softserve.edu.magento.pages.menu.customers.RegistrationNewCustomerPage;
import com.softserve.edu.magento.pages.menu.dashboard.DashboardPage;
import com.softserve.edu.magento.tools.ListUtils;
import com.softserve.edu.magento.tools.ParameterUtils;

public class CustomerSmokeTests {
	@DataProvider(parallel = true)
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
						.updateParametersAll(ApplicationSourcesRepository.getChromeLocalhostAdmin(), context),
						AdminUserRepository.get().adminMykhaylo());
	}

	// @Test(dataProvider = "smokeParameters")
	public void validRegistrationNewCustomerAndFindInTheTable(ApplicationSources applicationSources, IAdminUser adminUser)
			throws Exception {
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
		AllCustomersPageAfterSuccesRegistration asdfgh = regNewCust
				.setCustomerDataInLoginForm(CustomerUserRepository.get().NewCustomerRegistrationFromAdminSide());
		Assert.assertTrue(
				asdfgh.findCustomerInTheList(CustomerUserRepository.get().NewCustomerRegistrationFromAdminSide()));
		Assert.assertEquals(asdfgh.getRegisteredNewCustomerLabelgetText(), asdfgh.REGISTERED_CUSTOMER_TITLE);
		asdfgh.deleteCustomerUser(CustomerUserRepository.get().NewCustomerRegistrationFromAdminSide());
		Thread.sleep(5000);
		applicationAdmin.quit();
	}

	// @Test(dataProvider = "smokeParameters")
	public void searchCustomerInTable(ApplicationSources applicationSources, IAdminUser adminUser) throws Exception {
		// Precondition
		ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
		Thread.sleep(1000);
		DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
		Thread.sleep(1000);
		AllCustomersPage acp = dashboardPage.gotoAllCustomersPage();
		Thread.sleep(1000);
		Assert.assertEquals(acp.getCustomersLabelText(), acp.PAGE_TITLE);
		Assert.assertTrue(acp
				.findCustomerInTheListAfterSearch(CustomerUserRepository.get().NewCustomerRegistrationFromAdminSide()));
		Thread.sleep(5000);
		applicationAdmin.quit();
	}

	 @Test(dataProvider = "smokeParameters")
	public void findSortedColumnNameInCustomerList(ApplicationSources applicationSources, IAdminUser adminUser) throws Exception {
		// Precondition
		ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
		Thread.sleep(1000);
		DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
		Thread.sleep(1000);
		AllCustomersPage acp = dashboardPage.gotoAllCustomersPage();
		Thread.sleep(1000);
		Assert.assertTrue(acp.sortedNameField(), "Names Aren't sorted!");
		Thread.sleep(5000);
		applicationAdmin.quit();
	}


	  // @Test(dataProvider = "smokeParameters")
		public void tryToFindDeletedColumn(ApplicationSources applicationSources, IAdminUser adminUser) throws Exception {
			// Precondition
			ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
			Thread.sleep(1000);
			DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
			Thread.sleep(1000);
			AllCustomersPage acp = dashboardPage.gotoAllCustomersPage();		
			Thread.sleep(1000);
			acp.goToColumnsMenuDropdown();
			Thread.sleep(5000);
			acp.columnsmenudropdownNameClick();
			Thread.sleep(5000);
			acp.allCustomersLabelClick();
			Assert.assertTrue(acp.findDeletedColumn());
			Thread.sleep(5000);
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
