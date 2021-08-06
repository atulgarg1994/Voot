package com.zee5.PWASanityScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.business.zee.Zee5PWASanityWEBBusinessLogic;

public class WebPWAInSprintScript {

	private Zee5PWASanityWEBBusinessLogic Zee5WEBPWASanityBusinessLogic;

	@BeforeTest
	public void init() throws Exception {
		// zee5WebBusinessLogic.relaunchFlag = false;
		Zee5WEBPWASanityBusinessLogic = new Zee5PWASanityWEBBusinessLogic("Chrome");
	}

	@Test(priority = 1)
	@Parameters({ "userType" })
	public void PWAWEBLogin(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.ZeeWEBPWALogin(userType);
	}

	@Test(priority=2)
	@Parameters({ "userType" })
	public void Sprint72and73_PWA2_9106(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.authenticationFunctionality1(userType);
	}
	
	@Test(priority=3)
	@Parameters({ "userType" })
	public void ComboOfferPagePlexMovies(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.VerifyComboOfferPagePlexMovies(userType);
	}
	
	@Test(priority=4)
	@Parameters({ "userType" })
	public void ComboOfferForMovies(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.VerifyComboOfferForMovies(userType, "ZEEPLEX");;
	}
	
	@Test(priority=5)
	@Parameters({ "userType" })
	public void ComboOfferThroughSearchEntry(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.VerifyComboOfferThroughSearchEntry(userType);
	}
	
	@Test(priority=6)
	@Parameters({ "userType" })
	public void EntireTextOnComboOfferPage(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.VerifyEntireTextOnComboOfferPage(userType);
	}
	
	@Test(priority=7)
	@Parameters({ "userType" })
	public void KnowMoreCTA(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.VerifyKnowMoreCTA(userType, "ZEEPLEX");;
	}
	
	@Test(priority=8)
	@Parameters({ "userType" })
	public void SupermoonLogoPremiumIconsPrice(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.VerifySupermoonLogoPremiumIconsPrice(userType, "ZEEPLEX");;
	}
	
	@Test(priority=9)
	@Parameters({ "userType" })
	public void userIsAbleToSeeTheComboOfferWidgetBelowPlayerOnPlexConsumptionPageforSupermooon(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.userIsAbleToSeeTheComboOfferWidgetBelowPlayerOnPlexConsumptionPageforSupermooon(userType);
	}
	
	@Test(priority=10)
	@Parameters({ "userType" })
	public void textOnComboOffernudgeIsConfigurable(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.textOnComboOffernudgeIsConfigurable(userType , "ZEEPLEX");
	}
	
	@Test(priority=11)
	@Parameters({ "userType" })
	public void blocbusterMoviesAndLiveEventsAtHome(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.blocbusterMoviesAndLiveEventsAtHome(userType);
	}
	
	@Test(priority=12)
	@Parameters({ "userType" })
	public void comboOfferPageAfterClickinOnRentNow(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.comboOfferPageAfterClickinOnRentNow(userType, "ZEEPLEX");
	}
	
	@Test(priority=13)
	@Parameters({ "userType" })
	public void verifyinformationisdisplayingonComboScreen(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.verifyinformationisdisplayingonComboScreen(userType, "ZEEPLEX");
	}
	
	
	@Test(priority=14)
	@Parameters({ "userType" })
	public void comboOfferSaveAmount(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.comboOfferSaveAmount(userType, "ZEEPLEX");
	}
	
	@Test(priority=15)
	@Parameters({ "userType" })
	public void OtherPlanOnlyRentContentForINR249(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.OtherPlanOnlyRentContentForINR249(userType, "ZEEPLEX");;
	}
	
	@Test(priority=16)
	@Parameters({ "userType" })
	public void SupermoonComboPackDefaultSelect(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.SupermoonComboPackDefaultSelect(userType, "ZEEPLEX");;
	}
	
	@Test(priority=17)
	@Parameters({ "userType" })
	public void supermoonPrivacyPolicyAndTermsAndConditions(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.supermoonPrivacyPolicyAndTermsAndConditions(userType, "ZEEPLEX");
	}
	
