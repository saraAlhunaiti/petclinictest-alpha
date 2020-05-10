Feature: Add Visit
  As an employee
  I want to add a visit to a pet
  So that we can track their visits


  Scenario: Successfully add an new visit
    Given I am on the add-visit form
    And   I enter valid visit data
    When  I submit the form
    Then  The new visit details will be displayed on Owner-Information page

  Scenario: Unsuccessfully add an new visit
    Given I am on the add-visit form
    And   Provide an invalid birth date for Visit
    When  I click on the save Visit button
    Then  add visit button will be enabled but doesn't navigate

  Scenario: Leave all the fields empty
    Given I am on the add-visit form
    And   I leave all the fields empty
    Then  add visit button will be enabled but doesn't navigate
