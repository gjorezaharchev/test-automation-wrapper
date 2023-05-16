package com.taw.common.reporters.extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.taw.common.Global;

import java.io.File;
import java.util.Date;
import java.util.UUID;

public class ExtentManager extends Global{
    private static ExtentReports extent;
    public static ExtentReports createInstance(){
        String fileName = getReportName();
        String directory = System.getProperty("user.dir") + "/extent/reports/";
        new File(directory).mkdirs();
        String path = directory+fileName;
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(path);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setDocumentTitle("Automation Reports");
        htmlReporter.config().setReportName("Automation Test Result");
        htmlReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.setSystemInfo("Organization", $string("ORGANIZATION"));
        extent.setSystemInfo("Browser", String.valueOf(browser));
        extent.setSystemInfo("OS", OS);
        extent.attachReporter(htmlReporter);

        return extent;
    }

    public static String getReportName(){
        Date d = new Date();
        UUID uuid = UUID.randomUUID();

        String filename = "Automation_Report" + d.toString().replace(":", "_").replace(" ", "_" ) + uuid +  ".html";
        return filename;
    }
}
