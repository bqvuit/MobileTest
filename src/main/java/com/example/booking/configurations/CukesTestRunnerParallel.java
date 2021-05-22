package com.example.booking.configurations;

import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions(
        features = "src/test/java/com/example/booking/feature",
        glue = "com.example.booking.stepdefs",
        dryRun = false,
        strict = true
)
public class CukesTestRunnerParallel extends AbstractTestNGCucumberParallelTests {
//
//    @BeforeClass
//    public static void before() {
//
//    }
//
//    @AfterClass
//    public static void after() {
//
//    }
}