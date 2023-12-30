package utils;

import driver.DriverSingleton;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

import static utils.CoreUtils.getCurrentTimeAsString;

public class TestListener implements ITestListener {
    private final Logger log = LogManager.getRootLogger();

    @Override public void onTestStart(ITestResult result) {
        log.info("Test "+result.getMethod().getMethodName()+" started...");
    }

    @Override public void onTestSuccess(ITestResult result) {
        log.info("Test "+result.getMethod().getMethodName()+" succeeded! :)");
    }

    @Override public void onTestFailure(ITestResult result) {
        log.info("Test "+result.getMethod().getMethodName()+" failed! :(");
        log.error(result.getThrowable().getMessage());
        saveScreenshot();
    }

    @Override public void onTestSkipped(ITestResult result) {
    }

    @Override public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        log.info("Test "+result.getMethod().getMethodName()+" failed, but within success percentage! :/");
    }

    @Override public void onStart(ITestContext context) {
    }

    @Override public void onFinish(ITestContext context) {
    }

    private void saveScreenshot() {
        File screenCapture = ((TakesScreenshot) DriverSingleton
                .getDriver())
                .getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenCapture, new File(
                    ".//target/screenshots/" +
                            getCurrentTimeAsString() +
                            ".png"));
        } catch (IOException e) {
            log.error("Failed to save screenshot: " + e.getLocalizedMessage());
        }
    }
}