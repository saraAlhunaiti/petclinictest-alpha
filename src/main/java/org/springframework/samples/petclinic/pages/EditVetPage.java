package org.springframework.samples.petclinic.pages;

import org.openqa.selenium.WebDriver;

public class EditVetPage extends Page {
    private static final String URL = "http://localhost:8081/petclinic/vets/1/edit";

    public EditVetPage(WebDriver driver) {
        super(driver);
    }

    public void editVetForm() {
        super.goTo(URL);
    }

    public void fillInForm() {
        xPathClick("/html/body/app-root/app-vet-edit/div/div/form/div[2]/div/input");
        fill("firstName", "Maha");
        fill("lastName", "Jamil");
        saveVet();
    }

    public void fillInSymbolAndNumForm() {
        xPathClick("/html/body/app-root/app-vet-edit/div/div/form/div[2]/div/input");
        fill("firstName", "#2Besh");
        fill("lastName", "@Jamil4");
        saveVet();
    }

    public void fillInEmptyFieldForm() {
        xPathClick("/html/body/app-root/app-vet-edit/div/div/form/div[2]/div/input");
        editdelete("#firstName");
        editdelete("#lastName");
    }

    public void saveVet() {
        xPathClick("/html/body/app-root/app-vet-edit/div/div/form/div[5]/div/button[2]");
    }
}



