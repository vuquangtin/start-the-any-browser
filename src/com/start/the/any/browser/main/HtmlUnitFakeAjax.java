package com.start.the.any.browser.main;

import java.io.File;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HtmlUnitFakeAjax {
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
		SSLContext sslContext = SSLContext.getInstance("SSL");

		// set up a TrustManager that trusts everything
		sslContext.init(null, new TrustManager[] { new X509TrustManager() {
			public X509Certificate[] getAcceptedIssuers() {
				System.out.println("getAcceptedIssuers =============");
				return null;
			}

			public void checkClientTrusted(X509Certificate[] certs,
					String authType) {
				System.out.println("checkClientTrusted =============");
			}

			public void checkServerTrusted(X509Certificate[] certs,
					String authType) {
				System.out.println("checkServerTrusted =============");
			}
		} }, new SecureRandom());

		SSLSocketFactory sf = new SSLSocketFactory(sslContext);
		Scheme httpsScheme = new Scheme("https", 443, sf);
		SchemeRegistry schemeRegistry = new SchemeRegistry();
		schemeRegistry.register(httpsScheme);
		HttpsURLConnection.setDefaultSSLSocketFactory(sslContext
				.getSocketFactory());

	}

	private static final int PORT = 6000;

	public static void main(String[] args) {
		try {
			enableSSLSocket();
		} catch (KeyManagementException | NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.setProperty("javax.net.ssl.keyStore", "keyStore"
				+ File.separatorChar + "keystore.jks");
		System.setProperty("javax.net.ssl.keyStorePassword", "storePassword");
		SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory
				.getDefault();
		
		WebDriver driver = null;
		String URL = "https://www.bloomberg.com/news/articles/2019-10-28/apple-working-on-new-homekit-devices-after-homepod-apple-tv";
		URL = "https://stackoverflow.com/questions/19005318/implementing-x509trustmanager-passing-on-part-of-the-verification-to-existing";
		// URL="http://sport5.vn/w/bong-da/phan-tich-tran-dau/juventus-atletico-de-madrid-1b273958cbb9777c5a0d9305e9ac5df2.htm?utm_source=lotus";
		try {
			// Initiate HtmlUnitDriver object.
			driver = new HtmlUnitDriver();
			// driver..setUseInsecureSSL(true);
			driver.get(URL);
			System.out.println(driver.getTitle());
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	
}
