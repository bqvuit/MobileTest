package com.example.booking.model;
import com.example.booking.common.AndroidControl;
import com.example.booking.screens.CGVHome;
import com.example.booking.screens.Login;

public class World {
    protected static AndroidControl control;
    protected static CGVHome home;
    protected static Login login;

    public static void setControl(AndroidControl control) {
        World.control = control;
    }

    public static void setHome(CGVHome home) {
        World.home = home;
    }

    public static void setLogin(Login login) {
        World.login = login;
    }
}
