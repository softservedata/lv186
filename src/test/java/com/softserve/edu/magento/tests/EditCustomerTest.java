package com.softserve.edu.magento.tests;

import com.softserve.edu.magento.data.ApplicationSources;
import com.softserve.edu.magento.data.ApplicationSourcesRepository;
import com.softserve.edu.magento.data.admin.AdminUserRepository;
import com.softserve.edu.magento.data.admin.IAdminUser;
import com.softserve.edu.magento.data.customer.user.CustomerUserRepository;
import com.softserve.edu.magento.pages.admin.ApplicationAdmin;
import com.softserve.edu.magento.pages.admin.menu.customers.AllCustomersPage;
import com.softserve.edu.magento.pages.admin.menu.customers.RegistrationNewCustomerPage;
import com.softserve.edu.magento.pages.admin.menu.customers.editCustomer.EditCustomerPage;
import com.softserve.edu.magento.pages.admin.menu.dashboard.DashboardPage;
import com.softserve.edu.magento.tools.ListUtils;
import com.softserve.edu.magento.tools.ParameterUtils;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;

import java.util.Random;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;

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

	@Test(dataProvider = "smokeParameters") 
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
	
	@Test(dataProvider = "smokeParameters") 
	public void resetMadeChanges (ApplicationSources applicationSources, IAdminUser adminUser) {
		ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
		DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
		EditCustomerPage ecp = dashboardPage.gotoAllCustomersPage().getEditCustomerPage();
		ecp.navToAccountInfo().setFirstname("Dirty Jhonny");
		ecp.navToadresses().setCity("London");
		ecp.reset();
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
