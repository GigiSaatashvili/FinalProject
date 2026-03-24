package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.utils.WaitUtils;

public class MacBookNeoPage {

    WebDriver driver;
    WaitUtils waitUtils;

    public MacBookNeoPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
        PageFactory.initElements(driver, this);
    }

    // კატეგორიის გვერდზე პირველი პროდუქტის ღილაკს ვინახავთ
    @FindBy(xpath = "(//button[contains(@aria-label,'Go to product')])[1]")
    WebElement firstProductButton;

    // პირველი პროდუქტის ღილაკზე გადავდივართ
    public void openFirstProduct() {
        waitUtils.waitUntilElementIsClickable(firstProductButton);
        firstProductButton.click();
    }

    // ვაბრუნებთ მიმდინარე გვერდის URL-ს
    public String getCurrentPageUrl() {
        return driver.getCurrentUrl();
    }
}