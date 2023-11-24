package com.toolshop.gui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends AbstractPage {

    @FindBy(css = "a[data-test='nav-favorites']")
    private WebElement myFavoritesBtn;

    @FindBy(css = "a[data-test='nav-profile']")
    private WebElement profileBtn;

    @FindBy(css = "a[data-test='nav-invoices'")
    private WebElement invoicesBtn;

    @FindBy(css = "a[data-test='nav-messages']")
    private WebElement messagesBtn;

    @FindBy(css = "a[data-test='nav-home']")
    private WebElement homeBtn;

    @FindBy(css = "a[id='user-menu']")
    private WebElement userMenu;

    public AccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isFavoritesButtonPresent() {
        return isElementPresent(myFavoritesBtn);
    }

    public boolean isProfileButtonPresent() {
        return isElementPresent(profileBtn);
    }

    public boolean isInvoicesButtonPresent() {
        return isElementPresent(invoicesBtn);
    }

    public boolean isMessagesButtonPresent() {
        return isElementPresent(messagesBtn);
    }

    public HomePage clickOnHomePage() {
        waitForVisibilityOfElement(userMenu);
        click(homeBtn);
        return  new HomePage(driver);
    }
}
