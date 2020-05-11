package org.springframework.samples.petclinic.pages;

import org.openqa.selenium.WebDriver;

public class EditPetPage extends Page {
private static final String URL = "http://localhost:8081/petclinic/owners/1";


        public EditPetPage(WebDriver driver) {
            super(driver);
        }
    public void editPetForm(){
        super.goTo(URL);
    }


    public void fillInForm() {
        xPathClick("/html/body/app-root/app-owner-detail/div/div/table[2]/tr/app-pet-list[1]/table/tr/td[1]/dl/button[1]");
        fill("name","marshmallow");
        fillDate("body > app-root > app-pet-edit > div > div > form > div:nth-child(5) > input","2020/05/20");
        //ToDO: date is not updated
        selectFirst("type");
        submit();

    }
    public void fillInEmptyForm() {
        xPathClick("/html/body/app-root/app-owner-detail/div/div/table[2]/tr/app-pet-list[1]/table/tr/td[1]/dl/button[1]");
        fill("name","");
        fillDate("body > app-root > app-pet-edit > div > div > form > div:nth-child(5) > input","");
        selectFirst("type");
        submit();
    }
    public void submit() {
        xPathClick("/html/body/app-root/app-pet-edit/div/div/form/div[6]/div/button[2]");
    }


    public void fillNumAndSymbolsName() {
        xPathClick("/html/body/app-root/app-owner-detail/div/div/table[2]/tr/app-pet-list[1]/table/tr/td[1]/dl/button[1]");
        fill("name","2134@$%$#^245");


    }

    public void fillInDate(){
        xPathClick("/html/body/app-root/app-owner-detail/div/div/table[2]/tr/app-pet-list[1]/table/tr/td[1]/dl/button[1]");

        fillDate("body > app-root > app-pet-edit > div > div > form > div:nth-child(5) > input", "Fifth of May");
        submit();
    }

    public void updatedData() {
        elementIsUpdated("//*[text()='marshmallow']");
        // todo: check for updated data
    }
}
