package com.start.the.any.browser.previews;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.jsoup.Jsoup;

import com.start.the.any.browser.main.StartBrowser;
import com.start.the.any.browser.utilities.Log4jUtils;

public class OpenIframeLy {
	static Logger logger = Logger.getLogger(StartBrowser.class.getName());

	public static void main(String[] args) throws MalformedURLException,
			IOException {

		logger = Log4jUtils.initLog4j();
		String url = "https://www.bloomberg.com/company/stories/companies-hire-people-disabilities-outperformed-peers/";
		try {

			String jsonUrl = "http://open.iframe.ly/api/iframely?origin=''&url="
					+ url;
			jsonUrl = "http://open.iframe.ly/api/iframely?origin=preview&url=https://www.bloomberg.com/company/stories/companies-hire-people-disabilities-outperformed-peers/";

			// String pageName =
			// obj.getJSONObject("pageInfo").getString("pageName");
			jsonUrl = URLDecoder.decode(new URL(jsonUrl).toExternalForm(),
					StandardCharsets.UTF_8.toString());
			InputStream input = new URL(jsonUrl).openStream();
			Reader reader = new InputStreamReader(input, "UTF-8");
			JSONObject obj = new JSONObject(Jsoup.parse(url));

			logger.debug(obj);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		main2(new URL(url));

	}

	public static void main2(URL url) {
		try {
			URL apiURL = new URL("http://open.iframe.ly/api/oembed?url="
					+ URLEncoder.encode(url.toExternalForm(), "UTF-8")
					+ "&origin=preview");
			logger.debug("  Query " + apiURL);
			HttpURLConnection con = (HttpURLConnection) apiURL.openConnection();
			con.addRequestProperty("Referer", "https://iframely.com/");
			logger.debug("  Code " + con.getResponseCode());
			if (con.getResponseCode() != 200) {
				System.err.println(con.getErrorStream());

			}

			String json = convertStreamToString(con.getInputStream());
			logger.debug("  JSON= " + json);

			JSONObject job = new JSONObject(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	static String convertStreamToString(java.io.InputStream is) {
		java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
		return s.hasNext() ? s.next() : "";
	}
}
