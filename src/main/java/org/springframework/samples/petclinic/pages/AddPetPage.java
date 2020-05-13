package org.springframework.samples.petclinic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddPetPage extends Page {
    private static final String URL = "http://localhost:8081/petclinic/owners/1";

    public AddPetPage(WebDriver driver) {
        super(driver);
    }

    public void addPetForm() {
        super.goTo(URL);
        xPathClick("/html/body/app-root/app-owner-detail/div/div/button[3]");
    }

    public void fillInPetForm(String name, String birthDate, int typeIndex) {
        delete("body > app-root > app-pet-add > div > div > form > div:nth-child(5) > div > input");
        fill("name", name);
        fillDate("body > app-root > app-pet-add > div > div > form > div:nth-child(5) > div > input", birthDate);
        select("type", typeIndex);

    }

    public void newPetName(String name) {
        allPets().contains(name);

    }

    public void submit() {
        xPathClick("/html/body/app-root/app-pet-add/div/div/form/div[6]/div/button[2]");
    }
 public boolean isEnabled(WebElement element){

     return ((element).isEnabled());
 }

}
