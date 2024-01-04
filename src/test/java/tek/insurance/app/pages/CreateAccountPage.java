package tek.insurance.app.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.insurance.app.base.BaseSetup;

public class CreateAccountPage extends BaseSetup {

	public CreateAccountPage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//h2[text()='Create Primary Account Holder']")
	public WebElement createPrimaryAccountText;

	@FindBy(id = "email")
	public WebElement emailField;

	@FindBy(id = "title")
	public WebElement titleDropdown;

	@FindBy(id = "firstName")
	public WebElement firstNameField;

	@FindBy(id = "lastName")
	public WebElement lastNameField;

	@FindBy(id = "gender")
	public WebElement genderDropdown;

	@FindBy(id = "maritalStatus")
	public WebElement maritalStatusDropdown;

	@FindBy(id = "employmentStatus")
	public WebElement employmentStatusField;

	@FindBy(id = "dateOfBirth")
	public WebElement dateOfBirthField;

	@FindBy(xpath = "//button[text()='Create Account']")
	public WebElement createAccountBttn;

	@FindBy(xpath = "//button[text()='Clear Form']")
	public WebElement clearFormBttn;

	@FindBy(xpath = "//h2[text()='Sign up your account']")
	public WebElement signUpYourAccountLink;
	
	@FindBy(xpath = "//div[contains(@class,'chakra-stack ')]//following::h2")
	public List<WebElement> validateSingupOptions;
	
	@FindBy(xpath = "//div[@data-status='success' and @role='alert']")
	public WebElement successMessage; 
	
	@FindBy(id = "username")
	public WebElement userNameField;
	
	@FindBy(id = "password")
	public WebElement passwordField;
	
	@FindBy(id = "confirm")
	public WebElement confirmPassField;
	
	@FindBy(xpath = "//button[text()='Submit']")
	public WebElement submitBttn;
	
	@FindBy(xpath = "//div[contains(text(),'is exist')]")
	public WebElement errorAccountExist;
	
	@FindBy(xpath = "//h2[text()='Sign up your account']")
	public WebElement signupFormText;
	
	@FindBy(linkText = "register here")
	public WebElement registerHereBttn;
	
	// lookup
	
	@FindBy(id = "email")
	public WebElement emailLookup;
	
	@FindBy(id = "firstName")
	public WebElement firstnameLookup;
	
	@FindBy(id = "lastName")
	public WebElement lastNameLookup;
	
	@FindBy(id = "dateOfBirth")
	public WebElement dateOfBirthLookup;
	
	@FindBy(xpath = "//button[text()='Submit']")
	public WebElement submitLookup;
	
	@FindBy(id = "username")
	public WebElement userNameLookup;
	
	@FindBy(id = "password")
	public WebElement passowrdLookup;
	
	@FindBy(id = "confirm")
	public WebElement confirmPassLookup;
}
