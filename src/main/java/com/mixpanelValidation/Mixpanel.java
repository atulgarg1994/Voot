package com.mixpanelValidation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Reporter;
import com.aventstack.extentreports.Status;
import com.extent.ExtentReporter;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.config.EncoderConfig;
import com.jayway.restassured.response.Response;
import com.metadata.ResponseInstance;
import com.propertyfilereader.PropertyFileReader;

public class Mixpanel extends ExtentReporter {

	/**
	 * Global variables
	 */
	static String sheet = "Skip";
	static String fileName = "Skip";// ReportName;
	static String xlpath;
	static String booleanParameters = "";
	static String integerParameters = "";
	static int rownumber;
	protected static Response resp = null;
	public static String DOB;
	public static Properties FEProp = new Properties();
	private static String value;
	private static String key;
	static ExtentReporter extent = new ExtentReporter();
	static String UserID = "Unique ID";
	static String UserType = "guest";
	static String APIKey;
	static String Modelname;
	static String propValue = "Empty";
	public static boolean fetchUserdata = false;
	public static String DistinctId;
	static PropertyFileReader Prop;
	public static boolean SubcribedDetails = false;
	public static boolean Language = true;

	public static void ValidateParameter(String distinctID, String eventName)
			throws JsonParseException, JsonMappingException, IOException, InterruptedException, ParseException {
		System.out.println("Parameter Validation " + distinctID);
		Prop = new PropertyFileReader("properties/MixpanelKeys.properties");
		booleanParameters = Prop.getproperty("Boolean");
		integerParameters = Prop.getproperty("Integer");
		fileName = ReportName;
		xlpath = System.getProperty("user.dir") + "\\" + fileName + ".xlsx";
		StaticValues(distinctID);
		getParameterValue();
		fetchEvent(distinctID, eventName);
		SubcribedDetails = false;
	}

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {

//		System.out.println(System.getProperty("os.name"));
//		String distinct_id = "distinct_id";
//		System.out.println("properties[\"$" + distinct_id + "\"]==\"" + args + "\"");

//		xlpath = System.getProperty("user.dir") + "\\" + fileName + ".xlsx";
//		creatExcel();
//		parseResponse(tv);
//		fetchEvent("b10377cf504d657233894308d075a873", "Skip Login");
//		validation();
//		Instant instant = Instant.ofEpochSecond("1601475542");
//		java.util.Date time = new java.util.Date((long)1601475542*1000); 
//		System.out.println("Time : "+time);

//		PropertyFileReader Prop = new PropertyFileReader("properties/MixpanelKeys.properties");
//		booleanParameters = Prop.getproperty("Boolean");
//		integerParameters = Prop.getproperty("Integer");
//		System.out.println(Stream.of(booleanParameters).anyMatch("Ad isEmpty"::equals));
//		System.out.println(isContain(booleanParameters,"Ad isEmpty"));
//		System.out.println(Prop.getproperty("Integer"));
//		System.out.println(Prop.getproperty("String"));
//		Date date = new Date();
//		System.out.println(dateToUTC(date));
//		System.out.println(returnDuration("1601487000"));
//		long ut1 = Instant.now().getEpochSecond();
//		System.out.println(ut1);
//
//	        long ut2 = System.currentTimeMillis() / 1000L;
//	        System.out.println(ut2);
//
//	        Date now = new Date();
//	        long ut3 = now.getTime() / 1000L;
//	        System.out.println(ut3);

//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		LocalDateTime now = LocalDateTime.now();
//		String currentDate = dtf.format(now);
//		String distinct_id = "SM-M315F"; 

//		String distinct_id = "71046f70-7486-4238-9d9f-0dd6a67ede97";
//		Response request = RestAssured.given().auth().preemptive().basic("58baafb02e6e8ce03d9e8adb9d3534a6", "")
//				.config(RestAssured.config().encoderConfig(EncoderConfig.encoderConfig()))
//				.contentType("application/x-www-form-urlencoded; charset=UTF-8").formParam("from_date", currentDate)
//				.formParam("to_date", currentDate).formParam("event", "[ \"Ad View\"]")
//				.formParam("where", "properties[\"$distinct_id\"]==\"f81174907b5a4bcbe4205e4c3666f97e\"")
//				.post("https://data.mixpanel.com/api/2.0/export/");
//				.post("https://mixpanel.com/api/2.0/segmentation/");
//		request.print();
//		platform = "Android";
//		fetchEvent("SM-M205F","Video Exit");
//		modelName();
//		platform = "WEb";
//		fetchEvent("99d6fada0cd13df4a40843d16156070e","Display Language Change"); 
//		System.out.println("1989-11-20T18:30:00Z".split("T")[0]);
//		getDOB("1989-11-20T18:30:00Z".split("T")[0]);
//		System.out.println(validateEventTriggerTime("1604426176"));
//		getAdID();
//		PropertyFileReader Prop = new PropertyFileReader("properties/MixpanelKeys.properties");
//		booleanParameters = Prop.getproperty("Boolean");
//		integerParameters = Prop.getproperty("Integer");
//		fileName = "CTAs";
//		xlpath = System.getProperty("user.dir") + "\\" + fileName + ".xlsx";
//		platform = "Web";
//		fetchEvent("4b33865960727c7d933aa8e4ac03b7b8","Login Screen Display");
//		System.out.println(1612873997 <= 1612873637);
//		String empty[] = null;
//		System.out.println(empty == null);
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		String currentDate = dateFormat.format(date).toString().replaceFirst(" ", "_").replaceAll("/", "_").replaceAll(":","_");
		System.out.println(currentDate);
	}

