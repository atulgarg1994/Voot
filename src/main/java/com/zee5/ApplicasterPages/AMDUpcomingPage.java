package com.zee5.ApplicasterPages;

import org.openqa.selenium.By;

//-- Dev by Sushma

public class AMDUpcomingPage {

	public static By objItemImage = By.xpath("//*[@resource-id='com.graymatrix.did:id/item_image']");
	
	public static By objItemReleaseDate = By.xpath("//*[@resource-id='com.graymatrix.did:id/tv_releasing_date']");
	
	public static By objItemPrimaryText = By.xpath("//*[@resource-id='com.graymatrix.did:id/item_primary_text']");
	
	public static By objItemSecondaryText = By.xpath("//*[@resource-id='com.graymatrix.did:id/item_secondary_text']");
	
	public static By objItemGenre = By.xpath("//*[@resource-id='com.graymatrix.did:id/info_genre']");
	
	public static By objItemAgeRating = By.xpath("//*[@resource-id='com.graymatrix.did:id/info_age_rating']");
	
	public static By objItemMetadata = By.xpath("//*[@resource-id='com.graymatrix.did:id/metadata']");
	
	public static By objContentCard = By.xpath("(//*[@resource-id='com.graymatrix.did:id/item_image'])[1]");
	
	public static By objContentCardTitle = By.xpath("(//*[@resource-id='com.graymatrix.did:id/item_primary_text'])[1]");	
	
	
	public static By objContentCardMetadata = By.xpath("(//*[@resource-id='com.graymatrix.did:id/item_secondary_text'])[1]");
	
	public static By objGenre = By.xpath("(//*[@resource-id='com.graymatrix.did:id/info_genre'])[1]");
	
	public static By objCertificate = By.xpath("(//*[@resource-id='com.graymatrix.did:id/info_age_rating'])[1]");
	
	public static By objTitle(String title) {
		return By.xpath("//*[@text='"+title +"']");
	}
	public static By objContentCard1 = By.xpath("(//*[@resource-id='com.graymatrix.did:id/item_image'])[1]");
	
	public static By objContentCardTitle(String title) {
		return By.xpath("(//*[@text='"+title+"']//parent::*//child::*)[3]");
	}
	
	public static By objContentGenre(String title) {
		return By.xpath("(//*[@text='"+title+"']//parent::*//child::*)[5]");
	}
	
	public static By objContentCertificate(String title) {
		return By.xpath("(//*[@text='"+title+"']//parent::*//child::*)[7]");
	}
	
	public static By objContentReleaseDate(String title) {
	return By.xpath("(//*[@text='"+title+"']//parent::*//child::*)[1]");
	}
	
	
}
