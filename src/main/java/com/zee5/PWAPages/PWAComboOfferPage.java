package com.zee5.PWAPages;

import org.openqa.selenium.By;

public class PWAComboOfferPage {

	public static By objTrailer = By.xpath("(.//*[@class='buttonContainer ']//span[text()='Trailer'])[1]");
	public static By objRentForINR = By
			.xpath("(.//*[@class='tvodButtonContainer']//span[contains(text(),'Rent for INR')])[1]");
	public static By objRentNow = By
			.xpath("(.//*[@class='tvodButtonContainer']//span[contains(text(),'Rent Now')])[1]");

	public static By objWatchNowCTA = By
			.xpath("(.//*[@class='tvodButtonContainer']//span[contains(text(),'Watch Now')])[1]");
	public static By objExpiresDaysTxt = By.xpath(".//*[contains(@class,'timeExpired')]/span");
	public static By objWatchNowCTAInPlayer = By
			.xpath(".//*[@class='playerButtonAlignment']//child::*[text()='Watch Now']");
	public static By objExpiresinDaysTxtBelowThePlayer = By.xpath(".//*[@class='tvodBanner']//child::*//h3");
	public static By objPleaseNotebeForYouStartPopUp = By
			.xpath(".//*[@class='logoTitle']//child::*[text()='Please note before you start']");
	public static By objwatchNowCTAInPlayer = By
			.xpath(".//*[contains(@class,'buttonContainer')]//*[text()='Watch Now']");
	public static By objWatchTimeTxtPopUp = By.xpath(".//*[@class='hourData']/*[text()='Watch Time']");
	public static By objHourTime = By.xpath(".//*[@class='hourData']/span");
	public static By objYouWillHaveHoursToFinishTheMovieOnceStartedPlaybackTxt = By
			.xpath(".//*[@class='bannerTitle']/h5");
	public static By objPopUpDescription = By.xpath(".//*[@class='popupDescription']/span");
	public static By objAgreeAndWatchNow = By
			.xpath(".//*[@class='agreeandWatchButton']//*[text()='Agree and Watch Now']");

	public static By objwatchFullContentByRentingIt = By
			.xpath(".//*[@class='subscribe-msg-premium subscribemsg_en']/div/span");

	public static By objRentNowInPlayer = By
			.xpath(".//*[contains(@class,'subscribe-button subscribemsg_en') and contains(text(),'Rent Now')]");

	public static By objKnowMore = By.xpath(".//*[@class='comboOfferContainer']//child::*[text()='know more']");
	public static By objComboOfferWidget = By.xpath(".//*[@class='comboOfferWidget']");

	public static By objTermsOfService = By.xpath(".//*[@class='checkboxLabel']//child::*[text()='Terms of Services']");
	public static By objPrivacyPolicy = By.xpath(".//*[@class='checkboxLabel']//child::*[text()='Privacy Policy']");

	public static By objTermsOfServiceTitle = By
			.xpath(".//*[@class='staticPageContainer']//child::*[text()='Terms of Use']");
	public static By objPrivacyPolicyTitle = By
			.xpath(".//*[@class='staticPageContainer']//child::*[text()='Privacy Policy']");

	public static By objLangPopUp = By.xpath(".//*[@class='popupTitle bigTitle']");

	public static By objCloseIcon = By.xpath(".//*[@class='noSelect closePupup iconInitialLoad-ic_close']");

	public static By objCheckbox = By.xpath(".//*[@class='iconOther-ic_tick radioBtn ']");

	public static By objRadheComboOffer = By.xpath(".//*[@class='titleSubTitleComp']");

	public static By objContentCard = By.xpath(".//*[@class='movieCard card marginRight minutelyUrl noZoomOverlay']");
	public static By objPremiumCard = By.xpath(".//*[@class='premiumContent']");

	public static By objRentalValidateTxt = By.xpath("((.//*[@class='packDescDetails'])[1]/ul/li)[1]");
	public static By objWatchTimevalidateTxt = By.xpath("((.//*[@class='packDescDetails'])[1]/ul/li)[2]");
	public static By obj4000blockusterTxt = By.xpath("((.//*[@class='packDescDetails'])[2]/ul/li)[1]");
	public static By objzee5OriginalTxt = By.xpath("((.//*[@class='packDescDetails'])[2]/ul/li)[2]");
	public static By objWatchshowsTxt = By.xpath("((.//*[@class='packDescDetails'])[2]/ul/li)[3]");
	public static By objWatchAdTxt = By.xpath("((.//*[@class='packDescDetails'])[2]/ul/li)[4]");

