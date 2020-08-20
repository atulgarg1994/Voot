package com.zee5.ApplicasterPages;

import org.openqa.selenium.By;

//-- Dev by Bindu

public class AMDMoreMenu {

	public static By objMoreMenu = By.xpath("//*[@id='bb_bottom_bar_icon']");
	public static By objProfile = By.xpath("//*[@text='P']");
	public static By objUserType = By.xpath("//*[@text='Guest']");
	public static By objBackbutton = By.xpath("//*[@text='a']");
	public static By objBuySubscription = By.xpath("//*[@text='Buy Subscription']");
	public static By objMySubscription = By.xpath("//*[@text='My Subscription']");
	public static By objMyTransactions = By.xpath("//*[@text='My Transactions']");
	public static By objWatchlist = By.xpath("//*[@text='Watchlist']");
	public static By objMyRemainders = By.xpath("//*[@text='My Reminders']");
	public static By objHaveaPrepaidCode = By.xpath("//*[@text='Have a Prepaid Code?']");
	public static By objSettings = By.xpath("//*[@text='Settings']");
	public static By objHomeIcon = By.xpath("//*[@text='Home']");
	public static By objUpcomingIcon = By.xpath("//*[@text='Upcoming' and @id='bb_bottom_bar_title']");
	public static By objDownloadsIcon = By.xpath("//*[@text='Downloads']");
	public static By objMoreMenuIcon = By.xpath("//*[@text='More']");
	public static By objLogout = By.xpath("//*[@text='Logout']");
	public static By objLogoutBtn = By.xpath("//*[@id='logoutButton']");

	public static By objInviteAFriend = By.xpath("//*[@text='Invite a Friend']");
	public static By objAboutUs = By.xpath("//*[@text='About Us']");
	public static By objTermsOfUse = By.xpath("//*[@id='termsofuse']");
	public static By objPrivacyPolicy = By.xpath("//*[@id='privacypolicy']");
	public static By objBuildVersion = By.xpath("//*[@id='version']");
	public static By objDescription = By.xpath("//*[@text='Please connect to the internet and try again.']");

	public static By objParentalControl = By.xpath("//*[@id='parentalControl']");
	public static By objPasswordField = By.xpath("//*[@id='txtET_password_input']");
	public static By objPasswordContinueBtn = By.xpath("//*[@id='btn_verify_email_continue']");

	public static By objRestrictAllContent = By.xpath("//*[@text='Restrict All Content']");
	public static By objContinueBtn = By.xpath("//*[@id='btn_parental_control_continue']");

	public static By objSetPin = By.xpath("//*[@id='txt_verify_email_account_header']");
	public static By objParentalLockPin1 = By.xpath("//*[@id='otpEditText1']");
	public static By objParentalLockPin2 = By.xpath("//*[@id='otpEditText2']");
	public static By objParentalLockPin3 = By.xpath("//*[@id='otpEditText3']");
	public static By objParentalLockPin4 = By.xpath("//*[@id='otpEditText4']");
	public static By objParentalLockDone = By.xpath("//*[@id='dialog_done']");

	public static By objDownloadIcon = By.xpath("//*[@id='downloadTv']");
	public static By objRelatedSearchResult = By
			.xpath("(//*[@id='searchResultsContent']//following-sibling::*[@id='item_primary_text'])[1]");
	public static By objDataSaver = By.xpath("//*[@text='Data saver']");
	public static By objStartDownload = By.xpath("//*[@id='bottomSheetDialogStartDownloadBtn']");
	public static By objDownloadedIcon = By.xpath("(//*[@id='downloadView'])[2]");
	public static By objPlayerBackBtn = By.xpath("//*[@id='icon_down']");
	public static By objEnterPinCTA = By.xpath("//*[@text='Enter PIN']");

	// ----- Sub-Menu under settings
	public static By objVideo_Quality = By.xpath("//*[@id='qualityPixels']");
	public static By objVideo_WifiOnly = By.xpath("//*[@id='videoOverWifiSwitch']");
	public static By objVideo_Autoply = By.xpath("//*[@id='autoPlaySwitch']");

