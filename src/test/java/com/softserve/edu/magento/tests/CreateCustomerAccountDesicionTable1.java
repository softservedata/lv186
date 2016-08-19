package com.softserve.edu.magento.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.magento.data.ApplicationSources;
import com.softserve.edu.magento.data.ApplicationSourcesRepository;
import com.softserve.edu.magento.data.admin.AdminUserRepository;
import com.softserve.edu.magento.data.admin.IAdminUser;
import com.softserve.edu.magento.data.customer.user.CustomerUserRepository;
import com.softserve.edu.magento.data.customer.user.ICustomerUser;
import com.softserve.edu.magento.pages.admin.ApplicationAdmin;
import com.softserve.edu.magento.pages.admin.menu.customers.AllCustomersPage;
import com.softserve.edu.magento.pages.customer.AccountDashboardPage;
import com.softserve.edu.magento.pages.customer.ApplicationCustomer;
import com.softserve.edu.magento.pages.customer.CreateAccountPage;
import com.softserve.edu.magento.pages.customer.HomePageLogout;
import com.softserve.edu.magento.pages.customer.UnsuccessfulSignInPage;
import com.softserve.edu.magento.pages.customer.UnsuccessfulSignInPage.ErrorMessageSignIn;
import com.softserve.edu.magento.pages.customer.UnsuccessfulSignInPage.ErrorValidatorNameSingIn;
import com.softserve.edu.magento.pages.customer.Unsuccessful_CreateAccountPage;
import com.softserve.edu.magento.pages.customer.Unsuccessful_CreateAccountPage.ErrorMessage;
import com.softserve.edu.magento.pages.customer.Unsuccessful_CreateAccountPage.ErrorValidatorName;
import com.softserve.edu.magento.pages.customer.components.Header.Titles;
import com.softserve.edu.magento.tools.ListUtils;
import com.softserve.edu.magento.tools.ParameterUtils;

public class CreateCustomerAccountDesicionTable1 extends TestBase{
 
	 @DataProvider 
	  public Object[][] ApplicationParameters(ITestContext context) {
	     return new Object[][]{
				 {ParameterUtils.get().updateParametersAll(
						 ApplicationSourcesRepository.getChromeLocalhostCustomer(), context),
				 AdminUserRepository.get().adminYaryna()}
		 };

	  }
	 @AfterMethod
	  public void afterMethod() {
		 TestCustomerUser.get().returnToPrevCreateAccount();
		  ApplicationCustomer.quitAll();
	  } 
	 
	 @Test(dataProvider = "ApplicationParameters")
	  public void testCreateNewAccount1(ApplicationSources applicationSources,IAdminUser adminUser) {
		 ICustomerUser customerUser = CustomerUserRepository.get().User_DT1();
		 TestCustomerUser.get().setCustomerUser(customerUser);
		  //Precondition
		  // Prepare our application
		  ApplicationCustomer applicationCustomer = ApplicationCustomer.get(applicationSources);
		  HomePageLogout homePageLogout = applicationCustomer.load();
		  // Test step
		  // 1. Go to the create account page
		  CreateAccountPage createAccountPage = homePageLogout.clickCreateAccountLink();
		  // 2. Confirm that create account page is open
		  Assert.assertEquals(createAccountPage.getTitleText(), Titles.CREATE_NEW_CUSTOMER_ACCOUNT.toString());
		  // 2. Create new account
		  // 3. Successful create new account
		  // 4. Go to the account dashboard page
		  AccountDashboardPage accountDashboardPage = createAccountPage.createNewAccount(customerUser);
		  // 5. Confirm that account dashboard page is opened
		  Assert.assertEquals(accountDashboardPage.getTitleText(),
				  Titles.ACCOUNT_DASHBOARD.toString());
		  Assert.assertTrue(accountDashboardPage.confirmAccountInfCorrect(customerUser));
		  // 6. Sign Out user
		  homePageLogout = accountDashboardPage.clickSignOutButton();
		  // 7.Confirm that currently created user can log in
		  accountDashboardPage = homePageLogout.clickSignInLink().SignIn(customerUser);
		  Assert.assertEquals(accountDashboardPage.getTitleText(),
				  Titles.ACCOUNT_DASHBOARD.toString());
		  // 8.Go to  the admin page
		  ApplicationAdmin applicationAdmin = ApplicationAdmin.get(ApplicationSourcesRepository.getChromeLocalhostMacAdmin());
		  // 9. Log in admin
		  // 10. Go to the all customer page
		  AllCustomersPage allCustomersPage = applicationAdmin.load()
				  .successAdminLogin(adminUser)
				  .gotoAllCustomersPage();
		  Assert.assertTrue(allCustomersPage.confirmCustomerUserIsCreated(customerUser));
		 applicationAdmin.logout();
	 }
	 