	public static By objDiscount = By.xpath(".//*[contains(@class,'packPriceDetails')]//*[@class='saveAmount']");
	public static By objTotalDiscount = By.xpath(".//*[@class='packDescDetails totalDetails']//*[@class='saveAmount']");

	public static By objOnlyRentMovie = By.xpath("(.//*[@class='bottomSection'])[2]/h3");

	public static By objRentvalidateMoviecardTxt = By
			.xpath("((.//*[@class='bottomSection'])[2]//child::*[@class='packDescDetails']/ul/li)[1]");
	public static By objWatchTimevalidateMovieCardTxt = By
			.xpath("((.//*[@class='bottomSection'])[2]//child::*[@class='packDescDetails']/ul/li)[1]");

	public static By objBuyRadheComboBtn = By
			.xpath(".//*[@class='buttonContainer']//child::*[text()='Buy Radhe Combo']");
	public static By objRentMovieBtn = By.xpath(".//*[@class='buttonContainer']//child::*[text()='Rent Movie']");
	public static By objUpgradeBtn = By.xpath(".//*[@class='buttonContainer']//child::*[text()='Upgrade']");

	public static By objRentPopUp = By.xpath(".//*[@class='popupContent']");
	public static By objTitle = By.xpath(".//*[@class='plexExpiryContent']//*[@class='plexExpiryTitle']");
	public static By objReleasetxt = By.xpath(".//*[@class='plexExpiryReleaseBy']/span");
	public static By objLefftBannerrentvalidationTxt = By
			.xpath("(.//*[@class='plexExpiryBannerLeft']//*[@class='plexExpiryBannerTitleWrapper']/div)[1]");
	public static By objLeftBannerDays = By
			.xpath("(.//*[@class='plexExpiryBannerLeft']//*[@class='plexExpiryBannerTitleWrapper']/div)[2]");
	public static By objLeftBannerDesc = By
			.xpath(".//*[@class='plexExpiryBannerLeft']//*[@class='plexExpiryBannerDesc']");
	public static By objrentvalidityCard = By.xpath(".//*[@class='plexExpiryBannerLeft']");
	public static By objWatchTimeCard = By.xpath(".//*[@class='plexExpiryBannerRight']");
	public static By objWatchTimeTxt = By
			.xpath(".//*[@class='plexExpiryBannerRight']//*[@class='plexExpiryBannerTitleLeft']");
	public static By objHoursTxt = By
			.xpath(".//*[@class='plexExpiryBannerRight']//*[@class='plexExpiryBannerTitleRight']");
	public static By objRightBannerDesc = By
			.xpath(".//*[@class='plexExpiryBannerRight']//*[@class='plexExpiryBannerDesc']");
	public static By objExpirePoints = By.xpath(".//*[@class='plexExpiryPoints']/li");
	public static By objRentForINRBtn = By.xpath(".//*[@class='popupContent']//*[@class='buttonContainer ']//span");
	public static By objTermsOfUse = By.xpath(".//*[@class='plexBottomWrapper']//*[text()='Terms of Use']");

	public static By objSupportedDeviceLink = By
			.xpath(".//*[@class='plexExpiryPoints']//span[text()='supported devices']");
	public static By objZeeplexLink = By.xpath(".//*[@class='plexExpiryPoints']//span[text()='ZEEPLEX']");

	public static By objErrorTitle = By.xpath(".//*[@class='ErrorPage__errorTitle']");
	public static By objZeePlexPageHeader = By
			.xpath(".//*[@class='KbDetailLtContainer__articleTitle']//h1[text()='Renting movies on ZEEPLEX']");

	public static By objWatchListZeeplexTab = By.xpath(".//*[@id='plex']");
	public static By objFirstContentTitle = By.xpath("(.//*[@class='cardTitle overflowEllipsis '])[1]");

