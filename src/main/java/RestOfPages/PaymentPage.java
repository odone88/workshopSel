package RestOfPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage extends BasePage{

    public PaymentPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    final By amountOfElements = By.cssSelector("td[class*= 'cart_quantity'] span");

    final By priceWithoutShipping = By.cssSelector(".cart_total span.price");

    final By payByBankWireBtn = By.cssSelector("a.bankwire");

    final By proceedToCheckoutBtn = By.xpath("//*[contains(text(), 'I confirm')]");

    public String getAmountOfElements(){
        return driver.findElement(amountOfElements).getText();
    }

    public String getpriceOfTwoElementsWithoutShipping()
    {
    return driver.findElement(priceWithoutShipping).getText();
    }

    public PaymentPage clickOnBankWirePayment(){
        click(payByBankWireBtn);
        return this;
    }

    public OrderConfirmation confirmOrder(){
        click(proceedToCheckoutBtn);
        return new OrderConfirmation(driver, wait);
    }

}
