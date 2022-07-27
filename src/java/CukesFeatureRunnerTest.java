import helpers.Common;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import com.codeborne.selenide.Configuration;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/resources/features/Test.feature"},
        monochrome = true
)

public class CukesFeatureRunnerTest {
    @BeforeClass
    public static void executeBeforeTests() {
        Configuration.headless = true;
        Configuration.browserSize = "1600x900";
        WebDriverManager.chromedriver().driverVersion(Common.getChromeVersion()).setup();
    }

    @AfterClass
    public static void executeAfterTests() {
    }
}