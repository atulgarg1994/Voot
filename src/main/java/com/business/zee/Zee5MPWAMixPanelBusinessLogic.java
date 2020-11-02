package com.business.zee;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import com.driverInstance.CommandBase;
import com.extent.ExtentReporter;
import com.mixpanelValidation.Mixpanel;
import com.propertyfilereader.PropertyFileReader;
import com.utility.LoggingUtils;
import com.utility.Utilities;
import com.zee5.PWAPages.PWAHamburgerMenuPage;
import com.zee5.PWAPages.PWAHomePage;
import com.zee5.PWAPages.PWALoginPage;
import com.zee5.PWAPages.PWAPremiumPage;
import com.zee5.PWAPages.PWASearchPage;
import com.zee5.PWAPages.PWASignupPage;
import com.zee5.PWAPages.PWASubscriptionPages;

public class Zee5MPWAMixPanelBusinessLogic  extends Utilities {
	
	public Zee5MPWAMixPanelBusinessLogic(String Application) throws InterruptedException {
		new CommandBase(Application);
		init();
	}

	private int timeout;

	/** Retry Count */
	private int retryCount;

	ExtentReporter extent = new ExtentReporter();
	
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
	
	Mixpanel mixpanel = new Mixpanel();
	
	static LoggingUtils logger = new LoggingUtils();
	
	public void init() {

		PropertyFileReader handler = new PropertyFileReader("properties/Execution.properties");
		setTimeout(Integer.parseInt(handler.getproperty("TIMEOUT")));
		setRetryCount(Integer.parseInt(handler.getproperty("RETRY_COUNT")));
		logger.info(
				"Loaded the following properties" + " TimeOut :" + getTimeout() + " RetryCount :" + getRetryCount());
	}

	
	/**
	 * Generic function to click on the Player.
	 */

	public void playerClick(By byLocator, String validationtext) throws Exception {
		try {
			WebElement element = findElement(byLocator);
			element.click();
			logger.info("Clicked on the" + validationtext);
			extent.extentLogger("click", "Clicked on the " + " " + validationtext);
		} catch (Exception e) {
			logger.error(e);
		}
	}

	/**
	 * The method s for element and clicks if present. Returns no error if not
	 * present. Implemented for random popups
	 */
	public boolean waitForElementAndClickIfPresent(By locator, int seconds, String message)
			throws InterruptedException {
		for (int time = 0; time <= seconds; time++) {
			try {
				getDriver().findElement(locator).click();
				logger.info("Clicked element " + message);
				extent.extentLogger("clickedElement", "Clicked element " + message);
				return true;
			} catch (Exception e) {
				Thread.sleep(1000);
			}
		}
		return false;
	}

