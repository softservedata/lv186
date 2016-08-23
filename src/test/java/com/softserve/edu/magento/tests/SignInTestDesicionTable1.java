package com.softserve.edu.magento.tests;


import com.softserve.edu.magento.data.ApplicationSources;
import com.softserve.edu.magento.data.ApplicationSourcesRepository;
import com.softserve.edu.magento.data.admin.AdminUserRepository;
import com.softserve.edu.magento.data.admin.IAdminUser;
import com.softserve.edu.magento.data.customer.user.CustomerUserRepository;
import com.softserve.edu.magento.pages.admin.ApplicationAdmin;
import com.softserve.edu.magento.pages.admin.menu.customers.AllCustomersPage;
import com.softserve.edu.magento.pages.customer.*;
import com.softserve.edu.magento.pages.customer.UnsuccessfulSignInPage.ErrorMessageSignIn;
import com.softserve.edu.magento.pages.customer.UnsuccessfulSignInPage.ErrorValidatorNameSingIn;
import com.softserve.edu.magento.pages.customer.components.Header.Titles;
import com.softserve.edu.magento.tools.ParameterUtils;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SignInTestDesicionTable1 extends TestBase{

  @AfterMethod
  public void afterMethod() {
  	ApplicationCustomer.quitAll();
  }

  @DataProvider
  public Object[][] smokeParameters(ITestContext context) {
     return new Object[][] {
			  { ParameterUtils.get().updateParametersAll(
                      ApplicationSourcesRepository.getChromeLocalhostCustomer(), context)}
	 };
  }

  @Test(dataProvider = "smokeParameters")
  public void testSignIn1(ApplicationSources applicationSources) {
	  //Precondition
	  // Prepare our application
	  ApplicationCustomer applicationCustomer = ApplicationCustomer.get(applicationSources);
	  HomePageLogout homePageLogout = applicationCustomer.load();
	  // Test step
	  // 1. Go to the signIn page
	  // 2. Successful log in user
	  // 3. Go to the AccountDashboard Page
	  AccountDashboardPage accountDashboardPage =
			  homePageLogout.clickSignInLink().SignIn(CustomerUserRepository.get().User_DT_SingIn_1());
	  // 4. Confirm that AccountDashboard page is opened
	  Assert.assertEquals(accountDashboardPage.getTitleText(), 
			  Titles.ACCOUNT_DASHBOARD.toString());
	  Assert.assertTrue(accountDashboardPage.
			  confirmAccountInfCorrect(CustomerUserRepository.get().UserYaryna()));
	  // Return to the previous state
	  // Sign Out user
	  // Go to the home page
	  homePageLogout = accountDashboardPage.clickSignOutButton();
  }
  @Test(dataProvider = "smokeParameters")
  public void testSignIn2(ApplicationSources applicationSources) {
	  //Precondition
	  // Prepare our application
	  ApplicationCustomer applicationCustomer = ApplicationCustomer.get(applicationSources);
	  HomePageLogout homePageLogout = applicationCustomer.load();
	  // Test step
	  // 1. Go to the signIn page
	  // 2. Unsuccessful log in user
	  UnsuccessfulSignInPage unsuccessfulSignInPage = homePageLogout.clickSignInLink().
			  unsuccessfulSignIn(CustomerUserRepository.get().User_DT_SingIn_2());
	  // 3. Confirm that signIn page is still opened
	  Assert.assertEquals(unsuccessfulSignInPage.getTitleText(), 
			  Titles.CUSTOMER_LOGIN.toString());
	  // 4. Confirm that error message appear above sing in block
	  // with right text 
	  Assert.assertEquals(unsuccessfulSignInPage.getErrorMessageText(),
			  ErrorMessageSignIn.INVALID_SIGNIN.toString());
	  // Return to the previous state
	  // Go to the home page
	  unsuccessfulSignInPage.clickLogo();
  }
	@Test(dataProvider = "smokeParameters")
	public void testSignIn3(ApplicationSources applicationSources) {
		//Precondition
		// Prepare our application
		ApplicationCustomer applicationCustomer = ApplicationCustomer.get(applicationSources);
		HomePageLogout homePageLogout = applicationCustomer.load();
		// Test step
		// 1. Go to the signIn page
		// 2. Unsuccessful log in user
		UnsuccessfulSignInPage unsuccessfulSignInPage = homePageLogout.clickSignInLink().
				unsuccessfulSignIn(CustomerUserRepository.get().User_DT_SingIn_3());
		// 3. Confirm that signIn page is still opened
		Assert.assertEquals(unsuccessfulSignInPage.getTitleText(),
				Titles.CUSTOMER_LOGIN.toString());
		// 4. Confirm that error message appear above sing in block
		Assert.assertEquals(unsuccessfulSignInPage.getErrorValidatorText(ErrorValidatorNameSingIn.PASSWORD),
				ErrorMessageSignIn.FIELD_IS_REQUIRED.toString());
		// with right text
		// Return to the previous state
		// Go to the home page
		unsuccessfulSignInPage.clickLogo();
	}
	@Test(dataProvider = "smokeParameters")
	public void testSignIn4(ApplicationSources applicationSources) {
		//Precondition
		// Prepare our application
		ApplicationCustomer applicationCustomer = ApplicationCustomer.get(applicationSources);
		HomePageLogout homePageLogout = applicationCustomer.load();
		// Test step
		// 1. Go to the signIn page
		// 2. Unsuccessful log in user
		UnsuccessfulSignInPage unsuccessfulSignInPage = homePageLogout.clickSignInLink().
				unsuccessfulSignIn(CustomerUserRepository.get().User_DT_SingIn_4());
		// 3. Confirm that signIn page is still opened
		Assert.assertEquals(unsuccessfulSignInPage.getTitleText(),
				Titles.CUSTOMER_LOGIN.toString());
		// 4. Confirm that error message appear above sing in block
		Assert.assertEquals(unsuccessfulSignInPage.getErrorValidatorText(ErrorValidatorNameSingIn.EMAIL),
				ErrorMessageSignIn.ERROR_EMAIL_FORMATT.toString());
		// with right text
		// Return to the previous state
		// Go to the home page
		unsuccessfulSignInPage.clickLogo();
	}

  
}