package com.start.the.any.browser.selenium.appModules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.start.the.any.browser.selenium.pageObjects.FinancialAssessmentPage;

public class SetFinancialAssessmentAction {

	public static void Execute(WebDriver driver, String fxtradingexerience,
			String fxtradingfrequency, String indicestradingexperience,
			String indicestradingfrequency,
			String commoditiestradingexperience,
			String commoditiestradingfrequency,
			String stockstradingexperience, String stockstradingfrequency,
			String othertradingexperience, String othertradingfrequency,
			String otherderivativetradingexperience,
			String otherderivativetradingfrequency,
			String employmentindustry, String occupation, String education,
			String incomesource, String annualincome, String networth)
			throws Exception {
		Select oSelectfxtradingexerience = new Select(
				FinancialAssessmentPage.selectForexTradingExperience(driver));
		oSelectfxtradingexerience.selectByValue(fxtradingexerience);
		Select oSelectfxtradingfrequency = new Select(
				FinancialAssessmentPage.selectForexTradingFrequency(driver));
		oSelectfxtradingfrequency.selectByValue(fxtradingfrequency);
		Select oSelectindicestradingexperience = new Select(
				FinancialAssessmentPage
						.selectIndicesTradingExperience(driver));
		oSelectindicestradingexperience
				.selectByValue(indicestradingexperience);
		Select oSelectindicestradingfrequency = new Select(
				FinancialAssessmentPage.selectIndicesTradingFrequency(driver));
		oSelectindicestradingfrequency
				.selectByValue(indicestradingfrequency);
		Select oSelectcommoditiestradingexperience = new Select(
				FinancialAssessmentPage
						.selectCommoditiesTradingExperience(driver));
		oSelectcommoditiestradingexperience
				.selectByValue(commoditiestradingexperience);
		Select oSelectcommoditiestradingfrequency = new Select(
				FinancialAssessmentPage
						.selectCommoditiesTradingFrequency(driver));
		oSelectcommoditiestradingfrequency
				.selectByValue(commoditiestradingfrequency);
		Select oSelectstockstradingexperience = new Select(
				FinancialAssessmentPage.selectStocksTradingExperience(driver));
		oSelectstockstradingexperience
				.selectByValue(stockstradingexperience);
		Select oSelectstockstradingfrequency = new Select(
				FinancialAssessmentPage.selectStocksTradingFrequency(driver));
		oSelectstockstradingfrequency
				.selectByValue(stockstradingfrequency);
		Select oSelectbinaryoptionstradingexperience = new Select(
				FinancialAssessmentPage.selectOtherTradingExperience(driver));
		oSelectbinaryoptionstradingexperience
				.selectByValue(othertradingexperience);
		Select oSelectbinaryoptionstradingfrequency = new Select(
				FinancialAssessmentPage.selectOtherTradingFrequency(driver));
		oSelectbinaryoptionstradingfrequency
				.selectByValue(othertradingfrequency);
		Select oSelectotherderivativesexperience = new Select(
				FinancialAssessmentPage
						.selectOtherDerivatiesTradingExperience(driver));
		oSelectotherderivativesexperience
				.selectByValue(otherderivativetradingexperience);
		Select oSelectotherderivativesfrequency = new Select(
				FinancialAssessmentPage
						.selectOtherDerivatiesTradingFrequency(driver));
		oSelectotherderivativesfrequency
				.selectByValue(otherderivativetradingfrequency);
		Select oSelectemploymentindustry = new Select(
				FinancialAssessmentPage.selectIndustryEmployment(driver));
		oSelectemploymentindustry.selectByValue(employmentindustry);
		Select oSelectoccupation = new Select(
				FinancialAssessmentPage.selectOccupation(driver));
		oSelectoccupation.selectByValue(occupation);
		Select oSelecteducation = new Select(
				FinancialAssessmentPage.selectEducation(driver));
		oSelecteducation.selectByValue(education);
		Select oSelectannualincome = new Select(
				FinancialAssessmentPage.selectAnnualIncome(driver));
		oSelectannualincome.selectByValue(annualincome);
		Select oSelectnetworth = new Select(
				FinancialAssessmentPage.selectNetWorth(driver));
		oSelectnetworth.selectByValue(networth);
		FinancialAssessmentPage.btnUpdate(driver).click();
	}
}