	@Test(priority=18)
	@Parameters({ "userType" })
	public void BuyorRentorUpgrade(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.BuyorRentorUpgrade(userType, "ZEEPLEX");
	}
	
	
	@Test(priority=19)
	@Parameters({ "userType" })
	public void TextChangeAsDisplayLanguage(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.TextChangeAsDisplayLanguage(userType, "ZEEPLEX");
	}
	
	@Test(priority=20)
	@Parameters({ "userType" })
	public void ComboOfferScreenLessThan299RentNowCTA(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.ComboOfferScreenLessThan299RentNowCTA(userType);;
	}
	
	@Test(priority=21)
	@Parameters({ "userType" })
	public void ComboOfferScreenLessThan299RentNowCTAOnPlayer(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.ComboOfferScreenLessThan299RentNowCTAOnPlayer(userType);;
	}
	
	@Test(priority=22)
	@Parameters({ "userType" })
	public void ComboOfferScreenLessThan299RentNowCTABelowPlayer(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.ComboOfferScreenLessThan299RentNowCTABelowPlayer(userType);
	}
	
	@Test(priority=23)
	@Parameters({ "userType" })
	public void ComboOfferScreenLessThan299RentAfterClickingOnKnowMore(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.ComboOfferScreenLessThan299RentAfterClickingOnKnowMore(userType);
	}
	
	
	@Test(priority=24)
	@Parameters({ "userType" })
	public void comboOfferTitleAndRentContentCardTitle(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.comboOfferTitleAndRentContentCardTitle(userType, "ZEEPLEX");
	}
	
	@Test(priority=25)
	@Parameters({ "userType" })
	public void supermoonCardAndStrikedPrice(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.supermoonCardAndStrikedPrice(userType, "ZEEPLEX");;
	}
	
	@Test(priority=26)
	@Parameters({ "userType" })
	public void comboOfferpageText(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.comboOfferpageText(userType, "ZEEPLEX");;
	}
	
	@Test(priority=27)
	@Parameters({ "userType" })
	public void VerifyUpgragebuttonFor299user(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.VerifyUpgragebuttonFor299user(userType, "ZEEPLEX");
	}
	
	@Test(priority=28)
	@Parameters({ "userType" })
	public void VerifyFor299userRentShow(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.VerifyFor299userRentShow(userType, "ZEEPLEX");
	}
	
	
	@Test(priority=29)
	@Parameters({ "userType" })
	public void VerifyFor299PaymentPage(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.VerifyFor299PaymentPage(userType, "ZEEPLEX");
	}
	
	@Test(priority=30)
	@Parameters({ "userType" })
	public void VerifyFor299PaymentPageforOnlyRentMovie(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.VerifyFor299PaymentPageforOnlyRentMovie(userType, "ZEEPLEX");;
	}
	
	@Test(priority=31)
	@Parameters({ "userType" })
	public void supermoonCardAndStrikedPriceForRSVODUser(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.supermoonCardAndStrikedPriceForRSVODUser(userType, "ZEEPLEX");;
	}
	
	@Test(priority=32)
	@Parameters({ "userType" })
	public void justPayingDifferenceTxtAndActivePlanTxtRSVODUser(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.justPayingDifferenceTxtAndActivePlanTxtRSVODUser(userType);
	}
	
	@Test(priority=33)
	@Parameters({ "userType" })
	public void comboOfferTitleAndRentContentCardTitleForRSVODUser(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.comboOfferTitleAndRentContentCardTitleForRSVODUser(userType, "ZEEPLEX");
	}
	
	
	@Test(priority=34)
	@Parameters({ "userType" })
	public void comboOfferpageTextForRSVODUser(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.comboOfferpageTextForRSVODUser(userType, "ZEEPLEX");
	}
	
	@Test(priority=35)
	@Parameters({ "userType" })
	public void VerifyRentShowRSVODUser(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.VerifyRentShowRSVODUser(userType, "ZEEPLEX");;
	}
	
	@Test(priority=36)
	@Parameters({ "userType" })
	public void verifyTheRentNowCTABelowPlayerOnZeePlexConsumptionPage(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.verifyTheRentNowCTABelowPlayerOnZeePlexConsumptionPage(userType);;
	}
	
	
	@Test(priority=37)
	@Parameters({ "userType" })
	public void comboOfferTitleAndRentContentCardTitleForNonsubsUser(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.comboOfferTitleAndRentContentCardTitleForNonsubsUser(userType, "ZEEPLEX");
	}
	
