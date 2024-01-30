package com.testing.magento.pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasePage {
    public WebDriver driver;
    private FluentWait fluentWait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        fluentWait = new FluentWait(driver);

        fluentWait.withTimeout(Duration.ofSeconds(20));
        fluentWait.pollingEvery(Duration.ofMillis(300));
        fluentWait.ignoring(StaleElementReferenceException.class, NoSuchElementException.class);
    }

    public void implicitWait(int seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public void navigateTo(String url) {
        driver.navigate().to(url);
    }

    public void waitForElementToBeClickable(WebElement element) {
        fluentWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementToBeClickable(By selector) {
        fluentWait.until(ExpectedConditions.elementToBeClickable(selector));
    }

    public void waitForElementToBeVisible(WebElement element) {
        fluentWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBePresent(By selector) {
        fluentWait.until(ExpectedConditions.presenceOfElementLocated(selector));
    }

    public void waitForAllElementsToBePresent(By selector) {
        fluentWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy((selector)));
    }

    public void waitForElementToBeVisible(By selector) {
        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(selector));
    }

    public void waitForElementToBeSelected(By selector) {
        fluentWait.until(ExpectedConditions.elementToBeSelected(selector));
    }

    public void waitForElementToBeSelected(WebElement element) {
        fluentWait.until(ExpectedConditions.elementToBeSelected(element));
    }

    public WebElement findElement(By selector) {
        waitForElementToBePresent(selector);
        return driver.findElement(selector);
    }

    public void clickElement(By selector) {
        WebElement element = findElement(selector);
        waitForElementToBeClickable(selector);
        element.click();
    }

    public void scrollToElementAndClick(WebElement element) {
        Actions action = new Actions(driver);
        waitForElementToBeVisible(element);
        waitForElementToBeClickable(element);
        action.moveToElement(element).click().build().perform();
    }

    public void scrollToElementAndClick(By selector) {
        WebElement element = findElement(selector);
        Actions action = new Actions(driver);
        waitForElementToBeVisible(element);
        waitForElementToBeClickable(element);
        action.moveToElement(element).click().build().perform();
    }

    public void clickElementWithActions(WebElement element) {
        Actions action = new Actions(driver);
        waitForElementToBeVisible(element);
        action.click().perform();
    }

    public void clickElementWithActions(By selector) {
        WebElement element = findElement(selector);
        Actions action = new Actions(driver);
        waitForElementToBeClickable(element);
        action.click().perform();
    }

    public void clickElementWithJavaScriptExecutor(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void scrollToElementAndClickWithJavaScriptExecutor(By selector) {
        WebElement element = findElement(selector);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        js.executeScript("arguments[0].click();", element);
    }

    public void clickElementWithJavaScriptExecutor(By selector) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        WebElement element = findElement(selector);
        executor.executeScript("arguments[0].click();", element);
    }

    public void clickElement(WebElement element) {
        waitForElementToBeVisible(element);
        waitForElementToBeClickable(element);
        element.click();
    }

    public void enterText(By selector, String text) {
        waitForElementToBeVisible(selector);
        WebElement element = findElement(selector);
        element.sendKeys(text);
    }

    public boolean elementIsDisplayed(By selector) {
        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(selector));
        WebElement element = findElement(selector);
        return element.isDisplayed();
    }

    public boolean elementWithTextIsDisplayed(By selector, String text) {
        WebElement element = findElement(selector);
        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(selector));
        return element.isDisplayed() && (element.getText().equalsIgnoreCase(text));
    }

    public List<WebElement> getElementsList(By selector) {
        waitForAllElementsToBePresent(selector);
        return driver.findElements(selector);
    }

    public WebElement getElementFromListByIndex(By selector, int index) {
        waitForElementToBePresent(selector);
        return getElementsList(selector).get(index);
    }

    public WebElement getElementFromListByIndex(List<WebElement> elements, int index) {
        return elements.get(index);
    }

    public WebElement getElementWithAttributeFromList(List<WebElement> elements, String attribute, String value) {
        for (WebElement element : elements) {
            if (element.getAttribute(attribute).equalsIgnoreCase(value)) {
                return element;
            }
        }
        return null;
    }

    public WebElement getSubElementFromElement(WebElement element, By selector) {
        return element.findElement(selector);
    }

    public void selectOptionFromDropdownByVisibleText(By dropdownSelector, String text) {
        Select dropdown = new Select(driver.findElement(dropdownSelector));
        dropdown.selectByVisibleText(text);
    }

    public String getTextFromElement(By selector) {
        waitForElementToBePresent(selector);
        WebElement element = driver.findElement(selector);
        return element.getText();
    }

    public String getValueFromElement(By selector) {
        waitForElementToBePresent(selector);
        WebElement element = driver.findElement(selector);
        return element.getAttribute("value");
    }

    public String getTabName() {
        return driver.getTitle();
    }
}

