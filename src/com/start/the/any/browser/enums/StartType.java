package com.start.the.any.browser.enums;

import org.apache.log4j.Logger;

import com.start.the.any.browser.start.impl.StartFacebook;

public enum StartType {
	FACEBOOK("facebook"), YOUTUBE("youtube"), SESSION("session"), PLAYLIST(
			"playlist"),LOTUS("lotus");

	private String key;

	static Logger logger = Logger.getLogger(StartFacebook.class.getName());

	StartType(String key) {
		this.key = key;
	}

	public String getKey() {
		if (logger.isDebugEnabled()) {
			logger.debug(this.key + ":" + this.key);
		}
		return this.key;
	}
}
