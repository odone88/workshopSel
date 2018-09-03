package Driver;

import RestOfPages.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Driver {

    private static WebDriver driver;



    public static WebDriver getDriver(){
        if( null== driver)
        {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--start-maximized");
            driver = new ChromeDriver(chromeOptions);
        }
        return driver;
    }

    public static void quit(){
        if(null != driver){
            getDriver().quit();
        }
        driver = null;
    }




}
