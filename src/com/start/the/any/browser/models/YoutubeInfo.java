package com.start.the.any.browser.models;

import java.util.Random;

import org.apache.log4j.Logger;

public class YoutubeInfo {
	static Logger logger = Logger.getLogger(YoutubeInfo.class.getName());
	private String url;
	private int pause;
	public static final int MINUTE = 60;
	public static final int HOUR = 60 * 60;

	public YoutubeInfo(String url, int pause) {
		if (url.startsWith("https://www.")) {
			url = url.replace("https://www.", "https://m.");
		}
		this.url = url;

		this.pause = pause;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getPause() {
		return pause;
	}

	public int getSizeMinutePause() {
		return pause / 60;
	}

	public int getMinutePause() {
		int rand = new Random().nextInt(30) + 30;
		logger.info("sleep Random " + rand + " MINUTE");
		return rand * MINUTE;
	}

	public void setPause(int pause) {
		this.pause = pause;
	}
}
