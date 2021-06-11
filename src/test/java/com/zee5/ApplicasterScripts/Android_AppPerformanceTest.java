package com.zee5.ApplicasterScripts;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.business.zee.Zee5ApplicasterBusinessLogic;
import com.utility.Utilities;

public class Android_AppPerformanceTest {
	
	private Zee5ApplicasterBusinessLogic ZEE5ApplicasterBusinessLogic;

	@BeforeTest
	public void AppLaunch() throws Exception {
		System.out.println("Launching Andriod App");
		Utilities.relaunch = true;	// Clear App Data on First Launch
		ZEE5ApplicasterBusinessLogic = new Zee5ApplicasterBusinessLogic("zee");
	}
	
	@Test(priority = 0)
	@Parameters({ "userType" }) 
	public void accessDeviceLocation(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
	}
	
	@Test(priority = 1)	
	public void LoginFunctionality() throws Exception {
		ZEE5ApplicasterBusinessLogic.Performance_LoginFunctionality();
	}
	
	@Test(priority = 2)	
	public void ScreenNavigation() throws Exception {
		ZEE5ApplicasterBusinessLogic.SelectTopNavigationTab_Timer("Premium");
	}
	
	@Test(priority = 3)	
	public void InitiateContentPlayback() throws Exception {
		ZEE5ApplicasterBusinessLogic.Performance_InitiateContentPlayback();
	}
	
	@Test(priority = 4)
	public void DeeplinkValidaton() throws Exception {
		System.out.println("\nNative Andriod App Deeplink Validation");
		ZEE5ApplicasterBusinessLogic.relaunch(false);
		ZEE5ApplicasterBusinessLogic.deepLink_Validation("Consumption");
		ZEE5ApplicasterBusinessLogic.deepLink_Validation("LiveTV");
	}
	
	@AfterTest
	public void tearDownApp() {
		ZEE5ApplicasterBusinessLogic.tearDown();
	}
}
