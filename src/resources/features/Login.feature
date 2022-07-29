Feature: Login

  Scenario: User should be able to see login form
    When I visit https://www.saucedemo.com/ site
    Then I should see logo on the login page
    And I should see following data on the login page:
      | userName | password |
      | empty    | empty    |


  Scenario Outline: User should be able to login with different accepted credentials
    When I visit https://www.saucedemo.com/ site
    Then I should see logo on the login page
    When I fill login page with next data:
      | userName   | password   |
      | <userName> | <password> |
    And I press Login button on the login page
    Then I should see Products page
    And I should not see logo on the login page

    Examples:
      | userName                | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |


  Scenario Outline: User should not be able to login with different not accepted credentials
    When I visit https://www.saucedemo.com/ site
    Then I should see logo on the login page
    When I fill login page with next data:
      | userName   | password   |
      | <userName> | <password> |
    And I press Login button on the login page
    Then I should see next '<errorMessage>' error message below password field on the login page

    Examples:
      | userName                | password       | errorMessage                                                              |
      | locked_out_user         | secret_sauce   | Epic sadface: Sorry, this user has been locked out.                       |
      | correct_password        | secret_sauce   | Epic sadface: Username and password do not match any user in this service |
      | standard_user           | 123456         | Epic sadface: Username and password do not match any user in this service |
      | problem_user            | sauce          | Epic sadface: Username and password do not match any user in this service |
      | performance_glitch_user | secret         | Epic sadface: Username and password do not match any user in this service |
      | full_wrong_credentials  | randomPassword | Epic sadface: Username and password do not match any user in this service |