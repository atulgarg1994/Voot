package com.zee5.PWAPages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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
	
	public static By objTime = By.xpath("((.//*[@class='new_day'])[1])//td[1]");
	
	public static By objEventProperties = By.xpath("(((.//*[@class='new_day'])[1])//td/span[1])[1]//following-sibling::*[contains(@class,'label-gray')]//span");

	public static By objSegmentsBelowFindPeople = By.xpath(".//*[@class='has-gutter-cont']//*[@class='segments']");
	
	public static By objCreateSegmentsBtn = By.id("createSegmentBtn");
	
	public static By objPastActionsBtn = By.xpath(".//*[@data-id='pastBehaviorSegment']//*[@class='segCards_title' and text()='Actions']//parent::*//child::*[@class='btn btn-small btn-primary']");

	public static By objEventDD = By.xpath("(.//*[@class='v-align-middle-children grid']//*[@class='chzn-single'])[1]");
	
	public static By objSearchEvent = By.xpath("//*[@id=\"evtSelection1_chzn\"]/*[@class='chzn-drop']/*[@class='chzn-search']/input");
	
	public static By objHighlightedOptionBtn = By.xpath(".//*[@class='group-option active-result result-selected highlighted']");
	
	public static By objFilterByBtn = By.xpath(".//*[@class='filterClass']");
	
	public static By SystemPropertiesDD = By.xpath("//*[@id=\"selPM8_chzn\"]/a");
	
	public static By objSystemPropertiesSearchBtn = By.xpath("//*[@id=\"selPM8_chzn\"]/*[@class='chzn-drop']/*[@class='chzn-search']/input");
	
	public static By objSystemPropertiesSearchResultBtn = By.xpath("(.//*[@class='active-result group-option']/em[text()='Email'])[1]");
	
	public static By objInputValue = By.xpath("//*[@id=\"FEQuery1\"]/div[2]/div/div/div[3]/div[1]/div/span[2]/div[3]/div/input");
	
	
//	Campaign
	public static void main(String[] args) throws ParseException {
		 String startTime = "03:08:18 pm";
		    String endTime = "03:08:17 pm";
		    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss a");
		    Date d1 = sdf.parse(startTime);
		    Date d2 = sdf.parse(endTime);
		    long elapsed = (d2.getTime() - d1.getTime()); 
		    System.out.println(elapsed/(1000));
	}
	
}
