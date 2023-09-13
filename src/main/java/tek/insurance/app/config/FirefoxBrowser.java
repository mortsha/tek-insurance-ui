package tek.insurance.app.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxBrowser implements Browser {

	@Override
	public WebDriver openBrowser(String url) {
		FirefoxDriver driver = new FirefoxDriver();
		driver.get(url);
		return driver;
	}
	

}
