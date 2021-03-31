package com.zee5.ApplicasterPages;

import org.openqa.selenium.By;

public class AMDPlayerScreen {

	public static By objShareIcon = By.xpath("//*[@id='native_share_button']");
	public static By objWatchlistIcon = By.xpath("//*[@id='watch_list_image']");
	public static By objDownloadIcon = By.xpath("//*[@id='downlowd_image']");
	public static By objfirstContentcardOfParticularTray(String trayTitle) {
		return By.xpath("(//*[@text="+trayTitle+"]/parent::*/parent::*/following-sibling::*/child::*/child::*/child::*/child::*)[1]");
	}
	public static By objTitleOnPlayer = By.xpath("//*[@id='title_main']");
	public static By objQualityOptions = By.xpath("//*[@id='textView2']");
	public static By objQualityOptions(int i) {
		return By.xpath("(//*[@id='textView2'])["+i+"]");
	}
	public static By objAddToWatchlist = By.xpath("//*[@id='icon_add_to_watch_list_text']");
	public static By objLoginTextOnPlayer = By.xpath("//*[@resource-id='com.graymatrix.did:id/static_login_text']");
	public static By objLoginLinkOnPlayer = By.xpath("//*[@resource-id='com.graymatrix.did:id/login_button']");
	
	public static By objPlaybackRateSelected = By.xpath("(//*[@id='icon_selected']//parent::*//child::*)[2]");
	public static By objPlayerLoader = By.xpath("//*[@id='player_loading_progress']");
	public static By objSharePopUp = By.xpath("//*[@text='Share using']");
	public static By objTwitter = By.xpath("//*[@text='Tweet']");
	public static By objTweetButton = By.xpath("//*[@id='button_tweet']");
	public static By objFacebook = By.xpath("//*[@text='News Feed' or @text='Facebook']");
	public static By objFacebookPost = By.xpath("//*[@text='POST' or @text='Post' or @text='Share' or @text='SHARE']");
	public static By objCopyToClipboard = By.xpath("//*[@text='Copy to clipboard']");
	public static By objReplay = By.xpath("//*[@id='icon_replay']");
	public static By objSubtitlePopUp = By.xpath("//*[@id='popup_title']");
	public static By objEnglishSubtitle = By.xpath("//*[@text='English']");
	public static By objLoginCTA = By.xpath("//*[@id='get_premium_login']");
	public static By objRegisterPopUp = By.xpath("//*[@id='registrationContainer']");
	public static By objUpnextContentCard = By.xpath("(//*[@resource-id='com.graymatrix.did:id/card'])[3]");
	public static By objUpnextContentCardTitle = By.xpath("(//*[@id='title_similar'])[3]");
	public static By objUpnextRail = By.xpath("//*[@id='similarcontentlistView']");
	public static By objContentTitle = By.xpath("//*[@id='title_main']");
	public static By objShareIconOnPlayer = By.xpath("//*[@id='icon_share']"); 
	public static By objCompleteProfilePopUp = By.xpath("//*[@id='tellUsMoreContainer']");
	public static By objShareNowFb = By.xpath("//*[@contentDescription='SHARE NOW']");
	public static By objWatchCreditsCTA = By.xpath("//*[@text='Watch Credits']");
	public static By objUpNext = By.xpath("//*[@text='Up Next']");
	public static By objTitleInLandscape(String title) {
		return By.xpath("//*[@id='title_main' and contains(text(), '"+title+"')]");
	}
	public static By objUpNextCard = By.xpath("//*[@resource-id='com.graymatrix.did:id/upnext']");
	public static By objFirstContentCardTitleInUpnextTray = By.xpath("((//*[@resource-id='com.graymatrix.did:id/header_primary_text' and @text='Up Next']/parent::*/parent::*/following-sibling::*)[1]/child::*/child::*/child::*[@resource-id='com.graymatrix.did:id/item_primary_text'])[1]");
	public static By objCountDownTimerInUpNextCard = By.xpath("//*[@resource-id='com.graymatrix.did:id/counddownwatchcredit']");
	
	public static By objfbLoginPage = By.xpath("//*[@content-desc='Create New Facebook Account'] | //*[@content-desc='Log In'] | //*[@text='Log In'] | //*[@text='Create New Facebook Account']");

	public static By objAd = By.xpath("(//*[contains(text(),'Ad :')]) | (//*[contains(text(),'Ad 1 of 2 :')]) | (//*[contains(text(),'Ad 2 of 2 :')])");
	
	public static By objAd2 = By.xpath("(//*[contains(text(),'Ad 1')]) | //*[contains(text(),'Ad 2')] | //*[contains(text(),'Ad :')]");
	
	public static By objLoginButtonInRegisterPopUp = By.xpath("//*[@resource-id='com.graymatrix.did:id/tvLogin']");
	
	public static By objLearnMoreTextOnAdPlayBack = By.xpath("//*[contains(text(),'Learn More')]");

	public static By objAudioTrackOption = By.xpath("//*[@resource-id='com.graymatrix.did:id/icon_audioTrack_text']");
	public static By objPauseIcon = By.xpath("//*[@id='playerPlayPauseButton'] | //*[@id='icon_pause']");
	public static By objFullscreenIcon  = By.xpath("//*[@id='playerFullScreenControl'] | //*[@id='icon_fullscreen']");
		public static By objBackButton = By.xpath("//*[@id='icon_down'] |//*[@id='playerBackButton' and @onScreen='true']");

	public static By objPlayIcon = By.xpath("//*[@id='icon_play'] | //*[@id='playerPlayPauseButton']");
	
