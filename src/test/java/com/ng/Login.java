package com.ng;

import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

	@Test(priority = 1)
	// @Test(enabled = false)--------------use for disable.
	public void Login() throws InterruptedException {
		WebDriver driver = DriverUtil.getBrowser();
		System.out
				.println("Login test case running.................................");
		// driver.findElement(By.className("submit_btn")).click();
		driver.findElement(
				By.xpath("html/body/div[2]/div/div[1]/div[2]/div/div/form/div/div[2]/div[2]/input"))
				.clear();
		driver.findElement(
				By.xpath("html/body/div[2]/div/div[1]/div[2]/div/div/form/div/div[2]/div[2]/input"))
				.sendKeys("ravikant.tyagi@adi-mps.com");
		driver.findElement(
				By.xpath("html/body/div[2]/div/div[1]/div[2]/div/div/form/div/div[3]/span/input"))
				.clear();
		driver.findElement(
				By.xpath("html/body/div[2]/div/div[1]/div[2]/div/div/form/div/div[3]/span/input"))
				.sendKeys("qwer1234");
		driver.findElement(By.className("submit_btn")).click();
		Thread.sleep(3000);

		assertEquals("Logout", driver.findElement(By.linkText("Logout"))
				.getText());

	}

	@Test(priority = 2)
	public void Logout() throws InterruptedException {
		WebDriver driver = DriverUtil.getBrowser();
		System.out
				.println("Logout test case running.................................");
		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(3000);
		// accepting javascript alert
		Alert alert = driver.switchTo().alert();
		alert.accept();
		// rejecting javascript
		// alert.dismiss();
		// driver.close();
	}

	@BeforeClass
	public void navigateto() {
		WebDriver driver = DriverUtil.getBrowser();
		System.out
				.println("Opening Browser and clear cookies.................................");
		driver.manage().deleteAllCookies();
		driver.get("http://wileypad.mpstechnologies.com/wileypad/index.do");
		driver.manage().window().maximize();
	}

	@AfterClass
	public void closebrowser() throws InterruptedException {
		DriverUtil.closeBrowser();
		System.out
				.println("Closed the browser.................................Ends here test suit");

	}
}
