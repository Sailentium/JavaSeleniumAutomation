package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.logging.LogType;

import java.util.List;
import java.util.logging.Level;

import static com.codeborne.selenide.Selenide.getWebDriverLogs;
import static com.codeborne.selenide.WebDriverRunner.*;
import static org.openqa.selenium.OutputType.BYTES;

public class Hooks {
    @Before
    public void testDataSetup() {

    }

    @After
    public void tearDown(Scenario scenario) {
        if (driver().hasWebDriverStarted()) {
            if (scenario.isFailed()) {
                TakesScreenshot camera = (TakesScreenshot) getWebDriver();
                byte[] screenshot = camera.getScreenshotAs(BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName());
                List<String> errors = getWebDriverLogs(LogType.BROWSER, Level.SEVERE);
                if (errors.size() > 0) {
                    System.out.println("**********************");
                    System.out.println(errors.size() + "Console errors detected!");
                    System.out.println("**********************");
                    StringBuilder logs = new StringBuilder("******* JavaScript Errors *******\n");
                    for (String error : errors) {
                        logs.append(error).append("\n");
                    }
                    System.out.println(logs);
                    scenario.attach(logs.toString(), "text/plain", scenario.getName());
                }
            }
            closeWebDriver();
        }
    }
}
