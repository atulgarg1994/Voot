package com.zee5.AMDMixpanelScripts;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.business.zee.Zee5ApplicasterMixPanelBusinessLogic;
import com.utility.Utilities;

public class ZNAMixpanel_Onboarding {
	
	private Zee5ApplicasterMixPanelBusinessLogic Zee5ApplicasterMixPanelBusinessLogic;

	@BeforeTest
	public void init() throws Exception {
		Utilities.relaunch = true;
		Zee5ApplicasterMixPanelBusinessLogic = new Zee5ApplicasterMixPanelBusinessLogic("zee");
	}

	@Test(priority = 1)
	@Parameters({ "userType" })
	public void AndroidAppMixPanelLogin(String userType) throws Exception {
		System.out.println("\nLogin");
		Zee5ApplicasterMixPanelBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		Zee5ApplicasterMixPanelBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		Zee5ApplicasterMixPanelBusinessLogic.ZeeApplicasterLogin(userType);
	}
	
	@Test(priority = 2)
	@Parameters({ "userType"})
	public void LoginInitiatedEvent(String userType) throws Exception {
		System.out.println("\nVerify Login Initiated Event on successfull login");
		Zee5ApplicasterMixPanelBusinessLogic.event_LoginInitiated(userType);
	}
	
	@Test(priority = 3)
	@Parameters({ "userType"})
	public void LoginResultEvent(String userType) throws Exception {
		System.out.println("\nVerify Login Result Event on successfull login");
		Zee5ApplicasterMixPanelBusinessLogic.event_LoginResult(userType);
	}
	
	
	@Test(priority = 4)
	@Parameters({ "userType"})
	public void LogOutEvent(String userType) throws Exception {
		System.out.println("\nVerify Logout Event");
		Zee5ApplicasterMixPanelBusinessLogic.logout();
		Zee5ApplicasterMixPanelBusinessLogic.event_LogOut(userType);
	}
	
	@AfterTest
	public void tearDownApp() {
		System.out.println("\nExecution Complete");
		Zee5ApplicasterMixPanelBusinessLogic.tearDown();
	}
	
}
