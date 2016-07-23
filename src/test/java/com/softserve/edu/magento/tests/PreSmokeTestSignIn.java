package com.softserve.edu.magento.tests;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.magento.data.AdminUserRepository;
import com.softserve.edu.magento.data.ApplicationSources;
import com.softserve.edu.magento.data.ApplicationSourcesRepository;
import com.softserve.edu.magento.data.IAdminUser;
import com.softserve.edu.magento.data.customer.user.CustomerUserRepository;
import com.softserve.edu.magento.pages.ApplicationAdmin;
import com.softserve.edu.magento.pages.ApplicationCustomer;
import com.softserve.edu.magento.pages.customer.AccountDashboardPage;
import com.softserve.edu.magento.pages.customer.CreateAccountPage;
import com.softserve.edu.magento.pages.customer.HomePageLogout;
import com.softserve.edu.magento.pages.customer.SignInPage;
import com.softserve.edu.magento.pages.customer.UnsuccessfulSignInPage;
import com.softserve.edu.magento.pages.customer.UnsuccessfulSignInPage.ErrorMessageSignIn;
import com.softserve.edu.magento.pages.customer.Unsuccessful_CreateAccountPage;
import com.softserve.edu.magento.pages.customer.Unsuccessful_CreateAccountPage.ErrorMessage;
import com.softserve.edu.magento.pages.customer.components.Header.Titles;
import com.softserve.edu.magento.pages.menu.customers.AllCustomersPage;
import com.softserve.edu.magento.tools.ListUtils;
import com.softserve.edu.magento.tools.ParameterUtils;

public class PreSmokeTestSignIn {

  @AfterMethod
  public void afterMethod() {
	  ApplicationCustomer.quitAll();
  }
  @AfterClass
  void tearDown() throws Exception {
	  //ApplicationCustomer.quitAll();
  }
  @DataProvider //(parallel = true)
  public Object[][] smokeParameters(ITestContext context) {
      return ListUtils.get().toMultiArray(
              ParameterUtils.get().updateParametersAll(
                      ApplicationSourcesRepository.getFirefoxLocalhostCustomer(), context),
				AdminUserRepository.get().adminYaryna());
	/* return new Object[][] {
			 { ParameterUtils.get().updateParametersAll(
			 ApplicationSourcesRepository.getFirefoxLocalhostCustomer(), context)},
			 { ParameterUtils.get().updateParametersAll(
			 ApplicationSourcesRepository.getChromeLocalhostCustomer(), context)}
			 };*/
  }

