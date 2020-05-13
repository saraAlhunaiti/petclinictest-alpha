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
import static org.junit.Assert.assertTrue;

public class AddPetSteps {


    static {
        System.setProperty("webdriver.chrome.driver", "/chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
    }

    private final WebDriver driver = new ChromeDriver();
    private final AddPetPage addPetPage = new AddPetPage(driver);

    private String addPetFormURL;
    private String petName = "Caramella";
    private final String birthDate = "2020/02/22";


    //------------------\\
    @Given("I am on the add-pet form")
    public void iAmOnTheAddPetForm() {
        addPetPage.addPetForm();

    }

    @And("I enter valid pet data")
    public void iEnterValidPetData() {
        addPetPage.fillInPetForm(petName, birthDate, 2);
    }

    @When("I submit add-Pet form")
    public void iSubmitAddPetForm() {
        addPetFormURL = driver.getCurrentUrl();
        addPetPage.submit();

    }

    @Then("The new pet will be displayed under pets and visits beneath its owner")
    public void theNewPetWillBeDisplayedUnderPetsAndVisitsBeneathItsOwner() {
        addPetPage.newPetName(petName);
        driver.close();
    }


    @And("I enter invalid pet data")
    public void iEnterInvalidPetData() {
        addPetPage.fillInPetForm(petName, birthDate, 2);

    }


    @And("I enter symbols and numbers rather than words in the name field")
    public void iEnterSymbolsAndNumbersRatherThanWordsInTheNameField() {
        petName = "11#@%%11";
        addPetPage.fillInPetForm(petName, birthDate, 0);
    }

    @And("Provide an invalid birth date")
    public void provideAnInvalidBirthDate() {
        addPetPage.fillInPetForm(petName, "not-a-date", 1);

    }


    @And("try to add pet without filling in the fields")
    public void tryToAddPetWithoutFillingInTheFields() {
        addPetPage.submit();

    }


    @Then("I stay in add-pet form")
    public void iStayInAddPetForm() {
        assertTrue(addPetPage.isCurrent(addPetFormURL));
        driver.close();
    }
}


