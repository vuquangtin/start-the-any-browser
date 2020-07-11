package com.start.the.any.browser.main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.start.the.any.browser.utilities.Log4jUtils;

/***
 * ./start-tor-browser --detach google.com --profile
 * /home/vuquangtin/Desktop/Browser2/Data/Browser/profile
 * 
 * -marionette --detach https://google.com -foreground -no-remote -profile
 * /tmp/rust_mozprofileQEWlI8
 * 
 * @author vuquangtin
 *
 */
public class OpenTorBrowser {
	static Logger logger = Logger.getLogger(OpenTorBrowser.class.getName());
	private static WebDriver driver;

	private StringBuffer verificationErrors = new StringBuffer();
	public static final String COOKIE_FILE = "/home/vuquangtin/Desktop/Browser/Data/Browser/profile.default/control_auth_cookie";
	public static final String pathStartTorBrowser = "/home/vuquangtin/Desktop/Browser/start-tor-browser";
	public static final String profilePath = "/home/vuquangtin/Desktop/Browser/Data/Browser/profile.default";
	public static final String chromedriver = "/home/vuquangtin/workspace/crawl_data/drivers/chromedriver/linux64/chromedriver";

	public static void main(String[] args) {
		logger = Log4jUtils.initLog4j();
		String url = "https://google.com";
		String geckodriver = "geckodriver";

		try {
			// new OpenTorBrowser().runTorBrowser(url, pathStartTorBrowser,
			// profilePath, geckodriver);

			 new OpenTorBrowser().newConectionTorBrowser(url, geckodriver,
			 pathStartTorBrowser, profilePath);

//			 new OpenTorBrowser().connectionSeleniumTor(url, geckodriver,
//			 pathStartTorBrowser, profilePath);

			//new OpenTorBrowser().runWeb(url, pathStartTorBrowser);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void runTor(String baseUrl, String pathStartTorBrowser,
			String geckodriver) {
		System.setProperty("webdriver.gecko.driver", geckodriver);
		// "D:\\geckodriver-v0.10.0-win64\\geckodriver.exe"
		String torPath = "C:\\Users\\Dave\\Desktop\\Tor Browser\\Browser\\firefox.exe";
		//String profilePath = "C:\\Users\\Dave\\Desktop\\Tor Browser\\Browser\\TorBrowser\\Data\\Browser\\profile.default";
		FirefoxProfile torProfile = new FirefoxProfile(new File(profilePath));
		FirefoxBinary binary = new FirefoxBinary(new File(torPath));
		torProfile.setPreference("webdriver.load.strategy", "unstable");
		try {
			binary.startProfile(torProfile, new File(profilePath), "");
		} catch (IOException e) {
			e.printStackTrace();
		}
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("network.proxy.type", 1);
		profile.setPreference("network.proxy.socks", "127.0.0.1");
		profile.setPreference("network.proxy.socks_port", 9150);
		//WebDriver driver = new FirefoxDriver(binary, profile);
		//driver.get("https://www.google.com");
	}

	private static void runWeb(String baseUrl, String pathStartTorBrowser)
			throws IOException, InterruptedException {
		Runtime.getRuntime().exec(pathStartTorBrowser);
	}

	public void runTorBrowser(String baseUrl, String pathStartTorBrowser,
			String profilePath, String geckodriver) {
		logger.debug("runTorBrowser:" + baseUrl);
		// String profilePath =
		// "/home/vuquangtin/Desktop/Browser/Data/Browser/profile.default/";
		FirefoxProfile profile = new FirefoxProfile(new File(profilePath));
		FirefoxBinary binary = new FirefoxBinary(new File(pathStartTorBrowser));
		FirefoxOptions firefoxOptions = new FirefoxOptions().setBinary(binary);
		firefoxOptions.setCapability(CapabilityType.BROWSER_NAME,
				BrowserType.FIREFOX);
		firefoxOptions.setProfile(profile);
		// firefoxOptions.addArguments("--profile " + profilePath);
		List<String> listArguments = new ArrayList<String>();
		listArguments.add("--detach");
		listArguments.add(baseUrl);
		// firefoxOptions.addArguments();
		// firefoxOptions.addArguments(baseUrl);
		// firefoxOptions.addArguments("--window-size=1280,1024");
		// firefoxOptions.addArguments("--width=1280");
		// firefoxOptions.addArguments("--height=1024");

		// listArguments.add("--window-size=1280,1024");
		// listArguments.add("--width=1280");
		// listArguments.add("--height=1024");
		listArguments.add("-marionette");

		firefoxOptions.addArguments(listArguments);
		firefoxOptions.addArguments("-profile", "/tmp/rust_mozprofile1ubtG6");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("acceptSslCerts", false);
		capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS,
				firefoxOptions);

		// firefoxOptions.addArguments("--browser.privatebrowsing.autostart",
		// "false");
		// firefoxOptions.addArguments("--private");
		System.setProperty("webdriver.gecko.driver", geckodriver);
		// logger.debug(firefoxOptions.toString());
		// logger.debug(firefoxOptions.toJson());
		driver = new FirefoxDriver(capabilities);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get(baseUrl + "/");
	}

