package com.metadata;

import static com.jayway.restassured.RestAssured.given;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.testng.Reporter;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.mixpanelValidation.Mixpanel;
import com.propertyfilereader.PropertyFileReader;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Stream;

public class ResponseInstance {

	protected static Response resp = null;

	public static Response getResponse() {
		resp = given().urlEncodingEnabled(false).when().get(
				"https://gwapi.zee5.com/content/collection/0-8-homepage?limit=20&page=1&item_limit=20&desc=no&version=6&translation=en&languages=en,kn&country=IN");
		return resp;
	}

	public static Response getResponse(String URL) {
		resp = given().urlEncodingEnabled(false).when().get(URL);
		return resp;
	}

	public static void traysTitle() {
		int numberOfTrays = getResponse().jsonPath().getList("buckets").size();
		for (int i = 1; i < numberOfTrays; i++) {
			System.out.println(getResponse().jsonPath().getString("buckets[" + i + "].title"));
		}
	}

	public static ArrayList<String> traysIndiviualTags(String NameOfTheTray) {
		ArrayList<String> Arraytags = new ArrayList<String>();
		int numberOfTrays = getResponse().jsonPath().getList("buckets").size();
		for (int i = 1; i < numberOfTrays; i++) {
			String TrayName = getResponse().jsonPath().getString("buckets[" + i + "].title");
			int numberOfitmesTrays = getResponse().jsonPath().getList("buckets[" + i + "].items").size();
			if (TrayName.equals(NameOfTheTray)) {
				for (int j = 0; j < numberOfitmesTrays; j++) {
					Arraytags.add(getResponse().jsonPath().getString("buckets[" + i + "].items[" + j + "].title"));
				}
				break;
			}
			if (Arraytags.size() > 0) {
				break;
			}
		}
		return Arraytags;
	}

	public static ArrayList<String> ContentOfViewAll() {
		ArrayList<String> contentFromViewAll = new ArrayList<String>();
		for (int i = 1; i <= 3; i++) {
			String page1 = "https://gwapi.zee5.com/content/collection/0-8-2074?page=" + i
					+ "&limit=20&desc=no&country=IN&languages=en,kn&translation=en&version=6";
			resp = given().urlEncodingEnabled(false).when().get(page1);
			int sizeOfAnItem = resp.jsonPath().getList("buckets[0].items").size();
			if (sizeOfAnItem > 0) {
				for (int j = 0; j < sizeOfAnItem; j++) {
					contentFromViewAll.add(resp.jsonPath().getString("buckets[0].items[" + j + "].title"));
					System.out.println(contentFromViewAll);
				}
			}
		}
		return contentFromViewAll;
	}

	public static ArrayList<String> getCollectionContent(String CollectionName) {

		ArrayList<String> contentList = new ArrayList<String>();
		int sizeOfAnCollection = 0;
		int NumberOfCollection = resp.jsonPath().getList("buckets[0].items").size();
		for (int i = 0; i < NumberOfCollection; i++) {
			if (resp.jsonPath().getString("").equals(CollectionName)) {
				sizeOfAnCollection = resp.jsonPath().getList("buckets[0].items").size();
				for (int j = 0; j < sizeOfAnCollection; j++) {
					contentList.add(resp.jsonPath().getString(""));
				}
			}
			if (sizeOfAnCollection > 0) {
				break;
			}
		}
		return contentList;
	}

//	BASAVARAJ
	public static Response getRECOResponse(String URL, String username, String password) {
		Response respp = null;
		String Uri = URL;
		respp = given()
				.headers("X-ACCESS-TOKEN", getXAccessToken(), "Authorization", getBearerToken(username, password))
				.when().get(Uri);
		System.out.println(respp.getBody());
		return respp;
	}

	/**
	 * Function to return X-ACCESS TOKEN
	 * 
	 * @param page
	 * @return
	 */
	public static String getXAccessToken() {
		Response resp = null;
		String xAccessToken = "";
		String url = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("url");
		resp = given().urlEncodingEnabled(false).when().get(url);
		String respString = resp.getBody().asString();
		respString = respString.replace("\"gwapiPlatformToken\":\"\"", "");
		respString = respString.split("\"gwapiPlatformToken\":\"")[1];
		xAccessToken = respString.split("\"")[0];
		return xAccessToken;
	}
	
	public static String getXAccessToken1() {
		Response respToken = null, respForKey = null;
		// get APi-KEY
		String Uri = "https://gwapi.zee5.com/user/getKey?=aaa";
		respForKey = given().urlEncodingEnabled(false).when().get(Uri);
		String rawApiKey = respForKey.getBody().asString();
		String apiKeyInResponse = rawApiKey.substring(0, rawApiKey.indexOf("<br>airtel "));
		String finalApiKey = apiKeyInResponse.replaceAll("<br>rel - API-KEY : ", "");
		String UriForToken = "http://gwapi.zee5.com/user/getToken";
		respToken = given().headers("API-KEY", finalApiKey).when().get(UriForToken);
		String xAccessToken = respToken.jsonPath().getString("X-ACCESS-TOKEN");
		return xAccessToken;
	}

