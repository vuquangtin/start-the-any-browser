package com.start.the.any.browser.selenium.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FinancialAssessmentPage {
	private static WebElement element = null;

	public static WebElement selectForexTradingExperience(WebDriver driver)
			throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = wait.until(ExpectedConditions.elementToBeClickable(By
				.id("forextradingexperience")));
		Assert.assertTrue(element.isDisplayed());
		return element;
	}

	public static WebElement selectForexTradingFrequency(WebDriver driver)
			throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = wait.until(ExpectedConditions.elementToBeClickable(By
				.id("forextradingfrequency")));
		Assert.assertTrue(element.isDisplayed());
		return element;
	}

	public static WebElement selectIndicesTradingExperience(WebDriver driver)
			throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = wait.until(ExpectedConditions.elementToBeClickable(By
				.id("indicestradingexperience")));
		Assert.assertTrue(element.isDisplayed());
		return element;
	}

	public static WebElement selectIndicesTradingFrequency(WebDriver driver)
			throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = wait.until(ExpectedConditions.elementToBeClickable(By
				.id("indicestradingfrequency")));
		Assert.assertTrue(element.isDisplayed());
		return element;
	}

	public static WebElement selectCommoditiesTradingExperience(
			WebDriver driver) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = wait.until(ExpectedConditions.elementToBeClickable(By
				.id("commoditiestradingexperience")));
		Assert.assertTrue(element.isDisplayed());
		return element;
	}

	public static WebElement selectCommoditiesTradingFrequency(WebDriver driver)
			throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = wait.until(ExpectedConditions.elementToBeClickable(By
				.id("commoditiestradingfrequency")));
		Assert.assertTrue(element.isDisplayed());
		return element;
	}

	public static WebElement selectStocksTradingExperience(WebDriver driver)
			throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = wait.until(ExpectedConditions.elementToBeClickable(By
				.id("stockstradingexperience")));
		Assert.assertTrue(element.isDisplayed());
		return element;
	}

	public static WebElement selectStocksTradingFrequency(WebDriver driver)
			throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = wait.until(ExpectedConditions.elementToBeClickable(By
				.id("stockstradingfrequency")));
		Assert.assertTrue(element.isDisplayed());
		return element;
	}

	public static WebElement selectOtherDerivatiesTradingExperience(
			WebDriver driver) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = wait.until(ExpectedConditions.elementToBeClickable(By
				.id("otherderivativestradingexperience")));
		Assert.assertTrue(element.isDisplayed());
		return element;
	}

	public static WebElement selectOtherDerivatiesTradingFrequency(
			WebDriver driver) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = wait.until(ExpectedConditions.elementToBeClickable(By
				.id("otherderivativestradingfrequency")));
		Assert.assertTrue(element.isDisplayed());
		return element;
	}

	public static WebElement selectOtherTradingExperience(WebDriver driver)
			throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = wait.until(ExpectedConditions.elementToBeClickable(By
				.id("otherinstrumentstradingexperience")));
		Assert.assertTrue(element.isDisplayed());
		return element;
	}

	public static WebElement selectOtherTradingFrequency(WebDriver driver)
			throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = wait.until(ExpectedConditions.elementToBeClickable(By
				.id("otherinstrumentstradingfrequency")));
		Assert.assertTrue(element.isDisplayed());
		return element;
	}

	public static WebElement selectIndustryEmployment(WebDriver driver)
			throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = wait.until(ExpectedConditions.elementToBeClickable(By
				.id("employmentindustry")));
		Assert.assertTrue(element.isDisplayed());
		return element;
	}

	public static WebElement selectOccupation(WebDriver driver)
			throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = wait.until(ExpectedConditions.elementToBeClickable(By
				.id("occupation")));
		Assert.assertTrue(element.isDisplayed());
		return element;
	}

	public static WebElement selectEducation(WebDriver driver)
			throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = wait.until(ExpectedConditions.elementToBeClickable(By
				.id("educationlevel")));
		Assert.assertTrue(element.isDisplayed());
		return element;
	}

	public static WebElement selectIncomeSource(WebDriver driver)
			throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = wait.until(ExpectedConditions.elementToBeClickable(By
				.id("incomesource")));
		Assert.assertTrue(element.isDisplayed());
		return element;
	}

	public static WebElement selectAnnualIncome(WebDriver driver)
			throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = wait.until(ExpectedConditions.elementToBeClickable(By
				.id("netincome")));
		Assert.assertTrue(element.isDisplayed());
		return element;
	}

	public static WebElement selectNetWorth(WebDriver driver) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = wait.until(ExpectedConditions.elementToBeClickable(By
				.id("estimatedworth")));
		Assert.assertTrue(element.isDisplayed());
		return element;
	}

	public static WebElement btnUpdate(WebDriver driver) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = wait.until(ExpectedConditions.elementToBeClickable(By
				.id("btnsubmit")));
		Assert.assertTrue(element.isDisplayed());
		return element;
	}

	public static WebElement msgSuccess(WebDriver driver) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(By
				.xpath(".//*[contains(@id,'msgform')]")));
		Assert.assertTrue(element.isDisplayed());
		return element;
	}

	public static WebElement msgNoChanges(WebDriver driver) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(By
				.xpath(".//*[@id='formmessage']")));
		Assert.assertTrue(element.isDisplayed());
		return element;
	}

	public static WebElement errorForexTradingExperience(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath(".//*[@id='frmassessment']/fieldset[1]/div[1]/div[2]/div")));
		Assert.assertTrue(element.isDisplayed());
		return element;
	}

	public static WebElement errorForexTradingFrequency(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath(".//*[@id='frmassessment']/fieldset[1]/div[2]/div[2]/div")));
		Assert.assertTrue(element.isDisplayed());
		return element;
	}

	public static WebElement errorIndicesTradingExperience(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath(".//*[@id='frmassessment']/fieldset[1]/div[3]/div[2]/div")));
		Assert.assertTrue(element.isDisplayed());
		return element;
	}

	public static WebElement errorIndicesTradingFrequency(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath(".//*[@id='frmassessment']/fieldset[1]/div[4]/div[2]/div")));
		Assert.assertTrue(element.isDisplayed());
		return element;
	}

	public static WebElement errorCommoditiesTradingExperience(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath(".//*[@id='frmassessment']/fieldset[1]/div[5]/div[2]/div")));
		Assert.assertTrue(element.isDisplayed());
		return element;
	}

	public static WebElement errorCommoditiesTradingFrequency(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath(".//*[@id='frmassessment']/fieldset[1]/div[6]/div[2]/div")));
		Assert.assertTrue(element.isDisplayed());
		return element;
	}

	public static WebElement errorStocksTradingExperience(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath(".//*[@id='frmassessment']/fieldset[1]/div[7]/div[2]/div")));
		Assert.assertTrue(element.isDisplayed());
		return element;
	}

	public static WebElement errorStocksTradingFrequency(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath(".//*[@id='frmassessment']/fieldset[1]/div[8]/div[2]/div")));
		Assert.assertTrue(element.isDisplayed());
		return element;
	}

	public static WebElement errorOtherDerivatiesTradingExperience(
			WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath(".//*[@id='frmassessment']/fieldset[1]/div[9]/div[2]/div")));
		Assert.assertTrue(element.isDisplayed());
		return element;
	}

	public static WebElement errorOtherDerivatiesTradingFrequency(
			WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath(".//*[@id='frmassessment']/fieldset[1]/div[10]/div[2]/div")));
		Assert.assertTrue(element.isDisplayed());
		return element;
	}

	public static WebElement errorOtherTradingExperience(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath(".//*[@id='frmassessment']/fieldset[1]/div[11]/div[2]/div")));
		Assert.assertTrue(element.isDisplayed());
		return element;
	}

	public static WebElement errorOtherTradingFrequency(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath(".//*[@id='frmassessment']/fieldset[1]/div[12]/div[2]/div")));
		Assert.assertTrue(element.isDisplayed());
		return element;
	}

	public static WebElement errorIndustryEmployment(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath(".//*[@id='frmassessment']/fieldset[1]/div[13]/div[2]/div")));
		Assert.assertTrue(element.isDisplayed());
		return element;
	}

	public static WebElement errorOccupation(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath(".//*[@id='frmassessment']/fieldset[1]/div[14]/div[2]/div")));
		Assert.assertTrue(element.isDisplayed());
		return element;
	}

	public static WebElement errorEducation(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath(".//*[@id='frmassessment']/fieldset[1]/div[15]/div[2]/div")));
		Assert.assertTrue(element.isDisplayed());
		return element;
	}

	public static WebElement errorIncomeSource(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath(".//*[@id='frmassessment']/fieldset[1]/div[16]/div[2]/div")));
		Assert.assertTrue(element.isDisplayed());
		return element;
	}

	public static WebElement errorAnnualIncome(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath(".//*[@id='frmassessment']/fieldset[1]/div[17]/div[2]/div")));
		Assert.assertTrue(element.isDisplayed());
		return element;
	}

	public static WebElement errorNetWorth(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath(".//*[@id='frmassessment']/fieldset[1]/div[18]/div[2]/div")));
		Assert.assertTrue(element.isDisplayed());
		return element;
	}

}