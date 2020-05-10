Feature: Add Pet
  As an employee
  I want to add new pet
  So that we can track their visits


  Scenario: Successfully add an new pet
    Given I am on the add-pet form
    And   I enter valid pet data
    When  I submit add-Pet form
    Then  The new pet will be displayed under pets and visits beneath its owner

  Scenario: Unsuccessfully add an new pet
    Given I am on the add-pet form
    And   I enter invalid pet data
    When  I click on the save pet button
    Then  The the button will be enabled but doesn't navigate

  Scenario: Create pet with symbols and numbers in Name field
    Given I am on the add-pet form
    And   I enter symbols and numbers rather than words in the name field
    When  I submit the form
    Then  The new pet will be displayed under pets and visits beneath its owner

    Scenario: Try to Create Pet invalid birth date
      Given I am on the add-pet form
      And   Provide an invalid birth date
      When  I submit the form
      Then  The the button will be enabled but doesn't navigate

  Scenario: Leave all the fields empty
    Given I am on the add-pet form
    And   try to add pet without filling in the fields
    Then  The the button will be enabled but doesn't navigate

