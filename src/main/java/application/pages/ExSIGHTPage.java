package application.pages;

import java.io.IOException;

import org.openqa.selenium.By;

import project.library.CommonMethods;

public class ExSIGHTPage extends CommonMethods {
	
	By ExSIGHT_xpath = By.xpath("(//a[text()='ExSIGHT'])[1]");
	By Exightleftside = By.xpath("//a[@href='#oneclickreports']");
	By Lead_xpath = By.xpath("(//a[text()='Lead'])[1]");
	public By ExSightTitle = By.xpath("//div[@class='pageTitle']");
	By LeadOneClickReport = By.xpath("//a[@href='#oneclickreports']");
	By OneClickReport = By.className("oneclick-folderlist");
	By Boost_xpath = By.xpath("(//a[text()='Boost'])[1]");
	By boostcampaignSave_xpath = By.xpath("//select[@id='MaxCampaignsPerExhibitor']/following::input");
	By boosttemplateSave_xpath = By.xpath("//input[@id='submitTemplateConfig']");
	By boostcampresults_xpath = By.xpath("//select[@id='dropDownCompanySearch']");
	By boostCamResultsButton_xpath = By.xpath("(//span[text()='Results'])[1]");
	public By Campaign_Temp = By.xpath("//a[contains(.,'Campaign Templates')]");
	public By Campaign_Sch = By.xpath("//a[contains(.,'Scheduled Campaigns')]");
	public By Campaign_Result = By.xpath("//a[contains(.,'Campaign Results')]");
	By Uploadbutton = By.xpath("//input[@type='submit']");
	By removeImage = By.id("buttonRemoveImage");
	public By ConfigSave = By.id("submitTemplateConfig");
	By Browse = By.xpath("//input[@type='file']");
		
	public void Click_ExSIGHT() {
		
		mouseover(ExSIGHT_xpath);
		click_xpath(Lead_xpath);
	}
	
	public void Click_Boost() {
		
		mouseover(ExSIGHT_xpath);
		click_xpath(Boost_xpath);
	}
	
	public void OneClickReport() {
		
		click_xpath(LeadOneClickReport);
		selectItem_Xpath(OneClickReport, "SWAP Reports");			
	}
	
	public void Click_Boost_Config_Save() {
		
		click_xpath(boostcampaignSave_xpath);		
	}
	
	public void uploadFile() throws IOException, Exception {
		
		if (driver.findElement(removeImage).isDisplayed()) {
			click_xpath(removeImage);
			Thread.sleep(2000);
			click_xpath(Browse);
			Thread.sleep(2000);
			Runtime.getRuntime().exec(System.getProperty("user.dir") + "/UploadFile.exe");
			Thread.sleep(2000);
			click_xpath(Uploadbutton);
			Thread.sleep(3000);
			click_xpath(ConfigSave);
			Thread.sleep(2000);
		} else {			
			click_xpath(Browse);
			Thread.sleep(2000);
			Runtime.getRuntime().exec(System.getProperty("user.dir") + "/UploadFile.exe");
			Thread.sleep(2000);
			click_xpath(Uploadbutton);
			Thread.sleep(3000);
			click_xpath(ConfigSave);
			Thread.sleep(2000);
		}
	}	

	
}
