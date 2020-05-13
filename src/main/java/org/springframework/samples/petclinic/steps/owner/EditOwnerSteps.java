package org.springframework.samples.petclinic.steps.owner;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.samples.petclinic.pages.EditOwnerPage;

import java.util.logging.Level;

import static java.util.logging.Logger.getLogger;

public class EditOwnerSteps {
    static {
        System.setProperty("webdriver.chrome.driver", "/chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
    }

    private final WebDriver driver = new ChromeDriver();
    EditOwnerPage editOwnerPage = new EditOwnerPage(driver);

    @Given("I am on the edit-owner form")
    public void iAmOnTheEditOwnerForm() {
        editOwnerPage.editOwnerForm();
    }

    @When("I edit the owner's data with valid entries")
    public void iEditTheOwnerDataWithValidEntries() {
        editOwnerPage.fillInForm();
    }

    @Then("The owner's data will be updated")
    public void theOwnerDataWillBeUpdated() {
        editOwnerPage.ownerList();
        driver.close();
    }

    @And("I update by entering symbols and numbers rather than words")
    public void iUpdateByEnteringSymbolsAndNumbersRatherThanWords() {
        editOwnerPage.fillInSymbolAndNumForm();
    }

    @When("I update the form")
    public void iUpdateTheForm() {
    }

    @When("I remove data from the fields")
    public void iRemoveDataFromTheFields() {
        editOwnerPage.fillInEmptyFieldForm();
    }

    @Then("I stay in edit-owner form")
    public void IStayInEditOwnerForm() {
        driver.close();
    }

    @And("Each update field has an x at the end")
    public void validateIncorrectInputErrorSymbol() {
    }
}

