package org.springframework.samples.petclinic.steps.vet;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.samples.petclinic.pages.AddVetPage;

import java.util.logging.Level;

import static java.util.logging.Logger.getLogger;
import static org.junit.Assert.assertTrue;

public class AddVetSteps {
    private static final String ADD_VET_FORM_URL = "http://localhost:8081/petclinic/vets/add";

    static {
        System.setProperty("webdriver.chrome.driver", "/chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
    }

    private final WebDriver driver = new ChromeDriver();
    AddVetPage addVetPage = new AddVetPage(driver);

    @Given("I am on the add-vet form")
    public void iAmOnTheAddVetForm() {
        addVetPage.addVetForm();
    }

    @And("I enter valid vet data")
    public void iEnterValidVetData() {
        addVetPage.fillInForm();
    }

    @When("I submit the vet form")
    public void iSubmitTheVetForm() {
        addVetPage.submit();
    }


    @When("I try to enter a single character into the vet name fields")
    public void iTryToEnterASingleCharacterIntoTheVetNameFields() {
        addVetPage.fillInNameFields();
    }

    @Then("I see a specific message for each field specifying that the name fields must be at least {int} chars long")
    public void iSeeASpecificMessageForEachFieldSpecifyingThatTheNameFieldsMustBeAtLeastCharsLong(int arg0) {
        assertTrue(addVetPage.areNameFieldsShort());
    }

    @And("Each field has x at the end")
    public void eachFieldHasXAtTheEnd() {
        assertTrue(addVetPage.areNameFieldsUnchecked());
        driver.close();
    }

    @And("I enter then remove values from all fields")
    public void iEnterThenRemoveValuesFromAllFields() {
        addVetPage.fillInForm();
        addVetPage.removeValues();
    }

    @Then("The submit button will be disabled")
    public void theSubmitButtonWillBeDisabled() {
        assertTrue(addVetPage.isCurrent(ADD_VET_FORM_URL));
    }

    @And("I see a specific message for each field specifying it is required")
    public void iSeeASpecificMessageForEachFieldSpecifyingItIsRequired() {
        assertTrue(addVetPage.areNameFieldsRequired());

    }

    @Then("Name fields will have a tick on the right")
    public void nameFieldsWillHaveATickOnTheRight() {
        assertTrue(addVetPage.areNameFieldsChecked());
        driver.close();

    }
}
