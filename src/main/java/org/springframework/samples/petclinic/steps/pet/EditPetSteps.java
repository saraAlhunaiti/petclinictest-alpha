package org.springframework.samples.petclinic.steps.pet;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.samples.petclinic.pages.EditPetPage;

import java.util.logging.Level;

import static java.util.logging.Logger.getLogger;
import static org.junit.Assert.assertTrue;

public class EditPetSteps {
    static {
        System.setProperty("webdriver.chrome.driver", "/chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
    }


    private final WebDriver driver = new ChromeDriver();
    EditPetPage editPetPage = new EditPetPage(driver);

    private String petFormURL;
    private String petName = "snowBall";
    private final String birthDate = "2020/02/02";

    @Given("I am on the edit-pet form")
    public void iAmOnTheEditPetForm() {
        editPetPage.editPetForm();

    }

    @And("I enter valid pet-data")
    public void iEnterValidPetData() {
        editPetPage.fillInPetForm(petName, birthDate, 1);
    }

    @When("I click on the update pet button")
    public void iClickOnTheUpdatePetButton() {
        petFormURL = driver.getCurrentUrl();
        editPetPage.submit();
    }

    @Then("The updated pet's data will be displayed")
    public void theUpdatedPetSDataWillBeDisplayed() {
        editPetPage.updatedPetName(petName);
        driver.close();
    }



    @And("I enter symbols and numbers in name field")

    public void iEnterSymbolsAndNumbersInNameField() {
        petName = "67#$234";
        editPetPage.fillInPetForm(petName, birthDate, 1);
    }

    @And("I enter invalid birth-date")
    public void iEnterInvalidBirthDate() {
        editPetPage.fillInPetForm(petName, "not-a-date", 1);
    }

    @And("I  remove values from each field")
    public void iRemoveValuesFromEachField() {
        editPetPage.fillInPetForm(" ", " ", 1);
    }

    @Then("I stay in edit-pet form")
    public void iStayInEditPetForm() {
        assertTrue(editPetPage.isCurrent(petFormURL));
        driver.close();
    }

}


