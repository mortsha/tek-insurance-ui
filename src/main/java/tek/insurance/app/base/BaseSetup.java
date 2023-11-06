package tek.insurance.app.base;

import java.sql.ResultSet;
import java.time.Duration;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import tek.insurance.app.config.Browser;
import tek.insurance.app.config.ChromeBrowser;
import tek.insurance.app.config.ChromeHeadless;
import tek.insurance.app.config.EdgeBrowser;
import tek.insurance.app.config.FirefoxBrowser;
import tek.insurance.app.utilities.ReadYamlFiles;

public class BaseSetup {

	private static WebDriver webDriver;
	private final ReadYamlFiles environmentVariables;
	public static Logger logger;
	private DatabaseConfig databaseConfig;

	public BaseSetup() {
		// need the path of the environment config and log4j and store them as String

		String filePath = System.getProperty("user.dir") + "/src/main/resources/env_config.yml";
		String log4jPath = System.getProperty("user.dir") + "/src/main/resources/log4j.properties";
		try {
			environmentVariables = ReadYamlFiles.getInstance(filePath);
		} catch (Exception e) {
			System.out.println("Failed to load env_config property. Check your filePath");
			throw new RuntimeException("Failed to load environment config file " + e.getMessage());
		}
		logger = logger.getLogger("logger_file");
		PropertyConfigurator.configure(log4jPath);
//		databaseConfig = new DatabaseConfig();
	}

	public WebDriver getDriver() {
		return webDriver;
	}

	public void setupBrowser() {
		HashMap uiProperty = environmentVariables.getYamlProperty("ui");
		String url = uiProperty.get("url").toString().toLowerCase();
		Browser browser;
		switch (uiProperty.get("browser").toString().toLowerCase()) {
		case "chrome":
			if ((boolean) uiProperty.get("headless")) {
				browser = new ChromeHeadless();
			} else {
				browser = new ChromeBrowser();
			}
			webDriver = browser.openBrowser(url);
			break;

		case "firefox":
			browser = new FirefoxBrowser();
			webDriver = browser.openBrowser(url);
			break;
		case "edge":
			browser = new EdgeBrowser();
			webDriver = browser.openBrowser(url);
			break;
		default:
			throw new RuntimeException("Browser name in config does not matched with any of the cases.");

		}

		webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		webDriver.manage().window().maximize();
	}

	public void setupDatabaseConnection() {
		databaseConfig.connectToDatabase();
	}

	public ResultSet runDatabaseQuery(String query) {
		return databaseConfig.runQuery(query);
	}
	public void closeDatabaseConnection() {
		if(databaseConfig != null) {
			databaseConfig.closeDatabaseConnection();
		}
	}

	public void quitBrowser() {
		if (webDriver != null)
			webDriver.quit();
	}
}
