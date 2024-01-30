package com.testing.magento.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    private static final By CHECKOUT_BUTTON = By.cssSelector("#checkout");
    private static final By CART_TITLE = By.cssSelector("span.title");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void isCartPageDisplayed() {
        Assert.assertTrue(elementWithTextIsDisplayed(CART_TITLE, "Your Cart"));
    }

    public void clickCheckoutButton() {
        clickElement(CHECKOUT_BUTTON);
    }
}
