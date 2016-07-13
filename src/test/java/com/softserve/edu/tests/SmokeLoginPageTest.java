package com.softserve.edu.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.data.IUser;
import com.softserve.edu.data.UserRepository;
import com.softserve.edu.pages.ATopPage.ChangeLanguageFields;
import com.softserve.edu.pages.LoginPage;
import com.softserve.edu.pages.LoginValidatorPage;
import com.softserve.edu.pages.LoginValidatorPage.LoginValidatorPageL10n;

public class SmokeLoginPageTest {

	//@Test
    //@Deprecated
	public void checkChangeLanguage() throws Exception {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://registrator.herokuapp.com/login");
		//
		LoginPage loginPage = new LoginPage(driver);
		// Check Ukrainian
		Assert.assertEquals(loginPage.getLoginLabelText(), "Логін");
		Assert.assertEquals(loginPage.getPasswordLabelText(), "Пароль");
		Assert.assertEquals(loginPage.getSignintText(), "Увійти");
		Thread.sleep(2000);
		// Switch to Russian
		loginPage = loginPage.changeLanguage(ChangeLanguageFields.RUSSIAN);
		// Check Russian
		Assert.assertEquals(loginPage.getLoginLabelText(), "Логин");
		Assert.assertEquals(loginPage.getPasswordLabelText(), "Пароль");
		Assert.assertEquals(loginPage.getSignintText(), "Войти");
		Thread.sleep(2000);
		// Switch to English
		loginPage = loginPage.changeLanguage(ChangeLanguageFields.ENGLISH);
		// Check Russian
		Assert.assertEquals(loginPage.getLoginLabelText(), "Login");
		Assert.assertEquals(loginPage.getPasswordLabelText(), "Password");
		Assert.assertEquals(loginPage.getSignintText(), "Sign in");
		Thread.sleep(2000);
		// Switch to Ukrainian
		loginPage = loginPage.changeLanguage(ChangeLanguageFields.UKRAINIAN);
		// Check Russian
		Assert.assertEquals(loginPage.getLoginLabelText(), "Логін");
		Assert.assertEquals(loginPage.getPasswordLabelText(), "Пароль");
		Assert.assertEquals(loginPage.getSignintText(), "Увійти");
		Thread.sleep(2000);
		driver.quit();
	}

	//@Test
	public void checkInvalidLogin1() throws Exception {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://registrator.herokuapp.com/login");
		//
		LoginPage loginPage = new LoginPage(driver);
		Assert.assertEquals(loginPage.getChangeLanguageSelectedText(),
				ChangeLanguageFields.UKRAINIAN.toString());
		// Switch to Ukrainian
		ChangeLanguageFields curreanLanguage = ChangeLanguageFields.UKRAINIAN;
		loginPage = loginPage.changeLanguage(curreanLanguage);
		//LoginValidatorPage loginValidatorPage = loginPage.unsuccessfulLogin("proba", "proba");
		LoginValidatorPage loginValidatorPage = loginPage.unsuccessfulLogin(UserRepository.get().invalidUser());
		// STUB
		//LoginValidatorPage loginValidatorPage = new LoginValidatorPage(driver);
		//Assert.assertEquals(loginValidatorPage.getInvalidLoginValidatorText(), "Неправильний логін або пароль");
		Assert.assertEquals(loginValidatorPage.getInvalidLoginValidatorText(), LoginValidatorPageL10n.INVALID_LOGINVALIDATOR_LABEL.getLocalization(curreanLanguage));
		Thread.sleep(2000);
		driver.quit();
	}

    @DataProvider//(parallel = true)
    public Object[][] getUsers() {
        return new Object[][] {
                { UserRepository.get().invalidUser() },
                };
    }

    @Test(dataProvider = "getUsers")
    public void checkInvalidLogin2(IUser invalidUser) throws Exception {
        // precondition
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://registrator.herokuapp.com/login");
        //
        LoginPage loginPage = new LoginPage(driver);
        // test steps
        // 1. Switch to Ukrainian
        ChangeLanguageFields curreanLanguage = ChangeLanguageFields.UKRAINIAN;
        loginPage = loginPage.changeLanguage(curreanLanguage);
        // 2. invalid login
        LoginValidatorPage loginValidatorPage = loginPage.unsuccessfulLogin(invalidUser);
        // check
        Assert.assertEquals(loginValidatorPage.getInvalidLoginValidatorText(), LoginValidatorPageL10n.INVALID_LOGINVALIDATOR_LABEL.getLocalization(curreanLanguage));
        Thread.sleep(2000);
        // return to previous state
        driver.quit();
    }

}
