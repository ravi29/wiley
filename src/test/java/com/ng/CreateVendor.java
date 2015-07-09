package com.ng;


import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class CreateVendor {
	@Test
	public void newvendor() throws InterruptedException {
		Login obj = new Login();
		WebDriver driver = DriverUtil.getBrowser();
		obj.navigateto();
		obj.Login();
		long code=vendorcode();
		String vcode="vendor"+code;
		String email="v"+code+"@gmail.com";
		driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div/div[2]/div/div/div[6]/div[2]/a[1]")).click();
		driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div/div[2]/div/div/form/div/div[7]/div[2]/input[3]")).sendKeys("vendor1");
		driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div/div[2]/div/div/form/div/div[7]/div[4]/input")).sendKeys(vcode);
		driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div/div[2]/div/div/form/div/div[11]/div[2]/input[2]")).sendKeys("vendor1");
		driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div/div[2]/div/div/form/div/div[12]/div[2]/input")).sendKeys(email);
		Select se=new Select(driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div/div[2]/div/div/form/div/div[14]/div[2]/select")));
		se.selectByVisibleText("United States");
		driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div/div[2]/div/div/form/div/div[21]/div[1]/div[2]/input")).sendKeys("test");
		//driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div/div[2]/div/div/form/div/div[21]/div[3]/div[2]/input")).sendKeys("test");
		driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div/div[2]/div/div/form/div/div[21]/div[1]/div[4]/input")).sendKeys(email);
		Thread.sleep(20000);
		//driver.findElement(By.className("submit_btn")).click();
		
	}
	@AfterClass
	public void closebrowser() throws InterruptedException {
		DriverUtil.closeBrowser();
		System.out
				.println("Closed the browser.................................Ends here test suit");

	}
	public long vendorcode()
	{
		Date dt = new Date();
		long tt=dt.getTime();
		return tt;
	}
}
