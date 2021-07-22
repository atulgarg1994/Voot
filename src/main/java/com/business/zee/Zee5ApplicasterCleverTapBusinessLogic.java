package com.business.zee;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.WebElement;
import com.CleverTap.CleverTapDashboardData;
import com.driverInstance.CommandBase;
import com.extent.ExtentReporter;
import com.propertyfilereader.PropertyFileReader;
import com.utility.LoggingUtils;
import com.utility.Utilities;
import com.zee5.ApplicasterPages.AMDCleverTapPage;
import com.zee5.ApplicasterPages.AMDConsumptionScreen;
import com.zee5.ApplicasterPages.AMDHomePage;
import com.zee5.ApplicasterPages.AMDLoginScreen;
import com.zee5.ApplicasterPages.AMDMoreMenu;
import com.zee5.ApplicasterPages.AMDMySubscriptionPage;
import com.zee5.ApplicasterPages.AMDOnboardingScreen;
import com.zee5.ApplicasterPages.AMDRegistrationScreen;
import com.zee5.ApplicasterPages.AMDSearchScreen;
import com.zee5.ApplicasterPages.AMDWatchlistPage;
import com.zee5.PWAPages.CleverTapPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;

public class Zee5ApplicasterCleverTapBusinessLogic extends Utilities{

	
	public Zee5ApplicasterCleverTapBusinessLogic(String Application) {
		new CommandBase(Application);
		init();
	}

	private int timeout;

	/** Retry Count */
	private int retryCount;
	ExtentReporter extent = new ExtentReporter();

	/** The Constant logger. */
	static LoggingUtils logger = new LoggingUtils();

	/** The Android driver. */
	public AndroidDriver<AndroidElement> androidDriver;

	/** The Android driver. */
	public IOSDriver<WebElement> iOSDriver;

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public int getRetryCount() {
		return retryCount;
	}

	public void setRetryCount(int retryCount) {
		this.retryCount = retryCount;
	}

	public void init() {
		PropertyFileReader handler = new PropertyFileReader("properties/Execution.properties");
		setTimeout(Integer.parseInt(handler.getproperty("TIMEOUT")));
		setRetryCount(Integer.parseInt(handler.getproperty("RETRY_COUNT")));
		CleverTapTime();
		decode();
	}	
	
	public void tearDown() {
		getWebDriver().quit();
	}
	
	public void navigateToCleverTap() throws Exception{
		HeaderChildNode("Navigating to Segment section");
		verifyElementPresentAndClick(CleverTapPage.objSegments, "Segment");
		type(CleverTapPage.objSearchField, "Autoclevertap@g.com", "Search field");
		verifyElementPresentAndClick(CleverTapPage.objFindBtn, "Find button");
		waitTime(20000);
		verifyElementPresentAndClick(CleverTapPage.objActivityBtn, "Activity button");
	}
	
	public void loginCleverTap() throws Exception {
		HeaderChildNode("Login Clever tap");
		type(CleverTapPage.objEmailID, CTUserName, "Email field");
		type(CleverTapPage.objPasswordEditBx, CTPWD, "Password field");
		verifyElementPresentAndClick(CleverTapPage.objLoginBtn, "Login button");
	}
	
	public void getEventName(String EventName) {
		try {
			HeaderChildNode("Event Name");
			CleverTapDashboardData.creatExcelCleverTap();
			waitTime(10000);
			List<WebElement> event = findElements(CleverTapPage.objEventName);
			List<WebElement> time = findElements(CleverTapPage.objTime);
			System.out.println(event.size());
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss a");
			Date d1 = sdf.parse(currentDate);
			boolean eventReflected = false;
			for (int i = 0; i < event.size(); i++) {
				Date d2 = sdf.parse(time.get(i).getText());
				long elapsed = ((d2.getTime() - d1.getTime()) / 1000);
				if (elapsed >= 0) {
					if (event.get(i).getText().contains(EventName)) {
						logger.info("Event Reflected in dashboard " + EventName);
						extent.extentLoggerPass("Event", "Event Reflected in dashboard " + EventName);
						eventReflected = true;
						break;
					}
				} else {
					eventReflected = true;
					break;
				}
			}
			if (eventReflected) {
				logger.info("Event not reflected in dashboard " + EventName);
				extent.extentLoggerFail("Event", "Event not reflected in dashboard " + EventName);
			}
		} catch (Exception e) {
		}
	}

	
	public void SubscriptionPageViewed() throws Exception {
		HeaderChildNode("Subscription Page Viewed");
		waitTime(2000);
		verifyElementPresentAndClick(AMDHomePage.objBuyPlanCTA, "Buy Plan");
	}
	
