Feature: Add Visit
  As an employee
  I want to add a visit to a pet
  So that we can track their visits


  Scenario: Successfully add an new visit
    Given I am on the page of Owner Information
    When   I click on Add Visit button
    Given  I am on the add-visit form
    And    I enter valid visit data
    When   I submit the form
    Then  The new visit details will be displayed on Owner-Information page

  Scenario: Unsuccessfully add an new visit
    Given I am on the page of Owner Information
    When  I click on Add Visit button
    Given I am on the add-visit form
    And   I Provide an invalid visit date
    When  I submit the add-visit form
    Then  I stay in add visit form

  Scenario: Leave all the fields empty
    Given I am on the page of Owner Information
    When  I click on Add Visit button
    Given I am on the add-visit form
    And   I leave all the fields empty
    When  I submit the add-visit form
    Then  I stay in add visit form

  Scenario: Enter valid visit date and leave description filed empty
    Given I am on the page of Owner Information
    When  I click on Add Visit button
    Given I am on the add-visit form
    And   I provide valid visit data
    And   I leave the description field empty
    When  I submit the add-visit form
    Then  I stay in add visit form

  Scenario: Exceed the maximum allowed characters in the description field
    Given I am on the page of Owner Information
    When  I click on Add Visit button
    Given I am on the add-visit form
    And   I enter characters exceed the limit
    When  I submit the add-visit form
    Then  I stay in add visit form
