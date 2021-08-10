package com.taw.objects;

import com.taw.common.Global;
import org.openqa.selenium.By;

public class MobileApp extends Global {

    public static By username = By.id(appPackage + ":id/login_user_name");
    public static By password = By.id(appPackage + ":id/login_password");
    public static By loginBtn = By.id(appPackage + ":id/button_login");

    public static By search = By.xpath("//android.widget.ImageView[@content-desc=\"Search\"]");
    public static By searchText = By.id("com.google.android.youtube:id/search_edit_text");
    public static By searchQuery = By.id("com.google.android.youtube:id/search_query");
}
