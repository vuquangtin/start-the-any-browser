package com.start.the.any.browser.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.start.the.any.browser.models.LinkInfor;
import com.start.the.any.browser.utilities.FileUtils;
import com.start.the.any.browser.utilities.Log4jUtils;

public class JsoupMain {
	static Logger logger = Logger.getLogger(StartBrowser.class.getName());

	public static void main(String[] args) {
		logger = Log4jUtils.initLog4j();
		Document doc;
		// String url = "https://dantri.com.vn/";
		String folder = "/home/vuquangtin/workspace/java-selenium/start-the-any-browser/target/";
		Set<String> setUrl = new HashSet<String>();
		List<LinkInfor> listObjects = loadData();
		int index = 0;
		// https://dantri.com.vn/tam-long-nhan-ai/nhung-dua-tre-bi-bo-roi-tung-gap-chu-tich-ubmttq-viet-nam-gio-da-khong-con-coi-cut-20191112140148552.htm
		boolean showLog = false;
		for (LinkInfor item : listObjects) {
			Pattern urlPattern = Pattern.compile(item.getUrlPattern());
			Pattern catePattern = Pattern.compile(item.getCatePattern());
			String key = "";
			List<String> listCateUrl = new ArrayList<String>();
			listCateUrl.add(item.getUrl());
			while (true) {
				try {
					logger.debug("listUrl[" + index + "]):"
							+ listCateUrl.get(index));
					doc = Jsoup.connect(listCateUrl.get(index)).get();
					Elements allUrl = doc.select("a");
					for (Element urlItem : allUrl) {
						// System.out.println(headline.attr("title"));
						String href = urlItem.absUrl("href");
						// if (href.endsWith("htm")) {
						// if (href.matches(".*[0-9]{10,30}\\.htm")) {
						// System.out.println(href);
						// logger.debug("href:" + href);
						// extract url
						Matcher matcher = urlPattern.matcher(href);
						if (matcher.find()) {
							// System.out.println("Found value 0: " +
							// matcher.group(0));
							// System.out.println("Found value 1: " +
							// matcher.group(1));
							int groupCount = matcher.groupCount();
							logger.debug("Number of group = " + groupCount);
							key = matcher.group(groupCount);
							logger.debug("key: " + key);
							if (setUrl.contains(key) == false) {
								if (showLog)
									logger.debug("--->add url href:" + href);
								// System.out.println("href:" + href);
								if (!item.getAcceptParams()) {
									href = removeParams(href);
								}
								FileUtils.writeUsingFileWriter(
										folder + item.getFileName(), href);
								setUrl.add(key);
							} else {
								if (showLog)
									logger.debug("url href exists:" + href);
								// System.out.println(key + ":Exists");
							}
						} else {
							// extract category
							// System.out.println("NO MATCH");
							matcher = catePattern.matcher(href);
							if (matcher.find()) {
								// System.out.println("Found value 0: " +
								// matcher.group(0));
								// System.out.println("Found value 1: " +
								// matcher.group(1));
								// key = matcher.group(2);
								// System.out.println("key: " +
								// matcher.group(2));
								if (showLog)
									logger.debug("cate href:" + href);
								if (!item.getAcceptParams()) {
									href = removeParams(href);
								}
								if (listCateUrl.contains(href) == false) {
									listCateUrl.add(href);
									if (showLog)
										logger.debug("--->add cate href:"
												+ href);
								}
							}

						}

						// } else {
						// System.out.println("add:" + href);
						// if (listUrl.contains(href) == false)
						// listUrl.add(href);
						// }
					}
					// }
					if (showLog)
						logger.debug("--->listCateUrl.size:"
								+ listCateUrl.size());
					index++;
					if (index >= listCateUrl.size())
						break;

				} catch (IOException e) {

					e.printStackTrace();
					index++;
				}
			}
		}

	}

	public static String removeParams(String href) {
		if (href.contains("?"))
			href = href.substring(0, href.indexOf("?"));
		if (href.contains("#"))
			href = href.substring(0, href.indexOf("#"));
		return href;
	}

