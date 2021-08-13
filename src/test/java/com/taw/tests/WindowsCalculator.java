package com.taw.tests;

import com.taw.common.elements.Actions;
import com.taw.objects.windows.CalculatorObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WindowsCalculator extends Actions {
    //npm install appium-windows-driver -g
    //Activate windows 10 developer mode "Developer Settings->Developer Mode"
    //install Windows 10 SDK https://developer.microsoft.com/en-us/windows/downloads/windows-10-sdk/
    //Start appium
    //-ea -Dbrowser=windows -DdeviceName=WindowsPC -Dapp=notepad++
    //-ea -Dbrowser=windows -DdeviceName=WindowsPC -Dapp=microsoft.windowscalculator_8wekyb3d8bbwe!app

    private WebElement el = null;
    @BeforeMethod
    void set_up(){
        browser.open();
        wait.page_load_timeout();
    }

    @AfterMethod
    void tear_down(){
        wait.sleep(5000);
        driver.quit();
    }

    @Ignore
    @Test
    void notepad(){
        button.click(By.name("File"));
        button.click(By.name("Open..."));
        button.click(By.name("Cancel"));
    }

    @Ignore
    @Test
    void multiple_operations(){
        el = extract.element(CalculatorObjects.result);
        button.click(CalculatorObjects.clear);
        button.click(CalculatorObjects.seven);
        button.click(CalculatorObjects.multiply);
        button.click(CalculatorObjects.eight);
        button.click(CalculatorObjects.equals);
        button.click(CalculatorObjects.divide);
        button.click(CalculatorObjects.four);
        button.click(CalculatorObjects.equals);
        assertThat(el.getText()).isEqualTo("Display is 14");
        button.click(CalculatorObjects.plus);
        button.click(CalculatorObjects.five);
        button.click(CalculatorObjects.equals);
        assertThat(el.getText()).isEqualTo("Display is 19");
        button.click(CalculatorObjects.squareRoot);
    }
}
