package com.zee5.CleverTapScripts;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.business.zee.Zee5ApplicasterCleverTapBusinessLogic;
import com.utility.Utilities;

public class SubscriptionCartAbandonment {

	
	private Zee5ApplicasterCleverTapBusinessLogic Zee5ApplicasterCleverTapBusinessLogic;

	@BeforeTest
	public void AppLaunch() throws InterruptedException {
		System.out.println("Launching Andriod App");
		Utilities.relaunch = true;
		Zee5ApplicasterCleverTapBusinessLogic = new Zee5ApplicasterCleverTapBusinessLogic("zee");
	}
	
	@Test(priority = 0)
	@Parameters({ "userType" })
	public void loginresult(String userType) throws Exception {
		Zee5ApplicasterCleverTapBusinessLogic.ZeeApplicasterLogin(userType);
	}

	@Test(priority = 1)
	@Parameters({ "userType" })
	public void SubscriptionPageViewed(String userType) throws Exception {
		Zee5ApplicasterCleverTapBusinessLogic.SubscriptionPageViewed();
	}
	
	@Test(priority = 2)
	@Parameters({ "userType" })
	public void SubscriptionCallInitiated(String userType) throws Exception {
		Zee5ApplicasterCleverTapBusinessLogic.SubscriptionCallInitiated();
	}
	
	@Test(priority = 3)
	@Parameters({ "userType" })
	public void SubscriptionSelected(String userType) throws Exception {
		Zee5ApplicasterCleverTapBusinessLogic.SubscriptionSelected();
	}
	
	@Test(priority = 4)
	@Parameters({ "userType" })
	public void SubscriptionCallReturned(String userType) throws Exception {
		Zee5ApplicasterCleverTapBusinessLogic.SubscriptionCallReturned();
	}
	
	@Test(priority = 5)
	@Parameters({ "userType" })
	public void DisplayLanguageChange(String userType) throws Exception {
		Zee5ApplicasterCleverTapBusinessLogic.DisplayLanguageChange();
	}
	
	@Test(priority = 6)
	@Parameters({ "userType" })
	public void ContentLanguageChange(String userType) throws Exception {
		Zee5ApplicasterCleverTapBusinessLogic.ContentLanguageChange();
	}
	
	@Test(priority = 7)
	@Parameters({ "userType" })
	public void SearchCancelled(String userType) throws Exception {
		Zee5ApplicasterCleverTapBusinessLogic.SearchCancelled();
	}
	
	@Test(priority = 8)
	@Parameters({ "userType" })
	public void AddToWatchlist(String userType) throws Exception {
		Zee5ApplicasterCleverTapBusinessLogic.AddToWatchlist();
	}
	
	@Test(priority = 9)
	@Parameters({ "userType" })
	public void Share(String userType) throws Exception {
		Zee5ApplicasterCleverTapBusinessLogic.Share();
	}
	
	@Test(priority = 10)
	@Parameters({ "userType" })
	public void RemoveFromWatchlist(String userType) throws Exception {
		Zee5ApplicasterCleverTapBusinessLogic.RemoveFromWatchlist();
	}
	
//	@Test(priority = 10)
//	@Parameters({ "userType" })
//	public void PromoCodeResult(String userType) throws Exception {
//		Zee5ApplicasterCleverTapBusinessLogic.PromoCodeResult();
//	}
	
//	@Test(priority = 11)
	@Parameters({ "userType" })
	public void logout(String userType) throws Exception {
		Zee5ApplicasterCleverTapBusinessLogic.logout();
	}
	
	
	@Test(priority = 11)
	@Parameters({ "userType" })
	public void CleverTapRegistrationCheck(String userType) throws Exception {
		Zee5ApplicasterCleverTapBusinessLogic.relaunch(true);
		Zee5ApplicasterCleverTapBusinessLogic.accessDeviceLocationPopUp("Allow", userType);	
		Zee5ApplicasterCleverTapBusinessLogic.SelectYourCountry();
		Zee5ApplicasterCleverTapBusinessLogic.RegisterFunctionality(userType);
	}
	
	
	
	@Test(priority = 12)
	@Parameters({ "userType" })
	public void CleverTapLoginEventsCheck(String userType) throws Exception {
		Zee5ApplicasterCleverTapBusinessLogic.relaunch(true);
		Zee5ApplicasterCleverTapBusinessLogic.accessDeviceLocationPopUp("Allow", userType);	
		Zee5ApplicasterCleverTapBusinessLogic.SelectYourCountry();
		Zee5ApplicasterCleverTapBusinessLogic.cleverTapLoginFunctionality(userType);
	}
	
	
	
	@AfterTest
	public void tearDownApp() {
		System.out.println("Quit the App");
		Zee5ApplicasterCleverTapBusinessLogic.tearDown();
	}
}
