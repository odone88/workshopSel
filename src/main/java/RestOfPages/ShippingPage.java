package RestOfPages ;

import Driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShippingPage extends BasePage{



    final By agreeTermsCheck = By.id("uniform-cgv");

    public ShippingPage clickOnAgreeAgreement(){
        if (Driver.getDriver().findElement(agreeTermsCheck).isSelected() == false) {
            mouseOver(agreeTermsCheck);
            click(agreeTermsCheck);
        }
        return this;
    }

    public PaymentPage clickOnProceed(){
        click(proceedToCheckoutBtn2);
        return new PaymentPage();
    }
    }
