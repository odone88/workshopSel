package RestOfPages;

import Driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class MainPage extends BasePage{


    final By searchLabelTxt = By.cssSelector("[id='search_query_top']");
    final By sumbitSearchBtn = By.cssSelector("[name='submit_search']");
    final By blouse = By.cssSelector("img[title='Blouse']");
    final By addToCartButton = By.cssSelector("a[data-id-product='2']");
    final By dressesBtn = By.xpath("//*[contains(@class,'submenu-container')]/../a[contains(text(),'Dresses')]");
    final By signInBtn = By.cssSelector(".login");

    final String appString = "li.";



    public SearchedItemPage searchForItem(String faded) {
        insertText(searchLabelTxt, faded);
        click(sumbitSearchBtn);
        return new SearchedItemPage();
    }

    public MainPage mouseOverBlouse(){
        mouseOver(blouse);
        return this;
    }

    public ConfirmationBuyingPage clickAddToCartButton(){
        click(addToCartButton);
        return new ConfirmationBuyingPage();
    }

    public DressesPage clickOnDressesCategoryBtn(){
        click(dressesBtn);
        return new DressesPage();
    }


    public AuthenticationPage clickOnSignInBtn() {
        click(signInBtn);
        return new AuthenticationPage();
    }

    public MainPage clickOnAppLink(String string){
        click(By.cssSelector(appString + string));
        return this;
    }


    public String SwitchToDifferentWindowAndGetTitle(){
        String  currentHandle= Driver.getDriver().getWindowHandle();
        String actualTitle = "";
        for (String handle : Driver.getDriver().getWindowHandles()) {
            if(!handle.equals(currentHandle)){
                Driver.getDriver().switchTo().window(handle);
                actualTitle = Driver.getDriver().getTitle();
                break;
            }
        }
        return actualTitle;
    }



}
