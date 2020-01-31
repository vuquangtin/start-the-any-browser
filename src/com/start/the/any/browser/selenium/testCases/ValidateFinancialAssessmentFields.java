package com.start.the.any.browser.selenium.testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.start.the.any.browser.selenium.appModules.LoginAction;
import com.start.the.any.browser.selenium.appModules.SetFinancialAssessmentAction;
import com.start.the.any.browser.selenium.pageObjects.FinancialAssessmentPage;
import com.start.the.any.browser.selenium.pageObjects.MainAccountMenu;
import com.start.the.any.browser.selenium.pageObjects.ProfilePage;

public class ValidateFinancialAssessmentFields {
	public WebDriver driver;

	@Test(priority = 0)
	public void Login() throws Exception {
		LoginAction.Execute(driver, Constant.Email, Constant.Password);
	}

	@Test(priority = 1)
	public void NavigateToFinancialAssessmentPage() throws Exception {
		MainAccountMenu.linkMainAccount(driver).click();
		MainAccountMenu.linkProfile(driver).click();
		ProfilePage.linkFinancialAssessment(driver).click();
	}

	@Test(priority = 2)
	public void TestForexTradingExperience() throws Exception {
		SetFinancialAssessmentAction.Execute(driver, Constant.selectvalue,
				Constant.fxtradingfrequency, Constant.indicestradingexperience,
				Constant.indicestradingfrequency,
				Constant.commoditiestradingexperience,
				Constant.commoditiestradingfrequency,
				Constant.stockstradingexperience,
				Constant.stockstradingfrequency,
				Constant.othertradingexperience,
				Constant.othertradingfrequency,
				Constant.otherderivativetradingexperience,
				Constant.otherderivativetradingfrequency,
				Constant.employmentindustry, Constant.occupation,
				Constant.education, Constant.incomesource,
				Constant.annualincome, Constant.networth);
		if (FinancialAssessmentPage.errorForexTradingExperience(driver)
				.isDisplayed()) {
			System.out
					.println("Field validation for forex trading experience is working");
		}
	}

	@Test(priority = 3)
	public void TestForexTradingFrequency() throws Exception {
		SetFinancialAssessmentAction.Execute(driver,
				Constant.fxtradingexerience, Constant.selectvalue,
				Constant.indicestradingexperience,
				Constant.indicestradingfrequency,
				Constant.commoditiestradingexperience,
				Constant.commoditiestradingfrequency,
				Constant.stockstradingexperience,
				Constant.stockstradingfrequency,
				Constant.othertradingexperience,
				Constant.othertradingfrequency,
				Constant.otherderivativetradingexperience,
				Constant.otherderivativetradingfrequency,
				Constant.employmentindustry, Constant.occupation,
				Constant.education, Constant.incomesource,
				Constant.annualincome, Constant.networth);
		if (FinancialAssessmentPage.errorForexTradingFrequency(driver)
				.isDisplayed()) {
			System.out
					.println("Field validation for forex trading frquency is working");
		}
	}

	@Test(priority = 4)
	public void TestIndicesTradingExperience() throws Exception {
		SetFinancialAssessmentAction.Execute(driver,
				Constant.fxtradingexerience, Constant.fxtradingfrequency,
				Constant.selectvalue, Constant.indicestradingfrequency,
				Constant.commoditiestradingexperience,
				Constant.commoditiestradingfrequency,
				Constant.stockstradingexperience,
				Constant.stockstradingfrequency,
				Constant.othertradingexperience,
				Constant.othertradingfrequency,
				Constant.otherderivativetradingexperience,
				Constant.otherderivativetradingfrequency,
				Constant.employmentindustry, Constant.occupation,
				Constant.education, Constant.incomesource,
				Constant.annualincome, Constant.networth);
		if (FinancialAssessmentPage.errorIndicesTradingExperience(driver)
				.isDisplayed()) {
			System.out
					.println("Field validation for forex trading frquency is working");
		}
	}

