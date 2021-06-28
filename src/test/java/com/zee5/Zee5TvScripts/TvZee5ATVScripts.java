package com.zee5.Zee5TvScripts;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TvZee5ATVScripts {

	private com.business.zee.Zee5TvBusinessLogic Zee5TvBusiness;

	@BeforeTest
	public void Before() throws InterruptedException {
		// Utilities.relaunch = true;
		Zee5TvBusiness = new com.business.zee.Zee5TvBusinessLogic("zeeTV");
	}

	@Test(priority = 1)
	public void deviceAuthentication() throws Exception {
		Zee5TvBusiness.device();
	}

	@Test(priority = 2)
	@Parameters({ "userType" })
	public void welcomescreen(String userType) throws Exception {
		Zee5TvBusiness.welcomescreen();
	}

	@Test(priority = 3)
	@Parameters({ "userType" })
	public void TvLogin(String userType) throws Exception {
		// Zee5TvBusiness.jiraID = "TES-119";
		Zee5TvBusiness.login(userType);
	}

	@Test(priority = 4)
	@Parameters({ "userType" })
	public void searchScenarios(String userType) throws Exception {
		Zee5TvBusiness.searchScenarios(userType);
	}

	@Test(priority = 5)
	@Parameters({ "userType" })
	public void playback(String userType) throws Exception {
		Zee5TvBusiness.playbackHomepage();
	}

	@Test(priority = 6)
	@Parameters({ "userType" })
	public void carousel(String tab) throws Exception {
		Zee5TvBusiness.carouselValidation("Home");
	}

	@Test(priority = 7)
	@Parameters({ "userType" })
	public void landingScenarios(String userType) throws Exception {

		Zee5TvBusiness.landingPageHome(userType);
	}

	@Test(priority = 8)
	@Parameters({ "userType" })
	public void playerScenarios(String userType) throws Exception {
		Zee5TvBusiness.playerScenarios();
	}

	@Test(priority = 9)
	@Parameters({ "userType" })
	public void setting(String userType) throws Exception {
		Zee5TvBusiness.setting(userType);
	}

	@Test(priority = 10)
	public void collectingPage() throws Exception {
		Zee5TvBusiness.collectionpage();
	}

	@Test(priority = 11)
	public void subscription() throws Exception {
		Zee5TvBusiness.subscription();
	}

	@Test(priority = 12)
	public void continueWatching() throws Exception {
		Zee5TvBusiness.continueWatching();
	}

	@Test(priority = 13)
	public void liveTV() throws Exception {
		Zee5TvBusiness.liveTv();
	}

	@Test(priority = 14)
	public void beforeTV() throws Exception {
		Zee5TvBusiness.beforeTV();
	}

	@Test(priority = 15)
	public void upNext() throws Exception {
		Zee5TvBusiness.upnext();
	}

	@Test(priority = 16)
	public void language() throws Exception {
		Zee5TvBusiness.languagePage();
	}

	@Test(priority = 17)
	public void ads() throws Exception {
		Zee5TvBusiness.ads();
	}

	@Test(priority = 18)
	public void profile() throws Exception {
		Zee5TvBusiness.profile();
	}

	@Test(priority = 19)
	public void deeplinking() throws Exception {
		Zee5TvBusiness.deeplinking();
	}

	@Test(priority = 20)
	public void headerSection() throws Exception {
		Zee5TvBusiness.headerSection();
	}

	@Test(priority = 21)
	public void talamoos() throws Exception {
		Zee5TvBusiness.talamoos();
	}

	@Test(priority = 22)
	public void staticPage() throws Exception {
		Zee5TvBusiness.staticPages();
	}

	@Test(priority = 23)
	public void contactUS() throws Exception {
		Zee5TvBusiness.contactUs();
	}

//	@Test(priority = 26) //Insprint
	@Parameters({ "userType" })
	public void authenticateInprint(String userType) throws Exception {
		Zee5TvBusiness.autheticateInsprint(userType);
	}

//	@Test(priority = 27) //Insprint
	public void zeelogoVerificationInPlayer() throws Exception {
		Zee5TvBusiness.zeelogoVerificationInPlayer();
	}

//	@Test(priority = 28) //Insprint
	public void zeeplexTVOD() throws Exception {
		Zee5TvBusiness.zeeplex();
	}

//	@Test(priority = 29) //Insprint
	public void nowplaying() throws Exception {
		Zee5TvBusiness.nowplayingButton();
	}

//	@Test(priority = 30) //Insprint
	public void premiumLiveChannel() throws Exception {
		Zee5TvBusiness.premiumLiveChannel();
	}

//	@Test(priority = 31) //Insprint
	public void premiumcontentFromInfo() throws Exception {
		Zee5TvBusiness.premiumInUpnext();
	}

//	@Test(priority = 32) //Insprint
	@SuppressWarnings("static-access")
	public void e24channelSearch() throws Exception {
		Zee5TvBusiness.jiraID = "TES-121";
		Zee5TvBusiness.e24ChannelSearch();
	}

//	@Test(priority = 33) //Insprint
	public void noReminderText() throws Exception {
		Zee5TvBusiness.noReminderText();
	}

//	@Test(priority = 34) //Insprint
	public void premiumContentPlayback() throws Exception {
		Zee5TvBusiness.premiumconetntPlayback();
	}

	@SuppressWarnings("static-access")
//	@Test(priority = 40) // Insprint
	@Parameters({ "userType" })
	public void planTitle(String userType) throws Exception {
		if (userType.equals("Guest")) {
			Zee5TvBusiness.jiraID = "TC-21174";
		} else if (userType.equals("NonSubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-21177";

		} else if (userType.equals("SubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-21178";
		}
		Zee5TvBusiness.planTitle();
	}

	@SuppressWarnings("static-access")
//	@Test(priority = 42) // Insprint
	@Parameters({ "userType" })
	public void planLanguage(String userType) throws Exception {
		if (userType.equals("Guest")) {
			Zee5TvBusiness.jiraID = "TC-21179";
		} else if (userType.equals("NonSubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-21180";

		} else if (userType.equals("SubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-21181";
		}
		Zee5TvBusiness.planTitleLanguage();
	}

	@SuppressWarnings("static-access")
//	@Test(priority = 43) // Insprint
	@Parameters({ "userType" })
	public void planDescription(String userType) throws Exception {
		if (userType.equals("Guest")) {
			Zee5TvBusiness.jiraID = "TC-21182";
		} else if (userType.equals("NonSubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-21183";

		} else if (userType.equals("SubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-21184";
		}
		Zee5TvBusiness.planDiscription();
	}

	@SuppressWarnings("static-access")
//	@Test(priority = 44) // Insprint
	@Parameters({ "userType" })
	public void planDescriptionLanguage(String userType) throws Exception {
		if (userType.equals("Guest")) {
			Zee5TvBusiness.jiraID = "TC-21185";
		} else if (userType.equals("NonSubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-21186";

		} else if (userType.equals("SubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-21187";
		}
		Zee5TvBusiness.planDescriptionLanguage();
	}

	@SuppressWarnings("static-access")
	// @Test(priority = 45) // Insprint
	@Parameters({ "userType" })
	public void playercontol(String userType) throws Exception {
		if (userType.equals("Guest")) {
			Zee5TvBusiness.jiraID = "TC-21188";
		} else if (userType.equals("NonSubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-21193";

		} else if (userType.equals("SubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-21194";
		}
		Zee5TvBusiness.playerbar();
	}

	@SuppressWarnings("static-access")
//	@Test(priority = 46) // Insprint
	@Parameters({ "userType" })
	public void playerfadeout(String userType) throws Exception {
		if (userType.equals("Guest")) {
			Zee5TvBusiness.jiraID = "TC-21189";
		} else if (userType.equals("NonSubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-21195";

		} else if (userType.equals("SubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-21196";
		}
		Zee5TvBusiness.playerbarfadeoutPaused();
	}

	@SuppressWarnings("static-access")
//	@Test(priority = 47) // Insprint
	@Parameters({ "userType" })
	public void infoScreen(String userType) throws Exception {
		if (userType.equals("Guest")) {
			Zee5TvBusiness.jiraID = "TC-21190";
		} else if (userType.equals("NonSubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-21197";

		} else if (userType.equals("SubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-21198";
		}
		Zee5TvBusiness.infoScreen();
	}

	@SuppressWarnings("static-access")
//	@Test(priority = 48) // Insprint
	@Parameters({ "userType" })
	public void playerFadeout(String userType) throws Exception {
		if (userType.equals("Guest")) {
			Zee5TvBusiness.jiraID = "TC-21191";
		} else if (userType.equals("NonSubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-21199";

		} else if (userType.equals("SubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-21200";
		}
		Zee5TvBusiness.playerFadeOut();
	}

	@SuppressWarnings("static-access")
//	@Test(priority = 49) // Insprint
	@Parameters({ "userType" })
	public void playerFadeOutContentDetail(String userType) throws Exception {
		if (userType.equals("Guest")) {
			Zee5TvBusiness.jiraID = "TC-21192";
		} else if (userType.equals("NonSubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-21201";

		} else if (userType.equals("SubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-21202";
		}
		Zee5TvBusiness.playerFadeOutContentDetail();
	}

	@SuppressWarnings("static-access")
//	@Test(priority = 50) // Insprint
	@Parameters({ "userType" })
	public void cwPlayerControl(String userType) throws Exception {
		if (userType.equals("NonSubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-21203";
			Zee5TvBusiness.cwPlayerControl();

		} else if (userType.equals("SubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-21204";
			Zee5TvBusiness.cwPlayerControl();
		}

	}

	@SuppressWarnings("static-access")
//	@Test(priority = 51) // Insprint
	@Parameters({ "userType" })
	public void cwplayerfadeout(String userType) throws Exception {
		if (userType.equals("NonSubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-21205";
			Zee5TvBusiness.playerbarfadeoutPaused();

		} else if (userType.equals("SubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-21206";
			Zee5TvBusiness.playerbarfadeoutPaused();
		}

	}

	@SuppressWarnings("static-access")
//	@Test(priority = 52) // Insprint
	@Parameters({ "userType" })
	public void cwinfoScreen(String userType) throws Exception {
		if (userType.equals("NonSubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-21207";
			Zee5TvBusiness.infoScreen();

		} else if (userType.equals("SubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-21208";
			Zee5TvBusiness.infoScreen();
		}

	}

	@SuppressWarnings("static-access")
//	@Test(priority = 53) // Insprint
	@Parameters({ "userType" })
	public void cwplayerFadeout(String userType) throws Exception {
		if (userType.equals("NonSubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-21209";
			Zee5TvBusiness.playerFadeOut();

		} else if (userType.equals("SubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-21210";
			Zee5TvBusiness.playerFadeOut();
		}

	}

	@SuppressWarnings("static-access")
//	@Test(priority = 54) // Insprint
	@Parameters({ "userType" })
	public void cwplayerFadeOutContentDetail(String userType) throws Exception {
		if (userType.equals("NonSubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-21211";
			Zee5TvBusiness.playerFadeOutContentDetail();

		} else if (userType.equals("SubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-21212";
			Zee5TvBusiness.playerFadeOutContentDetail();
		}

	}

	@SuppressWarnings("static-access")
//	@Test(priority = 55) // Insprint
	@Parameters({ "userType" })
	public void watchlistPlayerControl(String userType) throws Exception {
		if (userType.equals("NonSubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-21213";
			Zee5TvBusiness.watchlistPlayerControl();

		} else if (userType.equals("SubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-21214";
			Zee5TvBusiness.watchlistPlayerControl();
		}

	}

	@SuppressWarnings("static-access")
//	@Test(priority = 56) // Insprint
	@Parameters({ "userType" })
	public void watchlistplayerfadeout(String userType) throws Exception {
		if (userType.equals("NonSubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-21215";
			Zee5TvBusiness.playerbarfadeoutPaused();

		} else if (userType.equals("SubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-21216";
			Zee5TvBusiness.playerbarfadeoutPaused();
		}

	}

	@SuppressWarnings("static-access")
//	@Test(priority = 57) // Insprint
	@Parameters({ "userType" })
	public void watchlistinfoScreen(String userType) throws Exception {
		if (userType.equals("NonSubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-21217";
			Zee5TvBusiness.infoScreen();

		} else if (userType.equals("SubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-212128";
			Zee5TvBusiness.infoScreen();
		}

	}

	@SuppressWarnings("static-access")
//	@Test(priority = 58) // Insprint
	@Parameters({ "userType" })
	public void watchlistplayerFadeout(String userType) throws Exception {
		if (userType.equals("NonSubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-21219";
			Zee5TvBusiness.playerFadeOut();

		} else if (userType.equals("SubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-21220";
			Zee5TvBusiness.playerFadeOut();
		}

	}

	@SuppressWarnings("static-access")
//	@Test(priority = 59) // Insprint
	@Parameters({ "userType" })
	public void watchlistplayerFadeOutContentDetail(String userType) throws Exception {
		if (userType.equals("NonSubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-21221";
			Zee5TvBusiness.playerFadeOutContentDetail();

		} else if (userType.equals("SubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-21222";
			Zee5TvBusiness.playerFadeOutContentDetail();
		}

	}

//	@Test(priority = 60) // Insprint
	@SuppressWarnings("static-access")
	@Parameters({ "userType" })
	public void expiredPlan(String userType) throws Exception {
		if (userType.equals("NonSubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-21618";
			Zee5TvBusiness.expiredPlanVerification();

		} else if (userType.equals("SubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-21619";
			Zee5TvBusiness.expiredPlanVerification();
		}
	}

//	@Test(priority = 61) // Insprint
	@SuppressWarnings("static-access")
	@Parameters({ "userType" })
	public void settingsOptionNaviation(String userType) throws Exception {
		if (userType.equals("Guest")) {
			Zee5TvBusiness.jiraID = "TC-21861";
		} else if (userType.equals("NonSubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-21862";

		} else if (userType.equals("SubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-21863";
		}
		Zee5TvBusiness.settingScreen();
	}

//	@Test(priority = 62) // Insprint
	@SuppressWarnings("static-access")
	@Parameters({ "userType" })
	public void settingsIconFocus(String userType) throws Exception {
		if (userType.equals("Guest")) {
			Zee5TvBusiness.jiraID = "TC-21864";
		} else if (userType.equals("NonSubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-21865";

		} else if (userType.equals("SubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-21866";
		}
		Zee5TvBusiness.settingsIconFocus();
	}

//	@Test(priority = 63) // Insprint
	@SuppressWarnings("static-access")
	@Parameters({ "userType" })
	public void firststRowLeftNavigation(String userType) throws Exception {
		if (userType.equals("Guest")) {
			Zee5TvBusiness.jiraID = "TC-21867";
		} else if (userType.equals("NonSubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-21868";

		} else if (userType.equals("SubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-21869";
		}
		Zee5TvBusiness.firststRowLeftNavigation();
	}

//	@Test(priority = 64) // Insprint
	@SuppressWarnings("static-access")
	@Parameters({ "userType" })
	public void lastRowRightNavigation(String userType) throws Exception {
		if (userType.equals("Guest")) {
			Zee5TvBusiness.jiraID = "TC-21870";
		} else if (userType.equals("NonSubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-21871";

		} else if (userType.equals("SubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-21872";
		}

		Zee5TvBusiness.lastRowRightNavigation();
	}

//	@Test(priority = 65) // Insprint
	@SuppressWarnings("static-access")
	@Parameters({ "userType" })
	public void firstRowLastcontentRightNavigation(String userType) throws Exception {
		if (userType.equals("Guest")) {
			Zee5TvBusiness.jiraID = "TC-21873";
		} else if (userType.equals("NonSubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-21874";

		} else if (userType.equals("SubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-21875";
		}
		Zee5TvBusiness.firstRowLastcontentRightNavigation();
	}

//	@Test(priority = 66) // Insprint
	@SuppressWarnings("static-access")
	@Parameters({ "userType" })
	public void secondRowFirstcontentLeftNavigation(String userType) throws Exception {
		if (userType.equals("Guest")) {
			Zee5TvBusiness.jiraID = "TC-21876";
		} else if (userType.equals("NonSubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-21877";

		} else if (userType.equals("SubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-21878";
		}

		Zee5TvBusiness.secondRowFirstcontentLeftNavigation();
	}

//	@Test(priority = 67) // Insprint
	@SuppressWarnings("static-access")
	@Parameters({ "userType" })
	public void appVersion(String userType) throws Exception {

		if (userType.equals("Guest")) {
			Zee5TvBusiness.jiraID = "TC-21882";
		} else if (userType.equals("NonSubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-21883";

		} else if (userType.equals("SubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-21884";
		}
		Zee5TvBusiness.versionInSettingPage();
	}

//	@Test(priority = 68) // Insprint
	@SuppressWarnings("static-access")
	@Parameters({ "userType" })
	public void upButtonNavigation(String userType) throws Exception {

		if (userType.equals("Guest")) {
			Zee5TvBusiness.jiraID = "TC-21879";
		} else if (userType.equals("NonSubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-21880";

		} else if (userType.equals("SubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-21881";
		}
		Zee5TvBusiness.upButtonNavigation();
	}

//	@Test(priority = 69) // Insprint
	@SuppressWarnings("static-access")
	@Parameters({ "userType" })
	public void deviceInfo(String userType) throws Exception {
		if (userType.equals("Guest")) {
			Zee5TvBusiness.jiraID = "TC-21620";
		} else if (userType.equals("NonSubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-21621";

		} else if (userType.equals("SubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-21622";
		}
		Zee5TvBusiness.deviceInfotab();
	}

//	@Test(priority = 70) // Insprint
	@SuppressWarnings("static-access")
	@Parameters({ "userType" })
	public void remoteRCU(String userType) throws Exception {
		if (userType.equals("Guest")) {
			Zee5TvBusiness.jiraID = "TC-21623";
		} else if (userType.equals("NonSubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-21624";

		} else if (userType.equals("SubscribedUser")) {
			Zee5TvBusiness.jiraID = "TC-21625";
		}
		Zee5TvBusiness.remoteKeysAFS();
		Zee5TvBusiness.selectRCU();
		Zee5TvBusiness.BackRCU();
	}

//	@Test(priority = 71) // Insprint
	@Parameters({ "userType" })
	public void svodInNews(String userType) throws Exception {
		Zee5TvBusiness.svodInNews();
	}

//	@Test(priority = 72) // Insprint
	@SuppressWarnings("static-access")
	@Parameters({ "userType" })
	public void rsvodplayback(String userType) throws Exception {
		Zee5TvBusiness.jiraID = "TC-21626";
		Zee5TvBusiness.rsvodPlaybackCheck();
	}

//	@Test(priority = 73) // Insprint
	@Parameters({ "userType" })
	public void afsnews24(String userType) throws Exception {
		Zee5TvBusiness.afsNews24();
	}

//	@Test(priority = 74) // Insprint
	@Parameters({ "userType" })
	public void polimerNewsChannelAFS(String userType) throws Exception {
	//	Zee5TvBusiness.afsPolimerNews();
		Zee5TvBusiness.airtelXtremenumberRCU();
	}
	
//	@Test(priority = 74) 
	@Parameters({ "userType" })
	public void loginPerformance(String userType) throws Exception {
		Zee5TvBusiness.Performance_LoginFunctionality(userType);
	}
	
//	@Test(priority = 75) 
	@Parameters({ "userType" })
	public void rgybInnerScreen(String userType) throws Exception {
		Zee5TvBusiness.innerscreenHandling();
		Zee5TvBusiness.detailscreen();
		Zee5TvBusiness.seasonpage();
		Zee5TvBusiness.searchscreen();
	}
	
//	@Test(priority = 76) 
	@Parameters({ "userType" })
	public void atvTSBRCU(String userType) throws Exception {
		Zee5TvBusiness.atvTSBremoteKeys();
		Zee5TvBusiness.atvTSBselectRCU();
		Zee5TvBusiness.atvTSBBackRCU();
		Zee5TvBusiness.atvTSBnumberRCU();
	}
//	@Test(priority = 77) 
	@Parameters({ "userType" })
	public void skipad(String userType) throws Exception {
		Zee5TvBusiness.skipAD();
	}
//	@Test(priority = 78) 
	@Parameters({ "userType" })
	public void liveTvPOC(String userType) throws Exception {
		Zee5TvBusiness.liveTVPOC();
	}
	
//	@Test(priority = 79) 
	@Parameters({ "userType" })
	public void stringInPages(String userType) throws Exception {
		Zee5TvBusiness.stringInPages();
	}
	
//	@Test(priority = 80) 
	@Parameters({ "userType" })
	public void loaderinPlayer(String userType) throws Exception {
		Zee5TvBusiness.loaderInPlayer();
	}


	@AfterTest
	public void After() {
		System.out.println("Tear Down");
		Zee5TvBusiness.TvtearDown();
	}

}