	public static By objDownloads_Quality = By.xpath("//*[@id='downloadLabel']");
	public static By objDownloads_WifiOnly = By.xpath("//*[@id='downloadOverWifiSwitch']");

	public static By objContentLang = By.xpath("//*[@id='contentLanguageValue']");
	public static By objDisplayLang = By.xpath("//*[@id='displayLanguageValue']");

	public static By objClearSearchHistory = By.xpath("//*[@id='searchHistoryAction']");
	public static By objResetDefault = By.xpath("//*[@id='resetSettingAction']");

	public static By objSetPinContinueBtn = By.xpath("//*[@id='btn_set_pin_continue']");
	public static By objNoRestriction = By.xpath("//*[@text='No Restriction']");
	public static By objDownloadDoneIcon = By.xpath("//*[@id='img_state']");

	public static By objHelpCentre = By.xpath("//*[@text='Help Centre'] | //*[@text='Help Center']");

	// developed by Sushma

	public static By objSettingsScreenTitle = By
			.xpath("//*[@resource-id='com.graymatrix.did:id/screen_title' and @text='Settings']");
	public static By objVideoStreamingMenuTitle = By
			.xpath("//*[@resource-id='com.graymatrix.did:id/videoStreamingTitle']");
	public static By objDownloadsMenuTitle = By.xpath("//*[@resource-id='com.graymatrix.did:id/downloadTitle']");
	public static By objLanguageMenuTitle = By.xpath("//*[@resource-id='com.graymatrix.did:id/languageTitle']");
	public static By objSearchHistroyLabel = By.xpath("//*[@resource-id='com.graymatrix.did:id/searchHistoryLabel']");
	public static By objResetSettingsToDefault = By
			.xpath("//*[@resource-id='com.graymatrix.did:id/resetSettingLabel']");
	// About Us Screen
	public static By objAboutUsHeader = By.xpath("//*[@text='About us']");
	// Logout

	public static By objLogoutPopup = By.xpath("//*[@resource-id='com.graymatrix.did:id/txt_logout_header']");
	public static By objCancelButton = By.xpath("//*[@resource-id='com.graymatrix.did:id/logoutCancelButton']");
	public static By objLogoutButton = By.xpath("//*[@resource-id='com.graymatrix.did:id/logoutButton']");
	public static By objProfileHeader = By.xpath("//*[@resource-id='com.graymatrix.did:id/header']");
	
	public static By objcloseButton = By.xpath("//*[@resource-id='com.graymatrix.did:id/icon_exit']");
	public static By objAboutUsDescription = By.xpath("//*[@resource-id='iframe_div']");
	public static By objHyperLinkInAboutUsScreen =  By.xpath("//*[@class='android.view.View']//*[@contentDescription='www.zee5.com']");
	public static By objPageNotFoundMsg = By.xpath("//*[@class='android.view.View']//*[@text='404! Not Found']");
	public static By objNetworkerrormsg = By.xpath("//*[@resource-id='android:id/message']");
	
	//Terms of Use Screen
	public static By objTermsOfUseHeader = By.xpath("//*[@text='Terms of Use']");
	public static By objTermsDescription = By.xpath("//*[@id='iframe_div' and ./*[@text='Terms of Use']]");
	public static By objsupportHyperlinkInTermsOfUse = By.xpath("//*[@text='support.in@zee5.com']");
	public static By objfeedbackLinkInTermsOfUse = By.xpath("//*[@text='feedback.yono@sbi.co.in']");
	public static By objzee5HyperlinkinTermsOfUse = By.xpath("(//*[@text='www.zee5.com'])[1]");
	public static By objsubscribelinkInTermsofUse = By.xpath("//*[@text='https://www.zee5.com/myaccount/subscription']");
	public static By objInternetErrormsg = By.xpath("//*[@text='You are not connected to internet']");

}
