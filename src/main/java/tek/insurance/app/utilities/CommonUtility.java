package tek.insurance.app.utilities;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import tek.insurance.app.base.BaseSetup;

public class CommonUtility extends BaseSetup {

	public static boolean recordsMatchList4(List<HashMap<String, String>> uiRecords,
			List<HashMap<String, Object>> dbRecords) {
		int counterUI = 0;
		int counterDB = 0;
		boolean recordsMatch = true;
		for (HashMap<String, String> uiRec : uiRecords) {
			if (!dbRecords.contains(uiRec)) {
				System.err.println("Record mismatch in UI: " + uiRec);
				counterUI++;
				recordsMatch = false;
			}
		}
		for (HashMap<String, Object> dbRec : dbRecords) {
			if (!uiRecords.contains(dbRec)) {
				System.err.println("Record mismatch in DB: " + dbRec);
				counterDB++;
				recordsMatch = false;
			}
		}
		System.out.println("Total UI Record mismatch: " + counterUI);
		System.out.println("Total DB Record mismatch: " + counterDB);
		return recordsMatch;
	}

	public boolean recordsMatchList2(List<HashMap<String, String>> uiRecords, List<HashMap<String, Object>> dbRecords) {
		if (uiRecords.size() != dbRecords.size()) {
			return false;
		}
		for (int i = 0; i < uiRecords.size(); i++) {
			HashMap<String, String> uiRecord = uiRecords.get(i);
			HashMap<String, Object> dbRecord = dbRecords.get(i);

			if (!uiRecord.equals(dbRecord)) {
				return false;

			}
		}
		return true;
	}

	public boolean sizeListMatch(List<HashMap<String, String>> uiRecords, List<HashMap<String, Object>> dbRecords) {
		if (uiRecords.size() != dbRecords.size()) {
			return false;
		}
		return true;
	}

	public static boolean recordsMatchsList(List<HashMap<String, String>> uiRecords,
			List<HashMap<String, Object>> dbRecords) {
		if (uiRecords.size() != dbRecords.size()) {
//			System.out.println("The size of the lists are not equal.");
			return false;
		}
		for (HashMap<String, String> ui : uiRecords) {
			boolean foundMatch = false;

			for (HashMap<String, Object> db : dbRecords) {
				if (mapEquals(ui, db)) {
					foundMatch = true;
					break;
				}
			}
			if (!foundMatch) {
				return false;
			}
		}
		return true;
	}

	private static boolean mapEquals(Map<String, String> map1, Map<String, Object> map2) {
		if (map1.size() != map2.size()) {
//			System.out.println("Maps sizes are not equal.");
			return false;
		}

		for (Map.Entry<String, String> entry : map1.entrySet()) {
			String key = entry.getKey();
			String value1 = entry.getValue();
			Object value2 = map2.get(key);

			if (!value1.equals(value2)) {
				return false;
			}
		}
		return true;
	}

	public static String capitalizeFirstLetter(String input) {
		if (input == null) {
			return input;
		}
		return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
	}

	public static String dateFormatted(String inputDate) {
		if (inputDate == null || inputDate.isEmpty()) {
			return "Date is null or empty";
		}
		try {
			DateTimeFormatter inputFormatWithMillis = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
			LocalDateTime dateWithMillis = LocalDateTime.parse(inputDate, inputFormatWithMillis);
			DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("MMMM d, yyyy");
			return dateWithMillis.format(outputFormat);
		} catch (DateTimeParseException e) {
			// Parsing with milliseconds failed, try without milliseconds
			try {
				DateTimeFormatter inputFormatWithoutMillis = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				LocalDateTime dateWithoutMillis = LocalDateTime.parse(inputDate, inputFormatWithoutMillis);
				DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("MMMM d, yyyy");
				return dateWithoutMillis.format(outputFormat);
			} catch (DateTimeParseException ex) {
				return "Invalid date format";
			}
		}
	}

	public static void print(String string) {
		System.out.println(string);
	}

	public void loggerActualAndExpected(String actual, String expected) {
		logger.info("The actual: " + actual + " and expected: " + expected + " was same - process passed");

	}

	public WebElement findElementByCustomXPath(String customXPath) {
		return getDriver().findElement(By.xpath(customXPath));
	}
	public WebElement findElementWithBy(By locator) {
		return getDriver().findElement(locator);
	}
	public List<WebElement> findElementsWithBy(By locator){
		return getDriver().findElements(locator);
	}

	public void refresh() {
		getDriver().navigate().refresh();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
	}

