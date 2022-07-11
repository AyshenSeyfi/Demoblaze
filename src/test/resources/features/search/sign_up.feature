@web
Feature: Sign Up

  Scenario: Successful sign up
    Given I navigate to Demoblaze homepage
    When I click on Sign Up button
    And I fill in with valid username and password
    And I click on Sign Up button on pop up
    And I dismiss the successful sign up message
    Then I click on Login button
    And I log in with the signed up user
    And I click on log in button on pop up
    And  I should see a welcome message