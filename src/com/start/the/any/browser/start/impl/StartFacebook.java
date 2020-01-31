package com.start.the.any.browser.start.impl;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.start.the.any.browser.enums.SleepType;
import com.start.the.any.browser.main.StartBrowser;
import com.start.the.any.browser.start.abs.AbsStart;
import com.start.the.any.browser.start.abs.IStart;
import com.start.the.any.browser.utilities.Facebook;

public class StartFacebook extends AbsStart implements IStart {
	static Logger logger = Logger.getLogger(StartFacebook.class.getName());

	public StartFacebook(WebDriver driver, int sleep, SleepType sleepType,
			boolean isShutdown) {
		super(driver, sleep, sleepType, isShutdown);
	}

	@Override
	public boolean start() {
		try {
			if (logger.isDebugEnabled())
				logger.debug("get:" + Facebook.HOME_PAGE);

			if (driver != null) {
				if (logger.isDebugEnabled())
					logger.debug("get me:" + Facebook.FACEBOOK_ME);
				driver.get(Facebook.FACEBOOK_ME);
				StartBrowser.sleepSeconds(totalSleep, "waitting Chrome");
			}
			if (isShutdown) {
				try {
					driver.close();
					driver.quit();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				System.exit(1);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
