Feature: Add Vet
  As an employee
  I want to add new Veterinarian
  So that we can track their specialities

  Scenario: Successfully enter vet data
    Given I am on the add-vet form
    And   I enter valid vet data
    When  I submit the vet form
    Then  Name fields will have a tick on the right

  Scenario: Short data
    Given I am on the add-vet form
    When  I try to enter a single character into the vet name fields
    Then  I see a specific message for each field specifying that the name fields must be at least 2 chars long
    And   Each field has x at the end

  Scenario: Remove values from all the fields
    Given I am on the add-vet form
    And   I enter then remove values from all fields
    Then  The submit button will be disabled
    And   I see a specific message for each field specifying it is required
    And   Each field has x at the end