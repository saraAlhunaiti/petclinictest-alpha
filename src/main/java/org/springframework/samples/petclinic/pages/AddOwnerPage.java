package org.springframework.samples.petclinic.pages;

import org.openqa.selenium.WebDriver;

public class AddOwnerPage extends Page {
    private static final String URL = "http://localhost:8081/petclinic/owners/add";


    public AddOwnerPage(WebDriver driver) {
        super(driver);
    }

    public void addOwnerForm() {
        super.goTo(URL);
    }

    public void fillInForm() {
        fill("firstName", "Laura");
        fill("lastName", "Franklin");
        fill("address", "some Dist. ");
        fill("city", "US");
        fill("telephone", "9112348976");
    }

    public void fillInNameFields() {
        xPathClick("/html/body/app-root/app-owner-list/div/div/div/div/button");
        fill("firstName", "G");
        fill("lastName", "F");

    }

    public void removeValues() {
        remove("telephone");
        remove("city");
        remove("address");
        remove("address");
        remove("lastName");
        remove("firstName");
    }

    public void fillInWithInvalidTelephoneNum() {
        xPathClick("/html/body/app-root/app-owner-list/div/div/div/div/button");
        fill("firstName", "Kristin");
        fill("lastName", "Franklin");
        fill("address", "some Dist. ");
        fill("city", "US");
        fill("telephone", "None");
    }

    public void fillInWithSymbols() {
        xPathClick("/html/body/app-root/app-owner-list/div/div/div/div/button");
        fill("firstName", "@#$%^");
        fill("lastName", "@#$%");
        fill("address", "@#$%");
        fill("city", "@#$%");
        fill("telephone", "9112348976");
    }

    public boolean checkedFields() {
        String path = "/html/body/app-root/app-owner-add/div/div/form/div[2]/div/span\n";
        if (exists(path)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean nameFieldsTextErrors() {
        String firstNamePath = "/html/body/app-root/app-owner-add/div/div/form/div[2]/div/span[2]";
        String lastNamePath = "/html/body/app-root/app-owner-add/div/div/form/div[3]/div/span[2]";
        if (exists(firstNamePath) && exists(lastNamePath)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean AllFieldsTextErrors() {
        String firstNamePath = "/html/body/app-root/app-owner-add/div/div/form/div[2]/div/span[2]";
        String lastNamePath = "/html/body/app-root/app-owner-add/div/div/form/div[3]/div/span[2]";
        String addressPath = "/html/body/app-root/app-owner-add/div/div/form/div[4]/div/span[2]";
        String cityPath = "/html/body/app-root/app-owner-add/div/div/form/div[5]/div/span[2]";
        String telephonePath = "/html/body/app-root/app-owner-add/div/div/form/div[6]/div/span[2]";
        if (exists(firstNamePath) && exists(lastNamePath) && (exists(addressPath)) && (exists(cityPath)) && (exists(telephonePath))) {
            return true;
        } else {
            return false;
        }
    }

    public boolean allFieldsCrossError() {
        String firstNameCross = "/html/body/app-root/app-owner-add/div/div/form/div[2]/div/span[1]";
        String lastNameCross = "/html/body/app-root/app-owner-add/div/div/form/div[3]/div/span[1]";
        String addressCross = "/html/body/app-root/app-owner-add/div/div/form/div[4]/div/span[1]";
        String cityCross = "/html/body/app-root/app-owner-add/div/div/form/div[5]/div/span[1]";
        String telephoneCross = "/html/body/app-root/app-owner-add/div/div/form/div[6]/div/span[1]";


        if (exists(firstNameCross) && exists(lastNameCross) && (exists(addressCross)) && (exists(cityCross)) && (exists(telephoneCross))) {
            return true;
        } else {
            return false;
        }
    }

    public boolean nameFieldsCrossError() {
        String firstNameCross = "/html/body/app-root/app-owner-add/div/div/form/div[2]/div/span[1]";
        String lastNameCross = "/html/body/app-root/app-owner-add/div/div/form/div[3]/div/span[1]";
        if (exists(firstNameCross) && exists(lastNameCross)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkOwnerIsAdded() {
        String path = "/html/body/app-root/app-owner-list";
        if (elementDoesExist(path)) {
            return true;
        } else {
            return false;
        }
    }

    public void submit() {
        xPathClick("/html/body/app-root/app-owner-add/div/div/form/div[7]/div/button[2]");
    }


}
