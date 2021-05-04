package com.zee5.PWAPages;

import org.openqa.selenium.By;

public class PWAComboOfferPage {

	
	public static By objTrailer = By.xpath(".//*[@class='trailerInfoContainer']");
	public static By objRentNow = By.xpath("objPrivacyPolicyTitle");
	
	public static By objwatchFullContentByRentingIt = By.xpath(".//*[@class='subscribe-msg-premium subscribemsg_en']/div/span");
	
	public static By objRentNowInPlayer = By.xpath("");
	
	public static By objRentNowBelowPlayer = By.xpath(".//*[@class='tvodBanner']//child::*[text()='Rent Now']");
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
	
}
