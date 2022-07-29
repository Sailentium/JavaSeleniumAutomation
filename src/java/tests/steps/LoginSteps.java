package tests.steps;

import com.codeborne.selenide.Condition;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import tests.pages.LoginPage;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$;

public class LoginSteps {
    @Then("^I (.*) see logo on the login page$")
    public void I_xxx_see_logo_on_the_login_page(String state) {
        LoginPage loginPage = new LoginPage();
        Condition condition = state.equalsIgnoreCase("should not") ? Condition.hidden : Condition.visible;
        $(loginPage.logoFieldLocator).shouldHave(condition);
    }

    @When("^I fill login page with next data:$")
    public void I_fill_login_page_with_next_data(DataTable loginDataTable) {
        LoginPage loginPage = new LoginPage();
        List<Map<String, String>> rows = loginDataTable.asMaps(String.class, String.class);
        for (Map<String, String> loginData : rows) {
            if (loginData.containsKey("userName")) {
                $(loginPage.userNameInputLocator).sendKeys(Keys.CONTROL + "A");
                $(loginPage.userNameInputLocator).sendKeys(Keys.BACK_SPACE);
                $(loginPage.userNameInputLocator).sendKeys(loginData.get("userName"));
            }
            if (loginData.containsKey("password")) {
                $(loginPage.passwordInputLocator).sendKeys(Keys.CONTROL + "A");
                $(loginPage.passwordInputLocator).sendKeys(Keys.BACK_SPACE);
                $(loginPage.passwordInputLocator).sendKeys(loginData.get("password"));
            }
        }
    }

    @And("^I should see following data on the login page:$")
    public void I_should_see_following_data_on_the_login_page(DataTable loginDataTable) {
        LoginPage loginPage = new LoginPage();
        List<Map<String, String>> rows = loginDataTable.asMaps(String.class, String.class);
        for (Map<String, String> loginData : rows) {
            if (loginData.containsKey("userName")) {
                if (loginData.get("userName").equalsIgnoreCase("empty")) {
                    $(loginPage.userNameInputLocator).shouldHave(Condition.empty);
                } else {
                    $(loginPage.userNameInputLocator).shouldHave(Condition.exactText(loginData.get("userName")));
                }
            }
            if (loginData.containsKey("password")) {
                if (loginData.get("password").equalsIgnoreCase("empty")) {
                    $(loginPage.passwordInputLocator).shouldHave(Condition.empty);
                } else {
                    $(loginPage.passwordInputLocator).shouldHave(Condition.exactText(loginData.get("password")));
                }
            }
        }
    }

    @And("^I press Login button on the login page$")
    public void I_press_login_button_on_the_login_page() {
        LoginPage loginPage = new LoginPage();
        $(loginPage.loginButtonLocator).click();
    }

    @Then("^I should see next '(.*)' error message below password field on the login page$")
    public void iShouldSeeNextErrorMessageBelowPasswordFieldOnTheLoginPage(String errorMessage) {
        LoginPage loginPage = new LoginPage();
        $(loginPage.errorMessageFieldLocator).shouldHave(Condition.exactText(errorMessage));
    }
}
