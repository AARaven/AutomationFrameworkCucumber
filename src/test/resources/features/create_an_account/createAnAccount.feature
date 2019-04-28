@account_creation
Feature: Create an account feature
  
  @nontag
  Scenario: Account creation
    
    Given I open login page
    When  I want to create a new account
    And   I fill required fields
    And   I click submit account creation
