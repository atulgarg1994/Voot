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
	public static By objHelpCentre = By.xpath("//*[@text='Help Centre']");
	public static By objTermsOfUse = By.xpath("//*[@id='termsofuse']");
	public static By objPrivacyPolicy = By.xpath("//*[@id='privacypolicy']");
	public static By objBuildVersion = By.xpath("//*[@id='version']");
	public static  By objDescription = By.xpath("//*[@text='Please connect to the internet and try again.']");
	
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
	public static By objRelatedSearchResult = By.xpath("(//*[@id='searchResultsContent']//following-sibling::*[@id='item_primary_text'])[1]");
	public static By objDataSaver = By.xpath("//*[@text='Data saver']");
	public static By objStartDownload = By.xpath("//*[@id='bottomSheetDialogStartDownloadBtn']");
	public static By objDownloadedIcon = By.xpath("(//*[@id='downloadView'])[2]");
	public static By objPlayerBackBtn = By.xpath("//*[@id='icon_down']");
	public static By objEnterPinCTA = By.xpath("//*[@text='Enter PIN']");
	
}
