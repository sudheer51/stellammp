package org.iit.stella.mmp.adminmodule.tests;

import org.iit.stella.mmp.HelperClass;
import org.iit.stella.mmp.TestBaseClass;
import org.iit.stella.mmp.adminmodule.pages.ViewMessagesPage;
import org.iit.stella.mmp.patientmodule.pages.SendMessagesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ViewMessagesTest extends TestBaseClass{

	@Test
	public void validateE2EMessages()
	{
		HelperClass helperObj = new HelperClass(driver);
		helperObj.launchBrowser(pro.getProperty("patienturl"));
		helperObj.patientLogin(pro.getProperty("patientusername"),pro.getProperty("patientpassword"));
		helperObj.moduleNavigation("Messages");
		String expectedReason = "Appointment for Doctor Charile";
		String expectedSubject= "Not feeling well";
		SendMessagesPage sPage = new SendMessagesPage(driver);
		sPage.sendMessage(expectedReason, expectedSubject);
		
		helperObj.launchBrowser(pro.getProperty("adminurl"));
		helperObj.adminLogin(pro.getProperty("adminusername"),pro.getProperty("adminpassword"));
		helperObj.moduleNavigation("Messages");
		
		ViewMessagesPage vPage= new ViewMessagesPage(driver);
		boolean result = vPage.fetchMessageDetails(expectedReason, expectedSubject);
		Assert.assertTrue(result);
	 
		
	
	}
}
