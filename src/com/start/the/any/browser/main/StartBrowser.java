package com.start.the.any.browser.main;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.start.the.any.browser.configs.ConfigSingleton;
import com.start.the.any.browser.enums.SleepType;
import com.start.the.any.browser.enums.StartType;
import com.start.the.any.browser.start.abs.IStart;
import com.start.the.any.browser.start.impl.StartFacebook;
import com.start.the.any.browser.start.impl.StartListYoutube;
import com.start.the.any.browser.start.impl.StartLotus;
import com.start.the.any.browser.start.impl.StartSession;
import com.start.the.any.browser.start.impl.StartYoutube;
import com.start.the.any.browser.useragent.UserAgentEnum;
import com.start.the.any.browser.utilities.Facebook;
import com.start.the.any.browser.utilities.Log4jUtils;
import com.start.the.any.browser.utilities.Minds;
import com.start.the.any.browser.utilities.OsCheck;

/**
 * Ứng dụng dùng để bắt đầu khởi tạo 1 trình duyệt dựa trên cấu hình và cho phép
 * sinh ra một phiên làm việc cho cấu hình hiện tại. </ul>
 * 
 * @author vuquangtin@gmail.ccom
 */
public class StartBrowser {

	static Logger logger = Logger.getLogger(StartBrowser.class.getName());
	public static final int MILLISECONDS_TO_MINUTES = 60000;
	public static final int MILLISECONDS_TO_SECONDS = 1000;
	private IStart iStart;

