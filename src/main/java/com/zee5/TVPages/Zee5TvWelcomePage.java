package com.zee5.TVPages;

import org.openqa.selenium.By;

public class Zee5TvWelcomePage {

	public static By objWelcomeSkipLink = By.xpath("//*[@id='welcome_skip' or @id='registration_skip']");

	public static By objalreadyRegister = By.xpath("//*[@id='already_register' or @id='register_ZEE']");
	
	public static By objLogiButtonAmazon = By.xpath("//*[@id='login_zee5_button']");
	
	public static By objLoginPopupAmazon = By.xpath("//*[@id='lwa_title']");
	
	
	public static By objauthenticatetext = By.xpath("//*[@id='authenticate_text']");
	public static By objloginCode = By.xpath("//*[@id='code_text']");
	public static By objHomepageTrayContent = By.xpath(
			"(//*[@id='row_header' and contains(text(),'Top')]//parent::*//following-sibling::*//child::*//child::*//child::*//child::*//child::*[@id='main_image'])[1]");

	public static By objContinuewatchingTrayImage = By.xpath(
			"(//*[@id='row_header' and contains(text(),'Continue')]//parent::*//following-sibling::*//child::*//child::*//child::*//child::*//child::*[@id='main_image'])[1]");
	public static By objBeforeTVTray = By.xpath(
			"	(//*[@id='row_header' and contains(text(),'Before')]//parent::*//following-sibling::*//child::*//child::*//child::*//child::*//child::*[@id='main_image'])[2]");
	public static By objshowpageTrayContent = By.xpath(
			"(//*[@id='row_header' and contains(text(),'Trending') or contains(text(),'Top')]//parent::*//following-sibling::*//child::*//child::*//child::*//child::*[@id='main_image'])[2]");
	
	public static By objshowpageTrayContentClub = By.xpath(
			"(//*[@id='row_header' and contains(text(),'Top')]//parent::*//following-sibling::*//child::*//child::*//child::*//child::*[@id='main_image'])[2]");

	public static By objLandingshowpageTrayContent = By.xpath(
			"(//*[@id='row_header' and contains(text(),'Top')]//parent::*//following-sibling::*//child::*//child::*//child::*//child::*[@id='main_image'])[2]");

	public static By objViewAllPremium = By.xpath("//*[@id='premium_tag']");

	public static By objMoviePageTrayContent = By.xpath(
			"(//*[@id='row_header' and contains(text(),'Trending') or contains(text(),'Top Zee ') or contains(text(),'For You')]//parent::*//following-sibling::*//child::*//child::*//child::*//child::*[@id='main_image'])[2]");

	public static By objLandingMoviePageTrayContent = By.xpath(
			"(//*[@id='row_header' and  contains(text(),'Popular')]//parent::*//following-sibling::*//child::*//child::*//child::*//child::*[@id='main_image'])[2]");

	public static By objPremiumPageTrayContent = By.xpath(
			"(//*[@id='row_header' and contains(text() ,'Premium')]//parent::*//following-sibling::*//child::*//child::*//child::*//child::*[@id='main_image'])[2]");

	public static By objLandingPremiumPageTrayContent = By.xpath(
			"(//*[@id='row_header' and contains(text() ,'Top')]//parent::*//following-sibling::*//child::*//child::*//child::*//child::*[@id='main_image'])[2]");

	public static By objVideoPageTrayContentPlayback = By.xpath(
			"(//*[@id='row_header' and contains(text() ,'Latest on')]//parent::*//following-sibling::*//child::*//child::*//child::*//child::*[@id='main_image'])[2]");

	public static By objVideoPageTrayContent= By.xpath(
			"(//*[@id='row_header' and contains(text() ,'Top')]//parent::*//following-sibling::*//child::*//child::*//child::*//child::*[@id='main_image'])[2]");
	
	public static By objLiveNewsContentinNewsPage = By.xpath(
			"(//*[@id='row_header' and contains(text() ,'Live News')]//parent::*//following-sibling::*//child::*//child::*//child::*//child::*[@id='main_image'])[2]");

