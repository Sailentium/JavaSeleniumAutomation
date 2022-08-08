Feature: Products

  Scenario: Standard User should be able to see correct numbers of products
    When I login with standard user
    Then I should see Products page
    And I should see 6 products on the Products page
    And I should see shopping cart element on the Products page
    And I should see products filter element on the Products page


