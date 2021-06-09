package com.zee5.ApplicasterScripts;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.business.zee.Zee5ApplicasterBusinessLogic;
import com.utility.Utilities;

public class Android_Search {
	
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
	@Parameters({ "userType" }) //Bindu
	public void SearchScreen(String userType) throws Exception {
	    ZEE5ApplicasterBusinessLogic.verifySearchOption(userType);
		ZEE5ApplicasterBusinessLogic.verifySearchLandingScreen(userType);
		ZEE5ApplicasterBusinessLogic.SearchBox(userType);
	}
	
	@Test(priority = 2)
	@Parameters({ "userType"}) //Sushma
	public void  TopAndTrendingSearches(String UserType) throws Exception {
		ZEE5ApplicasterBusinessLogic.TopSearches(UserType);
		ZEE5ApplicasterBusinessLogic.TrendingSearches();
	}
	
	@Test(priority = 3)		// Manasa
	@Parameters({ "userType"})		
	public void searchResultScreenValidation(String userType) throws Exception {
		System.out.println("\nVerify Search Result screen");
		ZEE5ApplicasterBusinessLogic.noSearchResults("gsggdhshs%$$%&");
		ZEE5ApplicasterBusinessLogic.searchPageValidation("Kam");
		ZEE5ApplicasterBusinessLogic.searchResultsAllTabs("Kamali");
	}
	
	@Test(priority = 4)		// Manasa
	@Parameters({ "userType" })		
	public void voiceSearchValidation(String userType) throws Exception {
		System.out.println("\nVerify Voice Search functionality");
		ZEE5ApplicasterBusinessLogic.voiceSearchValidation();
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.accessDeviceLocationPopUp("Allow", userType);
		ZEE5ApplicasterBusinessLogic.navigateToIntroScreen_DisplaylangScreen();
		ZEE5ApplicasterBusinessLogic.ZeeApplicasterLogin(userType);
		ZEE5ApplicasterBusinessLogic.voiceSearchDenyValidation();
	}
	
	@Test(priority = 5)		
	@Parameters({ "userType"})		
	public void searchResults(String userType) throws Exception {
		System.out.println("\nVerify Search Results");
		ZEE5ApplicasterBusinessLogic.SearResultsOfDifferentTestData("Allu Arjun"); //Search by Actor
		ZEE5ApplicasterBusinessLogic.SearResultsOfDifferentTestData("Kannada");
		ZEE5ApplicasterBusinessLogic.relaunch(false);
		ZEE5ApplicasterBusinessLogic.SearResultsOfDifferentTestData("Action");  //Search by Genre
		ZEE5ApplicasterBusinessLogic.SearResultsOfDifferentTestData("Star wars"); 
    }
	
	@Test(priority = 6)		
	@Parameters({ "userType"})		
	public void VerifysearchResults(String userType) throws Exception {
		System.out.println("\nVerify Search Results");
		ZEE5ApplicasterBusinessLogic.relaunch(true);
        ZEE5ApplicasterBusinessLogic.SearResultsOfDifferentTestData("Simba");
        ZEE5ApplicasterBusinessLogic.SearResultsOfDifferentTestData("Zee5 Originals");
        ZEE5ApplicasterBusinessLogic.relaunch(false);
        ZEE5ApplicasterBusinessLogic.SearResultsOfDifferentTestData("URI"); 
     }
	
	@Test(priority = 7)		
	@Parameters({ "userType"})		
	public void searchResultsForDifferentData(String userType) throws Exception {
		System.out.println("\nVerify Search Results");
		ZEE5ApplicasterBusinessLogic.relaunch(true);
		ZEE5ApplicasterBusinessLogic.SearResultsOfDifferentTestData("TV9");
		ZEE5ApplicasterBusinessLogic.SearResultsOfDifferentTestData("Kumkum bhagya-Episode 131000"); 
		ZEE5ApplicasterBusinessLogic.relaunch(false);
		ZEE5ApplicasterBusinessLogic.SearchResultByContentDescription("Tanu is shocked to see Pradeep alive. He threatens her, but she offers him a deal. Prachi tries to start things afresh with Rhea. Pallavi talks to Abhi and Pragya about Ranbeer and Rhea’s wedding.");
	}
	
	@AfterTest
	public void tearDownApp() {
		System.out.println("\nQuit the App\n");
		ZEE5ApplicasterBusinessLogic.tearDown();
	}

}
