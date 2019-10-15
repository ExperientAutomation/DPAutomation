package application.pages;

import org.openqa.selenium.By;
import project.library.CommonMethods;

public class LoginPage extends CommonMethods{	 
	
	/*
	 * @FindBy(how=How.XPATH, using= "//input[contains(@id,'Username')]")
	 * 
	 * @CacheLookup WebElement username;
	 * 
	 * @FindBy(how=How.XPATH, using="//input[contains(@id,'Password')]")
	 * 
	 * @CacheLookup WebElement password;
	 * 
	 * @FindBy(how=How.XPATH, using="//button[@type='submit']")
	 * 
	 * @CacheLookup WebElement login;
	 */

		   By loginUserName = By.xpath("//input[contains(@id,'Username')]");
		   By loginPassword = By.xpath("//input[contains(@id,'Password')]");
		   By loginButton = By.xpath("//button[@type='submit']");
	public By showcodepage = By.xpath("//span[contains(.,'Choose a Show')]");

	
	
	
	/*
	 * public void enterusername() {
	 * 
	 * WebElement Ele=findElement(driver, loginUserName); highlight(Ele);
	 * Ele.sendKeys(getSeleniumPropety("DP_USER_NAME")); }
	 * 
	 * public void enterpassword() {
	 * 
	 * WebElement Ele=findElement(driver, loginPassword); highlight(Ele);
	 * Ele.sendKeys(getSeleniumPropety("DP_PASSWORD")); }
	 * 
	 * public void clickLogin() { WebElement Ele=findElement(driver, loginButton);
	 * highlight(Ele); Ele.click(); }
	 */

	public void ApplicationUrl(String url) {

		driver.get(url);
	}

	public void LoginToAPplication() {

		enterText_xpath(loginUserName, LoginCredentails("USER_NAME"));
		enterText_xpath(loginPassword, LoginCredentails("PASSWORD"));
		click_xpath(loginButton);
	}
	
	public String verifytext() {
		
		return getText_xpath(showcodepage);
	}
}
