package com.toolshop;

import com.toolshop.gui.pages.AbstractTest;
import com.toolshop.gui.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebSampleTest extends AbstractTest {
    @Test
    public void productSearchTest() {
        HomePage homePage = new HomePage(driver);
        homePage.searchForProduct("Hammer");
        List<String> productTitles = homePage.getProductTitles();
        Assert.assertFalse(productTitles.isEmpty(), "Product search results are empty.");
       homePage.getProductTitleText();
    }


}
