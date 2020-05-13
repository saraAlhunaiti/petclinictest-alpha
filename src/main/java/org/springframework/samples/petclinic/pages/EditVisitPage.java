package org.springframework.samples.petclinic.pages;

import org.openqa.selenium.WebDriver;

public class EditVisitPage extends Page {
    private static final String URL = "http://localhost:8081/petclinic/owners/10";


    public EditVisitPage(WebDriver driver) {
        super(driver);
    }

    public void editVisitPage() {
        super.goTo(URL);
    }

    public void editVisitButton() {
        xPathClick("/html/body/app-root/app-owner-detail/div/div/table[2]/tr/app-pet-list[1]/table/tr/td[2]/app-visit-list/table/tr/td[3]/button[1]");
    }

    public void fillInForm() {
        delteFelid();
        fillDate("#visit > div.form-group.has-feedback > div:nth-child(1) > div > input", "2020/05/19");
        fill("description", "Pellentesque nec lacus elit. Pellentesque convallis nisi ac augue pharetra eu tristique neque consequat.");

    }

    public void fillInDate() {
        delteFelid();
        fillDate("#visit > div.form-group.has-feedback > div:nth-child(1) > div > input", "Fifth of May");

    }

    public void emptyForm() {
        delteFelid();

    }

    public void fillInDescription() {
        delteFelid();
        fillDate("#visit > div.form-group.has-feedback > div:nth-child(1) > div > input", "2020/05/23");
        fill("description", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent tempus eleifend risus ut congue. Pellentesque nec lacus elit. Pellentesque convallis nisi ac augue pharetra eu tristique neque consequat. Praesent tempus eleifend risus ut congue. Praesent tempus eleifend risus ut congue.");

    }

    public void submit() {
        xPathClick("//*[@id=\"visit\"]/div[2]/div/button[2]");
    }


    public void delteFelid() {
        editdelete("#visit > div.form-group.has-feedback > div:nth-child(1) > div > input");
        editdelete("#description");
    }


}
