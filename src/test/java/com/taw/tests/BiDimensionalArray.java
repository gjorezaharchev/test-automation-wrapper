package com.taw.tests;

import com.taw.common.elements.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.List;

public class BiDimensionalArray extends Actions {


    @Test
    public void test1() {
        browser.open();
        browser.maximize();
        navigate.to("https://demoqa.com/webtables");


        navigate.scroll(0, 400);
        By rowsL = By.xpath("//*[@role='rowgroup'] ");
        By columnsL = By.xpath(".//*[contains(@id, 'edit-record')]");
        List<WebElement> rowsE = waitElement.until(ExpectedConditions.presenceOfAllElementsLocatedBy(rowsL));
        System.out.println("Rows: " + rowsE.size());
        wait.sleep_in_seconds(2);

        for (WebElement row : rowsE) {
            List<WebElement> editB = row.findElements(columnsL);
            System.out.println("++++++ " + editB.size());
            if (editB.size() > 0) {
                editB.get(0).click();
                wait.sleep_in_seconds(2);
                button.click(By.xpath("//*[@id='registration-form-modal']/../button"));
            }

        }

        browser.close();
    }
}
