package com.start.the.any.browser.main;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.start.the.any.browser.utilities.ChromeCommandLineSwitches;

public class TestChromeBrowser {

	public WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.out.println("*******************");
		System.out.println("launching chrome browser");
		System.setProperty("webdriver.chrome.driver",
				ChromeCommandLineSwitches.CHROME_PATH);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void testGooglePageTitleInIEBrowser() {
		driver.navigate().to("http://www.google.com");
		String strPageTitle = driver.getTitle();
		System.out.println("Page title: - " + strPageTitle);
		Assert.assertEquals(strPageTitle.equalsIgnoreCase("Google"),
				"Page title doesn't match");
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			System.out.println("Closing chrome browser");
			driver.quit();
		}
	}

}