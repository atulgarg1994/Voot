package com.business.zee;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
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

	public Zee5ApplicasterBusinessLogic(String Application) throws InterruptedException {
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

	String pUserType = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
			.getParameter("userType");
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
	String RSVODPassword = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("RSVODPassword");
	
	//Retrieve the Mobile Device Name
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

	
/* ==================================================================================
------------------------------  Script Author: SHREE NIDHI -------------------------------

List of Functions Created
- contentLanguage(String userType)
- mobileRegistration(String loginThrough)
- subscribeNowSceanrios()
- unRegisteredEmailSubscribe()
- subscribeFLowMobileNumber()
- passwordScenario(String UserType)
- otpScenarios()
- checkScreenAfterRelaunch(String userType, String ScreenName)
===================================================================================== */
	
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
		Swipe("UP", 2);
		click(AMDSubscibeScreen.objContinueBtn, "Continue button");
		verifyElementExist(AMDSubscibeScreen.objAccountInfoHeader, "Account info screen");
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
		verifyElementExist(AMDSubscibeScreen.objAdbanner, "Carosual in subscription page");
		verifyElementExist(AMDSubscibeScreen.objApplyPromoCodeTextbox, "Promo code in subscribe page");
		verifyElementPresent(AMDSubscibeScreen.objApply, "Apply button is subscribe page");
		PartialSwipe("UP", 2);
		click(AMDSubscibeScreen.objContinueBtn, "Continue button");
		verifyElementExist(AMDSubscibeScreen.objAccountInfoHeader, "Account info screen");
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
		if (verifyElementExist(AMDRegistrationScreen.objNumericKeys, "Numeric Keypad")) {
			logger.info("Numeric keyboard is displayed in OTP screen");
			extent.extentLogger("Numeric", "Numeric keyboard is displayed in OTP screen");
		}
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
		if (verifyElementExist(AMDRegistrationScreen.objNumericKeys, "Numeric Keypad")) {
			logger.info("Numeric keyboard is displayed in OTP screen");
			extent.extentLogger("Numeric", "Numeric keyboard is displayed in OTP screen");
		}
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
		Back(1);

	}

	public void passwordScenario(String UserType) throws Exception {

		System.out.println("\nPassword Scenario");
		verifyElementExist(AMDSubscibeScreen.objPasswordTextField, "Password field");
		click(AMDSubscibeScreen.objPasswordTextField, "Password");
		type(AMDSubscibeScreen.objPasswordTextField, "User", "Password field");
		hideKeyboard();
		System.out.println("DEVICE NAME : "+getOEMName);
		if(getOEMName.contains("vivo")) {
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
		System.out.println("DEVICE NAME : "+getOEMName);
		if(getOEMName.contains("vivo")) {
			hidePwdKeyboard();
		}
		verifyElementPresentAndClick(AMDSubscibeScreen.objProceedPWDScreen, "Proceed button in password popup");
		verifyElementExist(AMDSubscibeScreen.objPaymentText, "Payment page");
		verifyElementExist(AMDSubscibeScreen.objSubscribeHeader, "Subscribe header in Payment page");
		verifyElementExist(AMDSubscibeScreen.objSubscribePageBackButton, "Back button in Payment page");
		Back(2);
		verifyElementPresentAndClick(AMDHomePage.objMoreMenu, "More Menu");
		Swipe("UP", 1);
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
		}
		else if (userType.equals("SubscribedUser")) {
			type(AMDLoginScreen.objEmailIdField, SubscribedUserName, "Email field");
			hideKeyboard();
			verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed button");
			waitTime(2000);
			type(AMDLoginScreen.objPasswordField, SubscribedPassword, "Password field");
		}
		
		
		if(userType.equalsIgnoreCase("Guest")) {
			verifyElementPresentAndClick(AMDLoginScreen.objSkipBtn, "Skip button");	
		}else {
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
		}
		else if(user.equals("Mobile")) {
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
		click(AMDRegistrationScreen.objFirstNameTxtField, "First name"); //Clicking on First Name field to get device keyboard
		hideKeyboard();
		verifyElementPresentAndClick(AMDRegistrationScreen.objRegisterBtn, "Register button");
		if (user.equals("Email")) {
			verifyElementExist(AMDHomePage.objHomeTab, "Home Screen");
		}
		else if(user.equals("Mobile"))  {
			logger.info("Mobile registration");
		}else {
			logger.info("Prepaid PopUp after registration");
		}
	}
	
	
	public void subscribeEntryPointsValidations(String userType) throws Exception {
		HeaderChildNode("Entry points");
		click(AMDOnboardingScreen.objDiplay_ContinueBtn, "Display continue");
		click(AMDOnboardingScreen.objContent_ContinueBtn, " Content Continue");
		click(AMDOnboardingScreen.objBrowseForFreeBtn, "Browse for free");
		if (userType.equals("Guest")) {
			click(AMDLoginScreen.objSkipButton, "Skip button");
			waitTime(10000);
			verifyElementExist(AMDHomePage.objGetPremiumCTAOnCarosel, "Get Premium CTA on carosel");
			click(AMDHomePage.objGetPremiumCTAOnCarosel, "Get Premium CTA on carosel");
			verifyElementExist(AMDSubscibeScreen.objSubscribeHeader, "Subscribe page");
			Back(1);
			waitTime(5000);
			verifyElementPresentAndClick(AMDHomePage.objShowsTab, "Shows Tab");
			waitTime(5000);
			PartialSwipe("UP", 1);
			waitTime(5000);
			if (verifyElementExist(AMDHomePage.objBeforeTVTray, "BeforeTV tray")) {
				waitTime(5000);
//				click(AMDHomePage.objBeforeTVTray, "BeforeTV tray");
				String beforeTVtrayName = findElement(AMDGenericObjects.objTrayTitle("Before TV")).getText();
				click(AMDGenericObjects.objViewAllBtn(beforeTVtrayName), "View All_Before TV Show");
				waitTime(4000);
				click(AMDHomePage.objBeforeTVContent, "BeforeTV content");
				waitTime(5000);
				verifyElementExist(AMDHomePage.objGetPremiumPopUP, "PremiumPopUp");
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
			verifyElementExist(AMDSubscibeScreen.objDescriptionText, "Premium Description in subscribe page");
			verifyElementExist(AMDSubscibeScreen.objAllAccessTab, "All access pack tab");
			verifyElementExist(AMDSubscibeScreen.objRSVODPremiumPack, "RSVOD pack tab");
			Swipe("UP", 1);
			verifyElementExist(AMDSubscibeScreen.obj30daysPack, "30 days premium plan tab");
			verifyElementExist(AMDSubscibeScreen.obj180daysPack, "180 days premium plan tab");
			verifyElementExist(AMDSubscibeScreen.obj365daysPack, "365 days premium plan tab");
			verifyElementExist(AMDSubscibeScreen.objContinueBtn, "Continue button in subscribe page");
			if (getDriver().findElement(AMDSubscibeScreen.objContinueBtn).isEnabled()) {
				logger.info("Continue button is highlighted");
				extent.extentLogger("Highlighted", "Continue button is highlighted");
			}
			click(AMDSubscibeScreen.objRSVODPremiumPack, "RSVOD Pack tab");
			verifyElementPresentAndClick(AMDSubscibeScreen.objRSVODPack1, "RSVOD Plan for 30 days");
			PartialSwipe("UP", 1);
			verifyElementExist(AMDSubscibeScreen.objRSVODPack2, "RSVOD Plan for 365 days");
			verifyElementExist(AMDSubscibeScreen.objDescriptionText, "Premium Description in subscribe page");
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
			verifyElementExist(AMDSubscibeScreen.objDescriptionText, "Premium Description in subscribe page");
			verifyElementExist(AMDSubscibeScreen.objAllAccessTab, "All access pack tab");
			verifyElementExist(AMDSubscibeScreen.objRSVODPremiumPack, "RSVOD pack tab");
			Swipe("UP", 1);
			verifyElementExist(AMDSubscibeScreen.obj30daysPack, "30 days premium plan tab");
			verifyElementExist(AMDSubscibeScreen.obj180daysPack, "180 days premium plan tab");
			verifyElementExist(AMDSubscibeScreen.obj365daysPack, "365 days premium plan tab");
			verifyElementExist(AMDSubscibeScreen.objContinueBtn, "Continue button in subscribe page");
			if (getDriver().findElement(AMDSubscibeScreen.objContinueBtn).isEnabled()) {
				logger.info("Continue button is highlighted");
				extent.extentLogger("Highlighted", "Continue button is highlighted");
			}
			click(AMDSubscibeScreen.objRSVODPremiumPack, "RSVOD Pack tab");
			verifyElementPresentAndClick(AMDSubscibeScreen.objRSVODPack1, "RSVOD Plan for 30 days");
			PartialSwipe("UP", 1);
			verifyElementExist(AMDSubscibeScreen.objRSVODPack2, "RSVOD Plan for 365 days");
			verifyElementExist(AMDSubscibeScreen.objDescriptionText, "Premium Description in subscribe page");
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
			verifyElementExist(AMDSearchScreen.objTermsOfUse, "Terms of use link");
			verifyElementExist(AMDSearchScreen.objPrivacyPolicy, "Privacy policy");
			if (findElement(AMDSearchScreen.objUpgradePopupProceedButton).isEnabled()) {
				logger.info("Proceed button is enebled when user select any pack in upgrade popup");
				extent.extentLogger("Proceed", "Proceed button is enebled when user select any pack in upgrade popup");
			}
			click(AMDSearchScreen.objUpgradePopupProceedButton, "Proceed");
			verifyElementExist(AMDSubscibeScreen.objSubscribeHeader, "Subscribe page");
			verifyElementExist(AMDSearchScreen.objPlanPrice, "Plan price detials in Subscribe page");
			verifyElementExist(AMDSearchScreen.objDiscount, "Discount price detials in Subscribe page");
			verifyElementExist(AMDSearchScreen.objRoundoff, "Round off price detials in Subscribe page");
			verifyElementExist(AMDSearchScreen.objTotalPayableAmount, "Total payable price detials in Subscribe page");
			verifyElementExist(AMDSearchScreen.objAccountInfo, "Account info detials in Subscribe page");
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
		verifyElementExist(AMDSubscibeScreen.objDescriptionText, "Premium Description in subscribe page");
		verifyElementExist(AMDSubscibeScreen.objAllAccessTab, "All access pack tab");
		verifyElementExist(AMDSubscibeScreen.objRSVODPremiumPack, "RSVOD pack tab");
		Swipe("UP", 1);
		verifyElementExist(AMDSubscibeScreen.obj30daysPack, "30 days premium plan tab");
		verifyElementExist(AMDSubscibeScreen.obj180daysPack, "180 days premium plan tab");
		verifyElementExist(AMDSubscibeScreen.obj365daysPack, "365 days premium plan tab");
		PartialSwipe("UP", 1);
		verifyElementExist(AMDSubscibeScreen.objContinueBtn, "Continue button in subscribe page");
		if (getDriver().findElement(AMDSubscibeScreen.objContinueBtn).isEnabled()) {
			logger.info("Continue button is highlighted");
			extent.extentLogger("Highlighted", "Continue button is highlighted");
		}
		click(AMDSubscibeScreen.objRSVODPremiumPack, "RSVOD Pack tab");
		verifyElementPresentAndClick(AMDSubscibeScreen.objRSVODPack1, "RSVOD Plan for 30 days");
		PartialSwipe("UP", 1);
		verifyElementExist(AMDSubscibeScreen.objRSVODPack2, "RSVOD Plan for 365 days");
		verifyElementExist(AMDSubscibeScreen.objDescriptionText, "Premium Description in subscribe page");
		if (getDriver().findElement(AMDSubscibeScreen.objContinueBtn).isEnabled()) {
			logger.info("Continue button is highlighted");
			extent.extentLogger("Highlighted", "Continue button is highlighted");
		}
		click(AMDSubscibeScreen.objContinueBtn, "Continue button");
		verifyElementExist(AMDSubscibeScreen.objAccountInfoHeader, "Account info screen");
		verifyElementExist(AMDSubscibeScreen.objSubscribeHeader, "Subscribe header");
		verifyElementExist(AMDSubscibeScreen.objSubscribePageBackButton, "Back button in Account info screen");
		verifyElementExist(AMDSubscibeScreen.objSelectedPackDesc, "Selected pack description in account info screen");
		verifyElementExist(AMDSubscibeScreen.objEmailID, "Email id field in Account info screen");
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


/* ==================================================================================
------------------------------  Script Author: BINDU -------------------------------

List of Functions Created
- BrowseForFreeAndMobileRegistration()
- VerifyLoginPage()
- SearchBox(String userType)
- verifySearchLandingScreen(String userType)
- verifySearchOption(String userType) 
===================================================================================== */

	public void BrowseForFreeAndMobileRegistration() throws Exception {

		extent.HeaderChildNode("Validating BrowseForFree Button on the intro screen");
		waitTime(5000);
		verifyElementPresent(AMDLoginScreen.objBrowseForFreeBtn, "BrowseForFreee Button");
		waitTime(5000);
		String BrowseForFree = getText(AMDLoginScreen.objBrowseForFreeBtn);
		System.out.println(BrowseForFree);
		if (BrowseForFree.concat("English") != null)
		{
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

		extent.HeaderChildNode("Validating the Navigation to Login or Register Screen Tapping on the Login link available in Intro Screen");
		//waitTime(8000);
		verifyElementPresent(AMDLoginScreen.objLoginLnk, "Login Link");
		click(AMDLoginScreen.objLoginLnk, "Login Link");
		verifyElementPresent(AMDLoginScreen.objLoginPage, "Login Page");
		logger.info("User navigated to Login/Register Screen Tapping on the Login link present on the Intro Screen");
		extent.extentLogger("Login/Register Screen",
				"User is navigated to Login/register Screen Tapping on the Login link present on the Intro Screen");
		verifyElementPresentAndClick(AMDLoginScreen.objSkipButton, "Skip button");
		//waitTime(4000);
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

	//	verifyElementPresent(AMDLoginScreen.objLoginTextChanged, "Login Text");
		
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
	
	public void SearchBox(String userType) throws Exception
	{
		extent.HeaderChildNode("validating the UI/UX of search Landing screen");
		System.out.println("\nValidating the UI/UX of search Landing screen");
		verifyElementPresent(AMDSearchScreen.objSearchIcon, "Search icon");
		click(AMDSearchScreen.objSearchIcon, "Search icon");
		waitTime(6000);
		
		verifyElementExist(AMDSearchScreen.objHomeOption,"Bottom bar Home Option");
		verifyElementExist(AMDSearchScreen.objUpcomingOption,"Bottom bar Upcoming Option");
		verifyElementExist(AMDSearchScreen.objDownloadsOption,"Bottom bar Downloads Option");
		verifyElementExist(AMDSearchScreen.objMoreOption,"Bottom bar More Option");
		
//		verifyElementExist(AMDHomePage.HomeIcon,"Bottom bar Home Option");
//		verifyElementExist(AMDHomePage.UpcomingIcon,"Bottom bar Upcoming Option");
//		verifyElementExist(AMDHomePage.DownloadIcon,"Bottom bar Downloads Option");
//		verifyElementExist(AMDHomePage.MoreMenuIcon,"Bottom bar More Option");
		
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
		System.out.println(sizee.getWidth() +" X "+sizeee);

		if (VoiceIconRightX >= sizeee) {
			logger.info("Microphone search icon is displayed at top right of the Search screen");
			extent.extentLogger("Microphone icon", "Microphone search icon is displayed at top right of the Search screen");
		}else{
			logger.error("Microphone icon is not displayed at top right of the Search screen");
			extent.extentLoggerFail("Microphone icon", "Microphone icon is not displayed at top right of the Search screen");
		}
		
		click(AMDSearchScreen.objVoiceicon,"Microphone Icon");
		//wait(2000);
		String MicrophoneAccessPopup = getDriver().findElement(AMDSearchScreen.objMicroPhone).getText();
		System.out.println(MicrophoneAccessPopup);
		
		if(MicrophoneAccessPopup.equalsIgnoreCase("ZEE5 requires your permission to access your device's microphone to enable voice search. The voice data is not stored with ZEE5."))
		{	
			logger.info("Device Microphone access permission pop up is displayed");
			extent.extentLogger("Voice Search Icon","Device Microphone access permission pop up is displayed");
		}else{
			logger.error("Device Microphone access permission pop up is not displayed");
			extent.extentLoggerFail("Voice Search icon", "Device Microphone access permission pop up is not displayed");
		}
		
		verifyElementExist(AMDSearchScreen.objVoiceSearchBackButton,"Back button");
		click(AMDSearchScreen.objVoiceSearchBackButton,"Back button");
		
		waitTime(2000);
		
		
		verifyElementExist(AMDSearchScreen.objsearchBox,"Search Box");
		logger.info("Search box is available on top section of search landing screen");
		extent.extentLogger("Search box","Search box is available on top section of search landing screen");
		
        String SearchBoxText = getDriver().findElement(AMDSearchScreen.objsearchBox).getText();
       
		System.out.println(SearchBoxText);
		logger.info(SearchBoxText);
		
		if(SearchBoxText.equalsIgnoreCase("Search for Movies, Shows, Channels etc."))
		{
			logger.info("Water Marked Text is displayed by default in Search Box");
			extent.extentLogger("Search box","Water Marked Text is displayed by default in Search Box");
		}else{
			logger.error("Water Marked Text is not displayed by default in Search Box");
			extent.extentLoggerFail("Search Box", "Water Marked Text is not displayed by default in Search Box");
		}
		
		
		verifyElementPresentAndClick(AMDLoginScreen.objBackBtn,"Back Button");
		verifyElementPresent(AMDLoginScreen.objHomeTab, "Home Tab");
		
		logger.info("User navigated to previous screen on tapping of back button available on the search screen");
		extent.extentLogger("Previous screen","User navigated to previous screen on tapping of back button available on the search screen");
		
		
		verifyElementPresent(AMDSearchScreen.objSearchIcon, "Search icon");
		click(AMDSearchScreen.objSearchIcon, "Search icon");
		
		waitTime(2000);
		if(verifyElementExist(AMDSearchScreen.objTrendingSearchOverlay,"Trending Search Overlay"))
		{
		logger.info("Trending search overlay is displayed");
		extent.extentLogger("Search screen","Trending search overlay is displayed");
		}else{
			logger.info("Trending search overlay is not displayed");
			extent.extentLoggerFail("Search screen","Trending search overlay is not displayed");
			
		}
		waitTime(2000);
		if(verifyElementExist(AMDSearchScreen.objTopSearchOverlay,"Top search Overlay"))
		{
			logger.info("Top search overlay is displayed");
			extent.extentLogger("Search screen","Top search overlay is displayed");
		}else{
			logger.info("Top search overlay is not displayed");
			extent.extentLoggerFail("Search screen","Top search overlay is not displayed");
			
		}
		
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
		verifyElementPresentAndClick(AMDSearchScreen.objHomeOption,"Bottom bar Home Option");
		
		
	}
	
	public void verifySearchLandingScreen(String userType) throws Exception
	{
		extent.HeaderChildNode("Validating "+userType+" user navigates to Search landing screen");
		System.out.println("\nValidating "+userType+"user navigates to Search landing screen");
		waitTime(10000);
		verifyElementPresent(AMDLoginScreen.objHomeTab, "Home Tab");
		boolean liveTV = false;
		
		int noOfTabs = getCount(AMDHomePage.objTitle);
        for (int i = 1; i <= 10; i++) {
       	String tabName = null;
			if (i == noOfTabs) 
			{
				if (!liveTV)
				{
					i = noOfTabs-1;
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
			extent.extentLogger("Search Icon",
					tabName + " tab is displayed and clicked on " + tabName + " tab");

			verifyElementPresentAndClick(AMDSearchScreen.objSearchIcon, "Search icon");
			waitTime(2000);
			

			if (verifyElementExist(AMDSearchScreen.objSearchEditBox, "Search box")) {
				logger.info("User navigated to Search Landing screen");
				extent.extentLogger("Search Screen", "User navigated to Search Landing screen");
			} else {
				logger.error("User not navigated to Search Landing screen");
				extent.extentLoggerFail("Search Screen",
						"User not navigated to Search Landing screen");
			}
			
			verifyElementPresentAndClick(AMDLoginScreen.objBackBtn,"Back Button");
			waitTime(2000);
			
			
			if(liveTV) {
				break;
			}
			if (tabName.equalsIgnoreCase("Live TV")) {
				liveTV = true;
			}
         }
		
		verifyElementPresentAndClick(AMDSearchScreen.objHomeOption,"Bottom bar Home Option");

	}
	
	
	public void verifySearchOption(String userType) throws Exception
	{
		extent.HeaderChildNode("Verify Search Icon on Landing pages as : "+userType);
		System.out.println("\nVerify Search Icon on Landing pages as "+userType);
		waitTime(10000);
		verifyElementPresent(AMDLoginScreen.objHomeTab, "Home Tab");
		boolean liveTV = false;

		int noOfTabs = getCount(AMDHomePage.objTitle);		
		System.out.println("HOME PAGE HEADERS: "+noOfTabs);
		for (int i = 1; i <= 10; i++) {

			String tabName = null;
			if (i == noOfTabs) {
				if (!liveTV) {
					i = noOfTabs-1;
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
			extent.extentLogger("Search Icon",
					tabName + " tab is displayed and clicked on " + tabName + " tab");

			WebElement elementSearchIcon = findElement(AMDSearchScreen.objSearchIcon);
			int SearchIconRightX = elementSearchIcon.getLocation().getX();
			System.out.println(SearchIconRightX);
			Dimension sizee = getDriver().manage().window().getSize();
//			System.out.println(sizee.getWidth());
			int sizeee = sizee.getWidth() - 300;
			System.out.println(sizee.getWidth() + " X "+sizeee);
			

			if (SearchIconRightX >= sizeee) {
				logger.info("Search icon is displayed at top right of the " + tabName + " tab ");
				extent.extentLogger("Search icon", "Search icon is displayed at top right of the " + tabName + " tab ");
			} else {
				logger.error("Search icon is not displayed at top right of the " + tabName + " tab ");
				extent.extentLoggerFail("Search icon",
						"Search icon is not displayed at top right of the " + tabName + " tab ");
			}
			if(liveTV) {
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
		verifyElementPresentAndClick(AMDSearchScreen.objHomeOption,"Bottom bar Home Option");

	}
	
/* ==================================================================================
------------------------------  Script Author: SUSHMA -------------------------------

List of Functions Created
- DisplayLanguagePopUp(String userType, String displaylanguage1, String displaylanguage2)
- DisplayLanguagePopUpValidation(String, String)
- loginOrRegisterScreen(String inValidPhnNo, String validPhnNo, String loginThrough, String userType)
- loginScreen(String validPassword)
- OtpScreen(String otp1, String otp2, String otp3, String otp4)
- TopSearches()
- 
===================================================================================== */

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
			if(verifyElementPresent(AMDLoginScreen.objContinueWithTxt, "Continue with social login"))
			{
				logger.info("Proceed button is not displayed when user enters invalid mobile number");
				extentLogger("Proceed button", "Proceed button is not displayed when user enters invalid mobile number");
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
				logger.error("Login button is not highlighted when user enters a minimum of 6 characters in password field");
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
	
	public void TopSearches(String usertype) throws Exception
	{
		extent.HeaderChildNode("Top Searches module");
        waitTime(5000);
		verifyElementPresentAndClick(AMDSearchScreen.objSearchIcon2, "Search icon");
		if(usertype.equalsIgnoreCase("NonSubscribedUser") || usertype.equalsIgnoreCase("SubscribedUser"))
		{
			
			if(verifyElementExist(AMDSearchScreen.objTopSearches, "Top searches tray"))
			{
				verifyElementPresent(AMDSearchScreen.objContentCardTitleOfTopSearchesTray, "Content card title of Top searches tray");
				
				getText(AMDSearchScreen.objContentCardTitleOfTopSearchesTray);
				
//				click(AMDSearchScreen.objContentCardTitleOfTopSearchesTray, "Content card of Top searches tray");
//				waitForElementDisplayed(AMDSearchScreen.objConsumptionScreenTitle, 10);
//				
//				verifyElementPresent(AMDSearchScreen.objConsumptionScreenTitle, "Title in Consumption screen");
//				
//
//					String consumptionScreenTitle = getText(AMDSearchScreen.objConsumptionScreenTitle);
//					if(contentCardTitleofTopSearches.equalsIgnoreCase(consumptionScreenTitle))
//					{
//					    logger.info("user navigated to respective consumption/Landing screen post tapping on any Top searches carousel");	
//					    extent.extentLogger("Title", "user navigated to respective consumption/Landing screen post tapping on any Top searches carousel");
//					}
//					else
//					{
//						logger.info("user is not navigated to respective consumption/Landing screen post tapping on any Top searches carousel");	
//					    extent.extentLoggerFail("Title", "user is not navigated to respective consumption/Landing screen post tapping on any Top searches carousel");
//					}
					Back(1);
			}
			else
			{
				logger.info("Top searches is not displayed");
				extentLoggerFail("Top searches", "Top searches is not displayed");
			}	
		}
		else
		{
			Back(1);
		}
	
	}
	
	
	public void TrendingSearches() throws Exception
	{
		extent.HeaderChildNode("Trending Searches module");
        
		verifyElementPresentAndClick(AMDSearchScreen.objSearchIcon2, "Search icon");
		
//	    verifyElementPresentAndClick(AMDSearchScreen.objSearchEditBox, "Search Box");
//	    type(AMDSearchScreen.objSearchBar, "Milana", "Search bar");
//		
//		verifyElementPresentAndClick(AMDSearchScreen.objSearchResultFirstContent, "content");
//		verifyElementExist(AMDSearchScreen.objConsumptionScreenTitle, "Title in Consumption screen");
//		Back(2);
//		waitTime(3000);
//		verifyElementPresentAndClick(AMDSearchScreen.objSearchIcon2, "Search icon");
//		
//		verifyElementPresent(AMDSearchScreen.objTrendingSearches, "Trending Searches tray");
		
		verifyElementPresent(AMDSearchScreen.objContentCardTitleOfTrendingSearchesTray, "Content card title of Trending searches tray");
		
		getText(AMDSearchScreen.objContentCardTitleOfTrendingSearchesTray);
		
//		click(AMDSearchScreen.objContentCardTitleOfTrendingSearchesTray, "Content card of Trending searches tray");
//		waitForElementDisplayed(AMDSearchScreen.objConsumptionScreenTitle, 10);
//		
//		verifyElementPresent(AMDSearchScreen.objConsumptionScreenTitle, "Title in Consumption screen");
//		
//			String consumptionScreenTitle = getText(AMDSearchScreen.objConsumptionScreenTitle);
//			if(contentCardTitleofTrendingSearches.equalsIgnoreCase(consumptionScreenTitle))
//			{
//			    logger.info("user navigated to respective consumption/Landing screen post tapping on any Trending searches carousel");	
//			    extent.extentLogger("Title", "user navigated to respective consumption/Landing screen post tapping on any Trending searches carousel");
//			}
//			else
//			{
//				logger.info("user is not navigated to respective consumption/Landing screen post tapping on any Trending searches carousel");	
//			    extent.extentLoggerFail("Title", "user is not navigated to respective consumption/Landing screen post tapping on any Trending searches carousel");
//			}
			Back(1);
		
	}


/* ==================================================================================
------------------------------  Script Author: VINAY ---------------------------------

List of Functions Created
- IntroScreen(String userType)
- 
- 
===================================================================================== */
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
			
			//Covered few TC's and Updated Code by Kushal
			
			click(AMDOnboardingScreen.objBackBtn, "Back button");
			verifyElementPresent(AMDGenericObjects.objCheckTitle("Display Language"), "Display language screen");
			click(AMDOnboardingScreen.objSelectDisplayLang("Kannada"), "Kannada language");
			click(AMDOnboardingScreen.objDiplay_ContinueBtn, "[Display Language] Continue Button");
			
			String strLang = findElement(AMDOnboardingScreen.objScreenTitle).getText();
			if(strLang!="Content Language")
			{
				
				extent.extentLogger("Content language screen","Content language is displayed in Kannada language");
				logger.info("Title of the screen : " + strLang + " is displayed in selected language");
			} else {
				extent.extentLoggerFail("Content language screen","Failed to display the content language in selected language");
				logger.error("Failed to display the content language in selected language");
			}
			
			click(AMDOnboardingScreen.objContent_ContinueBtn, "Continue Button");
			
			if(findElement(AMDOnboardingScreen.objBrowseForFreeBtn).getText()!="Browse for Free") {
				String strBrwsforFree = findElement(AMDOnboardingScreen.objBrowseForFreeBtn).getText();
				extent.extentLogger("Intro screen","Browse for free button is displayed in selected launguage: " + strBrwsforFree);
				logger.info("Browse for free button is displayed in selected launguage : " + strBrwsforFree);
			} else {
				extent.extentLoggerFail("Intro screen","Browse for free button failed to displayed in selected launguage");
				logger.error("Browse for free button failed to displayed in selected launguage");
			}
			String strSubsNow = findElement(AMDOnboardingScreen.objSubscribeNowBtn).getText();
			if(strSubsNow!="Subscribe Now") {
				extent.extentLogger("Intro screen","Subscribe Now button is displayed in selected launguage: " + strSubsNow);
				logger.info("Subscribe Now button is displayed in selected launguage : " + strSubsNow);
			} else {
				extent.extentLoggerFail("Intro screen","Subscribe Now button failed to displayed in selected launguage: "+strSubsNow);
				logger.error("Subscribe Now button failed to displayed in selected launguage: "+strSubsNow);
			}
			String strHavePrepaidCode = findElement(AMDOnboardingScreen.objHavePrepaidBtn).getText();
			if(strHavePrepaidCode!="Have a prepaid code") {
				extent.extentLogger("Intro screen","Have a Prepaid code CTA is displayed in selected launguage: " + strHavePrepaidCode);
				logger.info("Have a Prepaid code CTA is displayed in selected launguage: " + strHavePrepaidCode);
			} else {
				extent.extentLoggerFail("Intro screen","Have a Prepaid code CTA failed to displayed in selected launguage: "+strHavePrepaidCode);
				logger.error("Have a Prepaid code CTA failed to displayed in selected launguage: "+strHavePrepaidCode);
			}
			String strLoginCTA = findElement(AMDOnboardingScreen.objLoginLnk).getText();
			if(strHavePrepaidCode!="Login") {
				extent.extentLogger("Intro screen","Login CTA is displayed in selected launguage: " + strLoginCTA);
				logger.info("Login CTA is displayed in selected launguage: " + strLoginCTA);
			} else {
				extent.extentLoggerFail("Intro screen","Login CTA failed to displayed in selected launguage: "+strLoginCTA);
				logger.error("Login CTA failed to displayed in selected launguage: "+strLoginCTA);
			}
			Back(2);
			if(findElement(AMDOnboardingScreen.objSelectedDisplayLang).getText()!="English") {
				click(AMDOnboardingScreen.objSelectDisplayLang("English"), "English language");
				click(AMDOnboardingScreen.objDiplay_ContinueBtn, "[Display Language] Continue Button");
			}
			//***********************************************************
			
			
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
		}else {
			extent.extentLogger("Intro Screen","Intro Screen is not displayed for Susbcribed/Non-Subscribed user");
			logger.info("Intro Screen is not displayed for Susbcribed/Non-Subscribed user");
			System.out.println("Intro Screen is not displayed for Susbcribed/Non-Subscribed user");
		}
	}


/* ==================================================================================
------------------------------  Script Author: HITESH -------------------------------

Functions Created list
- navigateToRegisterScreen(String loginThrough)
- validateRegister(String firstName, String secoundName)
- checkRegisterButton()
- deepLinks(String tabName)
- relaunch()
- registerForFreeScreen()
===================================================================================== */

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
			extent.extentLoggerFail("“Email ID or Mobile number”", "“Email ID or Mobile number” field is not grayed out");
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
		verifyElementExist(AMDRegistrationScreen.objPasswordErrorMsg,"“Password must be a minimum of 6 characters” error message");
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
		click(AMDRegistrationScreen.objFirstNameTxtField, "First name"); //Clicking on First Name field to get device keyboard
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
	
/* ==================================================================================
------------------------------  Script Author: MANASA ---------------------------------

List of Functions Created
- ZeeApplicasterLogin(String LoginMethod)
- offlineScreenValidation()
- socialLoginValidation(String loginThrough)
- 
====================================================================================== */
	
	public void ZeeApplicasterLogin(String LoginMethod) throws Exception {
		extent.HeaderChildNode("Login Functionality");

		String UserType = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("userType");
		if (UserType.equals("Guest")) {
			extent.extentLogger("userType", "UserType : Guest");
//		return;
		}
		
//		verifyElementPresentAndClick(AMDLoginScreen.objLoginLnk, "Skip link");

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

			verifyElementPresentAndClick(AMDLoginScreen.objLoginBtn, "Login Button");
			waitTime(3000);
			break;
		}
	}

	public void offlineScreenValidation() throws Exception {

		extent.HeaderChildNode("Offline Screen Validation");

		Runtime.getRuntime().exec("adb shell svc wifi disable");
		
		if(pUserType.contains("Guest")) {
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
		

	//	verifyElementPresentAndClick(AMDOfflineScreen.objGoToDownloads, "Go to Downloads");
		
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
		waitTime(5000);
		verifyElementPresentAndClick(AMDHomePage.objUpcoming, "Upcoming tab");
		if (verifyElementExist(AMDHomePage.objTitle, "Upcoming Page")) {
			logger.info("Appropriate page is loaded");
			extent.extentLogger("Page", "Appropriate page is loaded");
		} else {
			logger.info("Appropriate page is not loaded");
			extent.extentLogger("Page", "Appropriate page is not loaded");
		}
	}
	
	public void socialLoginValidation(String loginThrough) throws Exception {
		extent.HeaderChildNode("Social Login Validation");
		verifyElementPresentAndClick(AMDOnboardingScreen.objDiplay_ContinueBtn, "Continue button");
		verifyElementPresentAndClick(AMDOnboardingScreen.objContent_ContinueBtn, "Continue button in content language screen");
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

	public void searchResultsAllTabs(String searchKeyword) throws Exception {

		extent.HeaderChildNode("Validating that user is able to find the searched content in all the tabs");
	
		type(AMDSearchScreen.objSearchBoxBar, searchKeyword+"\n", "Search bar");
		waitTime(2000);
		
		waitForElementDisplayed(AMDSearchScreen.objAllTab, 10);
		hideKeyboard();
		
		boolean allTabHighlighted = findElement(AMDSearchScreen.objAllTab).isSelected();
		
		if(allTabHighlighted == true) {
			logger.info("All Tab is highlighted by default");
			extent.extentLogger("All Tab", "All Tab is highlighted by default");
		}else {
			logger.error("All Tab is not highlighted by default");
			extent.extentLogger("All Tab", "All Tab is not highlighted by default");
		}
		
		waitTime(5000);
		
		swipeByElements(findElement(AMDSearchScreen.objMusicTabIndx),
				findElement(AMDSearchScreen.objShowsTabIndx));
		
		waitTime(3000);
		swipeByElements(findElement(AMDSearchScreen.objMusicTabIndx),
				findElement(AMDSearchScreen.objVideosTab));
		
		logger.info("User is able to scroll through the tabs");
		extent.extentLogger("Tabs", "User is able to scroll through the tabs");
		
		waitTime(2000);
		List<WebElement> tabs = getDriver().findElements(AMDSearchScreen.objTabs);
		System.out.println(tabs.size());
		boolean News = false;
		for (int i = 1; i <= tabs.size(); i++) {
			String tabName = null;
	
			System.out.println("i : "+i);
			
			if (i == 5) {
				
				if (!News) {
					i = 4;
				}
				
			WebElement eleTab = findElement(By.xpath("((//*[@resource-id='com.graymatrix.did:id/tabLayout'])[2]/child::*/child::*/child::*/child::*)["+i+"]"));
			 tabName = findElement(By.xpath("((//*[@resource-id='com.graymatrix.did:id/tabLayout'])[2]/child::*/child::*/child::*/child::*)["+i+"]")).getText();
			
				System.out.println(tabName);
				eleTab.click();
				
			} else {
				WebElement eleTab = findElement(By.xpath("((//*[@resource-id='com.graymatrix.did:id/tabLayout'])[2]/child::*/child::*/child::*/child::*)["+i+"]"));
				 tabName = findElement(By.xpath("((//*[@resource-id='com.graymatrix.did:id/tabLayout'])[2]/child::*/child::*/child::*/child::*)["+i+"]")).getText();
				System.out.println(tabName);
				eleTab.click();
			}
			
			
			logger.info(tabName + " tab is displayed and clicked on " + tabName + " tab");
			extent.extentLogger("Related search results",tabName + " tab is displayed and clicked on " + tabName + " tab");

			for(int j=1;j<=2;j++) {
				String searchResults= findElement(By.xpath("(//*[@id='searchResultsContent']//following-sibling::*[@id='item_primary_text'])["+j+"]")).getText();
				System.out.println(searchResults);
				
				if(searchResults.contains(searchKeyword)) {
					logger.info("Search Results  Keyword has results in " +tabName + " tab");
					extent.extentLogger("Related search results", "Search Results  Keyword has results in " +tabName + " tab");
				} else {
					logger.info("Related search results are not displayed in  " +tabName + " tab");
					extent.extentLogger("Related search results", "Related search results are not displayed in  " +tabName + " tab");
				}
			}
			
			
			if(News) {
				break;
			}
			if (tabName.equalsIgnoreCase("News")) {
				News = true;
			}
		}
		
		Back(1);
		
		if(verifyElementExist(AMDSearchScreen.objMicrophoneIcon, "Microphone Icon")) {
			logger.info("Microphone icon is displayed when user navigates back to Search landing screen from Search Result screen");
			extent.extentLogger("Microphone icon", "Microphone icon is displayed when user navigates back to Search landing screen from Search Result screen");
		} else {
			logger.error("Microphone icon is not displayed when user navigates back to Search landing screen from Search Result screen");
			extent.extentLoggerFail("Microphone icon",
					"Microphone icon is not displayed when user navigates back to Search landing screen from Search Result screen");
		}
		
	}

	
	public void noSearchResults(String searchKeyword) throws Exception {
		extent.HeaderChildNode("Validating the category tab is not displayed if the searched keyword don’t have results for the particular category");
		
		verifyElementPresentAndClick(AMDHomePage.objSearchBtn, "Search Icon");
		
		verifyElementPresentAndClick(AMDSearchScreen.objSearchEditBox, "Search Box");
		type(AMDSearchScreen.objSearchBoxBar, searchKeyword+"\n", "Search bar");
		waitTime(5000);
		
		if(verifyElementExist(AMDSearchScreen.objNoSearchResults, "No Search Results message")) {
			String noResults = getText(AMDSearchScreen.objNoSearchResults);
			logger.info(noResults +" message is displayed");
			extent.extentLogger("Search Results message", noResults +" message is displayed");
			
			logger.info("Searched keyword does not have results for the particular category");
			extent.extentLogger("Search Results message", "Searched keyword does not have results for the particular category");
		}else {
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

		System.out.println("StartX : " + startX);
		System.out.println("StartY : " + startY);
		System.out.println("endX : " + endX);
		System.out.println("endY : " + endY);
		
		touchAction.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
		.moveTo(PointOption.point(endX, endY)).release().perform();
	}

	public void searchPageValidation(String searchKeyword) throws Exception {
		extent.HeaderChildNode("Search Result Screen Validation");
		type(AMDSearchScreen.objSearchBoxBar, searchKeyword+"\n", "Search bar");
//		verifyElementExist(AMDSearchScreen.objSearchResultPage, "Search Result Screen");
		
//		if(verifyElementExist(AMDSearchScreen.objRecentSearch, "Recent Search Overlay")==false) {
//			extent.extentLogger("Recent Search Overlay","Recent Search Overlay is not available in search results screen");
//			logger.info("Recent Search Overlay is not available in search results screen");
//		}else {
//			extent.extentLoggerFail("Recent Search Overlay", "Recent Search Overlay is available in search results screen");
//			logger.error("Recent Search Overlay is available in search results screen");
//		}
		waitTime(5000);
		waitForElementDisplayed(AMDSearchScreen.objAllTab, 10);
		hideKeyboard();		
//		String enteredValue = getAttributValue("value", AMDSearchScreen.objSearchBoxBar);
		System.out.println(searchKeyword.length());
		waitTime(20000);
		if (searchKeyword.length() >= 3) {
			
			System.out.println(getDriver().findElements(AMDSearchScreen.objRelatedSearchResult).size());
			
			if (getDriver().findElements(AMDSearchScreen.objRelatedSearchResult).size() > 0) {
				logger.info("Search result screen is displayed once user enters 3rd character in the search box.");
				extent.extentLogger("Search result screen",
						"Search result screen is displayed once user enters 3rd character in the search box.");

			} else {
				logger.info("Search result screen is not displayed when user enters less than 3 characters in the search box.");
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
	
		verifyElementPresentAndClick(AMDHomePage.objSearchBtn, "Search Icon");
		verifyElementPresentAndClick(AMDSearchScreen.objMicrophoneIcon, "Microphone icon");
		verifyElementPresentAndClick(AMDSearchScreen.objProceedBtn,"Proceed Button");
		if(verifyElementExist(AMDSearchScreen.objAudioPermissionPopUp,"Audio Permission Popup")) {
			verifyElementPresentAndClick(AMDSearchScreen.objDeny, "Deny Option");
			
			if(verifyElementExist(AMDSearchScreen.objMicrophoneIcon, "Microphone Icon")) {
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
		
	//	verifyElementPresentAndClick(AMDHomePage.objSearchBtn, "Search Icon");
		
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
		if(verifyElementExist(AMDSearchScreen.objVoiceSearchPermission,"Microphone access permission popup")) {
			verifyElementExist(AMDSearchScreen.objMicrophoneIconLogo,"Microphone icon");
			verifyElementExist(AMDSearchScreen.objTermsAndConditions,"Terms of Use and Privacy Policy Message");
			verifyElementExist(AMDSearchScreen.objProceedBtn,"Proceed Button");
			verifyElementExist(AMDSearchScreen.objBackBtn,"Back button");
			
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
			
			click(AMDSearchScreen.objProceedBtn,"Proceed Button");
			if(verifyElementExist(AMDSearchScreen.objAudioPermissionPopUp,"Audio Permission Popup")) {
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
	

	
/* ==================================================================================
------------------------------  Script Author: KUSHAL ---------------------------------

List of Functions Created
- navigateToLoginScreen_DisplaylangScreen()
- navigateToIntroScreen_DisplaylangScreen()
- LoginWithEmailID(String pEmailId, String pPassword)
- verifyUIPresentInLoginPage()
- verifyLoginScreenUIFunctionality()
- VerifySkipLoginRegistrationScreen()
- VerifyLoginWithEmailId(String  pUserName,  String pPassword)
- verifyHaveAPrepaidCodePopUp()
- verifyInvalidPrepaidCodePopUpAfterLogin(String pEmailID, String  pPassword)
- verifyInvalidPrepaidCodePopUpAfterRegistration()
- verifyCongratulationPopupAppearsforValidPrepaidCode(String pCode, String pUserName, String pPassword)
====================================================================================== */

	
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
		if(pwdEncript.contains("false")) {
			extent.extentLogger("Default Show Password","Password is Encripted");
			logger.info("Password is Encripted");
		}else {
			extent.extentLoggerFail("Default Show Password","Password is not Encripted");
			logger.error("Password is not Encripted");
		}
		
		click(AMDLoginScreen.objShowPwdBtn, "Show Password");
		String checkPwdVisible = getAttributValue("checked", AMDLoginScreen.objShowPwdBtn);
		if(checkPwdVisible.contains("true")) {
			extent.extentLogger("Click Show Password","Password is Visible");
			logger.info("Password is Visible");
		}else {
			extent.extentLoggerFail("Click Show Password","Password is not Visible");
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
	
	public void VerifyLoginWithEmailId(String  pUserName,  String pPassword) throws Exception {
		
		extent.HeaderChildNode("Login With Email-ID");
			System.out.println("Login With Email-ID");
		verifyElementPresent(AMDGenericObjects.objScreenTitleName("Login/Register"), "Login/Register");
		type(AMDLoginScreen.objEmailIdField, pUserName, "Email-ID");
		verifyElementPresentAndClick(AMDLoginScreen.objProceedBtn, "Proceed button");
		if(getText(AMDLoginScreen.objEmailIdField).equalsIgnoreCase(pUserName)) {
			extent.extentLogger("Email-Id Retained","Email Id is retained in Login screen EmailId Field");
			logger.info("Email Id is retained in Login screen EmailId Field");
		}else {
			extent.extentLoggerFail("Email-Id Retained","Email Id failed to retained in Login screen EmailId Field");
			logger.error("Email Id failed to retained in Login screen EmailId Field");
		}
		String getPropertyValue = getAttributValue("enabled", AMDLoginScreen.objEmailIdField);
		if(getPropertyValue.equalsIgnoreCase("false")){
			extent.extentLogger("EmailId field is disabled/grayed out"," User cannot edit emailid field");
			logger.info("EmailId field is disabled/grayed out and user cannot edit emailid field");
		}else {
			extent.extentLoggerFail("EmailId field is not grayed out"," User is able to edit emailid field");
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
		if(verifyElementPresent(AMDHomePage.objHomeTab, "Home page")) {
			extent.extentLogger("Login with EmailId",pUserName +  " : is logged in successfully");
			logger.info(pUserName +  " is logged in  successfully");
		}else {
			extent.extentLoggerFail("Login with EmailId", pUserName +" failed to login");
			logger.error(pUserName +  " failed to login");
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
		if(getPropertyValue.equalsIgnoreCase("false")){
			extent.extentLogger("Apply button","Apply Button is by default dehighlighted");
			logger.info("Apply Button is by default dehighlighted");
		}else {
			extent.extentLoggerFail("Apply buttont","Apply Button fails to dehighlight by default");
			logger.error("Apply Button failed to dehighlight by default");
		}
		
		verifyElementPresent(AMDOnboardingScreen.objPrepaidCodeField, "Prepaid Code Field");
		if(getText(AMDOnboardingScreen.objPrepaidCodeField).equalsIgnoreCase("Prepaid Code")){
			extent.extentLogger("Prepaid Code field","Prepaid Code text is displayed in the edit field");
			logger.info("Prepaid Code text is displayed in the edit field");
		}else {
			extent.extentLoggerFail("Prepaid Code field","Prepaid Code text is not displayed in the edit field");
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
		if(getPropertyValue2.equalsIgnoreCase("true")){
			extent.extentLogger("Apply button","Apply Button is highlighted");
			logger.info("Apply Button is highlighted");
		}else {
			extent.extentLoggerFail("Apply buttont","Apply Button fails to highlight after entering code");
			logger.error("Apply Button fails to highlight after entering code");
		}
		
		click(AMDOnboardingScreen.objApplyBtn, "Apply button");
		verifyElementPresent(AMDOnboardingScreen.objFaceIcon, "Oops! label");
		String textMessage  = getText(AMDOnboardingScreen.objSuccessDesc);
		if(textMessage.contains("You are not logged in")) {
			extent.extentLogger("Invalid Code Message","You are not logged in to apply prepaid code... message");
			logger.info("You are not logged in to apply prepaid code... message is displayed");
		}else {
			extent.extentLoggerFail("Invalid Code Message","You are not logged in to apply prepaid code... message");
			logger.error("You are not logged in to apply prepaid code... message is not displayed");
		}
		
		verifyElementPresent(AMDOnboardingScreen.objRegisterBtn, "Register button");
		verifyElementPresentAndClick(AMDOnboardingScreen.objLoginBtn, "Login button");
		verifyElementPresent(AMDLoginScreen.objEmailIdField, "Login/Register screen");
	}
	
	public void verifyInvalidPrepaidCodePopUpAfterLogin(String pEmailID, String  pPassword) throws Exception {
		
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
		verifyElementPresent(AMDOnboardingScreen.objSuccessTitle("Invalid Prepaid Code"), "Invalid Prepaid Code Pop up");
		String getPopUpDesc =getText(AMDOnboardingScreen.objSuccessDesc); 
		if(getPopUpDesc.contains("Please Provide Valid Coupon code")) {
			extent.extentLogger("Invalid Pop up",getPopUpDesc +  "  message is displayed");
			logger.info(getPopUpDesc +  "is displayed in PopUp screen");
		}else {
			extent.extentLoggerFail("Invalid Pop up", "Please provide valid coupon code message is not displayed");
			logger.error("Please provide valid coupon code is not displayed");
		}
		
		verifyElementPresentAndClick(AMDOnboardingScreen.objDoneBtn, "Done button");
		if(verifyElementPresent(AMDHomePage.objHome, "Home Screen")) {
			extent.extentLogger("Login with registered user",pEmailID +  " :  is logged in Successfully");
			logger.info(pEmailID +  " is logged in  successfully");
		}else {
			extent.extentLoggerFail("Login with registered user", pEmailID +" failed to login");
			logger.error(pEmailID +  " failed to login");
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
		
		//---Register new user 
		registerForFreeScreen("Prepaid");
		
		verifyElementPresent(AMDOnboardingScreen.objSuccessTitle("Invalid Prepaid Code"), "Invalid Prepaid Code Pop up");
		String getPopUpDesc =getText(AMDOnboardingScreen.objSuccessDesc); 
		if(getPopUpDesc.contains("Please Provide Valid Coupon code")) {
			extent.extentLogger("Invalid Pop up",getPopUpDesc +  " is displayed in PopUp screen");
			logger.info(getPopUpDesc +  "is displayed in PopUp screen");
		}else {
			extent.extentLoggerFail("Invalid Pop up", "Please provide valid coupon code is not displayed");
			logger.error("Please provide valid coupon code is not displayed");
		}
		
		verifyElementPresentAndClick(AMDOnboardingScreen.objDoneBtn, "Done button");
		if(verifyElementPresent(AMDHomePage.objHome, "Home Screen")) {
			extent.extentLogger("Register New user","User is registered to ZEE5 successfully");
			logger.info("User is registered to ZEE5 successfully");
		}else {
			extent.extentLoggerFail("Register New user", "User failed to register");
			logger.error("User failed to register");
		}
		
	}
	
	
	//---------  Need a VALID Prepaid Code to verify Congratulations Popup screen ---------
		public void verifyCongratulationPopupAppearsforValidPrepaidCode(String pCode, String pUserName, String pPassword) throws Exception {
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

public void DownloadScreenValidation(String userType) throws Exception{
			extent.HeaderChildNode("Verify the UI/UX of Download landing screen");
			if (userType.equals("Guest")) {
				click(AMDLoginScreen.objSkipButton, "Skip button");
				waitTime(10000);
				verifyElementExist(AMDHomePage.objDownloadBtn,"Downloads tab at the bottom of Home page");
				click(AMDHomePage.objDownloadBtn,"Downloads tab");
				waitTime(5000);
				verifyElementExist(AMDDownloadPage.objDwnloadsHeader,"Downloads text at the top on center of the screen");
				verifyElementExist(AMDDownloadPage.objshowstab,"Shows tab in Downloads landing screen");
				verifyElementExist(AMDDownloadPage.objmoviestab,"Movies tab in Downlaods landing screen");
				verifyElementExist(AMDDownloadPage.objvideostab,"Videos tab in Downloads landing screen ");				
				waitTime(5000);
				String getPropertyValue = getAttributValue("enabled", AMDDownloadPage.objshowstab);
				if(getPropertyValue.equalsIgnoreCase("true")){
					extent.extentLogger("Shows tab","Shows tab is by default highlighted");
					logger.info("Shows tab is by default highlighted");
				}else {
					extent.extentLoggerFail("Shows tab","Shows tab fails to highlight by default");
					logger.error("Shows tab fails to highlight by default");
				}
				waitTime(2000);
				verifyElementPresentAndClick(AMDDownloadPage.objshowstab, "Shows tab in Downloads landing screen");
				verifyElementExist(AMDDownloadPage.objBrowseToDownloadBtn,"Browse to Download CTA under Shows tab");
				waitTime(3000);
				verifyElementPresentAndClick(AMDDownloadPage.objmoviestab,"Movies tab in Downlaods landing screen");
				verifyElementExist(AMDDownloadPage.objBrowseToDownloadBtn,"Browse to Download CTA under Shows tab");
				waitTime(3000);
				verifyElementPresentAndClick(AMDDownloadPage.objvideostab,"Videos tab in Downloads landing screen");
				verifyElementExist(AMDDownloadPage.objBrowseToDownloadBtn,"Browse to Download CTA under Shows tab");
				waitTime(3000);
				//Browse to Download CTA functionality
				
		}
	}
}
