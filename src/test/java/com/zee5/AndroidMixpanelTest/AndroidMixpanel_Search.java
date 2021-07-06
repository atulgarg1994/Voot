package com.zee5.AndroidMixpanelTest;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.business.zee.Zee5ApplicasterMixPanelBusinessLogic;
import com.utility.Utilities;

public class AndroidMixpanel_Search {
	
	private Zee5ApplicasterMixPanelBusinessLogic Zee5ApplicasterMixPanelBusinessLogic;

	@BeforeTest
	public void init() throws Exception {
		Utilities.relaunch = true;
		Zee5ApplicasterMixPanelBusinessLogic = new Zee5ApplicasterMixPanelBusinessLogic("zee");
	}

	@Test(priority = 1)
	@Parameters({"userType","keyword9"})
	public void AndroidMixPanel_SearchEventValidation(String pUserType,String pContentName) throws Exception {
		Zee5ApplicasterMixPanelBusinessLogic.navigateToHomeScreen();
		Zee5ApplicasterMixPanelBusinessLogic.ZeeApplicasterLogin(pUserType);
		Zee5ApplicasterMixPanelBusinessLogic.SearchEventFunctinality(pUserType, pContentName);
	}
	
	
	
//	@Test(priority = 2)
	public void verifyVideoStreamOverWifiChangedEvent() throws Exception {
		System.out.println("Verify Video stream  over Wifi Changed event");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifyVideoStreamOverWifiChangedEvent();
	}
	
//	@Test(priority = 3)
	public void verifyVideoAutoPlayChangedEvent() throws Exception {
		System.out.println("Video Streaming AutoPlay Changed");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifyVideoAutoPlayChangedEvent();
	}
	
//	@Test(priority = 4)
	public void verifyDownloadOverWifiChangedEvent() throws Exception {
		System.out.println("Verify Download over wifi changed");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifyDownloadOverWifiChangedEvent();
	}
	
//	@Test(priority = 5)
	@Parameters({ "downloadQualityOption" })
	public void verifyDownloadQualityChangeEvent(String downloadQualityOption) throws Exception {
		System.out.println("Verify Download Quality change event");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifyDownloadQualityChangeEvent(downloadQualityOption);
	}
	
//	@Test(priority = 6)
	public void verifydefaultsettingsRestoreEvent() throws Exception {
		System.out.println("Default settings Restore Event");
		Zee5ApplicasterMixPanelBusinessLogic.relaunch(true);
		Zee5ApplicasterMixPanelBusinessLogic.verifyDefaultSettingRestoredEvent();
	}
	
	@AfterTest
	public void tearDownApp() {
		System.out.println("\nExecution Complete");
		Zee5ApplicasterMixPanelBusinessLogic.tearDown();
	}

}
