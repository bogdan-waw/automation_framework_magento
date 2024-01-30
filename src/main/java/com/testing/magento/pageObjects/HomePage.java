package com.testing.magento.pageObjects;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BasePage {
    private final By PRODUCTS_LIST = By.cssSelector("li.product-item");
    private final By ADD_TO_CART_BUTTON_ON_PRODUCT = By.cssSelector("button.tocart");
    private final By SIZES_LIST_ON_PRODUCT = By.cssSelector("div.size div.swatch-option.text");
    private final By COLORS_LIST_ON_PRODUCT = By.cssSelector("div.color div.swatch-option.color");
    private final By CART_BUTTON = By.cssSelector("a.showcart");
    private final By PROCEED_TO_CHECKOUT_BUTTON = By.id("top-cart-btn-checkout");
    private final String URL = "https://magento.softwaretestingboard.com";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToHomePage() {
        navigateTo(URL);
    }

    public void isHomePageDisplayed() {
        Assert.assertEquals(getTabName(), "Home Page");
    }

    public void selectSizeOnProduct(WebElement productElement, String size) {
        List<WebElement> sizes = productElement.findElements(SIZES_LIST_ON_PRODUCT);
        WebElement sizeElement;
        if (StringUtils.isNotBlank(size)) {
            sizeElement = getElementWithAttributeFromList(sizes, "aria-label", size);
        } else {
            sizeElement = getElementFromListByIndex(sizes, 0);
        }
        clickElement(sizeElement);
    }

    private void selectSizeOnProductByIndex(WebElement productElement, int index) {
        List<WebElement> sizes = productElement.findElements(SIZES_LIST_ON_PRODUCT);
        WebElement sizeElement = getElementFromListByIndex(sizes, index);
        clickElement(sizeElement);
    }

    public void selectColorOnProduct(WebElement productElement, String color) {
        List<WebElement> colors = productElement.findElements(COLORS_LIST_ON_PRODUCT);
        WebElement colorElement;
        if (StringUtils.isNotBlank(color)) {
            colorElement = getElementWithAttributeFromList(colors, "aria-label", color);
        } else {
            colorElement = getElementFromListByIndex(colors, 0);
        }
        clickElement(colorElement);
    }

    public void selectColorOnProductByIndex(WebElement productWebElement, int index) {
        List<WebElement> colors = productWebElement.findElements(COLORS_LIST_ON_PRODUCT);
        WebElement colorElement = getElementFromListByIndex(colors, index);
        clickElement(colorElement);
    }

    public void addProductToCartByIndex(int index, String size, String color) {
        WebElement productElement = getElementFromListByIndex(PRODUCTS_LIST, index);
        WebElement addToCartButtonOnElement = getSubElementFromElement(productElement, ADD_TO_CART_BUTTON_ON_PRODUCT);
        selectSizeOnProduct(productElement, size);
        selectColorOnProduct(productElement, color);
        clickElement(addToCartButtonOnElement);
    }

    public void addProductToCartByIndex(int index) {
        WebElement productElement = getElementFromListByIndex(PRODUCTS_LIST, index);
        WebElement addToCartButtonOnElement = getSubElementFromElement(productElement, ADD_TO_CART_BUTTON_ON_PRODUCT);
        selectSizeOnProduct(productElement, "");
        selectColorOnProduct(productElement, "");
        clickElement(addToCartButtonOnElement);
    }

    public void goToProductByIndex(int index) {
        WebElement productElement = getElementFromListByIndex(PRODUCTS_LIST, index);
        scrollToElementAndClick(productElement);
    }

    public void clickCartButton() {
        clickElement(CART_BUTTON);
    }

    public void clickProceedToCheckoutButton() {
        clickElement(PROCEED_TO_CHECKOUT_BUTTON);
    }
}