	@Test(priority = 5)
	public void TestIndicesTradingFrequency() throws Exception {
		SetFinancialAssessmentAction.Execute(driver,
				Constant.fxtradingexerience, Constant.fxtradingfrequency,
				Constant.indicestradingexperience, Constant.selectvalue,
				Constant.commoditiestradingexperience,
				Constant.commoditiestradingfrequency,
				Constant.stockstradingexperience,
				Constant.stockstradingfrequency,
				Constant.othertradingexperience,
				Constant.othertradingfrequency,
				Constant.otherderivativetradingexperience,
				Constant.otherderivativetradingfrequency,
				Constant.employmentindustry, Constant.occupation,
				Constant.education, Constant.incomesource,
				Constant.annualincome, Constant.networth);
		if (FinancialAssessmentPage.errorIndicesTradingFrequency(driver)
				.isDisplayed()) {
			System.out
					.println("Field validation for Indices trading frequency is working");
		}
	}

	@Test(priority = 6)
	public void TestCommoditiesTradingExperience() throws Exception {
		SetFinancialAssessmentAction.Execute(driver,
				Constant.fxtradingexerience, Constant.fxtradingfrequency,
				Constant.indicestradingexperience,
				Constant.indicestradingfrequency, Constant.selectvalue,
				Constant.commoditiestradingfrequency,
				Constant.stockstradingexperience,
				Constant.stockstradingfrequency,
				Constant.othertradingexperience,
				Constant.othertradingfrequency,
				Constant.otherderivativetradingexperience,
				Constant.otherderivativetradingfrequency,
				Constant.employmentindustry, Constant.occupation,
				Constant.education, Constant.incomesource,
				Constant.annualincome, Constant.networth);
		if (FinancialAssessmentPage.errorCommoditiesTradingExperience(driver)
				.isDisplayed()) {
			System.out
					.println("Field validation for Commodities trading experience is working");
		}
	}

	@Test(priority = 7)
	public void TestCommoditiesTradingFrequency() throws Exception {
		SetFinancialAssessmentAction.Execute(driver,
				Constant.fxtradingexerience, Constant.fxtradingfrequency,
				Constant.indicestradingexperience,
				Constant.indicestradingfrequency,
				Constant.commoditiestradingexperience, Constant.selectvalue,
				Constant.stockstradingexperience,
				Constant.stockstradingfrequency,
				Constant.othertradingexperience,
				Constant.othertradingfrequency,
				Constant.otherderivativetradingexperience,
				Constant.otherderivativetradingfrequency,
				Constant.employmentindustry, Constant.occupation,
				Constant.education, Constant.incomesource,
				Constant.annualincome, Constant.networth);
		if (FinancialAssessmentPage.errorCommoditiesTradingFrequency(driver)
				.isDisplayed()) {
			System.out
					.println("Field validation for Commodities trading frequency is working");
		}
	}

	@Test(priority = 8)
	public void TestStocksTradingExperience() throws Exception {
		SetFinancialAssessmentAction.Execute(driver,
				Constant.fxtradingexerience, Constant.fxtradingfrequency,
				Constant.indicestradingexperience,
				Constant.indicestradingfrequency,
				Constant.commoditiestradingexperience,
				Constant.commoditiestradingfrequency, Constant.selectvalue,
				Constant.stockstradingfrequency,
				Constant.othertradingexperience,
				Constant.othertradingfrequency,
				Constant.otherderivativetradingexperience,
				Constant.otherderivativetradingfrequency,
				Constant.employmentindustry, Constant.occupation,
				Constant.education, Constant.incomesource,
				Constant.annualincome, Constant.networth);
		if (FinancialAssessmentPage.errorStocksTradingExperience(driver)
				.isDisplayed()) {
			System.out
					.println("Field validation for Stocks trading experience is working");
		}
	}

	@Test(priority = 9)
	public void TestStocksTradingFrequency() throws Exception {
		SetFinancialAssessmentAction.Execute(driver,
				Constant.fxtradingexerience, Constant.fxtradingfrequency,
				Constant.indicestradingexperience,
				Constant.indicestradingfrequency,
				Constant.commoditiestradingexperience,
				Constant.commoditiestradingfrequency,
				Constant.stockstradingexperience, Constant.selectvalue,
				Constant.othertradingexperience,
				Constant.othertradingfrequency,
				Constant.otherderivativetradingexperience,
				Constant.otherderivativetradingfrequency,
				Constant.employmentindustry, Constant.occupation,
				Constant.education, Constant.incomesource,
				Constant.annualincome, Constant.networth);
		if (FinancialAssessmentPage.errorStocksTradingFrequency(driver)
				.isDisplayed()) {
			System.out
					.println("Field validation for Stocks trading frequency is working");
		}
	}

