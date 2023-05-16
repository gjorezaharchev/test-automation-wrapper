package com.taw.tests;

import com.taw.common.elements.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class Calendar extends Actions {

    By openCalendar = By.xpath("//*[@id='datePickerMonthYearInput']/..");
    By mainCalendar = By.xpath("//*[contains(@class,'month-container')]");
    By calendarToday = By.xpath(".//*[contains(@class,'today')]");
    By calendarAvailable = By.xpath(".//*[@aria-disabled='false']");

    @Test
    public void test1() {
        browser.open();
        navigate.to("https://demoqa.com/date-picker");
        navigate.scroll(0, 400);
        button.click(openCalendar);

        elementBase.getElement(mainCalendar).findElements(calendarAvailable).get(29).click();
        wait.sleep_in_seconds(3);


        browser.close();
    }
}
