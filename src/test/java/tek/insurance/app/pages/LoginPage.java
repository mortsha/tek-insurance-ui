package tek.insurance.app.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.insurance.app.base.BaseSetup;

public class LoginPage extends BaseSetup {

	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(linkText = "Login")
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
	public WebElement cSRTitle;
	
	@FindBy(xpath = "//a[text()='Accounts']")
	public WebElement accountsSection;
	
	@FindBy(partialLinkText = "Dashboard")
	public WebElement dashboardSection;
	
	@FindBy(partialLinkText = "Request Quote")
	public WebElement requestQuoteSection;
	
	@FindBy(partialLinkText = "Plans")
	public WebElement plansSection;
	
	@FindBy(partialLinkText = "Payments")
	public WebElement paymentsSection;
	
	@FindBy(partialLinkText = "Settings")
	public WebElement settingsSection;
	
	@FindBy(xpath = "//button[@type='button']")
	public WebElement profileBttn;

	@FindBy(xpath = "//button[text()='Logout']")
	public WebElement profileLogoutBttn;
	
	// scenario second: login to primary account portal
	
	@FindBy(xpath = "//h2[text()='Primary Account Portal']")
	public WebElement primaryAccountPortal;
	
	@FindBy(xpath = "//p[text()='User Type']//following-sibling::p")
	public WebElement profileUserType;
	
	@FindBy(xpath = "//p[text()='Name']//following-sibling::p")
	public WebElement profileFullName;
	
	@FindBy(xpath = "//p[text()='Username']//following-sibling::p")
	public WebElement profileUsername;
	
	// negative testing
	
	@FindBy(xpath = "//div[@data-status='error' and @role='alert']")
	public WebElement errorMessage;
	
	
	
}
