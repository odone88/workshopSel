package RestOfPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderConfirmation extends BasePage{


    final By finalSuccess = By.cssSelector(".cheque-indent strong");

    public String getFinalSuccessText(){
        return getTextOfElement(finalSuccess);
    }

}
