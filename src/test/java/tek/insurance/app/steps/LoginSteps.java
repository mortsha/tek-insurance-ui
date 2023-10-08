package tek.insurance.app.steps;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.insurance.app.pages.POMFactory;
import tek.insurance.app.utilities.CommonUtility;

public class LoginSteps extends CommonUtility {
	POMFactory factory = new POMFactory();

	@Given("User clicked on login button")
	public void userClickedOnLoginButton() {
		waitTillClickable(factory.getLoginPage().loginLink);
		click(factory.getLoginPage().loginLink);
		logger.info("User successfully clicked on login button - process passed");
	}

	@Given("User should be see the {string} title")
	public void userShouldBeSeeTheTitle(String signInToYourAccount) {
		waitTillPresence(factory.getLoginPage().signInTitle);
		String actual = factory.getLoginPage().signInTitle.getText();
		Assert.assertEquals(actual, signInToYourAccount);
		logger.info("The actual: " + actual + " and expectd: " + signInToYourAccount + " was same - process passed");
	}

	@Given("User entered the username {string} and password {string}")
	public void userEnteredTheUsernameAndPassword(String username, String password) {
		waitTillPresence(factory.getLoginPage().usernameField);
		sendText(factory.getLoginPage().usernameField, username);
		logger.info("User successfully entered the username: " + username + " -process passed");

		waitTillPresence(factory.getLoginPage().passwordField);
		sendText(factory.getLoginPage().passwordField, password);
		logger.info("User successfully entered the password. process - passed");

	}

	@When("User clicked on	sign in")
	public void userClickedOnSignIn() {
		waitTillClickable(factory.getLoginPage().singInBttn);
		click(factory.getLoginPage().singInBttn);
		logger.info("User successfully clicked on sign in button");
	}

	@When("User should see the Error message of User not found")
	public void userShouldSeeTheErrorMessageOfUserNotFound() {
		waitTillPresence(factory.getLoginPage().errorUserNotFound);
		Assert.assertTrue(factory.getLoginPage().errorUserNotFound.isDisplayed());
		logger.info("Error message displayed - process passed");
	}

	@When("User should see the Error message of Password not matched")
	public void userShouldSeeTheErrorMessageOfPasswordNotMatched() {
		waitTillPresence(factory.getLoginPage().errorPassNotMatch);
		Assert.assertTrue(factory.getLoginPage().errorPassNotMatch.isDisplayed());
		logger.info("Error message displayed - process passed");
	}

	@Then("The {string} title should be displayed")
	public void theTitleShouldBeDisplayed(String customerPortal) {
		waitTillPresence(factory.getLoginPage().customerServicePortal);
		String actual = factory.getLoginPage().customerServicePortal.getText();
		Assert.assertEquals(actual, customerPortal);
		logger.info("The actual: " + actual + " and expected: " + customerPortal + " was same - process passed");
	}

	@Then("User should be see the {string} and {string}")
	public void userShouldBeSeeTheAnd(String accounts, String plans) {
		waitTillPresence(factory.getLoginPage().accountsLinkInCustomerPortal);
		String actualAccounts = factory.getLoginPage().accountsLinkInCustomerPortal.getText();
		Assert.assertEquals(actualAccounts, accounts);
		logger.info("The actual: " + actualAccounts + " and expected: " + accounts + " was same - process passed");

		String actualPlans = factory.getLoginPage().plansLink.getText();
		Assert.assertEquals(actualPlans, plans);
		logger.info("The actual: " + actualPlans + " and expected: " + plans + " was same - process passed");
	}

	@Then("User click on profile and user type {string} Full name {string} username {string}")
	public void userClickOnProfileAndUserTypeFullNameUsername(String userType, String fullName, String username) {
		waitTillClickable(factory.getLoginPage().profileBttn);
		click(factory.getLoginPage().profileBttn);

		waitTillPresence(factory.getLoginPage().userTypeInCustomer);
		String actualUserType = factory.getLoginPage().userTypeInCustomer.getText();
		Assert.assertEquals(actualUserType, userType);
		logger.info("The actual: " + actualUserType + " and expected: " + userType + " was same - process passed");

		waitTillPresence(factory.getLoginPage().fullNameInCustomer);
		String actualfullName = factory.getLoginPage().fullNameInCustomer.getText();
		Assert.assertEquals(actualfullName, fullName);
		logger.info("The actual: " + actualfullName + " and expected: " + fullName + " was same - process passed");

		waitTillPresence(factory.getLoginPage().usernameInCustomer);
		String actualUsername = factory.getLoginPage().usernameInCustomer.getText();
		Assert.assertEquals(actualUsername, username);
		logger.info("The actual: " + actualUsername + " and expected: " + username + " was same - process passed");
	}

