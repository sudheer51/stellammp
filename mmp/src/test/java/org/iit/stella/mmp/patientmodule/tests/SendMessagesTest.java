package org.iit.stella.mmp.patientmodule.tests;

import org.iit.stella.mmp.HelperClass;
import org.iit.stella.mmp.TestBaseClass;
import org.iit.stella.mmp.patientmodule.pages.SendMessagesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SendMessagesTest extends TestBaseClass{
	
	
	@Test
	public void validateSendMessages() {
		 
		HelperClass helperObj = new HelperClass(driver);
		helperObj.launchBrowser(pro.getProperty("patienturl"));
		helperObj.patientLogin(pro.getProperty("patientusername"),pro.getProperty("patientpassword"));
		helperObj.moduleNavigation("Messages");
		String reason = "Appointment for Doctor Charile";
		String subject= "Not feeling well";
		SendMessagesPage sPage = new SendMessagesPage(driver);
		String actual = sPage.sendMessage(reason,subject);
		String expected="Messages Successfully sent.";
		Assert.assertEquals(actual, expected);
	 
		 
		
	}

}
