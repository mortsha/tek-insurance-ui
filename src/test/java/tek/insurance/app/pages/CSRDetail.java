package tek.insurance.app.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.insurance.app.base.BaseSetup;

public class CSRDetail extends BaseSetup {


	public CSRDetail() {
		PageFactory.initElements(getDriver(), this);
	}
	
	// Address
	
	@FindBy(xpath = "//button[contains(@class,'chakra-modal__close-btn')]")
	public WebElement closeBttn;
	
	@FindBy(xpath = "//table/tbody/tr/td[2]")
	public List<WebElement> emailAddressList;
	
	@FindBy(xpath = "//div[contains(@class,'chakra-stack')]//child::button[3]")
	public WebElement nextPageBttn;

	@FindBy(xpath = "//td[text()='mori1234@gmail.com']//following-sibling::td[5]//child::button")
	public WebElement detailBttn;
	
	@FindBy(xpath = "//button[text()='Mailing Address']")
	public WebElement mailingAddressSection;
	
	@FindBy(xpath = "//button[text()='Add Mailing Address']")
	public WebElement addMailingAddressBttn;
	
	@FindBy(xpath = "//header[text()='Add Address']")
	public WebElement addAddressTitle;
	
	@FindBy(id = "addressType")
	public WebElement addressTypeDropdown;
	
	@FindBy(id = "addressLine1")
	public WebElement addressLineField;
	
	@FindBy(id = "city")
	public WebElement cityField;
	
	@FindBy(id = "state")
	public WebElement stateField;
	
	@FindBy(id = "postalCode")
	public WebElement zipcodeField;
	
	@FindBy(xpath = "//button[text()='Submit']")
	public WebElement submitBttn;
	
	@FindBy(xpath = "//button[text()='Cancel']")
	public WebElement cancelAddressBttn;
	
	@FindBy(xpath = "//p[text()='Address:']//following-sibling::p[1]")
	public List<WebElement> addressValidateList;
	
//	@FindBy(xpath = "//button[@aria-label='delete address']")
	@FindBy(css = "button[aria-label='delete address']")
	public List<WebElement> deleteAdressList;
	
	@FindBy(css = "button[aria-label='delete address']")
	public WebElement deleteAdress;
	
	@FindBy(xpath = "//div[text()='WARNING']")
	public List<WebElement> warningList;
	
	@FindBy(xpath = "//button[text()='Confirm']")
	public WebElement confirmBttn;
	
	@FindBy(xpath = "//span[text()='Current']//following::button[1]")
	public WebElement deleteCurrentBttn;
	
//	@FindBy(xpath = "//div[text()='Delete address']")
	@FindBy(xpath = "//div[contains(text(),'Delete')]")
	public List<WebElement> deleteMessageList;
	
	@FindBy(xpath = "//div[contains(text(),'Delete')]//following::div[1]")
	public List<WebElement> descriptionDeleteMessageList;
	// Phones
	
	// following delete message
	// //div[text()='Delete address']//following::div[1]
	
	// delete list
	// //div[contains(text(),'Delete')]
	
	// following list description 
	// //div[contains(text(),'Delete')]//following::div[1]
	
	@FindBy(xpath = "//div[contains(@class,'chakra-tabs__tablist')]//child::button")
	public List<WebElement> scrSectionList;
	
	@FindBy(xpath = "//button[contains(@class,'chakra-button')]")
	public List<WebElement> addSectionList;
	
	@FindBy(xpath = "//header[contains(@class,'chakra-modal__header')]")
	public List<WebElement> headerSectionTextList;
	
	@FindBy(id = "phoneType")
	public WebElement phoneTypeDropdown;
	
	@FindBy(id = "phoneNumber")
	public WebElement phoneNumberField;
	
	@FindBy(id = "phoneExtension")
	public WebElement extentionField;
	
	@FindBy(id = "phoneTime")
	public WebElement timeDropdown;
	
	@FindBy(xpath = "//div[contains(@class,'chakra-stack')]//child::p[1]")
	public List<WebElement> ValidateSectionList;
	
	@FindBy(xpath = "//button[contains(@aria-label,'delete phone')]")
	public WebElement deletePhoneBttn;
	// Car
	
	@FindBy(id = "make")
	public WebElement makeField;
	@FindBy(id = "model")
	public WebElement modelField;
	@FindBy(id = "year")
	public WebElement yearField;
	@FindBy(id = "licensePlate")
	public WebElement licensePlateField;
	
	@FindBy(xpath = "//button[contains(@aria-label,'delete car')]")
	public WebElement deleteCarBttn;
	
}
