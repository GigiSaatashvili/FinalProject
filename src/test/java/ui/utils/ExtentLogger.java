package ui.utils;

import com.aventstack.extentreports.ExtentTest;

public class ExtentLogger {

    // report-ში ინფორმაციულ ჩანაწერს ამატებს, თუ აქტიური ტესტი არსებობს
    public static void info(String message) {
        ExtentTest test = TestListener.getTest();
        if (test != null) {
            test.info(message);
        }
    }

    // report-ში წარმატებულ ნაბიჯს ამატებს, თუ აქტიური ტესტი არსებობს
    public static void pass(String message) {
        ExtentTest test = TestListener.getTest();
        if (test != null) {
            test.pass(message);
        }
    }

    // report-ში ჩავარდნილ ნაბიჯს ამატებს, თუ აქტიური ტესტი არსებობს
    public static void fail(String message) {
        ExtentTest test = TestListener.getTest();
        if (test != null) {
            test.fail(message);
        }
    }
}