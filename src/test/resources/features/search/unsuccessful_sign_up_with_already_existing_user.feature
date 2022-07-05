Feature: Sign Up with already existing user

  Scenario: Successful sign up
    Given I navigate to Demoblaze homepage
    And I click on Sign Up button
    And I fill in with already existing user credentials
      | username  | password |
      | ayshennew | test123  |
    When I click on Sign Up button on pop up
    Then I see an error message that this user already exists

