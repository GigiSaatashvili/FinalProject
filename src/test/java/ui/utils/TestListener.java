package ui.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private static final ExtentReports extent = ExtentReportManager.getInstance();
    private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    // ტესტის დაწყებისას ვქმნით ახალ ჩანაწერს რეპორტში
    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    // წარმატებული ტესტი აღინიშნება როგორც pass
    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("ტესტი წარმატებით შესრულდა");
    }

    // ჩავარდნილი ტესტი აღინიშნება როგორც fail და ვინახავთ შეცდომას
    @Override
    public void onTestFailure(ITestResult result) {
        test.get().fail(result.getThrowable());
    }

    // გამოტოვებული ტესტი აღინიშნება როგორც skipped
    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().skip("ტესტი გამოტოვებულია");
    }

    // suite-ის ბოლოს ვინახავთ report-ს
    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}