	@Test(priority = 10)
	public void TestOtherTradingExperience() throws Exception {
		SetFinancialAssessmentAction.Execute(driver,
				Constant.fxtradingexerience, Constant.fxtradingfrequency,
				Constant.indicestradingexperience,
				Constant.indicestradingfrequency,
				Constant.commoditiestradingexperience,
				Constant.commoditiestradingfrequency,
				Constant.stockstradingexperience,
				Constant.stockstradingfrequency, Constant.selectvalue,
				Constant.othertradingfrequency,
				Constant.otherderivativetradingexperience,
				Constant.otherderivativetradingfrequency,
				Constant.employmentindustry, Constant.occupation,
				Constant.education, Constant.incomesource,
				Constant.annualincome, Constant.networth);
		if (FinancialAssessmentPage.errorOtherTradingExperience(driver)
				.isDisplayed()) {
			System.out
					.println("Field validation for Binary options or other financial derivatives trading experience is working");
		}
	}

	@Test(priority = 11)
	public void TestOtherTradingFrequency() throws Exception {
		SetFinancialAssessmentAction.Execute(driver,
				Constant.fxtradingexerience, Constant.fxtradingfrequency,
				Constant.indicestradingexperience,
				Constant.indicestradingfrequency,
				Constant.commoditiestradingexperience,
				Constant.commoditiestradingfrequency,
				Constant.stockstradingexperience,
				Constant.stockstradingfrequency,
				Constant.othertradingexperience, Constant.selectvalue,
				Constant.otherderivativetradingexperience,
				Constant.otherderivativetradingfrequency,
				Constant.employmentindustry, Constant.occupation,
				Constant.education, Constant.incomesource,
				Constant.annualincome, Constant.networth);
		if (FinancialAssessmentPage.errorOtherTradingFrequency(driver)
				.isDisplayed()) {
			System.out
					.println("Field validation for Binary options or other financial derivatives trading frequency is working");
		}
	}

	@Test(priority = 12)
	public void TestOtherDerivatiesTradingExperience() throws Exception {
		SetFinancialAssessmentAction.Execute(driver,
				Constant.fxtradingexerience, Constant.fxtradingfrequency,
				Constant.indicestradingexperience,
				Constant.indicestradingfrequency,
				Constant.commoditiestradingexperience,
				Constant.commoditiestradingfrequency,
				Constant.stockstradingexperience,
				Constant.stockstradingfrequency,
				Constant.othertradingexperience,
				Constant.othertradingfrequency, Constant.selectvalue,
				Constant.otherderivativetradingfrequency,
				Constant.employmentindustry, Constant.occupation,
				Constant.education, Constant.incomesource,
				Constant.annualincome, Constant.networth);
		if (FinancialAssessmentPage.errorOtherDerivatiesTradingExperience(
				driver).isDisplayed()) {
			System.out
					.println("Field validation for Other financial instruments trading experience is working");
		}
	}

	@Test(priority = 13)
	public void TestOtherDerivatiesTradingFrequency() throws Exception {
		SetFinancialAssessmentAction.Execute(driver,
				Constant.fxtradingexerience, Constant.fxtradingfrequency,
				Constant.indicestradingexperience,
				Constant.indicestradingfrequency,
				Constant.commoditiestradingexperience,
				Constant.commoditiestradingfrequency,
				Constant.stockstradingexperience,
				Constant.stockstradingfrequency,
				Constant.othertradingexperience,
				Constant.othertradingfrequency,
				Constant.otherderivativetradingexperience,
				Constant.selectvalue, Constant.employmentindustry,
				Constant.occupation, Constant.education, Constant.incomesource,
				Constant.annualincome, Constant.networth);
		if (FinancialAssessmentPage
				.errorOtherDerivatiesTradingFrequency(driver).isDisplayed()) {
			System.out
					.println("Field validation for Other financial instruments trading frequency is working");
		}
	}

