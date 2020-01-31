package com.start.the.any.browser.selenium;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

public class FiltersBar {

	protected WebDriver driver;

	private By filterLeague = By.xpath("//*[@data-id='filterLeague']");
	private By filterLeagueSeleted = By
			.xpath("(//*[@data-id='filterLeague']//span[1]/span[1])[1]");
	private By filterTeam = By.xpath("//*[@data-id='filterTeam']");
	private By filterTeamSelected = By
			.xpath("(//*[@data-id='filterTeam']//span[1]/span)[1]");
	private By filterTeamDisabled = By
			.xpath("//*[@data-id='filterTeam']//button[@disabled]");
	private By filterGame = By.xpath("//*[@data-id='filterGame']");
	private By filterGameSelected = By
			.xpath("(//*[@data-id='filterGame']//button[1]/span[1]/span[1])[1]");
	private By filterGameDisabled = By
			.xpath("//*[@data-id='filterGame']//button[@disabled]");
	private By filterPlayer = By.xpath("//*[@data-id='filterPlayer']");
	private By filterPlayerDisabled = By
			.xpath("//*[@data-id='filterPlayer']//button[@disabled]");
	private By filterAction = By.xpath("//*[@data-id='filterAction']");
	private By filterActionDisabled = By
			.xpath("//*[@data-id='filterAction']//button[@disabled]");
	private By filterDate = By.xpath("//*[@data-id='filterDate']");
	private By filterDateDisabled = By
			.xpath("//*[@data-id='filterDate']//button[@disabled]");
	private By filterMoreFilters = By
			.xpath("//*[@data-id='filterMoreFilters']");
	private By filterMoreFiltersPopUp = By
			.xpath("//*[@data-id='filterMoreFiltersPopUp']");
	private By radiogroupRating = By
			.xpath("//*[@data-id='filterMoreFiltersPopUp']//*[@aria-label='rating']");
	private By radiogroupRatingOptions = By
			.xpath("//*[@data-id='filterMoreFiltersPopUp']//*[@aria-label='rating']//input[1]");
	private By radiogroupClipType = By
			.xpath("//*[@data-id='filterMoreFiltersPopUp']//*[@aria-label='clipType']");
	private By radiogroupClipTypeOptions = By
			.xpath("//*[@data-id='filterMoreFiltersPopUp']//*[@aria-label='clipType']//input[1]");
	private By filterBadges = By
			.xpath("//*[contains(@class,'MuiBadge-badge')]");

	private By filterMoreFiltersDisabled = By
			.xpath("//*[@data-id='filterMoreFilters']//button[@disabled]");
	private By noOptions = By
			.xpath("//*[@data-id='filterDropdown']//div[contains(text(),'No options')]");
	private By filterDropdown = By.xpath("//*[@data-id='filterDropdown']");
	private By leagueFilterInput = By
			.xpath("//*[@data-id='filterLeague']//input");
	private By dropdownOption = By
			.xpath("//*[@data-id='filterDropdown']/div[1]");
	private By dropdownOptions = By.xpath("//*[@data-id='filterDropdown']/div");
	private By applyButton = By.xpath("//*[@data-id='applyButton']");
	private By applyButtonDisabled = By
			.xpath("//*[@data-id='applyButton'][@tabindex='-1']");
	private By multiselectedOptions = By
			.xpath("//div[@x-placement]/div[1]/div[1]/div[1]/div[1]/div[1]/div[position() != last()][not(contains(text(), 'Search...'))]");
	private By removeMultiselectedOption = By
			.xpath("(//div[@x-placement]/div[1]/div[1]/div[1]/div[1]/div[1]/div[position() != last()]/div[2])[1]");
	private By removeMultiselectedOptions = By
			.xpath("//div[@x-placement]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]");
	private By datePicker = By.xpath("//*[@data-id='datePicker']");
	private By buttonSaveSearchEnabled = By
			.xpath("//*[@data-id='saveSearchButton'][not(@disabled)]");
	private By buttonSave = By.xpath("//*[@data-id='changeButton']");
	private By errorName = By.xpath("//*[@data-id='errorName']");
	private By inputPresetName = By.xpath("//*[@id='name']");
	private By buttonEditEnabled = By
			.xpath("//*[@data-id='saveSearchButton'][not(@disabled)]/span[contains(text(), 'Edit')]");
	private By buttonEditDisabled = By
			.xpath("//*[@data-id='saveSearchButton'][@disabled]/span[contains(text(), 'Edit')]");
	private By toastClose = By
			.xpath("//*[@class='Toastify__close-button Toastify__close-button--success']");
	private By monthYear = By
			.xpath("(//*[@data-id='datePicker']//*[@data-visible='true']//strong)[2]");
	private By days = By
			.xpath("(//*[@data-id='datePicker']//*[@data-visible='true']//strong)[2]//following::*[contains(@aria-label,'check-in')]");
	private By datePickerBackButton = By
			.xpath("//*[@data-id='datePicker']//*[@aria-label='Move backward to switch to the previous month.']");

