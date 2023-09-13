package tek.insurance.app.steps;

import org.junit.Assert;
import io.cucumber.java.en.Given;
import tek.insurance.app.pages.POMFactory;
import tek.insurance.app.utilities.CommonUtility;

public class MainPageStep extends CommonUtility {

	POMFactory factory = new POMFactory();

	@Given("User is on tek insurance page and verify the {string} logo")
	public void userIsOnTekInsurancePageAndVerifyTheLogo(String expected) {
		waitTillPresence(factory.getMainPage().tekInsuranceLink);
		Assert.assertTrue(factory.getMainPage().tekInsuranceLink.isDisplayed());
		String actual = factory.getMainPage().tekInsuranceLink.getText();
		Assert.assertEquals(expected, actual);
		logger.info(
				"User was able to log in to the main page and the tek insurance title was displayed - process passed");
	}

	@Given("Verify {string} text should be displayed")
	public void verifyTextShouldBeDisplayed(String expected) {
		waitTillPresence(factory.getMainPage().letGetStartedText);
		String actualText = factory.getMainPage().letGetStartedText.getText();
		Assert.assertEquals(expected, actualText);
		logger.info("The Actual and expected text was same - process passed");
	}

	@Given("verify {string} button should be displayed")
	public void verifyButtonShouldBeDisplayed(String expected) {
		waitTillPresence(factory.getMainPage().createPrimaryAccountBttn);
		String actualTextBttn = factory.getMainPage().createPrimaryAccountBttn.getText();
		Assert.assertEquals(expected, actualTextBttn);
		logger.info("The actual and expected text button was same - process passed");
	}

}