	public String connectionSeleniumTor(String url, String geckodriver,
			String pathStartTorBrowser, String profilePath) {
		System.setProperty("java.net.preferIPv4Stack", "true");
		System.setProperty("socksProxyHost", "127.0.0.1");
		System.setProperty("socksProxyPort", "9150");
		System.setProperty("webdriver.gecko.driver", geckodriver);
		WebDriver driver;
		FirefoxProfile profile = setingFirefoxProfil();
		DesiredCapabilities cap = new DesiredCapabilities();
		FirefoxBinary firefoxBinary = new FirefoxBinary();
		GeckoDriverService service = new GeckoDriverService.Builder(
				firefoxBinary).usingDriverExecutable(new File(geckodriver))
				.usingAnyFreePort().build();
		try {
			service.start();
		} catch (IOException e) {
			e.printStackTrace();
		}

		FirefoxOptions options = new FirefoxOptions(cap).setBinary(
				firefoxBinary).setProfile(profile);
		TorControl tc = null;
		try {
			tc = new TorControl();
			tc.authenticate();
			tc.useProxy();
			tc.newIdentity();
		} catch (Exception e) {
			System.out.println("Couldn't connect to the TOR control port "
					+ TorControl.CONTROLPORT);
		}
		driver = new FirefoxDriver(options);

		driver.get(url);
		String pageSource = driver.getPageSource();

		driver.close();
		kilProces("sudo service tor restart");

		if (service.isRunning()) {
			service.stop();
		}

		driver.quit();
		return pageSource;
	}

	public String newConectionTorBrowser(String url, String geckodriver,
			String pathStartTorBrowser, String profilePath) throws IOException {
		logger.debug("newConectionTorBrowser:" + url);
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver", geckodriver);
		// String torPath =
		// "/home/black/Загрузки/tor-browser/tor/Browser/start-tor-browser";
		// String profilePath =
		// "/home/black/Загрузки/tor-browser/tor/Browser/TorBrowser/Data/Browser/profile.default/";
		File torProfileDir = new File(profilePath);
		FirefoxBinary binary = new FirefoxBinary(new File(pathStartTorBrowser));

		FirefoxProfile torProfile = new FirefoxProfile(torProfileDir);
		torProfile.setPreference("network.proxy.type", 1);
		torProfile.setPreference("network.proxy.socks", "127.0.0.1");
		torProfile.setPreference("network.proxy.socks_port", 9150);
		binary.startProfile(torProfile, torProfileDir, "");
		torProfile.setPreference("webdriver.load.strategy", "unstable");
		FirefoxOptions options = new FirefoxOptions();
		options.setBinary(binary);
		options.setProfile(torProfile);
		options.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);

		driver = new FirefoxDriver(options);
		logger.debug("get:" + url);
		driver.navigate().to(url);

		try {
			logger.debug("get:" + url);
			driver.get(url);

			return driver.getPageSource();
		} finally {
			driver.close();
			kilProces("sudo service tor restart");
			driver.quit();
		}
	}

	private FirefoxProfile setingFirefoxProfil() {
		FirefoxProfile ff_prof = new FirefoxProfile();

		ff_prof.setPreference("places.history.enabled", false);
		ff_prof.setPreference("privacy.clearOnShutdown.offlineApps", true);
		ff_prof.setPreference("privacy.clearOnShutdown.passwords", true);
		ff_prof.setPreference("privacy.clearOnShutdown.siteSettings", true);
		ff_prof.setPreference("privacy.sanitize.sanitizeOnShutdown", true);
		ff_prof.setPreference("signon.rememberSignons", false);
		ff_prof.setPreference("network.cookie.lifetimePolicy", 2);
		ff_prof.setPreference("network.dns.disablePrefetch", true);
		ff_prof.setPreference("network.http.sendRefererHeader", 0);
		ff_prof.setPreference("network.proxy.type", 1);
		ff_prof.setPreference("network.proxy.socks_version", 5);
		ff_prof.setPreference("network.proxy.socks", "127.0.0.1");
		ff_prof.setPreference("network.proxy.socks_port", 9050);
		ff_prof.setPreference("network.proxy.socks_remote_dns", true);
		ff_prof.setPreference("permissions.default.image", 2);

		return ff_prof;
	}

	private void kilProces(String comant) {
		ProcessBuilder pbuilder = new ProcessBuilder("bash", "-c", comant);
		File err = new File("err.txt");
		try {
			pbuilder.redirectError(err);
			Process p = pbuilder.start();
			p.destroy();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
