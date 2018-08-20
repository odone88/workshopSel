package RestOfPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BasePage{

    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    final By searchLabelTxt = By.cssSelector("[id='search_query_top']");
    final By sumbitSearchBtn = By.cssSelector("[name='submit_search']");
    final By blouse = By.cssSelector("img[title='Blouse']");
    final By addToCartButton = By.cssSelector("a[data-id-product='2']");
    final By dressesBtn = By.xpath("//*[contains(@class,'submenu-container')]/../a[contains(text(),'Dresses')]");



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




}