	// next scenario:

	@Given("User entered the username {string} password {string}")
	public void userEnteredTheUsernamePassword(String username, String password) {
		waitTillPresence(factory.getLoginPage().usernameField);
		sendText(factory.getLoginPage().usernameField, username);
		logger.info("User successfully entered the username: " + username + " -process passed");

		waitTillPresence(factory.getLoginPage().passwordField);
		sendText(factory.getLoginPage().passwordField, password);
		logger.info("User successfully entered the password. process - passed");
	}

	@When("User clicked on sign in button")
	public void userClickedOnSignInButton() {
		waitTillClickable(factory.getLoginPage().singInBttn);
		click(factory.getLoginPage().singInBttn);
		logger.info("User successfully clicked on sign in button");
	}

	@Then("The {string} should be displayed")
	public void theShouldBeDisplayed(String primaryPortal) {
		waitTillPresence(factory.getLoginPage().primaryAccountPortal);
		String actual = factory.getLoginPage().primaryAccountPortal.getText();
		Assert.assertEquals(actual, primaryPortal);
		logger.info("The actual: " + actual + " and expected: " + primaryPortal + " was same - process passed");
	}

	@Then("Validate some options like {string} {string} {string} {string}")
	public void validateSomeOptionsLike(String dashboard, String plans, String payments, String settings) {
		waitTillPresence(factory.getLoginPage().dashboardLink);
		String actualDashboard = factory.getLoginPage().dashboardLink.getText();
		Assert.assertEquals(actualDashboard, dashboard);
		logger.info("The actual: " + actualDashboard + " and expected: " + dashboard + " was same - process passed");

		String actualPlans = factory.getLoginPage().plansLink.getText();
		Assert.assertEquals(actualPlans, plans);
		logger.info("The actual: " + actualPlans + " and expected: " + plans + " was same - process passed");

		String actualPayments = factory.getLoginPage().paymentsLink.getText();
		Assert.assertEquals(actualPayments, payments);
		logger.info("The actual: " + actualPayments + " and expected: " + payments + " was same - process passed");

		String actualsettings = factory.getLoginPage().settingsLink.getText();
		Assert.assertEquals(actualsettings, settings);
		logger.info("The actual: " + actualsettings + " and expected: " + settings + " was same - process passed");

	}

	@Then("User click on profile section and user type {string} FullName {string} username {string}")
	public void userClickOnProfileSectionAndUserTypeFullNameUsername(String userType, String fullName,
			String username) {
		waitTillClickable(factory.getLoginPage().profileBttn);
		click(factory.getLoginPage().profileBttn);
		waitTillPresence(factory.getLoginPage().userTypeInPrimary);
		String actualUserType = factory.getLoginPage().userTypeInPrimary.getText();
		Assert.assertEquals(actualUserType, userType);
		logger.info("The actual: " + actualUserType + " and expected: " + userType + " was same - process passed");

		waitTillPresence(factory.getLoginPage().fullNameInPrimary);
		String actualfullName = factory.getLoginPage().fullNameInPrimary.getText();
		Assert.assertEquals(actualfullName, fullName);
		logger.info("The actual: " + actualfullName + " and expected: " + fullName + " was same - process passed");

		waitTillPresence(factory.getLoginPage().usernameInPrimary);
		String actualUsername = factory.getLoginPage().usernameInPrimary.getText();
		Assert.assertEquals(actualUsername, username);
		logger.info("The actual: " + actualUsername + " and expected: " + username + " was same - process passed");
	}

	@Then("User click on logout button")
	public void userClickOnLogoutButton() {
		waitTillClickable(factory.getLoginPage().logoutBttnInCustomer);
		click(factory.getLoginPage().logoutBttnInCustomer);
		logger.info("User successfully clicked on logout button - process passed");
	}

	// Negative CSR Testing
	@Given("User enter the username {string} and password {string}")
	public void userEnterTheUsernameAndPassword(String username, String password) {
		waitTillPresence(factory.getLoginPage().usernameField);
		sendText(factory.getLoginPage().usernameField, username);
		logger.info("User successfully entered the username: " + username + " -process passed");
		waitTillPresence(factory.getLoginPage().passwordField);
		sendText(factory.getLoginPage().passwordField, password);
		logger.info("User successfully entered the password - process passed");
	}

	// Plans

	@When("The User click on Plans")
	public void theUserClickOnPlans() {
		waitTillClickable(factory.getLoginPage().plansLink);
		click(factory.getLoginPage().plansLink);
		logger.info("User succussfully clicked on Plans - process passed");
	}

