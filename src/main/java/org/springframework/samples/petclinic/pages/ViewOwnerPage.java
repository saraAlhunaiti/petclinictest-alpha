package org.springframework.samples.petclinic.pages;

import org.openqa.selenium.WebDriver;

public class ViewOwnerPage extends Page {

    private static final String URL = "http://localhost:8081/petclinic/owners";
    private static final String PATH_OwnerInformation = "/html/body/app-root/app-owner-detail/div/div/h2[1]";
    private static final String PATH_Owners = "/html/body/app-root/app-owner-list/div/div/h2";

    public ViewOwnerPage(WebDriver driver) {
        super(driver);
    }

    public void ownersList() {
        super.goTo(URL);
        isExisting(PATH_Owners);
    }

    public void selectFirstOwner() {
        xPathClick("/html/body/app-root/app-owner-list/div/div/div/table/tbody/tr[1]/td[1]/a");
    }

    public void ownerDetails() {
        isExisting(PATH_OwnerInformation);
    }

    //__________________ ViewOwners:
    public void clickOnAllOwner() {
        xPathClick("/html/body/app-root/div[1]/nav/div/ul/li[2]/a");
        xPathClick("/html/body/app-root/div[1]/nav/div/ul/li[2]/ul/li[1]/a");
    }

    public void allOwnerList() {
        isExisting(PATH_Owners);
    }


}