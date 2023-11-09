package tek.insurance.app.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.insurance.app.pages.POMFactory;
import tek.insurance.app.utilities.CommonUtility;
import tek.insurance.app.utilities.DataGenerator;
import org.junit.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;

public class CreateAccountTestStep extends CommonUtility {
	POMFactory factory = new POMFactory();
	private String mainEmail;
	private String emailLookup1;
	private String firstName;

	@Given("User is on tek insurance app website and validate the website")
	public void userIsOnTekInsuranceAppWebsiteAndValidateTheWebsite() {
		waitTillPresence(factory.getMainPage().tekInsuranceLink);
		Assert.assertTrue(factory.getMainPage().tekInsuranceLink.isDisplayed());
		logger.info("website logo successfully displayed - process passed");
	}

	@Given("User click on create primary account button")
	public void userClickOnCreatePrimaryAccountButton() {
		click(factory.getMainPage().createPrimaryAccountBttn);
		logger.info("User successfully clicked - process passed");
	}

	@Given("the signUp page should be displayed")
	public void theSignUpPageShouldBeDisplayed() {
		waitTillPresence(factory.getCreateAccountPage().createPrimaryAccountText);
		Assert.assertTrue(factory.getCreateAccountPage().createPrimaryAccountText.isDisplayed());
		logger.info("the create primary account was displayed - process passed");
	}

	@Given("Validate the header {string} and buttons {string} {string}")
	public void validateTheHeaderAndButtons(String createPrimaryAccountHolder, String createAccount, String resetForm) {
		String actual = getElementText(factory.getCreateAccountPage().createPrimaryAccountText);
		Assert.assertEquals(actual, createPrimaryAccountHolder);
		loggerActualAndExpected(actual, createPrimaryAccountHolder);

		String actualAccountBttn = getElementText(factory.getCreateAccountPage().createAccountBttn);
		Assert.assertEquals(actualAccountBttn, createAccount);
		loggerActualAndExpected(actualAccountBttn, createAccount);

		waitTillPresence(factory.getCreateAccountPage().clearFormBttn);
		String actualResetBttn = getElementText(factory.getCreateAccountPage().clearFormBttn);
		Assert.assertEquals(actualResetBttn, resetForm);
		loggerActualAndExpected(actualResetBttn, resetForm);
	}

