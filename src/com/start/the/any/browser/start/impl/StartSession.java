package com.start.the.any.browser.start.impl;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.start.the.any.browser.configs.ConfigSingleton;
import com.start.the.any.browser.enums.SleepType;
import com.start.the.any.browser.main.StartBrowser;
import com.start.the.any.browser.start.abs.AbsStart;
import com.start.the.any.browser.start.abs.IStart;

public class StartSession extends AbsStart implements IStart {
	static Logger logger = Logger.getLogger(StartSession.class.getName());
	private String HOME_PAGE = "http://google.com";

	public StartSession(WebDriver driver, int sleep, SleepType sleepType,
			boolean isShutdown) {
		super(driver, sleep, sleepType, isShutdown);
	}

	@Override
	public boolean start() {
		try {
			HOME_PAGE = ConfigSingleton.getInstance().getHomePage(HOME_PAGE);
			if (logger.isDebugEnabled())
				logger.debug("get:" + HOME_PAGE);
			if (driver != null) {
				if (logger.isDebugEnabled())
					logger.debug("get home page:" + HOME_PAGE);
				driver.get(HOME_PAGE);
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
