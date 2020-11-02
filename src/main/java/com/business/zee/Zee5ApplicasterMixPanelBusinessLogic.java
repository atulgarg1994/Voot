package com.business.zee;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import com.deviceDetails.DeviceDetails;
import com.driverInstance.CommandBase;
import com.emailReport.GmailInbox;
import com.extent.ExtentReporter;
import com.jayway.restassured.response.Response;
import com.metadata.ResponseInstance;
import com.mixpanelValidation.Mixpanel;
import com.propertyfilereader.PropertyFileReader;
import com.utility.LoggingUtils;
import com.utility.Utilities;
import com.zee5.ApplicasterPages.*;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Zee5ApplicasterMixPanelBusinessLogic extends Utilities {

	public Zee5ApplicasterMixPanelBusinessLogic(String Application) {
		new CommandBase(Application);
		init();
	}

	private int timeout;

	/** Retry Count */
	private int retryCount;
	ExtentReporter extent = new ExtentReporter();

	/** The Constant logger. */
//	final static Logger logger = Logger.getLogger("rootLogger");
	static LoggingUtils logger = new LoggingUtils();

	/** The Android driver. */
	public AndroidDriver<AndroidElement> androidDriver;

	/** The Android driver. */
	public IOSDriver<WebElement> iOSDriver;

	@Override
	public int getTimeout() {
		return timeout;
	}

	@Override
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	@Override
	public int getRetryCount() {
		return retryCount;
	}

	@Override
	public void setRetryCount(int retryCount) {
		this.retryCount = retryCount;
	}

	GmailInbox gmail = new GmailInbox();
	
	Mixpanel mixpanel = new Mixpanel();

	String FirstName = getParameterFromXML("FirstName");
	String LastName = getParameterFromXML("LastName");

	public void init() {

		PropertyFileReader handler = new PropertyFileReader("properties/Execution.properties");
		setTimeout(Integer.parseInt(handler.getproperty("TIMEOUT")));
		setRetryCount(Integer.parseInt(handler.getproperty("RETRY_COUNT")));
//		logger.info("Loaded the following properties" + " TimeOut :" + getTimeout() + " RetryCount :" + getRetryCount());
	}

	public void relaunchTillDisplayLanguageScreen(boolean clearData) throws Exception {
		HeaderChildNode("Relaunch the app");
		logger.info("Relaunching the application");
		extent.extentLogger("Relaunch", "Relaunching the application");
		waitTime(10000);
		getDriver().quit();
		relaunch = clearData;
		new Zee5ApplicasterBusinessLogic("zee");
		accessDeviceLocationPopUp("Allow", userType);
	}

	public void relaunchTillIntroScreen(boolean clearData) throws Exception {
		HeaderChildNode("Relaunch the app");
		logger.info("Relaunching the application");
		extent.extentLogger("Relaunch", "Relaunching the application");
		waitTime(10000);
		getDriver().quit();
		relaunch = clearData;
		new Zee5ApplicasterBusinessLogic("zee");
		accessDeviceLocationPopUp("Allow", userType);
		navigateToIntroScreen_DisplaylangScreen();
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
		accessDeviceLocationPopUp("Allow", userType);
		navigateToIntroScreen_DisplaylangScreen();
		ZeeApplicasterLogin(userType);
	}

	/**
	 * Function to Relaunch the driver
	 */
	public void relaunch2(boolean clearData) throws Exception {
		HeaderChildNode("Relaunch the app");
		logger.info("Relaunching the application");
		extent.extentLogger("Relaunch", "Relaunching the application");
		waitTime(10000);
		getDriver().quit();
		relaunch = clearData;
		new Zee5ApplicasterBusinessLogic("zee");
		accessDeviceLocationPopUp("Allow", userType);
		navigateToIntroScreen_DisplaylangScreen();
		ZeeApplicasterMixPanelLoginForParentalControl(userType);
	}

	/**
	 * Function to quit the driver
	 */
	public void tearDown() {
		getDriver().quit();
	}

	// Retrieve the Mobile Device Name
	String getOEMName = DeviceDetails.OEM;

	/**
	 * Function to access the device location
	 */
	public void accessDeviceLocationPopUp(String permission, String userType) throws Exception {
		extent.HeaderChildNode("Access Device Location PopUp");
		extent.extentLogger("User Type", "UserType : " + userType);
		logger.info("UserType : " + userType);
		System.out.println("Access Device Location PopUp");

		Swipe("Up", 1);
		click(AMDOnboardingScreen.objContinueBtnInDebugBuild, "Continue button");
		if (checkElementExist(AMDOnboardingScreen.objAllowBtn)) {
			Wait(5000);
			verifyElementPresent(AMDOnboardingScreen.objAllowBtn, "Allow button");
			verifyElementPresent(AMDOnboardingScreen.objDenyBtn, "Deny button");

			if (permission.equalsIgnoreCase("Allow")) {
				click(AMDOnboardingScreen.objAllowBtn, "Allow button");
			} else {
				click(AMDOnboardingScreen.objDenyBtn, "Deny button");
			}
		}
	}

	/**
	 * Functon to navigate to Intro screen
	 */
	public void navigateToIntroScreen_DisplaylangScreen() throws Exception {
		extent.HeaderChildNode("Navigation to Intro Screen");
		click(AMDOnboardingScreen.objContinueBtnInCountryPopUp, "Continuebutton(Country_Screen)");
		click(AMDOnboardingScreen.objDiplay_ContinueBtn, "Continue button (Display-LanguageScreen)");
		click(AMDOnboardingScreen.objContent_ContinueBtn, "Continue button (Content-LanguageScreen)");
		verifyElementPresent(AMDOnboardingScreen.objBrowseForFreeBtn, "Browse for Free");
	}

	/**
	 * Function to Login to Zee5
	 */
	public void ZeeApplicasterLogin(String LoginMethod) throws Exception {
		extent.HeaderChildNode("Login Functionality");

		String UserType = getParameterFromXML("userType");
		if (UserType.equals("Guest")) {
			extent.extentLogger("userType", "UserType : Guest");
		}

		verifyElementPresentAndClick(AMDLoginScreen.objLoginLnk, "Login link");
		waitTime(3000);

		switch (LoginMethod) {
		case "Guest":
			extent.HeaderChildNode("Guest User");
			extent.extentLogger("Accessing the application as Guest user", "Accessing the application as Guest user");
			waitTime(1000);
			hideKeyboard();
			verifyElementPresentAndClick(AMDLoginScreen.objLoginLnk, "Skip link");
			waitTime(3000);
			break;

		case "NonSubscribedUser":
			extent.HeaderChildNode("Login as NonSubscribed User");

			String Username = getParameterFromXML("NonsubscribedUserName");
			String Password = getParameterFromXML("NonsubscribedPassword");

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

			verifyElementPresentAndClick(AMDLoginScreen.objEmailIdField, "Email field");
			type(AMDLoginScreen.objEmailIdField, SubscribedUsername, "Email Field");
			verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed Button");
			verifyElementPresentAndClick(AMDLoginScreen.objPasswordField, "Password Field");
			type(AMDLoginScreen.objPasswordField, SubscribedPassword, "Password field");
			hideKeyboard();
			verifyElementPresentAndClick(AMDLoginScreen.objLoginBtn, "Login Button");
			waitTime(3000);
			break;

		case "ClubUser":
			extent.HeaderChildNode("Login as Club User");

			String ClubUsername = getParameterFromXML("ClubSubscribedUserName");
			String ClubPassword = getParameterFromXML("ClubSubscribedPassword");

			verifyElementPresentAndClick(AMDLoginScreen.objEmailIdField, "Email field");
			type(AMDLoginScreen.objEmailIdField, ClubUsername, "Email Field");
			verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed Button");
			verifyElementPresentAndClick(AMDLoginScreen.objPasswordField, "Password Field");
			type(AMDLoginScreen.objPasswordField, ClubPassword, "Password field");
			hideKeyboard();
			verifyElementPresentAndClick(AMDLoginScreen.objLoginBtn, "Login Button");
			waitTime(3000);
			break;
		}
	}

	/**
	 * Function to verify Skip Login
	 */
	public void verifySkipLoginEvent(String usertype) throws Exception {
		extent.HeaderChildNode("Verify Skip login event");
		if (usertype.equalsIgnoreCase("Guest")) {
			verifyElementPresentAndClick(AMDHomePage.objMoreMenu, "More menu");
			verifyElementPresentAndClick(AMDMoreMenu.objProfile, "My account");
			verifyElementPresentAndClick(AMDLoginScreen.objSkipBtn, "Skip link");
			mixpanel.FEProp.setProperty("Element","Skip");
			mixpanel.FEProp.setProperty("Source","Intro");
			mixpanel.ValidateParameter("", "Skip Login");
		}
	}

	/**
	 * Function to verify Skip login by skipping LoginPopUp while content playback
	 * 
	 * @throws Exception
	 */
	public void verifySkipLogin_LoginInRegistrationPopUp(String usertype, String keyword1) throws Exception {
		if (userType.equalsIgnoreCase("Guest")) {
			extent.HeaderChildNode("Verify Skip login event in Login or Register popUp during content playback");
			click(AMDSearchScreen.objSearchIcon, "Search icon");
			click(AMDSearchScreen.objSearchEditBox, "Search Box");
			type(AMDSearchScreen.objSearchBoxBar, keyword1 + "\n", "Search bar");
			hideKeyboard();
			waitForElementDisplayed(AMDSearchScreen.objAllTab, 10);
			click(AMDSearchScreen.objFirstContentInSearchResult, "Search result");
			waitForAdToFinishInAmd();
			waitTime(5000);
			if (verifyIsElementDisplayed(AMDPlayerScreen.objRegisterPopUp, "Register popUp")) {
				verifyElementPresentAndClick(AMDPlayerScreen.objLoginButtonInRegisterPopUp, "Login link");
			}
			verifyElementPresentAndClick(AMDLoginScreen.objSkipBtn, "Skip link");
		}
	}

	/**
	 * Function to handle Ad
	 */
	public void waitForAdToFinishInAmd() {
		waitTime(20000);
		if (verifyIsElementDisplayed(AMDPlayerScreen.objAd)) {
			logger.info("Ad is playing");
			extentLogger("Ad", "Ad is playing");

			verifyElementNotPresent(AMDPlayerScreen.objAd, 200);

			logger.info("Ad is completed");
			extentLogger("Ad", "Ad is completed");
		} else {
			logger.info("Ad is not played");
			extentLogger("Ad", "Ad is not played");
		}
	}

	/**
	 * Function to close the Register popUp
	 */
	public void registerPopUpClose() throws Exception {
		waitTime(5000);
		if (verifyIsElementDisplayed(AMDPlayerScreen.objRegisterPopUp)) {
			logger.info("Register Pop Up is displayed");
			extent.extentLogger("Register Pop Up", "Register Pop Up is displayed");
			Back(1);
		}
	}

	public void verifySkipLogin_LoginInGetPremiumPopUp(String userType, String keyword2) throws Exception {
		if (userType.equalsIgnoreCase("Guest")) {
			extent.HeaderChildNode(
					"Verify Skip login event on clicking login in Get premium popup during content playback");
			click(AMDSearchScreen.objSearchIcon, "Search icon");
			click(AMDSearchScreen.objSearchEditBox, "Search Box");
			type(AMDSearchScreen.objSearchBoxBar, keyword2 + "\n", "Search bar");
			hideKeyboard();
			waitForElementDisplayed(AMDSearchScreen.objAllTab, 10);
			click(AMDSearchScreen.objFirstContentInSearchResult, "Search result");
			verifyElementPresentAndClick(AMDPlayerScreen.objSubscribeNowLinkOnPlayer, "Subscribe Now Link");
			waitTime(2000);
			Swipe("Up", 1);
			verifyElementPresentAndClick(AMDPlayerScreen.objLoginCTA, "Login CTA");
			verifyElementPresentAndClick(AMDLoginScreen.objSkipBtn, "Skip link");
		}
	}

	public void verifyLogoutEvent(String userType) throws Exception {
		if (!(userType.equalsIgnoreCase("Guest"))) {
			extent.HeaderChildNode("Verify Logout Event");
			logout();
		}
	}

	public void logout() throws Exception {
		verifyElementPresentAndClick(AMDHomePage.objMoreMenu, "More menu");
		Swipe("Up", 1);
		verifyElementPresentAndClick(AMDMoreMenu.objLogout, "Logout");
		verifyElementPresentAndClick(AMDMoreMenu.objLogoutPopup, "Logout popUp");
		verifyElementPresentAndClick(AMDMoreMenu.objLogoutButton, "Logout button");
		Swipe("Down", 1);
		verifyElementPresent(AMDMoreMenu.objGuestUserAccount, "Guest user Header");
		verifyElementPresentAndClick(AMDHomePage.objHome, "Home tab");
	}

	public void verifyLoginScreenDisplayEventThroughMoreMenu(String userType) throws Exception {
		if (userType.equalsIgnoreCase("Guest")) {
			extent.HeaderChildNode("Verify Login Screen Display Event through MoreMenu");
			verifyElementPresentAndClick(AMDHomePage.objMoreMenu, "More menu");
			verifyElementPresentAndClick(AMDMoreMenu.objProfile, "My account");
			verifyElementPresentAndClick(AMDLoginScreen.objEmailIdField, "Email field");
			String Username = getParameterFromXML("NonsubscribedUserName");
			type(AMDLoginScreen.objEmailIdField, Username, "Email Field");
			verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed Button");
			waitTime(3000);
			verifyIsElementDisplayed(AMDLoginScreen.objLoginScreenTitle, "Login screen title");
		}
	}

	public void verifyLoginScreenDisplayEventThroughBrowseForScreen(String userType) throws Exception {
		if (userType.equalsIgnoreCase("Guest")) {
			extent.HeaderChildNode(
					"Verify Login Screen Display Event By Clicking On Browse for free button in welcome screen");

			verifyElementPresent(AMDOnboardingScreen.objBrowseForFreeBtn, "Browse for Free");
			verifyElementPresentAndClick(AMDLoginScreen.objEmailIdField, "Email field");
			String Username = getParameterFromXML("NonsubscribedUserName");
			type(AMDLoginScreen.objEmailIdField, Username, "Email Field");
			verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed Button");
			waitTime(3000);
			verifyIsElementDisplayed(AMDLoginScreen.objLoginScreenTitle, "Login screen title");
		}
	}

	public void verifyLoginScreenDisplayEventThroughLoginLink(String userType) throws Exception {
		if (userType.equalsIgnoreCase("Guest")) {
			extent.HeaderChildNode("Verify Login Screen Display Event By Clicking On Login link in welcome screen");

			verifyElementPresent(AMDOnboardingScreen.objLoginLnk, "Login link");
			verifyElementPresentAndClick(AMDLoginScreen.objEmailIdField, "Email field");
			String Username = getParameterFromXML("NonsubscribedUserName");
			type(AMDLoginScreen.objEmailIdField, Username, "Email Field");
			verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed Button");
			waitTime(3000);
			verifyIsElementDisplayed(AMDLoginScreen.objLoginScreenTitle, "Login screen title");
		}
	}

	public void verifyLoginScreenDisplayEventByClickingOnLoginButtonInMandatoryRegistartionPopUp(String userType,
			String keyword1) throws Exception {
		if (userType.equalsIgnoreCase("Guest")) {
			extent.HeaderChildNode(
					"Verify Login Screen Display Event By Clicking On Login Button In Mandatory Registartion PopUp");
			click(AMDSearchScreen.objSearchIcon, "Search icon");
			click(AMDSearchScreen.objSearchEditBox, "Search Box");
			type(AMDSearchScreen.objSearchBoxBar, keyword1 + "\n", "Search bar");
			hideKeyboard();
			waitForElementDisplayed(AMDSearchScreen.objAllTab, 10);
			click(AMDSearchScreen.objFirstContentInSearchResult, "Search result");
			waitForAdToFinishInAmd();
			waitTime(5000);
			if (verifyIsElementDisplayed(AMDPlayerScreen.objRegisterPopUp, "Register popUp")) {
				verifyElementPresentAndClick(AMDPlayerScreen.objLoginButtonInRegisterPopUp, "Login link");
				verifyElementPresentAndClick(AMDLoginScreen.objEmailIdField, "Email field");
				String Username = getParameterFromXML("NonsubscribedUserName");
				type(AMDLoginScreen.objEmailIdField, Username, "Email Field");
				verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed Button");
				waitTime(3000);
				verifyIsElementDisplayed(AMDLoginScreen.objLoginScreenTitle, "Login screen title");
			}
		}
	}

	public void verifyLoginScreenDisplayEventByClickingOnLoginButtonInGetPremiumPopUp(String userType, String keyword2)
			throws Exception {
		if (userType.equalsIgnoreCase("Guest")) {
			extent.HeaderChildNode(
					"Verify Login Screen Display Event By Clicking On Login Button In Get Premium Pop Up");
			click(AMDSearchScreen.objSearchIcon, "Search icon");
			click(AMDSearchScreen.objSearchEditBox, "Search Box");
			type(AMDSearchScreen.objSearchBoxBar, keyword2 + "\n", "Search bar");
			hideKeyboard();
			waitForElementDisplayed(AMDSearchScreen.objAllTab, 10);
			click(AMDSearchScreen.objFirstContentInSearchResult, "Search result");
			verifyElementPresentAndClick(AMDPlayerScreen.objSubscribeNowLinkOnPlayer, "Subscribe Now Link");
			waitTime(2000);
			Swipe("Up", 1);
			verifyElementPresentAndClick(AMDPlayerScreen.objLoginCTA, "Login CTA");
			verifyElementPresentAndClick(AMDLoginScreen.objEmailIdField, "Email field");
			String Username = getParameterFromXML("NonsubscribedUserName");
			type(AMDLoginScreen.objEmailIdField, Username, "Email Field");
			verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed Button");
			waitTime(3000);
			verifyIsElementDisplayed(AMDLoginScreen.objLoginScreenTitle, "Login screen title");
		}
	}

	public void verifyLoginInitiatedEventForValidCredentials(String userType, String loginMethod) throws Exception {
		if (userType.equalsIgnoreCase("Guest")) {
			extent.HeaderChildNode("Verify Login Initiated Event for Valid Credentials");
			socialLogin(loginMethod);
		}

	}

	public void socialLogin(String LoginMethod) throws Exception {
		switch (LoginMethod) {

		case "twitterLogin":
			twitterLogin();
			waitTime(3000);
			break;

		case "fbLogin":
			facebookLogin();
			waitTime(3000);
			break;

		}
	}

	public void twitterLogin() throws Exception {
		extent.HeaderChildNode("Verify Login Initiated Event for Valid Credentials through Twitter");

		verifyElementPresentAndClick(AMDHomePage.objMoreMenu, "More menu");
		verifyElementPresentAndClick(AMDMoreMenu.objProfile, "My account");
		waitTime(3000);
		waitForElementDisplayed(AMDLoginScreen.objtwitterBtn, 10);
		verifyElementPresentAndClick(AMDLoginScreen.objtwitterBtn, "Twitter icon");
		waitTime(10000);
		if (verifyIsElementDisplayed(AMDHomePage.objHome, "Home tab")) {
			logger.info("User Logged in Successfully");
			extent.extentLogger("Logged in", "User Logged in Successfully");
			logout();
		} else if (verifyIsElementDisplayed(AMDLoginScreen.objTwitterEmail, "Email Field")) {
			verifyElementPresent(AMDLoginScreen.objTwitterEmail, " Email Field");
			type(AMDLoginScreen.objTwitterEmail, "zee5latest@gmail.com", "Email Field");

			verifyElementPresent(AMDLoginScreen.objTwitterPassword, " Password Field");
			type(AMDLoginScreen.objTwitterPassword, "User@123", "Password Field");

//			verifyElementPresentAndClick(AMDLoginScreen.objLoginButtonInTwitterPage, "Login Button");
			waitTime(2000);
			Swipe("Up", 1);
			verifyElementPresentAndClick(AMDLoginScreen.objtwAuthorizeAppBtn, "Authorize App");

			waitForElementDisplayed(AMDHomePage.objHome, 20);
			if (checkElementDisplayed(AMDHomePage.objHome, "Home tab")) {
				logger.info("User Logged in Successfully");
				extent.extentLogger("Logged in", "User Logged in Successfully");
				logout();
			} else {
				logger.info("User is not logged in Successfully");
				extent.extentLoggerFail("Logged in", "User is not logged in Successfully");
				Back(1);
			}
		} else {
			click(AMDLoginScreen.objAuthorizeAppInTwitterpage, "Authorize App");
		}
	}

	public void facebookLogin() throws Exception {
		extent.HeaderChildNode("Verify Login Initiated Event for Valid Credentials through Facebook");
		verifyElementPresentAndClick(AMDHomePage.objMoreMenu, "More menu");
		verifyElementPresentAndClick(AMDMoreMenu.objProfile, "My account");
		waitTime(3000);
		waitForElementDisplayed(AMDLoginScreen.objfbBtn, 10);
		verifyElementPresentAndClick(AMDLoginScreen.objfbBtn, "Facebook icon");
		waitTime(10000);

		if (verifyIsElementDisplayed(AMDHomePage.objHome, "Home tab")) {
			logger.info("User Logged in Successfully");
			extent.extentLogger("Logged in", "User Logged in Successfully");
		} else {
			verifyElementPresent(AMDLoginScreen.objFBEmail, " Email Field");
			type(AMDLoginScreen.objFBEmail, "igstesttt@gmail.com", "Email Field");

			verifyElementPresent(AMDLoginScreen.objPasswordFieldInFBPage, " Password Field");
			type(AMDLoginScreen.objPasswordFieldInFBPage, "Igs123!@#", "Password Field");

			verifyElementPresentAndClick(AMDLoginScreen.objFBLoginBtn, "Login button");

			waitForElementDisplayed(AMDHomePage.objHome, 40);
			if (verifyIsElementDisplayed(AMDHomePage.objHome, "Home tab")) {
				logger.info("User Logged in Successfully");
				extent.extentLogger("Logged in", "User Logged in Successfully");
			}
		}
		logout();
	}

	public void verifyLoginResultEventForValidCredentials(String userType, String loginMethod) throws Exception {
		if (userType.equalsIgnoreCase("Guest")) {
			extent.HeaderChildNode("Verify Login Result Event for Valid Credentials");
			socialLogin(loginMethod);
		}
	}

	public void verifyTVAuthenticationScreenDisplayEvent(String userType) throws Exception {
		if (!(userType.equalsIgnoreCase("Guest"))) {
			extent.HeaderChildNode("Verify TV Authentication Screen Display Event");
			verifyElementPresentAndClick(AMDHomePage.objMoreMenu, "More menu");
			verifyElementPresentAndClick(AMDMoreMenu.objSettings, "Settings");
			Swipe("Up", 1);
			verifyElementPresentAndClick(AMDSettingsScreen.objAuthenticateDevice, "Authenticate Device");
			waitTime(3000);
		}
	}

	public void verifySubscriptionPageViewedEventViaBuySubscription(String userType) throws Exception {
		extent.HeaderChildNode("Verify Subscription Page Viewed Event by clicking on Buy subscription in more menu");
		if (!(userType.equalsIgnoreCase("SubscribedUser"))) {
			verifyElementPresentAndClick(AMDHomePage.objMoreMenu, "More menu");
			verifyElementPresentAndClick(AMDMoreMenu.objBuySubscription, "Buy Subscription option");

		}
	}

	public void verifySubscriptionPageViewedEventViaSubscribeBtn(String userType) throws Exception {
		extent.HeaderChildNode("Verify Subscription Page Viewed Event");
		if (!(userType.equalsIgnoreCase("SubscribedUser"))) {
			verifyElementPresentAndClick(AMDHomePage.objSubscribeIcon, "Subscribe button");
		}
	}

	public void verifySubscriptionSelectedEvent(String userType) throws Exception {
		extent.HeaderChildNode("Verify Subscription Selected Event");
		if (!(userType.equalsIgnoreCase("SubscribedUser"))) {
			verifyElementPresentAndClick(AMDHomePage.objSubscribeIcon, "Subscribe button");
			waitTime(3000);
			Swipe("Up", 2);
			SwipeUntilFindElement(AMDSubscibeScreen.objContinueBtn, "Up");
			verifyElementPresentAndClick(AMDSubscibeScreen.objContinueBtn, "Continue Button");
			waitTime(2000);
		}
	}

	public void verifySubscriptionSelectedEventByClubPack(String userType) throws Exception {
		extent.HeaderChildNode("Verify Subscription Selected Event By selecting Club Pack");
		if (!(userType.equalsIgnoreCase("SubscribedUser"))) {
			verifyElementPresentAndClick(AMDHomePage.objSubscribeIcon, "Subscribe button");
			click(AMDSubscibeScreen.objClubTab, "Club Pack");
			waitTime(2000);
			Swipe("Up", 2);
			click(AMDSubscibeScreen.objClub365daysPack, "Pack");
			verifyElementPresentAndClick(AMDSubscibeScreen.objContinueBtn, "Continue Button");
			waitTime(2000);
		}
	}

	public void verifyPromoCodeResultEventForValid(String userType) throws Exception {
		extent.HeaderChildNode("Verify Promo Code Result Event For Valid code");
		if (!(userType.equalsIgnoreCase("SubscribedUser"))) {
			verifyElementPresentAndClick(AMDHomePage.objSubscribeIcon, "Subscribe button");
			type(AMDSubscibeScreen.objApplyPromoCodeTextbox, "PNB20", "Prepaid Code");
			hideKeyboard();
			verifyElementPresentAndClick(AMDSubscibeScreen.objApply, "Apply Button");
			waitTime(2000);
		}
	}

	public void verifyPromoCodeResultEventForInvalid(String userType) throws Exception {
		extent.HeaderChildNode("Verify Promo Code Result Event For Invalid code");
		if (!(userType.equalsIgnoreCase("SubscribedUser"))) {
			verifyElementPresentAndClick(AMDHomePage.objSubscribeIcon, "Subscribe button");
			type(AMDSubscibeScreen.objApplyPromoCodeTextbox, "sdcrfd", "Prepaid Code");
			hideKeyboard();
			verifyElementPresentAndClick(AMDSubscibeScreen.objApply, "Apply Button");
			waitTime(2000);

		}
	}

	public void verifyCarouselBannerClickEvent() throws Exception {
		extent.HeaderChildNode(
				"Verify Carousel Banner Click Event And Video View Event For content played from Carousel");
		waitTime(5000);
		verifyElementPresentAndClick(AMDHomePage.objCarouselConetentCard, "Caorsel Content");

	}

	public void SelectTopNavigationTab(String pTabname) throws Exception {
		System.out.println("\nSelecting " + pTabname + " from Top navigation tabs");

		verifyElementPresentAndClick(AMDHomePage.objHome, "Home button");
		int noOfTabs = getCount(AMDHomePage.objTitle);
		System.out.println("\nTop Navigation Tabs: " + noOfTabs);
		for (int k = 1; k <= noOfTabs; k++) {
			if (verifyIsElementDisplayed(AMDGenericObjects.objPageTitle(pTabname))) {
				click(AMDGenericObjects.objPageTitle(pTabname), pTabname);
				break;
			} else {
				List<WebElement> element = getDriver().findElements(By.xpath("//*[@id='title']"));
				element.get(noOfTabs - 1).click();
				waitTime(1000);
			}
		}
	}

	public void verifyThumbnailClickEventFromTray() throws Exception {
		extent.HeaderChildNode("Verify Thumbnail Click Event For content played from trays");
		waitTime(5000);
		for (int i = 0; i < 5; i++) {
			boolean var = verifyIsElementDisplayed(AMDHomePage.objFirstThumbnailOfTray, "Thumbnail from a tray");
			if (var == false) {
				Swipe("Up", 1);
			} else {
				break;
			}
		}
		verifyElementPresentAndClick(AMDHomePage.objFirstThumbnailOfTray, "Thumbnail from a tray");
	}

	public void verifyThumbnailClickEventFromTrayInPlayBackPage(String keyword2) throws Exception {
		extent.HeaderChildNode("Verify Thumbnail Click Event For content played from trays in playback page");
		waitTime(5000);
		click(AMDSearchScreen.objSearchIcon, "Search icon");
		click(AMDSearchScreen.objSearchEditBox, "Search Box");
		type(AMDSearchScreen.objSearchBoxBar, keyword2 + "\n", "Search bar");
		hideKeyboard();
		waitForElementDisplayed(AMDSearchScreen.objAllTab, 10);
		click(AMDSearchScreen.objFirstContentInSearchResult, "Search result");
		for (int i = 0; i < 5; i++) {
			boolean var = verifyIsElementDisplayed(AMDConsumptionScreen.objContentCardOfTrayInConsumptionPage,
					"Thumbnail in playback page");
			if (var == false) {
				Swipe("Up", 1);
			} else {
				break;
			}
		}
		verifyElementPresentAndClick(AMDConsumptionScreen.objContentCardOfTrayInConsumptionPage,
				"Thumbnail in playback page");
	}

	@SuppressWarnings("deprecation")
	public void verifyParentalRestrictionEvent(String userType, String restriction) throws Exception {
		if (!(userType.equalsIgnoreCase("Guest"))) {

			extent.HeaderChildNode("Verify Parental Restriction Event");
			click(AMDHomePage.MoreMenuIcon, "More Menu tab");
			click(AMDMoreMenu.objSettings, "Settings option");
			waitTime(5000);
			Swipe("UP", 1);
			verifyElementPresentAndClick(AMDMoreMenu.objParentalControl, "Parental Control");
			verifyElementExist(AMDMoreMenu.objPasswordField, "Password field");
			String password = "";
			if (userType.equals("NonSubscribedUser")) {
				password = getParameterFromXML("SettingsNonsubscribedPassword");
			} else if (userType.equals("SubscribedUser")) {
				password = getParameterFromXML("SettingsSubscribedPassword");
			}
			click(AMDMoreMenu.objPasswordField, "Password field");
			getDriver().getKeyboard().sendKeys(password);

			hideKeyboard();
			if (getOEMName.contains("vivo")) {
				hidePwdKeyboard();
			}
			click(AMDMoreMenu.objPasswordContinueBtn, "Continue button");
			waitTime(2000);

			if (restriction.equalsIgnoreCase("Age13+")) {
				click(AMDMoreMenu.objRestrict13Above, "Restrict 13+ Content option");
				click(AMDMoreMenu.objContinueBtn, "Continue Button");
				waitTime(2000);

				verifyElementExist(AMDMoreMenu.objSetPin, "Set Pin");
				type(AMDMoreMenu.objParentalLockPin1, "1", "ParentalLockPin");
				hideKeyboard();
				type(AMDMoreMenu.objParentalLockPin2, "2", "ParentalLockPin");
				hideKeyboard();
				type(AMDMoreMenu.objParentalLockPin3, "3", "ParentalLockPin");
				hideKeyboard();
				type(AMDMoreMenu.objParentalLockPin4, "4", "ParentalLockPin");
				hideKeyboard();
				waitTime(4000);
				click(AMDMoreMenu.objSetPinContinueBtn, "Continue Button");
				waitTime(2000);
				click(AMDMoreMenu.objParentalLockDone, "Done Button");
			} else if (restriction.equalsIgnoreCase("Restrict All")) {
				click(AMDMoreMenu.objRestrictAllContent, "Restrict All Content option");
				click(AMDMoreMenu.objContinueBtn, "Continue Button");
				waitTime(2000);
				verifyElementExist(AMDMoreMenu.objSetPin, "Set Pin");
				type(AMDMoreMenu.objParentalLockPin1, "1", "ParentalLockPin");
				hideKeyboard();
				type(AMDMoreMenu.objParentalLockPin2, "2", "ParentalLockPin");
				hideKeyboard();
				type(AMDMoreMenu.objParentalLockPin3, "3", "ParentalLockPin");
				hideKeyboard();
				type(AMDMoreMenu.objParentalLockPin4, "4", "ParentalLockPin");
				hideKeyboard();
				waitTime(4000);
				click(AMDMoreMenu.objSetPinContinueBtn, "Continue Button");
				waitTime(2000);
				click(AMDMoreMenu.objParentalLockDone, "Done Button");
			}

			waitTime(3000);
			Swipe("Up", 2);
			verifyElementPresentAndClick(AMDMoreMenu.objParentalControl, "Parental Control");
			verifyElementExist(AMDMoreMenu.objPasswordField, "Password field");
			if (userType.equals("NonSubscribedUser")) {
				password = getParameterFromXML("SettingsNonsubscribedPassword");
			} else if (userType.equals("SubscribedUser")) {
				password = getParameterFromXML("SettingsSubscribedPassword");
			}
			click(AMDMoreMenu.objPasswordField, "Password field");
			getDriver().getKeyboard().sendKeys(password);

			hideKeyboard();
			if (getOEMName.contains("vivo")) {
				hidePwdKeyboard();
			}
			click(AMDMoreMenu.objPasswordContinueBtn, "Continue button");
			waitTime(2000);
			click(AMDMoreMenu.objNoRestriction, "No Restriction option");
			click(AMDMoreMenu.objContinueBtn, "Continue Button");
			waitTime(2000);
			click(AMDMoreMenu.objParentalLockDone, "Done Button");
			waitTime(3000);
		}
	}

	public void verifySubscriptionPageViewedEventByClickingGetPremiumCTAOnCarousel(String tabName) throws Exception {
		if (!(userType.equalsIgnoreCase("SubscribedUser"))) {
			extent.HeaderChildNode(
					"Verify Subscription Page Viewed event gets triggered, When user is navigating to Subscirption page by clicking on Get Premium CTA on carousel");
			waitTime(5000);
			verifyElementPresentAndClick(AMDHomePage.objGetPremiumCTAOnCarousel, "Caorsel Content");
			waitTime(4000);
		}
	}

	public void verifySubscriptionPageViewedEventByClickingSubscriptionbelowThePlayer(String usertype, String keyword2)
			throws Exception {
		if (!(userType.equalsIgnoreCase("SubscribedUser"))) {
			extent.HeaderChildNode(
					"Verify Subscription page viewed event by clicking Subscription CTA below the player in consumption page");
			click(AMDSearchScreen.objSearchIcon, "Search icon");
			click(AMDSearchScreen.objSearchEditBox, "Search Box");
			type(AMDSearchScreen.objSearchBoxBar, keyword2 + "\n", "Search bar");
			hideKeyboard();
			waitForElementDisplayed(AMDSearchScreen.objAllTab, 10);
			click(AMDSearchScreen.objFirstContentInSearchResult, "Search result");
			verifyElementPresentAndClick(AMDPlayerScreen.objSubscribeButtonBelowThePlayer,
					"Get premium CTA below the Player in consumption page");

		}
	}

	public void verifyScreenViewEvent(String screen) throws Exception {
		extent.HeaderChildNode("Verify Screen View Event");
		SelectTopNavigationTab(screen);
		waitTime(3000);
	}

	public void verifyViewMoreSelectedEventFromTray() throws Exception {
		extent.HeaderChildNode("Verify View More Selected Event For content played from Tray");
		waitTime(5000);
		for (int i = 0; i < 5; i++) {
			boolean var = verifyIsElementDisplayed(AMDHomePage.objFirstViewAllbtn, "View All option a tray");
			if (var == false) {
				Swipe("Up", 1);
			} else {
				break;
			}
		}
		verifyElementPresentAndClick(AMDHomePage.objFirstViewAllbtn, "View All option a tray");
	}

	public void verifyViewMoreSelectedEventFromPlaybackPage(String keyword2) throws Exception {
		extent.HeaderChildNode("Verify View More Selected Event For content played from Playback page");
		waitTime(5000);
		click(AMDSearchScreen.objSearchIcon, "Search icon");
		click(AMDSearchScreen.objSearchEditBox, "Search Box");
		type(AMDSearchScreen.objSearchBoxBar, keyword2 + "\n", "Search bar");
		hideKeyboard();
		waitForElementDisplayed(AMDSearchScreen.objAllTab, 10);
		click(AMDSearchScreen.objFirstContentInSearchResult, "Search result");
		for (int i = 0; i < 5; i++) {
			boolean var = verifyIsElementDisplayed(AMDHomePage.objFirstViewAllbtn, "View All option a tray");
			if (var == false) {
				Swipe("Up", 1);
			} else {
				break;
			}
		}
		verifyElementPresentAndClick(AMDHomePage.objFirstViewAllbtn, "View All option a tray");

	}

	public void clearSearchHistoryEvent(String usertype) throws Exception {
		if(!(usertype.equalsIgnoreCase("Guest"))) {
			extent.HeaderChildNode("Verify Clear Search History Event");
			click(AMDHomePage.MoreMenuIcon, "More menu icon");
			verifyElementPresentAndClick(AMDMoreMenu.objSettings, "Settings option");
			waitTime(300);
			Swipe("Up", 2);
			verifyElementPresentAndClick(AMDSettingsScreen.objClearSearchHistory, "Clear Search Histroy");
			waitTime(4000);
		}
	}

	public void verifySearchButtonClickEvent() throws Exception {
		extent.HeaderChildNode("Verify Search Button Click Event");
		waitTime(5000);
		click(AMDSearchScreen.objSearchIcon, "Search icon");
		waitTime(3000);
	}

	public void verifySearchExecutedEvent(String keyword2) throws Exception {
		extent.HeaderChildNode("Verify Search Executed Event");
		waitTime(5000);
		click(AMDSearchScreen.objSearchIcon, "Search icon");
		click(AMDSearchScreen.objSearchEditBox, "Search Box");
		type(AMDSearchScreen.objSearchBoxBar, keyword2 + "\n", "Search bar");
		waitTime(4000);
	}

	public void verifySearchResultClickedEvent(String keyword2) throws Exception {
		extent.HeaderChildNode("Verify Search Result click Event");
		waitTime(5000);
		click(AMDSearchScreen.objSearchIcon, "Search icon");
		click(AMDSearchScreen.objSearchEditBox, "Search Box");
		type(AMDSearchScreen.objSearchBoxBar, keyword2 + "\n", "Search bar");
		hideKeyboard();
		waitForElementDisplayed(AMDSearchScreen.objAllTab, 10);
		click(AMDSearchScreen.objFirstContentInSearchResult, "Search result");
		waitTime(3000);
	}

	public void verifyVideoQualityChangeEvent() throws Exception {
		extent.HeaderChildNode("Verify video quality change Event");
		click(AMDHomePage.MoreMenuIcon, "More menu icon");
		verifyElementPresentAndClick(AMDMoreMenu.objSettings, "Settings option");
		boolean var = verifyIsElementDisplayed(AMDMoreMenu.objSelectedVideoQualityOption("Auto"));
		if (var == true) {
			click(AMDMoreMenu.objVideo_Quality("Auto"), "Video quality option");
			click(AMDSettingsScreen.objVideoQualityBetter, "option Better");
			click(AMDMoreMenu.objVideo_Quality("Better"), "Video quality option");
			click(AMDMoreMenu.objAutoOption, "option Auto");
		} else {
			logger.error("the default selection in the Select Video Quality is not 'Auto' option");
			extentLoggerWarning("Default selected Video quality option",
					"the default selection in the Select Video Quality is not 'Auto' option");
		}

	}

	public void verifyVideoAutoPlayChangeEvent() throws Exception {
		extent.HeaderChildNode("Verify video AutoPlay change Event");
		click(AMDHomePage.MoreMenuIcon, "More menu icon");
		verifyElementPresentAndClick(AMDMoreMenu.objSettings, "Settings option");
		String elementAutoPlayToggleStatus = getText(AMDMoreMenu.objVideo_Autoply);
		if (elementAutoPlayToggleStatus.equalsIgnoreCase("ON")) {
			click(AMDMoreMenu.objVideo_Autoply, "Video Auto play toggle");
		} else {
			logger.info("the default state of the 'Auto Play' option is not in ON state");
			extentLoggerWarning("Video Auto Play", "the default state of the 'Auto Play' option is not in ON state");
		}
	}

	public void verifyDisplayLanguageChangeEvent(String displayLanguage) throws Exception {
		extent.HeaderChildNode("Verify display language change Event");
		click(AMDHomePage.MoreMenuIcon, "More menu icon");
		verifyElementPresentAndClick(AMDMoreMenu.objSettings, "Settings option");
		waitTime(1000);
		SwipeUntilFindElement(AMDMoreMenu.objDisplayLang, "Up");
		click(AMDMoreMenu.objDisplayLang, "Display language");
		click(AMDOnboardingScreen.objSelectDisplayLang(displayLanguage), "language");
		Back(1);
	}

	public void verifyContentLanguageChangeEvent() throws Exception {
		extent.HeaderChildNode("Verify Content language change Event");
		click(AMDHomePage.MoreMenuIcon, "More menu icon");
		verifyElementPresentAndClick(AMDMoreMenu.objSettings, "Settings option");
		waitTime(1000);
		SwipeUntilFindElement(AMDMoreMenu.objContentLang, "Up");
		click(AMDMoreMenu.objContentLang, "Content language");
		click(AMDOnboardingScreen.objSelectContentLang("English"), "English language");
		click(AMDOnboardingScreen.objContent_ContinueBtn, "Continue button in Content language screen");
	}

	public boolean SwipeUntilFindElement(By locator, String direction) throws Exception {

		boolean checkLocator, eletFound = false;
		if (direction.equalsIgnoreCase("UP")) {
			for (int i = 1; i < 25; i++) {
				PartialSwipe("UP", 1);
				checkLocator = verifyIsElementDisplayed(locator);
				if (checkLocator) {
					eletFound = true;
					break;
				}
			}
		}

		if (direction.equalsIgnoreCase("DOWN")) {
			for (int i = 1; i < 25; i++) {
				PartialSwipe("DOWN", 1);
				checkLocator = verifyIsElementDisplayed(locator);
				if (checkLocator) {
					eletFound = true;
					break;
				}
			}
		}
		return eletFound;
	}

	public void verifyDefaultSettingRestoredEvent() throws Exception {
		extent.HeaderChildNode("Verify Default Setting Restored Event");
		click(AMDHomePage.MoreMenuIcon, "More menu icon");
		verifyElementPresentAndClick(AMDMoreMenu.objSettings, "Settings option");
		Swipe("Up", 2);
		verifyElementPresentAndClick(AMDSettingsScreen.objDefaultSetting, "Default Setting Link");
		verifyElementPresentAndClick(AMDSettingsScreen.objYesCTA, "Yes CTA");
	}

	public void ZeeApplicasterMixPanelLoginForParentalControl(String LoginMethod) throws Exception {
		extent.HeaderChildNode("Login Functionality");

		String UserType = getParameterFromXML("userType");
		if (UserType.equals("Guest")) {
			extent.extentLogger("userType", "UserType : Guest");
		}

		verifyElementPresentAndClick(AMDLoginScreen.objLoginLnk, "Login link");
		waitTime(3000);

		switch (LoginMethod) {
		case "Guest":
			extent.HeaderChildNode("Guest User");
			extent.extentLogger("Accessing the application as Guest user", "Accessing the application as Guest user");
			waitTime(1000);
			hideKeyboard();
			verifyElementPresentAndClick(AMDLoginScreen.objLoginLnk, "Skip link");
			waitTime(3000);
			break;

		case "NonSubscribedUser":
			extent.HeaderChildNode("Login as NonSubscribed User");

			String Username = getParameterFromXML("ParentalNonsubscribedUserName");
			String Password = getParameterFromXML("ParentalNonsubscribedPassword");

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

			String SubscribedUsername = getParameterFromXML("ParentalSubscribedUserName");
			String SubscribedPassword = getParameterFromXML("ParentalSubscribedPassword");

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

	public void verifyCarouselBannerSwipeEvent(String tabName) throws Exception {
		extent.HeaderChildNode("Verify Carousel Banner Swipe Event Across tabs");
		SelectTopNavigationTab(tabName);
		waitForElementDisplayed(AMDHomePage.objCarouselDots, 10);
		waitTime(10000);

		if (verifyElementDisplayed(AMDHomePage.objBannerAd)) {
			verifyElementPresent(AMDHomePage.objCarouselUnitwithmastHeadAdbanner,
					"Carousel unit as first unit on " + tabName + " screen");
		} else {
			verifyElementPresent(AMDHomePage.objCarouselUnitwhenNomastHeadAdbanner,
					"Carousel unit as first unit on " + tabName + " screen");
		}

		// Validating Carousel manual swipe
		String width = getAttributValue("width", AMDHomePage.objCarouselConetentCard);

		String bounds = getAttributValue("bounds", AMDHomePage.objCarouselConetentCard);
		String b = bounds.replaceAll(",", " ").replaceAll("]", " ");
		String height = b.split(" ")[1];

		waitTime(3000);
		String Carouseltitle1 = getText(AMDHomePage.objCarouselTitle1);
		logger.info(Carouseltitle1);
		extentLoggerPass("Carousel Title", Carouseltitle1);
		carouselCardsSwipe("LEFT", 1, width, height);

		String Carouseltitle2 = getText(AMDHomePage.objCarouselTitle1);
		logger.info(Carouseltitle2);
		extentLoggerPass("Carousel Title", Carouseltitle2);
		carouselCardsSwipe("RIGHT", 1, width, height);
	}

	@SuppressWarnings("rawtypes")
	public void carouselCardsSwipe(String direction, int count, String width, String height) throws Exception {
		touchAction = new TouchAction(getDriver());

		try {

			int yCordinate;
			if (verifyElementIsNotDisplayed(AMDHomePage.objAdBannerAboveCarousel)) {
				yCordinate = (int) ((Integer.valueOf(height)) * 0.4);
			} else {
				yCordinate = (int) ((Integer.valueOf(height)) * 0.5);
			}

			if (direction.equalsIgnoreCase("LEFT")) {

				for (int i = 0; i < count; i++) {

					int startx = (Integer.valueOf(width));
					startx = (int) (startx * 0.8);
					int endx = (int) (startx * 0.1);

					int starty = (Integer.valueOf(height)) + yCordinate;
					touchAction.press(PointOption.point(startx, starty))
							.waitAction(WaitOptions.waitOptions(Duration.ofMillis(100)))
							.moveTo(PointOption.point(endx, starty)).release().perform();
					logger.info("Swiping screen in " + " " + direction + " direction" + " " + (i + 1) + " times");
					extent.extentLoggerPass("SwipeLeft",
							"Swiping screen in " + " " + direction + " direction" + " " + (i + 1) + " times");

					System.out.println("\n<<< Swipe <<<");
					System.out.println("[X,Y]: [" + startx + "," + starty + "] ===> [" + endx + "," + starty + "]");
				}
			} else if (direction.equalsIgnoreCase("RIGHT")) {

				for (int j = 0; j < count; j++) {
					int startx = (int) ((Integer.valueOf(width)) * 0.1);
					int endx = (int) ((Integer.valueOf(width)) * 0.8);
					int starty = (Integer.valueOf(height)) + yCordinate;
					touchAction.press(PointOption.point(startx, starty))
							.waitAction(WaitOptions.waitOptions(Duration.ofMillis(100)))
							.moveTo(PointOption.point(endx, starty)).release().perform();

					logger.info("Swiping screen in " + " " + direction + " direction" + " " + (j + 1) + " times");
					extent.extentLoggerPass("SwipeRight",
							"Swiping screen in " + " " + direction + " direction" + " " + (j + 1) + " times");

					System.out.println("\n>>> Swipe >>>");
					System.out.println("[X,Y]: [" + startx + "," + starty + "] ===> [" + endx + "," + starty + "]");
				}
			}
		} catch (Exception e) {
			logger.error(e);
		}
	}

	public void verifyPopUpLaunchEventForGetPremiumPopUp(String userType, String keyword2) throws Exception {
		if (!(userType.equalsIgnoreCase("SubscribedUser"))) {
			extent.HeaderChildNode(
					"Verify Pop Up Launch Event when get premium popup is displayed on playing premium content");
			click(AMDSearchScreen.objSearchIcon, "Search icon");
			click(AMDSearchScreen.objSearchEditBox, "Search Box");
			type(AMDSearchScreen.objSearchBoxBar, keyword2 + "\n", "Search bar");
			hideKeyboard();
			waitForElementDisplayed(AMDSearchScreen.objAllTab, 10);
			click(AMDSearchScreen.objFirstContentInSearchResult, "Search result");
			verifyElementPresentAndClick(AMDPlayerScreen.objSubscribeNowLinkOnPlayer, "Subscribe Now Link");

		}
	}

	public void verifyPopUpLaunchEventForCompleteProfilePopUp(String usertype, String searchKeyword) throws Exception {
		if (userType.equalsIgnoreCase("NonSubscribedUser")) {
			extent.HeaderChildNode("Verify Pop Up Launch Event when Complete Profile popup is displayed");
			click(AMDSearchScreen.objSearchIcon, "Search icon");
			click(AMDSearchScreen.objSearchEditBox, "Search Box");
			type(AMDSearchScreen.objSearchBoxBar, searchKeyword + "\n", "Search bar");
			hideKeyboard();
			// closeInterstitialAd(AMDGenericObjects.objCloseInterstitialAd, 2000);
			waitForElementDisplayed(AMDSearchScreen.objAllTab, 10);
			click(AMDSearchScreen.objFirstContentInSearchResult, "Search result");

			if (!(usertype.equalsIgnoreCase("SubscribedUser"))) {
				waitForAdToFinishInAmd();
			}
			completeProfilePopUpClose(usertype);
		}
	}

	public void completeProfilePopUpClose(String userType) throws Exception {
		waitTime(5000);
		if (userType.equalsIgnoreCase("NonSubscribedUser")) {
			if (verifyIsElementDisplayed(AMDPlayerScreen.objCompleteProfilePopUp)) {
				logger.info("Complete Profile Pop Up is displayed");
				extent.extentLogger("Complete Profile Pop Up", "Complete Profile Pop Up is displayed");
				Back(1);
			}
		}
	}

	public void verifyPopUpLaunchEventForRegisterPopUp(String userType, String keyword) throws Exception {
		if (userType.equalsIgnoreCase("Guest")) {
			extent.HeaderChildNode("Verify Pop Up Launch Event when Native popup is displayed");
			click(AMDSearchScreen.objSearchIcon, "Search icon");
			click(AMDSearchScreen.objSearchEditBox, "Search Box");
			type(AMDSearchScreen.objSearchBoxBar, keyword + "\n", "Search bar");
			hideKeyboard();
			// closeInterstitialAd(AMDGenericObjects.objCloseInterstitialAd, 2000);
			waitForElementDisplayed(AMDSearchScreen.objAllTab, 10);
			click(AMDSearchScreen.objFirstContentInSearchResult, "Search result");

			if (!(userType.equalsIgnoreCase("SubscribedUser"))) {
				waitForAdToFinishInAmd();
			}
			registerPopUpClose();
		}
	}

	public void verifyPopUpCTAsEvent(String userType, String keyword2) throws Exception {
		if (!(userType.equalsIgnoreCase("SubscribedUser"))) {
			extent.HeaderChildNode("Verify Pop Up CTA's Event when user clicks on CTA button displayed on the popup");
			click(AMDSearchScreen.objSearchIcon, "Search icon");
			click(AMDSearchScreen.objSearchEditBox, "Search Box");
			type(AMDSearchScreen.objSearchBoxBar, keyword2 + "\n", "Search bar");
			hideKeyboard();
			waitForElementDisplayed(AMDSearchScreen.objAllTab, 10);
			click(AMDSearchScreen.objFirstContentInSearchResult, "Search result");
			verifyElementPresentAndClick(AMDPlayerScreen.objSubscribeNowLinkOnPlayer, "Subscribe Now Link");
			Swipe("Up", 1);
			verifyElementPresentAndClick(AMDPlayerScreen.objLoginCTA, "Login CTA");
		}
	}

	public void verifyCTAsEvent(String userType, String tabName) throws Exception {
		extent.HeaderChildNode("Verify CTAs Event");
		SelectTopNavigationTab(tabName);
		verifyElementPresentAndClick(AMDHomePage.objSubscribeIcon, "Subscribe button");
		waitTime(3000);
	}

	public void findingTrayInscreen(int j, By byLocator1, By byLocator2, String str1, String str2, String userType,
			String tabName) throws Exception {
		boolean tray = false;
		for (int i = 0; i < j; i++) {
			if (!((verifyIsElementDisplayed(byLocator1)))) {
				Swipe("UP", 1);
			} else {
				verifyElementExist(byLocator1, str1);
				tray = true;
				if (tabName.equalsIgnoreCase("Home")) {
					if (str1.equalsIgnoreCase("Continue watching tray")) {

						Response respCW = ResponseInstance.getRespofCWTray(userType);

						List<String> ApinoOfContentsInCW = respCW.jsonPath().getList("array");
						logger.info("no.of contents in CW tray in Api " + ApinoOfContentsInCW.size());

						ArrayList<String> listOfContentsInCW = new ArrayList<String>();

						for (int k = 0; k < ApinoOfContentsInCW.size(); k++) {

							String title = respCW.jsonPath().getString("[" + k + "].title");
							listOfContentsInCW.add(title);
						}

						logger.info(listOfContentsInCW);

						for (int p = 0; p < ApinoOfContentsInCW.size(); p++) {

							verifyElementExist(AMDHomePage.objContentTitleOfCWTray(listOfContentsInCW.get(p)),
									"content title");

							if (verifyElementDisplayed(AMDHomePage.objLeftTimeOfFirstContentOfCWTray)) {
								logger.info("Left watch time info on cards is available");
								extent.extentLoggerPass("Left watch time info",
										"Left watch time info on cards is available");
							} else {
								logger.error("Left watch time info on cards is not available");
								extent.extentLoggerFail("Left watch time info",
										"Left watch time info on cards is not available");
							}
							if (verifyElementDisplayed(AMDHomePage.objProgressBarOfFirstContentOfCWTray)) {
								logger.info("Progress bar is displayed to indicate the content watched portion");
								extent.extentLoggerPass("Progress bar",
										"Progress bar is displayed to indicate the content watched portion");
							} else {
								logger.error("Progress bar is not displayed to indicate the content watched portion");
								extent.extentLoggerFail("Progress bar",
										"Progress bar is not displayed to indicate the content watched portion");
							}
							if (p != (ApinoOfContentsInCW.size() - 1)) {
								SwipeRail(AMDHomePage.objContentTitleOfCWTray(listOfContentsInCW.get(p + 1)));
							}
						}
					}
				}
				break;
			}
		}
		if (tray == false) {
			if (userType.equalsIgnoreCase("Guest")) {
				if (str1.equalsIgnoreCase("Continue watching tray")) {
					logger.info(str1 + " is not displayed for Guest user");
					extent.extentLoggerPass("Tray", str1 + " is not displayed for Guest user");
				} else {
					logger.error(str1 + " is not displayed");
					extent.extentLoggerWarning("Tray", str1 + " is not displayed");
				}
			} else {
				if (tabName.equalsIgnoreCase("Home")) {

					if (str1.equalsIgnoreCase("Continue watching tray")) {

						Response respCW = ResponseInstance.getRespofCWTray(userType);

						List<String> ApinoOfContentsInCW = respCW.jsonPath().getList("array");
						logger.info("no.of contents in CW tray in Api " + ApinoOfContentsInCW.size());

						if (ApinoOfContentsInCW.size() == 0) {

							logger.info(str1 + " is not displayed for this user");
							extent.extentLoggerPass("Tray", str1 + " is not displayed for this user");
						} else {
							logger.error(str1 + " is not displayed for this user");
							extent.extentLoggerWarning("Tray", str1 + " is not displayed for this user");
						}
					}
					logger.error(str1 + " is not displayed");
					extent.extentLoggerWarning("Tray", str1 + " is not displayed");
				} else {
					logger.error(str1 + " is not displayed");
					extent.extentLoggerWarning("Tray", str1 + " is not displayed");
				}
			}
		}
		for (int i = 0; i < j; i++) {
			if (!(verifyIsElementDisplayed(byLocator2))) {
				Swipe("DOWN", 1);
			} else {
				verifyElementExist(byLocator2, str2);
				break;
			}
		}
	}

	public void verifyRegistrationDOBEnteredEvent(String usertype) throws Exception {
		if (usertype.equalsIgnoreCase("Guest")) {
			extent.HeaderChildNode("Registration DOB entered event");
			verifyElementPresentAndClick(AMDHomePage.objMoreMenu, "More menu");
			verifyElementPresentAndClick(AMDMoreMenu.objProfile, "My account");
			waitTime(5000);
			String pEmailID = generateRandomString(5) + "@gmail.com";
			type(AMDRegistrationScreen.objEmailIDTextField, pEmailID, "Email field");
			verifyElementPresentAndClick(AMDRegistrationScreen.objProceedBtn, "Proceed button");
			verifyElementPresent(AMDRegistrationScreen.objScreenTitle, "Register for Free screen");
			click(AMDRegistrationScreen.objDOBTxtField, "DOB");
			type(AMDRegistrationScreen.objDOBTxtField, "01/01/1990", "DOB");
			waitTime(3000);
		}
	}

	public void verifyRegistrationGenderEnteredEvent(String usertype) throws Exception {
		if (usertype.equalsIgnoreCase("Guest")) {
			extent.HeaderChildNode("Registration Gender entered event");
			verifyElementPresentAndClick(AMDHomePage.objMoreMenu, "More menu");
			verifyElementPresentAndClick(AMDMoreMenu.objProfile, "My account");
			waitTime(5000);
			String pEmailID = generateRandomString(5) + "@gmail.com";
			type(AMDRegistrationScreen.objEmailIDTextField, pEmailID, "Email field");
			verifyElementPresentAndClick(AMDRegistrationScreen.objProceedBtn, "Proceed button");
			verifyElementPresent(AMDRegistrationScreen.objScreenTitle, "Register for Free screen");
			verifyElementPresentAndClick(AMDRegistrationScreen.objGederTxtField, "Gender field");
			verifyElementPresentAndClick(AMDRegistrationScreen.objMale, "Gender male");
			waitTime(3000);
		}
	}

	public void verifyRegistrationUserNameEnteredEvent(String usertype) throws Exception {
		if (usertype.equalsIgnoreCase("Guest")) {
			extent.HeaderChildNode("Registration userName entered event");
			verifyElementPresentAndClick(AMDHomePage.objMoreMenu, "More menu");
			verifyElementPresentAndClick(AMDMoreMenu.objProfile, "My account");
			waitTime(5000);
			String pEmailID = generateRandomString(5) + "@gmail.com";
			type(AMDRegistrationScreen.objEmailIDTextField, pEmailID, "Email field");
			verifyElementPresentAndClick(AMDRegistrationScreen.objProceedBtn, "Proceed button");
			verifyElementPresent(AMDRegistrationScreen.objScreenTitle, "Register for Free screen");
			type(AMDRegistrationScreen.objFirstNameTxtField, FirstName, "First name field");
			hideKeyboard();
			type(AMDRegistrationScreen.objLastNameTxtField, LastName, "Last name field");
			hideKeyboard();
			waitTime(3000);
		}
	}

	public void verifyRegistrationPasswordEnteredEvent(String usertype) throws Exception {
		if (usertype.equalsIgnoreCase("Guest")) {
			extent.HeaderChildNode("Registration Password entered event");
			verifyElementPresentAndClick(AMDHomePage.objMoreMenu, "More menu");
			verifyElementPresentAndClick(AMDMoreMenu.objProfile, "My account");
			waitTime(5000);
			String pEmailID = generateRandomString(5) + "@gmail.com";
			type(AMDRegistrationScreen.objEmailIDTextField, pEmailID, "Email field");
			verifyElementPresentAndClick(AMDRegistrationScreen.objProceedBtn, "Proceed button");
			verifyElementPresent(AMDRegistrationScreen.objScreenTitle, "Register for Free screen");
			click(AMDRegistrationScreen.objPasswordTxtField, "Passowrd");
			type(AMDRegistrationScreen.objPasswordTxtField, "123456", "Password field");
			hideKeyboard();
			waitTime(3000);
		}
	}

	public void verifyChangePasswordStartedEvent(String userType) throws Exception {
		if (!(userType.equalsIgnoreCase("Guest"))) {
			extent.HeaderChildNode("Change Password started event");
			verifyElementPresentAndClick(AMDHomePage.objMoreMenu, "More menu");
			verifyElementPresentAndClick(AMDMoreMenu.objProfile, "My account");
			waitTime(5000);
			verifyElementPresentAndClick(AMDMyProfileScreen.objChangePassword, "Change Password");
			verifyElementPresentAndClick(AMDChangePasswordScreen.objCurrentPwdField, "Current Password field");
			type(AMDChangePasswordScreen.objCurrentPwdField, "123456", "Current Password field");
			hideKeyboard();
			verifyElementPresentAndClick(AMDChangePasswordScreen.objNewPwdField, "New Password field");
			type(AMDChangePasswordScreen.objNewPwdField, "1234567", "New Password field");
			hideKeyboard();
			verifyElementPresentAndClick(AMDChangePasswordScreen.objConfirmPwdField, "Confirm Password field");
			type(AMDChangePasswordScreen.objConfirmPwdField, "1234567", "Confirm Password field");
			hideKeyboard();
			verifyElementPresentAndClick(AMDChangePasswordScreen.objUpdateBtn, "Update button");

			waitTime(3000);

			verifyElementPresentAndClick(AMDMyProfileScreen.objChangePassword, "Change Password");
			verifyElementPresentAndClick(AMDChangePasswordScreen.objCurrentPwdField, "Current Password field");
			type(AMDChangePasswordScreen.objCurrentPwdField, "1234567", "Current Password field");
			hideKeyboard();
			verifyElementPresentAndClick(AMDChangePasswordScreen.objNewPwdField, "New Password field");
			type(AMDChangePasswordScreen.objNewPwdField, "123456", "New Password field");
			hideKeyboard();
			verifyElementPresentAndClick(AMDChangePasswordScreen.objConfirmPwdField, "Confirm Password field");
			type(AMDChangePasswordScreen.objConfirmPwdField, "123456", "Confirm Password field");
			hideKeyboard();
			verifyElementPresentAndClick(AMDChangePasswordScreen.objUpdateBtn, "Update button");
			waitTime(3000);
		}
	}

	public void verifyChangePasswordResultEvent(String userType) throws Exception {
		if (!(userType.equalsIgnoreCase("Guest"))) {
			extent.HeaderChildNode("Change Password result event");
			verifyElementPresentAndClick(AMDHomePage.objMoreMenu, "More menu");
			verifyElementPresentAndClick(AMDMoreMenu.objProfile, "My account");
			waitTime(5000);
			verifyElementPresentAndClick(AMDMyProfileScreen.objChangePassword, "Change Password");
			verifyElementPresentAndClick(AMDChangePasswordScreen.objCurrentPwdField, "Current Password field");
			type(AMDChangePasswordScreen.objCurrentPwdField, "123456", "Current Password field");
			hideKeyboard();
			verifyElementPresentAndClick(AMDChangePasswordScreen.objNewPwdField, "New Password field");
			type(AMDChangePasswordScreen.objNewPwdField, "1234567", "New Password field");
			hideKeyboard();
			verifyElementPresentAndClick(AMDChangePasswordScreen.objConfirmPwdField, "Confirm Password field");
			type(AMDChangePasswordScreen.objConfirmPwdField, "1234567", "Confirm Password field");
			hideKeyboard();
			verifyElementPresentAndClick(AMDChangePasswordScreen.objUpdateBtn, "Update button");

			waitTime(3000);

			verifyElementPresentAndClick(AMDMyProfileScreen.objChangePassword, "Change Password");
			verifyElementPresentAndClick(AMDChangePasswordScreen.objCurrentPwdField, "Current Password field");
			type(AMDChangePasswordScreen.objCurrentPwdField, "1234567", "Current Password field");
			hideKeyboard();
			verifyElementPresentAndClick(AMDChangePasswordScreen.objNewPwdField, "New Password field");
			type(AMDChangePasswordScreen.objNewPwdField, "123456", "New Password field");
			hideKeyboard();
			verifyElementPresentAndClick(AMDChangePasswordScreen.objConfirmPwdField, "Confirm Password field");
			type(AMDChangePasswordScreen.objConfirmPwdField, "123456", "Confirm Password field");
			hideKeyboard();
			verifyElementPresentAndClick(AMDChangePasswordScreen.objUpdateBtn, "Update button");
			waitTime(3000);
		}
	}

	public void verifyVideoAutoPlayChangeEventForEnable() throws Exception {
		extent.HeaderChildNode("Verify video AutoPlay change Event");
		click(AMDHomePage.MoreMenuIcon, "More menu icon");
		verifyElementPresentAndClick(AMDMoreMenu.objSettings, "Settings option");
		String elementAutoPlayToggleStatus = getText(AMDMoreMenu.objVideo_Autoply);
		if (elementAutoPlayToggleStatus.equalsIgnoreCase("ON")) {
			logger.info("the default state of the 'Auto Play' option is in ON state");
			extentLoggerWarning("Video Auto Play", "the default state of the 'Auto Play' option is in ON state");
		} else {
			click(AMDMoreMenu.objVideo_Autoply, "Video Auto play toggle");

		}
	}

	public void verifyVideoAutoPlayChangeEventforDisable() throws Exception {
		extent.HeaderChildNode("Verify video AutoPlay change Event");
		click(AMDHomePage.MoreMenuIcon, "More menu icon");
		verifyElementPresentAndClick(AMDMoreMenu.objSettings, "Settings option");
		String elementAutoPlayToggleStatus = getText(AMDMoreMenu.objVideo_Autoply);
		if (elementAutoPlayToggleStatus.equalsIgnoreCase("ON")) {
			click(AMDMoreMenu.objVideo_Autoply, "Video Auto play toggle");
		} else {
			logger.info("the default state of the 'Auto Play' option is not in ON state");
			extentLoggerWarning("Video Auto Play", "the default state of the 'Auto Play' option is not in ON state");
		}
	}

	public void verifyAddtoWatchlistFromPlaybackPageInPotrait(String userType, String keyword3) throws Exception {
		if (!(userType.equalsIgnoreCase("Guest"))) {
			extent.HeaderChildNode("Verify Add to Watchlist Event From Playback Page");
			click(AMDSearchScreen.objSearchIcon, "Search icon");
			click(AMDSearchScreen.objSearchEditBox, "Search Box");
			type(AMDSearchScreen.objSearchBoxBar, keyword3 + "\n", "Search bar");
			hideKeyboard();
			waitTime(4000);
			waitForElementDisplayed(AMDSearchScreen.objAllTab, 10);
			click(AMDSearchScreen.objFirstContentInSearchResult, "Search result");
			waitTime(3000);
			verifyElementPresentAndClick(AMDConsumptionScreen.objWatchlistBtn, "Watchlist icon");
			waitTime(5000);
			verifyElementPresentAndClick(AMDConsumptionScreen.objWatchlistBtn, "Watchlist icon");
			waitTime(5000);

		}
	}

	public void verifyRemoveFromWatchListPlaybackPageInPotrait(String userType, String keyword3) throws Exception {
		if (!(userType.equalsIgnoreCase("Guest"))) {
			extent.HeaderChildNode("Verify Remove from Watchlist Event From Playback Page");
			click(AMDSearchScreen.objSearchIcon, "Search icon");
			click(AMDSearchScreen.objSearchEditBox, "Search Box");
			type(AMDSearchScreen.objSearchBoxBar, keyword3 + "\n", "Search bar");
			hideKeyboard();
			waitTime(4000);
			waitForElementDisplayed(AMDSearchScreen.objAllTab, 10);
			click(AMDSearchScreen.objFirstContentInSearchResult, "Search result");
			waitTime(3000);
			verifyElementPresentAndClick(AMDConsumptionScreen.objWatchlistBtn, "Watchlist icon");
			waitTime(5000);
			verifyElementPresentAndClick(AMDConsumptionScreen.objWatchlistBtn, "Watchlist icon");
			waitTime(5000);

		}
	}

	public void verifyPopUpLaunchEventForClubUser(String userType, String keyword6) throws Exception {
		if (userType.equalsIgnoreCase("ClubUser")) {
			extent.HeaderChildNode("Verify Pop Up Launch Event when user gets Upgrade popup for Club User");
			click(AMDSearchScreen.objSearchIcon, "Search icon");
			click(AMDSearchScreen.objSearchEditBox, "Search Box");
			type(AMDSearchScreen.objSearchBoxBar, keyword6 + "\n", "Search bar");
			hideKeyboard();
			waitTime(4000);
			waitForElementDisplayed(AMDSearchScreen.objAllTab, 10);
			click(AMDSearchScreen.objFirstContentInSearchResult, "Search result");
			waitTime(3000);
			verifyElementPresentAndClick(AMDClubPack.objUpgradeToPremiumLinkOnPlayer, "Upgrade button on player");
			verifyIsElementDisplayed(AMDClubPack.objUpgradePopUp, "Upgrade popUp");
			waitTime(3000);
		}
	}

	public void verifyContentBucketSwipeEvent() throws Exception {
		extent.HeaderChildNode("Verify Content Bucket Swipe Event Across tabs");
		waitForElementDisplayed(AMDHomePage.objHomeTab, 10);
		click(AMDHomePage.objPremiumTab, "Premium tab");
		waitTime(10000);
		SwipeRail(AMDHomePage.objContent);
		waitTime(3000);
	}

	public void verifyContentBucketSwipeEventInPlayBackPage(String keyword2) throws Exception {
		extent.HeaderChildNode("Verify Content Bucket Swipe Event in playback page");
		click(AMDSearchScreen.objSearchIcon, "Search icon");
		click(AMDSearchScreen.objSearchEditBox, "Search Box");
		type(AMDSearchScreen.objSearchBoxBar, keyword2 + "\n", "Search bar");
		hideKeyboard();
		waitTime(4000);
		waitForElementDisplayed(AMDSearchScreen.objAllTab, 10);
		click(AMDSearchScreen.objFirstContentInSearchResult, "Search result");
		waitTime(3000);
		SwipeRail(AMDHomePage.objContent);
		waitTime(3000);

	}

	public void verifyProfileUpdateResultEvent(String userType) throws Exception {
		if (!(userType.equalsIgnoreCase("Guest"))) {
			extent.HeaderChildNode("Verify Profile Update Result Event");
			verifyElementPresentAndClick(AMDHomePage.objMoreMenu, "More menu");
			verifyElementPresentAndClick(AMDMoreMenu.objProfile, "My account");
			waitTime(5000);
			verifyElementPresentAndClick(AMDProfileScreen.objEditBtn, "Edit");
			verifyElementPresentAndClick(AMDEditProfileScreen.objGenderDropdown, "Gender");
			String gender = getText(AMDEditProfileScreen.objSelectedGender);
			if (gender.equalsIgnoreCase("Male")) {
				click(AMDEditProfileScreen.objFemale, "Female option");
			} else {
				click(AMDEditProfileScreen.objMale, "Male option");
			}
			verifyElementPresentAndClick(AMDEditProfileScreen.objSaveChanges, "Save changes");

		}
	}

	public void verifyAddtoWatchlistFromPlaybackPageInFullScreen(String userType, String keyword3) throws Exception {
		if (!(userType.equalsIgnoreCase("Guest"))) {
			extent.HeaderChildNode("Verify Add to Watchlist Event From Playback Page in Full screen");
			click(AMDSearchScreen.objSearchIcon, "Search icon");
			click(AMDSearchScreen.objSearchEditBox, "Search Box");
			type(AMDSearchScreen.objSearchBoxBar, keyword3 + "\n", "Search bar");
			hideKeyboard();
			waitTime(4000);
			waitForElementDisplayed(AMDSearchScreen.objAllTab, 10);
			click(AMDSearchScreen.objFirstContentInSearchResult, "Search result");
			waitForElementDisplayed(AMDPlayerScreen.objPlayer, 30);
			verifyElementPresentAndClick(AMDPlayerScreen.objPauseIcon, "Pause icon");
			verifyElementPresentAndClick(AMDPlayerScreen.objFullscreenIcon, "Full screen icon");

			click(AMDPlayerScreen.objThreeDotsOnPlayer, "Player option with 3 dots");
			verifyElementPresentAndClick(AMDPlayerScreen.objAddToWatchlist, "Add to Watchlist option");
			waitTime(6000);
			verifyElementPresentAndClick(AMDPlayerScreen.objPlayerScreen, "Player screen");
			verifyElementPresentAndClick(AMDPlayerScreen.objPauseIcon, "Pause icon");
			click(AMDPlayerScreen.objThreeDotsOnPlayer, "Player option with 3 dots");
			verifyElementPresentAndClick(AMDPlayerScreen.objAddToWatchlist, "Add to Watchlist option");
			waitTime(5000);
		}
	}

	public void verifyRemoveFromWatchlistFromPlaybackPageInFullScreen(String userType, String keyword3)
			throws Exception {
		if (!(userType.equalsIgnoreCase("Guest"))) {
			extent.HeaderChildNode("Verify Remove from  Watchlist Event From Playback Page in Full screen");
			click(AMDSearchScreen.objSearchIcon, "Search icon");
			click(AMDSearchScreen.objSearchEditBox, "Search Box");
			type(AMDSearchScreen.objSearchBoxBar, keyword3 + "\n", "Search bar");
			hideKeyboard();
			waitTime(4000);
			waitForElementDisplayed(AMDSearchScreen.objAllTab, 10);
			click(AMDSearchScreen.objFirstContentInSearchResult, "Search result");
			waitForElementDisplayed(AMDPlayerScreen.objPlayer, 30);
			verifyElementPresentAndClick(AMDPlayerScreen.objPauseIcon, "Pause icon");
			verifyElementPresentAndClick(AMDPlayerScreen.objFullscreenIcon, "Full screen icon");

			click(AMDPlayerScreen.objThreeDotsOnPlayer, "Player option with 3 dots");
			verifyElementPresentAndClick(AMDPlayerScreen.objAddToWatchlist, "Add to Watchlist option");
			waitTime(6000);
			verifyElementPresentAndClick(AMDPlayerScreen.objPlayerScreen, "Player screen");
			verifyElementPresentAndClick(AMDPlayerScreen.objPauseIcon, "Pause icon");
			click(AMDPlayerScreen.objThreeDotsOnPlayer, "Player option with 3 dots");
			verifyElementPresentAndClick(AMDPlayerScreen.objAddToWatchlist, "Add to Watchlist option");
			waitTime(5000);
		}
	}

	public void videoViewEventForPremiumContentInPotrait(String usertype, String tabName) throws Exception {
		if (userType.equalsIgnoreCase("SubscribedUser")) {
			extent.HeaderChildNode("Video View Event for premium content in potrait");
			waitTime(10000);
			SelectTopNavigationTab(tabName);
			Swipe("UP", 1);
			boolean var = false;
			for (int i = 0; i < 3; i++) {
				var = verifyIsElementDisplayed(AMDHomePage.objPremiumTag, "Premium Tag");
				if (var == true) {
					verifyElementPresentAndClick(AMDHomePage.objPremiumTag, "Premium content");
					verifyIsElementDisplayed(AMDPlayerScreen.objPlayer, "Player screen");
					waitTime(3000);
					Back(1);
					break;
				} else {
					Swipe("UP", 1);
				}
			}
			if (var == false) {
				logger.info("Premium content is not displayed in the screen");
				extentLoggerWarning("Premium Content", "Premium content is not displayed in the screen");
			}
		}
	}

	public void videoViewEventForPremiumContentInFullScreen(String usertype, String tabName) throws Exception {
		if (userType.equalsIgnoreCase("SubscribedUser")) {
			extent.HeaderChildNode("Video View Event for premium content in full screen");
			waitTime(10000);
			SelectTopNavigationTab(tabName);
			Swipe("UP", 1);
			boolean var = false;
			for (int i = 0; i < 3; i++) {
				var = verifyIsElementDisplayed(AMDHomePage.objPremiumTag, "Premium Tag");
				if (var == true) {
					verifyElementPresentAndClick(AMDHomePage.objPremiumTag, "Premium content");
					verifyIsElementDisplayed(AMDPlayerScreen.objPlayer, "Player screen");
					waitTime(6000);
					click(AMDPlayerScreen.objPlayerScreen, "Player screen");
					verifyElementPresentAndClick(AMDPlayerScreen.objPauseIcon, "Pause icon");
					verifyElementPresentAndClick(AMDPlayerScreen.objFullscreenIcon, "Full screen icon");
					verifyElementPresentAndClick(AMDPlayerScreen.objPlayIcon, "Play icon");
					waitTime(4000);
					Back(2);
					break;
				} else {
					Swipe("UP", 1);
				}
			}
			if (var == false) {
				logger.info("Premium content is not displayed in the screen");
				extentLoggerWarning("Premium Content", "Premium content is not displayed in the screen");
			}
		}
	}

	public void videoViewEventForCarouselContentInPotrait(String tabName) throws Exception {
		extent.HeaderChildNode("Video View Event for carousel content in potrait");
		waitTime(10000);
		SelectTopNavigationTab(tabName);
		verifyElementPresentAndClick(AMDHomePage.objCarouselConetentCard, "carousel content");
		waitForElementDisplayed(AMDPlayerScreen.objPlayer, 20);
		Boolean var = verifyIsElementDisplayed(AMDPlayerScreen.objPlayer);
		if (var == true) {
			logger.info("Player screen is displayed");
			extentLoggerPass("Player screen", "Player screen is displayed");
		} else if (verifyIsElementDisplayed(AMDPlayerScreen.objPremiumTextOnPlayer)) {
			logger.info("Player inline subscription link is displayed");
			extentLoggerPass("Player screen", "Player inline subscription link is displayed");
		}
		Back(1);
	}

	public void videoViewEventForCarouselContentInFullScreen(String tabName) throws Exception {
		extent.HeaderChildNode("Video View Event for carousel content in full screen");
		waitTime(10000);
		SelectTopNavigationTab(tabName);
		verifyElementPresentAndClick(AMDHomePage.objCarouselConetentCard, "carousel content");
		waitForElementDisplayed(AMDPlayerScreen.objPlayer, 20);
		Boolean var = verifyIsElementDisplayed(AMDPlayerScreen.objPlayer);
		if (var == true) {
			logger.info("Player screen is displayed");
			extentLoggerPass("Player screen", "Player screen is displayed");
			waitTime(6000);
			click(AMDPlayerScreen.objPlayerScreen, "Player screen");
			verifyElementPresentAndClick(AMDPlayerScreen.objPauseIcon, "Pause icon");
			verifyElementPresentAndClick(AMDPlayerScreen.objFullscreenIcon, "Full screen icon");
			verifyElementPresentAndClick(AMDPlayerScreen.objPlayIcon, "Play icon");
			waitTime(4000);
			Back(2);
		} else if (verifyIsElementDisplayed(AMDPlayerScreen.objPremiumTextOnPlayer)) {
			logger.info("Player inline subscription link is displayed");
			extentLoggerPass("Player screen", "Player inline subscription link is displayed");
		}
	}

	public void videoViewEventOfcontentFromSearchPageInPotrait(String keyword3) throws Exception {
		extent.HeaderChildNode("Video View Event of content from search page in potrait");
		click(AMDSearchScreen.objSearchIcon, "Search icon");
		click(AMDSearchScreen.objSearchEditBox, "Search Box");
		type(AMDSearchScreen.objSearchBoxBar, keyword3 + "\n", "Search bar");
		hideKeyboard();
		waitTime(4000);
		waitForElementDisplayed(AMDSearchScreen.objAllTab, 10);
		click(AMDSearchScreen.objFirstContentInSearchResult, "Search result");
		verifyIsElementDisplayed(AMDPlayerScreen.objPlayer);
		Back(1);
	}

	public void videoViewEventOfcontentFromSearchPageInFullScreen(String keyword3) throws Exception {
		extent.HeaderChildNode("Video View Event of content from search page in Full screen");
		click(AMDSearchScreen.objSearchIcon, "Search icon");
		click(AMDSearchScreen.objSearchEditBox, "Search Box");
		type(AMDSearchScreen.objSearchBoxBar, keyword3 + "\n", "Search bar");
		hideKeyboard();
		waitTime(4000);
		waitForElementDisplayed(AMDSearchScreen.objAllTab, 10);
		click(AMDSearchScreen.objFirstContentInSearchResult, "Search result");
		verifyIsElementDisplayed(AMDPlayerScreen.objPlayer);
		waitTime(6000);
		click(AMDPlayerScreen.objPlayerScreen, "Player screen");
		verifyElementPresentAndClick(AMDPlayerScreen.objPauseIcon, "Pause icon");
		verifyElementPresentAndClick(AMDPlayerScreen.objFullscreenIcon, "Full screen icon");
		verifyElementPresentAndClick(AMDPlayerScreen.objPlayIcon, "Play icon");
		waitTime(4000);
		Back(2);
	}

	public void videoViewEventOfContentFromMyWatchListPageInPotrait(String usertype) throws Exception {
		if (!(usertype.equalsIgnoreCase("Guest"))) {
			extent.HeaderChildNode("Video View Event of content from My WatchList page in potrait");
			click(AMDMoreMenu.objWatchlist, "Watchlist option");
			click(AMDUserSessionManagement.objMoviesTabUnderWatchList, "Movies Tab");
			boolean contentsInMoviesTab = getDriver()
					.findElement(By.xpath("(//*[@resource-id='com.graymatrix.did:id/txt_reminder_item_title'])[1]"))
					.isDisplayed();
			if (contentsInMoviesTab == true) {
				getDriver()
						.findElement(By.xpath("(//*[@resource-id='com.graymatrix.did:id/txt_reminder_item_title'])[1]"))
						.click();
				verifyIsElementDisplayed(AMDPlayerScreen.objPlayer, "Player screen");
				Back(3);
			} else {
				logger.info("No contents in Watchlist");
				extentLoggerWarning("Watchlist", "No contents in Watchlist");
				Back(2);
			}
		}

	}

	public void videoViewEventOfContentFromMyWatchListPageInFullScreen(String usertype) throws Exception {
		if (!(usertype.equalsIgnoreCase("Guest"))) {
			extent.HeaderChildNode("Video View Event of content from My WatchList page in full screen");
			click(AMDMoreMenu.objWatchlist, "Watchlist option");
			click(AMDUserSessionManagement.objMoviesTabUnderWatchList, "Movies Tab");
			boolean contentsInMoviesTab = getDriver()
					.findElement(By.xpath("(//*[@resource-id='com.graymatrix.did:id/txt_reminder_item_title'])[1]"))
					.isDisplayed();
			if (contentsInMoviesTab == true) {
				getDriver()
						.findElement(By.xpath("(//*[@resource-id='com.graymatrix.did:id/txt_reminder_item_title'])[1]"))
						.click();
				boolean var = verifyIsElementDisplayed(AMDPlayerScreen.objPlayer, "Player screen");
				if (var == true) {
					logger.info("Player screen is displayed");
					extentLoggerPass("Player screen", "Player screen is displayed");
					waitTime(6000);
					click(AMDPlayerScreen.objPlayerScreen, "Player screen");
					verifyElementPresentAndClick(AMDPlayerScreen.objPauseIcon, "Pause icon");
					verifyElementPresentAndClick(AMDPlayerScreen.objFullscreenIcon, "Full screen icon");
					verifyElementPresentAndClick(AMDPlayerScreen.objPlayIcon, "Play icon");
					waitTime(4000);
					Back(4);
				}
			} else {
				logger.info("No contents in Watchlist");
				extentLoggerWarning("Watchlist", "No contents in Watchlist");
				Back(2);
			}
		}
	}

	public void verifyRemoveFromWatchlistFromWatchListPage(String userType) throws Exception {
		if (!(userType.equalsIgnoreCase("Guest"))) {
			extent.HeaderChildNode("Remove an content from My WatchList page");
			click(AMDHomePage.objMoreMenu, "More menu");
			click(AMDMoreMenu.objWatchlist, "Watchlist option");
			click(AMDUserSessionManagement.objShowsTabUnderWatchList, "Shows Tab");
			verifyElementPresentAndClick(AMDWatchlistPage.objEditBtn, "Edit button");
			verifyElementPresentAndClick(AMDWatchlistPage.objSelectContentByIndex(1), "check box");
			verifyElementPresentAndClick(AMDWatchlistPage.objDeleteAllBtn, "Delete All");
		}

	}

	public void verifyVideoStreamOverWifiChangeEventForEnable() throws Exception {
		extent.HeaderChildNode("Verify video wifi change Event for Enable");
		click(AMDHomePage.MoreMenuIcon, "More menu icon");
		verifyElementPresentAndClick(AMDMoreMenu.objSettings, "Settings option");
		verifyElementPresentAndClick(AMDMoreMenu.objVideo_WifiOnly, "Wifi only Switch");
		waitTime(3000);
		verifyElementPresentAndClick(AMDMoreMenu.objVideo_WifiOnly, "Wifi only Switch");
	}

	public void verifyVideoStreamOverWifiChangeEventForDisable() throws Exception {
		extent.HeaderChildNode("Verify video wifi change Event for Disable");
		click(AMDHomePage.MoreMenuIcon, "More menu icon");
		verifyElementPresentAndClick(AMDMoreMenu.objSettings, "Settings option");
		verifyElementPresentAndClick(AMDMoreMenu.objVideo_WifiOnly, "Wifi only Switch");
		waitTime(3000);
		verifyElementPresentAndClick(AMDMoreMenu.objVideo_WifiOnly, "Wifi only Switch");
	}

	public void verifyDownloadQualityChangeEvent() throws Exception {
		extent.HeaderChildNode("Verify Download quality change Event");
		click(AMDHomePage.MoreMenuIcon, "More menu icon");
		verifyElementPresentAndClick(AMDMoreMenu.objSettings, "Settings option");
		verifyElementPresentAndClick(AMDMoreMenu.objDownloads_Quality, "Download quality option");
		verifyElementPresentAndClick(AMDSettingsScreen.objVideoQualityBest, "Best option");
	}

	public void verifyDownloadOverWifiChangeEventForEnable() throws Exception {
		extent.HeaderChildNode("Verify Download Over wifi change Event for Enable");
		click(AMDHomePage.MoreMenuIcon, "More menu icon");
		verifyElementPresentAndClick(AMDMoreMenu.objSettings, "Settings option");
		verifyElementPresentAndClick(AMDMoreMenu.objDownloads_WifiOnly, "Download over wifi only switch");
		waitTime(3000);
		verifyElementPresentAndClick(AMDMoreMenu.objDownloads_WifiOnly, "Download over wifi only switch");
	}

	public void verifyDownloadOverWifiChangeEventForDisable() throws Exception {
		extent.HeaderChildNode("Verify Download Over wifi change Event for Disable");
		click(AMDHomePage.MoreMenuIcon, "More menu icon");
		verifyElementPresentAndClick(AMDMoreMenu.objSettings, "Settings option");
		verifyElementPresentAndClick(AMDMoreMenu.objDownloads_WifiOnly, "Download over wifi only switch");
		waitTime(3000);
		verifyElementPresentAndClick(AMDMoreMenu.objDownloads_WifiOnly, "Download over wifi only switch");
	}

	public void verifyDisplayLanguageChangeFromWelcomePage(String usertype, String dsl) throws Exception {
		if (usertype.equalsIgnoreCase("Guest")) {
			extent.HeaderChildNode("Verify Display Language Change event from Welcome page");
			click(AMDOnboardingScreen.objSelectDisplayLang(dsl), "language");
			verifyElementPresentAndClick(AMDOnboardingScreen.objDiplay_ContinueBtn,
					"Continue button in Display language Page");
		}
	}

	public void verifyContinueLanguageFromWelcomePage(String usertype) throws Exception {
		if (usertype.equalsIgnoreCase("Guest")) {
			extent.HeaderChildNode("Verify Content Language Change event from Welcome page");
			verifyElementPresentAndClick(AMDOnboardingScreen.objDiplay_ContinueBtn,
					"Continue button in Display language Page");
			click(AMDOnboardingScreen.objgetContentLangName(1), "Content Language");
			verifyElementPresentAndClick(AMDOnboardingScreen.objContent_ContinueBtn,
					"Continue button in Content language page");
		}
	}
	
	public void videoViewEventForPremiumContent(String usertype, String tabName) throws Exception {
		if (userType.equalsIgnoreCase("SubscribedUser")) {
			extent.HeaderChildNode("Video View Event for premium content in potrait");
			waitTime(10000);
			SelectTopNavigationTab(tabName);
			Swipe("UP", 1);
			boolean var = false;
			for (int i = 0; i < 3; i++) {
				var = verifyIsElementDisplayed(AMDHomePage.objPremiumTag, "Premium Tag");
				if (var == true) {
					verifyElementPresentAndClick(AMDHomePage.objPremiumTag, "Premium content");
					verifyIsElementDisplayed(AMDPlayerScreen.objPlayer, "Player screen");
					waitTime(3000);
					break;
				} else {
					Swipe("UP", 1);
				}
			}
			if (var == false) {
				logger.info("Premium content is not displayed in the screen");
				extentLoggerWarning("Premium Content", "Premium content is not displayed in the screen");
			}
		}
	}

	public void videoViewEventForCarouselContent(String tabName) throws Exception {
		extent.HeaderChildNode("Video View Event for carousel content");
		waitTime(10000);
		SelectTopNavigationTab(tabName);
		verifyElementPresentAndClick(AMDHomePage.objCarouselConetentCard, "carousel content");
		waitForElementDisplayed(AMDPlayerScreen.objPlayer, 20);
		Boolean var = verifyIsElementDisplayed(AMDPlayerScreen.objPlayer);
		if (var == true) {
			logger.info("Player screen is displayed");
			extentLoggerPass("Player screen", "Player screen is displayed");
		} else if (verifyIsElementDisplayed(AMDPlayerScreen.objPremiumTextOnPlayer)) {
			logger.info("Player inline subscription link is displayed");
			extentLoggerPass("Player screen", "Player inline subscription link is displayed");
		}
	}

	

	public void videoViewEventOfcontentFromSearchPage(String usertype, String keyword4) throws Exception {
		extent.HeaderChildNode("Video View Event of content from search page");
		click(AMDSearchScreen.objSearchIcon, "Search icon");
		click(AMDSearchScreen.objSearchEditBox, "Search Box");
		type(AMDSearchScreen.objSearchBoxBar, keyword4 + "\n", "Search bar");
		hideKeyboard();
		waitTime(4000);
		waitForElementDisplayed(AMDSearchScreen.objAllTab, 10);
		click(AMDSearchScreen.objFirstContentInSearchResult, "Search result");
		if (!(usertype.equalsIgnoreCase("SubscribedUser"))) {
			waitForAdToFinishInAmd();
		}
		registerPopUpClose();
		completeProfilePopUpClose(usertype);
		waitTime(6000);
		verifyElementPresentAndClick(AMDPlayerScreen.objPlayerScreen, "Player screen");
		verifyElementPresentAndClick(AMDPlayerScreen.objPauseIcon, "Pause icon");
		verifyElementPresentAndClick(AMDPlayerScreen.objFullscreenIcon, "Full screen icon");
		verifyElementPresentAndClick(AMDPlayerScreen.objPlayIcon, "Play icon");
		waitTime(4000);
	}
	
	public void videoViewEventOfContentFromMyWatchListPage(String usertype) throws Exception {
		if (!(usertype.equalsIgnoreCase("Guest"))) {
			extent.HeaderChildNode("Video View Event of content from My WatchList page");
			click(AMDHomePage.objMoreMenu, "More menu");
			click(AMDMoreMenu.objWatchlist, "Watchlist option");
			click(AMDUserSessionManagement.objMoviesTabUnderWatchList, "Movies Tab");
			waitTime(5000);
			boolean contentsInMoviesTab = verifyIsElementDisplayed(AMDUserSessionManagement.objcontentTitleInWatchListAndReminders);
			if (contentsInMoviesTab == true) {
				getDriver()
						.findElement(By.xpath("(//*[@resource-id='com.graymatrix.did:id/txt_reminder_item_title'])[1]"))
						.click();
				waitTime(5000);
				verifyIsElementDisplayed(AMDPlayerScreen.objPlayer, "Player screen");
			} else {
				logger.info("No contents in Watchlist");
				extentLoggerWarning("Watchlist", "No contents in Watchlist");
			}
		}
	}
	
	public void videoViewEventForTrailerContent(String usertype, String keyword3) throws Exception {
    	extent.HeaderChildNode("Verify Video View event for Trailer content");
    	click(AMDSearchScreen.objSearchIcon, "Search icon");
    	click(AMDSearchScreen.objSearchEditBox, "Search Box");
    	type(AMDSearchScreen.objSearchBoxBar, keyword3 + "\n", "Search bar");
    	hideKeyboard();
    	waitTime(4000);
    	waitForElementDisplayed(AMDSearchScreen.objAllTab, 10);
    	click(AMDSearchScreen.objFirstContentInSearchResult, "Search result");
    	waitForElementDisplayed(AMDPlayerScreen.objPlayer, 10);
    	verifyIsElementDisplayed(AMDPlayerScreen.objPlayer);
    	if(usertype.equalsIgnoreCase("SubscribedUser")) {
    		verifyElementPresentAndClick(AMDConsumptionScreen.objWatchTrialer, "Watch Trailer button");
    	}
    	waitTime(5000);
    }
    
	 public void videoViewEventOfContentFromUpNextRail(String usertype, String keyword4) throws Exception {
	    	extent.HeaderChildNode("Verify Video View event of content from Upnext rail");
	    	click(AMDSearchScreen.objSearchIcon, "Search icon");
	    	click(AMDSearchScreen.objSearchEditBox, "Search Box");
	    	type(AMDSearchScreen.objSearchBoxBar, keyword4 + "\n", "Search bar");
	    	hideKeyboard();
	    	waitTime(4000);
	    	waitForElementDisplayed(AMDSearchScreen.objAllTab, 10);
	    	click(AMDSearchScreen.objFirstContentInSearchResult, "Search result");
	    	waitTime(8000);
	    	Swipe("UP", 1);
			if (verifyElementDisplayed(AMDPlayerScreen.objFirstContentCardTitleInUpnextTray)) {
				verifyElementPresentAndClick(AMDPlayerScreen.objFirstContentCardTitleInUpnextTray, "Upnext rail content");
			}
			if (!(usertype.equalsIgnoreCase("SubscribedUser"))) {
				waitForAdToFinishInAmd();
			}
			registerPopUpClose();
			completeProfilePopUpClose(usertype);
			waitTime(6000);
			verifyElementPresentAndClick(AMDPlayerScreen.objPlayerScreen, "Player screen");
			verifyIsElementDisplayed(AMDPlayerScreen.objPlayer);
			waitTime(5000);
	    }

	 public void videoExitEventForPremiumContent(String usertype, String tabName) throws Exception {
			if (userType.equalsIgnoreCase("SubscribedUser")) {
				extent.HeaderChildNode("Video Exit Event for premium content in potrait");
				waitTime(10000);
				SelectTopNavigationTab(tabName);
				Swipe("UP", 1);
				boolean var = false;
				for (int i = 0; i < 3; i++) {
					var = verifyIsElementDisplayed(AMDHomePage.objPremiumTag, "Premium Tag");
					if (var == true) {
						verifyElementPresentAndClick(AMDHomePage.objPremiumTag, "Premium content");
						verifyIsElementDisplayed(AMDPlayerScreen.objPlayer, "Player screen");
						waitTime(3000);
						Back(1);
						break;
					} else {
						Swipe("UP", 1);
					}
				}
				if (var == false) {
					logger.info("Premium content is not displayed in the screen");
					extentLoggerWarning("Premium Content", "Premium content is not displayed in the screen");
				}
			}
		}
	    
	    public void videoExitEventForTrailerContent(String usertype, String keyword3) throws Exception {
	    	extent.HeaderChildNode("Verify Video Exit event for Trailer content");
	    	click(AMDSearchScreen.objSearchIcon, "Search icon");
	    	click(AMDSearchScreen.objSearchEditBox, "Search Box");
	    	type(AMDSearchScreen.objSearchBoxBar, keyword3 + "\n", "Search bar");
	    	hideKeyboard();
	    	waitTime(4000);
	    	waitForElementDisplayed(AMDSearchScreen.objAllTab, 10);
	    	click(AMDSearchScreen.objFirstContentInSearchResult, "Search result");
	    	waitForElementDisplayed(AMDPlayerScreen.objPlayer, 10);
	    	verifyIsElementDisplayed(AMDPlayerScreen.objPlayer);
	    	if(usertype.equalsIgnoreCase("SubscribedUser")) {
	    		verifyElementPresentAndClick(AMDConsumptionScreen.objWatchlistBtn, "Watch Trailer button");
	    		Back(1);
	    	}
	    	waitTime(5000);
	    	Back(1);
	    }
	    
	    public void videoExitEventForCarouselContent(String tabName) throws Exception {
			extent.HeaderChildNode("Video Exit Event for carousel content");
			waitTime(10000);
			SelectTopNavigationTab(tabName);
			verifyElementPresentAndClick(AMDHomePage.objCarouselConetentCard, "carousel content");
			waitForElementDisplayed(AMDPlayerScreen.objPlayer, 20);
			Boolean var = verifyIsElementDisplayed(AMDPlayerScreen.objPlayer);
			if (var == true) {
				logger.info("Player screen is displayed");
				extentLoggerPass("Player screen", "Player screen is displayed");
			} else if (verifyIsElementDisplayed(AMDPlayerScreen.objPremiumTextOnPlayer)) {
				logger.info("Player inline subscription link is displayed");
				extentLoggerPass("Player screen", "Player inline subscription link is displayed");
			}
			Back(1);
		}
	    
	    public void videoExitEventOfcontentFromSearchPage(String usertype, String keyword4) throws Exception {
			extent.HeaderChildNode("Video Exit Event of content from search page");
			click(AMDSearchScreen.objSearchIcon, "Search icon");
			click(AMDSearchScreen.objSearchEditBox, "Search Box");
			type(AMDSearchScreen.objSearchBoxBar, keyword4 + "\n", "Search bar");
			hideKeyboard();
			waitTime(4000);
			waitForElementDisplayed(AMDSearchScreen.objAllTab, 10);
			click(AMDSearchScreen.objFirstContentInSearchResult, "Search result");
			if (!(usertype.equalsIgnoreCase("SubscribedUser"))) {
				waitForAdToFinishInAmd();
			}
			registerPopUpClose();
			completeProfilePopUpClose(usertype);
			waitTime(6000);
			verifyElementPresentAndClick(AMDPlayerScreen.objPlayerScreen, "Player screen");
			verifyIsElementDisplayed(AMDPlayerScreen.objPlayer);
			verifyElementPresentAndClick(AMDPlayerScreen.objPauseIcon, "Pause icon");
			verifyElementPresentAndClick(AMDPlayerScreen.objFullscreenIcon, "Full screen icon");
			verifyElementPresentAndClick(AMDPlayerScreen.objPlayIcon, "Play icon");
			waitTime(4000);
			Back(2);
		}
	    
	    public void videoExitEventOfContentFromMyWatchListPage(String usertype) throws Exception {
			if (!(usertype.equalsIgnoreCase("Guest"))) {
				extent.HeaderChildNode("Video Exit Event of content from My WatchList page");
				click(AMDHomePage.objMoreMenu, "More menu");
				click(AMDMoreMenu.objWatchlist, "Watchlist option");
				click(AMDUserSessionManagement.objMoviesTabUnderWatchList, "Movies Tab");
				waitTime(5000);
				boolean contentsInMoviesTab = verifyIsElementDisplayed(AMDUserSessionManagement.objcontentTitleInWatchListAndReminders);
				if (contentsInMoviesTab == true) {
					getDriver()
							.findElement(By.xpath("(//*[@resource-id='com.graymatrix.did:id/txt_reminder_item_title'])[1]"))
							.click();
					waitTime(5000);
					verifyIsElementDisplayed(AMDPlayerScreen.objPlayer, "Player screen");
					Back(3);
				} else {
					logger.info("No contents in Watchlist");
					extentLoggerWarning("Watchlist", "No contents in Watchlist");
					Back(2);
				}
			}

		}
	    
	    public void videoExitEventOfContentFromUpNextRail(String usertype, String keyword4) throws Exception {
	    	extent.HeaderChildNode("Verify Video Exit event of content from Upnext rail");
	    	click(AMDSearchScreen.objSearchIcon, "Search icon");
	    	click(AMDSearchScreen.objSearchEditBox, "Search Box");
	    	type(AMDSearchScreen.objSearchBoxBar, keyword4 + "\n", "Search bar");
	    	hideKeyboard();
	    	waitTime(4000);
	    	waitForElementDisplayed(AMDSearchScreen.objAllTab, 10);
	    	click(AMDSearchScreen.objFirstContentInSearchResult, "Search result");
	    	waitTime(8000);
	    	Swipe("UP", 1);
			if (verifyElementDisplayed(AMDPlayerScreen.objFirstContentCardTitleInUpnextTray)) {
				verifyElementPresentAndClick(AMDPlayerScreen.objFirstContentCardTitleInUpnextTray, "Upnext rail content");
			}
			if (!(usertype.equalsIgnoreCase("SubscribedUser"))) {
				waitForAdToFinishInAmd();
			}
			registerPopUpClose();
			completeProfilePopUpClose(usertype);
			waitTime(6000);
			verifyElementPresentAndClick(AMDPlayerScreen.objPlayerScreen, "Player screen");
			verifyIsElementDisplayed(AMDPlayerScreen.objPlayer);
			Back(2);
	    }
	    
	    public void playerViewChangedEventForPremiumContent(String usertype, String tabName) throws Exception {
	    	if (userType.equalsIgnoreCase("SubscribedUser")) {
				extent.HeaderChildNode("Player View Changed Event for premium content");
				waitTime(10000);
				SelectTopNavigationTab(tabName);
				Swipe("UP", 1);
				boolean var = false;
				for (int i = 0; i < 3; i++) {
					var = verifyIsElementDisplayed(AMDHomePage.objPremiumTag, "Premium Tag");
					if (var == true) {
						verifyElementPresentAndClick(AMDHomePage.objPremiumTag, "Premium content");
						verifyElementPresentAndClick(AMDPlayerScreen.objPauseIcon, "Pause icon");
						verifyElementPresentAndClick(AMDPlayerScreen.objFullscreenIcon, "Full screen icon");
						verifyElementPresentAndClick(AMDPlayerScreen.objPlayIcon, "Play icon");
						waitTime(4000);
						break;
					} else {
						Swipe("UP", 1);
					}
				}
				if (var == false) {
					logger.info("Premium content is not displayed in the screen");
					extentLoggerWarning("Premium Content", "Premium content is not displayed in the screen");
				}
			}
	    }
	    
	    public void PlayerViewChangedEventForTrailerContent(String usertype, String keyword3) throws Exception {
	    	extent.HeaderChildNode("Player View Changed event for Trailer content");
	    	click(AMDSearchScreen.objSearchIcon, "Search icon");
	    	click(AMDSearchScreen.objSearchEditBox, "Search Box");
	    	type(AMDSearchScreen.objSearchBoxBar, keyword3 + "\n", "Search bar");
	    	hideKeyboard();
	    	waitTime(4000);
	    	waitForElementDisplayed(AMDSearchScreen.objAllTab, 10);
	    	click(AMDSearchScreen.objFirstContentInSearchResult, "Search result");
	    	waitForElementDisplayed(AMDPlayerScreen.objPlayer, 10);
	    	if(usertype.equalsIgnoreCase("SubscribedUser")) {
	    		verifyElementPresentAndClick(AMDConsumptionScreen.objWatchTrialer, "Watch Trailer button");
	    	}
	    	waitTime(6000);
			verifyElementPresentAndClick(AMDPlayerScreen.objPlayerScreen, "Player screen");
	    	verifyElementPresentAndClick(AMDPlayerScreen.objPauseIcon, "Pause icon");
	    	verifyElementPresentAndClick(AMDPlayerScreen.objFullscreenIcon, "Full screen icon");
			verifyElementPresentAndClick(AMDPlayerScreen.objPlayIcon, "Play icon");
	    	waitTime(5000);
	    	
	    }
	    
	    public void PlayerViewChangedEventForCarouselContent(String tabName) throws Exception {
			extent.HeaderChildNode("Player View Changed Event for carousel content");
			waitTime(10000);
			SelectTopNavigationTab(tabName);
			verifyElementPresentAndClick(AMDHomePage.objCarouselConetentCard, "carousel content");
			waitForElementDisplayed(AMDPlayerScreen.objPlayer, 20);
			Boolean var = verifyIsElementDisplayed(AMDPlayerScreen.objPlayer);
			if (var == true) {
				logger.info("Player screen is displayed");
				extentLoggerPass("Player screen", "Player screen is displayed");
				waitTime(6000);
				verifyElementPresentAndClick(AMDPlayerScreen.objPlayerScreen, "Player screen");
				verifyElementPresentAndClick(AMDPlayerScreen.objPauseIcon, "Pause icon");
		    	verifyElementPresentAndClick(AMDPlayerScreen.objFullscreenIcon, "Full screen icon");
				verifyElementPresentAndClick(AMDPlayerScreen.objPlayIcon, "Play icon");
				waitTime(5000);
			} else if (verifyIsElementDisplayed(AMDPlayerScreen.objPremiumTextOnPlayer)) {
				logger.info("Player inline subscription link is displayed");
				extentLoggerPass("Player screen", "Player inline subscription link is displayed");
			}
		}
	    
	    public void PlayerViewChangedEventOfcontentFromSearchPage(String usertype, String keyword4) throws Exception {
			extent.HeaderChildNode("Player View Changed Event of content from search page");
			click(AMDSearchScreen.objSearchIcon, "Search icon");
			click(AMDSearchScreen.objSearchEditBox, "Search Box");
			type(AMDSearchScreen.objSearchBoxBar, keyword4 + "\n", "Search bar");
			hideKeyboard();
			waitTime(4000);
			waitForElementDisplayed(AMDSearchScreen.objAllTab, 10);
			click(AMDSearchScreen.objFirstContentInSearchResult, "Search result");
			if (!(usertype.equalsIgnoreCase("SubscribedUser"))) {
				waitForAdToFinishInAmd();
			}
			registerPopUpClose();
			completeProfilePopUpClose(usertype);
			waitTime(6000);
			verifyElementPresentAndClick(AMDPlayerScreen.objPlayerScreen, "Player screen");
			verifyElementPresentAndClick(AMDPlayerScreen.objPauseIcon, "Pause icon");
			verifyElementPresentAndClick(AMDPlayerScreen.objFullscreenIcon, "Full screen icon");
			verifyElementPresentAndClick(AMDPlayerScreen.objPlayIcon, "Play icon");
			waitTime(4000);
		}
	    
	    public void PlayerViewChangedEventOfContentFromMyWatchListPage(String usertype) throws Exception {
			if (!(usertype.equalsIgnoreCase("Guest"))) {
				extent.HeaderChildNode("Player View Changed Event of content from My WatchList page");
				click(AMDHomePage.objMoreMenu, "More menu");
				click(AMDMoreMenu.objWatchlist, "Watchlist option");
				click(AMDUserSessionManagement.objMoviesTabUnderWatchList, "Movies Tab");
				waitTime(5000);
				boolean contentsInMoviesTab = verifyIsElementDisplayed(AMDUserSessionManagement.objcontentTitleInWatchListAndReminders);
				if (contentsInMoviesTab == true) {
					getDriver()
							.findElement(By.xpath("(//*[@resource-id='com.graymatrix.did:id/txt_reminder_item_title'])[1]"))
							.click();
					waitTime(5000);
					waitForElementDisplayed(AMDPlayerScreen.objPlayer, 10);
					verifyElementPresentAndClick(AMDPlayerScreen.objPauseIcon, "Pause icon");
					verifyElementPresentAndClick(AMDPlayerScreen.objFullscreenIcon, "Full screen icon");
					verifyElementPresentAndClick(AMDPlayerScreen.objPlayIcon, "Play icon");
					waitTime(4000);
				} else {
					logger.info("No contents in Watchlist");
					extentLoggerWarning("Watchlist", "No contents in Watchlist");
				}
			}

		}
	    
	    public void PlayerViewChangedEventOfContentFromUpNextRail(String usertype, String keyword4) throws Exception {
	    	extent.HeaderChildNode("Verify Player View Changed event of content from Upnext rail");
	    	click(AMDSearchScreen.objSearchIcon, "Search icon");
	    	click(AMDSearchScreen.objSearchEditBox, "Search Box");
	    	type(AMDSearchScreen.objSearchBoxBar, keyword4 + "\n", "Search bar");
	    	hideKeyboard();
	    	waitTime(4000);
	    	waitForElementDisplayed(AMDSearchScreen.objAllTab, 10);
	    	click(AMDSearchScreen.objFirstContentInSearchResult, "Search result");
	    	waitTime(8000);
	    	Swipe("UP", 1);
			if (verifyElementDisplayed(AMDPlayerScreen.objFirstContentCardTitleInUpnextTray)) {
				verifyElementPresentAndClick(AMDPlayerScreen.objFirstContentCardTitleInUpnextTray, "Upnext rail content");
			}
			if (!(usertype.equalsIgnoreCase("SubscribedUser"))) {
				waitForAdToFinishInAmd();
			}
			registerPopUpClose();
			completeProfilePopUpClose(usertype);
			waitTime(6000);
			verifyElementPresentAndClick(AMDPlayerScreen.objPlayerScreen, "Player screen");
			verifyElementPresentAndClick(AMDPlayerScreen.objPauseIcon, "Pause icon");
			verifyElementPresentAndClick(AMDPlayerScreen.objFullscreenIcon, "Full screen icon");
			verifyElementPresentAndClick(AMDPlayerScreen.objPlayIcon, "Play icon");
			waitTime(4000);
	    }
	    
	    public void VideoWatchDurationEventForPremiumContentComplete(String usertype, String tabName) throws Exception {
	    	if (userType.equalsIgnoreCase("SubscribedUser")) {
				extent.HeaderChildNode("Video Watch Duration Event for premium content when user completely watches the content");
				waitTime(10000);
				SelectTopNavigationTab(tabName);
				Swipe("UP", 1);
				boolean var = false;
				for (int i = 0; i < 3; i++) {
					var = verifyIsElementDisplayed(AMDHomePage.objPremiumTag, "Premium Tag");
					if (var == true) {
						verifyElementPresentAndClick(AMDHomePage.objPremiumTag, "Premium content");
						verifyElementPresentAndClick(AMDPlayerScreen.objPauseIcon, "Pause icon");
						seekVideoTillLast(AMDPlayerScreen.objProgressBar);
						verifyElementPresentAndClick(AMDPlayerScreen.objPlayIcon, "Play icon");
						waitTime(4000);
						break;
					} else {
						Swipe("UP", 1);
					}
				}
				if (var == false) {
					logger.info("Premium content is not displayed in the screen");
					extentLoggerWarning("Premium Content", "Premium content is not displayed in the screen");
				}
			}
	    }
	    
	    public void seekVideoTillLast(By byLocator1) throws Exception {
			String beforeSeek = findElement(AMDPlayerScreen.objTimer).getText();
			logger.info("Current time before seeking : " + timeToSec(beforeSeek));
			extent.extentLogger("Seek", "Current time before seeking in seconds: " + timeToSec(beforeSeek));

			WebElement element = getDriver().findElement(byLocator1);
			Dimension size = element.getSize();
			int startx = (int) (size.width);
			int startX = startx + 180;
			System.out.println(startX);
			SwipeAnElement(element, startX, 0);

			waitTime(2000);
			String afterSeek = findElement(AMDPlayerScreen.objTimer).getText();
			logger.info("Current time after seeking in seconds : " + timeToSec(afterSeek));
			extent.extentLogger("Seek", "Current time after seeking in seconds : " + timeToSec(afterSeek));

			String totalDur = findElement(AMDPlayerScreen.objTotalDuration).getText();
			if (timeToSec(afterSeek) > (timeToSec(totalDur) - 120)) {
				logger.info("Seeked the video till last");
				extentLoggerPass("Seeking the video till last", "Seeked the video till last");
				logger.info("Seek bar is functional");
				extent.extentLogger("Seek", "Seek bar is functional");
			} else {
				logger.info("Not seeked the video till last");
				extentLoggerFail("Seeking the video till last", "Not seeked the video till last");
				logger.info("Seek bar is not functional");
				extent.extentLoggerFail("Seek", "Seek bar is not functional");
			}
		}
	    
	    public void VideoWatchDurationEventForTrailerContentComplete(String usertype, String keyword3) throws Exception {
	    	extent.HeaderChildNode("Video Watch Duration event for Trailer content when user completely watches the content");
	    	click(AMDSearchScreen.objSearchIcon, "Search icon");
	    	click(AMDSearchScreen.objSearchEditBox, "Search Box");
	    	type(AMDSearchScreen.objSearchBoxBar, keyword3 + "\n", "Search bar");
	    	hideKeyboard();
	    	waitTime(4000);
	    	waitForElementDisplayed(AMDSearchScreen.objAllTab, 10);
	    	click(AMDSearchScreen.objFirstContentInSearchResult, "Search result");
	    	if(usertype.equalsIgnoreCase("SubscribedUser")) {
	    		verifyElementPresentAndClick(AMDConsumptionScreen.objWatchTrialer, "Watch Trailer button");
	    	}
	    	verifyElementPresentAndClick(AMDPlayerScreen.objPauseIcon, "Pause icon");
	    	seekVideoTillLast(AMDPlayerScreen.objProgressBar);
			verifyElementPresentAndClick(AMDPlayerScreen.objPlayIcon, "Play icon");
	    	waitTime(5000);
	    }
	    
	    public void VideoWatchDurationEventForCarouselContentComplete(String tabName) throws Exception {
			extent.HeaderChildNode("Video Watch Duration Event for carousel content when user completely watches the content");
			waitTime(10000);
			SelectTopNavigationTab(tabName);
			verifyElementPresentAndClick(AMDHomePage.objCarouselConetentCard, "carousel content");
			waitForElementDisplayed(AMDPlayerScreen.objPlayer, 20);
			Boolean var = verifyIsElementDisplayed(AMDPlayerScreen.objPlayer);
			if (var == true) {
				logger.info("Player screen is displayed");
				extentLoggerPass("Player screen", "Player screen is displayed");
				waitTime(6000);
				verifyElementPresentAndClick(AMDPlayerScreen.objPlayerScreen, "Player screen");
				verifyElementPresentAndClick(AMDPlayerScreen.objPauseIcon, "Pause icon");
				seekVideoTillLast(AMDPlayerScreen.objProgressBar);
				verifyElementPresentAndClick(AMDPlayerScreen.objPlayIcon, "Play icon");
				waitTime(5000);
			} else if (verifyIsElementDisplayed(AMDPlayerScreen.objPremiumTextOnPlayer)) {
				logger.info("Player inline subscription link is displayed");
				extentLoggerPass("Player screen", "Player inline subscription link is displayed");
			}
		}
	    
	    public void VideoWatchDurationEventOfcontentFromSearchPageComplete(String usertype, String keyword4) throws Exception {
			extent.HeaderChildNode("Video Watch Duration Event of content from search page when user completely watches the content");
			click(AMDSearchScreen.objSearchIcon, "Search icon");
			click(AMDSearchScreen.objSearchEditBox, "Search Box");
			type(AMDSearchScreen.objSearchBoxBar, keyword4 + "\n", "Search bar");
			hideKeyboard();
			waitTime(4000);
			waitForElementDisplayed(AMDSearchScreen.objAllTab, 10);
			click(AMDSearchScreen.objFirstContentInSearchResult, "Search result");
			if (!(usertype.equalsIgnoreCase("SubscribedUser"))) {
				waitForAdToFinishInAmd();
			}
			registerPopUpClose();
			completeProfilePopUpClose(usertype);
			waitTime(6000);
			verifyElementPresentAndClick(AMDPlayerScreen.objPlayerScreen, "Player screen");
			verifyElementPresentAndClick(AMDPlayerScreen.objPauseIcon, "Pause icon");
			seekVideoTillLast(AMDPlayerScreen.objProgressBar);
			waitTime(4000);
		}
	    
	    public void VideoWatchDurationEventOfContentFromMyWatchListPageComplete(String usertype) throws Exception {
			if (!(usertype.equalsIgnoreCase("Guest"))) {
				extent.HeaderChildNode("Video Watch Duration Event of content from My WatchList page when user completely watches the content");
				click(AMDHomePage.objMoreMenu, "More menu");
				click(AMDMoreMenu.objWatchlist, "Watchlist option");
				click(AMDUserSessionManagement.objMoviesTabUnderWatchList, "Movies Tab");
				waitTime(5000);
				boolean contentsInMoviesTab = verifyIsElementDisplayed(AMDUserSessionManagement.objcontentTitleInWatchListAndReminders);
				if (contentsInMoviesTab == true) {
					getDriver()
							.findElement(By.xpath("(//*[@resource-id='com.graymatrix.did:id/txt_reminder_item_title'])[1]"))
							.click();
					waitTime(5000);
					waitForElementDisplayed(AMDPlayerScreen.objPlayer, 10);
					verifyElementPresentAndClick(AMDPlayerScreen.objPauseIcon, "Pause icon");
					seekVideoTillLast(AMDPlayerScreen.objProgressBar);
					verifyElementPresentAndClick(AMDPlayerScreen.objPlayIcon, "Play icon");
					waitTime(4000);
				} else {
					logger.info("No contents in Watchlist");
					extentLoggerWarning("Watchlist", "No contents in Watchlist");
				}
			}

		}
	    
	    public void VideoWatchDurationEventOfContentFromUpNextRailComplete(String usertype, String keyword4) throws Exception {
	    	extent.HeaderChildNode("Verify Video Watch Duration event of content from Upnext rail when user completely watches the content");
	    	click(AMDSearchScreen.objSearchIcon, "Search icon");
	    	click(AMDSearchScreen.objSearchEditBox, "Search Box");
	    	type(AMDSearchScreen.objSearchBoxBar, keyword4 + "\n", "Search bar");
	    	hideKeyboard();
	    	waitTime(4000);
	    	waitForElementDisplayed(AMDSearchScreen.objAllTab, 10);
	    	click(AMDSearchScreen.objFirstContentInSearchResult, "Search result");
	    	waitTime(8000);
	    	Swipe("UP", 1);
			if (verifyElementDisplayed(AMDPlayerScreen.objFirstContentCardTitleInUpnextTray)) {
				verifyElementPresentAndClick(AMDPlayerScreen.objFirstContentCardTitleInUpnextTray, "Upnext rail content");
			}
			if (!(usertype.equalsIgnoreCase("SubscribedUser"))) {
				waitForAdToFinishInAmd();
			}
			registerPopUpClose();
			completeProfilePopUpClose(usertype);
			waitTime(6000);
			verifyElementPresentAndClick(AMDPlayerScreen.objPlayerScreen, "Player screen");
			verifyElementPresentAndClick(AMDPlayerScreen.objPauseIcon, "Pause icon");
			seekVideoTillLast(AMDPlayerScreen.objProgressBar);
			waitTime(4000);
	    }
	    
	    public void VideoWatchDurationEventForPremiumContentAbrupt(String usertype, String tabName) throws Exception {
			if (userType.equalsIgnoreCase("SubscribedUser")) {
				extent.HeaderChildNode("Verify Video Watch Duration event of Premium content when video closed abruptly");
				waitTime(10000);
				SelectTopNavigationTab(tabName);
				Swipe("UP", 1);
				boolean var = false;
				for (int i = 0; i < 3; i++) {
					var = verifyIsElementDisplayed(AMDHomePage.objPremiumTag, "Premium Tag");
					if (var == true) {
						verifyElementPresentAndClick(AMDHomePage.objPremiumTag, "Premium content");
						verifyIsElementDisplayed(AMDPlayerScreen.objPlayer, "Player screen");
						waitTime(10000);
						Back(1);
						break;
					} else {
						Swipe("UP", 1);
					}
				}
				if (var == false) {
					logger.info("Premium content is not displayed in the screen");
					extentLoggerWarning("Premium Content", "Premium content is not displayed in the screen");
				}
			}
		}
	    
	    public void VideoWatchDurationEventForTrailerContentAbrupt(String usertype, String keyword3) throws Exception {
	    	extent.HeaderChildNode("Verify Video Watch Duration event for Trailer content when video closed abruptly");
	    	click(AMDSearchScreen.objSearchIcon, "Search icon");
	    	click(AMDSearchScreen.objSearchEditBox, "Search Box");
	    	type(AMDSearchScreen.objSearchBoxBar, keyword3 + "\n", "Search bar");
	    	hideKeyboard();
	    	waitTime(4000);
	    	waitForElementDisplayed(AMDSearchScreen.objAllTab, 10);
	    	click(AMDSearchScreen.objFirstContentInSearchResult, "Search result");
	    	waitForElementDisplayed(AMDPlayerScreen.objPlayer, 10);
	    	verifyIsElementDisplayed(AMDPlayerScreen.objPlayer);
	    	if(usertype.equalsIgnoreCase("SubscribedUser")) {
	    		verifyElementPresentAndClick(AMDConsumptionScreen.objWatchTrialer, "Watch Trailer button");
	    		Back(1);
	    	}
	    	waitTime(5000);
	    	Back(1);
	    }
	    
	    public void VideoWatchDurationEventForCarouselContentAbrupt(String tabName) throws Exception {
			extent.HeaderChildNode("Video Watch Duration Event for carousel content when video closed abruptly");
			waitTime(10000);
			SelectTopNavigationTab(tabName);
			verifyElementPresentAndClick(AMDHomePage.objCarouselConetentCard, "carousel content");
			waitForElementDisplayed(AMDPlayerScreen.objPlayer, 20);
			Boolean var = verifyIsElementDisplayed(AMDPlayerScreen.objPlayer);
			if (var == true) {
				logger.info("Player screen is displayed");
				extentLoggerPass("Player screen", "Player screen is displayed");
			} else if (verifyIsElementDisplayed(AMDPlayerScreen.objPremiumTextOnPlayer)) {
				logger.info("Player inline subscription link is displayed");
				extentLoggerPass("Player screen", "Player inline subscription link is displayed");
			}
			Back(1);
		}
	    
	    public void VideoWatchDurationEventOfcontentFromSearchPageAbrupt(String usertype, String keyword4) throws Exception {
			extent.HeaderChildNode("Video Watch Duration Event of content from search page when video closed abruptly");
			click(AMDSearchScreen.objSearchIcon, "Search icon");
			click(AMDSearchScreen.objSearchEditBox, "Search Box");
			type(AMDSearchScreen.objSearchBoxBar, keyword4 + "\n", "Search bar");
			hideKeyboard();
			waitTime(4000);
			waitForElementDisplayed(AMDSearchScreen.objAllTab, 10);
			click(AMDSearchScreen.objFirstContentInSearchResult, "Search result");
			if (!(usertype.equalsIgnoreCase("SubscribedUser"))) {
				waitForAdToFinishInAmd();
			}
			registerPopUpClose();
			completeProfilePopUpClose(usertype);
			waitTime(6000);
			verifyElementPresentAndClick(AMDPlayerScreen.objPlayerScreen, "Player screen");
			verifyElementPresentAndClick(AMDPlayerScreen.objPauseIcon, "Pause icon");
			verifyElementPresentAndClick(AMDPlayerScreen.objFullscreenIcon, "Full screen icon");
			verifyElementPresentAndClick(AMDPlayerScreen.objPlayIcon, "Play icon");
			waitTime(4000);
			Back(2);
		}
	    
	    public void VideoWatchDurationEventOfContentFromMyWatchListPageAbrupt(String usertype) throws Exception {
			if (!(usertype.equalsIgnoreCase("Guest"))) {
				extent.HeaderChildNode("Video Watch Duration Event of content from My WatchList page when video closed abruptly");
				click(AMDHomePage.objMoreMenu, "More menu");
				click(AMDMoreMenu.objWatchlist, "Watchlist option");
				click(AMDUserSessionManagement.objMoviesTabUnderWatchList, "Movies Tab");
				waitTime(5000);
				boolean contentsInMoviesTab = verifyIsElementDisplayed(AMDUserSessionManagement.objcontentTitleInWatchListAndReminders);
				if (contentsInMoviesTab == true) {
					getDriver()
							.findElement(By.xpath("(//*[@resource-id='com.graymatrix.did:id/txt_reminder_item_title'])[1]"))
							.click();
					waitTime(5000);
					verifyIsElementDisplayed(AMDPlayerScreen.objPlayer, "Player screen");
					Back(3);
				} else {
					logger.info("No contents in Watchlist");
					extentLoggerWarning("Watchlist", "No contents in Watchlist");
					Back(2);
				}
			}

		}
	    
	    public void VideoWatchDurationEventOfContentFromUpNextRailAbrupt(String usertype, String keyword4) throws Exception {
	    	extent.HeaderChildNode("Verify Video Watch Duration event of content from Upnext rail  when video closed abruptly");
	    	click(AMDSearchScreen.objSearchIcon, "Search icon");
	    	click(AMDSearchScreen.objSearchEditBox, "Search Box");
	    	type(AMDSearchScreen.objSearchBoxBar, keyword4 + "\n", "Search bar");
	    	hideKeyboard();
	    	waitTime(4000);
	    	waitForElementDisplayed(AMDSearchScreen.objAllTab, 10);
	    	click(AMDSearchScreen.objFirstContentInSearchResult, "Search result");
	    	waitTime(8000);
	    	Swipe("UP", 1);
			if (verifyElementDisplayed(AMDPlayerScreen.objFirstContentCardTitleInUpnextTray)) {
				verifyElementPresentAndClick(AMDPlayerScreen.objFirstContentCardTitleInUpnextTray, "Upnext rail content");
			}
			if (!(usertype.equalsIgnoreCase("SubscribedUser"))) {
				waitForAdToFinishInAmd();
			}
			registerPopUpClose();
			completeProfilePopUpClose(usertype);
			waitTime(6000);
			verifyElementPresentAndClick(AMDPlayerScreen.objPlayerScreen, "Player screen");
			verifyIsElementDisplayed(AMDPlayerScreen.objPlayer);
			Back(2);
	    }

}
