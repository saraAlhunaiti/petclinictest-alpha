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
import static org.openqa.selenium.By.cssSelector;

public class Page {
    static {
        System.setProperty("webdriver.chrome.driver", "/chromedriver.exe");
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
        driver.findElement(cssSelector(path)).sendKeys(value);
    }

//    protected void delete(String path) {
//        driver.findElement(cssSelector(path)).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
//    }

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


    protected boolean exists(String id) {
        return driver.findElement(By.id(id)) != null;
    }



    protected boolean elementDoesExist (String path) {
        List<WebElement> dynamicElement = driver.findElements(By.xpath(path));
        return dynamicElement.size() < dynamicElement.size() + 1;
    }


    protected boolean removeItem (String path){
        List<WebElement> RemovedElement = driver.findElements(By.xpath(path));
        return RemovedElement.size() > RemovedElement.size() - 1;
    }



    public boolean isCurrent(String url) {
        return url.equals(driver.getCurrentUrl());
    }

//

}

