package com.testing.magento.factory;

import com.testing.magento.pageObjects.*;
import org.openqa.selenium.WebDriver;

public class PageFactory {
    private static PageFactory instance = null;
    private static WebDriver driver;
    private OrderCompletedPage orderCompletedPage;
    private CartPage cartPage;
    private ProductPage productPage;
    private HomePage homePage;
    private CheckoutShippingPage checkoutShippingPage;
    private CheckoutPaymentPage checkoutPaymentPage;

    public static PageFactory getInstance() {
        if (instance == null) {
            instance = new PageFactory();
        }
        return instance;
    }

    public void init(WebDriver driver) {
        this.driver = driver;
    }

    public void reset() {
        instance = null;
    }


    public OrderCompletedPage getOrderCompletedPage() {
        if (orderCompletedPage == null) {
            orderCompletedPage = new OrderCompletedPage(driver);
        }
        return orderCompletedPage;
    }

    public CartPage getCartPage() {
        if (cartPage == null) {
            cartPage = new CartPage(driver);
        }
        return cartPage;
    }

    public ProductPage getProductPage() {
        if (productPage == null) {
            productPage = new ProductPage(driver);
        }
        return productPage;
    }

    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage(driver);
        }
        return homePage;
    }

    public CheckoutShippingPage getCheckoutShippingPage() {
        if (checkoutShippingPage == null) {
            checkoutShippingPage = new CheckoutShippingPage(driver);
        }
        return checkoutShippingPage;
    }

    public CheckoutPaymentPage getCheckoutPaymentPage() {
        if (checkoutPaymentPage == null) {
            checkoutPaymentPage = new CheckoutPaymentPage(driver);
        }
        return checkoutPaymentPage;
    }
}

