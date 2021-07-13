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
	public void SubscriptionCallInitiatedEvent(String userType) throws Exception {
		Zee5ApplicasterCleverTapBusinessLogic.SubscriptionCallInitiated();
	}

	
	@AfterTest
	public void tearDownApp() {
		System.out.println("Quit the App");
		Zee5ApplicasterCleverTapBusinessLogic.tearDown();
	}
}
