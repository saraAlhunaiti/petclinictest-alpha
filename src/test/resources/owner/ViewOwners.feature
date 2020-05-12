Feature: View Owners
  As an employee
  I want to view customers'details (owners)
  So that we can track their personal details

  Scenario: Successfully view owner's details
    Given I am on the home page
    When  I click on all from owners drop-down list
    Then  Owners list page will be displayed

  Scenario: Owner's details existent
    Given I am on the home Pagee
    When  I click on all from owners list
    Then  Owners's details will be displayed