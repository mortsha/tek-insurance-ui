package tek.insurance.app.pages;

public class POMFactory {

	private CreateAccountTest createAccountTest;
	private MainPage mainPage;
	private LoginPage loginPage;

	public POMFactory() {
		this.createAccountTest = new CreateAccountTest();
		this.mainPage = new MainPage();
		this.loginPage = new LoginPage();
	}

	public CreateAccountTest getCreateAccountTest() {
		return createAccountTest;
	}

	public MainPage getMainPage() {
		return this.mainPage;
	}
	
	public LoginPage getLoginPage() {
		return this.loginPage;
	}
	
	

}