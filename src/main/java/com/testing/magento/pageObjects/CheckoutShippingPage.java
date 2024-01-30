package com.testing.magento.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckoutShippingPage extends BasePage {
    private static final By CONTINUE_BUTTON = By.cssSelector("button.continue");
    private static final By EMAIL = By.id("customer-email");
    private static final By FIRST_NAME = By.cssSelector("input[name='firstname']");
    private static final By LAST_NAME = By.cssSelector("input[name='lastname']");
    private static final By STREET_ADDRESS = By.cssSelector("input[name*='street']");
    private static final By CITY = By.cssSelector("input[name*='city']");
    private static final By STATE_DROPDOWN = By.cssSelector("div[name*='shippingAddress.region_id'] select");
    private static final By COUNTRY_DROPDOWN = By.cssSelector("div[name*='shippingAddress.country_id'] select");
    private static final By POSTAL_CODE = By.cssSelector("input[name*='postcode']");
    private static final By PHONE_NUMBER = By.cssSelector("input[name*='telephone']");
    private static final By SHIPPING_TITLE = By.cssSelector("#shipping div.step-title");
    private static final By SHIPPING_METHOD_OPTIONS = By.cssSelector("#checkout-shipping-method-load tr.row input.radio");

    public CheckoutShippingPage(WebDriver driver) {
        super(driver);
    }

    public void isCheckoutShippingPageDisplayed() {
        Assert.assertTrue(elementWithTextIsDisplayed(SHIPPING_TITLE, "Shipping Address"));
    }

    public void clickNextButton() {
        scrollToElementAndClick(CONTINUE_BUTTON);
    }

    public void enterPostalCode(String postalCode) {
        enterText(POSTAL_CODE, postalCode);
    }

    public void enterFirstname(String firstName) {
        enterText(FIRST_NAME, firstName);
    }

    public void enterLastName(String lastName) {
        enterText(LAST_NAME, lastName);
    }

    public void enterEmail(String email) {
        enterText(EMAIL, email);
    }

    public void enterStreetAddress(String streetAddress) {
        enterText(STREET_ADDRESS, streetAddress);
    }

    public void enterPhoneNumber(String phoneNumber) {
        enterText(PHONE_NUMBER, phoneNumber);
    }

    public void enterCity(String city) {
        enterText(CITY, city);
    }

    public void selectState(String state) {
        selectOptionFromDropdownByVisibleText(STATE_DROPDOWN, state);
    }

    public void selectCountry(String country) {
        selectOptionFromDropdownByVisibleText(COUNTRY_DROPDOWN, country);
    }

    public void selectShippingMethod() {
        List<WebElement> shippingMethodOptions = getElementsList(SHIPPING_METHOD_OPTIONS);
        scrollToElementAndClick(shippingMethodOptions.get(0));
    }

    public void enterCheckoutShippingInformation(String email, String firstName, String lastName, String streetAddress, String country, String state, String city, String postalCode, String phoneNumber) {
        enterEmail(email);
        enterFirstname(firstName);
        enterLastName(lastName);
        enterStreetAddress(streetAddress);
        selectCountry(country);
        selectState(state);
        enterCity(city);
        enterPostalCode(postalCode);
        enterPhoneNumber(phoneNumber);
        selectShippingMethod();
    }
}