  //@Test(dataProvider = "smokeParameters")
  public void testSignIn1(ApplicationSources applicationSources, IAdminUser adminUser) {
	  //prepare our application
	  ApplicationCustomer applicationCustomer = ApplicationCustomer.get(applicationSources);
	  HomePageLogout homePageLogout = applicationCustomer.load();
	  //confirm that home page is opened 
	  Assert.assertEquals(homePageLogout.getTitleText(), Titles.HOME_PAGE.toString());
	  //go to the signIn page 
	  SignInPage signInPage = homePageLogout.clickSignInLink();
	  //confirm that signIn page is opened
	  Assert.assertEquals(signInPage.getTitleText(), Titles.CUSTOMER_LOGIN.toString());
	  //succsess log in user
	  //go to the AccountDashboard Page
	  AccountDashboardPage accountDashboardPage = signInPage.SignIn(CustomerUserRepository.get().User());  
	  //confirm that AccountDashboard page is opened
	  Assert.assertEquals(accountDashboardPage.getTitleText(), 
			  Titles.ACCOUNT_DASHBOARD.toString());
	  // Sign Out user
	  //go to the home page
	  homePageLogout = accountDashboardPage.clickSignOutButton();
	  
  }
  //@Test(dataProvider = "smokeParameters")
  public void testSignIn1_1(ApplicationSources applicationSources, IAdminUser adminUser) {
	  ApplicationCustomer applicationCustomer = ApplicationCustomer.get(applicationSources);
	  HomePageLogout homePageLogout = applicationCustomer.load();
	  
	  Assert.assertEquals(homePageLogout.getTitleText(), Titles.HOME_PAGE.toString());
	  
	  SignInPage signInPage = homePageLogout.clickSignInLink();
	  
	  Assert.assertEquals(signInPage.getTitleText(), Titles.CUSTOMER_LOGIN.toString());
	  
	  AccountDashboardPage accountDashboardPage = signInPage.SignIn_Enter(CustomerUserRepository.get().User());  
	  
	  Assert.assertEquals(accountDashboardPage.getTitleText(), 
			  Titles.ACCOUNT_DASHBOARD.toString());
	  
	  homePageLogout = accountDashboardPage.clickSignOutButton();
  }
  //@Test(dataProvider = "smokeParameters")
  public void testSignIn2(ApplicationSources applicationSources, IAdminUser adminUser) {
	  ApplicationCustomer applicationCustomer = ApplicationCustomer.get(applicationSources);
	  HomePageLogout homePageLogout = applicationCustomer.load();
	  SignInPage signInPage = homePageLogout.clickSignInLink();
	  UnsuccessfulSignInPage unsuccessfulSignInPage = signInPage.
			  unsuccessfulSignIn(CustomerUserRepository.get().invalidUser());  
	  Assert.assertEquals(unsuccessfulSignInPage.getTitleText(), 
			  Titles.CUSTOMER_LOGIN.toString());
	  Assert.assertEquals(unsuccessfulSignInPage.getErrorMessageText(),
			  ErrorMessageSignIn.INVALID_SIGNIN.toString());
  }
 // @Test(dataProvider = "smokeParameters")
  public void testCreateAccount1(ApplicationSources applicationSources, IAdminUser adminUser) throws InterruptedException {
	  
	  ApplicationCustomer applicationCustomer = ApplicationCustomer.get(applicationSources);
	  HomePageLogout homePageLogout = applicationCustomer.load();
	  SignInPage signInPage = homePageLogout.clickSignInLink();
	  CreateAccountPage createAccountPage = signInPage.clickCreateAccountButton();
	  
	  AccountDashboardPage accountDashboardPage = createAccountPage.createNewAccount
			  (CustomerUserRepository.get().newUser());
	  
	  Assert.assertEquals(accountDashboardPage.getTitleText(),
			  Titles.ACCOUNT_DASHBOARD.toString());
	  
	  homePageLogout = accountDashboardPage.clickSignOutButton();
	  
	  Assert.assertEquals(homePageLogout.getTitleText(),
			  Titles.YOU_ARE_SIGNED_OUT.toString());
	  
	  ApplicationAdmin applicationAdmin = ApplicationAdmin.get(ApplicationSourcesRepository.getFirefoxLocalhostAdmin());
	  
	  AllCustomersPage allCustomersPage = applicationAdmin.load()
			  .successAdminLogin(adminUser)
			  .gotoAllCustomersPage();
	  allCustomersPage.deleteCustomerUser(CustomerUserRepository.get().newUser());
	  
  }
  @Test(dataProvider = "smokeParameters")
  public void testCreateAccount2(ApplicationSources applicationSources, IAdminUser adminUser) {
	//prepare our application
	  ApplicationCustomer applicationCustomer = ApplicationCustomer.get(applicationSources);
	  HomePageLogout homePageLogout = applicationCustomer.load();
	  //test steps
	  //1.Unsuccessful create account
	  Unsuccessful_CreateAccountPage unsuccessful_CreateAccountPage =
			  homePageLogout.clickCreateAccountLink().unsuccessful_createNewAccount(CustomerUserRepository.get().User());
	  //2.Confirm that error message 
	  Assert.assertEquals(unsuccessful_CreateAccountPage.getErrorMessageText(),
			  ErrorMessage.ALREADY_EXIST_ACCOUNT.toString());
	  ApplicationAdmin applicationAdmin = ApplicationAdmin.get(ApplicationSourcesRepository.getFirefoxLocalhostAdmin());
	  
	  
	  AllCustomersPage allCustomersPage = applicationAdmin.load()
			  .successAdminLogin(adminUser)
			  .gotoAllCustomersPage();
	  Assert.assertFalse(allCustomersPage
			  .confirmAlreadyExistCustomerUserIsCreated(CustomerUserRepository.get().User()));
	  
  }
  //@Test(dataProvider = "smokeParameters")
  public void testMysha(ApplicationSources applicationSources, IAdminUser adminUser) {
	//prepare our application
	  ApplicationCustomer applicationCustomer = ApplicationCustomer.get(applicationSources);
	  HomePageLogout homePageLogout = applicationCustomer.load();
	  
	  ApplicationAdmin applicationAdmin = ApplicationAdmin.get(ApplicationSourcesRepository.getFirefoxLocalhostAdmin());
	  
	  
	  AllCustomersPage allCustomersPage = applicationAdmin.load()
			  .successAdminLogin(adminUser)
			  .gotoAllCustomersPage();
	  allCustomersPage.doCustomerSearch("");
	  allCustomersPage.getNameColumn();
	  
  }
}
