package tek.insurance.app.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.insurance.app.base.BaseSetup;

public class CSRPlans extends BaseSetup{
	
	public CSRPlans () {
		PageFactory.initElements(getDriver(), this);
	}
	// Plans
	@FindBy(xpath = "//h2[contains(text(),'Plans Price')]")
	public WebElement todaysPlansPriceText;
	
	@FindBy(xpath = "//td[text()='Motorcycle']")
	public WebElement motorcyleText;
	
	@FindBy(xpath = "//td[text()='Boat']")
	public WebElement boatText;
	
	@FindBy(xpath = "//td[text()='Renters']")
	public WebElement rentersText;
	
	@FindBy(xpath = "//td[text()='Auto']")
	public WebElement autoText;
	
	@FindBy(xpath = "//table/tbody/tr/td[4]")
	public List<WebElement> createdDateList;
	
	@FindBy(xpath = "//table/tbody/tr/td[5]")
	public List<WebElement> expiredDateList;
	
	@FindBy(xpath = "//table/tbody/tr/td[2]")
	public List<WebElement> planTypeDateList;
	
}
