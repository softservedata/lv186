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
import com.softserve.edu.magento.data.customer.user.CustomerUserRepository;
import com.softserve.edu.magento.data.customer.user.ICustomerUser;
import com.softserve.edu.magento.pages.admin.ApplicationAdmin;
import com.softserve.edu.magento.pages.admin.menu.customers.AllCustomersPage;
import com.softserve.edu.magento.pages.customer.AccountDashboardPage;
import com.softserve.edu.magento.pages.customer.ApplicationCustomer;
import com.softserve.edu.magento.pages.customer.CreateAccountPage;
import com.softserve.edu.magento.pages.customer.HomePageLogout;
import com.softserve.edu.magento.pages.customer.Unsuccessful_CreateAccountPage;
import com.softserve.edu.magento.pages.customer.Unsuccessful_CreateAccountPage.ErrorMessage;
import com.softserve.edu.magento.pages.customer.Unsuccessful_CreateAccountPage.ErrorValidatorName;
import com.softserve.edu.magento.pages.customer.components.Header.Titles;
import com.softserve.edu.magento.tools.ListUtils;
import com.softserve.edu.magento.tools.ParameterUtils;

public class CreateCustomerAccountFieldsTest3 extends TestBase{

	 @AfterMethod
	  public void afterMethod() {
		 TestCustomerUser.get().returnToPrevCreateAccount();
	 	ApplicationCustomer.quitAll();
	  }
	 @DataProvider 
	  public Object[][] ApplicationParametersUnSuccess(ITestContext context) {
	     return ListUtils.get().toMultiArrayNumber(
	    		 ParameterUtils.get().updateParametersAll(
	                      ApplicationSourcesRepository.getChromeLocalhostCustomer(), context),
	    		 UserParametersUnSuccess()
	    		 );

	  }
	 public List<ICustomerUser> UserParametersUnSuccess() {
			List<ICustomerUser> users = new ArrayList<ICustomerUser>();
			users.add(CustomerUserRepository.get().User_BV1());
			users.add(CustomerUserRepository.get().User_BV3());
			//users.add(CustomerUserRepository.get().User_BV3());
			//users.add(CustomerUserRepository.get().User_BV4());
			return users;
	 }

	 @Test(dataProvider = "ApplicationParametersUnSuccess")
	  public void testCreateNewAccount1(ApplicationSources applicationSources,ICustomerUser customerUser) {
		  //Precondition
		  // Prepare our application
		  ApplicationCustomer applicationCustomer = ApplicationCustomer.get(applicationSources);
		  HomePageLogout homePageLogout = applicationCustomer.load();
		 TestCustomerUser.get().setCustomerUser(customerUser);
		  // Test step
		  // 1. Go to the create account page
		  CreateAccountPage createAccountPage = homePageLogout.clickCreateAccountLink();
		  // 2. Create new account
		  Unsuccessful_CreateAccountPage unsuccessful_CreateAccountPage = 
				  createAccountPage.unsuccessful_createNewAccount(customerUser);
		  // 3.Confirm that error message appear with right text
		  Assert.assertTrue(unsuccessful_CreateAccountPage.isErrorValidator(ErrorValidatorName.PASSWORD));
		  Assert.assertEquals(unsuccessful_CreateAccountPage.getErrorValidatorText(ErrorValidatorName.PASSWORD),
				  ErrorMessage.ERROR_PASSWORD_FORMAT_MIN_LENGHT.toString());
		  // 4.Go to  the admin page
		  ApplicationAdmin applicationAdmin = ApplicationAdmin.get(ApplicationSourcesRepository.getChromeLocalhostMacAdmin());
		  // 5. Log in admin
		  // 6. Go to the all customer page
		  AllCustomersPage allCustomersPage = applicationAdmin.load()
				  .successAdminLogin(AdminUserRepository.get().adminYaryna())
				  .gotoAllCustomersPage();
		  // 7. Confirm that already exist customer account is not created
		  Assert.assertFalse(allCustomersPage.confirmCustomerUserIsCreated(customerUser));
		  // Return to the previous state
		 applicationAdmin.logout();
	 }
	 @DataProvider 
	  public Object[][] ApplicationParametersUnSuccess2(ITestContext context) {
	     return ListUtils.get().toMultiArray(
	    		 ParameterUtils.get().updateParametersAll(
	                      ApplicationSourcesRepository.getChromeLocalhostCustomer(), context),
	    		 CustomerUserRepository.get().User_BV2()
	    		 );

	  }
	 @Test(dataProvider = "ApplicationParametersUnSuccess2")
	  public void testCreateNewAccount2(ApplicationSources applicationSources,ICustomerUser customerUser) {
		  //Precondition
		  // Prepare our application
		  ApplicationCustomer applicationCustomer = ApplicationCustomer.get(applicationSources);
		  HomePageLogout homePageLogout = applicationCustomer.load();
		 TestCustomerUser.get().setCustomerUser(customerUser);
		  // Test step
		  // 1. Go to the create account page
		  CreateAccountPage createAccountPage = homePageLogout.clickCreateAccountLink();
		  // 2. Create new account
		  Unsuccessful_CreateAccountPage unsuccessful_CreateAccountPage = 
				  createAccountPage.unsuccessful_createNewAccount(customerUser);
		  // 3.Confirm that error message appear with right text
		  Assert.assertTrue(unsuccessful_CreateAccountPage.isErrorValidator(ErrorValidatorName.PASSWORD));
		  Assert.assertEquals(unsuccessful_CreateAccountPage.getErrorValidatorText(ErrorValidatorName.PASSWORD),
				  ErrorMessage.FIELD_IS_REQUIRED.toString());
		  // 4.Go to  the admin page
		  ApplicationAdmin applicationAdmin = ApplicationAdmin.get(ApplicationSourcesRepository.getChromeLocalhostMacAdmin());
		  // 5. Log in admin
		  // 6. Go to the all customer page
		  AllCustomersPage allCustomersPage = applicationAdmin.load()
				  .successAdminLogin(AdminUserRepository.get().adminYaryna())
				  .gotoAllCustomersPage();
		  // 7. Confirm that already exist customer account is not created
		  Assert.assertFalse(allCustomersPage.confirmCustomerUserIsCreated(customerUser));
		  // Return to the previous state
		 applicationAdmin.logout();
	 }
	 
