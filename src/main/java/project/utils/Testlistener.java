package project.utils;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.internal.IResultListener;

import com.relevantcodes.extentreports.LogStatus;

import application.test.TCExecution;
import project.library.ApplicationMethods;
import project.library.CommonMethods;

public class Testlistener extends CommonMethods implements IResultListener{

	public final int usernamecolumn = 5; // Column number for UserName
	public static final int activitycol = 3;
	public static final int expectedresultcol = 4;		
	
	@Override
	public void onTestStart(ITestResult result) {
		
//		System.out.println("TestCase started Row#-"+TCExecution.row+": " +ApplicationMethods.excelsheet.getCellData("DP Test Cases",activitycol,TCExecution.row));			
		logger = report.startTest(result.getMethod().getMethodName());		
		logger.log(LogStatus.INFO, ApplicationMethods.excelsheet.getCellData("DP Test Cases",activitycol,TCExecution.row));
		logger.log(LogStatus.INFO, ApplicationMethods.excelsheet.getCellData("DP Test Cases",expectedresultcol,TCExecution.row));
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
	
//		System.out.println("TestCase Passed: " + result.getName());

		ApplicationMethods.excelsheet.setCellData("DP Test Cases", usernamecolumn + 1, TCExecution.row, "Pass");
		ApplicationMethods.excelsheet.setCellData("DP Test Cases", usernamecolumn, TCExecution.row,System.getProperty("user.name"));
//		logger.log(LogStatus.PASS, "Pass " +result.getName());		
	}
	
	@Override
	public void onTestFailure(ITestResult result) {			
						
		captureScreenshot();						
		ApplicationMethods.excelsheet.setCellData("DP Test Cases", usernamecolumn + 1, TCExecution.row, "Fail");
		ApplicationMethods.excelsheet.setCellData("DP Test Cases", usernamecolumn, TCExecution.row, System.getProperty("user.name"));
		logger.log(LogStatus.FAIL, result.getName()+"- Failed");
		System.out.println("Test Case Failed - Row#: " + TCExecution.row);
	}
	
	@Override
	public void onFinish(ITestContext result) {
		
		System.out.println("Testcases Executed");
		
		report.endTest(logger);
		report.flush();
		
		/*if (((ITestResult) result).getStatus() == ITestResult.FAILURE) {
			String screenshot_path = captureScreenshot(driver, result.getName());
			String image = logger.addScreenCapture(screenshot_path);
			logger.log(LogStatus.INFO, "Fail "+result.getName(), image);
	}*/	
		
	}
	
	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		
		ApplicationMethods.excelsheet.setCellData("DP Test Cases", usernamecolumn + 1, TCExecution.row, "NA");
		ApplicationMethods.excelsheet.setCellData("DP Test Cases", usernamecolumn, TCExecution.row, System.getProperty("user.name"));
		logger.log(LogStatus.SKIP,result.getName());
		System.out.println("SKIPPED-"+TCExecution.row);
		
	}

	@Override
	public void onConfigurationFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onConfigurationSkip(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onConfigurationSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

}
