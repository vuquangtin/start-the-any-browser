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

public class ValidateSetFinancialAssessment {
	public WebDriver driver;

	@Test
	public void ALogin() throws Exception {
		LoginAction.Execute(driver, Constant.Email, Constant.Password);
	}

	@Test
	public void BNavigateToFinancialAssessmentPage() throws Exception {
		MainAccountMenu.linkMainAccount(driver).click();
		MainAccountMenu.linkProfile(driver).click();
		ProfilePage.linkFinancialAssessment(driver).click();
	}

	@Test
	public void CSetFinancialAssessment() throws Exception {
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
				Constant.annualincome, Constant.networth);
		if (FinancialAssessmentPage.msgSuccess(driver).isDisplayed()) {
			System.out.println(FinancialAssessmentPage.msgSuccess(driver)
					.getText());
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