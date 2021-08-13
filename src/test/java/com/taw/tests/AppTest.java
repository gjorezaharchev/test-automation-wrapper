package com.taw.tests;

import com.google.common.collect.ImmutableMap;
import com.taw.common.elements.Actions;
import com.taw.objects.MobileApp;
import org.testng.annotations.*;
import java.net.MalformedURLException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AppTest extends Actions {


    //-ea -Dbrowser=android -Denvironment=TEST -Ddevice=2a1d0de31b047ece -Dapp=https://github.com/afollestad/material-dialogs/raw/master/sample/sample.apk -DappPackage=com.app -DappActivity=com.app.LoginActivity
    //-ea -Dbrowser=ios -Denvironment=TEST -Ddevice=2a1d0de31b047ece -Dapp=https://github.com/afollestad/material-dialogs/raw/master/sample/sample.ipa -DiosPlatformVersion=11.0 -DxcodeOrgId=test -DxcodeSigningId=test -Dudid=udid -DupdatedWDABundleId=test
    /* check app package and activity
    adb shell
    dumpsys window | grep -E 'mCurrentFocus'
     */

    @BeforeSuite
    public void setupAppium() throws MalformedURLException {
        browser.open();
        //navigate.to("google.com");
    }

    @AfterSuite
    public void uninstallApp() throws InterruptedException {
        //androidDriver.removeApp($("android.package"));
        androidDriver.quit();
    }

    @BeforeMethod
    public void start_app() {
        androidDriver.resetApp();
    }

    @Ignore
    @Test(enabled = true)
    public void myFirstTest() throws InterruptedException {
        String searchTerm = "Gjore Zaharchev";
        button.click(MobileApp.search);
        input.type(MobileApp.searchText, searchTerm );
        androidDriver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "search"));
        assertThat(extract.elementValue(MobileApp.searchQuery)).isEqualTo(searchTerm);
        wait.sleep(10000);
    }
}