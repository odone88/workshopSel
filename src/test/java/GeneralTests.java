import RestOfPages.*;
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

    @Test
    public void isPasswordElementFoundWhenClickedTab(){

        AuthenticationPage authenticationPage = mainPage.clickOnSignInBtn();
        authenticationPage.clickOnEmailAndClickTab();
        Assert.assertEquals("There is wrong active element. Please investigate", "passwd", authenticationPage.checkIfPasswordActive());
    }

    @Test
    public void isItFacebookPage(){

        String facebookTitle = mainPage.clickOnFbLink().SwitchToDifferentWindowAndGetTitle();
        Assert.assertEquals("There is wrong fb page title. Please investigate", "Grupa publiczna Selenium Framework | Facebook", facebookTitle);
    }

    @Test
    public void isItTwitterPage(){

        String twitterTitle = mainPage.clickOnTwitterPage().SwitchToDifferentWindowAndGetTitle();
        Assert.assertEquals("There is wrong fb page title. Please investigate", "Selenium Framework (@seleniumfrmwrk) | Twitter", twitterTitle);
    }

    @Test
    public void isItYouTubePage(){

        String youtubeTitle = mainPage.clickOnYouTubeLink().SwitchToDifferentWindowAndGetTitle();
        Assert.assertEquals("There is wrong fb page title. Please investigate", "Selenium Framework - YouTube", youtubeTitle);
    }

    @Test
    public void itItGooglePlusPage(){

        String googleTitle = mainPage.clickOnGoogleLink().SwitchToDifferentWindowAndGetTitle();
        Assert.assertEquals("There is wrong fb page title. Please investigate", "Selenium Framework - Google+", googleTitle);
    }

    @Test
    public void shouldUserSearchForChiffonPrintedDressViewItBuyTwoAndCheckEverything(){
        SearchedItemPage searchedItemPage = mainPage.searchForItem("Printed Dress");

        assertThat(searchedItemPage.isPrintedChiffonDressElementPresent()).as("Given Dress is displayed").isTrue();

        QuickViewPage quickViewPage = searchedItemPage.hoverQuickViewAndClickIt();
        ConfirmationBuyingPage confirmationBuyingPage = quickViewPage.changeToPrintedChiffonDressFrame().changeDressSizeToM().addQuantityByOne().clickOnAddToCartBtn();

        assertThat(confirmationBuyingPage.getSuccessTextElement()).as("Item was added to the cart without issues").isEqualTo("Product successfully added to your shopping cart");

        AuthenticationPage authenticationPage =  confirmationBuyingPage.clickOnProceedToCheckoutBtn().clickOnProceed();
        PaymentPage paymentPage = authenticationPage.enterEmailAndPasswordAndClickOk().clickOnProceed().clickOnAgreeAgreement().clickOnProceed();


        assertThat(paymentPage.getAmountOfElements()).as("Quantity of items is 2 which is correct").isEqualTo("2");
        assertThat(paymentPage.getpriceOfTwoElementsWithoutShipping().contains("32.80")).as("The price of two elements is ok").isEqualTo(true);

        OrderConfirmation orderConfirmation = paymentPage.clickOnBankWirePayment().confirmOrder();

        Assert.assertEquals("There is wrong fb page title. Please investigate", "Your order on My Store is complete.", orderConfirmation.getFinalSuccessText());

    }



}
