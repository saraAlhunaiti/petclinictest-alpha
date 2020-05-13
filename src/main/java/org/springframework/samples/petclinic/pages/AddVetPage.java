package org.springframework.samples.petclinic.pages;

import org.openqa.selenium.WebDriver;

public class AddVetPage extends Page {

    private static final String URL = "http://localhost:8081/petclinic/vets/add";
    private static final String FIELD1_CHECK_SIGN = "/html/body/app-root/app-vet-add/div/div/form/div[2]/div/span";
    private static final String FIELD2_CHECK_SIGN = " /html/body/app-root/app-vet-add/div/div/form/div[3]/div/span";
    private static final String NAME1_SHORT_ERROR = "/html/body/app-root/app-vet-add/div/div/form/div[2]/div/span[2]";
    private static final String NAME2_SHORT_ERROR = "/html/body/app-root/app-vet-add/div/div/form/div[3]/div/span[2]";
    private static final String FIELD1_UNCHECK_SIGN = "/html/body/app-root/app-vet-add/div/div/form/div[2]/div/span[1]";
    private static final String FIELD2_UNCHECK_SIGN = "/html/body/app-root/app-vet-add/div/div/form/div[3]/div/span[1]";
    private static final String FIELD1_REQUIRED_ERROR = "/html/body/app-root/app-vet-add/div/div/form/div[2]/div/span[2]";
    private static final String FIELD2_REQUIRED_ERROR = "/html/body/app-root/app-vet-add/div/div/form/div[3]/div/span[2]";
    public AddVetPage(WebDriver driver) {
        super(driver);
    }

    public void addVetForm() {
        super.goTo(URL);
    }

    public void fillInForm() {
        fill("firstName", "Kristan");
        fill("lastName", "Franklin");
        xPathClick("/html/body/app-root/app-vet-add/div/div/form/div[4]/div/div/select");
        xPathClick("/html/body/app-root/app-vet-add/div/div/form/div[4]/div/div/select/option[1]");
    }

    public boolean areNameFieldsChecked() {
        return checkTwoPathsExists(FIELD1_CHECK_SIGN, FIELD2_CHECK_SIGN);
    }

    public void submit() {
        xPathClick("/html/body/app-root/app-vet-add/div/div/form/div[5]/div/button[2]");
    }


    public void fillInNameFields() {
        fill("firstName", "G");
        fill("lastName", "F");
    }

    public boolean areNameFieldsShort() {
        return checkTwoPathsExists(NAME1_SHORT_ERROR, NAME2_SHORT_ERROR);
    }

    public boolean areNameFieldsUnchecked() {
        return checkTwoPathsExists(FIELD1_UNCHECK_SIGN, FIELD2_UNCHECK_SIGN);
    }

    public void removeValues() {
        remove("lastName");
        remove("firstName");
    }

    public boolean areNameFieldsRequired() {
        return checkTwoPathsExists(FIELD1_REQUIRED_ERROR, FIELD2_REQUIRED_ERROR);

    }

    public void fillInWithSymbols() {
        fill("firstName", "@#$%^");
        fill("lastName", "@#$%");
    }
}