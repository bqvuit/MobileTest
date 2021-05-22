package com.example.booking.stepdefs;

import com.example.booking.model.World;
import io.cucumber.java8.En;

public class HomePageSteps extends World implements En{

    public HomePageSteps() {
        Given("^open the app$", () -> {
            control.openCGVApp();
        });

        When("^open Menu bar$", () -> {
             home.openMenuBar();
        });

        When("^navigate to Login page$", () -> {
            home.clickOnLoginBtn();
            home.clickOnLoginBtnOnPromoteScreen();
        });
    }
}
