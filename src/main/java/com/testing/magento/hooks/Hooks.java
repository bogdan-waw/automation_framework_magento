package com.testing.magento.hooks;

import com.testing.magento.factory.PageFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    private WebDriver driver;

    @Before
    public void beforeScenario() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        PageFactory factory = PageFactory.getInstance();
        factory.init(driver);
    }

    @After
    public void afterScenario(Scenario s) {
        if (s.isFailed()) {
            try {
                final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                s.attach(screenshot, "image/png", "failureScreenshot");
            } catch (NullPointerException ignored) {
            }
        }
        if (driver != null) {
            driver.quit();
        }
        PageFactory.getInstance().reset();
    }
}

