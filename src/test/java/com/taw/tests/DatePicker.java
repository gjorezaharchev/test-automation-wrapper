package com.taw.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DatePicker {

    @Ignore
    @Test
    public void testDAtePicker() throws Exception {

        //DAte and Time to be set in textbox

        String dateTime = "12/07/2014 2:00 PM";
        System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://demos.telerik.com/kendo-ui/datetimepicker/index");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //button to open calendar

        WebElement selectDate = driver.findElement(By.xpath("//span[@aria-controls='datetimepicker_dateview']"));

        selectDate.click();

        //button to move next in calendar

        WebElement nextLink = driver.findElement(By.xpath("//div[@id='datetimepicker_dateview']//div[@class='k-header']//a[contains(@class,'k-nav-next')]"));

        //button to click in center of calendar header

        WebElement midLink = driver.findElement(By.xpath("//div[@id='datetimepicker_dateview']//div[@class='k-header']//a[contains(@class,'k-nav-fast')]"));

        //button to move previous month in calendar

        WebElement previousLink = driver.findElement(By.xpath("//div[@id='datetimepicker_dateview']//div[@class='k-header']//a[contains(@class,'k-nav-prev')]"));

        //Split the date time to get only the date part

        String date_dd_MM_yyyy[] = (dateTime.split(" ")[0]).split("/");

        //get the year difference between current year and year to set in calander

        int yearDiff = Integer.parseInt(date_dd_MM_yyyy[2]) - Calendar.getInstance().get(Calendar.YEAR);

        midLink.click();

        if (yearDiff != 0) {

            //if you have to move next year

            if (yearDiff > 0) {

                for (int i = 0; i < yearDiff; i++) {

                    System.out.println("Year Diff->" + i);

                    nextLink.click();

                }

            }

            //if you have to move previous year

            else if (yearDiff < 0) {

                for (int i = 0; i < (yearDiff * (-1)); i++) {

                    System.out.println("Year Diff->" + i);

                    previousLink.click();

                }

            }

        }

        Thread.sleep(1000);

        //Get all months from calendar to select correct one

        List<WebElement> list_AllMonthToBook = driver.findElements(By.xpath("//div[@id='datetimepicker_dateview']//table//tbody//td[not(contains(@class,'k-other-month'))]"));

        list_AllMonthToBook.get(Integer.parseInt(date_dd_MM_yyyy[1]) - 1).click();

        Thread.sleep(1000);

        //get all dates from calendar to select correct one

        List<WebElement> list_AllDateToBook = driver.findElements(By.xpath("//div[@id='datetimepicker_dateview']//table//tbody//td[not(contains(@class,'k-other-month'))]"));

        list_AllDateToBook.get(Integer.parseInt(date_dd_MM_yyyy[0]) - 1).click();

        ///FOR TIME

        WebElement selectTime = driver.findElement(By.xpath("//span[@aria-controls='datetimepicker_timeview']"));

        //click time picker button

        selectTime.click();

        //get list of times

        List<WebElement> allTime = driver.findElements(By.xpath("//div[@data-role='popup'][contains(@style,'display: block')]//ul//li[@role='option']"));

        dateTime = dateTime.split(" ")[1] + " " + dateTime.split(" ")[2];

        //select correct time

        for (WebElement webElement : allTime) {

            if (webElement.getText().equalsIgnoreCase(dateTime)) {

                webElement.click();

            }

        }

    }

}