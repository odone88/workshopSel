/*
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class Tests2Refactoring {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 15);
    }


    @After
    public void tearDown() {
        driver.quit();
    }

    private By searchText = By.cssSelector("[id='search_query_top']");
    private By submitSearch = By.cssSelector("[name='submit_search']");
    private By chiffonDressImage = By.cssSelector("img[title='Printed Chiffon Dress']");
    private By addToCartButton = By.xpath("//span[contains(text(),'Add')]");
    private By iconPlus = By.cssSelector(".icon-plus");
    private By size = By.cssSelector("#group_1");
    private By proceedBtn = By.xpath("//*[contains(text(), 'Proceed')]");
    private By successText = By.xpath("//div[starts-with(@class, 'layer_cart_product')]//h2");
    private By quantity = By.cssSelector(".cart_quantity_input");
    private By proceedToCheckout = By.cssSelector(".cart_navigation [title='Proceed to checkout']");



    @Test
    public void doesExplicitWaitWorkWhenAddingAnItemToTheCart(){

        setUp();
        driver.navigate().to("http://automationpractice.com");


        driver.findElement(searchText).sendKeys("Printed Dress");
        driver.findElement(submitSearch).click();
        WebElement chiffonDress = driver.findElement(chiffonDressImage);
        assertThat(chiffonDress.isDisplayed()).as("Given Dress is displayed").isTrue();
        chiffonDress.click();


        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));

        driver.findElement(iconPlus).click();

        new Select(driver.findElement(size)).selectByVisibleText("M");

        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        driver.findElement(addToCartButton).click();

        wait.until(ExpectedConditions.elementToBeClickable(proceedBtn));

        assertThat(driver.findElement(successText).getText()).as("Item was added to the cart without issues").isEqualTo("Product successfully added to your shopping cart");
        driver.findElement(proceedBtn).click();

        Assert.assertEquals("Quantity of items is not 1. Please investigate.", "2" , driver.findElement(quantity).getAttribute("value"));
        Assert.assertEquals("The price of item is incorrect. Please investigate.", true , driver.findElement(By.id("total_product_price_7_35_0")).getText().contains("32.80"));

        driver.findElement(proceedToCheckout).click();

        tearDown();

    }







}
*/
