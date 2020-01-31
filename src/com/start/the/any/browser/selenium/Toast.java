package com.start.the.any.browser.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

public class Toast {

	protected WebDriver driver;

	private By toastSuccess = By
			.xpath("//*[@class='Toastify__toast Toastify__toast--success']");
	private By toastSuccessClose = By
			.xpath("//*[@class='Toastify__close-button Toastify__close-button--success']");
	private By toastError = By
			.xpath("//*[@class='Toastify__toast Toastify__toast--error']");

	public Toast(WebDriver driver) {
		this.driver = driver;
	}

	public boolean SuccessToastIsDisplayed() {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.elementToBeClickable(toastSuccess));
			WebElement toast = driver.findElement(toastSuccess);
			return toast.isDisplayed();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
			return false;
		}
	}

	public void closeToast() {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(toastSuccessClose));
			WebElement toast = driver.findElement(toastSuccessClose);
			toast.click();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
		}
	}

	public boolean ErrorToastIsDisplayed() {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(toastError));
			WebElement toast = driver.findElement(toastError);
			return toast.isDisplayed();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
			return false;
		}
	}
}