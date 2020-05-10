package org.springframework.samples.petclinic.pages;

import org.openqa.selenium.WebDriver;

public class EditVisitPage extends Page {
private static final String URL = "http://localhost:8081/petclinic/owners/1";


        public EditVisitPage(WebDriver driver) {
            super(driver);
        }
    public void editVisitPage() {
        super.goTo(URL);
    }


        public void fillInForm() {
            xPathClick("/html/body/app-root/app-owner-detail/div/div/table[2]/tr/app-pet-list/table/tr/td[2]/app-visit-list/table/tr/td[3]/button[1]");
            fillDate("#visit > div.form-group.has-feedback > div:nth-child(1) > div > input", "2020/05/19");
            fill("description", "Pellentesque nec lacus elit. Pellentesque convallis nisi ac augue pharetra eu tristique neque consequat.");
            submit();
        }

        public void fillInDate(){
            xPathClick("/html/body/app-root/app-owner-detail/div/div/table[2]/tr/app-pet-list/table/tr/td[2]/app-visit-list/table/tr/td[3]/button[1]");

            fillDate("#visit > div.form-group.has-feedback > div:nth-child(1) > div > input", "Fifth of May");
            submit();
        }

        public void emptyForm(){
            xPathClick("/html/body/app-root/app-owner-detail/div/div/table[2]/tr/app-pet-list/table/tr/td[2]/app-visit-list/table/tr/td[3]/button[1]");
            submit();
        }

        public void submit() {
            xPathClick("//*[@id=\"visit\"]/div[2]/div/button[2]");
        }

    }
