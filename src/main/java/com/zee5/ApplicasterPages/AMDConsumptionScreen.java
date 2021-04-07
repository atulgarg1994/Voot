package com.zee5.ApplicasterPages;

import org.openqa.selenium.By;

public class AMDConsumptionScreen {

	public static By objMetaContentType = By.xpath("//*[@id='main_genre_tv']");

	public static By objMetaYear = By.xpath("//*[@id='release_year_tv']");

	public static By objMetaDuration = By.xpath("//*[@id='duration_tv']");

	public static By objMetaGenre = By.xpath("//*[@id='genresTv']");

	public static By objMetaRating = By.xpath("//*[@id='ageRatingTv']");

	public static By objAudioLang = By.xpath("//*[@id='languageTV']");

	public static By objSubtitles = By.xpath("//*[@id='subtitlesTv']");

	public static By objconfirmationPopUp = By.xpath("//*[@text='CONFIRMATION']");

	public static By objPopUpSubscribed = By.xpath("//*[@id='popup_title']");

	public static By objLoginCTA = By.xpath("//*[@id='get_premium_login']");

	public static By objSubscribePopUp = By.xpath("//*[@resource-id='com.graymatrix.did:id/popup_title']");
	public static By objMainGenre = By.xpath("//*[@resource-id='com.graymatrix.did:id/main_genre_tv']");
	public static By objReleasYear = By.xpath("//*[@resource-id='com.graymatrix.did:id/release_year_tv']");
	public static By objGenre = By.xpath("//*[@resource-id='com.graymatrix.did:id/genresTv']");

	public static By objAgeRating = By.xpath("//*[@resource-id='com.graymatrix.did:id/ageRatingTv']");
	public static By objPopUp = By.xpath("//*[@resource-id='com.graymatrix.did:id/popup_title']");
	public static By objCLosePopUpBtn = By.xpath("//*[@resource-id='com.graymatrix.did:id/hide_button']");

	public static By objRegisterPopUp = By.xpath("//*[@resource-id='com.graymatrix.did:id/tvtitle']");

	public static By objSubtitleOrAudioLanguages(String title) {
		return By.xpath("//*[@resource-id='com.graymatrix.did:id/textView2' and @text='" + title + "']");
	}

	public static By objSubscribeBtn = By.xpath("//*[@resource-id='com.graymatrix.did:id/get_premium_button']");
	public static By objSubscribeMessage = By.xpath("//*[@resource-id='com.graymatrix.did:id/title_main']");

	public static By objAd = By.xpath("//*[contains(@content-desc,'Ad')]");

	// Download section
	public static By objDataSaverQuality = By.xpath("//*[@id='radioButton_downlaodQuality' and @text='Data saver']");
	public static By objGoodQuality = By.xpath("//*[@id='radioButton_downlaodQuality' and @text='Good']");
	public static By objBetterQuality = By.xpath("//*[@id='radioButton_downlaodQuality' and @text='Better']");
	public static By objBestQuality = By.xpath("//*[@id='radioButton_downlaodQuality' and @text='Best']");
	public static By objQualityDesc = By.xpath("//*[@id='tv_message']");
	public static By objAlwaysAskMsg = By.xpath("//*[@id='checkBox_rememberThis']");
	public static By objStartDowloadBtn = By
			.xpath("//*[@resource-id='com.graymatrix.did:id/bottomSheetDialogStartDownloadBtn']");
	public static By objPauseDownload = By.xpath("//*[@resource-id='com.graymatrix.did:id/tvPauseDownload']");
	public static By objCancelDownload = By.xpath("//*[@resource-id='com.graymatrix.did:id/tvCancelDownload']");
	public static By objGotoDownloads = By.xpath("//*[@resource-id='com.graymatrix.did:id/tvNavigateDownload']");
	public static By objDowloadStatus = By.xpath("(//*[@resource-id='com.graymatrix.did:id/downloadView'])[2]");
	public static By objToastMsg = By.xpath("//*[@resource-id='android:id/message']");

//	(//*[@resource-id='com.graymatrix.did:id/downloadView'])[2]
	// Objects needed in Wathclist screen
	public static By objAddedContentInWatchList(String title) {
		return By.xpath("//*[@id='txt_reminder_item_title' and @text='" + title + "']");
	}

	public static By objRecommendedRail = By.xpath("//*[@id='header_primary_text' and @text='Recommended']");
	public static By objFeaturedMoviesRail = By.xpath("//*[@id='header_primary_text' and @text='Featured Movies']");
	public static By objReleatedVideosRail = By.xpath("//*[@id='header_primary_text' and @text='Related Videos']");

	public static By objArrow = By.xpath("(//*[@id='header_primary_text']//following::*[@id='header_arrow'])[1]");
	public static By objFirstTray = By.xpath("(//*[@id='recyclerView'])[2]");
	public static By objContentNameInTray1 = By.xpath("(//*[@id='item_primary_text'])[2]");

	// Mandatory pop ups
//	public static By objRegisterPopUp = By.xpath("//*[@resource-id='com.graymatrix.did:id/tvtitle']");
	public static By objRegisterTxtOnPlayer = By
			.xpath("//*[@resource-id='com.graymatrix.did:id/player_error_message']");

