package com.edureka.Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {
	public static WebDriver driver; // so that we can use driver anywhere by creating driver object only once.
	public Properties prop; //so that prop can be used in other class also to access properties files.
	
	public WebDriver Initialize() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Debjeet\\eclipse-workspace\\Edureka\\src\\main\\resources\\config.properties");
		prop.load(fis);
		
		//String driver_path = prop.getProperty("driver");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Debjeet\\eclipse-workspace\\Edureka\\Driver\\chromedriver.exe" );
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
			
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}
	
	

}
