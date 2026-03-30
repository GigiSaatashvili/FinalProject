package ui.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ui.utils.ConfigReader;
import ui.utils.DriverFactory;

public class BaseTest {

    protected WebDriver driver;
    protected static WebDriver staticDriver;

    // ყოველი UI ტესტის დაწყებამდე ვხსნით ბრაუზერს და გადავდივართ მთავარ გვერდზე
    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.createDriver();
        staticDriver = driver;
        driver.manage().window().maximize();
        driver.get(ConfigReader.get("baseUrl"));
    }

    // სხვა კლასებიდან მიმდინარე driver-ის მისაღებად
    public static WebDriver getDriver() {
        return staticDriver;
    }

    // ყოველი UI ტესტის დასრულების შემდეგ ვხურავთ ბრაუზერს
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}