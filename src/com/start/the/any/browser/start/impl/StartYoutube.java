package com.start.the.any.browser.start.impl;

import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.start.the.any.browser.configs.YoutubeSingleton;
import com.start.the.any.browser.enums.SleepType;
import com.start.the.any.browser.main.StartBrowser;
import com.start.the.any.browser.models.YoutubeInfo;
import com.start.the.any.browser.start.abs.AbsStart;
import com.start.the.any.browser.start.abs.IStart;
import com.start.the.any.browser.utilities.FileUtils;
import com.start.the.any.browser.utilities.Youtube;

public class StartYoutube extends AbsStart implements IStart {
	static Logger logger = Logger.getLogger(StartYoutube.class.getName());

	public StartYoutube(WebDriver driver, int sleep, SleepType sleepType,
			boolean isShutdown) {
		super(driver, sleep, sleepType, isShutdown);
	}

	@Override
	public boolean start() {
		try {
			if (logger.isDebugEnabled())
				logger.debug("get:" + Youtube.HOME_PAGE);

			if (driver != null) {

				List<YoutubeInfo> listYouTube = FileUtils
						.getContent(YoutubeSingleton.getInstance().getFileListURL("conf/youtube.txt"));
				int totalLink = listYouTube.size();
				if (listYouTube != null) {
					int MAX = YoutubeSingleton.getInstance().getLoop();
					int total = 0;
					while (true) {
						if (YoutubeSingleton.getInstance().getRandom()) {
							listYouTube = FileUtils
									.getContent(YoutubeSingleton.getInstance().getFileListURL("conf/youtube.txt"));
							List<YoutubeInfo> listYouTubeRandom = listYouTube
									.subList(0, listYouTube.size());
							Random rand = new Random();
							int index;
							while (listYouTubeRandom.size() > 0) {
								if (listYouTubeRandom.size() <= 1) {
									index = 0;
								} else {
									index = rand.nextInt(listYouTubeRandom
											.size());
								}

								YoutubeInfo youtubeInfo = listYouTubeRandom
										.get(index);
								listYouTubeRandom.remove(index);
								if (logger.isDebugEnabled())
									logger.debug("fetch random url[" + index
											+ "/" + listYouTubeRandom.size()
											+ "|" + totalLink + "]:"
											+ youtubeInfo.getUrl());
								driver.get(youtubeInfo.getUrl());
								// sleepSecondsAndAutoScrolling
								if (youtubeInfo.getSizeMinutePause() > 60) {
									StartBrowser.sleepSeconds(
											youtubeInfo.getMinutePause(),
											"waitting youtube play video");
									
								} else {
									StartBrowser.sleepSeconds(
											youtubeInfo.getPause(),
											"waitting youtube play video");
								}
								if (index == 0) {
									if (logger.isDebugEnabled())
										logger.debug("index:" + index);
									break;
								}
							}
						} else {
							listYouTube = FileUtils
									.getContent(YoutubeSingleton.getInstance().getFileListURL("conf/youtube.txt"));
							for (YoutubeInfo youtubeInfo : listYouTube) {
								if (logger.isDebugEnabled())
									logger.debug("fetch url:"
											+ youtubeInfo.getUrl());
								driver.get(youtubeInfo.getUrl());
								// sleepSecondsAndAutoScrolling
								StartBrowser.sleepSeconds(
										youtubeInfo.getPause(),
										"waitting youtube play video");
							}
							total++;
							if (total > MAX) {
								break;
							}
						}

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