	public static List<LinkInfor> loadData() {
		List<LinkInfor> listObjects = new ArrayList<LinkInfor>();
		// listObjects.add(loadDataDantri());
		// listObjects.add(loadDataVNExpress());
		// listObjects.add(loadDataVov());
		// listObjects.add(loadDataCand());
		// listObjects.add(loadDataDaidoanket());
		// listObjects.add(loadDataHanoimoi());
		// listObjects.add(loadDataSGGP());
		// listObjects.add(loadDataLaoDong());
		//listObjects.add(loadDataAnhdephd());
		listObjects.add(loadDataGaixinhvip());
		return listObjects;
	}

	public static LinkInfor loadDataGaixinhvip() {
		// https://gaixinhvip.com/gai-viet-nam
		// https://gaixinhvip.com/ung-cu-vien-ran-chu-hong-kong-hong-kong-vo-dich-post21246


		String homepage = "https://gaixinhvip.com/";
		String urlPattern = homepage + "(.*)(-post\\d+)";

		String filename = "lotus_gaixinhvip.txt";

		String catePattern = homepage + "[a-zA-Z0-9-/_]*";
		return loadDataItem(catePattern, urlPattern, homepage, filename);
	}

	public static LinkInfor loadDataAnhdephd() {
		// https://anhdephd.com/
		// https://anhdephd.com/hinh-nen-may-tinh
		// https://anhdephd.com/hinh-nen-noel-full-hd-dep-nhat-ngay-le-giang-sinh-christmas.html

		String homepage = "https://anhdephd.com/";
		String urlPattern = homepage + "([a-zA-Z0-9-_]*)\\.html";

		String filename = "lotus_anhdephd.txt";

		String catePattern = homepage + "[a-zA-Z0-9-/_]*";
		return loadDataItem(catePattern, urlPattern, homepage, filename);
	}

	public static LinkInfor loadDataLaoDong() {
		// https://laodong.vn/
		// https://laodong.vn/bat-dong-san/dau-tu-xay-dung-su-dung-von-nha-nuoc-la-anh-em-voi-tham-nhung-dat-dai-768588.ldo
		// https://laodong.vn/bat-dong-san/

		String homepage = "https://laodong.vn/";
		String urlPattern = homepage + "(.*)(-\\d+)\\.ldo";

		String filename = "lotus_laodong.txt";

		String catePattern = homepage + "[a-zA-Z0-9-/_]*";
		return loadDataItem(catePattern, urlPattern, homepage, filename);
	}

	public static LinkInfor loadDataSGGP() {
		// https://www.sggp.org.vn/
		// https://www.sggp.org.vn/khoahoc_congnghe/
		// https://www.sggp.org.vn/phapluat/
		// https://www.sggp.org.vn/nguyen-pho-bi-thu-huyen-nghia-hanh-de-nghi-bao-ve-tinh-mang-ban-than-gia-dinh-631227.html

		String homepage = "https://www.sggp.org.vn/";
		String urlPattern = homepage + "(.*)(-\\d+)\\.html";

		String filename = "lotus_sggp.txt";

		String catePattern = homepage + "[a-zA-Z0-9-/_]*";
		return loadDataItem(catePattern, urlPattern, homepage, filename);
	}

	public static LinkInfor loadDataHanoimoi() {
		// http://hanoimoi.com.vn/
		// http://hanoimoi.com.vn/tin-tuc/phap-dinh/951457/me-nu-sinh-giao-ga-xin-toa-mot-an-hue
		// http://hanoimoi.com.vn/Danh-muc-tin/189/The-gioi

		String homepage = "http://hanoimoi.com.vn/";
		String urlPattern = homepage + "tin-tuc/(.*)(/\\d+/).*";

		String filename = "lotus_hanoimoi.txt";
		// https://vov.vn/the-gioi/
		// http://cand.com.vn/xa-hoi/
		// http://cand.com.vn/dong-su-kien/39-thi-the-trong-xe-container-dong-lanh-248/
		String catePattern = homepage + "(d|D)anh-muc-tin/.*";
		return loadDataItem(catePattern, urlPattern, homepage, filename);
	}

