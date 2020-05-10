Feature: Edit visit
  As an employee
  I want to edit customers (Pets)
  So that we can modify customer's data

  Scenario: Successfully edit visit details
    Given I am on the edit-visit form
    And   I enter valid data to edit the visit
    When  I submit the form
    Then  The updated pet's data will be displayed

  Scenario: Unsuccessfully edit visit details
    Given I am on the edit-visit form
    And   Provide an invalid visit date
    When  I submit the form
    Then  add visit button will be enabled but doesn't navigate

  Scenario: Leave all the fields empty
    Given I am on the edit-visit form
    And   I did not fill the visit form
    Then  add visit button will be enabled but doesn't navigate
