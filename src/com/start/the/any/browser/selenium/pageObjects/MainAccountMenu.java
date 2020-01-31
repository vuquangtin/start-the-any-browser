package com.start.the.any.browser.selenium.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MainAccountMenu {
	private static WebElement element = null;

	public static WebElement linkProfile(WebDriver driver) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath(".//*[@id='all-accounts']/li/ul/a[1]")));
		Assert.assertTrue(element.isDisplayed());
		return element;
	}

	public static WebElement linkSecurity(WebDriver driver) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath(".//*[@id='all-accounts']/li/ul/a[2]")));
		Assert.assertTrue(element.isDisplayed());
		return element;
	}

	public static WebElement linkLogout(WebDriver driver) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath(".//*[@id='btnlogout']")));
		Assert.assertTrue(element.isDisplayed());
		return element;
	}

	public static WebElement linkMainAccount(WebDriver driver)
			throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath(".//*[@id='main-logout']")));
		Assert.assertTrue(element.isDisplayed());
		return element;
	}
}