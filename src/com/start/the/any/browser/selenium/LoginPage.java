package com.start.the.any.browser.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
	private static WebElement element = null;

	public static WebElement txtEmail(WebDriver driver) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.id("txtEmail")));
		Assert.assertTrue(element.isDisplayed());
		return element;
	}

	public static WebElement txtPassword(WebDriver driver) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.id("txtPass")));
		Assert.assertTrue(element.isDisplayed());
		return element;
	}

	public static WebElement btnLogin(WebDriver driver) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = wait.until(ExpectedConditions.elementToBeClickable(By
				.name("login")));
		Assert.assertTrue(element.isDisplayed());
		return element;
	}

	public static WebElement errLogin(WebDriver driver) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(".//*[@id='frmLogin']/p")));
		Assert.assertTrue(element.isDisplayed());
		return element;
	}
}
