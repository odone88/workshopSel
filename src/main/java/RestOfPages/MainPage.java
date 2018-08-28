package RestOfPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class MainPage extends BasePage{

    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    final By searchLabelTxt = By.cssSelector("[id='search_query_top']");
    final By sumbitSearchBtn = By.cssSelector("[name='submit_search']");
    final By blouse = By.cssSelector("img[title='Blouse']");
    final By addToCartButton = By.cssSelector("a[data-id-product='2']");
    final By dressesBtn = By.xpath("//*[contains(@class,'submenu-container')]/../a[contains(text(),'Dresses')]");
    final By signInBtn = By.cssSelector(".login");

    final By fbLink = By.cssSelector("[class='facebook'] a");
    final By twitterLink = By.cssSelector("[class='twitter'] a");
    final By youtubeLink = By.cssSelector("[class='youtube'] a");
    final By googleLink = By.cssSelector("[class='google-plus'] a");



    public SearchedItemPage searchForItem(String faded) {
        insertText(searchLabelTxt, faded);
        click(sumbitSearchBtn);
        return new SearchedItemPage(driver, wait);
    }

    public MainPage mouseOverBlouse(){
        mouseOver(blouse);
        return this;
    }

    public ConfirmationBuyingPage clickAddToCartButton(){
        click(addToCartButton);
        return new ConfirmationBuyingPage(driver, wait);
    }

    public DressesPage clickOnDressesCategoryBtn(){
        click(dressesBtn);
        return new DressesPage(driver, wait);
    }


    public AuthenticationPage clickOnSignInBtn() {
        click(signInBtn);
        return new AuthenticationPage(driver, wait);
    }

    public MainPage clickOnFbLink(){
        click(fbLink);
        return this;
    }

    public MainPage clickOnTwitterPage(){
        click(twitterLink);
        return this;
    }

    public MainPage clickOnYouTubeLink(){
        click(youtubeLink);
        return this;
    }

    public MainPage clickOnGoogleLink(){
        click(googleLink);
        return this;
    }

    public String SwitchToDifferentWindowAndGetTitle(){
        String  currentHandle= driver.getWindowHandle();
        String actualTitle = "";
        for (String handle : driver.getWindowHandles()) {
            if(!handle.equals(currentHandle)){
                driver.switchTo().window(handle);
                actualTitle = driver.getTitle();
                break;
            }
        }
        return actualTitle;
    }



}
