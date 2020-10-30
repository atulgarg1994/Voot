package com.mixpanelValidation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
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
	static String UserID = "$distinct_id";
	static String UserType = "guest";
	static String platform;
	static String APIKey;
	static String Modelname;
	public static boolean fetchUserdata = false;

	public static void ValidateParameter(String distinctID, String eventName)
			throws JsonParseException, JsonMappingException, IOException, InterruptedException {
		System.out.println("Parameter Validation " + distinctID);
		PropertyFileReader Prop = new PropertyFileReader("properties/MixpanelKeys.properties");
		booleanParameters = Prop.getproperty("Boolean");
		integerParameters = Prop.getproperty("Integer");
		fileName = ReportName;
		xlpath = System.getProperty("user.dir") + "\\" + fileName + ".xlsx";
		StaticValues();
		getParameterValue();
		fetchEvent(distinctID, eventName);
	}

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {

		System.out.println(System.getProperty("os.name"));
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
//		Response request = RestAssured.given().auth().preemptive().basic("b2514b42878a7e7769945befa7857ef1", "")
//				.config(RestAssured.config().encoderConfig(EncoderConfig.encoderConfig()))
//				.contentType("application/x-www-form-urlencoded; charset=UTF-8").formParam("from_date", currentDate)
//				.formParam("to_date", currentDate).formParam("event", "[ \"Login Password Entered\"]")
//				.formParam("where", "properties[\"$distinct_id\"]==\"" + distinct_id + "\"")
//				.post("https://data.mixpanel.com/api/2.0/export/");
////				.post("https://mixpanel.com/api/2.0/segmentation/");
//		request.print();
//		platform = "Android";
//		fetchEvent("SM-M205F","Video Exit");
//		modelName();
//		platform = "WEb";
//		fetchEvent("99d6fada0cd13df4a40843d16156070e","Display Language Change"); 
		System.out.println("1989-11-20T18:30:00Z".split("T")[0]);
		getDOB("1989-11-20T18:30:00Z".split("T")[0]);
	}
	
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
	@SuppressWarnings("unused")
	public static void fetchEvent(String distinct_id, String eventName)
			throws JsonParseException, JsonMappingException, IOException {
		try {
			Thread.sleep(60000);
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
		sheet = eventName.trim().replace(" ", "");
		if (request != null) {
			String response = request.asString();
			String s[] = response.split("\n");
			parseResponse(s[s.length - 1]);
			validation();
		} else {
			System.out.println("Event not triggered");
			extentReportFail("Event not triggered", "Event not triggered");
		}
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
					}
					validateParameter(key, value);
					extentReportInfo("Empty parameter",
							"Paramter :- <b>Key : " + key + " <br/> value : " + value + "</b>");
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public static void validateParameter(String key, String value) {
		String propValue = null;
		try {

			propValue = FEProp.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (propValue != null) {
			if (propValue.equals("[]")) {
				propValue = "N/A";
			}
			if (!propValue.equalsIgnoreCase(value)) {
				fillCellColor();
				extentReportFail("Empty parameter", "Value mismatch :- <b>Key : " + key + " <br/> value : " + value
						+ "<br/> API value : " + propValue + "</b>");
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

	private static boolean isContain(String source, String subItem) {
		String pattern = "\\b" + subItem + "\\b";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(source);
		return m.find();
	}

	private static void validateBoolean(String value) {
		if (!value.equals("N/A")) {
			if (!Stream.of("true", "false").anyMatch(value::equals)) {
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

	public static void StaticValues() {
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
		Mixpanel.FEProp.setProperty("region", ResponseInstance.getRegion());
	}

	@SuppressWarnings("static-access")
	public static void extentReportFail(String info, String details) {
		extent.childTest.get().log(Status.FAIL, details);
	}

	@SuppressWarnings("static-access")
	public static void extentReportInfo(String info, String details) {
		extent.childTest.get().log(Status.INFO, details);
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
		if (!UserType.equals("Guest")) {
			if (!fetchUserdata) {
				String pUsername = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
						.getParameter(UserType+"Name");
				String pPassword = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
						.getParameter(UserType+"Password");
				ResponseInstance.getUserData(pUsername, pPassword);
			}
		}
	}
}
