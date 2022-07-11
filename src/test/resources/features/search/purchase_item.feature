@web
Feature: Buy item

  Scenario: Purchase item with new user
    Given I navigate to Demoblaze homepage
    And I click on Sign Up button
    And I fill in with valid username and password
    And I click on Sign Up button on pop up
    And I dismiss the successful sign up message
    And I click on Login button
    And I log in with the signed up user
    And I click on log in button on pop up
    And I should see a welcome message
    When I click on the product
    And I click on Add to Cart button
    And I dismiss the message
    And I click on Cart button
    And I click on Place order
    And I fill in mandatory information
      | name     | creditCard |
      | testuser | 123456789  |
    Then I click on Purchase button
    And I should see successful purchase message

    Scenario: Purchase item with already existing user
    Given I navigate to Demoblaze homepage
      And I click on Login button
      And I fill in existing user credentials
        | username  | password |
        | ayshennew | test123  |
      And I click on log in button on pop up
      When I click on the product
      And I click on Add to Cart button
      And I dismiss the message
      And I click on Cart button
      And I click on Place order
      And I fill in mandatory information
        | name     | creditCard |
        | testuser | 123456789  |
      Then I click on Purchase button
      And I should see successful purchase message
