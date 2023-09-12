package tek.insurance.app.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeHeadless implements Browser{

	@Override
	public WebDriver openBrowser(String url) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("headless");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		return driver;
	}

}
