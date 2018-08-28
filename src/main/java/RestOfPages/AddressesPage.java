package RestOfPages ;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddressesPage extends BasePage{
    public AddressesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public ShippingPage clickOnProceed(){
        click(proceedToCheckoutBtn2);
        return new ShippingPage(driver, wait);
    }

}
