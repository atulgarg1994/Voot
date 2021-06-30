package com.zee5.ApplicasterScripts;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.business.zee.Zee5ApplicasterBusinessLogic;
import com.utility.Utilities;

public class Android_AppUpgradeScenarios {
	private Zee5ApplicasterBusinessLogic ZEE5ApplicasterBusinessLogic;
	
	@BeforeTest
	public void AppLaunch() throws InterruptedException {
		System.out.println("Launching Android App");
		 Utilities.relaunch = true; // Clear App Data on First Launch
		ZEE5ApplicasterBusinessLogic = new Zee5ApplicasterBusinessLogic("zee");
	}
	
	@Test(priority = 0)
	@Parameters({ "userType" })
	public void InstallMarketBuild(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.installmarketBuild();		
	}
	
	@Test(priority = 1)
	@Parameters({ "userType" })
	public void ApplicasterLogin(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		ZEE5ApplicasterBusinessLogic.LoginForUpgradeModule(userType);
	} 
	
	@Test(priority = 2)
	@Parameters({ "userType" })
	public void CaptureUserSettingDetails(String userType) throws Exception {		
		ZEE5ApplicasterBusinessLogic.GetSettingsDetails(userType);
	} 
	
	@Test(priority = 3)
	@Parameters({ "userType" })
	public void LaunchPlaystoreApp(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.UninstallZee5();		
		ZEE5ApplicasterBusinessLogic.LaunchPlayStoreApp();
		ZEE5ApplicasterBusinessLogic.clearPlayStoreAppData();
			}
	
	@Test(priority = 4)
	@Parameters({ "userType" })
	public void InstallBetaBuild(String userType) throws Exception {
				ZEE5ApplicasterBusinessLogic.InstallZee5();			
	}
	
}
