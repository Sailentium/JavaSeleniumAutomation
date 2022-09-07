@ReqresAPI
Feature: ReqresAPI


  Scenario: Should be able to register and login user with API
    Given I register user with following data to the reqres service:
      | email              | password |
      | eve.holt@reqres.in | pistol   |
    Then I should have 200 status code for the previous api request
    And I should have following data in the response body for the previous api request:
      | id | token             |
      | 4  | QpwL5tke4Pnpja7X4 |
    When I login as user to the reqres service:
      | email              | password |
      | eve.holt@reqres.in | pistol   |
    Then I should have 200 status code for the previous api request