	/**
	 * Function to return Bearer token
	 * 
	 * @param email, password
	 * @return bearer token
	 */
	public static String getBearerToken(String email, String password) {
		JSONObject requestParams = new JSONObject();
		requestParams.put("email", email);
		requestParams.put("password", password);
		RequestSpecification req = RestAssured.given();
		req.header("Content-Type", "application/json");
		req.config(com.jayway.restassured.RestAssured.config().encoderConfig(com.jayway.restassured.config.EncoderConfig
				.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)));
		req.body(requestParams.toString());
		Response resp = req.post("https://userapi.zee5.com/v2/user/loginemail");
		String accesstoken = resp.jsonPath().getString("access_token");
		String tokentype = resp.jsonPath().getString("token_type");
		String bearerToken = tokentype + " " + accesstoken;
		return bearerToken;
	}

	/**
	 * Get Recommendation data for the tab
	 * 
	 * @param tab
	 * @return reco response
	 */
	public static Response getRecoDataFromTab(String userType, String tab, String contLang) {
		Response respReco = null;
		if (tab.equalsIgnoreCase("shows")) {
			tab = "tvshows";
		} else if (tab.equalsIgnoreCase("premium")) {
			tab = "premiumcontents";
		} else if (tab.equalsIgnoreCase("home")) {
			tab = "homepage";
		} else if (tab.equalsIgnoreCase("kids")) {
			tab = "3673";
		} else if (tab.equalsIgnoreCase("videos")) {
			tab = "5011";
		} else if (tab.equalsIgnoreCase("movies")) {
			tab = "movies";
		} else if (tab.equalsIgnoreCase("music")) {
			tab = "2707";
		} else if (tab.equalsIgnoreCase("zeeoriginals")) {
			tab = "zeeoriginals";
		} else if (tab.equalsIgnoreCase("news")) {
			tab = "626";
		}
		Response regionResponse = given().urlEncodingEnabled(false).when().get("https://xtra.zee5.com/country");
		String region = regionResponse.getBody().jsonPath().getString("state_code");
		String Uri;
		if(Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getSuite().getName().equals("TV")) {
			Uri = "https://gwapi.zee5.com/content/reco?country=IN&translation=en&languages=" + contLang
					+ "&version=9&collection_id=0-8-" + tab + "&region=" + region;
		}else {
		 Uri = "https://gwapi.zee5.com/content/reco?country=IN&translation=en&languages=" + contLang
				+ "&version=6&collection_id=0-8-" + tab + "&region=" + region;
		}
		String xAccessToken = getXAccessToken();
		if (userType.equalsIgnoreCase("Guest")) {
			// Get Guest Token
			JSONObject requestParams = new JSONObject();
			requestParams.put("aid", "91955485578");
			requestParams.put("apikey", "6BAE650FFC9A3CAA61CE54D");
			requestParams.put("DekeyVal", "Z5G211");
			requestParams.put("UserAgent", "pwaweb");
			RequestSpecification request = RestAssured.given();
			request.header("Content-Type", "application/json");
			request.config(com.jayway.restassured.RestAssured.config()
					.encoderConfig(com.jayway.restassured.config.EncoderConfig.encoderConfig()
							.appendDefaultContentCharsetToContentTypeIfUndefined(false)));
			request.body(requestParams.toString());
			Response response = request.post("https://whapi-prod-node.zee5.com/fetchGuestToken");
			String guestToken = response.jsonPath().get("guest_user").toString();
			respReco = given().headers("x-access-token", xAccessToken).header("x-z5-guest-token", guestToken).when()
					.get(Uri);
		} else if (userType.equalsIgnoreCase("SubscribedUser")) {
			String email = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("SubscribedUserName");
			String password = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("SubscribedPassword");
			String bearerToken = getBearerToken(email, password);
			respReco = given().headers("x-access-token", xAccessToken).header("authorization", bearerToken).when()
					.get(Uri);
		} else if (userType.equalsIgnoreCase("NonSubscribedUser")) {
			String email = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("NonsubscribedUserName");
			String password = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("NonsubscribedPassword");
			String bearerToken = getBearerToken(email, password);
			respReco = given().headers("x-access-token", xAccessToken).header("authorization", bearerToken).when()
					.get(Uri);
		} else {
		}
		respReco.body().print();
		return respReco;
	}

	/**
	 * Get Recommendation data for the content
	 * 
	 * @param tab
	 * @return reco response
	 */
	public static Response getRecoTraysInDetailsPage(String userType, String contentID) {
		Response respReco = null;
		String Uri = "https://gwapi.zee5.com/content/reco?asset_id=" + contentID
				+ "&country=IN&translation=en&languages=en,kn&version=6&region=KA";
		System.out.println("Hitting content api:\n" + Uri);
		String xAccessToken = getXAccessToken();
		if (userType.equalsIgnoreCase("Guest")) {
			respReco = given().headers("x-access-token", xAccessToken).header("x-z5-guest-token", "12345").when()
					.get(Uri);
		} else if (userType.equalsIgnoreCase("SubscribedUser")) {
			String email = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("SubscribedUserName");
			String password = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("SubscribedPassword");
			String bearerToken = getBearerToken(email, password);
			respReco = given().headers("x-access-token", xAccessToken).header("authorization", bearerToken).when()
					.get(Uri);
		} else if (userType.equalsIgnoreCase("NonSubscribedUser")) {
			String email = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("NonsubscribedUserName");
			String password = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("NonsubscribedPassword");
			String bearerToken = getBearerToken(email, password);
			respReco = given().headers("x-access-token", xAccessToken).header("authorization", bearerToken).when()
					.get(Uri);
		} else {
			System.out.println("Incorrect user type passed to method");
		}
		respReco.body().print();
		return respReco;
	}

	/**
	 * Function to tray list on carousel for different pages
	 * 
	 * @param page
	 * @return
	 */
	public static List<String> traysTitleCarousel(String page) {
		Response responseCarouselTitle = getResponseForPages(page);
		List<String> titleOnCarouselList = new LinkedList<String>();
		int numberOfCarouselSlides = responseCarouselTitle.jsonPath().getList("buckets[0].items").size();
		System.out.println("api size : " + numberOfCarouselSlides);
		for (int i = 0; i < numberOfCarouselSlides; i++) {
			String title = responseCarouselTitle.jsonPath().getString("buckets[0].items[" + i + "].title");
			titleOnCarouselList.add(title);
		}
		return titleOnCarouselList;
	}

	/**
	 * Function to return response for different pages
	 * 
	 * @param page
	 * @return
	 */
	public static Response getResponseForPages(String page) {
		Response respCarousel = null;
		String Uri ;
		if (page.equals("news")) {
			page = "626";
		} else if (page.equals("music")) {
			page = "2707";
		} else if (page.equals("home")) {
			page = "homepage";
		}else if(page.equals("live tv")) {
			Uri = "https://catalogapi.zee5.com/v1/channel/genres?translation=en&country=IN";
		}
			Uri = "https://gwapi.zee5.com/content/collection/0-8-" + page
				+ "?page=1&limit=5&item_limit=20&country=IN&translation=en&languages=en,kn&version=6";
		respCarousel = given().urlEncodingEnabled(false).when().get(Uri);
		return respCarousel;
	}

	/**
	 * Method to get content details passing content ID
	 * 
	 */
	public static Response getContentDetails(String contentID, String contentType) {
		Response respContentDetails = null;
		String Uri = "";
		if (contentType.equals("original")) {
			Uri = "https://gwapi.zee5.com/content/tvshow/" + contentID + "?translation=en&country=IN";
		} else if (contentType.contentEquals("Manual")) {
			Uri = "https://gwapi.zee5.com/content/collection/" + contentID + "?translation=en&country=IN";
		} else {
			Uri = "https://gwapi.zee5.com/content/details/" + contentID + "?translation=en&country=IN&version=2";
		}
		respContentDetails = given().when().get(Uri);
		// System.out.println("Content Details API Response:
		// "+respContentDetails.getBody().asString());
		return respContentDetails;
	}

	/**
	 * Function to return response for different pages
	 * 
	 * @param page
	 * @return
	 */
	public static Response getResponseForPages(String page, String contLang) {
		Response respCarousel = null;
		String Uri = "";
		if (page.equals("news")) {
			page = "5857";
		} else if (page.equals("music")) {
			page = "2707";
		} else if (page.equals("home")) {
			page = "homepage";
		} else if (page.equals("kids")) {
			page = "3673";
		} else if (page.equals("freemovies")) {
			page = "5011";
		} else if (page.equals("play")) {
			page = "4603";
		} else if (page.equals("zeeoriginals") || page.equals("zee5 originals")) {
			page = "zeeoriginals";
		} else if (page.equals("videos")) {
			page = "videos";
		} else if (page.equals("movies")) {
			page = "movies";
		} else if (page.equals("shows")) {
			page = "tvshows";
		} else if (page.equals("premium")) {
			page = "premiumcontents";
		} else if (page.equals("club")) {
			page = "5851";
		}
		if (page.equals("stories")) {
			Uri = "https://zeetv.zee5.com/wp-json/api/v1/featured-stories";
		} else if(page.equals("live tv")) {
			Uri = "https://catalogapi.zee5.com/v1/channel/genres?translation=en&country=IN";
		}else {
			Uri = "https://gwapi.zee5.com/content/collection/0-8-" + page
					+ "?page=1&limit=5&item_limit=20&country=IN&translation=en&languages=" + contLang + "&version=10";
			System.out.println(Uri);
		}
		respCarousel = given().headers("X-ACCESS-TOKEN", getXAccessToken()).when().get(Uri);
		System.out.println("Response status : " + respCarousel.statusCode());
		// System.out.println("Response Body : "+respCarousel.getBody().asString());
		return respCarousel;
	}

	/**
	 * Function to tray list on carousel for different pages
	 * 
	 * @param page
	 * @return
	 */
	public static List<String> traysTitleCarousel(String page, String contLang) {
		Response responseCarouselTitle = getResponseForPages(page, contLang);
		List<String> titleOnCarouselList = new LinkedList<String>();
		int numberOfCarouselSlides = 0;
		String title = "";
		if (page.equals("stories")) {
			numberOfCarouselSlides = responseCarouselTitle.jsonPath().getList("posts").size();
		} else {
			numberOfCarouselSlides = responseCarouselTitle.jsonPath().getList("buckets[0].items").size();
		}
		System.out.println("api size : " + numberOfCarouselSlides);
		if (numberOfCarouselSlides > 7)
			numberOfCarouselSlides = 7;
		for (int i = 0; i < numberOfCarouselSlides; i++) { // Only 7 tray visible on UI
			if (page.equals("stories")) {
				title = responseCarouselTitle.jsonPath().getString("posts[" + i + "].title");
			} else {
				title = responseCarouselTitle.jsonPath().getString("buckets[0].items[" + i + "].title");
			}
			titleOnCarouselList.add(title);
		}
		return titleOnCarouselList;
	}

	public static Response getResponseForPages2(String page, String contLang, int q) {
		Response respCarousel = null;
		String Uri = "";
		if (page.equals("news")) {
			page = "626";
		} else if (page.equals("music")) {
			page = "2707";
		} else if (page.equals("home")) {
			page = "homepage";
		} else if (page.equals("kids")) {
			page = "3673";
		} else if (page.equals("freemovies")) {
			page = "5011";
		} else if (page.equals("play")) {
			page = "4603";
		}

		if (page.equals("stories")) {
			Uri = "https://zeetv.zee5.com/wp-json/api/v1/featured-stories";
		} else {
			Uri = "https://gwapi.zee5.com/content/collection/0-8-" + page + "?page=" + q
					+ "&limit=5&item_limit=20&country=IN&translation=en&languages=" + contLang + "&version=6";
		}

		respCarousel = given().headers("X-ACCESS-TOKEN", getXAccessToken()).when().get(Uri);
		System.out.println("Response status : " + respCarousel.statusCode());
		return respCarousel;
	}

	public static Response getResponseForUpcomingPage() {
		Response respCarousel = null;

		String Url = "https://gwapi.zee5.com/content/collection/0-8-3367?page=1&limit=10&item_limit=20&translation=en&country=IN&languages=en,kn&version=6&";
		respCarousel = given().urlEncodingEnabled(false).when().get(Url);
		return respCarousel;
	}

	public static Response getResponseForApplicasterPages(String userType, String page) {
		Response respHome = null;
		String language = getLanguage(userType);
		String Uri = "https://gwapi.zee5.com/content/collection/0-8-" + page
				+ "?page=1&limit=10&item_limit=20&translation=en&country=IN&version=6&languages=" + language;
		System.out.println(Uri);

		String xAccessToken = getXAccessTokenWithApiKey();
		if (userType.equalsIgnoreCase("Guest")) {
			respHome = given().headers("x-access-token", xAccessToken).when().get(Uri);
		} else if (userType.equalsIgnoreCase("SubscribedUser")) {
			String email = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("SubscribedUserName");
			String password = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("SubscribedPassword");
			String bearerToken = getBearerToken(email, password);
			respHome = given().headers("x-access-token", xAccessToken).header("authorization", bearerToken).when()
					.get(Uri);
		} else if (userType.equalsIgnoreCase("NonSubscribedUser")) {
			String email = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("NonsubscribedUserName");
			String password = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("NonsubscribedPassword");
			String bearerToken = getBearerToken(email, password);
			respHome = given().headers("x-access-token", xAccessToken).header("authorization", bearerToken).when()
					.get(Uri);
		} else {
			System.out.println("Incorrect user type passed to method");
		}
		return respHome;
	}

	// Getting Content Language API response for the NonSubscribedUser and
	// SubscribedUser ..

	// Getting API response ::

	public static Response getUserinfoforNonSubORSub(String userType) {
		Response resp = null;

		String url = "https://userapi.zee5.com/v1/settings";

		String xAccessToken = getXAccessTokenWithApiKey();
//					if (userType.equalsIgnoreCase("Guest")) {
//						resp = given().headers("x-access-token", xAccessToken).header("x-z5-guest-token", "12345").when()
//								.get(url);
//					} else
		if (userType.equalsIgnoreCase("SubscribedUser")) {
//						String email="zeetest998@test.com";
//						String password ="123456";
			String email = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("SubscribedUserName");
			String password = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("SubscribedPassword");
			String bearerToken = getBearerToken(email, password);
			resp = given().headers("x-access-token", xAccessToken).header("authorization", bearerToken).when().get(url);
		} else if (userType.equalsIgnoreCase("NonSubscribedUser")) {
//						String email="igstesting001@gmail.com";
			// String password ="igs@12345";
			String email = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("NonsubscribedUserName");
			String password = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("NonsubscribedPassword");
			String bearerToken = getBearerToken(email, password);
			resp = given().headers("x-access-token", xAccessToken).header("authorization", bearerToken).when().get(url);
		} else {
			System.out.println("Incorrect user type passed to method");
		}

		return resp;

	}

	// Fetching language from response ::
	public static String getLanguage(String userType) {
		String language = null;
		if (userType.contains("Guest")) {
			language = "en,kn";
		} else {
			Response resplanguage = getUserinfoforNonSubORSub(userType);
			// System.out.println(resplanguage.print());

			// System.out.println(resplanguage.jsonPath().getList("array").size());

			for (int i = 0; i < resplanguage.jsonPath().getList("array").size(); i++) {

				String key = resplanguage.jsonPath().getString("[" + i + "].key");
				// System.out.println(language);
				if (key.contains("content_language")) {
					language = resplanguage.jsonPath().getString("[" + i + "].value");
					System.out.println("UserType Language: " + language);
					break;
				}
			}
		}
		return language;
	}

	public static String getXAccessTokenWithApiKey() {
		Response respToken = null, respForKey = null;
		// get APi-KEY
		String Uri = "https://gwapi.zee5.com/user/getKey?=aaa";
		respForKey = given().urlEncodingEnabled(false).when().get(Uri);
		String rawApiKey = respForKey.getBody().asString();
		String apiKeyInResponse = rawApiKey.substring(0, rawApiKey.indexOf("<br>airtel "));
		String finalApiKey = apiKeyInResponse.replaceAll("<br>rel - API-KEY : ", "");
		String UriForToken = "http://gwapi.zee5.com/user/getToken";
		respToken = given().headers("API-KEY", finalApiKey).when().get(UriForToken);
		String xAccessToken = respToken.jsonPath().getString("X-ACCESS-TOKEN");
		return xAccessToken;
	}

	public static Response getRespofCWTray(String userType) {
		Response respCW = null;
		String language = getLanguage(userType);

		String Uri = "https://gwapi.zee5.com/user/v2/watchhistory?country=IN&translation=en&languages=" + language;

		String xAccessToken = getXAccessTokenWithApiKey();

		if (userType.equalsIgnoreCase("Guest")) {
			respCW = given().headers("x-access-token", xAccessToken).when().get(Uri);
		} else if (userType.equalsIgnoreCase("SubscribedUser")) {
//			String email = "zeetest998@test.com";
//			String password = "123456";
			String email = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("SubscribedUserName");
			String password = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("SubscribedPassword");
			String bearerToken = getBearerToken(email, password);
			respCW = given().headers("x-access-token", xAccessToken).header("authorization", bearerToken).when()
					.get(Uri);
		} else if (userType.equalsIgnoreCase("NonSubscribedUser")) {

//			String email = "igstesting001@gmail.com";
//			String password = "igs@12345";
			String email = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("NonsubscribedUserName");
			String password = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("NonsubscribedPassword");
			String bearerToken = getBearerToken(email, password);
			respCW = given().headers("x-access-token", xAccessToken).header("authorization", bearerToken).when()
					.get(Uri);
		} else {
			System.out.println("Incorrect user type passed to method");
		}
		return respCW;
	}

	public static Response getResponseForApplicasterPagesVersion2(String userType, String page, String pUsername,
			String pPassword) {
		Response respHome = null;
		String language = getLanguageVersion2(userType, pUsername, pPassword);
		String Uri = "https://gwapi.zee5.com/content/collection/0-8-" + page
				+ "?page=1&limit=10&item_limit=20&translation=en&country=IN&version=6&languages=" + language;

		String xAccessToken = getXAccessTokenWithApiKey();
		if (userType.equalsIgnoreCase("Guest")) {
			respHome = given().headers("x-access-token", xAccessToken).when().get(Uri);
		} else if (userType.equalsIgnoreCase("SubscribedUser")) {
			String bearerToken = getBearerToken(pUsername, pPassword);
			respHome = given().headers("x-access-token", xAccessToken).header("authorization", bearerToken).when()
					.get(Uri);
		} else if (userType.equalsIgnoreCase("NonSubscribedUser")) {
			String bearerToken = getBearerToken(pUsername, pPassword);
			respHome = given().headers("x-access-token", xAccessToken).header("authorization", bearerToken).when()
					.get(Uri);
		} else {
			System.out.println("Incorrect user type passed to method");
		}
		return respHome;
	}

	public static String getLanguageVersion2(String userType, String pUsername, String pPassword) {
		String language = null;
		if (userType.contains("Guest")) {
			language = "en,kn";
		} else {
			Response resplanguage = getUserinfoforNonSubORSubversion2(userType, pUsername, pPassword);
			// System.out.println(resplanguage.print());
			// System.out.println(resplanguage.jsonPath().getList("array").size());

			for (int i = 0; i < resplanguage.jsonPath().getList("array").size(); i++) {

				String key = resplanguage.jsonPath().getString("[" + i + "].key");
				// System.out.println(language);
				if (key.contains("content_language")) {
					language = resplanguage.jsonPath().getString("[" + i + "].value");
					System.out.println("UserType Language: " + language);
					break;
				}
			}
		}
		return language;
	}

	public static Response getUserinfoforNonSubORSubversion2(String userType, String pUsername, String pPassword) {
		Response resp = null;
		String url = "https://userapi.zee5.com/v1/settings";
		String xAccessToken = getXAccessTokenWithApiKey();

		if (userType.equalsIgnoreCase("SubscribedUser") | userType.equalsIgnoreCase("NonSubscribedUser")) {
			String bearerToken = getBearerToken(pUsername, pPassword);
			resp = given().headers("x-access-token", xAccessToken).header("authorization", bearerToken).when().get(url);
		} else {
			System.out.println("Incorrect user type passed to method");
		}
		return resp;
	}

	public static boolean BeforeTV(String UserType, String tabName) {
		Response resp = null;
		boolean title = false;
		String xAccessToken = getXAccessTokenWithApiKey();
		if (tabName.equals("Home")) {
			resp = given().headers("x-access-token", xAccessToken).when().get(
					"https://gwapi.zee5.com/content/collection/0-8-homepage?page=1&limit=10&item_limit=20&translation=en&country=IN&version=6&languages=en,kn&");
		} else if (tabName.equals("Show")) {
			resp = given().headers("x-access-token", xAccessToken).when().get(
					"https://gwapi.zee5.com/content/collection/0-8-tvshows?page=1&limit=10&item_limit=20&translation=en&country=IN&version=6&languages=en,kn&");
		}

		for (int i = 0; i < resp.jsonPath().getList("buckets").size(); i++) {
			title = resp.jsonPath().getString("buckets[" + i + "].title").contains("Premiere Episodes | Before");
			if (title) {
				break;
			}
		}
		return title;
	}

