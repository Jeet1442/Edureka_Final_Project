package com.edureka.Runner;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import com.edureka.Base.Base;

public class Tc_004_BrokenLinks extends Base {
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = Initialize();
		String url = prop.getProperty("url");
		driver.get(url);

}
	@Test
	public void Case3() throws IOException, InterruptedException {
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		
		for(int i=0; i<links.size(); i++) {
			
			WebElement element = links.get(i);
			String url = element.getAttribute("href");
			
			URL link = new URL(url);
			
			HttpURLConnection httpConn = (HttpURLConnection)link.openConnection();
			Thread.sleep(2000);
			
			httpConn.connect();
			
			int rescode = httpConn.getResponseCode();
			
			if(rescode >= 400) {
				
				System.out.println(url +" - "+ "is broken link");
			}
			else {
				System.out.println(url +" - "+ "is valid link");
			}
		}
		
	}

	@AfterTest
	public void close() {
		driver.close();
	}

}