	public void SubscriptionSelected() throws Exception {
		HeaderChildNode("Subscription Selected");
		verifyElementPresentAndClick(AMDMySubscriptionPage.objSelectPlanCheckBx, "Premium Plan Check Box");
	}
	
	public void SubscriptionCallInitiated() throws Exception {
		HeaderChildNode("Subscription Call Initiated");
		verifyElementPresentAndClick(AMDMySubscriptionPage.objContinueBtnInBuyPremiumNow, "Continue button");
	}
	
	public void SubscriptionCallReturned(String userType) throws Exception {
		if(!userType.equals("Guest")) {
		HeaderChildNode("Subscription Call Returned");
		verifyElementPresentAndClick(AMDMySubscriptionPage.objEnterCardNumberBtn, "Enter Card Number");
		type(AMDMySubscriptionPage.objEnterCCTxt,"4012001037141112", "Card Number");
		type(AMDMySubscriptionPage.objExpiryCCTxt, "0525", "Expiry");
		type(AMDMySubscriptionPage.objCVVTxt, "124", "CVV");
		verifyElementPresentAndClick(AMDMySubscriptionPage.objPayNow, "Pay Now button");
		waitTime(180000);
		}
	}
	
	
	public void DisplayLanguageChange() throws Exception {
		HeaderChildNode("Display Language Change");
		Back(1);
		Back(1);
		verifyElementPresentAndClick(AMDHomePage.objMoreMenuBtn, "More menu");
		verifyElementPresentAndClick(AMDMoreMenu.objSettings, "Settings");
		verifyElementPresentAndClick(AMDMoreMenu.objDisplayLang, "Display Language");
		click(AMDMoreMenu.objContinueLangBtn,"Continue");
	}

	public void ContentLanguageChange() throws Exception {
		HeaderChildNode("Content Language Change");
//		verifyElementPresentAndClick(AMDHomePage.objMoreMenuBtn, "More menu");
//		verifyElementPresentAndClick(AMDMoreMenu.objSettings, "Settings");		
		verifyElementPresentAndClick(AMDMoreMenu.objContentLang, "Content Language");
		click(AMDMoreMenu.objContinueLangBtn,"Continue");
	}

	public void SearchCancelled() throws Exception {
		Back(1);
		waitTime(2000);
		Back(1);
		HeaderChildNode("Search Cancelled");
		verifyElementPresentAndClick(AMDHomePage.objSearchBtn, "Search");
		verifyElementPresentAndClick(AMDSearchScreen.objSearchBackBtn, "Back button");
	}

	public void AddToWatchlist(String userType) throws Exception {
		if(!userType.equals("Guest")) {
		HeaderChildNode("Add To Watchlist");
		waitTime(2000);
		verifyElementPresentAndClick(AMDHomePage.objSearchBtn, "Search");
		waitTime(2000);
		type(AMDSearchScreen.objsearchBox,"love u ganesha","search field");
		waitTime(2000);
		verifyElementPresentAndClick(AMDSearchScreen.objFisrtSearchContent,"First Content In Search");
		verifyElementPresentAndClick(AMDConsumptionScreen.objWatchlistBtn, "Watchlist button");
		}
	}

