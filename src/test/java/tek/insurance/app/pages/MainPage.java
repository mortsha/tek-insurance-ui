package tek.insurance.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.insurance.app.base.BaseSetup;

public class MainPage extends BaseSetup {
	
	public MainPage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//h2[text()='TEK Insurance App']")
	public WebElement tekInsuranceLink;
	
	@FindBy(xpath = "//h2[text()='Lets get you started']")
	public WebElement letGetStartedText;
	
	@FindBy(xpath = "//a[text()='Create Primary Account']")
	public WebElement createPrimaryAccountBttn;
}