	/**
	 * Function to quit the driver
	 */
	public void tearDown() {
		getDriver().quit();
	}

	
	public void ZeePWALogin(String LoginMethod, String userType) throws Exception {
		String url = getParameterFromXML("url");
		extent.HeaderChildNode("User-Type : " + userType + ", Environment: " + url);
		// Get the email and password from properties
		String email = "";
		String password = "";
		// dismissSystemPopUp();
		// waitTime(3000);
		// dismissSystemPopUp();
		// dismissAppInstallPopUp();
		// dismissStayTundedPopUp();
		// dismiss3xPopUp();
		// dismissDisplayContentLanguagePopUp();
		// dismissSystemPopUp();
		dismissAllPopUps();
		if (userType.equalsIgnoreCase("Guest")) {
			extent.extentLogger("Guest", "Accessing the application as Guest user");
		} else if (userType.equalsIgnoreCase("SubscribedUser")) {
			extent.extentLogger("Subscribed", "Accessing the application as Subscribed user");
			email = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("SubscribedUserName");
			password = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("SubscribedPassword");
		} else if (userType.equalsIgnoreCase("NonSubscribedUser")) {
			extent.extentLogger("Non-Subscribed", "Accessing the application as Non-Subscribed user");
			email = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("NonsubscribedUserName");
			password = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("NonsubscribedPassword");
		}
		if (userType.equalsIgnoreCase("SubscribedUser") || userType.equalsIgnoreCase("NonSubscribedUser")) {
			if (!checkElementDisplayed(PWALoginPage.objLoginBtn, "Login Button")) {
				verifyElementPresentAndClick(PWAHomePage.objHamburgerMenu, "Hamburger Menu");
			}
			waitTime(3000);
			click(PWALoginPage.objLoginBtn, "Login button");
			waitTime(3000);
			HeaderChildNode("Login - Method" + LoginMethod);
			switch (LoginMethod) {

			case "E-mail":
				dismissAppInstallPopUp();
				verifyElementPresentAndClick(PWALoginPage.objEmailField, "Email field");
				waitTime(10000);
				// getDriver().getKeyboard().sendKeys("Bla bla");//works
				type(PWALoginPage.objEmailField, email, "Email Field");
				hideKeyboard();
				waitTime(3000);
				dismissSystemPopUp();
				verifyElementPresentAndClick(PWALoginPage.objPasswordField, "Password Field");
				type(PWALoginPage.objPasswordField, password + "\n", "Password field");
				hideKeyboard();
				waitTime(5000);
				directClickReturnBoolean(PWALoginPage.objLoginBtnLoginPage, "Login Button");
				waitTime(10000);
				break;

			case "Mobile":
				verifyElementPresentAndClick(PWALoginPage.objEmailField, "Email field");
				type(PWALoginPage.objEmailField, "8792396107\n", "Email Field");
				hideKeyboard();
				verifyElementPresentAndClick(PWALoginPage.objLoginBtn, "Login butotn");
				waitTime(3000);
				hideKeyboard();
				waitTime(5000);
				verifyElementPresentAndClick(PWALoginPage.objpasswordphno, "Password field");
				waitTime(3000);
				verifyElementPresentAndClick(PWALoginPage.objPasswordField, "password-field");
				type(PWALoginPage.objPasswordField, "tanisha19\n", "password-field");
				hideKeyboard();
				waitTime(2000);
				click(PWALoginPage.objproceedphno, "Proceed button");
				waitTime(5000);
				break;

			case "Facebook":
				extent.HeaderChildNode("Login through Facebook");
				verifyElementPresentAndClick(PWALoginPage.objFacebookIcon, "Facebook Icon");
				System.out.println(getDriver().getCurrentUrl());
				System.out.println(getDriver().getWindowHandles());
				getDriver().switchTo().window("CDwindow-1");
				waitTime(7000);
				if (verifyIsElementDisplayed(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger")) {
					click(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
					verifyElementPresent(PWAHamburgerMenuPage.objProfilePageIcon, "Profile icon");
					logger.info("User Logged in Successfully");
					extent.extentLogger("Logged in", "User Logged in Successfully");
				}

				else if (verifyIsElementDisplayed(PWALoginPage.objFacebookPageVerification, "Facebook page")) {
					verifyElementPresent(PWALoginPage.objFacebookPageVerification, "Facebook page");
					verifyElementPresent(PWALoginPage.objFacebookLoginEmail, " Email Field");
					type(PWALoginPage.objFacebookLoginEmail, "igszeetesttest@gmail.com", "Emial Field");
					verifyElementPresent(PWALoginPage.objFacebookLoginpassword, " Password Field");
					type(PWALoginPage.objFacebookLoginpassword, "Igs$123Zee\n", "Password Field");
					verifyElementPresentAndClick(PWALoginPage.objFacebookLoginButtonInFbPage, " Login Button");
					waitTime(9000);
					getDriver().switchTo().window("CDwindow-0");
					verifyIsElementDisplayed(PWALoginPage.objFbCountinueBtn, "Continue button");
					if (verifyIsElementDisplayed(PWASignupPage.objSignUpTxt, "SignUp")) {
						regestrationfromSocialMedia();
						verifyElementPresent(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
						click(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
						verifyElementPresent(PWAHamburgerMenuPage.objProfilePageIcon, "Profile icon");
						logger.info("User Logged in Successfully");
						extent.extentLogger("Logged in", "User Logged in Successfully");
					} else {
						waitTime(3000);
						verifyElementPresent(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
						click(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
						verifyElementPresent(PWAHamburgerMenuPage.objProfileIcon, "Profile icon");
						logger.info("User Logged in Successfully");
						extent.extentLogger("Logged in", "User Logged in Successfully");
					}

				} else if (verifyElementPresent(PWALoginPage.objFbCountinueBtn, "Continue button") == true) {
					click(PWALoginPage.objFbCountinueBtn, "Continue fb");
					if (verifyElementPresent(PWASignupPage.objSignUpTxt, "SignUp") == true) {
						regestrationfromSocialMedia();
						verifyElementPresent(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
						click(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
						verifyElementPresent(PWAHamburgerMenuPage.objProfilePageIcon, "Profile icon");
						logger.info("User Logged in Successfully");
						extent.extentLogger("Logged in", "User Logged in Successfully");
					} else {
						waitTime(7000);
						verifyElementPresent(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
						click(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
						verifyElementPresent(PWAHamburgerMenuPage.objProfilePageIcon, "Profile icon");
						logger.info("User Logged in Successfully");
						extent.extentLogger("Logged in", "User Logged in Successfully");
					}
				}

				break;

			case "Gmail":
				extent.HeaderChildNode("Login through Gmail");
				System.out.println(getDriver().getCurrentUrl());
				System.out.println(getDriver().getWindowHandles());
				verifyElementPresentAndClick(PWALoginPage.objGoogleIcon, "Google Icon");
				getDriver().switchTo().window("CDwindow-1");
				waitTime(4000);
				if (verifyIsElementDisplayed(PWALoginPage.objGmailEmailField, " Email Field")) {
					type(PWALoginPage.objGmailEmailField, "Zee5latest@gmail.com", "Emial Field");
					hideKeyboard();
					verifyElementPresentAndClick(PWALoginPage.objGmailNextButton, "clicked on next button");
					waitTime(3000);
					verifyElementPresent(PWALoginPage.objGmailPasswordField, " Password Field");
					type(PWALoginPage.objGmailPasswordField, "User@123\n", "Password Field");
					hideKeyboard();
					verifyElementPresentAndClick(PWALoginPage.objGmailNextButton, "clicked on next button");
					waitTime(5000);
					getDriver().switchTo().window("CDwindow-0");
					if (verifyIsElementDisplayed(PWASignupPage.objSignUpTxt, "signup")) {
						regestrationfromSocialMedia();
					}
					waitTime(5000);
					verifyElementPresent(PWAHomePage.objZeeLogo, "Zee logo");
					logger.info("User is Logged in successfully");
					extent.extentLogger("Logged in", "User is Logged in successfully");
				} else {
					waitTime(10000);
					verifyElementPresent(PWAHomePage.objZeeLogo, "Zee logo");
					logger.info("User is Logged in successfully");
					extent.extentLogger("Logged in", "User is Logged in successfully");
				}

				break;

			case "Twitter":
				extent.HeaderChildNode("Login through Twitter");
				verifyElementPresentAndClick(PWALoginPage.objTwitterIcon, "Twitter icon");
				waitTime(7000);
				System.out.println(getDriver().getWindowHandles());
				System.out.println(getDriver().getCurrentUrl());
				getDriver().switchTo().window("CDwindow-1");

				waitTime(5000);
				System.out.println(getDriver().getCurrentUrl());

				if (verifyIsElementDisplayed(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger")) {
					verifyElementPresentAndClick(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
					verifyElementPresent(PWAHamburgerMenuPage.objProfilePageIcon, "Profile icon");
					logger.info("User Logged in Successfully");
					extent.extentLogger("Logged in", "User Logged in Successfully");
				}

				else if (verifyIsElementDisplayed(PWALoginPage.objTwitterAuthorizeButton, "Authorize app")) {
					click(PWALoginPage.objTwitterAuthorizeButton, "Authorize app");
					regestrationfromSocialMedia();
				} else if (verifyIsElementDisplayed(PWALoginPage.objTwitterEmaildField, "Twitter Email field")) {

					type(PWALoginPage.objTwitterEmaildField, "Zee5latest@gmail.com", "Email Field");
					hideKeyboard();
					verifyElementPresentAndClick(PWALoginPage.objTwitterPasswordField, "Twitter Password field");
					type(PWALoginPage.objTwitterPasswordField, "User@123\n", "Password field");
					click(PWALoginPage.objTwitterSignInButton, "Sign in button");
					waitTime(5000);
					verifyElementPresentAndClick(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
					click(PWAHamburgerMenuPage.objLoginBtn, "Login");
					verifyElementPresentAndClick(PWALoginPage.objTwitterIcon, "Twitter icon");
				}

				if (verifyIsElementDisplayed(PWALoginPage.objTwitterAuthorizeButton, "Authorize")) {
					click(PWALoginPage.objTwitterAuthorizeButton, "Authorize");
					waitTime(7000);
					verifyElementPresentAndClick(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
					verifyElementPresent(PWAHamburgerMenuPage.objProfilePageIcon, "Profile icon");
					logger.info("User Logged in Successfully");
					extent.extentLogger("Logged in", "User Logged in Successfully");
				}
				break;
			}
		}
		dismiss3xPopUp();
		dismissAppInstallPopUp();
	}
	
	
	public void dismiss3xPopUp() throws Exception {
		String url = getParameterFromXML("url");
		if (!url.contains("newpwa")) {
			getDriver().context("NATIVE_APP");
			waitTime(3000);
			directClickReturnBoolean(PWAHomePage.obj3xfasterPopUpNoThanks, "NO THANKS in 3x Pop Up");
			getDriver().context("CHROMIUM");
		}
	}

	public void dismissAppInstallPopUp() throws Exception {
		directClickReturnBoolean(PWAHomePage.objAppInstallPopUpClose, "Close in App Install Pop Up");
	}

	public void dismissStayTundedPopUp() throws Exception {
		directClickReturnBoolean(PWAHomePage.objStayTunedPopUpClose, "Close in Stay Tuned Pop Up");
	}
	
	public boolean directClickReturnBoolean(By byLocator, String validationtext) throws Exception {
		try {
			WebElement element = (new WebDriverWait(getDriver(), 1))
					.until(ExpectedConditions.presenceOfElementLocated(byLocator));
			if (element.isDisplayed() == true) {
				element.click();
				logger.info("Clicked on " + validationtext);
				extent.extentLogger("click", "Clicked on " + validationtext);
				element = null;
				return true;
			}
		} catch (Exception e) {
		}
		return false;
	}

	public void dismissSystemPopUp() throws Exception {
		getDriver().context("NATIVE_APP");
		directClickReturnBoolean(PWASearchPage.objallow, "Allow in pop up");
		getDriver().context("CHROMIUM");
	}

	public void dismissAllPopUps() throws Exception {
		for (int trial = 0; trial < 8; trial++) {
			if (directClickReturnBoolean(PWAHomePage.objAppInstallPopUpClose, "Close in App Install Pop Up"))
				break;
			waitTime(5000);
		}
		for (int trial = 0; trial < 2; trial++) {
			try {
				waitTime(5000);
				getDriver().context("NATIVE_APP");
				directClickReturnBoolean(PWASearchPage.objallow, "Allow in pop up");
				getDriver().context("CHROMIUM");
				directClickReturnBoolean(PWAHomePage.objAppInstallPopUpClose, "Close in App Install Pop Up");
				directClickReturnBoolean(PWAHomePage.objStayTunedPopUpClose, "Close in Stay Tuned Pop Up");
				WebElement displayContentLang = (new WebDriverWait(getDriver(), 60))
						.until(ExpectedConditions.elementToBeClickable(PWAHomePage.objContinueDisplayContentLangPopup));
				if (displayContentLang.isDisplayed() == true) {
					if (directClickReturnBoolean(PWAHomePage.objContinueDisplayContentLangPopup,
							"Continue on Display Language Pop Up")) {
						dismissSystemPopUp();
						waitTime(3000);
						directClickReturnBoolean(PWAHomePage.objContinueDisplayContentLangPopup,
								"Continue on Content Language Pop Up");
						break;
					}
				}
			} catch (Exception e) {
			}
		}
	}

	public void regestrationfromSocialMedia() throws Exception {
		extent.HeaderChildNode("Regestration Screen");
		click(PWASignupPage.objDayPickerTab, "Day Tab");
		verifyElementPresentAndClick(PWASignupPage.objDayPickerTabValue, "Day option");
		verifyElementPresentAndClick(PWASignupPage.objMonthPickerTab, "Month Tab");
		verifyElementPresentAndClick(PWASignupPage.objMonthPickerTabValue, "Month option");
		verifyElementPresentAndClick(PWASignupPage.objYearPickerTab, "year Tab");
		verifyElementPresentAndClick(PWASignupPage.objYearPickerTabValue, "year option");
		verifyElementPresentAndClick(PWASignupPage.objGenderMaleBtn, "Gender tab");
		verifyElementPresentAndClick(PWALoginPage.objSignUpBtn, "signUp button");
		waitTime(10000);
		verifyElementPresent(PWAHomePage.objZeeLogo, "Zee logo");
		logger.info("User Logged in Successfully");
		extent.extentLogger("Logged in", "User Logged in Successfully");
	}
		
	@SuppressWarnings("static-access")
	public void verifyLoginScreenDisplayEventByClickingOnLoginButton(String userType) throws Exception {
		if (userType.equalsIgnoreCase("Guest")) {
			extent.HeaderChildNode("Verify Skip Login Event");
			waitTime(5000);
			click(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
			waitTime(3000);
			click(PWALoginPage.objLoginBtn, "Login button");
			
			waitTime(5000);
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			String token = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
			System.out.println(token);
	
			mixpanel.FEProp.setProperty("Source", "home");
			mixpanel.FEProp.setProperty("Page Name", "sign_in");
			mixpanel.ValidateParameter(token, "Login Screen Display");
		}
	}
	
	@SuppressWarnings("static-access")
	public void verifyLoginScreenDisplayEventByClickingOnLoginButtonOnPlayer(String userType, String keyword2)
			throws Exception {
		if (userType.equalsIgnoreCase("Guest")) {
			extent.HeaderChildNode("Verify Login Screen Display Event By Clicking On Login Button On Player");

			click(PWAHomePage.objSearchBtn, "Search Icon");
			type(PWAHomePage.objSearchField, keyword2, "Search");
			waitTime(5000);
			click(PWASearchPage.objSearchedResult(keyword2), "Search Result");
			waitTime(6000);
			
			if (checkElementDisplayed(PWAHamburgerMenuPage.objGetPremiumPopup, "GET PREMIUM POPUP") == true) {
				verifyElementPresentAndClick(PWAHamburgerMenuPage.objPopupClose, "POP-UP CLOSE BUTTON");
			}
			verifyElementPresent(PWASubscriptionPages.objLoginLinkInPlayer, "Login link");
			JSClick(PWASubscriptionPages.objLoginLinkInPlayer, "Login link");
			waitTime(2000);
			Back(1);
			if (checkElementDisplayed(PWAHamburgerMenuPage.objGetPremiumPopup, "GET PREMIUM POPUP") == true) {
				verifyElementPresentAndClick(PWAHamburgerMenuPage.objPopupClose, "POP-UP CLOSE BUTTON");
			}
			waitTime(3000);
			
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			String token = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
			System.out.println(token);
	
			mixpanel.FEProp.setProperty("Source", "movie_detail");
			mixpanel.FEProp.setProperty("Page Name", "sign_in");
			mixpanel.ValidateParameter(token, "Login Screen Display");
		}
	}

	@SuppressWarnings("static-access")
	public void verifyLoginScreenDisplayEventByClickingOnLoginButtonInRegistartionScreen(String userType)
			throws Exception {
		if (userType.equalsIgnoreCase("Guest")) {
			extent.HeaderChildNode(
					"Verify Login Screen Display Event By Clicking On Login Button In Registartion Screen");
			click(PWALoginPage.objSignUpBtnWEB, "Sign Up For Free");
			JSClick(PWALoginPage.objLoginLink, "Login link");
			Back(1);
			waitTime(2000);
			
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			String token = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
			System.out.println(token);
	
			mixpanel.FEProp.setProperty("Source", "home");
			mixpanel.FEProp.setProperty("Page Name", "sign_in");
			mixpanel.ValidateParameter(token, "Login Screen Display");
		}
	}

	@SuppressWarnings("static-access")
	public void verifyLoginScreenDisplayEventByClickingOnLoginButtonInGetPremiumPopUp(String userType, String keyword2)
			throws Exception {
		if (userType.equalsIgnoreCase("Guest")) {
			extent.HeaderChildNode(
					"Verify Login Screen Display Event By Clicking On Login Button In Get Premium Pop Up");

			click(PWAHomePage.objSearchBtn, "Search Icon");
			type(PWAHomePage.objSearchField, keyword2, "Search");
			waitTime(5000);
			click(PWASearchPage.objSearchedResult(keyword2), "Search Result");
			waitTime(6000);
			

			if (checkElementDisplayed(PWAHamburgerMenuPage.objGetPremiumPopup, "GET PREMIUM POPUP") == true) {
				verifyElementPresentAndClick(PWALoginPage.objLoginCTAInPremiumPopup, "Login link");
				Back(1);
			}
			waitTime(2000);
		
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			String token = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
			System.out.println(token);
	
			mixpanel.FEProp.setProperty("Source", "movie_detail");
			mixpanel.FEProp.setProperty("Page Name", "sign_in");
			mixpanel.ValidateParameter(token, "Login Screen Display");
		}
	}
	
	public void verifyLoginScreenDisplayEventByClickingOnLoginInRegistrationPopUp(String userType, String keyword)
			throws Exception {
		if (userType.equalsIgnoreCase("Guest")) {

			extent.HeaderChildNode(
					"Verify Login Screen Display Event during content playback post clicking on login in registration popup");
			click(PWAHomePage.objSearchBtn, "Search Icon");
			type(PWASearchPage.objSearchEditBox, keyword + "\n", "Search Edit box: " + keyword);
			waitTime(4000);
			waitForElement(PWASearchPage.objSearchResult(keyword), 10, "Search Result");
			click(PWASearchPage.objSearchResult(keyword), "Search Result");
			click(PWAPremiumPage.obj1stContentInShowDetailPage, "Content Card");
			waitForElement(PWALoginPage.objLoginLink, 20, "Login Link");
			click(PWALoginPage.objLoginLink, "Login Link");
			waitTime(5000);
			
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			String token = js.executeScript("return window.localStorage.getItem('guestToken');").toString();
			System.out.println(token);
	
			mixpanel.FEProp.setProperty("Source", "show_detail");
			mixpanel.FEProp.setProperty("Page Name", "sign_in");
			mixpanel.ValidateParameter(token, "Login Screen Display");
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
				getDriver().findElement(locator);
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
		click(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger menu");
		waitTime(2000);
		click(PWAHamburgerMenuPage.objDownArrow("My Account"), "Expander button");
		PartialSwipe("UP", 1);
		click(PWAHamburgerMenuPage.objExploreItemBtn("Logout"), "Logout option");
		waitTime(3000);
	}
	
	public void verifyLogoutEvent(String userType) throws Exception {
		if (!(userType.equalsIgnoreCase("Guest"))) {
			extent.HeaderChildNode("Verify Logout Event");
			waitTime(10000);
			
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			String ID = js.executeScript("return window.localStorage.getItem('ID');").toString();
			System.out.println(ID);
			mixpanel.FEProp.setProperty("Element", "LOGOUT");
			mixpanel.FEProp.setProperty("Page Name", "home");
			
			logout();
			waitTime(5000);
			mixpanel.ValidateParameter(ID, "Logout");
		}
	}
	
	
	

	public void login(String LoginMethod, String userType) throws Exception {
		String url = getParameterFromXML("url");
		extent.HeaderChildNode("User-Type : " + userType + ", Environment: " + url);
		// Get the email and password from properties
		String email = "";
		String password = "";
		// dismissSystemPopUp();
		// waitTime(3000);
		// dismissSystemPopUp();
		// dismissAppInstallPopUp();
		// dismissStayTundedPopUp();
		// dismiss3xPopUp();
		// dismissDisplayContentLanguagePopUp();
		// dismissSystemPopUp();
		dismissAllPopUps();
		if (userType.equalsIgnoreCase("Guest")) {
			extent.extentLogger("Guest", "Accessing the application as Guest user");
		} else if (userType.equalsIgnoreCase("SubscribedUser")) {
			extent.extentLogger("Subscribed", "Accessing the application as Subscribed user");
			email = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("SubscribedUserName");
			password = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("SubscribedPassword");
		} else if (userType.equalsIgnoreCase("NonSubscribedUser")) {
			extent.extentLogger("Non-Subscribed", "Accessing the application as Non-Subscribed user");
			email = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("NonsubscribedUserName");
			password = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("NonsubscribedPassword");
		}
		if (userType.equalsIgnoreCase("SubscribedUser") || userType.equalsIgnoreCase("NonSubscribedUser")) {
			if (!checkElementDisplayed(PWALoginPage.objLoginBtn, "Login Button")) {
				verifyElementPresentAndClick(PWAHomePage.objHamburgerMenu, "Hamburger Menu");
			}
			waitTime(3000);
			click(PWALoginPage.objLoginBtn, "Login button");
			waitTime(3000);
			HeaderChildNode("Login - Method" + LoginMethod);
			switch (LoginMethod) {

			case "E-mail":
				dismissAppInstallPopUp();
				verifyElementPresentAndClick(PWALoginPage.objEmailField, "Email field");
				waitTime(10000);
				// getDriver().getKeyboard().sendKeys("Bla bla");//works
				type(PWALoginPage.objEmailField, email, "Email Field");
				hideKeyboard();
				waitTime(3000);
				dismissSystemPopUp();
				verifyElementPresentAndClick(PWALoginPage.objPasswordField, "Password Field");
				type(PWALoginPage.objPasswordField, password + "\n", "Password field");
				hideKeyboard();
				waitTime(5000);
				directClickReturnBoolean(PWALoginPage.objLoginBtnLoginPage, "Login Button");
				waitTime(10000);
				break;

			case "Mobile":
				verifyElementPresentAndClick(PWALoginPage.objEmailField, "Email field");
				type(PWALoginPage.objEmailField, "8792396107\n", "Email Field");
				hideKeyboard();
				verifyElementPresentAndClick(PWALoginPage.objLoginBtn, "Login butotn");
				waitTime(3000);
				hideKeyboard();
				waitTime(5000);
				verifyElementPresentAndClick(PWALoginPage.objpasswordphno, "Password field");
				waitTime(3000);
				verifyElementPresentAndClick(PWALoginPage.objPasswordField, "password-field");
				type(PWALoginPage.objPasswordField, "tanisha19\n", "password-field");
				hideKeyboard();
				waitTime(2000);
				click(PWALoginPage.objproceedphno, "Proceed button");
				waitTime(5000);
				break;

			case "Facebook":
				extent.HeaderChildNode("Login through Facebook");
				verifyElementPresentAndClick(PWALoginPage.objFacebookIcon, "Facebook Icon");
				System.out.println(getDriver().getCurrentUrl());
				System.out.println(getDriver().getWindowHandles());
				getDriver().switchTo().window("CDwindow-1");
				waitTime(7000);
				if (verifyIsElementDisplayed(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger")) {
					click(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
					verifyElementPresent(PWAHamburgerMenuPage.objProfilePageIcon, "Profile icon");
					logger.info("User Logged in Successfully");
					extent.extentLogger("Logged in", "User Logged in Successfully");
				}

				else if (verifyIsElementDisplayed(PWALoginPage.objFacebookPageVerification, "Facebook page")) {
					verifyElementPresent(PWALoginPage.objFacebookPageVerification, "Facebook page");
					verifyElementPresent(PWALoginPage.objFacebookLoginEmail, " Email Field");
					type(PWALoginPage.objFacebookLoginEmail, "igszeetesttest@gmail.com", "Emial Field");
					verifyElementPresent(PWALoginPage.objFacebookLoginpassword, " Password Field");
					type(PWALoginPage.objFacebookLoginpassword, "Igs$123Zee\n", "Password Field");
					verifyElementPresentAndClick(PWALoginPage.objFacebookLoginButtonInFbPage, " Login Button");
					waitTime(9000);
					getDriver().switchTo().window("CDwindow-0");
					verifyIsElementDisplayed(PWALoginPage.objFbCountinueBtn, "Continue button");
					if (verifyIsElementDisplayed(PWASignupPage.objSignUpTxt, "SignUp")) {
						regestrationfromSocialMedia();
						verifyElementPresent(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
						click(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
						verifyElementPresent(PWAHamburgerMenuPage.objProfilePageIcon, "Profile icon");
						logger.info("User Logged in Successfully");
						extent.extentLogger("Logged in", "User Logged in Successfully");
					} else {
						waitTime(3000);
						verifyElementPresent(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
						click(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
						verifyElementPresent(PWAHamburgerMenuPage.objProfileIcon, "Profile icon");
						logger.info("User Logged in Successfully");
						extent.extentLogger("Logged in", "User Logged in Successfully");
					}

				} else if (verifyElementPresent(PWALoginPage.objFbCountinueBtn, "Continue button") == true) {
					click(PWALoginPage.objFbCountinueBtn, "Continue fb");
					if (verifyElementPresent(PWASignupPage.objSignUpTxt, "SignUp") == true) {
						regestrationfromSocialMedia();
						verifyElementPresent(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
						click(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
						verifyElementPresent(PWAHamburgerMenuPage.objProfilePageIcon, "Profile icon");
						logger.info("User Logged in Successfully");
						extent.extentLogger("Logged in", "User Logged in Successfully");
					} else {
						waitTime(7000);
						verifyElementPresent(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
						click(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
						verifyElementPresent(PWAHamburgerMenuPage.objProfilePageIcon, "Profile icon");
						logger.info("User Logged in Successfully");
						extent.extentLogger("Logged in", "User Logged in Successfully");
					}
				}

				break;

		
			case "Twitter":
				extent.HeaderChildNode("Login through Twitter");
				verifyElementPresentAndClick(PWALoginPage.objTwitterIcon, "Twitter icon");
				waitTime(7000);
				System.out.println(getDriver().getWindowHandles());
				System.out.println(getDriver().getCurrentUrl());
				getDriver().switchTo().window("CDwindow-1");

				waitTime(5000);
				System.out.println(getDriver().getCurrentUrl());

				if (verifyIsElementDisplayed(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger")) {
					verifyElementPresentAndClick(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
					verifyElementPresent(PWAHamburgerMenuPage.objProfilePageIcon, "Profile icon");
					logger.info("User Logged in Successfully");
					extent.extentLogger("Logged in", "User Logged in Successfully");
				}

				else if (verifyIsElementDisplayed(PWALoginPage.objTwitterAuthorizeButton, "Authorize app")) {
					click(PWALoginPage.objTwitterAuthorizeButton, "Authorize app");
					regestrationfromSocialMedia();
				} else if (verifyIsElementDisplayed(PWALoginPage.objTwitterEmaildField, "Twitter Email field")) {

					type(PWALoginPage.objTwitterEmaildField, "Zee5latest@gmail.com", "Email Field");
					hideKeyboard();
					verifyElementPresentAndClick(PWALoginPage.objTwitterPasswordField, "Twitter Password field");
					type(PWALoginPage.objTwitterPasswordField, "User@123\n", "Password field");
					click(PWALoginPage.objTwitterSignInButton, "Sign in button");
					waitTime(5000);
					verifyElementPresentAndClick(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
					click(PWAHamburgerMenuPage.objLoginBtn, "Login");
					verifyElementPresentAndClick(PWALoginPage.objTwitterIcon, "Twitter icon");
				}

				if (verifyIsElementDisplayed(PWALoginPage.objTwitterAuthorizeButton, "Authorize")) {
					click(PWALoginPage.objTwitterAuthorizeButton, "Authorize");
					waitTime(7000);
					verifyElementPresentAndClick(PWAHamburgerMenuPage.objHamburgerBtn, "Hamburger");
					verifyElementPresent(PWAHamburgerMenuPage.objProfilePageIcon, "Profile icon");
					logger.info("User Logged in Successfully");
					extent.extentLogger("Logged in", "User Logged in Successfully");
				}
				break;
			}
		}
		dismiss3xPopUp();
		dismissAppInstallPopUp();
	}
	
	
	public void verifyLoginInitiatedEventForValidCredentials(String userType, String loginMethod) throws Exception {
		if (userType.equalsIgnoreCase("Guest")) {
			extent.HeaderChildNode("Verify Login Initiated Event for Valid Credentials");
			login(userType,loginMethod);
			mixpanel.FEProp.setProperty("Source", "home");
			mixpanel.FEProp.setProperty("Page Name", "sign_in");
			LocalStorage local = ((ChromeDriver) getWebDriver()).getLocalStorage();
			mixpanel.ValidateParameter(local.getItem("guestToken"), "Login Initiated");
		}
	}

	public void verifyLoginResultEventForValidCredentials(String userType, String loginMethod) throws Exception {
		if (userType.equalsIgnoreCase("Guest")) {
			extent.HeaderChildNode("Verify Login Result Event for Valid Credentials");
			login(userType,loginMethod);
			LocalStorage local = ((ChromeDriver) getWebDriver()).getLocalStorage();
			mixpanel.FEProp.setProperty("Source", "home");
			mixpanel.FEProp.setProperty("Page Name", "sign_in");
			
			System.out.println(local.getItem("guestToken"));
			mixpanel.ValidateParameter(local.getItem("ID"), "Login Result");
		}
	}

	
	public void verifyLoginInitiatedEventForInvalidCredentials(String userType, String loginMethod) throws Exception {
		if (userType.equalsIgnoreCase("Guest")) {
			extent.HeaderChildNode("Verify Login Initiated Event post entering invalid credentials");

			String url = getParameterFromXML("url");
			extent.HeaderChildNode("User-Type : " + userType + ", Environment: " + url);
			// Get the email and password from properties
			String email = "";
			String password = "";
			// dismissSystemPopUp();
			// waitTime(3000);
			// dismissSystemPopUp();
			// dismissAppInstallPopUp();
			// dismissStayTundedPopUp();
			// dismiss3xPopUp();
			// dismissDisplayContentLanguagePopUp();
			// dismissSystemPopUp();
			dismissAllPopUps();
			if (userType.equalsIgnoreCase("Guest")) {
				extent.extentLogger("Guest", "Accessing the application as Guest user");
			} else if (userType.equalsIgnoreCase("SubscribedUser")) {
				extent.extentLogger("Subscribed", "Accessing the application as Subscribed user");
				email = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
						.getParameter("SubscribedUserName");
				password = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
						.getParameter("SubscribedPassword");
			} else if (userType.equalsIgnoreCase("NonSubscribedUser")) {
				extent.extentLogger("Non-Subscribed", "Accessing the application as Non-Subscribed user");
				email = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
						.getParameter("NonsubscribedUserName");
				password = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
						.getParameter("NonsubscribedPassword");
			}
			if (userType.equalsIgnoreCase("SubscribedUser") || userType.equalsIgnoreCase("NonSubscribedUser")) {
				if (!checkElementDisplayed(PWALoginPage.objLoginBtn, "Login Button")) {
					verifyElementPresentAndClick(PWAHomePage.objHamburgerMenu, "Hamburger Menu");
				}
				waitTime(3000);
				click(PWALoginPage.objLoginBtn, "Login button");
				waitTime(3000);
				HeaderChildNode("Login - Method" + loginMethod);
				switch (loginMethod) {

				case "E-mail":
					dismissAppInstallPopUp();
					verifyElementPresentAndClick(PWALoginPage.objEmailField, "Email field");
					waitTime(10000);
					// getDriver().getKeyboard().sendKeys("Bla bla");//works
					type(PWALoginPage.objEmailField, email, "Email Field");
					hideKeyboard();
					waitTime(3000);
					dismissSystemPopUp();
					verifyElementPresentAndClick(PWALoginPage.objPasswordField, "Password Field");
					type(PWALoginPage.objPasswordField, "vhgvgv" + "\n", "Password field");
					hideKeyboard();
					waitTime(5000);
					directClickReturnBoolean(PWALoginPage.objLoginBtnLoginPage, "Login Button");
					waitTime(10000);
					break;

				case "Mobile":
					verifyElementPresentAndClick(PWALoginPage.objEmailField, "Email field");
					type(PWALoginPage.objEmailField, "8792396107\n", "Email Field");
					hideKeyboard();
					verifyElementPresentAndClick(PWALoginPage.objLoginBtn, "Login butotn");
					waitTime(3000);
					hideKeyboard();
					waitTime(5000);
					verifyElementPresentAndClick(PWALoginPage.objpasswordphno, "Password field");
					waitTime(3000);
					verifyElementPresentAndClick(PWALoginPage.objPasswordField, "password-field");
					type(PWALoginPage.objPasswordField, "bhvb4223\n", "password-field");
					hideKeyboard();
					waitTime(2000);
					click(PWALoginPage.objproceedphno, "Proceed button");
					waitTime(5000);
					break;

				}
			}
		}
	}

	public void verifyLoginResultEventForInvalidCredentials(String userType, String loginMethod) throws Exception {
		if (userType.equalsIgnoreCase("Guest")) {
			extent.HeaderChildNode("Verify Login Result Event post entering invalid credentials");

			String url = getParameterFromXML("url");
			extent.HeaderChildNode("User-Type : " + userType + ", Environment: " + url);
			// Get the email and password from properties
			String email = "";
			String password = "";
			// dismissSystemPopUp();
			// waitTime(3000);
			// dismissSystemPopUp();
			// dismissAppInstallPopUp();
			// dismissStayTundedPopUp();
			// dismiss3xPopUp();
			// dismissDisplayContentLanguagePopUp();
			// dismissSystemPopUp();
			dismissAllPopUps();
			if (userType.equalsIgnoreCase("Guest")) {
				extent.extentLogger("Guest", "Accessing the application as Guest user");
			} else if (userType.equalsIgnoreCase("SubscribedUser")) {
				extent.extentLogger("Subscribed", "Accessing the application as Subscribed user");
				email = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
						.getParameter("SubscribedUserName");
				password = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
						.getParameter("SubscribedPassword");
			} else if (userType.equalsIgnoreCase("NonSubscribedUser")) {
				extent.extentLogger("Non-Subscribed", "Accessing the application as Non-Subscribed user");
				email = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
						.getParameter("NonsubscribedUserName");
				password = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
						.getParameter("NonsubscribedPassword");
			}
			if (userType.equalsIgnoreCase("SubscribedUser") || userType.equalsIgnoreCase("NonSubscribedUser")) {
				if (!checkElementDisplayed(PWALoginPage.objLoginBtn, "Login Button")) {
					verifyElementPresentAndClick(PWAHomePage.objHamburgerMenu, "Hamburger Menu");
				}
				waitTime(3000);
				click(PWALoginPage.objLoginBtn, "Login button");
				waitTime(3000);
				HeaderChildNode("Login - Method" + loginMethod);
				switch (loginMethod) {

				case "E-mail":
					dismissAppInstallPopUp();
					verifyElementPresentAndClick(PWALoginPage.objEmailField, "Email field");
					waitTime(10000);
					type(PWALoginPage.objEmailField, email, "Email Field");
					hideKeyboard();
					waitTime(3000);
					dismissSystemPopUp();
					verifyElementPresentAndClick(PWALoginPage.objPasswordField, "Password Field");
					type(PWALoginPage.objPasswordField, "bhjvjbm" + "\n", "Password field");
					hideKeyboard();
					waitTime(5000);
					directClickReturnBoolean(PWALoginPage.objLoginBtnLoginPage, "Login Button");
					waitTime(10000);
					break;

				case "Mobile":
					verifyElementPresentAndClick(PWALoginPage.objEmailField, "Email field");
					type(PWALoginPage.objEmailField, "8792396107\n", "Email Field");
					hideKeyboard();
					verifyElementPresentAndClick(PWALoginPage.objLoginBtn, "Login butotn");
					waitTime(3000);
					hideKeyboard();
					waitTime(5000);
					verifyElementPresentAndClick(PWALoginPage.objpasswordphno, "Password field");
					waitTime(3000);
					verifyElementPresentAndClick(PWALoginPage.objPasswordField, "password-field");
					type(PWALoginPage.objPasswordField, "hbjh211\n", "password-field");
					hideKeyboard();
					waitTime(2000);
					click(PWALoginPage.objproceedphno, "Proceed button");
					waitTime(5000);
					break;

				}
			}
		}
	}
	
	public void verifyTVAuthenticationScreenDisplayEvent(String userType) throws Exception {
		if (!(userType.equalsIgnoreCase("Guest"))) {
			extent.HeaderChildNode("Verify TV Authentication Screen Display Event");
			click(PWAHomePage.objHamburgerMenu, "Hamburger Menu");
			waitTime(3000);
			click(PWAHamburgerMenuPage.objAuthenticationOption, "Authenticate Device");
			
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			String ID = js.executeScript("return window.localStorage.getItem('ID');").toString();
			System.out.println(ID);
			mixpanel.FEProp.setProperty("Source", "home");
			mixpanel.FEProp.setProperty("Page Name", "device_authentication");
			mixpanel.FEProp.setProperty("element", "Authenticate Device");
			mixpanel.ValidateParameter(ID, "TV Authentication Screen Display");
		
		}
	}

	
}