	@When("user fill the form with below information")
	public void userFillTheFormWithBelowInformation(DataTable dataTable) {
		mainEmail = DataGenerator.getEmail();
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> row : data) {
			sendText(factory.getCreateAccountPage().emailField, mainEmail);
			logger.info("User seccessfully entered the email - process passed");

			selectByVisibleText(factory.getCreateAccountPage().titleDropdown, row.get("title"));
			logger.info("User seccessfully select the title - process passed");

			String mainFirstName = factory.getCreateAccountPage().firstNameField.getText();
			sendText(factory.getCreateAccountPage().firstNameField, row.get("firstName"));
			logger.info("User seccessfully entered the first name - process passed");

			sendText(factory.getCreateAccountPage().lastNameField, row.get("lastName"));
			logger.info("User seccessfully entered the last name - process passed");

			selectByVisibleText(factory.getCreateAccountPage().genderDropdown, row.get("gender"));
			logger.info("User seccessfully select the gender - process passed");

			selectByVisibleText(factory.getCreateAccountPage().maritalStatusDropdown, row.get("maritalStatus"));
			logger.info("User seccessfully select the marital status - process passed");

			factory.getCreateAccountPage().dateOfBirthField.sendKeys(row.get("dateOfBirth"));
			sendText(factory.getCreateAccountPage().dateOfBirthField, row.get("dateOfBirth"));
			logger.info("User seccessfully entered the date of birth - process passed");

			sendText(factory.getCreateAccountPage().employmentStatusField, row.get("employmentStatus"));
			logger.info("User seccessfully entered the employment status - process passed");

		}
	}

	// &
	@Then("user click on Create Account button")
	public void userClickOnCreateAccountButton() {
		click(factory.getCreateAccountPage().createAccountBttn);
		logger.info("User successfully clicked - process passed");
	}

	@Then("User click on Reset button")
	public void userClickOnResetButton() {
		click(factory.getCreateAccountPage().clearFormBttn);
		logger.info("Use successfully clicked - process passed");
	}

	@Then("the fields should be removed")
	public void theFieldsShouldBeRemoved() {

		String[] fieldNames = { getElementText(factory.getCreateAccountPage().emailField),
				getElementText(factory.getCreateAccountPage().firstNameField),
				getElementText(factory.getCreateAccountPage().lastNameField),
				getElementText(factory.getCreateAccountPage().employmentStatusField) };

		for (String fields : fieldNames) {
			String expected = "";
			Assert.assertEquals(fields, expected);
		}
		logger.info("The field are empty");
//
//		String actualEmailField = getElementText(factory.getCreateAccountTest().emailField);
//		String expectedEmailField = "";
//		Assert.assertEquals(actualEmailField, expectedEmailField);
//
//		String actualFirstName = getElementText(factory.getCreateAccountTest().firstNameField);
//		String expectedFirstName = "";
//		Assert.assertEquals(actualFirstName, expectedFirstName);
//
//		String actualLastNameField = getElementText(factory.getCreateAccountTest().lastNameField);
//		String expectedLastName = "";
//		Assert.assertEquals(actualLastNameField, expectedLastName);
//
//		String actualEmpField = getElementText(factory.getCreateAccountTest().employmentStatusField);
//		String expectedEmpField = "";
//		Assert.assertEquals(actualEmpField, expectedEmpField);
//		logger.info("The field are empty");
	}

	@Then("another page is displayed with the text {string}")
	public void anotherPageIsDisplayedWithTheText(String signUpYourAccount) {
		String actual = getElementText(factory.getCreateAccountPage().signUpYourAccountLink);
		Assert.assertEquals(actual, signUpYourAccount);
		logger.info("another page displayed successfully and text validated - process passed");
	}

	@Then("Validate the firstName {string} lastName {string} and email {string} should be the same")
	public void validateTheFirstNameLastNameAndEmailShouldBeTheSame(String expectedFirstName, String expectedLastName,
			String expectedEmail) {
		String expectedFullName = expectedFirstName + " " + expectedLastName;
		for (WebElement element : factory.getCreateAccountPage().validateSingupOptions) {
			if (element.getText().equals(expectedFullName)) {
				Assert.assertTrue(isElementDisplayed(element));
				logger.info("The fullname: " + element.getText() + " was displayed - process passed");
			} else if (element.getText().equals(mainEmail)) {
				Assert.assertTrue(isElementDisplayed(element));
				logger.info("The email: " + element.getText() + " was displayed - process passed");
			}
		}

	}

	@When("fill the from for username and password")
	public void fillTheFromForUsernameAndPassword(DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> row : data) {
			sendText(factory.getCreateAccountPage().userNameField, mainEmail);
			logger.info("User successfully entered the username - process passed");
			sendText(factory.getCreateAccountPage().passwordField, row.get("password"));
			logger.info("User successfully entered the password - process passed");
			sendText(factory.getCreateAccountPage().confirmPassField, row.get("confirmPassword"));
			logger.info("User successfully entered the confirm password - process passed");
		}
	}

	@Then("The user submits the form")
	public void theUserSubmitsTheForm() {
		click(factory.getCreateAccountPage().submitBttn);
		logger.info("User successfully clicked on submit button");
	}

	@Then("User should see the Success message of {string}")
	public void userShouldSeeTheSuccessMessageOf(String expectedSuccessMessage) {
		String successMessage = getElementText(factory.getCreateAccountPage().successMessage);
		String actualSuccessMessage = successMessage.replaceAll("SUCCESS\n", "");
		Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage);
		loggerActualAndExpected(actualSuccessMessage, expectedSuccessMessage);
	}

