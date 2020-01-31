package com.start.the.any.browser.selenium.appModules;

import org.openqa.selenium.WebDriver;

import com.start.the.any.browser.selenium.HomePage;
import com.start.the.any.browser.selenium.LoginPage;



public class LoginAction {
	public static void Execute(WebDriver driver, String sEmail, String sPassword)
			throws Exception {
		HomePage.btnLogin(driver).click();
		LoginPage.txtEmail(driver).clear();
		LoginPage.txtEmail(driver).sendKeys(sEmail);
		LoginPage.txtPassword(driver).clear();
		LoginPage.txtPassword(driver).sendKeys(sPassword);
		LoginPage.btnLogin(driver).click();
	}
}