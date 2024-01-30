package com.testing.magento.stepsDefinition;

import com.testing.magento.factory.PageFactory;
import com.testing.magento.pageObjects.CartPage;
import com.testing.magento.utils.ScenarioContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartSteps {
    PageFactory pageFactory = PageFactory.getInstance();
    CartPage cartPage = pageFactory.getCartPage();
    ScenarioContext scenarioContext;

    public CartSteps(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
    }

    @Then("The cart page is displayed")
    public void theCartPageIsDisplayed() {
        cartPage.isCartPageDisplayed();
    }

    @When("The user clicks checkout button")
    public void clickCheckoutButton() {
        cartPage.clickCheckoutButton();
    }
}
