package ui.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.base.BaseTest;
import ui.pages.HomePage;

public class HomePageTest extends BaseTest {

    @Test
    public void verifyHomePageLoads() {

        HomePage homePage = new HomePage(driver);

        // ვამოწმებთ რომ მთავარ გვერდზე ლოგო ჩანს
        Assert.assertTrue(homePage.isLogoDisplayed(),
                "მთავარ გვერდზე ispace უნდა იყოს ლოგო");
    }

    @Test
    public void checkSearchInput() {

        HomePage homePage = new HomePage(driver);

        homePage.acceptCookiesIfDisplayed();
        homePage.searchProduct("iphone");

        String searchValue = homePage.getSearchInputValue();

        Assert.assertTrue(searchValue.equalsIgnoreCase("iphone"),
                "ძებნის ველში iphone უნდა ჩაიწეროს სწორად");
    }

    @Test
    public void verifySearchFieldIsVisible() {

        HomePage homePage = new HomePage(driver);

        homePage.acceptCookiesIfDisplayed();

        Assert.assertTrue(homePage.isSearchInputDisplayed(),
                "მთავარ გვერდზე ძებნის ველი უნდა ჩანდეს");
    }

    @Test
    public void verifyHomePageTitleIsNotEmpty() {

        String pageTitle = driver.getTitle();

        Assert.assertTrue(pageTitle != null && !pageTitle.isBlank(),
                "მთავარი გვერდის სათაური ცარიელი არ უნდა იყოს");
    }

    @Test
    public void verifySearchInputPlaceholderIsNotEmpty() {

        HomePage homePage = new HomePage(driver);

        String placeholderText = homePage.getSearchInputPlaceholder();

        Assert.assertTrue(placeholderText != null && !placeholderText.isBlank(),
                "საძიებო ველის placeholder ტექსტი ცარიელი არ უნდა იყოს");
    }

    @Test
    public void verifyMacBookNeoCardOpensCategoryPage() {

        HomePage homePage = new HomePage(driver);

        homePage.acceptCookiesIfDisplayed();
        homePage.openMacBookNeoCategory();

        String currentUrl = driver.getCurrentUrl();

        Assert.assertTrue(currentUrl.contains("macbook-neo"),
                "MacBook Neo card-ზე დაჭერის შემდეგ URL-ში macbook-neo უნდა ჩანდეს");
    }
}