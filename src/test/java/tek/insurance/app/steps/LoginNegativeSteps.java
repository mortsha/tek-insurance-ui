package tek.insurance.app.steps;

import io.cucumber.java.en.Given;
import tek.insurance.app.pages.POMFactory;
import tek.insurance.app.utilities.CommonUtility;

public class LoginNegativeSteps extends CommonUtility{

	POMFactory factory = new POMFactory();
	
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
	
}
