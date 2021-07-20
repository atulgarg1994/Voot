package com.zee5.DFP;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import com.extent.ExtentReporter;

public class ParseCharlesLogs {

	static int colNumber = 0;
	static ExtentReporter extent = new ExtentReporter();

	@SuppressWarnings("unused")
	public static void readDocumnet()
			throws ParserConfigurationException, SAXException, IOException, InterruptedException {
		ArrayList<String> AllCalls = new ArrayList<String>();
		File file = new File(System.getProperty("user.dir") + CharlesConfigure.charlesName);
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setValidating(false);
		dbf.setNamespaceAware(true);
		dbf.setFeature("http://xml.org/sax/features/namespaces", false);
		dbf.setFeature("http://xml.org/sax/features/validation", false);
		dbf.setFeature("http://apache.org/xml/features/nonvalidating/load-dtd-grammar", false);
		dbf.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(file);
		doc.getDocumentElement().normalize();
		validateResponse(doc);
	}

	@SuppressWarnings("unused")
	public static void validateResponse(Document doc) {
		extent.HeaderChildNode("Validation API Response");
		ArrayList<String> eachOne = new ArrayList<String>();
		NodeList node = doc.getElementsByTagName("transaction");
		System.out.println(node.getLength());
		System.out.println(node.toString());
		for (int i = 0; i < node.getLength(); i++) {
			int j = 0;
			if (node.item(i).getTextContent().trim().contains("stagingb2bapi.zee5.com")) {
				extent.extentLoggerPass("", "stagingb2bapi.zee5.com API is triggered");
				System.out.println("stagingb2bapi.zee5.com API is triggered");
				break;
			} else {
				j = i;
			}
			if (j == node.getLength() - 1) {
				extent.extentLoggerFail("", "stagingb2bapi.zee5.com API is not triggered");
				System.out.println("stagingb2bapi.zee5.com API is not triggered");
			}
		}
		for (int i = 0; i < node.getLength(); i++) {
			int j = 0;
			if (node.item(i).getTextContent().trim().contains("config.php")) {
				extent.extentLoggerPass("", "config.php API is triggered");
				System.out.println("config.php API is triggered");
				break;
			} else {
				j = i;
			}
			if (j == node.getLength() - 1) {
				extent.extentLoggerFail("", "config.php API is not triggered");
				System.out.println("config.php API is not triggered");
			}
		}
		for (int i = 0; i < node.getLength(); i++) {
			int j = 0;
			if (node.item(i).getTextContent().trim().contains("pubads.g.doubleclick.net")) {
				extent.extentLoggerPass("", "pubads.g.doubleclick.net API is triggered");
				System.out.println("pubads.g.doubleclick.net API is triggered");

				if (node.item(i).getTextContent().trim().contains("/gampad/ads?iu")) {
					System.out.println("/gampad/ads?iu is Present");
				} else {

				}

				break;
			} else {
				j = i;
			}
			if (j == node.getLength() - 1) {
				extent.extentLoggerFail("", "pubads.g.doubleclick.net API is not triggered");
				System.out.println("pubads.g.doubleclick.net API is not triggered");
			}
		}
		for (int i = 0; i < node.getLength(); i++) {
			int j = 0;
			if (node.item(i).getTextContent().trim().contains("px.moatads.com")) {
				extent.extentLoggerPass("", "px.moatads.com API is triggered");
				System.out.println("px.moatads.com API is triggered");
				break;
			} else {
				j = i;
			}
			if (j == node.getLength() - 1) {
				extent.extentLoggerFail("", "px.moatads.com API is not triggered");
				System.out.println("px.moatads.com API is not triggered");
			}
		}
	}

