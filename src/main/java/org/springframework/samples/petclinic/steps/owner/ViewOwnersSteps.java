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


}
