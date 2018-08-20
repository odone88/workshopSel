package RestOfPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfirmationBuyingPage extends BasePage{

    public ConfirmationBuyingPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    final By successElement = By.xpath("//div[starts-with(@class, 'layer_cart_product')]//h2");

    final By proceedToCheckoutBtn = By.xpath("//*[contains(text(), 'Proceed')]");



    public String getSuccessTextElement(){
        return getTextOfElement(successElement);
    }

    public ShoppingCartSummaryPage clickOnProceedToCheckoutBtn() {
        click(proceedToCheckoutBtn);
        return new ShoppingCartSummaryPage(driver, wait);
    }








}
