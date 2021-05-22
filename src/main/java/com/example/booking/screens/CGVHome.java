package com.example.booking.screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class CGVHome extends AbstractScreen {
    @AndroidFindBy(id = "com.cgv.cinema.vn:id/btn_right_menu")
    private MobileElement menuBarBtn;

    @AndroidFindBy(id = "com.cgv.cinema.vn:id/user_name")
    private MobileElement loginBtn;

    @AndroidFindBy(id = "com.cgv.cinema.vn:id/btn_login")
    private MobileElement loginPromoteBtn;

    @AndroidFindBy(id = "com.cgv.cinema.vn:id/cgv_icon")
    private MobileElement titlePage;

    public void openMenuBar() {
        menuBarBtn.click();
    }

    public void clickOnLoginBtn() {
        loginBtn.click();
    }

    public void clickOnLoginBtnOnPromoteScreen() {
        loginPromoteBtn.click();
    }

    public boolean isHomePage(){
        return titlePage.isDisplayed();
    }
}
