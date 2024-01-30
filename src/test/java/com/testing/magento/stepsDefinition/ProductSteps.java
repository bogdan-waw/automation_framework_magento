package com.testing.magento.stepsDefinition;

import com.testing.magento.factory.PageFactory;
import com.testing.magento.model.Product;
import com.testing.magento.pageObjects.ProductPage;
import com.testing.magento.utils.Context;
import com.testing.magento.utils.ScenarioContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductSteps {
    PageFactory pageFactory = PageFactory.getInstance();
    ProductPage productPage = pageFactory.getProductPage();
    ScenarioContext scenarioContext;

    public ProductSteps(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
    }

    @Then("The product page is displayed")
    public void theProductPageIsDisplayed() {
        productPage.isProductPagePageDisplayed();
    }

    @When("The user adds the product to cart with size {} and color {}")
    public void addProductToCart(String size, String color) {
        Product product = productPage.addProductToCart(size, color);
        scenarioContext.setContext(Context.PRODUCT, product);
    }

    @When("The user goes to cart")
    public void goToCart() {
        productPage.goToCart();
    }
}

