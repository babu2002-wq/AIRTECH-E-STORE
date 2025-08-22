package com.airtech.qa.utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import com.airtech.qa.base.BaseClass;

public class ExtentReport implements ITestListener{

	public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;

    String repname;
    

    @Override
    public void onStart(ITestContext context) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        repname = "Test-Report-" + timeStamp + ".html";

        String reportPath = System.getProperty("user.dir") + "/reports/" + repname;
        sparkReporter = new ExtentSparkReporter(reportPath);
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Functional Testing");
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("Computer Name", "localhost");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Tester Name", "Ashisranjan Dash");
        extent.setSystemInfo("OS", "Windows 10");
        extent.setSystemInfo("Browser Name", "Chrome");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    	test = extent.createTest(result.getName());

        // Fetch description from @Test annotation
        String description = result.getMethod().getDescription();
        if (description != null && !description.isEmpty()) {
            test.log(Status.INFO, "💡 Review: " + description);
        }

        test.log(Status.PASS, "✅ Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getName());
        String description = result.getMethod().getDescription();
        if (description != null && !description.isEmpty()) {
            test.log(Status.INFO, "💡 Review: " + description);
        }
        test.log(Status.FAIL, "Test Failed: " + result.getName());

        // Get only the exception message (not full stack trace)
        String errorMessage = result.getThrowable().getMessage();

        // Trim to avoid very large error dumps
        if (errorMessage.length() > 200) {  
            errorMessage = errorMessage.substring(0, 200) + "...";  
        }

        test.log(Status.FAIL, "Reason: " + errorMessage);

        try {
            String imgPath = new BaseClass().captureScreen(result.getName());
            test.addScreenCaptureFromPath(imgPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onTestSkipped(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.SKIP, "Test Skipped: " + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        if (extent != null) {
            extent.flush(); 
        }

        String pathOfReport = System.getProperty("user.dir") + "/reports/" + repname;
        File extentReport = new File(pathOfReport);

        try {
            Desktop.getDesktop().browse(extentReport.toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        // No additional logic needed here
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // No additional logic needed here
    }
}
