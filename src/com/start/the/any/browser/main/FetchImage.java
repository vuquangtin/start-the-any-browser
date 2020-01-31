package com.start.the.any.browser.main;

import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509TrustManager;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class FetchImage {
	public static void enableSSLSocket() throws KeyManagementException,
			NoSuchAlgorithmException {
		HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
			public boolean verify(String hostname, SSLSession session) {
				return true;
			}
		});

		SSLContext context = SSLContext.getInstance("TLS");
		context.init(null, new X509TrustManager[] { new X509TrustManager() {
			public void checkClientTrusted(X509Certificate[] chain,
					String authType) throws CertificateException {
			}

			public void checkServerTrusted(X509Certificate[] chain,
					String authType) throws CertificateException {
			}

			public X509Certificate[] getAcceptedIssuers() {
				return new X509Certificate[0];
			}
		} }, new SecureRandom());
		HttpsURLConnection.setDefaultSSLSocketFactory(context
				.getSocketFactory());
	}

	public static void main(String[] args) {
		try {
			enableSSLSocket();
		} catch (KeyManagementException | NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Document doc = Jsoup
					.connect(
							"https://baotintuc.vn/the-gioi/lao-rung-chuyen-boi-dong-dat-manh-6-do-rung-lac-cam-nhan-duoc-tai-viet-nam-20191121070814957.htm")
					.get();
			System.out.println(doc.html());

			// Open a URL Stream
			Response resultImageResponse = Jsoup
					.connect(
							"https://cdnmedia.baotintuc.vn/Upload/lQuX6s340fSBU8AUyrDPxg/files/2019/11/dong-dat1_jpg.png")
					.timeout(10000).ignoreHttpErrors(true)
					.ignoreContentType(true).execute();

			// output here
			FileOutputStream out = (new FileOutputStream(new java.io.File(
					"dat1_jpg.png")));
			out.write(resultImageResponse.bodyAsBytes()); // resultImageResponse.body()
															// is where the
															// image's contents
															// are.
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