	public void Share() throws Exception {
		HeaderChildNode("Share");
		extent.HeaderChildNode("Verify Share CTA functionality");
		System.out.println("\nVerify Share CTA functionality");

		click(AMDConsumptionScreen.objShareBtn, "Share button");
		boolean isShareOption = verifyIsElementDisplayed(AMDMoreMenu.objshareOptions);
		if (isShareOption) {
			logger.info("User is navigated share options screen");
			extent.extentLoggerPass("Share through options screen", "User is navigated to share options screen");
			int shareOptions = getDriver().findElements(AMDMoreMenu.objShareOptions).size();
			if (shareOptions == 0) {
				extent.extentLoggerFail("Verify share options", "Share Options are not available");
				logger.info("Share Options are not available");
			} else {
				for (int i = 2; i <= shareOptions; i++) {
					String shareOptionName = getText(AMDMoreMenu.objShareOptions(i));
					logger.info("Share Option : \"" + shareOptionName + "\" is available to share");
					extent.extentLoggerPass("Share Option ",
							"Share Option : \"" + shareOptionName + "\" is available to share");
				}
			}
		} else {
			logger.info("Share Options are not displayed after clicking on Share CTA");
			extent.extentLoggerFail("Share through options screen",
					"Share Options are not displayed after clicking on Share CTA");
		}
		Back(1);
	}

	public void RemoveFromWatchlist(String userType) throws Exception {
		if(!userType.equals("Guest")) {
		Back(1);
		HeaderChildNode("Remove From Watchlist");
		verifyElementPresentAndClick(AMDHomePage.objMoreMenuBtn, "More menu");
		verifyElementPresentAndClick(AMDMoreMenu.objWatchlist, "Watchlist");
		verifyElementPresentAndClick(AMDWatchlistPage.objEditBtn, "Edit button");
		verifyElementPresentAndClick(AMDWatchlistPage.objSelectCheckBox, "Check box");
		verifyElementPresentAndClick(AMDWatchlistPage.objDeleteAllBtn, "Delete button");
		}
	}

	public void PromoCodeResult() {
		HeaderChildNode("Promo Code Result");
		
	}
	
	
	public void ZeeApplicasterLogin(String LoginMethod) throws Exception {
		System.out.println("\nLogin to the App");
		verifyElementPresentAndClick(AMDCleverTapPage.objCountryScreenConitnueBtn, "Continue button");
		switch (LoginMethod) {
		case "Guest":
			extent.HeaderChildNode("Logged in as <b>Guest</b> User");

			extent.extentLogger("Accessing the application as Guest user",
					"Accessing the application as <b>Guest</b> user");
			break;

		case "NonSubscribedUser":
			extent.HeaderChildNode("Login as NonSubscribed User");
			verifyElementPresentAndClick(AMDCleverTapPage.objCountryScreenConitnueBtn, "Continue button");
			String Username = getParameterFromXML("NonsubscribedUserName");
			String Password = getParameterFromXML("NonsubscribedPassword");

			verifyElementPresentAndClick(AMDHomePage.objHomeBtn, "Home tab");
			verifyElementPresentAndClick(AMDHomePage.objMoreMenu, "More Menu");
			verifyElementPresent(AMDMoreMenu.objLoginRegisterText, "Login/Register for best experience text");

			click(AMDMoreMenu.objLoginRegisterText, "Login/Registet link");
			verifyElementPresentAndClick(AMDLoginScreen.objEmailIdField, "Email field");
			type(AMDLoginScreen.objEmailIdField, Username, "Email Field");
			verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed Button");
			verifyElementPresentAndClick(AMDLoginScreen.objPasswordField, "Password Field");
			type(AMDLoginScreen.objPasswordField, Password, "Password field");
			hideKeyboard();
			verifyElementPresentAndClick(AMDLoginScreen.objLoginBtn, "Login Button");
			waitTime(3000);
			break;

		case "SubscribedUser":
			extent.HeaderChildNode("Login as Subscribed User");

			String SubscribedUsername = getParameterFromXML("SubscribedUserName");
			String SubscribedPassword = getParameterFromXML("SubscribedPassword");

			verifyElementPresentAndClick(AMDHomePage.objHomeBtn, "Home tab");
			verifyElementPresentAndClick(AMDHomePage.objMoreMenu, "More Menu");
			verifyElementPresent(AMDMoreMenu.objLoginRegisterText, "Login/Register for best experience text");

			click(AMDMoreMenu.objLoginRegisterText, "Login/Registet link");
			verifyElementPresentAndClick(AMDLoginScreen.objEmailIdField, "Email field");
			type(AMDLoginScreen.objEmailIdField, SubscribedUsername, "Email Field");
			verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed Button");
			verifyElementPresentAndClick(AMDLoginScreen.objPasswordField, "Password Field");
			type(AMDLoginScreen.objPasswordField, SubscribedPassword, "Password field");
			hideKeyboard();
			verifyElementPresentAndClick(AMDLoginScreen.objLoginBtn, "Login Button");
			waitTime(3000);
			break;																
		}
	}
	
