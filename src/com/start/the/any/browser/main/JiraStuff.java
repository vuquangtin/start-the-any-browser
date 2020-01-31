package com.start.the.any.browser.main;

import java.io.IOException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;

import javax.net.SocketFactory;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.security.cert.X509Certificate;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlPasswordInput;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;

public class JiraStuff {
	private static WebClient wc = null;
	private static SocketFactory factory = null;
	// private static Socket socket = null;
	private static SSLContext context = null;
	private static HtmlPage page = null;
	private static HtmlForm loginForm = null;
	private static HtmlTextInput username = null;
	private static HtmlSubmitInput submitButton = null;
	private static HtmlPasswordInput password = null;
	private static URL url = null;
	private static HttpsURLConnection connection = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			connectToJira();
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void disableCertificateValidation() {
		// Create a trust manager that does not validate certificate chains
		TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			public void checkClientTrusted(X509Certificate[] certs,
					String authType) {
				return;
			}

			public void checkServerTrusted(X509Certificate[] certs,
					String authType) {
				return;
			}

			@Override
			public void checkClientTrusted(
					java.security.cert.X509Certificate[] arg0, String arg1)
					throws CertificateException {
				// TODO Auto-generated method stub

			}

			@Override
			public void checkServerTrusted(
					java.security.cert.X509Certificate[] arg0, String arg1)
					throws CertificateException {
				// TODO Auto-generated method stub

			}
		} };

		// Install the all-trusting trust manager
		try {
			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, trustAllCerts, new SecureRandom());
			HttpsURLConnection
					.setDefaultSSLSocketFactory(sc.getSocketFactory());
		} catch (Exception e) {
			return;
		}
	}

	public static void connectToJira() throws GeneralSecurityException,
			IOException {
		disableCertificateValidation();
		wc = new WebClient();
		wc.getOptions().setJavaScriptEnabled(false);
		wc.getOptions().setUseInsecureSSL(true);
		factory = SSLSocketFactory.getDefault();
		// socket = factory.createSocket("localhost", 8080);
		context = SSLContext.getInstance("SSL");
		SSLContext sslContext = SSLContext.getInstance(KeyStoreConstant.TLS_PROTOCOL);
		context.init(null, InsecureTrustManager.INSTANCE, null);
		page = (HtmlPage) wc.getPage("https://jira.semantico.com/login.jsp");
		loginForm = (HtmlForm) page.getHtmlElementById("login-form");
		username = (HtmlTextInput) loginForm.getInputByName("os_username");
		username.setValueAttribute(System.getProperty("JiraLogin"));
		password = (HtmlPasswordInput) loginForm.getInputByName("os_password");
		password.setValueAttribute(System.getProperty("JiraPW"));
		submitButton = (HtmlSubmitInput) loginForm.getInputByName("login");
		page = (HtmlPage) submitButton.click();
		// input = new SyndFeedInput();
		// Page
		// page=wc.getPage("https://www.bloomberg.com/news/articles/2019-10-28/apple-working-on-new-homekit-devices-after-homepod-apple-tv");
		// page.getWebResponse().
		String URL = "https://www.bloomberg.com/news/articles/2019-10-28/apple-working-on-new-homekit-devices-after-homepod-apple-tv";
		HtmlPage currentPage = wc.getPage(URL);
		System.out.println(currentPage.getTitleText());
		// url = new
		// URL("https://jira.semantico.com/sr/jira.issueviews:searchrequest-comments-rss/temp/SearchRequest.xml?jqlQuery=issuetype+%3D+Bug+AND+status+%3D+Open+ORDER+BY+updated+DESC%2C+key+DESC&tempMax=5");

	}

	public static class InsecureTrustManager {
		public static final TrustManager[] INSTANCE = new TrustManager[] { new X509TrustManager() {
			private final X509Certificate[] empty = new X509Certificate[] {};

			@Override
			public void checkClientTrusted(
					java.security.cert.X509Certificate[] chain, String authType)
					throws CertificateException {
				// TODO Auto-generated method stub

			}

			@Override
			public void checkServerTrusted(
					java.security.cert.X509Certificate[] chain, String authType)
					throws CertificateException {
				// TODO Auto-generated method stub

			}

			@Override
			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return null;
			}
		} };

		private InsecureTrustManager() {
		}
	}
}
