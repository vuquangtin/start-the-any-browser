package com.start.the.any.browser.utilities;

import java.util.List;
import java.util.Random;

import com.start.the.any.browser.models.YoutubeInfo;

public class RandomUtils {
	public YoutubeInfo anyItem(List<YoutubeInfo> listYouTube) {

		Random rand = new Random();
		int index = rand.nextInt(listYouTube.size());

		YoutubeInfo item = listYouTube.get(index);
		listYouTube.remove(index);
		return item;

	}
}
