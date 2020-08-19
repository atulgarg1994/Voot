package com.business.zee;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import com.deviceDetails.DeviceDetails;
import com.driverInstance.CommandBase;
import com.emailReport.GmailInbox;
import com.extent.ExtentReporter;
import com.jayway.restassured.response.Response;
import com.metadata.ResponseInstance;
import com.propertyfilereader.PropertyFileReader;
import com.utility.Utilities;
import com.zee5.ApplicasterPages.*;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Zee5ApplicasterBusinessLogic extends Utilities {

	public Zee5ApplicasterBusinessLogic(String Application) {
		new CommandBase(Application);
		init();
	}

	private int timeout;

	/** Retry Count */
	private int retryCount;
	ExtentReporter extent = new ExtentReporter();

	/** The Constant logger. */
	final static Logger logger = Logger.getLogger("rootLogger");

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

	public void init() {

		PropertyFileReader handler = new PropertyFileReader("properties/Execution.properties");
		setTimeout(Integer.parseInt(handler.getproperty("TIMEOUT")));
		setRetryCount(Integer.parseInt(handler.getproperty("RETRY_COUNT")));
//		logger.info("Loaded the following properties" + " TimeOut :" + getTimeout() + " RetryCount :" + getRetryCount());
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
	}

	/**
	 * Function to quit the driver
	 */
	public void tearDown() {
		getDriver().quit();
	}

	String pUserType = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("userType");
	String RegisteredEmail = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
			.getParameter("RegisteredEmail");
	String RegisteredEmailPassword = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
			.getParameter("RegisteredEmailPassword");
	String UnRegisteredMobile = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
			.getParameter("UnRegisteredMobile");
	String RegisteredMobile = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
			.getParameter("RegisteredMobile");
	String RegisteredMobilePassword = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
			.getParameter("RegisteredMobilePassword");
	String PromoCode = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("PromoCode");
	String NonsubscribedUserName = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
			.getParameter("NonsubscribedUserName");
	String NonsubscribedPassword = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
			.getParameter("NonsubscribedPassword");
	String SubscribedUserName = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
			.getParameter("SubscribedUserName");
	String SubscribedPassword = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
			.getParameter("SubscribedPassword");
	String FirstName = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("FirstName");
	String LastName = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("LastName");

	String RSVODUser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("RSVODUser");
	String RSVODPassword = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
			.getParameter("RSVODPassword");

	String content1 = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
			.getParameter("searchcontent1");
	String content2 = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
			.getParameter("searchcontent2");
	String content3 = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
			.getParameter("searchcontent3");
	String content4 = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
			.getParameter("searchcontent4");
	String content5 = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
			.getParameter("searchcontent5");
	String content6 = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
			.getParameter("searchcontent6");
	String pVideoQuality = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
			.getParameter("VideoQuality");
	String pMovie = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("MovieName");

	// Retrieve the Mobile Device Name
	String getOEMName = DeviceDetails.OEM;

	public void accessDeviceLocationPopUp(String permission, String userType) throws Exception {
		extent.HeaderChildNode("Access Device Location PopUp");
		extent.extentLogger("User Type", "UserType : " + userType);
		logger.info("UserType : " + userType);
		System.out.println("Access Device Location PopUp");
		if (verifyElementExist(AMDOnboardingScreen.objAllowBtn, "Device Location Permision")) {
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

	/*
	 * =============================================================================
	 * ===== ------------------------------ Script Author: SHREE NIDHI
	 * -------------------------------
	 * 
	 * List of Functions Created - contentLanguage(String userType) -
	 * mobileRegistration(String loginThrough) - subscribeNowSceanrios() -
	 * unRegisteredEmailSubscribe() - subscribeFLowMobileNumber() -
	 * passwordScenario(String UserType) - otpScenarios() -
	 * checkScreenAfterRelaunch(String userType, String ScreenName)
	 * =============================================================================
	 * ========
	 */

	public void contentLanguage(String userType) throws Exception {
		extent.HeaderChildNode("Content language screen functionlity");
		extent.extentLogger("User Type", "UserType : " + userType);
		logger.info("UserType : " + userType);
		verifyElementPresentAndClick(AMDOnboardingScreen.objDiplay_ContinueBtn, "Continue button in display language");
		verifyElementExist(AMDOnboardingScreen.objScreenTitle, "Screen header");
		verifyElementExist(AMDOnboardingScreen.objContentLanguagePageTitle, "Page title");
		verifyElementExist(AMDOnboardingScreen.objContentLanguageContainer, "Content language");
		verifyElementExist(AMDOnboardingScreen.objContent_ContinueBtn, "Continue button in content language screen");
		verifyElementExist(AMDOnboardingScreen.objBackBtn, "Back button in content language screen");
		click(AMDOnboardingScreen.objSelectContentLang("English"), "Unselected English language");
		click(AMDOnboardingScreen.objContent_ContinueBtn, "Continue button in content language screen");
		waitTime(3000);
		if (verifyElementExist(AMDOnboardingScreen.objLoginLnk, "Login button")) {
			logger.info("User is navigated to intro screen");
			extent.extentLogger("Navigation", "user is navigated to intro screen");
			Back(1);
		}
		PartialSwipe("UP", 1);
		click(AMDOnboardingScreen.objSelectContentLang("Kannada"), "Unselected Kannada language");
		PartialSwipe("UP", 1);
		if (verifyElementExist(AMDOnboardingScreen.objSelectContentLang("Malayalam"), "Malayalam language")) {
			click(AMDOnboardingScreen.objSelectContentLang("Malayalam"), "Malayalam language");
			logger.info("Clicked on malayalam language");
			click(AMDOnboardingScreen.objContent_ContinueBtn, "Continue button in content language screen");
		} else {
			Swipe("UP", 1);
			verifyElementExist(AMDOnboardingScreen.objSelectContentLang("Malayalam"), "Malayalam language");
			click(AMDOnboardingScreen.objSelectContentLang("Malayalam"), "Malayalam language");
			logger.info("Clicked on malayalam language");
			click(AMDOnboardingScreen.objContent_ContinueBtn, "Continue button in content language screen");
		}
		waitTime(2000);
		String ContentLanguagetitle = getText(AMDOnboardingScreen.objContentLanguagePageTitle);
		logger.info(ContentLanguagetitle);
		if (ContentLanguagetitle.contains("please select at least one more language")) {
			logger.info("Select atleast one language screen is displayed");
			extent.extentLogger("Screen", "Select atleast one language screen is displayed");
		}

		verifyElementExist(AMDOnboardingScreen.objSelectContentLang("Hindi"), "Hindi language");
		verifyElementExist(AMDOnboardingScreen.objSelectContentLang("English"), "English language");
		verifyElementExist(AMDOnboardingScreen.objSelectContentLang("Marathi"), "Marathi language");
		verifyElementExist(AMDOnboardingScreen.objSelectContentLang("Telugu"), "Telugu language");
		Swipe("UP", 1);
		verifyElementExist(AMDOnboardingScreen.objSelectContentLang("Kannada"), "Kannada language");
		verifyElementExist(AMDOnboardingScreen.objSelectContentLang("Tamil"), "Tamil language");
		Swipe("UP", 1);
		verifyElementExist(AMDOnboardingScreen.objSelectContentLang("Bengali"), "Bengali language");
		verifyElementExist(AMDOnboardingScreen.objBackBtn, "Back button in content language screen");

		click(AMDOnboardingScreen.objSelectContentLang("Kannada"), "Kannada language");
		verifyElementPresentAndClick(AMDOnboardingScreen.objContent_ContinueBtn,
				"Continue button in content language screen");
		waitTime(2000);
		if (verifyElementExist(AMDOnboardingScreen.objLoginLnk, "Login button")) {
			logger.info("User is navigated to intro screen");
			extent.extentLogger("Navigation", "user is navigated to intro screen");
		}
	}

	public void mobileRegistration(String loginThrough) throws Exception {
		extent.HeaderChildNode("Mobile Registration From Intro screen loginlink");
		verifyElementPresentAndClick(AMDOnboardingScreen.objDiplay_ContinueBtn, "Continue button");
		verifyElementPresentAndClick(AMDOnboardingScreen.objContent_ContinueBtn,
				"Continue button in content language screen");
		navigateToRegisterScreen(loginThrough);
		verifyElementPresentAndClick(AMDLoginScreen.objEmailIdField, "EmailField");
		type(AMDLoginScreen.objEmailIdField, UnRegisteredMobile, "Mobile");
		hideKeyboard();
		click(AMDLoginScreen.objProceedBtn, "Proceed icon");
		registerForFreeScreen("Mobile");
		waitTime(3000);
		otpScenarios();
		Back(1);
		waitTime(3000);
		hideKeyboard();
		Back(1);
		int lenText = findElement(AMDLoginScreen.objEmailIdField).getAttribute("value").length();
		for (int i = 0; i < lenText; i++) {
			getDriver().findElement(AMDLoginScreen.objEmailIdField).sendKeys(Keys.BACK_SPACE);
		}
		type(AMDLoginScreen.objEmailIdField, RegisteredMobile, "Mobile number field");
		verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed button");
		type(AMDLoginScreen.objPasswordField, RegisteredMobilePassword, "Password field");
		verifyElementPresentAndClick(AMDLoginScreen.objLoginBtn, "Login button");
		verifyElementExist(AMDHomePage.objHomeTab, "Home tab");
		verifyElementPresentAndClick(AMDHomePage.objMoreMenu, "More Menu");
		Swipe("UP", 1);
		verifyElementPresentAndClick(AMDHomePage.objLogout, "Logout");
		verifyElementPresentAndClick(AMDHomePage.objLogoutPopUpLogoutButton, "Logout button");
		verifyElementPresentAndClick(AMDHomePage.objHome, "Home tab");
	}

	public void subscribeNowSceanrios(String userType) throws Exception {
		extent.HeaderChildNode("SubscribeNow Functionality for Registered email-id");

		verifyElementPresentAndClick(AMDOnboardingScreen.objDiplay_ContinueBtn, "Continue button");
		verifyElementPresentAndClick(AMDOnboardingScreen.objContent_ContinueBtn,
				"Continue button in content language screen");
		if (userType.equals("Guest")) {
			verifyElementPresentAndClick(AMDOnboardingScreen.objSubscribeNowBtn, "Subscribe now button");
			subscribePageValidation();
			passwordScenario("Registered");
			unRegisteredEmailSubscribe();
			subscribeFLowMobileNumber();
		}
		if (userType.equals("NonSubscribedUser")) {
			verifyElementPresentAndClick(AMDOnboardingScreen.objLoginLnk, "Login button");
			click(AMDLoginScreen.objEmailIdField, "Email field");
			verifyElementExist(AMDLoginScreen.objEmailIdField, "Email field");
			type(AMDLoginScreen.objEmailIdField, NonsubscribedUserName, "Email field");
			hideKeyboard();
			verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed button");
			waitTime(2000);
			type(AMDLoginScreen.objPasswordField, NonsubscribedPassword, "Password field");
			verifyElementPresentAndClick(AMDLoginScreen.objLoginBtn, "Login button");
			verifyElementExist(AMDHomePage.objHomeTab, "Home tab");
			relaunch(false);
			waitTime(2000);
			if (verifyElementExist(AMDHomePage.objHomeTab, "Home tab")) {
				logger.info(
						"When " + userType + " relaunch the app Display/Content language and Intro screen is skipped");
				extent.extentLogger("Relaunch",
						"When " + userType + " relaunch the app Display/Content language and Intro screen is skipped");
			}

		}
		if (userType.equals("SubscribedUser")) {
			verifyElementPresentAndClick(AMDOnboardingScreen.objLoginLnk, "Login button");
			click(AMDLoginScreen.objEmailIdField, "Email field");
			verifyElementExist(AMDLoginScreen.objEmailIdField, "Email field");
			type(AMDLoginScreen.objEmailIdField, SubscribedUserName, "Email field");
			hideKeyboard();
			verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed button");
			waitTime(2000);
			type(AMDLoginScreen.objPasswordField, SubscribedPassword, "Password field");
			verifyElementPresentAndClick(AMDLoginScreen.objLoginBtn, "Login button");
			verifyElementExist(AMDHomePage.objHomeTab, "Home tab");
			relaunch(false);
			waitTime(2000);
			if (verifyElementExist(AMDHomePage.objHomeTab, "Home tab")) {
				logger.info(
						"When " + userType + " relaunch the app Display/Content language and Intro screen is skipped");
				extent.extentLogger("Relaunch",
						"When " + userType + " relaunch the app Display/Content language and Intro screen is skipped");
			}
		}

	}

	public void unRegisteredEmailSubscribe() throws Exception {
		extent.HeaderChildNode("SubscribeNow Functionality for UnRegistered email-id");
		System.out.println("\nSubscribeNow Functionality for UnRegistered email-id");
		verifyElementExist(AMDSubscibeScreen.objSubscribeHeader, "Subscribe header in subscription page");
		verifyElementExist(AMDSubscibeScreen.objSubscribePageBackButton, "Back button in subscribe page");
		verifyElementExist(AMDSubscibeScreen.objAdbanner, "Carosual in subscription page");
		verifyElementExist(AMDSubscibeScreen.objApplyPromoCodeTextbox, "Promo code in subscribe page");
		verifyElementPresent(AMDSubscibeScreen.objApply, "Apply button is subscribe page");
		Swipe("UP", 3);
		click(AMDSubscibeScreen.objContinueBtn, "Continue button");
		verifyElementExist(AMDSubscibeScreen.objAccountInfoHeader, "Account info screen");
		hideKeyboard(); // Added by Kushal
		verifyElementExist(AMDSubscibeScreen.objSubscribeHeader, "Subscribe header");
		click(AMDSubscibeScreen.objEmailID, "Email id");
		type(AMDSubscibeScreen.objEmailID, RandomStringGenerator(5) + "@gmail.com", "Email");
		hideKeyboard();
		click(AMDSubscibeScreen.objProceedBtn, "Proceed button");
		passwordScenario("UnRegistered");

	}

	public void subscribeFLowMobileNumber() throws Exception {
		extent.HeaderChildNode("SubscribeNow Functionality for UnRegistered Mobile number");
		System.out.println("\nSubscribeNow Functionality for UnRegistered Mobile number");
		verifyElementExist(AMDSubscibeScreen.objSubscribeHeader, "Subscribe header in subscription page");
		verifyElementExist(AMDSubscibeScreen.objSubscribePageBackButton, "Back button in subscribe page");
		closeInterstitialAd(AMDGenericObjects.objCloseInterstitialAd, 2000); // INTERSTITIAL AD - HANDLED HERE
		verifyElementExist(AMDSubscibeScreen.objAdbanner, "Carosual in subscription page");
		verifyElementExist(AMDSubscibeScreen.objApplyPromoCodeTextbox, "Promo code in subscribe page");
		verifyElementPresent(AMDSubscibeScreen.objApply, "Apply button is subscribe page");
		PartialSwipe("UP", 4);
		click(AMDSubscibeScreen.objContinueBtn, "Continue button");
		verifyElementExist(AMDSubscibeScreen.objAccountInfoHeader, "Account info screen");
		hideKeyboard();
		verifyElementExist(AMDSubscibeScreen.objSubscribeHeader, "Subscribe header");
		click(AMDSubscibeScreen.objEmailID, "Email id");
		type(AMDSubscibeScreen.objEmailID, UnRegisteredMobile, "Email");
		hideKeyboard();
		click(AMDSubscibeScreen.objProceedBtn, "Proceed button");
		verifyElementExist(AMDSubscibeScreen.objVerifyOTPScreen, "OTP screen");
		type(AMDRegistrationScreen.objOTPField1, "1", "OTP box1");
		type(AMDRegistrationScreen.objOTPField2, "1", "OTP box2");

		click(AMDRegistrationScreen.objOTPField3, "OTP field 3");
		// Added a generic object to handle the numeric keyboard across various devices
//		if (verifyElementExist(AMDRegistrationScreen.objNumericKeys, "Numeric Keypad")) {
//			logger.info("Numeric keyboard is displayed in OTP screen");
//			extent.extentLogger("Numeric", "Numeric keyboard is displayed in OTP screen");
//		}
		type(AMDRegistrationScreen.objOTPField3, "1", "OTP box3");
		type(AMDRegistrationScreen.objOTPField4, "1", "OTP box4");

		hideKeyboard();
		waitTime(2000);
		if (findElement(AMDSubscibeScreen.objVerifyOTPScreenProceed).isEnabled() == true) {
			logger.info("Verify Button is highlighted");
			extent.extentLogger("Verify", "Verify Button is highlighted");
		}
		Back(1);

		extent.HeaderChildNode("SubscribeNow Functionality for Registered Mobile number");
		int lenText = findElement(AMDLoginScreen.objEmailIdField).getAttribute("value").length();
		for (int i = 0; i < lenText; i++) {
			getDriver().findElement(AMDLoginScreen.objEmailIdField).sendKeys(Keys.BACK_SPACE);
		}
		click(AMDSubscibeScreen.objEmailID, "Email");
		type(AMDSubscibeScreen.objEmailID, RegisteredMobile, "Email");

		hideKeyboard();
		click(AMDSubscibeScreen.objProceedBtn, "Proceed button");
		verifyElementExist(AMDSubscibeScreen.objEnterPassword, "Enter Password PopUp");
		verifyElementExist(AMDSubscibeScreen.objPasswordTextField, "Password field");
		verifyElementPresentAndClick(AMDSubscibeScreen.objGetOTP, "Get OTP");
		verifyElementExist(AMDSubscibeScreen.objVerifyOTPScreen, "OTP screen");

		type(AMDRegistrationScreen.objOTPField1, "1", "OTP box1");
		type(AMDRegistrationScreen.objOTPField2, "1", "OTP box2");

		// Added a generic object to handle the numeric keyboard across various devices
		click(AMDRegistrationScreen.objOTPField3, "OTP field 3");
//		if (verifyElementExist(AMDRegistrationScreen.objNumericKeys, "Numeric Keypad")) {
//			logger.info("Numeric keyboard is displayed in OTP screen");
//			extent.extentLogger("Numeric", "Numeric keyboard is displayed in OTP screen");
//		}
		type(AMDRegistrationScreen.objOTPField3, "1", "OTP box3");
		type(AMDRegistrationScreen.objOTPField4, "1", "OTP box4");

		hideKeyboard();
		waitTime(2000);
		if (findElement(AMDSubscibeScreen.objVerifyOTPScreenProceed).isEnabled() == true) {
			logger.info("Verify Button is highlighted");
			extent.extentLogger("Verify", "Verify Button is highlighted");
		}
		Back(1);
		click(AMDSubscibeScreen.objProceedBtn, "Proceed button");
		passwordScenario("Registered");
		Wait(2000);
		Back(1);
		closeInterstitialAd(AMDGenericObjects.objCloseInterstitialAd, 2000); // INTERSTITIAL AD - HANDLED HERE
	}

	public void closeInterstitialAd(By byLocator, int iTimeOut) throws Exception {
		try {

			if (checkcondition(byLocator)) {
				click(byLocator, "Interstitial Ad_Close button");
			}

		} catch (NoSuchElementException e) {
			System.out.println(e);
		}
	}

	public void passwordScenario(String UserType) throws Exception {

		System.out.println("\nPassword Scenario");
		verifyElementExist(AMDSubscibeScreen.objPasswordTextField, "Password field");
		click(AMDSubscibeScreen.objPasswordTextField, "Password");
		type(AMDSubscibeScreen.objPasswordTextField, "User", "Password field");
		hideKeyboard();
		System.out.println("DEVICE NAME : " + getOEMName);
		if (getOEMName.contains("vivo")) {
			hidePwdKeyboard();
		}
		verifyElementExist(AMDSubscibeScreen.objPasswordErrorMessage, "Error message");
		if (verifyElementExist(AMDSubscibeScreen.objPasswordHidden, "Toggle icon")) {
			logger.info("Passowrd is not shown");
			extent.extentLogger("password", "Passowrd is not shown");
		}
		click(AMDSubscibeScreen.objShowIcon, "Toggle password icon");
		if (verifyElementExist(AMDSubscibeScreen.objPasswordDisplayed, "Toggle icon")) {
			logger.info("Passowrd is shown after clicking on toggle passowrd icon");
			extent.extentLogger("password", "Passowrd is shown after clicking on toggle passowrd icon");
		}
		click(AMDSubscibeScreen.objShowIcon, "Toggle password icon");
		if (UserType == "Registered") {
			verifyElementExist(AMDSubscibeScreen.objForgotPassword, "forgot password");
			Wait(1000);
			click(AMDSubscibeScreen.objForgotPassword, "forgot password");
			verifyElementExist(AMDSubscibeScreen.objForgotPasswordPageHeader, "Forgot password page");
			Back(1);
			click(AMDSubscibeScreen.objProceedBtn, "Proceed button");
		}
		if (UserType == "UnRegistered") {
			logger.info("Forgot password is not displayed for unregistered user");
			verifyElementExist(AMDSubscibeScreen.objTermsandPrivacyLink, "Terms and privacy links");
		}
		verifyElementExist(AMDSubscibeScreen.objPasswordTextField, "Password field");
		click(AMDSubscibeScreen.objPasswordTextField, "Password");
		type(AMDSubscibeScreen.objPasswordTextField, RegisteredMobilePassword, "Password field");
		hideKeyboard();
		System.out.println("DEVICE NAME : " + getOEMName);
		if (getOEMName.contains("vivo")) {
			hidePwdKeyboard();
		}
		verifyElementPresentAndClick(AMDSubscibeScreen.objProceedPWDScreen, "Proceed button in password popup");
		waitTime(3000);
		PartialSwipe("DOWN", 3);
		verifyElementExist(AMDSubscibeScreen.objPaymentText, "Payment page");
		verifyElementExist(AMDSubscibeScreen.objSubscribeHeader, "Subscribe header in Payment page");
		verifyElementExist(AMDSubscibeScreen.objSubscribePageBackButton, "Back button in Payment page");
		Back(2);
		verifyElementPresentAndClick(AMDHomePage.objMoreMenu, "More Menu");
		Swipe("UP", 2);
		verifyElementPresentAndClick(AMDHomePage.objLogout, "Logout");
		verifyElementPresentAndClick(AMDHomePage.objLogoutPopUpLogoutButton, "Logout button");
		verifyElementPresentAndClick(AMDHomePage.objHome, "Home tab");
		verifyElementPresentAndClick(AMDHomePage.objSubscribeTeaser, "Subscribe tab");
	}

	public void otpScenarios() throws Exception {
		verifyElementExist(AMDRegistrationScreen.objOTPScreen, "OTP screen");
		verifyElementExist(AMDRegistrationScreen.objOTPTimer, "OTP timer");
		String OTPTimer1 = getText(AMDRegistrationScreen.objOTPTimer);
		logger.info(OTPTimer1);
		click(AMDRegistrationScreen.objVerifyOtpButton, "Verify button");
		waitTime(10000);
		String OTPTimer2 = getText(AMDRegistrationScreen.objOTPTimer);
		logger.info(OTPTimer2);
		boolean Time = OTPTimer1.equals(OTPTimer2);
		if (Time == false) {
			logger.info("The Otp timer is in reverse order");
			extentLogger("OtpTimer", "The Otp timer is in reverse order");
		}

		type(AMDRegistrationScreen.objOTPField1, "1", "OTP box1");
		type(AMDRegistrationScreen.objOTPField2, "1", "OTP box2");
		if (verifyElementExist(AMDRegistrationScreen.objNumericKeyBoard, "Alphakeyboard")) {
			logger.info("Numeric keyboard is displayed in OTP screen");
			extent.extentLogger("Numeric", "Numeric keyboard is displayed in OTP screen");
		}
		type(AMDRegistrationScreen.objOTPField3, "1", "OTP box3");
		type(AMDRegistrationScreen.objOTPField4, "1", "OTP box4");
		hideKeyboard();
		waitTime(2000);
		if (findElement(AMDRegistrationScreen.objVerifyOtpButton).isEnabled() == true) {
			logger.info("Verify Button is highlighted");
			extent.extentLogger("Verify", "Verify Button is highlighted");
		}
	}

	public void checkScreenAfterRelaunch(String userType, String ScreenName) throws Exception {
		extent.HeaderChildNode("Validating that" + ScreenName + "is not present when app is relaunched");
		verifyElementPresentAndClick(AMDOnboardingScreen.objDiplay_ContinueBtn, "Continue");
		verifyElementPresentAndClick(AMDOnboardingScreen.objContent_ContinueBtn, "Continue");

		verifyElementPresentAndClick(AMDOnboardingScreen.objLoginLnk, "Login button");
		click(AMDLoginScreen.objEmailIdField, "Email field");
		verifyElementExist(AMDLoginScreen.objEmailIdField, "Email field");

		if (userType.equals("NonSubscribedUser")) {
			type(AMDLoginScreen.objEmailIdField, NonsubscribedUserName, "Email field");
			hideKeyboard();
			verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed button");
			waitTime(2000);
			type(AMDLoginScreen.objPasswordField, NonsubscribedPassword, "Password field");
		} else if (userType.equals("SubscribedUser")) {
			type(AMDLoginScreen.objEmailIdField, SubscribedUserName, "Email field");
			hideKeyboard();
			verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed button");
			waitTime(2000);
			type(AMDLoginScreen.objPasswordField, SubscribedPassword, "Password field");
		}

		if (userType.equalsIgnoreCase("Guest")) {
			verifyElementPresentAndClick(AMDLoginScreen.objSkipBtn, "Skip button");
		} else {
			verifyElementPresentAndClick(AMDLoginScreen.objLoginBtn, "Login button");
		}

		verifyElementExist(AMDHomePage.objHomeTab, "Home tab");
		relaunch(false);
		waitTime(2000);

		if (userType.contains("Guest")) {
			if (verifyElementExist(AMDOnboardingScreen.objBrowseForFreeBtn, "Intro Screen")) {
				logger.info("When " + userType + " relaunch the app " + ScreenName + " is skipped");
				extent.extentLogger("Relaunch", "When" + userType + " relaunch the app" + ScreenName + " is skipped");
			} else {
				logger.error("When " + userType + " relaunch the app " + ScreenName + " is displayed");
				extent.extentLoggerFail("Relaunch",
						"When" + userType + " relaunch the app" + ScreenName + " is displayed");
			}
		} else if (verifyElementExist(AMDHomePage.objHomeTab, "Home tab")) {
			logger.info("When " + userType + " relaunch the app Display/Content language and Intro screen is skipped");
			extent.extentLogger("Relaunch",
					"When " + userType + " relaunch the app Display/Content language and Intro screen is skipped");
		} else {
			logger.error("When " + userType + " relaunch the app user is not redirected to Home page");
			extent.extentLoggerFail("Relaunch",
					"When " + userType + " relaunch the app user is not redirected to Home page");
		}
	}

	public void registerForFreeScreen(String user) throws Exception {
		extent.HeaderChildNode("Register for free Page");
		if (user.equals("Email")) {
			type(AMDRegistrationScreen.objEmailIDTextField, generateRandomString(5) + "@gmail.com", "Email field");
			verifyElementPresentAndClick(AMDRegistrationScreen.objProceedBtn, "Proceed button");
		} else if (user.equals("Mobile")) {
			logger.info("Mobile registration");
		}
		verifyElementExist(AMDRegistrationScreen.objScreenTitle, "Register for free title");
		type(AMDRegistrationScreen.objFirstNameTxtField, FirstName, "First name field");
		hideKeyboard();
		type(AMDRegistrationScreen.objLastNameTxtField, LastName, "Last name field");
		hideKeyboard();
		click(AMDRegistrationScreen.objDOBTxtField, "calender field");
		verifyElementPresent(AMDRegistrationScreen.objSelecteDOBPopup, "calender selection popup");
		verifyElementPresentAndClick(AMDRegistrationScreen.objDateSelection, "Date in calender popup");
		click(AMDRegistrationScreen.objOkButtonInCalenderPopUp, "Ok button");
		verifyElementPresentAndClick(AMDRegistrationScreen.objGederTxtField, "Gender field");
		verifyElementPresentAndClick(AMDRegistrationScreen.objMale, "Gender male");
		click(AMDRegistrationScreen.objPasswordTxtField, "Passowrd");
		type(AMDRegistrationScreen.objPasswordTxtField, "User@123", "Password field");
		click(AMDRegistrationScreen.objFirstNameTxtField, "First name"); // Clicking on First Name field to get device
																			// keyboard
		hideKeyboard();
		verifyElementPresentAndClick(AMDRegistrationScreen.objRegisterBtn, "Register button");
		if (user.equals("Email")) {
			verifyElementExist(AMDHomePage.objHomeTab, "Home Screen");
		} else if (user.equals("Mobile")) {
			logger.info("Mobile registration");
		} else {
			logger.info("Prepaid PopUp after registration");
		}
	}

	public void subscribeEntryPointsValidations(String userType) throws Exception {
		HeaderChildNode("Entry points");
		click(AMDOnboardingScreen.objDiplay_ContinueBtn, "Display continue");
		click(AMDOnboardingScreen.objContent_ContinueBtn, " Content Continue");
		click(AMDOnboardingScreen.objBrowseForFreeBtn, "Browse for free");
		if (userType.equals("Guest")) {
			hideKeyboard();
			click(AMDLoginScreen.objSkipButton, "Skip button");
			waitTime(10000);
//			closeInterstitialAd(AMDGenericObjects.objCloseInterstitialAd, 2000); // INTERSTITIAL AD HANDLED HERE
			verifyElementExist(AMDHomePage.objGetPremiumCTAOnCarosel, "Get Premium CTA on carosel");
			click(AMDHomePage.objGetPremiumCTAOnCarosel, "Get Premium CTA on carosel");
			verifyElementExist(AMDSubscibeScreen.objSubscribeHeader, "Subscribe page");
			Back(1);
			waitTime(5000);
			verifyElementPresentAndClick(AMDHomePage.objShowsTab, "Shows Tab");
			waitTime(5000);
//			closeInterstitialAd(AMDGenericObjects.objCloseInterstitialAd, 2000); // INTERSTITIAL AD - HANDLED HERE
			PartialSwipe("UP", 1);
			waitTime(5000);
			if (verifyElementExist(AMDHomePage.objBeforeTVTray, "BeforeTV tray")) {
				waitTime(5000);
				String beforeTVtrayName = findElement(AMDGenericObjects.objTrayTitle("Before")).getText();
				click(AMDGenericObjects.objViewAllBtn(beforeTVtrayName), "View All_Before TV Show");
				waitTime(4000);
				click(AMDHomePage.objBeforeTVContent, "BeforeTV content");
				waitTime(5000);
				verifyElementExist(AMDHomePage.objGetPremiumPopUP, "PremiumPopUp");
				Swipe("UP", 1);
				click(AMDHomePage.objGetPremiumPopUPProceedButton, "Proceed button");
				verifyElementExist(AMDSubscibeScreen.objSubscribeHeader, "Subscribe page");

			} else {
				logger.info("Before TV tray is not displayed");
				extent.extentLogger("TV", "Before TV tray is not displayed");
			}
			Back(1);
			waitTime(3000);
			Back(1);
			waitTime(3000);
			verifyElementPresentAndClick(AMDHomePage.HomeIcon, "Home Tab");
			verifyElementPresentAndClick(AMDHomePage.MoreMenuIcon, "More Menu");
			verifyElementPresentAndClick(AMDHomePage.objMoreMenuOptions("Buy Subscription"), "Buy Subscription");
			verifyElementExist(AMDSubscibeScreen.objSubscribeHeader, "Subscribe page");
			subscribePageValidation();
			passwordScenario("Registered");
			unRegisteredEmailSubscribe();
			subscribeFLowMobileNumber();
			waitTime(10000);
//			click(AMDHomePage.objSearchBtn, "Search button");
//			waitTime(5000);
//			click(AMDSearchScreen.objSearchEditBox, "Search box");
//			type(AMDSearchScreen.objSearchBoxBar, "Natasaarvabhowma trailer\n", "Search box");
//			hideKeyboard();
//			waitTime(6000);
//			click(AMDSearchScreen.objContentNameInPlayer("Natasaarvabhowma - Trailer"), "Search result");
//			waitTime(5000);
//			verifyElementExist(AMDSearchScreen.objContentNameInPlayer("Natasaarvabhowma - Trailer"),
//					"Content name below the player");
//			waitTime(30000);
//			verifyElementExist(AMDHomePage.objGetPremiumPopUP, "PremiumPopUp");
//			click(AMDHomePage.objGetPremiumPopUPProceedButton, "Proceed button");
//			verifyElementExist(AMDSubscibeScreen.objSubscribeHeader, "Subscribe page");
		}

		else if (userType.equals("NonSubscribedUser")) {
			verifyElementPresentAndClick(AMDLoginScreen.objEmailIdField, "Email field");
			type(AMDLoginScreen.objEmailIdField, NonsubscribedUserName, "Email field");
			hideKeyboard();
			verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed button");
			verifyElementPresentAndClick(AMDLoginScreen.objPasswordField, "Password field");
			type(AMDLoginScreen.objPasswordField, NonsubscribedPassword, "Password field");
			hideKeyboard();
			verifyElementPresentAndClick(AMDLoginScreen.objLoginBtn, "Login button");
			waitTime(1000);
			verifyElementExist(AMDHomePage.objHomeBtn, "Home button");
			click(AMDHomePage.objMoreMenu, "More menu");
			verifyElementPresentAndClick(AMDHomePage.objMyProfileIcon, "profile icon");

			if (verifyElementExist(AMDHomePage.objEditProfile, "Edit profile")) {
				logger.info("User is logged in successfully");
				extent.extentLogger("Edit", "User is logged in successfully");
			}
			Back(1);
			verifyElementPresentAndClick(AMDHomePage.objHomeBtn, "Home tab");
			waitTime(4000);
			verifyElementExist(AMDHomePage.objGetPremiumCTAOnCarosel, "Get Premium CTA on carosel");
			click(AMDHomePage.objGetPremiumCTAOnCarosel, "Get Premium CTA on carosel");
			verifyElementExist(AMDSubscibeScreen.objSubscribeHeader, "Subscribe page");
			Back(1);
//			waitTime(5000);                 NEED CLARIFICATION
//			verifyElementPresentAndClick(AMDHomePage.objShowsTab, "Shows Tab");
//			waitTime(5000);
//			PartialSwipe("UP", 1);
//			waitTime(5000);
//			if (verifyElementExist(AMDHomePage.objBeforeTVTray, "BeforeTV tray")) {
//				Wait(10000);
//				click(AMDHomePage.objBeforeTVTray, "BeforeTV tray");
//				waitTime(4000);
//				click(AMDHomePage.objBeforeTVContent, "BeforeTV content");
//				waitTime(5000);
//				verifyElementExist(AMDHomePage.objGetPremiumPopUP, "PremiumPopUp");
//				click(AMDHomePage.objGetPremiumPopUPProceedButton, "Proceed button");
//				verifyElementExist(AMDSubscibeScreen.objSubscribeHeader, "Subscribe page");
//
//			} else {
//				logger.info("Before TV tray is not displayed");
//				extent.extentLogger("TV", "Before TV tray is not displayed");
//			}
//			Back(1);
//			waitTime(3000);
//			Back(1);
			verifyElementPresentAndClick(AMDHomePage.objHomeBtn, "Home Tab");
			verifyElementPresentAndClick(AMDHomePage.objMoreMenuBtn, "More Menu");
			verifyElementPresentAndClick(AMDHomePage.objMoreMenuOptions("Buy Subscription"), "Buy Subscription");
			verifyElementExist(AMDSubscibeScreen.objSubscribeHeader, "Subscribe page");
			Back(1);
			verifyElementPresentAndClick(AMDHomePage.objMoreMenuOptions("My Subscription"), "My Subscription");
			verifyElementPresentAndClick(AMDHomePage.objSubscribeNowInMySubscription, "Subscribe now CTA");
			verifyElementExist(AMDSubscibeScreen.objSubscribeHeader, "Subscribe page");
			Back(1);
			waitTime(3000);
			Back(1);
			verifyElementPresentAndClick(AMDHomePage.objMoreMenuOptions("My Transactions"), "My Transactions");
			verifyElementPresentAndClick(AMDHomePage.objSubscribeNowInMyTransaction, "Subscribe now CTA");
			verifyElementExist(AMDSubscibeScreen.objSubscribeHeader, "Subscribe page");
			Back(1);
			waitTime(3000);
			Back(1);
			click(AMDHomePage.objHomeBtn, "Home Tab");
			verifyElementPresentAndClick(AMDHomePage.objSubscribeTeaser, "Subscribe button");
			verifyElementExist(AMDSubscibeScreen.objSubscribeHeader, "Subscribe header in subscription page");
			verifyElementExist(AMDSubscibeScreen.objSubscribePageBackButton, "Back button in subscribe page");
			verifyElementExist(AMDSubscibeScreen.objAdbanner, "Carosual in subscription page");
			verifyElementExist(AMDSubscibeScreen.objApplyPromoCodeTextbox, "Promo code in subscribe page");
			verifyElementPresent(AMDSubscibeScreen.objApply, "Apply button is subscribe page");
			if (verifyElementExist(AMDSubscibeScreen.objApplybuttonNotHighlighted, "Apply button")) {
				logger.info("Apply button is not highlighted by default");
				extent.extentLogger("Highlighted", "Apply button is not highlighted by default");
			}
			click(AMDSubscibeScreen.objApplyPromoCodeTextbox, "Promo");
			type(AMDSubscibeScreen.objApplyPromoCodeTextbox, PromoCode, "Promo code");
			hideKeyboard();
			click(AMDSubscibeScreen.objApply, "Apply button");
			verifyElementExist(AMDSubscibeScreen.objApplyPromoCodeappliedText, "Promo code applied successfully text");
			if (verifyElementExist(AMDSubscibeScreen.objApplyPromoCodeappliedText, "Promo")) {
				logger.info("Discounted price is displayed after promo code is applied");
				extent.extentLogger("Promo", "Discounted price is displayed after promo code is applied");
			}
			click(AMDSubscibeScreen.objCancelPromoCode, "Cancel promo");
			click(AMDSubscibeScreen.objApplyPromoCodeTextbox, "Promo");
			type(AMDSubscibeScreen.objApplyPromoCodeTextbox, "zee5flat5000", "Promo code");
			hideKeyboard();
			click(AMDSubscibeScreen.objApply, "Apply button");
			verifyElementExist(AMDSubscibeScreen.objInvalidPromoCodeText, "Invalid promo code error message");
			Swipe("UP", 2);
			PartialSwipe("UP", 2);
			verifyElementExist(AMDSubscibeScreen.objDescriptionText, "Premium Description in subscribe page");
			verifyElementExist(AMDSubscibeScreen.objAllAccessTab, "All access pack tab");
			verifyElementExist(AMDSubscibeScreen.objRSVODPremiumPack, "RSVOD pack tab");
			Swipe("UP", 1);
			verifyElementExist(AMDSubscibeScreen.obj30daysPack, "30 days premium plan tab");
			verifyElementExist(AMDSubscibeScreen.obj180daysPack, "180 days premium plan tab");
			verifyElementExist(AMDSubscibeScreen.obj365daysPack, "365 days premium plan tab");
			Swipe("UP", 1);
			verifyElementExist(AMDSubscibeScreen.objContinueBtn, "Continue button in subscribe page");
			if (getDriver().findElement(AMDSubscibeScreen.objContinueBtn).isEnabled()) {
				logger.info("Continue button is highlighted");
				extent.extentLogger("Highlighted", "Continue button is highlighted");
			}
			Swipe("DOWN", 1);
//			click(AMDSubscibeScreen.objRSVODPremiumPack, "RSVOD Pack tab");
//			verifyElementPresentAndClick(AMDSubscibeScreen.objRSVODPack1, "RSVOD Plan for 30 days");
//			PartialSwipe("UP", 2);
//			verifyElementExist(AMDSubscibeScreen.objRSVODPack2, "RSVOD Plan for 365 days");
			Swipe("Down", 1);
			verifyElementExist(AMDSubscibeScreen.objDescriptionText, "Premium Description in subscribe page");
			Swipe("Up", 2);
			if (getDriver().findElement(AMDSubscibeScreen.objContinueBtn).isEnabled()) {
				logger.info("Continue button is highlighted");
				extent.extentLogger("Highlighted", "Continue button is highlighted");
			}
			click(AMDSubscibeScreen.objContinueBtn, "Continue button");
			verifyElementExist(AMDSubscibeScreen.objPaymentText, "Payment page");
			verifyElementExist(AMDSubscibeScreen.objSubscribeHeader, "Subscribe header in Payment page");
			verifyElementExist(AMDSubscibeScreen.objSubscribePageBackButton, "Back button in Payment page");
			Back(1);
			waitTime(3000);
			Back(1);
			waitTime(5000);
			click(AMDHomePage.objSearchBtn, "Search button");
			waitTime(5000);
			click(AMDSearchScreen.objSearchEditBox, "Search box");
			type(AMDSearchScreen.objSearchBoxBar, "Natasaarvabhowma trailer\n", "Search box");
			hideKeyboard();
			waitTime(6000);
			click(AMDSearchScreen.objContentNameInPlayer("Natasaarvabhowma - Trailer"), "Search result");
			waitTime(5000);
			verifyElementExist(AMDSearchScreen.objContentNameInPlayer("Natasaarvabhowma - Trailer"),
					"Content name below the player");
			waitTime(30000);
			verifyElementExist(AMDHomePage.objGetPremiumPopUP, "PremiumPopUp");
			Swipe("UP", 1);
			click(AMDHomePage.objGetPremiumPopUPProceedButton, "Proceed button");
			verifyElementExist(AMDSubscibeScreen.objSubscribeHeader, "Subscribe page");

		}

		if (userType.equals("SubscribedUser")) {
			verifyElementPresentAndClick(AMDLoginScreen.objEmailIdField, "Email field");
			type(AMDLoginScreen.objEmailIdField, RSVODUser, "Email field");
			hideKeyboard();
			verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed button");
			verifyElementPresentAndClick(AMDLoginScreen.objPasswordField, "Password field");
			type(AMDLoginScreen.objPasswordField, RSVODPassword, "Password field");
			hideKeyboard();
			verifyElementPresentAndClick(AMDLoginScreen.objLoginButton, "Login button");
			waitTime(1000);
			verifyElementExist(AMDHomePage.objHomeBtn, "Home button");
			click(AMDHomePage.objMoreMenu, "More menu");
			verifyElementPresentAndClick(AMDHomePage.objMyProfileIcon, "profile icon");

			if (verifyElementExist(AMDHomePage.objEditProfile, "Edit profile")) {
				logger.info("User is logged in successfully");
				extent.extentLogger("Edit", "User is logged in successfully");
			}
			Back(1);
			verifyElementPresentAndClick(AMDHomePage.objHomeBtn, "Home tab");
			waitTime(4000);
			verifyElementPresentAndClick(AMDHomePage.objMoreMenuBtn, "More Menu");
			verifyElementPresentAndClick(AMDHomePage.objMoreMenuOptions("My Subscription"), "My Subscription");
			verifyElementExist(AMDHomePage.objPackAmount, "Purchased pack details");
			verifyElementExist(AMDHomePage.objCancelRenewal, "Cancel Renewal option");
			verifyElementPresentAndClick(AMDHomePage.objBrowseAllPack, "Browse all packs button");
			verifyElementExist(AMDSubscibeScreen.objSubscribeHeader, "Subscribe page");
			Back(1);
			waitTime(2000);
			Back(1);
			verifyElementPresentAndClick(AMDHomePage.objMoreMenuOptions("Buy Subscription"), "Buy Subscription");
			verifyElementExist(AMDSubscibeScreen.objSubscribeHeader, "Subscribe page");
			verifyElementExist(AMDSubscibeScreen.objSubscribeHeader, "Subscribe header in subscription page");
			verifyElementExist(AMDSubscibeScreen.objSubscribePageBackButton, "Back button in subscribe page");
			verifyElementExist(AMDSubscibeScreen.objAdbanner, "Carosual in subscription page");
			verifyElementExist(AMDSubscibeScreen.objApplyPromoCodeTextbox, "Promo code in subscribe page");
			verifyElementPresent(AMDSubscibeScreen.objApply, "Apply button is subscribe page");
			if (verifyElementExist(AMDSubscibeScreen.objApplybuttonNotHighlighted, "Apply button")) {
				logger.info("Apply button is not highlighted by default");
				extent.extentLogger("Highlighted", "Apply button is not highlighted by default");
			}
			click(AMDSubscibeScreen.objApplyPromoCodeTextbox, "Promo");
			type(AMDSubscibeScreen.objApplyPromoCodeTextbox, PromoCode, "Promo code");
			hideKeyboard();
			click(AMDSubscibeScreen.objApply, "Apply button");
			verifyElementExist(AMDSubscibeScreen.objApplyPromoCodeappliedText, "Promo code applied successfully text");
			if (verifyElementExist(AMDSubscibeScreen.objApplyPromoCodeappliedText, "Promo")) {
				logger.info("Discounted price is displayed after promo code is applied");
				extent.extentLogger("Promo", "Discounted price is displayed after promo code is applied");
			}
			click(AMDSubscibeScreen.objCancelPromoCode, "Cancel promo");
			click(AMDSubscibeScreen.objApplyPromoCodeTextbox, "Promo");
			type(AMDSubscibeScreen.objApplyPromoCodeTextbox, "zee5flat5000", "Promo code");
			hideKeyboard();
			click(AMDSubscibeScreen.objApply, "Apply button");
			verifyElementExist(AMDSubscibeScreen.objInvalidPromoCodeText, "Invalid promo code error message");
			Swipe("UP", 1);
			PartialSwipe("UP", 1);
			verifyElementExist(AMDSubscibeScreen.objDescriptionText, "Premium Description in subscribe page");
			verifyElementExist(AMDSubscibeScreen.objAllAccessTab, "All access pack tab");
			verifyElementExist(AMDSubscibeScreen.objRSVODPremiumPack, "RSVOD pack tab");
			Swipe("UP", 1);
			verifyElementExist(AMDSubscibeScreen.obj30daysPack, "30 days premium plan tab");
			verifyElementExist(AMDSubscibeScreen.obj180daysPack, "180 days premium plan tab");
			verifyElementExist(AMDSubscibeScreen.obj365daysPack, "365 days premium plan tab");
			Swipe("UP", 1);
			verifyElementExist(AMDSubscibeScreen.objContinueBtn, "Continue button in subscribe page");
			if (getDriver().findElement(AMDSubscibeScreen.objContinueBtn).isEnabled()) {
				logger.info("Continue button is highlighted");
				extent.extentLogger("Highlighted", "Continue button is highlighted");
			}
			Swipe("DOWN", 1);
			click(AMDSubscibeScreen.objRSVODPremiumPack, "RSVOD Pack tab");
			verifyElementPresentAndClick(AMDSubscibeScreen.objRSVODPack1, "RSVOD Plan for 30 days");
			PartialSwipe("UP", 2);
			verifyElementExist(AMDSubscibeScreen.objRSVODPack2, "RSVOD Plan for 365 days");
			Swipe("Down", 1);
			verifyElementExist(AMDSubscibeScreen.objDescriptionText, "Premium Description in subscribe page");
			Swipe("UP", 2);
			if (findElement(AMDSubscibeScreen.objContinueBtn).isEnabled()) {
				logger.info("Continue button is highlighted");
				extent.extentLogger("Highlighted", "Continue button is highlighted");
			}
			click(AMDSubscibeScreen.objContinueBtn, "Continue button");
			if (verifyElementExist(AMDHomePage.objHomeBtn, "Home tab")) {
				logger.info(
						"Subscribed user is navigated to home page after tapping on buy subscription continue button");
				extent.extentLogger("Home",
						"Subscribed user is navigated to home page after tapping on buy subscription continue button");
			}

			waitTime(5000);
			click(AMDHomePage.objSearchBtn, "Search button");
			waitTime(5000);
			click(AMDSearchScreen.objSearchEditBox, "Search box");
			type(AMDSearchScreen.objSearchBoxBar, "Chintu ka Birthday\n", "Search field");
			hideKeyboard();
			waitTime(7000);
			verifyElementPresentAndClick(AMDSearchScreen.objSearchResultPremiunm("Chintu Ka Birthday"),
					"Search result premium content");
			waitTime(5000);
			verifyElementExist(AMDSearchScreen.objContentNameInPlayer("Chintu Ka Birthday"), "Content name in player");
			waitTime(25000);
			verifyElementExist(AMDSearchScreen.objUpgradePopup, "Upgrade popup for RSVOD user");
			verifyElementExist(AMDSearchScreen.objUpgradePopupTitle, "Upgrade text in upgrade popup");
			verifyElementExist(AMDSearchScreen.objUpgradePopupDescription, "Upgrade popup description");
			logger.info(getText(AMDSearchScreen.objUpgradePopupDescription));
			verifyElementExist(AMDSearchScreen.objUpgradePopUpPacks("INR 99 for 30 days"),
					"30 days pack in upgrade popup");
			verifyElementExist(AMDSearchScreen.objUpgradePopUpPacks("INR 299 for 90 days"),
					"90 days pack in upgrade popup");
			verifyElementExist(AMDSearchScreen.objUpgradePopUpPacks("INR 599 for 180 days"),
					"180 days pack in upgrade popup");
			verifyElementExist(AMDSearchScreen.objUpgradePopUpPacks("INR 999 for 365 days"),
					"365 days pack in upgrade popup");
			Swipe("UP", 1);
			PartialSwipe("UP", 1);
			verifyElementExist(AMDSearchScreen.objTermsOfUse, "Terms of use link");
			verifyElementExist(AMDSearchScreen.objPrivacyPolicy, "Privacy policy");
			if (findElement(AMDSearchScreen.objUpgradePopupProceedButton).isEnabled()) {
				logger.info("Proceed button is enebled when user select any pack in upgrade popup");
				extent.extentLogger("Proceed", "Proceed button is enebled when user select any pack in upgrade popup");
			}
			click(AMDSearchScreen.objUpgradePopupProceedButton, "Proceed");
			verifyElementExist(AMDSubscibeScreen.objSubscribeHeader, "Subscribe page");
			Swipe("DOWN", 1);
			verifyElementExist(AMDSearchScreen.objPlanPrice, "Plan price detials in Subscribe page");
			verifyElementExist(AMDSearchScreen.objDiscount, "Discount price detials in Subscribe page");
			verifyElementExist(AMDSearchScreen.objRoundoff, "Round off price detials in Subscribe page");
			verifyElementExist(AMDSearchScreen.objTotalPayableAmount, "Total payable price detials in Subscribe page");
			verifyElementExist(AMDSearchScreen.objAccountInfo, "Account info detials in Subscribe page");
			Swipe("UP", 1);
			verifyElementExist(AMDSearchScreen.objYouWillBeChargedInfo, "Recurring amount detials in Subscribe page");
			relaunch(true);
			accessDeviceLocationPopUp("Allow", userType);
			subscribeAllaccessFunctionality();

		}
	}

	public void subscribeAllaccessFunctionality() throws Exception {
		HeaderChildNode("Subscribe All access functionality");
		click(AMDOnboardingScreen.objDiplay_ContinueBtn, "Display continue");
		click(AMDOnboardingScreen.objContent_ContinueBtn, " Content Continue");
		click(AMDOnboardingScreen.objBrowseForFreeBtn, "Browse for free");

		verifyElementPresentAndClick(AMDLoginScreen.objEmailIdField, "Email field");
		type(AMDLoginScreen.objEmailIdField, SubscribedUserName, "Email field");
		hideKeyboard();
		verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed button");
		verifyElementPresentAndClick(AMDLoginScreen.objPasswordField, "Password field");
		type(AMDLoginScreen.objPasswordField, SubscribedPassword, "Password field");
		hideKeyboard();
		verifyElementPresentAndClick(AMDLoginScreen.objLoginButton, "Login button");
		waitTime(1000);
		verifyElementExist(AMDHomePage.objHomeBtn, "Home button");
		click(AMDHomePage.objMoreMenu, "More menu");
		verifyElementPresentAndClick(AMDHomePage.objMyProfileIcon, "profile icon");

		if (verifyElementExist(AMDHomePage.objEditProfile, "Edit profile")) {
			logger.info("User is logged in successfully");
			extent.extentLogger("Edit", "User is logged in successfully");
		}
		Back(1);
		verifyElementPresentAndClick(AMDHomePage.objMoreMenuOptions("Buy Subscription"), "Buy Subscription");
		verifyElementExist(AMDSubscibeScreen.objSubscribeHeader, "Subscribe page");
		Swipe("UP", 1);
		waitTime(3000);
		Swipe("UP", 1);
		verifyElementPresentAndClick(AMDSubscibeScreen.obj365daysPack, "365 days all access pack");
		Swipe("UP", 1);
		click(AMDSubscibeScreen.objContinueBtn, "Continue button");
		if (verifyElementExist(AMDHomePage.objHomeBtn, "Home tab")) {
			logger.info(
					"Subscribed user is navigated to home page after tapping on all access plan subscription continue button");
			extent.extentLogger("Home",
					"Subscribed user is navigated to home page after tapping on all access plan subscription continue button");
		}
	}

	public void subscribePageValidation() throws Exception {
		System.out.println("\nVerifying Subscribe Page");
		verifyElementExist(AMDSubscibeScreen.objSubscribeHeader, "Subscribe header in subscription page");
		verifyElementExist(AMDSubscibeScreen.objSubscribePageBackButton, "Back button in subscribe page");
		verifyElementExist(AMDSubscibeScreen.objAdbanner, "Carosual in subscription page");
		verifyElementExist(AMDSubscibeScreen.objApplyPromoCodeTextbox, "Promo code in subscribe page");
		verifyElementPresent(AMDSubscibeScreen.objApply, "Apply button is subscribe page");
		if (verifyElementExist(AMDSubscibeScreen.objApplybuttonNotHighlighted, "Apply button")) {
			logger.info("Apply button is not highlighted by default");
			extent.extentLogger("Highlighted", "Apply button is not highlighted by default");
		}
		click(AMDSubscibeScreen.objApplyPromoCodeTextbox, "Promo");
		type(AMDSubscibeScreen.objApplyPromoCodeTextbox, PromoCode, "Promo code");
		hideKeyboard();
		click(AMDSubscibeScreen.objApply, "Apply button");
		verifyElementExist(AMDSubscibeScreen.objApplyPromoCodeappliedText, "Promo code applied successfully text");
		if (verifyElementExist(AMDSubscibeScreen.objApplyPromoCodeappliedText, "Promo")) {
			logger.info("Discounted price is displayed after promo code is applied");
			extent.extentLogger("Promo", "Discounted price is displayed after promo code is applied");
		}
		click(AMDSubscibeScreen.objCancelPromoCode, "Cancel promo");
		click(AMDSubscibeScreen.objApplyPromoCodeTextbox, "Promo");
		type(AMDSubscibeScreen.objApplyPromoCodeTextbox, "zee5flat5000", "Promo code");
		hideKeyboard();
		click(AMDSubscibeScreen.objApply, "Apply button");
		verifyElementExist(AMDSubscibeScreen.objInvalidPromoCodeText, "Invalid promo code error message");
		Swipe("UP", 1);
		verifyElementExist(AMDSubscibeScreen.objDescriptionText, "Premium Description in subscribe page");
		verifyElementExist(AMDSubscibeScreen.objAllAccessTab, "All access pack tab");
		verifyElementExist(AMDSubscibeScreen.objRSVODPremiumPack, "RSVOD pack tab");
		Swipe("UP", 1);
		verifyElementExist(AMDSubscibeScreen.obj30daysPack, "30 days premium plan tab");
		verifyElementExist(AMDSubscibeScreen.obj180daysPack, "180 days premium plan tab");
		verifyElementExist(AMDSubscibeScreen.obj365daysPack, "365 days premium plan tab");
		PartialSwipe("UP", 2);
		verifyElementExist(AMDSubscibeScreen.objContinueBtn, "Continue button in subscribe page");
		if (getDriver().findElement(AMDSubscibeScreen.objContinueBtn).isEnabled()) {
			logger.info("Continue button is highlighted");
			extent.extentLogger("Highlighted", "Continue button is highlighted");
		}
		Swipe("DOWN", 1);
		click(AMDSubscibeScreen.objRSVODPremiumPack, "RSVOD Pack tab");
		verifyElementPresentAndClick(AMDSubscibeScreen.objRSVODPack1, "RSVOD Plan for 30 days");
		PartialSwipe("UP", 1);
		verifyElementExist(AMDSubscibeScreen.objRSVODPack2, "RSVOD Plan for 365 days");
		verifyElementExist(AMDSubscibeScreen.objDescriptionText, "Premium Description in subscribe page");
		Swipe("UP", 1);
		if (getDriver().findElement(AMDSubscibeScreen.objContinueBtn).isEnabled()) {
			logger.info("Continue button is highlighted");
			extent.extentLogger("Highlighted", "Continue button is highlighted");
		}
		click(AMDSubscibeScreen.objContinueBtn, "Continue button");
		verifyElementExist(AMDSubscibeScreen.objAccountInfoHeader, "Account info screen");
		hideKeyboard();// ADDED By Kushal
		verifyElementExist(AMDSubscibeScreen.objSubscribeHeader, "Subscribe header");
		verifyElementExist(AMDSubscibeScreen.objSubscribePageBackButton, "Back button in Account info screen");
		verifyElementExist(AMDSubscibeScreen.objSelectedPackDesc, "Selected pack description in account info screen");
		verifyElementExist(AMDSubscibeScreen.objEmailID, "Email id field in Account info screen");
		hideKeyboard();
		Swipe("UP", 1);
		verifyElementExist(AMDSubscibeScreen.objORSeperator, "OR seperator in Account info screen");
		verifyElementExist(AMDSubscibeScreen.objFacebookIcon, "FB icon in Account info screen");
		verifyElementExist(AMDSubscibeScreen.objGoogleIcon, "Google icon in Account info screen");
		verifyElementExist(AMDSubscibeScreen.objTwitterIcon, "Twitter icon in Account info screen");
		verifyElementExist(AMDSubscibeScreen.objProceedButtonNothighlighted, "Proceed button dehighlighted by default");
		click(AMDSubscibeScreen.objEmailID, "Email");
		type(AMDSubscibeScreen.objEmailID, RegisteredEmail, "Email field");
		hideKeyboard();
		String Email = getText(AMDSubscibeScreen.objEmailID);
		if (Email != null) {
			logger.info("User can enter email/mobile number in email id field");
			extent.extentLogger("Email", "User can enter email/mobile number in email id field");
		}
		verifyElementExist(AMDSubscibeScreen.objProceedBtn, "Proceed button");
		click(AMDSubscibeScreen.objProceedBtn, "Proceed button");
		verifyElementExist(AMDSubscibeScreen.objEnterPassword, "Enter Password PopUp");
	}

	/*
	 * =============================================================================
	 * ===== ------------------------------ Script Author: BINDU
	 * -------------------------------
	 * 
	 * List of Functions Created - BrowseForFreeAndMobileRegistration() -
	 * VerifyLoginPage() - SearchBox(String userType) -
	 * verifySearchLandingScreen(String userType) - verifySearchOption(String
	 * userType)
	 * =============================================================================
	 * ========
	 */

	public void BrowseForFreeAndMobileRegistration() throws Exception {

		extent.HeaderChildNode("Validating BrowseForFree Button on the intro screen");
		waitTime(5000);
		verifyElementPresent(AMDLoginScreen.objBrowseForFreeBtn, "BrowseForFreee Button");
		waitTime(5000);
		String BrowseForFree = getText(AMDLoginScreen.objBrowseForFreeBtn);
		System.out.println(BrowseForFree);
		if (BrowseForFree.concat("English") != null) {
			logger.info("Browse For Free text is displayed in Selected Language");
			extent.extentLogger("Login/Register Screen", "Browse For Free text is displayed in Selected Language");
		} else {
			logger.info("Browse For Free text is not displayed in Selected Language");
			extent.extentLogger("Login/Register Screen", "Browse For Free text is not displayed in Selected Language");

		}

		verifyElementPresentAndClick(AMDLoginScreen.objBrowseForFreeBtn, "BrowseForFreee Button");
		waitTime(6000);
		logger.info("User navigated to Login/Register screen tapping on the Browser For Free Button");
		extent.extentLogger("Login/Register Screen",
				"User navigated to Login/Register screen tapping on the Browser For Free Button");

		extent.HeaderChildNode("Validating user navigated to OTP Verification Screen");
		verifyElementPresent(AMDLoginScreen.objEmailIdField, "Email Field");
		click(AMDLoginScreen.objEmailIdField, "Email Field");
		hideKeyboard();
		type(AMDLoginScreen.objEmailIdField, "1234567891", "Email Field");
		verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed Button");
		waitTime(4000);
		verifyElementPresentAndClick(AMDRegistrationScreen.objFirstNameTxtField, "FirstName Field");
		hideKeyboard();
		type(AMDRegistrationScreen.objFirstNameTxtField, "Zeetest", "FirstName Field");
		verifyElementPresentAndClick(AMDRegistrationScreen.objLastNameTxtField, "LastName Field");
		hideKeyboard();
		type(AMDRegistrationScreen.objLastNameTxtField, "Test", "LastName Field");

		verifyElementPresentAndClick(AMDRegistrationScreen.objDOBTxtField, "Date Of Birth Field");

		// verifyElementPresentAndClick(AMDRegistrationScreen.objDateAccept, "Date Of
		// Birth");

		verifyElementPresentAndClick(AMDRegistrationScreen.objDateSelection, "Date in calender popup");
		click(AMDRegistrationScreen.objOkButtonInCalenderPopUp, "Ok button");

//    verifyElementPresentAndClick(AMDEditProfileScreen.objGenderDropdown, "Gender Dropdown");
//    waitTime(3000);
//    verifyElementPresentAndClick(AMDRegistrationScreen.objFemale, "Female");        
//    waitTime(2000);

		verifyElementPresentAndClick(AMDRegistrationScreen.objGederTxtField, "Gender field");
		verifyElementPresentAndClick(AMDRegistrationScreen.objMale, "Gender male");

		verifyElementPresentAndClick(AMDRegistrationScreen.objPasswordTxtField, "Password Field");
		waitTime(2000);
		hideKeyboard();
		type(AMDRegistrationScreen.objPasswordTxtField, "adcbdefg", "Password Field");
		waitTime(2000);

//    verifyElementPresentAndClick(AMDRegistrationScreen.objRegister, "Register Field");
//    waitTime(6000);
//    verifyElementPresent(AMDRegistrationScreen.objVerifyOTPScreen, "OTP Verificatin Page");

		verifyElementPresentAndClick(AMDRegistrationScreen.objRegisterBtn, "Register button");
		waitTime(3000);

		logger.info("User navigated to OTP Verification Page");
		extent.extentLogger("OTP Verification Screen", "User navigated to OTP Verification screen");
		otpScenarios();
		Back(1);
		waitTime(3000);
		hideKeyboard();
		Back(1);
		int lenText = findElement(AMDLoginScreen.objEmailIdField).getAttribute("value").length();
		for (int i = 0; i < lenText; i++) {
			getDriver().findElement(AMDLoginScreen.objEmailIdField).sendKeys(Keys.BACK_SPACE);
		}
		type(AMDLoginScreen.objEmailIdField, RegisteredMobile, "Mobile number field");
		verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed button");
		type(AMDLoginScreen.objPasswordField, RegisteredMobilePassword, "Password field");
		verifyElementPresentAndClick(AMDLoginScreen.objLoginBtn, "Login button");
		verifyElementExist(AMDHomePage.objHomeTab, "Home tab");

	}

	public void VerifyLoginPage() throws Exception {

		extent.HeaderChildNode(
				"Validating the Navigation to Login or Register Screen Tapping on the Login link available in Intro Screen");
		// waitTime(8000);
		verifyElementPresent(AMDLoginScreen.objLoginLnk, "Login Link");
		click(AMDLoginScreen.objLoginLnk, "Login Link");
		verifyElementPresent(AMDLoginScreen.objLoginPage, "Login Page");
		logger.info("User navigated to Login/Register Screen Tapping on the Login link present on the Intro Screen");
		extent.extentLogger("Login/Register Screen",
				"User is navigated to Login/register Screen Tapping on the Login link present on the Intro Screen");
		verifyElementPresentAndClick(AMDLoginScreen.objSkipButton, "Skip button");
		// waitTime(4000);
		verifyElementPresent(AMDLoginScreen.objHomeTab, "Home Tab");
		logger.info("User navigated to Home Tab by clicking on the Skip button");
		extent.extentLogger("Home Tab", "User navigated to Home Tab by clicking on the Skip button");

		waitTime(2000);
		extent.HeaderChildNode(
				"Validating the Navigation to Login or Register Screen Tapping on the Login link available in Menu Screen");

		waitTime(2000);
		verifyElementPresent(AMDLoginScreen.objMenu, "Menu icon");
		click(AMDLoginScreen.objMenu, "Menu icon");
		verifyElementPresent(AMDLoginScreen.objProfileIcon, "Login Button");
		click(AMDLoginScreen.objProfileIcon, "Login Button");
		verifyElementPresent(AMDLoginScreen.objLoginPage, "Login Page");
		logger.info("User is navigated to Login/register Screen Tapping on the Login link present in the Menu Screen");
		extent.extentLogger("Login/Register Screen",
				"User is navigated to Login/register Screen Tapping on the Login link present in the Menu Screen");

		extent.HeaderChildNode("Validating UI/UX of Login Page");

		WebElement element = findElement(AMDLoginScreen.objLoginOrRegisterPageTitle);
		int leftX = element.getLocation().getX();
		int rightX = leftX + element.getSize().getWidth();
		int middleX = (rightX + leftX) / 2;
		Dimension size = getDriver().manage().window().getSize();
		if (middleX == Integer.valueOf((size.width) / 2)) {
			logger.info("Login/Register screen title is displayed at center of the screen");
			extent.extentLogger("Screen Title", "Login/Register screen title is displayed at center of the screen");
		} else {
			logger.error("Login/Register screen title is not displayed at center of the screen");
			extent.extentLoggerFail("Screen Title",
					"Login/Register screen title is not displayed at center of the screen");
		}

		WebElement elementBackBtn = findElement(AMDLoginScreen.objBackBtn);
		int BackBtnleftX = elementBackBtn.getLocation().getX();
		int BAckBtnrightX = BackBtnleftX + elementBackBtn.getSize().getWidth();
		int BackBtnmiddleX = (BAckBtnrightX + BackBtnleftX) / 2;

		if (BackBtnmiddleX <= 200) {
			logger.info("Back button is displayed at top left of the screen");
			extent.extentLogger("Back button", "Back button is displayed at top left of the screen");
		} else {
			logger.error("Back button is not displayed at top left of the screen");
			extent.extentLoggerFail("Back button", "Back button is not displayed at top left of the screen");
		}

		WebElement elementSkipBtn = findElement(AMDLoginScreen.objLoginLnk);
		int SkipBtnRightX = elementSkipBtn.getLocation().getX();
		System.out.println(SkipBtnRightX);
		Dimension sizee = getDriver().manage().window().getSize();
		System.out.println(sizee.getWidth());
		int sizeee = sizee.getWidth() - 300;
		System.out.println(sizeee);

		if (SkipBtnRightX >= sizeee) {
			logger.info("Skip button is displayed at top right of the screen");
			extent.extentLogger("Skip button", "Skip button is displayed at top right of the screen");
		} else {
			logger.error("Skip button is not displayed at top right of the screen");
			extent.extentLoggerFail("Skip button", "Skip button is not displayed at top right of the screen");
		}

		verifyElementPresent(AMDLoginScreen.objGoogleBtn, "Google Button");
		verifyElementPresent(AMDLoginScreen.objfbBtn, "Facebook Button");
		verifyElementPresent(AMDLoginScreen.objtwitterBtn, "Twitter Button");
		logger.info("Validated the UI/UX of Login Page");
		extent.extentLogger("Login/Register Screen", "Validated the UI/UX of Login page");

		extent.HeaderChildNode("Validating EmailID/Mobile No field is displayed");
		verifyElementPresent(AMDLoginScreen.objEmailIdField, "Email Field");
		logger.info("EmailID/Mobile No field is dispalyed");
		extent.extentLogger("Login/Register Screen", "EmailID/Mobile No field is dispalyed");

		extent.HeaderChildNode("Validating usen can enter EmailID or Mobile NO");
		click(AMDLoginScreen.objEmailIdField, "Email Field");
		hideKeyboard();

		type(AMDLoginScreen.objEmailIdField, "zeetest123@gmail.com", "Email Field");
		if (verifyElementPresent(AMDLoginScreen.objProceedBtn, "Proceed Button")) {
			logger.info("Proceed button is displayed , user entered the correct EmailID format");
			extent.extentLogger("Login/Register Screen",
					"Proceed button is displayed , user entered the correct EmailID format");
		} else {
			logger.info("Proceed button is not displayed , user not entered the correct EmailID format");
			extent.extentLogger("Login/Register Screen",
					"Proceed button is not displayed , user not entered the correct EmailID format");

		}

		// Check Proceed Button in highlighted

		if (getAttributValue("clickable", AMDRegistrationScreen.objProceedBtn).equals("true")) {
			logger.info("Proceed CTA is displayed and is highlated");
			extent.extentLogger("Proceed button", "Proceed CTA is displayed and is highlighted");
		} else {
			logger.error("Proceed CTA is not activated");
			extent.extentLoggerFail("Proceed button", "Proceed CTA is not activated");
		}

		extent.HeaderChildNode("Validating UI/UX of Login Page post changing the Display Language");
		waitTime(4000);
		verifyElementPresentAndClick(AMDLoginScreen.objBackBtn, "Back Button");
		verifyElementPresentAndClick(AMDLoginScreen.objSettings, "Settings Button");
		verifyElementPresentAndClick(AMDLoginScreen.objDisplayLang, "Display Language");
		waitTime(3000);
		verifyElementPresentAndClick(AMDLoginScreen.objLangHindi, "Display Language Hindi");
		verifyElementPresentAndClick(AMDLoginScreen.objLanguageContinueBtn, "Display Language Continue");
		waitTime(2000);
		verifyElementPresentAndClick(AMDLoginScreen.objBackBtn, "Back Button");
		waitTime(6000);
		verifyElementPresentAndClick(AMDLoginScreen.objMenuHindi, "Menu icon");
		verifyElementPresentAndClick(AMDLoginScreen.objProfileIcon, "Profile Icon");
		waitTime(3000);

		// verifyElementPresent(AMDLoginScreen.objLoginTextChanged, "Login Text");

		Dimension size1 = getDriver().manage().window().getSize();
		if (middleX == Integer.valueOf((size1.width) / 2)) {
			logger.info("Login/Register screen title is displayed at center of the screen");
			extent.extentLogger("Screen Title", "Login/Register screen title is displayed at center of the screen");
		} else {
			logger.error("Login/Register screen title is not displayed at center of the screen");
			extent.extentLoggerFail("Screen Title",
					"Login/Register screen title is not displayed at center of the screen");
		}

		WebElement elementBackBtn1 = findElement(AMDLoginScreen.objBackBtn);
		int BackBtnleftX1 = elementBackBtn1.getLocation().getX();
		int BAckBtnrightX1 = BackBtnleftX1 + elementBackBtn1.getSize().getWidth();
		int BackBtnmiddleX1 = (BAckBtnrightX1 + BackBtnleftX1) / 2;

		if (BackBtnmiddleX1 <= 200) {
			logger.info("Back button is displayed at top left of the screen");
			extent.extentLogger("Back button", "Back button is displayed at top left of the screen");
		} else {
			logger.error("Back button is not displayed at top left of the screen");
			extent.extentLoggerFail("Back button", "Back button is not displayed at top left of the screen");
		}

		WebElement elementSkipBtn1 = findElement(AMDLoginScreen.objLoginLnk);
		int SkipBtnRightX1 = elementSkipBtn1.getLocation().getX();
		System.out.println(SkipBtnRightX1);
		Dimension sizee1 = getDriver().manage().window().getSize();
		System.out.println(sizee1.getWidth());
		int sizeee1 = sizee1.getWidth() - 300;
		System.out.println(sizeee1);

		if (SkipBtnRightX1 >= sizeee1) {
			logger.info("Skip button is displayed at top right of the screen");
			extent.extentLogger("Skip button", "Skip button is displayed at top right of the screen");
		} else {
			logger.error("Skip button is not displayed at top right of the screen");
			extent.extentLoggerFail("Skip button", "Skip button is not displayed at top right of the screen");
		}

		verifyElementPresent(AMDLoginScreen.objGoogleBtn, "Google Button");
		verifyElementPresent(AMDLoginScreen.objfbBtn, "Facebook Button");
		verifyElementPresent(AMDLoginScreen.objtwitterBtn, "Twitter Button");
		logger.info("Validated the UI/UX of Login Page post changing the Display Language");
		extent.extentLogger("Login/Register Screen",
				"Validated the UI/UX of Login page post changing the Display Language");

		verifyElementPresentAndClick(AMDLoginScreen.objBackBtn, "Back Button");
		verifyElementPresentAndClick(AMDLoginScreen.objSettingsHindi, "Settings Button");
		verifyElementPresentAndClick(AMDLoginScreen.objDisplayLangHindi, "Display Language");
		waitTime(3000);
		verifyElementPresentAndClick(AMDLoginScreen.objLangEnglish, "Display Language English");
		verifyElementPresentAndClick(AMDLoginScreen.objLanguageContinueBtn, "Display Language Continue");
		waitTime(2000);
		verifyElementPresentAndClick(AMDLoginScreen.objBackBtn, "Back Button");
	}

	public void SearchBox(String userType) throws Exception {
		extent.HeaderChildNode("validating the UI/UX of search Landing screen");
		System.out.println("\nValidating the UI/UX of search Landing screen");
		verifyElementPresent(AMDSearchScreen.objSearchIcon, "Search icon");
		click(AMDSearchScreen.objSearchIcon, "Search icon");
		waitTime(6000);

		verifyElementExist(AMDSearchScreen.objHomeOption, "Bottom bar Home Option");
		verifyElementExist(AMDSearchScreen.objUpcomingOption, "Bottom bar Upcoming Option");
		verifyElementExist(AMDSearchScreen.objDownloadsOption, "Bottom bar Downloads Option");
		verifyElementExist(AMDSearchScreen.objMoreOption, "Bottom bar More Option");

		WebElement elementBackBtn = findElement(AMDLoginScreen.objBackBtn);
		int BackBtnleftX = elementBackBtn.getLocation().getX();
		int BAckBtnrightX = BackBtnleftX + elementBackBtn.getSize().getWidth();
		int BackBtnmiddleX1 = (BAckBtnrightX + BackBtnleftX) / 2;

		if (BackBtnmiddleX1 <= 200) {
			logger.info("Back button is displayed at top left of the screen");
			extent.extentLogger("Back button", "Back button is displayed at top left of the screen");
		} else {
			logger.error("Back button is not displayed at top left of the screen");
			extent.extentLoggerFail("Back button", "Back button is not displayed at top left of the screen");
		}

		WebElement elementVoiceIcon = findElement(AMDSearchScreen.objVoiceicon);
		int VoiceIconRightX = elementVoiceIcon.getLocation().getX();
		System.out.println(VoiceIconRightX);
		Dimension sizee = getDriver().manage().window().getSize();
//		System.out.println(sizee.getWidth());
		int sizeee = sizee.getWidth() - 300;
		System.out.println(sizee.getWidth() + " X " + sizeee);

		if (VoiceIconRightX >= sizeee) {
			logger.info("Microphone search icon is displayed at top right of the Search screen");
			extent.extentLogger("Microphone icon",
					"Microphone search icon is displayed at top right of the Search screen");
		} else {
			logger.error("Microphone icon is not displayed at top right of the Search screen");
			extent.extentLoggerFail("Microphone icon",
					"Microphone icon is not displayed at top right of the Search screen");
		}

		click(AMDSearchScreen.objVoiceicon, "Microphone Icon");
		// wait(2000);
		String MicrophoneAccessPopup = getDriver().findElement(AMDSearchScreen.objMicroPhone).getText();
		System.out.println(MicrophoneAccessPopup);

		if (MicrophoneAccessPopup.equalsIgnoreCase(
				"ZEE5 requires your permission to access your device's microphone to enable voice search. The voice data is not stored with ZEE5.")) {
			logger.info("Device Microphone access permission pop up is displayed");
			extent.extentLogger("Voice Search Icon", "Device Microphone access permission pop up is displayed");
		} else {
			logger.error("Device Microphone access permission pop up is not displayed");
			extent.extentLoggerFail("Voice Search icon", "Device Microphone access permission pop up is not displayed");
		}

		verifyElementExist(AMDSearchScreen.objVoiceSearchBackButton, "Back button");
		click(AMDSearchScreen.objVoiceSearchBackButton, "Back button");

		waitTime(2000);

		verifyElementExist(AMDSearchScreen.objsearchBox, "Search Box");
		logger.info("Search box is available on top section of search landing screen");
		extent.extentLogger("Search box", "Search box is available on top section of search landing screen");

		String SearchBoxText = getDriver().findElement(AMDSearchScreen.objsearchBox).getText();

		System.out.println(SearchBoxText);
		logger.info(SearchBoxText);

		if (SearchBoxText.equalsIgnoreCase("Search for Movies, Shows, Channels etc.")) {
			logger.info("Water Marked Text is displayed by default in Search Box");
			extent.extentLogger("Search box", "Water Marked Text is displayed by default in Search Box");
		} else {
			logger.error("Water Marked Text is not displayed by default in Search Box");
			extent.extentLoggerFail("Search Box", "Water Marked Text is not displayed by default in Search Box");
		}

		verifyElementPresentAndClick(AMDLoginScreen.objBackBtn, "Back Button");
		verifyElementPresent(AMDLoginScreen.objHomeTab, "Home Tab");

		logger.info("User navigated to previous screen on tapping of back button available on the search screen");
		extent.extentLogger("Previous screen",
				"User navigated to previous screen on tapping of back button available on the search screen");

		verifyElementPresent(AMDSearchScreen.objSearchIcon, "Search icon");
		click(AMDSearchScreen.objSearchIcon, "Search icon");

//		waitTime(2000);
//		if(verifyElementExist(AMDSearchScreen.objTrendingSearchOverlay,"Trending Search Overlay"))
//		{
//		logger.info("Trending search overlay is displayed");
//		extent.extentLogger("Search screen","Trending search overlay is displayed");
//		}else{
//			logger.info("Trending search overlay is not displayed");
//			extent.extentLoggerFail("Search screen","Trending search overlay is not displayed");
//		}
//		waitTime(2000);
//		if(verifyElementExist(AMDSearchScreen.objTopSearchOverlay,"Top search Overlay"))
//		{
//			logger.info("Top search overlay is displayed");
//			extent.extentLogger("Search screen","Top search overlay is displayed");
//		}else{
//			logger.info("Top search overlay is not displayed");
//			extent.extentLoggerFail("Search screen","Top search overlay is not displayed");
//			
//		}

//		click(AMDSearchScreen.objSearchEditBox, "Search box");
//		if(verifyElementExist(AMDSearchScreen.objVirtualKeyboard, "Keyboard"))
//		{
//			logger.info("Keyboard is displayed");
//			extent.extentLogger("Search screen","Keyboard is displayed");
//		}
//		else
//		{
//			logger.error("Keyboard is not displayed");
//			extent.extentLoggerFail("Search Screen", "Keyboard is not displayed");
//			
//		}
//		
//		hideKeyboard();	
		verifyElementPresentAndClick(AMDSearchScreen.objHomeOption, "Bottom bar Home Option");

	}

	public void verifySearchLandingScreen(String userType) throws Exception {
		extent.HeaderChildNode("Validating " + userType + " user navigates to Search landing screen");
		System.out.println("\nValidating " + userType + "user navigates to Search landing screen");
		waitTime(10000);
		verifyElementPresent(AMDLoginScreen.objHomeTab, "Home Tab");
		boolean liveTV = false;

		int noOfTabs = getCount(AMDHomePage.objTitle);
		for (int i = 1; i <= 10; i++) {
			String tabName = null;
			if (i == noOfTabs) {
				if (!liveTV) {
					i = noOfTabs - 1;
				}
				WebElement eleTab = getDriver()
						.findElement(By.xpath("(//*[@resource-id='com.graymatrix.did:id/title'])[" + i + "]"));
				tabName = eleTab.getText();
				System.out.println(tabName);
				eleTab.click();

			} else {
				WebElement eleTab = getDriver()
						.findElement(By.xpath("(//*[@resource-id='com.graymatrix.did:id/title'])[" + i + "]"));
				tabName = eleTab.getText();
				System.out.println(tabName);
				eleTab.click();
			}

			waitTime(2000);

			logger.info(tabName + " tab is displayed and clicked on " + tabName + " tab");
			extent.extentLogger("Search Icon", tabName + " tab is displayed and clicked on " + tabName + " tab");

			verifyElementPresentAndClick(AMDSearchScreen.objSearchIcon, "Search icon");
			waitTime(2000);

			if (verifyElementExist(AMDSearchScreen.objSearchEditBox, "Search box")) {
				logger.info("User navigated to Search Landing screen");
				extent.extentLogger("Search Screen", "User navigated to Search Landing screen");
			} else {
				logger.error("User not navigated to Search Landing screen");
				extent.extentLoggerFail("Search Screen", "User not navigated to Search Landing screen");
			}

			verifyElementPresentAndClick(AMDLoginScreen.objBackBtn, "Back Button");
			waitTime(2000);

			if (liveTV) {
				break;
			}
			if (tabName.equalsIgnoreCase("Live TV")) {
				liveTV = true;
			}
		}

		verifyElementPresentAndClick(AMDSearchScreen.objHomeOption, "Bottom bar Home Option");

	}

	public void verifySearchOption(String userType) throws Exception {
		extent.HeaderChildNode("Verify Search Icon on Landing pages as : " + userType);
		System.out.println("\nVerify Search Icon on Landing pages as " + userType);
		waitTime(10000);
		verifyElementPresent(AMDLoginScreen.objHomeTab, "Home Tab");
		boolean liveTV = false;

		int noOfTabs = getCount(AMDHomePage.objTitle);
		System.out.println("HOME PAGE HEADERS: " + noOfTabs);
		for (int i = 1; i <= 10; i++) {

			String tabName = null;
			if (i == noOfTabs) {
				if (!liveTV) {
					i = noOfTabs - 1;
				}
				WebElement eleTab = getDriver()
						.findElement(By.xpath("(//*[@resource-id='com.graymatrix.did:id/title'])[" + i + "]"));
				tabName = eleTab.getText();
				System.out.println(tabName);
				eleTab.click();

			} else {
				WebElement eleTab = getDriver()
						.findElement(By.xpath("(//*[@resource-id='com.graymatrix.did:id/title'])[" + i + "]"));
				tabName = eleTab.getText();
				System.out.println(tabName);
				eleTab.click();
			}

			waitTime(2000);

			logger.info(tabName + " tab is displayed and clicked on " + tabName + " tab");
			extent.extentLogger("Search Icon", tabName + " tab is displayed and clicked on " + tabName + " tab");

			WebElement elementSearchIcon = findElement(AMDSearchScreen.objSearchIcon);
			int SearchIconRightX = elementSearchIcon.getLocation().getX();
			System.out.println(SearchIconRightX);
			Dimension sizee = getDriver().manage().window().getSize();
//			System.out.println(sizee.getWidth());
			int sizeee = sizee.getWidth() - 300;
			System.out.println(sizee.getWidth() + " X " + sizeee);

			if (SearchIconRightX >= sizeee) {
				logger.info("Search icon is displayed at top right of the " + tabName + " tab ");
				extent.extentLogger("Search icon", "Search icon is displayed at top right of the " + tabName + " tab ");
			} else {
				logger.error("Search icon is not displayed at top right of the " + tabName + " tab ");
				extent.extentLoggerFail("Search icon",
						"Search icon is not displayed at top right of the " + tabName + " tab ");
			}
			if (liveTV) {
				break;
			}
			if (tabName.equalsIgnoreCase("Live TV")) {
				liveTV = true;
			}

		}

//		verifyElementPresent(AMDLoginScreen.objMenu, "Menu icon");
//		click(AMDLoginScreen.objMenu, "Menu icon");
//		
//       if(verifyElementExist(AMDSearchScreen.objSearchIcon, "Search Icon"))
//       {
//        
//        logger.info("Search icon is displayed at top right of the More Screen");
//		extent.extentLogger("Search icon", "Search icon is displayed at top right of the More Screen");
//       }
//       else
//       {
//    	   logger.info("Search icon is not displayed at top right of the More Screen");
//			   extent.extentLoggerFail("Search icon", "Search icon is not displayed at top right of the More Screen");
//       }
//		
		verifyElementPresentAndClick(AMDSearchScreen.objHomeOption, "Bottom bar Home Option");

	}

	/*
	 * =============================================================================
	 * ===== ------------------------------ Script Author: SUSHMA
	 * -------------------------------
	 * 
	 * List of Functions Created - DisplayLanguagePopUp(String userType, String
	 * displaylanguage1, String displaylanguage2) -
	 * DisplayLanguagePopUpValidation(String, String) - loginOrRegisterScreen(String
	 * inValidPhnNo, String validPhnNo, String loginThrough, String userType) -
	 * loginScreen(String validPassword) - OtpScreen(String otp1, String otp2,
	 * String otp3, String otp4) - TopSearches() -
	 * =============================================================================
	 * ========
	 */

	public void DisplayLanguagePopUpValidation(String displayLanguageSelection1, String displayLanguageSelection2)
			throws Exception {

		extent.HeaderChildNode("Display Language PopUp Validation");

		verifyElementPresent(AMDLoginScreen.objDisplayLanguageScreenTitle, "Display language screen Header");
		verifyElementPresent(AMDLoginScreen.objPageTitle, "Display language page title");
		verifyElementPresent(AMDOnboardingScreen.objDiplay_ContinueBtn, "Continue button");
		verifyElementPresent(AMDOnboardingScreen.objBackBtn, "Back button");

		verifyElementPresent(AMDLoginScreen.objSelectedDisplayLanguage, "Selected display language");
		String selectedlanguage = getText(AMDLoginScreen.objSelectedDisplayLanguage);
		logger.info(selectedlanguage + " language is selected by Default");
		extentLogger("Selected language", selectedlanguage + " language is selected by Default");

		click(AMDOnboardingScreen.objSelectDisplayLang(displayLanguageSelection2), "language");
		verifyElementPresent(AMDLoginScreen.objSelectedDisplayLanguage, "Selected display language");
		int totalSelectedLanguages = getDriver().findElements(AMDLoginScreen.objSelectedDisplayLanguage).size();
		logger.info(totalSelectedLanguages);

		if (totalSelectedLanguages == 1) {
			logger.info("User is able to select only one language from the display language list");
			extentLogger("Select one language",
					"User is able to select only one language from the display language list");
		}

		click(AMDOnboardingScreen.objSelectDisplayLang(displayLanguageSelection1), "English language");

		String pos1 = getAttributValue("bounds", AMDOnboardingScreen.objSelectDisplayLang(displayLanguageSelection1));
		String pos2 = null;

		HashSet<String> h = new HashSet<String>();

		for (int i = 0; i < 3; i++) {
			int totallangs = getDriver().findElements(By.xpath("//*[@id='display_language_content']")).size();
			for (int j = 1; j <= totallangs; j++) {
				String lang = getDriver().findElement(By.xpath("(//*[@id='display_language_content'])[" + j + "]"))
						.getText();
				h.add(lang);
			}
			Swipe("UP", 1);
			pos2 = getAttributValue("bounds", AMDOnboardingScreen.objSelectDisplayLang(displayLanguageSelection1));
		}
		System.out.println(h.size());
		if (h.size() == 11) {
			logger.info("Display language screen is displayed with all the display languages");
			extentLogger("Display Languages", "Display language screen is displayed with all the display languages");
		} else {
			logger.info("Display language screen is not displayed with all the display languages");
			extentLoggerFail("Display Languages",
					"Display language screen is not displayed with all the display languages");
		}
		if (pos1 != pos2) {
			logger.info("User is able to scroll up and down in the language list");
			extentLogger("Swipe", "User is able to scroll up and down in the language list");
		} else {
			logger.info("User is not able to scroll up and down in the language list");
			extentLoggerFail("Swipe", "User is not able to scroll up and down in the language list");
		}

		click(AMDOnboardingScreen.objDiplay_ContinueBtn, "Continue button");
		verifyElementPresent(AMDLoginScreen.objContentLanguageScreenTitle, "Content Language screen");
		Back(1);
//	verifyElementPresentAndClick(AMDOnboardingScreen.objContent_ContinueBtn, "Content Language PopUp Continue button");
//	relaunch();
//	if(getDriver().findElement(AMDOnboardingScreen.objBrowseForFreeBtn).isDisplayed())
//	{
//		logger.info("Display langauge screen is displayed only when user launch the app for the first time");
//		extentLogger("Display language", "Display langauge screen is displayed only when user launch the app for the first time");
//	}
	}

	public void loginOrRegisterScreen(String inValidPhnNo, String validPhnNo, String loginThrough, String userType)
			throws Exception {
		navigateToRegisterScreen(loginThrough);
//	verifyElementPresent(AMDOnboardingScreen.objBrowseForFreeBtn, "Browse for Free button");
//	String Browseforfreetxt = getText(AMDOnboardingScreen.objBrowseForFreeBtn);
//	logger.info(Browseforfreetxt);
//	click(AMDOnboardingScreen.objBrowseForFreeBtn, "Browse for Free button");
		extent.HeaderChildNode("Validating Login/Registration screen");
		if (userType.equals("Guest")) {
			WebElement element = findElement(AMDLoginScreen.objLoginOrRegisterPageTitle);
			int leftX = element.getLocation().getX();
			int rightX = leftX + element.getSize().getWidth();
			int middleX = (rightX + leftX) / 2;
			Dimension size = getDriver().manage().window().getSize();
			if (middleX == Integer.valueOf((size.width) / 2)) {
				logger.info("Login/Register screen title is displayed at center of the screen");
				extent.extentLogger("Screen Title", "Login/Register screen title is displayed at center of the screen");
			} else {
				logger.error("Login/Register screen title is not displayed at center of the screen");
				extent.extentLoggerFail("Screen Title",
						"Login/Register screen title is not displayed at center of the screen");
			}

			WebElement elementBackBtn = findElement(AMDLoginScreen.objBackBtn);
			int BackBtnleftX = elementBackBtn.getLocation().getX();
			int BAckBtnrightX = BackBtnleftX + elementBackBtn.getSize().getWidth();
			int BackBtnmiddleX = (BAckBtnrightX + BackBtnleftX) / 2;

			if (BackBtnmiddleX <= 200) {
				logger.info("Back button is displayed at top left of the screen");
				extent.extentLogger("Back button", "Back button is displayed at top left of the screen");
			} else {
				logger.error("Back button is not displayed at top left of the screen");
				extent.extentLoggerFail("Back button", "Back button is not displayed at top left of the screen");
			}

			WebElement elementSkipBtn = findElement(AMDLoginScreen.objLoginLnk);
			int SkipBtnRightX = elementSkipBtn.getLocation().getX();
			System.out.println(SkipBtnRightX);
			Dimension sizee = getDriver().manage().window().getSize();
			System.out.println(sizee.getWidth());
			int sizeee = sizee.getWidth() - 300;
			System.out.println(sizeee);

			if (SkipBtnRightX >= sizeee) {
				logger.info("Skip button is displayed at top right of the screen");
				extent.extentLogger("Skip button", "Skip button is displayed at top right of the screen");
			} else {
				logger.error("Skip button is not displayed at top right of the screen");
				extent.extentLoggerFail("Skip button", "Skip button is not displayed at top right of the screen");
			}

			verifyElementPresent(AMDLoginScreen.objGoogleBtn, "Goole icon");
			verifyElementPresent(AMDLoginScreen.objfbBtn, "Facebook icon");
			verifyElementPresent(AMDLoginScreen.objtwitterBtn, "Twitter icon");

			type(AMDLoginScreen.objEmailIdField, inValidPhnNo, "Email Id or Mobile Number field");
			hideKeyboard();
			verifyElementPresent(AMDLoginScreen.objErrorTxt, "Invalid Mobile number error message");

//			int ele=findElements(AMDLoginScreen.objProceedBtn).size();
			if (verifyElementPresent(AMDLoginScreen.objContinueWithTxt, "Continue with social login")) {
				logger.info("Proceed button is not displayed when user enters invalid mobile number");
				extentLogger("Proceed button",
						"Proceed button is not displayed when user enters invalid mobile number");
			}
			clearField(AMDLoginScreen.objEmailIdField, "Email Id");

			type(AMDLoginScreen.objEmailIdField, validPhnNo, "Email Id or Mobile Number field");
			hideKeyboard();
			verifyElementPresent(AMDLoginScreen.objProceedBtn, "Proceed button");

			boolean proceedbtn = getDriver().findElement(AMDLoginScreen.objProceedBtn).isEnabled();

			if (proceedbtn == true) {
				logger.info("Proceed button is highlighted when user enter valid Mobile number");
				extentLogger("ProceedButton", "Proceed button is highlighted when user enter valid Mobile number");
			}
			click(AMDLoginScreen.objProceedBtn, "Proceed button");
			if (verifyElementExist(AMDLoginScreen.objLoginScreenTitle, "Login screen title")) {
				logger.info("Proceed button is functional");
				extentLogger("Proceed button functionality", "Proceed button is functional");
			} else if (verifyElementExist(AMDLoginScreen.objRegistrationScreenTitle, "Registration screen title")) {
				logger.info("Proceed button is functional");
				extentLogger("Proceed button functionality", "Proceed button is functional");
			} else {
				logger.info("Proceed button is not functional");
				extentLoggerFail("Proceed button functionality", "Proceed button is not functional");
			}
		}
	}

	public void loginScreen(String validPassword) throws Exception {
		extent.HeaderChildNode("Login screen");
		verifyElementPresent(AMDLoginScreen.objPasswordField, "Password field");

		WebElement element = findElement(AMDLoginScreen.objLoginScreenTitle);
		int leftX = element.getLocation().getX();
		int rightX = leftX + element.getSize().getWidth();
		int middleX = (rightX + leftX) / 2;
		Dimension size = getDriver().manage().window().getSize();
		if (middleX == Integer.valueOf((size.width) / 2)) {
			logger.info("Login screen title is displayed at center of the screen");
			extent.extentLogger("Screen Title", "Login screen title is displayed at center of the screen");
		} else {
			logger.error("Login screen title is not displayed at center of the screen");
			extent.extentLoggerFail("Screen Title", "Login screen title is not displayed at center of the screen");
		}

		WebElement elementBackBtn = findElement(AMDLoginScreen.objBackBtn);
		int BackBtnleftX = elementBackBtn.getLocation().getX();
		int BAckBtnrightX = BackBtnleftX + elementBackBtn.getSize().getWidth();
		int BackBtnmiddleX = (BAckBtnrightX + BackBtnleftX) / 2;

		if (BackBtnmiddleX <= 200) {
			logger.info("Back button is displayed at top left of the screen");
			extent.extentLogger("Back button", "Back button is displayed at top left of the screen");
		} else {
			logger.error("Back button is not displayed at top left of the screen");
			extent.extentLoggerFail("Back button", "Back button is not displayed at top left of the screen");
		}

		click(AMDLoginScreen.objBackBtn, "Back button");
		verifyElementPresent(AMDLoginScreen.objLoginOrRegisterPageTitle, "Login/Register screen title");
		click(AMDLoginScreen.objProceedBtn, "Proceed button");

		String cursorAvailability = getAttributValue("focused", AMDLoginScreen.objPasswordField);
		if (cursorAvailability.equalsIgnoreCase("true")) {
			logger.info("Cursor is displayed on the Password field by default");
			extentLogger("Cursor", "Cursor is displayed on the Password field by default");
		} else {
			logger.info("Cursor is not displayed on the Password field by default");
			extentLoggerFail("Cursor", "Cursor is not displayed on the Password field by default");
		}

		String showpassword = getAttributValue("checked", AMDLoginScreen.objShowPwdBtn);
		if (showpassword.equalsIgnoreCase("false")) {
			logger.info("Password field text is hidden by default");
			extentLogger("Password hidden", "Password field text is hidden by default");
		} else {
			logger.info("Password field text is not hidden by default");
			extentLoggerFail("Password hidden", "Password field text is not hidden by default");
		}

		click(AMDLoginScreen.objShowPwdBtn, "Show password icon");

		findElement(
				By.xpath("//*[@resource-id='com.graymatrix.did:id/text_input_password_toggle' and @checked='true']"));
		logger.info("User can hide or unhide password using eye icon");
		extentLogger("Password field", "User can hide or unhide password using eye icon");

		click(AMDLoginScreen.objShowPwdBtn, "Show password icon");

		if (!(findElement(AMDLoginScreen.objLoginBtn).isEnabled())) {

			logger.info("Login CTA is displayed and is dehighlighted by default");
			extentLogger("Login button", "Login CTA is displayed and is dehighlighted by default");
		} else {
			logger.info("Login CTA is displayed and is not dehighlighted by default");
			extentLoggerFail("Login button", "Login CTA is displayed and is not dehighlighted by default");
		}

		verifyElementPresentAndClick(AMDLoginScreen.objForgetPwdBtn, "Forgot password link");
		verifyElementPresent(AMDLoginScreen.objForgotPasswordScreenTitle, "Forfot Password screen");
		click(AMDLoginScreen.objBackBtn, "Back button");

		type(AMDLoginScreen.objPasswordField, validPassword, "Password field");
//		hideKeyboard();
		String password = getText(AMDLoginScreen.objPasswordField);
		System.out.println(password.length());
		if (password.length() >= 6) {
			logger.info("Password field accepts minimum of six characters");
			extentLogger("Password field", "Password field accepts minimum of six characters");

			if (getDriver().findElement(AMDLoginScreen.objLoginBtn).isEnabled()) {
				logger.info("Login button is highlighted when user enters a minimum of 6 characters in password field");
				extentLogger("Login button",
						"the Login button is highlighted when user enters a minimum of 6 characters in password field");
			} else {
				logger.error(
						"Login button is not highlighted when user enters a minimum of 6 characters in password field");
				extentLoggerFail("Login button",
						"the Login button is not highlighted when user enters a minimum of 6 characters in password field");
			}
		} else {
			logger.info("Password field is not accepting minimum of six characters");
			extentLogger("Password field", "Password field is not accepting minimum of six characters");
		}
		hideKeyboard();
		click(AMDGenericObjects.objText("OR"), "OR text");
	}

	public void OtpScreen(String otp1, String otp2, String otp3, String otp4) throws Exception {
		extent.HeaderChildNode("Otp screen Validation");
		verifyElementPresentAndClick(AMDLoginScreen.objLoginWithOTPLink, "Login with OTP Link");

		WebElement element = findElement(AMDLoginScreen.objOtpScreenTitle);
		int leftX = element.getLocation().getX();
		int rightX = leftX + element.getSize().getWidth();
		int middleX = (rightX + leftX) / 2;
		Dimension size = getDriver().manage().window().getSize();
		if (middleX == Integer.valueOf((size.width) / 2)) {
			logger.info("Verify mobile screen title is displayed at center of the screen");
			extent.extentLogger("Screen Title", "Verify mobile screen title is displayed at center of the screen");
		} else {
			logger.error("Verify mobile screen title is not displayed at center of the screen");
			extent.extentLoggerFail("Screen Title",
					"Verify mobile screen title is not displayed at center of the screen");
		}

		WebElement elementBackBtn = findElement(AMDLoginScreen.objBackBtn);
		int BackBtnleftX = elementBackBtn.getLocation().getX();
		int BAckBtnrightX = BackBtnleftX + elementBackBtn.getSize().getWidth();
		int BackBtnmiddleX = (BAckBtnrightX + BackBtnleftX) / 2;

		if (BackBtnmiddleX <= 200) {
			logger.info("Back button is displayed at top left of the screen");
			extent.extentLogger("Back button", "Back button is displayed at top left of the screen");
		} else {
			logger.error("Back button is not displayed at top left of the screen");
			extent.extentLoggerFail("Back button", "Back button is not displayed at top left of the screen");
		}

		String cursorAvailability = getAttributValue("focused", AMDLoginScreen.objOtpEditBox1);
		if (cursorAvailability.equalsIgnoreCase("true")) {
			logger.info("Cursor is displayed on the first otp field by default");
			extentLogger("Cursor", "Cursor is displayed on the first otp field by default");
		} else {
			logger.info("Cursor is not displayed on the first otp field by default");
			extentLoggerFail("Cursor", "Cursor is not displayed on the first otp field by default");
		}
		click(AMDRegistrationScreen.objOTPField1, "First otp field");

//		if (findElements(AMDRegistrationScreen.objNumericKeypad).size() <= 20) {
//			logger.info("Numeric keypad is displayed in OTP screen");
//			extent.extentLogger("Numeric Keypad", "Numeric Keybpad is displayed in OTP screen");
//		}else {
//			logger.error("Numeric keypad is displayed in OTP screen");
//			extent.extentLoggerFail("Numeric Keypad", "Numeric keypad is not displayed in OTP screen");
//		}

		hideKeyboard();

		if (!(getDriver().findElement(AMDLoginScreen.objVerifyBtn).isEnabled())) {
			logger.info("Verify CTA is dehighlighted by default");
			extentLogger("Verify button", "Verify CTA is dehighlighted by default");
		} else {
			logger.info("Verify CTA is not dehighlighted by default");
			extentLoggerFail("Verify button", "Verify CTA is not dehighlighted by default");
		}

		if (getDriver().findElement(AMDLoginScreen.objResendOtpLink).isDisplayed()) {
			logger.info("Didn't get OTP text is displayed with Resend CTA");
			extentLogger("Resend button", "Didn't get OTP text is displayed with Resend CTA");
		} else {
			logger.info("Didn't get OTP text is not displayed with Resend CTA");
			extentLoggerFail("Resend button", "Didn't get OTP text is not displayed with Resend CTA");
		}

		if (getDriver().findElement(AMDLoginScreen.objOtp).isDisplayed()) {
			if (verifyElementExist(AMDLoginScreen.objCountDownTimer, "Count down Timer")) {
				logger.info("OTP is sent to the registered mobile number");
				extent.extentLogger("Otp", "OTP is sent to the registered mobile number");
			}

		}

		type(AMDLoginScreen.objOtpEditBox1, otp1, "first otp field");
		hideKeyboard();
		if (getDriver().findElement(AMDLoginScreen.objVerifyBtn).isEnabled() == false) {
			logger.info("Verify CTA is not highlighted");
			extentLogger("Verify button", "Verify CTA is not highlighted");
		}

		type(AMDLoginScreen.objOtpEditBox2, otp2, "second otp field");
		hideKeyboard();
		if (getDriver().findElement(AMDLoginScreen.objVerifyBtn).isEnabled() == false) {
			logger.info("Verify CTA is not highlighted");
			extentLogger("Verify button", "Verify CTA is not highlighted");
		}

		type(AMDLoginScreen.objOtpEditBox3, otp3, "third otp field");
		hideKeyboard();
		if (getDriver().findElement(AMDLoginScreen.objVerifyBtn).isEnabled() == false) {
			logger.info("Verify CTA is not highlighted");
			extentLogger("Verify button", "Verify CTA is not highlighted");
		}

		type(AMDLoginScreen.objOtpEditBox4, otp4, "fourth otp field");
		hideKeyboard();
		if (getDriver().findElement(AMDLoginScreen.objVerifyBtn).isEnabled()) {
			logger.info("Verify CTA is highlighted");
			extentLogger("Verify button", "Verify CTA is highlighted");
		} else {
			logger.info("Verify CTA is not highlighted");
			extentLoggerFail("Verify button", "Verify CTA is not highlighted");
		}

		click(AMDLoginScreen.objBackBtn, "Back button");
		verifyElementPresent(AMDLoginScreen.objLoginScreenTitle, "Login screen title");
		Back(1);
	}

	public void TopSearches(String usertype) throws Exception {
		extent.HeaderChildNode("Top Searches module");
		waitTime(5000);
		verifyElementPresentAndClick(AMDSearchScreen.objSearchIcon2, "Search icon");
		if (usertype.equalsIgnoreCase("NonSubscribedUser") || usertype.equalsIgnoreCase("SubscribedUser")) {

			int noOfTrays = findElements(AMDSearchScreen.objNoOftraysInSearchpage).size();
			System.out.println(noOfTrays);
			boolean TopSearchFound = false;
			for (int i = 1; i <= noOfTrays; i++) {
				String traytitle = getDriver()
						.findElement(
								By.xpath("(//*[@resource-id='com.graymatrix.did:id/header_primary_text'])[" + i + "]"))
						.getText();

				if (traytitle.equalsIgnoreCase("Top Searches")) {
					TopSearchFound = true;
					verifyElementExist(AMDSearchScreen.objTopSearches, "Top searches tray");

					verifyElementPresent(AMDSearchScreen.objContentCardTitleOfTopSearchesTray,
							"Content card title of Top searches tray");

					getText(AMDSearchScreen.objContentCardTitleOfTopSearchesTray);

//					click(AMDSearchScreen.objContentCardTitleOfTopSearchesTray, "Content card of Top searches tray");
//					waitForElementDisplayed(AMDSearchScreen.objConsumptionScreenTitle, 10);
//					
//					verifyElementPresent(AMDSearchScreen.objConsumptionScreenTitle, "Title in Consumption screen");
//					
//
//						String consumptionScreenTitle = getText(AMDSearchScreen.objConsumptionScreenTitle);
//						if(contentCardTitleofTopSearches.equalsIgnoreCase(consumptionScreenTitle))
//						{
//						    logger.info("user navigated to respective consumption/Landing screen post tapping on any Top searches carousel");	
//						    extent.extentLogger("Title", "user navigated to respective consumption/Landing screen post tapping on any Top searches carousel");
//						}
//						else
//						{
//							logger.info("user is not navigated to respective consumption/Landing screen post tapping on any Top searches carousel");	
//						    extent.extentLoggerFail("Title", "user is not navigated to respective consumption/Landing screen post tapping on any Top searches carousel");
//						}

					break;
				}
			}

			if (TopSearchFound == false) {
				logger.info("Top searches is not displayed");
				extentLoggerFail("Top searches tray", "Top searches is not displayed");
			}
			Back(1);
		} else {
			Back(1);
			selectContentLang_MoreMenu("Hindi");
		}
	}

	public void TrendingSearches() throws Exception {
		extent.HeaderChildNode("Trending Searches module");

		verifyElementPresentAndClick(AMDSearchScreen.objSearchIcon2, "Search icon");

		int noOfTrays = findElements(AMDSearchScreen.objNoOftraysInSearchpage).size();
		System.out.println(noOfTrays);
		boolean TrendingSearchFound = false;
		for (int i = 1; i <= noOfTrays; i++) {
			String traytitle = getDriver()
					.findElement(By.xpath("(//*[@resource-id='com.graymatrix.did:id/header_primary_text'])[" + i + "]"))
					.getText();

			if (traytitle.equalsIgnoreCase("Trending Searches")) {
				TrendingSearchFound = true;
//				    verifyElementPresentAndClick(AMDSearchScreen.objSearchEditBox, "Search Box");
//				    type(AMDSearchScreen.objSearchBar, "Milana", "Search bar");
//					
//					verifyElementPresentAndClick(AMDSearchScreen.objSearchResultFirstContent, "content");
//					verifyElementExist(AMDSearchScreen.objConsumptionScreenTitle, "Title in Consumption screen");
//					Back(2);
//					waitTime(3000);
//					verifyElementPresentAndClick(AMDSearchScreen.objSearchIcon2, "Search icon");
//					
//					verifyElementPresent(AMDSearchScreen.objTrendingSearches, "Trending Searches tray");

				verifyElementPresent(AMDSearchScreen.objContentCardTitleOfTrendingSearchesTray,
						"Content card title of Trending searches tray");

				getText(AMDSearchScreen.objContentCardTitleOfTrendingSearchesTray);

//					click(AMDSearchScreen.objContentCardTitleOfTrendingSearchesTray, "Content card of Trending searches tray");
//					waitForElementDisplayed(AMDSearchScreen.objConsumptionScreenTitle, 10);
//					
//					verifyElementPresent(AMDSearchScreen.objConsumptionScreenTitle, "Title in Consumption screen");
//					
//						String consumptionScreenTitle = getText(AMDSearchScreen.objConsumptionScreenTitle);
//						if(contentCardTitleofTrendingSearches.equalsIgnoreCase(consumptionScreenTitle))
//						{
//						    logger.info("user navigated to respective consumption/Landing screen post tapping on any Trending searches carousel");	
//						    extent.extentLogger("Title", "user navigated to respective consumption/Landing screen post tapping on any Trending searches carousel");
//						}
//						else
//						{
//							logger.info("user is not navigated to respective consumption/Landing screen post tapping on any Trending searches carousel");	
//						    extent.extentLoggerFail("Title", "user is not navigated to respective consumption/Landing screen post tapping on any Trending searches carousel");
//						}

				break;
			}
		}

		if (TrendingSearchFound == false) {
			logger.info("Trending searches is not displayed");
			extentLoggerFail("Trending searches tray", "Trending searches is not displayed");
		}
		Back(1);
	}

	/*
	 * =============================================================================
	 * ===== ------------------------------ Script Author: VINAY
	 * ---------------------------------
	 * 
	 * List of Functions Created - IntroScreen(String userType) - -
	 * =============================================================================
	 * ========
	 */
	public void IntroScreen(String userType) throws Exception {
		extent.HeaderChildNode("Validating Intro screen module");
		// Verify user is navigated to intro screen
		if (userType.equals("Guest")) {
			if (findElement(AMDOnboardingScreen.objScreenTitle).getText().equals("ZEE5")) {
				String ZEE5 = getDriver().findElement(AMDOnboardingScreen.objScreenTitle).getText();
				extent.extentLogger("Verify user is navigated to Login/Registration screen",
						"User is navigated to " + ZEE5 + " Screen");
				logger.info("User is navigated to " + ZEE5 + " Screen after clicking on Browse for free");
			} else {
				extent.extentLoggerFail("Verify user is navigated to Login/Registration screen",
						"Intro screeen in not displayed");
				logger.info("Intro screeen in not displayed");
			}
			// Verify back button is displayed
			verifyElementPresent(AMDOnboardingScreen.objBackBtn, "Back button");
			// Verify user is navigated to Content language screeen post tapping back button
			click(AMDOnboardingScreen.objBackBtn, "Back button");
			String contentLang = getDriver().findElement(AMDOnboardingScreen.objScreenTitle).getText();
			if (contentLang.equals("Content Language")) {
				extent.extentLogger("Verify user is navigated to Content language screen",
						"User is navigated to " + contentLang + " scree");
				logger.info("User is navigated to " + contentLang + " screen");
			} else {
				extent.extentLogger("Verify user is navigated to Content language screen",
						"Failed to navigate into content language screen");
				logger.info("Failed to navigate into content language screen");
			}

			// Covered few TC's and Updated Code by Kushal

			click(AMDOnboardingScreen.objBackBtn, "Back button");
			verifyElementPresent(AMDGenericObjects.objCheckTitle("Display Language"), "Display language screen");
			click(AMDOnboardingScreen.objSelectDisplayLang("Kannada"), "Kannada language");
			click(AMDOnboardingScreen.objDiplay_ContinueBtn, "[Display Language] Continue Button");

			String strLang = findElement(AMDOnboardingScreen.objScreenTitle).getText();
			if (strLang != "Content Language") {

				extent.extentLogger("Content language screen", "Content language is displayed in Kannada language");
				logger.info("Title of the screen : " + strLang + " is displayed in selected language");
			} else {
				extent.extentLoggerFail("Content language screen",
						"Failed to display the content language in selected language");
				logger.error("Failed to display the content language in selected language");
			}

			click(AMDOnboardingScreen.objContent_ContinueBtn, "Continue Button");

			if (findElement(AMDOnboardingScreen.objBrowseForFreeBtn).getText() != "Browse for Free") {
				String strBrwsforFree = findElement(AMDOnboardingScreen.objBrowseForFreeBtn).getText();
				extent.extentLogger("Intro screen",
						"Browse for free button is displayed in selected launguage: " + strBrwsforFree);
				logger.info("Browse for free button is displayed in selected launguage : " + strBrwsforFree);
			} else {
				extent.extentLoggerFail("Intro screen",
						"Browse for free button failed to displayed in selected launguage");
				logger.error("Browse for free button failed to displayed in selected launguage");
			}
			String strSubsNow = findElement(AMDOnboardingScreen.objSubscribeNowBtn).getText();
			if (strSubsNow != "Subscribe Now") {
				extent.extentLogger("Intro screen",
						"Subscribe Now button is displayed in selected launguage: " + strSubsNow);
				logger.info("Subscribe Now button is displayed in selected launguage : " + strSubsNow);
			} else {
				extent.extentLoggerFail("Intro screen",
						"Subscribe Now button failed to displayed in selected launguage: " + strSubsNow);
				logger.error("Subscribe Now button failed to displayed in selected launguage: " + strSubsNow);
			}
			String strHavePrepaidCode = findElement(AMDOnboardingScreen.objHavePrepaidBtn).getText();
			if (strHavePrepaidCode != "Have a prepaid code") {
				extent.extentLogger("Intro screen",
						"Have a Prepaid code CTA is displayed in selected launguage: " + strHavePrepaidCode);
				logger.info("Have a Prepaid code CTA is displayed in selected launguage: " + strHavePrepaidCode);
			} else {
				extent.extentLoggerFail("Intro screen",
						"Have a Prepaid code CTA failed to displayed in selected launguage: " + strHavePrepaidCode);
				logger.error(
						"Have a Prepaid code CTA failed to displayed in selected launguage: " + strHavePrepaidCode);
			}
			String strLoginCTA = findElement(AMDOnboardingScreen.objLoginLnk).getText();
			if (strHavePrepaidCode != "Login") {
				extent.extentLogger("Intro screen", "Login CTA is displayed in selected launguage: " + strLoginCTA);
				logger.info("Login CTA is displayed in selected launguage: " + strLoginCTA);
			} else {
				extent.extentLoggerFail("Intro screen",
						"Login CTA failed to displayed in selected launguage: " + strLoginCTA);
				logger.error("Login CTA failed to displayed in selected launguage: " + strLoginCTA);
			}
			Back(2);
			if (findElement(AMDOnboardingScreen.objSelectedDisplayLang).getText() != "English") {
				click(AMDOnboardingScreen.objSelectDisplayLang("English"), "English language");
				click(AMDOnboardingScreen.objDiplay_ContinueBtn, "[Display Language] Continue Button");
			}
			// ***********************************************************

			click(AMDOnboardingScreen.objContent_ContinueBtn, "[Content Language] Continue button");
			// Verify Login button is displayed
			verifyElementExist(AMDOnboardingScreen.objLoginLnk, "Login button");

			// Verify user is navigated to Login Registration screen
			click(AMDOnboardingScreen.objLoginLnk, "Login button");
			hideKeyboard();
			// Click operation is used for the device which do not identify the keyboard
			click(AMDLoginScreen.objContinueWithTxt, "Or Continue with");
			if (findElement(AMDOnboardingScreen.objScreenTitle).getText().equals("Login/Register")) {
				extent.extentLogger("Verify Navigation on clicking Login button",
						"User is navigated to" + findElement(AMDOnboardingScreen.objScreenTitle).getText() + " screen");
				logger.info("User is navigated to " + findElement(AMDOnboardingScreen.objScreenTitle).getText()
						+ " screen");
			} else {
				extent.extentLogger("Verify Navigation on clicking Login button",
						"Failed to navigate into Login/Register screen post tapping Login button");
				logger.info("Failed to navigate into Login/Register screen post tapping Login button");
			}
			click(AMDOnboardingScreen.objBackBtn, "Back button");
			// Verify that content feature carousel is displayed
			verifyElementExist(AMDOnboardingScreen.objFeatureCarousel, "Feature carousel rail");
			// Verify that Preminum member benifits section is displayed
			verifyElementExist(AMDOnboardingScreen.objBenefitsTextSection, "Benifits of premium member section");
			// Verify that pagination dots are displayed
			verifyElementExist(AMDOnboardingScreen.objDotsIndicator, "Pagination dots");
			// Verify Browse for free is displayed
			verifyElementExist(AMDOnboardingScreen.objBrowseForFreeBtn, "Browse for free");

			// Verify user is navigated to Login/Registration page post tapping Browse for
			// free
			click(AMDOnboardingScreen.objBrowseForFreeBtn, "Browse for free");
			if (findElement(AMDOnboardingScreen.objScreenTitle).getText().equals("Login/Register")) {
				extent.extentLogger("Verify Navigation on clicking Browse for Free button",
						"User is navigated to" + findElement(AMDOnboardingScreen.objScreenTitle).getText() + " screen");
				logger.info("User is navigated to " + findElement(AMDOnboardingScreen.objScreenTitle).getText()
						+ " screen");
			} else {
				extent.extentLogger("Verify Navigation on clicking Browse for Free button",
						"Failed to navigate into Login/Register screen post tapping Browse for Free button");
				logger.info("Failed to navigate into Login/Register screen post tapping Browse for Free button");
			}
			click(AMDOnboardingScreen.objBackBtn, "Back button");

			// Verify that Subscribe Now button is available
			verifyElementPresentAndClick(AMDOnboardingScreen.objSubscribeNowBtn, "Subcribe Now button");

			// Verify user is navigated to Subscribe now screen

			waitTime(2000);
			if (findElement(AMDOnboardingScreen.objScreenTitle).getText().equals("Subscribe")) {
				extent.extentLogger("Verify Navigation on clicking Subscribe Now button",
						"User is navigated to" + findElement(AMDOnboardingScreen.objScreenTitle).getText() + " screen");
				logger.info("User is navigated to " + findElement(AMDOnboardingScreen.objScreenTitle).getText()
						+ " screen");
			} else {
				extent.extentLogger("Verify Navigation on clicking Subcribe button",
						"Failed to navigate into Subscribe screen post tapping Subscribe Now button");
				logger.info("Failed to navigate into Subscribe screen post tapping Subcribe Now button");
			}
			click(AMDOnboardingScreen.objBackBtn, "Back button");

			// Verify that Have a prepaid code? is displayed
			verifyElementPresentAndClick(AMDOnboardingScreen.objHavePrepaidBtn, "Have a preapaid code? button");

			// Verify Prepaid code screen is displayed after tapping on Prepaid code button
			if (findElement(AMDOnboardingScreen.objPrepaidPopupLabel).isDisplayed()) {
				extent.extentLogger("Verify navigation post tapping Prepaid code button", "User is navigated to "
						+ findElement(AMDOnboardingScreen.objPrepaidPopupLabel).getText() + " Screen");
				logger.info("User is navigated to " + findElement(AMDOnboardingScreen.objPrepaidPopupLabel).getText()
						+ " Screen");
			} else {
				extent.extentLogger("Verify navigation post tapping Prepaid code button",
						"Failed to navigate into Prepaid screen post tapping Have a prepaid code button");
				logger.info("Failed to navigate into Prepaid screen post tapping Have a prepaid code button");
			}
			Back(1);
		} else {
			extent.extentLogger("Intro Screen", "Intro Screen is not displayed for Susbcribed/Non-Subscribed user");
			logger.info("Intro Screen is not displayed for Susbcribed/Non-Subscribed user");
			System.out.println("Intro Screen is not displayed for Susbcribed/Non-Subscribed user");
		}
	}

	/*
	 * =============================================================================
	 * ===== ------------------------------ Script Author: HITESH
	 * -------------------------------
	 * 
	 * Functions Created list - navigateToRegisterScreen(String loginThrough) -
	 * validateRegister(String firstName, String secoundName) -
	 * checkRegisterButton() - deepLinks(String tabName) - relaunch() -
	 * registerForFreeScreen()
	 * =============================================================================
	 * ========
	 */

	public void navigateToRegisterScreen(String loginThrough) throws Exception {
		if (loginThrough.equals("BrowseForFree")) {
			HeaderChildNode("Validate Browse for Free Button functionality");
			verifyElementExist(AMDOnboardingScreen.objBrowseForFreeBtn, "Browse for Free button");
			logger.info("Browse for Free button is displayed in language : "
					+ getText(AMDOnboardingScreen.objBrowseForFreeBtn));
			extent.extentLogger("Browse for Free button", "Browse for Free button is displayed in language : "
					+ getText(AMDOnboardingScreen.objBrowseForFreeBtn));

			verifyElementPresentAndClick(AMDOnboardingScreen.objBrowseForFreeBtn, "Browse for Free");

			if (verifyElementExist(AMDLoginScreen.objLoginLnk, "Login link")) {
				logger.info("Login/Register Screen is displayed");
				extent.extentLogger("Login/Register Screen", "Login/Register Screen is displayed");
			} else {
				logger.info("Login/Register Screen is not displayed");
				extent.extentLogger("Login/Register Screen", "Login/Register Screen is not displayed");
			}

		} else if (loginThrough.equals("login")) {
			HeaderChildNode("Validate Login/Register Screen");
			verifyElementPresentAndClick(AMDLoginScreen.objLoginLnk, "Login link");
		}

	}

	public void validateRegister(String firstName, String secoundName) throws Exception {
		waitTime(8000);
		String pEmailID = generateRandomString(5) + "@gmail.com";
		type(AMDRegistrationScreen.objEmailIDTextField, pEmailID, "Email field");
		verifyElementPresentAndClick(AMDRegistrationScreen.objProceedBtn, "Proceed button");
		verifyElementPresent(AMDRegistrationScreen.objScreenTitle, "Register for Free screen");
		HeaderChildNode("Validate fields of Register screen");
		WebElement element = findElement(AMDRegistrationScreen.objScreenTitle);
		int leftX = element.getLocation().getX();
		int rightX = leftX + element.getSize().getWidth();
		int middleX = (rightX + leftX) / 2;
		Dimension size = getDriver().manage().window().getSize();
		if (middleX == Integer.valueOf((size.width) / 2)) {
			logger.info("Register for Free Title is displayed at center of the screen");
			extent.extentLogger("Screen Title", "Register for Free Title is displayed at center of the screen");
		} else {
			logger.error("Register for Free Title is not displayed at center of the screen");
			extent.extentLoggerFail("Screen Title", "Register for Free Title is not displayed at center of the screen");
		}

		WebElement elementBackBtn = findElement(AMDRegistrationScreen.objBackBtn);
		int BackBtnleftX = elementBackBtn.getLocation().getX();
		int BAckBtnrightX = BackBtnleftX + elementBackBtn.getSize().getWidth();
		int BackBtnmiddleX = (BAckBtnrightX + BackBtnleftX) / 2;

		if (BackBtnmiddleX <= 200) {
			logger.info("Back button is displayed at top left of the screen");
			extent.extentLogger("Back button", "Back button is displayed at top left of the screen");
		} else {
			logger.error("Back button is not displayed at top left of the screen");
			extent.extentLoggerFail("Back button", "Back button is not displayed at top left of the screen");
		}

		if (getAttributValue("focused", AMDRegistrationScreen.objFirstNameTxtField).equals("true")) {
			logger.info("First Name field is focused");
			extent.extentLogger("First Name field", "First Name field is focused");
		} else {
			logger.error("First Name field is not focused");
			extent.extentLoggerFail("First Name field", "First Name field is not focused");
		}

		checkRegisterButton();
		verifyElementExist(AMDRegistrationScreen.objEmailIDTextField, "Email ID or Mobile number");

		if (!findElement(AMDRegistrationScreen.objEmailIDTextField).isEnabled()) {
			logger.info("“Email ID or Mobile number” field is grayed out");
			extent.extentLogger("“Email ID or Mobile number”", "“Email ID or Mobile number” field is grayed out");
		} else {
			logger.error("“Email ID or Mobile number” field is not grayed out");
			extent.extentLoggerFail("“Email ID or Mobile number”",
					"“Email ID or Mobile number” field is not grayed out");
		}

		String EmailBeforeType = getText(AMDRegistrationScreen.objEmailIDTextField);
		type(AMDRegistrationScreen.objEmailIDTextField, pEmailID, "Email field");
		String EmailAfterType = getText(AMDRegistrationScreen.objEmailIDTextField);
		if (EmailBeforeType.equalsIgnoreCase(EmailAfterType)) {
			logger.info("User is not allowed to edit the Email field");
			extent.extentLogger("Email field", "User is not allowed to edit the Email field");
		} else {
			logger.error("User is allowed to edit the Email field");
			extent.extentLoggerFail("Email field", "User is allowed to edit the Email field");
		}

		verifyElementExist(AMDRegistrationScreen.objFirstNameTxtField, "First Name field");
		verifyElementExist(AMDRegistrationScreen.objLastNameTxtField, "Last Name field");

		type(AMDRegistrationScreen.objFirstNameTxtField, firstName, "First Name field");
		checkRegisterButton();
		type(AMDRegistrationScreen.objLastNameTxtField, secoundName, "Last Name field");
		checkRegisterButton();
		verifyElementExist(AMDRegistrationScreen.objDOBCalenderBtn, "DOB Icon");
		click(AMDRegistrationScreen.objDOBTxtField, "Date of Birth");
		verifyElementExist(AMDRegistrationScreen.objCalenderPopUp, "Calender PopUp");

		// get a calendar instance, which defaults to "now"
		Calendar calendar = Calendar.getInstance();
		// add one day to the date/calendar
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		// now get "tomorrow"
		Date tomorrow = calendar.getTime();

		verifyElementPresent(AMDOnboardingScreen.objNextDate(tomorrow.toString().split(" ")[2].replace("0", "")),
				"Future date " + tomorrow.toString().split(" ")[2]);
//	
//    if(verifyElementExist(AMDOnboardingScreen.objNextBtnPopUpInCalender, "Next Button in calender")) 
//    {
//    	logger.info("Next Button in calender is not available to select Future date ");
//		extent.extentLogger("Next button", "Next Button in calender is not available to select Future date ");
//    }else {
//    	logger.info("Next Button in calender is available to select Future date ");
//		extent.extentLogger("Next button", "Next Button in calender is available to select Future date ");
//    }

		String DMD = getText(AMDRegistrationScreen.objMonthDayDate);
		System.out.println(DMD + " " + (tomorrow.toString().substring(0, 11)));
		if (!DMD.contains(tomorrow.toString().substring(0, 11))) {
			logger.info("Future date is not allowed for select");
			extent.extentLogger("Future button", "Future date is not allowed for select");
		} else {
			logger.info("Future date is allowed for select");
			extent.extentLogger("Future button", "Future date is allowed for select");
		}

		LocalDate currentDate = LocalDate.now();
		int dom = currentDate.getDayOfMonth();
		Month month = currentDate.getMonth();
		int currentyear = currentDate.getYear();

		int year = Integer.valueOf(getText(AMDRegistrationScreen.objHeaderYearTxt));

		String DayMonth = DMD.split(",")[1];
		if (DayMonth.toLowerCase().contains(month.toString().substring(0, 2).toLowerCase())) {
			logger.info("Current Month is displayed");
			extent.extentLogger("Current Month", "Current Month is displayed");
		} else {
			logger.error("Current Month is not displayed");
			extent.extentLoggerFail("Current month", "Current Month is not displayed");
		}

		if (DayMonth.contains(String.valueOf(dom))) {
			logger.info("Current date is displayed");
			extent.extentLogger("Current date", "Current date is displayed");
		} else {
			logger.error("Current date is not displayed");
			extent.extentLoggerFail("Current date", "Current date is not displayed");
		}
		if ((currentyear - 18) == year) {
			logger.info("Current year is displayed");
			extent.extentLogger("Current year", "Current year is displayed");
		} else {
			logger.error("Current year is not displayed");
			extent.extentLoggerFail("Current year", "Current year is not displayed");
		}

		verifyElementExist(AMDRegistrationScreen.objCancelBtn, "Cancel button in calender popUp");
		verifyElementPresentAndClick(AMDRegistrationScreen.objOkBtn, "Ok button in calender popUp");

		verifyElementPresentAndClick(AMDRegistrationScreen.objGederTxtField, "Gender field");
		verifyElementExist(AMDRegistrationScreen.objSelectGenderText, "Select your Gender screen");

		WebElement GenderTotleElement = findElement(AMDRegistrationScreen.objSelectGenderText);
		int GenderTotleleftX = GenderTotleElement.getLocation().getX();
		int GenderTotlerightX = GenderTotleleftX + GenderTotleElement.getSize().getWidth();
		int GenderTotlemiddleX = (GenderTotlerightX + GenderTotleleftX) / 2;
		Dimension windowSize = getDriver().manage().window().getSize();
		if (GenderTotlemiddleX == Integer.valueOf((windowSize.width) / 2)) {
			logger.info("Select your gender screen title is displayed at the center of the screen");
			extent.extentLogger("Screen Title",
					"Select your gender screen title is displayed at the center of the screen");
		} else {
			logger.error("Select your gender screen title is not displayed at the center of the screen");
			extent.extentLoggerFail("Screen Title",
					"Select your gender screen title is not displayed at the center of the screen");
		}

		verifyElementExist(AMDRegistrationScreen.objSelecteGender, "Tick mark on the selected option");
		String selectedGender = getText(AMDRegistrationScreen.objSelectedGenderName);
		logger.info("Selected Gender : " + selectedGender);
		extent.extentLogger("Select Gender", "Selected Gender : " + selectedGender);

		WebElement CloseIconElement = findElement(AMDRegistrationScreen.objXMark);
		int CloseIconupperY = CloseIconElement.getLocation().getY();
		int CloseIconlowerY = CloseIconupperY + CloseIconElement.getSize().getHeight();
		int CloseIconmiddleY = (CloseIconupperY + CloseIconlowerY) / 2;

		Dimension windowsSize = getDriver().manage().window().getSize();

		if (CloseIconmiddleY >= ((windowsSize.getHeight() / 2) + 100)) {
			logger.info("X icon appears on the bottom of the screen");
			extent.extentLogger("Select Gender", "X icon appears on the bottom of the screen");
		} else {
			logger.error("X icon is not appears on the bottom of the screen");
			extent.extentLoggerFail("Select Gender", "X icon is not appears on the bottom of the screen");
		}
		click(AMDRegistrationScreen.objMale, "Gender : Male");
		checkRegisterButton();

		verifyElementExist(AMDRegistrationScreen.objPasswordTxtField, "Set Password");
		click(AMDRegistrationScreen.objPasswordTxtField, "Set Password");
		type(AMDRegistrationScreen.objPasswordTxtField, generateRandomString(4), "entered 5 charecter in set password");
		hideKeyboard();
		verifyElementExist(AMDRegistrationScreen.objPasswordErrorMsg,
				"“Password must be a minimum of 6 characters” error message");
		type(AMDRegistrationScreen.objPasswordTxtField, generateRandomString(6), "entered 6 charecter in set password");

		for (int i = 0; i < 2; i++) {
			String eyeIcon = getAttributValue("checked", AMDRegistrationScreen.objEyeIcon);
			if (eyeIcon.equals("false")) {
				logger.info("Password is hide");
				extent.extentLogger("Password hide eye icon", "Password is hide");
			} else {
				logger.info("Password is visible");
				extent.extentLogger("Password hide eye icon", "Password is visible");
			}
			click(AMDRegistrationScreen.objEyeIcon, "Eye Icon");
		}
		click(AMDRegistrationScreen.objFirstNameTxtField, "First name"); // Clicking on First Name field to get device
																			// keyboard
		hideKeyboard();
		checkRegisterButton();
//	if(relaunch) {
//		verifyElementPresentAndClick(AMDRegistrationScreen.objRegisterBtn, "Register button");
//		verifyElementPresent(AMDHomePage.objHomeTab, "Home page");
//	}
	}

	public void checkRegisterButton() throws Exception {
		if (getAttributValue("clickable", AMDRegistrationScreen.objRegisterBtn).equals("false")) {
			logger.info("Register CTA is displayed and is dehighlated by default");
			extent.extentLogger("Register button", "Register CTA is displayed and is dehighlated by default");
		} else {
			logger.info("Register CTA is Activated");
			extent.extentLogger("Register button", "Register CTA is Activated");
		}
	}

	public void deepLinks(String tabName) {
		try {
			getDriver().close();
			waitTime(5000);
			String cmd3 = "adb shell am start -W -a android.intent.action.VIEW -d  \"https://www.zee5.com/" + tabName
					+ "\" com.graymatrix.did";
			Process process = Runtime.getRuntime().exec(cmd3);
			new BufferedReader(new InputStreamReader(process.getInputStream()));
			waitTime(12000);
			HeaderChildNode("DeepLink");
			if (tabName.contains("Home")) {
				verifyElementExist(AMDHomePage.objHomeTab, "Home screen");
				if (!verifyElementExist(AMDLoginScreen.objPageTitle, "Display language")) {
					if (!verifyElementExist(AMDOnboardingScreen.objContentLanguagePageTitle, "Content language")) {
						logger.info("Display Language and Content Language not displayed for deeplink");
						extent.extentLogger("Language popup",
								"Display Language and Content Language not displayed for deeplink");
					}
				}

			} else {
				if (verifyElementExist(AMDLoginScreen.objLoginLnk, "Login/Register Screen")) {
					logger.info("Login/Register Screen is displayed for deeplink");
					extent.extentLogger("Language popup", "Login/Register Screen is displayed for deeplink");
				}
			}
			waitTime(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * =============================================================================
	 * ===== ------------------------------ Script Author: MANASA
	 * ---------------------------------
	 * 
	 * List of Functions Created - ZeeApplicasterLogin(String LoginMethod) -
	 * offlineScreenValidation() - socialLoginValidation(String loginThrough) -
	 * =============================================================================
	 * =========
	 */

	public void ZeeApplicasterLogin(String LoginMethod) throws Exception {
		extent.HeaderChildNode("Login Functionality");

		String UserType = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("userType");
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

			String Username = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("NonsubscribedUserName");
			String Password = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("NonsubscribedPassword");

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

			String SubscribedUsername = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("SubscribedUserName");
			String SubscribedPassword = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("SubscribedPassword");

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

	public void offlineScreenValidation() throws Exception {

		extent.HeaderChildNode("Offline Screen Validation");
		System.out.println("\nOffline Screen Validation");

		Runtime.getRuntime().exec("adb shell svc wifi disable");
		if (getOEMName.equalsIgnoreCase("Sony")) {
			Wifi_TurnOFFnON();
		}

		if (pUserType.contains("Guest")) {
			verifyElementPresentAndClick(AMDHomePage.objMoviesTab, "Movies tab");
		}

		verifyElementExist(AMDOfflineScreen.objYouAreOffline, "You are Offline");
		verifyElementExist(AMDOfflineScreen.objTryAgain, "Try Again");
		verifyElementExist(AMDOfflineScreen.objGoToDownloads, "Go to Downloads");
		verifyElementExist(AMDHomePage.objHome, "Home");
		verifyElementExist(AMDHomePage.objUpcoming, "Upcoming");
		verifyElementExist(AMDHomePage.objDownload, "Download");
		verifyElementExist(AMDHomePage.objMoreMenu, "More Menu");

		click(AMDHomePage.objUpcoming, "Upcoming");
		verifyElementExist(AMDOfflineScreen.objYouAreOffline, "You are Offline");
		click(AMDHomePage.objMoreMenu, "More Menu");
		verifyElementExist(AMDOfflineScreen.objYouAreOffline, "You are Offline");

		// verifyElementPresentAndClick(AMDOfflineScreen.objGoToDownloads, "Go to
		// Downloads");

		verifyElementPresentAndClick(AMDHomePage.objDownload, "Download");
		if (verifyElementExist(AMDOfflineScreen.objDownloadScreen, "Download Section")) {
			logger.info("Navigated to Download Section");
			extent.extentLogger("Download Section", "Navigated to Download Section");
		} else {
			logger.info("Not navigated to Download Section");
			extent.extentLogger("Download Section", "Not navigated to Download Section");
		}
		verifyElementPresentAndClick(AMDHomePage.objHome, "Home Tab");
		verifyElementPresentAndClick(AMDOfflineScreen.objTryAgain, "Try Again");
		Runtime.getRuntime().exec("adb shell svc wifi enable");
		if (getOEMName.equalsIgnoreCase("Sony")) {
			Wifi_TurnOFFnON();
		}
		waitTime(5000);
		verifyElementPresentAndClick(AMDHomePage.objUpcoming, "Upcoming tab");

		waitForElementDisplayed(AMDUpcomingPage.objContentCardTitle, 10);
		if (verifyElementExist(AMDUpcomingPage.objContentCardTitle, "Upcoming Page Content Card")) {
			logger.info("Appropriate page is loaded");
			extent.extentLogger("Page", "Appropriate page is loaded");
		} else {
			logger.info("Appropriate page is not loaded");
			extent.extentLogger("Page", "Appropriate page is not loaded");
		}
	}

	public void Wifi_TurnOFFnON() throws Exception {
		Runtime.getRuntime()
				.exec("adb shell am start -a android.intent.action.MAIN -n com.android.settings/.wifi.WifiSettings");
		waitTime(2000);
//		Runtime.getRuntime().exec("adb shell input keyevent 23");
		verifyElementPresentAndClick(AMDGenericObjects.objWifiToggle, "Wifi-Toggle button");
		waitTime(2000);
		Runtime.getRuntime().exec("adb shell monkey -p com.graymatrix.did -c android.intent.category.LAUNCHER 1");
	}

	public void socialLoginValidation(String loginThrough) throws Exception {
		extent.HeaderChildNode("Social Login Validation");
		verifyElementPresentAndClick(AMDOnboardingScreen.objDiplay_ContinueBtn, "Continue button");
		verifyElementPresentAndClick(AMDOnboardingScreen.objContent_ContinueBtn,
				"Continue button in content language screen");
		navigateToRegisterScreen(loginThrough);
		// verifyElementPresentAndClick(AMDLoginScreen.objLoginLnk, "Login link");
		verifyElementPresentAndClick(AMDLoginScreen.objGoogleBtn, "Gmail icon");

		if (verifyElementExist(AMDLoginScreen.objGmailSignIn, "Gmail Sign In")) {
			verifyElementPresentAndClick(AMDLoginScreen.objGmailEmailField, "Email Field");
			type(AMDLoginScreen.objGmailEmailField, "zeetest55@gmail.com", "Email Field");
			verifyElementPresentAndClick(AMDLoginScreen.objGmailNextBtn, "Next Button");
			verifyElementPresentAndClick(AMDLoginScreen.objGmailPasswordField, "Password Field");
			type(AMDLoginScreen.objGmailPasswordField, "zeetest123", "Password Field");
			verifyElementPresentAndClick(AMDLoginScreen.objGmailNextBtn, "Next Button");

			if (verifyElementExist(AMDLoginScreen.objGmailAddPhoneNumber, "Add Phone Number")) {
				verifyElementPresentAndClick(AMDLoginScreen.objSkipBtn, "Skip Button");
			}
			if (verifyElementExist(AMDLoginScreen.objAgreeBtn, "Agree Button")) {
				click(AMDLoginScreen.objAgreeBtn, "Agree Button");
			}

			if (verifyElementExist(AMDLoginScreen.objAcceptBtn, "Accept Button")) {
				click(AMDLoginScreen.objAcceptBtn, "Accept Button");
			}
		}

		if (verifyElementExist(AMDLoginScreen.objGmailAccount, "Gmail Account")) {
			click(AMDLoginScreen.objGmailAccount, "Gmail Account");
			waitTime(5000);
		}
		if (verifyElementExist(AMDOnboardingScreen.objTellUsMore, "More info Screen")) {
			if (verifyElementExist(AMDLoginScreen.objEmailIdField, "Email Id field")) {
				type(AMDLoginScreen.objEmailIdField, "zeetest@gmail.com", "Email Id field");
			}

			verifyElementPresentAndClick(AMDLoginScreen.objDOB, "Date of Birth");
			verifyElementPresentAndClick(AMDLoginScreen.objDate, "Date");
			verifyElementPresentAndClick(AMDLoginScreen.objDateOK, "OK button");
			verifyElementPresentAndClick(AMDLoginScreen.objGender, "Gender Field");
			verifyElementPresentAndClick(AMDLoginScreen.objGenderMale, "Male");
			verifyElementExist(AMDLoginScreen.objSubmitButton, "Submit Button");
			Back(1);
		}

		if (verifyElementExist(AMDHomePage.objHome, "Home Tab")) {
			logger.info("User logged in successfully");
			extent.extentLogger("Login", "User logged in successfully");

			verifyElementPresentAndClick(AMDHomePage.objMoreMenu, "More Menu");
			Swipe("UP", 2);

			verifyElementPresentAndClick(AMDMoreMenu.objLogout, "Logout");
			verifyElementPresentAndClick(AMDMoreMenu.objLogoutBtn, "Logout Button");
			waitTime(5000);
			Swipe("Down", 2);
			verifyElementPresentAndClick(AMDMoreMenu.objProfile, "Login/Register");

		}

		verifyElementPresentAndClick(AMDLoginScreen.objtwitterBtn, "Twitter icon");
		waitTime(5000);

		if (verifyElementExist(AMDLoginScreen.objTwitterAuthorize, "Authorize app")) {
			click(AMDLoginScreen.objTwitterAuthorize, "Authorize app");
		}

		if (verifyElementExist(AMDLoginScreen.objTwitterEmail, "Email Id field")) {
			click(AMDLoginScreen.objTwitterEmail, "Email Id field");
			type(AMDLoginScreen.objTwitterEmail, "zee5latest@gmail.com", "Email Id field");
			verifyElementPresentAndClick(AMDLoginScreen.objTwitterPassword, "Password Field");
			type(AMDLoginScreen.objTwitterPassword, "User@123", "Password field");
			verifyElementPresentAndClick(AMDLoginScreen.objTwitterLoginBtn, "Login Button");

			waitTime(5000);
			if (verifyElementExist(AMDHomePage.objHome, "Home Tab")) {
				logger.info("User logged in successfully");
				extent.extentLogger("Login", "User logged in successfully");

				verifyElementPresentAndClick(AMDHomePage.objMoreMenu, "More Menu");
				Swipe("UP", 2);

				verifyElementPresentAndClick(AMDMoreMenu.objLogout, "Logout");
				verifyElementPresentAndClick(AMDMoreMenu.objLogoutBtn, "Logout Button");
				waitTime(5000);
				Swipe("Down", 2);
				verifyElementPresentAndClick(AMDMoreMenu.objProfile, "Login/Register");

			}
		}

		if (verifyElementExist(AMDOnboardingScreen.objTellUsMore, "More info Screen")) {
			if (verifyElementExist(AMDLoginScreen.objEmailIdField, "Email Id field")) {
				type(AMDLoginScreen.objEmailIdField, "zeetest@gmail.com", "Email Id field");
			}

			verifyElementPresentAndClick(AMDLoginScreen.objDOB, "Date of Birth");
			verifyElementPresentAndClick(AMDLoginScreen.objDate, "Date");
			verifyElementPresentAndClick(AMDLoginScreen.objDateOK, "OK button");
			verifyElementPresentAndClick(AMDLoginScreen.objGender, "Gender Field");
			verifyElementPresentAndClick(AMDLoginScreen.objGenderMale, "Male");
			verifyElementExist(AMDLoginScreen.objSubmitButton, "Submit Button");
		}

		if (verifyElementExist(AMDHomePage.objHome, "Home Tab")) {
			logger.info("User logged in successfully");
			extent.extentLogger("Login", "User logged in successfully");

			verifyElementPresentAndClick(AMDHomePage.objMoreMenu, "More Menu");
			Swipe("UP", 2);

			verifyElementPresentAndClick(AMDMoreMenu.objLogout, "Logout");
			verifyElementPresentAndClick(AMDMoreMenu.objLogoutBtn, "Logout Button");
			waitTime(5000);
			Swipe("Down", 2);
			verifyElementPresentAndClick(AMDMoreMenu.objProfile, "Login/Register");

		}

		verifyElementPresentAndClick(AMDLoginScreen.objfbBtn, "Facebook icon");
		waitTime(5000);

		if (verifyElementExist(AMDLoginScreen.objFBLogIntoAnotherAccount, "Log Into Another Account")) {
			click(AMDLoginScreen.objFBLogIntoAnotherAccount, "Log Into Another Account");
			if (verifyElementExist(AMDLoginScreen.objFBEmail, "Email Id field")) {
				click(AMDLoginScreen.objFBEmail, "Email Id field");
				type(AMDLoginScreen.objFBEmail, "igszeefive@gmail.com", "Email Id field");
				verifyElementPresentAndClick(AMDLoginScreen.objFBPassword, "Password Field");
				type(AMDLoginScreen.objFBPassword, "zeefive@igs", "Password field");
				verifyElementPresentAndClick(AMDLoginScreen.objFBLoginBtn, "Login Button");
			}
		} else if (verifyElementExist(AMDLoginScreen.objFBEmail, "Email Id field")) {
			click(AMDLoginScreen.objFBEmail, "Email Id field");
			type(AMDLoginScreen.objFBEmail, "igszeefive@gmail.com", "Email Id field");
			verifyElementPresentAndClick(AMDLoginScreen.objFBPassword, "Password Field");
			type(AMDLoginScreen.objFBPassword, "zeefive@igs", "Password field");
			verifyElementPresentAndClick(AMDLoginScreen.objFBLoginBtn, "Login Button");
		}

		if (verifyElementExist(AMDHomePage.objHome, "Home Tab")) {
			logger.info("User logged in successfully");
			extent.extentLogger("Login", "User logged in successfully");
		}

		verifyElementPresentAndClick(AMDHomePage.objMoreMenu, "More Menu");
		Swipe("UP", 1);

		verifyElementPresentAndClick(AMDMoreMenu.objLogout, "Logout");
		verifyElementPresentAndClick(AMDMoreMenu.objLogoutBtn, "Logout Button");
		waitTime(5000);
		Swipe("Down", 2);
		verifyElementPresentAndClick(AMDMoreMenu.objProfile, "Login/Register");

		if (verifyElementExist(AMDOnboardingScreen.objTellUsMore, "More info Screen")) {
			if (verifyElementExist(AMDLoginScreen.objEmailIdField, "Email Id field")) {
				type(AMDLoginScreen.objEmailIdField, "zeetest@gmail.com", "Email Id field");
			}
			verifyElementPresentAndClick(AMDLoginScreen.objDOB, "Date of Birth");
			verifyElementPresentAndClick(AMDLoginScreen.objDate, "Date");
			verifyElementPresentAndClick(AMDLoginScreen.objDateOK, "OK button");
			verifyElementPresentAndClick(AMDLoginScreen.objGender, "Gender Field");
			verifyElementPresentAndClick(AMDLoginScreen.objGenderMale, "Male");
			verifyElementExist(AMDLoginScreen.objSubmitButton, "Submit Button");
			Back(1);
		}
	}

	@SuppressWarnings("deprecation")
	public void searchResultsAllTabs(String searchModuleKeyword) throws Exception {

		extent.HeaderChildNode("Validating that user is able to find the searched content in all the tabs");

		// type(AMDSearchScreen.objSearchBoxBar, searchModuleKeyword + "\n", "Search
		// bar");
		getDriver().getKeyboard().sendKeys(searchModuleKeyword);

		hideKeyboard();

		waitForElementDisplayed(AMDSearchScreen.objAllTab, 20);

		boolean allTabHighlighted = findElement(AMDSearchScreen.objAllTab).isSelected();

		if (allTabHighlighted == true) {
			logger.info("All Tab is highlighted by default");
			extent.extentLogger("All Tab", "All Tab is highlighted by default");
		} else {
			logger.error("All Tab is not highlighted by default");
			extent.extentLogger("All Tab", "All Tab is not highlighted by default");
		}

		waitTime(5000);

		swipeByElements(findElement(AMDSearchScreen.objMusicTabIndx), findElement(AMDSearchScreen.objShowsTabIndx));

		waitTime(3000);
		swipeByElements(findElement(AMDSearchScreen.objMusicTabIndx), findElement(AMDSearchScreen.objVideosTab));

		logger.info("User is able to scroll through the tabs");
		extent.extentLogger("Tabs", "User is able to scroll through the tabs");

		waitTime(2000);
		List<WebElement> tabs = getDriver().findElements(AMDSearchScreen.objTabs);
		System.out.println(tabs.size());
		boolean News = false;
		for (int i = 1; i <= tabs.size(); i++) {
			String tabName = null;

			System.out.println("i : " + i);

			if (i == 5) {

				if (!News) {
					i = 4;
				}

				WebElement eleTab = findElement(By.xpath(
						"((//*[@resource-id='com.graymatrix.did:id/tabLayout'])[2]/child::*/child::*/child::*/child::*)["
								+ i + "]"));
				tabName = findElement(By.xpath(
						"((//*[@resource-id='com.graymatrix.did:id/tabLayout'])[2]/child::*/child::*/child::*/child::*)["
								+ i + "]")).getText();

				System.out.println(tabName);
				eleTab.click();

			} else {
				WebElement eleTab = findElement(By.xpath(
						"((//*[@resource-id='com.graymatrix.did:id/tabLayout'])[2]/child::*/child::*/child::*/child::*)["
								+ i + "]"));
				tabName = findElement(By.xpath(
						"((//*[@resource-id='com.graymatrix.did:id/tabLayout'])[2]/child::*/child::*/child::*/child::*)["
								+ i + "]")).getText();
				System.out.println(tabName);
				eleTab.click();
			}

			logger.info(tabName + " tab is displayed and clicked on " + tabName + " tab");
			extent.extentLogger("Related search results",
					tabName + " tab is displayed and clicked on " + tabName + " tab");

			List<WebElement> results = findElements(AMDSearchScreen.objRelatedSearchResult);
			System.out.println(results.size());

			for (int j = 1; j <= results.size(); j++) {
				String searchResults = findElement(By.xpath(
						"(//*[@id='searchResultsContent']//following-sibling::*[@id='item_primary_text'])[" + j + "]"))
								.getText();
				System.out.println(searchResults);

				if (searchResults.contains(searchModuleKeyword)) {
					logger.info("Search Results  Keyword has results in " + tabName + " tab");
					extent.extentLogger("Related search results",
							"Search Results  Keyword has results in " + tabName + " tab");
				} else {
					logger.info("Related search results are not displayed in  " + tabName + " tab");
					extent.extentLogger("Related search results",
							"Related search results are not displayed in  " + tabName + " tab");
				}
			}

			if (News) {
				break;
			}
			if (tabName.equalsIgnoreCase("News")) {
				News = true;
			}
		}

		Back(1);

		if (verifyElementExist(AMDSearchScreen.objMicrophoneIcon, "Microphone Icon")) {
			logger.info(
					"Microphone icon is displayed when user navigates back to Search landing screen from Search Result screen");
			extent.extentLogger("Microphone icon",
					"Microphone icon is displayed when user navigates back to Search landing screen from Search Result screen");
		} else {
			logger.error(
					"Microphone icon is not displayed when user navigates back to Search landing screen from Search Result screen");
			extent.extentLoggerFail("Microphone icon",
					"Microphone icon is not displayed when user navigates back to Search landing screen from Search Result screen");
		}

	}

	@SuppressWarnings("deprecation")
	public void noSearchResults(String invalidSearchKeyword) throws Exception {
		extent.HeaderChildNode(
				"Validating the category tab is not displayed if the searched keyword don’t have results for the particular category");

		verifyElementPresentAndClick(AMDHomePage.objSearchBtn, "Search Icon");

		verifyElementPresentAndClick(AMDSearchScreen.objSearchEditBox, "Search Box");
		getDriver().getKeyboard().sendKeys(invalidSearchKeyword);
		hideKeyboard();
		// type(AMDSearchScreen.objSearchBoxBar, invalidSearchKeyword + "\n", "Search
		// bar");
		if (verifyElementExist(AMDSearchScreen.objNoSearchResults, "No Search Results message")) {
			String noResults = getText(AMDSearchScreen.objNoSearchResults);
			logger.info(noResults + " message is displayed");
			extent.extentLogger("Search Results message", noResults + " message is displayed");

			logger.info("Searched keyword does not have results for the particular category");
			extent.extentLogger("Search Results message",
					"Searched keyword does not have results for the particular category");
		} else {
			logger.info("Searched keyword has results for the particular category");
			extent.extentLogger("Search Results message", "Searched keyword has results for the particular category");

		}
		verifyElementPresentAndClick(AMDSearchScreen.objClearSearch, "Clear Search");
	}

	public void swipeByElements(WebElement webElement, WebElement webElement2) {

		touchAction = new TouchAction<>(getDriver());

		int startX = webElement.getLocation().getX() + (webElement.getSize().getWidth() / 2);
		int startY = webElement.getLocation().getY() + (webElement.getSize().getHeight() / 2);

		int endX = webElement2.getLocation().getX() + (webElement2.getSize().getWidth() / 2);
		int endY = webElement2.getLocation().getY() + (webElement2.getSize().getHeight() / 2);
		touchAction.press(PointOption.point(startX, startY))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(endX, endY))
				.release().perform();
	}

	@SuppressWarnings("deprecation")
	public void searchPageValidation(String partlySpeltSearchKeyword) throws Exception {
		extent.HeaderChildNode("Search Result Screen Validation");
		getDriver().getKeyboard().sendKeys(partlySpeltSearchKeyword);
//		type(AMDSearchScreen.objSearchBoxBar, partlySpeltSearchKeyword + "\n", "Search bar");
//		verifyElementExist(AMDSearchScreen.objSearchResultPage, "Search Result Screen");

//		if(verifyElementExist(AMDSearchScreen.objRecentSearch, "Recent Search Overlay")==false) {
//			extent.extentLogger("Recent Search Overlay","Recent Search Overlay is not available in search results screen");
//			logger.info("Recent Search Overlay is not available in search results screen");
//		}else {
//			extent.extentLoggerFail("Recent Search Overlay", "Recent Search Overlay is available in search results screen");
//			logger.error("Recent Search Overlay is available in search results screen");
//		}

		hideKeyboard();
		waitForElementDisplayed(AMDSearchScreen.objAllTab, 20);

//		String enteredValue = getAttributValue("value", AMDSearchScreen.objSearchBoxBar);
		System.out.println(partlySpeltSearchKeyword.length());
		waitTime(20000);
		if (partlySpeltSearchKeyword.length() >= 3) {

			System.out.println(getDriver().findElements(AMDSearchScreen.objRelatedSearchResult).size());

			if (getDriver().findElements(AMDSearchScreen.objRelatedSearchResult).size() > 0) {
				logger.info("Search result screen is displayed once user enters 3rd character in the search box.");
				extent.extentLogger("Search result screen",
						"Search result screen is displayed once user enters 3rd character in the search box.");

			} else {
				logger.info(
						"Search result screen is not displayed when user enters less than 3 characters in the search box.");
				extent.extentLogger("Search result screen",
						"Search result screen is not displayed when user enters less than 3 characters in the search box.");
			}
		}

		PartialSwipe("UP", 2);
		logger.info("User is able to scroll down the search results");
		extent.extentLogger("Search results", "User is able to scroll down the search results");
		verifyElementPresentAndClick(AMDSearchScreen.objClearSearch, "Clear Search");
		hideKeyboard();
	}

	public void voiceSearchDenyValidation() throws Exception {
		extent.HeaderChildNode("Voice Search Access Deny Validation");
		System.out.println("Voice Search Access Deny Validation");
		verifyElementPresentAndClick(AMDHomePage.objSearchBtn, "Search Icon");
		verifyElementPresentAndClick(AMDSearchScreen.objMicrophoneIcon, "Microphone icon");
		verifyElementPresentAndClick(AMDSearchScreen.objProceedBtn, "Proceed Button");
		if (verifyElementExist(AMDSearchScreen.objAudioPermissionPopUp, "Audio Permission Popup")) {
			verifyElementPresentAndClick(AMDSearchScreen.objDeny, "Deny Option");

			if (verifyElementExist(AMDSearchScreen.objMicrophoneIcon, "Microphone Icon")) {
				logger.info("Search landing screen is displayed after denying audio permission");
				extent.extentLogger("Search landing screen",
						"Search landing screen is displayed after denying audio permission");

			} else {
				logger.info("Search landing screen is not displayed after denying audio permission");
				extent.extentLogger("Search landing screen",
						"Search landing screen is not displayed after denying audio permission");
			}

//			verifyElementPresentAndClick(AMDSearchScreen.objMicrophoneIcon, "Microphone icon");
//			verifyElementExist(AMDSearchScreen.objVoiceSearchPermission,"Microphone access permission popup");
//			verifyElementExist(AMDSearchScreen.objAudioPermissionPopUp,"Audio Permission Popup");

		}
	}

	public void voiceSearchValidation() throws Exception {
		extent.HeaderChildNode("Voice Search Validation");
		System.out.println("Voice Search Validation");
		// verifyElementPresentAndClick(AMDHomePage.objSearchBtn, "Search Icon");

		WebElement elementMicrophoneIcon = findElement(AMDSearchScreen.objMicrophoneIcon);
		int iconRightX = elementMicrophoneIcon.getLocation().getX();
		System.out.println(iconRightX);
		Dimension sizee = getDriver().manage().window().getSize();
		System.out.println(sizee.getWidth());
		int sizeee = sizee.getWidth() - 300;
		System.out.println(sizeee);

		if (iconRightX >= sizeee) {
			logger.info("Microphone icon is displayed on right side of the search box");
			extent.extentLogger("Microphone icon", "Microphone icon is displayed on right side of the search box");
		} else {
			logger.error("Microphone icon is not displayed on right side of the search box");
			extent.extentLoggerFail("Microphone icon",
					"Microphone icon is not displayed on right side of the search box");
		}
		click(AMDSearchScreen.objMicrophoneIcon, "Microphone icon");
		if (verifyElementExist(AMDSearchScreen.objVoiceSearchPermission, "Microphone access permission popup")) {
			verifyElementExist(AMDSearchScreen.objMicrophoneIconLogo, "Microphone icon");
			verifyElementExist(AMDSearchScreen.objTermsAndConditions, "Terms of Use and Privacy Policy Message");
			verifyElementExist(AMDSearchScreen.objProceedBtn, "Proceed Button");
			verifyElementExist(AMDSearchScreen.objBackBtn, "Back button");

			WebElement elementBackBtn = findElement(AMDSearchScreen.objBackBtn);
			int BackBtnleftX = elementBackBtn.getLocation().getX();
			int BAckBtnrightX = BackBtnleftX + elementBackBtn.getSize().getWidth();
			int BackBtnmiddleX = (BAckBtnrightX + BackBtnleftX) / 2;

			if (BackBtnmiddleX <= 200) {
				logger.info("Back button is displayed at top left of the screen");
				extent.extentLogger("Back button", "Back button is displayed at top left of the screen");
			} else {
				logger.error("Back button is not displayed at top left of the screen");
				extent.extentLoggerFail("Back button", "Back button is not displayed at top left of the screen");
			}

			click(AMDSearchScreen.objProceedBtn, "Proceed Button");
			if (verifyElementExist(AMDSearchScreen.objAudioPermissionPopUp, "Audio Permission Popup")) {
				verifyElementPresentAndClick(AMDSearchScreen.objAllow, "Allow Option");
				verifyElementExist(AMDSearchScreen.objVoiceSearchScreen, "Voice Search Screen");
				verifyElementExist(AMDSearchScreen.objMicrophoneLogoInVoiceSearch, "Microphone icon");
				verifyElementExist(AMDSearchScreen.objSeeUrTextMsg, "See your text here message");
				verifyElementPresentAndClick(AMDSearchScreen.objCloseBtn, "Close Button");

//				verifyElementPresentAndClick(AMDSearchScreen.objMicrophoneIcon, "Microphone icon");
//				verifyElementExist(AMDSearchScreen.objVoiceSearchPermission,"Microphone access permission popup");
//				verifyElementExist(AMDSearchScreen.objAudioPermissionPopUp,"Audio Permission Popup");

			}

		}

	}

	/*
	 * =============================================================================
	 * ===== ------------------------------ Script Author: KUSHAL
	 * ---------------------------------
	 * 
	 * List of Functions Created - navigateToLoginScreen_DisplaylangScreen() -
	 * navigateToIntroScreen_DisplaylangScreen() - LoginWithEmailID(String pEmailId,
	 * String pPassword) - verifyUIPresentInLoginPage() -
	 * verifyLoginScreenUIFunctionality() - VerifySkipLoginRegistrationScreen() -
	 * VerifyLoginWithEmailId(String pUserName, String pPassword) -
	 * verifyHaveAPrepaidCodePopUp() -
	 * verifyInvalidPrepaidCodePopUpAfterLogin(String pEmailID, String pPassword) -
	 * verifyInvalidPrepaidCodePopUpAfterRegistration() -
	 * verifyCongratulationPopupAppearsforValidPrepaidCode(String pCode, String
	 * pUserName, String pPassword)
	 * =============================================================================
	 * =========
	 */

	public void navigateToLoginScreen_DisplaylangScreen() throws Exception {
		extent.HeaderChildNode("Navigation to Login Screen");
		click(AMDOnboardingScreen.objDiplay_ContinueBtn, "Continue button (Display-LanguageScreen)");
		click(AMDOnboardingScreen.objContent_ContinueBtn, "Continue button (Content-LanguageScreen)");
		verifyElementPresentAndClick(AMDOnboardingScreen.objBrowseForFreeBtn, "Browse for Free");
	}

	public void navigateToIntroScreen_DisplaylangScreen() throws Exception {
		extent.HeaderChildNode("Navigation to Intro Screen");
		click(AMDOnboardingScreen.objDiplay_ContinueBtn, "Continue button (Display-LanguageScreen)");
		click(AMDOnboardingScreen.objContent_ContinueBtn, "Continue button (Content-LanguageScreen)");
		verifyElementPresent(AMDOnboardingScreen.objBrowseForFreeBtn, "Browse for Free");
	}

	public void LoginWithEmailID(String pEmailId, String pPassword) throws Exception {
//		extent.HeaderChildNode("Log into ZEE5 with registered Email account");
		verifyElementPresent(AMDLoginScreen.objEmailIdLabel, "Login/Register screen");
		type(AMDLoginScreen.objEmailIdField, pEmailId, "Email-Id/Phone");
		click(AMDLoginScreen.objProceedBtn, "Proceed button");
		verifyElementPresent(AMDLoginScreen.objPasswordField, "Password field");
		type(AMDLoginScreen.objPasswordField, pPassword, "Password");
		hideKeyboard();
		click(AMDLoginScreen.objLoginBtn, "Login Button");
	}

	public void verifyUIPresentInLoginPage() throws Exception {
		verifyElementPresent(AMDLoginScreen.objBackBtn, "Back button");
		verifyElementPresent(AMDLoginScreen.objLoginLnk, "Skip button");
		verifyElementPresent(AMDLoginScreen.objGoogleBtn, "Google login button");
		verifyElementPresent(AMDLoginScreen.objfbBtn, "facebook login button");
		verifyElementPresent(AMDLoginScreen.objtwitterBtn, "twitter login button");
	}

	public void verifyLoginScreenUIFunctionality() throws Exception {
		extent.HeaderChildNode("Veirfy UI elements present in Login Screen");
		verifyElementPresent(AMDGenericObjects.objScreenTitleName("Login"), "Login Screen");

		String pwdEncript = getAttributValue("checked", AMDLoginScreen.objShowPwdBtn);
		if (pwdEncript.contains("false")) {
			extent.extentLogger("Default Show Password", "Password is Encripted");
			logger.info("Password is Encripted");
		} else {
			extent.extentLoggerFail("Default Show Password", "Password is not Encripted");
			logger.error("Password is not Encripted");
		}

		click(AMDLoginScreen.objShowPwdBtn, "Show Password");
		String checkPwdVisible = getAttributValue("checked", AMDLoginScreen.objShowPwdBtn);
		if (checkPwdVisible.contains("true")) {
			extent.extentLogger("Click Show Password", "Password is Visible");
			logger.info("Password is Visible");
		} else {
			extent.extentLoggerFail("Click Show Password", "Password is not Visible");
			logger.error("Password is not Visible");
		}

		verifyElementPresentAndClick(AMDLoginScreen.objForgetPwdBtn, "Forgot Password CTA");
		verifyElementPresent(AMDGenericObjects.objScreenTitleName("Forgot Password"), "Forgot Password Screen");
		click(AMDLoginScreen.objBackBtn, "Back button");
	}

	public void VerifySkipLoginRegistrationScreen() throws Exception {
		extent.HeaderChildNode("Browse for Free - Skip Login/Register screen to Home page");
		verifyElementPresent(AMDGenericObjects.objScreenTitleName("Login/Register"), "Login/Register title");
		verifyUIPresentInLoginPage();
		verifyElementPresent(AMDLoginScreen.objEmailIdLabel, "Email ID or Mobile Number");
		type(AMDLoginScreen.objEmailIdField, "testmessage.com", "EmailId");
		verifyElementPresent(AMDLoginScreen.objErrInvalidID, getText(AMDLoginScreen.objErrInvalidID));
		clearField(AMDLoginScreen.objEmailIdField, "EmailId");
		type(AMDLoginScreen.objEmailIdField, "987654321", "Phone Number");
		verifyElementPresent(AMDLoginScreen.objErrInvalidID, getText(AMDLoginScreen.objErrInvalidID));
		clearField(AMDLoginScreen.objEmailIdField, "EmailId");
		type(AMDLoginScreen.objEmailIdField, "sample@zee5.com", "EmailId");
		hideKeyboard();
		verifyElementPresent(AMDLoginScreen.objProceedBtn, "Proceed button");
		verifyElementPresentAndClick(AMDLoginScreen.objLoginLnk, "Skip button");
		verifyElementPresent(AMDHomePage.objHome, "Home Page");
	}

	public void VerifyLoginWithEmailId(String pUserName, String pPassword) throws Exception {

		extent.HeaderChildNode("Login With Email-ID");
		System.out.println("Login With Email-ID");
		verifyElementPresent(AMDGenericObjects.objScreenTitleName("Login/Register"), "Login/Register");
		type(AMDLoginScreen.objEmailIdField, pUserName, "Email-ID");
		verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed button");
		if (getText(AMDLoginScreen.objEmailIdField).equalsIgnoreCase(pUserName)) {
			extent.extentLogger("Email-Id Retained", "Email Id is retained in Login screen EmailId Field");
			logger.info("Email Id is retained in Login screen EmailId Field");
		} else {
			extent.extentLoggerFail("Email-Id Retained", "Email Id failed to retained in Login screen EmailId Field");
			logger.error("Email Id failed to retained in Login screen EmailId Field");
		}
		String getPropertyValue = getAttributValue("enabled", AMDLoginScreen.objEmailIdField);
		if (getPropertyValue.equalsIgnoreCase("false")) {
			extent.extentLogger("EmailId field is disabled/grayed out", " User cannot edit emailid field");
			logger.info("EmailId field is disabled/grayed out and user cannot edit emailid field");
		} else {
			extent.extentLoggerFail("EmailId field is not grayed out", " User is able to edit emailid field");
			logger.error("EmailId field is not grayed out and user is able to edit emailid field");
		}
		verifyLoginScreenUIFunctionality();

		verifyElementPresent(AMDLoginScreen.objPasswordField, "Password field");
		type(AMDLoginScreen.objPasswordField, "xcvzc", "Password");
		verifyElementPresent(AMDLoginScreen.objErrorTxtMsg, "Password must be a minimum of 6 characters");
		clearField(AMDLoginScreen.objPasswordField, "Password");
		type(AMDLoginScreen.objPasswordField, pPassword, "Password");
		hideKeyboard();
		verifyElementPresentAndClick(AMDLoginScreen.objLoginBtn, "Login Button");
		Wait(2000);
		if (verifyElementPresent(AMDHomePage.objHomeTab, "Home page")) {
			extent.extentLogger("Login with EmailId", pUserName + " : is logged in successfully");
			logger.info(pUserName + " is logged in  successfully");
		} else {
			extent.extentLoggerFail("Login with EmailId", pUserName + " failed to login");
			logger.error(pUserName + " failed to login");
		}
	}

	public void verifyHaveAPrepaidCodePopUp() throws Exception {
		extent.HeaderChildNode("Verify Have a prepaid code PopUp UI is displayed");
		click(AMDOnboardingScreen.objDiplay_ContinueBtn, "Continue button (Display-LanguageScreen)");
		click(AMDOnboardingScreen.objContent_ContinueBtn, "Continue button (Content-LanguageScreen)");
		verifyElementPresentAndClick(AMDOnboardingScreen.objHavePrepaidBtn, "Have a prepaid code? CTA");
		verifyElementPresent(AMDOnboardingScreen.objPrepaidPopupLabel, "Prepaid Code PopUp Header");
		verifyElementPresent(AMDOnboardingScreen.objWhatIsPrepaidCodeBtn, "What is a Prepaid Code?");
		verifyElementPresent(AMDOnboardingScreen.objApplyBtn, "Apply button");

		String getPropertyValue = getAttributValue("enabled", AMDOnboardingScreen.objApplyBtn);
		if (getPropertyValue.equalsIgnoreCase("false")) {
			extent.extentLogger("Apply button", "Apply Button is by default dehighlighted");
			logger.info("Apply Button is by default dehighlighted");
		} else {
			extent.extentLoggerFail("Apply buttont", "Apply Button fails to dehighlight by default");
			logger.error("Apply Button failed to dehighlight by default");
		}

		verifyElementPresent(AMDOnboardingScreen.objPrepaidCodeField, "Prepaid Code Field");
		if (getText(AMDOnboardingScreen.objPrepaidCodeField).equalsIgnoreCase("Prepaid Code")) {
			extent.extentLogger("Prepaid Code field", "Prepaid Code text is displayed in the edit field");
			logger.info("Prepaid Code text is displayed in the edit field");
		} else {
			extent.extentLoggerFail("Prepaid Code field", "Prepaid Code text is not displayed in the edit field");
			logger.error("Prepaid Code text is not displayed in the edit field");
		}

		verifyElementPresentAndClick(AMDOnboardingScreen.objWhatIsPrepaidCodeBtn, "What is Prepaid Code? CTA");
		verifyElementPresent(AMDGenericObjects.objCheckTitle("About Prepaid Code"), "About Prepaid Code Screen");
		verifyElementPresent(AMDOnboardingScreen.objDescriptionTxt, "About Prepaid code description");
		verifyElementPresentAndClick(AMDOnboardingScreen.objBackBtn, "Back Button");
		verifyElementPresent(AMDOnboardingScreen.objPrepaidPopupLabel, "Prepaid Popup");
		verifyElementPresentAndClick(AMDOnboardingScreen.objPopUpDivider, "Popup Horizontal line");
		verifyElementPresentAndClick(AMDOnboardingScreen.objHavePrepaidBtn, "Have a prepaid code? CTA");

		click(AMDOnboardingScreen.objPrepaidCodeField, "Prepaid code field");
		Wait(1000);
		type(AMDOnboardingScreen.objPrepaidCodeField, "ZNA2020", "Prepaid Code field");
		hideKeyboard();
		String getPropertyValue2 = getAttributValue("enabled", AMDOnboardingScreen.objApplyBtn);
		if (getPropertyValue2.equalsIgnoreCase("true")) {
			extent.extentLogger("Apply button", "Apply Button is highlighted");
			logger.info("Apply Button is highlighted");
		} else {
			extent.extentLoggerFail("Apply buttont", "Apply Button fails to highlight after entering code");
			logger.error("Apply Button fails to highlight after entering code");
		}

		click(AMDOnboardingScreen.objApplyBtn, "Apply button");
		verifyElementPresent(AMDOnboardingScreen.objFaceIcon, "Oops! label");
		String textMessage = getText(AMDOnboardingScreen.objSuccessDesc);
		if (textMessage.contains("You are not logged in")) {
			extent.extentLogger("Invalid Code Message", "You are not logged in to apply prepaid code... message");
			logger.info("You are not logged in to apply prepaid code... message is displayed");
		} else {
			extent.extentLoggerFail("Invalid Code Message", "You are not logged in to apply prepaid code... message");
			logger.error("You are not logged in to apply prepaid code... message is not displayed");
		}

		verifyElementPresent(AMDOnboardingScreen.objRegisterBtn, "Register button");
		verifyElementPresentAndClick(AMDOnboardingScreen.objLoginBtn, "Login button");
		verifyElementPresent(AMDLoginScreen.objEmailIdField, "Login/Register screen");
	}

	public void verifyInvalidPrepaidCodePopUpAfterLogin(String pEmailID, String pPassword) throws Exception {

		extent.HeaderChildNode("Verify Invalid prepaid code PopUp UI is displayed after successful login");
		click(AMDOnboardingScreen.objDiplay_ContinueBtn, "Continue button (Display-LanguageScreen)");
		click(AMDOnboardingScreen.objContent_ContinueBtn, "Continue button (Content-LanguageScreen)");
		verifyElementPresentAndClick(AMDOnboardingScreen.objHavePrepaidBtn, "Have a prepaid code? CTA");
		click(AMDOnboardingScreen.objPrepaidCodeField, "Prepaidcode Field");
		type(AMDOnboardingScreen.objPrepaidCodeField, "CODE2020", "Prepaid Code field");
		hideKeyboard();
		verifyElementPresentAndClick(AMDOnboardingScreen.objApplyBtn, "Apply button");
		verifyElementPresentAndClick(AMDOnboardingScreen.objLoginBtn, "Login button");
		LoginWithEmailID(pEmailID, pPassword);
		Wait(1000);
		verifyElementPresent(AMDOnboardingScreen.objSuccessTitle("Invalid Prepaid Code"),
				"Invalid Prepaid Code Pop up");
		String getPopUpDesc = getText(AMDOnboardingScreen.objSuccessDesc);
		if (getPopUpDesc.contains("Please Provide Valid Coupon code")) {
			extent.extentLogger("Invalid Pop up", getPopUpDesc + "  message is displayed");
			logger.info(getPopUpDesc + "is displayed in PopUp screen");
		} else {
			extent.extentLoggerFail("Invalid Pop up", "Please provide valid coupon code message is not displayed");
			logger.error("Please provide valid coupon code is not displayed");
		}

		verifyElementPresentAndClick(AMDOnboardingScreen.objDoneBtn, "Done button");
		if (verifyElementPresent(AMDHomePage.objHome, "Home Screen")) {
			extent.extentLogger("Login with registered user", pEmailID + " :  is logged in Successfully");
			logger.info(pEmailID + " is logged in  successfully");
		} else {
			extent.extentLoggerFail("Login with registered user", pEmailID + " failed to login");
			logger.error(pEmailID + " failed to login");
		}

	}

	public void verifyInvalidPrepaidCodePopUpAfterRegistration() throws Exception {

		extent.HeaderChildNode("Verify Invalid prepaid code PopUp UI is displayed after successful login");
		click(AMDOnboardingScreen.objDiplay_ContinueBtn, "Continue button (Display-LanguageScreen)");
		click(AMDOnboardingScreen.objContent_ContinueBtn, "Continue button (Content-LanguageScreen)");
		verifyElementPresentAndClick(AMDOnboardingScreen.objHavePrepaidBtn, "Have a prepaid code? CTA");
		click(AMDOnboardingScreen.objPrepaidCodeField, "Prepaidcode Field");
		type(AMDOnboardingScreen.objPrepaidCodeField, "CODE2020", "Prepaid Code field");
		hideKeyboard();
		verifyElementPresentAndClick(AMDOnboardingScreen.objApplyBtn, "Apply button");
		verifyElementPresentAndClick(AMDOnboardingScreen.objRegisterBtn, "Register button");
		Wait(1000);
		type(AMDRegistrationScreen.objEmailIDTextField, generateRandomString(6) + "@yopmail.com", "Email field");
		verifyElementPresentAndClick(AMDRegistrationScreen.objProceedBtn, "Proceed button");

		// ---Register new user
		registerForFreeScreen("Prepaid");

		verifyElementPresent(AMDOnboardingScreen.objSuccessTitle("Invalid Prepaid Code"),
				"Invalid Prepaid Code Pop up");
		String getPopUpDesc = getText(AMDOnboardingScreen.objSuccessDesc);
		if (getPopUpDesc.contains("Please Provide Valid Coupon code")) {
			extent.extentLogger("Invalid Pop up", getPopUpDesc + " is displayed in PopUp screen");
			logger.info(getPopUpDesc + "is displayed in PopUp screen");
		} else {
			extent.extentLoggerFail("Invalid Pop up", "Please provide valid coupon code is not displayed");
			logger.error("Please provide valid coupon code is not displayed");
		}

		verifyElementPresentAndClick(AMDOnboardingScreen.objDoneBtn, "Done button");
		if (verifyElementPresent(AMDHomePage.objHome, "Home Screen")) {
			extent.extentLogger("Register New user", "User is registered to ZEE5 successfully");
			logger.info("User is registered to ZEE5 successfully");
		} else {
			extent.extentLoggerFail("Register New user", "User failed to register");
			logger.error("User failed to register");
		}

	}

	// --------- Need a VALID Prepaid Code to verify Congratulations Popup screen
	// -----------

	public void verifyCongratulationPopupAppearsforValidPrepaidCode(String pCode, String pUserName, String pPassword)
			throws Exception {
		extent.HeaderChildNode("Verify Congratulation PopUp is displayed for valid Prepaid Code");
		click(AMDOnboardingScreen.objDiplay_ContinueBtn, "Continue button (Display-LanguageScreen)");
		click(AMDOnboardingScreen.objContent_ContinueBtn, "Continue button (Content-LanguageScreen)");
		click(AMDOnboardingScreen.objHavePrepaidBtn, "Have a prepaid code? CTA");
		click(AMDOnboardingScreen.objPrepaidCodeField, "Prepaidcode Field");
		type(AMDOnboardingScreen.objPrepaidCodeField, pCode, "Valid Prepaid Code");
		hideKeyboard();
		verifyElementPresentAndClick(AMDOnboardingScreen.objApplyBtn, "Apply button");
		click(AMDOnboardingScreen.objLoginBtn, "Login button");
		LoginWithEmailID(pUserName, pPassword);

		verifyElementPresent(AMDOnboardingScreen.objSuccessTitle("Congratulations!"), "Congratulations! Pop up screen");
		String getPopUpDesc = getText(AMDOnboardingScreen.objSuccessDesc);
		if (getPopUpDesc.contains("Prepaid code applied successfully")) {
			extent.extentLogger("Congrats Pop up", getPopUpDesc + " - message is displayed");
			logger.info(getPopUpDesc + " is displayed in PopUp screen");
		} else {
			extent.extentLoggerFail("Congrats Pop up", "Message - Prepaid code applied successfully is not displayed");
			logger.error("Message - Prepaid code applied successfully is not displayed");
		}

		verifyElementPresentAndClick(AMDOnboardingScreen.objWatchNowBtn, "Watch Now button");

		if (verifyElementPresent(AMDHomePage.objHomeTab, "Home page")) {
			extent.extentLogger("Login with EmailId", pUserName + " : is logged in successfully");
			logger.info(pUserName + " is logged in  successfully");
		} else {
			extent.extentLoggerFail("Login with EmailId", pUserName + " failed to login");
			logger.error(pUserName + " failed to login");
		}
	}

	/**
	 * Author : Sushma
	 * 
	 * @throws Exception
	 */
	public void homeLandingScreen(String userType, String tabName) throws Exception {
		extent.HeaderChildNode("Navigating to Home screen and verifing the Subscribe icon");
		System.out.println("Home Landing screen and verifing the subscribe icon");

		verifyElementPresentAndClick(AMDHomePage.objHomeTab, tabName + " Tab");
		String activeTab = getText(AMDHomePage.objSelectedTab);
		if (activeTab.equalsIgnoreCase(tabName)) {
			logger.info("user is able to navigate to " + tabName + " screen by tapping on " + tabName
					+ " tab displayed in the top navigation bar");
			extent.extentLogger(tabName + " Tab", "user is able to navigate to " + tabName + " screen by tapping on "
					+ tabName + " tab displayed in the top navigation bar");
		} else {
			logger.info("user is not able to navigate to " + tabName + " screen by tapping on " + tabName
					+ " tab displayed in the top navigation bar");
			extent.extentLoggerFail(tabName + " Tab", "user is not able to navigate to " + tabName
					+ " screen by tapping on " + tabName + " tab displayed in the top navigation bar");
		}
		waitTime(10000);
		// closeInterstitialAd(AMDGenericObjects.objCloseInterstitialAd, 2000);

		if (!(userType.equalsIgnoreCase("SubscribedUser"))) {
			if (verifyElementDisplayed(AMDHomePage.objSubscribeTeaser)) {
				logger.info("subscribe icon is dislayed");
				extent.extentLogger("Subscribe icon", "subscribe icon is dislayed");
			} else {
				logger.info("subscribe icon is not dislayed");
				extent.extentLoggerFail("Subscribe icon", "subscribe icon is not dislayed");
			}
		} else {
			if (verifyElementIsNotDisplayed(AMDHomePage.objSubscribeTeaser)) {
				logger.info("subscribe icon is not dislayed");
				extent.extentLogger("Subscribe icon", "subscribe icon is not dislayed");

			} else {
				logger.info("subscribe icon is dislayed");
				extent.extentLoggerFail("Subscribe icon", "subscribe icon is dislayed");
			}
		}

		carouselValidation(userType, tabName);

		String courselContentTitle = carouselValidationWithApi(userType, "homepage");
		verifyElementPresentAndClick(AMDHomePage.objContentTitle(courselContentTitle), "Carousel content");

		if (!(verifyElementIsNotDisplayed(AMDHomePage.objWatchTrailerIconOnPlayerscreen))) {
			if (verifyElementIsNotDisplayed(AMDHomePage.objLoginButtonOnPlayerscreen)) {
				logger.info(
						"Content playback is initiated for the guest user post tapping on premium content which is having trailer");
				extentLogger("Trailer",
						"Content playback is initiated for the guest user post tapping on premium content which is having trailer");

			} else {
				logger.info(
						"Content playback is not initiated for the guest user post tapping on premium content which is having trailer");
				extentLoggerFail("Trailer",
						"Content playback is not initiated for the guest user post tapping on premium content which is having trailer");
			}
			Back(1);
		} else {
			if (!(verifyElementIsNotDisplayed(AMDHomePage.objLoginButtonOnPlayerscreen))) {
				logger.info(
						"Content playback is not initiated for the guest user post tapping on premium content which is not having trailer");
				extentLogger("Trailer",
						"Content playback is not initiated for the guest user post tapping on premium content which is not having trailer");
			} else {
				logger.info(
						"Content playback is initiated for the guest user post tapping on premium content which is not having trailer");
				extentLoggerFail("Trailer",
						"Content playback is initiated for the guest user post tapping on premium content which is not having trailer");
			}
			Back(1);
		}

		extent.HeaderChildNode("Verifing the availability of trays in the screen");
		findingTrayInscreen(2, AMDHomePage.objTrayTitle("Continue Watching"), AMDHomePage.objCarouselConetentCard,
				"Continue watching tray", "MastheadCarousel", userType, tabName);
		findingTrayInscreen(2, AMDHomePage.objTrayTitle("Trending on ZEE5"), AMDHomePage.objCarouselConetentCard,
				"Trending on Zee5 tray", "MastheadCarousel", userType, tabName);
		findingTrayInscreen(25, AMDHomePage.objTrayTitle("Trending Trailers"), AMDHomePage.objCarouselConetentCard,
				"Trending Trailers and Teasers tray", "Mastheadcarousel", userType, tabName);

		if (userType.equalsIgnoreCase("Guest")) {
			selectContentLang_MoreMenu2("English,Malayalam");
			waitTime(5000);
			// closeInterstitialAd(AMDGenericObjects.objCloseInterstitialAd, 2000);
			findingTrayInscreen(25, AMDHomePage.objTrayTitle("Live Channels"), AMDHomePage.objCarouselConetentCard,
					"Live Channels tray", "Mastheadcarousel", userType, tabName);
			findingTrayInscreen(25, AMDHomePage.objTrayTitle("Malayalam Movie Bonanza"),
					AMDHomePage.objCarouselConetentCard, "Malayalam Movie Bonanza tray", "Mastheadcarousel", userType,
					tabName);
			deselectContentLang_MoreMenuAndSelectDefaultLanguage("English,Malayalam");
		}
	}

	public void selectContentLang_MoreMenu2(String planguage) throws Exception {

		click(AMDHomePage.HomeIcon, "Home button");
		click(AMDHomePage.MoreMenuIcon, "More Menu");
		Swipe("UP", 1);
		verifyElementPresentAndClick(AMDMoreMenu.objSettings, "Settings CTA");
		verifyElementPresent(AMDGenericObjects.objScreenTitleName("Settings"), "Settings Screen");
		Swipe("UP", 1);
		verifyElementPresentAndClick(AMDMoreMenu.objContentLang, "Content language");
		verifyElementPresent(AMDGenericObjects.objScreenTitleName("Content Language"), "Content language screen");

		// ***** UnSelecting default content languages *****
		if (pUserType.contains("Guest")) {
			click(AMDOnboardingScreen.objSelectContentLang("English"), "English");
			PartialSwipe("UP", 2);
			waitTime(1000);
			click(AMDOnboardingScreen.objSelectContentLang("Kannada"), "Kannada");
			Swipe("DOWN", 1);
		}

		// ***** Selecting required language *****
		if (planguage.contains(",")) {
			Swipe("DOWN", 1);
			String[] pLanguages = planguage.split(",");
			int n = pLanguages.length;
			for (int i = 0; i < n; i++) {

				for (int j = 0; j < 5; j++) {
					if (getDriver().findElements(AMDOnboardingScreen.objSelectContentLang(pLanguages[i])).size() == 0) {
						PartialSwipe("UP", 1);
					} else {
						verifyElementPresentAndClick(AMDOnboardingScreen.objSelectContentLang(pLanguages[i]),
								pLanguages[i]);
						break;
					}
				}
			}
		} else {
			outerLoop: for (int i = 1; i <= 4; i++) {
				int totalLanguages = getCount(AMDOnboardingScreen.objContentLangBtns);
				for (int j = 1; j <= totalLanguages; j++) {
					String visibleLang = getText(AMDOnboardingScreen.objgetContentLangName(j));
					if (planguage.equalsIgnoreCase(visibleLang)) {
						verifyElementPresentAndClick(AMDOnboardingScreen.objSelectContentLang(planguage), planguage);
						break outerLoop;
					}
				}
				PartialSwipe("UP", 1);
			}
		}

		waitTime(1000);
		verifyElementPresentAndClick(AMDOnboardingScreen.objContent_ContinueBtn, "Continue button");
		waitTime(1000);
//	click(AMDGenericObjects.objBackBtn, "Back button");
		Back(1);
		click(AMDHomePage.HomeIcon, "Home button");
	}

	public static String carouselValidationWithApi(String userType, String pagenameforApi) {
		Response respPage = ResponseInstance.getResponseForApplicasterPages(userType, pagenameforApi);
//	System.out.println(respPage);

		List<String> bucketsSize = respPage.jsonPath().getList("buckets");
		logger.info("bucketsSize: " + bucketsSize.size());
		String carouselContentTitle = null;
		main: for (int i = 0; i < bucketsSize.size(); i++) {
			String description = respPage.jsonPath().getString("buckets[" + i + "].short_description");

			if ((description.equalsIgnoreCase("Home Page Slider")) | (description.equalsIgnoreCase("Movies Banner"))) {
				List<String> carouselItems = respPage.jsonPath().getList("buckets[" + i + "].items");
				logger.info("carouselItems: " + carouselItems.size());

				for (int j = 0; j < 7; j++) {
					carouselContentTitle = respPage.jsonPath().getString("buckets[" + i + "].items[" + j + "].title");
					logger.info(carouselContentTitle);

					String CarouselContentBusinessType = respPage.jsonPath()
							.getString("buckets[" + i + "].items[" + j + "].business_type");
					logger.info(CarouselContentBusinessType);

					if (CarouselContentBusinessType.equalsIgnoreCase("premium_downloadable")) {
						break main;
					}
				}
			}
		}
		return carouselContentTitle;
	}

	public void deselectContentLang_MoreMenuAndSelectDefaultLanguage(String planguage) throws Exception {

		click(AMDHomePage.HomeIcon, "Home button");
		click(AMDHomePage.MoreMenuIcon, "More Menu");
		Swipe("UP", 1);
		verifyElementPresentAndClick(AMDMoreMenu.objSettings, "Settings CTA");
		verifyElementPresent(AMDGenericObjects.objScreenTitleName("Settings"), "Settings Screen");
		Swipe("UP", 1);
		verifyElementPresentAndClick(AMDMoreMenu.objContentLang, "Content language");
		verifyElementPresent(AMDGenericObjects.objScreenTitleName("Content Language"), "Content language screen");

		// ***** deSelecting selected language *****
		if (planguage.contains(",")) {
			Swipe("DOWN", 1);
			String[] pLanguages = planguage.split(",");
			int n = pLanguages.length;
			System.out.println(n);
			for (int i = 0; i < n; i++) {
				int totalLanguages = getCount(AMDOnboardingScreen.objContentLangBtns);
				for (int j = 1; j <= totalLanguages; j++) {
					String visibleLang = getText(AMDOnboardingScreen.objgetContentLangName(j));
					if (pLanguages[i].equalsIgnoreCase(visibleLang)) {
						verifyElementPresentAndClick(AMDOnboardingScreen.objSelectContentLang(pLanguages[i]),
								pLanguages[i]);
					}
				}
				PartialSwipe("UP", 3);
			}
		} else {
			outerLoop: for (int i = 1; i <= 4; i++) {
				int totalLanguages = getCount(AMDOnboardingScreen.objContentLangBtns);
				for (int j = 1; j <= totalLanguages; j++) {
					String visibleLang = getText(AMDOnboardingScreen.objgetContentLangName(j));
					if (planguage.equalsIgnoreCase(visibleLang)) {
						verifyElementPresentAndClick(AMDOnboardingScreen.objSelectContentLang(planguage), planguage);
						break outerLoop;
					}
				}
				PartialSwipe("UP", 1);
			}
		}

		// ***** Selecting default content languages *****
		if (pUserType.contains("Guest")) {
			Swipe("DOWN", 4);
			click(AMDOnboardingScreen.objSelectContentLang("English"), "English");
			PartialSwipe("UP", 2);
			waitTime(1000);
			click(AMDOnboardingScreen.objSelectContentLang("Kannada"), "Kannada");
			Swipe("DOWN", 1);
		}
		waitTime(1000);
		verifyElementPresentAndClick(AMDOnboardingScreen.objContent_ContinueBtn, "Continue button");
		waitTime(1000);
//	click(AMDGenericObjects.objBackBtn, "Back button");
		Back(1);
		click(AMDHomePage.HomeIcon, "Home button");
	}

	public void carouselValidation(String UserType, String tabName) throws Exception {
		extent.HeaderChildNode("Carousel validation");

		waitForElementDisplayed(AMDHomePage.objCarouselDots, 10);
		waitTime(10000);

		if ((verifyElementIsNotDisplayed(AMDHomePage.objBannerAd))) {
			verifyElementPresent(AMDHomePage.objCarouselUnitwhenNomastHeadAdbanner,
					"Carousel unit as first unit on " + tabName + " screen");
		} else {
			verifyElementPresent(AMDHomePage.objCarouselUnitwithmastHeadAdbanner,
					"Carousel unit as first unit on " + tabName + " screen");
		}

		// Validating Carousel manual swipe
		String width = getAttributValue("width", AMDHomePage.objCarouselConetentCard);

		String bounds = getAttributValue("bounds", AMDHomePage.objCarouselConetentCard);
		String b = bounds.replaceAll(",", " ").replaceAll("]", " ");
		String height = b.split(" ")[1];
		// System.out.println(height);
		waitTime(4000);

		carouselSwipe("RIGHT", 1, width, height);
		String Carouseltitle1 = getText(AMDHomePage.objCarouselTitle1);
		logger.info(Carouseltitle1);
		extentLogger("Carousel Title", Carouseltitle1);
		carouselSwipe("LEFT", 1, width, height);
		String Carouseltitle2 = getText(AMDHomePage.objCarouselTitle1);
		logger.info(Carouseltitle2);
		extentLogger("Carousel Title", Carouseltitle2);
		carouselSwipe("RIGHT", 1, width, height);
		String Carouseltitle3 = getText(AMDHomePage.objCarouselTitle1);
		logger.info(Carouseltitle3);
		extentLogger("Carousel Title", Carouseltitle3);
		if (!(Carouseltitle1.equalsIgnoreCase(Carouseltitle2))) {
			if (Carouseltitle3.equalsIgnoreCase(Carouseltitle1)) {
				logger.info("user is able to manually swipe banners from right to left or vice versa.");
				extent.extentLogger("Carousel swipe",
						"user is able to manually swipe banners from right to left or vice versa.");
			} else {
				logger.info("user is not able to manually swipe banners from right to left or vice versa.");
				extent.extentLoggerFail("Carousel swipe",
						"user is not able to manually swipe banners from right to left or vice versa.");
			}
		} else {
			logger.info("user is not able to manually swipe banners from right to left or vice versa.");
			extent.extentLoggerFail("Carousel swipe",
					"user is not able to manually swipe banners from right to left or vice versa.");
		}
		// Validating Pagination dot, Play icon and GetPremium on Carousel
		int noofCarouselContents = findElements(AMDHomePage.objCarouselDots).size();
		// System.out.println(noofCarouselContents);
		for (int i = 0; i < noofCarouselContents; i++) {
			logger.info(getText(AMDHomePage.objCarouselTitle1));
			verifyElementExist(AMDHomePage.objCarouselDots, "Pagination dot");
			carouselSwipe("LEFT", 1, width, height);
		}

		for (int i = 0; i < noofCarouselContents; i++) {

			logger.info(getText(AMDHomePage.objCarouselTitle1));
			verifyElementExist(AMDHomePage.objPlayBtn, "Play icon");
			carouselSwipe("LEFT", 1, width, height);
		}
		if ((tabName.equals("Kids")) | (tabName.equals("Music"))) {
			extent.extentLogger("Verify Get Premium tag", "Get Premium tag is not configured for " + tabName + " tab");
			logger.info("Get Premium tag is not configured for " + tabName + " tab");

		} else {
			if ((UserType.equalsIgnoreCase("Guest")) | (UserType.equalsIgnoreCase("NonSubscribedUser"))) {
				for (int i = 0; i < noofCarouselContents; i++) {

					logger.info(getText(AMDHomePage.objCarouselTitle1));
					verifyElementExist(AMDHomePage.objGetPremium, "GetPremium tag");
					carouselSwipe("LEFT", 1, width, height);
				}
				click(AMDHomePage.objGetPremium, "GetPremium tag");
				verifyElementPresent(AMDSubscibeScreen.objSubscribeHeader, "Subscription screen");
				Back(1);
			} else {
				for (int i = 0; i < noofCarouselContents; i++) {

					System.out.println(getText(AMDHomePage.objCarouselTitle1));
					if (verifyElementIsNotDisplayed(AMDHomePage.objGetPremium)) {
						logger.info("Get Premium tag is not displayed");
						extent.extentLogger("GetPremium tag", "Get Premium tag is not displayed");
					} else {
						logger.info("Get Premium tag is displayed");
						extent.extentLoggerFail("GetPremium tag", "Get Premium tag is displayed");
					}
					carouselSwipe("LEFT", 1, width, height);
				}
			}
		}

		// navigation to consumption screen of selected content
		String CarouselTitle = getText(AMDHomePage.objCarouselPlayIconContentCard);
		click(AMDHomePage.objCarouselPlayIconContentCard, "Carousel content");

		if (!(verifyElementIsNotDisplayed(AMDHomePage.objSubscribePopUpInConsumptionPage))) {
			Back(1);
		}
		verifyElementPresent(AMDHomePage.objConsumptionScreenTitle, "Consumption screen");
		String consumptionScreenTitle = getText(AMDHomePage.objConsumptionScreenTitle);

		if (CarouselTitle.equalsIgnoreCase(consumptionScreenTitle)) {
			logger.info("Consumption Screen is displayed for the selected content");
			extent.extentLogger("Consumption screen", "Consumption Screen is displayed for the selected content");
		} else {
			logger.info("Consumption Screen is not displayed for the selected content");
			extent.extentLoggerFail("Consumption screen",
					"Consumption Screen is not displayed for the selected content");
		}
		Back(1);

		// Validating Carousel Auto scroll
		String title1 = getText(AMDHomePage.objCarouselTitle1);
		logger.info(title1);
		extentLogger("Carousel Title", title1);
		waitTime(4000);
		String title2 = getText(AMDHomePage.objCarouselTitle2);
		logger.info(title2);
		extentLogger("Carousel Title", title2);
		waitTime(4000);
		String title3 = getText(AMDHomePage.objCarouselTitle3);
		logger.info(title3);
		extentLogger("Carousel Title", title3);

		if (!(title1.equalsIgnoreCase(title2))) {
			if (!(title2.equalsIgnoreCase(title3))) {
				logger.info(
						"Banners available in feature carousel unit rotates from right to left at a fixed time interval");
				extentLogger("Carousel unit Autorotation",
						"Banners available in feature carousel unit rotate from right to left at a fixed time interval");
			} else {
				logger.info(
						"Banners available in feature carousel unit are not rotating from right to left at a fixed time interval");
				extentLoggerFail("Carousel unit Autorotation",
						"Banners available in feature carousel unit are not rotating from right to left at a fixed time interval");
			}
		} else {
			logger.info(
					"Banners available in feature carousel unit are not rotating from right to left at a fixed time interval");
			extentLoggerFail("Carousel unit Autorotation",
					"Banners available in feature carousel unit are not rotating from right to left at a fixed time interval");
		}
	}

	@SuppressWarnings("rawtypes")
	public void carouselSwipe(String direction, int count, String width, String height) throws Exception {
		touchAction = new TouchAction(getDriver());

		try {
			if (direction.equalsIgnoreCase("LEFT")) {

				for (int i = 0; i < count; i++) {

					int startx = (Integer.valueOf(width)) - 200;
					int endx = 100;
					int starty = (Integer.valueOf(height)) + 300;
					touchAction.press(PointOption.point(startx, starty))
							.waitAction(WaitOptions.waitOptions(Duration.ofMillis(100)))
							.moveTo(PointOption.point(endx, starty)).release().perform();
					logger.info("Swiping screen in " + " " + direction + " direction" + " " + (i + 1) + " times");
					extent.extentLogger("SwipeLeft",
							"Swiping screen in " + " " + direction + " direction" + " " + (i + 1) + " times");
				}
			} else if (direction.equalsIgnoreCase("RIGHT")) {

				for (int j = 0; j < count; j++) {
					int startx = 100;
					int endx = (Integer.valueOf(width)) - 200;
					int starty = (Integer.valueOf(height)) + 300;
					touchAction.press(PointOption.point(startx, starty))
							.waitAction(WaitOptions.waitOptions(Duration.ofMillis(100)))
							.moveTo(PointOption.point(endx, starty)).release().perform();

					logger.info("Swiping screen in " + " " + direction + " direction" + " " + (j + 1) + " times");
					extent.extentLogger("SwipeRight",
							"Swiping screen in " + " " + direction + " direction" + " " + (j + 1) + " times");
				}
			}
		} catch (Exception e) {
			logger.error(e);

		}
	}

	public void findingTrayInscreen(int j, By byLocator1, By byLocator2, String str1, String str2, String userType,
			String tabName) throws Exception {
		boolean tray = false;
		for (int i = 0; i < j; i++) {
			if (verifyElementIsNotDisplayed(byLocator1)) {
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
								extent.extentLogger("Left watch time info",
										"Left watch time info on cards is available");
							} else {
								logger.info("Left watch time info on cards is not available");
								extent.extentLoggerFail("Left watch time info",
										"Left watch time info on cards is not available");
							}
							if (verifyElementDisplayed(AMDHomePage.objProgressBarOfFirstContentOfCWTray)) {
								logger.info("Progress bar is displayed to indicate the content watched portion");
								extent.extentLogger("Progress bar",
										"Progress bar is displayed to indicate the content watched portion");
							} else {
								logger.info("Progress bar is not displayed to indicate the content watched portion");
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
					logger.info(str1 + " is not displayed");
					extent.extentLogger("Tray", str1 + " is not displayed");
				} else {
					logger.info(str1 + " is not displayed");
					extent.extentLoggerFail("Tray", str1 + " is not displayed");
				}
			} else {
				if (tabName.equalsIgnoreCase("Home")) {

					if (str1.equalsIgnoreCase("Continue watching tray")) {

						Response respCW = ResponseInstance.getRespofCWTray(userType);

						List<String> ApinoOfContentsInCW = respCW.jsonPath().getList("array");
						logger.info("no.of contents in CW tray in Api " + ApinoOfContentsInCW.size());

						if (ApinoOfContentsInCW.size() == 0) {

							logger.info(str1 + " is not displayed for this user");
							extent.extentLogger("Tray", str1 + " is not displayed for this user");
						} else {
							logger.info(str1 + " is not displayed for this user");
							extent.extentLoggerFail("Tray", str1 + " is not displayed for this user");
						}
					}
					logger.info(str1 + " is not displayed");
					extent.extentLoggerFail("Tray", str1 + " is not displayed");
				}

			}
		}
		for (int i = 0; i < j; i++) {
			if (verifyElementIsNotDisplayed(byLocator2)) {
				Swipe("DOWN", 1);
			} else {
				verifyElementExist(byLocator2, str2);
				break;
			}
		}
	}

	public void adBannerVerify(String tabname) throws Exception {
		extent.HeaderChildNode("Masthead and Display Ad verification");
		System.out.println("Masthead and Display Ad verification");
		waitTime(20000);
		closeInterstitialAd(AMDGenericObjects.objCloseInterstitialAd, 10000);

		getDriver().findElement(By.xpath("//*[@id='title' and @text='" + tabname + "']")).click();
		waitTime(10000);

		if (verifyElementDisplayed(AMDHomePage.objBannerAd)) {
			logger.info("Masthead and Display ads are displayed properly in " + tabname + " screen");
			extent.extentLogger("Ads", "Masthead and Display ads are displayed properly in " + tabname + " screen");
		} else {
			logger.info("Masthead and Display ads are not displayed properly in " + tabname + " screen");
			extent.extentLoggerFail("Ads",
					"Masthead and Display ads are not displayed properly in " + tabname + " screen");
		}
	}

	/**
	 * Author : Bhavana Module : Download Screen Validation
	 */

	public void EmptystateScreenValidation(String userType) throws Exception {
		extent.HeaderChildNode("Downloads screen Empty-state validation as " + userType);
		System.out.println("\nDownloads screen Empty-state validation as: " + userType);
		click(AMDHomePage.objDownloadBtn, "Downloads button");
		waitTime(3000);
		if (verifyElementExist(AMDDownloadPage.objDwnloadsHeader,
				"Downloads header at the top on center of the screen")) {
			extent.extentLogger("Downloads tab",
					"User is navigated to Downloads screen on tapping Downloads button present in the bottom navigation bar");
			logger.info(
					"User is navigated to Downloads screen on tapping Downloads button present in the bottom navigation bar");
		} else {
			extent.extentLoggerFail("Downloads tab", "User fails to navigate to Downloads screen");
			logger.error("User fails to navigate to Downloads screen");
		}
		Back(1);
		click(AMDHomePage.objDownloadBtn, "Downloads button");

		if (verifyElementExist(AMDDownloadPage.objBrowseToDownloadBtn,
				"Browse to Download CTA in Empty-state screen to download")) {
			extent.extentLogger("Downloads screen",
					"User is navigated to Empty-state screen when no downloaded contents are present");
			logger.info("User is navigated to Empty-state screen when no downloaded contents are present");
		} else {
			extent.extentLoggerFail("Downloads screen",
					"User fails to navigate to Empty-state screen when no downloaded contents are present");
			logger.error("User fails to navigate to Empty-state screen when no downloaded contents are present");
		}
		verifyElementPresentAndClick(AMDDownloadPage.objBrowseToDownloadBtn,
				"Browse to Download CTA in Empty-state screen");
		waitTime(3000);
		String getPropertyshows = getAttributValue("enabled", AMDDownloadPage.objshowstab);
		if (getPropertyshows.equalsIgnoreCase("true")) {
			extent.extentLogger("Shows tab",
					"“Browse to Download” button is be tappable in the Empty-state screen to Download the content ");
			logger.info(
					"“Browse to Download” button is be tappable in the Empty-state screen to Download the contents");
		} else {
			extent.extentLoggerFail("Shows tab", "User fails to tap the 'Browse to Download' button");
			logger.error("User fails to tap the 'Browse to Download' button");
		}
		click(AMDHomePage.objDownloadBtn, "Downloads button");
	}

	public void validationofDownloadingContent() throws Exception {
		extent.HeaderChildNode("Validating funtionality of Pause and Continue Download CTA call-Out option");
		System.out.println("\nValidating funtionality of Pause and Continue Download CTA call-Out option");

		DownloadContent(content2, pVideoQuality, true);
		if (checkElementExist(AMDDownloadPage.objDownloadingText)) {
			extent.extentLogger("Donwloading Content", "Downloading content is displayed in Downloads screen");
			logger.info("Downloading content is displayed in Donwloads screen");
		} else {
			extent.extentLoggerFail("Donwloading Content", "Downloading content is not displayed in Downloads screen");
			logger.error("Downloading content is not displayed in Downloads screen");
		}
		verifyElementExist(AMDDownloadPage.objDownloadingText, "'Downloading' text");
		click(AMDDownloadPage.objDownloadingText, "Downloading text");
		verifyElementExist(AMDDownloadPage.objDownloadingCircularBar, "Downloading circular bar");
		click(AMDDownloadPage.objDownloadingCircularBar, "Downloading circular bar");
		if (verifyElementExist(AMDDownloadPage.objPauseDownloadoption, "Call out with Pause option")) {
			extent.extentLogger("Pause", "Pause option is displayed when user taps Downloding content");
			logger.info("Pause option is displayed when user taps Downloding content");
		} else {
			extent.extentLoggerFail("Pause", "Pause option is NOT displayed when user taps Downloding content");
			logger.error("Pause option is NOT displayed when user taps Downloding content");
		}
		waitTime(2000);
		if (verifyElementExist(AMDDownloadPage.objCancelDownloadOption, "Call out with Cancel Download option")) {
			extent.extentLogger("Pause", "Cancel Download is displayed when user taps Downloding content");
			logger.info("Cancel Download is displayed when user taps Downloding content");
		} else {
			extent.extentLoggerFail("Pause", "Cancel Download is NOT displayed when user taps Downloding content");
			logger.error("Cancel Download NOT is displayed when user taps Downloding content");
		}
		click(AMDDownloadPage.objPauseDownloadoption, "Pause option");
		verifyElementExist(AMDDownloadPage.objPausedText, "'Paused' text");
		if (verifyElementExist(AMDDownloadPage.objPausedBar, "Paused bar")) {
			extent.extentLogger("Pause", "User is able to Pause the Downloading content on tapping 'Pause' option");
			logger.info("User is able to Pause the Downloading content on tapping 'Pause' option");
		} else {
			extent.extentLoggerFail("Pause",
					"User is fails to Pause the Downloading content on tapping 'Pause' option");
			logger.error("User fails to Pause the Downloading content on tapping 'Pause' option");
		}
		click(AMDDownloadPage.objPausedBar, "Paused bar");
		verifyElementPresentAndClick(AMDDownloadPage.objContinueOption, "Continue option");
		if (verifyElementExist(AMDDownloadPage.objDownloadingCircularBar, "Downloading circular bar")) {
			extent.extentLogger("Re-start", "User is able to re-start the Paused content");
			logger.info("User is able to re-start the Paused content");
		} else {
			extent.extentLoggerFail("Re-start", "User fails to re-start the Paused content");
			logger.error("User fails to re-start the Paused content");
		}
	}

	public void DownloadContent(String str) throws Exception {
		System.out.println("\nInitiate Download : " + str);
		verifyElementPresentAndClick(AMDSearchScreen.objSearchIcon2, "Search Icon");
//		verifyElementPresentAndClick(AMDDownloadPage.objSearchIcon, "Search Icon");
		waitTime(3000);
		click(AMDSearchScreen.objSearchEditBox, "Search edit");
		type(AMDSearchScreen.objSearchBoxBar, str, "Search Field");
		waitTime(3000);
		hideKeyboard();
		click(AMDSearchScreen.objSelectFirstEpisodeResult, "Searched Show");
		waitTime(5000);
		verifyElementPresentAndClick(AMDDownloadPage.objDownloadIcon, "Download button");
		verifyElementExist(AMDDownloadPage.objDownloadVideoQualityPopup, "Download video quality Pop up");
		click(AMDDownloadPage.objStartDownloadCTA, "Start Download CTA");
		waitTime(2000);
		Back(1);
		click(AMDHomePage.objDownloadBtn, "Downloads tab");
	}

	public void pauseAllAndCancelDownload() throws Exception {
		extent.HeaderChildNode("Validating Call-Out options with Pause All and Cancel Download CTA");
		System.out.println("\nValidating Call-Out options with Pause All and Cancel Download CTA");

		verifyElementPresentAndClick(AMDDownloadPage.objDownloadingCircularBar, "Downloading Icon");
		verifyElementExist(AMDDownloadPage.objCallOutwithPauseAll, "Call out with Pause and Cancel Download CTAs");
		verifyElementExist(AMDDownloadPage.objPauseAllOption, "Pause All CTA");
		verifyElementExist(AMDDownloadPage.objCancelDownloadOption, "Cancel Download CTA");
		click(AMDDownloadPage.objPauseAllOption, "Pause All CTA");
		if (verifyElementExist(AMDDownloadPage.objPausedText, "'Paused' text")) {
			extent.extentLogger("Pause All", "Queued contents are Paused and in Paused state");
			logger.info("Queued contents are Paused and in Paused state");
		}
		click(AMDDownloadPage.objPausedIcon("Comedy Kiladigalu Championship Episode 24"), "Paused icon");
		click(AMDDownloadPage.objRetryCTA, "Continue option");
		int totalEpisodesList = getDriver().findElements(AMDDownloadPage.objNoOfEpisodeList).size();
		logger.info(totalEpisodesList);
		click(AMDDownloadPage.objDownloadingCircularBar, "Downloading Icon");
		click(AMDDownloadPage.objCancelDownloadOption, "Cancel Download CTA");
		waitTime(3000);
		int totalEpisodesList2 = getDriver().findElements(AMDDownloadPage.objNoOfEpisodeList).size();
		logger.info(totalEpisodesList2);
		if (totalEpisodesList != totalEpisodesList2) {
			extent.extentLogger("Cancel Download", "Downloading content is deleted");
			logger.info("Downloading content is deleted");
		} else {
			extent.extentLoggerFail("Cancel Download",
					"Downloading content is not deleted on tapping Cancel Download CTA");
			logger.error("Downloading content is not deleted on tapping Cancel Download CTA");
		}
	}

	public void DownloadsSection() throws Exception {
		extent.HeaderChildNode("Validating Downloads Page section");
		System.out.println("\nValidating Downloads Page section");

		verifyElementExist(AMDDownloadPage.objTitleoftheShow, "Title of the show");
		System.out.println("Title of the Show is " + getText(AMDDownloadPage.objTitleoftheShow));
		logger.info("Title of the Show is " + getText(AMDDownloadPage.objTitleoftheShow));
		extent.extentLogger("Title", "Title of the Show is " + getText(AMDDownloadPage.objTitleoftheShow));
		verifyElementExist(AMDDownloadPage.objNoOfEpisodes, "Number of Episodes");
		System.out.println("Number of Episodes are " + getText(AMDDownloadPage.objNoOfEpisodes));
		logger.info("Number of Episodes are " + getText(AMDDownloadPage.objNoOfEpisodes));
		extent.extentLogger("Episodes", "Number of Episodes are " + getText(AMDDownloadPage.objNoOfEpisodes));
		verifyElementExist(AMDDownloadPage.objSizeOfEpiodes, "Size of Episodes");
		System.out.println("Size of Episodes is " + getText(AMDDownloadPage.objSizeOfEpiodes));
		logger.info("Size of Episodes is " + getText(AMDDownloadPage.objSizeOfEpiodes));
		extent.extentLogger("Size", "Size of Episodes is " + getText(AMDDownloadPage.objSizeOfEpiodes));
		verifyElementExist(AMDDownloadPage.objRightArrowinDownloads, "Right Arrow");
		verifyElementExist(AMDDownloadPage.objThumbnailOfShows, "Thumbnail of the Show");
		waitTime(2000);
		click(AMDDownloadPage.objTitleoftheShow, "Title of the show");
		if (verifyElementExist(AMDDownloadPage.objDownloadMoreCTA, "Download More CTA")) {
			extent.extentLogger("Download More", "Show name is Tappable");
			logger.info("Show name is Tappable");
		} else {
			extent.extentLoggerFail("Download More", "Show name NOT is Tappable");
			logger.error("Show name is NOT Tappable");
		}
		Back(1);
		click(AMDDownloadPage.objThumbnailOfShows, "Thumbnail of the Show");
		if (verifyElementExist(AMDDownloadPage.objDownloadMoreCTA, "Download More CTA")) {
			extent.extentLogger("Download More", "Thumbnail is Tappable");
			logger.info("Thumbnail is Tappable");
		} else {
			extent.extentLoggerFail("Download More", "Thumbnail is NOT Tappable");
			logger.error("Thumbnail is NOT Tappable");
		}
		Back(1);
		click(AMDDownloadPage.objRightArrowinDownloads, "Right Arrow");
		if (verifyElementExist(AMDDownloadPage.objDownloadMoreCTA, "Download More CTA")) {
			extent.extentLogger("Download More", "Right Arrow Tappable");
			logger.info("Right Arrow is Tappable");
		} else {
			extent.extentLoggerFail("Download More", "Right Arrow Tappable");
			logger.error("Right Arrow is Tappable");
		}
	}

	public void LatestEpisode() throws Exception {
		waitTime(3000);
		extent.HeaderChildNode("Validating New Episode");
		System.out.println("Validating New Episode");
		if (checkElementExist(AMDDownloadPage.objNewEpisodeContent, "New Episode on top")) {
			extent.extentLogger("New Epiosde on top ", "New Episode on top is displayed");
			logger.info("New Episode on top is displayed");
		} else {
			extent.extentLoggerFail("New Epiosde on top ", "New Episode on top is NOT displayed");
			logger.error("New Episode on top is NOT displayed");
		}
		String titleOfNewEpisode = getText(AMDDownloadPage.objtitleofNewEpisode);
		System.out.println(titleOfNewEpisode);
		if (checkElementExist(AMDDownloadPage.objNewEpisodeTag, "'New Episode' text")) {
			extent.extentLogger("New Epiosde text", "New Episode text is displayed");
			logger.info("New Episode text is displayed");
		} else {
			extent.extentLoggerFail("New Epiosde text", "New Episode text is NOT displayed");
			logger.error("New Episode text is NOT displayed");
		}
		if (checkElementExist(AMDDownloadPage.objThumbnailOfLatestEpisode, "Thumbnail of Latest Episode")) {
			extent.extentLogger("Thumbnail of Latest Episode", "Thumbnail of Latest Episode is displayed");
			logger.info("Thumbnail of Latest Episode is displayed");
		} else {
			extent.extentLoggerFail("Thumbnail of Latest Episode", "Thumbnail of Latest Episode NOT is displayed");
			logger.error("Thumbnail of Latest Episode is NOT displayed");
		}
		verifyElementExist(AMDDownloadPage.objDownloadNowbbtn, "Download Now button");
		verifyElementExist(AMDDownloadPage.objClosebtn, "Cancel button (X)");
		waitTime(2000);
		verifyElementPresentAndClick(AMDDownloadPage.objDownloadNowbbtn, "Download Now button");
		if (checkElementExist(AMDDownloadPage.objDownloadVideoQualityPopup, "Download popup")) {
			extent.extentLogger("Download Now ", "Download Now button is functional");
			logger.info("Download Now button is functional");
		} else {
			extent.extentLoggerFail("Download Now ", "Download Now button is NOT functional");
			logger.error("Download Now button is NOT functional");
		}
		Back(1);
		click(AMDDownloadPage.objClosebtn, "Cancel button (X)");
		if ((checkElementExist(AMDDownloadPage.objNewEpisodeTag, "New Episode")) == false) {
			extent.extentLogger("Cancel button", "Cancel button is Tappable");
			logger.info("Cancel button is Tappable");
		} else {
			extent.extentLoggerFail("Cancel button", "Cancel button is NOT Tappable");
			logger.error("Cancel button is NOT Tappable");
		}
		if ((checkElementExist(AMDDownloadPage.objThumbnailOfLatestEpisode, "Latest Episode")) == false) {
			extent.extentLogger("New Episode", "Latest Epiosde is not displayed on the top");
			logger.info("Latest Epiosde is not displayed on the top");
		} else {
			extent.extentLoggerFail("New Episode", "Latest Epiosde is not displayed on the top");
			logger.error("Latest Epiosde is not displayed on the top");
		}
		waitTime(2000);
		Back(1);
		click(AMDDownloadPage.objRightArrowinDownloads, "Right Arrow");
		waitTime(2000);
		verifyElementPresentAndClick(AMDDownloadPage.objDownloadNowbbtn, "Download Now button");
		click(AMDDownloadPage.objDownloadVideoQualityPopup, "Download video quality Pop up");
		click(AMDDownloadPage.objStartDownloadCTA, "Start Download CTA");
		waitTime(2000);
		verifyElementExist(AMDDownloadPage.objDownloadingCircularBar, "Downloading Icon");
		Back(1);
		verifyElementExist(AMDDownloadPage.objDownloadingText, "Downloading text");
		click(AMDDownloadPage.objDownloadingText, "Downloading text");
		if (checkElementExist(AMDDownloadPage.objEpisodesList, "Episoed List")) {
			extent.extentLogger("Episodes list", "Episodes list is displayed");
			logger.info("Episodes list is displayed");
		} else {
			extent.extentLoggerFail("Episodes list", "Episodes list is NOT displayed");
			logger.error("Episodes list is NOT displayed");
		}
		if ((checkElementExist(AMDDownloadPage.objClosebtn, "Cross (X) icon")) == false) {
			extent.extentLogger("Close button",
					"Cross (X) icon is not displayed when New Episode download is in progress");
			logger.info("Cross (X) icon is not displayed when New Episode download is in progress");
		} else {
			extent.extentLogger("Close button", "Cross (X) icon is displayed when New Episode download is in progress");
			logger.info("Cross (X) icon is displayed when New Episode download is in progress");
		}
		if (checkElementExist(AMDDownloadPage.objtitleofNewEpisode, titleOfNewEpisode)) {
			extent.extentLogger("Episodes list", "New Episode on top of the screen is displayed");
			logger.info("New Episode on top is displayed");
		} else {
			extent.extentLoggerFail("Episodes list", "New Episode on top of the screen is NOT displayed");
			logger.error("New Episode on top is NOT displayed");
		}
	}

	public void DownloadingOffline() throws Exception {
		extent.HeaderChildNode("Validation Downloads in Offline mode");
		System.out.println("\nValidation Downloads in Offline mode");

		// *** Verifying download in offline Mode
		setWifiConnectionToONOFF("Off");

		if (getOEMName.equalsIgnoreCase("Sony")) {
			Wifi_TurnOFFnON();
			waitTime(2000);
		}
		waitForElementDisplayed(AMDDownloadPage.objDownloadFailedText, 2000);
		verifyElementExist(AMDDownloadPage.objDownloadFailedText, "Download Failed text");
		verifyElementExist(AMDDownloadPage.objDownloadErrorText, "Download Error text");
		click(AMDDownloadPage.objDownloadErrorText, "Download Error text");
		verifyElementExist(AMDDownloadPage.objRetryCTA, "Retry CTA Call-Out");
		verifyElementExist(AMDDownloadPage.objCancelDownloadOption, "Cancel Download CTA Call-Out");

		setWifiConnectionToONOFF("ON");
		if (getOEMName.equalsIgnoreCase("Sony")) {
			Wifi_TurnOFFnON();
			waitTime(7000);
			waitForElementDisplayed(AMDDownloadPage.objRetryCTA, 2000);
		}
		click(AMDDownloadPage.objRetryCTA, "Call out with Retry CTA");
		waitTime(5000);
		if (verifyElementExist(AMDDownloadPage.objDownloadingCircularBar, "Downloading circular bar")) {
			extent.extentLogger("Re-start", "User is able to tap the Retry CTA and resumed downloading the content");
			logger.info("User is able to tap the Retry CTA and resumed downloading the content");
		} else {
			extent.extentLoggerFail("Re-start",
					"User fails to tap the Retry CTA and fail to resume downloading the content");
			logger.error("User fails to tap the Retry CTA and fail to resume downloading the content");
		}
	}

	public void verifyDownloadsSubscribeUser() throws Exception {
		extent.HeaderChildNode("Verify the download screen");
		System.out.println("\nVerify the download screen");
		verifyElementExist(AMDHomePage.objDownloadBtn, "Downloads tab at the bottom navigation bar");
		click(AMDHomePage.objDownloadBtn, "Downloads tab");
		waitTime(2000);
		String SubscriptionExpierstext = getDriver().findElement(AMDDownloadPage.objPackExpiredText).getText();
		System.out.println(SubscriptionExpierstext);
		if (SubscriptionExpierstext.equalsIgnoreCase("Your Subscription expires in 10 days")) {
			logger.info("Your Premium subscription expires in XX days text message is displayed");
			extent.extentLogger("Download Screen",
					"Your Premium subscription expires in XX days text message is displayed");
		} else {
			logger.error("Your Premium subscription expires in XX days text message is displayed");
			extent.extentLoggerFail("Download Screen",
					"Your Premium subscription expires in XX days text message is displayed");
		}
		verifyElementPresentAndClick(AMDSearchScreen.objSearchIcon2, "Search Icon");
		waitTime(3000);
		click(AMDSearchScreen.objSearchEditBox, "Search edit");
		type(AMDSearchScreen.objSearchBoxBar, "Dil Bechara - Title Track", "Search Field");
		waitTime(5000);
		hideKeyboard();
		click(AMDDownloadPage.objSearchedContent, "Searched Show");
		waitTime(3000);
		verifyElementPresentAndClick(AMDDownloadPage.objDownloadIcon, "Download button");
		waitTime(2000);
		click(AMDDownloadPage.objDownloadVideoQualityPopup, "Download video quality Pop up");
		click(AMDDownloadPage.objStartDownloadCTA, "Start Download CTA");
		waitTime(1000);
		Back(1);
		click(AMDHomePage.objDownloadBtn, "Downloads tab");
		verifyElementExist(AMDDownloadPage.objvideostab, "Videos tab in Downloads landing screen ");
		waitTime(2000);
		verifyElementExist(AMDDownloadPage.objDownloadedTickMark, "Tick Mark on the downloaded content");
		click(AMDDownloadPage.objDownloadedTickMark, "Tick Mark on the downloaded content");
		verifyElementExist(AMDDownloadPage.objDeleteDownloadOption, "Delete downloaded content");
		click(AMDDownloadPage.objDeleteDownloadOption, "Delete downloaded content");
		waitTime(4000);
		if (verifyElementExist(AMDDownloadPage.objDownloadTextIcon, "Download Icon")) {
			logger.info("Content is deleted by tapping on delete download");
			extent.extentLogger("Download Screen", "Content is deleted by tapping on delete download");
		} else {
			logger.error("Content is deleted by tapping on delete download");
			extent.extentLoggerFail("Download Screen", "Content is deleted by tapping on delete download");
		}
		verifyElementExist(AMDDownloadPage.objRemaindMeLater, "Remaind Me Later");
		click(AMDDownloadPage.objRemaindMeLater, "Remaind Me Later");
		if (verifyElementExist(AMDDownloadPage.objPackExpiredText, "Premium pack expires Text")) {
			logger.info("Premium pack expires text is not displayed by tapping on Remaind Me Later");
			extent.extentLogger("Download Screen",
					"Premium pack expires text is not displayed by tapping on Remaind Me Later");
		} else {
			logger.error("Premium pack expires text is not displayed by tapping on Remaind Me Later");
			extent.extentLoggerFail("Download Screen",
					"Premium pack expires text is not displayed by tapping on Remaind Me Later");
		}

	}

	public void DownloadScreenValidation(String userType) throws Exception {
		System.out.println("\nDownload Landing Screen Validation");
		if (userType.contentEquals("NonSubscribedUser") || userType.contentEquals("SubscribedUser")) {

			EmptystateScreenValidation(userType);
			verifyDownloadsWithSingleTire();
			verifyMovieContentInDownloadsScreen(pMovie, pVideoQuality);
			validationofDownloadingContent();

			int totalEpisodesList = getDriver().findElements(AMDDownloadPage.objNoOfEpisodeList).size();
			logger.info("Content Cards: " + totalEpisodesList);
			// --- Download check in Offline Mode
			DownloadingOffline();

			extent.HeaderChildNode("Verify Deleted Content from Downloads screen");
			System.out.println("\nVerify Deleted Content from Downloads screen");

			click(AMDDownloadPage.objDownloadingCircularBar, "Downloading circular bar");
			click(AMDDownloadPage.objCancelDownloadOption, "Cancel Download CTA");

			int totalEpisodesList2 = getDriver().findElements(AMDDownloadPage.objNoOfEpisodeList).size();
			logger.info("Content Cards: " + totalEpisodesList2);
			if (totalEpisodesList != totalEpisodesList2) {
				extent.extentLogger("Cancel Download", "Downloading content is deleted");
				logger.info("Downloading content is deleted");
			} else {
				extent.extentLoggerFail("Cancel Download", "Downloading content is NOT deleted");
				logger.error("Downloading content is NOT deleted");
			}
			waitTime(2000);
			Back(1);
			String getProperty1 = getAttributValue("enabled", AMDHomePage.objDownloadBtn);
			if (getProperty1.equalsIgnoreCase("true")) {
				extent.extentLogger("Downloads Tab", "Downloads active page without content downloading is displayed");
				logger.info("Downloads active page without content downloading is displayed");
			} else {
				extent.extentLoggerFail("Downloads tab",
						"No Downloads active page without content downloading is NOT displayed");
				logger.error("No Downloads active page without content downloading is NOT displayed");
			}

			extent.HeaderChildNode("Verify multiple downloading content in Downloads screen");
			System.out.println("\nVerify multiple downloading content in Downloads screen");

			// **** Download Episode content3
			DownloadContent(content3, pVideoQuality, true);
			if (checkElementExist(AMDDownloadPage.objDownloadingText)) {
				extent.extentLogger("Downloading Content", "Downloading content is displayed in Downloads screen");
				logger.info("Downloading content is displayed in Donwloads screen");
			} else {
				extent.extentLoggerFail("Downloading Content",
						"Downloading content is not displayed in Downloads screen");
				logger.error("Downloading content is not displayed in Downloads screen");
			}

			// **** Download Episode content4
			DownloadContent(content4, "Better", true);
			if (checkElementExist(AMDDownloadPage.objDownloadingText)) {
				extent.extentLogger("Donwloading Content", "Downloading content is displayed in Downloads screen");
				logger.info("Downloading content is displayed in Donwloads screen");
			} else {
				extent.extentLoggerFail("Donwloading Content",
						"Downloading content is not displayed in Downloads screen");
				logger.error("Downloading content is not displayed in Downloads screen");
			}
			if (checkElementExist(AMDDownloadPage.objShowsDownloadPage)) {
				extent.extentLogger("ShowsList", "Shows list is displayed in the upfront tab");
				logger.info("Shows list is displayed in the upfront tab");
			} else {
				extent.extentLoggerFail("ShowsList", "Shows list is NOT displayed in the upfront tab");
				logger.error("Shows list is NOT displayed in the upfront tab");
			}
			waitTime(3000);
			click(AMDDownloadPage.objDownloadingText, "Downloading text");
			if (checkElementExist(AMDDownloadPage.objDownloadingCircularBar)) {
				extent.extentLogger("Queued", "User is able to Download only one content at a time");
				logger.info("User is able to Download only one content at a time");
			} else {
				extent.extentLoggerFail("Queued", "User fails to Download only one content at a time");
				logger.error("User fails to Download only one content at a time");
			}
			if (verifyElementExist(AMDDownloadPage.objQueuedbar("Comedy Kiladigalu Championship Episode 9"),
					"Paused icon")) {
				extent.extentLogger("Queued", "Contents are Queued up in a line ");
				logger.info("Contents are Queued up in a line ");
			} else {
				extent.extentLoggerFail("Queued", "Contents are NOT Queued up in a line ");
				logger.error("Contents are NOT Queued up in a line ");
			}
			pauseAllAndCancelDownload();
			click(AMDDownloadPage.objPausedBar, "Paused icon");
			click(AMDDownloadPage.objRetryCTA, "Continue option");
			waitTime(2000);
			Back(1);

			// **** Download Episode content5
			DownloadContent(content5, pVideoQuality, true);
			waitTime(1000);
			click(AMDDownloadPage.objDownloadingText, "Downloading text");
			if (checkElementExist(AMDDownloadPage.objDownloadingCircularBar)) {
				extent.extentLogger("Downloading", "Incomplete Downloads are available");
				logger.info("Incomplete Downloads are available");
			}
			click(AMDDownloadPage.objDownloadingCircularBar, "Downloading Icon");
			if (checkElementExist(AMDDownloadPage.objCallOutwithPauseAll)) {
				extent.extentLogger("Downloading", "Incomplete Downloads are NOT allowed to be Play");
				logger.info("Incomplete Downloads are NOT allowed to be Play");
			} else {
				extent.extentLoggerFail("Downloading", "Incomplete Downloads are allowed to be Play");
				logger.error("Incomplete Downloads are allowed to be Play");
			}
//			switchNetworkWifiToData();
			Back(2);

			// **** Download Episode content6
			DownloadContent(content6, "Best", true);
			DownloadsSection();
			LatestEpisodeOnTheTop();
			click(AMDHomePage.HomeIcon, "Home Icon");
		}
		if (userType.contentEquals("SubscribedUser")) {
			ZNALogoutMethod();
			ValidateSubscriptionExpireBanner();
		}
	}

	public void DownloadContent(String contentName, String Quality, boolean checkAlwaysAskOption) throws Exception {
		System.out.println("\nInitiate Download : " + contentName);
		verifyElementPresentAndClick(AMDSearchScreen.objSearchIcon2, "Search Icon");
		waitTime(3000);
		click(AMDSearchScreen.objSearchEditBox, "Search edit");
		type(AMDSearchScreen.objSearchBoxBar, contentName, "Search Field");
		waitTime(3000);
		hideKeyboard();
		click(AMDSearchScreen.objSelectFirstEpisodeResult, "Searched Show");
		waitForElementDisplayed(AMDDownloadPage.objPauseIconOnPlayer, 2000);
		waitTime(3000);
		verifyElementPresentAndClick(AMDDownloadPage.objDownloadIcon, "Download button");
		waitTime(2000);
		DownloadVideoQualityPopUp(Quality, checkAlwaysAskOption);
		waitTime(2000);
		Back(1);
		click(AMDHomePage.objDownloadBtn, "Downloads Tab");
	}

	public void DownloadVideoQualityPopUp(String Quality, boolean checkAlwaysAsk) throws Exception {

		verifyElementExist(AMDDownloadPage.objDownloadVideoQualityPopup, "Download Video Quality PopUp screen");
		click(AMDDownloadPage.objDownloadQualityOptions(Quality), Quality);

		String getValue = getAttributValue("checked", AMDDownloadPage.objAlwaysAskCheckBox);
		if (checkAlwaysAsk) {
			if (!getValue.contains("true")) {
				click(AMDDownloadPage.objAlwaysAskCheckBox, "Always ask quality for every download");
			}
		} else {
			if (getValue.contains("true")) {
				click(AMDDownloadPage.objAlwaysAskCheckBox, "Always ask quality for every download");
			}
		}
		click(AMDDownloadPage.objStartDownloadCTA, "Start Download CTA");
	}

	public void switchNetworkWifiToData() throws Exception {
		extent.HeaderChildNode("Validating Downloading resumes after switching network");
		System.out.println("\nValidating Downloading resumes after switching network");

		// Switching Network from Wifi -> Data
		Runtime.getRuntime().exec("adb shell svc wifi disable");
		Runtime.getRuntime().exec("adb shell svc data enable");
		if (verifyElementExist(AMDDownloadPage.objDownloadingCircularBar, "Downloading Icon")) {
			extent.extentLogger("Downloading", "User is able to continue the download on shuffling wifi to data");
			logger.info("User is able to continue the download on shuffling wifi to data");
		}
		waitTime(2000);
		// Switching Network from Data -> Wifi
		Runtime.getRuntime().exec("adb shell svc data disable");
		Runtime.getRuntime().exec("adb shell svc wifi enable");
		if (verifyElementExist(AMDDownloadPage.objDownloadingCircularBar, "Downloading Icon")) {
			extent.extentLogger("Downloading", "User is able to continue the download on shuffling data to wifi");
			logger.info("User is able to continue the download on shuffling wifi to data");
		}
	}

	public void LatestEpisodeOnTheTop() throws Exception {
		extent.HeaderChildNode("Validating New Episode Overlay on the Top");
		System.out.println("\nValidating New Episode Overlay on the Top");

		if (checkElementExist(AMDDownloadPage.objNewEpisodeContent)) {
			extent.extentLogger("New Epiosde on top ", "New Episode content card is displayed on the Top");
			logger.info("New Episode on top is displayed");
		} else {
			extent.extentLoggerWarning("New Epiosde on top ", "New Episode content card is NOT displayed on the Top");
			logger.info("New Episode on top is NOT displayed");
		}

		if (checkElementExist(AMDDownloadPage.objNewEpisodeTag)) {
			String titleOfNewEpisode = getText(AMDDownloadPage.objtitleofNewEpisode);
			extent.extentLogger("New Epiosde title", "Episode title is: " + titleOfNewEpisode);
			logger.info("Episode title is: " + titleOfNewEpisode);
		} else {
			extent.extentLoggerWarning("New Epiosde title", "Episode title is NOT displayed");
			logger.error("Episode title is NOT displayed");
		}

		if (checkElementExist(AMDDownloadPage.objThumbnailOfLatestEpisode)) {
			extent.extentLogger("Thumbnail of Latest Episode", "Thumbnail Image of Latest Episode is displayed");
			logger.info("Thumbnail of Latest Episode is displayed");
		} else {
			extent.extentLoggerWarning("Thumbnail of Latest Episode", "Thumbnail of Latest Episode NOT is displayed");
			logger.error("Thumbnail Image of Latest Episode is NOT displayed");
		}
		verifyElementExist(AMDDownloadPage.objDownloadNowbbtn, "Download Now CTA");
		verifyElementPresentAndClick(AMDDownloadPage.objClosebtn, "Close button (X)");
		Back(1);
		click(AMDDownloadPage.objRightArrowinDownloads, "Right Arrow");
		if (checkElementExist(AMDDownloadPage.objDownloadNowbbtn)) {
			extent.extentLogger("Latest Epiosde", "Latest Epiosde is displayed on the top");
			logger.info("Latest Epiosde is not displayed on the top");
		} else {
			extent.extentLoggerWarning("Latest Epiosde", "Latest Epiosde is NOT displayed on the top");
			logger.error("Latest Epiosde is displayed on the top");
		}
		Back(1);
	}

	public void verifyMovieContentInDownloadsScreen(String MovieName, String Quality) throws Exception {
		extent.HeaderChildNode("Validating the downloading content in Movies tab");
		System.out.println("\nValidating the downloading content in Movies tab");

		DownloadContent(MovieName, Quality, true);
		String getPropertyValue = getAttributValue("enabled", AMDDownloadPage.objmoviestab);
		if (getPropertyValue.equalsIgnoreCase("true")) {
			extent.extentLogger("MOVIES Tab is highlighted",
					"User is taken to MOVIES tab by default, since download is in-progress..");
			logger.info("User is taken to MOVIES tab by default, since download is in-progress..");
		} else {
			extent.extentLoggerFail("MOVIES Tab",
					"User is NOT taken to MOVIES tab by default, even after initiating Movie content download");
			logger.error("User is NOT taken to MOVIES tab by default, even after initiating Movie content download");
		}

		if (checkElementExist(AMDDownloadPage.objDownloadingCircularBar)) {
			String getMovieName = getText(AMDDownloadPage.objDownloadedContent);
			click(AMDDownloadPage.objDownloadedContent, getMovieName);
			click(AMDDownloadPage.objCancelDownloadOption, "Cancel CTA");
			extent.extentLogger("Downloading Movie", getMovieName + " movie is downloading in the Downloads screen");
			logger.info(getMovieName + " movie is downloading in Downloads screen");
		} else {
			extent.extentLoggerFail("Donwloading Movie",
					"Downloading " + MovieName + " is NOT displayed in the Downloads screen");
			logger.error("Downloading " + MovieName + " is NOT displayed in Downloads screen");
		}
	}

	/**
	 * Author : Bhavana Module : Download Screen Validation
	 */
	public void DownloadScreenUIUXValidation(String userType) throws Exception {
		extent.HeaderChildNode("Verify the UI/UX of Download landing screen as " + userType);
		System.out.println("\nVerify the UI/UX of Download landing screen as " + userType);
		waitTime(5000);
		verifyElementExist(AMDHomePage.objDownloadBtn, "Downloads tab at the bottom navigation bar");
		click(AMDHomePage.objDownloadBtn, "Downloads tab");
		waitTime(3000);
		verifyElementExist(AMDDownloadPage.objDwnloadsHeader, "Downloads header at the top on center of the screen");
		verifyElementExist(AMDDownloadPage.objshowstab, "Shows tab in Downloads landing screen");
		verifyElementExist(AMDDownloadPage.objmoviestab, "Movies tab in Downlaods landing screen");
		verifyElementExist(AMDDownloadPage.objvideostab, "Videos tab in Downloads landing screen ");
		String getPropertyValue = getAttributValue("enabled", AMDDownloadPage.objshowstab);
		if (getPropertyValue.equalsIgnoreCase("true")) {
			extent.extentLogger("Shows tab", "Shows tab is by default highlighted");
			logger.info("Shows tab is by default highlighted");
		} else {
			extent.extentLoggerFail("Shows tab", "Shows tab fails to highlight by default");
			logger.error("Shows tab fails to highlight by default");
		}

		verifyElementPresentAndClick(AMDDownloadPage.objshowstab, "Shows tab in Downloads landing screen");
		verifyElementExist(AMDDownloadPage.objBrowseToDownloadBtn, "Browse to Download CTA under Shows tab");
		verifyElementPresentAndClick(AMDDownloadPage.objmoviestab, "Movies tab in Downlaods landing screen");
		verifyElementExist(AMDDownloadPage.objBrowseToDownloadBtn, "Browse to Download CTA under Movies tab");
		verifyElementPresentAndClick(AMDDownloadPage.objvideostab, "Videos tab in Downloads landing screen");
		verifyElementExist(AMDDownloadPage.objBrowseToDownloadBtn, "Browse to Download CTA under Videos tab");
	}

	public void BrowseToDownloadFunctionality(String userType) throws Exception {
		extent.HeaderChildNode("Verify Browse to Download CTA functionality as " + userType);
		System.out.println("\nVerify Browse to Download CTA functionality as " + userType);
		String getSelectedTabName;
		verifyElementPresentAndClick(AMDDownloadPage.objshowstab, "Shows tab in Downloads landing screen");
		verifyElementPresentAndClick(AMDDownloadPage.objBrowseToDownloadBtn, "Browse to Download CTA under Shows tab");
		waitTime(3000);
		getSelectedTabName = getText(AMDHomePage.objSelectedTab);
		if (getSelectedTabName.equalsIgnoreCase("Shows")) {
			extent.extentLogger("Shows tab", "User is navigated to Shows landing page");
			logger.info("User is navigated to Shows landing page");
		} else {
			extent.extentLoggerFail("Shows tab", "User fails to navigate to Shows landing page and instead displayed : "
					+ getSelectedTabName + " landing screen");
			logger.error("User fails to navigate to Shows landing page and instead displayed : " + getSelectedTabName
					+ " landing screen");
		}
		click(AMDHomePage.objDownloadBtn, "Downloads tab");
		verifyElementPresentAndClick(AMDDownloadPage.objmoviestab, "Movies tab in Downlaods landing screen");
		verifyElementPresentAndClick(AMDDownloadPage.objBrowseToDownloadBtn, "Browse to Download CTA under Movies tab");
		waitTime(3000);
		getSelectedTabName = getText(AMDHomePage.objSelectedTab);
		if (getSelectedTabName.equalsIgnoreCase("Movies")) {
			extent.extentLogger("Movies tab", "User is navigated to Movies landing page");
			logger.info("User is navigated to Movies landing page");
		} else {
			extent.extentLoggerFail("Movies tab",
					"User fails to navigate to Movies landing page and instead displayed : " + getSelectedTabName
							+ " landing screen");
			logger.error("User fails to navigate to Movies landing page and instead displayed : " + getSelectedTabName
					+ " landing screen");
		}
		click(AMDHomePage.objDownloadBtn, "Downloads tab");
		verifyElementPresentAndClick(AMDDownloadPage.objvideostab, "Videos tab in Downloads landing screen");
		verifyElementPresentAndClick(AMDDownloadPage.objBrowseToDownloadBtn, "Browse to Download CTA under Videos tab");
		waitTime(3000);
		getSelectedTabName = getText(AMDHomePage.objSelectedTab);
		if (getSelectedTabName.equalsIgnoreCase("Videos")) {
			extent.extentLogger("Videos tab", "User is navigated to videos landing page");
			logger.info("User is navigated to Videos landing page");
		} else {
			extent.extentLoggerFail("Movies tab",
					"User fails to navigate to Videos landing page and instead displayed : " + getSelectedTabName
							+ " landing screen");
			logger.error("User fails to navigate to Videos landing page and instead displayed : " + getSelectedTabName
					+ " landing screen");
		}
	}

	public void ZNALogoutMethod() throws Exception {
		verifyElementExist(AMDHomePage.objHomeTab, "Home tab");
		verifyElementPresentAndClick(AMDHomePage.objMoreMenu, "More Menu");
		waitTime(2000);
		PartialSwipe("UP", 2);
		verifyElementPresentAndClick(AMDHomePage.objLogout, "Logout");
		verifyElementPresentAndClick(AMDHomePage.objLogoutPopUpLogoutButton, "Logout button");
		verifyElementPresentAndClick(AMDHomePage.objHome, "Home tab");
	}

	public void ValidateSubscriptionExpireBanner(String LoginMethod) throws Exception {
		extent.HeaderChildNode("Verify the download screen");
		System.out.println("\nVerify the download screen");
		ZeeApplicasterLogin(LoginMethod);
		verifyElementExist(AMDHomePage.objDownloadBtn, "Downloads tab at the bottom navigation bar");
		click(AMDHomePage.objDownloadBtn, "Downloads tab");
		waitTime(2000);
		String SubscriptionExpiersText = getDriver().findElement(AMDDownloadPage.objPackExpiredText).getText();
		System.out.println(SubscriptionExpiersText);
		if (SubscriptionExpiersText.contains("Your Subscription expires in")) {
			logger.info(SubscriptionExpiersText + "text message is displayed");
			extent.extentLogger("Download Screen", SubscriptionExpiersText + "text message is displayed");
		} else {
			logger.error(SubscriptionExpiersText + "text message is displayed");
			extent.extentLoggerFail("Download Screen", SubscriptionExpiersText + "text message is not displayed");
		}
		waitTime(2000);
		verifyElementExist(AMDDownloadPage.objRemaindMeLater, "Remind Me Later");
		click(AMDDownloadPage.objRemaindMeLater, "Remind Me Later");
		if (verifyElementNotPresent(AMDDownloadPage.objPackExpiredText, 2)) {
			logger.info("Premium pack expires text is not displayed by tapping on Remaind Me Later");
			extent.extentLogger("Download Screen",
					"Premium pack expires text is not displayed by tapping on Remaind Me Later");
		}
	}

	public void verifyDownloadsWithSingleTire() throws Exception {
		extent.HeaderChildNode(
				"Validating Video DownloadScreen and Content playback of downloaded Video with Single tier content");
		System.out.println(
				"\nValidating Video DownloadScreen and Content playback of downloaded Video with Single tier content");

		verifyElementPresentAndClick(AMDSearchScreen.objDownloadsOption, "Downloading Icon");
		waitTime(2000);
		DownloadContent(content1, "Good", true);
		String DownloadedContentText = getDriver().findElement(AMDDownloadPage.objDownloadedVideoContent).getText();
		System.out.println(DownloadedContentText);
		if (DownloadedContentText.contains(content1)) {
			logger.info("Downloaded Video content is displayed in the Upfront screen of the Videos Tab");
			extent.extentLogger("Download Screen",
					"Downloaded Video content is displayed in the Upfront screen of the Videos Tab");
		} else {
			logger.error("Downloaded Video content is NOT displayed in the Upfront screen of the Videos Tab");
			extent.extentLoggerFail("Download Screen",
					"Downloaded Video content is NOT displayed in the Upfront screen of the Videos Tab");
		}
		Back(1);
		waitTime(3000);
		click(AMDSearchScreen.objDownloadsOption, "Downloading Icon");
		String getPropertyValue = getAttributValue("enabled", AMDDownloadPage.objvideostab);
		if (getPropertyValue.equalsIgnoreCase("true")) {
			extent.extentLogger("Videos tab",
					"Videos tab is by default highlighted, User is taken to VIDEOS tab by default, hence Shows and Movies tab do not have any downloaded content");
			logger.info(
					"Videos tab is by default highlighted, User is taken to VIDEOS tab by default, hence Shows and Movies tab do not have any downloaded content");
		} else {
			extent.extentLoggerFail("Videos tab",
					"Videos tab fails to highlight by default, User is NOT taken to VIDEOS tab by default, even though Shows/Movies has no downloaded content");
			logger.error(
					"Videos tab fails to highlight by default, User is NOT taken to VIDEOS tab by default, even though Shows/Movies has no downloaded content");
		}

		verifyElementPresentAndClick(AMDDownloadPage.objvideostab, "Videos tab in Downloads screen");
		verifyElementPresentAndClick(AMDDownloadPage.objDownloadedVideoContent, content1);
		verifyElementPresentAndClick(AMDDownloadPage.objPlayDownloadedContent, "Play Call-out");

		if (verifyElementDisplayed(AMDDownloadPage.objPauseIconOnPlayer)) {
			extent.extentLogger("Video Content", "Playback Started for Video Content : " + content1);
			logger.info("Playback Started for Video Content : " + content1);
		} else {
			logger.error("Playback failed to Start for Video Content - " + content1);
			extent.extentLoggerFail("Download Screen", "Playback failed to Start for the Video Content - " + content1);
		}
		Back(1);

		verifyElementPresentAndClick(AMDDownloadPage.objmoviestab, "Movies tab in Downlaods landing screen");
		if (verifyElementExist(AMDDownloadPage.objBrowseToDownloadBtn, "Browse to Download CTA under Movies tab")) {
			extent.extentLogger("Movies tab", "Movies Tab not having any downloaded content");
			logger.info("Movies Tab not having any downloaded content");
		}

		verifyElementPresentAndClick(AMDDownloadPage.objshowstab, "Shows tab in Downloads landing screen");
		if (verifyElementExist(AMDDownloadPage.objBrowseToDownloadBtn, "Browse to Download CTA under Shows tab")) {
			extent.extentLogger("Shows tab", "Shows Tab not having any downloaded content");
			logger.info("Shows Tab not having any downloaded content");
		}
	}

	public void ValidateSubscriptionExpireBanner() throws Exception {
		extent.HeaderChildNode("Validating Subscription Expiry banner in Donwloads Screen");
		System.out.println("\nValidating Subscription Expiry banner in Donwloads Screen");
		click(AMDHomePage.objMoreMenu, "More Menu");
		click(AMDMoreMenu.objProfile, "Profile");

		String SubscribedUserWith15daysExpiryUsername = Reporter.getCurrentTestResult().getTestContext()
				.getCurrentXmlTest().getParameter("SubscribedUserWith15daysExpiryUsername");
		String SubscribedUserWith15daysExpiryPassword = Reporter.getCurrentTestResult().getTestContext()
				.getCurrentXmlTest().getParameter("SubscribedUserWith15daysExpiryPassword");
		verifyElementPresentAndClick(AMDLoginScreen.objEmailIdField, "Email field");

		LoginWithEmailID(SubscribedUserWith15daysExpiryUsername, SubscribedUserWith15daysExpiryPassword);
		waitTime(3000);
		verifyElementExist(AMDHomePage.objDownloadBtn, "Downloads tab at the bottom navigation bar");
		click(AMDHomePage.objDownloadBtn, "Downloads tab");
		click(AMDDownloadPage.objmoviestab, "Movies tab");

		if (verifyIsElementDisplayed(AMDDownloadPage.objPackExpiredText)) {
			String SubscriptionExpiersText = getDriver().findElement(AMDDownloadPage.objPackExpiredText).getText();
			System.out.println(SubscriptionExpiersText);
			if (SubscriptionExpiersText.contains("Your Subscription expires in")) {
				logger.info(SubscriptionExpiersText + "  is displayed");
				extent.extentLogger("Downloads Screen", SubscriptionExpiersText + " is displayed");
			} else {
				logger.error("Your Subscription expires in X-days is NOT displayed");
				extent.extentLoggerFail("Downloads Screen", "Your Subscription expires in X-days is NOT displayed");
			}
		} else {
			logger.error("Subscription is about to Expire message is NOT displayed");
			extent.extentLoggerWarning("Your Subscription expires",
					"Subscription is about to Expire message is NOT displayed");
		}

		waitTime(2000);
		verifyElementExist(AMDDownloadPage.objRemaindMeLater, "Remind Me Later");
		click(AMDDownloadPage.objRemaindMeLater, "Remind Me Later");
		if (checkElementExist(AMDDownloadPage.objIcon)) {
			logger.info("Premium pack expires message is not displayed on tapping - Remaind Me Later");
			extent.extentLogger("Downloads Screen",
					"Premium pack expires text is not displayed on tapping - Remaind Me Later");
		}
		click(AMDHomePage.HomeIcon, "Home Icon");
	}

	/**
	 * Author : Bindu Module : Shows Screen
	 */
	public void verifyShowsScreen(String userType) throws Exception {
		extent.HeaderChildNode("Verify user navigates to shows screen");
		System.out.println("\nVerify User navigated to Shows Screen");
		verifyElementPresentAndClick(AMDHomePage.objShowsTab, "Shows Tab");
		String getPropertyValue = getAttributValue("enabled", AMDHomePage.objShowsTab);
		if (getPropertyValue.equalsIgnoreCase("true")) {
			logger.info(
					"user is able to navigate to Shows screen by tapping on Shows tab displayed in the top navigation bar");
			extent.extentLogger("Shows Tab",
					"user is able to navigate to Shows screen by tapping on Shows tab displayed in the top navigation bar");
		} else {
			logger.info(
					"user is not able to navigate to Shows screen by tapping on Shows tab displayed in the top navigation bar");
			extent.extentLoggerFail("Shows Tab",
					"user is not able to navigate to Shows screen by tapping on Shows tab displayed in the top navigation bar");
		}

		if (!(userType.equalsIgnoreCase("SubscribedUser"))) {
			if (verifyElementDisplayed(AMDHomePage.objSubscribeTeaser)) {
				logger.info("subscribe icon is dislayed");
				extent.extentLogger("Subscribe icon", "subscribe icon is dislayed");
			} else {
				logger.info("subscribe icon is not dislayed");
				extent.extentLoggerFail("Subscribe icon", "subscribe icon is not dislayed");
			}
		} else {

			verifyElementIsNotDisplayed(AMDHomePage.objSubscribeTeaser);
			logger.info("subscribe icon is not dislayed");
			extent.extentLogger("Subscribe icon", "subscribe icon is not dislayed");
//			if (verifyElementDisplayed(AMDHomePage.objSubscribeTeaser)) {
//				logger.info("subscribe icon is dislayed");
//				extent.extentLoggerFail("Subscribe icon", "subscribe icon is dislayed");
//			} else {
//				logger.info("subscribe icon is not dislayed");
//				extent.extentLogger("Subscribe icon", "subscribe icon is not dislayed");
//			}
		}
		carouselValidationforShowsAndNews(userType, "Shows");
		String CarouselTitle = ShowsScreenValidationwithApiData(userType);
		if (CarouselTitle == null) {
			logger.info("No premium content present in the carousel");
		} else {
			verifyElementPresentAndClick(AMDHomePage.objContentTitle(CarouselTitle), "Carousel content");
			if (verifyElementExist(AMDHomePage.objWatchTrailerIconOnPlayerscreen, "Watch Trailer button")) {
				if (verifyElementNotPresent(AMDHomePage.objLoginButtonOnPlayerscreen, 10)) {
					logger.info(
							"Content playback is not initiated for the guest user post tapping on premium content which is having trailer");
					extentLoggerFail("Trailer",
							"Content playback is not initiated for the guest user post tapping on premium content which is having trailer");
				} else {
					logger.info(
							"Content playback is initiated for the guest user post tapping on premium content which is having trailer");
					extentLogger("Trailer",
							"Content playback is initiated for the guest user post tapping on premium content which is having trailer");
				}
				Back(1);
			} else {
				if (verifyElementExist(AMDHomePage.objLoginButtonOnPlayerscreen, "Login button")) {
					logger.info(
							"Content playback is not initiated for the guest user post tapping on premium content which is not having trailer");
					extentLogger("Trailer",
							"Content playback is not initiated for the guest user post tapping on premium content which is not having trailer");
				} else {
					logger.info(
							"Content playback is initiated for the guest user post tapping on premium content which is not having trailer");
					extentLoggerFail("Trailer",
							"Content playback is initiated for the guest user post tapping on premium content which is not having trailer");
				}
				Back(1);
			}
		}
		findingTrayInscreen(2, AMDHomePage.objTrayTitle("Continue Watching"), AMDHomePage.objCarouselConetentCard,
				"Continue watching tray", "MastheadCarousel", userType, "Shows");
		findingTrayInscreen(4, AMDHomePage.objTrayTitle("Before"), AMDHomePage.objCarouselConetentCard,
				"Before TV tray", "MastheadCarousel", userType, "Shows");
		findingTrayInscreen(3, AMDHomePage.objTrayTitle("Trending Shows"), AMDHomePage.objCarouselConetentCard,
				"Trending shows tray", "MastheadCarousel", userType, "Shows");
	}

	public void carouselValidationforShowsAndNews(String UserType, String tabName) throws Exception {

		extent.HeaderChildNode("Carousel validation");

		waitForElementDisplayed(AMDHomePage.objCarouselDots, 10);
		waitTime(10000);

		if ((verifyElementIsNotDisplayed(AMDHomePage.objBannerAd))) {
			verifyElementPresent(AMDHomePage.objCarouselUnitwhenNomastHeadAdbanner,
					"Carousel unit as first unit on " + tabName + " screen");
		} else {
			verifyElementPresent(AMDHomePage.objCarouselUnitwithmastHeadAdbanner,
					"Carousel unit as first unit on " + tabName + " screen");
		}

		// Validating Carousel manual swipe
		String width = getAttributValue("width", AMDHomePage.objCarouselConetentCard);

		String bounds = getAttributValue("bounds", AMDHomePage.objCarouselConetentCard);
		String b = bounds.replaceAll(",", " ").replaceAll("]", " ");
		String height = b.split(" ")[1];
		// System.out.println(height);
		waitTime(4000);

		carouselSwipe("RIGHT", 1, width, height);
		String Carouseltitle1 = getText(AMDHomePage.objCarouselTitle1);
		logger.info(Carouseltitle1);
		extentLogger("Carousel Title", Carouseltitle1);
		carouselSwipe("LEFT", 1, width, height);
		String Carouseltitle2 = getText(AMDHomePage.objCarouselTitle1);
		logger.info(Carouseltitle2);
		extentLogger("Carousel Title", Carouseltitle2);
		carouselSwipe("RIGHT", 1, width, height);
		String Carouseltitle3 = getText(AMDHomePage.objCarouselTitle1);
		logger.info(Carouseltitle3);
		extentLogger("Carousel Title", Carouseltitle3);
		if (!(Carouseltitle1.equalsIgnoreCase(Carouseltitle2))) {
			if (Carouseltitle3.equalsIgnoreCase(Carouseltitle1)) {
				logger.info("user is able to manually swipe banners from right to left or vice versa.");
				extent.extentLogger("Carousel swipe",
						"user is able to manually swipe banners from right to left or vice versa.");
			} else {
				logger.info("user is not able to manually swipe banners from right to left or vice versa.");
				extent.extentLoggerFail("Carousel swipe",
						"user is not able to manually swipe banners from right to left or vice versa.");
			}
		} else {
			logger.info("user is not able to manually swipe banners from right to left or vice versa.");
			extent.extentLoggerFail("Carousel swipe",
					"user is not able to manually swipe banners from right to left or vice versa.");
		}
		// Validating Pagination dot, Play icon and GetPremium on Carousel
		int noofCarouselContents = findElements(AMDHomePage.objCarouselDots).size();
		// System.out.println(noofCarouselContents);
		for (int i = 0; i < noofCarouselContents; i++) {
			logger.info(getText(AMDHomePage.objCarouselTitle1));
			verifyElementExist(AMDHomePage.objCarouselDots, "Pagination dot");
			carouselSwipe("LEFT", 1, width, height);
		}

		for (int i = 0; i < noofCarouselContents; i++) {

			logger.info(getText(AMDHomePage.objCarouselTitle1));
			verifyElementExist(AMDHomePage.objPlayBtn, "Play icon");
			carouselSwipe("LEFT", 1, width, height);
		}
		if ((tabName.equals("Kids")) | (tabName.equals("Music"))) {
			extent.extentLogger("Verify Get Premium tag", "Get Premium tag is not configured for " + tabName + " tab");
			logger.info("Get Premium tag is not configured for " + tabName + " tab");

		}
//		else {
//			if ((UserType.equalsIgnoreCase("Guest")) | (UserType.equalsIgnoreCase("NonSubscribedUser"))) {
//				for (int i = 0; i < noofCarouselContents; i++) {
//
//					logger.info(getText(AMDHomePage.objCarouselTitle1));
//					verifyElementExist(AMDHomePage.objGetPremium, "GetPremium tag");
//					carouselSwipe("LEFT", 1, width, height);
//				}
//				click(AMDHomePage.objGetPremium, "GetPremium tag");
//				verifyElementPresent(AMDSubscibeScreen.objSubscribeHeader, "Subscription screen");
//				Back(1);
//			}
		else {
			for (int i = 0; i < noofCarouselContents; i++) {

				System.out.println(getText(AMDHomePage.objCarouselTitle1));
				if (verifyElementIsNotDisplayed(AMDHomePage.objGetPremium)) {
					logger.info("Get Premium tag is not displayed");
					extent.extentLogger("GetPremium tag", "Get Premium tag is not displayed");
				} else {
					logger.info("Get Premium tag is displayed");
					extent.extentLoggerFail("GetPremium tag", "Get Premium tag is displayed");
				}
				carouselSwipe("LEFT", 1, width, height);
			}
		}

		// navigation to consumption screen of selected content
		String CarouselTitle = getText(AMDHomePage.objCarouselPlayIconContentCard);
		click(AMDHomePage.objCarouselPlayIconContentCard, "Carousel content");

		if (!(verifyIsElementDisplayed(AMDSubscibeScreen.objSubscribeHeader))) {
			Back(1);
		}

		verifyElementPresent(AMDHomePage.objConsumptionScreenTitle, "Consumption screen");
		String consumptionScreenTitle = getText(AMDHomePage.objConsumptionScreenTitle);
		System.out.println(consumptionScreenTitle);

		if (CarouselTitle.equalsIgnoreCase(consumptionScreenTitle)) {
			logger.info("Consumption Screen is displayed for the selected content");
			extent.extentLogger("Consumption screen", "Consumption Screen is displayed for the selected content");
		} else {
			logger.info("Consumption Screen is not displayed for the selected content");
			extent.extentLoggerFail("Consumption screen",
					"Consumption Screen is not displayed for the selected content");
		}
		Back(1);

		// Validating Carousel Auto scroll
		String title1 = getText(AMDHomePage.objCarouselTitle1);
		logger.info(title1);
		extentLogger("Carousel Title", title1);
		waitTime(4000);
		String title2 = getText(AMDHomePage.objCarouselTitle2);
		logger.info(title2);
		extentLogger("Carousel Title", title2);
		waitTime(4000);
		String title3 = getText(AMDHomePage.objCarouselTitle3);
		logger.info(title3);
		extentLogger("Carousel Title", title3);

		if (!(title1.equalsIgnoreCase(title2))) {
			if (!(title2.equalsIgnoreCase(title3))) {
				logger.info(
						"Banners available in feature carousel unit rotates from right to left at a fixed time interval");
				extentLogger("Carousel unit Autorotation",
						"Banners available in feature carousel unit rotate from right to left at a fixed time interval");
			} else {
				logger.info(
						"Banners available in feature carousel unit are not rotating from right to left at a fixed time interval");
				extentLoggerFail("Carousel unit Autorotation",
						"Banners available in feature carousel unit are not rotating from right to left at a fixed time interval");
			}
		} else {
			logger.info(
					"Banners available in feature carousel unit are not rotating from right to left at a fixed time interval");
			extentLoggerFail("Carousel unit Autorotation",
					"Banners available in feature carousel unit are not rotating from right to left at a fixed time interval");
		}
	}

	public void verifyCarouselCollectionListingscreen(String userType) throws Exception {
		extent.HeaderChildNode(
				"Verify user navigated to collection Listing screen post tapping on any collection available on carousel");
		System.out.println(
				"Verify user navigated to collection Listing screen post tapping on any collection available on carousel");
		if (userType.equals("Guser")) {
			selectContentLang_MoreMenu("Hindi");
			verifyElementPresentAndClick(AMDHomePage.objShowsTab, "Shows Tab");
		}
		waitTime(1000);

		click(AMDNewsPage.objCarouselCollectionContent, "Carousel content");
		verifyElementPresent(AMDNewsPage.objListingScreen, "Screen Header");
		logger.info("Listing Collection Screen is displayed post tapping on any collection available on corousel");
		extent.extentLogger("Listing Collection screen",
				"Listing Collection Screen is displayed post tapping on any collection available on corousel");
		verifyElementPresent(AMDLoginScreen.objBackBtn, "Back Button");
		click(AMDLoginScreen.objBackBtn, "Back Button");
		if (userType.equals("Guest")) {
			selectContentLang_MoreMenu("Hindi");
			verifyElementPresentAndClick(AMDHomePage.objShowsTab, "Shows Tab");
		}
	}

	public void verifyConsumptionScreen(String userType) throws Exception {
		extent.HeaderChildNode(
				"Verify user navigated to consumption screen post tapping on any where on the banner section");
		System.out
				.println("Verify user navigated to consumption scree post tapping on any where on the banner section");
		PartialSwipe("UP", 1);
		verifyElementPresentAndClick(AMDShowsScreen.objcontentCard, "Banner card");
		waitTime(6000);

		if (verifyElementExist(AMDShowsScreen.objPlayer, "Player")) {
			logger.info("User is navigated to Consumption Screen");
			extent.extentLogger("Consumption Screen", "User is navigated to Consumption Screen");

		} else {
			logger.info("User is not navigated to Consumption Screen");
			extent.extentLoggerFail("Consumption Screen", "User is not navigated to Consumption Screen");
		}

		Back(1);
		extent.HeaderChildNode("Verify Watch Next tray is available on Shows screen");
		System.out.println("\nVerify Watch Nest Tray is available on Shows screen");
		PartialSwipe("UP", 1);

		if (verifyElementExist(AMDShowsScreen.objWatchNextTray, "Watch Next Tray")) {
			logger.info("Watch Next tray is displayed in Shows landing screen");
			extent.extentLogger("Shows Screen", "Watch Next tray is displayed in Shows landing screen");
		} else {
			logger.info("Watch Next tray is not displayed in Shows landing screen");
			extent.extentLoggerFail("Shows Screen", "Watch Next tray is not displayed in Shows landing screen");
		}
	}

	@SuppressWarnings("unused")
	public void verifyConsumptionScreenOfBeforeTVContent(String userType) throws Exception {
		extent.HeaderChildNode("Verify content Playback in Shows Before TV");
		System.out.println("\nVerify content Playback in Shows Before TV");
		findingTrayInscreen(4, AMDHomePage.objTrayTitle("Before"), AMDHomePage.objCarouselConetentCard, "Before TV",
				"MastheadCarousel", userType, "Shows");
		if (verifyElementExist(AMDHomePage.objBeforeTVTray, "BeforeTV tray")) {
			waitTime(5000);
			String beforeTVtrayName = findElement(AMDGenericObjects.objTrayTitle("Before")).getText();
//				click(AMDGenericObjects.objViewAllBtn(beforeTVtrayName), "View All_Before TV Show");
			click(AMDHomePage.objBeforeTVTray, "BeforeTV tray");
			waitTime(4000);
			click(AMDShowsScreen.objBeforeTVContent1, "BeforeTV content");
			waitTime(5000);
			if (verifyElementExist(AMDSubscibeScreen.objSubscribeHeader, "Subscribe page")) {
				Back(1);
			}

			if (userType.equals("Guest")) {

				if (verifyElementExist(AMDShowsScreen.objLoginLink, "Login link")) {
					logger.info(
							"User navigated to consumption screen with login link on the player tapping on Before TV Content");
					extent.extentLogger("Consumption Screen",
							"User navigated to consumption screen with login link on the player tapping on Before TV Content");
				} else {
					logger.info(
							"User not navigated to consumption screen with login link on the player tapping on Before TV Content");
					extent.extentLoggerFail("Consumption Screen",
							"User not navigated to consumption screen with login link on the player tapping on Before TV Content");
				}
			} else if (userType.equals("NonSubscribedUser")) {
				if (verifyElementExist(AMDShowsScreen.objSubscribeNowlink, "Subscribe Now link")) {
					logger.info(
							"User navigated to consumption screen with Subscribe Now link on the player tapping on Before TV Content");
					extent.extentLogger("Consumption Screen",
							"User navigated to consumption screen with Subscribe Now link on the player tapping on Before TV Content");
				} else {
					logger.info(
							"User not navigated to consumption screen with Subscribe Now link on the player tapping on Before TV Content");
					extent.extentLoggerFail("Consumption Screen",
							"User not navigated to consumption screen with Subscribe Now link on the player tapping on Before TV Content");
				}
			} else {
				logger.info("Content playback is initiated for the subscribed user on tapping any Before Tv Content");
				extent.extentLogger("Consumption Screen",
						"Content playback is initiated for the subscribed user on tapping any Before Tv Content");
			}
		} else {
			logger.info("Shows Before TV Tray is not  displayed");
			extent.extentLogger("Shows screen", "Shows Before TV Tray is not displayed");
			PartialSwipe("UP", 1);
		}
		Back(2);
	}

	@SuppressWarnings("unused")
	public String ShowsScreenValidationwithApiData(String userType) throws Exception {
		extent.HeaderChildNode("Shows Premium Content validation with API Data");
		// verifyElementPresentAndClick(AMDHomePage.objShowsTab, "Shows Tab");
		Response resp = ResponseInstance.getResponseForApplicasterPages(userType, "tvshows");
		List<String> apitotaltrays = resp.jsonPath().getList("buckets");
		System.out.println(apitotaltrays.size());
		String CarouselTitle = null;
		boolean Carousel = false;
		for (int i = 0; i < 7; i++) {

			String businessType = resp.jsonPath().getString("buckets[" + i + "].items");
			if (businessType.equalsIgnoreCase("premium_downloadable")) {
				Carousel = true;
				CarouselTitle = resp.jsonPath().getString("buckets[" + i + "].items[" + i + "].title");
				System.out.println(CarouselTitle);
				break;
			}
		}
		return CarouselTitle;
	}

	/**
	 * Author : Manasa
	 */
	public void upcomingSectionValidation() throws Exception {
		extent.HeaderChildNode("Upcoming Screen Validation");
		// waitTime(5000);
		waitForElementDisplayed(AMDHomePage.objHomeTab, 10);
		verifyElementPresentAndClick(AMDHomePage.objUpcoming, "Upcoming tab");

		WebElement element = findElement(AMDHomePage.objUpcoming);
		int leftX = element.getLocation().getX();
		int rightX = leftX + element.getSize().getWidth();
		int middleX = (rightX + leftX) / 2;
		Dimension size = getDriver().manage().window().getSize();
		if (middleX == Integer.valueOf((size.width) / 2)) {
			logger.info("Upcoming text is displayed at the center of the screen");
			extent.extentLogger("Title", "Upcoming text is displayed at center of the screen");
		} else {
			logger.error("Upcoming text is not displayed at center of the screen");
			extent.extentLoggerFail("Title", "Upcoming text is not displayed at center of the screen");
		}

		WebElement searchIcon = findElement(AMDHomePage.objSearchBtn);
		int searchIconRightX = searchIcon.getLocation().getX();
		System.out.println(searchIconRightX);
		Dimension sizee = getDriver().manage().window().getSize();
		System.out.println(sizee.getWidth());
		int sizeee = sizee.getWidth() - 300;
		System.out.println(sizeee);

		if (searchIconRightX >= sizeee) {
			logger.info("Search icon is displayed at top right of the screen");
			extent.extentLogger("Search icon", "Search icon is displayed at top right of the screen");
		} else {
			logger.error("Search icon is not displayed at top right of the screen");
			extent.extentLoggerFail("Search icon", "Search icon is not displayed at top right of the screen");
		}
		Response resp = ResponseInstance.getResponseForUpcomingPage();

		String titleWithTrailer = resp.jsonPath().getString("buckets[0].items[0].original_title");
		System.out.println("API Title " + titleWithTrailer);

		verifyElementPresentAndClick(AMDUpcomingPage.objContentCard1, "Content Card");

		String titleConsumptionScreen = getText(AMDUpcomingPage.objContentCardTitle);
		System.out.println(titleConsumptionScreen);

		if (titleConsumptionScreen.contains(titleWithTrailer)) {
			logger.info("Navigated to appropriate consumption screen on tapping anywhere on any content card");
			extent.extentLogger("Title",
					"Navigated to appropriate consumption screen on tapping anywhere on any content card");
			logger.info("Trailer/Teaser playback is played");
			extent.extentLogger("Trailer/Teaser", "Trailer/Teaser playback is played");

		} else {
			logger.info("Not navigated to appropriate consumption screen on tapping anywhere on any content card");
			extent.extentLoggerFail("Title",
					"Not navigated to appropriate consumption screen on tapping anywhere on any content card");
			logger.info("Trailer/Teaser playback is not played");
			extent.extentLoggerFail("Trailer/Teaser", "Trailer/Teaser playback is not played");
		}

		verifyElementExist(AMDMoreMenu.objDownloadIcon, "Download icon");

		Back(1);

		verifyElementPresentAndClick(AMDUpcomingPage.objContentCardTitle, "Metadata");

		if (titleConsumptionScreen.contains(titleWithTrailer)) {
			logger.info("Navigated to appropriate consumption screen on tapping anywhere on the metadata");
			extent.extentLogger("Title",
					"Navigated to appropriate consumption screen on tapping anywhere on the metadata");
		} else {
			logger.info("Not navigated to appropriate consumption screen on tapping anywhere on the metadata");
			extent.extentLoggerFail("Title",
					"Not navigated to appropriate consumption screen on tapping anywhere on the metadata");
		}

		Back(1);

		verifyElementPresentAndClick(AMDHomePage.objSearchBtn, "Search icon");

		if (verifyElementExist(AMDSearchScreen.objMicrophoneIcon, "Microphone Icon")) {
			logger.info("Search landing screen is displayed after denying audio permission");
			extent.extentLogger("Search landing screen",
					"Search landing screen is displayed after denying audio permission");
		} else {
			logger.info("Search landing screen is not displayed after denying audio permission");
			extent.extentLogger("Search landing screen",
					"Search landing screen is not displayed after denying audio permission");
		}
		Back(1);
	}

	public void moreSectionValidation() throws Exception {
		extent.HeaderChildNode("More Screen Validation");
		System.out.println("\nMore Section Validation");

		Runtime.getRuntime().exec("adb shell svc wifi disable");
		if (getOEMName.equalsIgnoreCase("Sony")) {
			Wifi_TurnOFFnON();
		}

		waitTime(5000);
		verifyElementPresentAndClick(AMDHomePage.MoreMenuIcon, "More Menu tab");

		verifyElementExist(AMDOfflineScreen.objYouAreOffline, "You are Offline");
		verifyElementExist(AMDOfflineScreen.objDescription, "Please connect to the internet and try again");
		verifyElementExist(AMDOfflineScreen.objTryAgain, "Try Again");
		verifyElementExist(AMDOfflineScreen.objGoToDownloads, "Go to Downloads");

		Runtime.getRuntime().exec("adb shell svc wifi enable");
		if (getOEMName.equalsIgnoreCase("Sony")) {
			Wifi_TurnOFFnON();
		}
		waitTime(5000);
		verifyElementPresentAndClick(AMDOfflineScreen.objTryAgain, "Try Again");
		waitTime(2000);
		Swipe("DOWN", 1);
		verifyElementExist(AMDMoreMenu.objProfile, "Profile icon");
		verifyElementExist(AMDMoreMenu.objBuySubscription, "Buy Subscription option");
		verifyElementExist(AMDMoreMenu.objMySubscription, "My Subscription option");
		verifyElementExist(AMDMoreMenu.objMyTransactions, "My Transactions option");
		verifyElementExist(AMDMoreMenu.objWatchlist, "Watchlist option");
		verifyElementExist(AMDMoreMenu.objMyRemainders, "My Reminders option");
		verifyElementExist(AMDMoreMenu.objHaveaPrepaidCode, "Have a prepaid code option");
		Swipe("UP", 1);
		verifyElementExist(AMDMoreMenu.objSettings, "Settings option");
		verifyElementExist(AMDMoreMenu.objInviteAFriend, "Invite a Friend option");
		verifyElementExist(AMDMoreMenu.objAboutUs, "About Us option");
		verifyElementExist(AMDMoreMenu.objHelpCentre, "Help Centre option");
		Swipe("UP", 1);
		verifyElementExist(AMDMoreMenu.objTermsOfUse, "Terms of Use");
		verifyElementExist(AMDMoreMenu.objPrivacyPolicy, "Privacy policy");
		verifyElementExist(AMDMoreMenu.objBuildVersion, "Build Version");
	}

	@SuppressWarnings("deprecation")
	public void parentalPinValidation(String userType, String searchKeyword) throws Exception {
		extent.HeaderChildNode("Parental Pin Validation");

		if ((userType.equalsIgnoreCase("NonSubscribedUser") || (userType.equalsIgnoreCase("SubscribedUser")))) {
			verifyElementPresentAndClick(AMDSearchScreen.objSearchIcon, "Search icon");
			verifyElementPresentAndClick(AMDSearchScreen.objSearchEditBox, "Search Box");
			type(AMDSearchScreen.objSearchBoxBar, searchKeyword + "\n", "Search bar");
			waitTime(2000);
			hideKeyboard();
			waitForElementDisplayed(AMDSearchScreen.objAllTab, 10);

			verifyElementPresentAndClick(AMDMoreMenu.objRelatedSearchResult, "Search result");

			verifyElementPresentAndClick(AMDMoreMenu.objDownloadIcon, "Download icon");
			verifyElementPresentAndClick(AMDMoreMenu.objDataSaver, "Data Saver option");
			verifyElementPresentAndClick(AMDMoreMenu.objStartDownload, "Start Download");

			Back(1);
			verifyElementPresentAndClick(AMDHomePage.MoreMenuIcon, "More Menu tab");
			verifyElementPresentAndClick(AMDMoreMenu.objSettings, "Settings option");
			waitTime(5000);
			Swipe("UP", 1);
			verifyElementPresentAndClick(AMDMoreMenu.objParentalControl, "Parental Control");
			verifyElementExist(AMDMoreMenu.objPasswordField, "Password field");
			String password = "";
			if (userType.equals("NonSubscribedUser")) {
				password = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
						.getParameter("NonsubscribedPassword");
			} else if (userType.equals("SubscribedUser")) {
				password = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
						.getParameter("SubscribedPassword");
			}
			click(AMDMoreMenu.objPasswordField, "Password field");
			getDriver().getKeyboard().sendKeys(password);

			hideKeyboard();
			if (getOEMName.contains("vivo")) {
				hidePwdKeyboard();
			}
			click(AMDMoreMenu.objPasswordContinueBtn, "Continue button");
			waitTime(2000);

			verifyElementPresentAndClick(AMDMoreMenu.objRestrictAllContent, "Restrict All Content option");
			verifyElementPresentAndClick(AMDMoreMenu.objContinueBtn, "Continue Button");
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
			verifyElementPresentAndClick(AMDMoreMenu.objSetPinContinueBtn, "Continue Button");
			waitTime(2000);

			verifyElementPresentAndClick(AMDMoreMenu.objParentalLockDone, "Done Button");
			Back(2);

			verifyElementPresentAndClick(AMDHomePage.objDownload, "Downloads tab");
			verifyElementPresentAndClick(AMDDownloadPage.objvideostab, "Videos tab");
			waitForElementDisplayed(AMDMoreMenu.objDownloadDoneIcon, 20);
			verifyElementPresentAndClick(AMDDownloadPage.objDownloadedContent, "Downloaded Content");
			verifyElementPresentAndClick(AMDDownloadPage.objPlayDownloadedContent, "Play Downloaded Content");

			waitTime(2000);
			Back(1);
			verifyElementPresentAndClick(AMDDownloadPage.objEnterPinCTA, "Play Downloaded Content");

			type(AMDMoreMenu.objParentalLockPin1, "1", "ParentalLockPin");
			hideKeyboard();
			type(AMDMoreMenu.objParentalLockPin2, "2", "ParentalLockPin");
			hideKeyboard();
			type(AMDMoreMenu.objParentalLockPin3, "3", "ParentalLockPin");
			hideKeyboard();
			type(AMDMoreMenu.objParentalLockPin4, "4", "ParentalLockPin");
			hideKeyboard();
			click(AMDMoreMenu.objSetPinContinueBtn, "Continue button");
			waitTime(5000);
			Back(1);
			verifyElementPresentAndClick(AMDHomePage.MoreMenuIcon, "More Menu tab");
			verifyElementPresentAndClick(AMDMoreMenu.objSettings, "Settings option");
			waitTime(5000);
			Swipe("UP", 1);
			verifyElementPresentAndClick(AMDMoreMenu.objParentalControl, "Parental Control");
			verifyElementExist(AMDMoreMenu.objPasswordField, "Password field");

			if (userType.equals("NonSubscribedUser")) {
				password = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
						.getParameter("NonsubscribedPassword");
			} else if (userType.equals("SubscribedUser")) {
				password = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
						.getParameter("SubscribedPassword");
			}
			click(AMDMoreMenu.objPasswordField, "Password field");
			getDriver().getKeyboard().sendKeys(password);

			hideKeyboard();
			if (getOEMName.contains("vivo")) {
				hidePwdKeyboard();
			}
			click(AMDMoreMenu.objPasswordContinueBtn, "Continue button");
			waitTime(2000);

			verifyElementPresentAndClick(AMDMoreMenu.objNoRestriction, "No Restriction");
			verifyElementPresentAndClick(AMDMoreMenu.objContinueBtn, "Continue Button");
			waitTime(2000);
			verifyElementPresentAndClick(AMDMoreMenu.objParentalLockDone, "Done Button");

			Back(2);
		}
	}

	/**
	 * Author : Vinay Module : Premium tab screen validations
	 * 
	 * @param UserType
	 */

	/* ===========Premium tab screen validations=========== */

	public void PremiumTabScreen(String UserType) throws Exception {

		extent.HeaderChildNode("Verifying Premium tab screen");
		System.out.println("Navigated to Premium page");
		// Verify user is navigated to Premium tab
		click(AMDHomePage.objPremiumTab, "Premium tab");
		// closeInterstitialAd(AMDGenericObjects.objCloseInterstitialAd, 2000);
		String activeTab = getText(AMDHomePage.objSelectedTab);
		if (activeTab.equalsIgnoreCase("Premium")) {
			extent.extentLogger("Verify user is navigated to Premium tab",
					"User is navigated to Premium tab on clicking premium tab");
			logger.info("User is navigated to Premium tab on clicking premium tab");
		} else {
			extent.extentLoggerFail("Verify user is navigated to Premium tab",
					"Failed to navigate to Premium tab on clicking premium tab");
			logger.info("Failed to navigate to Premium tab on clicking premium tab");
		}

		// Verify Subscribe icon is displayed
		// verifyElementPresent(AMDHomePage.objSubscribeIcon, "Subscribe icon in premium
		// tab");
		if (!(UserType.equalsIgnoreCase("SubscribedUser"))) {
			if (verifyElementDisplayed(AMDHomePage.objSubscribeTeaser)) {
				logger.info("subscribe icon is dislayed");
				extent.extentLogger("Subscribe icon", "subscribe icon is dislayed");
			} else {
				logger.info("subscribe icon is not dislayed");
				extent.extentLoggerFail("Subscribe icon", "subscribe icon is not dislayed");
			}
		}
//		else {
//			if (verifyElementDisplayed(AMDHomePage.objSubscribeTeaser)) {
//				logger.info("subscribe icon is dislayed");
//				extent.extentLoggerFail("Subscribe icon", "subscribe icon is dislayed");
//			} else {
//				logger.info("subscribe icon is not dislayed");
//				extent.extentLogger("Subscribe icon", "subscribe icon is not dislayed");
//			}
//		}

		// Verify continue watching tray is not displayed for guest user
		/*
		 * if(UserType.equals("Guest")) {
		 * if(verifyElementExist(AMDHomePage.objContinueWatchingTray,
		 * "Continue Watching") == false) {
		 * extent.extentLogger("Verify continue watching tray ",
		 * "Continue Watching tray is not displayed for guest user");
		 * logger.info("Continue Watching tray is not displayed for guest user");
		 * 
		 * }else { extent.extentLoggerFail("Verify continue watching tray ",
		 * "Continue Watching tray is displayed for guest user");
		 * logger.info("Continue Watching tray is displayed for guest user"); } }
		 */
		// Verify Trending now tray is displayed
		// verifyElementPresent(AMDHomePage.objTrendingNowTray, "Trending Now tray");
		carouselValidation(UserType, "Premium");
	}

	/* ========Kids tab validations======== */
	public void KidsTabScreen(String UserType) throws Exception {

		extent.HeaderChildNode("Verifying Kids tab screen");
		click(AMDHomePage.objPremiumTab, "Premium tab");
		waitTime(3000);
		click(AMDHomePage.objNewsTab, "News Tab");
		waitTime(3000);
		// Verify user is navigated to Premium tab
		click(AMDHomePage.objKidsTab, "Kids tab");
		// closeInterstitialAd(AMDGenericObjects.objCloseInterstitialAd, 2000);
		String activeTab = getText(AMDHomePage.objSelectedTab);
		if (activeTab.equalsIgnoreCase("Kids")) {
			extent.extentLogger("Verify user is navigated to Kids tab",
					"User is navigated to Kids tab on clicking Kids tab");
			logger.info("User is navigated to Kids tab on clicking Kids tab");
		} else {
			extent.extentLoggerFail("Verify user is navigated to Kids tab",
					"Failed to navigate to Kids tab on clicking Kids tab");
			logger.info("Failed to navigate to Kids tab on clicking Kids tab");
		}

		// Verify Subscribe icon is displayed
		// verifyElementPresent(AMDHomePage.objSubscribeIcon, "Subscribe icon in premium
		// tab");
		if (!(UserType.equalsIgnoreCase("SubscribedUser"))) {
			if (verifyElementDisplayed(AMDHomePage.objSubscribeTeaser)) {
				logger.info("subscribe icon is dislayed");
				extent.extentLogger("Subscribe icon", "subscribe icon is dislayed");
			} else {
				logger.info("subscribe icon is not dislayed");
				extent.extentLoggerFail("Subscribe icon", "subscribe icon is not dislayed");
			}
		}
//		else {
//			if (verifyElementDisplayed(AMDHomePage.objSubscribeTeaser)) {
//				logger.info("subscribe icon is dislayed");
//				extent.extentLoggerFail("Subscribe icon", "subscribe icon is dislayed");
//			} else {
//				logger.info("subscribe icon is not dislayed");
//				extent.extentLogger("Subscribe icon", "subscribe icon is not dislayed");
//			}
//		}
		// Verify Trending on ZEE5 tray is displayed
		// verifyElementPresent(AMDHomePage.objTrendingOnZee5Tray, "Trending on Zee5");
		// Verify Play icon is displayed
//		String width = getAttributValue("width", AMDHomePage.objCarouselConetentCard);
//		String height = getAttributValue("height", AMDHomePage.objCarouselConetentCard);
//
//		int noofCarouselContents = findElements(AMDHomePage.objCarouselDots).size();
//		for (int i = 0; i < noofCarouselContents; i++) {
//			System.out.println(getText(AMDHomePage.objCarouselTitle));
//			verifyElementExist(AMDHomePage.objPlayBtn, "Play icon");
//			carouselSwipe("LEFT", 1, width, height);
//		}
		carouselValidation(UserType, "Kids");
	}

	/**
	 * Author : Bindu Module : News Landing Page
	 */
	public void verifyNewsLandingScreen(String userType) throws Exception {
		extent.HeaderChildNode("Verify user navigates to News screen");
		System.out.println("\nVerify User navigated to News Screen");
		click(AMDHomePage.objPremiumTab, "Premium tab");
		verifyElementPresentAndClick(AMDHomePage.objNewsTab, "News Tab");
		getText(AMDHomePage.objSelectedTab);
		String getPropertyValue = getAttributValue("enabled", AMDHomePage.objNewsTab);
		if (getPropertyValue.equalsIgnoreCase("true")) {
			logger.info(
					"user is able to navigate to News screen by tapping on News tab displayed in the top navigation bar");
			extent.extentLogger("Shows Tab",
					"user is able to navigate to News screen by tapping on News tab displayed in the top navigation bar");
		} else {
			logger.info(
					"user is not able to navigate to News screen by tapping on News tab displayed in the top navigation bar");
			extent.extentLoggerFail("News Tab",
					"user is not able to navigate to News screen by tapping on News tab displayed in the top navigation bar");
		}

		if (!(userType.equalsIgnoreCase("SubscribedUser"))) {
			if (verifyElementDisplayed(AMDHomePage.objSubscribeTeaser)) {
				logger.info("subscribe icon is dislayed");
				extent.extentLogger("Subscribe icon", "subscribe icon is dislayed");
			} else {
				logger.info("subscribe icon is not dislayed");
				extent.extentLoggerFail("Subscribe icon", "subscribe icon is not dislayed");
			}
		} else {
			verifyElementIsNotDisplayed(AMDHomePage.objSubscribeTeaser);
			logger.info("subscribe icon is not dislayed");
			extent.extentLogger("Subscribe icon", "subscribe icon is not dislayed");
//			if (verifyElementDisplayed(AMDHomePage.objSubscribeTeaser)) {
//				logger.info("subscribe icon is dislayed");
//				extent.extentLoggerFail("Subscribe icon", "subscribe icon is dislayed");
//			} else {
//				logger.info("subscribe icon is not dislayed");
//				extent.extentLogger("Subscribe icon", "subscribe icon is not dislayed");
//			}
		}
		carouselValidationforShowsAndNews(userType, "News");
	}

	public void verifyTraysInNewsScreen(String userType) throws Exception {
		extent.HeaderChildNode("Verify Trays Present in News Landing Screen");
		System.out.println("Verify Trays Present in News Landing Screen");
		waitTime(6000);
		if (userType.equals("Guest")) {
			selectContentLang_MoreMenu("Hindi");
		}
		verifyElementPresentAndClick(AMDHomePage.objNewsTab, "News Tab");

		findingTrayInscreen(2, AMDHomePage.objTrayTitle("Continue Watching"), AMDHomePage.objCarouselConetentCard,
				"Continue watching tray", "MastheadCarousel", userType, "News");
		findingTrayInscreen(10, AMDHomePage.objTrayTitle("Today's Headlines"), AMDHomePage.objCarouselConetentCard,
				"Today's Headlines tray", "MastheadCarousel", userType, "News");
		findingTrayInscreen(10, AMDHomePage.objTrayTitle("Entertainment News"), AMDHomePage.objCarouselConetentCard,
				"Entertainment News tray", "MastheadCarousel", userType, "News");
		findingTrayInscreen(4, AMDHomePage.objTrayTitle("Live News"), AMDHomePage.objCarouselConetentCard,
				"Live News tray", "MastheadCarousel", userType, "News");
		findingTrayInscreen(7, AMDHomePage.objTrayTitle("Top Stories"), AMDHomePage.objCarouselConetentCard,
				"Top Stories tray", "MastheadCarousel", userType, "News");

		if (userType.equals("Guest")) {
			deselectContentLang_MoreMenuAndSelectDefaultLanguage("Hindi");
		}
	}

	public void verifyListingCollectionScreen(String userType) throws Exception {
		extent.HeaderChildNode("Verify user navigated to Listing collection Screen");
		System.out.println("Verify user navigated to Listing collection Screen");
		verifyElementPresentAndClick(AMDHomePage.objNewsTab, "News Tab");
		waitTime(2000);
		PartialSwipe("UP", 1);
		verifyElementPresent(AMDNewsPage.objRightArrowBtn, "Right arrow");
		click(AMDNewsPage.objRightArrowBtn, "Right arrow");
		waitTime(4000);
		verifyElementPresent(AMDNewsPage.objListingScreen, "Screen Header");
		logger.info("Listing Collection Screen is displayed by clicking on right arrow for the trays");
		extent.extentLogger("Listing Collection screen",
				"Listing Collection Screen is displayed by clicking on right arrow for the trays");

		Swipe("UP", 1);
		verifyElementExist(AMDNewsPage.objNextContentImg, "Next Content");
		logger.info("User can able to swipe the screen to view the next content");
		extent.extentLogger("Listing Collection screen", "User can able to swipe the screen to view the next content");

		Swipe("DOWN", 1);
		verifyElementPresent(AMDNewsPage.objThumbnailImg1, "Thumbnail Image");
		click(AMDNewsPage.objThumbnailImg1, "Thumbnail Image");
		verifyElementExist(AMDHomePage.objConsumptionScreenTitle, "Consumption screen");
		logger.info("user can able to tap on Thumb Nail Image");
		extent.extentLogger("Listing Collection screen", "user can able to tap on Thumb Nail Image");
		Back(1);

		if (verifyElementIsNotDisplayed(AMDNewsPage.objMetaData)) {
			logger.info("MetaData like Title,Year,Duration is not displayed in listing collection screen");
			extent.extentLogger("Listing Collection screen",
					"MetaData like Title,Year,Duration is not displayed in listing collection screen");
		}

		verifyElementPresent(AMDNewsPage.objThumbnailImg1, "Thumbnail Image");
		// waitTime(6000);
		click(AMDNewsPage.objThumbnailImg1, "Thumbnail Image");
		waitTime(2000);
		if (verifyElementPresent(AMDNewsPage.objConsumptionScreenTitle, "Consumption Screen Title")) {
			logger.info("User navigated to consumption screen tapping on thumbnail image in listing screen");
			extent.extentLogger("Consumption Screen",
					"User navigated to consumption screen tapping on thumbnail image in listing screen");

		} else {
			logger.info("User not navigated to consumption screen tapping on thumbnail image in listing screen");
			extent.extentLogger("Consumption Screen",
					"User not navigated to consumption screen tapping on thumbnail image in listing screen");
		}
		Back(1);
		verifyElementPresent(AMDLoginScreen.objBackBtn, "Back Button");
		click(AMDLoginScreen.objBackBtn, "Back Button");
		waitTime(2000);
		verifyElementPresent(AMDHomePage.objNewsTab, "News Tab");
		logger.info("User navigated to News Landing screen tapping on back icon available on listing screen");
		extent.extentLogger("Listing Screen",
				"User navigated to News Landing screen tapping on back icon available on listing screen");
	}

	/**
	 * Author : Sushma Module : Movies
	 */
	public void moviesLandingScreen(String userType, String tabName) throws Exception {
		extent.HeaderChildNode("Navigating to Home screen and verifing the Subscribe icon");
		System.out.println("Movies Landing screen and checking the Subscribe icon");

		// closeInterstitialAd(AMDGenericObjects.objCloseInterstitialAd, 2000);

		verifyElementPresentAndClick(AMDHomePage.objMoviesTab, tabName + " Tab");
		String activeTab = getText(AMDHomePage.objSelectedTab);
		if (activeTab.equalsIgnoreCase(tabName)) {
			logger.info("user is able to navigate to " + tabName + " screen by tapping on " + tabName
					+ " tab displayed in the top navigation bar");
			extent.extentLogger(tabName + " Tab", "user is able to navigate to " + tabName + " screen by tapping on "
					+ tabName + " tab displayed in the top navigation bar");
		} else {
			logger.info("user is not able to navigate to " + tabName + " screen by tapping on " + tabName
					+ " tab displayed in the top navigation bar");
			extent.extentLoggerFail(tabName + " Tab", "user is not able to navigate to " + tabName
					+ " screen by tapping on " + tabName + " tab displayed in the top navigation bar");
		}
		waitTime(10000);
		// closeInterstitialAd(AMDGenericObjects.objCloseInterstitialAd, 2000);

		if (!(userType.equalsIgnoreCase("SubscribedUser"))) {
			if (verifyElementDisplayed(AMDHomePage.objSubscribeTeaser)) {
				logger.info("subscribe icon is dislayed");
				extent.extentLogger("Subscribe icon", "subscribe icon is dislayed");
			} else {
				logger.info("subscribe icon is not dislayed");
				extent.extentLoggerFail("Subscribe icon", "subscribe icon is not dislayed");
			}
		} else {
			if (verifyElementIsNotDisplayed(AMDHomePage.objSubscribeTeaser)) {
				logger.info("subscribe icon is not dislayed");
				extent.extentLogger("Subscribe icon", "subscribe icon is not dislayed");

			} else {
				logger.info("subscribe icon is dislayed");
				extent.extentLoggerFail("Subscribe icon", "subscribe icon is dislayed");
			}
		}

		waitTime(3000);
		carouselValidation(userType, tabName);

		String courselContentTitle = carouselValidationWithApi(userType, "movies");
		verifyElementPresentAndClick(AMDHomePage.objContentTitle(courselContentTitle), "Carousel content");

		if (!(verifyElementIsNotDisplayed(AMDHomePage.objWatchTrailerIconOnPlayerscreen))) {
			if (verifyElementIsNotDisplayed(AMDHomePage.objLoginButtonOnPlayerscreen)) {
				logger.info(
						"Content playback is initiated for the guest user post tapping on premium content which is having trailer");
				extentLogger("Trailer",
						"Content playback is initiated for the guest user post tapping on premium content which is having trailer");

			} else {
				logger.info(
						"Content playback is not initiated for the guest user post tapping on premium content which is having trailer");
				extentLoggerFail("Trailer",
						"Content playback is not initiated for the guest user post tapping on premium content which is having trailer");
			}
			Back(1);
		} else {
			if (!(verifyElementIsNotDisplayed(AMDHomePage.objLoginButtonOnPlayerscreen))) {
				logger.info(
						"Content playback is not initiated for the guest user post tapping on premium content which is not having trailer");
				extentLogger("Trailer",
						"Content playback is not initiated for the guest user post tapping on premium content which is not having trailer");
			} else {
				logger.info(
						"Content playback is initiated for the guest user post tapping on premium content which is not having trailer");
				extentLoggerFail("Trailer",
						"Content playback is initiated for the guest user post tapping on premium content which is not having trailer");
			}
			Back(1);
		}
		extent.HeaderChildNode("Verifing the availability of tray in the screen");
		findingTrayInscreen(2, AMDHomePage.objTrayTitle("Continue Watching"), AMDHomePage.objCarouselConetentCard,
				"Continue watching tray", "MastheadCarousel", userType, tabName);
		findingTrayInscreen(2, AMDHomePage.objTrayTitle("Trending Movies"), AMDHomePage.objCarouselConetentCard,
				"Trending Movies tray", "MastheadCarousel", userType, tabName);
	}

	/**
	 * Author : Kushal
	 */
	public void selectContentLang_MoreMenu(String planguage) throws Exception {

		click(AMDHomePage.HomeIcon, "Home button");
		click(AMDHomePage.MoreMenuIcon, "More Menu");
		Swipe("UP", 1);
		verifyElementPresentAndClick(AMDMoreMenu.objSettings, "Settings CTA");
		verifyElementPresent(AMDGenericObjects.objScreenTitleName("Settings"), "Settings Screen");
		Swipe("UP", 1);
		verifyElementPresentAndClick(AMDMoreMenu.objContentLang, "Content language");
		verifyElementPresent(AMDGenericObjects.objScreenTitleName("Content Language"), "Content language screen");

		// ****** UnSelecting default content languages ******
		if (pUserType.contains("Guest")) {
			click(AMDOnboardingScreen.objSelectContentLang("English"), "English");
			PartialSwipe("UP", 2);
			waitTime(1000);
			click(AMDOnboardingScreen.objSelectContentLang("Kannada"), "Kannada");
			Swipe("DOWN", 1);
		}

		// ****** Selecting required language ******
		if (planguage.contains(",")) {
			Swipe("DOWN", 1);
			String[] pLanguages = planguage.split(",");
			int n = pLanguages.length;
			for (int i = 0; i < n; i++) {
				int totalLanguages = getCount(AMDOnboardingScreen.objContentLangBtns);
				for (int j = 1; j <= totalLanguages; j++) {
					String visibleLang = getText(AMDOnboardingScreen.objgetContentLangName(j));
					if (pLanguages[i].equalsIgnoreCase(visibleLang)) {
						verifyElementPresentAndClick(AMDOnboardingScreen.objSelectContentLang(pLanguages[i]),
								pLanguages[i]);
					}
				}
				PartialSwipe("UP", 1);
			}
		} else {
			outerLoop: for (int i = 1; i <= 4; i++) {
				int totalLanguages = getCount(AMDOnboardingScreen.objContentLangBtns);
				for (int j = 1; j <= totalLanguages; j++) {
					String visibleLang = getText(AMDOnboardingScreen.objgetContentLangName(j));
					if (planguage.equalsIgnoreCase(visibleLang)) {
						verifyElementPresentAndClick(AMDOnboardingScreen.objSelectContentLang(planguage), planguage);
						break outerLoop;
					}
				}
				PartialSwipe("UP", 1);
			}
		}

		waitTime(1000);
		verifyElementPresentAndClick(AMDOnboardingScreen.objContent_ContinueBtn, "Continue button");
		waitTime(1000);
//	click(AMDGenericObjects.objBackBtn, "Back button");
		Back(1);
		click(AMDHomePage.HomeIcon, "Home button");
	}

	/**
	 * Author :Manasa Module : UpComing Screen
	 */

	public void upcomingContentValidationWithAPIData() throws Exception {

		extent.HeaderChildNode("Upcoming Content Validation With API Data");
		waitForElementDisplayed(AMDHomePage.objHomeTab, 10);
		verifyElementPresentAndClick(AMDHomePage.objUpcoming, "Upcoming tab");
		Response resp = ResponseInstance.getResponseForUpcomingPage();
		List<String> apiTitle = new LinkedList<String>();
		List<String> apiMetadata = new LinkedList<String>();
		List<String> contentList = resp.jsonPath().getList("buckets[0].items");
		System.out.println(contentList.size());

		for (int i = 0; i < contentList.size(); i++) {
			String title = resp.jsonPath().getString("buckets[0].items[" + i + "].title");
			System.out.println("Show Title " + title);

			apiTitle.add(title);

			String metadata = resp.jsonPath().getString("buckets[0].items[" + i + "].description");
			System.out.println("API Metadata " + metadata);
			apiMetadata.add(metadata);

			String releaseDate = resp.jsonPath().getString("buckets[0].items[" + i + "].release_date");
			String[] releaseDateSplit = releaseDate.split("T");

			String contentName = apiTitle.get(i);
			System.out.println(contentName);

			String convertedXpath = titleToXpath(contentName);
			System.out.println(convertedXpath);

			String contentDescription = apiMetadata.get(i);

			String UIMetadata = getDriver().findElementByXPath(AMDUpcomingPage.objContentCardTitle(convertedXpath))
					.getText();

			System.out.println(UIMetadata);

			if (verifyElementExist(AMDUpcomingPage.objTitle(convertedXpath), "Show Title : " + title)) {
				logger.info("Title on the content card matches with Api data");
				extent.extentLogger("Title", "Title on the content card matches with Api data");
			} else {
				logger.info("Title on the content card does not match with Api data");
				extent.extentLoggerFail("Title", "Title on the content card does not match with Api data");
			}

			if (UIMetadata.contains(contentDescription)) {
				logger.info("Metadata on the content card matches with Api data");
				extent.extentLogger("Metadata", "Metadata on the content card matches with Api data");
			} else {
				logger.info("Metadata on the content card does not match with Api data");
				extent.extentLoggerFail("Metadata", "Metadata on the content card does not match with Api data");
			}

			String genre = getDriver().findElementByXPath(AMDUpcomingPage.objContentGenre(convertedXpath)).getText();
			logger.info("Content Genre : " + genre);
			extent.extentLogger("Genre", "Content Genre : " + genre);

			String certificate = getDriver().findElementByXPath(AMDUpcomingPage.objContentCertificate(convertedXpath))
					.getText();
			logger.info("Content Certificate : " + certificate);
			extent.extentLogger("Certificate", "Content Certificate : " + certificate);

			System.out.println("Release Date " + releaseDateSplit[0]);
			logger.info("Release Date " + releaseDateSplit[0]);
			extent.extentLogger("Release Date", "Release Date " + releaseDateSplit[0]);

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date upcomingReleaseDate = sdf.parse(releaseDateSplit[0]);
			Date dateToday = sdf.parse(date());

			if (upcomingReleaseDate.compareTo(dateToday) <= 0) {
				logger.info("Previously released content is listed in the upcoming section");
				extent.extentLoggerFail("Release Date",
						"Previously released content is listed in the upcoming section");

			} else {
				logger.info("Previously released content is not listed in the upcoming section");
				extent.extentLogger("Release Date",
						"Previously released content is not listed in the upcoming section");
			}
			swipeByElements(findElement(AMDUpcomingPage.objGenre), findElement(AMDHomePage.objSearchBtn));
			waitTime(3000);
		}
	}

	public String titleToXpath(String trayTitle) throws Exception {
		String xPath = null;
		StringBuffer Sbuffer1 = new StringBuffer();
		// System.out.println(trayTitle);
		if (trayTitle.contains("'")) {
			// System.out.println("Length of the title is: "+trayTitle.length());
			String[] S = trayTitle.split("'");
			// System.out.println("The size of the array is: "+S.length);
			// for(String x : S)
			// System.out.println(x);
			//
			Sbuffer1.append("//*[@text=concat(\"");
			Sbuffer1.append(S[0]);
			// System.out.println(Sbuffer1);
			for (int i = 1; i < S.length; i++) {
				Sbuffer1.append("\",\"'\",\"" + S[i]);
			}
			Sbuffer1.append("\")]");
			// System.out.println("The Xpath is:"+Sbuffer1.toString());
			xPath = Sbuffer1.toString();

		} else {
			Sbuffer1.append("//*[@text=\"" + trayTitle + "\"]");
			// System.out.println("The Xpath is:"+Sbuffer1.toString());
			xPath = Sbuffer1.toString();
		}
		return xPath;
	}

	public static String date() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		String strDate = formatter.format(date);
		formatter = new SimpleDateFormat("yyyy-MM-dd");
		strDate = formatter.format(date);
		System.out.println(strDate);

		return strDate;
	}

	/**
	 * Author : Hitesh Module : Live TV
	 * 
	 * @throws Exception
	 */
	public void LiveTV(String UserType) throws Exception {
		extent.HeaderChildNode("Verifying Live TV Landing screen");
		System.out.println("\nVerifying Live TV Landing screen");
		// swipeByElements(findElement(AMDHomePage.objNewsTab),
		// findElement(AMDHomePage.objHomeTab));
		verifyElementPresentAndClick(AMDHomePage.objLiveTvTab, "Live Tv");
		waitTime(2000);
		if (verifyElementDisplayed(AMDLiveTVScreen.objChannelGuide)) {
			logger.info("Navigated to Live TV Screen");
			extentLogger("Navigation to Live TV", "Navigated to Live TV Screen");
		} else {
			logger.info("Unable to navigated to Live TV Screen");
			extentLoggerFail("Navigation to Live TV", "Unable to navigated to Live TV Screen");
		}

		if (UserType.equals("Guest")) {
			verifyElementExist(AMDLiveTVScreen.objSubscribeIcon, "Subscribe Icon for " + UserType + " User");
		} else if (UserType.equals("NonSubscribedUser")) {
			verifyElementExist(AMDLiveTVScreen.objSubscribeIcon, "Subscribe Icon for " + UserType + " User");
		}
//		else if (UserType.equals("SubscribedUser")) {
//			verifyElementExist(AMDLiveTVScreen.objSubscribeIcon, "Subscribe Icon for " + UserType + " User");
//		}
		verifyElementExist(AMDLiveTVScreen.objChannelGuide, "Channel Guide toggle option");
		click(AMDLiveTVScreen.objChannelGuide, "Channel Guide");
		if (findElement(AMDLiveTVScreen.objChannelGuide).isSelected()) {
			logger.info("Channel Guide is Selected");
			extentLogger("Verify Toogle options", "Channel Guide is Selected");
		} else {
			logger.info("Channel Guide is not Selected");
			extentLoggerFail("Verify Toogle options", "Channel Guide is not Selected");
		}
		click(AMDLiveTVScreen.onjLiveTvToggle, "Channel Guide");

		for (int i = 0; i < findElements(AMDLiveTVScreen.objContentInLiveTV).size(); i++) {
			if (verifyElementDisplayed(AMDLiveTVScreen.objImageIcon)) {
				logger.info("Image Icon is Displayed");
			} else {
				logger.info("Image Icon is Not Displayed");
			}
		}

		verifyElementPresentAndClick(AMDLiveTVScreen.objFirstContent, "Clicked on Live Tv content");
		verifyElementExist(AMDLiveTVScreen.objLiveTV, "Live Icon on Player");
		Back(1);
		verifyElementExist(AMDLiveTVScreen.objTray("FREE Channels"), "FREE Channels tray");
		verifyElementExist(AMDLiveTVScreen.objTray("Music"), "Music tray");
		PartialSwipe("UP", 1);
		verifyElementExist(AMDLiveTVScreen.objTray("News"), "News tray");

//		VerifyDuplicateTrays(AMDLiveTVScreen.objTray("FREE Channels"), "FREE Channels tray");
//		VerifyDuplicateTrays(AMDLiveTVScreen.objTray("Music"), "Music tray");
//		VerifyDuplicateTrays(AMDLiveTVScreen.objTray("News"), "News tray");
	}

	public void channelGuideScreenValidation(String UserType) throws Exception {
		extent.HeaderChildNode("Verifying Channel Guide screen in Live TV Landing screen");
		System.out.println("\nVerifying Channel Guide screen in Live TV Landing screen");
		// swipeByElements(findElement(AMDHomePage.objNewsTab),
		// findElement(AMDHomePage.objHomeTab));
		verifyElementPresentAndClick(AMDHomePage.objLiveTvTab, "Live Tv");
		verifyElementExist(AMDLiveTVScreen.objChannelGuide, "Channel Guide toggle option");
		click(AMDLiveTVScreen.objChannelGuide, "Channel Guide");
		if (findElement(AMDLiveTVScreen.objChannelGuide).isSelected()) {
			logger.info("Channel Guide is Selected");
			extentLogger("Verify Toogle options", "Channel Guide is Selected");
		} else {
			logger.info("Channel Guide is not Selected");
			extentLoggerFail("Verify Toogle options", "Channel Guide is not Selected");
		}
		if (UserType.equals("Guest")) {
			verifyElementExist(AMDLiveTVScreen.objSubscribeIcon, "Subscribe Icon for " + UserType + " User");
		} else if (UserType.equals("NonSubscribedUser")) {
			verifyElementExist(AMDLiveTVScreen.objSubscribeIcon, "Subscribe Icon for " + UserType + " User");
		}
//		else if (UserType.equals("SubscribedUser")) {
//			verifyElementExist(AMDLiveTVScreen.objSubscribeIcon, "Subscribe Icon for " + UserType + " User");
//		}
		if (findElements(AMDLiveTVScreen.objChannelLogo).size() > 0) {
			logger.info("list of channels are displayed in Channel Guide screen");
			extentLogger("Channel Guide Screen", "list of channels are displayed in Channel Guide screen");
		} else {
			logger.error("list of channels are not displayed in Channel Guide screen");
			extentLoggerFail("Channel Guide Screen", "list of channels are not displayed in Channel Guide screen");
		}
		verifyElementPresentAndClick(AMDHomePage.objMusicTab, "Music Tab");
		if (findElement(AMDHomePage.objMusicTab).isSelected()) {
			logger.info("User is able to navigate to any screen from channel guide screen");
			extentLogger("Screen", "User is able to navigate to any screen from channel guide screen");
		} else {
			logger.info("User is not able to navigate to any screen from channel guide screen");
			extentLoggerFail("Screen", "User is not able to navigate to any screen from channel guide screen");
		}
	}

	public void VerifyDuplicateTrays(By tray, String trayName) {
		for (int i = 0; i < 4; i++) {
			if ((findElements(tray).size()) > 1) {
				logger.error("Duplicate tray :" + trayName);
			} else {
				logger.info("No Duplicate tray :" + trayName);
			}
			Swipe("UP", 1);
		}
		for (int i = 0; i < 4; i++) {
			Swipe("Down", 1);
		}
	}

	/**
	 * Author : Manasa Module :
	 */
	public void verifySubscriptionReminderInDownloads() throws Exception {
		extent.HeaderChildNode("Verify Subscription Reminder In Downloads");
		System.out.println("\nVerify Subscription Reminder In Downloads");
		waitTime(5000);
		verifyElementPresentAndClick(AMDHomePage.objDownload, "Downloads tab");
		String subscriptionExpiry = getText(AMDDownloadPage.objSubscriptionExpiry);
		logger.info("Subscription Expiry Message : " + subscriptionExpiry + " is displayed");
		extent.extentLogger("Subscription Expiry Message",
				"Subscription Expiry Message : " + subscriptionExpiry + " is displayed");
		verifyElementExist(AMDDownloadPage.objSubscriptionExpiryMessage, "Subscription Renewal Message");
		verifyElementPresentAndClick(AMDDownloadPage.objRemindMeLaterCTA, "Remind Me Later CTA");
//		if(verifyElementExist(AMDDownloadPage.objSubscriptionExpiryMessage, "Subscription Reminder Message")) {
//			logger.info("Subscription Reminder Message is hidden");
//			extent.extentLogger("Subscription Reminder Message","Subscription Reminder Message is hidden");
//		}else {
//			logger.info("Subscription Reminder Message is not hidden");
//			extent.extentLogger("Subscription Reminder Message","Subscription Reminder Message is not hidden");	
//		}
	}

	/**
	 * Author : Vinay Module : Music Landing screen
	 * 
	 */
	public void MusicLandingScreen(String userType) throws Exception {
		// Verify user is navigated to Music landing screen
		click(AMDHomePage.objMusicTab, "Music tab");
		// closeInterstitialAd(AMDGenericObjects.objCloseInterstitialAd, 2000);
		// Verify user is navigated to Premium tab
		String activeTab = getText(AMDHomePage.objSelectedTab);
		if (activeTab.equalsIgnoreCase("Music")) {
			extent.extentLogger("Verify user is navigated to Music tab",
					"User is navigated to Music tab on clicking Music tab");
			logger.info("User is navigated to Music tab on clicking Music tab");
		} else {
			extent.extentLoggerFail("Verify user is navigated to Music tab",
					"Failed to navigate to Music tab on clicking Music tab");
			logger.info("Failed to navigate to Music tab on clicking Music tab");
		}
		// Verify Subscribe icon is displayed on Music landing screen
		// verifyElementPresent(AMDHomePage.objSubscribeIcon, "Subscribe icon in premium
		// tab");

		if (!(userType.equalsIgnoreCase("SubscribedUser"))) {
			if (verifyElementDisplayed(AMDHomePage.objSubscribeTeaser)) {
				logger.info("Subscribe icon is dislayed");
				extent.extentLogger("Subscribe icon", "Subscribe icon is dislayed");
			} else {
				logger.info("Subscribe icon is not dislayed");
				extent.extentLoggerFail("Subscribe icon", "Subscribe icon is not dislayed");
			}
		}
//		else {
//			if (verifyElementDisplayed(AMDHomePage.objSubscribeTeaser)) {
//				logger.info("Subscribe icon is dislayed");
//				extent.extentLogger("Subscribe icon", "Subscribe icon is dislayed");
//			} else {
//				logger.info("Subscribe icon is not dislayed");
//				extent.extentLoggerFail("Subscribe icon", "Subscribe icon is not dislayed");
//			}
//		}
		// Verify ZEE5 Original Music tray is displayed
		// verifyElementPresent(AMDHomePage.objZEEOriginalMusicTray, "ZEE5 Original
		// Music tray");
		carouselValidation(userType, "Music");
	}

	/**
	 * Author : Manasa Module : ZeeOriginals
	 */
	public void zee5OriginalsLandingScreen(String userType, String tabName) throws Exception {
		extent.HeaderChildNode("Navigating to Zee5 Originals screen and verifing the Subscribe icon");
		System.out.println("Zee5 Originals Landing screen and verifing the subscribe icon");
//		 swipeByElements(findElement(AMDHomePage.objNewsTab),
//		 findElement(AMDHomePage.objHomeTab));
		waitTime(2000);
		verifyElementPresentAndClick(AMDHomePage.objZee5OriginalsTab, tabName + " Tab");
		String activeTab = getText(AMDHomePage.objSelectedTab);
		if (activeTab.equalsIgnoreCase(tabName)) {
			logger.info("User is able to navigate to " + tabName + " screen by tapping on " + tabName
					+ " tab displayed in the top navigation bar");
			extent.extentLogger(tabName + " Tab", "User is able to navigate to " + tabName + " screen by tapping on "
					+ tabName + " tab displayed in the top navigation bar");
		} else {
			logger.info("User is not able to navigate to " + tabName + " screen by tapping on " + tabName
					+ " tab displayed in the top navigation bar");
			extent.extentLoggerFail(tabName + " Tab", "User is not able to navigate to " + tabName
					+ " screen by tapping on " + tabName + " tab displayed in the top navigation bar");
		}
		waitTime(10000);
		// closeInterstitialAd(AMDGenericObjects.objCloseInterstitialAd, 2000);
		if (!(userType.equalsIgnoreCase("SubscribedUser"))) {
			if (verifyElementDisplayed(AMDHomePage.objSubscribeTeaser)) {
				logger.info("Subscribe icon is displayed");
				extent.extentLogger("Subscribe icon", "Subscribe icon is displayed");
			} else {
				logger.info("Subscribe icon is not displayed");
				extent.extentLoggerFail("Subscribe icon", "Subscribe icon is not displayed");
			}
		} else {
			if (verifyElementIsNotDisplayed(AMDHomePage.objSubscribeTeaser)) {
				logger.info("Subscribe icon is not displayed");
				extent.extentLogger("Subscribe icon", "Subscribe icon is not displayed");

			} else {
				logger.info("Subscribe icon is displayed");
				extent.extentLoggerFail("Subscribe icon", "Subscribe icon is displayed");
			}
		}

		carouselValidation(userType, tabName);
		String courselContentTitle = zeeOriginalsCarouselValidationWithApi(userType, "zeeoriginals");
		verifyElementPresentAndClick(AMDHomePage.objContentTitle(courselContentTitle), "Carousel content");

		if (!(verifyElementIsNotDisplayed(AMDHomePage.objWatchTrailerIconOnPlayerscreen))) {
			if (verifyElementIsNotDisplayed(AMDHomePage.objLoginButtonOnPlayerscreen)) {
				logger.info(
						"Content playback is initiated for the guest user post tapping on premium content which is having trailer");
				extentLogger("Trailer",
						"Content playback is initiated for the guest user post tapping on premium content which is having trailer");

			} else {
				logger.info(
						"Content playback is not initiated for the guest user post tapping on premium content which is having trailer");
				extentLoggerFail("Trailer",
						"Content playback is not initiated for the guest user post tapping on premium content which is having trailer");
			}
			Back(1);
		} else {
			if (!(verifyElementIsNotDisplayed(AMDHomePage.objLoginButtonOnPlayerscreen))) {
				logger.info(
						"Content playback is not initiated for the guest user post tapping on premium content which is not having trailer");
				extentLogger("Trailer",
						"Content playback is not initiated for the guest user post tapping on premium content which is not having trailer");
			} else {
				logger.info(
						"Content playback is initiated for the guest user post tapping on premium content which is not having trailer");
				extentLoggerFail("Trailer",
						"Content playback is initiated for the guest user post tapping on premium content which is not having trailer");
			}
			Back(1);
		}
		extent.HeaderChildNode("Verifying the availability of trays in the screen");
		findingTrayInscreen(2, AMDHomePage.objTrayTitle("Best of ZEE5 Originals"), AMDHomePage.objCarouselConetentCard,
				"Best of ZEE5 Originals", "MastheadCarousel", userType, tabName);
		// PartialSwipe("UP", 1);
		findingTrayInscreen(25, AMDHomePage.objTrayTitle("ZEE5 Original Music"), AMDHomePage.objCarouselConetentCard,
				"ZEE5 Original Music tray", "Mastheadcarousel", userType, tabName);
	}

	public static String zeeOriginalsCarouselValidationWithApi(String userType, String pagenameforApi) {
		Response respPage = ResponseInstance.getResponseForApplicasterPages(userType, pagenameforApi);
		List<String> items = respPage.jsonPath().getList("buckets[0].items");
		logger.info("bucketsSize: " + items.size());
		String carouselContentTitle = null;
		main: for (int i = 0; i < items.size(); i++) {
			carouselContentTitle = respPage.jsonPath().getString("buckets[0].items[" + i + "].title");
			logger.info(carouselContentTitle);

			String CarouselContentBusinessType = respPage.jsonPath()
					.getString("buckets[0].items[" + i + "].business_type");
			logger.info(CarouselContentBusinessType);
			if (CarouselContentBusinessType.equalsIgnoreCase("premium_downloadable")) {
				break main;
			}
		}
		return carouselContentTitle;
	}

	/**
	 * Author : Sushma Module : Settings
	 */
	public void settings() throws Exception {
		verifyElementPresentAndClick(AMDHomePage.MoreMenuIcon, "More menu icon");
		verifyElementPresentAndClick(AMDMoreMenu.objSettings, "Settings option");
		verifyElementPresent(AMDMoreMenu.objVideoStreamingMenuTitle, "Video streaming menu");
		verifyElementPresent(AMDMoreMenu.objDownloadsMenuTitle, "Downloads menu");
		Swipe("UP", 1);
		verifyElementPresent(AMDMoreMenu.objLanguageMenuTitle, "Languages menu");
		verifyElementPresent(AMDMoreMenu.objSearchHistroyLabel, "Search histroy Label");
		verifyElementPresent(AMDMoreMenu.objResetSettingsToDefault, "Reset Settings to default Label");
	}

	/**
	 * Author : Bhavana
	 */

	public void AboutUsScreenValidation(String userType) throws Exception {
		extent.HeaderChildNode("Verifying About Us screen as \" + userType");
		System.out.println("Verifying About Us screen as " + userType);
		verifyElementPresentAndClick(AMDHomePage.objMoreMenu, "More menu");
		verifyElementPresentAndClick(AMDMoreMenu.objAboutUs, "About Us");
		verifyElementExist(AMDMoreMenu.objAboutUsHeader, "About Us Header");
		if (checkElementExist(AMDMoreMenu.objAboutUsHeader, "About Us Header")) {
			logger.info("User is navigated to About Us screen");
			extent.extentLogger("About Us", "User is navigated to About Us screen");
		} else {
			logger.error("User is unable to navigate to About Us screen");
			extent.extentLoggerFail("About Us", "User is unable to navigate to About Us screen");
		}
		verifyElementExist(AMDMoreMenu.objcloseButton, "Close button in About Us Screen");
		verifyElementExist(AMDMoreMenu.objAboutUsDescription, "Breif' Description about Application");
		// verifyElementExist(AMDMoreMenu.objHyperLinkInAboutUsScreen,"Hyper link in
		// About Us screen");
		String str = getText(AMDMoreMenu.objHyperLinkInAboutUsScreen);
		System.out.println("Hyper link in About us Sceen is " + str);
		verifyElementPresentAndClick(AMDMoreMenu.objHyperLinkInAboutUsScreen, "Hyper link in About Us screen");
		if (verifyElementExist(AMDMoreMenu.objPageNotFoundMsg, "ERROR,Page not found")) {
			logger.error("On clicking the Hyper link,user is unable to navigate to the respective page of Hyper link");
			extent.extentLoggerFail("Hyper Link",
					"On clicking the Hyper link,user is unable to navigate to the respective page of Hyper link");
		} else {
			logger.info("User is navigated to the respective page of the Hyper link");
			extent.extentLogger("Hyper link", "User is navigated to the respective page of the Hyper link");
		}
		Back(1);
	}

	@SuppressWarnings("unused")
	public void LogoutValidation(String userType) throws Exception {
		extent.HeaderChildNode("Validation of Logout option as " + userType);
		System.out.println("Validation of Logout option as " + userType);
		click(AMDHomePage.objMoreMenu, "More menu");
		Swipe("UP", 1);
		if (userType.contentEquals("Guest")) {
			if (verifyElementIsNotDisplayed(AMDMoreMenu.objLogout)) {
				logger.info("Logout option is NOT displayed for " + userType + "user");
				extent.extentLogger("Log out", "Logout option is NOT displayed for " + userType + "user");
			} else {
				logger.error("Logout option is displayed for " + userType + "user");
				extent.extentLoggerFail("Log out", "Logout option is displayed for " + userType + "user");
			}
		}
		if (userType.contentEquals("NonSubscribedUser") || userType.contentEquals("SubscribedUser")) {
			verifyElementPresentAndClick(AMDMoreMenu.objLogout, "Logout option in More menu");
			verifyElementExist(AMDMoreMenu.objLogoutPopup, "Logout Confirmation Popup");
			verifyElementExist(AMDMoreMenu.objCancelButton, "Cancel button");
			verifyElementExist(AMDMoreMenu.objLogoutButton, "Logout button");
			String getPropertyValue = getAttributValue("enabled", AMDMoreMenu.objCancelButton);
			if (getPropertyValue.equalsIgnoreCase("true")) {
				logger.info("Cancel button is by default highlighted");
				extent.extentLogger("Cancel button", "Cancel button is by default highlighted");
			} else {
				logger.error("Cancel button is by default highlighted");
				extent.extentLoggerFail("Cancel button", "Cancel button is by default highlighted");
			}
			click(AMDMoreMenu.objCancelButton, "Cancel button");
			String getPropertyValue2 = getAttributValue("enabled", AMDHomePage.objMoreMenu);
			if (getPropertyValue.equalsIgnoreCase("true")) {
				logger.info("Cancel button is tappable and functional");
				extent.extentLogger("Cancel button", "Cancel button is tappable and functional");
			} else {
				logger.error("Cancel button is NOT tappable and NOT functional");
				extent.extentLogger("Cancel button", "Cancel button is NOT tappable and NOT functional");
			}
			click(AMDMoreMenu.objLogout, "Logout option in More menu");
			click(AMDMoreMenu.objLogoutButton, "Logout button");
			Swipe("DOWN", 1);
			String value = getText(AMDMoreMenu.objProfileHeader);
			System.out.println(value);
			if (value.equalsIgnoreCase("Guest")) {
				logger.info("Logout button is tappable and user is logged out successfully");
				extent.extentLogger(" Logout button", "Logout button is tappable and user is logged out successfully");
			} else {
				logger.error("Logout button is NOT tappable and user is unable to logout");
				extent.extentLoggerFail(" Logout button", "Logout button is NOT tappable and user is unable to logout");
			}
		}
	}

	/**
	 * Author : MANASA Module : Download
	 */
	public void downloadSettingsValidation() throws Exception {
		extent.HeaderChildNode("To verify if Quality in Downloads is set to Ask Everytime by default");

		String quality = getText(AMDMoreMenu.objDownloads_Quality);
		logger.info("Download Quality is set to " + quality + " by default");
		extent.extentLogger("Download Quality", "Download Quality is set to " + quality + " by default");
		verifyElementPresentAndClick(AMDMoreMenu.objDownloads_Quality, "Download Quality Settings option");

		extent.HeaderChildNode("To verify if Select Download Video Quality screen is displayed");
		if (verifyElementExist(AMDSettingsScreen.objSelectVideoQualityLabel, "Select Video Download Quality")) {
			logger.info("Navigated to Select Download Video Quality screen");
			extent.extentLogger("Quality", "Navigated to Select Download Video Quality screen");
		} else {
			logger.error("Not navigated to Select Download Video Quality screen");
			extent.extentLoggerFail("Quality", "Not navigated to Select Download Video Quality screen");
		}
		verifyElementExist(AMDSettingsScreen.objVideoQualityBest, "Best Quality Option");
		verifyElementExist(AMDSettingsScreen.objVideoQualityBetter, "Better Quality Option");
		verifyElementExist(AMDSettingsScreen.objVideoQualityGood, "Good Quality Option");
		verifyElementExist(AMDSettingsScreen.objVideoQualityDatasaver, "Data Saver Quality Option");
		verifyElementExist(AMDSettingsScreen.objVideoQualityAskEachTime, "Ask Each Time Option");
		verifyElementPresentAndClick(AMDSettingsScreen.objXButton, "X Button");
	}

	/**
	 * Author : Bindu Module : Exit
	 */
	public void verifyDisplayLanguageScreen(String userType) throws Exception {
		extent.HeaderChildNode("Verify Display Language Screen");
		System.out.println("\nVerify Display Language Screen");
		accessDeviceLocationPopUp("Allow", userType);
		verifyElementExist(AMDOnboardingScreen.objDiplay_ContinueBtn, "Continue button (Display-LanguageScreen)");
		Back(1);
		waitTime(2000);
		verifyElementExist(AMDOnboardingScreen.objExitPopup, "Exit Popup is displayed");
		String Exitpopup = getDriver().findElement(AMDOnboardingScreen.objExitPopup).getText();
		System.out.println(Exitpopup);
		if (Exitpopup.equalsIgnoreCase("Are you sure you want to exit ZEE5?")) {
			logger.info("Exit popup is displayed with message");
			extent.extentLogger("Exit Popup", "Exit popup is displayed with message");
		} else {
			logger.info("Exit popup is not displayed with message");
			extent.extentLoggerFail("Exit Popup", "Exit popup is not displayed with message");
		}
		verifyElementExist(AMDOnboardingScreen.objExitYes, "Exit Popup with Yes CTA");
		verifyElementExist(AMDOnboardingScreen.objExitNo, "Exit Popup with No CTA");

		extent.HeaderChildNode("Verify Exip popup closes on tapping on NO CTA");
		click(AMDOnboardingScreen.objExitNo, "Exit Popup with No CTA");
		waitTime(2000);
		verifyElementNotPresent(AMDOnboardingScreen.objExitPopup, 2);
		logger.info("Exit Popup closes when user taps on No CTA");
		Back(1);
		verifyElementExist(AMDOnboardingScreen.objExitPopup, "Exit Popup is displayed");

		extent.HeaderChildNode(" Verify Exit Popuop closes on tapping device back button");
		Back(1);
		verifyElementNotPresent(AMDOnboardingScreen.objExitPopup, 2);
		logger.info("Exit Popup closes when user taps on device back button");
	}

	public void LoginAfterLogout(String userType) throws Exception {

		if (userType.contentEquals("NonSubscribedUser")) {
			click(AMDMoreMenu.objProfile, "Profile");

			String Username = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("NonsubscribedUserName");
			String Password = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("NonsubscribedPassword");

			verifyElementPresentAndClick(AMDLoginScreen.objEmailIdField, "Email field");
			type(AMDLoginScreen.objEmailIdField, Username, "Email Field");
			verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed Button");
			verifyElementPresentAndClick(AMDLoginScreen.objPasswordField, "Password Field");
			type(AMDLoginScreen.objPasswordField, Password, "Password field");
			hideKeyboard();
			verifyElementPresentAndClick(AMDLoginScreen.objLoginBtn, "Login Button");
			waitTime(3000);
		}

		if (userType.contentEquals("SubscribedUser")) {
			click(AMDMoreMenu.objProfile, "Profile");

			String SubscribedUsername = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("SubscribedUserName");
			String SubscribedPassword = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("SubscribedPassword");

			verifyElementPresentAndClick(AMDLoginScreen.objEmailIdField, "Email field");
			type(AMDLoginScreen.objEmailIdField, SubscribedUsername, "Email Field");
			verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed Button");
			verifyElementPresentAndClick(AMDLoginScreen.objPasswordField, "Password Field");
			type(AMDLoginScreen.objPasswordField, SubscribedPassword, "Password field");
			hideKeyboard();
			verifyElementPresentAndClick(AMDLoginScreen.objLoginBtn, "Login Button");
			waitTime(3000);
		}
	}

	public void logoutOfflineValidation(String userType) throws Exception {

		if (userType.contentEquals("NonSubscribedUser") || userType.contentEquals("SubscribedUser")) {
			extent.HeaderChildNode("Offline Validation of Logout option as " + userType);
			System.out.println("Offline Validation of Logout option as " + userType);
			click(AMDHomePage.objMoreMenu, "More menu");
			Swipe("UP", 1);
			click(AMDMoreMenu.objLogout, "Logout option in More menu");
			setWifiConnectionToONOFF("Off");
			verifyElementExist(AMDMoreMenu.objNetworkerrormsg, "Internet connectivity error message");
			if (checkElementExist(AMDMoreMenu.objNetworkerrormsg, "Internet connectivity error message")) {
				logger.info(
						"Internet connectivity ERROR message is displayed on clicking Logout button without Internet");
				extent.extentLogger(" Logout button",
						"Internet connectivity ERROR message is displayed on clicking Logout button without Internet");
			} else {
				logger.error(
						"Internet connectivity ERROR message is NOT displayed on clicking Logout button without Internet");
				extent.extentLoggerFail(" Logout button",
						"Internet connectivity ERROR message is NOT displayed on clicking Logout button without Internet");
			}
			setWifiConnectionToONOFF("On");
			Back(1);
			click(AMDHomePage.HomeIcon, "Home Icon");
		}
	}
}
