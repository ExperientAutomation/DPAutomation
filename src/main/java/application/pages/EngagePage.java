package application.pages;

import org.openqa.selenium.By;

import project.library.CommonMethods;

public class EngagePage extends CommonMethods{
	
	By engage_xpath = By.xpath("(//a[text()='Engage'])[1]");
	By activity_xpath = By.xpath("(//a[text()='Activity'])[1]");
	By exhibitors_xpath = By.xpath("(//a[text()='Exhibitors'])[1]");
	By sessions_xpath = By.xpath("(//a[text()='Sessions'])[1]");
	By speakers_xpath = By.xpath("(//a[text()='Speakers'])[1]");
	By sponsorships_xpath = By.xpath("(//a[text()='Sponsorships'])[1]");
	By surveys_xpath = By.xpath("(//a[text()='Surveys'])[1]");
	
	public void EngageTab() {
		
		click_xpath(engage_xpath);
	}

	public void ExhibitorsPage() {
		
		mouseover(engage_xpath);
		click_xpath(exhibitors_xpath);
	}
	
	public void SessionPage() {
		
		mouseover(engage_xpath);
		click_xpath(sessions_xpath);
	}
	
	public void SpeakersPage() {
		
		mouseover(engage_xpath);
		click_xpath(speakers_xpath);
	}
	
	public void sponsorshipsPage() {
		
		mouseover(engage_xpath);
		click_xpath(sponsorships_xpath);
	}

	public void SurveysPage() {
		
		mouseover(engage_xpath);
		click_xpath(surveys_xpath);
	}
}
