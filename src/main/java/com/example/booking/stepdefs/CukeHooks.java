package com.example.booking.stepdefs;

import com.example.booking.common.AndroidControl;
import com.example.booking.common.Constant;
import com.example.booking.manage.PoolFactory;
import com.example.booking.model.World;
import com.example.booking.screens.CGVHome;
import com.example.booking.screens.Login;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static com.example.booking.common.Helper.getDeviceId;
import static com.example.booking.common.Helper.getResourceDir;
import static com.example.booking.manage.PoolFactory.*;

public class CukeHooks{
    protected AndroidControl control;

    @Before
    public void setUp(Scenario scenario ) throws Exception {
        String deviceId = getDeviceId();
        setDevice(deviceId);
        AppiumDriverLocalService service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingAnyFreePort());
        service.start();

        control = new AndroidControl();
        World world = new World();
        world.setControl(control);
        if (control.isAPKInstalled(Constant.APP_CGV_PACKAGE)) {
            String apkPath = getResourceDir() + "apk/CGV.apk";
            control.installAPK(apkPath);
        }

        setDriver(initLocalDriver(service.getUrl(), deviceId));
        AndroidDriver<WebElement> driver = getDriver();
        control.clearCGVAppData();
        driver.manage().timeouts().implicitlyWait(14000, TimeUnit.MILLISECONDS);
        //initScreenObject();
        world.setHome(new CGVHome());
        world.setLogin(new Login());

        String featureName = scenario.getId().split(";")[0].replace("-", " ");
        System.out.println("=====Executing ..." + scenario.getName() + "(" + featureName + ")");
    }

    @After
    public void closeApp(Scenario scenario) throws IOException {
        if(scenario.isFailed()) {
            File file = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File("Error.png"));
        }
        forceCloseApp();
        PoolFactory.closeDriver();

    }

    private void forceCloseApp() {
        control.forceCloseCGVApp();
    }


    protected void getCurrentScreenShot() {

    }
}
