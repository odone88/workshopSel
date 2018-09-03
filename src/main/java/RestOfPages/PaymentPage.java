package RestOfPages;

import Driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage extends BasePage{


    final By amountOfElements = By.cssSelector("td[class*= 'cart_quantity'] span");

    final By priceWithoutShipping = By.cssSelector(".cart_total span.price");

    final By payByBankWireBtn = By.cssSelector("a.bankwire");

    final By proceedToCheckoutBtn = By.xpath("//*[contains(text(), 'I confirm')]");

    public String getAmountOfElements(){
        return getTextOfElement(amountOfElements);
    }

    public String getpriceOfTwoElementsWithoutShipping()
    {
    return getTextOfElement(priceWithoutShipping);
    }

    public PaymentPage clickOnBankWirePayment(){
        click(payByBankWireBtn);
        return this;
    }

    public OrderConfirmation confirmOrder(){
        click(proceedToCheckoutBtn);
        return new OrderConfirmation();
    }

}
