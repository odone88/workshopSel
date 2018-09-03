package ViewPages;

import Driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QuickViewPage extends BaseViewPage {

    public QuickViewPage changeToPrintedChiffonDressFrame(){
        Driver.getDriver().switchTo().frame(findElement(quickViewIFrame));
        return this;
    }

    public QuickViewPage addQuantityByOne(){
        click(addQuantityBtn);
        return this;
    }

    public QuickViewPage changeDressSizeToM(String size){
        chooseItemFromDropDownByName(sizeDropDown, size);
        return this;
    }






}