	public static By objLandingNewsContentinNewsPage = By.xpath(
			"	(//*[@id='row_header' and contains(text() ,'Entertainment News')]//parent::*//following-sibling::*//child::*//child::*//child::*//child::*[@id='main_image'])[2]");
	
	public static By objLandingNewsContentinVideosPage = By.xpath(
			"	(//*[@id='row_header' and contains(text() ,'Latest')]//parent::*//following-sibling::*//child::*//child::*//child::*//child::*[@id='main_image'])[2]");
	public static By objcontinueButtonInLoginPage = By.xpath("//*[@id='continue_button_reg']");

	public static By objContentTitleIncontentPage = By.xpath("//*[@id='detail_title']");

	public static By objContentDescriptionIncontentPage = By.xpath("//*[@id='details_description_text']");
	public static By objContentdurationIncontentPage = By.xpath("(//*[@class='android.widget.TextView'])[6]");
	public static By objContentyearIncontentPage = By.xpath("	(//*[@class='android.widget.TextView'])[7]");
	public static By objContentcertificateIncontentPage = By.xpath("(//*[@class='android.widget.TextView'])[5]");
	public static By objContentTypeIncontentPage = By.xpath("(//*[@class='android.widget.TextView'])[3]");
	public static By objContentgenreIncontentPage = By.xpath("(//*[@class='android.widget.TextView'])[4]");
	public static By objContenttrailerplaybackIncontentPage = By.xpath("//*[@id='trailer_playback_container']");

	public static By objContentShowTypeIncontentPage = By.xpath("(//*[@class='android.widget.TextView'])[2]");
	public static By objContentShowgnereIncontentPage = By.xpath("	(//*[@class='android.widget.TextView'])[3]");
	public static By objContentShowcertificateIncontentPage = By.xpath("(//*[@class='android.widget.TextView'])[4]");
	public static By objContentShowyearIncontentPage = By.xpath("(//*[@class='android.widget.TextView'])[5]");

	public static By objContinueWatchingTray = By.xpath("//*[@id='row_header' and @text='Continue Watching']");
	public static By objMyWatlistTray = By.xpath("//*[@id='row_header' and @text='My Watchlist']");

	public static By objViewallButton = By.xpath("(//*[@text='View All']//parent::*)[1]");

	public static By objViewallPageHead = By.xpath("//*[@id='details_main_head']");

	public static By objYoumayLike = By.xpath("//*[@id='header_title']");
	public static By objAddtoWatchlist = By
			.xpath("(//*[@id='detail_button_text' and @text='Add to Watchlist']//parent::*//child::*)[1]");

	public static By objPremiumTag(int str) {
		return By.xpath("(//*[@id='premium_tag'])[" + str + "]");
	}

	public static By objViewallTray = By.xpath(
			"(//*[@id='row_header' and contains(text(),'Top ZEE5')]//parent::*//following-sibling::*//child::*//child::*//child::*//child::*//child::*[@id='main_image'])[2]");

	public static By objNameColumn = By.xpath("//*[@id='profile_name']");
	public static By objEmailIdColumn = By.xpath("//*[@id='profile_id_view']");
	public static By objMobileNumberColumn = By.xpath("//*[@id='profile_number_view']");
	public static By objDOBColumn = By.xpath("//*[@id='profile_date_of_birth']");
	public static By objGenderColumn = By.xpath("//*[@id='profile_gender']");

	public static By objEditProfileInMyProfile = By.xpath("//*[@id='profile_tv_edit_button']");

	public static By objSaveButton = By.xpath("//*[@id='profile_tv_save_button']");

	public static By objEditProfilepage = By.xpath("//*[@text='EDIT PROFILE']");

	public static By objNameText = By.xpath("(//*[@id='profile_name']//child::*)[2]");
	public static By objProfileOptionInSettingPage = By
			.xpath("//*[@text='PROFILE']//parent::*//child::*[@id='icon_image']");

