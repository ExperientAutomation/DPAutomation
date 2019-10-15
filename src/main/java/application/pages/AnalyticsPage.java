package application.pages;

import org.openqa.selenium.By;

import project.library.CommonMethods;

public class AnalyticsPage extends CommonMethods{
	
	public By pageTitle_xpath = By.xpath("//div[@class='pageTitle']"); 
	By analytics_xapth = By.xpath("(//a[text()='Analytics'])[1]");
	By registration_xpath = By.xpath("(//a[text()='Registration'])[1]");
	By overview_xpath = By.xpath("//a[text()='Overview']");
	By timeline_xpath = By.xpath("//a[text()='Timeline']");
	By pacing_xpath = By.xpath("//a[text()='Pacing']");
	By maps_xpath = By.xpath("//a[text()='Maps']");
	By totals_xpath = By.xpath("//a[text()='Totals']");
	By generatelink_xpath = By.id("linkGenerateLink");
	public By generatePopupTitle = By.xpath("(//span[@class='ui-dialog-title'])[2]");
	public By SendemailPopupTitle = By.xpath("(//span[@class='ui-dialog-title'])[3]");
	By generatelinkemaillink_xpath = By.id("btnGenLinkEmail");
	By genlinksendemail_xpath = By.id("buttonEmailLinkSend");
	By genlinkemailcancel_xpath = By.id("buttonEmailLinkCancel");
	By genlinkToAddress_xpath = By.id("To");
	public By printicon_xpath = By.xpath("//a[@class='PrintPage']");
	By unified_xpath = By.xpath("(//a[text()='Unified'])[1]");
	By unifiedDeselectbutton_xpath = By.id("linkClearChecked");
	By unifiedExportbutton_xpath = By.xpath("(//a[@class='button small'])[1]");
	By housing_xpath = By.xpath("(//a[text()='Housing'])[1]");
	By session_xpath = By.xpath("(//a[text()='Session'])[1]");	
	
	public By tour_xpath = By.id("btnHeaderTour");
	By tournextOnebutton_xpath = By.xpath("(//a[text()='Next'])[1]");
	By tournextTwobutton_xpath = By.xpath("(//a[text()='Next'])[2]");
	public By tourpreviousbutton_xpath = By.xpath("(//a[text()='Previous'])[1]");
	public By tourclosepopup_xpath = By.xpath("(//a[@class='joyride-close-tip'])[2]");
	public By tour_welcomeText = By.xpath("(//h4[text()='Welcome!'])[2]");
		
	public By regcheckboxone = By.xpath("(//input[@id=\"chkDimensionVal\"])[1]");
	By regcheckboxtwo = By.xpath("(//input[@id=\"chkDimensionVal\"])[2]");
	By regExport = By.xpath("(//a[@id='tour-export'])[1]");
	
	public By printXpath = By.xpath("//embed[@id='plugin']");
	public By printcancel = By.xpath("(//button[@class='cancel'])[1]");
	
	public void click_Analytics_page() {
		
		click_xpath(analytics_xapth);
	}
	
	public void click_session_page() throws InterruptedException {
		
		mouseover(analytics_xapth);
		click_xpath(session_xpath);		
		Thread.sleep(2000);
	}
			
	public void click_housing_page() throws InterruptedException {
		
		mouseover(analytics_xapth);
		click_xpath(housing_xpath);
		Thread.sleep(2000);
	}
	
	public void click_Unified_page() throws InterruptedException {
		
		mouseover(analytics_xapth);
		click_xpath(unified_xpath);
		Thread.sleep(2000);
	}
	
	public void click_overview() throws InterruptedException {
		
		click_xpath(overview_xpath);
		Thread.sleep(2000);
	}
	
	public void click_TimeLine() {
		
		click_xpath(timeline_xpath);
	}
	
	public void click_Pacing() throws InterruptedException {
		
		click_xpath(pacing_xpath);
		Thread.sleep(2000);
	}
	
	public void click_Maps() {
		
		click_xpath(maps_xpath);
	}
	
	public void click_Totals() {
		
		click_xpath(totals_xpath);
	}
	
	public void generate_link() {
		
		click_xpath(generatelink_xpath);
	}
	
	public void generate_email_link() {
		
		click_xpath(generatelinkemaillink_xpath);
	}
	
	public void generate_send_email() {
		
		enterText_xpath(genlinkToAddress_xpath,getSeleniumPropety("emailid"));
		click_xpath(genlinksendemail_xpath);
	}
	
	public void tour_link() {
		
		click_xpath(tour_xpath);		
	}
	
	public void tour_next() {
		
		click_xpath(tournextOnebutton_xpath);
		click_xpath(tournextTwobutton_xpath);
	}
	
	public void tour_close() {
		
		click_xpath(tourpreviousbutton_xpath);
		click_xpath(tourclosepopup_xpath);
	}
	
	public void Export_button() {		
		
		scrollingToElementofAPage(regExport);
//		click_xpath(regcheckboxone);
//		click_xpath(regcheckboxtwo);
		click_xpath(regExport);		
	}
	
}
