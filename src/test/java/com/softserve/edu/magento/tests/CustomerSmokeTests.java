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
				.toMultiArray(ParameterUtils.get()
						.updateParametersAll(ApplicationSourcesRepository.getChromeLocalhostAdmin(), context),
						AdminUserRepository.get().adminMykhaylo());
	}

	 @Test(dataProvider = "smokeParameters", priority = 1)
	public void findSortedColumnNameInCustomerList(ApplicationSources applicationSources, IAdminUser adminUser) throws Exception {
		// Precondition
		ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
		DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
		AllCustomersPage acp = dashboardPage.gotoAllCustomersPage();
		Assert.assertEquals(acp.getCustomersLabelText(), acp.PAGE_TITLE);
		Assert.assertTrue(acp.sortedNameField(), "Names Aren't sorted!");
		applicationAdmin.quit();
	}
	 @Test(dataProvider = "smokeParameters", priority = 2)
	public void validRegistrationNewCustomerAndFindInTheTable(ApplicationSources applicationSources, IAdminUser adminUser)
			throws Exception {
		// Precondition
		ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
		DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
		AllCustomersPage acp = dashboardPage.gotoAllCustomersPage();
		Assert.assertEquals(acp.getCustomersLabelText(), acp.PAGE_TITLE);
		RegistrationNewCustomerPage regNewCust = acp.goToRegistrationNewCustomerPage();
		Assert.assertEquals(regNewCust.getFromNewCustomerLabelText(), regNewCust.PAGE_TITLE);
		AllCustomersPageAfterSuccesRegistration allCustAfter = regNewCust
				.setCustomerDataInLoginForm(CustomerUserRepository.get().NewCustomerRegistrationFromAdminSide());
		Assert.assertTrue(
				allCustAfter.findCustomerInTheList(CustomerUserRepository.get().NewCustomerRegistrationFromAdminSide()));
		Assert.assertEquals(allCustAfter.getRegisteredNewCustomerLabelgetText(), allCustAfter.REGISTERED_CUSTOMER_TITLE);
		allCustAfter.deleteCustomerUser(CustomerUserRepository.get().NewCustomerRegistrationFromAdminSide());
		applicationAdmin.quit();
	}

	 @Test(dataProvider = "smokeParameters", priority = 3)
	public void searchCustomerInTable(ApplicationSources applicationSources, IAdminUser adminUser) throws Exception {
		// Precondition
		ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
		DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
		AllCustomersPage acp = dashboardPage.gotoAllCustomersPage();
		Assert.assertEquals(acp.getCustomersLabelText(), acp.PAGE_TITLE);
		Assert.assertTrue(acp
				.findCustomerInTheListAfterSearch(CustomerUserRepository.get().SteveRinger()));
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

