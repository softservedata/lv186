

import org.testng.annotations.Test;

import com.magento.edu.customer.components.Header.Titles;
import com.magento.edu.customer.data.user.CustomerUserRepository;
import com.magento.edu.customer.pages.AccountDashboardPage;
import com.magento.edu.customer.pages.CreateAccountPage;
import com.magento.edu.customer.pages.HomePage;
import com.magento.edu.customer.pages.SignInPage;
import com.magento.edu.customer.pages.UnsuccessfulSignInPage;
import com.magento.edu.customer.pages.UnsuccessfulSignInPage.ErrorMessageSignIn;
import com.magento.edu.customer.pages.Unsuccessful_CreateAccountPage;
import com.magento.edu.customer.pages.Unsuccessful_CreateAccountPage.ErrorMessage;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class TestCaseSignIn1 {
	WebDriver driver;
  @BeforeMethod
  public void beforeMethod() {
	  driver = new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

  @Test
  public void testSignIn1() {
	  driver.get("http://192.168.195.210/magento");
	  HomePage homePage = new HomePage(driver);
	  
	  Assert.assertEquals(homePage.getTitleText(), Titles.HOME_PAGE.toString());
	  
	  SignInPage signInPage = homePage.clickSignInLink();
	  
	  Assert.assertEquals(signInPage.getTitleText(), Titles.CUSTOMER_LOGIN.toString());
	  
	  AccountDashboardPage accountDashboardPage = signInPage.SignIn(CustomerUserRepository.get().User());  
	  
	  Assert.assertEquals(accountDashboardPage.getTitleText(), 
			  Titles.ACCOUNT_DASHBOARD.toString());
	  
	  homePage = accountDashboardPage.clickSignOutButton();
  }
  @Test
  public void testSignIn1_1() {
	  driver.get("http://192.168.195.210/magento");
	  HomePage homePage = new HomePage(driver);
	  
	  Assert.assertEquals(homePage.getTitleText(), Titles.HOME_PAGE.toString());
	  
	  SignInPage signInPage = homePage.clickSignInLink();
	  
	  Assert.assertEquals(signInPage.getTitleText(), Titles.CUSTOMER_LOGIN.toString());
	  
	  AccountDashboardPage accountDashboardPage = signInPage.SignIn_Enter(CustomerUserRepository.get().User());  
	  
	  Assert.assertEquals(accountDashboardPage.getTitleText(), 
			  Titles.ACCOUNT_DASHBOARD.toString());
	  
	  homePage = accountDashboardPage.clickSignOutButton();
  }
  @Test
  public void testSignIn2() {
	  driver.get("http://192.168.195.210/magento");
	  HomePage homePage = new HomePage(driver);
	  SignInPage signInPage = homePage.clickSignInLink();
	  UnsuccessfulSignInPage unsuccessfulSignInPage = signInPage.
			  unsuccessfulSignIn(CustomerUserRepository.get().invalidUser());  
	  Assert.assertEquals(unsuccessfulSignInPage.getTitleText(), 
			  Titles.CUSTOMER_LOGIN.toString());
	  Assert.assertEquals(unsuccessfulSignInPage.getErrorMessageText(),
			  ErrorMessageSignIn.INVALID_SIGNIN.toString());
  }
  @Test
  public void testCreateAccount1() {
	  driver.get("http://192.168.195.210/magento");
	  HomePage homePage = new HomePage(driver);
	  SignInPage signInPage = homePage.clickSignInLink();
	  CreateAccountPage createAccountPage = signInPage.clickCreateAccountButton();
	  
	  AccountDashboardPage accountDashboardPage = createAccountPage.createNewAccount
			  (CustomerUserRepository.get().newUser());
	  
	  Assert.assertEquals(accountDashboardPage.getTitleText(),
			  Titles.ACCOUNT_DASHBOARD.toString());
	  
	  //accountDashboardPage.clickDropdown_account_menu_button();
	  homePage = accountDashboardPage.clickSignOutButton();
	  
	  Assert.assertEquals(homePage.getTitleText(),
			  Titles.YOU_ARE_SIGNED_OUT.toString());
  }
  @Test
  public void testCreateAccount2() {
	  driver.get("http://192.168.195.210/magento");
	  HomePage homePage = new HomePage(driver);
	  CreateAccountPage createAccountPage = homePage.clickCreateAccountLink();
	  Unsuccessful_CreateAccountPage unsuccessful_CreateAccountPage =
			  createAccountPage.unsuccessful_createNewAccount(CustomerUserRepository.get().User());
	  
	  Assert.assertEquals(unsuccessful_CreateAccountPage.getErrorMessageText(),
			  ErrorMessage.ALREADY_EXIST_ACCOUNT.toString());
	  
  }
}
