package com.zee5.AndroidMixpanelTest;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.business.zee.Zee5ApplicasterMixPanelBusinessLogic;
import com.utility.Utilities;

public class AndroidMixpanel_CTAs {
	
	private Zee5ApplicasterMixPanelBusinessLogic Zee5ApplicasterMixPanelBusinessLogic;

	@BeforeTest
	public void init() throws Exception {
		Utilities.relaunch = true;
		Zee5ApplicasterMixPanelBusinessLogic = new Zee5ApplicasterMixPanelBusinessLogic("zee");
	}

	@Test(priority = 1)
	@Parameters({"userType"})
	public void AndroidMixPanel_CTAsEventValidation(String pUserType) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.navigateToHomeScreen();
		Zee5ApplicasterMixPanelBusinessLogic.ZeeApplicasterLogin(pUserType);
		Zee5ApplicasterMixPanelBusinessLogic.verifyCTAsEvent(pUserType,"Subscribe");
	}
	
	
	@AfterTest
	public void tearDownApp() {
		System.out.println("Quit the App");
		Zee5ApplicasterMixPanelBusinessLogic.tearDown();
	}


}