	public static By objVerison = By.xpath("//*[@id='tv_settings_version']");
	public static By objParentalOption = By
			.xpath("(//*[@text='PARENTAL CONTROL']//parent::*)[1]//child::*[@id='icon_image']");

	public static By objLogoutOption = By.xpath("(//*[@text='LOGOUT']//parent::*)[1]//child::*[@id='icon_image']");
	public static By objLoginOption = By.xpath("(//*[@text='LOGIN']//parent::*)[1]//child::*[@id='icon_image']");
	public static By objVideoqualityOption = By
			.xpath("(//*[@text='VIDEO QUALITY']//parent::*)[1]//child::*[@id='icon_image']");
	public static By objreminderOption = By.xpath("(//*[@text='REMINDERS']//parent::*)[1]//child::*[@id='icon_image']");

	public static By objMyPlanOption = By.xpath("(//*[@text='MY PLANS' or @text='MY PLAN'] //parent::*)[1]//child::*[@id='icon_image']");
	
			public static By objALLPlanOption = By.xpath("(//*[@text='ALL PLANS']//parent::*)[1]//child::*[@id='icon_image']");
	public static By objnoreminder = By.xpath("//*[@id='no_reminder_msg']");

	public static By objreminderLayout = By.xpath("//*[@id='reminder_vertical']");
	public static By objVideoQualityHeader = By.xpath("//*[@id='videoQualityheading']");

	public static By objZeelogo = By.xpath("//*[@id='zee_image']");

	public static By objwelcomescreenmessage1 = By.xpath("//*[@id='welcome_msg_one']");
	public static By objwelcomescreenmessage2 = By.xpath("//*[@id='welcome_msg_two']");

	public static By objVideoQualityResolutionOptions = By.xpath("//*[@id='radiobtn1']");
	public static By objVideoQualityResolutionOptions2 = By.xpath("//*[@id='radiobtn2']");
	public static By objVideoQualityResolutionOptions3 = By.xpath("//*[@id='radiobtn3']");
	public static By objVideoQualityResolutionOptions4 = By.xpath("//*[@id='radiobtn4']");
	public static By objVideoQualityResolutionOptions5 = By.xpath("//*[@id='radiobtn5']");

	public static By objMyProfilePageheader = By.xpath("//*[@id='my_account_title']");

	public static By objParentpopuptitle = By.xpath("//*[@id='parental_title']");
	public static By objParentalControlMessage = By.xpath("//*[@id='parentalcontrol_site']");

	public static By objChooseLanguagePopup = By
			.xpath("//*[@id='language_title1' and @text='Choose your preferred display language']");

	public static By objChooseLanguagePopupContinue = By.xpath("//*[@id='continue_button_lang']");

	public static By objSelectedOption = By.xpath("//*[@id='channel_filter_language_tick']");

	public static By objLoginIcon = By.xpath("//*[@id='icon_title' and @text='LOGIN']");

	public static By objMenuTopIcon = By.xpath("//*[@id='menu_items_title']");

	public static By objMenuTopParticular(int str) {
		return By.xpath("(//*[@id='menu_items_title'])[" + str + "]");
	}
	
	public static By objApiRecoTray(String trayname) {
		return By.xpath("//*[@id='row_header' and contains(text(),'"+ trayname +"')]");
	}

	public static By objHomeTabTrending = By.xpath("//*[@id='row_header' and contains(text(),'Trending on')]");

	public static By objShowsTabTrending = By.xpath("//*[@id='row_header' and contains(text(),'Trending')]");

	public static By objRecommendForYou = By
			.xpath("(//*[@id='row_header' and contains(text(),'For You') or contains(text(),'for You')])[1]");

	public static By objRecommendForYouContentDetail = By.xpath(
			"(//*[@id='header_title' and contains(text(),'For You') or contains(text(),'for You') or contains(text(),'You')])[1]");
	
	
	public static By objAuthenticateErrorMessage = By.xpath("//*[@id='authenticate_error_message']");
	
	public static By objAuthenticateNewCodeButton = By.xpath("//*[@id='new_code_button']");
	

}