//			:::::::::::::::Mixpanel:::::::::::::::::::::: 

	public static void main(String[] args) throws Exception {
//		getResponseForApplicasterPages("Guest", "3673").print();
//		System.out.println(BeforeTV("Guest","Home"));
//		getUserData();
//		getRegion();
//		getresponse("kam");
//		getDetailsOfCustomer("zeetest@gmail.com","zee123");
//		getUserSettingsDetails("","");	
//		getFreeContent("home", "zee5latest@gmail.com", "User@123");
//		getContentDetails("0-0-232924","originals");
//		Player("basavaraj.pn5@gmail.com","igsindia123");
//		getWatchList("basavaraj.pn5@gmail.com","igsindia123");
//		getUserData("basavaraj.pn5@gmail.com","igsindia123");
//		getUserOldSettingsDetails("amdnonmixpanel@yopmail.com","123456");
//		ValidateRailsAndContents("Guest","Movies");
//		getUserData("amdnonmixpanel@yopmail.com","123456");
//		ArrayList<List<String>> AL = new ArrayList<List<String>>();
//		List<String> List = new ArrayList<String>();
//		
//		for(int i=0;i<10;i++) {
//			if(i<5) {
//					List.add(String.valueOf(i));
//			}else if(i>5) {
//				List.add(String.valueOf(i));
//			}
//			if(i == 5) {
//				AL.add(List);
//			}else if(i == 9) {
//				AL.add(List);
//			}
//		}
//		System.out.println(AL);
//		subscriptionDetails();
//		getSubscriptionDetails("zeetest10@test.com", "123456");
//		resp = given().headers("x-access-token", getXAccessToken()).when().get("https://gwapi.zee5.com/content/details/0-0-manual_5dtffmaonrs0?translation=en&country=IN&version=2");
//		resp.prettyPrint();
//		getTrayNameFromPage("home");
		getPageResponse("home","premium_downloadable");
	}

	public static Properties getUserSettingsDetails(String pUsername, String pPassword) {
		Properties pro = new Properties();
		if (!pUsername.equals("")) {
			String bearerToken = getBearerToken(pUsername, pPassword);
			resp = given().headers("x-access-token", getXAccessTokenWithApiKey()).header("authorization", bearerToken)
					.when().get("https://userapi.zee5.com/v1/settings");

			String[] comm = resp.asString().replace("{", "").replace("}", "").replace("[", "").replace("]", "")
					.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
			System.out.println(comm.length);
			String value = null;
			for (int i = 0; i < comm.length;) {
				String key = comm[i].replace("\"", "").split("y:")[1];
				try {
					value = comm[i + 1].replace("\"", "").split("e:")[1];
				} catch (Exception e) {
					value = "Empty";
				}
				if (value.contains("age_rating")) {
					key = "Parent Control Setting";
					value = value.replace("\\", "").split(":")[1].replace(", pin", "");
				}
				pro.setProperty(key, value);
				i = i + 2;
			}
		}
		return pro;
	}

	@SuppressWarnings("unused")
	public static void getUserData(String pUsername,String pPassword) {
		String[] userData = { "email", "first_name", "last_name", "birthday", "gender", "registration_country",
				"recurring_enabled" };
		Properties pro = new Properties();
		String xAccessToken = getXAccessTokenWithApiKey();
		String bearerToken = getBearerToken(pUsername, pPassword);
		String url = "https://userapi.zee5.com/v1/user";
		resp = given().headers("x-access-token", xAccessToken).header("authorization", bearerToken).when().get(url);
		resp.print();
		String commaSplit[] = resp.asString().replace("{", "").replace("}", "").replaceAll("[.,](?=[^\\[]*\\])", "-")
				.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
		for (int i = 0; i < commaSplit.length; i++) {
			if (Stream.of(userData).anyMatch(commaSplit[i]::contains)) {
				String com[] = commaSplit[i].split(":(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
				Mixpanel.FEProp.setProperty(com[0].replace("\"", ""), com[1].replace("\"", ""));
			}
		}
		getDOB();
		Mixpanel.fetchUserdata = true;
	}
	
	private static void getDOB() {
		System.out.println(Mixpanel.FEProp.getProperty("birthday").split("T")[0]);
		LocalDate dob = LocalDate.parse(Mixpanel.FEProp.getProperty("birthday").split("T")[0]);
		LocalDate curDate = LocalDate.now();
		Mixpanel.FEProp.setProperty("Age",String.valueOf((Period.between(dob, curDate).getYears())+1));
	}

	public static String getRegion() {
		Response regionResponse = given().urlEncodingEnabled(false).when().get("https://xtra.zee5.com/country");
		return regionResponse.getBody().jsonPath().getString("state");
	}

	public static String getresponse(String searchText) {
		Response resp = given().urlEncodingEnabled(false).when().get("https://gwapi.zee5.com/content/search_all?q="
				+ searchText
				+ "&limit=10&asset_type=0,6,1&country=IN&languages=hi,en,mr,te,kn,ta,ml,bn,gu,pa,hr,or&translation=en&version=3&");
		return resp.jsonPath().getString("results[0].total");
	}

	public static String getFreeContent(String tabName, String pUsername, String pPassword) {
		PropertyFileReader handler = new PropertyFileReader("properties/MixpanelKeys.properties");
		String language;
		String pageName = handler.getproperty(tabName.toLowerCase());
		if (!pUsername.equals("")) {
			Properties prop = getUserSettingsDetails(pUsername, pPassword);
			System.out.println(prop.getProperty("content_language"));
			language = prop.getProperty("content_language");
		} else {
			language = "en,kn";
		}
		String url = "https://gwapi.zee5.com/content/collection/0-8-" + pageName
				+ "?page=1&limit=5&item_limit=20&country=IN&translation=en&languages=" + language + "&version=6";
		String xAccessToken = getXAccessTokenWithApiKey();
		if (!pUsername.equals("")) {
			String bearerToken = getBearerToken(pUsername, pPassword);
			resp = given().headers("x-access-token", xAccessToken).header("authorization", bearerToken).when().get(url);
		} else {
			resp = given().headers("x-access-token", xAccessToken).when().get(url);
		}
		String title = "No Free Contents";
		for (int i = 0; i < 7; i++) {
			if (resp.jsonPath().getString("buckets[0].items[" + i + "].business_type").equals("free")) {
				title = resp.jsonPath().getString("buckets[0].items[" + i + "].title");
				if (!title.contains("HiPi")) {
					System.out.println(title);
					break;
				}
			}
		}
		
		if(!pUsername.equals("")) {
			getUserData(pUsername,pPassword);
		}
		return title;
	}
	
	public static Properties getUserOldSettingsDetails(String pUsername, String pPassword) {
		Properties pro = new Properties();
		if (!pUsername.equals("")) {
			String bearerToken = getBearerToken(pUsername, pPassword);
			resp = given().headers("x-access-token", getXAccessTokenWithApiKey()).header("authorization", bearerToken)
					.when().get("https://userapi.zee5.com/v1/settings");

			String[] comm = resp.asString().replace("{", "").replace("}", "").replace("[", "").replace("]", "")
					.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
			String value = null;
			for (int i = 0; i < comm.length;) {
				String key = comm[i].replace("\"", "").split("y:")[1];
				try {
					value = comm[i + 1].replace("\"", "").split("e:")[1];
				} catch (Exception e) {
					value = "Empty";
				}
				if (value.contains("age_rating")) {
					key = "Parent Control Setting";
					value = value.replace("\\", "").split(":")[1].replace(", pin", "");
				}
				pro.setProperty(key, value);
				i = i + 2;
			}
		}
		pro.forEach((key, value) -> System.out.println(key + " : " + value));
		return pro;
	}
	
	public static void getContentDetails(String ID) {
		System.out.println("Content ID :"+ID);
		resp = given().headers("x-access-token", getXAccessTokenWithApiKey()).when().get("https://gwapi.zee5.com/content/details/"+ID+"?translation=en&country=IN&version=2");
//		resp = given().headers("x-access-token", getXAccessTokenWithApiKey()).when().get("https://gwapi.zee5.com/content/details/0-1-84080?translation=en&country=IN&version=2");
		Mixpanel.FEProp.setProperty("Content Duration", resp.jsonPath().getString("duration"));
		Mixpanel.FEProp.setProperty("Content ID", resp.jsonPath().getString("id"));
		Mixpanel.FEProp.setProperty("Content Name", resp.jsonPath().getString("original_title"));
		Mixpanel.FEProp.setProperty("Content Specification", resp.jsonPath().getString("asset_subtype"));
		Mixpanel.FEProp.setProperty("Characters",resp.jsonPath().getList("actors").toString().replaceAll(",","-").replaceAll("\\s", ""));
		Mixpanel.FEProp.setProperty("Audio Language",resp.jsonPath().getList("audio_languages").toString().replace("[", "").replace("]", ""));
		Mixpanel.FEProp.setProperty("Subtitle Language", resp.jsonPath().getString("subtitle_languages").toString());
		Mixpanel.FEProp.setProperty("Content Type",resp.jsonPath().getString("business_type"));
		Mixpanel.FEProp.setProperty("Genre",resp.jsonPath().getList("genre.id").toString().replaceAll(",","-").replaceAll("\\s", ""));
		Mixpanel.FEProp.setProperty("Content Original Language",resp.jsonPath().getString("languages").replace("[", "").replace("]", ""));
//		if(resp.jsonPath().getString("is_drm").equals("1")) {
		Mixpanel.FEProp.setProperty("DRM Video",resp.jsonPath().getString("is_drm"));
//		}else {
//			Mixpanel.FEProp.setProperty("DRM Video","false");
//		}
//		resp.print();
//		Mixpanel.FEProp.forEach((key, value) -> System.out.println(key + " : " + value));
		}
	
	
	public static void Player(String pUsername, String pPassword) {
		String url = "https://gwapi.zee5.com/content/player/0-1-136585";
		String bearerToken = getBearerToken(pUsername, pPassword);
		resp = given().headers("x-access-token", getXAccessTokenWithApiKey()).header("authorization", bearerToken).when().get(url);
		resp.print();
	}
	
	@SuppressWarnings("unused")
	public static void getWatchList(String pUsername, String pPassword) {
		String url = "https://userapi.zee5.com/v1/watchlist";
		String bearerToken = getBearerToken(pUsername, pPassword);
		System.out.println(getXAccessTokenWithApiKey()+"\n");
		System.out.println(bearerToken);
//		resp = given().headers("x-access-token", getXAccessTokenWithApiKey()).header("authorization", bearerToken).when().get(url);
//		resp.print();
	}
	
	
	public static String getLanguage1(String userType)
	{
		String language = null;
		if(userType.contains("Guest"))
		{
			language = "en,hi,kn";
		}else{
			Response resplanguage = ResponseInstance.getUserinfoforNonSubORSub(userType);			
		//	System.out.println(resplanguage.print());
			//System.out.println(resplanguage.jsonPath().getList("array").size());
			for(int i=0 ; i<resplanguage.jsonPath().getList("array").size() ; i++)
			{
				String key = resplanguage.jsonPath().getString("["+i+"].key");
			//	System.out.println(language);
				if(key.contains("content_language"))
				{
					language = resplanguage.jsonPath().getString("["+i+"].value");
					System.out.println("UserType Language: "+language);
					break;
				}
			}
		}
		return language;
	}
	
	public static void getContentDetailsForNews(String ID) {
		resp = given().headers("x-access-token", getXAccessTokenWithApiKey()).when().get("https://gwapi.zee5.com/content/details/" + ID + "?translation=en&country=IN&version=2");
		Mixpanel.FEProp.setProperty("Content Duration", resp.jsonPath().getString("duration"));
		Mixpanel.FEProp.setProperty("Content ID", resp.jsonPath().getString("id"));
		Mixpanel.FEProp.setProperty("Content Name", resp.jsonPath().getString("original_title"));
		Mixpanel.FEProp.setProperty("Characters",resp.jsonPath().getList("actors").toString().replaceAll(",", "-").replaceAll("\\s", ""));
		Mixpanel.FEProp.setProperty("Audio Language",resp.jsonPath().getList("audio_languages").toString().replace("[", "").replace("]", ""));
		Mixpanel.FEProp.setProperty("Subtitle Language", resp.jsonPath().getString("subtitle_languages").toString());
		Mixpanel.FEProp.setProperty("Content Type", resp.jsonPath().getString("business_type"));
		Mixpanel.FEProp.setProperty("Genre",resp.jsonPath().getList("genre.id").toString().replaceAll(",", "-").replaceAll("\\s", ""));
		Mixpanel.FEProp.setProperty("Content Original Language",resp.jsonPath().getString("languages").replace("[", "").replace("]", ""));
//		if(resp.jsonPath().getString("is_drm").equals("1")) {
		Mixpanel.FEProp.setProperty("DRM Video", resp.jsonPath().getString("is_drm"));
//		}else {
//			Mixpanel.FEProp.setProperty("DRM Video","false");
//		}
//		Mixpanel.FEProp.forEach((key, value) -> System.out.println(key + " : " + value));
	}

	public static Response getResponseDetails(String contentID) {

		Response responseRAW = null;
		String URI = "https://gwapi.zee5.com/content/details/" + contentID + "?translation=en&country=IN&version=2";
		responseRAW = given().headers("X-ACCESS-TOKEN", getXAccessTokenAMD()).when().get(URI);
		System.out.println("\n" + URI);
		if (responseRAW.statusCode() != 200) {
			System.out.println(responseRAW.getStatusLine() + " | Content ID: " + contentID);
		}
		return responseRAW;
	}

	public static String getXAccessTokenAMD() {
		Response respToken = null, respForKey = null;
		// get APi-KEY
		String Uri = "https://gwapi.zee5.com/user/getKey?=aaa";
		respForKey = given().urlEncodingEnabled(false).when().get(Uri);
		String rawApiKey = respForKey.getBody().asString();
		String apiKeyInResponse = rawApiKey.substring(0, rawApiKey.indexOf("<br>airtel "));
		String finalApiKey = apiKeyInResponse.replaceAll("<br>rel - API-KEY : ", "");
		String UriForToken = "http://gwapi.zee5.com/user/getToken";
		respToken = given().headers("API-KEY", finalApiKey).when().get(UriForToken);
		String xAccessToken = respToken.jsonPath().getString("X-ACCESS-TOKEN");
		return xAccessToken;
	}

	public static Response getResponseForAppPages(String page, String contLang) {
		Response respCarousel = null;
		String Url = "";
		switch (page.toLowerCase()) {
			case "news":
				page = "5857";
				break;
			
			case "music":
				page = "2707";
				break;
			
			case "home":
				page = "homepage";
				break;
			
			case "kids":
				page = "3673";
				break;
		
			case "freemovies":
				page = "5011";
				break;
			
			case "videos":
				page = "videos";
				break;
			
			case "movies":
				page = "movies";
				break;
				
			case "shows":
				page = "tvshows";
				break;

			case "premium":
				page = "premiumcontents";
				break;
				
			case "club":
				page = "5851";
				break;
				
			case "zeeoriginals":
				page = "5851";
				break;
				
			case "zee5 originals":
				page = "5851";
				break;
					
			case "live tv":
				Url = "https://catalogapi.zee5.com/v1/channel/genres?translation=en&country=IN";
				System.out.println(Url);
				break;
				
			case "stories":
				Url = "https://zeetv.zee5.com/wp-json/api/v1/featured-stories";
				break;
		}
	
		if(Url.length() == 0) {
			Url = "https://gwapi.zee5.com/content/collection/0-8-" + page+ "?page=1&limit=5&item_limit=20&country=IN&translation=en&languages=" + contLang + "&version=10";
			System.out.println(Url);
		}
		
		respCarousel = given().headers("X-ACCESS-TOKEN", getXAccessTokenAMD()).when().get(Url);
		System.out.println("Response status : " + respCarousel.statusCode());
		return respCarousel;
	}
	
public static String getTrayNameFromPage(String pTabName) {
		
		String tabName = pTabName;
		resp=ResponseInstance.getResponseForAppPages(tabName,"en,kn");
		System.out.println(resp.toString());
		
		String assettype="",contentID="",contentName="",pTrayName="",topCatogery="";
		if(tabName.equalsIgnoreCase("live tv")) {
			pTrayName = resp.jsonPath().get("genres[0].value");
			System.out.println(pTrayName);
		}else {
			for (int i = 1; i < 5; i++) {
				assettype = resp.jsonPath().get("buckets[" + i + "].items[0].asset_type").toString();
				pTrayName = resp.jsonPath().get("buckets[" + i + "].title").toString();
				if (assettype.equals("0") || assettype.equals("1")) {
					contentID = resp.jsonPath().get("buckets[" + i + "].items[0].id").toString();
					contentName = resp.jsonPath().get("buckets[" + i + "].items[0].title").toString();
					topCatogery = resp.jsonPath().get("buckets[" + i + "].items[0].asset_subtype").toString();
					
					System.out.println("\nTrayName: " + pTrayName);
					System.out.println("ContentID: " + contentID);
					System.out.println("ContentName: " + contentName);
					System.out.println("Top Category: " + topCatogery);
					System.out.println("Vertical Index: " + i);
					break;
				}
			}

			Response contentResp = null, subContentResp = null;
			contentResp = getResponseDetails(contentID);
			System.out.println("RESPONSE StatusCode: " + contentResp.statusCode());

			int relatedNodelength = contentResp.jsonPath().getList("related").size();
			System.out.println("Related Node: " + relatedNodelength);
			String newContentId = null;
			String pCharacters = null;
			if (relatedNodelength >= 1) {
				newContentId = contentResp.jsonPath().get("related[0].id");
				System.out.println("Related Node is Present | contentID: " + newContentId);
				subContentResp = getResponseDetails(newContentId);
				System.out.println("RESPONSE StatusCode: " + subContentResp.statusCode());

				String pOriginalTitle = subContentResp.jsonPath().get("original_title");
				int contentDuration = subContentResp.jsonPath().get("duration");
				String pDuration = Integer.toString(contentDuration);
				String onAir = subContentResp.jsonPath().get("on_air");
				String pBussinessType = subContentResp.jsonPath().get("business_type");
				String pImgURL = subContentResp.jsonPath().get("image_url");
				int assetType = subContentResp.jsonPath().get("asset_type");
				String pContentSpecification = subContentResp.jsonPath().get("asset_subtype");
				int episode = subContentResp.jsonPath().get("episode_number");
				String pEpisodeNum = Integer.toString(episode);
				String release_date = subContentResp.jsonPath().get("release_date").toString();
				String pPublishedDate = release_date.replace(release_date.substring(10), "");
				String pContentBillingType = subContentResp.jsonPath().get("billing_type");
				if (pContentBillingType.length() == 0) {
					pContentBillingType = "N/A";
				}

				int languageCount = subContentResp.jsonPath().getList("languages").size();
				String pLanguages = null;
				if (languageCount > 1) {
					System.out.println("MULTIPLE LANGUAGES");
				} else if (languageCount == 1) {
					pLanguages = subContentResp.jsonPath().get("languages[0]");
				} else {
					System.out.println("Original Languages is Empty");
				}

				int audioLangCount = subContentResp.jsonPath().getList("audio_languages").size();
				String pAudioLangguage = null;
				if (audioLangCount > 1) {
					System.out.println("AUDIO LANGUAGES");
				} else if (audioLangCount == 1) {
					pAudioLangguage = subContentResp.jsonPath().get("audio_languages[0]");
				} else {
					pAudioLangguage = "N/A";
					System.out.println("Audio Language is Empty");
				}

				int subTitleLangCount = subContentResp.jsonPath().getList("subtitle_languages").size();
				String pSubTitleLangguage = null;
				if (subTitleLangCount > 1) {
					System.out.println("SUBTITLE LANGUAGES");
				} else if (subTitleLangCount == 1) {
					pSubTitleLangguage = subContentResp.jsonPath().get("subtitle_languages[0]");
				} else {
					System.out.println("Subtitle Language is Empty");
					pSubTitleLangguage = "N/A";
				}

				int genreCount = subContentResp.jsonPath().getList("genres").size();
				String pGenre = null;
				for (int i = 0; i < genreCount; i++) {
					if (genreCount == 1) {
						pGenre = subContentResp.jsonPath().get("genre[" + i + "].value");
					} else {
						pGenre = pGenre + " - " + subContentResp.jsonPath().get("genre[" + i + "].value");
					}
				}
				pGenre = pGenre.replace("null - ", "");

				int actorsCount = subContentResp.jsonPath().getList("actors").size();
				ArrayList<String> getCharacters = new ArrayList<String>();
				if (actorsCount >= 1) {
					for (int j = 0; j < actorsCount; j++) {
						getCharacters.add(subContentResp.jsonPath().get("actors[" + j + "]").toString());
					}
					pCharacters = getCharacters.toString();
				} else if (tabName.equalsIgnoreCase("Live TV") | tabName.equalsIgnoreCase("Livetv")) {
					getCharacters.add("N/A");
					pCharacters = getCharacters.toString().replace("[", "").replace("]", "");
				} else {
					pCharacters = getCharacters.toString();
				}

				int isDRM = subContentResp.jsonPath().get("is_drm");
				String pDRM_Video = "false";
				if (isDRM == 1) {
					pDRM_Video = "true";
				}

				System.out.println("\n--PRINTING VALIDATION PARAMETERS--");
				System.out.println(pTrayName);
				System.out.println(newContentId);
				System.out.println(pOriginalTitle);
				System.out.println(pDuration);
				System.out.println(pBussinessType);
				System.out.println(pGenre);
				System.out.println(pContentSpecification);
				System.out.println(pEpisodeNum);
				System.out.println(pPublishedDate);
				System.out.println(pLanguages);
				System.out.println(pAudioLangguage);
				System.out.println(pSubTitleLangguage);
				System.out.println(pCharacters);
				System.out.println(pDRM_Video);
				System.out.println(pImgURL);
				System.out.println(pContentBillingType);
				System.out.println("AssetType : " +assetType);
				System.out.println(onAir);
				System.out.println(topCatogery);

				// ----- Mix Panel Content Parameters Validation ------
				Mixpanel.FEProp.setProperty("Audio Language", pAudioLangguage);
				Mixpanel.FEProp.setProperty("Carousal Name", pTrayName);
				Mixpanel.FEProp.setProperty("Content ID", newContentId);
				Mixpanel.FEProp.setProperty("Content Name", pOriginalTitle);
				Mixpanel.FEProp.setProperty("Content Duration", pDuration);
				Mixpanel.FEProp.setProperty("Content Type", pBussinessType);
				Mixpanel.FEProp.setProperty("Content Specification", pContentSpecification);
				Mixpanel.FEProp.setProperty("Content Original Language", pLanguages);
				Mixpanel.FEProp.setProperty("Characters", pCharacters.toString());
				Mixpanel.FEProp.setProperty("Content Billing Type", pContentBillingType);
				Mixpanel.FEProp.setProperty("DRM Video", pDRM_Video);
				Mixpanel.FEProp.setProperty("Episode No", pEpisodeNum);
				Mixpanel.FEProp.setProperty("Genre", pGenre);
				Mixpanel.FEProp.setProperty("Image URL", pImgURL);
				Mixpanel.FEProp.setProperty("Publishing Date", pPublishedDate);
				Mixpanel.FEProp.setProperty("Subtitle Language", pSubTitleLangguage);
				Mixpanel.FEProp.setProperty("Top Category", topCatogery);
				

			} else {
				int getDuration = contentResp.jsonPath().get("duration");
				String pDuration = Integer.toString(getDuration);
				String onAir = contentResp.jsonPath().get("on_air");
				String pBusinessType = contentResp.jsonPath().get("business_type");
				int assetType = contentResp.jsonPath().get("asset_type");
				String pAssetSubType = contentResp.jsonPath().get("asset_subtype");
				String pImgURL = contentResp.jsonPath().get("image_url");
				int getEpisodeNumber = contentResp.jsonPath().get("episode_number");
				String pEpisodeNumber = Integer.toString(getEpisodeNumber);
				String pTitle = contentResp.jsonPath().get("title");
				String releaseDate = contentResp.jsonPath().get("release_date").toString();
				String pPublishedDate = releaseDate.replace(releaseDate.substring(10), "");
				String pContentBillingType = contentResp.jsonPath().get("billing_type");
				if (pContentBillingType.length() == 0) {
					pContentBillingType = "N/A";
				}

				int languageCount = contentResp.jsonPath().getList("languages").size();
				String pLanguages = null;
				if (languageCount > 1) {
					System.out.println("MULTIPLE LANGUAGES");
				} else if (languageCount == 1) {
					pLanguages = contentResp.jsonPath().get("languages[0]");
				} else {
					System.out.println("Original Languages is Empty");
				}

				int genreSize = contentResp.jsonPath().getList("genre").size();
				String pGenre = null;
				for (int i = 0; i < genreSize; i++) {
					if (genreSize == 1) {
						pGenre = contentResp.jsonPath().get("genre[" + i + "].value");
					} else {
						pGenre = pGenre + " - " + contentResp.jsonPath().get("genre[" + i + "].value");
					}
				}
				pGenre = pGenre.replace("null - ", "");

				int audioLangCount = contentResp.jsonPath().getList("audio_languages").size();
				String pAudioLangguage = null;
				if (audioLangCount > 1) {
					System.out.println("AUDIO LANGUAGES");
				} else if (audioLangCount == 1) {
					pAudioLangguage = contentResp.jsonPath().get("audio_languages[0]");
				} else {
					pAudioLangguage = "N/A";
					System.out.println("Audio Language is Empty");
				}

				int subTitleLangCount = contentResp.jsonPath().getList("subtitle_languages").size();
				String pSubTitleLangguage = null;
				if (subTitleLangCount > 1) {
					System.out.println("SUBTITLE LANGUAGES");
				} else if (subTitleLangCount == 1) {
					pSubTitleLangguage = contentResp.jsonPath().get("subtitle_languages[0]");
				} else {
					System.out.println("Subtitle Language is Empty");
					pSubTitleLangguage = "N/A";
				}

				int actorsCount = contentResp.jsonPath().getList("actors").size();
				ArrayList<String> getCharacters = new ArrayList<String>();
				if (actorsCount >= 1) {
					for (int j = 0; j < actorsCount; j++) {
						getCharacters.add(contentResp.jsonPath().get("actors[" + j + "]").toString());
					}
					pCharacters = getCharacters.toString();
				} else if (tabName.equalsIgnoreCase("Live TV") | tabName.equalsIgnoreCase("Livetv")) {
					getCharacters.add("N/A");
					pCharacters = getCharacters.toString().replace("[", "").replace("]", "");
				} else {
					pCharacters = getCharacters.toString();
				}

				int isDRM = contentResp.jsonPath().get("is_drm");
				String pDRM_Video = "false";
				if (isDRM == 1) {
					pDRM_Video = "true";
				}

				System.out.println("\n--PRINTING VALIDATION PARAMETERS--");
				System.out.println(pTrayName);
				System.out.println(contentID);
				System.out.println(pTitle);
				System.out.println(pDuration);
				System.out.println(pBusinessType);
				System.out.println(pGenre);
				System.out.println(pAssetSubType);
				System.out.println(pEpisodeNumber);
				System.out.println(pPublishedDate);
				System.out.println(pLanguages);
				System.out.println(pAudioLangguage);
				System.out.println(pSubTitleLangguage);
				System.out.println(pCharacters);
				System.out.println(pDRM_Video);
				System.out.println(pImgURL);
				System.out.println(pContentBillingType);
				System.out.println("AssetType : " + assetType);
				System.out.println(onAir);
				System.out.println(topCatogery);

				// ----- Mix Panel Content Parameters Validation ------
				Mixpanel.FEProp.setProperty("Audio Language", pAudioLangguage);
				Mixpanel.FEProp.setProperty("Carousal Name", pTrayName);
				Mixpanel.FEProp.setProperty("Content ID", contentID);
				Mixpanel.FEProp.setProperty("Content Name", pTitle);
				Mixpanel.FEProp.setProperty("Content Duration", pDuration);
				Mixpanel.FEProp.setProperty("Content Type", pBusinessType);
				Mixpanel.FEProp.setProperty("Content Specification", pAssetSubType);
				Mixpanel.FEProp.setProperty("Content Original Language", pLanguages);
				Mixpanel.FEProp.setProperty("Characters", pCharacters.toString());
				Mixpanel.FEProp.setProperty("Content Billing Type", pContentBillingType);
				Mixpanel.FEProp.setProperty("DRM Video", pDRM_Video);
				Mixpanel.FEProp.setProperty("Episode No", pEpisodeNumber);
				Mixpanel.FEProp.setProperty("Genre", pGenre);
				Mixpanel.FEProp.setProperty("Image URL", pImgURL);
				Mixpanel.FEProp.setProperty("Publishing Date", pPublishedDate);
				Mixpanel.FEProp.setProperty("Subtitle Language", pSubTitleLangguage);
				Mixpanel.FEProp.setProperty("Top Category", topCatogery);
			}	
		}
		return pTrayName;
	}
	
	public static void subscriptionDetails() {
		String url = "https://subscriptionapi.zee5.com/v1/subscription?include_all=true";
		String UserType = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("userType");
		String pUsername = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
				.getParameter(UserType + "Name");
		String pPassword = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
				.getParameter(UserType + "Password");
		String bearerToken = getBearerToken(pUsername, pPassword);
		resp = given().headers("x-access-token", getXAccessTokenWithApiKey()).header("authorization", bearerToken).when().get(url);
		Mixpanel.FEProp.setProperty("pack duration",resp.jsonPath().getString("[0].subscription_plan.billing_frequency")); 
		String uri = "[0].subscription_plan.";
		String id = resp.jsonPath().getString(uri+"id");
		String original_title = resp.jsonPath().getString(uri+"original_title");
		String subscription_plan_Type = resp.jsonPath().getString(uri+"subscription_plan_type");
		Mixpanel.FEProp.setProperty("Pack Selected",id+"_"+original_title+"_"+subscription_plan_Type); 
		Mixpanel.FEProp.setProperty("Cost",resp.jsonPath().getString("[0].subscription_plan.price")); 
	}


	public static void getPageResponse(String tabName,String typeOfContent) {
		String Uri;
		Response respCarousel = null;
		String userType = "Guest";
		String q= null;
		String contLang= "en,kn";
		
		PropertyFileReader handler = new PropertyFileReader("properties/MixpanelKeys.properties");
		String page = handler.getproperty(tabName.toLowerCase());
		title:for (int i = 1; i < 5; i++) {
		if(page.equals("stories")) {
			Uri = "https://zeetv.zee5.com/wp-json/api/v1/featured-stories";
		}else {
			Uri = "https://gwapi.zee5.com/content/collection/0-8-" + page+ "?page="+i+"&limit=5&item_limit=20&country=IN&translation=en&languages="+contLang+"&version=10";
		}
		String xAccessToken = getXAccessTokenWithApiKey();
		if (userType.equalsIgnoreCase("Guest")) {
			respCarousel = given().headers("x-access-token", xAccessToken).header("x-z5-guest-token", "12345").when().get(Uri);
		} else if (userType.equalsIgnoreCase("SubscribedUser"))
		{
			String email = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("SubscribedUserName");
			String password = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("SubscribedPassword");
			String bearerToken = getBearerToken(email, password);
			respCarousel = given().headers("x-access-token", xAccessToken).header("authorization", bearerToken).when().get(Uri);
		} else if (userType.equalsIgnoreCase("NonSubscribedUser"))
		{
			String email = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("NonsubscribedUserName");
			String password = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("NonsubscribedPassword");
			String bearerToken = getBearerToken(email, password);
			respCarousel = given().headers("x-access-token", xAccessToken).header("authorization", bearerToken).when().get(Uri);
		} else {
			System.out.println("Incorrect user type passed to method");
		}
		
		if(typeOfContent.equalsIgnoreCase("FreeContent")) {
			int bucketSize = respCarousel.jsonPath().getList("buckets").size();
			for (int j = 0; j < bucketSize; j++) {
				int itemsSize = respCarousel.jsonPath().getList("buckets["+j+"].items").size();
				for (int k = 0; k < itemsSize; k++) {
					if(respCarousel.jsonPath().getString("buckets["+j+"].items["+k+"].business_type").contains("free")) {
						System.out.println("title : "+respCarousel.jsonPath().getString("buckets["+j+"].items["+k+"].title"));
						break title;
					}
				}
			}
		}else if(typeOfContent.equalsIgnoreCase("premium_downloadable")){
			int bucketSize = respCarousel.jsonPath().getList("buckets").size();
			for (int j = 0; j < bucketSize; j++) {
				int itemsSize = respCarousel.jsonPath().getList("buckets["+j+"].items").size();
				for (int k = 0; k < itemsSize; k++) {
					if(respCarousel.jsonPath().getString("buckets["+j+"].items["+k+"].business_type").contains("premium_downloadable")) {
						System.out.println("title : "+respCarousel.jsonPath().getString("buckets["+j+"].items["+k+"].title"));
						break title;
					}
				}
			}
		}else if(typeOfContent.equalsIgnoreCase("trailer")){
			int bucketSize = respCarousel.jsonPath().getList("buckets").size();
			for (int j = 0; j < bucketSize; j++) {
				int itemsSize = respCarousel.jsonPath().getList("buckets["+j+"].items").size();
				for (int k = 0; k < itemsSize; k++) {
					if(respCarousel.jsonPath().getString("buckets["+j+"].items["+k+"].business_type").contains("premium_downloadable")) {
						System.out.println("title : "+respCarousel.jsonPath().getString("buckets["+j+"].items["+k+"].title"));
						break title;
					}
				}
			}
		}
//		respCarousel.prettyPrint();
		}
	}
	
	public void getContentByMediaType(String mediaType, String content) {

		switch (mediaType) {

		case "carousel":
			switch (content) {
			case "freeContent":
				break;

			case "PremiumContent":
				break;

			case "trailer":
				break;
			}
			break;
		case "tray":
			switch (content) {
			case "freeContent":
				break;

			case "PremiumContent":
				break;

			case "trailer":
				break;
			}
			break;
		}
		
	}
}

