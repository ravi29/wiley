package com.ng;

import static org.testng.AssertJUnit.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class Metadataprocessingstatus {
	@Test(priority=1)
	public void checkstatus() throws InterruptedException {
		WebDriver driver = DriverUtil.getBrowser();
		Login obj = new Login();
		obj.navigateto();
		obj.Login();
		driver.findElement(
				By.xpath("html/body/div[1]/div[2]/div/div/div[2]/div/div/div[4]/div[2]/a[3]"))
				.click();
		WebElement element = driver
				.findElement(By
						.xpath("html/body/div[1]/div[2]/div/div/div[2]/div/div/form/div/div[2]/div[2]/div[2]/select"));
		Select se = new Select(element);
		se.selectByVisibleText("Processed");
		driver.findElement(By.id("submitbutton")).click();
		assertEquals(
				"Processed",
				driver.findElement(
						By.xpath("html/body/div[1]/div[2]/div/div/div[2]/div/div/div[5]/div[3]/div[3]/div/table/tbody/tr[3]/td[3]"))
						.getText());
		Thread.sleep(20000);
	}
	
	@Test(priority=2)
	public void BackButton()
	{
		WebDriver driver = DriverUtil.getBrowser();
		driver.findElement(By.className("submit_btn")).click();
		assertEquals("PRINT ASSET DELIVERY SYSTEM (PAD)",driver.findElement(By.className("pagehead")).getText());
	}
	@AfterClass
	public void closebrowser() {
		DriverUtil.closeBrowser();
		System.out
				.println("Closed the browser.................................");
	}
}
