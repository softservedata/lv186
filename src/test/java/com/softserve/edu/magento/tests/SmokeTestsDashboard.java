package com.softserve.edu.magento.tests;


import java.util.List;
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
import com.softserve.edu.magento.data.admin.dashboard.ISearch;
import com.softserve.edu.magento.data.admin.dashboard.SearchRepository;
import com.softserve.edu.magento.data.customer.user.CustomerUserRepository;
import com.softserve.edu.magento.data.customer.user.ICustomerUser;
import com.softserve.edu.magento.pages.ApplicationAdmin;
import com.softserve.edu.magento.pages.ApplicationCustomer;
import com.softserve.edu.magento.pages.customer.HomePageLogout;
import com.softserve.edu.magento.pages.menu.dashboard.DashboardPage;
import com.softserve.edu.magento.tools.ParameterUtils;

public class SmokeTestsDashboard {

	@DataProvider(parallel = true)
	public Object[][] smokeParameters(ITestContext context) {
		return new Object[][] {
			{ ParameterUtils.get().updateParametersAll(ApplicationSourcesRepository.getFirefoxLocalhostAdmin(),
					context), AdminUserRepository.get().adminTest(), CustomerUserRepository.get().getTeodorDrayzer() },
			{ ParameterUtils.get().updateParametersAll(ApplicationSourcesRepository.getChromeLocalhostAdmin(),
					context), AdminUserRepository.get().adminBohdan(), CustomerUserRepository.get().getTeodorDrayzer() } };

}
	@DataProvider(parallel = true)
	public Object[][] smokeParameters2(ITestContext context) {
		return new Object[][] {
			{ ParameterUtils.get().updateParametersAll(ApplicationSourcesRepository.getFirefoxLocalhostAdmin(),
					context), AdminUserRepository.get().adminBohdan() },
			{ ParameterUtils.get().updateParametersAll(ApplicationSourcesRepository.getChromeLocalhostAdmin(),
					context), AdminUserRepository.get().adminTest() } };

}

	@DataProvider(parallel = true)
	public Object[][] smokeParameters3(ITestContext context) {
		return new Object[][] {
				{ ParameterUtils.get().updateParametersAll(ApplicationSourcesRepository.getChromeLocalhostCustomer(),
						context), AdminUserRepository.get().adminBohdan(), ApplicationAdmin.get(ApplicationSourcesRepository.getChromeLocalhostAdmin()), SearchRepository.get().searchFields() },
				{ ParameterUtils.get().updateParametersAll(ApplicationSourcesRepository.getFirefoxLocalhostCustomer(),
						context), AdminUserRepository.get().adminTest(), ApplicationAdmin.get(ApplicationSourcesRepository.getFirefoxLocalhostAdmin()), SearchRepository.get().searchFields() } };

	}
	
	@Test(dataProvider = "smokeParameters")
	public void findCustomerFromLastOrders(ApplicationSources applicationSources, IAdminUser adminUser,
			ICustomerUser customerUser) {
		ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
		DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
		List<String> result = dashboardPage.getCustomersFromLastOrdersRecords();
		String searchCheck = customerUser.getPersonalInfo().getFirstname() + " "
				+ customerUser.getPersonalInfo().getLastname();
		Assert.assertTrue(result.contains(searchCheck), "User not found");
		applicationAdmin.quit();
	}

	@Test(dataProvider = "smokeParameters2")
	public void checkReloadMessage(ApplicationSources applicationSources, IAdminUser adminUser) {
		ApplicationAdmin applicationAdmin = ApplicationAdmin.get(applicationSources);
		DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
		Assert.assertEquals(dashboardPage.getReloadMessageText(), DashboardPage.RELOAD_MESSAGE);
		;
	}

	@Test(dataProvider = "smokeParameters3")
	public void checkSearchResults(ApplicationSources applicationSources, IAdminUser adminUser, ApplicationAdmin adminBrowser, ISearch listOfTerms) {
		ApplicationCustomer applicationCustomer = ApplicationCustomer.get(applicationSources);
		HomePageLogout homePage = applicationCustomer.load();
		List<String> searchTerms = listOfTerms.getSearchFields();
		String searchField = searchTerms.get(0);
		homePage.search(searchField);
		ApplicationAdmin applicationAdmin = adminBrowser;
		DashboardPage dashboardPage = applicationAdmin.load().successAdminLogin(adminUser);
		List<String> searchResultTable = dashboardPage.getSearchTermsFromLastSearchTermsRecords();
		Assert.assertTrue(searchResultTable.contains(searchField), "Search term not found");
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
