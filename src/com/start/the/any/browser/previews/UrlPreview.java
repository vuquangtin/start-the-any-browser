package com.start.the.any.browser.previews;

public class UrlPreview {
	/****
	 * use http://api.linkpreview.net/?key=5942e7
	 * ef52f4c5b3bf4389318384e5ab760ab91faaec9
	 * &q=https://www.bloomberg.com/company
	 * /stories/hustle-drive-determination-two
	 * -bloomberg-employees-benefits-hiring
	 * -working-first-generation-college-graduates/
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// http://api.linkpreview.net/?key=5bb905e4709c07d0c5dcce206d1a180df48ebcbd42e33

		// http://api.linkpreview.net/?key=5942e7ef52f4c5b3bf4389318384e5ab760ab91faaec9&q=https://www.linkpreview.net/docs
		// 5c7061cb8b2d714407ebebef881f1a536ffa36a9b8f6b
		// 5bb905e4709c07d0c5dcce206d1a180df48ebcbd42e33
		// TODO Auto-generated method stub
		// hiện tại đã fixed xong chỉ còn các site chặn theo IP thì không lấy dc
		// như
		// https://www.bloomberg.com/company/diversity-inclusion/?utm_source=bloomberg-menu&utm_medium=bcom
		// Cái này các mạng xã hội # như minds.com sử dụng của bên thứ ba là
		// dùng api của
		// https://iframely.com/plans
		// chi tiết sử dung minds:
		// https://gitlab.com/minds/engine/blob/master/Controllers/api/v1/newsfeed/preview.php
		//
		// https://www.minds.com/api/v1/newsfeed/preview?url=http://kenh14.vn/lisa-blackpink-co-chum-anh-selfie-voi-do-an-khien-fan-vua-doi-vua-thieu-nghi-luc-nhin-vao-doi-mat-ay-la-quen-ca-them-an-20191128121931301.chn?utm_source=lotus&utm_campaign=lotus&utm_medium=lotus
		// co the mua 1tr requet/thang/400$
		// thank
		// http://open.iframe.ly/api/iframely?origin=
		// http://open.iframe.ly/api/oembed?origin=preview&url=https://gitlab.com/minds/engine/blob/master/Controllers/api/v1/newsfeed/preview.php
		// http://iframe.ly/api/oembed?origin=

		// https://oembed.com/
		// ---------------------OK
		// https://github.com/JohnGrieco/clius-site/blob/8126561ea0696f852d3ddb9ffce02e1b4ea5c611/client/main.html
		// http://open.iframe.ly/api/iframely?origin=minds&api_key=443e12d67f0fd27373378b&url=https://www.bloomberg.com/news/articles/2019-12-02/hong-kong-to-post-first-budget-deficit-in-15-years-chan-says?srnd=premium-asia

		// https://github.com/kemist/glitch-hello-express/blob/0e32d2f781dca2ea3c388385e3e5c03283803b0e/views/index.html
		// http://open.iframe.ly/api/iframely?origin=preview&api_key=57924d18254bf0be219387&url=https://www.bloomberg.com/news/articles/2019-12-02/hong-kong-to-post-first-budget-deficit-in-15-years-chan-says?srnd=premium-asia
		// 2017
		// https://github.com/anorudes/medium-editor-embed-plugin/blob/298dec754ac84e051bec2c1a597082aea46f2e85/examples/index.html
		// http://open.iframe.ly/api/iframely?origin=preview&api_key=a4920851894431b9654fc5&url=https://www.bloomberg.com/news/articles/2019-12-02/hong-kong-to-post-first-budget-deficit-in-15-years-chan-says?srnd=premium-asia
		// 2017
		// https://github.com/kaypiKun/IonicFirebasePOC/blob/30a31556accdb3724f5f97a13a376874a855d20c/chatPOC/www/js/controllers.js
		// http://open.iframe.ly/api/iframely?origin=preview&api_key=31d4151b543e7f5df7c092&url=https://www.bloomberg.com/news/articles/2019-12-02/hong-kong-to-post-first-budget-deficit-in-15-years-chan-says?srnd=premium-asia

		// 2018
		// https://github.com/calebstrait/Lynx/blob/b50c646d4dd0c1ab78218277fcb5d78f2977fa70/flaskgames/templates/home.html
		// http://open.iframe.ly/api/iframely?origin=preview&api_key=5cb8504ea0e83577845b2b&url=https://www.bloomberg.com/news/articles/2019-12-02/hong-kong-to-post-first-budget-deficit-in-15-years-chan-says?srnd=premium-asia

		// 2018
		// https://github.com/nguyenvo09/fake_news_detection_deep_learning/blob/415676e87ef4e9b8849b45ba6abe82a1b613b252/crawled_websites/392.html
		// http://open.iframe.ly/api/iframely?origin=preview&api_key=63223a46998ecbfe2d26ff&url=https://www.bloomberg.com/news/articles/2019-12-02/hong-kong-to-post-first-budget-deficit-in-15-years-chan-says?srnd=premium-asia
		// http://iframe.ly/api/oembed?origin=discovery&api_key=63223a46998ecbfe2d26ff&url=https://www.snopes.com/muslims-open-fire-hikers/&format=json
		// http://iframe.ly/api/oembed?origin=discovery&api_key=63223a46998ecbfe2d26ff&url=https://www.snopes.com/muslims-open-fire-hikers/&format=xml

		// 2019
		// https://github.com/MadBlackCat/gplay_privacy/blob/2845c513a0dd6637560c9ae273e96616931a8c32/privacy_policy/roosterteeth.com.html
		// http://open.iframe.ly/api/iframely?origin=preview&api_key=902662807c91d691b05056&url=https://www.bloomberg.com/news/articles/2019-12-02/hong-kong-to-post-first-budget-deficit-in-15-years-chan-says?srnd=premium-asia
	}

}
