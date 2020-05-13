package org.springframework.samples.petclinic.pages;

import org.openqa.selenium.WebDriver;

public class EditVetPage extends Page {
    private static final String URL = "http://localhost:8081/petclinic/vets";

    public EditVetPage(WebDriver driver) {
        super(driver);
    }

    public void editVetForm() {
        super.goTo(URL);
    }

    public void fillInForm() {
        xPathClick("/html/body/app-root/app-vet-list/div/div/table/tbody/tr[1]/td[3]/button[1]");
        fill("firstName", "Maha");
        fill("lastName", "Jamil");
        saveVet();
    }

    public void fillInSymbolAndNumForm() {
        xPathClick("/html/body/app-root/app-vet-list/div/div/table/tbody/tr[1]/td[3]/button[1]");
        fill("firstName", "#2Besh");
        fill("lastName", "@Jamil4");
        saveVet();
    }

    public void fillInEmptyFieldForm() {
        xPathClick("//*[@id=\"vets\"]/tbody/tr[1]/td[3]/button[1]");
        editdelete("#firstName");
        editdelete("#lastName");
    }

    public void saveVet() {
        xPathClick("/html/body/app-root/app-vet-edit/div/div/form/div[5]/div/button[2]");
    }

}



