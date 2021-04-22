package com.zee5.ApplicasterPages;

import org.openqa.selenium.By;

//-- Dev by Vinay

public class AMDSubscibeScreen {
	
	public static By objSelectPackText  = By.xpath("//*[@text='Select Pack']");
	public static By objAdbanner = By.xpath("//*[@id='packSelectionCrousalImageView']");
	public static By objApplyPromoCodeTextbox = By.xpath("//*[@id='txtET_promocode_input']");
	
	public static By objCancelPromoCode = By.xpath("//*[@resource-id='com.graymatrix.did:id/icon_cancel_promo_code']");
	public static By objApplyPromoCodeappliedText = By.xpath("//*[@resource-id='com.graymatrix.did:id/textinput_helper_text']");
	public static By objPriceAfterPromoCode = By.xpath("//*[@resource-id='com.graymatrix.did:id/old_price_tv']");
	public static By objApplybuttonNotHighlighted = By.xpath("//*[@resource-id='com.graymatrix.did:id/apply_promocode' and @selected='false']");
	public static By objApplyPromoCodeText = By.xpath("//*[@id='txtET_promocode_input'] and @text='Have a Promo Code?");
	public static By objApply = By.xpath("//*[@resource-id='com.graymatrix.did:id/apply_promocode']");
	public static By objDescriptionText = By.xpath("//*[@resource-id='com.graymatrix.did:id/deviceslayout']");
	public static By objClubTab  = By.xpath("//*[@text='Club']");
	public static By objInvalidPromoCodeText = By.xpath("//*[@resource-id='com.graymatrix.did:id/textinput_error']");
	public static By objSelectYourPreminumPackText = By.xpath("//*[@id='packsViewTextView']");
	public static By objPremiumTab  = By.xpath("//*[@text='Premium']");
	public static By obj30daysPack = By.xpath("//*[@id='holder_price' and ./*[./*[@text='INR 99 for 30 days']]]");
	public static By objRadioBtn = By.xpath("//*[@id='selectionImageSelector']");
	public static By obj180daysPack = By.xpath("//*[@id='holder_price' and ./*[./*[@text='INR 599 for 180 days']]]");
	public static By obj365daysPack = By.xpath("//*[@id='holder_price' and ./*[./*[@text='INR 699 for 365 days']]]");
	public static By objContinueBtn = By.xpath("//*[@id='btnContinue_PackSelection']");
	public static By objRSVODPack1 = By.xpath("(//*[@resource-id='com.graymatrix.did:id/decription_tv'])[1]");
	public static By objRSVODPack2 = By.xpath("//*[@resource-id='com.graymatrix.did:id/tv']");
	
	//Account info
	public static By objSelectPack = By.xpath("//*[@id='pack_selection_title']");
	public static By objAllAccessPack = By.xpath("//*[@id='tv_selected_pack']");
	public static By objTvPackYear = By.xpath("//*[@id='tv_pack_year']");
	public static By objSelectedPackDesc = By.xpath("//*[@id='tv_selected_pack_description']");
	public static By objProceedButtonNothighlighted = By.xpath("//*[@resource-id='com.graymatrix.did:id/btnContinue_useraccountdetails' and @clickable='false']");
	public static By objORSeperator = By.xpath("//*[@class='android.widget.TextView' and @text='OR']");
	public static By objAccountInfoHeader = By.xpath("//*[@text='Account Info' and ./parent::*[@id='user_inputs_details_layout']]");
	public static By objEmailID = By.xpath("//*[@id='edit_email']");
	public static By objProceedBtn = By.xpath("//*[@id='btnContinue_useraccountdetails']");
	public static By objContinueWithText = By.xpath("//*[@text='Continue with:']");
	public static By objGoogleIcon = By.xpath("//*[@id='google_login']");
	public static By objFacebookIcon = By.xpath("//*[@id='fb_login']");
	public static By objTwitterIcon = By.xpath("//*[@id='twitter_login']");
	
	//Password screen 
	public static By objDrabBtn = By.xpath("//*[@id='dialog_divider']");
	public static By objEnterPassword = By.xpath("//*[@id='header_verify_pwd']");
	public static By objPasswordTextField  = By.xpath("//*[@id='input_password']");
	public static By objPasswordErrorMessage = By.xpath("//*[@resource-id='com.graymatrix.did:id/textinput_error']");
	public static By objShowIcon = By.xpath("//*[@id='text_input_end_icon']");
	public static By objProceedPWDScreen = By.xpath("//*[@id='subscription_plan_validate_password_button']");
	public static By objVerifyOTPScreenProceed = By.xpath("//*[@resource-id='com.graymatrix.did:id/btn_verify_proceed']");
	public static By objForgotPassword = By.xpath("//*[@id='option_forgot_password']");
	
