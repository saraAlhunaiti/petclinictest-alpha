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
import static org.junit.Assert.assertTrue;


import java.util.logging.Level;

import static java.util.logging.Logger.getLogger;

public class VisitSteps {
    static {
        System.setProperty("webdriver.chrome.driver", "/Users/chromedriver");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
    }

    private final WebDriver driver = new ChromeDriver();
    private final AddVisitPage addVisitPage = new AddVisitPage(driver);
    private final RemoveVisit removeVisit = new RemoveVisit(driver);
    private final EditVisitPage editVisitPage= new EditVisitPage(driver);
    private String visitFormsURL = "";



    //****** Add Visit ******\\

//--------- Successfully add an new visit ---------\\

    @Given("I am on the page of Owner Information")
    public void iAmOnThePageOfOwnerInformation() {
        addVisitPage.addVisitForm();
    }

    @When("I click on Add Visit button")
    public void iClickOnAddVisitButton() {
        addVisitPage.addVisitButton ();
    }

    @Given("I am on the add-visit form")
    public void iAmOnTheAddVisitForm() {
        addVisitPage.addVisitForm();
    }

    @And("I enter valid visit data")
    public void iEnterValidVisitData() {
        iClickOnAddVisitButton();
        addVisitPage.fillInForm();
    }

    @Then("The new visit details will be displayed on Owner-Information page")
    public void theNewVisitDetailsWillBeDisplayedOnOwnerInformationPage() {
        addVisitPage.visitdetailsDisplyed();
    }

//--------- Unsuccessfully add an new visit ---------\\

    @And("Provide an invalid birth date for Visit")
    public void provideAnInvalidBirthDateForVisit() {
        iClickOnAddVisitButton();
        addVisitPage.fillInDate();
    }

    @When("I click on the save Visit button")
    public void iClickOnTheSaveVisitButton() {
    }

    @When("I submit the add-visit form")
    public void iSubmitTheAddVisitForm() {
        visitFormsURL=driver.getCurrentUrl();
        addVisitPage.submit();
    }

    @Then("I stay in add visit form")
    public void iStayInAddVisitForm() {
        assertTrue(editVisitPage.isCurrent(visitFormsURL));
    }

//--------- Leave all the fields empty ---------\\

    @And("I leave all the fields empty")
    public void iLeaveAllTheFieldsEmpty() {
        iClickOnAddVisitButton();
        addVisitPage.emptyForm();

    }

//--------- Exceed the maximum allowed characters in the description field ---------\\

    @And("I enter characters exceed the limit")
    public void iEnterCharactersExceedTheLimit() {
        iClickOnAddVisitButton();
        addVisitPage.fillInDescription();
    }


//--------- Exceed the maximum allowed characters in the description field ---------\\

    @And("I provide valid visit data")
    public void iProvideValidVisitData() {
        iClickOnAddVisitButton();
        addVisitPage.validDate();
    }

    @And("I leave the description field empty")
    public void iLeaveTheDescriptionFieldEmpty() {
       addVisitPage.emptyDescription();
    }




        //****** Edit visit Form ******\\

//--------- Successfully add an new visit ---------\\

    @When("I click on Edit Visit button")
    public void iClickOnEditVisitButton() {
        editVisitPage.editVisitButton ();

    }

    @Given("I am on the edit-visit form")
    public void iAmOnTheEditVisitForm() {
        editVisitPage.editVisitPage();
    }


    @And("I enter valid data to edit the visit")
    public void iEnterValidDataToEditTheVisit() {
        iClickOnEditVisitButton();
        editVisitPage.fillInForm();

    }

    @Then("The updated pet's data will be displayed")
    public void theUpdatedPetSDataWillBeDisplayed() {

    }

//--------- Unsuccessfully add an new visit ---------\\


    @And("I Provide an invalid visit date")
    public void iProvideAnInvalidVisitDate() {
        iClickOnEditVisitButton();
        editVisitPage.fillInDate();
        iSubmitTheEditVisitForm();
    }

    @When("I submit the edit-visit form")
    public void iSubmitTheEditVisitForm() {
        visitFormsURL=driver.getCurrentUrl();
        addVisitPage.submit();
    }

    @Then("I stay in edit visit form")
    public void iStayInEditVisitForm() {
        assertTrue(editVisitPage.isCurrent(visitFormsURL));
    }

    //--------- Leave all the fields empty ---------\\

    @And("I did not fill the visit form")
    public void iDidNotFillTheVisitForm() {
        iClickOnEditVisitButton();
        editVisitPage.emptyForm();
        iSubmitTheEditVisitForm();

    }


//--------- Exceed the maximum allowed characters in the description field ---------\\

    @And("I edit the description filed with characters that exceed the limit")
    public void iEditTheDescriptionFiledWithCharactersThatExceedTheLimit() {
        iClickOnEditVisitButton();
        editVisitPage.fillInDescription();
        iSubmitTheEditVisitForm();


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




}
