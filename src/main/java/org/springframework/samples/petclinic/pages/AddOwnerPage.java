package org.springframework.samples.petclinic.pages;

import org.openqa.selenium.WebDriver;

public class AddOwnerPage extends Page {
    private static final String URL = "http://localhost:8081/petclinic/owners/add";
    private static final String FIELD1_CHECK_SIGN = "/html/body/app-root/app-owner-add/div/div/form/div[2]/div/span\n";
    private static final String FIELD2_CHECK_SIGN = "/html/body/app-root/app-owner-add/div/div/form/div[3]/div/span";
    private static final String FIELD3_CHECK_SIGN = "/html/body/app-root/app-owner-add/div/div/form/div[4]/div/span";
    private static final String FIELD4_CHECK_SIGN = "/html/body/app-root/app-owner-add/div/div/form/div[5]/div/span";
    private static final String FIELD5_CHECK_SIGN = "/html/body/app-root/app-owner-add/div/div/form/div[6]/div/span";
    private static final String FIELD1_UNCHECK_SIGN = "/html/body/app-root/app-owner-add/div/div/form/div[2]/div/span[1]";
    private static final String FIELD2_UNCHECK_SIGN = "/html/body/app-root/app-owner-add/div/div/form/div[3]/div/span[1]";
    private static final String FIELD3_UNCHECK_SIGN = "/html/body/app-root/app-owner-add/div/div/form/div[4]/div/span[1]";
    private static final String FIELD4_UNCHECK_SIGN = "/html/body/app-root/app-owner-add/div/div/form/div[5]/div/span[1]";
    private static final String FIELD5_UNCHECK_SIGN = "/html/body/app-root/app-owner-add/div/div/form/div[6]/div/span[1]";
    private static final String NAME1_SHORT_ERROR = "/html/body/app-root/app-owner-add/div/div/form/div[2]/div/span[2]";
    private static final String NAME2_SHORT_ERROR = "/html/body/app-root/app-owner-add/div/div/form/div[3]/div/span[2]";
    private static final String FIELD1_REQUIRED_ERROR = "/html/body/app-root/app-owner-add/div/div/form/div[2]/div/span[2]";
    private static final String FIELD2_REQUIRED_ERROR = "/html/body/app-root/app-owner-add/div/div/form/div[3]/div/span[2]";
    private static final String FIELD3_REQUIRED_ERROR = "/html/body/app-root/app-owner-add/div/div/form/div[4]/div/span[2]";
    private static final String FIELD4_REQUIRED_ERROR = "/html/body/app-root/app-owner-add/div/div/form/div[5]/div/span[2]";
    private static final String FIELD5_REQUIRED_ERROR = "/html/body/app-root/app-owner-add/div/div/form/div[6]/div/span[2]";
    private static final String CHARACTER_TELEPHONE_ERROR = "/html/body/app-root/app-owner-add/div/div/form/div[6]/div/span[2]";


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
        fillInForm();
        fill("telephone", "None");
    }


    public void fillInWithSymbols() {
        fill("firstName", "@#$%^");
        fill("lastName", "@#$%");
        fill("address", "@#$%");
        fill("city", "@#$%");
        fill("telephone", "9112348976");
    }

    public boolean areAllFieldsChecked() {
        return checkAllPathsExists(FIELD1_CHECK_SIGN, FIELD2_CHECK_SIGN, FIELD3_CHECK_SIGN, FIELD4_CHECK_SIGN, FIELD5_CHECK_SIGN);
    }

    public boolean areNameFieldsUnchecked() {
        return checkTwoPathsExists(FIELD1_UNCHECK_SIGN, FIELD2_UNCHECK_SIGN);
    }

    public boolean areNameFieldsShort() {
        return checkTwoPathsExists(NAME1_SHORT_ERROR, NAME2_SHORT_ERROR);
    }

    public boolean areAllFieldsRequired() {
        return checkAllPathsExists(FIELD1_REQUIRED_ERROR, FIELD2_REQUIRED_ERROR, FIELD3_REQUIRED_ERROR, FIELD4_REQUIRED_ERROR, FIELD5_REQUIRED_ERROR);
    }

    public boolean areAllFieldsUnchecked() {
        return checkAllPathsExists(FIELD1_UNCHECK_SIGN, FIELD2_UNCHECK_SIGN, FIELD3_UNCHECK_SIGN, FIELD4_UNCHECK_SIGN, FIELD5_UNCHECK_SIGN);
    }

    public boolean isTelephoneFieldNumber() {
        return exists(CHARACTER_TELEPHONE_ERROR);
    }

    public boolean isTelephoneFieldUnchecked() {
        return exists(FIELD5_UNCHECK_SIGN);
    }

    public boolean checkOwnerIsAdded() {
        String path = "/html/body/app-root/app-owner-list";
        return (elementDoesExist(path));

    }

    public void submit() {
        xPathClick("/html/body/app-root/app-owner-add/div/div/form/div[7]/div/button[2]");
    }


}
