package org.iit.stella.mmp;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBaseClass {

	protected WebDriver driver;
	protected Properties pro;
	@BeforeClass
	public void instantiateDriver() throws IOException  
	{
		
	 
		ProjectConfiguration pConfig = new ProjectConfiguration();	
		pro = pConfig.loadProperties();
		 
		if(pro.getProperty("browser").equals("chrome"))
 		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		 	
		}
		else if(pro.getProperty("browser").equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		}
		 
	}
}
 

