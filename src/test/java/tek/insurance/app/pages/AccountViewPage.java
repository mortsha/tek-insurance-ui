package tek.insurance.app.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.insurance.app.base.BaseSetup;

public class AccountViewPage extends BaseSetup {

	public AccountViewPage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//h2[text()='Primary Accounts']")
	public WebElement primaryAccountsText;

	@FindBy(xpath = "//table/tbody/tr")
	public List<WebElement> tableRowList;

	@FindBy(xpath = "//div[contains(@class,'chakra-stack')]//child::button[3]")
	public WebElement nextBttn;
	
	@FindBy(xpath = "//p[contains(text(),'Page')]")
	public WebElement totalPages;
	
	@FindBy(xpath = "//select[contains(@class,'chakra-select')]")
	public WebElement showDropdown;
	
	@FindBy(xpath = "//a[contains(@class,'chakra-button')and contains(@aria-label,'AddPrimaryAccount')]")
	public WebElement createAccountBttnInPrimaryAccoutn;
	
}
