package com.toolshop.gui.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HomePage extends AbstractPage{

    private static final Logger LOGGER = LogManager.getLogger();

    protected WebDriver driver;

    @FindBy(css = "input[data-test='search-query']")
    private WebElement searchInput;

    @FindBy(css = "button[data-test='search-submit']")
    private WebElement searchBtn;

    @FindBy(xpath = "//h5[@data-test='product-name']")
    private List<WebElement> productNameList;

    @FindBy(xpath = "//h3[contains(text(),'Searched for')]")
    private WebElement searchTitle;

    @FindBy(xpath = "//h4[contains(text(),'By category')]")
    private WebElement byCategoryText;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

   /* public void searchForProduct(String query) {
        searchInput.sendKeys(query);
        WebElement dynamicElement = (new WebDriverWait(driver, 15))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[data-test='search-submit']")));
        searchBtn.click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }*/
  /* public void searchForProduct() {
       sendKeys(searchInput, );
   }*/

    public void searchForProduct(String query) {
        moveToElement(byCategoryText);
        sendKeys(searchInput, query);
        click(searchBtn);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getProductTitles() {
        List<String> titles = new ArrayList<>();
        for (WebElement product : productNameList) {
            titles.add(product.getText());
        }
        return titles;
    }

    public void getProductTitleText() {
        List<String> productNameListTexts = getProductTitles();
        List<String> filteredList = productNameListTexts.stream()
                .filter(s-> s.toLowerCase().contains("hammer"))
                .collect(Collectors.toList());
        filteredList.forEach(System.out::println);
    }
}
