package tek.insurance.app.steps;

import java.util.List;
import java.util.Map;

import javax.lang.model.element.Element;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import tek.insurance.app.pages.POMFactory;
import tek.insurance.app.utilities.CommonUtility;
import tek.insurance.app.utilities.DataGenerator;

public class CSRDetailAddress extends CommonUtility {

	POMFactory factory = new POMFactory();
	private DataGenerator dataGenerator = new DataGenerator();
	private String addressLine;
	private String city;
	private String phoneNumber;
	private String licensePlate;
	private String fullAddress;
	private String addressId;
	private String phoneId;
	private String carId;

	@Then("User click on close button to close the profile section")
	public void userClickOnCloseButtonToCloseTheProfileSection() {
		click(factory.getCSRDetail().closeBttn);
		logger.info("User seccessfully clicked on close button - process passed");
	}

	@Given("The user click on Accounts")
	public void theUserClickOnAccounts() {
		click(factory.getLoginPage().accountsSection);
		logger.info("User successfully clicked on Accounts - process passed");
	}

	@Given("find the account with email {string} and click on details")
	public void findTheAccountWithEmailAndClickOnDetails(String email) throws InterruptedException {

		sendText(factory.getCSRDetail().emailFieldPrimaryAccount, email);
		click(factory.getCSRDetail().detailAccountBttn);
		logger.info("User successfully clicked on detail button");

		// next solution
//		
//		click(factory.getCSRDetail().dropdownShow);
//		selectByValue(factory.getCSRDetail().dropdownShow, "50");
//
//		boolean emailFound = false;
//		while (!emailFound) {
//			for (WebElement element : factory.getCSRDetail().emailAddressList) {
//				if (element.getText().equalsIgnoreCase(email)) {
//					click(By.xpath("//td[text()='" + email + "']//following-sibling::td[5]//child::button"));
//					emailFound = true;
//					return;
//				}
//			}
//			if (!emailFound) {
//				click(factory.getCSRDetail().nextPageBttn);
//				waitTillPresence(By.xpath("//table/tbody/tr/td[2]"));
//			}
//			if (emailFound) {
//				break;
//			}
//		}
//		logger.info("User successfully find the email and clicked on details - process passed ");
	}

	@When("validate the title {string} should be present")
	public void validateTheTitleShouldBePresent(String expectedTitle) {
		waitTillPrecenseElements(factory.getCSRDetail().titleList);
		boolean titleFound = false;

		for (WebElement element : factory.getCSRDetail().titleList) {
			String actualTitle = element.getText();
			if (actualTitle.equals(expectedTitle)) {
				titleFound = true;
				break; // Exit the loop once a matching title is found
			}
		}
		if (titleFound) {
			Assert.assertTrue(true);
			logger.info("Match found: " + expectedTitle);
		} else {
			Assert.fail("Title not found: " + expectedTitle);
			logger.error("Title not found: " + expectedTitle);

		}
	}

	@Given("User click on {string} section")
	public void userClickOnSection(String section) {
		for (WebElement element : factory.getCSRDetail().scrSectionList) {
			if (element.getText().equals(section)) {
				click(element);
			}
		}
		logger.info("User successfully clicked on " + section + " section - process passed");

	}

	@When("User click on {string} section button")
	public void userClickOnSectionButton(String addSection) {
		for (WebElement element : factory.getCSRDetail().addSectionList) {
			if (element.getText().equals(addSection)) {
				click(element);
			}
		}
		logger.info("User successfully clicked on " + addSection + " section - process passed");

	}

//	@When("User click on Add mailing address button")
//	public void userClickOnAddMailingAddressButton() {
//		click(factory.getCSRDetail().addMailingAddressBttn);
//		logger.info("User successfully clicked on Add Mailing Adress - process passed");
//	}

	@When("validate the {string} text header")
	public void validateTheTextHeader(String expectedHeaderText) {
		for (WebElement element : factory.getCSRDetail().headerSectionTextList) {
			if (element.getText().equals(expectedHeaderText)) {
				String actualHeader = element.getText();
				Assert.assertEquals(actualHeader, expectedHeaderText);
				logger.info("The actual: " + actualHeader + " and expected: " + expectedHeaderText
						+ " is same - process passed");
			}
		}

	}

