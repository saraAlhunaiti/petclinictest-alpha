package org.springframework.samples.petclinic.pages;

import org.openqa.selenium.WebDriver;

public class AddPetPage extends Page {
    private static final String URL = "http://localhost:8081/petclinic/owners/1";

    public AddPetPage(WebDriver driver) {
        super(driver);
    }

    public void addPetForm() {
        super.goTo(URL);
    }

    public void fillInForm() {
        xPathClick("/html/body/app-root/app-owner-detail/div/div/button[3]");
        fill("name", "Milo");
        fillDate("body > app-root > app-pet-add > div > div > form > div:nth-child(5) > div > input", "2020/05/03");
        selectFirst("type");
        submit();


    }    public void invalidData() {
        xPathClick("/html/body/app-root/app-owner-detail/div/div/button[3]");
        fill("name", "Milo");
        fillDate("body > app-root > app-pet-add > div > div > form > div:nth-child(5) > div > input", "Fifth of May");
        selectFirst("type");
        submit();


    }


    public void fillInName() {
        xPathClick("/html/body/app-root/app-owner-detail/div/div/button[3]");
        fill("name", "@&*46582");
        fillDate("body > app-root > app-pet-add > div > div > form > div:nth-child(5) > div > input", "2020/05/16");
        selectFirst("type");
        submit();

    }

    public void fillInBirthday(){
        xPathClick("/html/body/app-root/app-owner-detail/div/div/button[3]");
        fill("name", "Oscar");
        fillDate("body > app-root > app-pet-add > div > div > form > div:nth-child(5) > div > input", "Fifth of May");
        selectFirst("type");
        submit();

    }


    public void petDoesExist() {
        elementDoesExist( "/html/body/app-root/app-owner-detail/div/div/table[2]/tr/app-pet-list/table/tr/td[1]/dl");


    }
    public void emptyForm(){
        xPathClick("/html/body/app-root/app-owner-detail/div/div/button[3]");
        submit();

    }

    public void submit() {
        xPathClick("/html/body/app-root/app-pet-add/div/div/form/div[6]/div/button[2]");
    }




}
