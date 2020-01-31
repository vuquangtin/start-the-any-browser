package com.start.the.any.browser.main;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.start.the.any.browser.utilities.ChromeCommandLineSwitches;

public class ChromeExample {

	public static WebDriver driver;

	public static void main(String[] args) {
		System.out.println("launching chrome browser");
		System.setProperty("webdriver.chrome.driver",
				ChromeCommandLineSwitches.CHROME_PATH);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(12000, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// driver.navigate().to("http://google.com");
		driver.get("http://demo.guru99.com/test/guru99home/");
		// WebElement Element =
		// driver.findElement(By.xpath("//a[text()='Linux']"));
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		// driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
}