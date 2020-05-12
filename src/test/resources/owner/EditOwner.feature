Feature: Edit Owner
  As an employee
  I want to edit customers (owners)
  So that we can modify customer's data

  Scenario: Successfully edit an owner's details
    Given I am on the edit-owner form
    When  I edit the owner's data with valid entries
    Then  The owner's data will be updated

  Scenario: Edit owner with symbols and numbers in key fields
    Given I am on the edit-owner form
    And   I update by entering symbols and numbers rather than words
    When  I update the form
    Then  The owner's data will be updated

  Scenario: Edit an owner with empty fields
    Given I am on the edit-owner form
    When  I remove data from the fields
    And   Each update field has an x at the end
    Then  I stay in edit-owner form