	@When("The text Todays Plans Price should be display")
	public void theTextTodaysPlansPriceShouldBeDisplay() {
		waitTillPresence(factory.getLoginPage().todaysPlansPriceText);
		Assert.assertTrue(factory.getLoginPage().todaysPlansPriceText.isDisplayed());
		logger.info("The text was displayed successfully - process passed");
	}

	@Then("The plan types {string} {string} {string} {string} should be there")
	public void thePlanTypesShouldBeThere(String motorcycle, String boat, String renters, String auto) {
		waitTillPresence(factory.getLoginPage().motorcyleText);
		Assert.assertTrue(factory.getLoginPage().motorcyleText.isDisplayed());
		logger.info("The text motorcycle was displayed - process passed");

		waitTillPresence(factory.getLoginPage().boatText);
		Assert.assertTrue(factory.getLoginPage().boatText.isDisplayed());
		logger.info("The text boat was displayed - process passed");

		waitTillPresence(factory.getLoginPage().rentersText);
		Assert.assertTrue(factory.getLoginPage().rentersText.isDisplayed());
		logger.info("The text renters was displayed - process passed");

		waitTillPresence(factory.getLoginPage().autoText);
		Assert.assertTrue(factory.getLoginPage().autoText.isDisplayed());
		logger.info("The text auto was displayed - process passed");

	}

	@Then("Date created should be todays date")
	public void dateCreatedShouldBeTodaysDate() {

		LocalDate todaysDate = LocalDate.now();
		DateTimeFormatter formatterTodayDate = DateTimeFormatter.ofPattern("MMMM d, yyyy");
		String actualCreatedDate = todaysDate.format(formatterTodayDate);

		waitTillPresence(factory.getLoginPage().motorCreatedDate);
		String motorDate = factory.getLoginPage().motorCreatedDate.getText();
		Assert.assertEquals(actualCreatedDate, motorDate);
		logger.info("the actual date created " + actualCreatedDate + " and expected " + motorDate
				+ " was same - process passed");

		waitTillPresence(factory.getLoginPage().boatCreatedDate);
		String boatDate = factory.getLoginPage().boatCreatedDate.getText();
		Assert.assertEquals(actualCreatedDate, boatDate);
		logger.info("the actual date created " + actualCreatedDate + " and expected " + boatDate
				+ " was same - process passed");

		waitTillPresence(factory.getLoginPage().rentersCreatedDate);
		String rentersDate = factory.getLoginPage().rentersCreatedDate.getText();
		Assert.assertEquals(actualCreatedDate, rentersDate);
		logger.info("the actual date created " + actualCreatedDate + " and expected " + rentersDate
				+ " was same - process passed");

		waitTillPresence(factory.getLoginPage().autoCreatedDate);
		String autoDate = factory.getLoginPage().autoCreatedDate.getText();
		Assert.assertEquals(actualCreatedDate, autoDate);
		logger.info("the actual date created " + actualCreatedDate + " and expected " + autoDate
				+ " was same - process passed");
	}

	@Then("Date expired should be one day after that date")
	public void dateExpiredShouldBeOneDayAfterThatDate() {
		LocalDate tomorrowDate = LocalDate.now().plusDays(1);
		DateTimeFormatter formatterTodayDate = DateTimeFormatter.ofPattern("MMMM d, yyyy");
		String actualExpiredDate = tomorrowDate.format(formatterTodayDate);

		waitTillPresence(factory.getLoginPage().motorExpiredDate);
		String motorExpireDate = factory.getLoginPage().motorExpiredDate.getText();
		Assert.assertEquals(actualExpiredDate, motorExpireDate);
		logger.info("the actual expired date  " + actualExpiredDate + " and expected " + motorExpireDate
				+ " was same - process passed");

		waitTillPresence(factory.getLoginPage().boatExpiredDate);
		String boatExpireDate = factory.getLoginPage().boatExpiredDate.getText();
		Assert.assertEquals(actualExpiredDate, boatExpireDate);
		logger.info("the actual expired date  " + actualExpiredDate + " and expected " + boatExpireDate
				+ " was same - process passed");

		waitTillPresence(factory.getLoginPage().rentersExpiredDate);
		String rentersExpireDate = factory.getLoginPage().rentersExpiredDate.getText();
		Assert.assertEquals(actualExpiredDate, rentersExpireDate);
		logger.info("the actual expired date  " + actualExpiredDate + " and expected " + rentersExpireDate
				+ " was same - process passed");

		waitTillPresence(factory.getLoginPage().autoExpiredDate);
		String autoExpireDate = factory.getLoginPage().autoExpiredDate.getText();
		Assert.assertEquals(actualExpiredDate, autoExpireDate);
		logger.info("the actual expired date  " + actualExpiredDate + " and expected " + autoExpireDate
				+ " was same - process passed");
	}

}
