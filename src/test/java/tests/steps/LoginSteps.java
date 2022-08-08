package tests.steps;

import com.codeborne.selenide.Condition;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.pages.LoginPage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

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
            loginPage.fillLoginFrom(loginData);
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
    public void I_should_see_next_xxx_error_message_below_password_field_on_the_login_page(String errorMessage) {
        LoginPage loginPage = new LoginPage();
        $(loginPage.errorMessageFieldLocator).shouldHave(Condition.exactText(errorMessage));
    }

    @When("^I login with standard user$")
    public void I_login_with_standard_user() {
        LoginPage loginPage = new LoginPage();
        open("https://www.saucedemo.com/");
        Map<String, String> standard_user = new HashMap<>();
        standard_user.put("userName", "standard_user");
        standard_user.put("password", "secret_sauce");
        loginPage.fillLoginFrom(standard_user);
        $(loginPage.loginButtonLocator).click();
    }
}
