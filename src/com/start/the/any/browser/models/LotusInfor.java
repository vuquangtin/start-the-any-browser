package com.start.the.any.browser.models;

public class LotusInfor {
	private String id;

	// private String url;

	// public LotusInfor(String source) {
	// String arr[] = source.split("\t");
	// if (arr.length == 2) {
	// setId(arr[0]);
	// // setUrl(arr[1]);
	// }
	// }

	public LotusInfor(String id) {
		setId(id);
		// setUrl(url);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	// public String getUrl() {
	// return url;
	// }
	//
	// public void setUrl(String url) {
	// this.url = url;
	// }

	@Override
	public String toString() {
		return id;// + "\t" + url;
	}
}
