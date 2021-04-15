package com.zee5.ApplicasterScripts;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.business.zee.Zee5ApplicasterBusinessLogic;
import com.utility.Utilities;

public class TasksAndDefects {

	private Zee5ApplicasterBusinessLogic ZEE5ApplicasterBusinessLogic;

	@BeforeTest
	public void AppLaunch() throws InterruptedException {
		System.out.println("Launching Android App");
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
	@Parameters({ "userType", "searchKeyword4" })
	public void TasksAndDefects(String userType, String searchKeyword4) throws Exception {
		ZEE5ApplicasterBusinessLogic.tasksAndDefectsValidation(userType, searchKeyword4);
		
	}
	
	@Test(priority = 2)
	@Parameters({ "userType"})
	public void TasksAndDefectsMethod2(String userType) throws Exception {
		   ZEE5ApplicasterBusinessLogic.DownloadUpNextContent(userType);
		   ZEE5ApplicasterBusinessLogic.PostLogoutValidation(userType);
		   ZEE5ApplicasterBusinessLogic.LoginFromMoreScreen(userType);
		   ZEE5ApplicasterBusinessLogic.RecommendRailInMovies(userType);
		   ZEE5ApplicasterBusinessLogic.PlayEduauraaAndValidateExpandCollapseofBenefitsSection(userType);
		   ZEE5ApplicasterBusinessLogic.RecommendRailListingScreenInNews(userType);
		   ZEE5ApplicasterBusinessLogic.ContinueWatchingTrayDefectValidation(userType);
		   ZEE5ApplicasterBusinessLogic.TrendingNews(userType);
		   ZEE5ApplicasterBusinessLogic.SearchedContent(userType);
		   ZEE5ApplicasterBusinessLogic.ValidationOfDownloadedContentInDownlodsScreen(userType);
		   ZEE5ApplicasterBusinessLogic.prepaidCodeValidation(userType);
		   ZEE5ApplicasterBusinessLogic.EduaraaCarousel(userType);
		   ZEE5ApplicasterBusinessLogic.contentPlayBackValidation(userType);
		   ZEE5ApplicasterBusinessLogic.DownloadBeforeTvContent(userType);
		   ZEE5ApplicasterBusinessLogic.AllEpisodeTrayListingScreen(userType);
		   ZEE5ApplicasterBusinessLogic.relaunch(true);
		   ZEE5ApplicasterBusinessLogic.LaunchAppinOffline(userType);
		   ZEE5ApplicasterBusinessLogic.ValidatingQualityOptionDefect(userType);
	}
	
	@AfterTest
	public void tearDownApp() {
		System.out.println("Quit the App");
		ZEE5ApplicasterBusinessLogic.tearDown();
	}
}