	@SuppressWarnings({ "resource", "unused", "rawtypes" })
	public static void oneTag(Document doc) throws IOException {
		ArrayList<String> eachOne = new ArrayList<String>();
		String array[];
		NodeList node = doc.getElementsByTagName("transaction");
		System.out.println(node.getLength());
		for (int i = 0; i < node.getLength(); i++) {
			// System.out.println("--------------------------------------------------------------");
			eachOne.add(node.item(i).getTextContent().trim());
		}
		String event = "zee5_applicaster_app_android_moat_enabled_preroll";
		for (int j = 0; j < eachOne.size(); j++) {
			if (eachOne.get(j).contains(event)) {
				System.out.println("========================================================");
				System.out.println(event + " is Present");
				System.out.println("========================================================");
				String trimString = eachOne.get(j);
				String[] delimiter = trimString.split("\n")[10].split("&");
				System.out.println(delimiter.length);
				for (int i = 0; i < delimiter.length; i++) {
					System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
					String Key = delimiter[i].split("=")[0];
					String Value = delimiter[i].split("=")[1];
					String KeyData = Key;
					String ValueData = Value.replace("%3D", "=").replace("%26", "&").replace("%2B", "+")
							.replace("%3A", ":").replace("%2F", "/");
					int preRoll = 1;
					int midRoll = 1;
					int postRoll = 1;
					InputStream ExcelFileToRead = new FileInputStream(
							System.getProperty("user.dir") + "\\DFPExcelDump" + "\\" + "DFP0091" + ".xlsx");
					XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);
					XSSFSheet sheet = wb.getSheetAt(0);
					XSSFRow row;
					XSSFCell cell;
					Iterator rows = sheet.rowIterator();
					int starRow = sheet.getFirstRowNum();
					System.out.println("Row start : " + starRow);
					int endRow = sheet.getLastRowNum();
					System.out.println("Row end : " + endRow);
					String keyFromExcel = "";
					for (int k = 0; k < endRow; k++) {
						XSSFCell KeyName = sheet.getRow(k + 1).getCell(0);
						String KeyName1 = KeyName.toString();
						int rownumberOfEvent = KeyName.getRow().getRowNum();

						if (KeyName1.equalsIgnoreCase(KeyData)) {
							System.out.println("M A T C H E D");
							writetoExcel(rownumberOfEvent, KeyData, ValueData);
						} else {
							System.out.println("* * * * * * * ");
						}
					}
				}
			} else {
				System.out.println("========================================================");
				System.out.println(event + " is not Present");
			}
		}
	}

	public static void writetoExcel(int i, String key, String value) {
		// System.out.println("WriteToExcel");

		String xlpath = System.getProperty("user.dir") + "\\DFPExcelDump" + "\\" + "DFP0091" + ".xlsx";
		String Previousdata = "";
		try {
			XSSFWorkbook myExcelBook = new XSSFWorkbook(new FileInputStream(xlpath));
			FileOutputStream output = new FileOutputStream(xlpath);
			XSSFSheet myExcelSheet = myExcelBook.getSheet("Sheet1");
			if (value.contains("preroll")) {
				colNumber = 2;
			} else if (value.contains("postroll")) {
				colNumber = 4;
			} else if (value.contains("midroll")) {
				colNumber = 3;
			}

			int rc = myExcelSheet.getLastRowNum();
			for (int noRow = 0; noRow < rc; noRow++) {
				if (myExcelSheet.getRow(noRow + 1).getCell(0).toString().equals(key)) {

					Cell celll = myExcelSheet.getRow(noRow + 1).getCell(colNumber);

					if (celll == null) {
					} else {
						Previousdata = myExcelSheet.getRow(noRow + 1).getCell(colNumber).toString();
					}
					XSSFRow row = myExcelSheet.getRow((noRow + 1));
					if (row == null) {
						row = myExcelSheet.createRow((noRow + 1));
					}
					Cell cell = null;
					if (cell == null) {
						cell = row.createCell(colNumber);
					}
					cell.setCellValue(Previousdata + "\n" + value);
					System.out.println(Previousdata + "\n" + value);
					break;
				}
			}
			myExcelBook.write(output);
			myExcelBook.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
