package application.pages;

import org.openqa.selenium.By;
import project.library.CommonMethods;

public class SelectShowCode extends CommonMethods {

	By showcodepage = By.xpath("//span[contains(.,'Choose a Show')]");
	By selectshowcode = By.xpath("//input[@id='txtShowCodeFilter']");
	By showcodelink = By.xpath("//button[@id='btn" + getSeleniumPropety("DP_Showcode")+"']");
public	By DPHomepage = By.xpath("//div[@class='pageTitle']");
	By showcodecontinue = By.xpath("//button[@id='btnContinue']");
	public By logout_xpath = By.className("link-logout");
	public By Logout_Text = By.xpath("//a[@class='PostLogoutRedirectUri']/../../h3");

	public void Verify_Enter_showcode_and_click_the_showcode_link() throws Exception {

		enterText_xpath(selectshowcode, getSeleniumPropety("DP_Showcode"));
		click_xpath(showcodelink);
		click_xpath(showcodecontinue);			
	}
	
	

}