	@When("The Your current address checkbox is {string} selected")
	public void theYourCurrentAddressCheckboxIsSelected(String checkBox) {
		if (checkBox.equals("off")) {
			click(factory.getCSRDetail().currentAddressCheckBox);
			logger.info("The checkbox is off now - process passed");
		} else if (checkBox.equals("on")) {
			if (!isElementDisplayed(factory.getCSRDetail().currentAddressCheckBox)) {
				click(factory.getCSRDetail().currentAddressCheckBox);
			} else {
				Assert.assertTrue(isElementDisplayed(factory.getCSRDetail().currentAddressCheckBox));
				logger.info("The checkbox is alreadey on - process passed");
			}
		}

	}

	@Then("The user fill the form with the below information")
	public void theUserFillTheFormWithTheBelowInformation(DataTable dataTable) throws InterruptedException {
		addressLine = dataGenerator.getAddressLine();
		System.out.println("ADDRESS: " + addressLine);
		city = dataGenerator.getCity();
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> row : data) {
			click(factory.getCSRDetail().addressTypeDropdown);
			selectByVisibleText(factory.getCSRDetail().addressTypeDropdown, row.get("AddressType"));
			sendText(factory.getCSRDetail().addressLineField, addressLine);
			sendText(factory.getCSRDetail().cityField, city);
			sendText(factory.getCSRDetail().stateField, dataGenerator.getState());
			sendText(factory.getCSRDetail().zipcodeField, dataGenerator.getZipeCode());
		}
		logger.info("User fill the Address form successfully - process passed");
	}

	@Then("The user fill the Phone form with the below information")
	public void theUserFillThePhoneFormWithTheBelowInformation(DataTable dataTable) throws InterruptedException {
		phoneNumber = dataGenerator.getPhoneNumber();
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> row : data) {
			click(factory.getCSRDetail().phoneTypeDropdown);
			selectByVisibleText(factory.getCSRDetail().phoneTypeDropdown, row.get("PhoneType"));
			sendText(factory.getCSRDetail().phoneNumberField, phoneNumber);
			sendText(factory.getCSRDetail().extentionField, dataGenerator.getExtension());
			click(factory.getCSRDetail().timeDropdown);
			selectByVisibleText(factory.getCSRDetail().timeDropdown, row.get("Time"));
		}
		logger.info("User successfully fill the Phone form - process passed");
	}

	@Then("The user fill the Car form with the below information")
	public void theUserFillTheCarFormWithTheBelowInformation(DataTable dataTable) {
		licensePlate = dataGenerator.getLicensePlate();
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> row : data) {
			sendText(factory.getCSRDetail().makeField, row.get("Make"));
			sendText(factory.getCSRDetail().modelField, row.get("Model"));
			sendText(factory.getCSRDetail().yearField, row.get("Year"));
			sendText(factory.getCSRDetail().licensePlateField, licensePlate);
		}
		logger.info("User successfully fill the Car form - process passed");

	}

	@Then("The user click on submit button")
	public void theUserClickOnSubmitButton() throws InterruptedException {
		click(factory.getCSRDetail().submitBttn);
		logger.info("User successfully clicked on submit button - process passed");
	}

	@Then("validate the address is present")
	public void validateTheAddressIsPresent() {
		refresh();
		fullAddress = addressLine + ", " + city;
		boolean addressFound = false;
		for (WebElement element : factory.getCSRDetail().addressValidateList) {
			if (element.getText().equals(fullAddress)) {
				addressFound = true;
				break;
			}
		}
		if (addressFound) {
			logger.info("The actual and expected addresses match - process passed");
		} else {
			Assert.fail("Address not found: " + fullAddress);
			logger.info("Address not found: " + fullAddress);
		}
	}

	@Then("The user click on delete button of {string}")
	public void theUserClickOnDeleteButtonOf(String deleteSection) {
		switch (deleteSection.toLowerCase()) {
		case "address":
			WebElement addressIdXpath = findElementByCustomXPath(
					"//p[contains(text(),'" + addressLine + "')]//parent::div");
			addressId = addressIdXpath.getAttribute("id");
			click(By.xpath("//div[@id='" + addressId + "']//preceding::div[1]//child::button"));
			logger.info("User clicked on delete address successfully - process passed");
			break;

		case "phone":
			String phoneFormatted = dataGenerator.formatPhoneNumber(phoneNumber);
			WebElement phoneIdXPath = findElementByCustomXPath("//p[contains(text(),'" + phoneFormatted
					+ "')]//parent::div//parent::div[starts-with(@class,'css')]");
			phoneId = phoneIdXPath.getAttribute("id");
			click(By.xpath("//div[@id='" + phoneId + "']//preceding::div[1]//child::button"));

			logger.info("User clicked on delete phone successfully - process passed");
			break;

		case "car":
			WebElement carIdXPath = findElementByCustomXPath(
					"//p[contains(text(),'" + licensePlate + "')]//parent::div//preceding-sibling::div");
			carId = carIdXPath.getAttribute("id");
			click(By.xpath("//div[@id='" + carId + "']//preceding::div[1]//child::button"));
			logger.info("User clicked on delete car successfully - process passed");
			break;

		default:
			break;
		}
	}

	@Then("The user click on delete button")
	public void theUserClickOnDeleteButton() {
		click(factory.getCSRDetail().deleteAdress);
	}

	@Then("The message Warning {string} should be display")
	public void theMessageWarningShouldBeDisplay(String warningDelMessage) {
		waitTillPresence(factory.getCSRDetail().deleteMessage);
		String actualDel = factory.getCSRDetail().deleteMessage.getText().replace("WARNING\n", "");
		Assert.assertEquals(actualDel, warningDelMessage);
		loggerActualAndExpected(actualDel, warningDelMessage);
	}

	@Then("The user click on confirm button")
	public void theUserClickOnConfirmButton() {
		click(factory.getCSRDetail().confirmBttn);
		logger.info("User clicked on confirm button successfully - process passed");
	}

	@Then("The message {string} id {string} should be displayed")
	public void theMessageIdShouldBeDisplayed(String textFirstPart, String textSecondPart) {
		String expectedDelSuccess = textFirstPart + " " + addressId + " " + textSecondPart;
		boolean messageFound = false;
		waitTillPrecenseElements(factory.getCSRDetail().successDeleteMessageList);
		for (WebElement element : factory.getCSRDetail().successDeleteMessageList) {
			String actualMessage = element.getText().replace("Delete address\n", "");
			if (actualMessage.equals(expectedDelSuccess)) {
				messageFound = true;
				break;
			}
		}
		if (messageFound) {
			Assert.assertTrue(true);
			logger.info("Matched found: " + expectedDelSuccess);
		} else {
			Assert.fail("Message not found: " + expectedDelSuccess);
			logger.info("Message not found: " + expectedDelSuccess);
		}
	}

	// Phones

	@Then("The message {string} id {string} should be displayed in phone section")
	public void theMessageIdShouldBeDisplayedInPhoneSection(String textFirstPart, String textSecondPart) {
		String expectedDelSuccess = textFirstPart + " " + phoneId + " " + textSecondPart;
		boolean messageFound = false;
		waitTillPrecenseElements(factory.getCSRDetail().successDeleteMessageList);
		for (WebElement element : factory.getCSRDetail().successDeleteMessageList) {
			String actualMessage = element.getText().replace("Delete phone\n", "");
			if (actualMessage.equals(expectedDelSuccess)) {
				messageFound = true;
				break;
			}
		}
		if (messageFound) {
			Assert.assertTrue(true);
			logger.info("Matched found: " + expectedDelSuccess);
		} else {
			Assert.fail("Message not found: " + expectedDelSuccess);
			logger.info("Message not found: " + expectedDelSuccess);
		}
	}

	@Then("validate the phone is present")
	public void validateThePhoneIsPresent() {
		refresh();

		for (WebElement element : factory.getCSRDetail().scrSectionList) {
			if (element.getText().equals("Phones")) {
				click(element);
			}
		}

		String phoneFormatted = dataGenerator.formatPhoneNumber(phoneNumber);

		for (WebElement element : factory.getCSRDetail().ValidateSectionList) {
			if (element.getText().equals(phoneFormatted)) {
				Assert.assertTrue(isElementDisplayed(element));
				break;
			}

		}
		logger.info("The phone is present - process passed");
	}

	@Then("Validate the data of {string} is in account details")
	public void validateTheDataOfIsInAccountDetails(String section) {
		switch (section.toLowerCase()) {
		case "phone":
			refresh();

			for (WebElement element : factory.getCSRDetail().scrSectionList) {
				if (element.getText().equals("Phones")) {
					click(element);
				}
			}

			String phoneFormatted = dataGenerator.formatPhoneNumber(phoneNumber);

			for (WebElement element : factory.getCSRDetail().ValidateSectionList) {
				if (element.getText().equals(phoneFormatted)) {
					Assert.assertTrue(isElementDisplayed(element));
					break;
				}

			}
			logger.info("The phone is present - process passed");
			break;
		case "car":
			refresh();
			for (WebElement element : factory.getCSRDetail().scrSectionList) {
				if (element.getText().equals("Cars")) {
					click(element);
				}
			}

			for (WebElement element : factory.getCSRDetail().ValidateSectionList) {
				if (element.getText().equals(licensePlate)) {
					waitTillPresence(element);
					Assert.assertTrue(isElementDisplayed(element));
					break;

				}
			}
			logger.info("Validated the License Plate - process passed");
			break;
		default:
			System.out.println("Input is wrong in validate section");
			break;
		}
	}

	@Then("validate the {string} section is present")
	public void validateTheSectionIsPresent(String section) {
		switch (section.toLowerCase()) {
		case "phone":
			refresh();

			for (WebElement element : factory.getCSRDetail().scrSectionList) {
				if (element.getText().equals("Phones")) {
					click(element);
				}
			}

			String phoneFormatted = dataGenerator.formatPhoneNumber(phoneNumber);

			for (WebElement element : factory.getCSRDetail().ValidateSectionList) {
				if (element.getText().equals(phoneFormatted)) {
					Assert.assertTrue(isElementDisplayed(element));
					break;
				}

			}
			logger.info("The phone is present - process passed");
			break;
		case "car":
			refresh();
			for (WebElement element : factory.getCSRDetail().scrSectionList) {
				if (element.getText().equals("Cars")) {
					click(element);
				}
			}

			for (WebElement element : factory.getCSRDetail().ValidateSectionList) {
				if (element.getText().equals(licensePlate)) {
					waitTillPresence(element);
					Assert.assertTrue(isElementDisplayed(element));
					break;

				}
			}
			logger.info("Validated the License Plate - process passed");
			break;
		default:
			System.out.println("Input is wrong in validate section");
			break;
		}
	}

	// Car

	@Then("The message {string} id {string} should be displayed in car section")
	public void theMessageIdShouldBeDisplayedInCarSection(String textFirstPart, String textSecondPart) {
		String expectedDelSuccess = textFirstPart + " " + carId + " " + textSecondPart;
		boolean messageFound = false;
		waitTillPrecenseElements(factory.getCSRDetail().successDeleteMessageList);
		for (WebElement element : factory.getCSRDetail().successDeleteMessageList) {
			String actualMessage = element.getText().replace("Delete car\n", "");
			if (actualMessage.equals(expectedDelSuccess)) {
				messageFound = true;
				break;
			}
		}
		if (messageFound) {
			Assert.assertTrue(true);
			logger.info("Matched found: " + expectedDelSuccess);
		} else {
			Assert.fail("Message not found: " + expectedDelSuccess);
			logger.info("Message not found: " + expectedDelSuccess);
		}
	}

}
