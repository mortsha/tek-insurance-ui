package tek.insurance.app.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
	private String validateAddress;

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
		click(factory.getCSRDetail().dropdownShow);
		selectByValue(factory.getCSRDetail().dropdownShow, "50");

		boolean emailFound = false;
		while (!emailFound) {
			for (WebElement element : factory.getCSRDetail().emailAddressList) {
				if (element.getText().equalsIgnoreCase(email)) {
//					click(factory.getCSRDetail().detailBttn);
					click(By.xpath("//td[text()='" + email + "']//following-sibling::td[5]//child::button"));
					emailFound = true;
					return;
				}
			}
			if (!emailFound) {
				click(factory.getCSRDetail().nextPageBttn);
				waitTillPresence(By.xpath("//table/tbody/tr/td[2]"));
			}
			if (emailFound) {
				break;
			}
		}
		logger.info("User successfully find the email and clicked on details - process passed ");
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
		if(checkBox.equals("off")) {
			click(factory.getCSRDetail().currentAddressCheckBox);
			logger.info("The checkbox is off now - process passed");
		}else if(checkBox.equals("on")) {
			if(!isElementDisplayed(factory.getCSRDetail().currentAddressCheckBox)) {
				click(factory.getCSRDetail().currentAddressCheckBox);
			}else {
				Assert.assertTrue(isElementDisplayed(factory.getCSRDetail().currentAddressCheckBox));
				logger.info("The checkbox is alreadey on - process passed");
			}
		}
		
	}

	@Then("The user fill the form with the below information")
	public void theUserFillTheFormWithTheBelowInformation(DataTable dataTable) throws InterruptedException {
		addressLine = dataGenerator.getAddressLine();
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
		Thread.sleep(1000);
	}

	@Then("validate the address is present")
	public void validateTheAddressIsPresent() {
		validateAddress = addressLine;
		for (WebElement element : factory.getCSRDetail().addressValidateList) {
			if (element.getText().equalsIgnoreCase(validateAddress)) {
				Assert.assertTrue(element.isDisplayed());
				System.out.println(element.getText());
				logger.info("Validate the address - process passed");
			}
		}
	}

	@Then("The user click on delete button of {string}")
	public void theUserClickOnDeleteButtonOf(String deleteSection) {
		switch (deleteSection.toLowerCase()) {
		case "address":
			click(By.xpath("//p[text()='" + validateAddress + "']//preceding::div[1]//child::button"));
//			click(factory.getCSRDetail().deleteAdress);
			logger.info("User clicked on delete address successfully - process passed");
			break;

		case "phone":
			String phoneFormatted = dataGenerator.formatPhoneNumber(phoneNumber);
			click(By.xpath("//p[text()='" + phoneFormatted + "']//preceding::div[2]//child::button"));
//			click(factory.getCSRDetail().deletePhoneBttn);
			logger.info("User clicked on delete phone successfully - process passed");
			break;

		case "car":
			click(By.xpath("//p[text()='" + licensePlate + "']//preceding::div[2]//child::button"));
//			click(factory.getCSRDetail().deleteCarBttn);
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
	public void theMessageWarningShouldBeDisplay(String warningMessage) {
		for (WebElement element : factory.getCSRDetail().warningList) {
			if (element.getText().equalsIgnoreCase(warningMessage)) {
				waitTillPresence(element);
				Assert.assertTrue(element.isDisplayed());
				logger.info("Message displayed - process passed");
			}
		}
	}

	@Then("The user click on confirm button")
	public void theUserClickOnConfirmButton() {
		click(factory.getCSRDetail().confirmBttn);
		logger.info("User clicked on confirm button successfully - process passed");
	}

	@Then("The message {string} should be displayed")
	public void theMessageShouldBeDisplayed(String deleteMessage) throws InterruptedException {
		System.out.println("Printing to make sure");
		waitTillPrecenseElements(factory.getCSRDetail().successDeleteMessageList);
		for (WebElement element : factory.getCSRDetail().successDeleteMessageList) {
			if (element.getText().equals(deleteMessage)) {
				Assert.assertTrue(element.isDisplayed());
				logger.info("The message: " + element.getText() + " is present - process passed");
			}
		}

	}

	@Then("the address should be deleted from account detail")
	public void theAddressShouldBeDeletedFromAccountDetail() {
	}

	// Phones

	@Then("validate the {string} section is present")
	public void validateTheSectionIsPresent(String section) {
		switch (section.toLowerCase()) {
		case "phone":
			String phoneFormatted = dataGenerator.formatPhoneNumber(phoneNumber);
			for (WebElement element : factory.getCSRDetail().ValidateSectionList) {
				if (element.getText().equals(phoneFormatted)) {
					waitTillPresence(element);
					Assert.assertTrue(element.isDisplayed());
					logger.info("Validated the phone - process passed");
				}
			}
			break;
		case "car":
			for (WebElement element : factory.getCSRDetail().ValidateSectionList) {
				if (element.getText().equals(licensePlate)) {
					waitTillPresence(element);
					Assert.assertTrue(element.isDisplayed());
					logger.info("Validated the License Plate - process passed");

				}
			}
			break;
		default:
			System.out.println("Input is wrong in validate section");
			break;
		}
	}

//	@Then("validate the phone is present")
//	public void validateThePhoneIsPresent() throws InterruptedException {
//		String phoneFormatted = dataGenerator.formatPhoneNumber(phoneNumber);
//		for (WebElement element : factory.getCSRDetail().ValidateSectionList) {
//			if (element.getText().equals(phoneFormatted)) {
//				waitTillPresence(element);
//				Assert.assertTrue(element.isDisplayed());
//				logger.info("Validated the phone - process passed");
//
//			}
//		}
//
//	}

	// Car

}
