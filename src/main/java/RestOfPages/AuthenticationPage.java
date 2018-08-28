package RestOfPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthenticationPage extends BasePage{
    public AuthenticationPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    final By emailTxt = By.id("email");

    final By passwordTxt = By.id("passwd");

    final By signInBtn = By.id("SubmitLogin");







    public void clickOnEmailAndClickTab(){
        click(emailTxt);
        insertText(emailTxt,"blablabla");
        //pewnie mozna ladniej zrobic
        Actions a = new Actions(driver);
        a.sendKeys(Keys.TAB).build().perform();
    }

    public String checkIfPasswordActive(){
        WebElement currentElement = driver.switchTo().activeElement();
        return currentElement.getAttribute("name");
    }

    public AddressesPage enterEmailAndPasswordAndClickOk(){
        insertText(emailTxt, "zzz@z.com");
        insertText(passwordTxt, "zzzzz");
        click(signInBtn);
        return new AddressesPage(driver, wait);
    }



}
