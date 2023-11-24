package com.toolshop.gui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends AbstractPage{

    @FindBy(css = "span[class='product-title']")
    private WebElement productTitleText;

    @FindBy(css = "button[data-test='proceed-1']")
    private WebElement confirmBtn;

    @FindBy(xpath = "//p[contains(text(),'already logged in')]")
    private WebElement loggedInText;

    @FindBy(css = "button[data-test='proceed-2']")
    private WebElement confirmSingIBtn;

    @FindBy(css = "input[id='address']")
    private WebElement addressInput;

    @FindBy(css = "button[data-test='proceed-3']")
    private WebElement confirmAddressBtn;

    @FindBy(css = "select[id='payment-method']")
    private WebElement paymentMethodMenu;

    @FindBy(css = "option[value='3: Credit Card']")
    private WebElement paymentCreditCard;

    @FindBy(css = "input[id='account-name']")
    private WebElement accountNameInput;

    @FindBy(css = "input[id='account-number']")
    private WebElement accountNumberInput;

    @FindBy(css = "button[data-test='finish']")
    private WebElement confirmFinishBtn;

    @FindBy(css = "div[class='help-block']")
    private WebElement successPaymentText;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getTitleText() {
        return getTitleText(productTitleText);
    }

    public void clickToCheckoutButton(WebElement element) {
        click(element);
    }

    public WebElement getConfirmBtn() {
        return confirmBtn;
    }

    public WebElement getConfirmSingIBtn() {
        return confirmSingIBtn;
    }

    public WebElement getConfirmAddressBtn() {
        return confirmAddressBtn;
    }

    public boolean isElementPresent(WebElement element){
       return element.isEnabled();
    }

    public WebElement getLoggedInText() {
        return loggedInText;
    }

    public WebElement getAddressInput() {
        return addressInput;
    }

    public void fillPaymentMethod(String name, String number) {
        click(paymentMethodMenu);
        click(paymentCreditCard);
        sendKeys(accountNameInput,name);
        sendKeys(accountNumberInput,number);
        waitForElementToBeClickable(confirmFinishBtn);
        click(confirmFinishBtn);
    }

    public WebElement getSuccessPaymentText() {
        return successPaymentText;
    }
}
