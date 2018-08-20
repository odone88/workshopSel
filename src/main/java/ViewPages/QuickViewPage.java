package ViewPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QuickViewPage extends BaseViewPage {

    public QuickViewPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public QuickViewPage changeToPrintedChiffonDressFrame(){
        driver.switchTo().frame(findElement(quickViewIFrame));
        return this;
    }

    public QuickViewPage addQuantityByOne(){
        click(addQuantityBtn);
        return this;
    }

    public QuickViewPage changeDressSizeToM(){
        chooseItemFromDropDownByName(sizeDropDown, "M");
        return this;
    }






}
