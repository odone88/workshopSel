package RestOfPages;

import ViewPages.LongerViewPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartSummaryPage extends BasePage{

    public ShoppingCartSummaryPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    final By quantityOfAddedElements = By.cssSelector("[class*='cart_quantity_input']");

    final By priceFor2ChiffonDress = By.id("total_product_price_7_35_0");

    final By continueShoppingBtn = By.cssSelector("a[title='Continue shopping']");





    public String getQuantityOfAddedElements(){
        return getValueAttributeFromElement(quantityOfAddedElements);
    }

    public String getPriceFor2ChiffonDress(){
        return getTextOfElement(priceFor2ChiffonDress);
    }

    public LongerViewPage clickOnContinueShopping(){
        click(continueShoppingBtn);
        return new LongerViewPage(driver, wait);
    }

    public AuthenticationPage clickOnProceed(){
        //Actions action = new Actions(driver);
        //action.moveToElement(driver.findElement(proceedToCheckoutBtn)).build().perform();
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].scrollIntoView();", findElement(proceedToCheckoutBtn));
        click(proceedToCheckoutBtn2);
        return new AuthenticationPage(driver, wait);
    }
}
