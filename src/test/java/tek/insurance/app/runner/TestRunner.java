package tek.insurance.app.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(
		tags = "@Lookup",
		features = ("classpath:features"),
		glue = "tek.insurance.app",
		dryRun = false,
		plugin = {
				"pretty",
				"html:target/htmlReports/cucumber-preety.html",
				"json:target/jsonReports/cucumber.json"
		},
		snippets = CAMELCASE,
		monochrome = true
		)



public class TestRunner {

}
