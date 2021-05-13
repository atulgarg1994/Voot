package com.zee5.PWASanityScripts;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.business.zee.Zee5PWASanityWEBBusinessLogic;

public class WebPWAComboOfferScript {

	private Zee5PWASanityWEBBusinessLogic Zee5WEBPWASanityBusinessLogic;

	@BeforeTest
	public void init() throws Exception {
		// zee5WebBusinessLogic.relaunchFlag = false;
		Zee5WEBPWASanityBusinessLogic = new Zee5PWASanityWEBBusinessLogic("Chrome");
	}

	@Test(priority = 1)
	@Parameters({ "userType" })
	public void PWAWEBLogin(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.ZeeWEBPWALogin(userType);
	}
	
//	@Test(priority = 2)
	@Parameters({ "userType" })
	public void InSprintComboOfferAutomation(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.ComboOfferPremiumPlex(userType);
	}
	
	@Test(priority = 3) //Hitesh
	@Parameters({ "userType" })
	public void ComboOfferAutomation(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.ValidateCTAsAndValidateComboOfferScreen();
	}
	
//	@Test(priority = 4) //Lakshmi
	@Parameters({ "userType" })
	public void SubscriptionComboOfferPageValidation(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.pwasubscription(userType);
		Zee5WEBPWASanityBusinessLogic.pwavalidatingpaymentpage(userType);
		Zee5WEBPWASanityBusinessLogic.pwavalidatinupiandwalletpaymentpage(userType);
		Zee5WEBPWASanityBusinessLogic.PWAMobikvikPageValidation(userType);
		Zee5WEBPWASanityBusinessLogic.pwainsprint1(userType);
		Zee5WEBPWASanityBusinessLogic.pwainsprint(userType);
	}
	
//	@Test(priority = 5)
	@Parameters({ "userType" })
	public void InSprintComboOfferAutomations(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.navigateToHome();
		Zee5WEBPWASanityBusinessLogic.ComboOfferPremiumPlexSub(userType);
	}
	
}
