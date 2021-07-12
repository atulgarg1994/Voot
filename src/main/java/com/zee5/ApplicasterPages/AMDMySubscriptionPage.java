package com.zee5.ApplicasterPages;

import org.openqa.selenium.By;

public class AMDMySubscriptionPage {
	public static By objActivePackAmt = By.xpath("//*[@id='pack_amount'");
	public static By objActivePackDuration = By.xpath("//*[@id='pack_duration']");
	public static By objDateOfPurchase = By.xpath("//*[@id='pack_purchase_date']");
	public static By objBrowseAllPack = By.xpath("//*[@id='btn_browse_packs']");
	
	public static By objApplybuttonNotHighlighted = By.xpath("//*[@resource-id='com.graymatrix.did:id/apply_promocode' and @enabled='false']");
	public static By objPaymentText = By.xpath("//*[@text='Payment Methods']");
	public static By objContentNameInPlayer(String ResultName) {
			return By.xpath("//*[@resource-id='com.graymatrix.did:id/cell_center_container']/child::*[@text='"+ResultName+"']");
		}
	public static By objTermsandPrivacyLink = By.xpath("//*[@text='By proceeding you agree to our Terms of Use and Privacy Policy']");

	public static By objOfferPlanName = By.xpath("(//*[@text='Make Payment']//following::*[@class='android.widget.TextView'])[1]");
	
	public static By objOfferPlanPrice = By.xpath("((//*[@text='Make Payment']//following::*[4])//child::*[3])[1]");
	
	public static By objEnterCCTxt = By.xpath("(//*[@class='android.widget.EditText'])[1]");
	public static By objExpiryCCTxt = By.xpath("(//*[@class='android.widget.EditText'])[2]");
	public static By objCVVTxt = By.xpath("(//*[@class='android.widget.EditText'])[3]");
	public static By objRetryPaymentCTA = By.id("retryButton");
	
}
