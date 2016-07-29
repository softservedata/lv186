package com.softserve.edu.magento.tests;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.magento.data.ApplicationSources;
import com.softserve.edu.magento.data.ApplicationSourcesRepository;
import com.softserve.edu.magento.data.admin.AdminUserRepository;
import com.softserve.edu.magento.data.admin.IAdminUser;
import com.softserve.edu.magento.data.customer.user.CustomerUserRepository;
import com.softserve.edu.magento.pages.admin.ApplicationAdmin;
import com.softserve.edu.magento.pages.admin.menu.customers.AllCustomersPage;
import com.softserve.edu.magento.pages.customer.AccountDashboardPage;
import com.softserve.edu.magento.pages.customer.ApplicationCustomer;
import com.softserve.edu.magento.pages.customer.CreateAccountPage;
import com.softserve.edu.magento.pages.customer.HomePageLogout;
import com.softserve.edu.magento.pages.customer.SignInPage;
import com.softserve.edu.magento.pages.customer.UnsuccessfulSignInPage;
import com.softserve.edu.magento.pages.customer.UnsuccessfulSignInPage.ErrorMessageSignIn;
import com.softserve.edu.magento.pages.customer.Unsuccessful_CreateAccountPage;
import com.softserve.edu.magento.pages.customer.Unsuccessful_CreateAccountPage.ErrorMessage;
import com.softserve.edu.magento.pages.customer.components.Header.Titles;
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
  @DataProvider (parallel = true)
  public Object[][] smokeParameters(ITestContext context) {
     return ListUtils.get().toMultiArray(
              ParameterUtils.get().updateParametersAll(
                      ApplicationSourcesRepository.getFirefoxLocalhostCustomer(), context),
				AdminUserRepository.get().adminYaryna());
	 /*return new Object[][] {
			 { ParameterUtils.get().updateParametersAll(
			 ApplicationSourcesRepository.getFirefoxLocalhostCustomer(), context),
				 AdminUserRepository.get().adminYaryna() },
			 { ParameterUtils.get().updateParametersAll(
			 ApplicationSourcesRepository.getChromeLocalhostCustomer(), context),
				 AdminUserRepository.get().adminYaryna()}
			 };*/
  }

  @Test(dataProvider = "smokeParameters")
  public void testSignIn1(ApplicationSources applicationSources, IAdminUser adminUser) {
	  //Precondition
	  // Prepare our application
	  ApplicationCustomer applicationCustomer = ApplicationCustomer.get(applicationSources);
	  HomePageLogout homePageLogout = applicationCustomer.load();
	  // Test step
	  // 1. Confirm that home page is opened 
	  Assert.assertEquals(homePageLogout.getTitleText(), Titles.HOME_PAGE.toString());
	  // 2. Go to the signIn page 
	  SignInPage signInPage = homePageLogout.clickSignInLink();
	  // 3. Confirm that signIn page is opened
	  Assert.assertEquals(signInPage.getTitleText(), Titles.CUSTOMER_LOGIN.toString());
	  // 4. Successful log in user
	  // 5. Go to the AccountDashboard Page
	  AccountDashboardPage accountDashboardPage = signInPage.SignIn(CustomerUserRepository.get().UserYaryna());  
	  // 6. Confirm that AccountDashboard page is opened
	  Assert.assertEquals(accountDashboardPage.getTitleText(), 
			  Titles.ACCOUNT_DASHBOARD.toString());
	  // Return to the previous state
	  // Sign Out user
	  // Go to the home page
	  homePageLogout = accountDashboardPage.clickSignOutButton();
	  
  }
  @Test(dataProvider = "smokeParameters")
  public void testSignIn1_1(ApplicationSources applicationSources, IAdminUser adminUser) {
	  //Precondition
	  // Prepare our application
	  ApplicationCustomer applicationCustomer = ApplicationCustomer.get(applicationSources);
	  HomePageLogout homePageLogout = applicationCustomer.load();
	  // Test step
	  // 1. Confirm that home page is opened 
	  Assert.assertEquals(homePageLogout.getTitleText(), Titles.HOME_PAGE.toString());
	  // 2. Go to the signIn page 
	  SignInPage signInPage = homePageLogout.clickSignInLink();
	  // 3. Confirm that signIn page is opened
	  Assert.assertEquals(signInPage.getTitleText(), Titles.CUSTOMER_LOGIN.toString());
	  // 4. Successful log in user
	  // 5. Go to the AccountDashboard Page
	  AccountDashboardPage accountDashboardPage = signInPage.SignIn_Enter(CustomerUserRepository.get().UserYaryna());  
	  // 6. Confirm that AccountDashboard page is opened
	  Assert.assertEquals(accountDashboardPage.getTitleText(), 
			  Titles.ACCOUNT_DASHBOARD.toString());
	  // Return to the previous state
	  // Sign Out user
	  // Go to the home page
	  homePageLogout = accountDashboardPage.clickSignOutButton();
  }
  @Test(dataProvider = "smokeParameters")
  public void testSignIn2(ApplicationSources applicationSources, IAdminUser adminUser) {
	  //Precondition
	  // Prepare our application
	  ApplicationCustomer applicationCustomer = ApplicationCustomer.get(applicationSources);
	  HomePageLogout homePageLogout = applicationCustomer.load();
	  // Test step
	  // 1. Confirm that home page is opened 
	  Assert.assertEquals(homePageLogout.getTitleText(), Titles.HOME_PAGE.toString());
	  // 2. Go to the signIn page 
	  SignInPage signInPage = homePageLogout.clickSignInLink();
	  // 3. Confirm that signIn page is opened
	  Assert.assertEquals(signInPage.getTitleText(), Titles.CUSTOMER_LOGIN.toString());
	  // 4. Unsuccessful log in user
	  UnsuccessfulSignInPage unsuccessfulSignInPage = signInPage.
			  unsuccessfulSignIn(CustomerUserRepository.get().invalidUser()); 
	  // 5. Confirm that signIn page is still opened
	  Assert.assertEquals(unsuccessfulSignInPage.getTitleText(), 
			  Titles.CUSTOMER_LOGIN.toString());
	  // 6. Confirm that error message appear above sing in block 
	  // with right text 
	  Assert.assertEquals(unsuccessfulSignInPage.getErrorMessageText(),
			  ErrorMessageSignIn.INVALID_SIGNIN.toString());
	  // Return to the previous state
	  // Go to the home page
	  unsuccessfulSignInPage.clickLogo();
  }
  @Test(dataProvider = "smokeParameters")
  public void testCreateAccount1(ApplicationSources applicationSources, IAdminUser adminUser) throws InterruptedException {
	  //Precondition
	  // Prepare our application
	  ApplicationCustomer applicationCustomer = ApplicationCustomer.get(applicationSources);
	  HomePageLogout homePageLogout = applicationCustomer.load();
	  // Test step
	  // 1. Go to the signIn page
	  SignInPage signInPage = homePageLogout.clickSignInLink();
	  // 2. Go to the create account page
	  CreateAccountPage createAccountPage = signInPage.clickCreateAccountButton();
	  // 3. Confirm that create account page is opened
	  Assert.assertEquals(createAccountPage.getTitleText(),
			  Titles.CREATE_NEW_CUSTOMER_ACCOUNT.toString());
	  // 4. Successful create new account
	  // 5. Go to the account dashboard page
	  AccountDashboardPage accountDashboardPage = createAccountPage.createNewAccount
			  (CustomerUserRepository.get().newUser());
	  // 6. Confirm that account dashboard page is opened
	  Assert.assertEquals(accountDashboardPage.getTitleText(),
			  Titles.ACCOUNT_DASHBOARD.toString());
	  // 7. Sign Out user
	  homePageLogout = accountDashboardPage.clickSignOutButton();
	  // 8.Confirm that home page is opened after log out
	  Assert.assertEquals(homePageLogout.getTitleText(),
		  Titles.YOU_ARE_SIGNED_OUT.toString());
	  // 9.Confirm that currently created user can log in
	  signInPage = homePageLogout.clickSignInLink();
	  accountDashboardPage = signInPage.SignIn(CustomerUserRepository.get().newUser());
	  Assert.assertEquals(accountDashboardPage.getTitleText(),
			  Titles.ACCOUNT_DASHBOARD.toString());
	  // Return to the previous state
	  // 1. Sign Out user
	  accountDashboardPage.clickSignOutButton();
	  // 2. Go to the admin page
	  ApplicationAdmin applicationAdmin = ApplicationAdmin.get(ApplicationSourcesRepository.getFirefoxLocalhostAdmin());
	  // 3. Log in admin
	  // 4. Go to the all customer page
	  AllCustomersPage allCustomersPage = applicationAdmin.load()
			  .successAdminLogin(adminUser)
			  .gotoAllCustomersPage();
	  // 5. Delete currently created user
	  allCustomersPage = allCustomersPage.deleteCustomerUser(CustomerUserRepository.get().newUser());
	  // 6. Log out admin
	  allCustomersPage.clickSignOut();
	  
  }
  @Test(dataProvider = "smokeParameters")
  public void testCreateAccount2(ApplicationSources applicationSources, IAdminUser adminUser) {
	  //Precondition
	  // Prepare our application
	  ApplicationCustomer applicationCustomer = ApplicationCustomer.get(applicationSources);
	  HomePageLogout homePageLogout = applicationCustomer.load();
	  // Test steps
	  // 1.Unsuccessful create account already exist customer
	  Unsuccessful_CreateAccountPage unsuccessful_CreateAccountPage =
			  homePageLogout.clickCreateAccountLink().unsuccessful_createNewAccount(CustomerUserRepository.get().UserYaryna());
	  // 2.Confirm that error message appear with right text
	  Assert.assertEquals(unsuccessful_CreateAccountPage.getErrorMessageText(),
			  ErrorMessage.ALREADY_EXIST_ACCOUNT.toString());
	  // 3.Go to  the admin page
	  ApplicationAdmin applicationAdmin = ApplicationAdmin.get(ApplicationSourcesRepository.getFirefoxLocalhostAdmin());
	  // 4. Log in admin
	  // 5. Go to the all customer page
	  AllCustomersPage allCustomersPage = applicationAdmin.load()
			  .successAdminLogin(adminUser)
			  .gotoAllCustomersPage();
	  // 6. Confirm that already exist customer account is not created
	  Assert.assertFalse(allCustomersPage
			  .confirmAlreadyExistCustomerUserIsCreated(CustomerUserRepository.get().UserYaryna()));
	  // Return to the previous state
	  allCustomersPage.clickSignOut();
	  
  }
  
}