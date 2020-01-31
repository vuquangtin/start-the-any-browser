package com.start.the.any.browser.selenium;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

public class ScheduleHomePage {

	protected WebDriver driver;

	/* Create elements with locators */
	private By scheduleTitle = By.xpath("//*[@data-id='scheduleTitle']");
	private By scheduleTime = By.xpath("//*[@data-id='scheduleTime']");
	private By scheduleTeamName = By.xpath("(//*[@data-id='teamName'])[1]");
	private By scheduleGameDate = By.xpath("(//*[@data-id='gameDate'])[1]");
	private By scheduleLeagueName = By.xpath("(//*[@data-id='leagueName'])[1]");
	private By scheduleLiveLogo = By.xpath("(//*[@data-id='liveBadge'])[1]");
	private By scheduleTeamLogotype = By.xpath("(//*[@data-id='teamLogo'])[1]");

	private By leagueSectionNames = By
			.xpath("//*[@data-id='leaguesSection']//h6");
	private By leagueSectionVideos = By
			.xpath("//*[@data-id='leaguesSection']//*[@data-id='videos']");
	private By leagueSectionVideosTitle = By
			.xpath("//*[@data-id='leaguesSection']//*[@data-id='videoTitle']");
	private By leagueSectionVideosTime = By
			.xpath("//*[@data-id='leaguesSection']//*[@data-id='videoPublishedDate']");
	private By leagueSectionVideoTitle = By
			.xpath("(//*[@data-id='leaguesSection']//*[@data-id='videoTitle'])[1]");
	private By leagueSectionVideo = By
			.xpath("(//*[@data-id='leaguesSection']//*[@data-id='video']//*[@data-id='clipVideo'])[1]");
	private By leagueVideoPaused = By
			.xpath("(//*[@data-id='leaguesSection']//*[@data-id='video'])[1]//*[@class='video-react-play-control video-react-control video-react-button video-react-paused']");
	private By leagueVideoPlayPauseBtn = By
			.xpath("(//*[@data-id='leaguesSection']//*[@class='video-react-control-bar video-react-control-bar-auto-hide']//button[1])[1]");
	private By leagueVideoBigPlayBtn = By
			.xpath("//*[name()='svg'][contains(@class,'video__play-button pointer')]");
	private By leagueVideoTimer = By.xpath("(//*[contains(text(),'0:03')])[1]");// 3
																				// seconds
																				// count
	private By leagueSectionName = By
			.xpath("(//*[@data-id='leaguesSection']//h6)[1]");

	private By liveSectionTitle = By
			.xpath("//*[@data-id='liveSection']//*[contains(text(),'LIVE NOW')]");
	private By highlightsSectionTitle = By
			.xpath("//*[@data-id='liveSection']//*[contains(text(),'Recent Highlights')]");
	private By liveBadge = By.xpath("(//*[@data-id='liveBadge'])[1]");
	private By buttonMore = By.xpath("(//*[@data-id='viewMoreButton'])[1]");
	private By liveOrHighlightsTitle = By
			.xpath("(//*[@data-id='liveSection']//h6)[1]");
	private By liveOrHighlightsVideos = By
			.xpath("(//*[@data-id='liveSection'])[1]//*[@data-id='videos']//*[@data-id='video']");

	private By liveOrHighlightsVideo = By
			.xpath("((//*[@data-id='liveSection'])[1]//*[@data-id='video'])[1]");
	private By liveOrHighlightsVideoTitle = By
			.xpath("((//*[@data-id='liveSection'])[1]//*[@data-id='videoTitle'])[1]");
	private By liveOrHighlightsVideoTime = By
			.xpath("((//*[@data-id='liveSection'])[1]//*[@data-id='videoPublishedDate'])[1]");
	private By bookmarkIcon = By.xpath("//*[@data-id='bookmarkIcon']");
	private By toastBookmarkSuccess = By
			.xpath("//*[@class='Toastify__toast Toastify__toast--success']");
	private By toastBookmarkSuccessClose = By
			.xpath("//*[@class='Toastify__close-button Toastify__close-button--success']");

	public ScheduleHomePage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean ScheduleTitleDisplayed() {
		driver.manage().timeouts().implicitlyWait(5, SECONDS);
		WebElement scheduleSectionTile = driver.findElement(scheduleTitle);
		return scheduleSectionTile.isDisplayed();
	}

