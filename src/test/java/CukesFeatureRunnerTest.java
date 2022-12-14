import com.codeborne.selenide.Configuration;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        plugin = {"pretty", "json:target/cucumber.json", "html:target/cucumber-report.html"},
        monochrome = true
)

public class CukesFeatureRunnerTest {
    @BeforeClass
    public static void executeBeforeTests() {
        Configuration.headless = true;
        Configuration.browserSize = "1600x900";
        WebDriverManager.chromedriver().setup();
    }

    @AfterClass
    public static void executeAfterTests() {
    }
}