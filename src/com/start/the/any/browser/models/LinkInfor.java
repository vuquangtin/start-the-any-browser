package com.start.the.any.browser.models;

public class LinkInfor {
	private String id;
	private String url;
	private String urlPattern;
	private String catePattern;
	private String fileName;
	private boolean acceptParams = false;

	public LinkInfor(String url) {
		this.url = url;
	}

	public LinkInfor(String id, String url) {
		setId(id);
		setUrl(url);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrlPattern() {
		return urlPattern;
	}

	public void setUrlPattern(String urlPattern) {
		this.urlPattern = urlPattern;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getCatePattern() {
		return catePattern;
	}

	public void setCatePattern(String catePattern) {
		this.catePattern = catePattern;
	}

	public boolean getAcceptParams() {
		return acceptParams;
	}

	public void setAcceptParams(boolean acceptParams) {
		this.acceptParams = acceptParams;
	}
}
