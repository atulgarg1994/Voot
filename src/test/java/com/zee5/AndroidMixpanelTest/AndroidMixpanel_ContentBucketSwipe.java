package com.zee5.AndroidMixpanelTest;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.business.zee.Zee5ApplicasterMixPanelBusinessLogic;
import com.utility.Utilities;

public class AndroidMixpanel_ContentBucketSwipe {

	private Zee5ApplicasterMixPanelBusinessLogic Zee5ApplicasterMixPanelBusinessLogic;
	
	@BeforeTest
	public void init() throws Exception {
		Utilities.relaunch = true;
		Zee5ApplicasterMixPanelBusinessLogic = new Zee5ApplicasterMixPanelBusinessLogic("zee");
	}

	@Test(priority = 1)
	@Parameters({"userType","pTabName"})
	public void AndroidMixPanel_ContentBucketSwipeEventValidation(String userType,String pTabName) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.navigateToHomeScreen();
		Zee5ApplicasterMixPanelBusinessLogic.ZeeApplicasterLogin(userType);
		Zee5ApplicasterMixPanelBusinessLogic.ContentBucketSwipeEventValidation(userType,pTabName);
		Zee5ApplicasterMixPanelBusinessLogic.EventValidation(userType, "Content Bucket Swipe", "Homepage", "SplashPage");
	}
	
	@AfterTest
	public void tearDownApp() {
		System.out.println("Execution Complete");
		Zee5ApplicasterMixPanelBusinessLogic.tearDown();
	}
}
