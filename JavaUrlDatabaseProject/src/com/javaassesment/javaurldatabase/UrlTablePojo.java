package com.javaassesment.javaurldatabase;

public class UrlTablePojo {

	private String url;
	private int usageCount;

	public UrlTablePojo(String url, int usageCount) {
		super();
		this.url = url;
		this.usageCount = usageCount;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getUsageCount() {
		return usageCount;
	}

	public void setUsageCount(int usageCount) {
		this.usageCount = usageCount;
	}

	@Override
	public String toString() {
		return "UrlInfo [url=" + url + ", usageCount=" + usageCount + "]";
	}
}
