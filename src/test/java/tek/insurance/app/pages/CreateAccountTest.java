package tek.insurance.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.insurance.app.base.BaseSetup;

public class CreateAccountTest extends BaseSetup {

	public CreateAccountTest() {
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

	@FindBy(xpath = "//button[text()='Reset Form']")
	public WebElement resetFormBttn;

}
