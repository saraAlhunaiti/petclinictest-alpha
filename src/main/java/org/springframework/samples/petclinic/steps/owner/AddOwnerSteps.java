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
        System.setProperty("webdriver.chrome.driver", "/chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
    }

    private final WebDriver driver = new ChromeDriver();
    AddOwnerPage addOwnerPage = new AddOwnerPage(driver);
    private final static String ADD_OWNER_FORM_URL = "http://localhost:8081/petclinic/owners/add";
    private final static String ADD_PET_FORM_UR = "http://localhost:8081/petclinic/owners\n";


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
        assertTrue(addOwnerPage.areAllFieldsChecked());
        driver.close();
    }

    @Then("The submit button is disabled")
    public void theSubmitButtonIsDisabled() {
        assertTrue(addOwnerPage.isCurrent(ADD_OWNER_FORM_URL));
        ;
    }

    @When("I try to enter a single character into the name fields")
    public void iTryToEnterASingleCharacterIntoTheNameFields() {
        addOwnerPage.fillInNameFields();
    }

    @Then("I see a specific message for each field specifying that the field must be at least 2 chars long")
    public void validateMinLengthErrorMessage() {
        assertTrue(addOwnerPage.areNameFieldsShort());

    }

    @And("Each field has an x at the end")
    public void validateIncorrectInputErrorSymbol() {
        assertTrue(addOwnerPage.areNameFieldsUnchecked());
        driver.close();
    }

    @And("The field has an x at the end")
    public void validateIncorrectInputErrorSymbols() {
        assertTrue(addOwnerPage.isTelephoneFieldUnchecked());
        driver.close();
    }

    @And("I enter then remove values from each field")
    public void iEnterThenRemoveValuesFromEachField() {
        addOwnerPage.fillInForm();
        addOwnerPage.removeValues();
    }

    @And("I see a specific message for each field specifying that it is required")
    public void iSeeASpecificMessageForEachFieldSpecifyingThatItIsRequired() {
        assertTrue(addOwnerPage.areAllFieldsRequired());
    }

    @And("I enter a non-numeric value into the phone field")
    public void iEnterANonNumericValueIntoThePhoneField() {
        addOwnerPage.fillInWithInvalidTelephoneNum();
    }

    @And("I see an error message specifying that the phone number only accepts digits")
    public void iSeeAnErrorMessageSpecifyingThatThePhoneNumberOnlyAcceptsDigits() {
        assertTrue(addOwnerPage.isTelephoneFieldNumber());
    }

    @And("I enter symbols and numbers rather than words in all fields except the telephone no. field")
    public void iEnterSymbolsAndNumbersRatherThanWords() {
        addOwnerPage.fillInWithSymbols();
    }


    @And("All fields has an x at the end")
    public void allFieldsHasAnXAtTheEnd() {
        assertTrue(addOwnerPage.areAllFieldsUnchecked());
        driver.close();
    }


    @Then("The add owner button is disabled")
    public void theAddOwnerButtonIsDisabled() {
        assertTrue(addOwnerPage.isCurrent(ADD_PET_FORM_UR));
        driver.close();

    }
}
