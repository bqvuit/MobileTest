package com.example.booking.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AndroidControl {

    private static final Logger logger = LogManager.getLogger(AndroidControl.class);

    public boolean isAPKInstalled(String packageName) {
        return executeCommand("adb" + "pm list packages " + packageName).isEmpty();
    }

    public void installAPK(String apkPath) {
        executeCommand("adb" + " install " + apkPath);
    }

    public void openCGVApp() {
        executeCommand("adb shell " + "monkey -p "
                + Constant.APP_CGV_PACKAGE
                + " -c android.intent.category.LAUNCHER 1");
    }

    public void forceCloseCGVApp() {
        executeCommand("adb shell " + "am force-stop " + Constant.APP_CGV_PACKAGE);
    }

    public void clearCGVAppData() {
        executeCommand("adb shell " + "pm clear " + Constant.APP_CGV_PACKAGE);
    }

    public static String executeCommand(String command) {
        StringBuilder output = new StringBuilder();

        Process p;

        try {
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

        } catch (Exception e) {
            logger.error(e);
        }

        return output.toString();
    }
}