	public static By objcontentTitleInconsumptionPage = By.xpath("//*[@resource-id='com.graymatrix.did:id/contentCl']/child::*[@resource-id='com.graymatrix.did:id/item_primary_text'] | //*[@id='content_title']");

	public static By objSubscribeButtonBelowThePlayer = By.xpath("//*[@resource-id='com.graymatrix.did:id/subscribeButton']");
	
	public static By objTimer = By.xpath("//*[@id='playerDurationCurrent']");
	public static By objTotalDuration = By.xpath("//*[@id='playerDurationTotal']");
	public static By objProgressBar = By.xpath("//*[@id='playerSeekBar']");
	public static By objThreeDotsOnPlayer = By.xpath("//*[@id='playerMoreOptionButton']");

	public static By obj3dotMenu = By.xpath("//*[@id='optionsLinearLayout']");
	public static By objPlaybackrate = By.xpath("//*[@text='Playback Rate']");
	public static By objOptionInPlaybackrate = By.xpath("//*[@id='optionsLinearLayout']");
	public static By objplayer = By.xpath("//*[@id='playerTouchToHideShowController']");
	
	public static By objNextIcon = By.xpath("//*[@id='icon_next'] | //*[@id='playerSkipNextButton']");
	public static By objPreviousIcon = By.xpath("//*[@resource-id='com.graymatrix.did:id/playerSkipPreviousButton'] | //*[@resource-id='com.graymatrix.did:id/playerSkipPreviousButton']");
	public static By objChromeCastIcon = By.xpath("//*[@id='icon_cast'] | //*[@resource-id='com.graymatrix.did:id/playerCastButton']");
	public static By objSubtitleOptionInPotraitMode = By.xpath("//*[@resource-id='com.graymatrix.did:id/subtitlesTv'] | //*[@resource-id='com.graymatrix.did:id/subtitle_language_textView']");
	public static By objSubtitleValueInPotraitMode = By.xpath("//*[@resource-id='com.graymatrix.did:id/subtitlesValueTv'] | //*[@resource-id='com.graymatrix.did:id/actual_subtitle_language_textView']");
	public static By objSubscribeNowButtonOnPlayer = By.xpath("//*[@resource-id='com.graymatrix.did:id/subscribe_now_action'] | //*[@resource-id='com.graymatrix.did:id/errorViewButton']");
	public static By objSubscribeScreen = By.xpath("//*[@resource-id='com.graymatrix.did:id/screen_title' and @text='Subscribe']");
	public static By objParentalPinPopUp = By.xpath("//*[@id='otpEditText1'] | //*[@id='parentalPinView'] | //*[@id='parentalFragmentTitleTextView']");

	public static By objSubtitleOption = By.xpath("//*[@id='icon_subtitle_text'] | //*[@id='playerOptionTitle' and contains(text(),'Subtitles')]");

	public static By objPlaybackRate = By.xpath("//*[@id='icon_subtitle_text'] | //*[@id='playerOptionTitle' and contains(text(),'Playback Rate')]");

	public static By objSubtitleDefaultSelected = By.xpath("(//*[@id='icon_selected']//parent::*//child::*)[2] | //*[@id='playerOptionIcon' and @text='t']//following-sibling::*");

	public static By objLandscapePlayerScreen = By.xpath("//*[@id='searchResultPageRecyclerView']");

	public static By objDialogBox = By.xpath("//*[@id='dialog_divider']"); 

	public static By objPlaybackRate2 = By.xpath("//*[@text='2.0X'] | //*[@text='Playback Rate']//following::*[@text='2.0']");

	public static By objPremiumTextOnPlayer = By.xpath("//*[@resource-id='com.graymatrix.did:id/static_premium_text'] | //*[@id='errorViewText' and (contains(text(),'You need subscription'))]");

	public static By objSubscribeNowLinkOnPlayer = By.xpath("//*[@resource-id='com.graymatrix.did:id/subscribe_now_action'] | //*[@id='errorViewButton' and @text='Subscribe']");

	public static By objGetPremiumPopUp = By.xpath("//*[@resource-id='com.graymatrix.did:id/popup_title' and @text='Subscribe'] | //*[@id='screen_title' and @text='Subscribe']");

	public static By objSkipIntro = By.xpath("//*[@id='skipintro'] | //*[@resource-id='com.graymatrix.did:id/playerSkipIntroButton']");
	
	public static By objPlayer = By.xpath("//*[@id='controller'] | //*[@id='playerTouchToHideShowController'] | (//*[@class='android.widget.FrameLayout'])[9]");
	
	public static By objPause = By.xpath("//*[@resource-id='com.graymatrix.did:id/playerPlayPauseButton' and @text='P']");
	public static By objPlay = By.xpath("//*[@resource-id='com.graymatrix.did:id/playerPlayPauseButton' and @text='p']");
	
	public static By objSelectedQualityOption = By.xpath("//*[@resource-id='com.graymatrix.did:id/icon_selected']/following-sibling::* | //*[@id='playerOptionsTitleTextView' and @text='Select Video Quality']");
	
	public static By objQuality = By.xpath("//*[@id='icon_quality_text'] | //*[@id='playerOptionTitle' and @text='Quality 480p']");

	public static By objPlayerScreen = By.xpath("//*[@resource-id='com.graymatrix.did:id/playerElevationParent'] | //*[@id='playerTouchToHideShowController']");

	public static By objRetryBtn = By.xpath("//*[@id='errorViewButton']");
	public static By objReplayIconOnPlayer = By.xpath("//*[@id='playerPlayPauseButton']");
	
}
