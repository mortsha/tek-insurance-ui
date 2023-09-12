package tek.insurance.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.insurance.app.base.BaseSetup;

public class CreateAccountTest extends BaseSetup{
	
	public CreateAccountTest() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath = "")
	public WebElement name;

}
