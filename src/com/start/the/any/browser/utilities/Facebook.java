package com.start.the.any.browser.utilities;

/**
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:01677443333
 *
 */
public class Facebook {

	// Domain facebook
	public final static String DOMAIN = "facebook.com";
	public final static String M_DOMAIN = "m.facebook.com";
	public final static String MBASIC_DOMAIN = "mbasic.facebook.com";

	// Fabeook url
	public final static String HOME_PAGE = "https://www.facebook.com/";
	public final static String PROFILE_WITH_ID = "https://www.facebook.com/profile.php?id=";
	public final static String HOME_GROUP_PAGE = "https://www.facebook.com/groups/";
	public final static String LOGIN_PAGE = "https://www.facebook.com/login";
	public final static String HOME_PAGE_NO_WWW = "https://facebook.com/";
	public final static String HOME_PAGE_NO_SLASH = "https://www.facebook.com";
	public final static String URL_GRAPH_SEARCH = "https://www.facebook.com/search/";

	public final static String M_LOGIN_PAGE = "https://m.facebook.com/login";
	public final static String M_HOME_PAGE_PHP = "https://m.facebook.com/home.php";
	public final static String M_HOME_PAGE = "https://m.facebook.com/";
	public final static String M_PROFILE_HOME_PAGE_WITH_ID = "https://m.facebook.com/profile.php?id=";
	public final static String M_HOME_PAGE_NO_SLASH = "https://m.facebook.com";
	public final static String M_URL_GRAPH_SEARCH = "https://m.facebook.com/search/";

	public static final String GRAPH_BASEURL_V26 = "https://graph.facebook.com/v2.6";
	public static final String GRAPH_APP = "https://graph.facebook.com/app";
	public static final String GRAPH_APP_WITH_TOKEN = GRAPH_APP+"?access_token=";
	
	public static final String GRAPH_METHOD = "https://api.facebook.com/method/";
	public static final String GRAPH_METHOD_GET_SESSIONG_FOR_APP_WITH_TOKEN= GRAPH_METHOD+"auth.getSessionforApp?access_token=";
	public final static String MESSAGES_PAGE = "https://www.facebook.com/messages/t/";
	public final static String URL_FRIEND_REQUEST = "https://www.facebook.com/friends/requests";
	public final static String URL_FRIEND_RECENT = "friends_recent";

	// 0839100255
	public final static String PHONE_NUMBER_REGEX = "09[0-9]{8}|01[0-9]{9}|9[0-9]{8}|1[0-9]{9}|.*@.*|[0-9]*";// {10}";
	// https://mbasic.facebook.com/xuanphong.pham.391
	public final static String MBASIC_HOME_PAGE = "https://mbasic.facebook.com/";
	public final static String MBASIC_HOME_NO_SLASH = "https://mbasic.facebook.com/";
	public final static String MBASIC_PROFILE_WITH_ID = "https://mbasic.facebook.com/profile.php?id=";
	public final static String MBASIC_GROUPS = "https://mbasic.facebook.com/groups/";
	public final static String MBASIC_URL_GRAPH_SEARCH = "https://mbasic.facebook.com/search/";
	// -----------------------------page-----------------------------
	// https://mbasic.facebook.com/khacvietsinger/?fref=none
	// https://mbasic.facebook.com/duy.phuong.56027281?v=likes&sectionid=9999&lst=100005292333215%3A100007786844073%3A1499496946&startindex=11
	// 11
	// https://mbasic.facebook.com/duy.phuong.56027281?v=likes&sectionid=9999&startindex=22
	public final static String MBASIC_PROFILE_LIKES = "https://mbasic.facebook.com/duy.phuong.56027281?v=likes&sectionid=9999&startindex=22";
	// https://mbasic.facebook.com/profile.php?v=friends&id=100012073517625&startindex=24&refid=17
	public final static String MBASIC_PROFILE_FRIENDS = "https://mbasic.facebook.com/duy.phuong.56027281/friends?refid=61";
	// https://mbasic.facebook.com/subscribe/lists/?id=100007786844073&f=10&t=out
	public final static String MBASIC_PROFILE_FOLLOWING = "https://mbasic.facebook.com/subscribe/lists/?id=100007786844073&f=10&t=out";
	// public final static String MBASIC
	// public final static String MBASIC
	public final static String TOUCH_HOME_PAGE = "https://touch.facebook.com/";
	public static final String FACEBOOK_ME = HOME_PAGE + "me";

	public static final class ServerNormal {
		public static final String REST_URL = "http://api.facebook.com/restserver.php";
		public static final String VIDEO_URL = "http://api-video.facebook.com/restserver.php";
		public static final String SECURE_REST_URL = "https://api.facebook.com/restserver.php";
		public static final String SECURE_REST_AUTH_URL = "https://m.facebook.com/auth.php";
		public static final String API_VERSION = "1.0";
		public static final String LOGIN_URL = "http://www.facebook.com/login.php";
		public static final String PERM_URL = "http://m.facebook.com/authorize.php";
		public static final String SECURE_LOGIN_URL = "https://login.facebook.com/login.php";
		public static final String LOGOUT_URL = "http://www.facebook.com/logout.php";
		public static final String INSTALL_URL = "http://www.facebook.com/install.php";
		public static final String PERM_OK = "http://www.facebook.com";
		public static final String PERM_cancel = "http://www.facebook.com";
	}

	public static final class SecureServer {
		public static final String REST_URL = "https://api.facebook.com/restserver.php";
		public static final String VIDEO_URL = "https://api-video.facebook.com/restserver.php";
		public static final String SECURE_REST_URL = "https://api.facebook.com/restserver.php";
		public static final String SECURE_REST_AUTH_URL = "https://m.facebook.com/auth.php";
		public static final String API_VERSION = "1.0";
		public static final String LOGIN_URL = "https://www.facebook.com/login.php";
		public static final String PERM_URL = "https://m.facebook.com/authorize.php";
		public static final String SECURE_LOGIN_URL = "https://login.facebook.com/login.php";
		public static final String LOGOUT_URL = "https://www.facebook.com/logout.php";
		public static final String INSTALL_URL = "https://www.facebook.com/install.php";
		public static final String PERM_OK = "https://www.facebook.com";
		public static final String PERM_cancel = "https://www.facebook.com";
	}

	// FB REST Parameters
	public static final class RestParameters {
		public static final String API_KEY = "api_key";
		public static final String API_VERSION = "v";
		public static final String FORMAT = "format";
		public static final String METHOD = "method";
		public static final String SESSION_KEY = "session_key";
		public static final String CALL_ID = "call_id";
		public static final String SECRET_KEY = "secret_key";
	};

	public static final class LoginParameters {
		public static final String API_KEY = "api_key";
		public static final String API_VERSION = "v";
		public static final String NEXT_URL = "next";
		public static final String NEXT_Cancel = "next_cancel";
		public static final String AUTH_TOKEN = "auth_token";
		public static final String POPUP = "popup";
		public static final String SKIP_COOKIE = "skipcookie";
		public static final String HIDE_CHECKBOX = "hide_checkbox";
		public static final String CANVAS = "canvas";
		public static final String EMAIL = "email";
		public static final String PASSWORD = "password";
	}

	public static final class InstallParameters {
		public static final String API_KEY = "api_key";
		public static final String NEXT_URI = "next";
	}

	public static final class Format {
		public static final String JSON = "JSON";
		public static final String XML = "XML";
	}

}
