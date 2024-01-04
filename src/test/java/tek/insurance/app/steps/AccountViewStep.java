package tek.insurance.app.steps;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.insurance.app.pages.POMFactory;
import tek.insurance.app.utilities.CommonUtility;

public class AccountViewStep extends CommonUtility {
	POMFactory factory = new POMFactory();

	private static List<HashMap<String, String>> uiRecords = new ArrayList<>();
	private static List<HashMap<String, Object>> dbRecords = new ArrayList<>();

	@Given("User is on the Accounts page with the title {string}")
	public void userIsOnTheAccountsPageWithTheTitle(String expectedTitle) throws InterruptedException {

		waitTillPresence(factory.getAccountViewPage().primaryAccountsText);
		String actualText = factory.getAccountViewPage().primaryAccountsText.getText();

		Assert.assertEquals(actualText, expectedTitle);
		loggerActualAndExpected(actualText, expectedTitle);
	}

	@When("User select {string} from show dropdown")
	public void userSelectFromShowDropdown(String expectedPage) {
		click(factory.getAccountViewPage().showDropdown);
		selectByValue(factory.getAccountViewPage().showDropdown, expectedPage);
		logger.info("User successfully selected the " + expectedPage + " of dropdown - process passed");
	}

	@Then("User retrieves and stores data from the uiWebsite")
	public void userRetrievesAndStoresDataFromTheUiWebsite() {
		String totalpageText = getElementText(factory.getAccountViewPage().totalPages);
		String lastPageString = totalpageText.substring(totalpageText.indexOf('f') + 1).trim();
		int lastPageInt = Integer.valueOf(lastPageString);

		int currentPage = 0;
		boolean nextPageEnable = true;

//		List<HashMap<String, String>> uiRecords = new ArrayList<>();

		while (nextPageEnable) {
			List<WebElement> rows = factory.getAccountViewPage().tableRowList;

			for (WebElement row : rows) {
				List<WebElement> cells = row.findElements(By.tagName("td"));

				HashMap<String, String> recordMap = new HashMap<>();
				String email = cells.get(1).getText();
				String fullName = cells.get(2).getText();
				String gender = cells.get(3).getText();
				String maritalStatus = cells.get(4).getText();
				String dateOfBirth = cells.get(5).getText();

				recordMap.put("email", email);
				recordMap.put("fullName", fullName);
				recordMap.put("gender", gender);
				recordMap.put("marital_status", maritalStatus);
				recordMap.put("date_of_birth", dateOfBirth);

				uiRecords.add(recordMap);
			}
			nextPageEnable = isElementEnabled(factory.getAccountViewPage().nextBttn);

			if (nextPageEnable) {
				click(factory.getAccountViewPage().nextBttn);
				currentPage++;
			}
			if (currentPage >= lastPageInt) {
				nextPageEnable = false;
			}
		}
		for (HashMap<String, String> record : uiRecords) {
			System.out.println(record);
		}
		System.out.println("Total Records: " + uiRecords.size());

		if (uiRecords.size() != 0) {
			Assert.assertTrue(true);
			logger.info("Successfully retireve data from uiWebsite - process passed");
		} else {
			Assert.fail();
			System.err.println("Retrieve from uiWebsite failed");

		}
	}
	// database

	@When("User retrieves and stores data from the database")
	public void userRetrievesAndStoresDataFromTheDatabase() throws SQLException {
		setupDatabaseConnection();
		ResultSet result = runDatabaseQuery(
				"select email,title, first_name, last_name, gender,marital_status, date_of_birth from primary_person order by id desc");
		ResultSetMetaData metaData = result.getMetaData();
//		List<HashMap<String, Object>> dbRecords = new ArrayList<>();

		try {
			while (result.next()) {
				HashMap<String, Object> dataMap = new HashMap<>();

				for (int i = 1; i <= metaData.getColumnCount(); i++) {
					String columnName = metaData.getColumnName(i);
					String columnValue = result.getString(i);

					if (columnName.equals("title")) {
						String title = columnValue;
						String firstName = result.getString("first_name");
						String lastName = result.getString("last_name");
						if (firstName != null && lastName != null) {
							String fullName = title + " " + firstName + " " + lastName;
							dataMap.put("fullName", fullName);
						}
					} else if (!columnName.equals("first_name") && !columnName.equals("last_name")) {
						if (columnValue != null) {
							if (columnName.equals("marital_status")) {
								columnValue = capitalizeFirstLetter(columnValue);
							} else if (columnName.equals("date_of_birth")) {
								columnValue = dateFormatted(columnValue);
							} else if (columnName.equals("gender")) {
								columnValue = capitalizeFirstLetter(columnValue);
							}
							dataMap.put(columnName, columnValue);
						}
					}
				}
				dbRecords.add(dataMap);
			}
			for (HashMap<String, Object> record : dbRecords) {
				System.out.println(record);
			}
			print("Total size of Database: " + dbRecords.size());
			closeDatabaseConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (dbRecords.size() != 0) {
			Assert.assertTrue(true);
			logger.info("Successfully retireve data from database - process passed");
		} else {
			Assert.fail();
			System.err.println("Retrieve from database failed");
		}
	}

	// validate

	@Then("Validate that the data from uiWebsite matches the data from the database")
	public void validateThatTheDataFromUiWebsiteMatchesTheDataFromTheDatabase() {
		System.out.println("Size of UI: " + uiRecords.size());
		System.out.println("Size of Database: " + dbRecords.size());

		boolean isMathces = recordsMatchsList(uiRecords, dbRecords);
		boolean isMathces2 = recordsMatchList2(uiRecords, dbRecords);
		boolean isMathces4 = recordsMatchList4(uiRecords, dbRecords);
		System.out.println("Aserter for validate: " + isMathces);
		System.out.println("Aserter for validate2: " + isMathces2);
		System.out.println("Aserter for validate4: " + isMathces4);

		Assert.assertTrue(recordsMatchList4(uiRecords, dbRecords));
		logger.info("successfully data form ui and database validated - process passed");
	}

	// validating create account button

	@When("User click on {string} button")
	public void userClickOnButton(String CABttn) {
		click(factory.getAccountViewPage().createAccountBttnInPrimaryAccoutn);
		logger.info("user successfully clicked on create account button - process passed");

	}

	@Then("another page should be displayed with the header {string}")
	public void anotherPageShouldBeDisplayedWithTheHeader(String expectedHeader) {
		String actualHeader = getElementText(factory.getCreateAccountPage().createPrimaryAccountText);
		Assert.assertEquals(actualHeader, expectedHeader);
		loggerActualAndExpected(actualHeader, expectedHeader);
	}

}
