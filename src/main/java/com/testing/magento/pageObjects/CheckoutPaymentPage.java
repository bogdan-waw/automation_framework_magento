package com.testing.magento.pageObjects;

import com.testing.magento.model.Product;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPaymentPage extends BasePage {
    private static final By PLACE_ORDER_BUTTON = By.cssSelector("button.checkout");
    private static final By PAYMENT_TITLE = By.cssSelector("div.payment-group div.step-title");
    private static final By ITEMS_IN_CART_DETAILS_TOGGLE = By.cssSelector("div.items-in-cart div.title");
    private static final By PRODUCT_DETAILS_TOGGLE = By.cssSelector("div.product span.toggle");
    private static final By PRODUCT_DETAILS_PRICE = By.cssSelector("tr.sub td.amount");
    private static final By PRODUCT_DETAILS_QUANTITY = By.cssSelector("div.details-qty span.value");
    private static final By PRODUCT_DETAILS_NAME = By.cssSelector("strong.product-item-name");
    private Product product = new Product();

    public CheckoutPaymentPage(WebDriver driver) {
        super(driver);
    }

    public void isCheckoutPaymentPageDisplayed() {
        Assert.assertTrue(elementWithTextIsDisplayed(PAYMENT_TITLE, "Payment Method"));
    }

    public void clickPlaceOrderButton() {
        clickElementWithJavaScriptExecutor(PLACE_ORDER_BUTTON);
    }

    public Product getProductDetails() {
        expandItemsInCartDetails();
        expandProductDetails();
        setProductDetails();
        return product;
    }

    private void setProductDetails() {
        String price = getTextFromElement(PRODUCT_DETAILS_PRICE);
        String name = getTextFromElement(PRODUCT_DETAILS_NAME);
        int qty = Integer.valueOf(getTextFromElement(PRODUCT_DETAILS_QUANTITY));
        product.setQuantity(qty);
        product.setName(name);
        product.setPrice(price);
    }

    public void expandItemsInCartDetails() {
        scrollToElementAndClickWithJavaScriptExecutor(ITEMS_IN_CART_DETAILS_TOGGLE);
    }

    public void expandProductDetails() {
        scrollToElementAndClickWithJavaScriptExecutor(PRODUCT_DETAILS_TOGGLE);
    }
}
