Feature: Remove visit
  As an employee
  I Remove A visit
  So that we can Delete customer's Pet's visit

  Scenario: Successfully remove a visit
    Given I am on the Owner-Information page to Delete visit
    When  I click on Delete Visit button
    Then  The visit will be removed