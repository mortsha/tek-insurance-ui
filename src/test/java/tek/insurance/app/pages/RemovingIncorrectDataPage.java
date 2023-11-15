package tek.insurance.app.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.insurance.app.base.BaseSetup;

public class RemovingIncorrectDataPage extends BaseSetup{

	public RemovingIncorrectDataPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath = "//table/tbody/tr/td")
	public List<WebElement> dataFieldsList;
	
	@FindBy(xpath = "//table/tbody/tr/td[1]//child::button")
	public WebElement deleteAccountBttn;
}
