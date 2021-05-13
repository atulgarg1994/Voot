package com.zee5.ApplicasterPages;

import org.openqa.selenium.By;

public class AMDTVODComboOffer {

	public static final By ObjOnlyRentMoviePlanSelect = null;
	public static By objTrailerCTAonCarousel = By.xpath("");
	public static By objRentNowTextOnPlayer = By.xpath("//*[@id='rentNowDescription']");
	public static By objRentNowCTAOnPlayer = By.xpath("//*[@id='rentNowCta']");
	public static By objRentNowCTABelowPlayer = By.xpath("//*[@id='ctaBannerButton']/child::*[@id='subscribeButton' and contains(text(), 'Rent')]");
	public static By objComboOfferWidgetBelowThePlayer = By.xpath("//*[@id='comboOfferImageView']");
	
	public static By objHowItWorksCTA = By.xpath("//*[@id='howItWorksTextView']");
	public static By objQandAModelWindow = By.xpath("//*[@id='faqList']");
	
	public static By objPayLessWatchMoreText = By.xpath("//*[@id='mainSubtitle' and @text='Pay less, Watch more!']");
	public static By objKnowMoreCTAOnWidget = By.xpath("");
	public static By objPosterOfMovieContent = By.xpath("//*[@id='posterImageView']");
	public static By objComboOfferPlan = By.xpath("//*[@id='comboPlanTitleLabel' and @text='Radhe Combo']");
	public static By objOnlyRentMoviePlan = By.xpath("//*[@id='onlyRentSectionTitleLabel' and @text='Only Rent Movie']");
	public static By objDefaultComboOfferPlan = By.xpath("");
	public static By objBuyComboOfferCTAOnComboOfferPage = By.xpath("");
	public static By objRentMovieCTAonComboOfferPage = By.xpath("");

	public static By objCTABelowTheComboOfferPage = By.xpath("//*[@id='continueButton']");
	public static By objUpgradeTextOnComboOfferPage = By.xpath("//*[@id='mainTitle']");
	public static By objUpgradeSubTextOnComboOfferPage = By.xpath("//*[@id='mainSubtitle']");

	public static By objBuyRadheComboCTA = By.xpath("//*[@text='Buy Radhe Combo']");
	public static By objPaymentStep2 = By.xpath("//*[@id='steptwoofthree']");
	public static By objAccountInfoLabel = By.xpath("//*[@id='heading' and @text='Account Info']");
	public static By objBackIcon = By.xpath("//*[@id='backIcon']");
	public static By objEmailIdfield = By.xpath("//*[@id='edit_email']");
	public static By objContinueBtn = By.xpath("//*[@id='continueButton']");

	public static By objAlreadyActive = By.xpath("//*[@text='You have it all']");
	public static By objAlreadyRented = By.xpath("//*[@text='Movie already rented']");
	public static By objWatchNowCTA = By.xpath("//*[@id='continueButton' and @text='Watch Now']");
	public static By objBuyPremiumCTA = By.xpath("//*[@id='continueButton' and @text='Buy Premium']");
	public static By objActivePlanMsg2 = By.xpath("//*[@text='You have already rented this ZEEPLEX movie']");

	public static By objAdFreeTxt = By.xpath("//*[@id='label' and @text='Watch Ad-free']");
	public static By objPlanName = By.xpath("//*[@id='planName']");
	public static By objPlanDesc = By.xpath("//*[@id='planDescription']");
	public static By objPlanPrice = By.xpath("//*[@id='planPrice']");
	public static By objPlanReccuring = By.xpath("//*[@id='planRecurring']");
	public static By objPlanFooterlbl = By.xpath("///*[@id='planFooterLabel']");

