package com.example.booking.stepdefs;

import com.example.booking.model.World;
import io.cucumber.java8.En;
import org.testng.Assert;

public class LoginPageSteps extends World implements En{

    public LoginPageSteps() {

        When("^the user logs in with \"(.*)\" and \"(.*)\"", (String userName, String password) -> {
            login.loginToCGVApp(userName, password);
        });

        Then("^the user logs in successfully", () -> {
            Assert.assertTrue(home.isHomePage());
        });

        Then("^the user logs in failed", () -> {
            Assert.assertEquals(login.getErrorMessage(), "Email hoặc số điện thoại");
        });
    }
}

