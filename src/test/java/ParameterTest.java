import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;


@RunWith(value = Parameterized.class)
public class ParameterTest extends BaseTest{

    @Parameterized.Parameter(0)
    public String targetPage;

    @Parameterized.Parameter(1)
    public String targetPageTitle;

    @Parameterized.Parameters(name = "{index}: Open social link for {0} and expect title with {1}")
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
            {"facebook","Selenium Framework"},
            {"twitter","Twitter"},
            {"youtube","YouTube"},
            {"google-plus","Google+"}
        });
    }

    @Test
    public void isItFacebookPage(){
        String appTitle = mainPage.clickOnAppLink(targetPage).SwitchToDifferentWindowAndGetTitle();
        Assert.assertTrue("There is wrong fb page title. Please investigate", appTitle.contains(targetPageTitle));
    }




}
