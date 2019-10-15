package application.test;

import java.awt.AWTException;

import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import project.library.ApplicationMethods;
import project.library.CommonMethods;

@Listeners(project.utils.Testlistener.class)
public class TCExecution extends CommonMethods {

	public static int row = 0;

	@Test(priority = 0, enabled = true)
	public void Enter_UserName_And_Password() throws Exception {

		row = 2;

		ApplicationMethods.ObjLoginPage.ApplicationUrl(getSeleniumPropety("DP_URL"));
		ApplicationMethods.ObjLoginPage.LoginToAPplication();
		
		if (verifText(ApplicationMethods.ObjLoginPage.showcodepage, "Choose a Show")) {

			logger.log(LogStatus.PASS, "Choose a Show dropdown list popup displayed for the first-time.");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "Choose a Show dropdown list popup did NOT display for the first-time.");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 1, enabled = true)
	public void Enter_showcode_and_click_the_showcode_link() throws Exception {

		row = 3;

		ApplicationMethods.Objselectshow.Verify_Enter_showcode_and_click_the_showcode_link();
		if (verifObjectPresent(ApplicationMethods.Objselectshow.DPHomepage)) {

			logger.log(LogStatus.PASS,"System displayed entered showcode and show Home with correct Chats and Graphs.");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL,"System did NOT display, entered showcode and show Home with correct Chats and Graphs.");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 2, enabled = true)
	public void Check_left_Side_Quick_link() throws Exception {

		row = 4;

		ApplicationMethods.objDashboardpage.DPLeftSide_OneclickReport();
		// verifObjectPresent(ApplicationMethods.objDashboardpage.oneclickreports, "Left
		// side link not present");

		if (driver.findElements(ApplicationMethods.objDashboardpage.quicklooklink).size() > 0) {
			click_xpath(ApplicationMethods.objDashboardpage.quicklooklink);

			if (VerifyErrorOnPage()) {

				logger.log(LogStatus.PASS, "System navigated to corresponding page.");
				System.out.println("Test Case Passed- Row#: " + row);
			} else {
				logger.log(LogStatus.FAIL, "System did not navigate to corresponding page.");
				System.out.println("Test Case Failed#: " + row);
				Assert.fail();
			}

		} else {

			System.out.println("Quick link report not available in Left Side ");
			logger.log(LogStatus.PASS, "Quick link report not available in Left Side");
		}
	}

	@Test(priority = 3, enabled = true)
	public void Left_Side_Customer_Search() throws Exception {

		row = 5;

		ApplicationMethods.objDashboardpage.DP_Left_Side_Customer_Search_Button();
		if (verifObjectPresent(ApplicationMethods.objDashboardpage.Customersearchpage)) {

			logger.log(LogStatus.PASS, "System takes to Customer Search page and show all records.");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "System did NOT take to Customer Search page and show all records.");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 4, enabled = true)
	public void Verify_Home_Page() throws Exception {

		row = 6;

		ApplicationMethods.objDashboardpage.DP_Home_link();
		if (verifObjectPresent(ApplicationMethods.objDashboardpage.DPshcusomersearch)) {

			logger.log(LogStatus.PASS, "System takes back to Dashboard page.");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			
			System.out.println("Failed");
			logger.log(LogStatus.FAIL, "System did not take back to Dashboard page.");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 5, enabled = true)
	public void Verify_CustomerSearch_FristName_LastName() throws Exception {

		row = 7;

		ApplicationMethods.objDashboardpage.DashBoard_FN_LN_Enter();
		ApplicationMethods.objDashboardpage.DP_Left_Side_Customer_Search_Button();
		
		if (verifText(ApplicationMethods.objCustomerSearch.customerdetail_xpath, "test")) {

			logger.log(LogStatus.PASS, "Based on the Search, Customer Search result displays.");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "Based on the Search, Customer Search result did not display.");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 6, enabled = true)
	public void Verify_Back_to_Search_Criteria() throws Exception {

		row = 8;

		ApplicationMethods.objCustomerSearch.Back_To_SearchCriteria_Result();
		if (verifObjectPresent(ApplicationMethods.objCustomerSearch.cussearchLN_xpath)) {

			logger.log(LogStatus.PASS, "System takes to Customer Search page.");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "System did not take to Customer Search page.");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 7, enabled = true)
	public void Verify_invalid_Name_Search() throws Exception {

		row = 9;

		ApplicationMethods.objCustomerSearch.Customer_Search("xyz");
		if (verifText(ApplicationMethods.objCustomerSearch.searchresultnorecords,
				"No customers found meeting this criteria")) {

			logger.log(LogStatus.PASS, "Customer Search page shows'No customers found meeting this criteria' message.");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL,
					"Customer Search page did NOT show 'No customers found meeting this criteria' message.");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 8, enabled = true)
	public void verify_Valid_Name_Search() throws Exception {

		row = 10;

		ApplicationMethods.objCustomerSearch.Back_To_SearchCriteria_Result();
		ApplicationMethods.objCustomerSearch.Customer_Search("Test");
		if (verifText(ApplicationMethods.objCustomerSearch.customerdetail_xpath, "test")) {

			logger.log(LogStatus.PASS, "Customer Search page shows'No customers found meeting this criteria' message.");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL,
					"Customer Search page did NOT show 'No customers found meeting this criteria' message.");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 9, enabled = true)
	public void verify_Customer_Details_page() throws Exception {

		row = 11;
		
//		Disable WebStaff Config in Prod ShowMan
		String DPmainwin = driver.getWindowHandle();
		// Uncheck WebStaff configuration in ShowMan
		ApplicationMethods.objCustomerSearch.openShowMan_DPConfig(true, "UNCHECK");
		switchIfWindowsAre(driver, 2);
		driver.switchTo().window(DPmainwin);
		
		Thread.sleep(2000);
		ApplicationMethods.objCustomerSearch.Customer_View_Icon();
		if (verifObjectPresent(ApplicationMethods.objCustomerSearch.editprofile_xpath)) {

			logger.log(LogStatus.PASS,
					"The Customer details page displayed and Back to Search Results, Request a Change, Preview Confirmation, accordions & Edit icon.");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL,
					"The Customer details page did not display and Back to Search Results, Request a Change, Preview Confirmation, accordions & Edit icon. ");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 10, enabled = true)
	public void Verify_Customer_Edit_page() throws Exception {

		row = 12;
		
		ApplicationMethods.objCustomerSearch.Customer_edit_icon_Profile();
		if (verifObjectPresent(ApplicationMethods.objCustomerSearch.editprofiletitle_xpath)) {

			logger.log(LogStatus.PASS, "Customer Edit Profile modal window displays.");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "Customer Edit Profile modal window did not display.");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 11, dependsOnMethods = { "Verify_Customer_Edit_page" }, enabled = true)
	public void Verify_Edit_profile_First_last_name_change() throws Exception {		

		row = 13;

		ApplicationMethods.objCustomerSearch.Customer_First_Name_update();
		ApplicationMethods.objCustomerSearch.Save_Cust_Profile();
		if (verifText(ApplicationMethods.objCustomerSearch.messagetext, "Save Successful!")) {

			logger.log(LogStatus.PASS, "The modal Saved and closed and update in the Customer Search result page.");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "The modal did not Save and update in the Customer Search result page.");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}

		ApplicationMethods.objCustomerSearch.popup_OK();
	}

