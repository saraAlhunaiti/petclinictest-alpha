package org.springframework.samples.petclinic.steps.vet;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.samples.petclinic.pages.HomePage;
import org.springframework.samples.petclinic.pages.ViewVetsPage;

import java.util.logging.Level;

import static java.util.logging.Logger.getLogger;

public class ViewVetsSteps {
    static {
        System.setProperty("webdriver.chrome.driver", "/chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
    }

    private final WebDriver driver = new ChromeDriver();
    HomePage homePage = new HomePage(driver);
    ViewVetsPage viewVetsPage = new ViewVetsPage(driver);

    @Given("I am on the Home page")
    public void iAmOnTheHomePage() {
        homePage.home();
    }

    @When("I click on all from Veterinarians drop-down list")
    public void iClickOnAllFromVeterinariansDropDownList() {
        viewVetsPage.clickOnAllVet();
    }

    @Then("vets list page will be displayed")
    public void vetsListPageWillBeDisplayed() {
        viewVetsPage.allVetList();
    }

}
