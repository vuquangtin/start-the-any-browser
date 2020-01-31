package com.start.the.any.browser.enums;

import org.apache.log4j.Logger;

import com.start.the.any.browser.start.impl.StartFacebook;

public enum SleepType {
	SECOND(0), MIMUTE(1), HOUR(2), DAY(3); // Hour Day Week Month Season Year
											// Decade Century
	// Millennium Tropical year Sidereal year
	// Samvatsara
	private int key;

	static Logger logger = Logger.getLogger(StartFacebook.class.getName());

	SleepType(int key) {
		this.key = key;
	}

	public int getKey() {
		if (logger.isDebugEnabled()) {
			logger.debug(this.key + ":" + this.key);
		}
		return this.key;
	}
}
