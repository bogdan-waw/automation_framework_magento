package com.testing.magento.stepsDefinition;

import com.testing.magento.factory.PageFactory;
import com.testing.magento.model.Product;
import com.testing.magento.pageObjects.CheckoutPaymentPage;
import com.testing.magento.utils.Context;
import com.testing.magento.utils.ScenarioContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CheckoutPaymentSteps {
    PageFactory pageFactory = PageFactory.getInstance();
    CheckoutPaymentPage checkoutPaymentPage = pageFactory.getCheckoutPaymentPage();
    ScenarioContext scenarioContext;

    public CheckoutPaymentSteps(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
    }

    @Then("The checkout payment page is displayed")
    public void theCheckoutPaymentPageIsDisplayed() {
        checkoutPaymentPage.isCheckoutPaymentPageDisplayed();
    }

    @Then("The product details are correct")
    public void theProductDetailsAreCorrect() {
        Product productOnProductPage = (Product) scenarioContext.getContext(Context.PRODUCT);
        Product productOnCheckoutPaymentPage = checkoutPaymentPage.getProductDetails();
        Assert.assertEquals(productOnProductPage, productOnCheckoutPaymentPage);
    }

    @When("The user places the order")
    public void clickPlaceOrderButton() {
        checkoutPaymentPage.clickPlaceOrderButton();
    }
}
