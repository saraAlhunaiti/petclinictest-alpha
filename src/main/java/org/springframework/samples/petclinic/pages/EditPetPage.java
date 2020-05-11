package org.springframework.samples.petclinic.pages;

import org.openqa.selenium.WebDriver;

public class EditPetPage extends Page {
    private static final String URL = "http://localhost:8081/petclinic/owners/1";


    public EditPetPage(WebDriver driver) {
        super(driver);
    }

    public void editPetForm() {
        super.goTo(URL);
        xPathClick("/html/body/app-root/app-owner-detail/div/div/table[2]/tr/app-pet-list[1]/table/tr/td[1]/dl/button[1]");
    }


    public void fillInPetForm(String name, String birthDate, int typeIndex) {
        delete("body > app-root > app-pet-edit > div > div > form > div:nth-child(5) > input");
        fill("name", name);
        fillDate("body > app-root > app-pet-edit > div > div > form > div:nth-child(5) > input", birthDate);
        select("type", typeIndex);

    }

    public void submit() {
        xPathClick("/html/body/app-root/app-pet-edit/div/div/form/div[6]/div/button[2]");
    }

    public void updatedPetName(String name) {
        allPets().contains(name);
    }
}
