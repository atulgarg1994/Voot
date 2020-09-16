package com.business.zee;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import com.driverInstance.CommandBase;
import com.extent.ExtentReporter;
import com.propertyfilereader.PropertyFileReader;
import com.utility.Utilities;
import com.zee5.PWAPages.PWAHamburgerMenuPage;
import com.zee5.PWAPages.PWAHomePage;
import com.zee5.PWAPages.PWALandingPages;
import com.zee5.PWAPages.PWALoginPage;
import com.zee5.PWAPages.PWAPlayerPage;
import com.zee5.PWAPages.PWASearchPage;
import com.zee5.PWAPages.PWASignupPage;
import com.zee5.PWAPages.PWASubscriptionPages;

public class Zee5PWAWEBMixPanelBusinessLogic extends Utilities {

	public Zee5PWAWEBMixPanelBusinessLogic(String Application) throws InterruptedException {
		new CommandBase(Application);
		init();
	}
	
	String URL = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("url");

	private int timeout;

	/** Retry Count */
	private int retryCount;

	ExtentReporter extent = new ExtentReporter();

	/** The Constant logger. */
	final static Logger logger = Logger.getLogger("rootLogger");
	
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
		logger.info(
				"Loaded the following properties" + " TimeOut :" + getTimeout() + " RetryCount :" + getRetryCount());
	}

	public void ZeeWEBPWAMixPanelLogin(String LoginMethod) throws Exception {
		String userType = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("userType");	
		switch (userType) {
		case "Guest":
			extent.HeaderChildNode("Guest User");
			extent.extentLogger("Accessing the application as Guest user", "Accessing the application as Guest user");
			dismissDisplayContentLanguagePopUp();
			waitTime(3000);
			break;

		case "NonSubscribedUser":
			extent.HeaderChildNode("Login as NonSubscribed User");
			String Username = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("NonsubscribedUserName");
			String Password = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("NonsubscribedPassword");
			verifyElementPresentAndClick(PWALoginPage.objWebLoginBtn, "Login button");
			waitTime(3000);
			verifyElementPresent(PWALoginPage.objWebLoginPageText, "Login page");
			verifyElementPresentAndClick(PWALoginPage.objEmailField, "Email field");
			type(PWALoginPage.objEmailField, Username, "Email Field");
			waitTime(3000);
			verifyElementPresentAndClick(PWALoginPage.objPasswordField, "Password Field");
			type(PWALoginPage.objPasswordField, Password, "Password field");
			waitTime(5000);
			click(PWALoginPage.objWebLoginButton, "Login Button");
			waitTime(3000);
			break;

		case "SubscribedUser":
			extent.HeaderChildNode("Login as Subscribed User");
			String SubscribedUsername = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("SubscribedUserName");
			String SubscribedPassword = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("SubscribedPassword");
			verifyElementPresentAndClick(PWALoginPage.objWebLoginBtn, "Login button");
			waitTime(3000);
			verifyElementPresent(PWALoginPage.objWebLoginPageText, "Login page");
			verifyElementPresentAndClick(PWALoginPage.objEmailField, "Email field");
			type(PWALoginPage.objEmailField, SubscribedUsername, "Email Field");
			waitTime(3000);
			verifyElementPresentAndClick(PWALoginPage.objPasswordField, "Password Field");
			type(PWALoginPage.objPasswordField, SubscribedPassword, "Password field");
			waitTime(5000);
			click(PWALoginPage.objWebLoginButton, "Login Button");
			waitTime(3000);
			break;
		}
	}

	/**
	 * Dismiss the Display Language pop up
	 */
	public void dismissDisplayContentLanguagePopUp() throws Exception {
		extent.HeaderChildNode("Dismiss Display and Content Language Pop Ups");
		waitForElementAndClickIfPresent(PWAHomePage.objContinueDisplayContentLangPopup, 90,
				"Continue on Display Language Pop Up");
		Thread.sleep(5000);
		waitForElementAndClickIfPresent(PWAHomePage.objContinueDisplayContentLangPopup, 10,
				"Continue on Content Language Pop Up");
	}
	
	
	/**
	 * Function to enter url
	 */
	public void enterURLInWEBBrowser(String browser, String url) {
		extent.HeaderChildNode("Enter Browser URL");
		if (browser.equalsIgnoreCase("chrome")) {
			try {
				getWebDriver().get(url);
				extent.extentLogger("enteredURL", "Entered " + url + " in " + browser + " browser");
				logger.info("Entered " + url + " in " + browser + " browser");
			} catch (Exception e) {
				extent.extentLogger("failToEnterURL", "Failed to enter " + url + " in " + browser + " browser");
			}
		}
	}
	
	
	/**
	 * Function to select any tab
	 * 
	 */
	public boolean navigateToAnyScreenOnWeb(String screen) throws Exception {
		try {
			if (checkElementExist(PWAHomePage.objHomeBarText(screen), screen + " Tab")) {
				click(PWAHomePage.objHomeBarText(screen), screen + " Tab");
				return true;
			} else {
				JavascriptExecutor executor = (JavascriptExecutor) getWebDriver();
				getWebDriver().findElement(PWAHomePage.objMoreMenuIcon);
				waitTime(2000);
				try {
					WebElement tab = getWebDriver().findElement(PWAHomePage.objMoreMenuTabs(screen));
					logger.info(screen + " Tab is displayed");
					extent.extentLogger("tabDisplayed", screen + " Tab is displayed");
					executor.executeScript("arguments[0].click();", tab);
					logger.info("Clicked on " + screen + " Tab");
					extent.extentLogger("tabClicked", "Clicked on " + screen + " Tab");
				} catch (Exception e) {
				}
			}

		} catch (Exception e) {
			System.out.println("Exception : " + e.getMessage());
		}
		return false;
	}

	/**
	 * Function to scroll down
	 */
	public static void scrollDownWEB() {
		js.executeScript("window.scrollBy(0,250)", "");
	}
	
	/**
	 * Waits for player loader to complete
	 * 
	 * @throws Exception
	 */
	public void waitForPlayerLoaderToComplete() throws Exception {
		// verifyElementNotPresent(PWAPlayerPage.objPlayerLoader, 60);

		new WebDriverWait(getWebDriver(), 120)
				.until(ExpectedConditions.invisibilityOfElementLocated(PWAPlayerPage.objPlayerLoader));
	}

	/**
	 * Video Player or Live Player Ad verify
	 * 
	 * @param playerType
	 * @throws Exception
	 */
	public void waitForPlayerAdToComplete(String playerType) throws Exception {
		boolean adWasDisplayed = false;
		boolean playerDisplayed = false;
		int confirmCount = 0;
		waitTime(5000);
		main: for (int trial = 0; trial < 120; trial++) {
			try {
				findElement(PWAPlayerPage.objAd);
				adWasDisplayed = true;
				if (trial == 5) {
					logger.info("Ad play in progress");
					extent.extentLogger("AdPlayInProgress", "Ad play in progress");
					try {
						getWebDriver().findElement(PWAPlayerPage.objAd);
					} catch (Exception e) {
					}
				}
				if (Math.floorMod(trial, 15) == 0)
					System.out.println("Ad play in progress");
				Thread.sleep(1000);

//				//SkipAD
//				if(checkElementExist(PWAPlayerPage.objSkipAd, "SkipAd")){
//					Thread.sleep(5000);
//					click(PWAPlayerPage.objSkipAd, "SkipButton");					
//				}
//				else
//				{
//					System.out.println("No Skip Button Displayed");
//				}

			} catch (Exception e) {
				try {
					if (playerType.equals("Live Player")) {
						findElement(PWAPlayerPage.objLivePlayerLiveTag);
					} else if (playerType.equals("Video Player")) {
						findElement(PWAPlayerPage.objPlayerSeekBar);
					}
					playerDisplayed = true;
					confirmCount++;
					if (confirmCount == 1) {
						if (adWasDisplayed == false) {
							logger.info("Ad did not play");
							extent.extentLogger("AdDidNotPlay", "Ad did not play");
						} else {
							logger.info("Ad play complete");
							extent.extentLogger("AdPlayComplete", "Ad play complete");
						}
						break main;
					}
				} catch (Exception e1) {
				}
			}
		}
		if (playerDisplayed == false && adWasDisplayed == false) {
			logger.error("Ad play failure");
			extent.extentLogger("failedAd", "Ad play failure");
		}
	}

	/**
	 * Function Scroll to Element
	 *
	 * @param element
	 * @throws Exception
	 */
	public void ScrollToTheElementWEB(By element) throws Exception {
		JavascriptExecutor jse = (JavascriptExecutor) getWebDriver();
		jse.executeScript("arguments[0].scrollIntoView(true);", findElement(element));
		jse.executeScript("window.scrollBy(0,-250)", "");
	}

	public void tearDown() {
		getWebDriver().quit();
	}

	public void navigateHome() {
		getWebDriver().get("https://newpwa.zee5.com/");
		getWebDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void Back_TO_TopArrow_Web(String usertype) throws Exception {

		scrollToBottomOfPageWEB();
		if (usertype.equalsIgnoreCase("Guest")) {
			if (checkElementExist(PWAHomePage.objWhatWonderingPopUp, "Wondering popUp")) {
				waitTime(3000);
				click(PWAHomePage.objWhatWonderingPopUpCloseIcon, "Close icon");
			}
		}
		
		if (checkElementExist(PWALandingPages.obj_Pwa_Back_to_Top_Arrow_btn, "Back to Top")) {
			click(PWALandingPages.obj_Pwa_Back_to_Top_Arrow_btn, "Back to Top");
			System.out.println("Scrolled back to top using Back to top btn");
		}

	}

	/**
	 * The method will wait for the element to be located for a maximum of given
	 * seconds. The method terminates immediately once the element is located. The
	 * method throws error if the element could not be located within the given
	 * seconds
	 */
	public boolean waitForElement(By locator, int seconds, String message) throws InterruptedException {
		for (int time = 0; time <= seconds; time++) {
			try {
				getWebDriver().findElement(locator);
				logger.info("Located element " + message);
				extent.extentLogger("locatedElement", "Located element " + message);
				return true;
			} catch (Exception e) {
				Thread.sleep(1000);
				if (time == seconds) {
					logger.error("Failed to locate element " + message);
					extent.extentLoggerFail("failedLocateElement", "Failed to locate element " + message);
				}
			}
		}
		return false;
	}
	
	/**
	 * Generic function to Logout.
	 */
	public void logout() throws Exception {
		extent.HeaderChildNode("Logout");
		verifyElementPresentAndClick(PWALandingPages.objWebProfileIcon, "Profile Icon");
		waitTime(3000);
		verifyElementPresentAndClick(PWAHamburgerMenuPage.objMyProfileOptionsWEB("Logout"), "Logout option");
		waitTime(3000);
		verifyElementNotPresent(PWAHamburgerMenuPage.objProfileIconWEB, 5);
		if (verifyElementPresent(PWALoginPage.objLoginBtnWEB, "Logout")) {
			logger.info("User successfuly logged out");
			extent.extentLogger("Log out", "User successfuly logged out");
		}
		click(PWAHomePage.objZeeLogo, "Home page");
	}

	public void verifySkipLoginEvent(String userType) throws Exception {
		if(userType.equalsIgnoreCase("Guest")) {
			extent.HeaderChildNode("Verify Skip Login Event");
			verifyElementPresentAndClick(PWALoginPage.objWebLoginBtn, "Login button");
			waitTime(3000);
			verifyElementPresentAndClick(PWALoginPage.objSkip, "Skip Login");
		}
	}
	
	public void verifySkipRegistrationEvent(String userType) throws Exception {
		if(userType.equalsIgnoreCase("Guest")) {
			extent.HeaderChildNode("Verify Skip Registration Event");
			verifyElementPresentAndClick(PWALoginPage.objSignUpBtnWEB, "Sign Up for Free button");
			waitTime(3000);
			verifyElementPresentAndClick(PWALoginPage.objCloseRegisterPopup, "Skip Registration");
		}
	}
	
	public void verifySkipRegistrationEventDuringContentPlayback(String userType,String keyword) throws Exception {
		extent.HeaderChildNode("Verify Skip Registration Event During Content Playback");
		if(userType.equalsIgnoreCase("Guest")) {
			click(PWAHomePage.objSearchBtn, "Search Icon");
			type(PWASearchPage.objSearchEditBox, keyword + "\n", "Search Edit box: " + keyword);
			waitTime(4000);
			waitForElement(PWASearchPage.objSearchResult(keyword), 10, "Search Result");
			click(PWASearchPage.objSearchResult(keyword), "Search Result");
			waitForElement(PWALoginPage.objCloseRegisterPopup,20, "Skip Registration");
			verifyElementPresentAndClick(PWALoginPage.objCloseRegisterPopup, "Skip Registration");
		}
	}
	
	public void verifySubscriptionPageViewedEvent(String userType,String keyword1,String keyword2) throws Exception {
		extent.HeaderChildNode("Verify Subscription Page Viewed Event");
		if(!(userType.equalsIgnoreCase("SubscribedUser"))) {
			verifyElementPresentAndClick(PWAHomePage.objSubscribeBtn, "Subscribe button");
			Back(1);
			verifyElementPresentAndClick(PWAHomePage.objHamburgerMenu, "Hamburger Menu");
			verifyElementPresentAndClick(PWAHamburgerMenuPage.objBuySubscription, "Buy Subscription option");
			Back(1);
			click(PWAHomePage.objHamburgerMenu, "Hamburger Menu");
			verifyElementPresentAndClick(PWAHamburgerMenuPage.objHaveAPrepaidCode, "Have a Prepaid Code? option");
			Back(1);
			click(PWAHomePage.objSearchBtn, "Search Icon");
			type(PWASearchPage.objSearchEditBox, keyword1 + "\n", "Search Edit box: " + keyword1);
			waitTime(4000);
			waitForElement(PWASearchPage.objSearchResult(keyword1), 10, "Search Result");
			click(PWASearchPage.objSearchResult(keyword1), "Search Result");
			waitForElement(PWAPlayerPage.objGetPremiumCTABelowPlayerScreen, 10, "Get Premium/Subscribe CTA below player");
			verifyElementPresentAndClick(PWAPlayerPage.objGetPremiumCTABelowPlayerScreen, "Get Premium/Subscribe CTA below player");
			Back(1);
//			
//			click(PWAHomePage.objSearchBtn, "Search Icon");
//			type(PWASearchPage.objSearchEditBox, keyword2 + "\n", "Search Edit box: " + keyword2);
//			waitTime(4000);
//			waitForElement(PWASearchPage.objSearchResult(keyword2), 10, "Search Result");
//			click(PWASearchPage.objSearchResult(keyword2), "Search Result");
			
			verifyElementPresentAndClick(PWASubscriptionPages.objHaveACode, "Have A Code section");
			type(PWASubscriptionPages.objHaveACode, "sdcrfd", "Prepaid Code");
			verifyElementPresentAndClick(PWASubscriptionPages.objApplyBtn, "Apply Button");
			waitTime(2000);
			verifyElementPresentAndClick(PWASubscriptionPages.objHaveACodeCloseBtn, "Close Button");
			verifyElementPresentAndClick(PWASubscriptionPages.objHaveACode, "Have A Code section");
			type(PWASubscriptionPages.objHaveACode, "PNB20", "Prepaid Code");
			verifyElementPresentAndClick(PWASubscriptionPages.objApplyBtn, "Apply Button");
			waitTime(2000);
			verifyElementPresentAndClick(PWASubscriptionPages.objContinueBtn, "Continue Button");
			waitTime(5000);
		}
	}
	
	public void verifyTVAuthenticationScreenDisplayEvent(String userType) throws Exception {
		if(!(userType.equalsIgnoreCase("Guest"))) {
			extent.HeaderChildNode("Verify TV Authentication Screen Display Event");
			click(PWAHomePage.objHamburgerMenu, "Hamburger Menu");
			waitTime(3000);
			verifyElementPresentAndClick(PWAHamburgerMenuPage.objAuthenticateDevice, "Authenticate Device");
			Back(1);
		}
	}
	
	
	public void facebookLogin() throws Exception {
		extent.HeaderChildNode("Login through Facebook");
		getWebDriver().get(URL);
		verifyElementPresentAndClick(PWALoginPage.objLoginBtnWEB, "Login button");

		waitForElementDisplayed(PWALoginPage.objFacebookIcon, 10);

		checkElementDisplayed(PWALoginPage.objGoogleIcon, "Google icon");
		waitTime(1000);
		checkElementDisplayed(PWALoginPage.objTwitterIcon, "Twitter icon");
	
		checkElementDisplayed(PWALoginPage.objFacebookIcon, "Facebook icon");

		waitTime(10000);
		click(PWALoginPage.objFacebookIcon, "Facebook Icon");
		switchToWindow(2);

		if (checkElementDisplayed(PWALandingPages.objWebProfileIcon, "Profile icon")) {
			logger.info("User Logged in Successfully");
			extent.extentLogger("Logged in", "User Logged in Successfully");

		}

		else {
			checkElementDisplayed(PWALoginPage.objFacebookPageVerificationWeb, "Facebook page");
			verifyElementPresent(PWALoginPage.objFacebookLoginEmailWeb, " Email Field");
			type(PWALoginPage.objFacebookLoginEmailWeb, "igstesttt@gmail.com", "Emial Field");
			verifyElementPresent(PWALoginPage.objFacebookLoginpasswordWeb, " Password Field");
			type(PWALoginPage.objFacebookLoginpasswordWeb, "Igs123!@#", "Password Field");
			verifyElementPresentAndClick(PWALoginPage.objFacebookLoginButtonInFbPageWeb, "Login Button");
			switchToWindow(1);
			waitForElementDisplayed(PWALandingPages.objWebProfileIcon, 20);
			if (verifyElementPresent(PWALandingPages.objWebProfileIcon, "Profile icon")) {
				logger.info("User Logged in Successfully");
				extent.extentLogger("Logged in", "User Logged in Successfully");
			}
		}
		logout();
	}
	
	public void phoneNumberRegistration() throws Exception {
		extent.HeaderChildNode(
				"verifing that user is able to enter Mobile number, Password, date of birth, gender in Registration page");
		click(PWALoginPage.objSignUpBtnWEB, "Sign up button");
		waitForElementDisplayed(PWALoginPage.objEmailField, 5);
		checkElementDisplayed(PWALoginPage.objEmailField, "Email/PhoneNo Field");
		type(PWALoginPage.objEmailField, "7892215", "PhoneNumber Field");
		String PhoneNumberField = getText(PWALoginPage.objEmailField);
		if (PhoneNumberField != null) {
			logger.info("User is allowed to enter PhoneNumber");
			extentLogger("PhoneNumber", "User is allowed to enter PhoneNumber in PhoneNumber Field");
		}
		checkElementDisplayed(PWALoginPage.objIncorrectPhoneNumberMessage,
				"When User Enter Invalid PhoneNumber, Error Message");
		type(PWALoginPage.objEmailField, "214", "PhoneNumber Field");
		if (checkElementDisplayed(PWALoginPage.objIncorrectPhoneNumberMessage, "PhoneNumber Error Message") == false) {
			logger.info("User is allowed to enter valid PhoneNumber");
			extent.extentLogger("PhoneNumber", "User is allowed to enter valid PhoneNumber");
		}
		checkElementDisplayed(PWALoginPage.objCountryCode, "Country code field");
		click(PWALoginPage.objCountryCode, "Country code field");
		checkElementDisplayed(PWALoginPage.objCountryCodeDropDown, "Drop down of country code");
		click(PWALoginPage.objCountryCodeAlgeria, "Algeria country code");
		click(PWALoginPage.objCountryCode, "Country code field");
		click(PWALoginPage.objCountryCodeAndoora, "Andoora country code");
		click(PWALoginPage.objCountryCode, "Country code field");
		click(PWALoginPage.objCountryCodeIndia, "India country code");

		if (getWebDriver().findElement(PWASignupPage.objSignUpButtonHighlightedWeb).isEnabled()) {
			logger.info("SignUp button is highlighted");
			extent.extentLogger("Continue button", "SignUp button is highlighted");
		}
		click(PWASignupPage.objSignUpButtonHighlightedWeb, "SignUp Button");
		extent.HeaderChildNode(
				"Verifing that user is allowed to update the mobile number, password, date of birth and gender post navigating back from change number button");
		waitTime(10000);
		click(PWASignupPage.objChangeNumberLink, "Change number link");
		waitTime(5000);
		type(PWALoginPage.objEmailField, "7892215214", "PhoneNumber Field");
		click(PWASignupPage.objSignUpButtonHighlightedWeb, "Continue Button");
		extent.HeaderChildNode("verifing OTP Screen");
		waitForElementDisplayed(PWASignupPage.objOTPTimer, 5);
		checkElementDisplayed(PWASignupPage.objOTPTimer, "OTP timer");
		String otpTimer1 = getText(PWASignupPage.objOTPTimer);
		String OtpTimer1 = otpTimer1.substring(3);
		int otp1 = Integer.parseInt(OtpTimer1);
		System.out.println(otp1);
		waitTime(6000);
		String otpTimer2 = getText(PWASignupPage.objOTPTimer);
		String OtpTimer2 = otpTimer2.substring(3);
		int otp2 = Integer.parseInt(OtpTimer2);
		System.out.println(otp2);
		if (!otpTimer1.equals(otpTimer2)) {
			logger.info("The Otp timer is in reverse order");
			extentLogger("OtpTimer", "The Otp timer is in reverse order");
		}
		waitTime(60000);
		if (verifyElementPresent(PWASignupPage.objResendOtpOption, "Resend button")) {
			logger.info("ResendOtp option is active after 60seconds");
			extent.extentLogger("ResendOtp", "ResendOtp option is active after 60seconds");
		}
		type(PWASignupPage.objOTP1, "a", "OTP box1");
		type(PWASignupPage.objOTP2, "b", "OTP box2");
		type(PWASignupPage.objOTP3, "c", "OTP box3");
		type(PWASignupPage.objOTP4, "d", "OTP box4");
		waitTime(2000);
		if (getWebDriver().findElement(PWASignupPage.objSignUpButtonHighlighted).isEnabled() == false) {
			logger.info("Verify Button is not highlighted when user enter non numeric value in otp section");
			extent.extentLogger("Verify",
					"Verify Button is not highlighted when user enter non numeric value in otp section");
		}
		type(PWASignupPage.objOTP1, "1", "OTP box1");
		type(PWASignupPage.objOTP2, "2", "OTP box2");
		type(PWASignupPage.objOTP3, "3", "OTP box3");
		type(PWASignupPage.objOTP4, "4", "OTP box4");
		waitTime(3000);
		if (getWebDriver().findElement(PWASignupPage.objVerifyBtnWeb).isEnabled() == true) {
			logger.info("Verify Button is highlighted");
			extent.extentLogger("Verify", "Verify Button is highlighted");
			verifyElementPresentAndClick(PWASignupPage.objVerifyBtnWeb, "Verified Button");
			try {
				Boolean Message = getWebDriver().findElement(By.xpath("//*[@class='toastMessage']")).isDisplayed();
				if (Message == true) {
					extent.extentLogger("Toast", "Toast message displayed");
					logger.info("Toast message displayed");
				} else {
					System.out.println("Toast message is not displayed");
				}
			} catch (Exception e) {
				System.out.println("Toast message is not displayed");
			}
		}
		Back(2);
	}
	
	public void twitterLogin() throws Exception {
		extent.HeaderChildNode("Login through Twitter");

		verifyElementPresentAndClick(PWALoginPage.objLoginBtnWEB, "Login button");
		waitForElementDisplayed(PWALoginPage.objLoginPageheader, 10);

		waitForElementDisplayed(PWALoginPage.objTwitterIcon, 10);
		checkElementDisplayed(PWALoginPage.objTwitterIcon, "Twitter icon");
		waitTime(1000);

		click(PWALoginPage.objTwitterIcon, "twitter Icon");
		switchToWindow(2);

		if (checkElementDisplayed(PWALandingPages.objWebProfileIcon, "Profile icon")) {
			logger.info("User Logged in Successfully");
			extent.extentLogger("Logged in", "User Logged in Successfully");
			logout();

		}

		else {
			verifyElementPresent(PWALoginPage.objTwitterEmaildField, " Email Field");
			type(PWALoginPage.objTwitterEmaildField, "Zee5latest@gmail.com", "Emial Field");

			verifyElementPresent(PWALoginPage.objTwitterPasswordField, " Password Field");
			type(PWALoginPage.objTwitterPasswordField, "User@123", "Password Field");

			verifyElementPresentAndClick(PWALoginPage.objTwitterSignInButton, "Login Button");
			getWebDriver().close();
			switchToParentWindow();
			waitForElementDisplayed(PWALandingPages.objWebProfileIcon, 20);
			if (checkElementDisplayed(PWALandingPages.objWebProfileIcon, "Profile icon")) {
				logger.info("User Logged in Successfully");
				extent.extentLogger("Logged in", "User Logged in Successfully");
				logout();
			} else {
				logger.info("User is not logged in Successfully");
				extent.extentLoggerFail("Logged in", "User is not logged in Successfully");
				Back(1);
			}
		}

	}

	public void verifyLoginInitiatedEventForValidCredentials(String userType) throws Exception {
		if(userType.equalsIgnoreCase("Guest")) {
			extent.HeaderChildNode("Verify Login Initiated Event for Valid Credentials");
			twitterLogin();
			facebookLogin();
			phoneNumberRegistration();
		}
	}
}
