package ui.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ui.base.BaseTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    // ჩავარდნის დროს ვიღებთ screenshot-ს და ვაბრუნებთ მის absolute path-ს
    public static String takeScreenshot(String testName) {
        WebDriver driver = BaseTest.getDriver();

        if (driver == null) {
            return null;
        }

        File screenshotsDir = new File("target/screenshots");
        if (!screenshotsDir.exists()) {
            screenshotsDir.mkdirs();
        }

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File destinationFile = new File(screenshotsDir, testName + "_" + timestamp + ".png");

        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(sourceFile, destinationFile);
            return destinationFile.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}