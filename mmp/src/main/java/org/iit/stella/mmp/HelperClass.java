package org.iit.stella.mmp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperClass {

	WebDriver driver;
	public HelperClass(WebDriver driver) {
		 this.driver = driver;
	}
	public void patientLogin(String username,String password)
	{
		driver.findElement(By.id("username")).sendKeys(username );
		driver.findElement(By.id("password")).sendKeys(password );
		driver.findElement(By.name("submit")).click();
	}
	public void adminLogin(String username,String password)
	{
		driver.findElement(By.id("username")).sendKeys(username );
		driver.findElement(By.id("password")).sendKeys(password );
		driver.findElement(By.name("admin")).click();
	}
	public void moduleNavigation(String moduleName)
	{
		driver.findElement(By.xpath("//span[normalize-space()='"+moduleName+"']")).click();
	}
	 
	public void launchBrowser(String url)
	{
		driver.get(url);
	}
}
