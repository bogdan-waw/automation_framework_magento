package com.testing.magento.pageObjects;

import com.testing.magento.model.Product;
import org.apache.commons.lang3.StringUtils;
import org.awaitility.Awaitility;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.Callable;

public class ProductPage extends BasePage {
    private final By ADD_TO_CART_BUTTON = By.cssSelector("button.tocart");
    private final By SIZES_LIST = By.cssSelector("div.size div.swatch-option.text");
    private final By COLORS_LIST = By.cssSelector("div.color div.swatch-option.color");
    private final By CART_BUTTON = By.cssSelector("a.showcart");
    private final By CART_COUNTER = By.cssSelector("a.showcart span.counter-number");
    private final By PROCEED_TO_CHECKOUT_BUTTON = By.cssSelector("#top-cart-btn-checkout");
    private final By PRODUCT_INFO = By.cssSelector("div.product-info-main");
    private final By PRICE = By.cssSelector("div.product-info-price span.price");
    private final By PRODUCT_NAME = By.cssSelector("div.product-info-main span.base");
    private final By PRODUCT_QUANTITY = By.cssSelector("#qty");
    private int cartCounter;
    private Product product = new Product();

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void isProductPagePageDisplayed() {
        Assert.assertTrue(elementIsDisplayed(PRODUCT_INFO));
    }

    public void selectSizeOnProduct(String size) {
        List<WebElement> sizes = getElementsList(SIZES_LIST);
        WebElement sizeElement;
        if (StringUtils.isNotBlank(size)) {
            sizeElement = getElementWithAttributeFromList(sizes, "aria-label", size);
        } else {
            sizeElement = getElementFromListByIndex(sizes, 0);
        }
        scrollToElementAndClick(sizeElement);
    }

    public void selectColorOnProduct(String color) {
        List<WebElement> colors = getElementsList(COLORS_LIST);
        WebElement colorElement;
        if (StringUtils.isNotBlank(color)) {
            colorElement = getElementWithAttributeFromList(colors, "aria-label", color);
        } else {
            colorElement = getElementFromListByIndex(colors, 0);
        }
        scrollToElementAndClick(colorElement);
    }

    public void clickAddToCartButton() {
        clickElement(ADD_TO_CART_BUTTON);
    }

    public Product addProductToCart(String size, String color) {
        cartCounter = getCartCounter();

        selectSizeOnProduct(size);
        selectColorOnProduct(color);

        setProductInfo();
        clickAddToCartButton();
        return product;
    }

    private void setProductInfo() {
        String price = getTextFromElement(PRICE);
        String name = getTextFromElement(PRODUCT_NAME);
        int qty = Integer.valueOf(getValueFromElement(PRODUCT_QUANTITY));
        product.setPrice(price);
        product.setName(name);
        product.setQuantity(qty);
    }

    public void clickCartButton() {
        Awaitility.await().until(counterIsUpdated());
        scrollToElementAndClick(CART_BUTTON);
    }

    public void clickProceedToCheckoutButton() {
        scrollToElementAndClick(PROCEED_TO_CHECKOUT_BUTTON);
    }

    public void goToCart() {
        clickCartButton();
        clickProceedToCheckoutButton();
    }

    private Callable<Boolean> counterIsUpdated() {
        return () -> cartCounter != getCartCounter();
    }

    private int getCartCounter() {
        String cartCounter = getTextFromElement(CART_COUNTER);
        int counter;
        if (StringUtils.isNotBlank(cartCounter)) {
            counter = Integer.valueOf(cartCounter);
        } else {
            counter = 0;
        }
        return counter;
    }
}
