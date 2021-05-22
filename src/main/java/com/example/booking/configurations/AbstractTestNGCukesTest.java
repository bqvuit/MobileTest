package com.example.booking.configurations;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.DataProvider;


public abstract class AbstractTestNGCukesTest extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider()
	public Object[][] scenarios() {
		return super.scenarios();
	}

}