	@Test(priority=38)
	@Parameters({ "userType" })
	public void supermoonCardAndStrikedPriceForNonSubs(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.supermoonCardAndStrikedPriceForNonSubs(userType, "ZEEPLEX");
	}
	
	
	@Test(priority=39)
	@Parameters({ "userType" })
	public void justPayingDifferenceTxtAndActivePlanTxt(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.justPayingDifferenceTxtAndActivePlanTxt(userType, "ZEEPLEX");
	}
	
	@Test(priority=40)
	@Parameters({ "userType" })
	public void VerifyComboOfferPage(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.VerifyComboOfferPage(userType);;
	}
	
	@Test(priority=41)
	@Parameters({ "userType" })
	public void BuySubscriptionPageThroughHeader(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.BuySubscriptionPageThroughHeader(userType);;
	}
	@Test(priority=42)
	@Parameters({ "userType" })
	public void BuyPlanInConsumptionPage(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.BuyPlanInConsumptionPage(userType);
	}
	
	@Test(priority=43)
	@Parameters({ "userType" })
	public void BuyPlanInCarousel(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.BuyPlanInCarousel(userType);
	}
	
	
	@Test(priority=44)
	@Parameters({ "userType" })
	public void VerifyComboOfferPageThroughTab(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.VerifyComboOfferPageThroughTab(userType);
	}
	
	@Test(priority=45)
	@Parameters({ "userType" })
	public void ComboOfferPageThroughTitleClick(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.ComboOfferPageThroughTitleClick(userType);;
	}
	
	@Test(priority=46)
	@Parameters({ "userType" })
	public void BuySubscriptionPageThroughCarousel(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.BuySubscriptionPageThroughCarousel(userType);;
	}
	@Test(priority=47)
	@Parameters({ "userType" })
	public void MYSubscriptionPageValidation(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.MYSubscriptionPageValidation(userType);
	}
	
	@Test(priority=48)
	@Parameters({ "userType" })
	public void UpcomingAndNowShowing(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.UpcomingAndNowShowing(userType);
	}
	
	
	@Test(priority=49)
	@Parameters({ "userType" })
	public void UpcomingTrailer(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.UpcomingTrailer(userType);
	}
	
	@Test(priority=50)
	@Parameters({ "userType" })
	public void ZeeplexCTA(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.ZeeplexCTA(userType);;
	}
	
	@Test(priority=51)
	@Parameters({ "userType" })
	public void TrailerAndRentNow(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.TrailerAndRentNow(userType);;
	}
	@Test(priority=52)
	@Parameters({ "userType" })
	public void TrailerAndRentForInr(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.TrailerAndRentForInr(userType);
	}
	
	@Test(priority=53)
	@Parameters({ "userType" })
	public void ZeeplexCTABasedOnDisplayLanguage(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.ZeeplexCTABasedOnDisplayLanguage(userType);
	}
	
	
	@Test(priority=54)
	@Parameters({ "userType" })
	public void ComboOfferWidget(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.ComboOfferWidget(userType);
	}
	
	@Test(priority=55)
	@Parameters({ "userType" })
	public void RentNowOnPlayer(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.RentNowOnPlayer(userType);;
	}
	
	@Test(priority=56)
	@Parameters({ "userType" })
	public void RentNowBelowPlayer(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.RentNowBelowPlayer(userType);;
	}
	
	@Test(priority=57)
	@Parameters({ "userType" })
	public void RentNowOnWidget(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.RentNowOnWidget(userType);
	}
	
	@Test(priority=58)
	@Parameters({ "userType" })
	public void ComboOfferPageThroughSearch(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.ComboOfferPageThroughSearch(userType);
	}
	
	
	@Test(priority=59)
	@Parameters({ "userType" })
	public void RentNowGuestcheckout(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.RentNowGuestcheckout(userType);
	}
	
	@Test(priority=60)
	@Parameters({ "userType" })
	public void TrailerConsumptionPageGuestCheckOut(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.TrailerConsumptionPageGuestCheckOut(userType);;
	}
	
