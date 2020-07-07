package com.start.the.any.browser.main;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class OpenTorBrowser {
	private static WebDriver driver;
	private static String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();

	public static void main(String[] args) {
		String torPath = "/home/vuquangtin/Desktop/Browser/start-tor-browser";
		String profilePath = "/home/vuquangtin/Desktop/Browser/Data/Browser/profile.default/";
		FirefoxProfile profile = new FirefoxProfile(new File(profilePath));
		FirefoxBinary binary = new FirefoxBinary(new File(torPath));
		FirefoxOptions firefoxOptions = new FirefoxOptions().setBinary(binary);
		firefoxOptions.setCapability(CapabilityType.BROWSER_NAME,
				BrowserType.FIREFOX);
		firefoxOptions.setProfile(profile);
		firefoxOptions.addArguments("-profile="+profilePath);
		//firefoxOptions.addArguments("-profile","/tmp/rust_mozprofile1ubtG6");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("acceptSslCerts", false);
		capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS,
				firefoxOptions);
		firefoxOptions.addArguments("--window-size=1280,1024");
		firefoxOptions.addArguments("--width=1280");
		firefoxOptions.addArguments("--height=1024");
		//firefoxOptions.addArguments("--browser.privatebrowsing.autostart", "false");
		//firefoxOptions.addArguments("--private");
		System.setProperty("webdriver.gecko.driver", "geckodriver");
	    System.out.println(firefoxOptions.toString());
	    System.out.println(firefoxOptions.toJson());
		driver = new FirefoxDriver(firefoxOptions);

		baseUrl = "https://qa2all.wordpress.com";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get(baseUrl + "/");

	}

}
