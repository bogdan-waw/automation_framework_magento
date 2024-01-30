package com.testing.magento.stepsDefinition;

import com.testing.magento.factory.PageFactory;
import com.testing.magento.pageObjects.CheckoutShippingPage;
import com.testing.magento.utils.ScenarioContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutShippingSteps {
    PageFactory pageFactory = PageFactory.getInstance();
    CheckoutShippingPage checkoutShippingPage = pageFactory.getCheckoutShippingPage();
    ScenarioContext scenarioContext;

    public CheckoutShippingSteps(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
    }

    @Then("The checkout shipping page is displayed")
    public void theCheckoutShippingPageIsDisplayed() {
        checkoutShippingPage.isCheckoutShippingPageDisplayed();
    }

    @When("The user enters the first name {} on the checkout information page")
    public void enterFirstname(String firstName) {
        checkoutShippingPage.enterFirstname(firstName);
    }

    @When("The user enters the last name {} on the checkout information page")
    public void enterLastName(String lastName) {
        checkoutShippingPage.enterLastName(lastName);
    }

    @When("The user enters the postal code {} on the checkout information page")
    public void enterPostalCode(String postalCode) {
        checkoutShippingPage.enterPostalCode(postalCode);
    }

    @When("The user enters the shipping details on the checkout page")
    public void enterCheckoutDetails() {
        checkoutShippingPage.enterCheckoutShippingInformation("abc@gmail.com", "bogdan", "alexandru", "test address", "United States", "Alabama", "test city", "12345-6789", "0765123456");
    }

    @When("The user continues to payment")
    public void continueToPayment() {
        checkoutShippingPage.clickNextButton();
    }
}
