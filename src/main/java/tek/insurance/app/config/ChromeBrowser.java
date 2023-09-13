package tek.insurance.app.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowser implements Browser {

	@Override
	public WebDriver openBrowser(String url) {
		ChromeDriver driver = new ChromeDriver();
		driver.get(url);
		return driver;
	}

}
