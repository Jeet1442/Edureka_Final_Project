package com.edureka.Runner;

import java.io.IOException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import com.edureka.Base.Base;

public class Tc_002_FlightBooking extends Base {
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = Initialize();
		String url = prop.getProperty("url");
		driver.get(url);

}
	@Test
	public void Case2() throws InterruptedException {
		
		
		//Click on flights
		driver.findElement(By.xpath("//*[text() = 'Flights']")).click();
		Thread.sleep(5000);
		
		//To close ads
		if(driver.findElement(By.id("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0")).isDisplayed()) {
		WebElement frame1 = driver.findElement(By.id("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0"));
		driver.switchTo().frame(frame1);
		if(driver.findElement(By.id("ad_iframe")).isDisplayed()) {
		WebElement frame2 = driver.findElement(By.id("ad_iframe"));
		driver.switchTo().frame(frame2);
		}
		driver.findElement(By.xpath("//*[@id=\"dismiss-button\"]")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		}
		
		//Filling up the details
		driver.findElement(By.xpath("//*[@value='oneway']")).click();
		
		//Selecting 3 passengers
		for(int i = 0; i<2;i++) {
			driver.findElement(By.name("passCount")).sendKeys(Keys.ARROW_DOWN);
			driver.findElement(By.name("passCount")).sendKeys(Keys.ENTER);
		}
		
		//Selecting departing from
		for(int i = 0; i<=2;i++) {
			driver.findElement(By.name("fromPort")).sendKeys(Keys.ARROW_DOWN);
			driver.findElement(By.name("fromPort")).sendKeys(Keys.ENTER);
		}
		
		//Selecting month
		for(int i = 0; i<=3;i++) {
			driver.findElement(By.name("fromMonth")).sendKeys(Keys.ARROW_DOWN);
			driver.findElement(By.name("fromMonth")).sendKeys(Keys.ENTER);
		}
		
		//Selecting date
		for(int i = 0; i<=10;i++) {
			driver.findElement(By.name("fromDay")).sendKeys(Keys.ARROW_DOWN);
			driver.findElement(By.name("fromDay")).sendKeys(Keys.ENTER);
		}
		
		//Selecting destination
		for(int i = 0; i<=7;i++) {
			driver.findElement(By.name("toPort")).sendKeys(Keys.ARROW_DOWN);
			driver.findElement(By.name("toPort")).sendKeys(Keys.ENTER);
		}
		
		//Selecting month
		for(int i = 0; i<=5;i++) {
			driver.findElement(By.name("toMonth")).sendKeys(Keys.ARROW_DOWN);
			driver.findElement(By.name("toMonth")).sendKeys(Keys.ENTER);
		}
		
		//Selecting date
		for(int i = 0; i<=15;i++) {
			driver.findElement(By.name("toDay")).sendKeys(Keys.ARROW_DOWN);
			driver.findElement(By.name("toDay")).sendKeys(Keys.ENTER);
		}
		
		//Selecting preference
		driver.findElement(By.xpath("//*[@value='Business']")).click();
		for(int i = 0; i<2;i++) {
			driver.findElement(By.name("airline")).sendKeys(Keys.ARROW_DOWN);
			driver.findElement(By.name("airline")).sendKeys(Keys.ENTER);
		}
		
		//Click on continue
		driver.findElement(By.name("findFlights")).click();
	}
	

	@AfterTest
	public void close() {
		driver.close();
	}
	
}