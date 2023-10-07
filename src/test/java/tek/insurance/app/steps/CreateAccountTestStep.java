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
	String mainEmail;
	String emailLookup1;

	@Given("User is on tek insurance app website and validate the website")
	public void userIsOnTekInsuranceAppWebsiteAndValidateTheWebsite() {
		waitTillPresence(factory.getMainPage().tekInsuranceLink);
		Assert.assertTrue(factory.getMainPage().tekInsuranceLink.isDisplayed());
		logger.info("website logo successfully displayed - process passed");
	}

	@Given("User click on create primary account button")
	public void userClickOnCreatePrimaryAccountButton() {
		waitTillClickable(factory.getMainPage().createPrimaryAccountBttn);
		click(factory.getMainPage().createPrimaryAccountBttn);
		logger.info("User successfully clicked - process passed");
	}

	@Given("the signUp page should be displayed")
	public void theSignUpPageShouldBeDisplayed() {
		waitTillPresence(factory.getCreateAccountTest().createPrimaryAccountText);
		Assert.assertTrue(factory.getCreateAccountTest().createPrimaryAccountText.isDisplayed());
		logger.info("the create primary account was displayed - process passed");
	}

	@Given("by the name of {string} text with {string} and {string} buttons")
	public void byTheNameOfTextWithAndButtons(String createPrimaryAccountHolder, String createAccount,
			String resetForm) {
		waitTillPresence(factory.getCreateAccountTest().createPrimaryAccountText);
		String actual = factory.getCreateAccountTest().createPrimaryAccountText.getText();
		Assert.assertEquals(createPrimaryAccountHolder, actual);
		logger.info(
				"the actual " + actual + " and expected " + createPrimaryAccountHolder + " was same - process passed");

		waitTillPresence(factory.getCreateAccountTest().createAccountBttn);
		String actualAccountBttn = factory.getCreateAccountTest().createAccountBttn.getText();
		Assert.assertEquals(createAccount, actualAccountBttn);
		logger.info("the actual " + actualAccountBttn + " and expected " + createAccount
				+ " button was same - process passed");

		waitTillPresence(factory.getCreateAccountTest().resetFormBttn);
		String actualResetBttn = factory.getCreateAccountTest().resetFormBttn.getText();
		Assert.assertEquals(resetForm, actualResetBttn);
		logger.info(
				"the actual " + actualResetBttn + " and expected " + resetForm + " button was same - process passed");

	}

	@When("user fill the form with below information")
	public void userFillTheFormWithBelowInformation(DataTable dataTable) {
		mainEmail = DataGenerator.getEmail();
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> row : data) {
			sendText(factory.getCreateAccountTest().emailField, mainEmail);
			logger.info("User seccessfully entered the email - process passed");

			selectByVisibleText(factory.getCreateAccountTest().titleDropdown, row.get("title"));
			logger.info("User seccessfully select the title - process passed");

			sendText(factory.getCreateAccountTest().firstNameField, row.get("firstName"));
			logger.info("User seccessfully entered the first name - process passed");

			sendText(factory.getCreateAccountTest().lastNameField, row.get("lastName"));
			logger.info("User seccessfully entered the last name - process passed");

			selectByVisibleText(factory.getCreateAccountTest().genderDropdown, row.get("gender"));
			logger.info("User seccessfully select the gender - process passed");

			selectByVisibleText(factory.getCreateAccountTest().maritalStatusDropdown, row.get("maritalStatus"));
			logger.info("User seccessfully select the marital status - process passed");

			factory.getCreateAccountTest().dateOfBirthField.sendKeys(row.get("dateOfBirth"));
			sendText(factory.getCreateAccountTest().dateOfBirthField, row.get("dateOfBirth"));
			logger.info("User seccessfully entered the date of birth - process passed");

			sendText(factory.getCreateAccountTest().employmentStatusField, row.get("employmentStatus"));
			logger.info("User seccessfully entered the employment status - process passed");

		}
	}

	@Then("user click on Create Account button")
	public void userClickOnCreateAccountButton() {
		waitTillClickable(factory.getCreateAccountTest().createAccountBttn);
		click(factory.getCreateAccountTest().createAccountBttn);
		logger.info("User successfully clicked - process passed");
	}

	@Then("user click on Cancel button")
	public void userClickOnCancelButton() {
		waitTillClickable(factory.getCreateAccountTest().resetFormBttn);
		click(factory.getCreateAccountTest().resetFormBttn);
		logger.info("Use successfully clicked - process passed");
	}

	@Then("the fields should be removed")
	public void theFieldsShouldBeRemoved() {
		waitTillPresence(factory.getCreateAccountTest().emailField);
		String actualEmailField = factory.getCreateAccountTest().emailField.getText();
		String expectedEmailField = "";
		Assert.assertEquals(actualEmailField, expectedEmailField);

		waitTillPresence(factory.getCreateAccountTest().firstNameField);
		String actualFirstName = factory.getCreateAccountTest().firstNameField.getText();
		String expectedFirstName = "";
		Assert.assertEquals(actualFirstName, expectedFirstName);

		waitTillPresence(factory.getCreateAccountTest().lastNameField);
		String actualLastNameField = factory.getCreateAccountTest().lastNameField.getText();
		String expectedLastName = "";
		Assert.assertEquals(expectedLastName, actualLastNameField);

		waitTillPresence(factory.getCreateAccountTest().employmentStatusField);
		String actualEmpField = factory.getCreateAccountTest().employmentStatusField.getText();
		String expectedEmpField = "";
		Assert.assertEquals(expectedEmpField, actualEmpField);
		logger.info("The field are empty");
	}

	@Then("another page should be displayed and validate the {string} text")
	public void anotherPageShouldBeDisplayedAndValidateTheText(String signUpYourAccount) {
		waitTillPresence(factory.getCreateAccountTest().signUpYourAccountLink);
		String actual = factory.getCreateAccountTest().signUpYourAccountLink.getText();
		Assert.assertEquals(signUpYourAccount, actual);
		logger.info("another page displayed successfully and text validated - process passed");
	}

