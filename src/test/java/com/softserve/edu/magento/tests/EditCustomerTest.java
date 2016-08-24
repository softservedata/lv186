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
import com.softserve.edu.magento.pages.admin.ApplicationAdmin;
import com.softserve.edu.magento.pages.admin.menu.customers.editCustomer.EditCustomerPage;
import com.softserve.edu.magento.pages.admin.menu.dashboard.DashboardPage;
import com.softserve.edu.magento.tools.ListUtils;
import com.softserve.edu.magento.tools.ParameterUtils;

public class EditCustomerTest extends TestBase {
	@DataProvider(parallel = true)
	public Object[][] smokeParameters(ITestContext context) {
		return ListUtils.get()
				.toMultiArray(
						ParameterUtils.get()
								.updateParametersAll(ApplicationSourcesRepository.getChromeHomeHostAdmin(), context),
						AdminUserRepository.get().adminAndrii());
	}

	@Test(dataProvider = "smokeParameters", groups = "EditTest")
	public void saveEditCustomer(ApplicationSources applicationSources, IAdminUser adminUser) {
		ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);

		DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
		System.out.println("luck DashboardPage!");
		EditCustomerPage ediCustomerPage = dashboardPage.gotoAllCustomersPage().getEditCustomerPage();
		System.out.println("luck EditCustomerPage!");
		ediCustomerPage.navToAccountInfo();

		Assert.assertTrue(ediCustomerPage
				.compareFields(ediCustomerPage.getCustomerAllData().get(0)));
		applicationAdmin.quit();
	}

	// @Test(dataProvider = "smokeParameters", groups = "EditTest")
	public void resetMadeChanges(ApplicationSources applicationSources, IAdminUser adminUser) {
		ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);

		DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);

		EditCustomerPage ediCustomerPage = dashboardPage.gotoAllCustomersPage().getEditCustomerPage();

		ediCustomerPage.navToadresses();

		Assert.assertTrue(ediCustomerPage.compareChangesMadetoCity());
		applicationAdmin.quit();
	}

	//@Test(dataProvider = "smokeParameters", groups = "EditTest")
	public void saveAndContinue(ApplicationSources applicationSources, IAdminUser adminUser) {
		ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);

		DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);

		EditCustomerPage ediCustomerPage = dashboardPage.gotoAllCustomersPage().getEditCustomerPage();

		ediCustomerPage.initAccountInfo();

		ediCustomerPage.lastnameSendValue(" Dirty Johnny");

		EditCustomerPage newEdiCustomerPage = ediCustomerPage.saveAndContinueEdit();

		newEdiCustomerPage.navToAccountInfo();

		newEdiCustomerPage.setSuccessMessage();

		Assert.assertTrue(newEdiCustomerPage.getSuccessMessage().isDisplayed());
		applicationAdmin.quit();
	}

	//@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		ApplicationAdmin.signout();
		// ApplicationAdmin.quitAll();
	}

	//@AfterClass(alwaysRun = true)
	void tearDown() throws Exception {
		ApplicationAdmin.quitAll();
	}

}