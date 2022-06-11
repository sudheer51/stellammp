package org.iit.stella.mmp.patientmodule.tests;

import java.util.HashMap;

import org.iit.stella.mmp.HelperClass;
import org.iit.stella.mmp.TestBaseClass;
import org.iit.stella.mmp.patientmodule.pages.ScheduleAppointmentPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ScheduleAppointmentTests extends TestBaseClass {
	@Test
	public void bookAppointment() {
		 
		HelperClass helperObj = new HelperClass(driver);
		helperObj.launchBrowser("value of Patient Url" + pro.getProperty("patienturl"));
		System.out.println("Printing the patient url");
		helperObj.patientLogin(pro.getProperty("patientusername"),pro.getProperty("patientpassword"));
		helperObj.moduleNavigation("Schedule Appointment");
		ScheduleAppointmentPage sPage = new ScheduleAppointmentPage(driver);
		HashMap<String,String> expectedHMap =  sPage.bookAppointment("Charlie","10Am","Fever & Sym by Automation Test @ Stella",10);
		HashMap<String,String> actualHMap = sPage.fetchPatientDataValues();
		boolean result = actualHMap.equals(expectedHMap);
		Assert.assertTrue(result);
		System.out.println("TC Executed Successfully");
		
		
	}
	 
 
}
