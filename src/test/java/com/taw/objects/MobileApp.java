package com.taw.objects;

import com.taw.common.Global;
import org.openqa.selenium.By;

public class MobileApp extends Global {

    public By username = By.id(appPackage + ":id/login_user_name");
    public By password = By.id(appPackage + ":id/login_password");
    public By loginBtn = By.id(appPackage + ":id/button_login");
}
