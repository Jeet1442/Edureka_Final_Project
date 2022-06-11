package com.edureka.Runner;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.*;
import com.edureka.Base.Base;

public class Tc_001_Register extends Base {
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = Initialize();
		String url = prop.getProperty("url");
		driver.get(url);
		
}
	@Test
	public void Case1() {
		
		//Click on Register
		driver.findElement(By.xpath("//*[text() = 'REGISTER']")).click();
		
		//Fill up the details
		driver.findElement(By.name("firstName")).sendKeys("Debjeet");
		driver.findElement(By.name("lastName")).sendKeys("Saha");
		driver.findElement(By.name("phone")).sendKeys("9804980124");
		driver.findElement(By.name("userName")).sendKeys("saha.deb45618@gmail.com");
		
		driver.findElement(By.name("address1")).sendKeys("30 Main Road");
		driver.findElement(By.name("city")).sendKeys("Kolkata");
		driver.findElement(By.name("state")).sendKeys("West Bengal");
		driver.findElement(By.name("postalCode")).sendKeys("700122");
		driver.findElement(By.name("country")).click();
		
		//Selecting INDIA in country
		driver.findElement(By.name("country")).click();
		for(int i = 0; i<107;i++) {
			driver.findElement(By.name("country")).sendKeys(Keys.ARROW_DOWN);
		}
		driver.findElement(By.name("country")).sendKeys(Keys.ENTER);
		
		driver.findElement(By.id("email")).sendKeys("Debjeet");
		driver.findElement(By.name("password")).sendKeys("12345");
		driver.findElement(By.name("confirmPassword")).sendKeys("12345");
		
		//Clicking on submit
		driver.findElement(By.name("submit")).click();
		
		
}
	
	@AfterTest
	public void close() {
		driver.close();
	}
	
}
