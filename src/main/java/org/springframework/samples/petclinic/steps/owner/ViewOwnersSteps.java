package org.springframework.samples.petclinic.steps.owner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.samples.petclinic.pages.HomePage;
import org.springframework.samples.petclinic.pages.ViewOwnerPage;

import java.util.logging.Level;

import static java.util.logging.Logger.getLogger;

public class ViewOwnersSteps {
    static {
        System.setProperty("webdriver.chrome.driver", "/chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
    }

    private final WebDriver driver = new ChromeDriver();
    HomePage homePage = new HomePage(driver);
    ViewOwnerPage viewOwnerPage = new ViewOwnerPage(driver);
    //_________________ Scenario: Successfully view owner's details
    @Given("I am on the home page")
    public void iAmOnTheHomePage() {
        homePage.home();
    }

    @When("I click on all from owners drop-down list")
    public void iClickOnAllFromOwnersDropDownList() {
        viewOwnerPage.clickOnAllOwner();
    }

    @Then("Owners list page will be displayed")
    public void ownersListPageWillBeDisplayed() {
        viewOwnerPage.allOwnerList();
    }


    //_________________  Scenario: Owner's details existent

    @Given("I am on the home Pagee")
    public void iAmOnTheHomePagee() {
        homePage.home();
    }
    @When("I click on all from owners list")
    public void iClickOnAllFromOwnersList() {
        viewOwnerPage.clickOnAllOwner();
    }

    @Then("Owners's details will be displayed")
    public void ownersSDetailsWillBeDisplayed() {
        viewOwnerPage.ownersDetailsExistent();
    }


}