	@Test(priority = 12, dependsOnMethods= {"Verify_Edit_profile_First_last_name_change"}, enabled = true)
	public void verify_Auto_login() throws Exception {

		row = 14;

		String mainwin = driver.getWindowHandle();
		ApplicationMethods.objCustomerSearch.Auto_login_Link();
		switchIfWindowsAre(driver, 2);

		if (VerifyErrorOnPage()) {

			logger.log(LogStatus.PASS, "System opened the registrant in separate tab and auto login.");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "System did not open the registrant in separate tab and auto login.");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}

		if (driver.getWindowHandles().size() > 1) {
			driver.close();
			driver.switchTo().window(mainwin);
		}
	}

	@Test(priority = 13, enabled = true)
	public void Verify_Reset_Password() throws Exception {

		row = 15;

		ApplicationMethods.objCustomerSearch.Reset_password();
		if (verifText(ApplicationMethods.objCustomerSearch.messagetext,
				"The password reset message was successfully sent to your email.")) {

			logger.log(LogStatus.PASS, "System sent reset password and shows Success message.");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "System did not send reset password and show Success message.");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}

		ApplicationMethods.objCustomerSearch.popup_OK();
	}

	@Test(priority = 14, enabled = true)
	public void verify_Request_a_Change() throws Exception {

		row = 16;

		ApplicationMethods.objCustomerSearch.Request_a_Change_link();
		if (verifObjectPresent(ApplicationMethods.objCustomerSearch.RegChange_title)) {

			logger.log(LogStatus.PASS, "System sent and shows Success message.");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "System did not send and show Success message.");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 15, dependsOnMethods = { "verify_Request_a_Change" }, enabled = true)
	public void verify_EmailID_Body_Send_change_Request() throws Exception {

		row = 17;

		ApplicationMethods.objCustomerSearch.Request_change_Fill_details_Send();
		if (verifText(ApplicationMethods.objCustomerSearch.messagetext, "Change request has been sent.")) {

			logger.log(LogStatus.PASS, "System sent email and show Success message.");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "System did not send email and show Success message.");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
		ApplicationMethods.objCustomerSearch.popup_OK();
	}

	@Test(priority = 16, enabled = true)
	public void verify_Preview_Confirm() throws Exception {

		row = 18;

		ApplicationMethods.objCustomerSearch.Preview_Link();
		Thread.sleep(3000);
		driver.switchTo().frame(0);
		Thread.sleep(2000);
		if (verifObjectPresent(ApplicationMethods.objCustomerSearch.PreviewProfile)) {

			logger.log(LogStatus.PASS, "System opens 'View Confirmation' modal window with necessary details.");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "System did not open 'View Confirmation' modal window with necessary details.");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}

		driver.switchTo().defaultContent();
	}

	@Test(priority = 17, dependsOnMethods = { "verify_Preview_Confirm" }, enabled = true)
	public void verify_preview_close() throws Exception {

		row = 19;

		ApplicationMethods.objCustomerSearch.preview_close();
		if (verifObjectPresent(ApplicationMethods.objCustomerSearch.preview_xpath)) {

			logger.log(LogStatus.PASS, "System closes the Preview Confirmation window.");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "System did not close the Preview Confirmation window.");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 18, enabled = true)
	public void verify_all_accordions() throws Exception {

		row = 20;

		ApplicationMethods.objCustomerSearch.All_Accortions_link();
		if (verifObjectPresent(ApplicationMethods.objCustomerSearch.preview_xpath)) {

			logger.log(LogStatus.PASS, "All accordions displays with necessary details without error.");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "All accordions did not display necessary details without error.");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 19, enabled = false)
	public void verify_Customer_Search_page() throws Exception {		
		
		row = 21;			

		// Enable WebStaff in Prod ShowMan		
		String DPmainwin = driver.getWindowHandle();
		ApplicationMethods.objCustomerSearch.openShowMan_DPConfig(true, "CHECKED");
		 // Enable DP Config and edit in WebStaff
		switchIfWindowsAre(driver, 2);
		driver.switchTo().window(DPmainwin);
		
		Thread.sleep(2000);
		scrollingToTopofAPage();
		ApplicationMethods.objCustomerSearch.Back_To_SearchCriteria_Profile();
		if (verifObjectPresent(ApplicationMethods.objCustomerSearch.viewprofileicon_xpath)) {

			logger.log(LogStatus.PASS, "System takes back to Customer Search page.");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "System did not take back to Customer Search page.");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 20, dependsOnMethods = {"verify_Customer_Search_page"}, enabled = false)
	public void verify_WebStaff_Edit() throws AWTException, Exception {

		row = 22;

		String DPmainwin = driver.getWindowHandle();
		
		switchIfWindowsAre(driver, 2);
		driver.switchTo().window(DPmainwin);
		
		ApplicationMethods.objCustomerSearch.edit_profile_icon();
		switchIfWindowsAre(driver, 2);

		if (verifObjectPresent(ApplicationMethods.objCustomerSearch.WebStaffRegID)) {

			logger.log(LogStatus.PASS, "System takes to WebStaff Search page.");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "System did not take to WebStaff Search page.");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
		driver.close();
		driver.switchTo().window(DPmainwin);
	}

	@Test(priority = 22, enabled = false)
	public void verify_Add_Link() throws Exception {

		row = 26;

		String mainpage = driver.getWindowHandle();
		ApplicationMethods.objCustomerSearch.Add_Record();
		switchIfWindowsAre(driver, 2);

		if (verifObjectPresent(ApplicationMethods.objCustomerSearch.WebStaffRegID)) {

			logger.log(LogStatus.PASS, "System takes to WebStaff Search page.");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "System did not take to WebStaff Search page.");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
		driver.close();
		driver.switchTo().window(mainpage);

	}
	