	@Test(priority = 14)
	public void TestIndustryEmployment() throws Exception {
		SetFinancialAssessmentAction.Execute(driver,
				Constant.fxtradingexerience, Constant.fxtradingfrequency,
				Constant.indicestradingexperience,
				Constant.indicestradingfrequency,
				Constant.commoditiestradingexperience,
				Constant.commoditiestradingfrequency,
				Constant.stockstradingexperience,
				Constant.stockstradingfrequency,
				Constant.othertradingexperience,
				Constant.othertradingfrequency,
				Constant.otherderivativetradingexperience,
				Constant.otherderivativetradingfrequency, Constant.selectvalue,
				Constant.occupation, Constant.education, Constant.incomesource,
				Constant.annualincome, Constant.networth);
		if (FinancialAssessmentPage.errorIndustryEmployment(driver)
				.isDisplayed()) {
			System.out
					.println("Field validation for Industry of Employment is working");
		}
	}

	@Test(priority = 15)
	public void TestOccupation() throws Exception {
		SetFinancialAssessmentAction.Execute(driver,
				Constant.fxtradingexerience, Constant.fxtradingfrequency,
				Constant.indicestradingexperience,
				Constant.indicestradingfrequency,
				Constant.commoditiestradingexperience,
				Constant.commoditiestradingfrequency,
				Constant.stockstradingexperience,
				Constant.stockstradingfrequency,
				Constant.othertradingexperience,
				Constant.othertradingfrequency,
				Constant.otherderivativetradingexperience,
				Constant.otherderivativetradingfrequency,
				Constant.employmentindustry, Constant.selectvalue,
				Constant.education, Constant.incomesource,
				Constant.annualincome, Constant.networth);
		if (FinancialAssessmentPage.errorOccupation(driver).isDisplayed()) {
			System.out.println("Field validation for Occupation is working");
		}
	}

	@Test(priority = 16)
	public void TestEducation() throws Exception {
		SetFinancialAssessmentAction.Execute(driver,
				Constant.fxtradingexerience, Constant.fxtradingfrequency,
				Constant.indicestradingexperience,
				Constant.indicestradingfrequency,
				Constant.commoditiestradingexperience,
				Constant.commoditiestradingfrequency,
				Constant.stockstradingexperience,
				Constant.stockstradingfrequency,
				Constant.othertradingexperience,
				Constant.othertradingfrequency,
				Constant.otherderivativetradingexperience,
				Constant.otherderivativetradingfrequency,
				Constant.employmentindustry, Constant.occupation,
				Constant.selectvalue, Constant.incomesource,
				Constant.annualincome, Constant.networth);
		if (FinancialAssessmentPage.errorEducation(driver).isDisplayed()) {
			System.out.println("Field validation for Education is working");
		}
	}

	@Test(priority = 17)
	public void TestAnnualIncome() throws Exception {
		SetFinancialAssessmentAction.Execute(driver,
				Constant.fxtradingexerience, Constant.fxtradingfrequency,
				Constant.indicestradingexperience,
				Constant.indicestradingfrequency,
				Constant.commoditiestradingexperience,
				Constant.commoditiestradingfrequency,
				Constant.stockstradingexperience,
				Constant.stockstradingfrequency,
				Constant.othertradingexperience,
				Constant.othertradingfrequency,
				Constant.otherderivativetradingexperience,
				Constant.otherderivativetradingfrequency,
				Constant.employmentindustry, Constant.occupation,
				Constant.education, Constant.incomesource,
				Constant.selectvalue, Constant.networth);
		if (FinancialAssessmentPage.errorAnnualIncome(driver).isDisplayed()) {
			System.out.println("Field validation for Annual Income is working");
		}
	}

	@Test(priority = 18)
	public void TestNetWorth() throws Exception {
		SetFinancialAssessmentAction.Execute(driver,
				Constant.fxtradingexerience, Constant.fxtradingfrequency,
				Constant.indicestradingexperience,
				Constant.indicestradingfrequency,
				Constant.commoditiestradingexperience,
				Constant.commoditiestradingfrequency,
				Constant.stockstradingexperience,
				Constant.stockstradingfrequency,
				Constant.othertradingexperience,
				Constant.othertradingfrequency,
				Constant.otherderivativetradingexperience,
				Constant.otherderivativetradingfrequency,
				Constant.employmentindustry, Constant.occupation,
				Constant.education, Constant.incomesource,
				Constant.annualincome, Constant.selectvalue);
		if (FinancialAssessmentPage.errorNetWorth(driver).isDisplayed()) {
			System.out.println("Field validation for Net Worth is working");
		}
	}

	@BeforeTest
	public void launchApplication() {

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(Constant.URL);
	}

	@AfterTest
	public void endSession() {
		driver.quit();
	}
}