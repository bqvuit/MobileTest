package com.example.booking.screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Login extends AbstractScreen {

    @AndroidFindBy(id = "com.cgv.cinema.vn:id/edt_email_phone")
    private MobileElement emailInput;

    @AndroidFindBy(id = "com.cgv.cinema.vn:id/edt_password")
    private MobileElement passInput;

    @AndroidFindBy(id = "com.cgv.cinema.vn:id/btn_login")
    private MobileElement submitLogin;

    @AndroidFindBy(id = "com.cgv.cinema.vn:id/edt_email_phone")
    private MobileElement missingCredentialTxt;

    public Login inputUserName(String user) {
        emailInput.sendKeys(user);
        return this;
    }

    public Login inputPassword(String pass) {
        passInput.sendKeys(pass);
        return this;
    }

    public Login clickSubmit() {
        submitLogin.click();
        return this;
    }

    public void loginToCGVApp(String user, String pass) {
        inputUserName(user)
                .inputPassword(pass)
                .clickSubmit();
    }

    public String getErrorMessage(){
        return missingCredentialTxt.getText();
    }

}
