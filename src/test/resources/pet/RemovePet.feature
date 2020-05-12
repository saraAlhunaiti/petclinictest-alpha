Feature: Remove pet
  As an employee
  I Remove A pet
  So that we can Delete customer's Pet

  Scenario: Successfully remove a pet
    Given I am on the Owner-Information page
    When  I click on Delete Pet button
    Then  The Pet will be removed