	public static By objOnlyRentMovieCheckBox = By
			.xpath("(.//*[@class='packGrid'])[2]//*[@class='iconOther-ic_tick radioBtn active']");

	// Combo Offer Popup
	public static By objRentMovieForTitle = By.xpath("//span[contains(text(), 'Rent Movie for ')]");
	public static By objCurrentPlanTextDesc = By.xpath("//span[contains(text(),'You are currently on ')]");
	public static By objComboPopupRentMovieBtn = By.xpath("//*[@class='comboPopupBtns']//span[text()='Rent Movie']");

	// Upgrade To Combo Offer Popup
	public static By objUpgradeToComboOfferPopupTitle = By
			.xpath("//span[contains(text(), 'Upgrade to Combo Offer by just paying the difference')]");
	public static By objUpgradeToComboOfferPopupUpgradeBtn = By
			.xpath("//*[@class='comboPopupBtns']//span[text()='Upgrade']");

	public static By objPaymentPageHeader = By.xpath(".//*[@class='stepTitle' and text()='Make Payment']");

	// Lakshmi Combo Offer
	public static By objcomboofferpage = By.xpath("//div[@class='titleSubTitleComp']//h1");
	public static By objbuycta = By.xpath("//div[@class='buttonContainer']");
	public static By objpackprice249 = By.xpath("(//div[@class='priceAmout'])[2]");
	public static By objpackprice499 = By.xpath("(//div[@class='priceAmout'])[1]");
	public static By objRentNowTitle = By.xpath(
			"((.//*[@class='tvodButtonContainer']//span[contains(text(),'Rent Now')])[1])//ancestor::*[@class='tvodCardContainer']//*[@class='tvodTitle']");

	public static By objRentNowInConsumptionPage = By.xpath("//*[@class='buttonContainer ']//span[text()='Rent Now']");

	public static By objTrailerOfFirstMovie = By.xpath("(//span[contains(text(),'Trailer')])[1]");

	public static By objComboOfferPageHeader = By.xpath("//*[@class='titleSubTitleComp']");
	public static By objExplorePremiumButton = By.xpath("//*[text()='Explore Premium']");
	public static By objRentMoviebutton = By.xpath("//*[text()='Rent Movie']");
	public static By objHaveitAllPopDialog = By.xpath("//*[text()='You have it all']");
	public static By objYouHaveAlreadyRentedThisZEEPLEXMovieDialog = By
			.xpath("//*[@class='subtitleItem']//span[text()='You have already rented this ZEEPLEX movie']");
	public static By objYouHaveActivePremiumPlanDialog = By
			.xpath("//*[@class='subtitleItem']//span[text()='Your premium Rs 999 for 1 year plan is active']");
	public static By objExplorePremiumCTA = By.xpath("//*[@class='buttonContainer ']//span[text()='Buy Premium']");
	public static By objZeeplexPopupCloseButton = By.xpath("//*[@class='drowerCloseIcon iconInitialLoad-ic_close']");
	public static By obj299PackUpgradePopup = By.xpath(
			"(//div[@class='titleAndSubtitle'])//span[text()='Upgrade to Combo Offer by just paying the difference']");
	public static By obj299PackUpgradeCTA = By.xpath("(//div[@class='buttonContainer '])//span[text()='Upgrade']");
	public static By objZeeplexAndTickIcon = By.xpath("//*[@class='icon']//img[@alt='combo offer popup icon']");
	public static By objComboOfferPageUpgrade299PackHeader = By
			.xpath("//li[@class='subtitleItem']//span[text()='You are currently on ₹299 Premium 3 Months plan.']");
	public static By objUpgradeTextJustPayingDifference = By.xpath("//div[@class='titleSubTitleComp']//h1");
	public static By objPayLessWatchMoreHeader = By
			.xpath("//div[@class='titleSubTitleComp']//p[text()='Pay less, Watch more!']");
	public static By objUpgradeCloseButton = By.xpath("//div[@class='drowerCloseIcon iconInitialLoad-ic_close']");
	public static By objRentOnlyMovieCheckboxPrice = By.xpath("(//div[@class='priceAmout'])[2]");
	public static By objTrailerBtn = By.xpath("(.//*[@class='buttonContainer ']//span[text()='Trailer'])[1]");

