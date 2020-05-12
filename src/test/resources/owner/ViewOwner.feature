Feature: View Owner
  As an employee
  I want to view customers'details (owners)
  So that we can track their personal details

  Scenario: Successfully view owner's details
    Given I am on the view-owners list on the owners page
    When  I click on the owner's name
    Then  Owner detail page will be displayed

  Scenario: Owner's details existent
    Given I am on the View-Owners Page
    When  I click on owner's name
    Then  Owner's details will be displayed