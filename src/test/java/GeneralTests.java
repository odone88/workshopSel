import RestOfPages.ConfirmationBuyingPage;
import RestOfPages.DressesPage;
import RestOfPages.SearchedItemPage;
import RestOfPages.ShoppingCartSummaryPage;
import ViewPages.QuickViewPage;
import org.junit.Assert;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GeneralTests extends BaseTest {



    @Test
    public void shouldUserFindTextFaded(){

        SearchedItemPage searchedItemPage = mainPage.searchForItem("Faded");
        Assert.assertTrue("Faded Tshirt is not prsent. Please investigate", searchedItemPage.isFadedElementPresent());
    }

    @Test
    public void shouldUserAddBlouseToTheCart(){

        ConfirmationBuyingPage confirmationBuyingPage = mainPage.mouseOverBlouse().clickAddToCartButton();
        assertThat(confirmationBuyingPage.getSuccessTextElement()).as("Item was added to the cart without issues").isEqualTo("Product successfully added to your shopping cart");
        ShoppingCartSummaryPage shoppingCartSummaryPage = confirmationBuyingPage.clickOnProceedToCheckoutBtn();
        Assert.assertEquals("Item was not added to the cart. Please investigate.", "1" , shoppingCartSummaryPage.getQuantityOfAddedElements());
    }

    @Test
    public void shouldUserSearchForChiffonPrintedDressAndBuyTwo(){

        SearchedItemPage searchedItemPage = mainPage.searchForItem("Printed Dress");

        assertThat(searchedItemPage.isPrintedChiffonDressElementPresent()).as("Given Dress is displayed").isTrue();

        ConfirmationBuyingPage confirmationBuyingPage = searchedItemPage.clickOnPrintedChiffonDress().addQuantityByOne().changeDressSizeToM().clickOnAddToCartBtn();

        assertThat(confirmationBuyingPage.getSuccessTextElement()).as("Item was added to the cart without issues").isEqualTo("Product successfully added to your shopping cart");

        ShoppingCartSummaryPage shoppingCartSummaryPage = confirmationBuyingPage.clickOnProceedToCheckoutBtn();

        Assert.assertEquals("Quantity of items is not 2. Please investigate.", "2" , shoppingCartSummaryPage.getQuantityOfAddedElements());
        Assert.assertEquals("The price of item is incorrect. Please investigate.", true , shoppingCartSummaryPage.getPriceFor2ChiffonDress().contains("32.80"));
    }

    @Test
    public void arePricesDiscountsAllRightForDresses(){

        DressesPage dressesPage = mainPage.clickOnDressesCategoryBtn();
        Assert.assertTrue("discount for dresses are calculated in a wrong way. Please investigate.", dressesPage.checkIfDiscountsAreCorrectlyCalculated());
    }

    @Test
    public void shouldUserSearchForChiffonPrintedDressViewItBuyTwo(){
        SearchedItemPage searchedItemPage = mainPage.searchForItem("Printed Dress");

        assertThat(searchedItemPage.isPrintedChiffonDressElementPresent()).as("Given Dress is displayed").isTrue();

        QuickViewPage quickViewPage = searchedItemPage.hoverQuickViewAndClickIt();
        ConfirmationBuyingPage confirmationBuyingPage = quickViewPage.changeToPrintedChiffonDressFrame().changeDressSizeToM().addQuantityByOne().clickOnAddToCartBtn();

        assertThat(confirmationBuyingPage.getSuccessTextElement()).as("Item was added to the cart without issues").isEqualTo("Product successfully added to your shopping cart");

        ShoppingCartSummaryPage shoppingCartSummaryPage = confirmationBuyingPage.clickOnProceedToCheckoutBtn();

        Assert.assertEquals("Quantity of items is not 2. Please investigate.", "2" , shoppingCartSummaryPage.getQuantityOfAddedElements());
        Assert.assertEquals("The price of item is incorrect. Please investigate.", true , shoppingCartSummaryPage.getPriceFor2ChiffonDress().contains("32.80"));
    }


}