	public void logout(String userType) throws Exception {
		if(!userType.equals("Guest")) {
		HeaderChildNode("LogOut");
		verifyElementPresentAndClick(AMDHomePage.objMoreMenuBtn, "More menu");
		Swipe("UP", 1);
		verifyElementPresentAndClick(AMDMoreMenu.objLogoutBtn, "Logout");
		}
	}
	
	
	
	public void NoThanksPopUp(String permission, String userType) throws Exception {
		extent.HeaderChildNode("Access Device Location PopUp");
		extent.extentLogger("User Type", "UserType : " + userType);
		logger.info("UserType : " + userType);
		System.out.println("Access Device Location PopUp");
		Thread.sleep(10000);
		Thread.sleep(10000);
				if(verifyIsElementDisplayed(AMDOnboardingScreen.objUpdateZee5PopUpNOTHANKSButton, "NO THANKS Button"))
				{
					click(AMDOnboardingScreen.objUpdateZee5PopUpNOTHANKSButton, "NO THANKS Button");
				}else{
					System.out.println("UpdateZee5 Not displayed");
				}
//				Thread.sleep(10000);
//		if (verifyIsElementDisplayed(AMDOnboardingScreen.objAllowLocationAccessPopup, "AllowPopup")) {
//			Wait(5000);
//
//			String str1 = getAttributValue("text", AMDOnboardingScreen.objFirstPermissionButton);
//			String str2 = getAttributValue("text", AMDOnboardingScreen.objSecondPermissionButton);
//			System.out.println(str1);
//			System.out.println(str2);
//
//			if (str1.contains("ALLOW")) {
//				System.out.println("ALLOW is present");
//				click(AMDOnboardingScreen.ele1Allow(str1), str1);
//			} else if (str1.contains("Allow")) {
//				System.out.println("Allow is present");
//				click(AMDOnboardingScreen.ele1Allow(str1), str1);
//			} else if (str2.contains("ALLOW")) {
//				System.out.println("ALLOW is present");
//				click(AMDOnboardingScreen.ele1Allow(str2), str2);
//			} else if (str2.contains("Allow")) {
//				System.out.println("Allow is present");
//				click(AMDOnboardingScreen.ele1Allow(str2), str2);
//			} else if (str1.contains("WHILE USING THE APP")) {
//				System.out.println("WHILE USING THE APP is present");
//				click(AMDOnboardingScreen.ele1Allow(str1), str1);
//			}
//			Thread.sleep(10000);
//		} else {
//			System.out.println("Access Device Location PopUp not displayed");
//		}
				SelectYourCountry();

	}
	
	
	
	public void SelectYourCountry() throws Exception
	{
		extent.HeaderChildNode("Select Your country and Language");
		waitTime(5000);
		verifyElementPresentAndClick(AMDOnboardingScreen.objContinueBtnInCountryPopUp, "SelectYourCountry Continue Button");
		waitTime(5000);
	}
	
	
	
