package org.springframework.samples.petclinic.steps.vet;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.samples.petclinic.pages.EditVetPage;

import java.util.logging.Level;

import static java.util.logging.Logger.getLogger;

public class EditVetSteps {
    static {
        System.setProperty("webdriver.chrome.driver", "/chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
    }

    private final WebDriver driver = new ChromeDriver();
    EditVetPage editVetPage = new EditVetPage(driver);

    @Given("I am on the edit-vet form")
    public void iAmOnTheEditVetForm() {
        editVetPage.editVetForm();
    }

    @When("I edit the vet's name with valid entries")
    public void iEditTheVetNameWithValidEntries() {
        editVetPage.fillInForm();
    }

    @Then("The vet's name will be updated")
    public void TheVetNameWillBeUpdated() {
        driver.close();
    }

    @And("I update vet by entering symbols and numbers rather than words")
    public void iUpdateVetByEnteringSymbolsAndNumbersRatherThanWords() {
        editVetPage.fillInSymbolAndNumForm();
    }

    @When("I update Vet form")
    public void iUpdateVetForm() {
    }

    @When("I remove vet data from the fields")
    public void iRemoveVetDataFromTheFields() {
        editVetPage.fillInEmptyFieldForm();
    }

    @Then("I stay in edit-Vet form")
    public void IStayInEditVetForm() {
        driver.close();
    }

    @And("Each vet update field has an x at the end")
    public void EachVetUpdateFieldHasAnxAtTheEndl() {
    }
}


