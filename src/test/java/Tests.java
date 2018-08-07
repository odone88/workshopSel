
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[starts-with(@class, 'layer_cart_product')]//h2")));

      String successText = driver.findElement(By.xpath("//div[starts-with(@class, 'layer_cart_product')]//h2")).getText();

      Assert.assertEquals("Item was not added to the cart. Please investigate.", "Product successfully added to your shopping cart" , successText);

      driver.findElement(By.xpath("//*[contains(text(), 'Proceed')]")).click();

      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Summary')]")));

      String quantityOfItems = driver.findElement(By.cssSelector("[class*='cart_quantity_input']")).getAttribute("value");

      Assert.assertEquals("Item was not added to the cart. Please investigate.", "1" , quantityOfItems);

      driver.quit();

   }



}