// Test Case row 27th need to test manually. 
	
	@Test(priority = 23, enabled = false) // 
	public void verify_WebStaff_Transaction() throws Exception {

		row = 28;

		ApplicationMethods.objCustomerSearch.dollar_icon();
		if (verifObjectPresent(ApplicationMethods.objCustomerSearch.Acc_Trans)) {

			logger.log(LogStatus.PASS, "System is directly takes to 'Transactions' accordion");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "System did not take to Transactions accordion");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 24, enabled = true)
	public void verify_email_icon() throws Exception {

		row = 29;

		scrollingToTopofAPage();
		ApplicationMethods.objCustomerSearch.Back_To_SearchCriteria_Profile();
		ApplicationMethods.objCustomerSearch.email_icon();
		Thread.sleep(3000);
//		System.out.println("Frame Size: " + driver.findElements(By.tagName("iframe")).size());
		driver.switchTo().frame(0);
		Thread.sleep(2000);
		
		if (verifObjectPresent(ApplicationMethods.objCustomerSearch.PreviewProfile)) {

			logger.log(LogStatus.PASS, "System opens 'View Confirmation' modal window with necessary details.");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "System did not open 'View Confirmation' modal window with necessary details.");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}

		driver.switchTo().defaultContent();

	}

	@Test(priority = 25, dependsOnMethods = { "verify_email_icon" }, enabled = true)
	public void verify_email_preview_close() throws Exception {

		row = 30;

		ApplicationMethods.objCustomerSearch.preview_close();
		if (verifObjectPresent(ApplicationMethods.objCustomerSearch.emailicon_xpath)) {

			logger.log(LogStatus.PASS,
					"System closes the Preview Confirmation window and display Customer Search page.");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL,
					"System did not close the Preview Confirmation window and display Customer Search page.");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}

	}

	@Test(priority = 26, enabled = true)
	public void verify_reset_password() throws Exception {
		
				
		row = 31;

		ApplicationMethods.objCustomerSearch.Back_To_SearchCriteria_Result();
		ApplicationMethods.objCustomerSearch.Reset_button();
		Thread.sleep(2000);
		if (driver.findElement(ApplicationMethods.objCustomerSearch.cussearchLN_xpath).getAttribute("value").isEmpty()) {

			logger.log(LogStatus.PASS, "System clears Search field values.");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "System did not clear Search field values.");
			System.out.println("Test Case Failed -Row#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 27, enabled = true)
	public void verify_Report_page() throws Exception {
		
		row = 32;

		ApplicationMethods.objReportpage.click_Manage_Reports();
		if (verifText(ApplicationMethods.objReportpage.Pagetitle, "Manage Reports")) {

			logger.log(LogStatus.PASS, "System opens Manage Report page and display different types of report.");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "System did not Manage Report page and display different types of report.");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 28, enabled = true)
	public void verify_Report_templates_Count() throws Exception {

		row = 33;

		ApplicationMethods.objReportpage.Report_template_Count();
		if (verifObjectPresent(ApplicationMethods.objReportpage.RegTypeViewReport)) {

			logger.log(LogStatus.PASS, "All 'Counts' reports should get filter ");
			System.out.println("Te"
					+ "st Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "All 'Counts' reports did not get filter ");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 29, enabled = true)
	public void verify_RegType_Report() throws Exception {

		row = 34;

		ApplicationMethods.objReportpage.click_view_RegType();
		if (verifText(ApplicationMethods.objReportpage.RegTypeTitle, "RegType Count")) {

			logger.log(LogStatus.PASS, "Report view details page displays");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "Report view details page did not display");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 30, enabled = true)
	public void verify_ExcelFormat() throws Exception {

		row = 35;

		ApplicationMethods.objReportpage.Run_report_Excel_Format();
		if (VerifyErrorOnPage()) {

			logger.log(LogStatus.PASS, "Report opened without error");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "Report opened with error");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 31, enabled = true)
	public void verify_SaveAs() throws Exception {

		row = 36;

		ApplicationMethods.objReportpage.Save_As();
		if (verifText(ApplicationMethods.objCustomerSearch.messagetext, "Save Successful!")) {

			logger.log(LogStatus.PASS, "Reg Type report saved and return to View Report details page.");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "Reg Type report did not save and return to View Report details page.");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
		Thread.sleep(2000);
		ApplicationMethods.objCustomerSearch.popup_OK();
	}

	@Test(priority = 32, dependsOnMethods = { "verify_SaveAs" }, enabled = true)
	public void verify_BackTo_Manage() throws Exception {

		row = 37;

		ApplicationMethods.objReportpage.click_Back_To_Report();
		if (verifText(ApplicationMethods.objReportpage.Pagetitle, "Manage Reports")) {

			logger.log(LogStatus.PASS, "The Page navigates to Manage Reports..");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "The Page did not navigate to Manage Reports.");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 33, enabled = true)
	public void verify_Saved_Report() throws Exception {

		row = 38;

		ApplicationMethods.objReportpage.MySavedReport();
		if (verifText(ApplicationMethods.objReportpage.SaveReportTitle, ApplicationMethods.objReportpage.ReportName)) {

			logger.log(LogStatus.PASS, "The Saved report opened and displayed report details");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "The Saved report did not open and displayed report details");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 34, enabled = true)
	public void verify_HotelInventoryReport() throws Exception {

		row = 39;

		ApplicationMethods.objReportpage.RunHotelInv();
		if (VerifyErrorOnPage()) {

			logger.log(LogStatus.PASS, "The Hotel Inventory report shows without error.");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "The Hotel Inventory report shows error.");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 35, enabled = true)
	public void verify_Badging_Page() throws Exception {
				
		row = 40;

		ApplicationMethods.objBadgepage.open_Badge_page();
		if (verifText(ApplicationMethods.objBadgepage.pagetitle, "Badging")) {

			logger.log(LogStatus.PASS, "System navigates to Badging page.");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "System did not navigate to Badging page.");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 36, dependsOnMethods = {"verify_Badging_Page"}, enabled = true)
	public void verify_Credentail_report() throws Exception {

		row = 41;

		ApplicationMethods.objBadgepage.select_Credentails();
		if (VerifyErrorOnPage()) {

			logger.log(LogStatus.PASS, "System runs Credentials and show PDF report");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "System did not run Credentials or show PDF");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 37, enabled = true)
	public void verify_Analytics_page() throws Exception {	
		
		row = 42;

		ApplicationMethods.objAnalyticspage.click_Analytics_page();
		if (verifText(ApplicationMethods.objAnalyticspage.pageTitle_xpath, "Registration Analytics - Overview")) {
			logger.log(LogStatus.PASS, "System shows Analytics page");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "System did not show Analytics page");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 38, enabled = true)
	public void verify_Analytics_Reg_Overview() throws Exception {

		row = 43;

		ApplicationMethods.objAnalyticspage.click_overview();
		if (verifText(ApplicationMethods.objAnalyticspage.pageTitle_xpath, "Registration Analytics - Overview")) {
			logger.log(LogStatus.PASS, "System shows Analytics Overview page");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "System did not show Analytics Overview page");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 39, enabled = false)
	public void verify_Analytics_Reg_TimeLine() throws Exception {

		row = 44;
		
		Thread.sleep(3000);
		ApplicationMethods.objAnalyticspage.click_TimeLine();
		if (verifText(ApplicationMethods.objAnalyticspage.pageTitle_xpath, "Registration Analytics - Timeline")) {
			logger.log(LogStatus.PASS, "System shows Analytics Timeline page");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "System did not show Analytics Timeline page");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 40, enabled = true)
	public void verify_Analytics_Reg_Pacing() throws Exception {	

		row = 45;

		ApplicationMethods.objAnalyticspage.click_Pacing();
		if (verifText(ApplicationMethods.objAnalyticspage.pageTitle_xpath, "Registration Analytics - Pacing")) {
			logger.log(LogStatus.PASS, "System shows Analytics Pacing page");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "System did not show Analytics Pacing page");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 41, enabled = true)
	public void verify_Analytics_Reg_Maps() throws Exception {

		row = 46;

		ApplicationMethods.objAnalyticspage.click_Maps();
		if (verifText(ApplicationMethods.objAnalyticspage.pageTitle_xpath, "Registration Analytics - Maps")) {
			logger.log(LogStatus.PASS, "System shows Analytics Maps page");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "System did not show Analytics Maps page");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 42, enabled = false)
	public void verify_Analytics_Reg_Totals() throws Exception {

		row = 47;

		ApplicationMethods.objAnalyticspage.click_Totals();
		if (verifText(ApplicationMethods.objAnalyticspage.pageTitle_xpath, "Registration Analytics - Totals")) {
			logger.log(LogStatus.PASS, "System shows Analytics Totals page");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "System did not show Analytics Totals page");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 43, enabled = true)
	public void verify_Analytics_Reg_Generate_Link() throws Exception {

		row = 48;

		ApplicationMethods.objAnalyticspage.generate_link();
		Thread.sleep(2000);		

		if (verifText(ApplicationMethods.objAnalyticspage.generatePopupTitle, "Share this Page")) {
			logger.log(LogStatus.PASS, "System shows Generate Link Popup");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "System did not show Generate link popup");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 44, dependsOnMethods = {"verify_Analytics_Reg_Generate_Link" }, enabled = true)
	public void verify_Analytics_Reg_Email_Link() throws Exception {

		row = 49;

		ApplicationMethods.objAnalyticspage.generate_email_link();

		if (verifText(ApplicationMethods.objAnalyticspage.SendemailPopupTitle, "Send a Link to this Page")) {
			logger.log(LogStatus.PASS, "System shows Generate Link Popup");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "System did not show Generate link popup");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 45, dependsOnMethods = { "verify_Analytics_Reg_Email_Link" }, enabled = true)
	public void verify_Analytics_Reg_Send_Email() throws Exception {

		row = 50;

		ApplicationMethods.objAnalyticspage.generate_send_email();

		if (verifText(ApplicationMethods.objCustomerSearch.messagetext, "Email has been sent.")) {

			logger.log(LogStatus.PASS, "Success message shows");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "Email not sent, failed");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}

		ApplicationMethods.objCustomerSearch.popup_OK();
		Thread.sleep(2000);
	}

	@Test(priority = 46, enabled = true)
	public void verify_Analytics_Session() throws Exception {

		row = 51;

		ApplicationMethods.objAnalyticspage.click_session_page();
		if (verifText(ApplicationMethods.objAnalyticspage.pageTitle_xpath, "Session Analytics - Overview")) {
			logger.log(LogStatus.PASS, "System shows Analytics Overview page");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "System did not show Analytics Overview page");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 47, enabled = true)
	public void verify_Analytics_Session_Overview() throws Exception {

		row = 52;

		ApplicationMethods.objAnalyticspage.click_overview();
		if (verifText(ApplicationMethods.objAnalyticspage.pageTitle_xpath, "Session Analytics - Overview")) {
			logger.log(LogStatus.PASS, "System shows Analytics Overview page");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "System did not show Analytics Overview page");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 48, enabled = false)
	public void verify_Analytics_Session_TimeLine() throws Exception {

		row = 53;

		ApplicationMethods.objAnalyticspage.click_TimeLine();
		if (verifText(ApplicationMethods.objAnalyticspage.pageTitle_xpath, "Session Analytics - Timeline")) {
			logger.log(LogStatus.PASS, "System shows Analytics Timeline page");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "System did not show Analytics Timeline page");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 49, enabled = true)
	public void verify_Analytics_Session_Pacing() throws Exception {

		row = 54;

		ApplicationMethods.objAnalyticspage.click_Pacing();
		if (verifText(ApplicationMethods.objAnalyticspage.pageTitle_xpath, "Session Analytics - Pacing")) {
			logger.log(LogStatus.PASS, "System shows Analytics Pacing page");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "System did not show Analytics Pacing page");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 50, enabled = true)
	public void verify_Analytics_Session_Maps() throws Exception {

		row = 55;

		ApplicationMethods.objAnalyticspage.click_Maps();
		if (verifText(ApplicationMethods.objAnalyticspage.pageTitle_xpath, "Session Analytics - Maps")) {
			logger.log(LogStatus.PASS, "System shows Analytics Maps page");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "System did not show Analytics Maps page");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 51, enabled = false)
	public void verify_Analytics_Session_Totals() throws Exception {

		row = 56;

		ApplicationMethods.objAnalyticspage.click_Totals();
		if (verifText(ApplicationMethods.objAnalyticspage.pageTitle_xpath, "Session Analytics - Totals")) {
			logger.log(LogStatus.PASS, "System shows Analytics Totals page");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "System did not show Analytics Totals page");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 52, enabled = true)
	public void verify_Analytics_Housing() throws Exception {

		row = 57;

		ApplicationMethods.objAnalyticspage.click_housing_page();
		if (verifText(ApplicationMethods.objAnalyticspage.pageTitle_xpath, "Housing Analytics - Overview")) {
			logger.log(LogStatus.PASS, "System shows Analytics Overview page");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "System did not show Analytics Overview page");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 53, enabled = true)
	public void verify_Analytics_Housing_Overview() throws Exception {

		row = 58;

		ApplicationMethods.objAnalyticspage.click_overview();
		if (verifText(ApplicationMethods.objAnalyticspage.pageTitle_xpath, "Housing Analytics - Overview")) {
			logger.log(LogStatus.PASS, "System shows Analytics Overview page");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "System did not show Analytics Overview page");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 54, enabled = false)
	public void verify_Analytics_Housing_TimeLine() throws Exception {

		row = 59;

		ApplicationMethods.objAnalyticspage.click_TimeLine();
		if (verifText(ApplicationMethods.objAnalyticspage.pageTitle_xpath, "Housing Analytics - Timeline")) {
			logger.log(LogStatus.PASS, "System shows Analytics Timeline page");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "System did not show Analytics Timeline page");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 55, enabled = true)
	public void verify_Analytics_Housing_Pacing() throws Exception {

		row = 60;

		ApplicationMethods.objAnalyticspage.click_Pacing();
		if (verifText(ApplicationMethods.objAnalyticspage.pageTitle_xpath, "Housing Analytics - Pacing")) {
			logger.log(LogStatus.PASS, "System shows Analytics Pacing page");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "System did not show Analytics Pacing page");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 56, enabled = true)
	public void verify_Analytics_Housing_Maps() throws Exception {

		row = 61;

		ApplicationMethods.objAnalyticspage.click_Maps();
		if (verifText(ApplicationMethods.objAnalyticspage.pageTitle_xpath, "Housing Analytics - Maps")) {
			logger.log(LogStatus.PASS, "System shows Analytics Maps page");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "System did not show Analytics Maps page");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 57, enabled = false)
	public void verify_Analytics_Housing_Totals() throws Exception {

		row = 62;

		ApplicationMethods.objAnalyticspage.click_Totals();
		if (verifText(ApplicationMethods.objAnalyticspage.pageTitle_xpath, "Housing Analytics - Totals")) {
			logger.log(LogStatus.PASS, "System shows Analytics Totals page");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "System did not show Analytics Totals page");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 58, enabled = true)
	public void verify_Analytics_Unified() throws Exception {

		row = 63;

		ApplicationMethods.objAnalyticspage.click_Unified_page();
		if (verifText(ApplicationMethods.objAnalyticspage.pageTitle_xpath, "Unified Analytics - Overview")) {
			logger.log(LogStatus.PASS, "System shows Analytics Overview page");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "System did not show Analytics Overview page");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 59, enabled = true)
	public void verify_Analytics_Unified_Overview() throws Exception {

		row = 64;

		ApplicationMethods.objAnalyticspage.click_overview();
		if (verifText(ApplicationMethods.objAnalyticspage.pageTitle_xpath, "Unified Analytics - Overview")) {
			logger.log(LogStatus.PASS, "System shows Analytics Overview page");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "System did not show Analytics Overview page");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 60, enabled = false)
	public void verify_Analytics_Unified_TimeLine() throws Exception {

		row = 65;

		ApplicationMethods.objAnalyticspage.click_TimeLine();
		if (verifText(ApplicationMethods.objAnalyticspage.pageTitle_xpath, "Unified Analytics - Timeline")) {
			logger.log(LogStatus.PASS, "System shows Analytics Timeline page");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "System did not show Analytics Timeline page");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 61, enabled = true)
	public void verify_Analytics_Unified_Pacing() throws Exception {

		row = 66;

		ApplicationMethods.objAnalyticspage.click_Pacing();
		if (verifText(ApplicationMethods.objAnalyticspage.pageTitle_xpath, "Unified Analytics - Pacing")) {
			logger.log(LogStatus.PASS, "System shows Analytics Pacing page");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "System did not show Analytics Pacing page");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 62, enabled = true)
	public void verify_Analytics_Unified_Maps() throws Exception {

		row = 67;

		ApplicationMethods.objAnalyticspage.click_Maps();
		if (verifText(ApplicationMethods.objAnalyticspage.pageTitle_xpath, "Unified Analytics - Maps")) {
			logger.log(LogStatus.PASS, "System shows Analytics Maps page");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "System did not show Analytics Maps page");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 63, enabled = false)
	public void verify_Analytics_Unified_Totals() throws Exception {

		row = 68;

		ApplicationMethods.objAnalyticspage.click_Totals();
		if (verifText(ApplicationMethods.objAnalyticspage.pageTitle_xpath, "Unified Analytics - Totals")) {
			logger.log(LogStatus.PASS, "System shows Analytics Totals page");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "System did not show Analytics Totals page");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 64, enabled = true)
	public void verify_Analytics_Unified_Tour_Link() throws Exception {

		row = 69;

		ApplicationMethods.objAnalyticspage.click_overview();
		ApplicationMethods.objAnalyticspage.tour_link();
		if (verifText(ApplicationMethods.objAnalyticspage.tour_welcomeText, "Welcome!")) {
			logger.log(LogStatus.PASS, "System shows Welcome Tour popups");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "System did not show Welcome popup");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 65, enabled = true)
	public void verify_Analytics_Unified_Tour_Next() throws Exception {

		row = 70;

		ApplicationMethods.objAnalyticspage.tour_next();
		if (verifObjectPresent(ApplicationMethods.objAnalyticspage.tourpreviousbutton_xpath)) {
			logger.log(LogStatus.PASS, "System shows Previous button");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "System did not show Previous button.");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 66, enabled = true)
	public void verify_Analytics_Unified_Tour_Close() throws Exception {

		row = 71;

		ApplicationMethods.objAnalyticspage.tour_close();
		if (verifObjectPresent(ApplicationMethods.objAnalyticspage.tour_xpath)) {
			logger.log(LogStatus.PASS, "System close the tour popup window");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "System did not close the popup window");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 67, enabled = false)
	public void verify_Analytics_Unified_Print() throws Exception {
		
		row = 72;

//		click_xpath(ApplicationMethods.objAnalyticspage.printicon_xpath);		
//		driver.findElement(ApplicationMethods.objAnalyticspage.printicon_xpath).sendKeys(Keys.ENTER);
			
//		System.out.println("Test");
	
		SoftAssert softassert = new SoftAssert();		
		Screen s = new Screen();
		Pattern cancel = new Pattern(System.getProperty("user.dir") + "//SikuliImage//Cancel.png");
		Pattern Print = new Pattern(System.getProperty("user.dir") + "/SikuliImage/Print.png");
		Pattern RegOverview = new Pattern(System.getProperty("user.dir") + "//SikuliImage//RegOverview.png");	
		s.click(Print);		
		Thread.sleep(2000);		
		
		if (s.exists(RegOverview) != null) {
			System.out.println("pass");
			// if (verifObjectPresent(ApplicationMethods.objAnalyticspage.printicon_xpath))
			// {
			logger.log(LogStatus.PASS, "System verified Print window");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			System.out.println("Fail");
			logger.log(LogStatus.FAIL, "System did not close the popup window");
			System.out.println("Test Case Failed#: " + row);
//			Assert.fail();					
			softassert.assertTrue(false);			
		}
		s.click(cancel);
		softassert.assertAll();
	}

	@Test(priority = 68, enabled = false)
	public void verify_Analytics_Unified_RegType_Select() throws Exception {

		row = 73;

		ApplicationMethods.objAnalyticspage.click_Totals();
		click_xpath(ApplicationMethods.objAnalyticspage.regcheckboxone);
		if (VerifyErrorOnPage()) {
			logger.log(LogStatus.PASS, "System verified Reg Type ");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "System did not verify Reg type");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 69, enabled = true)
	public void verify_Analytics_Unified_RegType_Export() throws Exception {

		row = 74;

		ApplicationMethods.objAnalyticspage.Export_button();
		if (VerifyErrorOnPage()) {
			logger.log(LogStatus.PASS, "System verified Reg Type ");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "System did not verify Reg type");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 70, enabled = true)
	public void verify_ExSIGHT_Page() throws Exception {

		row = 75;

		Assert.assertTrue(driver.findElement(ApplicationMethods.objExSIGHTPage.ExSightTitle).isDisplayed(), "ExSIGHT tab displayed");
			
		ApplicationMethods.objExSIGHTPage.Click_ExSIGHT();
		if (verifText(ApplicationMethods.objExSIGHTPage.ExSightTitle, "ExSIGHT")) {
			logger.log(LogStatus.PASS, "System shows ExSight Page");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "System did not show ExSight Page");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 71, dependsOnMethods = {"verify_ExSIGHT_Page"},enabled = true)
	public void verify_ExSIGHT_LeadPage() throws Exception {

		row = 76;

		ApplicationMethods.objExSIGHTPage.OneClickReport();
		if (VerifyErrorOnPage()) {
			logger.log(LogStatus.PASS, "System shows Quick links report");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "System did not show quick link report.");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 72, dependsOnMethods = {"verify_ExSIGHT_Page"}, enabled = true)
	public void verify_ExSIGHT_BoostPage() throws Exception {

		row = 77;

		ApplicationMethods.objExSIGHTPage.Click_Boost();
		if (verifText(ApplicationMethods.objExSIGHTPage.ExSightTitle, "Traffic Boost - Configuration")) {
			logger.log(LogStatus.PASS, "System shows Traffic Boost Configuration Page");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "System did not show Traffic Boost Configuration Page");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 73, dependsOnMethods = {"verify_ExSIGHT_Page"},enabled = true)
	public void verify_ExSIGHT_TrafficBoost_Save() throws Exception {

		row = 78;

		ApplicationMethods.objExSIGHTPage.Click_Boost_Config_Save();
		if (verifText(ApplicationMethods.objCustomerSearch.messagetext, "Save Successful!")) {

			logger.log(LogStatus.PASS, "Traffic Boost Saved and closed the popup box");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "The modal did not Save and update Traffic Boost");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}

		ApplicationMethods.objCustomerSearch.popup_OK();
	}

	@Test(priority = 74, dependsOnMethods = {"verify_ExSIGHT_Page"},enabled = true)
	public void verify_ExSIGHT_CampaignPage() throws Exception {

		row = 79;

		click_xpath(ApplicationMethods.objExSIGHTPage.Campaign_Temp);
		if (verifText(ApplicationMethods.objExSIGHTPage.ExSightTitle, "Traffic Boost - Templates")) {
			logger.log(LogStatus.PASS, "System shows Traffic Boost Templates Page");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "System did not show Traffic Boost Templates Page");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}

	@Test(priority = 75, dependsOnMethods = {"verify_ExSIGHT_Page"},enabled = true)
	public void verify_ExSIGHT_CampaignPage_Upload_Save() throws Exception {

		row = 80;

//		ApplicationMethods.objExSIGHTPage.uploadFile();		
		click_xpath(ApplicationMethods.objExSIGHTPage.ConfigSave);
		if (verifText(ApplicationMethods.objCustomerSearch.messagetext, "Save Successful!")) {
			logger.log(LogStatus.PASS, "Traffic Boost Saved and closed the popup box");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "The modal did not Save and update Traffic Boost");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}

		ApplicationMethods.objCustomerSearch.popup_OK();
	}
	
	@Test(priority = 76, dependsOnMethods = {"verify_ExSIGHT_Page"},enabled = true)
	public void verify_ExSIGHT_Scheduled_Campaigns() throws Exception {

		row = 81;
		
		ApplicationMethods.objExSIGHTPage.scrollingToTopofAPage();
		click_xpath(ApplicationMethods.objExSIGHTPage.Campaign_Sch);
		if (verifText(ApplicationMethods.objExSIGHTPage.ExSightTitle, "Traffic Boost - Scheduled Campaigns")) {
			logger.log(LogStatus.PASS, "System shows Traffic Boost Scheduled Campaigns Page");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "System did not show Traffic Boost Scheduled Campaigns Page");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}
	
	@Test(priority = 77, dependsOnMethods = {"verify_ExSIGHT_Page"},enabled = true)
	public void verify_ExSIGHT_Results() throws Exception {

		row = 82;

		click_xpath(ApplicationMethods.objExSIGHTPage.Campaign_Result);
		if (verifText(ApplicationMethods.objExSIGHTPage.ExSightTitle, "Results")) {
			logger.log(LogStatus.PASS, "System shows Results page");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "System did not show Results page");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}	
	
	// Manual testing from row 83 to 98.. 
	
	@Test(priority = 78, enabled = true)
	public void  verify_LogOut() throws Exception {
		
		row = 99;
		
		click_xpath(ApplicationMethods.Objselectshow.logout_xpath);
		if (verifText(ApplicationMethods.Objselectshow.Logout_Text, "You are now logged out")) {
			logger.log(LogStatus.PASS, "System logged out.");
			System.out.println("Test Case Passed- Row#: " + row);
		} else {
			logger.log(LogStatus.FAIL, "System did not log out");
			System.out.println("Test Case Failed#: " + row);
			Assert.fail();
		}
	}
}