	public void cleverTapLoginFunctionality(String userType) throws Exception{
		extent.HeaderChildNode("CleverTap Login");
		
		if(userType.equalsIgnoreCase("Guest")) {
		
		String Username = getParameterFromXML("NonsubscribedUserName");
		String Password = getParameterFromXML("NonsubscribedPassword");

		verifyElementPresentAndClick(AMDOnboardingScreen.objZeeMoreButton, "More button");
		
		verifyElementPresentAndClick(AMDOnboardingScreen.objZeeLoginRegisterLink, "Login/Register Link");

		verifyElementPresentAndClick(AMDLoginScreen.objEmailIdField, "Email field");
		type(AMDLoginScreen.objEmailIdField, Username, "Email Field");
		verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed Button");
		verifyElementPresentAndClick(AMDLoginScreen.objPasswordField, "Password Field");
		type(AMDLoginScreen.objPasswordField, Password, "Password field");
		hideKeyboard();
		verifyElementPresentAndClick(AMDLoginScreen.objLoginBtn, "Login Button");
		waitTime(3000);
		
		}
	}
	
	
	
	
	public void RegisterFunctionality(String userType) throws Exception{
		extent.HeaderChildNode("CleverTap Register");
		if(userType.equals("Guest")){
			//REGISTRATION
			String pDOB = "01/01/1990";
			String newEmailID = null;
			String newPassword = "123456";
			//ResponseInstance.newPassword = "123456";
			String firstName = generateRandomString(6);
			String lastName = generateRandomString(6);

			verifyElementPresentAndClick(AMDHomePage.MoreMenuIcon, "More Menu");
			
			verifyElementPresentAndClick(AMDMoreMenu.objLoginRegister, "Login/Register Button");
			//ResponseInstance.newEmailID = generateRandomString(8) + "@gmail.com";
			newEmailID = generateRandomString(8) + "@gmail.com";
			extent.extentLogger("", "New emailID : "+newEmailID);
			type(AMDRegistrationScreen.objEmailIDTextField, newEmailID, "Email field");
			click(AMDRegistrationScreen.objProceedBtn, "Proceed button");
			
			verifyElementExist(AMDRegistrationScreen.objScreenTitle, "Register for free title");
			verifyElementPresentAndClick(AMDRegistrationScreen.objFirstNameTxtField, "First name field");		
			type(AMDRegistrationScreen.objFirstNameTxtField, firstName, "First name");
//			hideKeyboard();
			
			verifyElementPresentAndClick(AMDRegistrationScreen.objLastNameTxtField, "Last Name field");
			type(AMDRegistrationScreen.objLastNameTxtField, lastName, "Last Name");
//			hideKeyboard();
			
			click(AMDRegistrationScreen.objDOBTxtField, "DOB field");
			type(AMDRegistrationScreen.objDOBTxtField, pDOB, "DOB");
//			hideKeyboard();		
			
			verifyElementPresentAndClick(AMDRegistrationScreen.objGederTxtField, "Gender field");
			verifyElementPresentAndClick(AMDRegistrationScreen.objMale, "Gender male");
			
			verifyElementPresentAndClick(AMDRegistrationScreen.objPasswordTxtField, "Passowrd field");
			type(AMDRegistrationScreen.objPasswordTxtField, newPassword, "Password");
			hideKeyboard();
			waitTime(5000);
			verifyElementPresentAndClick(AMDRegistrationScreen.objRegisterBtn, "Register button");
			waitTime(10000);	
		}
	}
	
	
	
	/**
	 * Function to Relaunch the driver
	 */
	public void relaunch(boolean clearData) throws Exception {
		HeaderChildNode("Relaunch the app");
		logger.info("Relaunching the application");
		extent.extentLogger("Relaunch", "Relaunching the application");
		waitTime(10000);
		getDriver().quit();
		relaunch = clearData;
		new Zee5ApplicasterBusinessLogic("zee");
		if (userType != "Guest" & clearData == false) {
			System.out.println("Navigates to Landing Sccreen..");
		}
	}
	
	
	public void validateResult() throws Exception {
		HeaderChildNode("Verify Events are reflected in dashboard");
		setPlatform("Web");
		new Zee5ApplicasterCleverTapBusinessLogic("Chrome");
			loginCleverTap();
			navigateToCleverTap();
			getEventName("Subscription Call Returned");
			getEventName("Subscription Call Initiated");
			getEventName("Subscription Selected");
			getEventName("Subscription Page Viewed");
			getEventName("Share");
			getEventName("Remove From Watchlist");
			getEventName("Search Cancelled");
			getEventName("Content Language Changed");
			getEventName("Display Language Changed");
			getEventName("Login Result");
			getEventName("Logout");
			getWebDriver().quit();
			setPlatform("Android");
	}
	
}