	@SuppressWarnings("unused")
	private static void getDOB(String s) {
		LocalDate dob = LocalDate.parse(s);
		LocalDate curDate = LocalDate.now();
		System.out.println(String.valueOf(Period.between(dob, curDate).getYears()));
	}

	/**
	 * Function to fetch logs from mixpanel dash board using rest assured API
	 * 
	 * @param distinct_id
	 * @param eventName
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	public static void fetchEvent(String distinct_id, String eventName)
			throws JsonParseException, JsonMappingException, IOException {
		try {
			Thread.sleep(180000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		String currentDate = dtf.format(now); // Get current date in formate yyyy-MM-dd
		System.out.println("Current Date : " + currentDate);
		
		if (platform.equals("Android")) {
			APIKey = "b2514b42878a7e7769945befa7857ef1";
			UserID = "$model";
			distinct_id = modelName();
		} else if (platform.equalsIgnoreCase("Web") || platform.equalsIgnoreCase("MPWA")){
			APIKey = "58baafb02e6e8ce03d9e8adb9d3534a6";
			if (distinct_id.contains("-")) {
				UserID = "Unique ID";
				UserType = "Login";
			}
		}else if(platform.equals("TV")) {
			APIKey = "e45c2466330383c493ba355fd0819bf4";
			UserID = "$model";
			distinct_id = modelName();
		}
	
		Response request=null;
		for(int trial=0;trial<5;trial++) {
			request = RestAssured.given().auth().preemptive().basic(APIKey, "")
					.config(RestAssured.config().encoderConfig(EncoderConfig.encoderConfig()))
					.contentType("application/x-www-form-urlencoded; charset=UTF-8").formParam("from_date", currentDate)
					.formParam("to_date", currentDate).formParam("event", "[\"" + eventName + "\"]")
					.formParam("where", "properties[\"" + UserID + "\"]==\"" + distinct_id + "\"")
					.post("https://data.mixpanel.com/api/2.0/export/");
			if(request.equals(null) || request.equals("")) extent.extentLogger("", "Failed to fetch MP Response");
			else break;
		}
		
		System.out.println("Response : "+request.asString());
		sheet = eventName.trim().replace(" ", "").replace("/", "");
		if (request.toString() != null) {
			if (platform.equals("Android")) {
				parseResponse(getLatestEvent(request));
			} else {
				String response = request.asString();
				String s[] = response.split("\n");
//				String time = checkLatestEvent(s[s.length - 1]);
//				if(time == null) {
					parseResponse(s[s.length - 1]);
//				}else {
//					System.out.println("Event not triggered");
//					extentReportFail("Event not triggered", "Event not triggered");
//					return;
//				}
			}
			validation();
		}else {
			System.out.println("Event not triggered");
			extentReportFail("Event not triggered", "Event not triggered");
		}
	}

	public static String checkLatestEvent(String s) {
		String empty = null;
		String commaSplit[] = s.replace("\"properties\":{", "").replace("}", "").replaceAll("[.,](?=[^\\[]*\\])", "-")
				.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
		String com[] = commaSplit[1].split(":(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
		int MPTime = Integer.valueOf(com[1].replace("\"", "").replace("$", ""));
		long currentTime = Instant.now().getEpochSecond();
		long subCurrentTime = (currentTime - 360);
		if (subCurrentTime <= MPTime) {
			return s;
		}
		return empty;
	}
	
	
	/**
	 * Parse the response and split the response
	 * 
	 * @param reponse
	 */
	public static void parseResponse(String response) {
		String commaSplit[] = response.replace("\"properties\":{", "").replace("}", "")
				.replaceAll("[.,](?=[^\\[]*\\])", "-").split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
		creatExcel(); // Create an excel file
		for (int i = 0; i < commaSplit.length; i++) {
			if (i != 0) {
				String com[] = commaSplit[i].split(":(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
				/** Write key value into excel */
				write(i, com[0].replace("\"", "").replace("$", ""), com[1].replace("\"", "").replace("$", ""));
			}
		}
	}

	@SuppressWarnings("unused")
	private static boolean validateEventTriggerTime(String time) {
		int eventTime = Integer.valueOf(time);
		int elapseTime = (eventTime + 360);
		System.out.println(eventTime + "  " + elapseTime);
		if (eventTime < elapseTime) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Function to create excel file of format .xlsx Function to create sheet
	 */
	public static void creatExcel() {
		try {
			File file = new File(xlpath);
			if (!file.exists()) {
				XSSFWorkbook workbook = new XSSFWorkbook();
				workbook.createSheet(sheet); // Create sheet
				FileOutputStream fos = new FileOutputStream(new File(xlpath));
				workbook.write(fos);
				workbook.close();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Function to write values into excel
	 * 
	 * @param i
	 * @param parameter
	 */
	public static void write(int i, String key, String value) {
		try {
			XSSFWorkbook myExcelBook = new XSSFWorkbook(new FileInputStream(xlpath));
			FileOutputStream output = new FileOutputStream(xlpath);
			XSSFSheet myExcelSheet = myExcelBook.getSheet(sheet);
			XSSFRow row = myExcelSheet.createRow(i);
			if (row == null) {
				row = myExcelSheet.createRow(i); // create row if not created
			}
			row.createCell(0).setCellValue(key); // write parameter key into excel into first column
			row.createCell(1).setCellValue(value); // write parameter value into excel second column
			myExcelBook.write(output);
			myExcelBook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Validation
	 */
	public static void validation() {
		int NumberOfRows = getRowCount();
		System.out.println(NumberOfRows);
		extent.HeaderChildNode("Parameter Validation");
		if(NumberOfRows != 0) {
		for (rownumber = 1; rownumber < NumberOfRows; rownumber++) {
			try {
				XSSFWorkbook myExcelBook = new XSSFWorkbook(new FileInputStream(xlpath));
				XSSFSheet myExcelSheet = myExcelBook.getSheet(sheet);
				value = myExcelSheet.getRow(rownumber).getCell(1).toString();
				key = myExcelSheet.getRow(rownumber).getCell(0).toString();
				if (value.trim().isEmpty()) {
					System.out.println("Paramter is empty :- Key:" + key + " - value" + value);
					extentReportFail("Empty parameter",
							"Paramter is empty :- <b>Key : " + key + " \n value : " + value + "</b>");
					fillCellColor();
				} else {
					if (isContain(booleanParameters, key)) {
						validateBoolean(value);
					} else if (isContain(integerParameters, key)) {
						validateInteger(value);
					}else if (isContain(integerParameters, key)) {
						validateFloat(value);
					}
					validateParameterValue(key, value);
//					extentInfo();
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		}else {
			System.out.println("Event not triggered");
			extentReportFail("Event not triggered", "Event not triggered");
		}
		FEProp.clear();
	}

	public static void validateParameterValue(String key, String value) {
		try {
			propValue = FEProp.getProperty(key);
			if(key.equalsIgnoreCase("Publishing date")) {
				propValue = propValue.split("T")[0];
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (propValue != null) {
			if (propValue.equals("[]")) {
				propValue = "N/A";
			}
			if (!propValue.replaceAll("\\s", "").equalsIgnoreCase(value.replaceAll("\\s", ""))) {
				fillCellColor();
				extentReportFail("Parameter", "Parameter : <b>Key : " + key + " <br/> value : " + value + "<br/>Expected Value : "+propValue+"</b>");
			}else {
				extentReportInfo("Parameter", "Parameter : <b>Key : " + key + " <br/> value : " + value + "<br/>Expected Value : "+propValue+"</b>");
			}
		}
	}

	/**
	 * Get Row count
	 */
	// Generic method to return the number of rows in the sheet.
	public static int getRowCount() {
		int rc = 0;
		try {
			System.out.println(xlpath);
			FileInputStream fis = new FileInputStream(xlpath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet s = wb.getSheet(sheet);
			rc = s.getLastRowNum();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rc;
	}

	private static void validateInteger(String value) {
		if (!value.equals("N/A")) {
			Pattern p = Pattern.compile("[0-9]+");
			Matcher m = p.matcher(value);
			if (!m.matches()) {
				fillCellColor();
				extentReportFail("Empty parameter",
						"Value is not a Integer Data-Type :- <b>Key : " + key + " <br/> value : " + value + "</b>");
			}
		}
	}

	private static void validateFloat(String value) {
		if (!value.equals("N/A")) {
//			Pattern p = Pattern.compile("[0-9]+");
//			Matcher m = p.matcher(value);
//			if (!m.matches()) {
//				fillCellColor();
//				extentReportFail("Empty parameter",
//						"Value is not a Integer Data-Type :- <b>Key : " + key + " <br/> value : " + value + "</b>");
//			}
		}
	}
	
	private static boolean isContain(String source, String subItem) {
		String pattern = "\\b" + subItem + "\\b";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(source);
		return m.find();
	}

	private static void validateBoolean(String value) {
		if (!value.equals("N/A")) {
			if (!Stream.of("true", "false", "TRUE", "FALSE").anyMatch(value::equals)) {
				fillCellColor();
				extentReportFail("Empty parameter",
						"Value is not a boolean Data-Type :- <b>Key : " + key + " <br/> value : " + value + "</b>");
			}
		}
	}

	public static void fillCellColor() {
		try {
			XSSFWorkbook myExcelBook = new XSSFWorkbook(new FileInputStream(xlpath));
			XSSFSheet myExcelSheet = myExcelBook.getSheet(sheet);
			Row Cellrow = myExcelSheet.getRow(rownumber);
			XSSFCellStyle cellStyle = myExcelBook.createCellStyle();
			cellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
			cellStyle.setFillPattern(FillPatternType.FINE_DOTS);
			if (Cellrow.getCell(0) == null) {
				Cellrow.createCell(0);
			}
			Cell cell1 = Cellrow.getCell(0);
			cell1.setCellStyle(cellStyle);
			FileOutputStream fos = new FileOutputStream(new File(xlpath));
			myExcelBook.write(fos);
			fos.close();
		} catch (Exception e) {
		}
	}

	public static void StaticValues(String UniqueID) throws ParseException {
		platform = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getSuite().getName();
		if (platform.equals("Mpwa")) {
			FEProp.setProperty("Platform Name", "Web");
			FEProp.setProperty("os", "Android");
		} else if (platform.equals("Android")) {
			FEProp.setProperty("Platform Name", platform);
			FEProp.setProperty("os", "Android");
		} else if (platform.equals("Web")) {
			FEProp.setProperty("Platform Name", platform);
			FEProp.setProperty("os", System.getProperty("os.name").split(" ")[0]);
		}
		Mixpanel.FEProp.setProperty("Landing Page Name", "home");
		Mixpanel.FEProp.setProperty("Unique ID", UniqueID);
		
		userType = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("userType");
		
		if(userType.equals("Guest")) {
			if(SubcribedDetails == false) {
			Mixpanel.FEProp.setProperty("Gender", "N/A");
			Mixpanel.FEProp.setProperty("Age", "N/A");
			Mixpanel.FEProp.setProperty("Free Trial Expiry Date", "N/A");
			Mixpanel.FEProp.setProperty("Free Trial Package", "N/A");
			Mixpanel.FEProp.setProperty("Latest Subscription Pack", "N/A");
			Mixpanel.FEProp.setProperty("Latest Subscription Pack Expiry", "N/A");
			Mixpanel.FEProp.setProperty("Next Expiring Pack", "N/A");
			Mixpanel.FEProp.setProperty("Next Pack Expiry Date", "N/A");
			Mixpanel.FEProp.setProperty("Pack Duration", "N/A");
			Mixpanel.FEProp.setProperty("Parent Control Setting", "N/A");
			Mixpanel.FEProp.setProperty("User Type", "guest");
			Mixpanel.FEProp.setProperty("Partner Name", "N/A");
			Mixpanel.FEProp.setProperty("HasRental", "false");
			Mixpanel.FEProp.setProperty("hasEduauraa", "false");
			if(Language != false) {
			Mixpanel.FEProp.setProperty("New App Language", "en");
			Mixpanel.FEProp.setProperty("New Content Language", "[en-kn]");
			}
			}
		}else if(userType.equals("NonSubscribedUser"))
		{
			NonSubcribedDetails();
		}else if(userType.equals("SubscribedUser")) {
			SubcribedDetails();
		}
	}
	
	public static void NonSubcribedDetails() {
		Prop = new PropertyFileReader("properties/MixpanelKeys.properties");
		Mixpanel.FEProp.setProperty("Free Trial Expiry Date", Prop.getproperty("NonSub_Free_Trial_Expiry_Date"));
		Mixpanel.FEProp.setProperty("Free Trial Package", Prop.getproperty("NonSub_Free_Trial_Package"));
		Mixpanel.FEProp.setProperty("Latest Subscription Pack", Prop.getproperty("NonSub_Latest_Subscription_Pack"));
		Mixpanel.FEProp.setProperty("Latest Subscription Pack Expiry", Prop.getproperty("NonSub_Latest_Subscription_Pack_Expiry"));
		Mixpanel.FEProp.setProperty("Next Expiring Pack", Prop.getproperty("NonSub_Next_Expiring_Pack"));
		Mixpanel.FEProp.setProperty("Next Pack Expiry Date", Prop.getproperty("NonSub_Next_Pack_Expiry_Date"));
		Mixpanel.FEProp.setProperty("Pack Duration", Prop.getproperty("NonSub_Pack_Duration"));
		Mixpanel.FEProp.setProperty("HasRental", Prop.getproperty("NonSub_HasRental"));
		Mixpanel.FEProp.setProperty("hasEduauraa", Prop.getproperty("NonSub_hasEduauraa"));
		SubcribedDetails = true;
	}
	
	public static void SubcribedDetails() throws ParseException {	
		String UserType;
		UserType = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("userType");
		String username = null,password = null;
		if(UserType.equals("SubscribedUser")) {
			username = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("SubscribedUserName");
			password = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("SubscribedUserPassword");
		}
		Response subscriptionResp=ResponseInstance.getSubscriptionDetails(username, password);
		int subscriptionItems=subscriptionResp.jsonPath().get("subscription_plan.size()");		
		String id=subscriptionResp.jsonPath().get("subscription_plan["+(subscriptionItems-1)+"].id").toString();
		String subscription_plan_type=subscriptionResp.jsonPath().get("subscription_plan["+(subscriptionItems-1)+"].subscription_plan_type").toString();
		String title=subscriptionResp.jsonPath().get("subscription_plan["+(subscriptionItems-1)+"].title").toString();
		String Latest_Subscription_Pack=id+"_"+title+"_"+subscription_plan_type;
		String packExpiry=subscriptionResp.jsonPath().get("subscription_end["+(subscriptionItems-1)+"]").toString();
		SimpleDateFormat requiredFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		java.text.DateFormat actualFormat = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		actualFormat.setTimeZone(java.util.TimeZone.getTimeZone("GMT"));
		java.util.Date packExpiryDate = actualFormat.parse(packExpiry);
		String Latest_Subscription_Pack_Expiry=requiredFormat.format(packExpiryDate).toString();
		String Next_Expiring_Pack="["+Latest_Subscription_Pack+"]";
		String Next_Pack_Expiry_Date=Latest_Subscription_Pack_Expiry;
		String billing_frequency=subscriptionResp.jsonPath().get("subscription_plan["+(subscriptionItems-1)+"].billing_frequency").toString();	
		Response tvodResp=ResponseInstance.getTVODDetails(username, password);
		int tvodItems=tvodResp.jsonPath().get("playback_state.size()");
		String HasRental="";
		try {			
			if(tvodResp.jsonPath().get("playback_state["+(tvodItems-1)+"]").toString().equalsIgnoreCase("purchased")) HasRental="true";
			else HasRental="false";
		}catch(Exception e) {HasRental="false";}
		
		Response settingsResp=ResponseInstance.getSettingsDetails(username, password);
		String hasEduauraa="false",key="";
		int pairs=settingsResp.jsonPath().get("key.size()");
		for (int i=0;i<pairs;i++) {
			key=settingsResp.jsonPath().get("key["+i+"]").toString();
			if(key.equals("eduauraaClaimed")) { 			
				hasEduauraa=settingsResp.jsonPath().get("value["+i+"]").toString();
				if(hasEduauraa.equals("")) hasEduauraa="false";
				break;
			}
		}
		Mixpanel.FEProp.setProperty("Free Trial Expiry Date", "N/A");
		Mixpanel.FEProp.setProperty("Free Trial Package", "N/A");		
		Mixpanel.FEProp.setProperty("Latest Subscription Pack", Latest_Subscription_Pack);
		Mixpanel.FEProp.setProperty("Latest Subscription Pack Expiry", Latest_Subscription_Pack_Expiry);
		Mixpanel.FEProp.setProperty("Next Expiring Pack", Next_Expiring_Pack);
		Mixpanel.FEProp.setProperty("Next Pack Expiry Date", Next_Pack_Expiry_Date);
		Mixpanel.FEProp.setProperty("Pack Duration", billing_frequency);
		Mixpanel.FEProp.setProperty("HasRental", HasRental);
		Mixpanel.FEProp.setProperty("hasEduauraa", hasEduauraa);
	}

	@SuppressWarnings("static-access")
	public static void extentReportFail(String info, String details) {
		extent.childTest.get().log(Status.FAIL, details);
	}

	@SuppressWarnings("static-access")
	public static void extentReportInfo(String info, String details) {
		extent.childTest.get().log(Status.INFO, details);
	}

	
	
	public static void extentInfo() {
		try {
			if (propValue.equals("Empty")) {
				extentReportInfo("Empty parameter", "Parameter :- <b>Key : " + key + " <br/> value : " + value);
			} else {
				extentReportInfo("Empty parameter", "Parameter :- <b>Key : " + key + " <br/> value : " + value
					+ "<br/> Expected value : " + propValue + "</b>");
			}
		}catch(Exception e) {
			extentReportInfo("Empty parameter", "Parameter :- <b>Key : " + key + " <br/> value : " + value);
		}
	}

	public static String modelName() {
		try {
			String cmd3 = "adb shell getprop ro.product.model";
			Process process = Runtime.getRuntime().exec(cmd3);
			BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
			Modelname = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Modelname;
	}

	public static void getParameterValue() {
		UserType = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("userType");
		String pUsername = null;
		String pPassword = null;
		if (!UserType.equals("Guest")) {
			if (!fetchUserdata) {
				if(UserType.equals("NonSubscribedUser")) {
				 pUsername = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
						.getParameter("NonSubscribedUserName");
				pPassword = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
						.getParameter("NonSubscribedUserPassword");
				}else if(UserType.equals("SubscribedUser")) {
					pUsername = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
							.getParameter("SubscribedUserName");
					pPassword = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
							.getParameter("SubscribedUserPassword");
				}
				ResponseInstance.getUserData(pUsername, pPassword);
				ResponseInstance.getUserSettingsValues(pUsername, pPassword);
			}
		}
		fetchUserdata = false;
	}

	public static void getAdID() {
		try {
			String cmd3 = "adb shell \"grep adid_key /data/data/com.google.android.gms/shared_prefs/adid_settings.xml\"";
			Process process = Runtime.getRuntime().exec(cmd3);
			BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
			Modelname = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(Modelname);
	}
	
	public static String getLatestEvent(Response responseEvent) {
		try {
		String response = responseEvent.asString();
		String s[] = response.split("\n");
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < s.length; i++) {
			String commaSplit[] = s[i].replace("\"properties\":{", "").replace("}", "")
					.replaceAll("[.,](?=[^\\[]*\\])", "-").split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
			String com[] = commaSplit[1].split(":(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
			list.add(Integer.valueOf(com[1].replace("\"", "").replace("$", "")));
			System.out.println(Integer.valueOf(com[1].replace("\"", "").replace("$", "")));
		}
		System.out.println(String.valueOf(Collections.max(list)));
		for(int i = 0; i < s.length; i++) {
			if(s[i].contains(String.valueOf(Collections.max(list)))) {
//				System.out.println(s[i]);
				return s[i];
			}
		}
		}catch(Exception e) {
			
		}
		return "";
	}
	
	// added by Kushal
	
	public static String fetchContentId(String distinct_id, String eventName)
			throws JsonParseException, JsonMappingException, IOException {
		try {
			Thread.sleep(180000);
		} catch (InterruptedException e) {
		}
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		String currentDate = dtf.format(now); // Get current date in formate yyyy-MM-dd
		System.out.println("Current Date : " + currentDate);
		if (platform.equals("Android")) {
			APIKey = "b2514b42878a7e7769945befa7857ef1";
			UserID = "$model";
			distinct_id = modelName();
		} else {
			APIKey = "58baafb02e6e8ce03d9e8adb9d3534a6";
			if (distinct_id.contains("-")) {
				UserID = "Unique ID";
				UserType = "Login";
			}
		}
		Response request = RestAssured.given().auth().preemptive().basic(APIKey, "")
				.config(RestAssured.config().encoderConfig(EncoderConfig.encoderConfig()))
				.contentType("application/x-www-form-urlencoded; charset=UTF-8").formParam("from_date", currentDate)
				.formParam("to_date", currentDate).formParam("event", "[\"" + eventName + "\"]")
				.formParam("where", "properties[\"" + UserID + "\"]==\"" + distinct_id + "\"")
				.post("https://data.mixpanel.com/api/2.0/export/");
		request.print();
		String getContentId = null,getDistinctId=null;
		sheet = eventName.trim().replace(" ", "");
		if (request.toString() != null) {
			if (platform.equals("Web") || platform.equals("MPWA")) {
				parseResponse(getLatestEvent(request));
			} else {
				String response = request.asString();
				String s[] = response.split("\n");
				parseResponse(s[s.length - 1]);
				System.out.println("LATEST RESPONSE: \n"+s[s.length - 1]);
				getContentId = parseContentId(s[s.length-1]);
				getDistinctId= parseDistinctId(s[s.length-1]);
				DistinctId = getDistinctId;
			}
		}else {
			System.out.println("Event not triggered");
			extentReportFail("Event not triggered", "Event not triggered");
		}
		return getContentId;
	}
	
	public static String parseContentId(String response) {
		String strContentID = response.split("Content ID")[1].split(",")[0].replace("\":\"", "").replace("\"", "");
		System.out.println("CONTENT ID : "+strContentID);
		return strContentID;
	}


	public static String parseDistinctId(String response) {
		String strDistinctID = response.split("distinct_id")[1].split(",")[0].replace("\":\"", "").replace("\"", "");
		System.out.println("Distinct ID : " + strDistinctID);
		return strDistinctID;
	}

	public static void parentalValidateParameter(String distinctID, String eventName)
			throws JsonParseException, JsonMappingException, IOException, InterruptedException, ParseException {
		System.out.println("Parameter Validation " + distinctID);
		PropertyFileReader Prop = new PropertyFileReader("properties/MixpanelKeys.properties");
		booleanParameters = Prop.getproperty("Boolean");
		integerParameters = Prop.getproperty("Integer");
		fileName = ReportName;
		xlpath = System.getProperty("user.dir") + "\\" + fileName + ".xlsx";
		StaticValues(distinctID);
		getParentalParameterValue();
		fetchEvent(distinctID, eventName);
	}

	public static void getParentalParameterValue() {
		UserType = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("userType");
		if (!UserType.equals("Guest")) {
			if (!fetchUserdata) {
				String pUsername = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
						.getParameter("SettingsNonSubscribedUserName");
				String pPassword = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
						.getParameter("SettingsNonSubscribedPassword");
				ResponseInstance.getUserData(pUsername, pPassword);
			}
		}
	}
	
	public String languageShortform(String lang) {
		PropertyFileReader handler = new PropertyFileReader("properties/MixpanelKeys.properties");
		String lng = handler.getproperty(lang.toLowerCase());
		return lng;
	}

}
