package org.springframework.samples.petclinic.pages;

import org.openqa.selenium.WebDriver;

public class AddVisitPage extends Page {

    private static final String URL = "http://localhost:8081/petclinic/owners/10";


    public AddVisitPage(WebDriver driver) {
        super(driver);
    }

    public void addVisitForm() {
        super.goTo(URL);
    }

    public void addVisitButton() {
        xPathClick("/html/body/app-root/app-owner-detail/div/div/table[2]/tr/app-pet-list[1]/table/tr/td[1]/dl/button[3]");
    }

    public void fillInForm() {

        fillDate("#visit > div.form-group.has-feedback > div:nth-child(1) > div > input", "2020/05/23");
        fill("description", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        submit();
    }


    public void fillInDate() {
        fillDate("#visit > div.form-group.has-feedback > div:nth-child(1) > div > input", "Fifth of May");
        fill("description", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        submit();
    }

    public void fillInDescription() {
        fillDate("#visit > div.form-group.has-feedback > div:nth-child(1) > div > input", "2020/05/23");
        fill("description", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent tempus eleifend risus ut congue. Pellentesque nec lacus elit. Pellentesque convallis nisi ac augue pharetra eu tristique neque consequat. Praesent tempus eleifend risus ut congue. Praesent tempus eleifend risus ut congue.");
        submit();
    }

    public void validDate() {
        fillDate("#visit > div.form-group.has-feedback > div:nth-child(1) > div > input", "2020/05/23");
        submit();
    }

    public void emptyDescription() {
        submit();
    }

    public void emptyForm() {
        submit();
    }

    public void submit() {
        xPathClick("//*[@id=\"visit\"]/div[2]/div/button[2]");
    }

    public void visitdetailsDisplyed() {
        elementDoesExist("/html/body/app-root/app-owner-detail/div/div/table[2]/tr/app-pet-list[1]/table/tr/td[2]/app-visit-list/table/tr");
    }

}
