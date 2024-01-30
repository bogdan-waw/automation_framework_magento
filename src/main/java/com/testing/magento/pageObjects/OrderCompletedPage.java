package com.testing.magento.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderCompletedPage extends BasePage {
    private static final By ORDER_COMPLETED_TITLE = By.cssSelector("h1.page-title span");
    private static final By ORDER_COMPLETE_CONFIRMATION = By.cssSelector("div.checkout-success");

    public OrderCompletedPage(WebDriver driver) {
        super(driver);
    }

    public void isOrderCompletedPageDisplayed() {
        Assert.assertTrue(elementIsDisplayed(ORDER_COMPLETE_CONFIRMATION));
        Assert.assertTrue(elementWithTextIsDisplayed(ORDER_COMPLETED_TITLE, "Thank you for your purchase!"));
    }
}
