package RestOfPages;

import Driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfirmationBuyingPage extends BasePage{



    final By successElement = By.xpath("//div[starts-with(@class, 'layer_cart_product')]//h2");





    public String getSuccessTextElement(){
        return getTextOfElement(successElement);
    }

    public ShoppingCartSummaryPage clickOnProceedToCheckoutBtn() {
        click(proceedToCheckoutBtn);
        return new ShoppingCartSummaryPage();
    }








}
