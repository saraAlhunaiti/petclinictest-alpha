package org.springframework.samples.petclinic.pages;

import org.openqa.selenium.WebDriver;

public class EditOwnerPage extends Page {
    private static final String URL = "http://localhost:8081/petclinic/owners/4";

    public EditOwnerPage(WebDriver driver){
        super(driver);
    }
    public void editOwnerForm(){
        super.goTo(URL);
    }
    public void fillInForm() {
        xPathClick("/html/body/app-root/app-owner-detail/div/div/button[2]");
        fill("firstName","Besh");
        fill("lastName","Jamil");
        fill("address","Al-Safa 12. ");
        fill("city","Jeddah");
        fill("telephone","0555090234");
        updateOwner();
    }
    public void fillInSymbolAndNumForm() {
        xPathClick("/html/body/app-root/app-owner-detail/div/div/button[2]");
        fill("firstName","#2Besh");
        fill("lastName","@Jamil4");
        fill("address","&Al-Safa 12. ");
        fill("city","(Jeddah)");
        fill("telephone","0555090234");
        updateOwner();
    }
    public void fillInEmptyFieldForm() {
        xPathClick("/html/body/app-root/app-owner-detail/div/div/button[2]");
        fill("firstName","");
        fill("lastName","");
        fill("address","");
        fill("city","");
        fill("telephone","");
        updateOwner();
    }
    public void updateOwner() {
        xPathClick("/html/body/app-root/app-owner-edit/div/div/form/div[7]/div/button[2]");
    }
    public void ownerList(){
        super.goTo(URL);
    }
}
