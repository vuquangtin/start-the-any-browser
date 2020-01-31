package com.start.the.any.browser.main;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.BrowserVersionFeatures;
import com.gargoylesoftware.htmlunit.PluginConfiguration;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class UnitTest {

	public static void main(String[] args) throws Exception {
		String URL = "https://www.bloomberg.com/news/articles/2019-10-28/apple-working-on-new-homekit-devices-after-homepod-apple-tv";
		WebClient webClient = new WebClient(BrowserVersion.CHROME);
//		webClient.setWebConnection(new HttpWebConnection(webClient) {
//			@Override
//			protected AbstractHttpClient createHttpClient() {
//				AbstractHttpClient client = super.createHttpClient();
//				try {
//					HttpParams params = client.getParams();
//					params.setParameter(ConnRoutePNames.LOCAL_ADDRESS,
//							InetAddress.getByName("XXX.XXX.XXX.XXX"));
//					client.setParams(params);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//				return client;
//			}
//		});

		webClient.getOptions().setUseInsecureSSL(true);
		webClient.getCookieManager().setCookiesEnabled(true);

		HtmlPage page = (HtmlPage) webClient.getPage(URL);
		BrowserVersion firefox17WithUptoDateFlash = new BrowserVersion(
				BrowserVersion.FIREFOX_17.getApplicationName(),
				BrowserVersion.FIREFOX_17.getApplicationVersion(),
				BrowserVersion.FIREFOX_17.getUserAgent(),
				BrowserVersion.FIREFOX_17.getBrowserVersionNumeric(),
				new BrowserVersionFeatures[] {
						BrowserVersionFeatures.JS_FRAME_RESOLVE_URL_WITH_PARENT_WINDOW,
						BrowserVersionFeatures.STYLESHEET_HREF_EXPANDURL,
						BrowserVersionFeatures.STYLESHEET_HREF_STYLE_NULL });

		PluginConfiguration plugin = new PluginConfiguration("Shockwave Flash",
				"Shockwave Flash 14.0 r0", "NPSWF32_14_0_0_145.dll");
		plugin.getMimeTypes().add(
				new PluginConfiguration.MimeType(
						"application/x-shockwave-flash", "Adobe Flash movie",
						"swf"));

		firefox17WithUptoDateFlash.getPlugins().add(plugin);

		webClient = new WebClient(firefox17WithUptoDateFlash);
		webClient.getOptions().setJavaScriptEnabled(false);
		webClient.getOptions().setThrowExceptionOnScriptError(false);

		// Get the first page
		final HtmlPage page1 = webClient
				.getPage("https://www.example.com/login.html");
	}
}
