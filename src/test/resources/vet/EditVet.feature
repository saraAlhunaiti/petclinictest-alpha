Feature: Edit Vet
  As an employee
  I want to edit Veterinarian (vet)
  So that we can modify customer's data

  Scenario: Successfully edit a vet's name
    Given I am on the edit-vet form
    When  I edit the vet's name with valid entries
    Then  The vet's name will be updated

  Scenario: Edit vet with symbols and numbers in key fields
    Given I am on the edit-vet form
    And   I update vet by entering symbols and numbers rather than words
    When  I update Vet form
    Then  The vet's name will be updated

  Scenario: Edit a vet with empty fields
    Given I am on the edit-vet form
    When  I remove vet data from the fields
    And   Each update field has an x at the end
    Then  I stay in edit-Vet form