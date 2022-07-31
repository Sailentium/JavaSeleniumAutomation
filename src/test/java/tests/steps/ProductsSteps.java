package tests.steps;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.Then;
import tests.pages.ProductsPage;

import static com.codeborne.selenide.Selenide.$;

public class ProductsSteps {
    @Then("^I (.*) see Products page$")
    public void I_Xxx_see_products_page(String state) {
        ProductsPage productsPage = new ProductsPage();
        Condition condition = state.equalsIgnoreCase("should") ? Condition.visible : Condition.hidden;
        $(productsPage.pageTitleLocator).shouldHave(condition);
    }
}
