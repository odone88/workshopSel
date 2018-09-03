package RestOfPages;

import Driver.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class BasePage {

    protected WebDriverWait wait;
    protected Actions actions;
    JavascriptExecutor js;

    public BasePage() {
        wait = new WebDriverWait(Driver.getDriver(), 20);
        actions = new Actions(Driver.getDriver());
        js = (JavascriptExecutor) Driver.getDriver();
    }

    final By proceedToCheckoutBtn = By.xpath("//*[contains(text(), 'Proceed')]");

    final By proceedToCheckoutBtn2 = By.cssSelector("p.cart_navigation span");

    protected boolean isElementPresent(By by) {
        try {
            Driver.getDriver().findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    protected void click(By locator) {
        try{
            waitForElement(locator);
            Driver.getDriver().findElement(locator).click();
        }
        catch(StaleElementReferenceException e){
            Driver.getDriver().findElement(locator).click();
        }
    }

    protected void waitForElement(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected String getTextOfElement(By locator){
        waitForElement(locator);
        return Driver.getDriver().findElement(locator).getText();
    }

    protected String getTextOfWebElement(WebElement element){
        wait.until((ExpectedConditions.elementToBeClickable(element)));
        return element.getText();
    }

    protected String getValueAttributeFromElement(By locator){
        waitForElement(locator);
        return Driver.getDriver().findElement(locator).getAttribute("value");
    }

    protected void insertText(By locator, String text) {
        waitForElement(locator);
        Driver.getDriver().findElement(locator).clear();
        Driver.getDriver().findElement(locator).sendKeys(text);
    }

    protected void mouseOver(By by) {
        waitForElementAndReturn(by, 25);
        actions.moveToElement(Driver.getDriver().findElement(by)).build().perform();
    }

    protected void chooseItemFromDropDownByName(By dropdownLocator, String name){
        waitForElementAndReturn(dropdownLocator, 20);
        new Select(Driver.getDriver().findElement(dropdownLocator)).selectByVisibleText(name);
    }

    protected WebElement waitForElementAndReturn(By locator, int timeoutInSeconds){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeoutInSeconds);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return Driver.getDriver().findElement(locator);
    }

    protected WebElement findElement(By elementBy){
        return Driver.getDriver().findElement(elementBy);
    }

    protected List<WebElement> findElements(By elementBy){
        return Driver.getDriver().findElements(elementBy);
    }

    protected void scrollToElement(By by){
        waitForElementAndReturn(by, 25);
        actions.moveToElement(Driver.getDriver().findElement(by));
    }

    protected void scrollToElement2(By by){
        waitForElementAndReturn(by, 25);
        js.executeScript("arguments[0].scrollIntoView();", findElement(by));
    }




}
