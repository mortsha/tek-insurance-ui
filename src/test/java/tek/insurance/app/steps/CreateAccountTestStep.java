package tek.insurance.app.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.insurance.app.pages.POMFactory;
import tek.insurance.app.utilities.CommonUtility;
import tek.insurance.app.utilities.DataGenerator;
import org.junit.Assert;
import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;

public class CreateAccountTestStep extends CommonUtility {
	POMFactory factory = new POMFactory();

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
		logger.info(
				"the actual " + actualAccountBttn + " and expected " + createAccount + " button was same - process passed");
		
		waitTillPresence(factory.getCreateAccountTest().resetFormBttn);
		String actualResetBttn = factory.getCreateAccountTest().resetFormBttn.getText();
		Assert.assertEquals(resetForm, actualResetBttn);
		logger.info(
				"the actual " + actualResetBttn + " and expected " + resetForm + " button was same - process passed");
		
	}

	@When("user fill the form with below information")
	public void userFillTheFormWithBelowInformation(DataTable dataTable) {
		String email = DataGenerator.getEmail();
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> row : data) {
			sendText(factory.getCreateAccountTest().emailField, email);
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

	@Then("another page should be displayed")
	public void anotherPageShouldBeDisplayed() {
		// next step
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

}
