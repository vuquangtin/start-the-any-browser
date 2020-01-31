package com.start.the.any.browser.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

public class NotifyCusp {

	protected WebDriver driver;

	private By dialogNotify = By.xpath("//*[@data-id='notifyCUSPPopUpTitle']");
	private By fieldTitle = By.xpath("//*[@data-id='titleField']//textarea[1]");
	private By fieldDescription = By
			.xpath("//*[@data-id='descriptionField']//textarea[1]");
	private By errorTitle = By.xpath("//*[@data-id='errorTitle']");
	private By buttonSendEnabled = By
			.xpath("//*[@data-id='buttonSend'][not(@disabled)]");
	private By buttonSendDisabled = By
			.xpath("//*[@data-id='buttonSend'][@disabled]");

	public NotifyCusp(WebDriver driver) {

		this.driver = driver;
	}

	public boolean NotifyCuspDialogIsDisplayed() {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(dialogNotify));
			WebElement dialog = driver.findElement(dialogNotify);
			return dialog.isDisplayed();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
			return false;
		}
	}

	public void putInTitle(String input) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(fieldTitle));
			WebElement field = driver.findElement(fieldTitle);
			field.sendKeys(input);
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
		}
	}

	public void putInDescription(String input) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(fieldDescription));
			WebElement field = driver.findElement(fieldDescription);
			field.sendKeys(input);
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
		}
	}

	public boolean ErrorTitleIsDisplayed() {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(errorTitle));
			WebElement error = driver.findElement(errorTitle);
			return error.isDisplayed();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
			return false;
		}
	}

	public boolean SendButtonIsDisabled() {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(buttonSendDisabled));
			WebElement button = driver.findElement(buttonSendDisabled);
			return button.isDisplayed();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
			return false;
		}
	}

	public boolean SendButtonIsEnabled() {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(buttonSendEnabled));
			WebElement button = driver.findElement(buttonSendEnabled);
			return button.isDisplayed();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
			return false;
		}
	}

	public void clickSendButton() {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(buttonSendEnabled));
			WebElement button = driver.findElement(buttonSendEnabled);
			button.click();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
		}
	}
}
