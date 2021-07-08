package com.zee5.Zee5TvScripts;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TvZee5TvperformanceScripts {

	public class TvZee5ATVScripts {

		private com.business.zee.Zee5TvBusinessLogic Zee5TvBusiness;

		@BeforeTest
		public void Before() throws InterruptedException {
			// Utilities.relaunch = true;
			Zee5TvBusiness = new com.business.zee.Zee5TvBusinessLogic("zeeTV");
		}

		@Test(priority = 01)
		@Parameters({ "userType" })
		public void appLaunchPerformance(String userType) throws Exception {
			Zee5TvBusiness.appLaunch(userType);
		}

		@Test(priority = 02)
		@Parameters({ "userType" })
		public void loginPerformance(String userType) throws Exception {
			Zee5TvBusiness.loginPerformance(userType);
		}

		@Test(priority = 03)
		@Parameters({ "userType" })
		public void navigationPerformance(String userType) throws Exception {
			Zee5TvBusiness.SelectTopNavigationTab_Timer("Movies");
		}

		@Test(priority = 04)
		@Parameters({ "userType" })
		public void playbackperformanace(String userType) throws Exception {
			Zee5TvBusiness.Performance_InitiateContentPlayback();
		}

		@Test(priority = 05)
		@Parameters({ "userType" })
		public void deeplinkperformanace(String userType) throws Exception {
			Zee5TvBusiness.deepLink_Validation("Consumption");
		}

		@AfterTest
		public void After() {
			System.out.println("Tear Down");
			// System.out.println(Zee5TvBusiness.performaceDetails);
			Zee5TvBusiness.TvtearDown();
		}
	}
}
