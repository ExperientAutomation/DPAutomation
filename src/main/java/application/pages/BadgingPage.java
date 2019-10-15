package application.pages;

import org.openqa.selenium.By;

import project.library.CommonMethods;

public class BadgingPage extends CommonMethods {

	By hometablink = By.xpath("(//a[contains(.,'Home')])[1]");
	public By pagetitle = By.xpath("//div[@class='pageTitle']");
	By badgingtablink_xpath = By.xpath("(//a[text()='Badging'])[1]");
	By badgereportcmp_xpath = By.xpath("//div[contains(text(),'Company 3 1/3 x 4')]");
	By badgeregtype_xpath = By.xpath("//input[@id='RegTypeCode_A_']");

	By badgecompanyone = By.xpath("(//input[@id='Company_Index']/../child::label/input)[1]");
	By badgecompanytwo = By.xpath("(//input[@id='Company_Index']/../child::label/input)[3]");	
	By badgerun = By.id("btnRun");
	

	public void open_Badge_page() {
		
		mouseover(hometablink);
		click_xpath(badgingtablink_xpath);
	}
	
	public void select_Credentails() throws Exception {
		
		click_xpath(badgereportcmp_xpath);
		click_xpath(badgeregtype_xpath);
		click_xpath(badgecompanyone);
		click_xpath(badgecompanytwo);
		click_xpath(badgerun);		
	}	
}
