package application.pages;

import java.util.Random;

import org.openqa.selenium.By;

import project.library.CommonMethods;

public class Report_Page extends CommonMethods {
	
	Random rand = new Random();
	int count = rand.nextInt(50);	
	public String ReportName ="Test Desc-"+count;
	
	By managereportstablink_xpath = By.xpath("(//a[text()='Manage Reports'])[1]");
	By hometablink = By.xpath("(//a[contains(.,'Home')])[1]");
	By ReportTemplate = By.xpath("//div[@id='filterBox-box-0']/div[contains(.,'Report Templates')]");
	By MySavedReport = By.xpath("//div[@id='filterBox-box-0']/div[contains(.,'My Saved')]");
	public By Pagetitle = By.xpath("//div[@class='pageTitle']");
	By reportcountslink_xpath = By.xpath("//div[text()='Counts']");
	public By HoteInventoryreportviewicon_xpath = By.xpath("(//a[.//text()[normalize-space()='Hotel Inventory Cross']]/parent::div/following-sibling::div/a)[1]");
	By HoteInventoryreportrunicon_xpath = By.xpath("(//a[.//text()[normalize-space()='Hotel Inventory Cross']]/parent::div/following-sibling::div/a)[2]");
	public By RegTypeViewReport = By.xpath("(//a[.//text()[normalize-space()='RegType Count']]/parent::div/following-sibling::div/a)[1]");
	public By HotelInvTitle = By.xpath("(//div[@class='tblListItemName' and contains(.,'Hotel Inventory Cross')])[3]");
	public By RegTypeTitle = By.xpath("(//div[@class='tblListItemName' and contains(.,'RegType Count')])[4]");
	public By SaveReportTitle = By.xpath("(//div[@class='tblListItemName' and contains(.,'"+ReportName+"')])[2]");
	By reportsave_xpath = By.id("buttonEditReportSave");
	By reportsaveas_xpath = By.id("buttonEditReportSaveAs");
	By reportrun_xpath = By.id("buttonEditReportRun");
	By SaveAsReportview =  By.xpath("(//a[contains(.,'"+ReportName+"')]/../../div[@class='divListItemAction']/a)[1]");
	
	By reportdetailrun = By.id("buttonEditReportRun");
	By reportname = By.id("report_name");
	By reportdesc = By.id("short_description");
	By newreportsave = By.xpath("(//div[@class='ui-dialog-buttonset']/button)[1]");
	By backtomanagereports_xpath = By.xpath("//input[@value='Back to Manage Reports']");
	By filter = By.id("filters");
	By MemberType = By.xpath("(//input[@name='Filters.MemberTypes'])[1]");
	By AttendeeType = By.xpath("(//input[@name='Filters.RegTypes'])[1]");
	By reportexcelxlstype_xpath = By.xpath("//span[contains(.,'Excel (xls)')]");
	By badgingtablink_xpath = By.xpath("(//a[text()='Badging'])[1]");
	By badgereportcmp_xpath = By.xpath("//div[contains(text(),'Company 3 1/3 x 4')]");
	By badgeregtype_xpath = By.id("RegTypeCode_A");	
	
	public void click_Manage_Reports() {
		
		mouseover(hometablink);
		click_xpath(managereportstablink_xpath);
	}
	
	public void Report_template_Count() throws InterruptedException {
		
		click_xpath(ReportTemplate);
		Thread.sleep(2000);
		click_xpath(reportcountslink_xpath);
		Thread.sleep(2000);
	}
	
	public void click_view_HotelInv_Report() {
		
		click_xpath(HoteInventoryreportviewicon_xpath);
	}
	
	public void click_view_RegType() throws InterruptedException {
	
		click_xpath(RegTypeViewReport);	
		Thread.sleep(3000);
	}
	
	public void click_RunReportHoteInv() {
	
		click_xpath(HoteInventoryreportrunicon_xpath);
	}
	
	public void click_Save_RunReport() {
		
		click_xpath(reportrun_xpath);
	}
	
	public void click_Back_To_Report() {
		
		click_xpath(backtomanagereports_xpath);
	}

	public void Run_report_Excel_Format() {
		
		click_xpath(reportexcelxlstype_xpath);
//		click_xpath(filter);
//		click_xpath(MemberType);
//		click_xpath(AttendeeType);
		scrollingToTopofAPage();
		click_xpath(reportdetailrun);			
	}

	public void Save_As() {		
		
		click_xpath(reportsaveas_xpath);
		enterText_xpath(reportname, "Chandra_test_report");
		enterText_xpath(reportdesc, ReportName );
		click_xpath(newreportsave);
		
	}

	public void MySavedReport() {
		
		click_xpath(MySavedReport);		
		click_xpath(SaveAsReportview);
	}
	
	public void RunHotelInv() throws InterruptedException {
		
		click_Back_To_Report();
		Report_template_Count();
		click_RunReportHoteInv();		
	}

}