//	@Then("validate the exact email created before")
//	public void validateTheExactEmailCreatedBefore() {
//		List<WebElement> head = (List<WebElement>) factory.getCreateAccountTest().headingEmailText;
//		for (var heads : head) {
//			if (heads.getText().equals(mainEmail)) {
//				Assert.assertTrue(heads.getText().equals(mainEmail));
//			}
//		}
//		try {
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		logger.info("the two emails was same - process passed");
//	}

	@When("fill the from for username and password")
	public void fillTheFromForUsernameAndPassword(DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> row : data) {
			waitTillPresence(factory.getCreateAccountTest().userNameField);
			sendText(factory.getCreateAccountTest().userNameField, mainEmail);
			logger.info("User successfully entered the username - process passed");

			waitTillPresence(factory.getCreateAccountTest().passwordField);
			sendText(factory.getCreateAccountTest().passwordField, row.get("password"));
			logger.info("User successfully entered the password - process passed");

			waitTillPresence(factory.getCreateAccountTest().confirmPassField);
			sendText(factory.getCreateAccountTest().passwordField, row.get("confirmPassword"));
			logger.info("User successfully entered the confirm password - process passed");
		}
	}

	@Then("sumbit the form")
	public void sumbitTheForm() {
		waitTillPresence(factory.getCreateAccountTest().submitBttn);
		click(factory.getCreateAccountTest().submitBttn);
		logger.info("User successfully clicked on submit button");
	}

	@When("user fill form with below information")
	public void userFillFormWithBelowInformation(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> row : data) {
			sendText(factory.getCreateAccountTest().emailField, row.get("email"));
			logger.info("User seccessfully entered the email - process passed");

			selectByVisibleText(factory.getCreateAccountTest().titleDropdown, row.get("title"));
			logger.info("User seccessfully select the title - process passed");

			sendText(factory.getCreateAccountTest().firstNameField, row.get("firstName"));
			logger.info("User seccessfully entered the first name - process passed");

			sendText(factory.getCreateAccountTest().lastNameField, row.get("lastName"));
			logger.info("User seccessfully entered the last name - process passed");

			selectByVisibleText(factory.getCreateAccountTest().genderDropdown, row.get("gender"));
			logger.info("User seccessfully select the gender - process passed");

			selectByVisibleText(factory.getCreateAccountTest().maritalStatusDropdown, row.get("maritalStatus"));
			logger.info("User seccessfully select the marital status - process passed");

			factory.getCreateAccountTest().dateOfBirthField.sendKeys(row.get("dateOfBirth"));
			sendText(factory.getCreateAccountTest().dateOfBirthField, row.get("dateOfBirth"));
			logger.info("User seccessfully entered the date of birth - process passed");

			sendText(factory.getCreateAccountTest().employmentStatusField, row.get("employmentStatus"));
			logger.info("User seccessfully entered the employment status - process passed");
		}
	}
	// negative user account exist

	@Then("the error should be display and say the account with this email is exist")
	public void theErrorShouldBeDisplayAndSayTheAccountWithThisEmailIsExist() {
		waitTillPresence(factory.getCreateAccountTest().errorAccountExist);
		Assert.assertTrue(factory.getCreateAccountTest().errorAccountExist.isDisplayed());
		logger.info("The error message succesffully displayed - process passed");
	}

	// lookup
	@When("user fill form with the below information")
	public void userFillFormWithTheBelowInformation(DataTable dataTable) {
		emailLookup1 = DataGenerator.getEmail();
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> row : data) {
			sendText(factory.getCreateAccountTest().emailField, emailLookup1);
			logger.info("User seccessfully entered the email - process passed");

			selectByVisibleText(factory.getCreateAccountTest().titleDropdown, row.get("title"));
			logger.info("User seccessfully select the title - process passed");

			sendText(factory.getCreateAccountTest().firstNameField, row.get("firstName"));
			logger.info("User seccessfully entered the first name - process passed");

			sendText(factory.getCreateAccountTest().lastNameField, row.get("lastName"));
			logger.info("User seccessfully entered the last name - process passed");

			selectByVisibleText(factory.getCreateAccountTest().genderDropdown, row.get("gender"));
			logger.info("User seccessfully select the gender - process passed");

			selectByVisibleText(factory.getCreateAccountTest().maritalStatusDropdown, row.get("maritalStatus"));
			logger.info("User seccessfully select the marital status - process passed");

			factory.getCreateAccountTest().dateOfBirthField.sendKeys(row.get("dateOfBirth"));
			sendText(factory.getCreateAccountTest().dateOfBirthField, row.get("dateOfBirth"));
			logger.info("User seccessfully entered the date of birth - process passed");

			sendText(factory.getCreateAccountTest().employmentStatusField, row.get("employmentStatus"));
			logger.info("User seccessfully entered the employment status - process passed");
		}
	}

	@Then("user click on Login button")
	public void userClickOnLoginButton() throws InterruptedException {
		Thread.sleep(1000);
		waitTillPresence(factory.getLoginPage().loginLink);
		click(factory.getLoginPage().loginLink);
		logger.info("User successfully cliked - process passed");
		
	}

	@Then("click on register here")
	public void clickOnRegisterHere() {
		waitTillClickable(factory.getCreateAccountTest().registerHereBttn);
		click(factory.getCreateAccountTest().registerHereBttn);
		logger.info("User successfully registered - process passed");
	}

	@Then("fill the form with existing information provided before")
	public void fillTheFormWithExistingInformationProvidedBefore(DataTable dataTable)  {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> row : data) {
			
			sendText(factory.getCreateAccountTest().emailLookup, emailLookup1);
			logger.info("User seccessfully entered the email - process passed");

			sendText(factory.getCreateAccountTest().firstnameLookup, row.get("FirstName"));
			logger.info("User seccessfully entered the fistname - process passed");

			sendText(factory.getCreateAccountTest().lastNameLookup, row.get("LastName"));
			logger.info("User seccessfully entered the lastName - process passed");

			sendText(factory.getCreateAccountTest().dateOfBirthLookup, row.get("DateOfBirth"));
			logger.info("User seccessfully entered the dateOfBirth - process passed");
			// matched data message display
		}
	}

	@Then("click on submit")
	public void clickOnSubmit() throws InterruptedException {
		waitTillClickable(factory.getCreateAccountTest().submitLookup);
		click(factory.getCreateAccountTest().submitLookup);
		logger.info("User successfully clicked on submit - process passed");

	}

	@Then("fill from for username and password")
	public void fillFromForUsernameAndPassword(DataTable dataTable)  {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> row : data) {
			sendText(factory.getCreateAccountTest().userNameLookup, emailLookup1);
			logger.info("User successfully entered username - process passed");

			sendText(factory.getCreateAccountTest().passowrdLookup, row.get("password"));
			logger.info("User successfully entered password - process passed");

			sendText(factory.getCreateAccountTest().confirmPassLookup, row.get("confirmPassword"));
			logger.info("User successfully entered confirmPassword - process passed");
		}
	}

}
