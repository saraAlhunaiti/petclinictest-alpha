package org.springframework.samples.petclinic.steps.visit;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.samples.petclinic.pages.AddVisitPage;
import org.springframework.samples.petclinic.pages.EditVisitPage;
import org.springframework.samples.petclinic.pages.RemoveVisit;

import java.util.logging.Level;

import static java.util.logging.Logger.getLogger;

public class VisitSteps {
    static {
        System.setProperty("webdriver.chrome.driver", "/chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
    }

    private final WebDriver driver = new ChromeDriver();
    private final AddVisitPage addVisitPage = new AddVisitPage(driver);
    private final RemoveVisit removeVisit = new RemoveVisit(driver);
    private final EditVisitPage editVisitPage= new EditVisitPage(driver);



//--------- Successfully add an new visit ---------\\

    @Given("I am on the add-visit form")
    public void iAmOnTheAddVisitForm() {
        addVisitPage.addVisitForm();
    }

    @And("I enter valid visit data")
    public void iEnterValidVisitData() {
        addVisitPage.fillInForm();
    }

    @Then("The new visit details will be displayed on Owner-Information page")
    public void theNewVisitDetailsWillBeDisplayedOnOwnerInformationPage() {
        addVisitPage.visitdetailsDisplyed();
    }




//--------- Unsuccessfully add an new visit ---------\\


    @And("Provide an invalid birth date for Visit")
    public void provideAnInvalidBirthDateForVisit() {
        addVisitPage.fillInDate();
    }

    @When("I click on the save Visit button")
    public void iClickOnTheSaveVisitButton() {

    }



//--------- Leave all the fields empty ---------\\

    @And("I leave all the fields empty")
    public void iLeaveAllTheFieldsEmpty() {
        addVisitPage.emptyForm();

    }



//--------- Edit visit Form ---------\\

    @Given("I am on the edit-visit form")
    public void iAmOnTheEditVisitForm() {
        editVisitPage.editVisitPage();
    }
    @And("I enter valid data to edit the visit")
    public void iEnterValidDataToEditTheVisit() {
        editVisitPage.fillInForm();
    }

    @Then("The updated pet's data will be displayed")
    public void theUpdatedPetSDataWillBeDisplayed() {

    }


    @And("Provide an invalid visit date")
    public void provideAnInvalidVisitDate() {
        editVisitPage.fillInDate();
    }

    @And("I did not fill the visit form")
    public void iDidNotFillTheVisitForm() {
        editVisitPage.emptyForm();
    }


 //---------Remove visit ---------\\


    @Given("I am on the Owner-Information page")
    public void iAmOnTheOwnerInformationPage() {
        removeVisit.removeVisitForm();
    }


    @When("I click on Delete Visit button")
    public void iClickOnDeleteVisitButton() {

        removeVisit.clickRemoveButton();
    }

    @Then("The visit will be removed")
    public void theVisitWillBeRemoved() {
        removeVisit.removeVisit();

    }


    @Then("add visit button will be enabled but doesn't navigate")
    public void addVisitButtonWillBeEnabledButDoesnTNavigate() {

    }
}
