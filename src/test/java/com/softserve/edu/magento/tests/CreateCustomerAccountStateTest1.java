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
import com.softserve.edu.magento.pages.customer.components.Header.Titles;
import com.softserve.edu.magento.tools.ListUtils;
import com.softserve.edu.magento.tools.ParameterUtils;

public class CreateCustomerAccountStateTest1 extends TestBase{

	 @AfterMethod
	  public void afterMethod() {
		 TestCustomerUser.get().returnToPrevCreateAccount();
		 ApplicationCustomer.quitAll();
	  } 
	 @DataProvider 
	  public Object[][] ApplicationParameters(ITestContext context) {
	     return ListUtils.get().toMultiArrayNumber(
	    		 ParameterUtils.get().updateParametersAll(
	                      ApplicationSourcesRepository.getChromeLocalhostCustomer(), context),
	    		 UserParameters()
	    		 );

	  }
	 public List<ICustomerUser> UserParameters() {
			List<ICustomerUser> users = new ArrayList<ICustomerUser>();
			users.add(CustomerUserRepository.get().User_DT_PASSWORD1());
			return users;
	 }
	 
	 @Test(dataProvider = "ApplicationParameters")
	  public void testCreateNewAccount1(ApplicationSources applicationSources,ICustomerUser customerUser) {
		  //Precondition
		  // Prepare our application
		 TestCustomerUser.get().setCustomerUser(customerUser);
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
		  // 6. Sign Out user
		  homePageLogout = accountDashboardPage.clickSignOutButton();

	 }
	 
	 @Test(dataProvider = "ApplicationParameters")
	  public void testCreateNewAccount2(ApplicationSources applicationSources,ICustomerUser customerUser) {
		  //Precondition
		  // Prepare our application
		 TestCustomerUser.get().setCustomerUser(customerUser);
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
				  createAccountPage.unsuccessful_createNewAccount(CustomerUserRepository.get().UserYaryna());
		  // 4. Confirm that create account page is still open
		  Assert.assertEquals(unsuccessful_CreateAccountPage.getTitleText(),
				  Titles.CREATE_NEW_CUSTOMER_ACCOUNT.toString());
		  // 5. Confirm that error message is appear
		  Assert.assertEquals(unsuccessful_CreateAccountPage.getErrorMessageText(),
				  ErrorMessage.ALREADY_EXIST_ACCOUNT.toString());
		  // 6. Create new account
		  // 7. Go to the account dashboard page
		  AccountDashboardPage accountDashboardPage = unsuccessful_CreateAccountPage.createNewAccount(customerUser);
		  // 8. Confirm that account dashboard page is opened
		  Assert.assertEquals(accountDashboardPage.getTitleText(),
				  Titles.ACCOUNT_DASHBOARD.toString());
		  // 9. Sign Out user
		  homePageLogout = accountDashboardPage.clickSignOutButton();

	 }

	
	 

}
