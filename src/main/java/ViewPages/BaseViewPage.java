package ViewPages;

import RestOfPages.BasePage;
import RestOfPages.ConfirmationBuyingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseViewPage extends BasePage {

    public BaseViewPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    final By addToCartButton = By.xpath("//span[contains(text(),'Add')]");
    final By addQuantityBtn = By.cssSelector(".icon-plus");
    final By sizeDropDown = By.cssSelector("#group_1");
    final By quickViewIFrame = By.cssSelector(".fancybox-iframe");

    public ConfirmationBuyingPage clickOnAddToCartBtn(){
        click(addToCartButton);
        return new ConfirmationBuyingPage(driver, wait);
    }


}
