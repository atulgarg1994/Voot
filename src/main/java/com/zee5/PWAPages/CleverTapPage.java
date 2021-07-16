package com.zee5.PWAPages;

import org.openqa.selenium.By;

public class CleverTapPage {

	public static By objEmailID = By.xpath(".//input[@type='email']");
	
	public static By objPasswordEditBx = By.xpath(".//input[@type='password']");
	
	public static By objLoginBtn = By.xpath(".//span[text()='Log In']");
	
	public static By objSegments = By.xpath(".//*[@icon='ctleftnavicon-Segments']//child::*[contains(text(),'Segments')]");
	
	public static By objSearchField = By.xpath(".//*[@id='searchIput']");
	
	public static By objFindBtn = By.xpath(".//*[@id='searchBtn']");
	
	public static By objActivityBtn = By.xpath(".//*[@id='modeTbDash']//child::*[contains(text(),'Activity')]");
	
	public static By objEventName = By.xpath("((.//*[@class='new_day'])[1])//td/span[1]");
	
	public static By objEventProperties = By.xpath("(((.//*[@class='new_day'])[1])//td/span[1])[1]//following-sibling::*[contains(@class,'label-gray')]//span");

	public static By objSegmentsBelowFindPeople = By.xpath(".//*[@class='has-gutter-cont']//*[@class='segments']");
	
	public static By objCreateSegmentsBtn = By.id("createSegmentBtn");
	
	public static By objPastActionsBtn = By.xpath(".//*[@data-id='pastBehaviorSegment']//*[@class='segCards_title' and text()='Actions']//parent::*//child::*[@class='btn btn-small btn-primary']");
}