	public static LinkInfor loadDataDaidoanket() {
		// http://daidoanket.vn/mat-tran
		// http://daidoanket.vn/mat-tran/tang-cuong-su-phoi-hop-giua-mttq-viet-nam-va-chinh-hiep-trung-quoc-tintuc453344
		// http://daidoanket.vn/chinh-tri/van-bang-cua-trung-tam-chinh-tri-cap-huyen-la-dieu-kien-de-xep-ngach-bac-can-bo-cong-chuc-vien-chuc-tintuc453295
		String urlPattern = "http://daidoanket.vn/(.*)(-tintuc\\d+)";
		String homepage = "http://daidoanket.vn/";
		String filename = "lotus_daidoanket.txt";
		// https://vov.vn/the-gioi/
		// http://cand.com.vn/xa-hoi/
		// http://cand.com.vn/dong-su-kien/39-thi-the-trong-xe-container-dong-lanh-248/
		String catePattern = "http://daidoanket.vn/[a-zA-Z-/_]*";
		return loadDataItem(catePattern, urlPattern, homepage, filename);
	}

	public static LinkInfor loadDataCand() {
		// http://cand.com.vn/
		// http://cand.com.vn/Su-kien-Binh-luan-thoi-su/DBQH-Nha-8B-Le-Truc-HH-Linh-Dam-dang-thach-thuc-du-luan-571623/
		String urlPattern = "http://cand.com.vn/[a-zA-Z0-9-]*/(.*)(-\\d+)(|/)";
		String homepage = "http://cand.com.vn/";
		String filename = "lotus_cand.txt";
		// https://vov.vn/the-gioi/
		// http://cand.com.vn/xa-hoi/
		// http://cand.com.vn/dong-su-kien/39-thi-the-trong-xe-container-dong-lanh-248/
		String catePattern = "http://cand.com.vn/[a-zA-Z0-9-/_]*";
		return loadDataItem(catePattern, urlPattern, homepage, filename);
	}

	public static LinkInfor loadDataVov() {
		// https://vov.vn/
		// https://vov.vn/tin-nong/bao-dong-tinh-trang-nguoi-trung-quoc-vi-pham-phap-luat-tai-da-nang-982823.vov
		String urlPattern = "https://vov.vn/(.*)(-\\d+)(\\.vov)";
		String homepage = "https://vov.vn/";
		String filename = "lotus_vov.txt";
		// https://vov.vn/the-gioi/
		String catePattern = "https://vov.vn/[a-zA-Z-0-9/_]";
		return loadDataItem(catePattern, urlPattern, homepage, filename);
	}

	public static LinkInfor loadDataDantri() {
		String urlPattern = "https://dantri.com.vn/(.*)(-\\d+)(\\.htm)";
		String homepage = "https://dantri.com.vn/";
		String filename = "lotus_dantri.txt";
		// https://dantri.com.vn/xa-hoi.htm
		// https://dantri.com.vn/dien-dan/the-gioi.htm
		String catePattern = "https://dantri.com.vn/[a-zA-Z-0-9/_]*\\.htm";
		return loadDataItem(catePattern, urlPattern, homepage, filename);
	}

	// https://vnexpress.net/
	public static LinkInfor loadDataVNExpress() {
		// https://vnexpress.net/kinh-doanh/nha-dau-tu-cocobay-sa-lay-voi-khoan-no-hang-ty-dong-4018402.html?vn_source=Home&vn_campaign=ThuongVien&vn_medium=Item-1&vn_term=Desktop&vn_thumb=1
		String urlPattern = "https://vnexpress.net/(.*)(-\\d+)(\\.html)";
		String homepage = "https://vnexpress.net/";
		String filename = "lotus_vnexpress.txt";
		// https://vnexpress.net/the-thao
		String catePattern = "https://vnexpress.net/[a-zA-Z-/_]";
		return loadDataItem(catePattern, urlPattern, homepage, filename);
	}

	public static LinkInfor loadDataItem(String catePattern, String urlPattern,
			String homepage, String filename) {
		LinkInfor item = new LinkInfor(homepage);
		item.setCatePattern(catePattern);
		item.setUrlPattern(urlPattern);
		item.setFileName(filename);
		return item;
	}
}
