package com.softserve.edu.magento.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.softserve.edu.magento.data.AdminUserRepository;
import com.softserve.edu.magento.data.IAdminUser;
import com.softserve.edu.magento.pages.AdminLogPage;

public class PageFactoryTest {

	@Test
	public void checkAdminLogon2() throws Exception {
		// Precondition
	    IAdminUser user = AdminUserRepository.get().invalid();
	    //
        // WebDriver driver = browser.getWebDriver();
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://192.168.195.210/magento/admin");
        Thread.sleep(1000);
        //
        // Test Steps
        //AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
        //AdminLogPage adminLoginPage = new AdminLogPage(driver);
        AdminLogPage adminLoginPage = PageFactory.initElements(driver, AdminLogPage.class);
        //adminLoginPage.successAdminLogin(user);
        //
        adminLoginPage.setLoginInput(user.getUsername());
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
        adminLoginPage.setLoginInput(user.getUsername());
        //
        Thread.sleep(3000);
        driver.quit();
	}

}