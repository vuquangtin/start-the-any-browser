package com.start.the.any.browser.main;

import java.io.IOException;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class ExtractUrl {

	public static void main(String[] args)
			throws FailingHttpStatusCodeException, MalformedURLException,
			IOException {

		// Initailzing Webclient Object to imitate chrome browser
		WebClient webClient = new WebClient(BrowserVersion.CHROME);
		webClient.getOptions().setJavaScriptEnabled(false);
		webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
		webClient.getOptions().setThrowExceptionOnScriptError(false);

		HtmlPage page = webClient.getPage("https://dantri.com.vn/");

		// Getting Form from google home page. tsf is the form name
		for (Object a : page.getByXPath("//a")) {
			HtmlAnchor href = (HtmlAnchor) a;
			System.out.println(href.getTextContent());
			System.out.println(href.getHrefAttribute());
		}

	}

}
