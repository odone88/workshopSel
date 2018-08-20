package ViewPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LongerViewPage extends BaseViewPage {

    public LongerViewPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public LongerViewPage addQuantityByOne(){
        click(addQuantityBtn);
        return this;
    }

    public LongerViewPage changeDressSizeToM(){
        chooseItemFromDropDownByName(sizeDropDown, "M");
        return this;
    }







}
