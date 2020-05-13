package org.springframework.samples.petclinic.pages;

import org.openqa.selenium.WebDriver;

public class RemovePetPage extends Page {
    private static final String URL = "http://localhost:8081/petclinic/owners/1";
    private static final String PATH_OwnerInformation = "/html/body/app-root/app-owner-detail/div/div/h2[1]";

    public RemovePetPage(WebDriver driver) {
        super(driver);
    }

    public void ownerDetails() {
        super.goTo(URL);
        isExisting(PATH_OwnerInformation);
    }

    public void clickOnDeletePet() {
        xPathClick("/html/body/app-root/app-owner-detail/div/div/table[2]/tr/app-pet-list[1]/table/tr/td[1]/dl/button[2]");
    }

    public void checkForDeletePet() {
        removeItem("/html/body/app-root/app-owner-detail/div/div/table[2]/tr/app-pet-list/table/tr/td[1]/dl/dd[1]");
    }
}