	public static void main(String[] args) {
		logger = Log4jUtils.initLog4j();
		boolean seleniumActive = ConfigSingleton.getInstance().getSeleniumActive(true);
		String sessionName = "Default";
		logger.info("seleniumActive:" + seleniumActive);
		if (seleniumActive) {
			sessionName = ConfigSingleton.getInstance().getSessionFolder();
			logger.info("sessionName:" + sessionName);
			// "100026796833604_gmail4_VuThiPhuong";
			// String accessToken = "100011097882370_TEST_USERAGENT";
			boolean enableSaveSession = true;
			if (sessionName == null || !sessionName.matches("[0-9]*_.*")) {
				enableSaveSession = false;
			} else {
				enableSaveSession = true;
			}
			UserAgentEnum userAgent = ConfigSingleton.getInstance()
					.getUserAgentEnum(UserAgentEnum.MAC_Yandex_Browser_171);
			logger.info("userAgent:" + userAgent);
			// isNewSession = false;
			// http://timfb.xyz/menu/get-session-for-app.html
			// AppIdType appIdType = AppIdType.FACEBOOK_FOR_IPHONE;
			// ChromedriverHandler.chromeDriverHandlerThread().start();
			StartBrowser browser = new StartBrowser(sessionName,
					enableSaveSession, userAgent);
			browser.start();
			// ChromedriverHandler.chromeDriverHandlerThread().stop();
			if (logger.isDebugEnabled())
				logger.debug("sleep:100m");
			sleep(100);
		} else {
			sessionName = ConfigSingleton.getInstance().getSessionFolder();
			logger.debug("session:" + sessionName);
			String sessionPath = ConfigSingleton.getInstance().getSessionPath();
			logger.debug("sessionPath:" + sessionPath);
			logger.debug("run:" + Facebook.FACEBOOK_ME);
			String[] cmdarray = null;
			// https://winaero.com/blog/run-google-chrome-with-different-profiles/
			// check chrome chrome://version/
			String chromeBinPath;
			switch (OsCheck.getOperatingSystemType()) {
			case Linux:
				/**
				 * And for Linux:
				 * 
				 * google-chrome --profile-directory=Default
				 */
				// --start-maximized --no-first-run --no-default-browser-check
				chromeBinPath=ConfigSingleton.getInstance().get("googlechrome.bin.path","/opt/google/chrome/chrome");
				cmdarray = new String[] {
						"bash",
						"-c",
						chromeBinPath+" --user-data-dir="
								+ sessionPath + " --profile-directory="
								+ sessionName + " " + Minds.HOME_PAGE };

				break;
			case MacOS:
				//https://stackoverflow.com/questions/34193343/how-to-load-and-launch-a-google-chrome-app-from-the-command-line
				// open -a "Google Chrome" --args --profile-directory=Default
				chromeBinPath=ConfigSingleton.getInstance().get("googlechrome.bin.path","/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
				cmdarray = new String[] {
						"/usr/bin/open",
						"-a",
						chromeBinPath+" --args --user-data-dir="
								+ sessionPath + " --profile-directory="
								+ sessionName + " " + Minds.HOME_PAGE };
				//Runtime.getRuntime().exec(new String[]{"/usr/bin/open", "-a", "/Applications/Google Chrome.app", "http://yourwebsite.com/"});
				break;
			case Other:
				break;
			case Solaris:
				break;
			case Windows:
				break;
			default:
				break;

			}
			if (cmdarray != null) {
				for (String cmdarrayItem : cmdarray) {
					logger.debug("cmdarrayItem:" + cmdarrayItem);
				}
				try {
					Runtime.getRuntime().exec(cmdarray);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

	}

	public boolean start() {
		StartType startType = ConfigSingleton.getInstance().getStartType();
		int sleep = ConfigSingleton.getInstance().getSleep();
		SleepType sleepType = ConfigSingleton.getInstance().getSleepType();
		switch (startType) {
		case FACEBOOK:
			iStart = new StartFacebook(driver, sleep, sleepType, false);
			return iStart.start();
		case YOUTUBE:
			iStart = new StartYoutube(driver, sleep, sleepType, true);
			return iStart.start();
		case SESSION:
			iStart = new StartSession(driver, sleep, sleepType, true);
			return iStart.start();
		case PLAYLIST:
			iStart = new StartListYoutube(driver, sleep, sleepType, true);
			return iStart.start();
		case LOTUS:
			iStart = new StartLotus(driver, sleep, sleepType, false);
			return iStart.start();
		default:
			iStart = new StartFacebook(driver, sleep, sleepType, false);
			return iStart.start();

		}

	}

	WebDriver driver;

	public void initWebDriver() {
		initWebDriver(true, null, UserAgentEnum.SAFARI_MACOS_10_6_8);
	}

	public void initWebDriver(boolean isSaveSessionBrowser,
			UserAgentEnum userAgent) {
		initWebDriver(isSaveSessionBrowser, null, userAgent);
	}

	public void initWebDriver(boolean isSaveSessionBrowser,
			String sessionFolder, UserAgentEnum userAgent) {
		if (driver == null) {
			ConfigSingleton.getInstance().setChromeDriverProperty();
			ConfigSingleton.getInstance().setChromeLogs();
			// System.setProperty("webdriver.chrome.logfile",
			// "/home/tin/eclipse-workspace/FBGrapher/FBGrapher/crawl_data/logs/chromedriver.log");
			ChromeOptions options = new ChromeOptions();
			Map<String, Object> chromePreferences = new HashMap<String, Object>();
			chromePreferences.put(
					"profile.default_content_setting_values.notifications", 2);
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			if (logger.isDebugEnabled())
				logger.debug(capabilities);
			// chromePreferences.put("profile.default_content_settings.popups",
			// 0);
			String downloadDirectory = ConfigSingleton.getInstance()
					.getChromeDownloadDirectory();
			if (downloadDirectory != null) {
				chromePreferences.put("download.default_directory",
						downloadDirectory);
				if (logger.isDebugEnabled())
					logger.debug("download.default_directory:"
							+ downloadDirectory);
			} else {
				if (logger.isDebugEnabled())
					logger.debug("download.default_directory:null");
			}
			//options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200", "--ignore-certificate-errors");
	        options.addArguments("--disable-gpu"); // applicable to windows os only
	        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
	        options.addArguments("--no-sandbox"); // Bypass OS security model
			// options.addExtensions(new File("*Block-image_v1.0.crx"));
			// options.addArguments("ignore-certificate-errors");
			// DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			if (profileId == null) {
				// ----------------- Bước 1: sử dụng user-agent
				// Safari.txt[https://github.com/tamimibrahim17/List-of-user-agents/blob/master/Safari.txt]
				// vượt ckeckpoint
				// 442616890626 : Facebook Touch
				options.addArguments("--user-agent="
						+ UserAgentEnum.SAFARI_MACOS_10_6_8.getUserAgent());
				// "Mozilla/5.0 (Macintosh; U; Intel MacOS X 10_6_7; ja-jp)
				// AppleWebKit/533.20.25 (KHTML, like Gecko)
				// Version/5.0.4Safari/533.20.27");

				// options.addArguments("--user-agent=" + "Mozilla/5.0 (iPhone;
				// CPU iPhone OS
				// 10_3_1 like Mac OS X) AppleWebKit/603.1.30 (KHTML, like
				// Gecko) Version/10.0
				// Mobile/14E304 Safari/602.1");

				profileId = sessionFolder;
			} else {
				// ----------------- Bước 2: sử dụng chrome bình thường
				// 350685531728 : Facebook for Android
				if (userAgent != null) {
					options.addArguments("--user-agent="
							+ userAgent.getUserAgent());
				} else {
					options.addArguments("--user-agent="
							+ "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Ubuntu Chromium/67.0.3396.62 Chrome/67.0.3396.62 Safari/537.36");
				}
			}
			// options.addArguments("--user-agent="
			// + "Mozilla/5.0 (Macintosh; U; Intel MacOS X 10_6_7; ja-jp)
			// AppleWebKit/533.20.25 (KHTML, like Gecko)
			// Version/5.0.4Safari/533.20.27");

			// options.addArguments("--user-agent="
			// + "Mozilla/5.0 (Macintosh; U; PPC Mac OS X 10_4_11; tr)
			// AppleWebKit/528.4+
			// (KHTML, like Gecko) Version/4.0dp1 Safari/526.11.2" );
			// options.addArguments("--no-sandbox");
			// String userAgent = "Mozilla/5.0 (iPad; CPU OS 9_3_2 like Mac OS
			// X)
			// AppleWebKit/600.1.4 (KHTML, like Gecko) 1Password/6.4.2 (like
			// Version/9.3.2
			// Mobile/13F69 Safari/600.1.4)";//
			// RandomUserAgent.getRandomUserAgent();
			// userAgent = UserAgentEnum.SAFARI_MACOS.getUserAgent();
			// logger.debug("--user-agent=" + userAgent);
			// options.addArguments("--user-agent=" + userAgent);
			// options.addArguments("--privileged");
			// options.addArguments("--disable-setuid-sandbox");
			if (isSaveSessionBrowser) {
				options.addArguments("user-data-dir="
						+ ConfigSingleton.getInstance().getSessionPath()
						+ profileId);
				logger.debug("user-data-dir="
						+ ConfigSingleton.getInstance().getSessionPath()
						+ profileId);
			}
			// capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			// ChromeDriverService src = new ChromeDriverService.Builder()
			// .usingDriverExecutable(new
			// File(ConfigSingleton.getInstance().getChromeSeleniumDriverPath()))
			// .usingAnyFreePort().build();
			// try {
			// src.start();
			// } catch (IOException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
			// if (logger.isDebugEnabled())
			// logger.debug("start driver");
			// try {
			// // src,
			// // options.addArguments("disable-infobars");
			// // options.merge(capabilities);
			// options.setExperimentalOption("prefs", chromePreferences);
			// capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS,
			// true);
			// capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			// Map<String, String> environment = new HashMap<String, String>();
			// environment.put("DISPLAY", ":1.5");// 1.5
			// // environment.put("-Dwindow.hide", "false");
			// ChromeDriverService chromeDriverService = new
			// ChromeDriverService.Builder()
			// .usingDriverExecutable(new
			// File(ConfigSingleton.getInstance().getChromeSeleniumDriverPath()))
			// .usingAnyFreePort().withEnvironment(ImmutableMap.of("DISPLAY",
			// ":1")).build();
			// // .withEnvironment(ImmutableMap.of("DISPLAY", ":1"))
			// // String[] listCapability =
			// // { "--start-maximized",
			// // "--disable-extensions", "--disable-translate" };
			// // ----------incognito
			// capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION,
			// true);
			// capabilities.setCapability("chrome.switches",
			// Arrays.asList("--start-maximized", "--disable-extensions",
			// "--disable-translate", "--incognito"));
			// // capabilities.setCapability("chrome.switches",
			// // listCapability);
			//
			// try {
			// chromeDriverService.start();
			// } catch (IOException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
			// listDrivers.add(new ChromeDriver(chromeDriverService,
			// capabilities));// options);

			// driver = new ChromeDriver(capabilities);
			// options.addArguments("--no-sandbox");
			// options.addArguments("--disable-setuid-sandbox");
			try {
				driver = new ChromeDriver(options);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// driver = new ChromeDriver(src, options);
			// RemoteWebDriver driver = new RemoteWebDriver(
			// new URL("http://localhost:4444/wd/hub"),
			// new ChromeOptions());
			// ChromeOptions options = new ChromeOptions();
			// options.addArguments("disable-infobars");
			// options.merge(capabilities);
			if (logger.isDebugEnabled())
				logger.debug("end driver");
			if (driver != null) {
				// driver.manage().timeouts().implicitlyWait(10,
				// TimeUnit.SECONDS);
				driver.manage().timeouts()
						.implicitlyWait(12000, TimeUnit.SECONDS);
				driver.manage().window().maximize();

				if (!isSaveSessionBrowser)
					driver.manage().deleteAllCookies();
			}
			// } catch (org.openqa.selenium.WebDriverException e) {
			// e.printStackTrace();
			// } catch (Exception e) {
			// e.printStackTrace();
			// }

		}
	}

	String profileId = null;

	public StartBrowser(String fbSession, boolean isSaved,
			UserAgentEnum userAgent) {
		if (fbSession != null) {
			startBrowser(fbSession, isSaved, userAgent);
		}

	}

	public boolean startBrowser(String fbSession, boolean isSaved,
			UserAgentEnum userAgent) {
		// if (fbSession.matches("[0-9]*") || fbSession.matches("[0-9]*_.*")) {
		profileId = fbSession;
		if (driver == null) {
			if (isSaved) {
				if (logger.isDebugEnabled())
					logger.debug("isSaveSessionBrowser:" + isSaved);
				try {
					initWebDriver(isSaved, userAgent);
					// driver =
					// ChromeDriverHelper.getInstance(profileId).getChromeDriver();
					// driver.manage().timeouts().implicitlyWait(30,
					// TimeUnit.SECONDS);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				if (logger.isDebugEnabled())
					logger.debug("isSaveSessionBrowser:" + isSaved);
				initWebDriver(isSaved, userAgent);
				// ConfigSingleton.getInstance().setChromeDriverProperty();
				// driver = new ChromeDriver();
				// driver.manage().window().maximize();
				// driver.manage().deleteAllCookies();
				// driver.manage().timeouts().implicitlyWait(30,
				// TimeUnit.SECONDS);
			}
		}
		initWebDriver();
		// }
		return false;
	}

	public static void sleep(int minutes) {
		sleep(minutes, "", "");
	}

	public static void sleep(int minutes, String message, String getMessage) {
		try {
			if (logger.isDebugEnabled())
				logger.debug(message + ":" + "(pleep " + minutes
						+ "p)\nMessage:" + getMessage);
			Thread.sleep(minutes * MILLISECONDS_TO_MINUTES);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void pause(String pauseMessage) {
		try {
			int minutes = 30;
			if (logger.isDebugEnabled())
				logger.debug(pauseMessage + ":" + "(pleep " + minutes + "m)");
			Thread.sleep(minutes * MILLISECONDS_TO_MINUTES);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void sleepSeconds(int seconds, String message) {
		try {
			if (logger.isDebugEnabled())
				logger.debug(message + ":" + "(pleep " + seconds + " seconds)");
			Thread.sleep(seconds * MILLISECONDS_TO_SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void sleepSecondsAndAutoScrolling(JavascriptExecutor js,
			WebDriver driver, int seconds, String message) {
		boolean isScrollDown = true;
		int minSpleep = 60;
		int maxCount = 1;
		int index = 0;
		if (seconds > minSpleep) {
			maxCount = seconds / minSpleep;
		}
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		while (true) {
			try {
				index++;
				if (logger.isDebugEnabled())
					logger.debug(message + ":"
							+ "(sleepSecondsAndAutoScrolling " + seconds
							+ " seconds)");
				try {
					if (isScrollDown) {
						driver.manage().timeouts()
								.implicitlyWait(60, TimeUnit.SECONDS);
						js.executeScript("window.scrollTo(0,document.body.scr‌​ollHeight);");
						isScrollDown = false;
					} else {
						driver.manage().timeouts()
								.implicitlyWait(60, TimeUnit.SECONDS);
						js.executeScript("window.scrollTo(0,0);");
						isScrollDown = true;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (seconds > minSpleep) {
					seconds = seconds - minSpleep;
					Thread.sleep(minSpleep * MILLISECONDS_TO_SECONDS);
				} else {
					Thread.sleep(seconds * MILLISECONDS_TO_SECONDS);
					break;
				}
				if (index >= maxCount)
					break;
			} catch (InterruptedException e) {
				e.printStackTrace();
				break;
			}
		}
	}

}

// String windowSize = "1920,1200";
// options.addArguments("--headless",
// "--disable-gpu",
// "--incognito",
// "--whitelisted-ips=''",
// "window-size=" + windowSize);
// options.setBinary("/Users/admin/Downloads/googlechrome.dmg");
// options.addArguments("--headless");
// options.addArguments("--start-maximized");
// options.addArguments("--disable-cache");
// options.addArguments("--disable-cached-picture-raster");
// options.addArguments("--disable-accelerated-mjpeg-decode");
// options.addArguments("--disable-accelerated-2d-canvas");
// options.addArguments("--disable-accelerated-jpeg-decoding");
// options.addArguments("--disable-accelerated-video-decode");
// options.addArguments("--disable-affiliation-based-matching");
// options.addArguments("--disable-appcontainer");
// options.addArguments("--disable-auto-hiding-toolbar-threshold");
// options.addArguments("--disable-autofill-keyboard-accessory-view");
// options.addArguments("--disable-background-networking");
// options.addArguments("--disable-backing-store-limit");
// options.addArguments("--disable-blink-features");
// options.addArguments("--disable-boot-animation");
// options.addArguments("--disable-breakpad");
// options.addArguments("--disable-bundled-ppapi-flash");
// options.addArguments("--disable-canvas-aa");
// options.addArguments("--disable-cast-streaming-hw-encoding");
// options.addArguments("--disable-child-account-detection");
// options.addArguments("--disable-clear-browsing-data-counters");
// options.addArguments("--disable-client-side-phishing-detection");
// options.addArguments("--disable-cloud-import");
// options.addArguments("--disable-component-cloud-policy");
// options.addArguments("--disable-component-extensions-with-background-pages");
// options.addArguments("--disable-component-update");
// options.addArguments("--disable-core-animation-plugins");
// options.addArguments("--disable-credit-card-scan");
// options.addArguments("--disable-d3d11");
// options.addArguments("--disable-databases");
// options.addArguments("--disable-datasaver-prompt");
// options.addArguments("--disable-default-apps");
// options.addArguments("--disable-delay-agnostic-aec");
// options.addArguments("--disable-demo-mode");
// options.addArguments("--disable-device-disabling");
// options.addArguments("--disable-device-discovery-notifications");
// options.addArguments("--disable-dinosaur-easter-egg");
// options.addArguments("--disable-direct-npapi-requests");
// options.addArguments("--disable-display-list-2d-canvas");
//
// options.addArguments("--disable-distance-field-text");
// options.addArguments("--disable-domain-blocking-for-3d-apis");
// options.addArguments("--disable-domain-reliability");
// options.addArguments("--disable-drive-search-in-app-launcher");
// options.addArguments("--disable-drop-sync-credential");
// options.addArguments("--disable-dwm-composition");
// options.addArguments("--disable-encrypted-media");
// options.addArguments("--disable-experimental-app-list");
// options.addArguments("--disable-extensions");
// options.addArguments("--disable-extensions-file-access-check");
// options.addArguments("--disable-extensions-http-throttling");
// options.addArguments("--disable-features");
// options.addArguments("--disable-field-trial-config");
// options.addArguments("--disable-file-system");
// options.addArguments("--disable-fill-on-account-select");

/*
 * options.addArguments("--disable-flash-3d");
 * options.addArguments("--disable-flash-stage3d");
 * options.addArguments("--disable-full-form-autofill-ios");
 * options.addArguments("--disable-gaia-services"); options.addArguments
 * ("--disable-gesture-requirement-for-media-playback");
 * options.addArguments("--disable-gl-drawing-for-tests");
 * options.addArguments("--disable-gl-error-limit");
 * options.addArguments("--disable-gl-extensions");
 * options.addArguments("--disable-glsl-translator");
 */

// options.addArguments("--disable-gpu");
// options.addArguments("--disable-gpu-compositing");
// options.addArguments("--disable-gpu-driver-bug-workarounds");
// options.addArguments("--disable-gpu-early-init");
// options.addArguments("--disable-gpu-memory-buffer-compositor-resources");
// options.addArguments("--disable-gpu-memory-buffer-video-frames");
// options.addArguments("--disable-gpu-process-crash-limit");
// options.addArguments("--disable-gpu-program-cache");
// options.addArguments("--disable-gpu-rasterization");
// options.addArguments("--disable-gpu-sandbox");
// options.addArguments("--disable-gpu-shader-disk-cache");
// options.addArguments("--disable-gpu-vsync");
// options.addArguments("--disable-gpu-watchdog");
// options.addArguments("--disable-hang-monitor");
// options.addArguments("--disable-hid-detection-on-oobe");
// options.addArguments("--disable-hide-inactive-stacked-tab-close-buttons");
// options.addArguments("--disable-histogram-customizer");
// options.addArguments("--disable-hosted-app-shim-creation[5]");
// options.addArguments("--disable-hosted-apps-in-windows[5]");
// options.addArguments("--disable-icon-ntp");
// options.addArguments("--disable-infobars");
// options.addArguments("--disable-input-view");
// options.addArguments("--disable-ios-password-generation");
// options.addArguments("--disable-ios-password-suggestions");
// options.addArguments("--disable-ipv4");
// options.addArguments("--disable-ipv6");
// options.addArguments("--disable-javascript-harmony-shipping");
// options.addArguments("--disable-keyboard-commands");
// options.addArguments("--disable-kill-after-bad-ipc");
// options.addArguments("--disable-lcd-text");
// options.addArguments("--disable-legacy-window[6]");
// options.addArguments("--disable-local-storage");
// options.addArguments("--disable-logging");
// options.addArguments("--disable-login-animations");
// options.addArguments("--disable-low-end-device-mode");
// options.addArguments("--disable-low-res-tiling");
// options.addArguments("--disable-lru-snapshot-cache");
// options.addArguments("--disable-mac-overlays[10]");
// options.addArguments("--disable-mac-views-native-app-windows[5]");
// options.addArguments("--disable-main-frame-before-activation");
// options.addArguments("--disable-manager-for-sync-signin");
// options.addArguments("--disable-md-downloads");
// options.addArguments("--disable-media-source");
// options.addArguments("--disable-media-thread-for-media-playback[8]");
// options.addArguments("--disable-merge-key-char-events[6]");
// options.addArguments("--disable-method-check");
//
// options.addArguments("--disable-minimize-on-second-launcher-item-click");
// options.addArguments("--disable-mojo-channel");
// options.addArguments("--disable-mtp-write-support");
// options.addArguments("--disable-multilingual-spellchecker[11]");
// options.addArguments("--disable-namespace-sandbox");
// options.addArguments("--disable-native-gpu-memory-buffers");
// options.addArguments("--disable-network-portal-notification");
// options.addArguments("--disable-new-app-list-mixer");
// options.addArguments("--disable-new-bookmark-apps");
// options.addArguments("--disable-new-channel-switcher-ui");
// options.addArguments("--disable-new-kiosk-ui");
// options.addArguments("--disable-new-korean-ime");
// options.addArguments("--disable-new-profile-management");
// options.addArguments("--disable-new-task-manager[12]");
// options.addArguments("--disable-new-zip-unpacker");
// options.addArguments("--disable-notifications");
// options.addArguments("--disable-ntp-favicons");
// options.addArguments("--disable-ntp-popular-sites");
// options.addArguments("--disable-offer-store-unmasked-wallet-cards");
// options.addArguments("--disable-offer-upload-credit-cards");
// options.addArguments("--disable-office-editing-component-extension");
// options.addArguments("--disable-offline-auto-reload");
// options.addArguments("--disable-offline-auto-reload-visible-only");
// options.addArguments("--disable-offline-pages");
// options.addArguments("--disable-out-of-process-pac");

/*
 * options.addArguments("--disable-overlay-scrollbar"); options
 * .addArguments("--disable-overscroll-edge-effect[8]");
 * options.addArguments("--disable-page-visibility");
 * options.addArguments("--disable-panel-fitting[7]");
 * options.addArguments("--disable-password-generation"); options .addArguments(
 * "--disable-password-manager-reauthentication" ); options
 * .addArguments("--disable-password-separated-signin-flow" );
 * options.addArguments("--disable-pdf-material-ui");
 * options.addArguments("--disable-pepper-3d");
 * options.addArguments("--disable-permissions-api"); options.addArguments
 * ("--disable-physical-keyboard-autocorrect");
 * options.addArguments("--disable-pinch");
 * options.addArguments("--disable-plugins-discovery");
 * options.addArguments("--disable-pnacl-crash-throttling"); options
 * .addArguments("--disable-policy-key-verification");
 * options.addArguments("--disable-popup-blocking");
 * options.addArguments("--disable-preconnect"); options.addArguments
 * ("--disable-prefer-compositing-to-lcd-text");
 * options.addArguments("--disable-presentation-api");
 * options.addArguments("--disable-print-preview");
 * options.addArguments("--disable-prompt-on-repost"); options
 * .addArguments("--disable-pull-to-refresh-effect[8]"); options
 * .addArguments("--disable-push-api-background-mode");
 * options.addArguments("--disable-quic");
 * options.addArguments("--disable-quic-port-selection");
 * options.addArguments("--disable-reading-from-canvas"); options
 * .addArguments("--disable-remote-core-animation[10]");
 * options.addArguments("--disable-remote-fonts");
 * options.addArguments("--disable-renderer-accessibility");
 * options.addArguments("--disable-renderer-backgrounding");
 * options.addArguments("--disable-rgba-4444-textures");
 * options.addArguments("--disable-rollback-option"); options
 * .addArguments("--disable-rtc-smoothness-algorithm"); options
 * .addArguments("--disable-save-password-bubble[5]"); options
 * .addArguments("--disable-screen-orientation-lock[8]");
 * options.addArguments("--disable-seccomp-filter-sandbox");
 * options.addArguments("--disable-session-crashed-bubble");
 * options.addArguments("--disable-settings-window");
 * options.addArguments("--disable-setuid-sandbox");
 * options.addArguments("--disable-shader-name-hashing");
 * options.addArguments("--disable-shared-workers"); options.
 * addArguments("--disable-signin-scoped-device-id"); options
 * .addArguments("--disable-simplified-fullscreen-ui");
 * options.addArguments("--disable-single-click-autofill"); options
 * .addArguments("--disable-site-engagement-service");
 * options.addArguments("--disable-smooth-scrolling");
 * options.addArguments("--disable-software-rasterizer"); options
 * .addArguments("--disable-spdy-proxy-dev-auth-origin");
 * options.addArguments("--disable-speech-api");
 * options.addArguments("--disable-surfaces");
 * options.addArguments("--disable-svg1dom");
 * options.addArguments("--disable-sync");
 * options.addArguments("--disable-sync-app-list");
 * options.addArguments("--disable-sync-backup");
 * options.addArguments("--disable-sync-rollback");
 * options.addArguments("--disable-sync-types");
 * options.addArguments("--disable-tab-switcher");
 * options.addArguments("--disable-threaded-animation");
 * options.addArguments("--disable-threaded-compositing");
 * options.addArguments("--disable-threaded-scrolling"); options
 * .addArguments("--disable-timezone-tracking-option");
 * options.addArguments("--disable-touch-adjustment");
 * options.addArguments("--disable-touch-drag-drop");
 * options.addArguments("--disable-touch-feedback");
 * options.addArguments("--disable-translate");
 * options.addArguments("--disable-translate-new-ux[5]");
 * options.addArguments("--disable-usb-keyboard-detect[6]");
 * options.addArguments("--disable-v8-idle-tasks"); options.addArguments
 * ("--disable-vaapi-accelerated-video-encode[7]"); options.addArguments
 * ("--disable-views-rect-based-targeting"); options
 * .addArguments("--disable-virtual-keyboard-overscroll");
 * options.addArguments("--disable-voice-input");
 * options.addArguments("--disable-volume-adjust-sound");
 * options.addArguments("--disable-wake-on-wifi"); options.addArguments
 * ("--disable-web-notification-custom-layouts");
 * options.addArguments("--disable-web-resources");
 * options.addArguments("--disable-web-security");
 * options.addArguments("--disable-webaudio");
 * options.addArguments("--disable-webgl");
 * options.addArguments("--disable-webrtc-encryption[13]");
 * options.addArguments("--disable-webrtc-hw-decoding[13]");
 * options.addArguments("--disable-webrtc-hw-encoding[13]"); options
 * .addArguments("--disable-webrtc-multiple-routes[13]"); options
 * .addArguments("--disable-win32k-renderer-lockdown[6]");
 * options.addArguments("--disable-wkwebview");
 * options.addArguments("--disable-x-token");
 * options.addArguments("--disable-xss-auditor"); options.addArguments
 * ("--disable-zero-browsers-open-for-tests");
 * options.addArguments("--disable-zero-copy");
 * options.addArguments("--disabled"); options.addArguments(
 * "--disallow-autofill-sync-credential" ); options .addArguments(
 * "--disallow-autofill-sync-credential-for-reauth" ); options.addArguments(
 * "--disallow-unchecked-dangerous-downloads[3]");
 * options.addArguments("--disk-cache-dir");
 * options.addArguments("--disk-cache-size");
 */
/*
 * Login Facebook using token. Step: <ul> <li>
 * https://graph.facebook.com/app?access_token=
 * EAAAAAYsX7TsBACYGeQCZACJ4eitGyYmtreA1CxVuUSyk9iyShB9EXjs74YFBqR1ZCULf5SHLIeoloFzAKbqRw8aOCT2tW73mOM7VMV4e21SXWZCo3R22lLMIl5oNZCpZBD7ovqFUL05ZBm3SqmYgPZBSKZCkdRRetSCHlSZBOAvek2j1aZBYwjdkWcuythHSA6j5Ak4cjSOaZBldBZCbUdR0YIrd
 * </li> <li>
 * https://api.facebook.com/method/auth.getSessionforApp?access_token=
 * EAAAAAYsX7TsBACYGeQCZACJ4eitGyYmtreA1CxVuUSyk9iyShB9EXjs74YFBqR1ZCULf5SHLIeoloFzAKbqRw8aOCT2tW73mOM7VMV4e21SXWZCo3R22lLMIl5oNZCpZBD7ovqFUL05ZBm3SqmYgPZBSKZCkdRRetSCHlSZBOAvek2j1aZBYwjdkWcuythHSA6j5Ak4cjSOaZBldBZCbUdR0YIrd
 * &format=json&new_app_id=6628568379&generate_session_cookies=1</li>
 */