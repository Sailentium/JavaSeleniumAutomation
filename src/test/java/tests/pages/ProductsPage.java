package tests.pages;

import org.openqa.selenium.By;

public class ProductsPage {
    public By pageTitleLocator = By.xpath("//span[text()='Products']");
    public By productItemLocator = By.cssSelector(".inventory_item");
    public By productsFilterItemLocator = By.cssSelector(".product_sort_container");
    public By shoppingCardItemLocator = By.cssSelector(".shopping_cart_link");
    public By filterOptionLocator = By.cssSelector(".product_sort_container");
    public By productItemNameLocator = By.cssSelector(".inventory_item_name");
    public By addToCartSauceLabsBackpackLocator = By.cssSelector("#add-to-cart-sauce-labs-backpack");
}
