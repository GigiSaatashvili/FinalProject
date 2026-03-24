package ui.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static ExtentReports extent;

    // ვქმნით Extent report ობიექტს და ვუთითებთ სად შეინახოს HTML რეპორტი
    public static ExtentReports getInstance() {
        if (extent == null) {
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/ExtentReport.html");
            sparkReporter.config().setReportName("Final Project Test Report");
            sparkReporter.config().setDocumentTitle("Automation Test Results");

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);

            extent.setSystemInfo("Project", "Final Project");
            extent.setSystemInfo("Tester", "Gigi");
        }
        return extent;
    }
}