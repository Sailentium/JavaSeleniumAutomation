package tests.steps;

import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.open;

public class TestStepsFile {

    @When("^I visit (.*) site$")
    public void I_visit_xxx_site(String siteName) {
        open(siteName);
    }

}
