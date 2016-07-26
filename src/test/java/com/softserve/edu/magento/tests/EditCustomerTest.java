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

public class EditCustomerTest {
	@DataProvider(parallel = true)
	public Object[][] smokeParameters(ITestContext context) {
		return ListUtils.get()
				.toMultiArray(
						ParameterUtils.get()
								.updateParametersAll(ApplicationSourcesRepository.getFirefoxLocalhostAdmin(), context),
						AdminUserRepository.get().adminAndrii());
	}

	 @Test(dataProvider = "smokeParameters", groups = "EditTest")
	public void saveEditCustomer(ApplicationSources applicationSources, IAdminUser adminUser) {
		ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
		DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
		EditCustomerPage ediCustomerPage = dashboardPage.gotoAllCustomersPage().getEditCustomerPage();
		ediCustomerPage.navToAccountInfo();
		Assert.assertTrue(ediCustomerPage
				.compareFields(ediCustomerPage.getCustomerAllData().get(8)));
		applicationAdmin.quit();
	}

	 @Test(dataProvider = "smokeParameters", groups = "EditTest")
	public void resetMadeChanges(ApplicationSources applicationSources, IAdminUser adminUser) {
		ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
		DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
		EditCustomerPage ediCustomerPage = dashboardPage.gotoAllCustomersPage().getEditCustomerPage();
		ediCustomerPage.navToadresses();
		Assert.assertTrue(ediCustomerPage.compareChangesMadetoCity());
		applicationAdmin.quit();
	}

	@Test(dataProvider = "smokeParameters", groups = "EditTest")
	public void saveAndContinue(ApplicationSources applicationSources, IAdminUser adminUser) {
		ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
		DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
		EditCustomerPage ediCustomerPage = dashboardPage.gotoAllCustomersPage().getEditCustomerPage();
		ediCustomerPage.navToAccountInfo().setLastname(" Dirty Johnny");
		EditCustomerPage newediCustomerPage = ediCustomerPage.saveAndContinueEdit();
		newediCustomerPage.navToAccountInfo();
		newediCustomerPage.setSuccessMessage();
		Assert.assertTrue(newediCustomerPage.getSuccessMessage().isDisplayed());
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