	public static By objContentThumbnail = By
			.xpath("(//*[@class='tvodCard card marginRight minutelyUrl noZoomOverlay'])[1]");
	public static By objResumeCTA = By.xpath("//span[text()='Resume']");

	// Combo offer is displayed with Upgrade text Upgrade your existing pack by
	// paying the difference
	public static By objUpgradeToRadheComboPackByJustPayingTheDifference = By
			.xpath("//h1[.='Upgrade to Radhe Combo pack by just paying the difference']");

	public static By objTvodConsumptionPage = By.xpath("//*[@class='tvodImageContainer']");

	public static By objRentedMoviePricePaymentPage = By.xpath("//*[@class='yearDetails']");

	public static By objRentedMoviePrice = By.xpath("//*[@class='iconOther-ic_tick radioBtn active']//parent::*");

	// Trailer Consumption Page
	public static By objTrailerConsumptionPage = By
			.xpath("//div[@style='position: absolute; inset: 0px; margin: 1.5%;']");
	// Rent Now once trailer completed
	public static By objRentNowPlaybackOnConsumptionPage = By
			.xpath("//div[@class='subscribe-button subscribemsg_en noPremiumIcon']");
	// Skip CTA once trailer completed
	public static By objSkipCTAPlaybackOnConsumptionPage = By
			.xpath("//*[contains(@class,'skip-button subscribe-link subscribemsg_en')]");
	// Login button once trailer completed
	public static By objLoginButtonPlaybackOnConsumptionPage = By.xpath("//span[@class='login-link']");

	// Skip tamil
	public static By objSkipTamilWords = By.xpath("//*[@text='ஸ்கிப்']");
	// Buy Plan In Player

	public static By objBuyPlanInPlayer = By
			.xpath(".//*[contains(@class,'subscribe-button subscribemsg_en') and contains(text(),'Buy Plan')]");
	// your Primium 749 for 1 year plan
	public static By OBJYourPrimium749For1YearPlan = By
			.xpath("//*[@text='Your Premium ₹749  for 1 Year  plan is active']");

	// You're watching a trailer
	public static By objYoureWatchingATrailer = By.xpath("//*[@css='DIV.trailerInfoContainer']");
	
	//Buy Plan In Player below Player CTA.
	public static By objBuyPlanInPlayerBelowPlayerCTA = By.xpath("//*[@class='subscribe-teaser-button ']");
	
	public static By objBuySupermoonComboat499 =By.xpath("");
	
	public static By objBlockbusterText=By.xpath("");
	
	public static By objsupermoonComboOffer = By.xpath(".//*[@class='titleSubTitleComp']");
	public static By objSupermoonThumbnail=By.xpath("");
	public static By objRentContent=By.xpath("");
	public static By objPaymentheaderComboOfferPrice=By.xpath("");
	
	public static By objZeeplexTitle=By.xpath("");
	public static By objPoster=By.xpath("");
	public static By objBuySuperMoonComboBtn = By.xpath(".//*[@class='buttonContainer']//child::*[text()='Buy Supermoon Combo']");
	
	public static By objExpiredTxtInMyRental=By.xpath("");
	
	public static By objSharebelowPlayer=By.xpath("//div[@class=\"channelConsumptionMetaDiv\" ]/child::*/child::*//*[@title='Share']");
	public static By objZeePlexLogo = By.xpath("(//img[@alt='plex_logo'])[1]");
	//duration
	public static By objcontentDuration=By.xpath("(//div[@class='consumptionMetaDiv']//span[@class='showMetaClass']//p[2])[1]");

	//genre
	public static By objcontentGenre=By.xpath("//div[@class='consumptionMetaDiv']//div[@class='metaInfo lineHeightClass']//span[@class='showMetaClass']//a");

	public static By objDescBelowShareBtn=By.xpath("//p[@id='description']");

	public static By objLiveTVTVODItem(String title) {
		return By.xpath("//*[contains(@class,'cardTitle')]//*[text()=" + title + "]/parent::*/parent::*//a");
	}
	
	public static By objLiveTVTvodAd=By.xpath("");
	
	public static By objplexlogoOnCard=By.xpath("");
	
