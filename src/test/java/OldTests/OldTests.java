/*

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class Tests {




@Test
public void firstTest(){

   System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
   WebDriver driver = new ChromeDriver();
   driver.manage().window().maximize();

   driver.navigate().to("http://automationpractice.com");

   Assert.assertEquals("message", "My Store", driver.getTitle());

   driver.quit();

}

   @Test
   public void shouldUserFindTextFaded(){

      System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
      WebDriver driver = new ChromeDriver();
      driver.manage().window().maximize();

      driver.navigate().to("http://automationpractice.com");

      driver.findElement(By.cssSelector("[id='search_query_top']")).sendKeys("Faded");
      driver.findElement(By.cssSelector("[name='submit_search']")).click();

      Assert.assertTrue("message", driver.findElement(By.xpath("//*[contains(text(), 'Faded Short')]")).isDisplayed());

      driver.quit();

   }

   @Test
   public void shouldUserAddBlouseToTheCart(){

      System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
      WebDriver driver = new ChromeDriver();
      driver.manage().window().maximize();

      driver.navigate().to("http://automationpractice.com");

      WebDriverWait wait = new WebDriverWait(driver, 10);

      Actions action = new Actions(driver);
      WebElement we = driver.findElement(By.cssSelector("img[title='Blouse']"));

      action.moveToElement(we).build().perform();

      By addToCartButton = By.cssSelector("a[data-id-product='2']");

      wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButton));

      driver.findElement(addToCartButton).click();

      By successElement = By.xpath("//div[starts-with(@class, 'layer_cart_product')]//h2");

      wait.until(ExpectedConditions.visibilityOfElementLocated(successElement));

      String successText = driver.findElement(successElement).getText();

      Assert.assertEquals("Item was not added to the cart. Please investigate.", "Product successfully added to your shopping cart" , successText);

      driver.findElement(By.xpath("//*[contains(text(), 'Proceed')]")).click();

      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Summary')]")));

      String quantityOfItems = driver.findElement(By.cssSelector("[class*='cart_quantity_input']")).getAttribute("value");

      Assert.assertEquals("Item was not added to the cart. Please investigate.", "1" , quantityOfItems);

      driver.quit();

   }


    @Test
    public void containerTest(){

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("http://automationpractice.com");

        List<WebElement> containers = driver.findElements(By.cssSelector("ul#homefeatured div.product-container"));

        int count = 0;
        Boolean bla = false;

        if(containers.size() == 7){
            for (WebElement item : containers) {

                if (item.findElement(By.className("product-name")).getText().contains("Dress")) {
                    count++;
                }
                if (count > 0)
                    bla = true;
                else
                    bla = false;
            }

        }


        Assert.assertEquals(true, bla);

        driver.quit();

    }

    @Test
    public void boxesTest(){

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("http://automationpractice.com");

        List<WebElement> boxes = driver.findElements(By.cssSelector("ul#homefeatured a.product-name"));

        int count = 0;
        Boolean bla = false;

        if (boxes.size() == 7){
            for (WebElement item : boxes) {

                if (item.getText().contains("Dress")) {
                    count++;
                }
                if (count > 0)
                    bla = true;
                else
                    bla = false;
            }
        }

        Assert.assertEquals(true, bla);

        driver.quit();

    }



    @Test
    public void arePricesDiscountsAllRightForDresses(){

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 15);
        driver.navigate().to("http://automationpractice.com");

        By dressesBtn = By.xpath("//*[contains(@class,'submenu-container')]/../a[contains(text(),'Dresses')]");
        wait.until(ExpectedConditions.presenceOfElementLocated(dressesBtn));
        driver.findElement(dressesBtn).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".price-percent-reduction")));
        List<WebElement> dressesWithDiscounts = driver.findElements(By.xpath("//*[@class='right-block']//span[@class='price-percent-reduction']//parent::div"));
        By discount = By.cssSelector(".price-percent-reduction");
        By newPrice = By.cssSelector(".price");
        By oldPrice = By.cssSelector(".old-price");

        for(WebElement el : dressesWithDiscounts){

            String discountString = el.findElement(discount).getText().replace("%","").replace(" ","").replace("-","");
            float discountFloat = Float.parseFloat(discountString);

            String priceString = el.findElement(newPrice).getText().replace("$","").replace(" ","");
            float priceFloat = Float.parseFloat(priceString);

            String priceStringOld = el.findElement(oldPrice).getText().replace("$","").replace(" ","");
            float priceFloatOld = Float.parseFloat(priceStringOld);

            float checkPriceAfterDiscount = priceFloatOld - (discountFloat/100)*priceFloatOld;


            Assert.assertEquals(priceFloat, checkPriceAfterDiscount, 0.1);
        }


        driver.quit();

    }


    @Test
    public void doesImplicitWaitWorkWhenAddingAnItemToTheCart(){

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.navigate().to("http://automationpractice.com");


        driver.findElement(By.cssSelector("[id='search_query_top']")).sendKeys("Printed Dress");
        driver.findElement(By.cssSelector("[name='submit_search']")).click();
        WebElement dress = driver.findElement(By.cssSelector("img[title='Printed Chiffon Dress']"));
        assertThat(dress.isDisplayed()).as("Given Dress is displayed").isTrue();
        dress.click();
        By addToCartButton = By.xpath("//span[contains(text(),'Add')]");
        driver.findElement(addToCartButton).click();
        WebElement successText = driver.findElement(By.xpath("//div[starts-with(@class, 'layer_cart_product')]//h2"));
        assertThat(successText.getText()).as("Item was added to the cart without issues").isEqualTo("Product successfully added to your shopping cart");
        driver.findElement(By.xpath("//*[contains(text(), 'Proceed')]")).click();
        WebElement quantity = driver.findElement(By.cssSelector(".cart_quantity_input"));
        Assert.assertEquals("Quantity of items is not 1. Please investigate.", "1" , quantity.getAttribute("value"));
        Assert.assertEquals("The price of item is incorrect. Please investigate.", true , driver.findElement(By.id("total_product_price_7_34_0")).getText().contains("16.40"));
        driver.findElement(By.cssSelector(".cart_navigation [title='Proceed to checkout']")).click();

        driver.quit();

    }


    @Test
    public void doesExplicitWaitWorkWhenAddingAnItemToTheCart(){

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 15);
        driver.navigate().to("http://automationpractice.com");


        driver.findElement(By.cssSelector("[id='search_query_top']")).sendKeys("Printed Dress");
        driver.findElement(By.cssSelector("[name='submit_search']")).click();
        WebElement dress = driver.findElement(By.cssSelector("img[title='Printed Chiffon Dress']"));
        assertThat(dress.isDisplayed()).as("Given Dress is displayed").isTrue();
        dress.click();
        By addToCartButton = By.xpath("//span[contains(text(),'Add')]");
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        By iconPlus = By.cssSelector(".icon-plus");
        driver.findElement(iconPlus).click();
        By size = By.cssSelector("#group_1");
        new Select(driver.findElement(size)).selectByVisibleText("M");
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        driver.findElement(addToCartButton).click();
        By proceedBtn = By.xpath("//*[contains(text(), 'Proceed')]");
        wait.until(ExpectedConditions.elementToBeClickable(proceedBtn));
        WebElement successText = driver.findElement(By.xpath("//div[starts-with(@class, 'layer_cart_product')]//h2"));
        assertThat(successText.getText()).as("Item was added to the cart without issues").isEqualTo("Product successfully added to your shopping cart");
        driver.findElement(proceedBtn).click();
        WebElement quantity = driver.findElement(By.cssSelector(".cart_quantity_input"));
        Assert.assertEquals("Quantity of items is not 1. Please investigate.", "2" , quantity.getAttribute("value"));
        Assert.assertEquals("The price of item is incorrect. Please investigate.", true , driver.findElement(By.id("total_product_price_7_35_0")).getText().contains("32.80"));
        driver.findElement(By.cssSelector(".cart_navigation [title='Proceed to checkout']")).click();

        driver.quit();

    }







}
*/
