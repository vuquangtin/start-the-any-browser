package com.start.the.any.browser.main;

import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.Security;

import javax.net.ssl.HttpsURLConnection;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;

public class SSLMain {
	public static void main(String a[]) throws Exception {
		System.setProperty("java.protocol.handler.pkgs",
				"com.sun.net.ssl.internal.www.protocol");
		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

		URL url = new URL(
				"https://dantri.com.vn/the-thao/doi-tuyen-viet-nam-thang-tien-ky-luc-tren-bang-xep-hang-fifa-20191128214633314.htm");
		URLConnection con = url.openConnection();

		if (con instanceof HttpsURLConnection) {
			System.out.println("https");
		} else if (con instanceof HttpURLConnection) {
			System.out.println("http");
		}
		// Open a URL Stream
		String imageLocation = "https://icdn.dantri.com.vn/thumb_w/640/2019/11/28/bxh-chau-a-1574952108644.png";
		Response resultImageResponse = Jsoup.connect(imageLocation)
				.ignoreContentType(true).execute();

		// output here
		FileOutputStream out = (new FileOutputStream(new java.io.File(
				"1574952108644.png")));
		out.write(resultImageResponse.bodyAsBytes()); // resultImageResponse.body()
														// is where the image's
														// contents are.
		out.close();

	}
}