	public static By objLoading=By.xpath("");
	public static By objPackDetails=By.xpath("//*[@class='packDetails pack ']");

	public static By objVideoNameInSearch=By.xpath("//h3[@class='cardTitle overflowEllipsis ']");
	
	public static By objRentNowBelowPlayer = By.xpath(".//*[@class='tvodBanner']//child::*[contains(text(),'Rent Now')]");

	public static By objSupermoonPlanTxtinOnlyRent=By.xpath("(.//*[@class='bottomSection'])[2]/child::*//h4");
	public static By objSupermoonPlanTxt=By.xpath("//div[@class='topSection']//h2");
	public static By objLiveEventTicket=By.xpath("(//div[@class='bottomSection']//div[@class='packDescDetails']//ul//li)[1]");
	public static By objExclusiveVideos=By.xpath("(//div[@class='bottomSection']//div[@class='packDescDetails']//ul//li)[2]");
	
	public static By objBottomOnlyRentMovie=By.xpath("(//div[@class='bottomSection'])[2]//h4");
	public static By objbottomLiveEventTicket=By.xpath("(//div[@class='bottomSection']//div[@class='packDescDetails']//ul//li)[7]");
	public static By objbottomExclusiveVideos=By.xpath("(//div[@class='bottomSection']//div[@class='packDescDetails']//ul//li)[8]");
	public static By objSelectedCheckbox = By.xpath(".//*[@class='iconOther-ic_tick radioBtn active']");
	public static By objOtherLangBuysupermoonComboCTA=By.xpath(".//*[@class='buttonContainer']//child::*//child::*");
	public static By objOtherLangRentNowCTA=By.xpath("//*[@class='tvodButtonContainer']//div[@class='rentNowButton']/child::*//button[@type='button']");
	
	public static By objPoPupRentForInrBtn=By.xpath(".//*[@class='drowerPopupContent']//*[@class='buttonContainer ']//span");
	public static By objYouCurrentlyOnTxt= By.xpath("//div[@class='titleSubTitleComp']//p");
	public static By objDifference =By.xpath(".//*[contains(@class,'packDescDetails totalDetails')]//h4//span");
	
	public static By objBuySupermoonComboBtn = By.xpath(".//*[@class='buttonContainer']//child::*[text()='Buy Premium']");
	
	public static By objRentForINRInPlayer = By.xpath("//*[contains(@class,'subscribe-button subscribemsg_en') and contains(text(),'Rent ')]");
	public static By objPlanPriceInMakePaymentSection = By.xpath("(.//*[contains(@class,'upgradePackDetails')]//*[@class='amountBreakup']//p)[2]");
	public static By objdiscountInMakePaymentSection = By.xpath("(.//*[contains(@class,'upgradePackDetails')]//*[@class='amountBreakup']//p)[4]");
	public static By objTotalPayableAmountInMakePaymentSection = By.xpath(".//*[contains(@class,'upgradePackDetails')]//div[@class='totalAmount']//span");
	
	public static By objTermsOfUseHeader = By.xpath("//div[@class='staticPageWrap']//div[@class='staticPageContainer']/h1[contains(text(),'Terms of Use')]");

	public static By objRentContentBtn=By.xpath(".//*[@class='buttonContainer']//child::*[text()='Rent Content']");
	
	public static By objSupermoonImgInZeeplex=By.xpath("//div[@class='tvodGrid']//div[@class='content']//img");
	
	public static By objMyRentalTitle=By.xpath("//div[@class='plexRentalContent']//div[@class='plexItemWrap']//div[@class='contentDetails']//h3[@class='title']//a");
	public static By objHowItworksConsumption=By.xpath("//div[@class='plexLearnMoreButton']//span");
	public static By objBuyCombobutton = By.xpath("//*[@class='buttonContainer']//button");
	public static By objupiproceedtopay=By.xpath("//*[@class='linearLayout sidebarItem_content sidebarItem_content_addupi']//following-sibling::*//article[text()='Verify']");

	public static By objZeerentalsResume =By.xpath("(//div[@class='plexDetails'])[3]//span");
	
	public static By objZeerentalsWatch =By.xpath("(//div[@class='plexDetails'])[3]//span");
}