	public boolean ScheduleTimeDisplayed() {
		driver.manage().timeouts().implicitlyWait(5, SECONDS);
		WebElement scheduleSectionTime = driver.findElement(scheduleTime);
		return scheduleSectionTime.isDisplayed();
	}

	public boolean ScheduleTeamLogoDisplayed() {
		driver.manage().timeouts().implicitlyWait(5, SECONDS);
		List<WebElement> scheduleTeamLogo = driver
				.findElements(scheduleTeamLogotype);

		for (WebElement i : scheduleTeamLogo)
			if (i.isDisplayed()) {
				return true;
			} else {
			}
		return false;

	}

	public boolean ScheduleTeamNameDisplayed() {
		driver.manage().timeouts().implicitlyWait(5, SECONDS);
		WebElement scheduleTeam = driver.findElement(scheduleTeamName);
		return scheduleTeam.isDisplayed();

	}

	public boolean ScheduleGameDateDisplayed() {
		driver.manage().timeouts().implicitlyWait(5, SECONDS);
		WebElement scheduleDate = driver.findElement(scheduleGameDate);
		return scheduleDate.isDisplayed();
	}

	public boolean ScheduleLeagueNameDisplayed() {
		driver.manage().timeouts().implicitlyWait(5, SECONDS);
		WebElement scheduleLeaguename = driver.findElement(scheduleLeagueName);
		return scheduleLeaguename.isDisplayed();
	}

