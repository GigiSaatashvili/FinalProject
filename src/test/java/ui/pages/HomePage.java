package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.utils.WaitUtils;

public class HomePage {



    WebDriver driver;
    WaitUtils waitUtils;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
        PageFactory.initElements(driver, this);
    }

    // Cookie popup-ის კონტეინერი
    @FindBy(css = "div.cookies-popup_container")
    WebElement cookiesPopupContainer;

    // მთავარი გვერდის ლოგო
    @FindBy(css = "img")
    WebElement logo;

    // მთავარი გვერდის საძიებო ველი
    @FindBy(css = "input.catalog-search_input")
    WebElement searchInput;

    // მთავარ გვერდზე MacBook Neo card-ს ვინახავთ
    @FindBy(xpath = "//a[contains(@href,'/category/macbook-neo')]")
    WebElement macBookNeoCard;

    public boolean isLogoDisplayed() {
        return logo.isDisplayed();
    }

    // თუ cookie popup გამოჩნდა, ვხურავთ
    public void acceptCookiesIfDisplayed() {
        try {
            WebElement acceptButton = waitUtils.waitUntilElementIsClickable(
                    driver.findElement(By.xpath("//button[contains(.,'I accept')]"))
            );
            acceptButton.click();
            waitUtils.waitUntilElementIsInvisible(cookiesPopupContainer);

        } catch (Exception e) {

        }
    }

    // საძიებო ველში შეგვყავს ტექსტი და ვიწყებთ ძებნას
    public void searchProduct(String productName) {


        waitUtils.waitUntilElementIsInvisible(By.cssSelector("div.ui-backdrop"));
        waitUtils.waitUntilElementIsClickable(searchInput);

        searchInput.clear();
        searchInput.sendKeys(productName);
        searchInput.sendKeys(Keys.ENTER);
    }

    // ვაბრუნებთ საძიებო ველში ჩაწერილ მნიშვნელობას
    public String getSearchInputValue() {
        return searchInput.getAttribute("value");
    }

    // ვაბრუნებთ საძიებო ველის placeholder ტექსტს
    public String getSearchInputPlaceholder() {
        return searchInput.getAttribute("placeholder");
    }

    // ვამოწმებთ რომ საძიებო ველი გვერდზე ჩანს
    public boolean isSearchInputDisplayed() {
        return searchInput.isDisplayed();
    }

    // MacBook Neo card-ის ბმულს ვიღებთ და პირდაპირ შესაბამის გვერდზე გადავდივართ
    public void openMacBookNeoCategory() {
        String macBookNeoUrl = macBookNeoCard.getAttribute("href");
        driver.get(macBookNeoUrl);
    }

}