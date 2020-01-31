package com.start.the.any.browser.threads;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.start.the.any.browser.models.LotusInfor;
import com.start.the.any.browser.utilities.FileUtils;

public class ExtractLotusProfileRunnable implements Runnable {
	private String source;
	static Logger logger = Logger.getLogger(ExtractLotusProfileRunnable.class
			.getName());
	// https://lotus.vn/w/profile/24641149332806916.htm
	String pattern = ".*w/profile/(\\d+)\\.htm";
	public final static String LOTUS_PROFILES = "lotus_profiles.txt";
	public final static String INDEX = "index_profiles.txt";
	List<WebElement> listTagA;

	public ExtractLotusProfileRunnable(String source) {
		// logger.debug(source);
		logger.debug("ExtractLotusProfileRunnable");
		setSource(source);

	}

	public ExtractLotusProfileRunnable(List<WebElement> listTagA) {
		this.listTagA = listTagA;

	}

	@Override
	public void run() {
		if (source != null) {
			// logger.debug("source:" + source);
			Pattern regexProfile = Pattern.compile(pattern);
			Matcher matcher = regexProfile.matcher(source);
			String id;
			Set<String> setProfiles = FileUtils
					.loadLotusProfile(LOTUS_PROFILES);
			int i = 0;
			while (matcher.find()) {
				id = matcher.group(1);
				if (i % 10 == 0)
					logger.debug("[" + i + "]id:" + id);
				if (setProfiles.contains(id) == false) {
					try {
						FileUtils.writeUsingFileWriter(LOTUS_PROFILES,
								new LotusInfor(id).toString());
						setProfiles.add(id);
					} catch (IOException e) {
						e.printStackTrace();
					} finally {

					}
				}
				i++;
			}
			// Document doc = Jsoup.parse(source);
			// Elements aTag = doc.select("a");
			// String id;
			// Set<String> setProfiles = FileUtils
			// .loadLotusProfile(LOTUS_PROFILES);
			// for (Element headline : aTag) {
			// String href = headline.absUrl("href");
			// logger.debug("href:" + href);
			// Matcher m = regexProfile.matcher(href);
			// if (m.find()) {
			// id = m.group(1);
			// logger.debug("id:" + id);
			// if (setProfiles.contains(id) == false) {
			// try {
			// FileUtils.writeUsingFileWriter(LOTUS_PROFILES,
			// new LotusInfor(id).toString());
			// setProfiles.add(id);
			// } catch (IOException e) {
			// e.printStackTrace();
			// } finally {
			//
			// }
			// }
			// }
			// }
		} else {
			logger.debug("source==null");
			String href;
			if (listTagA != null) {
				Set<String> setProfiles = FileUtils
						.loadLotusProfile(LOTUS_PROFILES);
				for (WebElement webElement : listTagA) {
					href = webElement.getAttribute("href");
					logger.debug("href:" + href);
					Pattern regexProfile = Pattern.compile(pattern);
					Matcher matcher = regexProfile.matcher(href);
					if (matcher.find()) {
						String id = matcher.group(1);
						logger.debug("id:" + id);
						if (setProfiles.contains(id) == false) {
							try {
								FileUtils.writeUsingFileWriter(LOTUS_PROFILES,
										new LotusInfor(id).toString());
								setProfiles.add(id);
							} catch (IOException e) {
								e.printStackTrace();
							} finally {

							}
						}
					}
				}
			}
		}

	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

}