	public boolean ScheduleLiveLabelDisplayed() {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(scheduleLiveLogo));
			WebElement live = driver.findElement(scheduleLiveLogo);
			return live.isDisplayed();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
			return false;
		}
	}

	public boolean ScheduleScrollable() {
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		Boolean verticalScroll = (Boolean) javascript
				.executeScript("return document.documentElement.scrollHeight>document.documentElement.clientHeight;");
		if (verticalScroll = true) {
			return true;
		} else {
			return false;
		}
	}

	public boolean LeagueSectionNameDisplayed() {
		driver.manage().timeouts().implicitlyWait(5, SECONDS);
		List<WebElement> leagueNames = driver.findElements(leagueSectionNames);

		for (WebElement i : leagueNames)
			if (i.isDisplayed()) {
				return true;
			} else {
			}
		return false;
	}

	public boolean LeagueSectionVideosDisplayed() {
		driver.manage().timeouts().implicitlyWait(5, SECONDS);
		List<WebElement> videos = driver.findElements(leagueSectionVideos);

		for (WebElement i : videos)
			if (i.isDisplayed()) {
				return true;
			} else {
			}
		return false;
	}

	public void clickLeagueSectionName() {
		driver.manage().timeouts().implicitlyWait(5, SECONDS);
		driver.findElement(leagueSectionName).click();

	}

	public void clickLeagueSectionVideoDescription() {
		driver.manage().timeouts().implicitlyWait(6, SECONDS);
		driver.findElement(leagueSectionVideoTitle).click();

	}

	public boolean LeagueSectionVideoDescription() {
		driver.manage().timeouts().implicitlyWait(5, SECONDS);
		List<WebElement> leagueVideoDescription = driver
				.findElements(leagueSectionVideosTitle);
		for (WebElement i : leagueVideoDescription)
			if (i.isDisplayed()) {
				return true;
			} else {
			}
		return false;
	}

	public boolean LiveHighlightsVideoDescription() {
		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebElement description = driver
					.findElement(liveOrHighlightsVideoTitle);
			return description.isDisplayed();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
			return false;
		}
	}

	public boolean LiveHighlightsVideoTime() {
		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebElement time = driver.findElement(liveOrHighlightsVideoTime);
			return time.isDisplayed();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
			return false;
		}
	}

	public boolean LeagueSectionVideoTime() {
		driver.manage().timeouts().implicitlyWait(5, SECONDS);
		List<WebElement> leagueVideoTime = driver
				.findElements(leagueSectionVideosTime);

		for (WebElement i : leagueVideoTime)

			if (i.isDisplayed()) {
				return true;
			} else {
			}
		return false;
	}

	public void LeagueVideoHover(String browserType) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(leagueSectionVideo));
			WebElement video = driver.findElement(leagueSectionVideo);

			if (browserType.equals("safari")) {
				String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript(mouseOverScript, video);
				video.click();
				Thread.sleep(1000);
			} else {
				Actions action = new Actions(driver);
				action.moveToElement(video).build().perform();
			}
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
		}
	}

	public void LiveVideoHover(String browserType) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(liveOrHighlightsVideo));
			WebElement video = driver.findElement(liveOrHighlightsVideo);

			if (browserType.equals("safari")) {
				String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript(mouseOverScript, video);
			} else {
				Actions action = new Actions(driver);
				action.moveToElement(video).build().perform();
			}

		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
		}
	}

	public void HighlightVideoHover(String browserType) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(liveOrHighlightsVideo));
			WebElement video = driver.findElement(liveOrHighlightsVideo);

			if (browserType.equals("safari")) {
				String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript(mouseOverScript, video);
			} else {
				Actions action = new Actions(driver);
				action.moveToElement(video).build().perform();
			}

		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
		}
	}

	public void clickVideoPlay() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(leagueVideoBigPlayBtn));
		WebElement play = driver.findElement(leagueVideoBigPlayBtn);
		play.click();
	}

	public void clickVideoPause() {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(leagueVideoPlayPauseBtn));
			WebElement pause = driver.findElement(leagueVideoPlayPauseBtn);
			pause.click();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
		}
	}

	public boolean VideoPlaying() {
		driver.manage().timeouts().implicitlyWait(6, SECONDS);
		WebElement videoTimerCount = driver.findElement(leagueVideoTimer);
		return videoTimerCount.isDisplayed();
	}

	public boolean VideoPaused() {
		driver.manage().timeouts().implicitlyWait(3, SECONDS);
		WebElement videoPause = driver.findElement(leagueVideoPaused);
		return videoPause.isDisplayed();
	}

	public int LeagueSectionVideosCount() {
		try {
			List<WebElement> count = driver.findElements(leagueSectionVideos);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions
					.presenceOfAllElementsLocatedBy(leagueSectionVideos));

			return count.size();
		} catch (Throwable e) {
			System.out.println(e);
			return 5;// 5 will cause false
		}
	}

	public boolean LiveTitleDisplayed() {
		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebElement liveTitle = driver.findElement(liveSectionTitle);
			return liveTitle.isDisplayed();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
			return false;
		}
	}

	public boolean HighlightsTitleDisplayed() {
		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebElement highlightsTitle = driver
					.findElement(highlightsSectionTitle);
			return highlightsTitle.isDisplayed();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
			return false;
		}
	}

	public int LiveHighlightsVideosCount() {
		try {
			List<WebElement> count = driver
					.findElements(liveOrHighlightsVideos);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions
					.visibilityOfAllElementsLocatedBy(liveOrHighlightsVideos));

			return count.size();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
			return 1000;// 1000 will cause false
		}
	}

	public void clickLiveHighlightsTitle() {
		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebElement title = driver.findElement(liveOrHighlightsTitle);
			title.click();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
		}
	}

	public boolean MoreButton() {
		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebElement moreButton = driver.findElement(buttonMore);
			return moreButton.isDisplayed();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
			return false;
		}
	}

	public void clickMoreButton() {
		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebElement moreButton = driver.findElement(buttonMore);
			moreButton.click();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
		}
	}

	public boolean LiveBadge() {
		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebElement live = driver.findElement(liveBadge);
			return live.isDisplayed();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
			return false;
		}
	}

	public boolean LiveOrHighlightsBookmark() {
		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebElement bookmark = driver.findElement(bookmarkIcon);
			return bookmark.isDisplayed();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
			return false;
		}
	}

	public boolean LeagueSectionBookmark() {
		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebElement bookmark = driver.findElement(bookmarkIcon);
			return bookmark.isDisplayed();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
			return false;
		}
	}

	public void clickLeagueVideoBookmark() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(bookmarkIcon));
			WebElement bookmark = driver.findElement(bookmarkIcon);
			bookmark.click();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
		}
	}

	public String LeagueSectionVideoTitleText() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.presenceOfElementLocated(leagueSectionVideoTitle));
			WebElement title = driver.findElement(leagueSectionVideoTitle);
			return title.getAttribute("title");
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
			return "No title found";
		}
	}

	public void clickBookmarkToastClose() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(toastBookmarkSuccessClose));
			WebElement close = driver.findElement(toastBookmarkSuccessClose);
			close.click();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
		}
	}
}