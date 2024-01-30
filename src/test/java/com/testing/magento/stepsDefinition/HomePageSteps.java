package com.testing.magento.stepsDefinition;

import com.testing.magento.factory.PageFactory;
import com.testing.magento.pageObjects.HomePage;
import com.testing.magento.utils.ScenarioContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps {
    PageFactory pageFactory = PageFactory.getInstance();
    HomePage homePage = pageFactory.getHomePage();
    ScenarioContext scenarioContext;

    public HomePageSteps(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
    }

    @Given("The user navigates to home page")
    public void navigateToLoginPage() {
        homePage.navigateToHomePage();
    }

    @Then("The home page is displayed")
    public void theCatalogPageIsDisplayed() {
        homePage.isHomePageDisplayed();
    }

    @When("The user adds first product to cart")
    public void addFirstProductToCart() {
        homePage.addProductToCartByIndex(0, "s", "blue");
    }

    @When("The user goes to first product")
    public void goToFirstProductToCart() {
        homePage.goToProductByIndex(0);
    }

    @When("The user clicks on cart button")
    public void clickCartButton() {
        homePage.clickCartButton();
    }

    @When("The user clicks on proceed to checkout button")
    public void clickProceedToCheckoutButton() {
        homePage.clickProceedToCheckoutButton();
    }
}
