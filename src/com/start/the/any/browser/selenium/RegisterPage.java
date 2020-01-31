package com.start.the.any.browser.selenium;

import static jdk.nashorn.internal.objects.NativeString.trim;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {

	private WebDriver driver;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}

	// Path to the resource directory

	private File resourcesDirectory = new File("src/main/resources");

	// The testing site's URL

	private String url = "http://afdatest.nome.co.za/";

	// XPathes for Pre_register page
	private By buttonRegister = By.xpath("//button/span[text()='Register']");
	private By anchorPre_register = By
			.xpath("//div[@class='col-centered col-sm-4 col-xs-12']/h2");
	private By checkboxIagree = By.xpath("//label[@for='agreement_checkbox']");
	private By buttonNextPreRegister = By.id("next_button");
	// XPathes for Register/2 page
	private By fieldFirstName = By.id("first_name");
	private By fieldlastName = By.id("last_name");
	private By fieldCellPhone = By.name("cellphone");
	private By fieldEmail = By.name("email");
	private By fieldConfirmEmail = By.name("email_confirmation");
	private By fieldPassword = By.name("password");
	private By fieldConfirmPassword = By.name("password_confirmation");
	private By buttonRegisterRegister2 = By.id("register_btn");
	// XPathes for Apphome page
	private By anchorApphome = By.xpath("//div[@class='jumbotron']/a");
	// XPathes for select_institution page
	private By dropboxSelectInstitute = By.id("institution_select");
	private By optionAFDA = By
			.xpath("//select[@id='institution_select']/option[@value='1']");
	private By buttonNextSelectInstitution = By
			.xpath("//input[@type='submit']");
	// XPathe for assessment_process_intro/1 page
	private By buttonNextAssessment = By
			.xpath("//div[@class='col-xs-12 text-center']/a");
	// XPathe for consent_app_page/119 page
	private By buttonConcentApp = By
			.xpath("//div[@class='col-md-12  text-center']/a");
	// XPath for Payment page
	private By linkOnlyForTest = By.xpath("(//div[@class='row']/a)[1]");
	// XPathes for BIOGRAPHICAL DATA page
	private By dropboxTitle = By.id("id_title");
	private By optionTitle = By
			.xpath("//select[@id='id_title']/option[@value='MR']");
	private By dropboxGender = By.id("id_applicant_gender");
	private By optionGender = By
			.xpath("//select[@id='id_applicant_gender']/option[@value='1']");
	private By dropboxID = By.id("id_id_type");
	private By optionID = By
			.xpath("//select[@id='id_id_type']/option[@value='ID']");
	private By fieldID = By.id("id_id_number");
	private By inputIDdoc = By.id("id_id_doc");
	private By fieldBirthdate = By.id("id_birth_date");
	private By dropboxEquityCode = By.id("id_equity_code");
	private By optionEquityCode = By
			.xpath("//select[@id='id_equity_code']/option[@value='W']");
	private By dropboxNationality = By.id("id_nationality");
	private By optionNationality = By
			.xpath("//select[@id='id_nationality']/option[@value='UA']");
	private By dropboxHomeLanguage = By.id("id_home_language");
	private By optionHomeLanguage = By
			.xpath("//select[@id='id_home_language']/option[@value='4']");
	private By dropboxRSACitizen = By.id("id_rsa_citizen_resident_status");
	private By optionRSACitizen = By
			.xpath("//select[@id='id_rsa_citizen_resident_status']/option[@value='Y']");
	private By dropboxSocioStatus = By.id("id_socio_economic_status");
	private By optionSocioStatus = By
			.xpath("//select[@id='id_socio_economic_status']/option[@value='H']");
	private By dropboxHasDisabilityStatus = By.id("id_has_disability_status");
	private By optionHasDisabilityStatus = By
			.xpath("//select[@id='id_has_disability_status']/option[@value='Y']");
	private By dropboxDisabilityStatus = By.id("id_disability_status");
	private By optionDisabilityStatus = By
			.xpath("//select[@id='id_disability_status']/option[@value='C']");
	private By fieldHomeAddress = By.id("id_home_address");
	private By fieldPostAddress = By.id("id_postal_address");
	private By buttonNextBioData = By
			.xpath("//div[@class='col-xs-12 text-center']/input[@type='submit']");
	// XPathes for COURSE QUALIFICATION page
	private By dropboxCourseCampus = By.id("id_course_campus");
	private By optionCourseCampus = By
			.xpath("//select[@id ='id_course_campus']/option[@value='2']");
	private By dropboxCourseName = By.id("courses");
	private By optionCourseName = By
			.xpath("//select[@id ='courses']/option[@value='3']");
	private By dropboxCampusAssessed = By.id("id_assesmment_campus_same_yn");
	private By optionCampusAssessed = By
			.xpath("//select[@id ='id_assesmment_campus_same_yn']/option[@value='Y']");
	private By buttonNextCourseQualify = By
			.xpath("//div[@class='col-xs-12 text-center']/input[@type='submit']");
	// XPathes for LATEST FORMAL QUALIFICATIONS COMPLETED TO DATE page
	private By fieldYearQualificationCompletion = By
			.id("id_qualification_year");
	private By dropboxQualificationType = By.id("id_qualification_type");
	private By optionQualificationType = By
			.xpath("//select[@id='id_qualification_type']/option[@value='1']");
	private By dropboxQualificationResult = By.id("id_qualification_result");
	private By optionQualificationResult = By
			.xpath("//select[@id='id_qualification_result']/option[@value='Pass DA']");
	private By inputDiploma = By.id("id_qual_doc_name");
	private By buttonNextLatestQualify = By
			.xpath("//div[@class='col-xs-12 text-center']/input[@type='submit']");
	// XPathes for SR Questionnaire Instructions page
	private By buttonNextSrqAgreement = By.id("next_button");
	private By checkboxSrqAgreement = By
			.xpath("//label[@for='srq_agreement_checkbox']");
	// Xpathes for Section 1 LIFE FACTORS page
	private By buttonNextLifeFactors = By.id("next_button");
	private By anchorSections = By.xpath("//div[@class='row no-gutter']/h3");
	// Xpathes for Section 1 TECH
	private By buttonNextTech = By.id("next_button");
	// Xpathes for Section 2 INDIVIDUAL ATTRIBUTES
	private By buttonNextIndividual = By.id("next_button");
	// Xpathes for Section 3 LEARNING STYLES
	private By buttonNextLearning = By.id("next_button");
	// Xpathes for Portfolio of Learning Steps
	private By buttonNextPortfolio = By
			.xpath("//div[@class='col-xs-12 text-center']/input[@type='submit']");
	// Xpathes for Portfolio of Learning Creator Download
	private By buttonDownloadPol = By
			.xpath("//p[text()='Download your PoL assignment: ']/a");
	private By buttonDownloadAssignment = By
			.xpath("//p[text()='Download your assignment answer sheets: ']/a");
	private By buttonNextPortfolioCreator = By
			.xpath("//div[@class='col-xs-12 text-center']/input[@type='submit']");
	// XPathes for Upload your portfolio of learning assignment page
	private By inputPoLAnswerSheet = By.id("id_assignment_answer_sheet");
	private By buttonNextUploadPortfolio = By
			.xpath("//div[@class='col-xs-12 text-center']/input[@type='submit']");
	// XPathes for RATE YOURSELF page
	private By buttonNextRateYourself = By
			.xpath("//div[@class='col-xs-12 text-center']/input[@type='submit']");
	// Xpathes for PROVIDE EVIDENCE/ OTHER UPLOADS page
	private By fieldEvidence = By.id("id_form-0-title");
	private By inputEvidence = By.id("id_form-0-file");
	private By buttonNextEvidence = By
			.xpath("//div[@class='col-xs-12 text-center']/input[@type='submit']");
	// XPathes for Upload your motivational letter page
	private By inputMotivationLetter = By.id("id_motivational_letter");
	private By buttonNextMotivationLetter = By
			.xpath("//div[@class='col-xs-12 text-center']/input[@type='submit']");
	// XPathes for External References page
	private By dropboxReverenceTitle1 = By
			.xpath("//select[@id='id_ref_1_title']/option[@value='MR']");
	private By dropboxReverenceTitle2 = By
			.xpath("//select[@id='id_ref_2_title']/option[@value='MR']");
	private By fieldReferenceName1 = By.id("id_ref_1_name");
	private By fieldReferenceName2 = By.id("id_ref_2_name");
	private By fieldReferenceEmail1 = By.id("id_ref_1_email");
	private By fieldReferenceEmail2 = By.id("id_ref_2_email");
	private By fieldReferencePhone1 = By.id("id_ref_1_phone");
	private By fieldReferencePhone2 = By.id("id_ref_2_phone");
	private By fieldReferenceRelationship1 = By.id("id_ref_1_relationship");
	private By fieldReferenceRelationship2 = By.id("id_ref_2_relationship");
	private By buttonNextRelationship = By
			.xpath("//div[@class='col-xs-12 text-center']/input[@type='submit']");
	// XPathes for VERIFY page
	private By buttonNextVerify = By
			.xpath("//div[@class='col-xs-12 text-center']/input[@type='submit']");
	private By buttonHome = By.xpath("//a[@class='btn btn-primary']");
	private By anchorHome = By.xpath("(//form/p)[1]");

	public void registration() {
		driver.manage().window().maximize();
		driver.get(url);

		// Click the Register button

		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions.visibilityOfElementLocated(buttonRegister))
				.click();
		(new WebDriverWait(driver, 3)).until(ExpectedConditions
				.invisibilityOfElementLocated(buttonRegister));
		Assertions
				.assertEquals(
						(new WebDriverWait(driver, 3))
								.until(ExpectedConditions
										.visibilityOfElementLocated(anchorPre_register))
								.getText(), "Do I qualify?",
						"We are not on the pre_register page");

		// Click the checkbox and the Next button on the pre_register page

		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions.visibilityOfElementLocated(checkboxIagree))
				.click();
		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions
						.visibilityOfElementLocated(buttonNextPreRegister))
				.click();
		(new WebDriverWait(driver, 3)).until(ExpectedConditions
				.invisibilityOfElementLocated(buttonNextPreRegister));
		Assertions
				.assertEquals(
						(new WebDriverWait(driver, 3))
								.until(ExpectedConditions
										.visibilityOfElementLocated(anchorPre_register))
								.getText(), "Register on NOME Portal",
						"We are not on the register/2 page");

		// fill the Register on NOME Portal page

		String user_name = getUserName();
		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions.visibilityOfElementLocated(fieldFirstName))
				.sendKeys(user_name);
		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions.visibilityOfElementLocated(fieldlastName))
				.sendKeys(user_name);
		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions.visibilityOfElementLocated(fieldCellPhone))
				.sendKeys("+380999220963");
		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions.visibilityOfElementLocated(fieldEmail))
				.sendKeys(user_name + "@gmail.com");

		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions
						.visibilityOfElementLocated(fieldConfirmEmail))
				.sendKeys(user_name + "@gmail.com");
		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions.visibilityOfElementLocated(fieldPassword))
				.sendKeys("20nometest18");
		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions
						.visibilityOfElementLocated(fieldConfirmPassword))
				.sendKeys("20nometest18");
		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions
						.visibilityOfElementLocated(buttonRegisterRegister2))
				.click();
		(new WebDriverWait(driver, 3)).until(ExpectedConditions
				.invisibilityOfElementLocated(buttonRegisterRegister2));
		Assertions.assertEquals(
				(new WebDriverWait(driver, 3)).until(
						ExpectedConditions
								.visibilityOfElementLocated(anchorApphome))
						.getText(), "Start my RPL for Access process",
				"We are not on the apphome page");

		// Click the Start my RPL for Access process

		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions.visibilityOfElementLocated(anchorApphome))
				.click();
		(new WebDriverWait(driver, 3)).until(ExpectedConditions
				.invisibilityOfElementLocated(anchorApphome));
		Assertions
				.assertEquals(
						(new WebDriverWait(driver, 3))
								.until(ExpectedConditions
										.visibilityOfElementLocated(anchorPre_register))
								.getText(), "RPL for Access for information",
						"We are not on the select_institution page");

		// Fill the Select institution page

		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions
						.visibilityOfElementLocated(dropboxSelectInstitute))
				.click();
		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions
						.visibilityOfElementLocated(dropboxSelectInstitute))
				.click();
		(new WebDriverWait(driver, 3))
				.until(ExpectedConditions
						.visibilityOfElementLocated(buttonNextSelectInstitution))
				.click();
		(new WebDriverWait(driver, 5)).until(ExpectedConditions
				.invisibilityOfElementLocated(buttonNextSelectInstitution));
		Assertions
				.assertEquals(
						(new WebDriverWait(driver, 3))
								.until(ExpectedConditions
										.visibilityOfElementLocated(anchorPre_register))
								.getText(),
						"OVERVIEW OF THE RPL FOR ACCESS PROCESS",
						"We are not on the assessment_process_intro/1 page");

		// Click the Next button on the assessment_process_intro/1 page

		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions
						.visibilityOfElementLocated(buttonNextAssessment))
				.click();
		(new WebDriverWait(driver, 3)).until(ExpectedConditions
				.invisibilityOfElementLocated(buttonNextAssessment));
		Assertions
				.assertEquals(
						(new WebDriverWait(driver, 3))
								.until(ExpectedConditions
										.visibilityOfElementLocated(anchorPre_register))
								.getText(),
						"GENERAL TERMS, CONDITIONS AND CONSENT FORM",
						"We are not on the consent_app_page/114 page");

		// Click the Next button on the consent_app_page/119/

		(new WebDriverWait(driver, 3))
				.until(ExpectedConditions
						.visibilityOfElementLocated(buttonConcentApp)).click();
		(new WebDriverWait(driver, 3)).until(ExpectedConditions
				.invisibilityOfElementLocated(buttonConcentApp));
		Assertions
				.assertEquals(
						(new WebDriverWait(driver, 3))
								.until(ExpectedConditions
										.visibilityOfElementLocated(anchorPre_register))
								.getText(), "Payment",
						"We are not on the paymentSage/119 page");

		// Click the link on the Payment page

		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions.visibilityOfElementLocated(linkOnlyForTest))
				.click();
		(new WebDriverWait(driver, 3)).until(ExpectedConditions
				.invisibilityOfElementLocated(linkOnlyForTest));
		Assertions
				.assertEquals(
						(new WebDriverWait(driver, 3))
								.until(ExpectedConditions
										.visibilityOfElementLocated(anchorPre_register))
								.getText(), "BIOGRAPHICAL DATA",
						"We are not on the BIOGRAPHICAL DATA page");

		// Fill the BIOGRAPHICAL DATA page

		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions.visibilityOfElementLocated(dropboxTitle))
				.click();
		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions.visibilityOfElementLocated(optionTitle))
				.click();
		// (new WebDriverWait(driver,
		// 3)).until(ExpectedConditions.invisibilityOfElementLocated(optionTitle));
		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions.visibilityOfElementLocated(dropboxGender))
				.click();
		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions.visibilityOfElementLocated(optionGender))
				.click();
		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions.visibilityOfElementLocated(dropboxID))
				.click();
		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions.visibilityOfElementLocated(optionID))
				.click();
		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions.visibilityOfElementLocated(fieldID))
				.sendKeys("7311065120082");
		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions.visibilityOfElementLocated(inputIDdoc))
				.sendKeys(resourcesDirectory.getAbsolutePath() + "\\id.png");
		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions.visibilityOfElementLocated(fieldBirthdate))
				.sendKeys("06111973");
		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions
						.visibilityOfElementLocated(dropboxEquityCode)).click();
		(new WebDriverWait(driver, 3))
				.until(ExpectedConditions
						.visibilityOfElementLocated(optionEquityCode)).click();
		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions
						.visibilityOfElementLocated(dropboxNationality))
				.click();
		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions
						.visibilityOfElementLocated(optionNationality)).click();
		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions
						.visibilityOfElementLocated(dropboxHomeLanguage))
				.click();
		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions
						.visibilityOfElementLocated(optionHomeLanguage))
				.click();
		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions
						.visibilityOfElementLocated(dropboxRSACitizen)).click();
		(new WebDriverWait(driver, 3))
				.until(ExpectedConditions
						.visibilityOfElementLocated(optionRSACitizen)).click();
		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions
						.visibilityOfElementLocated(dropboxSocioStatus))
				.click();
		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions
						.visibilityOfElementLocated(optionSocioStatus)).click();
		(new WebDriverWait(driver, 3))
				.until(ExpectedConditions
						.visibilityOfElementLocated(dropboxHasDisabilityStatus))
				.click();
		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions
						.visibilityOfElementLocated(optionHasDisabilityStatus))
				.click();
		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions
						.visibilityOfElementLocated(dropboxDisabilityStatus))
				.click();
		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions
						.visibilityOfElementLocated(optionDisabilityStatus))
				.click();
		(new WebDriverWait(driver, 3))
				.until(ExpectedConditions
						.visibilityOfElementLocated(fieldHomeAddress))
				.sendKeys(
						"228 Johannes Ramokhoase(Proes) Street Pretoria South Africa");
		(new WebDriverWait(driver, 3))
				.until(ExpectedConditions
						.visibilityOfElementLocated(fieldPostAddress))
				.sendKeys("Private Bag X990 Pretoria South Africa");
		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions
						.visibilityOfElementLocated(buttonNextBioData)).click();
		(new WebDriverWait(driver, 3)).until(ExpectedConditions
				.invisibilityOfElementLocated(fieldHomeAddress));
		Assertions
				.assertEquals(
						(new WebDriverWait(driver, 3))
								.until(ExpectedConditions
										.visibilityOfElementLocated(anchorPre_register))
								.getText(), "COURSE QUALIFICATION",
						"We are not on the COURSE QUALIFICATION page");

		// Fill the COURSE QUALIFICATION page

		(new WebDriverWait(driver, 5)).until(
				ExpectedConditions.elementToBeClickable(dropboxCourseCampus))
				.click();
		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions.elementToBeClickable(optionCourseCampus))
				.click();
		(new WebDriverWait(driver, 5)).until(
				ExpectedConditions.elementToBeClickable(dropboxCourseName))
				.click();
		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions.elementToBeClickable(optionCourseName))
				.click();
		(new WebDriverWait(driver, 5)).until(
				ExpectedConditions.elementToBeClickable(dropboxCampusAssessed))
				.click();
		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions.elementToBeClickable(optionCampusAssessed))
				.click();
		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions
						.visibilityOfElementLocated(buttonNextCourseQualify))
				.click();
		(new WebDriverWait(driver, 3)).until(ExpectedConditions
				.invisibilityOfElementLocated(dropboxCourseCampus));
		Assertions
				.assertEquals(
						(new WebDriverWait(driver, 3))
								.until(ExpectedConditions
										.visibilityOfElementLocated(anchorPre_register))
								.getText(),
						"LATEST FORMAL QUALIFICATIONS COMPLETED TO DATE",
						"We are not on the LATEST FORMAL QUALIFICATIONS page");

		// Fill the LATEST FORMAL QUALIFICATIONS COMPLETED TO DATE page

		(new WebDriverWait(driver, 3))
				.until(ExpectedConditions
						.visibilityOfElementLocated(fieldYearQualificationCompletion))
				.sendKeys("1995");
		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions
						.visibilityOfElementLocated(dropboxQualificationType))
				.click();
		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions
						.visibilityOfElementLocated(optionQualificationType))
				.click();
		(new WebDriverWait(driver, 3))
				.until(ExpectedConditions
						.visibilityOfElementLocated(dropboxQualificationResult))
				.click();
		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions
						.visibilityOfElementLocated(optionQualificationResult))
				.click();
		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions.visibilityOfElementLocated(inputDiploma))
				.sendKeys(
						resourcesDirectory.getAbsolutePath() + "\\diploma.png");
		// fill the Subject + Persentage fields
		for (int i = 1; i < 9; i++) {
			String subjectId = "id_qual_sub" + i + "_name";
			String persentageId = "id_qual_sub" + i + "_percentage";
			String subjectName = "Subject name" + i;
			(new WebDriverWait(driver, 3)).until(
					ExpectedConditions.visibilityOfElementLocated(By
							.id(subjectId))).sendKeys(subjectName);
			(new WebDriverWait(driver, 3)).until(
					ExpectedConditions.visibilityOfElementLocated(By
							.id(persentageId))).sendKeys("100");
		}
		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions
						.visibilityOfElementLocated(buttonNextLatestQualify))
				.click();
		Assertions
				.assertEquals(
						(new WebDriverWait(driver, 3))
								.until(ExpectedConditions
										.visibilityOfElementLocated(anchorPre_register))
								.getText(), "SR Questionnaire Instructions",
						"We are not on the SR Questionnaire Instructions page");

		// Fill the SR Questionnaire Instructions page

		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions
						.visibilityOfElementLocated(checkboxSrqAgreement))
				.click();
		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions
						.visibilityOfElementLocated(buttonNextSrqAgreement))
				.click();
		Assertions
				.assertEquals(
						(new WebDriverWait(driver, 3))
								.until(ExpectedConditions
										.visibilityOfElementLocated(anchorPre_register))
								.getText(), "Study Readiness Questionnaire",
						"We are not on the Study Readiness Questionnaire page");

		// Fill the Section 1 LIFE FACTORS page

		// Click the questions from 1 to 20
		for (int i = 1; i < 21; i++) {
			String xpath = "//input[@name='question_" + i + "']";
			checkRadiobuttons(xpath);
		}

		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions.elementToBeClickable(buttonNextLifeFactors))
				.click();

		Assertions.assertEquals(
				(new WebDriverWait(driver, 3)).until(
						ExpectedConditions
								.visibilityOfElementLocated(anchorSections))
						.getText(), "Section 1 TECH",
				"We are not on the Section 1 TECH page");

		// Fill the Section 1 TECH page

		// Click the questions from 22 to 48
		for (int i = 22; i < 49; i++) {
			String xpath = "//input[@name='question_" + i + "']";
			checkRadiobuttons_reverse(xpath);
		}
		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions.elementToBeClickable(buttonNextTech))
				.click();
		Assertions.assertEquals(
				(new WebDriverWait(driver, 3)).until(
						ExpectedConditions
								.visibilityOfElementLocated(anchorSections))
						.getText(), "Section 2 INDIVIDUAL ATTRIBUTES",
				"We are not on the Section 2 INDIVIDUAL ATTRIBUTES page");

		// Fill the Section 2 INDIVIDUAL ATTRIBUTES page

		// Click the questions 21, from 49 to 90 and from 126 to 127
		String xpath = "//input[@name='question_21']";
		checkRadiobuttons(xpath);
		for (int i = 49; i < 91; i++) {
			xpath = "//input[@name='question_" + i + "']";
			checkRadiobuttons(xpath);
		}
		for (int i = 126; i < 128; i++) {
			xpath = "//input[@name='question_" + i + "']";
			checkRadiobuttons(xpath);
		}
		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions.elementToBeClickable(buttonNextIndividual))
				.click();
		Assertions.assertEquals(
				(new WebDriverWait(driver, 3)).until(
						ExpectedConditions
								.visibilityOfElementLocated(anchorSections))
						.getText(), "Section 3 LEARNING STYLES",
				"We are not on the Section 3 LEARNING STYLES page");

		// Fill the Section 3 LEARNING STYLES page

		for (int i = 91; i < 126; i++) {
			xpath = "//input[@name='question_" + i + "']";
			checkRadiobuttons(xpath);
		}
		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions.elementToBeClickable(buttonNextLearning))
				.click();
		Assertions
				.assertEquals(
						(new WebDriverWait(driver, 3))
								.until(ExpectedConditions
										.visibilityOfElementLocated(anchorPre_register))
								.getText(), "Portfolio of Learning Steps",
						"We are not on the Portfolio of Learning Steps page");

		// Fill the Portfolio of Learning Steps page

		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions
						.visibilityOfElementLocated(buttonNextPortfolio))
				.click();
		// (new WebDriverWait(driver,
		// 10)).until(ExpectedConditions.invisibilityOfElementLocated(buttonNextPortfolio));
		// Assertions.assertEquals((new WebDriverWait(driver,
		// 3)).until(ExpectedConditions.visibilityOfElementLocated(anchorPre_register)).getText(),
		// "Portfolio of Learning Creator Download",
		// "We are not on the Portfolio of Learning Creator Download page");

		// Portfolio of Learning Creator Download

		// Check the link
		Assertions
				.assertEquals(
						(new WebDriverWait(driver, 3))
								.until(ExpectedConditions
										.visibilityOfElementLocated(buttonDownloadPol))
								.getAttribute("href"),
						"http://afdatest.nome.co.za/media/AFDA_-_Course_8_-_PoL_Guideline.pdf",
						"The *Download your PoL assignment* link is not http://afdatest.nome.co.za/media/AFDA_-_Course_8_-_PoL_Guideline.pdf");

		Assertions
				.assertEquals(
						(new WebDriverWait(driver, 3))
								.until(ExpectedConditions
										.visibilityOfElementLocated(buttonDownloadAssignment))
								.getAttribute("href"),
						"http://afdatest.nome.co.za/media/AFDA_-_Course_8_-_PoL_Answer_sheet.docx",
						"The *Download your assignment answer sheets* link is not http://afdatest.nome.co.za/media/AFDA_-_Course_8_-_PoL_Answer_sheet.docx");

		// Check the button
		Assertions.assertTrue(
				(new WebDriverWait(driver, 3)).until(
						ExpectedConditions
								.visibilityOfElementLocated(buttonDownloadPol))
						.isEnabled(),
				"The *Download your PoL assignment* button is not enabled");
		Assertions
				.assertTrue(
						(new WebDriverWait(driver, 3))
								.until(ExpectedConditions
										.visibilityOfElementLocated(buttonDownloadAssignment))
								.isEnabled(),
						"The *Download your assignment answer sheets* button is not enabled");

		(new WebDriverWait(driver, 3))
				.until(ExpectedConditions
						.visibilityOfElementLocated(buttonNextPortfolioCreator))
				.click();
		(new WebDriverWait(driver, 3)).until(ExpectedConditions
				.invisibilityOfElementLocated(buttonDownloadPol));
		Assertions
				.assertEquals(
						(new WebDriverWait(driver, 3))
								.until(ExpectedConditions
										.visibilityOfElementLocated(anchorPre_register))
								.getText(),
						"Upload your portfolio of learning assignment",
						"We are not on the Upload your portfolio of learning assignment page");

		// Upload your portfolio of learning assignment

		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions
						.visibilityOfElementLocated(inputPoLAnswerSheet))
				.sendKeys(
						resourcesDirectory.getAbsolutePath()
								+ "\\AFDA_-_Course_8_-_PoL_Answer_sheet.docx");

		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions
						.visibilityOfElementLocated(buttonNextUploadPortfolio))
				.click();
		(new WebDriverWait(driver, 3)).until(ExpectedConditions
				.invisibilityOfElementLocated(inputPoLAnswerSheet));
		Assertions
				.assertEquals(
						(new WebDriverWait(driver, 10))
								.until(ExpectedConditions
										.visibilityOfElementLocated(anchorPre_register))
								.getText(), "RATE YOURSELF",
						"We are not on the RATE YOURSELF page");

		// RATE YOURSELF page

		// for (int i = 365; i < 375; i++){
		//
		// String path1 = "competency_" + i;
		// String path2 = "//select[@id='competency_" + i +
		// "']/option[@value='9']";
		// (new WebDriverWait(driver,
		// 5)).until(ExpectedConditions.visibilityOfElementLocated(By.id(path1))).click();
		// (new WebDriverWait(driver,
		// 5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path2))).click();
		// }
		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions
						.visibilityOfElementLocated(buttonNextRateYourself))
				.click();
		// (new WebDriverWait(driver,
		// 3)).until(ExpectedConditions.invisibilityOfElementLocated(By.id("374")));
		Assertions
				.assertEquals(
						(new WebDriverWait(driver, 10))
								.until(ExpectedConditions
										.visibilityOfElementLocated(anchorPre_register))
								.getText(), "PROVIDE EVIDENCE/ OTHER UPLOADS",
						"We are not on the PROVIDE EVIDENCE/ OTHER UPLOADS page");

		// PROVIDE EVIDENCE/ OTHER UPLOADS

		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions.visibilityOfElementLocated(fieldEvidence))
				.sendKeys("Poetry certificate");
		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions.visibilityOfElementLocated(inputEvidence))
				.sendKeys(
						resourcesDirectory.getAbsolutePath()
								+ "\\certificate.png");
		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions
						.visibilityOfElementLocated(buttonNextEvidence))
				.click();
		(new WebDriverWait(driver, 3)).until(ExpectedConditions
				.invisibilityOfElementLocated(fieldEvidence));
		Assertions
				.assertEquals(
						(new WebDriverWait(driver, 10))
								.until(ExpectedConditions
										.visibilityOfElementLocated(anchorPre_register))
								.getText(), "Upload your motivational letter",
						"We are not on the Upload your motivational letter page");

		// Upload your motivational letter

		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions
						.visibilityOfElementLocated(inputMotivationLetter))
				.sendKeys(
						resourcesDirectory.getAbsolutePath()
								+ "\\motivation_letter.doc");
		(new WebDriverWait(driver, 3))
				.until(ExpectedConditions
						.visibilityOfElementLocated(buttonNextMotivationLetter))
				.click();
		(new WebDriverWait(driver, 3)).until(ExpectedConditions
				.invisibilityOfElementLocated(inputMotivationLetter));
		Assertions
				.assertEquals(
						(new WebDriverWait(driver, 10))
								.until(ExpectedConditions
										.visibilityOfElementLocated(anchorPre_register))
								.getText(), "External References",
						"We are not on the External References page");

		// External References

		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions
						.visibilityOfElementLocated(dropboxReverenceTitle1))
				.click();
		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions
						.visibilityOfElementLocated(fieldReferenceName1))
				.sendKeys("Bill Gates");
		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions
						.visibilityOfElementLocated(fieldReferenceEmail1))
				.sendKeys("bill@microsoft.com");
		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions
						.visibilityOfElementLocated(fieldReferencePhone1))
				.sendKeys("1(800)8000001");
		(new WebDriverWait(driver, 3))
				.until(ExpectedConditions
						.visibilityOfElementLocated(fieldReferenceRelationship1))
				.sendKeys("Friend");

		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions
						.visibilityOfElementLocated(dropboxReverenceTitle2))
				.click();
		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions
						.visibilityOfElementLocated(fieldReferenceName2))
				.sendKeys("Elon Musk");
		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions
						.visibilityOfElementLocated(fieldReferenceEmail2))
				.sendKeys("musk@paypal.com");
		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions
						.visibilityOfElementLocated(fieldReferencePhone2))
				.sendKeys("1(800)7000001");
		(new WebDriverWait(driver, 3))
				.until(ExpectedConditions
						.visibilityOfElementLocated(fieldReferenceRelationship2))
				.sendKeys("Friend");

		(new WebDriverWait(driver, 3)).until(
				ExpectedConditions
						.visibilityOfElementLocated(buttonNextRelationship))
				.click();
		(new WebDriverWait(driver, 3)).until(ExpectedConditions
				.invisibilityOfElementLocated(fieldReferenceName1));

		Assertions
				.assertEquals(
						(new WebDriverWait(driver, 10))
								.until(ExpectedConditions
										.visibilityOfElementLocated(anchorPre_register))
								.getText(), "VERIFY",
						"We are not on the VERIFY page");

		// VERIFY page

		(new WebDriverWait(driver, 7))
				.until(ExpectedConditions
						.visibilityOfElementLocated(buttonNextVerify)).click();
		// you can increase the sleep if you have bad internet connection
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		(new WebDriverWait(driver, 7)).until(
				ExpectedConditions.elementToBeClickable(buttonHome)).click();

		Assertions.assertEquals(
				trim((new WebDriverWait(driver, 10)).until(
						ExpectedConditions
								.visibilityOfElementLocated(anchorHome))
						.getText()), "Applied at: AFDA",
				"We are not on the LAST page");
	}

	// Click from Up to Down
	private void checkRadiobuttons(String x_path) {
		List<String> ids = new ArrayList<>();
		(new WebDriverWait(driver, 3)).until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath(x_path)));
		List<WebElement> radiobuttonList = driver
				.findElements(By.xpath(x_path));
		for (WebElement rbutton : radiobuttonList) {
			ids.add(rbutton.getAttribute("id"));
		}
		for (String id : ids) {
			driver.findElement(By.id(id)).click();
		}
		ids.clear();
		radiobuttonList.clear();
	}

	// Click from Down to Up
	private void checkRadiobuttons_reverse(String x_path) {
		List<String> ids = new ArrayList<>();
		(new WebDriverWait(driver, 3)).until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath(x_path)));
		List<WebElement> radiobuttonList = driver
				.findElements(By.xpath(x_path));
		for (WebElement rbutton : radiobuttonList) {
			ids.add(rbutton.getAttribute("id"));
		}
		Collections.reverse(ids);
		for (String id : ids) {
			driver.findElement(By.id(id)).click();
		}
		ids.clear();
		radiobuttonList.clear();
	}

	private String getUserName() {
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		Date today = Calendar.getInstance().getTime();
		String dat = df.format(today);
		return "nometest" + dat;
	}
}