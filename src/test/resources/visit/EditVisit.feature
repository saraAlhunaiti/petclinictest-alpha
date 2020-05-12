Feature: Edit visit
  As an employee
  I want to edit customers (Pets)
  So that we can modify customer's data

  Scenario: Successfully edit visit details
    Given I am on the page of Owner Information
    When  I click on Edit Visit button
    Given I am on the edit-visit form
    And   I enter valid data to edit the visit
    When  I submit the edit-visit form
    Then  The updated visit's data will be displayed

  Scenario: Unsuccessfully edit visit details
    Given I am on the page of Owner Information
    When  I click on Edit Visit button
    Given I am on the edit-visit form
    And   I Provide an invalid visit date
    When  I submit the edit-visit form
    Then  I stay in edit visit form

  Scenario: Leave all the fields empty
    Given I am on the page of Owner Information
    When  I click on Edit Visit button
    Given I am on the edit-visit form
    And   I did not fill the visit form
    When  I submit the edit-visit form
    Then  I stay in edit visit form

  Scenario: Exceed the maximum allowed characters in the description field
    Given I am on the page of Owner Information
    When  I click on Edit Visit button
    Given I am on the edit-visit form
    And   I edit the description filed with characters that exceed the limit
    When  I submit the edit-visit form
    Then  I stay in edit visit form