package tek.insurance.app.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeHeadless implements Browser{

	@Override
	public WebDriver openBrowser(String url) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("headless");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get(url);
		return driver;
	}

}
