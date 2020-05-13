package org.springframework.samples.petclinic.pages;

import org.openqa.selenium.WebDriver;

public class EditOwnerPage extends Page {
    private static final String URL = "http://localhost:8081/petclinic/owners/5";

    public EditOwnerPage(WebDriver driver) {
        super(driver);
    }

    public void editOwnerForm() {
        super.goTo(URL);
    }


    public void fillInForm() {
        xPathClick("/html/body/app-root/app-owner-detail/div/div/button[2]");
        fill("firstName", "George");
        fill("lastName", "Franklin");
        fill("address", "Al-Safa 12. ");
        fill("city", "Jeddah");
        fill("telephone", "0555090234");
        updateOwner();
    }

    public void fillInSymbolAndNumForm() {
        xPathClick("/html/body/app-root/app-owner-detail/div/div/button[2]");
        fill("firstName", "#2Besh");
        fill("lastName", "@Jamil4");
        fill("address", "&Al-Safa 12. ");
        fill("city", "(Jeddah)");
        fill("telephone", "0555090234");
        updateOwner();
    }

    public void fillInEmptyFieldForm() {
        xPathClick("/html/body/app-root/app-owner-detail/div/div/button[2]");
        editdelete("#firstName");
        editdelete("#lastName");
        editdelete("#address");
        editdelete("#city");
        editdelete("#telephone");
    }

    public void updateOwner() {
        xPathClick("/html/body/app-root/app-owner-edit/div/div/form/div[7]/div/button[2]");
    }

    public void ownerList() {
        super.goTo(URL);
    }
}
