package ui.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    public static WebDriver createDriver() {

        String browser = ConfigReader.get("browser");

        if (browser == null || browser.equalsIgnoreCase("chrome")) {

            ChromeOptions options = new ChromeOptions();

            // ბრაუზერის permission popup-ებს ვთიშავ
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("profile.default_content_setting_values.geolocation", 2);
            prefs.put("profile.default_content_setting_values.notifications", 2);

            options.setExperimentalOption("prefs", prefs);

            return new ChromeDriver(options);
        }

        throw new IllegalArgumentException("Unsupported browser: " + browser);
    }
}