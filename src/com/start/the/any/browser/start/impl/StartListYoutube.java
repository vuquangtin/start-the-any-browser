package com.start.the.any.browser.start.impl;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.start.the.any.browser.enums.SleepType;
import com.start.the.any.browser.main.StartBrowser;
import com.start.the.any.browser.start.abs.AbsStart;
import com.start.the.any.browser.start.abs.IStart;
import com.start.the.any.browser.utilities.Youtube;

public class StartListYoutube extends AbsStart implements IStart {

	static Logger logger = Logger.getLogger(StartListYoutube.class.getName());

	public StartListYoutube(WebDriver driver, int sleep, SleepType sleepType,
			boolean isShutdown) {
		super(driver, sleep, sleepType, isShutdown);
	}

	@Override
	public boolean start() {
		try {
			if (logger.isDebugEnabled())
				logger.debug("get:" + Youtube.PLAY_LIST);

			if (driver != null) {

				if (Youtube.PLAY_LIST != null) {
					int MAX = 1000;
					int i = 0;
					if (logger.isDebugEnabled())
						logger.debug("fetch url:" + Youtube.PLAY_LIST);
					driver.get(Youtube.PLAY_LIST);
					while (i < MAX) {
						try {
							StartBrowser.sleepSeconds(60 * 10,
									"waitting youtube play video");
						} catch (Exception ex) {
							ex.printStackTrace();
							break;
						}
						i++;
					}

				}

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
