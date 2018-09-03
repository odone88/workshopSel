package RestOfPages;

import Driver.Driver;
import ViewPages.LongerViewPage;
import ViewPages.QuickViewPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchedItemPage extends BasePage{


    final By fadedShortTShirt = By.xpath("//*[contains(text(), 'Faded Short')]");

    final By printedChiffonDress = By.cssSelector("h5 a[title='Printed Chiffon Dress']");

    final By quickViewPrintedChiffonDress = By.xpath("//*[@title='Printed Chiffon Dress']/../a[2]/span");



    public boolean isFadedElementPresent(){
        return isElementPresent(fadedShortTShirt);
    }

    public boolean isPrintedChiffonDressElementPresent(){
        return isElementPresent(printedChiffonDress);
    }

    public LongerViewPage clickOnPrintedChiffonDress(){
        click(printedChiffonDress);
        return new LongerViewPage();
    }

    public QuickViewPage hoverQuickViewAndClickIt(){
        //scrollToElement2(printedChiffonDress);
        mouseOver(printedChiffonDress);
        click(quickViewPrintedChiffonDress);
        return new QuickViewPage();
    }


}
