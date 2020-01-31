package com.start.the.any.browser.start.impl;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.start.the.any.browser.enums.SleepType;
import com.start.the.any.browser.start.abs.AbsStart;
import com.start.the.any.browser.start.abs.IStart;
import com.start.the.any.browser.threads.ExtractLotusProfileRunnable;
import com.start.the.any.browser.utilities.FileUtils;
import com.start.the.any.browser.utilities.ShuffleUtils;

public class StartLotus extends AbsStart implements IStart {
	final static int M_BOUND = 3;
	final static int TIMEOUT_IN_SECONDS = 5;
	final static String HOME = "https://lotus.vn/w/profile/29460917397406666.htm";
	static Logger logger = Logger.getLogger(StartLotus.class.getName());
	ExecutorService executors;
	WebDriverWait wait;
	private final String notFanText = "Trở thành Fan";
	private final String fanText = "Đã trở thành Fan";
	private final String strInFanText = "Đã".toLowerCase();

	public StartLotus(WebDriver driver, int sleep, SleepType sleepType,
			boolean isShutdown) {
		super(driver, sleep, sleepType, isShutdown);
		logger.debug("StartLotus:");
		executors = Executors.newFixedThreadPool(5);
	}

	@Override
	public boolean start() {
		List<String> list = null;
		try {
			list = FileUtils.getListUrl("lotus.txt");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// driver.get(LUFFY);
		boolean isRandom = true;
		int size = 0;
		int index = 0;

		WebElement findElement;
		if (list != null && list.size() > 0) {
			// if(isRandom)
			size = list.size();
			List<Integer> listIndex;
			if (isRandom) {
				listIndex = ShuffleUtils.shuffle(size);
			} else {
				listIndex = ShuffleUtils.nonshuffle(size);
			}
			for (Integer item : listIndex) {
				try {

					try {
						driver.get(HOME);
					} catch (UnhandledAlertException f) {
						logger.debug("UnhandledAlertException " + HOME);
						f.printStackTrace();
						boolean alertable = checkAlert();
						if (alertable) {
							try {
								driver.get(HOME);
							} catch (UnhandledAlertException fe) {
								logger.debug("UnhandledAlertException " + HOME);
								fe.printStackTrace();
								alertable = checkAlert();
								if (alertable) {
									logger.debug("alertable:" + alertable);
								} else {
									logger.debug("alertable:" + alertable);
								}
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					if (logger.isDebugEnabled())
						logger.debug("get[" + item + "/(" + index + "/" + size
								+ ")]:" + list.get(item));
					if (driver != null) {
						try {
							logger.debug("UnhandledAlertException Click share");
							wait = new WebDriverWait(driver, TIMEOUT_IN_SECONDS);
							findElement = wait
									.until(ExpectedConditions.visibilityOfElementLocated(By
											.xpath("//*[@class=\"mention-input\"]")));
							// WebElement element = driver.findElement(By
							// .xpath("//*[@id=\"button-create-post\"]"));
							if (findElement != null) {
								findElement.sendKeys(list.get(item));
								findElement.sendKeys(Keys.ENTER);
								//findElement.sendKeys(Keys.SPACE);
								Thread.sleep(6000);
								wait = new WebDriverWait(driver,
										TIMEOUT_IN_SECONDS);
								findElement = wait
										.until(ExpectedConditions.visibilityOfElementLocated(By
												.xpath("//*[@id=\"postCmt\"]/div/div/div/div[3]/div[2]/div/button")));
								// WebElement elementSubmint = driver
								// .findElement(By
								// .xpath("//*[@id=\"postCmt\"]/div/div/div/div[3]/div[2]/div/button"));
								findElement.click();
								Thread.sleep(2000);
							}
						} catch (UnhandledAlertException f) {
							logger.debug("UnhandledAlertException Click share");
							f.printStackTrace();
							boolean alertable = checkAlert();
							if (alertable) {
								logger.debug("accept");
								// alert.accept();
								// alert.dismiss();
							} else {
								logger.debug("false accept");
							}

						} catch (Exception ex) {
							logger.debug("accept Exception");
							ex.printStackTrace();
						}
						logger.debug("enter extractProfile");
						extractProfile();
						int sleep = 1000 * (new Random().nextInt(60 * M_BOUND));
						if (sleep == 0)
							sleep = 30 * 1000;
						logger.debug("sleep:" + (sleep / 1000) + " s");

						Thread.sleep(sleep);
						if (isShutdown) {
							try {
								driver.close();
								driver.quit();
							} catch (Exception ex) {
								ex.printStackTrace();
							}
							System.exit(1);
						}
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				index++;
			}
			return true;
		}
		return false;
	}

	public boolean isAlertPresent() {
		boolean foundAlert = false;
		wait = new WebDriverWait(driver, TIMEOUT_IN_SECONDS /*
															 * timeout in
															 * seconds
															 */);
		try {
			if (wait.until(ExpectedConditions.alertIsPresent()) == null) {
				logger.debug("alert was not present");
				foundAlert = false;
			} else {
				logger.debug("alert was present");
				foundAlert = true;
			}

		} catch (TimeoutException eTO) {
			foundAlert = false;
		}
		return foundAlert;
	}

	private void extractProfile() {
		// try {
		// if (isAlertPresent() == true) {
		// boolean alertable = checkAlert();
		// if (alertable) {
		// logger.debug("alert was clicked");
		// }
		// }
		// } catch (Exception ex) {
		// ex.printStackTrace();
		// }

		logger.debug("extractProfile");
		Set<String> setProfiles = FileUtils
				.loadLotusProfile(ExtractLotusProfileRunnable.LOTUS_PROFILES);
		if (setProfiles.size() == 0) {
			try {
				// driver.get(LUFFY);
				// String
				// pageSource=driver.findElement(By.tagName("body")).getText();
				String javascript = "return arguments[0].innerHTML";
				String pageSource = (String) ((JavascriptExecutor) driver)
						.executeScript(javascript,
								driver.findElement(By.tagName("html")));
				pageSource = "<html>" + pageSource + "</html>";
				// logger.debug(pageSource);
				// executors.execute(new
				// ExtractLotusProfileRunnable(driver.getPageSource()));
				executors.execute(new ExtractLotusProfileRunnable(pageSource));
			} catch (UnhandledAlertException f) {
				f.printStackTrace();
				checkAlert();
			}

		} else {
			int index = FileUtils.getIndex();
			String profile = FileUtils.loadLotusProfile(
					ExtractLotusProfileRunnable.LOTUS_PROFILES, index);
			if (profile != null) {
				String url = "https://lotus.vn/w/profile/" + profile + ".htm";
				logger.debug("get:" + url);
				try {
					driver.get(url);
					if (isAlertPresent() == true) {
						boolean alertable = checkAlert();
						if (alertable) {
							logger.debug("alert was clicked");
							logger.debug("reload url:" + url);
							driver.get(url);
						}
					}
				} catch (UnhandledAlertException f) {
					logger.debug("UnhandledAlertException " + url);
					f.printStackTrace();
					boolean alertable = checkAlert();
					if (alertable) {
						logger.debug("accept");
						// alert.accept();
						// alert.dismiss();
					} else {
						logger.debug("false accept");
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				try {
					logger.debug("sleep 2s");
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				try {
					logger.debug("find fanWebElement");
					// Specify the amount of time the driver should wait when
					// searching for an element if it is not immediately
					// present. Specify this time to 0 to move ahead if element
					// is not found.
					driver.manage().timeouts()
							.implicitlyWait(1000, TimeUnit.MILLISECONDS);
					WebElement fanWebElement = null;
					boolean exceptionable = false;
					try {
						wait = new WebDriverWait(driver, TIMEOUT_IN_SECONDS);
						fanWebElement = wait
								.until(ExpectedConditions.visibilityOfElementLocated(By
										.xpath("//*[@id=\"profile-info\"]/div[1]/div[2]/a[2]/span[2]")));
						// WebElement fanWebElement = driver
						// .findElement(By
						// .xpath("//*[@id=\"profile-info\"]/div[1]/div[2]/a[2]/span[2]"));
						if (fanWebElement.getText().equals("Làm fan")) {
							logger.debug("click Làm fan");
							fanWebElement.click();
						} else {
							logger.debug("DA Là fan");
						}
					} catch (Exception ex) {
						exceptionable = true;
						ex.printStackTrace();

					}
					if (fanWebElement == null && exceptionable == true) {
						try {
							wait = new WebDriverWait(driver, TIMEOUT_IN_SECONDS);
							fanWebElement = wait
									.until(ExpectedConditions.visibilityOfElementLocated(By
											.xpath("//*[@id=\"profile-info\"]/div[1]/div[2]/a/span[2]")));
							// WebElement fanWebElement = driver
							// .findElement(By
							// .xpath("//*[@id=\"profile-info\"]/div[1]/div[2]/a[2]/span[2]"));
							logger.debug("str:"
									+ fanWebElement.getText().toLowerCase());
							if (fanWebElement.getText().toLowerCase()
									.contains(strInFanText) == false) {
								logger.debug("click Làm fan");
								fanWebElement.click();
							} else {
								logger.debug("DA Là fan");
							}
						} catch (Exception ex) {
							exceptionable = true;
							ex.printStackTrace();

						}
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			try {
				logger.debug("sleep 2s");
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				String javascript = "return arguments[0].innerHTML";
				String pageSource = (String) ((JavascriptExecutor) driver)
						.executeScript(javascript,
								driver.findElement(By.tagName("html")));
				pageSource = "<html>" + pageSource + "</html>";
				// driver.getPageSource();
				pageSource = (String) ((JavascriptExecutor) driver)
						.executeScript("return document.getElementsByTagName('html')[0].innerHTML");
				List<WebElement> listTagA = driver
						.findElements(By.tagName("a"));
				StringBuilder html = new StringBuilder();
				for (WebElement webElement : listTagA) {
					// logger.debug("href:" + webElement.getAttribute("href"));
					html.append("\n" + webElement.getAttribute("href"));
				}

				executors.execute(new ExtractLotusProfileRunnable(html
						.toString()));
				// executors.execute(new ExtractLotusProfileRunnable(listTagA));
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			index = index + 1;
			try {
				FileUtils.writeIndex(index + "");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/***
	 * @see https
	 *      ://stackoverflow.com/questions/8244723/alert-handling-in-selenium
	 *      -webdriver-selenium-2-with-java
	 */
	public boolean checkAlert() {
		try {
			wait = new WebDriverWait(driver, TIMEOUT_IN_SECONDS);
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			if (alert != null) {
				alert = driver.switchTo().alert();
				alert.accept();

			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * try { Alert alert = driver.switchTo().alert(); String alertText =
		 * alert.getText(); logger.debug("Alert data: " + alertText);
		 * alert.accept(); } catch (NoAlertPresentException e) {
		 * e.printStackTrace(); }
		 */
		return false;
	}
}
