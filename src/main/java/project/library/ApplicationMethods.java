package project.library;

import application.pages.AnalyticsPage;
import application.pages.BadgingPage;
import application.pages.CutomerSearchPage;
import application.pages.DashBoardPage;
import application.pages.ExSIGHTPage;
import application.pages.LoginPage;
import application.pages.Report_Page;
import application.pages.SelectShowCode;
import project.utils.XlsUtil;

public class ApplicationMethods extends CommonMethods {	
	
	public static XlsUtil excelsheet = new XlsUtil(".//src//main//resources//Test Cases ExcelSheet//DP Test Cases.xlsx");
	
	public static LoginPage ObjLoginPage = new LoginPage();
	
	public static SelectShowCode Objselectshow = new SelectShowCode();
	
	public static DashBoardPage objDashboardpage = new DashBoardPage();
	
	public static CutomerSearchPage objCustomerSearch = new CutomerSearchPage();

	public static Report_Page objReportpage = new Report_Page();
	
	public static BadgingPage objBadgepage = new BadgingPage();
	
	public static AnalyticsPage objAnalyticspage = new AnalyticsPage();
	
	public static ExSIGHTPage objExSIGHTPage = new ExSIGHTPage();

}