	@Test(priority=61)
	@Parameters({ "userType" })
	public void RentNowBelowPlayerGuestCheckout(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.RentNowBelowPlayerGuestCheckout(userType);;
	}
	@Test(priority=62)
	@Parameters({ "userType" })
	public void RentNowAndLoginOnPlayerGuestCheckOut(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.RentNowAndLoginOnPlayerGuestCheckOut(userType);
	}
	
	@Test(priority=63)
	@Parameters({ "userType" })
	public void ComboOfferWidgetGuestCheckout(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.ComboOfferWidgetGuestCheckout(userType);
	}
	
	
	@Test(priority=64)
	@Parameters({ "userType" })
	public void RentNowOnPlayerGuestCheckout(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.RentNowOnPlayerGuestCheckout(userType);
	}
	
	@Test(priority=65)
	@Parameters({ "userType" })
	public void LiveTVSupermoonContentGuestCheckout(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.LiveTVSupermoonContentGuestCheckout(userType);;
	}
	
	@Test(priority=66)
	@Parameters({ "userType" })
	public void KnowMoreWidgetGuestCheckOut(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.KnowMoreWidgetGuestCheckOut(userType);;
	}
	@Test(priority=67)
	@Parameters({ "userType" })
	public void BuyComboBtnGuestCheckOut(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.BuyComboBtnGuestCheckOut(userType);
	}
	
	@Test(priority=68)
	@Parameters({ "userType" })
	public void AccountInfoGuestCheckOut(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.AccountInfoGuestCheckOut(userType);
	}
	
	
	@Test(priority=69)
	@Parameters({ "userType" })
	public void ComboOfferScreenLessThan299User(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.ComboOfferScreenLessThan299User(userType);
	}
	
	@Test(priority=70)
	@Parameters({ "userType" })
	public void ComsumptionPageLessThan299User(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.ComsumptionPageLessThan299User(userType);;
	}
	
	@Test(priority=71)
	@Parameters({ "userType" })
	public void RentNowCTAConsumptionPageLessThan299User(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.RentNowCTAConsumptionPageLessThan299User(userType);;
	}
	
	@Test(priority=72)
	@Parameters({ "userType" })
	public void ValidateSearchContentLessThan299User(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.ValidateSearchContentLessThan299User(userType);
	}
	
	@Test(priority=73)
	@Parameters({ "userType" })
	public void LiveTVSupermoonLessThan299User(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.LiveTVSupermoonLessThan299User(userType);
	}
	
	
	@Test(priority=74)
	@Parameters({ "userType" })
	public void TermsAndPrivacyPolicyRSVOD(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.TermsAndPrivacyPolicyRSVOD(userType);
	}
	
	@Test(priority=75)
	@Parameters({ "userType" })
	public void TermsOfUsePageRSVODUser(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.TermsOfUsePageRSVODUser(userType);;
	}
	
	@Test(priority=76)
	@Parameters({ "userType" })
	public void PrivacyPolicyPageRSVODUser(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.PrivacyPolicyPageRSVODUser(userType);;
	}
	
	
	@Test(priority=77)
	@Parameters({ "userType" })
	public void TermsAndPrivacyPolicGuest(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.TermsAndPrivacyPolicGuest(userType);
	}
	
	@Test(priority=78)
	@Parameters({ "userType" })
	public void TermsOfUsePageGuest(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.TermsOfUsePageGuest(userType);
	}
	
	
	@Test(priority=79)
	@Parameters({ "userType" })
	public void PrivacyPolicyPageGuest(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.PrivacyPolicyPageGuest(userType);
	}
	
	@Test(priority=80)
	@Parameters({ "userType" })
	public void UpgradeButtonRSVOD(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.UpgradeButtonRSVOD(userType);;
	}
	
	@Test(priority=81)
	@Parameters({ "userType" })
	public void PaymentPageUsingUpgradeButtonRSVOD(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.PaymentPageUsingUpgradeButtonRSVOD(userType);;
	}
	@Test(priority=82)
	@Parameters({ "userType" })
	public void PaymentPageUsingRentNowButtonRSVOD(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.PaymentPageUsingRentNowButtonRSVOD(userType);
	}
	
	@Test(priority=83)
	@Parameters({ "userType" })
	public void RentNowCTA(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.RentNowCTA(userType);
	}
	
	
	@Test(priority=84)
	@Parameters({ "userType" })
	public void TrailerCTA(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.TrailerCTA(userType);
	}
	
