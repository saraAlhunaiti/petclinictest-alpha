package org.springframework.samples.petclinic.steps.vet;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.samples.petclinic.pages.RemoveVetPage;

import java.util.logging.Level;

import static java.util.logging.Logger.getLogger;

public class RemoveVetSteps {
    static {
        System.setProperty("webdriver.chrome.driver", "/chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
    }

    private final WebDriver driver = new ChromeDriver();
    RemoveVetPage removeVetPage = new RemoveVetPage(driver);

    @Given("I am on the vet-Information page")
    public void iAmOnTheVetInformationPage() {
        removeVetPage.vetsList();
    }

    @When("I click on Delete vet button")
    public void iClickOnDeleteVetButton() {
        removeVetPage.clickOnDeleteVet();
    }

    @Then("The vet will be removed")
    public void theVetWillBeRemoved() {
        removeVetPage.checkForDeleteVet();
        driver.close();
    }
}
