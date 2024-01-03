package tek.insurance.app.steps;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.insurance.app.pages.POMFactory;
import tek.insurance.app.utilities.CommonUtility;
import tek.insurance.app.utilities.DateUtility;

public class LoginSteps extends CommonUtility {
	POMFactory factory = new POMFactory();
	private String pPassed = " - Process Passed";

	@Given("User clicked on login button")
	public void userClickedOnLoginButton() {
		click(factory.getLoginPage().loginLink);
		logger.info("User successfully clicked on login button " + pPassed);
	}

	@Given("User should be see the {string} title")
	public void userShouldBeSeeTheTitle(String expectedsignInToYourAccount) {
		String actualTitle = getElementText(factory.getLoginPage().signInTitle);
		Assert.assertEquals(actualTitle, expectedsignInToYourAccount);
		loggerActualAndExpected(actualTitle, expectedsignInToYourAccount);
	}

	@Given("User entered the username {string} and password {string}")
	public void userEnteredTheUsernameAndPassword(String username, String password) {
		sendText(factory.getLoginPage().usernameField, username);
		logger.info("User successfully entered the username: " + username + pPassed);
		sendText(factory.getLoginPage().passwordField, password);
		logger.info("User successfully entered the password. process" + pPassed);

	}

	@When("User clicked on sign in")
	public void userClickedOnSignIn() {
		click(factory.getLoginPage().singInBttn);
		logger.info("User successfully clicked on sign in button" + pPassed);
	}

	@Then("The {string} title should be displayed")
	public void theTitleShouldBeDisplayed(String expectedCustomerPortal) {
		switch (expectedCustomerPortal) {
		case "Customer Service Portal":
			String actual = getElementText(factory.getLoginPage().cSRTitle);
			Assert.assertEquals(actual, expectedCustomerPortal);
			loggerActualAndExpected(actual, expectedCustomerPortal);
			break;
		case "Primary Account Portal":
			String actualTitle = getElementText(factory.getLoginPage().primaryAccountPortal);
			Assert.assertEquals(actualTitle, expectedCustomerPortal);
			loggerActualAndExpected(actualTitle, expectedCustomerPortal);
			break;

		default:
			System.out.println("None of the titles was displayed - Sign in to Accounts Part");
			break;
		}

	}

	@Then("User should be see the sections {string}  {string}")
	public void userShouldBeSeeTheSections(String expectedAccounts, String expectedPlans) {
		String actualAccounts = getElementText(factory.getLoginPage().accountsSection);
		Assert.assertEquals(actualAccounts, expectedAccounts);
		loggerActualAndExpected(actualAccounts, expectedAccounts);

		String actualPlans = getElementText(factory.getLoginPage().plansSection);
		Assert.assertEquals(actualPlans, expectedPlans);
		loggerActualAndExpected(actualPlans, expectedPlans);
	}

	@Then("User click on profile and user type {string} Full name {string} username {string}")
	public void userClickOnProfileAndUserTypeFullNameUsername(String userType, String fullName, String username) {
		click(factory.getLoginPage().profileBttn);

		String actualUserType = getElementText(factory.getLoginPage().profileUserType);
		Assert.assertEquals(actualUserType, userType);
		loggerActualAndExpected(actualUserType, userType);

		String actualfullName = getElementText(factory.getLoginPage().profileFullName);
		Assert.assertEquals(actualfullName, fullName);
		loggerActualAndExpected(actualfullName, fullName);

		String actualUsername = getElementText(factory.getLoginPage().profileUsername);
		Assert.assertEquals(actualUsername, username);
		loggerActualAndExpected(actualUsername, username);
	}

	// next scenario:

	@Given("User entered the username {string} password {string}")
	public void userEnteredTheUsernamePassword(String username, String password) {
		sendText(factory.getLoginPage().usernameField, username);
		logger.info("User successfully entered the username: " + username + " -process passed");

		sendText(factory.getLoginPage().passwordField, password);
		logger.info("User successfully entered the password. process - passed");
	}

