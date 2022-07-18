@web
Feature: Login

  Test log in functionality

  Scenario: Login with existing user
    Given I navigate to Demoblaze homepage
    And I click on Login button
    And I fill in existing user credentials
      | username  | password |
      | ayshennew | test123  |
    When I click on log in button on pop up
    Then  I should see a welcome message