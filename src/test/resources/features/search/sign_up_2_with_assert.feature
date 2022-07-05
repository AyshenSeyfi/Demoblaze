Feature: Sign Up with assert

  Scenario: Successful sign up
    Given I navigate to Demoblaze homepage
    When I click on Sign Up button
    And I fill in with valid username and password
    And I click on Sign Up button on pop up
    Then I see the successful sign up message