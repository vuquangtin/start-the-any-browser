package com.start.the.any.browser.selenium.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProfilePage {
	private static WebElement element = null;

	public static WebElement linkPersonalDetails(WebDriver driver)
			throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath(".//*[@id='settingsContainer']/div/div[1]/div[2]/h4/a")));
		Assert.assertTrue(element.isDisplayed());
		return element;
	}

	public static WebElement linkFinancialAssessment(WebDriver driver)
			throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath(".//*[@id='settingscontainer']/div/div[2]/div[2]/h4/a")));
		Assert.assertTrue(element.isDisplayed());
		return element;
	}
}
