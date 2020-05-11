package org.springframework.samples.petclinic.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
<<<<<<< HEAD
=======

import java.util.ArrayList;
>>>>>>> master
import java.util.List;
import java.util.logging.Level;
import static java.util.logging.Logger.getLogger;
import static org.openqa.selenium.By.cssSelector;
<<<<<<< HEAD
=======
import static org.openqa.selenium.By.id;
>>>>>>> master

public class Page {
    static {
        //System.setProperty("webdriver.chrome.driver", "/Users/chromedriver");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
    }


    private final WebDriver driver;

    protected Page(WebDriver driver) {
        this.driver = driver;

    }


    protected void goTo(String url) {
        driver.get(url);
    }


    protected void xPathClick(String path) {
        driver.findElement(By.xpath(path)).click();
    }

<<<<<<< HEAD
=======
    protected void remove(String id) {
        final WebElement element = waitFor(id);
        element.clear();
        element.sendKeys(" \b");
    }

    protected boolean xPathExists(String xPath) {
        return driver.findElement(By.xpath(xPath)) != null;
    }

    protected boolean elementIsUpdated (String text){
        WebElement textDemo = driver.findElement(By.xpath(text));
        if(textDemo.isDisplayed()) {
            return true;
        } else{
            return false;}
    }

    protected void fillDate(String path, String value) {
        driver.findElement(cssSelector(path)).sendKeys(value);
    }



    protected void delete(String path) {
        driver.findElement(cssSelector(path)).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
    }


    public boolean isExisting(String path){
        return driver.findElement(By.xpath(path)).isDisplayed();
    }

    public boolean exists(String xPath) {
        return driver.findElement(By.xpath(xPath)) != null;
    }
    protected boolean elementDoesExist(String path) {

        List<WebElement> dynamicElement = driver.findElements(By.xpath(path));

        return dynamicElement.size() < dynamicElement.size() + 1;
    }


    public boolean checkAllPathsExists(String path1, String path2, String path3, String path4, String path5) {
        return (exists(path1) && exists(path2) && exists(path3) && exists(path4) && exists(path5));
    }

    public boolean checkTwoPathsExists(String path1, String path2) {
        return (exists(path1) && exists(path2));
    }

>>>>>>> master
    protected String getText(String cssPath) {
        return driver.findElement(By.xpath(cssPath)).getText();
    }

    protected void fill(String id, String value) {
        final WebElement element = waitFor(id);
        element.clear();
        element.sendKeys(value);
    }

    protected void selectFirst(String id) {
        new Select(driver.findElement(By.id(id))).selectByIndex(1);
    }

<<<<<<< HEAD
    protected void fillDate(String path, String value) {
        driver.findElement(cssSelector(path)).sendKeys(value);
    }

//    protected void delete(String path) {
//        driver.findElement(cssSelector(path)).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
//    }

    protected void editdelete(String path) {
        driver.findElement(By.cssSelector(path)).clear();
        driver.findElement(By.cssSelector(path)).sendKeys("a");
        driver.findElement(By.cssSelector(path)).sendKeys("\b");
=======
    protected void select(String id, int i) {
        new Select(driver.findElement(id(id))).selectByIndex(1);
    }
    public boolean isCurrent(String url) {
        return url.equals(driver.getCurrentUrl());
>>>>>>> master
    }


    protected void editdelete(String path) {
        driver.findElement(By.cssSelector(path)).clear();
        driver.findElement(By.cssSelector(path)).sendKeys("a");
        driver.findElement(By.cssSelector(path)).sendKeys("\b");
    }

    protected void click(String id) {
        waitFor(id).click();
    }

    private WebElement waitFor(String id) {
        return waitFor(id, 5);
    }

    private WebElement waitFor(String id, int waitInterval) {
        return (new WebDriverWait(driver, waitInterval)).until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
    }

<<<<<<< HEAD

    protected boolean exists(String id) {
        return driver.findElement(By.id(id)) != null;
=======
    public List<String> allPets(){
        List<WebElement> allPets = driver.findElements(By.xpath("/html/body/app-root/app-owner-detail/div/div/table[2]/tr/app-pet-list/table/tr/td[1]/dl/dd[1]"));
        List<String> petsNames=new ArrayList<>();
        for(WebElement pet: allPets)
        {
            petsNames.add(pet.getText());
        }
        return petsNames;
>>>>>>> master
    }

    public void fillInPetForm(String name, String birthDate, int typeIndex) {
        delete("body > app-root > app-pet-edit > div > div > form > div:nth-child(5) > input");
        fill("name",name);
        fillDate("body > app-root > app-pet-edit > div > div > form > div:nth-child(5) > input",birthDate);
        select("type",typeIndex);
    }

<<<<<<< HEAD

    protected boolean elementDoesExist (String path) {
        List<WebElement> dynamicElement = driver.findElements(By.xpath(path));
        return dynamicElement.size() < dynamicElement.size() + 1;
    }


    protected boolean removeItem (String path){
=======
    protected boolean removeItem(String path){
>>>>>>> master
        List<WebElement> RemovedElement = driver.findElements(By.xpath(path));
        return RemovedElement.size() > RemovedElement.size() - 1;
    }


<<<<<<< HEAD

    public boolean isCurrent(String url) {
        return url.equals(driver.getCurrentUrl());
=======
        return RemovedElement.size() > RemovedElement.size()-1;
>>>>>>> master
    }

//

}

