package org.springframework.samples.petclinic.pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends Page {
    private static final String URL = "http://localhost:8081/petclinic/";

    public HomePage(WebDriver driver) {

        super(driver);
    }

    public void home() {
        super.goTo(URL);
    }

}
