Feature: Edit pet
  As an employee
  I want to edit customers (owners)
  So that we can modify customer's data

  Scenario: Successfully edit pet's details
    Given I am on the edit-pet form
    And   I enter valid pet-data
    When  I click on the update pet button
    Then  The updated pet's data will be displayed

  Scenario: Edit pet with symbols and numbers in the name field
    Given I am on the edit-pet form
    And   I enter symbols and numbers in name field
    When  I click on the update pet button
    Then  click Update-pet button is disabled

  Scenario: Unsuccessfully edit pet's birth date with invalid date
    Given I am on the edit-pet form
    And   I enter invalid birth-date
    When  I click on the update pet button
    Then  click Update-pet button is disabled

  Scenario: Leave all the fields empty
    Given I am on the edit-pet form
    And   I  remove values from each field
    When  I click on the update pet button
    Then  click Update-pet button is disabled
