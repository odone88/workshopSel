package RestOfPages;

import Driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class AuthenticationPage extends BasePage{


    final By emailTxt = By.id("email");

    final By passwordTxt = By.id("passwd");

    final By signInBtn = By.id("SubmitLogin");







    public void clickOnEmailAndClickTab(){
        click(emailTxt);
        insertText(emailTxt,"blablabla");
        actions.sendKeys(Keys.TAB).build().perform();
    }

    public String checkIfPasswordActive(){
        WebElement currentElement = Driver.getDriver().switchTo().activeElement();
        return currentElement.getAttribute("name");
    }

    public AddressesPage enterEmailAndPasswordAndClickOk(){
        insertText(emailTxt, "zzz@z.com");
        insertText(passwordTxt, "zzzzz");
        click(signInBtn);
        return new AddressesPage();
    }



}
