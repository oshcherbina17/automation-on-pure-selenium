package com.listeners;

import com.toolshop.gui.pages.AbstractTest;
import com.toolshop.gui.pages.RemoteDriverFactory;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.testng.ITestListener;
import org.testng.ITestResult;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotListener extends RemoteDriverFactory implements ITestListener {

    private static final Logger LOGGER = LogManager.getLogger();

    private static String getFormatDateTime(long sec) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
        return simpleDateFormat.format(new Date(sec));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        File source = ((TakesScreenshot) getRemoteDriver()).getScreenshotAs(OutputType.FILE);
        try {
            Path destination = Paths.get("screenshots", result.getName()
                    + getFormatDateTime(System.currentTimeMillis()) + ".png");
            Files.copy(source.toPath(), destination);
            System.out.println("Screenshot saved: " + destination);
        } catch (IOException e) {
            LOGGER.error("Problem with screenshot");
            throw new RuntimeException(e);
        }
    }

}

