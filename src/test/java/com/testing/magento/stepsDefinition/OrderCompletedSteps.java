package com.testing.magento.stepsDefinition;

import com.testing.magento.factory.PageFactory;
import com.testing.magento.pageObjects.OrderCompletedPage;
import com.testing.magento.utils.ScenarioContext;
import io.cucumber.java.en.Then;

public class OrderCompletedSteps {
    PageFactory pageFactory = PageFactory.getInstance();
    OrderCompletedPage orderCompletedPage = pageFactory.getOrderCompletedPage();
    ScenarioContext scenarioContext;

    public OrderCompletedSteps(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
    }

    @Then("The order completed page is displayed")
    public void theCheckoutOverviewPageIsDisplayed() {
        orderCompletedPage.isOrderCompletedPageDisplayed();
    }
}