	 @Test(dataProvider = "ApplicationParameters")
	  public void testCreateNewAccount2(ApplicationSources applicationSources,IAdminUser adminUser) {
		 ICustomerUser customerUser = CustomerUserRepository.get().User_DT2();
		 TestCustomerUser.get().setCustomerUser(customerUser);
		 //Precondition
		  // Prepare our application
		  ApplicationCustomer applicationCustomer = ApplicationCustomer.get(applicationSources);
		  HomePageLogout homePageLogout = applicationCustomer.load();
		  // Test step
		  // 1. Go to the create account page
		  CreateAccountPage createAccountPage = homePageLogout.clickCreateAccountLink();
		  // 2. Confirm that create account page is open
		  Assert.assertEquals(createAccountPage.getTitleText(),
				  Titles.CREATE_NEW_CUSTOMER_ACCOUNT.toString());
		  // 3. Unsuccessful create new account
		  Unsuccessful_CreateAccountPage unsuccessful_CreateAccountPage = 
				  createAccountPage.unsuccessful_createNewAccount(customerUser);
		  // 4. Confirm that create account page is still open
		  Assert.assertEquals(unsuccessful_CreateAccountPage.getTitleText(),
				  Titles.CREATE_NEW_CUSTOMER_ACCOUNT.toString());
		  // 5. Confirm that error message is appear
		  Assert.assertEquals(unsuccessful_CreateAccountPage.getErrorValidatorText(ErrorValidatorName.CONFIRMPASSWORD),
				  ErrorMessage.PASSWORDS_IS_NOT_THE_SAME.toString());
		  // 6. try to Sign in user
		  UnsuccessfulSignInPage unsuccessfulSignInPage = unsuccessful_CreateAccountPage.clickSignInLink()
				  .unsuccessfulSignIn(customerUser);
		  // 7.Confirm that invalid user not sign in and error message is appear
		  Assert.assertEquals(unsuccessfulSignInPage.getErrorMessageText(),
				  ErrorMessageSignIn.INVALID_SIGNIN.toString());
		  // 8.Go to  the admin page and confirm that invalid user is not created 
		  ApplicationAdmin applicationAdmin = ApplicationAdmin.get(ApplicationSourcesRepository.getChromeLocalhostMacAdmin());
		  AllCustomersPage allCustomersPage = applicationAdmin.load()
				  .successAdminLogin(adminUser)
				  .gotoAllCustomersPage();
		  Assert.assertFalse(allCustomersPage.confirmCustomerUserIsCreated(customerUser));
		 applicationAdmin.logout();
	 }
	 @Test(dataProvider = "ApplicationParameters")
	  public void testCreateNewAccount3(ApplicationSources applicationSources,IAdminUser adminUser) {
		 ICustomerUser customerUser = CustomerUserRepository.get().User_DT3();
		 TestCustomerUser.get().setCustomerUser(customerUser);
		 //Precondition
		  // Prepare our application
		  ApplicationCustomer applicationCustomer = ApplicationCustomer.get(applicationSources);
		  HomePageLogout homePageLogout = applicationCustomer.load();
		  // Test step
		  // 1. Go to the create account page
		  CreateAccountPage createAccountPage = homePageLogout.clickCreateAccountLink();
		  // 2. Confirm that create account page is open
		  Assert.assertEquals(createAccountPage.getTitleText(),
				  Titles.CREATE_NEW_CUSTOMER_ACCOUNT.toString());
		  // 3. Unsuccessful create new account
		  Unsuccessful_CreateAccountPage unsuccessful_CreateAccountPage = 
				  createAccountPage.unsuccessful_createNewAccount(customerUser);
		  // 4. Confirm that create account page is still open
		  Assert.assertEquals(unsuccessful_CreateAccountPage.getTitleText(),
				  Titles.CREATE_NEW_CUSTOMER_ACCOUNT.toString());
		  // 5. Confirm that error message is appear
		  Assert.assertEquals(unsuccessful_CreateAccountPage.getErrorValidatorText(ErrorValidatorName.EMAIL),
				  ErrorMessage.ERROR_EMAIL_FORMAT.toString());
		  // 6. try to Sign in user
		  UnsuccessfulSignInPage unsuccessfulSignInPage = unsuccessful_CreateAccountPage.clickSignInLink()
				  .unsuccessfulSignIn(customerUser);
		  // 7.Confirm that invalid user not sign in and error message is appear
		  Assert.assertEquals(unsuccessfulSignInPage.getErrorValidatorText(ErrorValidatorNameSingIn.EMAIL),
				  ErrorMessageSignIn.ERROR_EMAIL_FORMATT.toString());
		  // 8.Go to  the admin page and confirm that invalid user is not created
		  ApplicationAdmin applicationAdmin = ApplicationAdmin.get(ApplicationSourcesRepository.getChromeLocalhostMacAdmin());
		  AllCustomersPage allCustomersPage = applicationAdmin.load()
				  .successAdminLogin(adminUser)
				  .gotoAllCustomersPage();
		  Assert.assertFalse(allCustomersPage.confirmCustomerUserIsCreated(customerUser));
		 applicationAdmin.logout();
	 }
	 //@Test(dataProvider = "ApplicationParameters")
	  public void testCreateNewAccount4(ApplicationSources applicationSources,IAdminUser adminUser) {
		 ICustomerUser customerUser = CustomerUserRepository.get().User_DT4();
		  TestCustomerUser.get().setCustomerUser(customerUser);
		 //Precondition
		  // Prepare our application
		  ApplicationCustomer applicationCustomer = ApplicationCustomer.get(applicationSources);
		  HomePageLogout homePageLogout = applicationCustomer.load();
		  // Test step
		  // 1. Go to the create account page
		  CreateAccountPage createAccountPage = homePageLogout.clickCreateAccountLink();
		  // 2. Confirm that create account page is open
		  Assert.assertEquals(createAccountPage.getTitleText(),
				  Titles.CREATE_NEW_CUSTOMER_ACCOUNT.toString());
		  // 3. Unsuccessful create new account
		  Unsuccessful_CreateAccountPage unsuccessful_CreateAccountPage = 
				  createAccountPage.unsuccessful_createNewAccount(customerUser);
		  // 4. Confirm that create account page is still open
		  Assert.assertEquals(unsuccessful_CreateAccountPage.getTitleText(),
				  Titles.CREATE_NEW_CUSTOMER_ACCOUNT.toString());
		  // 5. Confirm that error message is appear
		  Assert.assertEquals(unsuccessful_CreateAccountPage.getErrorValidatorText(ErrorValidatorName.EMAIL),
				  ErrorMessage.ERROR_EMAIL_FORMAT.toString());
		  Assert.assertEquals(unsuccessful_CreateAccountPage.getErrorValidatorText(ErrorValidatorName.CONFIRMPASSWORD),
				  ErrorMessage.PASSWORDS_IS_NOT_THE_SAME.toString());
		  // 6. try to Sign in user
		  UnsuccessfulSignInPage unsuccessfulSignInPage = unsuccessful_CreateAccountPage.clickSignInLink()
				  .unsuccessfulSignIn(customerUser);
		  // 7.Confirm that invalid user not sign in and error message is appear
		  Assert.assertEquals(unsuccessfulSignInPage.getErrorMessageText(),
				  ErrorMessageSignIn.INVALID_SIGNIN);
		  // 8.Go to  the admin page and confirm that invalid user is not created 
		  ApplicationAdmin applicationAdmin = ApplicationAdmin.get(ApplicationSourcesRepository.getChromeLocalhostMacAdmin());
		  AllCustomersPage allCustomersPage = applicationAdmin.load()
				  .successAdminLogin(adminUser)
				  .gotoAllCustomersPage();
		  Assert.assertFalse(allCustomersPage.confirmCustomerUserIsCreated(customerUser));
		  // Return to the previous state
		  // 1. Log out admin
		  applicationAdmin.logout();
	 }
	 //@Test(dataProvider = "ApplicationParameters")
	  public void testCreateNewAccount5(ApplicationSources applicationSources,IAdminUser adminUser) {
		 ICustomerUser customerUser = CustomerUserRepository.get().User_DT5();
		  TestCustomerUser.get().setCustomerUser(customerUser);
		 //Precondition
		  // Prepare our application
		  ApplicationCustomer applicationCustomer = ApplicationCustomer.get(applicationSources);
		  HomePageLogout homePageLogout = applicationCustomer.load();
		  // Test step
		  // 1. Go to the create account page
		  CreateAccountPage createAccountPage = homePageLogout.clickCreateAccountLink();
		  // 2. Confirm that create account page is open
		  Assert.assertEquals(createAccountPage.getTitleText(),
				  Titles.CREATE_NEW_CUSTOMER_ACCOUNT.toString());
		  // 3. Unsuccessful create new account
		  Unsuccessful_CreateAccountPage unsuccessful_CreateAccountPage = 
				  createAccountPage.unsuccessful_createNewAccount(customerUser);
		  // 4. Confirm that create account page is still open
		  Assert.assertEquals(unsuccessful_CreateAccountPage.getTitleText(),
				  Titles.CREATE_NEW_CUSTOMER_ACCOUNT.toString());
		  // 5. Confirm that error message is appear
		  Assert.assertEquals(unsuccessful_CreateAccountPage.getErrorValidatorText(ErrorValidatorName.FIRSTNAME),
				  ErrorMessage.FIELD_IS_REQUIRED.toString());
		  Assert.assertEquals(unsuccessful_CreateAccountPage.getErrorValidatorText(ErrorValidatorName.LASTNAME),
				  ErrorMessage.FIELD_IS_REQUIRED.toString());
		  Assert.assertEquals(unsuccessful_CreateAccountPage.getErrorValidatorText(ErrorValidatorName.EMAIL),
				  ErrorMessage.FIELD_IS_REQUIRED.toString());
		  Assert.assertEquals(unsuccessful_CreateAccountPage.getErrorValidatorText(ErrorValidatorName.PASSWORD),
				  ErrorMessage.FIELD_IS_REQUIRED.toString());
		  Assert.assertEquals(unsuccessful_CreateAccountPage.getErrorValidatorText(ErrorValidatorName.CONFIRMPASSWORD),
				  ErrorMessage.FIELD_IS_REQUIRED.toString());
		  
		  // 6.Go to  the admin page and confirm that invalid user is not created 
		  ApplicationAdmin applicationAdmin = ApplicationAdmin.get(ApplicationSourcesRepository.getChromeLocalhostMacAdmin());
		  AllCustomersPage allCustomersPage = applicationAdmin.load()
				  .successAdminLogin(adminUser)
				  .gotoAllCustomersPage();
		  Assert.assertFalse(allCustomersPage.confirmCustomerUserIsCreated(customerUser));
		  applicationAdmin.logout();
	 }
	 //@Test(dataProvider = "ApplicationParameters")
	  public void testCreateNewAccount6(ApplicationSources applicationSources,IAdminUser adminUser) {
		 ICustomerUser customerUser = CustomerUserRepository.get().User_DT6();
		  TestCustomerUser.get().setCustomerUser(customerUser);
		 //Precondition
		  // Prepare our application
		  ApplicationCustomer applicationCustomer = ApplicationCustomer.get(applicationSources);
		  HomePageLogout homePageLogout = applicationCustomer.load();
		  // Test step
		  // 1. Go to the create account page
		  CreateAccountPage createAccountPage = homePageLogout.clickCreateAccountLink();
		  // 2. Confirm that create account page is open
		  Assert.assertEquals(createAccountPage.getTitleText(),
				  Titles.CREATE_NEW_CUSTOMER_ACCOUNT.toString());
		  // 3. Unsuccessful create new account
		  Unsuccessful_CreateAccountPage unsuccessful_CreateAccountPage = 
				  createAccountPage.unsuccessful_createNewAccount(customerUser);
		  // 4. Confirm that create account page is still open
		  Assert.assertEquals(unsuccessful_CreateAccountPage.getTitleText(),
				  Titles.CREATE_NEW_CUSTOMER_ACCOUNT.toString());
		  // 5. Confirm that error message is appear
		  Assert.assertEquals(unsuccessful_CreateAccountPage.getErrorValidatorText(ErrorValidatorName.LASTNAME),
				  ErrorMessage.FIELD_IS_REQUIRED.toString());
		  Assert.assertEquals(unsuccessful_CreateAccountPage.getErrorValidatorText(ErrorValidatorName.CONFIRMPASSWORD),
				  ErrorMessage.FIELD_IS_REQUIRED.toString());
		  // 6. try to Sign in user
		  UnsuccessfulSignInPage unsuccessfulSignInPage = unsuccessful_CreateAccountPage.clickSignInLink()
				  .unsuccessfulSignIn(customerUser);
		  // 7.Confirm that invalid user not sign in and error message is appear
		  Assert.assertEquals(unsuccessfulSignInPage.getErrorMessageText(),
				  ErrorMessageSignIn.INVALID_SIGNIN.toString());
		  // 8.Go to  the admin page and confirm that invalid user is not created 
		  ApplicationAdmin applicationAdmin = ApplicationAdmin.get(ApplicationSourcesRepository.getChromeLocalhostMacAdmin());
		  AllCustomersPage allCustomersPage = applicationAdmin.load()
				  .successAdminLogin(adminUser)
				  .gotoAllCustomersPage();
		  Assert.assertFalse(allCustomersPage.confirmCustomerUserIsCreated(customerUser));
		  applicationAdmin.logout();
	 }
	 //@Test(dataProvider = "ApplicationParameters")
	  public void testCreateNewAccount7(ApplicationSources applicationSources,IAdminUser adminUser) {
		 ICustomerUser customerUser = CustomerUserRepository.get().User_DT7();
		  TestCustomerUser.get().setCustomerUser(customerUser);
		 //Precondition
		  // Prepare our application
		  ApplicationCustomer applicationCustomer = ApplicationCustomer.get(applicationSources);
		  HomePageLogout homePageLogout = applicationCustomer.load();
		  // Test step
		  // 1. Go to the create account page
		  CreateAccountPage createAccountPage = homePageLogout.clickCreateAccountLink();
		  // 2. Confirm that create account page is open
		  Assert.assertEquals(createAccountPage.getTitleText(),
				  Titles.CREATE_NEW_CUSTOMER_ACCOUNT.toString());
		  // 3. Unsuccessful create new account
		  Unsuccessful_CreateAccountPage unsuccessful_CreateAccountPage = 
				  createAccountPage.unsuccessful_createNewAccount(customerUser);
		  // 4. Confirm that create account page is still open
		  Assert.assertEquals(unsuccessful_CreateAccountPage.getTitleText(),
				  Titles.CREATE_NEW_CUSTOMER_ACCOUNT.toString());
		  // 5. Confirm that error message is appear
		  Assert.assertEquals(unsuccessful_CreateAccountPage.getErrorValidatorText(ErrorValidatorName.EMAIL),
				  ErrorMessage.FIELD_IS_REQUIRED.toString());
		  
		  // 6.Go to  the admin page and confirm that invalid user is not created 
		  ApplicationAdmin applicationAdmin = ApplicationAdmin.get(ApplicationSourcesRepository.getChromeLocalhostMacAdmin());
		  AllCustomersPage allCustomersPage = applicationAdmin.load()
				  .successAdminLogin(adminUser)
				  .gotoAllCustomersPage();
		  Assert.assertFalse(allCustomersPage.confirmCustomerUserIsCreated(customerUser));
		  applicationAdmin.logout();
	 }
	 //@Test(dataProvider = "ApplicationParameters")
	  public void testCreateNewAccount8(ApplicationSources applicationSources, IAdminUser adminUser) {
		  ICustomerUser customerUser = CustomerUserRepository.get().User_DT8();
		  TestCustomerUser.get().setCustomerUser(customerUser);
		  //Precondition
		  // Prepare our application
		  ApplicationCustomer applicationCustomer = ApplicationCustomer.get(applicationSources);
		  HomePageLogout homePageLogout = applicationCustomer.load();
		  // Test steps
		  // 1.Unsuccessful create account already exist customer
		  Unsuccessful_CreateAccountPage unsuccessful_CreateAccountPage =
				  homePageLogout.clickCreateAccountLink().unsuccessful_createNewAccount(customerUser);
		  // 2.Confirm that error message appear with right text
		  Assert.assertEquals(unsuccessful_CreateAccountPage.getErrorMessageText(),
				  ErrorMessage.ALREADY_EXIST_ACCOUNT.toString());
		  // 3.Go to  the admin page and confirm that invalid user is not created 
		  ApplicationAdmin applicationAdmin = ApplicationAdmin.get(ApplicationSourcesRepository.getChromeLocalhostMacAdmin());
		  AllCustomersPage allCustomersPage = applicationAdmin.load()
				  .successAdminLogin(adminUser)
				  .gotoAllCustomersPage();
		  Assert.assertFalse(allCustomersPage
				  .confirmAlreadyExistCustomerUserIsCreated(customerUser));
		  allCustomersPage.clickSignOut();  
	  }
	@Test(dataProvider = "ApplicationParameters")
	public void testCreateNewAccount10(ApplicationSources applicationSources, IAdminUser adminUser) {

		ICustomerUser customerUser = CustomerUserRepository.get().User_DT10();
		TestCustomerUser.get().setCustomerUser(customerUser);

		ApplicationCustomer applicationCustomer = ApplicationCustomer.get(applicationSources);
		HomePageLogout homePageLogout = applicationCustomer.load();
		CreateAccountPage createAccountPage = homePageLogout.clickCreateAccountLink();

		Assert.assertEquals(createAccountPage.getTitleText(), Titles.CREATE_NEW_CUSTOMER_ACCOUNT.toString());

		AccountDashboardPage accountDashboardPage = createAccountPage.createNewAccount(customerUser);

		Assert.assertEquals(accountDashboardPage.getTitleText(),
				Titles.ACCOUNT_DASHBOARD.toString());
		Assert.assertTrue(accountDashboardPage.confirmAccountInfCorrect(customerUser));

		homePageLogout = accountDashboardPage.clickSignOutButton();
		accountDashboardPage = homePageLogout.clickSignInLink().SignIn(customerUser);
		Assert.assertEquals(accountDashboardPage.getTitleText(),
				Titles.ACCOUNT_DASHBOARD.toString());
		ApplicationAdmin applicationAdmin = ApplicationAdmin.get(ApplicationSourcesRepository.getChromeLocalhostMacAdmin());
		AllCustomersPage allCustomersPage = applicationAdmin.load()
				.successAdminLogin(adminUser)
				.gotoAllCustomersPage();
		Assert.assertTrue(allCustomersPage.confirmCustomerUserIsCreated(customerUser));
		applicationAdmin.logout();
	}

}
