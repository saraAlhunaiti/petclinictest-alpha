Feature: View vets
  As an employee
  I want to view Veterinarians'details (vet)
  So that we can track their personal details

  Scenario: Successfully view vet's details
    Given I am on the Home page
    When  I click on all from Veterinarians drop-down list
    Then  vets list page will be displayed