package RestOfPages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    final By proceedToCheckoutBtn = By.xpath("//*[contains(text(), 'Proceed')]");

    final By proceedToCheckoutBtn2 = By.cssSelector("p.cart_navigation span");

    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    protected void click(By locator) {
        try{
            waitForElement(locator);
            driver.findElement(locator).click();
        }
        catch(StaleElementReferenceException e){
            driver.findElement(locator).click();
        }
    }

    protected void waitForElement(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected String getTextOfElement(By locator){
        waitForElement(locator);
        return driver.findElement(locator).getText();
    }

    protected String getTextOfWebElement(WebElement element){
        wait.until((ExpectedConditions.elementToBeClickable(element)));
        return element.getText();
    }

    protected String getValueAttributeFromElement(By locator){
        waitForElement(locator);
        return driver.findElement(locator).getAttribute("value");
    }

    protected void insertText(By locator, String text) {
        waitForElement(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    protected void mouseOver(By by) {
        waitForElementAndReturn(by, 25);
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(by)).build().perform();
    }

    protected void chooseItemFromDropDownByName(By dropdownLocator, String name){
        waitForElementAndReturn(dropdownLocator, 20);
        new Select(driver.findElement(dropdownLocator)).selectByVisibleText(name);
    }

    protected WebElement waitForElementAndReturn(By locator, int timeoutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return driver.findElement(locator);
    }

    protected WebElement findElement(By elementBy){
        return driver.findElement(elementBy);
    }

    protected List<WebElement> findElements(By elementBy){
        return driver.findElements(elementBy);
    }




}
