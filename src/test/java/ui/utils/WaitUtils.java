package ui.utils;

 import org.openqa.selenium.By;
 import org.openqa.selenium.WebDriver;
 import org.openqa.selenium.WebElement;
 import org.openqa.selenium.support.ui.ExpectedConditions;
 import org.openqa.selenium.support.ui.WebDriverWait;

 import java.time.Duration;

public class WaitUtils {
    // selenium wait მექანიზმია
    private final WebDriverWait wait;

    public WaitUtils(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
                    // ელოდება რომ დაკლიკებადი გახდეს
    public WebElement waitUntilElementIsClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
               // ესეც დამხმარეა
    public void waitUntilElementIsVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    public void waitUntilElementIsInvisible(By by) {
    }

    public void waitUntilElementIsInvisible(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
}
