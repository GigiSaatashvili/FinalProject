package ui.tests;
 import org.testng.Assert;
 import org.testng.annotations.Test;
 import ui.base.BaseTest;
 import ui.pages.HomePage;
 import ui.pages.MacBookNeoPage;


public class HomePageTest extends BaseTest {
    @Test
    public void verifyHomePageLoads() {

        HomePage homePage = new HomePage(driver);

        //ვამოწმებთ რომ მთავარ გვერდზე ლოგო ჩანს
        Assert.assertTrue(false,
                "ტესტი შეგნებულად ჩავაგდე სქრინშოტის შესამოწმებლად");
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

  /*  @Test
    public void verifyIphoneCategoryOpens() {

        HomePage homePage = new HomePage(driver);

        homePage.acceptCookiesIfDisplayed();
        homePage.openIphoneCategory();

        String currentUrl = driver.getCurrentUrl();
        String pageTitle = driver.getTitle();

        System.out.println("Current URL after iPhone click: " + currentUrl);
        System.out.println("Page title after iPhone click: " + pageTitle);

        Assert.assertTrue(currentUrl != null && !currentUrl.isBlank(),
                "iPhone-ზე დაჭერის შემდეგ ცარიელი URL არ უნდა იყოს");
    } */

    // ვამოწმებთ რომ მთავარ გვერდზე ძებნის ველი მომხმარებლისთვის ხილვადია
    @Test
    public void verifySearchFieldIsVisible() {

        HomePage homePage = new HomePage(driver);

        homePage.acceptCookiesIfDisplayed();

        Assert.assertTrue(homePage.isSearchInputDisplayed(),
                "მთავარ გვერდზე ძებნის ველი უნდა ჩანდეს");
    }

    // ვამოწმებთ რომ ენის შეცვლის შემდეგ URL და საძიებო ველის placeholder იცვლება
  /*  @Test
    public void verifyLanguageSwitchToEnglish() {

        HomePage homePage = new HomePage(driver);

        homePage.acceptCookiesIfDisplayed();

        String initialUrl = homePage.getCurrentPageUrl();
        String initialPlaceholder = homePage.getSearchInputPlaceholder();

        homePage.switchToEnglish();

        String updatedUrl = homePage.getCurrentPageUrl();
        String updatedPlaceholder = homePage.getSearchInputPlaceholder();

        Assert.assertTrue(updatedUrl.contains("/en"),
                "English ენაზე გადასვლის შემდეგ URL-ში /en უნდა გამოჩნდეს");

        Assert.assertNotEquals(updatedPlaceholder, initialPlaceholder,
                "ენის შეცვლის შემდეგ საძიებო ველის placeholder ტექსტი უნდა შეიცვალოს");
    } */


    // ვამოწმებთ რომ მთავარი გვერდის სათაური ცარიელი არ არის
    @Test
    public void verifyHomePageTitleIsNotEmpty() {

        String pageTitle = driver.getTitle();

        Assert.assertTrue(pageTitle != null && !pageTitle.isBlank(),
                "მთავარი გვერდის სათაური ცარიელი არ უნდა იყოს");
    }

    // ვამოწმებთ რომ საძიებო ველს placeholder ტექსტი აქვს
    @Test
    public void verifySearchInputPlaceholderIsNotEmpty() {

        HomePage homePage = new HomePage(driver);

        String placeholderText = homePage.getSearchInputPlaceholder();

        Assert.assertTrue(placeholderText != null && !placeholderText.isBlank(),
                "საძიებო ველის placeholder ტექსტი ცარიელი არ უნდა იყოს");
    }

    // ვამოწმებთ რომ MacBook Neo card-ზე დაჭერის შემდეგ შესაბამისი გვერდი იხსნება
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