	public static By objVerifyOTPScreen = By.xpath("//*[@resource-id='com.graymatrix.did:id/txt_verify_mobile_otp_account_header']");
	public static By objGetOTP = By.xpath("//*[@resource-id='com.graymatrix.did:id/btn_get_otp']");
	public static By objForgotPasswordPageHeader = By.xpath("//*[@resource-id='com.graymatrix.did:id/screen_title' and @text='Forgot Password']");
	
	public static By objPasswordHidden = By.xpath("//*[@resource-id='com.graymatrix.did:id/input_password' and @password='true']");
	public static By objPasswordDisplayed = By.xpath("//*[@resource-id='com.graymatrix.did:id/input_password' and @password='false']");
	//Payment Screen
	public static By objAccountInfoText = By.xpath("//*[@id='account_info_title']");
	public static By objUserEmailID = By.xpath("//*[@id='selectedUserDetailsName']");
	public static By objProfileIcon = By.xpath("//*[@id='iconSmile']");
	public static By objPaymentOption = By.xpath("//*[@text='Payment Options']");
	public static By PaymentOptionsRadioBtn = By.xpath("//*[@class='android.widget.RadioButton']");
	public static By objPaymentReccuringMsg = By.xpath("//*[@id='payment_recurring_msg']");
	public static By objContinueBtnPaymentScreen = By.xpath("//*[@id='btnContinue_paymentdetails']");
	
	public static By objSelectedPackText = By.xpath("//*[@resource-id='com.graymatrix.did:id/pack_selection_title']");
	
	public static By objHaveAPromocode = By.xpath("//*[@text='Have a code?']");
	
	public static By objClub365daysPack = By.xpath("//*[@id='holder_price' and ./*[./*[@text='INR 365 for 365 days']]]");
	
	public static By objPackDescription = By.xpath("//*[@resource-id='com.graymatrix.did:id/decription_tv']");
	public static By objApplyBtn = By.xpath("//*[@id='apply']");
	
	public static By objInvalidPrepaidCodePopUp = By.xpath("//*[@id='prepaid_code_layout']");
	public static By objDoneBtn = By.xpath("//*[@id='btn_dialog_done']");
	
	public static By objDefaultSelectedPack = By.xpath("(//*[@id='selectionImageSelector' and @selected='true']//parent::*//parent::*//child::*//child::*)[1]");

	public static By objGetPremiumBtn = By.xpath("//*[@id='get_premium_button']");
	
	public static By objAccountInfoText1 = By.xpath("(//*[@text='Account Info'])[1]");
	
	public static By objRSVODPack3Desc = By.xpath("(//*[@resource-id='com.graymatrix.did:id/decription_tv'])[3]");
	public static By packdetailsinPaymentPage(String pack) {
			return By.xpath("//*[@text='"+pack+"']");
		}
	
	public static By objPlanPrice = By.xpath("//*[@text='Plan Price']//following-sibling::*//following-sibling::*");
	public static By objTotalPayable = By.id("//*[@text='Payable Amount']//following-sibling::*//following-sibling::*");
	
	public static By objRSVODselectedPackDesc = By.xpath("//*[@resource-id='com.graymatrix.did:id/selectionImageSelector' and @selected='true']/parent::*/parent::*/following-sibling::*/child::*");
	
	public static By objPaymentText = By.xpath("//*[@text='Payment Methods']");
	
	public static By objTermsandPrivacyLink = By.xpath("//*[@text='By proceeding you agree to our Terms of Use and Privacy Policy']");
	
	public static By objZEE5SubscriptionPage = By.xpath("//div[@class='subPackFlowContent']");
	
	public static By objNewSubscribePopup = By.xpath("//*[@id='plansHeader']");
	public static By objContinueOnSubscribePopup = By.xpath("//*[@id='continueButton']");
	public static By objMakePaymentScreen = By.xpath("//*[@class='android.widget.TextView' and @text='Make Payment']");
	
	//Select pack 
	public static By objSubscribeHeader = By.xpath("//*[@text='Subscribe'] | //*[@id='plansHeader']");
	
	public static By objSubscribePageBackButton = By.xpath("//*[@resource-id='com.graymatrix.did:id/icon_back'] | //*[@id='planSelectionBackButton']");
	
}
