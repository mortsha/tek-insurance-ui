package tek.insurance.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.insurance.app.base.BaseSetup;

public class LoginPage extends BaseSetup {

	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath = "//a[text()='Login']")
	public WebElement loginLink;
	
	@FindBy(xpath = "//h2[text()='Sign in to your Account']")
	public WebElement signInTitle;
	
	@FindBy(id = "username")
	public WebElement usernameField;
	
	@FindBy(id = "password")
	public WebElement passwordField;
	
	@FindBy(xpath = "//button[text()='Sign In']")
	public WebElement singInBttn;
	
	@FindBy(xpath = "//h2[text()='Customer Service Portal']")
	public WebElement customerServicePortal;
	
	@FindBy(xpath = "//a[text()='Accounts']")
	public WebElement accountsLinkInCustomerPortal;
	
	@FindBy(xpath = "//a[text()='Plans']")
	public WebElement plansLinkInCustomerPortal;
	
	@FindBy(xpath = "//button[@type='button']")
	public WebElement profileBttn;
	
	@FindBy(xpath = "//p[text()='CSR']")
	public WebElement userTypeInCustomer;
	
	@FindBy(xpath = "//p[text()='Supervisor']")
	public WebElement fullNameInCustomer;
	

	@FindBy(xpath = "//p[text()='supervisor']")
	public WebElement usernameInCustomer;
	
	@FindBy(xpath = "//button[text()='Logout']")
	public WebElement logoutBttnInCustomer;
	
	// scenario second: login to primary account portal
	
	@FindBy(xpath = "//h2[text()='Primary Account Portal']")
	public WebElement primaryAccountPortal;
	

	
	@FindBy(xpath = "//a[text()='Dashboard']")
	public WebElement dashboardLink;
	
	@FindBy(xpath = "//a[text()='Plans']")
	public WebElement plansLink;
	
	@FindBy(xpath = "//a[text()='Payments']")
	public WebElement paymentsLink;
	
	@FindBy(xpath = "//a[text()='Settings']")
	public WebElement settingsLink;
	
	@FindBy(xpath = "//p[text()='CUSTOMER']")
	public WebElement userTypeInPrimary;
	
	@FindBy(xpath = "//p[text()='Mroi Shi']")
	public WebElement fullNameInPrimary;
	
	@FindBy(xpath = "//p[text()='mori123']")
	public WebElement usernameInPrimary;
}