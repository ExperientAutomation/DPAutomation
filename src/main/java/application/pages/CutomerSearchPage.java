package application.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import project.library.CommonMethods;

public class CutomerSearchPage extends CommonMethods {

	public By backtosearchcusresult_xpath = By.xpath("(//div[@id='customerSearchResults']/child::div[@class='mT']/input)[1]");
	public By backtosearchprofile_xpath_ =By.xpath("(//div[@id='detailContainer']/div/div/input)[1]");
	public By customerdetail_xpath = By.xpath("(//a[@title='View Customer Detail'])[1]");
	By customertablink_xpath = By.xpath("(//a[text()='Customers'])[1]");
	By customersearchButton_xpath = By.id("buttonSearch");
	By reset_xpath =  By.id("buttonReset");
	public By cussearchLN_xpath = By.xpath("(//input[@id='LastName'])[1]");
	By DPcustomerFN = By.xpath("(//input[@id='FirstName'])[2]");
	By DPcustomerLN = By.xpath("(//input[@id='LastName'])[2]");
	By DPcustomercmp = By.id("Company");
	By DPshcustomerregid = By.id("RegistrantID");
	By DPcustomerRegType = By.id("RegTypeCode");
	public By searchresultnorecords = By.className("pp-no-record");
	By customersearchtable = By.id("searchResultsContainer");
	By resultpageeditprofileicon_xpath = By.className("linkSearchResultsEditProfile CanBeDisabled");
	public By viewprofileicon_xpath = By.xpath("(//a[@class='linkViewDetail'])[1]");
	By dollaricon_xpath = By.className("linkBalDue");
	public By emailicon_xpath = By.className("linkPreviewConfirmation");
	public By editprofile_xpath = By.id("linkCustomerDetailEditProfile");
	By editicon_xpath = By.xpath("//a[@class='linkSearchResultsEditProfile CanBeDisabled']");
	public By editprofiletitle_xpath = By.xpath("(//div[@class=\"ui-dialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix\"])");
	By editprofilesave_xpath = By.id("buttonEditProfileSave");
	By autologin_xpath = By.xpath("//input[@value='Auto-Login as Registrant']");
	By resetpsw_xpath = By.id("buttonPasswordReset");
	By changerequest_xpath = By.id("buttonChangeRequest");
	public By RegChange_title = By.xpath("(//span[@class='ui-dialog-title'])[3]");
	By ReqChangeTo_xpath = By.id("To");
	By ReqChangebody = By.id("Body");
	By ReChangeSend = By.id("buttonChangeRequestSend");
	public By preview_xpath = By.id("buttonPreviewConfirmation");
	public By previewTitle = By.id("ui-id-4");
	public By PreviewProfile = By.xpath("//h1[contains(.,'Profile')]");

//	By Preview_close_button_xpath = By.xpath("//span[contains(.,'Close')]");
//	By Preview_close_button_xpath = By.xpath("//button[@title='close']");
	By Preview_close_button_xpath = By.xpath("(//button[@title='close'])[3]");
	By messageboxOK = By.xpath("//span[contains(.,'OK')]");
	public By messagetext = By.className("ExecMsgUser");

	// Accordions
	By Acc_Reserv = By.xpath("//a[contains(text(),'Reservation')]");
	By Acc_Prod = By.xpath("//a[contains(text(),'Production')]");
	public By Acc_Trans = By.xpath("//a[contains(text(),'Transactions')]");
	By Acc_Market = By.xpath("//a[contains(text(),'Marketing Codes')]");
	By Acc_Demo = By.xpath("//a[contains(text(),'Demographics')]");
	
	By WebStaffAdd = By.id("linkCustomerAddProfile");
	
	//WebStaff Page xpath
	public By WebStaffTitle_xpath = By.xpath("(//span[@class='label-item'])[1]");
	public By WebStaffFirstName = By.id("firstName");
	public By WebStaffRegID = By.xpath("//input[@name='registrantId']");
	By WebStaffSave = By.className("dark");
	By WebStaffPaymentSave = By.xpath("(//button[@class='button dark'])[1]");	
	

	public void Back_To_SearchCriteria_Profile() {

		click_xpath(backtosearchprofile_xpath_);
	}
	
	public void Back_To_SearchCriteria_Result() {

		click_xpath(backtosearchcusresult_xpath);
	}

