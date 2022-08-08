package tests.steps;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import tests.pages.ProductsPage;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProductsSteps {
    @Then("^I (.*) see Products page$")
    public void I_xxx_see_products_page(String state) {
        ProductsPage productsPage = new ProductsPage();
        Condition condition = state.equalsIgnoreCase("should") ? Condition.visible : Condition.hidden;
        $(productsPage.pageTitleLocator).shouldHave(condition);
    }

    @And("^I should see (.*) products on the Products page$")
    public void I_should_see_xxx_products_on_the_Products_page(int numberOfProducts) {
        ProductsPage productsPage = new ProductsPage();
        $$(productsPage.productItemLocator).shouldHave(size(numberOfProducts));
    }

    @And("^I (.*) see (.*) element on the Products page$")
    public void I_xxx_see_xxx_element_on_the_Products_page(String state, String elementName) {
        ProductsPage productsPage = new ProductsPage();
        Condition expectedCondition = state.equalsIgnoreCase("should") ? Condition.visible : Condition.hidden;
        if (elementName.equalsIgnoreCase("shopping cart")) {
            $(productsPage.shoppingCardItemLocator).shouldHave(expectedCondition);
        } else if (elementName.equalsIgnoreCase("products filter")) {
            $(productsPage.productsFilterItemLocator).shouldHave(expectedCondition);
        } else
            throw new IllegalArgumentException(String.format("Wrong element name - %s", elementName));
    }
}
