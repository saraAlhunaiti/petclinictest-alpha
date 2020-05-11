package org.springframework.samples.petclinic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.logging.Level;

import static java.util.logging.Logger.getLogger;

public class Page  {
    static {
        System.setProperty("webdriver.chrome.driver", "/Users/chromedriver");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
    }

    private final WebDriver driver;
    protected Page(WebDriver driver) {
        this.driver = driver; }


    protected void goTo(String url) {
        driver.get(url);
    }


    protected void xPathClick(String path) {
        driver.findElement(By.xpath(path)).click();
    }

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


    protected boolean elementDoesExist(String path) {

        List<WebElement> dynamicElement = driver.findElements(By.xpath(path));

        if (dynamicElement.size() < dynamicElement.size() + 1) {
          System.out.println(true);
            return true;
        } else {
           System.out.println(false);
            return false;
        }
    }

    public boolean isExisting(String path){
        return driver.findElement(By.xpath(path)).isDisplayed();
    }


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

    protected void fillDate(String path, String value) {
        WebElement toClear = driver.findElement(By.cssSelector(path));
        toClear.sendKeys(Keys.CONTROL + "a");
        toClear.sendKeys(Keys.DELETE);
        driver.findElement(By.cssSelector(path)).sendKeys(value);

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

    protected boolean exists(String id) {
        return driver.findElement(By.id(id)) != null;
    }



    protected boolean removevisitdetails(String path){
        List<WebElement> RemovedElement = driver.findElements(By.xpath(path));

        if (RemovedElement.size() > RemovedElement.size()-1) {
            System.out.println(true);
            System.out.println(RemovedElement.size());
            return true;
        }
        else {
            System.out.println(false);
            return false;
        }
    }


}
