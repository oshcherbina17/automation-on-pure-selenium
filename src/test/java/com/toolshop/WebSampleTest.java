package com.toolshop;

import com.toolshop.gui.pages.HomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebSampleTest {
    protected WebDriver driver;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/olhashcherbina/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://practicesoftwaretesting.com/#/");
    }

    @Test
    public void testWebsite() {
        HomePage homePage = new HomePage(driver);
        homePage.searchForProduct("Hammer");
        List<String> productTitles = homePage.getProductTitles();
        Assert.assertFalse(productTitles.isEmpty(), "Product search results are empty.");
       homePage.getProductTitleText();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
