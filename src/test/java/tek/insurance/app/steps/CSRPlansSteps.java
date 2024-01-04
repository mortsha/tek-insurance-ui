package tek.insurance.app.steps;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.insurance.app.pages.POMFactory;
import tek.insurance.app.utilities.CommonUtility;
import tek.insurance.app.utilities.DateUtility;

public class CSRPlansSteps extends CommonUtility {

	POMFactory factory = new POMFactory();

	@When("The User click on Plans")
	public void theUserClickOnPlans() {
		click(factory.getLoginPage().plansSection);
		logger.info("User succussfully clicked on Plans - process passed");
	}

	@When("The text Todays Plans Price should be display")
	public void theTextTodaysPlansPriceShouldBeDisplay() {
		waitTillPresence(factory.getCSRAccountPlansPage().todaysPlansPriceText);
		Assert.assertTrue(factory.getCSRAccountPlansPage().todaysPlansPriceText.isDisplayed());
		logger.info("The text was displayed successfully - process passed");
	}

	@Then("The plan types {string} {string} {string} {string} should be there")
	public void thePlanTypesShouldBeThere(String motorcycle, String boat, String renters, String auto) {
		for (WebElement element : factory.getCSRAccountPlansPage().planTypeDateList) {
			String expected = element.getText();
			if (expected.contains(motorcycle) || expected.contains(boat) || expected.contains(renters)
					|| expected.contains(auto)) {
				System.out.println(expected);
				Assert.assertTrue(element.isDisplayed());
			}
		}
		logger.info("Plan type was displayed successfully - process passed");
	}

	@Then("Date created should be todays date")
	public void dateCreatedShouldBeTodaysDate() {
		String expectedCreatedDate = DateUtility.todaysDate();
		for (WebElement element : factory.getCSRAccountPlansPage().createdDateList) {
			String actualCreatedDate = getElementText(element);
			Assert.assertEquals(expectedCreatedDate, actualCreatedDate);
			logger.info("the expected date created " + expectedCreatedDate + " and actual " + actualCreatedDate
					+ " was same - process passed");
		}
	}

	@Then("Date expired should be one day after that date")
	public void dateExpiredShouldBeOneDayAfterThatDate() {
		String expectedExpiredDate = DateUtility.incrementDate(1);
		for (WebElement element : factory.getCSRAccountPlansPage().expiredDateList) {
			String actualExpiredDate = getElementText(element);
			Assert.assertEquals(expectedExpiredDate, actualExpiredDate);
			logger.info("the expected date created " + expectedExpiredDate + " and actual " + actualExpiredDate
					+ " was same - process passed");
		}
	}
}
