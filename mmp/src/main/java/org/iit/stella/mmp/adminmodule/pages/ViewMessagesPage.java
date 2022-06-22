package org.iit.stella.mmp.adminmodule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewMessagesPage {

	WebDriver driver;
	public ViewMessagesPage(WebDriver driver)
	{
		this.driver= driver;	
	}
	public boolean fetchMessageDetails(String expectedReason,String expectedSubject)
	{
	 
		boolean result = false;
		String actualReason = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[2]/td[2]")).getText().trim();
		String actualSubject = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[3]")).getText().trim();
		if((actualReason.equals(expectedReason))&&(actualSubject.equals(expectedSubject)))
		{
			result = true;
		}
		return result;
	}
}
