package com.example.booking.screens;

import com.example.booking.manage.PoolFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

abstract class AbstractScreen {
    private AndroidDriver driver;

    AbstractScreen() {
        driver = PoolFactory.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    private MobileElement allowBtn;

    @AndroidFindBy(xpath = "//*[@text='Tiếp tục']")
    private MobileElement continueBtn;

    @AndroidFindBy(xpath = "//*[@text='Tiếp']")
    private MobileElement nextBtn;

    @AndroidFindBy(xpath = "//*[@text='OK']")
    private MobileElement okBtn;

    @AndroidFindBy(id = "com.vn.app.bagang:id/id_docked_tap_icon")
    private List<MobileElement> slideMenu;

    public void clickAllowPermissionBtn() {
        allowBtn.click();
    }

    public void clickContinueBtn() {
        continueBtn.click();
    }

    public void clickNextBtn() {
        nextBtn.click();
    }

    public void clickOkBtn() {
        okBtn.click();
    }

    protected void setDate() {
        okBtn.click();
    }

    protected MobileElement findElementByText(String text) {
        return (MobileElement) driver.findElement(By.xpath("//*[@text='" + text + "']"));
    }

    public void clickMoreTab() {
        slideMenu.get(4).click();
    }

    public String getAlertMessage(){
        return driver.switchTo().alert().getText();
    }
}