	public static By objLoginBtnOnPopup = By.xpath("//*[@resource-id='com.graymatrix.did:id/tvLogin']");
	public static By objContentCardOfTrayInConsumptionPage = By
			.xpath("(//*[@resource-id='com.graymatrix.did:id/horizontal_list_10_parent'])[1]");
	public static By objGetPremiumCTA = By.xpath("//*[@id='get_premium_button' and @text='Get Premium']");

	public static By objAudioLanguageValue = By.xpath("//*[@resource-id='com.graymatrix.did:id/languageValueTV']");
	public static By objAvailableAudioLanguages = By
			.xpath("//*[@resource-id='com.graymatrix.did:id/languageAvailableInTV']");
	public static By objSelectedAudioLanguage = By
			.xpath("//*[@resource-id='com.graymatrix.did:id/icon_selected']/following-sibling::*");

	public static By objAudioLanguages(int i) {
		return By.xpath("(//*[@resource-id='com.graymatrix.did:id/textView2'])[" + i + "]");
	}
	
	public static By objSubtitleValue = By.xpath("//*[@resource-id='com.graymatrix.did:id/subtitlesValueTv']");
	public static By objProceedBtnOnSubscribePopUpInPlayerScreen = By.xpath("//*[@resource-id='com.graymatrix.did:id/proceed']");
	
	public static By objShareBtn = By.xpath("//*[@resource-id='com.graymatrix.did:id/shareText'] | //*[@id='metaInfoActionButtonTextView' and @text='Share']");
	
	public static By objOkBtn = By.xpath("//*[@id='okButton'] | //*[@id='addDeviceButtonOK']");

	public static By objDownloadbtn = By.xpath("//*[@id='downlowd_image'] | //*[@id='metaInfoActionButtonTextView' and @text='Download']");

	public static By getClubCTA = By.xpath("//*[@id='get_premium_button' and @text='Get Club'] | //*[@id='subscribeButton' and @text='Get Club']");
	
	public static By objContentName = By.xpath("//*[@id='content_title']");
	public static By objAudioLanguage = By.xpath("//*[@id='audio_language_textView']");
	public static By objSubtitle = By.xpath("//*[@id='subtitle_language_textView']");
	public static By objContentDesc = By.xpath("//*[@id='contentDescriptionTextView']");
	public static By objExpandDesc = By.xpath("//*[@id='expand_imageView']");
	public static By objWatchlistBtn = By.xpath("//*[@id='metaInfoActionButtonTextView' and @text='Watchlist']");
	public static By objCastBtn = By.xpath("//*[@id='metaInfoActionButtonTextView' and @text='Cast']");
	public static By objDownloadBtn = By.xpath("//*[@id='metaInfoActionButtonTextView' and @text='Download']");
	public static By objWatchTrialer = By.xpath("//*[@id='metaInfoActionButtonTextView' and @text='Watch Trailer']");
	public static By objCurrentAudioLanguage = By.xpath("//*[@id='actual_audio_language_textView']");
	public static By objSubtitleAndAudioLangItems = By.xpath("//*[@id='playerOptionTitle']");
	public static By objCurrentSubTitle = By.xpath("//*[@id='actual_subtitle_language_textView']");
	public static By objSubtitleAndAudioLangItems(int index) {
			return By.xpath("(//*[@id='playerOptionTitle'])[" + index + "]");
		}
	public static By objAudioLanguagepopup = By.xpath("//*[@id='playerOptionsTitleTextView']");
	
	public static By objDuratation = By.xpath("//*[@id='playerDurationTotal']");
	
	public static By objContentInfo = By.xpath("//*[@id='content_info']");
	
	public static By objAudeioLangPopUpClose = By.xpath("//*[@id='player_option_top_pill']");
	

	public static By objCompleteProfilePopup = By.xpath("//*[@id='tv_title' and @text='Complete Profile']");
	public static By objProfilePopupTextMsg = By.xpath("//*[@id='tvSubtitle']");
	public static By objSendOTPBtn = By.xpath("//*[@id='btnupdate' and @text='Send OTP']");
	public static By objMobNumField = By.xpath("//*[@id='edit_email' and @text='Mobile Number']");
	public static By objErrTextOnPlayer = By.xpath("//*[@id='errorViewText']");

	public static By objFirstUpNextContent = By.xpath("(//*[@id='horizontal_list_10_parent'])[1]|(//*[@id='belowPlayerContentRecyclerView']//child::*[@text='Up Next']//parent::*//following-sibling::*//*[@class='android.widget.ImageView'])[1]");
	public static By objRegisterBtnOnPlayer = By.xpath("//*[@resource-id='com.graymatrix.did:id/btnAction']|//*[@id='errorViewButton']");
	public static By objBeforeTVContentName = By.xpath("(//*[@id='collectionPageRecyclerView']//*[@id='cell_bottom_container']//*[@class='android.widget.TextView'])[1]");
	
	public static By objBackFrmCollectionscreen = By.xpath("//*[@id='railDialogBackButton']");
	
	public static By objRightArrow(String railName) {
		return By.xpath("//*[contains(text(),'" + railName + "')]//following-sibling::*[@text='a']");
		}

}
