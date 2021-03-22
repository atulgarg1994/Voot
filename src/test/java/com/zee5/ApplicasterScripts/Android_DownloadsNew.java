package com.zee5.ApplicasterScripts;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.business.zee.Zee5ApplicasterBusinessLogic;
import com.utility.Utilities;

public class Android_DownloadsNew {
	private Zee5ApplicasterBusinessLogic ZEE5ApplicasterBusinessLogic;

	@BeforeTest
	public void AppLaunch() throws InterruptedException {
		System.out.println("Launching Andriod App");
		Utilities.relaunch = true; // Clear App Data on First Launch
		ZEE5ApplicasterBusinessLogic = new Zee5ApplicasterBusinessLogic("zee");
	}
	
	@Test(priority = 0)	 
	@Parameters({ "userType" })
	public void ApplicasterLogin(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		ZEE5ApplicasterBusinessLogic.ZeeApplicasterLogin(userType);
	}
	
	@Test(priority = 1)
	@Parameters({ "userType"})
	public void ContentPlayBackDownloads(String userType) throws Exception {
			ZEE5ApplicasterBusinessLogic.DownloadsContentPlayBackValidation(userType,"Better",true);
	}
	
	@Test(priority = 2)
	@Parameters({ "userType"})
	public void DonwloadsLandingScreen(String userType) throws Exception {
		ZEE5ApplicasterBusinessLogic.DownloadScreenUIUXValidation(userType);
		ZEE5ApplicasterBusinessLogic.BrowseToDownloadFunctionality(userType);
		//ZEE5ApplicasterBusinessLogic.DownloadScreenValidation(userType);
	}
	
	@Test(priority = 3)
	@Parameters({ "userType"})
	public void Downloads_EmptystateScreenValidation(String userType) throws Exception {
			ZEE5ApplicasterBusinessLogic.EmptystateScreenValidation(userType);
	}
	
	@Test(priority = 4)
	@Parameters({ "userType"})
	public void Downloads_verifyDownloadsWithSingleTire(String userType) throws Exception {
			ZEE5ApplicasterBusinessLogic.verifyDownloadsWithSingleTire(userType);
	}

	@Test(priority = 5)
	@Parameters({ "userType","MovieName","VideoQuality"})
	public void Downloads_verifyMovieContentInDownloadsScreen(String userType,String pMovie, String pVideoQuality) throws Exception {
			ZEE5ApplicasterBusinessLogic.verifyMovieContentInDownloadsScreen(userType, pMovie, pVideoQuality);
	}	

	@Test(priority = 6)
	@Parameters({ "userType"})
	public void Downloads_validationofDownloadingContent(String userType) throws Exception {
		    ZEE5ApplicasterBusinessLogic.relaunch(true);
		    ZEE5ApplicasterBusinessLogic.navigateToHomeLandingScreen();
			ZEE5ApplicasterBusinessLogic.validationofDownloadingContent(userType);
	}
	
	//@Test(priority = 7)
	@Parameters({ "userType"})
	public void Downloads_DownloadingOffline(String userType) throws Exception {
			ZEE5ApplicasterBusinessLogic.DownloadingOffline(userType);
	}
	
	@Test(priority = 8)
	@Parameters({ "userType"})
	public void Downloads_validationofDeletedContentAndMultipleDownloads(String userType) throws Exception {
			ZEE5ApplicasterBusinessLogic.DeletedContentAndMultipleDownloadContent(userType);
	}
	
	@Test(priority = 9)
	@Parameters({ "userType"})
	public void Downloads_pauseAllAndCancelDownload(String userType) throws Exception {
			ZEE5ApplicasterBusinessLogic.pauseAllAndCancelDownload(userType);
	}
	
	
	@Test(priority = 10)
	@Parameters({ "userType"})
	public void Downloads_validationofDownloadsSectionAndLatestEpisode(String userType) throws Exception {
		     ZEE5ApplicasterBusinessLogic.relaunch(true);
		     ZEE5ApplicasterBusinessLogic.navigateToHomeLandingScreen();
			 ZEE5ApplicasterBusinessLogic.DownloadsSectionAndLatestEpisode(userType);
	}
	
	@Test(priority = 11)
	@Parameters({ "userType"})
	public void Downloads_ValidateSubscriptionExpireBanner(String userType) throws Exception {
		if (userType.contentEquals("SubscribedUser")) {
			ZEE5ApplicasterBusinessLogic.ZNALogoutMethod();
			ZEE5ApplicasterBusinessLogic.ValidateSubscriptionExpireBanner();
		}
				}
	
	@AfterTest
	public void tearDownApp() {
		System.out.println("\nQuit the App\n");
		ZEE5ApplicasterBusinessLogic.tearDown();
	}
}
