package tek.insurance.app.pages;

public class POMFactory {

	private CreateAccountTest createAccountTest;
	private MainPage mainPage;

	public POMFactory() {
		this.createAccountTest = new CreateAccountTest();
		this.mainPage = new MainPage();
	}

	public CreateAccountTest getCreateAccountTest() {
		return createAccountTest;
	}

	public MainPage getMainPage() {
		return this.mainPage;
	}

}