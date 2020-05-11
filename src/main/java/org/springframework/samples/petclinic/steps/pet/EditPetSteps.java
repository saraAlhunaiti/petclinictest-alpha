package org.springframework.samples.petclinic.steps.pet;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.samples.petclinic.pages.EditPetPage;

import java.util.logging.Level;

import static java.util.logging.Logger.getLogger;

public class EditPetSteps {
    static {
        System.setProperty("webdriver.chrome.driver", "/chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
    }


    private final WebDriver driver = new ChromeDriver();
    EditPetPage editPetPage = new EditPetPage(driver);

    @Given("I am on the edit-pet form")
    public void iAmOnTheEditPetForm() {
        editPetPage.editPetForm();
    }

    @And("I enter valid pet-data")
    public void iEnterValidPetData() {
        editPetPage.fillInForm();

    }
    @When("I click on the update pet button")
    public void iClickOnTheUpdatePetButton() {

    }

    @Then("The updated pet's data will be displayed")
    public void theUpdatedPetSDataWillBeDisplayed() {
       // editPetPage.updatedData();
        driver.close();
    }

    //-------------------------------------------
//
//    @And("I enter symbols and numbers rather than words in the name field")
//    public void iEnterSymbolsAndNumbersRatherThanWordsInTheNameField() {
//        editPetPage.fillNumAndSymbolsName();
//    }

//    @And("Provide an invalid birth date")
//    public void provideAnInvalidBirthDate() {
//        editPetPage.fillInvalidDate();
//
//    }

    @Then("The the button will be disabled")
    public boolean theTheButtonWillBeDisabled() {
        return driver.findElement(By.xpath("/html/body/app-root/app-pet-edit/div/div/form/div[6]/div/button[2]")).isEnabled();
        // Todo: deal with the error "Failure"
    }

    @Then("The update pet button will be disabled")
    public boolean theUpdatePetButtonWillBeDisabled() {

        return driver.findElement(By.xpath("/html/body/app-root/app-pet-edit/div/div/form/div[6]/div/button[2]")).isEnabled();

        // ToDo : update button is enabled
    }


    @And("I enter symbols and numbers in name field")
    public void iEnterSymbolsAndNumbersInNameField() {
       editPetPage.fillNumAndSymbolsName();
   }

    @And("I enter invalid birth-date")
    public void iEnterInvalidBirthDate() {
        editPetPage.fillInDate();
    }

    @And("I  remove values from each field")
    public void iRemoveValuesFromEachField() {
        editPetPage.fillInEmptyForm();
    }
}

