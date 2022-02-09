package testCheckout;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import testBase.Config;

public class checkoutProcess extends Config {

    String cartAmount;
    ShippingPage shippingPage;
    OrderSummaryPage orderSummaryPage;

    @Test
    public void testUncheckTermsCheckbox() {
        BlousesPage blousesPage = homePage.clickBlouses();
        blousesPage.addBlouseToCart(1);
        CartPage cartPage = blousesPage.clickProceedToCheckout();
        cartAmount = cartPage.getTotalPriceInCart();
        LoginPage loginPage = cartPage.clickProceedToCheckout();
        loginPage.enterLoginData("fido@example.com" , "123456");
        AddressPage addressPage = loginPage.clickLoginInCheckout();
        shippingPage = addressPage.clickProceedToCheckout();
        shippingPage.clickProceedToCheckout();
        String termsErrorMessage = shippingPage.getTermsErrorMessage();
        shippingPage.closeErrorMessage();
        Assert.assertTrue(termsErrorMessage.contains("You must agree to the terms of service before continuing"));
    }

    @Test (priority = 1 , dependsOnMethods = "testUncheckTermsCheckbox")
    public void validateTotalAmount() {
        shippingPage.checkAgreeToTerms();
        PaymentPage paymentPage = shippingPage.clickProceedToCheckout();
        orderSummaryPage = paymentPage.clickPayByBankWire();
        String summaryAmount = orderSummaryPage.getTotalPriceInSummary();
        Assert.assertEquals(summaryAmount , cartAmount);
    }

    @Test (priority = 2 , dependsOnMethods = "validateTotalAmount")
    public void validateOrderIsPlaced() {
        OrderConfirmationPage orderConfirmationPage = orderSummaryPage.confirmOrder();
        String orderReference = orderConfirmationPage.getOrderReference();
        AccountPage accountPage = orderConfirmationPage.clickAccountName();
        OrderHistoryPage orderHistoryPage = accountPage.clickOrderHistory();
        String historyOrderReference = orderHistoryPage.getLatestOrderReference();
        Assert.assertEquals(historyOrderReference , orderReference);
    }
}
