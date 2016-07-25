package com.softserve.edu.magento.tests;

import java.util.Random;

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
import com.softserve.edu.magento.editCustomer.EditCustomerPage;
import com.softserve.edu.magento.pages.admin.ApplicationAdmin;
import com.softserve.edu.magento.pages.admin.menu.dashboard.DashboardPage;
import com.softserve.edu.magento.tools.ListUtils;
import com.softserve.edu.magento.tools.ParameterUtils;

public class EditCustomerTest {
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
				.toMultiArray(
						ParameterUtils.get()
								.updateParametersAll(ApplicationSourcesRepository.getFirefoxLocalhostAdmin(), context),
						AdminUserRepository.get().adminAndrii());
	}

	// @Test(dataProvider = "smokeParameters")
	public void saveEditCustomer(ApplicationSources applicationSources, IAdminUser adminUser) {
		ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
		DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
		EditCustomerPage ecp = dashboardPage.gotoAllCustomersPage().getEditCustomerPage();
		ecp.navToAccountInfo();
		Assert.assertTrue(ecp.compareFields(ecp.getCustomerAllData()
				// TODO method
				.get(new Random().nextInt(ecp.getCustomerAllData().size()))));
		applicationAdmin.quit();
	}

	// @Test(dataProvider = "smokeParameters")
	public void resetMadeChanges(ApplicationSources applicationSources, IAdminUser adminUser) {
		ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
		DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
		EditCustomerPage ecp = dashboardPage.gotoAllCustomersPage().getEditCustomerPage();
		ecp.navToadresses();
		Assert.assertTrue(ecp.compareChangesMadetoCity());
	}

	@Test(dataProvider = "smokeParameters")
	public void saveAndContinue(ApplicationSources applicationSources, IAdminUser adminUser) {
		ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
		DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
		EditCustomerPage ecp = dashboardPage.gotoAllCustomersPage().getEditCustomerPage();
		ecp.navToAccountInfo().setLastname(" Dirty Johnny");
		EditCustomerPage nuecp = ecp.saveAndContinueEdit();
		nuecp.navToAccountInfo();
		nuecp.setSuccessMessage();
		Assert.assertTrue(nuecp.getSuccessMessage().isDisplayed());
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