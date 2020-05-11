package org.springframework.samples.petclinic.steps.pet;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.samples.petclinic.pages.AddPetPage;

import java.util.logging.Level;

import static java.util.logging.Logger.getLogger;

public class AddPetSteps {


    static {
        System.setProperty("webdriver.chrome.driver", "/chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
    }

    private final WebDriver driver = new ChromeDriver();
    private final AddPetPage addPetPage = new AddPetPage(driver);




    //--------- Successfully add an new visit ---------\\
    @Given("I am on the add-pet form")
    public void iAmOnTheAddPetForm() {
        addPetPage.addPetForm();
    }

    @And("I enter valid pet data")
    public void iEnterValidPetData() {
        addPetPage.fillInForm();
    }

    @When("I submit add-Pet form")
    public void iSubmitAddPetForm() {

    }

    @Then("The new pet will be displayed under pets and visits beneath its owner")
    public void theNewPetWillBeDisplayedUnderPetsAndVisitsBeneathItsOwner() {
        addPetPage.petDoesExist();
    }

//--------- Unsuccessfully add an new visit ---------\\

    @And("I enter invalid pet data")
    public void iEnterInvalidPetData() {
        addPetPage.invalidData();

    }


    @And("I enter symbols and numbers rather than words in the name field")
    public void iEnterSymbolsAndNumbersRatherThanWordsInTheNameField() {
        addPetPage.fillInName();
    }

    @And("Provide an invalid birth date")
    public void provideAnInvalidBirthDate() {
        addPetPage.fillInBirthday();

    }

    @When("I click on the save pet button")
    public void iClickOnTheSavePetButton() {

    }

    @Then("The the button will be enabled but doesn't navigate")
    public void theTheButtonWillBeEnabledButDoesnTNavigate() {
    }

    @And("try to add pet without filling in the fields")
    public void tryToAddPetWithoutFillingInTheFields() {
        addPetPage.emptyForm();

    }


}