	@When("User clicked on sign in button")
	public void userClickedOnSignInButton() {
		click(factory.getLoginPage().singInBttn);
		logger.info("User successfully clicked on sign in button");
	}

	@Then("The {string} should be displayed")
	public void theShouldBeDisplayed(String primaryPortal) {
		waitTillPresence(factory.getLoginPage().primaryAccountPortal);
		String actual = factory.getLoginPage().primaryAccountPortal.getText();
		Assert.assertEquals(actual, primaryPortal);
		loggerActualAndExpected(actual, primaryPortal);
	}

	@Then("Validate some options like {string} {string} {string} {string} {string}")
	public void validateSomeOptionsLike(String expectedBoard, String expectedRQ, String expectedPlans, String expectedPayments,
			String expectedSettings) {
		String actualDashboard = getElementText(factory.getLoginPage().dashboardSection);
		Assert.assertEquals(actualDashboard, expectedBoard);
		loggerActualAndExpected(actualDashboard, expectedBoard);
		
		String actualRQ = getElementText(factory.getLoginPage().requestQuoteSection);
		Assert.assertEquals(actualRQ, expectedRQ);
		loggerActualAndExpected(actualRQ, expectedRQ);

		String actualPlans = getElementText(factory.getLoginPage().plansSection);
		Assert.assertEquals(actualPlans, expectedPlans);
		loggerActualAndExpected(actualPlans, expectedPlans);

		String actualPayments = getElementText(factory.getLoginPage().paymentsSection);
		Assert.assertEquals(actualPayments, expectedPayments);
		loggerActualAndExpected(actualPayments, expectedPayments);

		String actualsettings = getElementText(factory.getLoginPage().settingsSection);
		Assert.assertEquals(actualsettings, expectedSettings);
		loggerActualAndExpected(actualsettings, expectedSettings);
	}

	@Then("User click on profile section and user type {string} FullName {string} username {string}")
	public void userClickOnProfileSectionAndUserTypeFullNameUsername(String userType, String fullName,
			String username) {
		click(factory.getLoginPage().profileBttn);
		String actualUserType = getElementText(factory.getLoginPage().profileUserType);
		Assert.assertEquals(actualUserType, userType);
		loggerActualAndExpected(actualUserType, userType);

		String actualfullName = getElementText(factory.getLoginPage().profileFullName);
		Assert.assertEquals(actualfullName, fullName);
		loggerActualAndExpected(actualfullName, fullName);

		String actualUsername = getElementText(factory.getLoginPage().profileUsername);
		Assert.assertEquals(actualUsername, username);
		loggerActualAndExpected(actualUsername, username);
	}

	@Then("User click on logout button")
	public void userClickOnLogoutButton() {
		click(factory.getLoginPage().profileLogoutBttn);
		logger.info("User successfully clicked on logout button - process passed");
	}

	@Then("Validate the home page")
	public void validateTheHomePage() {
		waitTillPresence(factory.getMainPage().tekInsuranceLink);
		Assert.assertTrue(isElementDisplayed(factory.getMainPage().tekInsuranceLink));
		logger.info("website logo successfully displayed - process passed");
	}

	// Negative with scenario outline
	@Then("User should see the Error message of {string}")
	public void userShouldSeeTheErrorMessageOf(String expectedError) {
		String errorMessage = getElementText(factory.getLoginPage().errorMessage);
		String actualErrorMessage = errorMessage.replaceAll("ERROR\n", "");
		Assert.assertEquals(actualErrorMessage, expectedError);
		loggerActualAndExpected(actualErrorMessage, expectedError);
	}

//	 Negative CSR Testing
	@Given("User enter the username {string} and password {string}")
	public void userEnterTheUsernameAndPassword(String username, String password) {
		sendText(factory.getLoginPage().usernameField, username);
		logger.info("User successfully entered the username: " + username + pPassed);
		sendText(factory.getLoginPage().passwordField, password);
		logger.info("User successfully entered the password" + pPassed);
	}

}
