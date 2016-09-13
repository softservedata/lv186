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
import com.softserve.edu.magento.pages.customer.ApplicationCustomer;
import com.softserve.edu.magento.pages.customer.CreateAccountPage;
import com.softserve.edu.magento.pages.customer.HomePageLogout;
import com.softserve.edu.magento.pages.customer.Unsuccessful_CreateAccountPage;
import com.softserve.edu.magento.pages.customer.Unsuccessful_CreateAccountPage.ErrorValidatorName;
import com.softserve.edu.magento.tools.ListUtils;
import com.softserve.edu.magento.tools.ParameterUtils;
import ss.af.reporting.annotations.ServiceReport;

public class CreateCustomerAccountFieldsTest1 extends TestBase{

	 @AfterMethod
	  public void afterMethod() {
		 TestCustomerUser.get().returnToPrevCreateAccount();
		  ApplicationCustomer.quitAll();
	  }
	 @DataProvider 
	  public Object[][] ApplicationParametersSpeshialSymb(ITestContext context) {
		 return ListUtils.get().toMultiArrayNumber(
				 ParameterUtils.get().updateParametersAll(
						 ApplicationSourcesRepository.getChromeLocalhostCustomer(), context),
				 UserParametersSpeshialSymb()
		 );

	  }
	public List<ICustomerUser> UserParametersSpeshialSymb() {
		List<ICustomerUser> users = new ArrayList<ICustomerUser>();
		/*users.add(CustomerUserRepository.get().User_Special_Symb1());
		users.add(CustomerUserRepository.get().User_Special_Symb1_1());
		users.add(CustomerUserRepository.get().User_Special_Symb2());
		users.add(CustomerUserRepository.get().User_Special_Symb3());
		users.add(CustomerUserRepository.get().User_Special_Symb4());
		users.add(CustomerUserRepository.get().User_Special_Symb5());
		users.add(CustomerUserRepository.get().User_Special_Symb6());
		users.add(CustomerUserRepository.get().User_Special_Symb7());
		users.add(CustomerUserRepository.get().User_Special_Symb8());
		users.add(CustomerUserRepository.get().User_Special_Symb9());
		users.add(CustomerUserRepository.get().User_Special_Symb10());
		users.add(CustomerUserRepository.get().User_Special_Symb11());
		users.add(CustomerUserRepository.get().User_Special_Symb12());
		users.add(CustomerUserRepository.get().User_Special_Symb13());
		users.add(CustomerUserRepository.get().User_Special_Symb14());*/
		users.add(CustomerUserRepository.get().User_Special_Symb15());
		//users.add(CustomerUserRepository.get().User_Special_Symb16());
		return users;
			 
	}

	
	 @Test(dataProvider = "ApplicationParametersSpeshialSymb")
	 @ServiceReport
	  public void testCreateNewAccount1(ApplicationSources applicationSources, ICustomerUser customerUser) {
		  //Precondition
		  // Prepare our application
		 TestCustomerUser.get().setCustomerUser(customerUser);
		  ApplicationCustomer applicationCustomer = ApplicationCustomer.get(applicationSources);
		  HomePageLogout homePageLogout = applicationCustomer.load();
		  // Test step
		  // 1. Go to the create account page
		  CreateAccountPage createAccountPage = homePageLogout.clickCreateAccountLink();
		  // 2. Create new account
		  Unsuccessful_CreateAccountPage unsuccessful_CreateAccountPage = 
				  createAccountPage.unsuccessful_createNewAccount(customerUser);
		  // 3.Confirm that error message appear with right text
		  Assert.assertFalse(unsuccessful_CreateAccountPage.isErrorValidator(ErrorValidatorName.FIRSTNAME));
		  Assert.assertFalse(unsuccessful_CreateAccountPage.isErrorValidator(ErrorValidatorName.LASTNAME));
		 Assert.assertFalse(unsuccessful_CreateAccountPage.isErrorValidator(ErrorValidatorName.PASSWORD));
		  Assert.assertTrue(unsuccessful_CreateAccountPage.isErrorValidator(ErrorValidatorName.EMAIL));
		  // 4.Go to  the admin page
		  ApplicationAdmin applicationAdmin = ApplicationAdmin.get(ApplicationSourcesRepository.getChromeLocalhostMacAdmin());
		  // 5. Log in admin
		  // 6. Go to the all customer page
		  AllCustomersPage allCustomersPage = applicationAdmin.load()
				  .successAdminLogin(AdminUserRepository.get().adminYaryna())
				  .gotoAllCustomersPage();
		  // 7. Confirm that already exist customer account is not created
//		  Assert.assertFalse(allCustomersPage.confirmCustomerUserIsCreated(customerUser));
		  // Return to the previous state
		  allCustomersPage.clickSignOut();
	 }
	 

}
