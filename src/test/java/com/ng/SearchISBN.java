package com.ng;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchISBN {

	@BeforeClass
	public void SearchByIsbn() throws InterruptedException {
		WebDriver driver = DriverUtil.getBrowser();
		Login obj = new Login();
		// System.out.println("Searching title by isbn");
		obj.navigateto();
		obj.Login();
	}

	@Test(priority = 1)
	public void SearchByISBN()

	{
		WebDriver driver = DriverUtil.getBrowser();
		System.out.println("Searching title by isbn");
		driver.findElement(
				By.xpath("html/body/div[1]/div[2]/div/div/div[2]/div/div/div[4]/div[2]/a[1]"))
				.click();
		driver.findElement(By.id("isbnName")).sendKeys("9780470193211");
		driver.findElement(By.id("submitbutton")).click();
		WebElement isbn = driver
				.findElement(By
						.xpath("html/body/div[1]/div[2]/div/div/div[2]/div/div/div[6]/div[3]/div[3]/div/table/tbody/tr[2]/td[1]/a"));
		assertEquals("9780470193211", isbn.getText());
	}
	
	@Test(priority=2)
	public void SearchByTitle() throws InterruptedException
	{
		WebDriver driver = DriverUtil.getBrowser();
		System.out.println("Searching by title");
		driver.findElement(By.id("isbnName")).clear();
		Thread.sleep(30000);
		driver.findElement(By.id("titleName")).sendKeys("Making RTI Work");
		driver.findElement(By.id("submitbutton")).click();
		WebElement isbn = driver
				.findElement(By
						.xpath("html/body/div[1]/div[2]/div/div/div[2]/div/div/div[6]/div[3]/div[3]/div/table/tbody/tr[2]/td[1]/a"));
		assertEquals("9780470193211", isbn.getText());
		
	}
	
	@Test(priority=3)
	public void SearchByTitleType()
	{
		WebDriver driver = DriverUtil.getBrowser();
		driver.findElement(By.id("titleName")).clear();
		WebElement element= driver.findElement(By.id("titletype"));
		Select se=new Select(element);
		se.selectByVisibleText("POD");
		driver.findElement(By.id("submitbutton")).click();
		WebElement isbn = driver
				.findElement(By
						.xpath("html/body/div[1]/div[2]/div/div/div[2]/div/div/div[6]/div[3]/div[3]/div/table/tbody/tr[3]/td[3]"));
		assertEquals("POD", isbn.getText());
	}

	@AfterClass
	public void closebrowser() {
		DriverUtil.closeBrowser();
		System.out
				.println("Closed the browser.................................");
	}
}
