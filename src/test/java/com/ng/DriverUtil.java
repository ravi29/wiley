package com.ng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class DriverUtil {
	// WebDriver driver=null;
	private static WebDriver driver = new FirefoxDriver();

	public static WebDriver getBrowser() {
		if (driver == null) {
			driver = new FirefoxDriver();
		}
		return driver;
	}

	public static void closeBrowser() {

		if (driver != null){
			driver.quit();
			driver = null;
		}
	}
}
