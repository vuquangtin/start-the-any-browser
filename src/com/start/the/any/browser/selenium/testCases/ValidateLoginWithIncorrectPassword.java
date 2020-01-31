package com.start.the.any.browser.selenium.testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.start.the.any.browser.selenium.LoginPage;
import com.start.the.any.browser.selenium.appModules.LoginAction;

public class ValidateLoginWithIncorrectPassword {
	public WebDriver driver;

	@Test
	public void ALoginIncorrectPassword() throws Exception {
		String password = "Pass1234";
		LoginAction.Execute(driver, Constant.Email, password);
	}

	@Test
	public void BValidateMessage() throws Exception {
		Assert.assertTrue(LoginPage.errLogin(driver).isDisplayed());
		if (LoginPage.errLogin(driver).isDisplayed()) {
			System.out.println(LoginPage.errLogin(driver).getText());
			Assert.assertEquals("Incorrect email or password.", LoginPage
					.errLogin(driver).getText());
		}
	}

	@BeforeTest
	public void launchApplication() {
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(Constant.URL);
	}

	@AfterTest
	public void endSession() {
		driver.quit();
	}
}