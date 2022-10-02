@Products
Feature: Products

  Scenario: Standard User should be able to see correct numbers of products
    When I login with standard user
    Then I should see Products page
    And I should see 6 products on the Products page
    And I should see shopping cart element on the Products page
    And I should see products filter element on the Products page


  Scenario: Standard User should be able to filter products
    When I login with standard user
    Then I should see Products page
    And I should see 6 products on the Products page
    When I select 'Name (Z to A)' filter option on the Products page
    Then I should see 'Test.allTheThings() T-Shirt (Red)' first product name on the Products page
    And I should see 'Sauce Labs Backpack' last product name on the Products page
    When I select 'Name (A to Z)' filter option on the Products page
    Then I should see 'Sauce Labs Backpack' first product name on the Products page
    And I should see 'Test.allTheThings() T-Shirt (Red)' last product name on the Products page
    When I select 'Price (low to high)' filter option on the Products page
    Then I should see 'Sauce Labs Onesie' first product name on the Products page
    And I should see 'Sauce Labs Fleece Jacket' last product name on the Products page
    When I select 'Price (high to low)' filter option on the Products page
    Then I should see 'Sauce Labs Fleece Jacket' first product name on the Products page
    And I should see 'Sauce Labs Onesie' last product name on the Products page


  Scenario: Standard User should be able to add product to the cart
    When I login with standard user
    Then I should see Products page
    And I should see 6 products on the Products page
    When I add to cart 'Sauce Labs Backpack' product
    Then I should see cart badge element on the Products page
