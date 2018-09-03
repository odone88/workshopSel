package RestOfPages ;

import Driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddressesPage extends BasePage{



    public ShippingPage clickOnProceed(){
        click(proceedToCheckoutBtn2);
        return new ShippingPage();
    }

}
