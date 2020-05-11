package org.springframework.samples.petclinic.pages;

import org.openqa.selenium.WebDriver;

public class RemoveVisit extends Page {


    private static final String URL = "http://localhost:8081/petclinic/owners/1";


    public RemoveVisit(WebDriver driver) {
        super(driver);
    }

    public void removeVisitForm() {
        super.goTo(URL);
    }

    public void clickRemoveButton() {

        xPathClick("/html/body/app-root/app-owner-detail/div/div/table[2]/tr/app-pet-list/table/tr/td[2]/app-visit-list/table/tr/td[3]/button[2]");

    }

    public void  removeVisit(){
        removeItem("/html/body/app-root/app-owner-detail/div/div/table[2]/tr/app-pet-list[1]/table/tr/td[2]/app-visit-list/table/tr");
    }

}
