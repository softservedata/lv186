package com.softserve.edu.magento.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.magento.edu.customer.components.Header.Titles;
import com.magento.edu.customer.pages.AccountDashboardPage;
import com.magento.edu.customer.pages.CreateAccountPage;
import com.magento.edu.customer.pages.HomePageLogout;
import com.magento.edu.customer.pages.SignInPage;
import com.magento.edu.customer.pages.UnsuccessfulSignInPage;
import com.magento.edu.customer.pages.UnsuccessfulSignInPage.ErrorMessageSignIn;
import com.magento.edu.customer.pages.Unsuccessful_CreateAccountPage;
import com.magento.edu.customer.pages.Unsuccessful_CreateAccountPage.ErrorMessage;
import com.softserve.edu.magento.data.AdminUserRepository;
import com.softserve.edu.magento.data.ApplicationSources;
import com.softserve.edu.magento.data.ApplicationSourcesRepository;
import com.softserve.edu.magento.data.IAdminUser;
import com.softserve.edu.magento.data.customer.user.CustomerUserRepository;
import com.softserve.edu.magento.pages.ApplicationAdmin;
import com.softserve.edu.magento.pages.ApplicationCustomer;
import com.softserve.edu.magento.pages.menu.dashboard.DashboardPage;
import com.softserve.edu.magento.tools.ListUtils;
import com.softserve.edu.magento.tools.ParameterUtils;

public class PreSmokeTestSignIn {
	WebDriver driver;
  @BeforeMethod
  public void beforeMethod() {
	  //driver = new FirefoxDriver();
	  //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }

  @AfterMethod
  public void afterMethod() {
	  //driver.quit();
  }
  @AfterClass
  void tearDown() throws Exception {
	  ApplicationCustomer.quitAll();
  }
  @DataProvider //(parallel = true)
  public Object[][] smokeParameters(ITestContext context) {
      return ListUtils.get().toMultiArray(
              ParameterUtils.get().updateParametersAll(
                      ApplicationSourcesRepository.getFirefoxLocalhostCustomer(), context));
  }

  @Test(dataProvider = "smokeParameters")
  public void testSignIn1(ApplicationSources applicationSources) {
	  
	  ApplicationCustomer applicationCustomer = ApplicationCustomer.get(applicationSources);
	  HomePageLogout homePageLogout = applicationCustomer.load();
	  
	  Assert.assertEquals(homePageLogout.getTitleText(), Titles.HOME_PAGE.toString());
	  
	  SignInPage signInPage = homePageLogout.clickSignInLink();
	  
	  Assert.assertEquals(signInPage.getTitleText(), Titles.CUSTOMER_LOGIN.toString());
	  
	  AccountDashboardPage accountDashboardPage = signInPage.SignIn(CustomerUserRepository.get().User());  
	  
	  Assert.assertEquals(accountDashboardPage.getTitleText(), 
			  Titles.ACCOUNT_DASHBOARD.toString());
	  
	  homePageLogout = accountDashboardPage.clickSignOutButton();
	  ApplicationAdmin applicationAdmin = ApplicationAdmin.get(ApplicationSourcesRepository.getFirefoxLocalhostAdmin());
	  applicationAdmin.load().successAdminLogin(AdminUserRepository.get().adminYaryna());
	  
  }
  //@Test
  public void testSignIn1_1(ApplicationSources applicationSources) {
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
  //@Test
  public void testSignIn2(ApplicationSources applicationSources) {
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
  //@Test
  public void testCreateAccount1(ApplicationSources applicationSources) {
	  
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
  }
  //@Test
  public void testCreateAccount2(ApplicationSources applicationSources) {
	  ApplicationCustomer applicationCustomer = ApplicationCustomer.get(applicationSources);
	  HomePageLogout homePageLogout = applicationCustomer.load();
	  //CreateAccountPage createAccountPage = homePage.clickCreateAccountLink();
	  Unsuccessful_CreateAccountPage unsuccessful_CreateAccountPage =
			  homePageLogout.clickCreateAccountLink().unsuccessful_createNewAccount(CustomerUserRepository.get().User());
	  
	  Assert.assertEquals(unsuccessful_CreateAccountPage.getErrorMessageText(),
			  ErrorMessage.ALREADY_EXIST_ACCOUNT.toString());
	  
  }
}