//	@Then("sumbit the form")
//	public void sumbitTheForm() {
//		click(factory.getCreateAccountTest().submitBttn);
//		logger.info("User successfully clicked on submit button");
//	}

	@When("user fill form with below information")
	public void userFillFormWithBelowInformation(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> row : data) {
			sendText(factory.getCreateAccountPage().emailField, row.get("email"));
			logger.info("User seccessfully entered the email - process passed");

			selectByVisibleText(factory.getCreateAccountPage().titleDropdown, row.get("title"));
			logger.info("User seccessfully select the title - process passed");

			sendText(factory.getCreateAccountPage().firstNameField, row.get("firstName"));
			logger.info("User seccessfully entered the first name - process passed");

			sendText(factory.getCreateAccountPage().lastNameField, row.get("lastName"));
			logger.info("User seccessfully entered the last name - process passed");

			selectByVisibleText(factory.getCreateAccountPage().genderDropdown, row.get("gender"));
			logger.info("User seccessfully select the gender - process passed");

			selectByVisibleText(factory.getCreateAccountPage().maritalStatusDropdown, row.get("maritalStatus"));
			logger.info("User seccessfully select the marital status - process passed");

			factory.getCreateAccountPage().dateOfBirthField.sendKeys(row.get("dateOfBirth"));
			sendText(factory.getCreateAccountPage().dateOfBirthField, row.get("dateOfBirth"));
			logger.info("User seccessfully entered the date of birth - process passed");

			sendText(factory.getCreateAccountPage().employmentStatusField, row.get("employmentStatus"));
			logger.info("User seccessfully entered the employment status - process passed");
		}
	}
	// negative user account exist

	@Then("the error should be display and the error message {string}")
	public void theErrorShouldBeDisplayAndTheErrorMessage(String expectedErrorMessage) {
		String errorMessage = getElementText(factory.getLoginPage().errorMessage);
		String actualErrorMessage = errorMessage.replaceAll("ERROR\n", "");
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
		loggerActualAndExpected(actualErrorMessage, expectedErrorMessage);
	}

	// lookup
	@When("user fill form with the below information")
	public void userFillFormWithTheBelowInformation(DataTable dataTable) {
		emailLookup1 = DataGenerator.getEmail();
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> row : data) {
			sendText(factory.getCreateAccountPage().emailField, emailLookup1);
			logger.info("User seccessfully entered the email - process passed");

			selectByVisibleText(factory.getCreateAccountPage().titleDropdown, row.get("title"));
			logger.info("User seccessfully select the title - process passed");

			sendText(factory.getCreateAccountPage().firstNameField, row.get("firstName"));
			logger.info("User seccessfully entered the first name - process passed");
			firstName = getAttribute(factory.getCreateAccountPage().firstNameField, "value");

			sendText(factory.getCreateAccountPage().lastNameField, row.get("lastName"));
			logger.info("User seccessfully entered the last name - process passed");

			selectByVisibleText(factory.getCreateAccountPage().genderDropdown, row.get("gender"));
			logger.info("User seccessfully select the gender - process passed");

			selectByVisibleText(factory.getCreateAccountPage().maritalStatusDropdown, row.get("maritalStatus"));
			logger.info("User seccessfully select the marital status - process passed");

			factory.getCreateAccountPage().dateOfBirthField.sendKeys(row.get("dateOfBirth"));
			sendText(factory.getCreateAccountPage().dateOfBirthField, row.get("dateOfBirth"));
			logger.info("User seccessfully entered the date of birth - process passed");

			sendText(factory.getCreateAccountPage().employmentStatusField, row.get("employmentStatus"));
			logger.info("User seccessfully entered the employment status - process passed");
		}
	}

	@Then("user navigate to sign up")
	public void userNavigateToSignUp() {
		String actualSignUpText = getElementText(factory.getCreateAccountPage().signupFormText);
		Assert.assertEquals("Sign up your account", actualSignUpText);
		logger.info("signup your account text was displayed - process passed");

	}

	@Then("user click on Login button")
	public void userClickOnLoginButton() throws InterruptedException {

		click(factory.getLoginPage().loginLink);
		logger.info("User successfully cliked - process passed");

	}

	@Then("click on register here")
	public void clickOnRegisterHere() {
		waitTillClickable(factory.getCreateAccountPage().registerHereBttn);
		click(factory.getCreateAccountPage().registerHereBttn);
		logger.info("User successfully registered - process passed");
	}

	@Then("fill the form with existing information provided before")
	public void fillTheFormWithExistingInformationProvidedBefore(DataTable dataTable) throws InterruptedException {
		Thread.sleep(1000);
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> row : data) {

			sendText(factory.getCreateAccountPage().emailLookup, emailLookup1);
			logger.info("User seccessfully entered the email - process passed");

			sendText(factory.getCreateAccountPage().firstnameLookup, row.get("FirstName"));
			logger.info("User seccessfully entered the firstname - process passed");

			sendText(factory.getCreateAccountPage().lastNameLookup, row.get("LastName"));
			logger.info("User seccessfully entered the lastName - process passed");

			sendText(factory.getCreateAccountPage().dateOfBirthLookup, row.get("DateOfBirth"));
			logger.info("User seccessfully entered the dateOfBirth - process passed");
			// matched data message display
		}
	}

	@Then("click on submit")
	public void clickOnSubmit() throws InterruptedException {
		waitTillClickable(factory.getCreateAccountPage().submitLookup);
		click(factory.getCreateAccountPage().submitLookup);
		logger.info("User successfully clicked on submit - process passed");

	}

	@Then("User should see Success message of {string}")
	public void userShouldSeeSuccessMessageOf(String expectedSuccessMessage) {
		String expected = expectedSuccessMessage + " " + firstName;
		String successMessage = getElementText(factory.getCreateAccountPage().successMessage);
		String actualSuccessMessage = successMessage.replaceAll("SUCCESS\n", "");
		Assert.assertEquals(actualSuccessMessage, expected);
		loggerActualAndExpected(actualSuccessMessage, expected);
	}

	@Then("fill from for username and password")
	public void fillFromForUsernameAndPassword(DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> row : data) {
			sendText(factory.getCreateAccountPage().userNameLookup, emailLookup1);
			logger.info("User successfully entered username - process passed");

			sendText(factory.getCreateAccountPage().passowrdLookup, row.get("password"));
			logger.info("User successfully entered password - process passed");

			sendText(factory.getCreateAccountPage().confirmPassLookup, row.get("confirmPassword"));
			logger.info("User successfully entered confirmPassword - process passed");
		}
	}

}
