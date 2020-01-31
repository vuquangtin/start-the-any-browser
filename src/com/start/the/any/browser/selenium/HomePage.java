package com.start.the.any.browser.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage {

	private static WebElement element = null;

	public static WebElement btnLogin(WebDriver driver) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		element = wait.until(ExpectedConditions.elementToBeClickable(By
				.id("btnlogin")));
		Assert.assertTrue(element.isDisplayed());
		return element;
	}
}