	public void Customer_Search(String name) {

		enterText_xpath(cussearchLN_xpath, name);
		selectItem_Xpath(DPcustomerRegType, "A");
		click_xpath(customersearchButton_xpath);
	}

	public void Customer_View_Icon() {

		click_xpath(viewprofileicon_xpath);
	}

	public void Customer_edit_icon_Profile() {

		click_xpath(editprofile_xpath);
	}

	public void edit_profile_icon() {
		
		click_xpath(editicon_xpath);
	}
	
	public void dollar_icon() {

		click_xpath(dollaricon_xpath);
	}
	
	public void email_icon() {
		
		click_xpath(emailicon_xpath);
	}
	
	public void Customer_First_Name_update() {

		enterText_xpath(DPcustomerFN, "Test edit");
		enterText_xpath(DPcustomerLN, "Test edit");
	}

	public void Auto_login_Link() {

		click_xpath(autologin_xpath);
	}

	public void Reset_password() {

		click_xpath(resetpsw_xpath);
	}

	public void Save_Cust_Profile() {

		click_xpath(editprofilesave_xpath);
	}

	public void Request_a_Change_link() {

		click_xpath(changerequest_xpath);
	}

	public void Request_change_Fill_details_Send() {

		enterText_xpath(ReqChangeTo_xpath, LoginCredentails("USER_EMAILID"));
		enterText_xpath(ReqChangebody, "Automation Test Content entered in Body");
		click_xpath(ReChangeSend);
	}

	public void popup_OK() {

		click_xpath(messageboxOK);
	}

	public void Preview_Link() {

		click_xpath(preview_xpath);
	}

	public void preview_close() {
		click_xpath(Preview_close_button_xpath);
	}

	public void All_Accortions_link() {

		click_xpath(Acc_Reserv);
		VerifyErrorOnPage();

		click_xpath(Acc_Prod);
		VerifyErrorOnPage();

		click_xpath(Acc_Trans);
		VerifyErrorOnPage();

		click_xpath(Acc_Market);
		VerifyErrorOnPage();

		click_xpath(Acc_Demo);
		VerifyErrorOnPage();
	}

	public void WebStaff_FirstName() {
		
		enterText_xpath(WebStaffFirstName,"WebStaff Test");		
	}

	public void WebStaff_Save() {
		
		click_xpath(WebStaffSave);
	}
	
	public void Add_Record() {
		
		click_xpath(WebStaffAdd);
	}
	
	public void Reset_button() {
		
		click_xpath(reset_xpath);
	}
	
	// Open ShowMan application
	public void openShowMan_DPConfig(Boolean checkboxvalue,String methodName) throws AWTException, Exception {
		
		String dpwindow = driver.getWindowHandle();
		
		String a = "window.open('about:blank','_blank');";
		 ((JavascriptExecutor)driver).executeScript(a);

		Set<String> browsers = driver.getWindowHandles();
		for (String i : browsers) {
			if (!i.equals(dpwindow)) {
				driver.switchTo().window(i);
				driver.get(getSeleniumPropety("ShowMan_URL"));
				enterText_xpath(By.xpath("//input[@class='inputShowCode']"), getSeleniumPropety("DP_Showcode"));
				click_xpath(By.xpath("//input[@value='Go!']"));
				click_xpath(By.xpath("//td[contains(.,'DP Config')]"));
				click_xpath(By.xpath("//div[@id='MainNav_0_Item_6']"));
				Thread.sleep(2000);
				
				Boolean ShowManWebstaff = driver.findElement(By.xpath("//input[@id='cbDPWebStaffEnabled']")).isSelected();
				
				if(methodName.equals("UNCHECK") && ShowManWebstaff)
				{
				click_xpath(By.id("cbDPWebStaffEnabled"));
				Thread.sleep(2000);
				click_xpath(By.id("btnSave"));
				Thread.sleep(5000);
				}
				
				else if(methodName.equals("CHECKED") && !ShowManWebstaff)
				{
					click_xpath(By.id("cbDPWebStaffEnabled"));
					Thread.sleep(2000);
					click_xpath(By.id("btnSave"));
					Thread.sleep(5000);
				}				
			}
		}
		System.out.println("ShowMan DP setting is saved");
		driver.close();
	}
}
