package com.start.the.any.browser.selenium.appModules;

import org.openqa.selenium.WebDriver;

import com.start.the.any.browser.selenium.pageObjects.MainAccountMenu;

public class LogoutAction {
	public static void Execute(WebDriver driver) throws Exception {
		System.out.println(driver.getTitle());
		MainAccountMenu.linkMainAccount(driver).click();
		MainAccountMenu.linkLogout(driver).click();
	}
}