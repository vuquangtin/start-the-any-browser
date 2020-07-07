package com.start.the.any.browser.main;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import javax.imageio.ImageIO;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.X509TrustManager;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;

import com.start.the.any.browser.utilities.Log4jUtils;
import com.start.the.any.browser.utilities.RandomUserAgent;

public class GetImage {

	static Logger logger = Logger.getLogger(GetImage.class.getName());

	public static void main(String[] args) throws IOException,
			InterruptedException, ExecutionException, TimeoutException,
			KeyManagementException, NoSuchAlgorithmException {
		logger = Log4jUtils.initLog4j();
		String url = "https://vnn-imgs-f.vgcloud.vn/2020/02/18/08/tuyen-viet-nam-mo-world-cup-can-su-tao-bao-tu-thay-park.jpg";
		URL urlObject = new URL(url);
		BufferedImage image;
		//@see https://stackoverflow.com/questions/28318604/imageio-read-failing-with-no-exception-and-a-vaild-url
		try {
			HttpURLConnection httpcon = (HttpURLConnection) urlObject
					.openConnection();
			image = ImageIO.read(httpcon.getInputStream());
			
			if (image == null) {
				logger.info("read image=null. . .");
				try (CloseableHttpClient httpclient = HttpClients
						.createDefault()) {
					HttpGet httpget = new HttpGet(url);
					try (CloseableHttpResponse response = httpclient
							.execute(httpget);
							InputStream stream = response.getEntity()
									.getContent()) {
						image = ImageIO.read(stream);
						// System.out.println(sourceImg);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (Exception var) {
			logger.error("IGNORED " + var.getMessage(), var);
			logger.info("Start security method . . .");
			var.printStackTrace();
			HttpsURLConnection httpsCon = (HttpsURLConnection) urlObject
					.openConnection();
			httpsCon.setSSLSocketFactory(getSSLContext().getSocketFactory());
			httpsCon.addRequestProperty("User-Agent",
					RandomUserAgent.getRandomUserAgent());
			image = ImageIO.read(httpsCon.getInputStream());
		}
		if (image != null) {
			logger.info(image.getHeight() + "\t" + image.getWidth());
		} else {
			logger.info("null");
		}

	}

	private static SSLContext getSSLContext() throws NoSuchAlgorithmException,
			KeyManagementException {
		/***
		 * Fixed Error javax.net.ssl.SSLHandshakeException:
		 * sun.security.validator.ValidatorException: PKIX path building failed:
		 * sun.security.provider.certpath.SunCertPathBuilderExc ption: unable to
		 * find valid certification path to requested target
		 * 
		 * @see https://stackoverflow.com/questions/19005318/implementing-
		 *      x509trustmanager-passing-on-part-of-the-verification-to-existing
		 */
		SSLContext context = SSLContext.getInstance("TLS");
		context.init(null, new X509TrustManager[] { new X509TrustManager() {
			@Override
			public void checkClientTrusted(X509Certificate[] x509Certificates,
					String s) throws CertificateException {
			}

			@Override
			public void checkServerTrusted(X509Certificate[] x509Certificates,
					String s) throws CertificateException {
			}

			public X509Certificate[] getAcceptedIssuers() {
				return new X509Certificate[0];
			}
		} }, new SecureRandom());
		return context;
	}
}
