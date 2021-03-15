package com.zee5.TVPages;

import org.openqa.selenium.By;

public class Zee5TvHomePage {

	public static By objHighlightedTab = By.xpath("//*[@id='menu_items_title' and @focused='true']");

	public static By objSelectTab(String str) {
		return By.xpath("//*[@id='menu_items_title' and @text='" + str + "']");
	}

	public static By objchannelInAllchannelTab(int i) {
		return By.xpath("(//*[@id='channel_horizontal_view_channel_image'])[" + i + "]");
	}

	public static By objSearchIcon = By.xpath("//*[@id='search_icon_menu']");

	public static By objChannelFilterButton = By.xpath("//*[@id='channel_listing_filter_button']");

	public static By objFilterPopup = By.xpath("//*[@id='btn_language']");

	public static By objSortinFilterPopup = By.xpath("//*[@id='sort_layout']");
	public static By objPopularFilterPopup = By.xpath("//*[@id='popularity_layout']");
	public static By objAtoZFilterPopup = By.xpath("//*[@id='atoz_layout']");
	public static By objItemCountLanguageFilterPopup = By.xpath("//*[@id='item_count_language']");
	public static By objLanguageFilterPopup = By.xpath("//*[@id='btn_language']");
	public static By objGenreInFilterPopup = By.xpath("//*[@id='btn_genre']");

	public static By objGenreConterInFilterPopup = By.xpath("//*[@id='item_count_genres_channel']");

	public static By objChannelSort = By.xpath("(//*[@id='channel_sort_textview'])[1]");

	public static By obj3rdEpisode = By.xpath("(//*[@id='tv_shows_result_images'])[3]");

	public static By objupnextTrayContent(int i) {
		return By.xpath("(//*[@id='up_next_container'])[" + i + "]");
	}

	public static By objDisplaylanguageOptions = By.xpath("//*[@id='relative_individual_display']");

	public static By objContentlanguageOptions = By.xpath("//*[@id='relative_individual']");

	public static By objContentlanguageOptionsSelect(int i) {
		return By.xpath("//*[@id='relative_individual'][" + i + "]");
	}

	public static By objDisplaylanguageOptionsSelect(int i) {
		return By.xpath("(//*[@id='relative_individual_display'])[" + i + "]");
	}

	public static By objDisplaylanguageOptionsSelectText(int i) {
		return By.xpath("(//*[@id='english_text'])[" + i + "]");
	}

	public static By objContentlanguageOptionsSelectText(int i) {
		return By.xpath("(//*[@id='checkbox_content' and @checked='true'])[" + i + " ]//parent::*");
	}

	public static By objContentlanguageButtonChecked = By.xpath("//*[@id='checkbox_content' and @checked='true']");
	public static By objEnglistDisplaylanguageButton = By
			.xpath("//*[@text='English']//parent::*//parent::*[@id='relative_individual_display']");

	public static By objOdiaContentlanguageButton = By
			.xpath("//*[@text='Odia']//parent::*//parent::*[@id='relative_individual']");

	public static By objAddcontentLanguagePopup = By.xpath("//*[@id='add_content_lang']");
	public static By objDisplaylanguageButton = By.xpath("//*[@id='display_button']");
	public static By objContentlanguageButton = By.xpath("//*[@id='content_button']");

	public static By objDisplayLanguageHeader = By.xpath("//*[@id='language_title' and @text='DISPLAY LANGUAGE']");

	public static By objlanguageButton = By.xpath("(//*[@text='LANGUAGE SETTINGS']//parent::*)[1]");

	public static By objSaveButton = By.xpath("//*[@id='save_button_lang']");

	public static By objMorecontentPopup = By.xpath("//*[@id='more_content']");

	public static By objOptionsInSetting(String option) {
		return By.xpath("//*[@id='icon_title' and contains(text(),'" + option + "')]");
	}

	public static By objOptionsInSettingClick(String option) {
		return By.xpath("(//*[contains(text(),'" + option + "')]//parent::*)[1]");
	}

	public static By objFAQPage = By.xpath("//*[@id='faq_activity_title']");

	public static By objContactUsPage = By.xpath("//*[@id='contact_us_text']");
	public static By objAboutUsPage = By.xpath("//*[@id='faq_activity_title' and @text='About Us']");
	public static By objTermsOfUsePage = By.xpath("//*[@text='Terms Of Use']");
	public static By objPrivacyPolicyPage = By.xpath("(//*[@text='Privacy Policy'])[1]");

	public static By objSubmitButton = By.xpath("//*[@id='submit_btn']");

	public static By objSuccessPopup = By.xpath("//*[@id='textview_success']");

	public static By objSplCharechter = By.xpath("//*[@id='spl_char']");
	public static By objatbutton = By.xpath("//*[@text='@']");
	public static By objdotbutton = By.xpath("//*[@text='.']");
	
	public static By objmessagebox = By.xpath("//*[@id='edittext_msg']");

	public static By objAlphaKeyboard = By.xpath("//*[@id='caps_turn_On']");

	public static By objAlphaKeyboardGbutton = By.xpath("//*[@id='button_g']");
	public static By objAlphaKeyboardMbutton = By.xpath("//*[@id='button_m']");
	public static By objAlphaKeyboardAbutton = By.xpath("//*[@id='button_a']");
	public static By objAlphaKeyboardIbutton = By.xpath("//*[@id='button_i']");
	public static By objAlphaKeyboardLbutton = By.xpath("//*[@id='button_l']");
	public static By objAlphaKeyboardCbutton = By.xpath("//*[@id='button_c']");
	public static By objAlphaKeyboardObutton = By.xpath("//*[@id='button_o']");
	public static By objAlphaKeyboardXbutton = By.xpath("//*[@id='button_x']");
	public static By objAlphaKeyboardYbutton = By.xpath("//*[@id='button_y']");
	public static By objAlphaKeyboardZbutton = By.xpath("//*[@id='button_z']");
	
	public static By objCountryCodePopup = By.xpath("//*[@id='country_code_text']");
	
	public static By objClubPremiumPopup = By.xpath("//*[@id='tv_pop_up_un_subscribe_text']");
	
	public static By objAllaccessButton = By.xpath("//*[@id='allaccessBtn']");
	
	public static By objWatchNextTray = By.xpath("//*[@id='row_header' and @text='Watch Next']");
	
	public static By objEditBox = By.xpath("//*[@id='edittext_msg']");
	public static By objSelectCountryBox = By.xpath("//*[@id='select_your_country_hint']");
	public static By objResetButton = By.xpath("//*[@id='reset_button']");
	
	public static By objrowHeaderTray(String trayname) {
		return By.xpath("//*[@id='row_header' and @text='"+ trayname +"']");
	}
	
	public static By objClubContent(String contentName) {
		return By.xpath("//*[@id='home_title' and @text='"+ contentName +"']");
	}
	
	public static By objCarouselBannerTitle(String title) {
		return By.xpath("//*[@id='banner_title' and @text='" + title + "']");
	}
}