	public static void implicitlyAndPageWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
	}

	public WebDriverWait getWait() {
		return new WebDriverWait(getDriver(), Duration.ofSeconds(20));
	}

	public WebElement waitTillClickable(WebElement element) {
		return this.getWait().until(ExpectedConditions.elementToBeClickable(element));
	}

	public WebElement waitTillClickable(By by) {
		return this.getWait().until(ExpectedConditions.elementToBeClickable(by));
	}

	public WebElement waitTillPresence(WebElement element) {
		return this.getWait().until(ExpectedConditions.visibilityOf(element));
	}

	public List<WebElement> waitTillPrecenseElements(List<WebElement> elements) {
		return this.getWait().until(ExpectedConditions.visibilityOfAllElements(elements));
	}
	public List<WebElement> waitTillPrecenseElements(By locator){
		return this.getWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	public WebElement waitTillPresence(By by) {
		return this.getWait().until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void click(WebElement element) {
		this.waitTillClickable(element).click();
	}

	public void click(By by) {
		this.waitTillClickable(by).click();
	}

	public void sendText(WebElement element, String value) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].value=''", element);
		this.waitTillPresence(element).sendKeys(value);
	}

	public String getElementText(WebElement element) {
		return this.waitTillPresence(element).getText();
	}

	public byte[] takeScreenShotAsBytes() {
		return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
	}

	public void sendText(By by, String value) {
		this.waitTillPresence(by).sendKeys(value);
	}

	public String getElementText(By by) {
		return this.waitTillPresence(by).getText();
	}

	public String getTitle() {
		String title = getDriver().getTitle();
		return title;
	}

	public void sendValueUsingJS(WebElement ele, String value) {
		JavascriptExecutor executor = ((JavascriptExecutor) getDriver());
		executor.executeScript("arguments[0].value='" + value + "';", ele);
	}

	public void clearTextUsingSendKeys(WebElement toClear) {
		toClear.sendKeys(Keys.CONTROL + "a");
		toClear.sendKeys(Keys.DELETE);
	}

	public void selectByIndex(WebElement ele, int index) {
		Select select = new Select(ele);
		select.selectByIndex(index);
	}

	public void selectByValue(WebElement ele, String value) {
		Select select = new Select(ele);
		select.selectByValue(value);

	}

	public void selectByVisibleText(WebElement ele, String visibleText) {
		Select select = new Select(ele);
		select.selectByVisibleText(visibleText);

	}

	public void deselectByIndex(WebElement ele, int index) {
		Select deselect = new Select(ele);
		deselect.deselectByIndex(index);
	}

	public void deselectByValue(WebElement ele, String value) {
		Select deselect = new Select(ele);
		deselect.deselectByValue(value);
	}

	public void deselectByVisibleText(WebElement ele, String visibleText) {
		Select deselect = new Select(ele);
		deselect.deselectByVisibleText(visibleText);
	}

	public String getAttribute(WebElement ele, String Value) {
		String attribute = ele.getAttribute(Value);
		return attribute;
	}

	public String getTagname(WebElement ele) {
		return ele.getTagName();
	}

	public String getText(WebElement ele) {
		String text = ele.getText();
		return text;
	}

	public String getText(By by) {
		WebElement element = getDriver().findElement(by);
		String text = element.getText();
		return text;
	}

	public void HighlightElement(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].style.border='3px solid red'", ele);
		js.executeScript("arguments[0].style.border='1px white'", ele);
	}

	public void dragAndDropAction(WebElement elementToHover, WebElement elementToClick) {
		Actions action = new Actions(getDriver());
		action.dragAndDrop(elementToHover, elementToClick).build().perform();
	}

	public boolean isElementDisplayed(WebElement ele) {
		if (ele.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isElementDisplayed(By by) {
		try {
			return getDriver().findElement(by).isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	public boolean isElementDisplayed(String xpathExpression) {
		return isElementDisplayed(By.xpath(xpathExpression));
	}

	public boolean isElementEnabled(WebElement ele) {
		if (ele.isEnabled()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isElementSelected(WebElement ele) {
		if (ele.isSelected()) {
			return true;
		} else {
			return false;
		}
	}

	public void moveToElementAction(WebElement ele) {
		Actions actions = new Actions(getDriver());
		actions.moveToElement(ele);
		actions.build().perform();
	}

	public WebElement fluientWaitforElement(WebElement element, int timoutSec, int pollingSec) {
		FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(getDriver()).withTimeout(Duration.ofSeconds(timoutSec))
				.pollingEvery(Duration.ofSeconds(pollingSec))
				.ignoring(NoSuchElementException.class, TimeoutException.class)
				.ignoring(StaleElementReferenceException.class);
		for (int i = 0; i < 2; i++)
			fWait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}

	public void switchwindow(String pageTitle) {
		String currentWindow = getDriver().getWindowHandle();
		Set<String> handles = getDriver().getWindowHandles();
		for (String winHandle : handles) {
			String currentWindowTitle = getDriver().switchTo().window(winHandle).getTitle();

			if (currentWindowTitle.equals(pageTitle)) {
				break;
			} else {
				getDriver().switchTo().window(currentWindow);
			}
		}
	}

	public void selectCalendarDateWithJS(String date, WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) getDriver());
		js.executeScript("arguments[0].setAttribute('value','" + date + "');", element);

	}

	public void clickElementWithJS(WebElement element) {

		JavascriptExecutor js = ((JavascriptExecutor) getDriver());
		js.executeScript("arguments[0].click();", element);

	}

	public void scrollPageDownWithJS() {

		JavascriptExecutor js = ((JavascriptExecutor) getDriver());
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

	}

	public void slowDown() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