	@Test(priority=85)
	@Parameters({ "userType" })
	public void RentNowCTAOnPlayer(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.RentNowCTAOnPlayer(userType);;
	}
	
	@Test(priority=86)
	@Parameters({ "userType" })
	public void RentNowCTAOnPlayerThroughSearch(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.RentNowCTAOnPlayerThroughSearch(userType);;
	}
	@Test(priority=87)
	@Parameters({ "userType" })
	public void ComboOfferWidgetLiveTV(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.ComboOfferWidgetLiveTV(userType);
	}
	
	@Test(priority=88)
	@Parameters({ "userType" })
	public void ComboOfferPageThroughZEEPLEXTitle(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.ComboOfferPageThroughZEEPLEXTitle(userType);
	}
	
	
	@Test(priority=89)
	@Parameters({ "userType" })
	public void ComboOfferPageThroughKnowMore(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.ComboOfferPageThroughKnowMore(userType);
	}
	
	@Test(priority=90)
	@Parameters({ "userType" })
	public void ComboOfferPageOnClickONBelowPlayer(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.ComboOfferPageOnClickONBelowPlayer(userType);;
	}
	
	@Test(priority=91)
	@Parameters({ "userType" })
	public void ComboOfferScreenDetails(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.ComboOfferScreenDetails(userType);
	}
	@Test(priority=92)
	@Parameters({ "userType" })
	public void authenticationFunctionality1(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.authenticationFunctionality1(userType);
	}
	
	@Test(priority=93)
	@Parameters({ "userType" })
	public void VerifyComboOfferThroughTabEntryPointsRSVOD(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.VerifyComboOfferThroughTabEntryPointsRSVOD(userType , "ZEEPLEX");
	}
	
	
	@Test(priority=94)
	@Parameters({ "userType" })
	public void comboOfferpageTextForNonSubsUser(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.comboOfferpageTextForNonSubsUser(userType , "ZEEPLEX");
	}
	
	
	@Test(priority=95)
	@Parameters({ "userType" })
	public void watchCTAonCarousalForSupermoon(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.watchCTAonCarousalForSupermoon(userType , "ZEEPLEX");;
	}
	@Test(priority=96)
	@Parameters({ "userType" })
	public void ResumeCTAonCarousalForSupermoon(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.ResumeCTAonCarousalForSupermoon(userType , "ZEEPLEX");
	}
	
	@Test(priority=97)
	@Parameters({ "userType" })
	public void watchCTAonZeePlexForSupermoonevent(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.watchCTAonZeePlexForSupermoonevent(userType);
	}
	
	
	@Test(priority=98)
	@Parameters({ "userType" })
	public void CreditAndDebitCardAsPerVD(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.CreditAndDebitCardAsPerVD(userType);
	}
	
	@Test(priority=99)
	@Parameters({ "userType" })
	public void CardDetailsValidation(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.CardDetailsValidation(userType);;
	}
	
	@Test(priority=100)
	@Parameters({ "userType" })
	public void BankPageOnSearchedResult(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.BankPageOnSearchedResult(userType);;
	}
	@Test(priority=101)
	@Parameters({ "userType" })
	public void ComboOfferWidgetBasedOnDisplayLanguage(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.ComboOfferWidgetBasedOnDisplayLanguage(userType);
	}
	
	@Test(priority=102)
	@Parameters({ "userType" })
	public void ExplorePremium999(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.ExplorePremium999(userType);
	}
	
	
	@Test(priority=103)
	@Parameters({ "userType" })
	public void ExplorePremiumPopupClone999(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.ExplorePremiumPopupClone999(userType);
	}
	
	@Test(priority=104)
	@Parameters({ "userType" })
	public void ExplorePremium749(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.ExplorePremium749(userType);;
	}
	
	@Test(priority=105)
	@Parameters({ "userType" })
	public void ExplorePremiumPopupClone749(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.ExplorePremiumPopupClone749(userType);;
	}
	
	@Test(priority=106)
	@Parameters({ "userType" })
	public void ExplorePremium599(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.ExplorePremium599(userType);
	}
	
