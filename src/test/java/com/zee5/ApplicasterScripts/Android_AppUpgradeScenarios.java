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
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp1("Allow", userType);
		ZEE5ApplicasterBusinessLogic.navigateToIntroScreen_DisplaylangScreen1();
		ZEE5ApplicasterBusinessLogic.LoginForUpgradeModule(userType);
	} 
	
	@Test(priority = 2)
	@Parameters({ "userType" })
	public void CaptureUserSettingDetailsForMarketBuild(String userType) throws Exception {		
		ZEE5ApplicasterBusinessLogic.GetSettingsDetails(userType);		
	} 
	
	//@Test(priority = 3)
	@Parameters({ "userType" })
	public void GetContinueWatchingTrayDetails(String userType) throws Exception {		
		ZEE5ApplicasterBusinessLogic.GetContinueWatchingTrayDetails(userType);
			} 
	
	@Test(priority = 4)
	@Parameters({ "userType" })
	public void GetDownloadsDetailsForMarketBuild(String userType) throws Exception {		
		ZEE5ApplicasterBusinessLogic.DownloadsDetails(userType);
	} 
	
	@Test(priority = 5)
	@Parameters({ "userType" })
	public void GetWatchListDetailsForMarketBuild(String userType) throws Exception {		
		ZEE5ApplicasterBusinessLogic.WatchListDetails(userType);
	} 
	
	@Test(priority = 6)
	@Parameters({ "userType" })
	public void LaunchPlaystoreApp(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.LaunchPlayStoreApp();
		ZEE5ApplicasterBusinessLogic.clearPlayStoreAppData();
			}
	
	@Test(priority = 7)
	@Parameters({ "userType" })
	public void InstallUpgradeBuild(String userType) throws Exception {
				ZEE5ApplicasterBusinessLogic.InstallZee5();			
	}
	
	@Test(priority = 8)
	@Parameters({ "userType" })
	public void CaptureUserSettingsDetailsForUpgradeBuild(String userType) throws Exception {
				ZEE5ApplicasterBusinessLogic.CaptureSettingsDetailsForupgradeBuild();			
	}
	
	//@Test(priority = 9)
	@Parameters({ "userType" })
	public void CaptureContinueWatchingTrayForUpgradeBuild(String userType) throws Exception {
				ZEE5ApplicasterBusinessLogic.CaptureContinueWatchingTrayForUpgradeBuild();			
	}
	
	@Test(priority = 10)
	@Parameters({ "userType" })
	public void CaptureDownloadsForrUpgradeBuild(String userType) throws Exception {
				ZEE5ApplicasterBusinessLogic.CaptureDownloadsForrUpgradeBuild();			
	}
	
	@Test(priority = 11)
	@Parameters({ "userType" })
	public void captureWatchlistDetailsForUpgradeBuild(String userType) throws Exception {
				ZEE5ApplicasterBusinessLogic.captureWatchlistDetailsForUpgradeBuild();			
	}
}