	public FiltersBar(WebDriver driver) {
		this.driver = driver;
	}

	public boolean LeagueFilterIsDisplayedEnabled() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(filterLeague));
			WebElement filter = driver.findElement(filterLeague);
			return filter.isDisplayed() && filter.isEnabled();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
			return false;
		}
	}

	public boolean TeamFilterIsDisplayedEnabled() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(filterTeam));
			WebElement filter = driver.findElement(filterTeam);
			return filter.isDisplayed();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
			return false;
		}
	}

	public boolean TeamFilterIsDisplayedDisabled() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(filterTeamDisabled));
			WebElement filter = driver.findElement(filterTeamDisabled);
			return filter.isDisplayed();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
			return false;
		}
	}

	public boolean GameFilterIsDisplayedEnabled() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(filterGame));
			WebElement filter = driver.findElement(filterGame);
			return filter.isDisplayed();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
			return false;
		}
	}

	public boolean GameFilterIsDisplayedDisabled() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(filterGameDisabled));
			WebElement filter = driver.findElement(filterGameDisabled);
			return filter.isDisplayed();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
			return false;
		}
	}

	public boolean PlayerFilterIsDisplayedEnabled() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(filterPlayer));
			WebElement filter = driver.findElement(filterPlayer);
			return filter.isDisplayed();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
			return false;
		}
	}

	public boolean PlayerFilterIsDisplayedDisabled() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(filterPlayerDisabled));
			WebElement filter = driver.findElement(filterPlayerDisabled);
			return filter.isDisplayed();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
			return false;
		}
	}

	public boolean ActionFilterIsDisplayedEnabled() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(filterAction));
			WebElement filter = driver.findElement(filterAction);
			return filter.isDisplayed();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
			return false;
		}
	}

	public boolean ActionFilterIsDisplayedDisabled() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(filterActionDisabled));
			WebElement filter = driver.findElement(filterActionDisabled);
			return filter.isDisplayed();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
			return false;
		}
	}

	public boolean DateFilterIsDisplayedEnabled() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(filterDate));
			WebElement filter = driver.findElement(filterDate);
			return filter.isDisplayed();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
			return false;
		}
	}

	public boolean DateFilterIsDisplayedDisabled() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(filterDateDisabled));
			WebElement filter = driver.findElement(filterDateDisabled);
			return filter.isDisplayed();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
			return false;
		}
	}

	public boolean MoreFilterIsDisplayedEnabled() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(filterMoreFilters));
			WebElement filter = driver.findElement(filterMoreFilters);
			return filter.isDisplayed();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
			return false;
		}
	}

	public boolean MoreFilterIsDisplayedDisabled() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(filterMoreFiltersDisabled));
			WebElement filter = driver.findElement(filterMoreFiltersDisabled);
			return filter.isDisplayed();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
			return false;
		}
	}

	public void clickLeagueFilter() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			WebElement filter = driver.findElement(filterLeague);
			filter.click();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
		}
	}

	public void clickTeamFilter() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(filterTeam));
			WebElement filter = driver.findElement(filterTeam);
			filter.click();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
		}
	}

	public void clickGameFilter() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(filterGame));
			WebElement filter = driver.findElement(filterGame);
			filter.click();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
		}
	}

	public void clickPlayerFilter() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(filterPlayer));
			WebElement filter = driver.findElement(filterPlayer);
			filter.click();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
		}
	}

	public void clickActionFilter() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(filterAction));
			WebElement filter = driver.findElement(filterAction);
			filter.click();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
		}
	}

	public void clickDateFilter() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(filterDate));
			WebElement filter = driver.findElement(filterDate);
			filter.click();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
		}
	}

	public void clickMoreFilters() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(filterMoreFilters));
			WebElement filter = driver.findElement(filterMoreFilters);
			filter.click();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
		}
	}

	public boolean FilterDropdownIsDisplayed() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(filterDropdown));
			WebElement dropdown = driver.findElement(filterDropdown);
			return dropdown.isDisplayed();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
			return false;
		}
	}

	public int FoundOptionsCount() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions
					.visibilityOfAllElementsLocatedBy(dropdownOptions));
			List<WebElement> list = driver.findElements(dropdownOptions);
			return list.size();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
			return 0;
		}
	}

	public int MultiSelectedOptionsCount() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.visibilityOfAllElementsLocatedBy(multiselectedOptions));
			List<WebElement> list = driver.findElements(multiselectedOptions);
			return list.size();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
			return 0;
		}

	}

	public void ScrollFilterDropdown() {
		try {
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(filterDropdown));
			JavascriptExecutor je = (JavascriptExecutor) driver;
			je.executeScript("document.querySelector('div.menu-list-container').scrollBy(0, 10000)");
			Thread.sleep(1000);
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
		}
	}

	public void PutInLeagueName(String leagueName) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(leagueFilterInput));
			WebElement input = driver.findElement(leagueFilterInput);

			Actions actions = new Actions(driver);
			actions.moveToElement(input);
			actions.click();
			actions.sendKeys(leagueName);
			actions.build().perform();

		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
		}
	}

	// First option is selected
	public void SelectOptionFromDropdown() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(dropdownOption));
			WebElement option = driver.findElement(dropdownOption);

			Actions actions = new Actions(driver);
			actions.moveToElement(option);
			actions.click();
			actions.build().perform();

		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
		}
	}

	public void InputAndSelectLeague(String league) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(leagueFilterInput));
			WebElement input = driver.findElement(leagueFilterInput);

			Actions actions = new Actions(driver);
			actions.moveToElement(input);
			actions.click();
			actions.sendKeys(league);
			actions.sendKeys(Keys.RETURN);
			actions.build().perform();
			Thread.sleep(1000);

		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
		}
	}

	public void SelectSecondOptionFromDropdown() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(dropdownOption));
			WebElement option = driver.findElement(dropdownOption);

			Actions actions = new Actions(driver);
			actions.moveToElement(option);
			actions.sendKeys(Keys.DOWN, Keys.RETURN);
			actions.build().perform();

		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
		}
	}

	public void clickOnLeagueFilterSelected() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(filterLeagueSeleted));
			WebElement filter = driver.findElement(filterLeagueSeleted);
			filter.click();

		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
		}
	}

	// Returns the string value of the name shown on the league filter
	public String SelectedLeagueNameOnFilter() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(filterLeagueSeleted));
			WebElement league = driver.findElement(filterLeagueSeleted);
			return league.getText();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
			return "Fail";
		}
	}

	public String SelectedTeamNameOnFilter() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(filterTeamSelected));
			WebElement team = driver.findElement(filterTeamSelected);
			return team.getText();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
			return "Fail";
		}
	}

	public String SelectedGameNameOnFilter() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(filterGameSelected));
			WebElement game = driver.findElement(filterGameSelected);
			return game.getText();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
			return "Fail";
		}
	}

	public boolean NoResultPlaceholderIsDisplayed() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(noOptions));
			WebElement option = driver.findElement(noOptions);
			return option.isDisplayed();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
			return false;
		}
	}

	public boolean ApplyButtonIsDisplayedEnabled() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(applyButton));
			WebElement button = driver.findElement(applyButton);
			return button.isDisplayed() & button.isEnabled();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
			return false;
		}
	}

	public boolean ApplyButtonIsDisplayedDisabled() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(applyButtonDisabled));
			WebElement button = driver.findElement(applyButtonDisabled);
			return button.isDisplayed();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
			return false;
		}
	}

	public void clickApplyButton() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(applyButton));
			WebElement button = driver.findElement(applyButton);
			button.click();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
		}
	}

	public void RemoveSelectedOption() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(removeMultiselectedOption));
			WebElement remove = driver.findElement(removeMultiselectedOption);
			remove.click();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
		}
	}

	public void RemoveSelectedOptions() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(removeMultiselectedOptions));
			WebElement removeAll = driver
					.findElement(removeMultiselectedOptions);
			removeAll.click();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
		}
	}

	// Checks if there's a specific item in the dropdown list
	public boolean DropdownOptionValue(String value) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(dropdownOptions));
			List<WebElement> list = driver.findElements(dropdownOptions);
			for (WebElement i : list)
				if (i.getText().contains(value)) {
					return true;
				} else {
				}
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
		}
		return false;
	}

	public void SelectSpecificDropdownOption(String value) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions
					.visibilityOfAllElementsLocatedBy(dropdownOptions));
			List<WebElement> list = driver.findElements(dropdownOptions);
			for (WebElement i : list)
				if (i.getText().equals(value)) {
					i.click();
					Thread.sleep(1000);
				} else {
				}
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
		}
	}

	public boolean DatePickerIsDisplayed() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(datePicker));
			WebElement calendar = driver.findElement(datePicker);
			return calendar.isDisplayed();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
			return false;
		}
	}

	public boolean MoreFiltersPopUpIsDisplayed() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(filterMoreFiltersPopUp));
			WebElement filter = driver.findElement(filterMoreFiltersPopUp);
			return filter.isDisplayed();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
			return false;
		}
	}

	public boolean RatingRadiogroupIsDisplayed() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(radiogroupRating));
			WebElement radiogroup = driver.findElement(radiogroupRating);
			return radiogroup.isDisplayed();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
			return false;
		}
	}

	public boolean ClipTypeRadiogroupIsDisplayed() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(radiogroupClipType));
			WebElement radiogroup = driver.findElement(radiogroupClipType);
			return radiogroup.isDisplayed();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
			return false;
		}
	}

	public boolean SaveButtonIsEnabled() {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(buttonSaveSearchEnabled));
			WebElement button = driver.findElement(buttonSaveSearchEnabled);
			return button.isDisplayed();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
			return false;
		}
	}

	public boolean EditButtonIsDisabled() {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(buttonEditDisabled));
			WebElement button = driver.findElement(buttonEditDisabled);
			return button.isDisplayed();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
			return false;
		}
	}

	public boolean EditButtonIsEnabled() {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(buttonEditEnabled));
			WebElement button = driver.findElement(buttonEditEnabled);
			return button.isDisplayed();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
			return false;
		}
	}

	public void clickEditSearchButton() {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(buttonEditEnabled));
			WebElement button = driver.findElement(buttonEditEnabled);
			button.click();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
		}
	}

	public void clickSaveSearch() {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(buttonSaveSearchEnabled));
			WebElement button = driver.findElement(buttonSaveSearchEnabled);
			button.click();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
		}
	}

	public void clickSave() {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(buttonSave));
			WebElement button = driver.findElement(buttonSave);
			button.click();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
		}
	}

	public void PresetNameInput(String value) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(inputPresetName));
			WebElement input = driver.findElement(inputPresetName);

			for (int i = 0; i < 100; i++) {
				input.sendKeys(Keys.BACK_SPACE);
			}

			input.sendKeys(value);
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
		}
	}

	public String PresetNamePrepopulated() {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(inputPresetName));
			WebElement input = driver.findElement(inputPresetName);
			return input.getAttribute("value");
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
		}
		return null;
	}

	public boolean ErrorNameIsDisplayed() {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(errorName));
			WebElement error = driver.findElement(errorName);
			return error.isDisplayed();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
			return false;
		}
	}

	public String StringRandomizer(int length) {

		char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890"
				.toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		String randomString = sb.toString();
		return randomString;
	}

	public void clickToastClose() {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(toastClose));
			WebElement close = driver.findElement(toastClose);
			close.click();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
		}
	}

	/*
	 * public void SelectDate(String dateFrom) { try { WebDriverWait wait = new
	 * WebDriverWait(driver, 5);
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(dateCheckIn));
	 * WebElement date = driver.findElement(toastClose); date.click(); } catch
	 * (Throwable e) { ExtentTestManager.getTest().log(Status.INFO, e);
	 * System.out.println(e); } }
	 */

	public void SelectDate(String date) {
		try {
			String splitter[] = date.split("/");
			String checkInmonth_year = splitter[1];
			String checkInday = splitter[0];

			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.visibilityOfAllElementsLocatedBy(monthYear));
			WebElement month_year = driver.findElement(monthYear);
			WebElement buttonBack = driver.findElement(datePickerBackButton);

			while (!month_year.getText().equals(checkInmonth_year)) {
				buttonBack.click();
				Thread.sleep(300);
				month_year = driver.findElement(monthYear);
			}

			wait.until(ExpectedConditions
					.presenceOfAllElementsLocatedBy(monthYear));
			List<WebElement> day = driver.findElements(days);
			for (WebElement i : day)
				if (i.getText().equals(checkInday)) {
					i.click();

				}
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
		}
	}

	public void selectRating(String rating) {

		try {

			List<WebElement> optionsRating = driver
					.findElements(radiogroupRatingOptions);
			for (WebElement i : optionsRating)
				if (i.getAttribute("value").equals(rating)) {
					i.click();
				}
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
		}
	}

	public void selectClipType(String type) {

		try {
			/*
			 * WebDriverWait wait = new WebDriverWait(driver, 5);
			 * wait.until(ExpectedConditions
			 * .visibilityOfAllElementsLocatedBy(radiogroupClipTypeOptions));
			 */
			List<WebElement> optionsClipType = driver
					.findElements(radiogroupClipTypeOptions);

			for (WebElement i : optionsClipType)
				if (i.getAttribute("value").equals(type)) {
					i.click();
				}
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
		}
	}

	public int FilterBadgesCount() {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.visibilityOfAllElementsLocatedBy(filterBadges));
			List<WebElement> list = driver.findElements(filterBadges);
			return list.size();
		} catch (Throwable e) {
			ExtentTestManager.getTest().log(Status.INFO, e);
			System.out.println(e);
			return 0;
		}
	}
}