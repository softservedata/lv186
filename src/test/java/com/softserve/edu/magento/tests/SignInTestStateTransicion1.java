package com.softserve.edu.magento.tests;


import com.softserve.edu.magento.data.ApplicationSources;
import com.softserve.edu.magento.data.ApplicationSourcesRepository;
import com.softserve.edu.magento.data.customer.user.CustomerUserRepository;
import com.softserve.edu.magento.pages.customer.*;
import com.softserve.edu.magento.pages.customer.UnsuccessfulSignInPage.ErrorMessageSignIn;
import com.softserve.edu.magento.pages.customer.UnsuccessfulSignInPage.ErrorValidatorNameSingIn;
import com.softserve.edu.magento.pages.customer.components.Header.Titles;
import com.softserve.edu.magento.tools.ParameterUtils;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SignInTestStateTransicion1 extends TestBase{

  @AfterMethod
  public void afterMethod() {
  	ApplicationCustomer.quitAll();
  }

  @DataProvider (parallel = true)
  public Object[][] smokeParameters(ITestContext context) {
     return new Object[][] {
			  { ParameterUtils.get().updateParametersAll(
                      ApplicationSourcesRepository.getChromeLocalhostCustomer(), context)}
	 };
  }
  @Test(dataProvider = "smokeParameters")
  public void testSignIn2(ApplicationSources applicationSources) {
	  //Precondition
	  // Prepare our application
	  ApplicationCustomer applicationCustomer = ApplicationCustomer.get(applicationSources);
	  HomePageLogout homePageLogout = applicationCustomer.load();
	  // Test step
	  // 1. Go to the signIn page
	  SignInPage signInPage = homePageLogout.clickSignInLink();
	  // 2. Confirm that Sing In page is opened
	  Assert.assertEquals(signInPage.getTitleText(), Titles.CUSTOMER_LOGIN.toString());
	  // 3. Unsuccessful log in user
	  UnsuccessfulSignInPage unsuccessfulSignInPage = signInPage.
			  unsuccessfulSignIn(CustomerUserRepository.get().User_DT_SingIn_2());
	  // 4. Confirm that signIn page is still opened
	  Assert.assertEquals(unsuccessfulSignInPage.getTitleText(), 
			  Titles.CUSTOMER_LOGIN.toString());
	  // 5. Confirm that error message appear above sing in block
	  // with right text 
	  Assert.assertEquals(unsuccessfulSignInPage.getErrorMessageText(),
			  ErrorMessageSignIn.INVALID_SIGNIN.toString());
	  // 6. Try to unsuccessful log in user second time
	  unsuccessfulSignInPage = unsuccessfulSignInPage.
			  unsuccessfulSignIn(CustomerUserRepository.get().User_DT_SingIn_2());
	  // 7. Confirm that signIn page is still opened
	  Assert.assertEquals(unsuccessfulSignInPage.getTitleText(),
			  Titles.CUSTOMER_LOGIN.toString());
	  // 8. Confirm that error message appear above sing in block
	  // with right text
	  Assert.assertEquals(unsuccessfulSignInPage.getErrorMessageText(),
			  ErrorMessageSignIn.INVALID_SIGNIN.toString());
	  // 9. Try to successful log in user
	  AccountDashboardPage accountDashboardPage = unsuccessfulSignInPage.
			  SignIn(CustomerUserRepository.get().User_DT_SingIn_1());
	  // 10. Confirm that AccountDashboard page is opened
	  Assert.assertEquals(accountDashboardPage.getTitleText(),
			  Titles.ACCOUNT_DASHBOARD.toString());
	  Assert.assertTrue(accountDashboardPage.
			  confirmAccountInfCorrect(CustomerUserRepository.get().UserYaryna()));
	  // Return to the previous state
	  // Sing out user
	  homePageLogout = accountDashboardPage.clickSignOutButton();
  }
}