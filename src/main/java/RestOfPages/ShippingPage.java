package RestOfPages ;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShippingPage extends BasePage{

    public ShippingPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    final By agreeTermsCheck = By.id("uniform-cgv");

    public ShippingPage clickOnAgreeAgreement(){
        if (driver.findElement(agreeTermsCheck).isSelected() == false) {
            mouseOver(agreeTermsCheck);
            click(agreeTermsCheck);
        }
        return this;
    }

    public PaymentPage clickOnProceed(){
        click(proceedToCheckoutBtn2);
        return new PaymentPage(driver, wait);
    }
    }
