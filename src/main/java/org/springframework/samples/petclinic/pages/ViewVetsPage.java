package org.springframework.samples.petclinic.pages;

import org.openqa.selenium.WebDriver;

public class ViewVetsPage extends Page {
    private static final String URL = "http://localhost:8081/petclinic/vets";
    private static final String PATH_Veterinarians = "/html/body/app-root/app-vet-list/div/div/h2";
    public ViewVetsPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAllVet() {
        xPathClick("/html/body/app-root/div[1]/nav/div/ul/li[3]/a");
        xPathClick("/html/body/app-root/div[1]/nav/div/ul/li[3]/ul/li[1]/a");
    }
    public void allVetList() { isExisting(PATH_Veterinarians); }
}
