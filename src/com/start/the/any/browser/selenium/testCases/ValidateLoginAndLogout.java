package com.start.the.any.browser.selenium.testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.start.the.any.browser.selenium.HomePage;
import com.start.the.any.browser.selenium.appModules.LoginAction;
import com.start.the.any.browser.selenium.appModules.LogoutAction;

public class ValidateLoginAndLogout {

	public WebDriver driver;

	@BeforeTest
	public void setUp() {

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(Constant.URL);
	}

	@Test
	public void ALaunch() {
		driver.get(Constant.URL);
	}

	@Test
	public void BLogin() throws Exception {
		LoginAction.Execute(driver, Constant.Email, Constant.Password);
	}

	@Test
	public void CLogout() throws Exception {
		LogoutAction.Execute(driver);
		Assert.assertTrue(HomePage.btnLogin(driver).isDisplayed());
	}

	@AfterTest
	public void endSession() {
		driver.quit();
	}
}