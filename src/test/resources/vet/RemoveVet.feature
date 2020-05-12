Feature: Remove Vet
  As an employee
  I want to remove a Veterinarian
  So that we can track their specialities

  Scenario: Successfully remove a vet
    Given I am on the vet-Information page
    When  I click on Delete vet button
    Then  The vet will be removed