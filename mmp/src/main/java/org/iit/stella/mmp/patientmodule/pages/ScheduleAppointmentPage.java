package org.iit.stella.mmp.patientmodule.pages;

import java.util.HashMap;

import org.iit.stella.mmp.AppLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ScheduleAppointmentPage {

	WebDriver driver;
	private By createButton = By.xpath("//input[@value='Create new appointment']");
	private By datePickerYear= By.xpath("//span[@class='ui-datepicker-year']");
	private By datePickerMonth= By.xpath("//span[@class='ui-datepicker-month']");
	private By datePickerArrow = By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e'])[1]");
	private By timeID = By.id("time");
	private By symID= By.id("sym");
	
	
	
	public ScheduleAppointmentPage(WebDriver driver)
	{
		this.driver= driver;	
	}

	public HashMap<String, String> bookAppointment(String doctorName,String time,String sym,int days)
	{

		HashMap<String,String> expectedhMap = new HashMap<String,String>();
		expectedhMap.put("doctorName", doctorName);
		driver.findElement(createButton).click();
		driver.findElement(By.xpath("(//h4[contains(text(),'Dr."+doctorName+"')])[1]/ancestor::ul/following-sibling::button")).click();
		driver.switchTo().frame("myframe");
		driver.findElement(By.id("datepicker")).click();


		String expectedDate = AppLibrary.getFutureDate(days,"dd/MMM/yyyy");
		String expectedDateArr[] = expectedDate.split("/");
		String expectedDt = expectedDateArr[0];
		String expectedMonth = expectedDateArr[1]; 
		String expectedYear = expectedDateArr[2];
		String actualYear = driver.findElement(datePickerYear).getText();//2022
		while(!(expectedYear.equals(actualYear)))
		{
			driver.findElement(datePickerArrow).click();
			actualYear = driver.findElement(datePickerYear).getText();
		}
		String actualMonth = driver.findElement(datePickerMonth).getText();
		while(!(expectedMonth.equals(actualMonth)))
		{
			driver.findElement(datePickerArrow).click();
			actualMonth =  driver.findElement(datePickerMonth).getText();
		}
		driver.findElement(By.linkText(expectedDt)).click();
		expectedhMap.put("dateofAppointment",AppLibrary.getFutureDate(days,"MM/dd/yyyy")) ;


		Select timeSelect = new Select(driver.findElement(timeID));
		timeSelect.selectByVisibleText(time);
		expectedhMap.put("time", time);

		driver.findElement(By.id("ChangeHeatName")).click();

		driver.findElement(symID).sendKeys(sym);
		expectedhMap.put("sym", sym);

		driver.findElement(By.xpath("//input[@value='Submit']")).click();

		return expectedhMap;
	}
	public HashMap<String, String> fetchPatientDataValues()
	{
		HashMap<String,String> actualhMap = new HashMap<String,String>();
		String actualDate = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[1]")).getText().trim();
		actualhMap.put("dateofAppointment", actualDate);
		String actualtime= driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[2]")).getText().trim();
		actualhMap.put("time", actualtime);
		String actualSym= driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[3]")).getText().trim();
		actualhMap.put("sym", actualSym);
		String actualDoctor= driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[4]")).getText().trim();
		actualhMap.put("doctorName", actualDoctor);
		return actualhMap;
		
	}
	
}