	// Radhe combo Plan Card
	public static By objRecommendedTag = By.xpath("//*[@id='comboTagLabel' and @text='RECOMMENDED']");
	public static By objPlanTitle = By.xpath("//*[@id='comboPlanTitleLabel']");
	public static By objPlanCost = By.xpath("//*[@id='comboRadioButton']");
	public static By objStrikeOutCost = By.xpath("//*[@id='comboPerceivedPriceLabel']");
	public static By objSaveAmount = By.xpath("//*[@id='comboPlanSavingLabel']");
	public static By objRadheRentalPrice = By.xpath("//*[@id='rentalPriceLabel']");
	public static By obj1YearPremiumPlanPrice = By.xpath("//*[@id='yearlyPlanPriceLabel']");
	public static By obj1YearPremiumPlanPack = By.xpath("//*[@id='yearlyPlanBenefitsSectionLabel']");
	public static By objPriceOnBottomOfTheComboCard = By.xpath("//*[@id='comboActualTotalPriceValue']");
	public static By objRadheCard = By.xpath("//*[@id='itemThumbnailImageView']");
	public static By obj1YearPremiumCard = By.xpath("//*[@id='planThumbnailImageView']");
	public static By objRentalValidity = By.xpath("//*[@id='comboRentalValidityLabel']");
	public static By objWatchTimeValidity = By.xpath("//*[@id='comboWatchTimeValidityLabel']");

	// Only Rent Movie card
	public static By objOnlyRentMoviePlanCost = By.xpath("//*[@id='onlyRentRadioButton']");
	public static By objOnlyRentMovieRentalValidity = By.xpath("//*[@id='onlyRentRentalValidityLabel']");
	public static By objOnlyRentMovieWatchTimeValidity = By.xpath("//*[@id='onlyRentWatchTimeValidityLabel']");

	public static By objUpgradeBottomSheet = By.xpath("//*[@id='design_bottom_sheet']");
	public static By objUpgradeBottomSheetText = By.xpath("//*[@id='titleText']");
	public static By objUpgradeBottomSheetSubText = By.xpath("//*[@id='subtitleText']");
	public static By objUpgradeBottomSheetCTA = By.xpath("//*[@id='buttonFirstAction']");
	
	public static By objTrailerCTAonCarouselForContent(String contentTitle) {
		return By.xpath("//*[@text='"+contentTitle+"']/parent::*/following-sibling::*/child::*/child::*[@id='outlinedButton' and @text='Trailer']");
	}
	
	public static By objRentNowCTAonCarouselForContent(String contentTitle) {
		return By.xpath("//*[@text='"+contentTitle+"']/parent::*/following-sibling::*/child::*/child::*[@id='subscribeButton' and @text='Rent Now']");
	}
	
	public static By objRentNowCTAonCarousel = By.xpath("//*[@id='subscribeButton' and @text='Rent Now']");
	public static By objRentNowCTAonCarouselAagKaGola = By.xpath("//*[@text='Aag Ka Gola']//following::*//*[@id='subscribeButton' and @text='Rent Now']");
	
	public static By obComboOfferScreen = By.xpath("//*[@id='posterImageView']");
	public static By objPasswordfield = By.xpath("//*[@id='edit_email']");

	public static By objBottomSheetTitle = By.xpath("//*[@id='titleText']");
	public static By objBottomSheetSubTitle = By.xpath("//*[@id='subtitleText']");

	public static By objActivePlanMsg1 = By.xpath("//*[@id='titleText']");

	public static By objWatchNowCalloutCTA = By.xpath("//*[@id='buttonFirstAction' and @text='Watch Now']");
	public static By objBuyPremiumCalloutCTA = By.xpath("//*[@id='buttonSecondAction' and @text='Buy Premium']");
	public static By objExplorePremiumCTA = By.xpath("//*[@id='buttonSecondAction' and @text='Explore Premium']");
	
	public static By objPlayCTAonCarouselforContent(String pContentName) {
		return By.xpath("//*[@text='"+pContentName+"']//following::*//*[@id='outlinedButton' and @text='Play']");
	}
}
