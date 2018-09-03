package RestOfPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DressesPage extends BasePage{


    final By discount = By.cssSelector(".price-percent-reduction");
    final By newPrice = By.cssSelector(".price");
    final By oldPrice = By.cssSelector(".old-price");

    final By dressesWithDiscount = By.xpath("//*[@class='right-block']//span[@class='price-percent-reduction']//parent::div");

    List<WebElement> dressesWithDiscountsList = findElements(dressesWithDiscount);

    public boolean checkIfDiscountsAreCorrectlyCalculated() {
        boolean ifDressesDiscountOk = false;
        for (WebElement el : dressesWithDiscountsList) {

            String discountString = getTextOfWebElement(el.findElement(discount)).replace("%", "").replace(" ", "").replace("-", "");
            float discountFloat = Float.parseFloat(discountString);

            String priceString = getTextOfWebElement(el.findElement(newPrice)).replace("$", "").replace(" ", "");
            float priceFloat = Float.parseFloat(priceString);

            String priceStringOld = getTextOfWebElement(el.findElement(oldPrice)).replace("$", "").replace(" ", "");
            float priceFloatOld = Float.parseFloat(priceStringOld);

            float checkPriceAfterDiscount = priceFloatOld - (discountFloat / 100) * priceFloatOld;
            ifDressesDiscountOk = priceFloat == checkPriceAfterDiscount;
        }
        return ifDressesDiscountOk;
    }


}
