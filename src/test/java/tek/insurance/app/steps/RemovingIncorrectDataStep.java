package tek.insurance.app.steps;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import tek.insurance.app.pages.POMFactory;
import tek.insurance.app.utilities.CommonUtility;

public class RemovingIncorrectDataStep extends CommonUtility {

	POMFactory factory = new POMFactory();

	@Given("a connection to the database")
	public void aConnectionToTheDatabase() {
		setupDatabaseConnection();
		logger.info("Successfully connected to database");
	}

	@When("retrieve abd identify the emails of accounts with null date of birth and remove the accounts")
	public void retrieveAbdIdentifyTheEmailsOfAccountsWithNullDateOfBirthAndRemoveTheAccounts() {
		ResultSet result = runDatabaseQuery("select * from primary_person where date_of_birth is null;");
		List<String> emailsToDelete = new ArrayList<>();

		try {
			while (result.next()) {
				emailsToDelete.add(result.getString(3));
			}
			System.out.println("List size: " + emailsToDelete.size());

			if (emailsToDelete.size() != 0) {
				for (String email : emailsToDelete) {
					System.out.println("Email: " + email);
					sendText(factory.getCSRAccountDetailsPage().emailFieldPrimaryAccount, email);
					click(factory.getRemovingIncorrectDataPage().deleteAccountBttn);

					click(factory.getCSRAccountDetailsPage().confirmBttn);
					factory.getCSRAccountDetailsPage().emailFieldPrimaryAccount.clear();

					click(factory.getLoginPage().accountsSection);
				}
			} else {
				System.out.println("There is no data with null fields");
			}

			closeDatabaseConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
