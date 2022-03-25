package com.taw.common.reporters.extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.taw.common.Global;

import java.io.File;
import java.util.Date;

public class ExtentManager extends Global{
    private static ExtentReports extent;
    public static ExtentReports createInstance(){
        String fileName = getReportName();
        String directory = System.getProperty("user.dir") + "/reports/";
        new File(directory).mkdirs();
        String path = directory+fileName;
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(path);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setDocumentTitle("Automation Reports");
        htmlReporter.config().setReportName("Automation Test Result");
        htmlReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.setSystemInfo("Organization", "Seavus");
        extent.setSystemInfo("Browser", "My browser");
        extent.attachReporter(htmlReporter);

        return extent;
    }

    public static String getReportName(){
        Date d = new Date();
        String filename = "Automation_Report" + d.toString().replace(":", "_").replace(" ", "_" + ".html");
        return filename;
    }
}