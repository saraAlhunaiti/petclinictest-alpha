package org.springframework.samples.petclinic.pages;

import org.openqa.selenium.WebDriver;

public class RemoveVetPage extends Page {

    private static final String URL = "http://localhost:8081/petclinic/vets";
    private static final String PATH_Veterinarians = "/html/body/app-root/app-vet-list/div/div/h2";

    public RemoveVetPage(WebDriver driver) {
        super(driver);
    }

    public void vetsList() {
        super.goTo(URL);
        isExisting(PATH_Veterinarians);
    }

    public void clickOnDeleteVet() {
        xPathClick("//*[@id=\"vets\"]/tbody/tr[1]/td[3]/button[2]");
    }

    public void checkForDeleteVet() {
        removeItem("//*[@id=\"vets\"]/tbody/tr");
    }

}


