package application.pages;

import org.openqa.selenium.By;
import project.library.CommonMethods;

public class DashBoardPage extends CommonMethods {

	By homelink = By.xpath("(//a[text()='Home'])[1]/ancestor::li");
	By DPshcustomerFN = By.id("FirstName");
	By DPshcustomerLN = By.id("LastName");
	By DPshcustomercmp = By.id("Company");
	By DPshcustomerregid = By.id("RegistrantID");
	public By DPshcusomersearch = By.xpath("//input[@value='Search']");
	public By oneclickreports = By.xpath("//a[@href='#oneclickreports']");
	public By quicklooklink = By.xpath("(//a[@class='dimensionQuickLookLink'])[1]");	
	public By Customersearchpage = By.xpath("//div[@id='searchResultsContainer']");

	public void DPLeftSide_OneclickReport() {

		click_xpath(oneclickreports);		
	}
	
	public void DP_Left_Side_Customer_Search_Button() {
		
		click_xpath(DPshcusomersearch);		
	}
	
	public void DP_Home_link() {
		
		click_xpath(homelink);		
	}
	
	public void DashBoard_FN_LN_Enter() {
		
		enterText_xpath(DPshcustomerFN, "Test");
		enterText_xpath(DPshcustomerLN, "Test");		
	}	
}
