package tek.insurance.app.pages;

public class POMFactory {

	private CreateAccountPage createAccountPage;
	private MainPage mainPage;
	private LoginPage loginPage;
	private CSRAccountDetailsPage cSRAccountDetailsPage;
	private CSRAccountPlansPage cSRAccountPlansPage;
	private AccountViewPage accountViewPage;
	private RemovingIncorrectDataPage removingIncorrectDataPage;

	public POMFactory() {
		this.createAccountPage = new CreateAccountPage();
		this.mainPage = new MainPage();
		this.loginPage = new LoginPage();
		this.cSRAccountDetailsPage = new CSRAccountDetailsPage();
		this.cSRAccountPlansPage = new CSRAccountPlansPage();
		this.accountViewPage = new AccountViewPage();
		this.removingIncorrectDataPage = new RemovingIncorrectDataPage();
	}

	public RemovingIncorrectDataPage getRemovingIncorrectDataPage() {
		return this.removingIncorrectDataPage;
	}

	public AccountViewPage getAccountViewPage() {
		return this.accountViewPage;
	}

	public CreateAccountPage getCreateAccountPage() {
		return this.createAccountPage;
	}

	public MainPage getMainPage() {
		return this.mainPage;
	}

	public LoginPage getLoginPage() {
		return this.loginPage;
	}

	public CSRAccountDetailsPage getCSRAccountDetailsPage() {
		return this.cSRAccountDetailsPage;
	}

	public CSRAccountPlansPage getCSRAccountPlansPage() {
		return this.cSRAccountPlansPage;
	}

}