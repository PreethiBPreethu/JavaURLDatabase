package com.javaassesment.javaurldatabase;

import java.util.Map;

public class DataBaseStore2 {
	
	public static void storeUrl(String url) {
		String shortKey = generateShortKey();
		UrlTablePojo urlInfo = new UrlTablePojo(url, 1);
		Main.table.put(shortKey, urlInfo);
		System.out.println("URL stored successfully. Short Key: " + shortKey);
	}

	public static String getUrlShortKey(String url) {
		for (Map.Entry<String, UrlTablePojo> entry : Main.table.entrySet()) {
			UrlTablePojo urlInfo = entry.getValue();
			if (urlInfo.getUrl().equals(url)) {
				int count = urlInfo.getUsageCount() + 1;
				urlInfo.setUsageCount(count);
				return entry.getKey();
			}
		}
		System.out.println("URL not found.");
		return null;
	}

	public static int getUrlUsageCount(String url) {
		for (UrlTablePojo urlInfo : Main.table.values()) {
			if (urlInfo.getUrl().equals(url)) {
				return urlInfo.getUsageCount();
			}
		}
		System.out.println("URL not found.");
		return -1;
	}

	public static void listUrls() {
		System.out.println("List of URLs and Counts (JSON format):");
		System.out.print("{ ");
		for (Map.Entry<String, UrlTablePojo> entry : Main.table.entrySet()) {
			UrlTablePojo urlInfo = entry.getValue();
			String json = "\"" + entry.getKey() + "\": {\"url\": \"" + urlInfo.getUrl() + "\", \"count\": "
					+ urlInfo.getUsageCount() + "}, ";
			System.out.print(json);
		}
		System.out.println("}");

	}

	public static String generateShortKey() {
		return "shortKey :: " + Main.uniqueCount++;
	}
}
