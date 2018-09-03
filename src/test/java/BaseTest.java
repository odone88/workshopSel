
import Driver.Driver;
import RestOfPages.MainPage;
import org.assertj.core.api.SoftAssertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;


public class BaseTest extends TestRules{

    MainPage mainPage;
    SoftAssertions softAssertions;

    @Before
    public void setUp(){
        Driver.getDriver().get("http://automationpractice.com");
        mainPage = new MainPage();
        softAssertions = new SoftAssertions();
    }

    @After
    public void tearDown() throws Exception {
        Driver.quit();
    }

    @Rule
    public TestRules ruleExample = new TestRules();


}
