package tek.insurance.app.pages;

public class POMFactory {

	private CreateAccountTest createAccountTest;
	private MainPage mainPage;
	private LoginPage loginPage;
	private CSRDetail csrDetail;
	private CSRPlans csrPlans;

	public POMFactory() {
		this.createAccountTest = new CreateAccountTest();
		this.mainPage = new MainPage();
		this.loginPage = new LoginPage();
		this.csrDetail = new CSRDetail();
		this.csrPlans = new CSRPlans();
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
	
	public CSRDetail getCSRDetail() {
		return this.csrDetail;
	}
	public CSRPlans getCSRPlans() {
		return this.csrPlans;
	}
	

}