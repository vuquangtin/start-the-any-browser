package com.start.the.any.browser.start.abs;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.start.the.any.browser.enums.SleepType;

public abstract class AbsStart {
	protected WebDriver driver;
	protected int sleep;
	protected boolean isShutdown;
	protected SleepType sleepType;
	protected int totalSleep;

	public AbsStart(WebDriver driver, int sleep, SleepType sleepType,
			boolean isShutdown) {
		this.driver = driver;
		this.sleep = sleep;
		this.sleepType = sleepType;
		this.isShutdown = isShutdown;
		switch (sleepType) {
		case DAY:
			totalSleep = sleep * 60 * 60 * 24;
			break;
		case HOUR:
			totalSleep = sleep * 60 * 60;
			break;
		case MIMUTE:
			totalSleep = sleep * 60;
			break;
		case SECOND:
			totalSleep = sleep;
			break;
		default:
			totalSleep = sleep;
			break;

		}
	}

	public void handleAlert(WebDriver driver, WebDriverWait wait) {
		if (wait == null) {
			wait = new WebDriverWait(driver, 5);
		}

		try {
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			alert.accept();
		} catch (WebDriverException ex) {
			ex.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
