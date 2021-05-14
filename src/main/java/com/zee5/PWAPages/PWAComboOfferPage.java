package com.zee5.PWAPages;

import org.openqa.selenium.By;

public class PWAComboOfferPage {

	
	public static By objTrailer = By.xpath("(.//*[@class='buttonContainer ']//span[text()='Trailer'])[1]");
	public static By objRentForINR = By.xpath("(.//*[@class='tvodButtonContainer']//span[contains(text(),'Rent for INR')])[1]");
	public static By objRentNow = By.xpath("(.//*[@class='tvodButtonContainer']//span[contains(text(),'Rent Now')])[1]");
	
	public static By objwatchFullContentByRentingIt = By.xpath(".//*[@class='subscribe-msg-premium subscribemsg_en']/div/span");
	
	public static By objRentNowInPlayer = By.xpath(".//*[contains(@class,'subscribe-button subscribemsg_en') and contains(text(),'Rent Now')]");
	
	public static By objRentNowBelowPlayer = By.xpath(".//*[@class='tvodBanner']//child::*[contains(text(),'Rent')]");
	public static By objKnowMore = By.xpath(".//*[@class='comboOfferContainer']//child::*[text()='know more']");
	public static By objComboOfferWidget = By.xpath(".//*[@class='comboOfferWidget']");
	
	public static By objTermsOfService = By.xpath(".//*[@class='checkboxLabel']//child::*[text()='Terms of Services']");
	public static By objPrivacyPolicy = By.xpath(".//*[@class='checkboxLabel']//child::*[text()='Privacy Policy']");
	
	public static By objTermsOfServiceTitle = By.xpath(".//*[@class='staticPageContainer']//child::*[text()='Terms of Use']");
	public static By objPrivacyPolicyTitle = By.xpath(".//*[@class='staticPageContainer']//child::*[text()='Privacy Policy']");
	
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
	
	public static By objDiscount = By.xpath(".//*[@class='packPriceDetails']//*[@class='saveAmount']");
	public static By objTotalDiscount = By.xpath(".//*[@class='packDescDetails totalDetails']//*[@class='saveAmount']");
	
	public static By objOnlyRentMovie = By.xpath("(.//*[@class='bottomSection'])[2]/h3");
	
	public static By objRentvalidateMoviecardTxt = By.xpath("((.//*[@class='bottomSection'])[2]//child::*[@class='packDescDetails']/ul/li)[1]");
	public static By objWatchTimevalidateMovieCardTxt = By.xpath("((.//*[@class='bottomSection'])[2]//child::*[@class='packDescDetails']/ul/li)[1]");
	
	public static By objBuyRadheComboBtn = By.xpath(".//*[@class='buttonContainer']//child::*[text()='Buy Radhe Combo']");
	public static By objRentMovieBtn = By.xpath(".//*[@class='buttonContainer']//child::*[text()='Rent Movie']");
	public static By objUpgradeBtn = By.xpath(".//*[@class='buttonContainer']//child::*[text()='Upgrade']");
	
	public static By objRentPopUp = By.xpath(".//*[@class='popupContent']");
	public static By objTitle = By.xpath(".//*[@class='plexExpiryContent']//*[@class='plexExpiryTitle']");
	public static By objReleasetxt = By.xpath(".//*[@class='plexExpiryReleaseBy']/span");
	public static By objLefftBannerrentvalidationTxt = By.xpath("(.//*[@class='plexExpiryBannerLeft']//*[@class='plexExpiryBannerTitleWrapper']/div)[1]");
	public static By objLeftBannerDays = By.xpath("(.//*[@class='plexExpiryBannerLeft']//*[@class='plexExpiryBannerTitleWrapper']/div)[2]");
	public static By objLeftBannerDesc = By.xpath(".//*[@class='plexExpiryBannerLeft']//*[@class='plexExpiryBannerDesc']");
	public static By objrentvalidityCard = By.xpath(".//*[@class='plexExpiryBannerLeft']");
	public static By objWatchTimeCard = By.xpath(".//*[@class='plexExpiryBannerRight']");
	public static By objWatchTimeTxt = By.xpath(".//*[@class='plexExpiryBannerRight']//*[@class='plexExpiryBannerTitleLeft']");
	public static By objHoursTxt = By.xpath(".//*[@class='plexExpiryBannerRight']//*[@class='plexExpiryBannerTitleRight']");
	public static By objRightBannerDesc = By.xpath(".//*[@class='plexExpiryBannerRight']//*[@class='plexExpiryBannerDesc']");
	public static By objExpirePoints = By.xpath(".//*[@class='plexExpiryPoints']/li");
	public static By objRentForINRBtn = By.xpath(".//*[@class='popupContent']//*[@class='buttonContainer ']//span");
	public static By objTermsOfUse = By.xpath(".//*[@class='plexBottomWrapper']//*[text()='Terms of Use']");
	
	public static By objTermsOfUseHeader = By.xpath(".//*[@class='staticPageContainer']/h1[text()='Terms of Use']");
	public static By objSupportedDeviceLink = By.xpath(".//*[@class='plexExpiryPoints']//span[text()='supported devices']");
	public static By objZeeplexLink = By.xpath(".//*[@class='plexExpiryPoints']//span[text()='ZEEPLEX']");
	
	public static By objErrorTitle = By.xpath(".//*[@class='ErrorPage__errorTitle']");
	public static By objZeePlexPageHeader = By.xpath(".//*[@class='KbDetailLtContainer__articleTitle']//h1[text()='Renting movies on ZEEPLEX']");
	
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
	
	public static By objWatchNowCTA = By.xpath("(//button[@type='button' and span[text()='Watch Now']])[1]");
	
	public static By objPaymentPageHeader = By.xpath(".//*[@class='stepTitle' and text()='Make Payment']");

	// Lakshmi Combo Offer
	public static By objcomboofferpage = By.xpath("//div[@class='titleSubTitleComp']//h1");
	public static By objbuycta = By.xpath("//div[@class='buttonContainer']");
	public static By objpackprice249 = By.xpath("(//div[@class='priceAmout'])[2]");
	public static By objpackprice499 = By.xpath("(//div[@class='priceAmout'])[1]");
	public static By objRentNowTitle = By.xpath("((.//*[@class='tvodButtonContainer']//span[contains(text(),'Rent Now')])[1])//ancestor::*[@class='tvodCardContainer']//*[@class='tvodTitle']");

	public static By objRentNowInConsumptionPage=By.xpath("//*[@class='rentButton']");

}