	@Test(priority=107)
	@Parameters({ "userType" })
	public void ExplorePremiumPopupClone599(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.ExplorePremiumPopupClone599(userType);
	}
	
	
	@Test(priority=108)
	@Parameters({ "userType" })
	public void ExplorePremium499(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.ExplorePremium499(userType);
	}
	
	@Test(priority=109)
	@Parameters({ "userType" })
	public void ExplorePremiumPopupClone499(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.ExplorePremiumPopupClone499(userType);;
	}
	
	@Test(priority=110)
	@Parameters({ "userType" })
	public void TermsAndPrivacyPolicyNonSubscribeduser(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.TermsAndPrivacyPolicyNonSubscribeduser(userType);;
	}
	
	@Test(priority=111)
	@Parameters({ "userType" })
	public void TermsOfUsePageNonSubscribeduser(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.TermsOfUsePageNonSubscribeduser(userType);
	}
	
	@Test(priority=112)
	@Parameters({ "userType" })
	public void PrivacyPolicyPageNonSubscribeduser(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.PrivacyPolicyPageNonSubscribeduser(userType);
	}
	
	
	@Test(priority=113)
	@Parameters({ "userType" })
	public void ResumeCTAonZeePlexForSupermoonevent(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.ResumeCTAonZeePlexForSupermoonevent(userType);
	}
	
	@Test(priority=114)
	@Parameters({ "userType" })
	public void NoComboOfferWidgetBelowThePlayer(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.NoComboOfferWidgetBelowThePlayer(userType);;
	}
	
	@Test(priority=115)
	@Parameters({ "userType" })
	public void ExpiresInHoursBelowThePlayer(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.ExpiresInHoursBelowThePlayer(userType);;
	}
	
	@Test(priority=116)
	@Parameters({ "userType" })
	public void ExpiresInRentalAndWatchTime(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.ExpiresInRentalAndWatchTime(userType);
	}
	
	@Test(priority=117)
	@Parameters({ "userType" })
	public void componentsInRentalAndWatchTime(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.componentsInRentalAndWatchTime(userType);
	}
	
	
	@Test(priority=118)
	@Parameters({ "userType" })
	public void activeAndExpiryInRentalAndWatchTime(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.activeAndExpiryInRentalAndWatchTime(userType);
	}
	
	@Test(priority=119)
	@Parameters({ "userType" })
	public void NavigateToConsumptionScreenFromMyRental(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.NavigateToConsumptionScreenFromMyRental(userType);;
	}
	
	@Test(priority=120)
	@Parameters({ "userType" })
	public void noRentalTimeValidityInZeeplexPage(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.noRentalTimeValidityInZeeplexPage(userType);;
	}
	
	@Test(priority=121)
	@Parameters({ "userType" })
	public void HowItWorksInConsumptionPage(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.HowItWorksInConsumptionPage(userType);
	}
	
	@Test(priority=122)
	@Parameters({ "userType" })
	public void SixPopularBanks(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.SixPopularBanks(userType);
	}
	
	
	@Test(priority=123)
	@Parameters({ "userType" })
	public void UPISelectionForNonRecuring(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.UPISelectionForNonRecuring(userType);
	}
	
	@Test(priority=124)
	@Parameters({ "userType" })
	public void UPIPaymentScreenValidation(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.UPIPaymentScreenValidation(userType);;
	}
	
	@Test(priority=125)
	@Parameters({ "userType" })
	public void UPICountDownTimer(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.UPICountDownTimer(userType);;
	}
	
	@Test(priority=126)
	@Parameters({ "userType" })
	public void PlanSelectionPageUsingBackButtonInUPI(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.PlanSelectionPageUsingBackButtonInUPI(userType);
	}
	
	@Test(priority=127)
	@Parameters({ "userType" })
	public void EnterUPIID(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.EnterUPIID(userType);
	}
	
	
	@Test(priority=128)
	@Parameters({ "userType" })
	public void GenerateORPageUsingBackArrowInUPI(String userType) throws Exception {
		Zee5WEBPWASanityBusinessLogic.GenerateORPageUsingBackArrowInUPI(userType);
	}
	
	
	@AfterClass
	public void tearDown() {
		Zee5WEBPWASanityBusinessLogic.tearDown();
	}
}