	 @DataProvider 
	  public Object[][] ApplicationParametersSuccess(ITestContext context) {
	     return ListUtils.get().toMultiArrayNumber(
	    		 ParameterUtils.get().updateParametersAll(
	                      ApplicationSourcesRepository.getChromeLocalhostCustomer(), context),
	    		 UserParametersSuccess()
	    		 );

	  }
	 public List<ICustomerUser> UserParametersSuccess() {
			List<ICustomerUser> users = new ArrayList<ICustomerUser>();
			users.add(CustomerUserRepository.get().User_BV4());
			return users;
	 }
	 
	 @Test(dataProvider = "ApplicationParametersSuccess")
	  public void testCreateNewAccount3(ApplicationSources applicationSources,ICustomerUser customerUser) {
		  //Precondition
		  // Prepare our application
		  ApplicationCustomer applicationCustomer = ApplicationCustomer.get(applicationSources);
		  HomePageLogout homePageLogout = applicationCustomer.load();
		 TestCustomerUser.get().setCustomerUser(customerUser);
		  // Test step
		  // 1. Go to the create account page
		  CreateAccountPage createAccountPage = homePageLogout.clickCreateAccountLink();
		  // 2. Create new account
		  // 3. Successful create new account
		  // 4. Go to the account dashboard page
		  AccountDashboardPage accountDashboardPage = createAccountPage.createNewAccount(customerUser);
		  // 5. Confirm that account dashboard page is opened
		  Assert.assertEquals(accountDashboardPage.getTitleText(),
				  Titles.ACCOUNT_DASHBOARD.toString());
		  // 6. Sign Out user
		  accountDashboardPage.clickSignOutButton();
		  // 7.Go to  the admin page
		  ApplicationAdmin applicationAdmin = ApplicationAdmin.get(ApplicationSourcesRepository.getChromeLocalhostMacAdmin());
		  // 8. Log in admin
		  // 9. Go to the all customer page
		  AllCustomersPage allCustomersPage = applicationAdmin.load()
				  .successAdminLogin(AdminUserRepository.get().adminYaryna())
				  .gotoAllCustomersPage();
		  // 10. Confirm that already exist customer account is created
		  Assert.assertTrue(allCustomersPage.confirmCustomerUserIsCreated(customerUser));
		 applicationAdmin.logout();
	 }

	
	 

}
