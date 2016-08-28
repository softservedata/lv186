package com.softserve.edu.magento.tests;

import com.softserve.edu.magento.pages.admin.menu.customers.*;
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
import com.softserve.edu.magento.pages.admin.menu.dashboard.DashboardPage;
import com.softserve.edu.magento.tools.ListUtils;
import com.softserve.edu.magento.tools.ParameterUtils;
import org.testng.asserts.SoftAssert;
import ss.af.reporting.annotations.ServiceReport;

public class CustomerSmokeTests extends TestBase{
	private SoftAssert softAssert = new SoftAssert();
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



	@Test(dataProvider = "smokeParameters", priority = 1)
	@ServiceReport
	public void validRegistrationNewCustomerAndFindInTheTable(ApplicationSources applicationSources,
			IAdminUser adminUser) throws Exception {
		// Precondition
		// login and go to DashboardPage
		ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
		DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
		// go to AllCustomersPage
		AllCustomersPage acp = dashboardPage.gotoAllCustomersPage();
		// Verify that AllCustomersPage is opened
		softAssert.assertEquals(acp.getCustomersLabelText(), acp.PAGE_TITLE);
		// go to RegistrationNewCustomerPage
		RegistrationNewCustomerPage regNewCust = acp.goToRegistrationNewCustomerPage();
		// Verify that RegistrationNewCustomerPage is opened
		softAssert.assertEquals(regNewCust.getFromNewCustomerLabelText(), regNewCust.PAGE_TITLE);
		// setting data to login form
		AllCustomersPageAfterSuccesRegistration allCustAfter = regNewCust
				.setCustomerDataInLoginForm(CustomerUserRepositoryForAdmin.get().NewCustomerRegistrationFromAdminSide());
		// Verify that new Customer was registered
		softAssert.assertEquals(allCustAfter.getRegisteredNewCustomerLabelgetText(),
				allCustAfter.REGISTERED_CUSTOMER_TITLE);
		// Try to find registered customer in Customer page
		softAssert.assertTrue(allCustAfter
				.findCustomerInTheList(CustomerUserRepositoryForAdmin.get().NewCustomerRegistrationFromAdminSide()));
		// deleting registered Customer
		allCustAfter.deleteCustomerUser(CustomerUserRepositoryForAdmin.get().NewCustomerRegistrationFromAdminSide());
		// clearing fields
		allCustAfter.clickClearAllButton();
		// Sign Out Admin
		applicationAdmin.quit();
	}

	@Test(dataProvider = "smokeParameters", priority = 2)
	public void invalidErrorMessageRegistrationNewCustomer(ApplicationSources applicationSources,
															  IAdminUser adminUser) throws Exception {
		// Precondition
		// login and go to DashboardPage
		ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
		DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
		// go to AllCustomersPage
		AllCustomersPage acp = dashboardPage.gotoAllCustomersPage();
		// Verify that AllCustomersPage is opened
		softAssert.assertEquals(acp.getCustomersLabelText(), acp.PAGE_TITLE);
		// go to RegistrationNewCustomerPage
		RegistrationNewCustomerPage regNewCust = acp.goToRegistrationNewCustomerPage();
		// Verify that RegistrationNewCustomerPage is opened
		softAssert.assertEquals(regNewCust.getFromNewCustomerLabelText(), regNewCust.PAGE_TITLE);
		// setting data to login form
		RegistrationNewCustomerErrorPage err = regNewCust
				.setRingerDataInLoginForm(CustomerUserRepositoryForAdmin.get().SteveRinger());
		// Verify that it is immpossible to registrate existed customer
		softAssert.assertEquals(err.getExistEmailErrorTextLabel(), err.ERROR_MESSAGE_EMAIL_EXIST);
		// Sign Out Admin
		applicationAdmin.quit();
	}

	@Test(dataProvider = "smokeParameters", priority = 3)
	public void invalidErrorFieldsRegistrationNewCustomer(ApplicationSources applicationSources,
														   IAdminUser adminUser) throws Exception {
		// Precondition
		// login and go to DashboardPage
		ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
		DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
		// go to AllCustomersPage
		AllCustomersPage acp = dashboardPage.gotoAllCustomersPage();
		// Verify that AllCustomersPage is opened
		softAssert.assertEquals(acp.getCustomersLabelText(), acp.PAGE_TITLE);
		// go to RegistrationNewCustomerPage
		RegistrationNewCustomerPage regNewCust = acp.goToRegistrationNewCustomerPage();
		// Verify that RegistrationNewCustomerPage is opened
		softAssert.assertEquals(regNewCust.getFromNewCustomerLabelText(), regNewCust.PAGE_TITLE);
		// setting data to login form
		RegistrationNewCustomerErrorFieldsPage err = regNewCust
				.setInvalidFirstnameLastNameEmailDataInLoginForm(CustomerUserRepositoryForAdmin.get().customerWithInvalidFields());
		// Verify that we will receive error fields messages
		softAssert.assertEquals(err.getFirstnameErrorLabelText(), err.ERROR_MESSAGE_FIRSTNAME);
		softAssert.assertEquals(err.getLastnameErrorLabelText(), err.ERROR_MESSAGE_LASTNAME);
		softAssert.assertEquals(err.getEmailErrorLabelText(), err.ERROR_MESSAGE_EMAIL);
		// Sign Out Admin
		applicationAdmin.quit();
	}


	@Test(dataProvider = "smokeParameters", priority = 4)
	public void checkResetButton(ApplicationSources applicationSources,
								 IAdminUser adminUser) throws Exception {
		// Precondition
		// login and go to DashboardPage
		ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
		DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
		// go to AllCustomersPage
		AllCustomersPage acp = dashboardPage.gotoAllCustomersPage();
		// Verify that AllCustomersPage is opened
		softAssert.assertEquals(acp.getCustomersLabelText(), acp.PAGE_TITLE);
		// go to RegistrationNewCustomerPage
		RegistrationNewCustomerPage regNewCust = acp.goToRegistrationNewCustomerPage();
		// Verify that RegistrationNewCustomerPage is opened
		softAssert.assertEquals(regNewCust.getFromNewCustomerLabelText(), regNewCust.PAGE_TITLE);
		// setting data to login form
		regNewCust.setRingerDataInLoginFormAndClickResetButton(CustomerUserRepositoryForAdmin.get().SteveRinger());
		// Verify that fielsds are empty
		softAssert.assertTrue(regNewCust.getFirstnameInput().getText().isEmpty(), "Firstname field isn't empty!");
		softAssert.assertTrue(regNewCust.getLastnameInput().getText().isEmpty(), "Lastname field isn't empty!");
		softAssert.assertTrue(regNewCust.getEmailInput().getText().isEmpty(), "Email field isn't empty!");
		// Sign Out Admin
		applicationAdmin.quit();


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
		softAssert.assertAll();
	}

}
