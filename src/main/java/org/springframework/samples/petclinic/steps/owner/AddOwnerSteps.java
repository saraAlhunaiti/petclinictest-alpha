package org.springframework.samples.petclinic.steps.owner;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.samples.petclinic.pages.AddOwnerPage;

import java.util.logging.Level;

import static java.util.logging.Logger.getLogger;
import static org.junit.Assert.assertTrue;


public class AddOwnerSteps {
    static {
        System.setProperty("webdriver.chrome.driver", "/Users/chromedriver");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
    }

    private final WebDriver driver = new ChromeDriver();
    AddOwnerPage addOwnerPage = new AddOwnerPage(driver);

    @Given("I am on the add-owner form")
    public void iAmOnTheAddOwnerForm() {
        addOwnerPage.addOwnerForm();
    }

    @When("I enter valid owner data")
    public void iEnterValidData() {
        addOwnerPage.fillInForm();
    }

    @When("I submit the form")
    public void iSubmitTheForm() {
        addOwnerPage.submit();
    }

    @Then("Each field will have a tick on the right")
    public void eachFieldWillHaveATickOnTheRight() {
        assertTrue(addOwnerPage.checkedFields());
    }

    @Then("The submit button is disabled")
    public void theSubmitButtonIsDisabled() {
    }

    @When("I try to enter a single character into the name fields")
    public void iTryToEnterASingleCharacterIntoTheNameFields() {
        addOwnerPage.fillInNameFields();
    }

    @Then("I see a specific message for each field specifying that the field must be at least 2 chars long")
    public void validateMinLengthErrorMessage() {
        assertTrue(addOwnerPage.nameFieldsTextErrors());

    }

    @And("Each field has an x at the end")
    public void validateIncorrectInputErrorSymbol() {
        assertTrue(addOwnerPage.nameFieldsCrossError());
    }

    @And("The field has an x at the end")
    public void validateIncorrectInputErrorSymbols() {
    }

    @And("I enter then remove values from each field")
    public void iEnterThenRemoveValuesFromEachField() {
        addOwnerPage.fillInForm();
        addOwnerPage.removeValues();
    }

    @And("I see a specific message for each field specifying that it is required")
    public void iSeeASpecificMessageForEachFieldSpecifyingThatItIsRequired() {
        assertTrue(addOwnerPage.AllFieldsTextErrors());
    }

    @And("I enter a non-numeric value into the phone field")
    public void iEnterANonNumericValueIntoThePhoneField() {
        addOwnerPage.fillInWithInvalidTelephoneNum();
    }

    @And("I see an error message specifying that the phone number only accepts digits")
    public void iSeeAnErrorMessageSpecifyingThatThePhoneNumberOnlyAcceptsDigits() {
    }

    @And("I enter symbols and numbers rather than words in all fields except the telephone no. field")
    public void iEnterSymbolsAndNumbersRatherThanWords() {
        addOwnerPage.fillInWithSymbols();
    }


    @When("I add another owner with duplicate details")
    public void iAddAnotherOwnerWithDuplicateDetails(){
        addOwnerPage.addOwnerForm();
        addOwnerPage.fillInForm();
        addOwnerPage.submit();
    }

    @Then("The new owner will be added to the owner's list")
    public void theNewOwnerWillBeAddedToTheOwnerSList() {
        assertTrue(addOwnerPage.checkOwnerIsAdded());
    }

    @And("All fields has an x at the end")
    public void allFieldsHasAnXAtTheEnd() {
        assertTrue(addOwnerPage.allFieldsCrossError());
    }
}
