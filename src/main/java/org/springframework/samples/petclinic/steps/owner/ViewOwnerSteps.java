package org.springframework.samples.petclinic.steps.owner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.samples.petclinic.pages.ViewOwnerPage;

import java.util.logging.Level;

import static java.util.logging.Logger.getLogger;

public class ViewOwnerSteps {
    static {
        System.setProperty("webdriver.chrome.driver", "/chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
    }
    private final WebDriver driver = new ChromeDriver();
    ViewOwnerPage viewOwnerPage = new ViewOwnerPage(driver);
    @Given("I am on the view-owners list on the owners page")
    public void iAmOnTheViewOwnersListOnTheOwnersPage() {
        viewOwnerPage.ownersList();
    }

    @When("I click on the owner's name")
    public void iClickOnTheOwnerSName() {
        viewOwnerPage.selectFirstOwner();
    }

    @Then("Owner detail page will be displayed")
    public void ownerDetailPageWillBeDisplayed() {
        viewOwnerPage.ownerDetails();
    }
}
