package org.springframework.samples.petclinic.steps.pet;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.samples.petclinic.pages.RemovePetPage;

import java.util.logging.Level;

import static java.util.logging.Logger.getLogger;

public class RemovePetSteps {
    static {
        System.setProperty("webdriver.chrome.driver", "/chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
    }

    private final WebDriver driver = new ChromeDriver();
    RemovePetPage removePetPage = new RemovePetPage(driver);
    @Given("I am on the Owner-Information page")
    public void iAmOnTheOwnerInformationPage() {
        removePetPage.ownerDetails();
    }

    @When("I click on Delete Pet button")
    public void iClickOnDeletePetButton() {
        removePetPage.clickOnDeletePet();
    }

    @Then("The Pet will be removed")
    public void thePetWillBeRemoved() {
        removePetPage.checkForDeletePet();
    }
}
