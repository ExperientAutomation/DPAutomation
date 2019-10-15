package project.library;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.io.Files;
import com.relevantcodes.extentreports.LogStatus;

public class CommonMethods extends BaseTestClass {

	public static String getSeleniumPropety(String key) {
		String path = System.getProperty("user.dir") + "/ConfigFile/PathFile.properties";

		FileReader fio;
		Properties seleniumProp = null;
		try {
			fio = new FileReader(path);
			seleniumProp = new Properties();
			seleniumProp.load(fio);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return seleniumProp.getProperty(key);

	}
	
	public String LoginCredentails(String key) {

		String path = "N:\\QA\\R&DQA\\Selenium\\GlobalCredentials\\LoginCredentials.properties";

		FileReader fio;
		Properties objRepoProp = null;
		try {
			fio = new FileReader(path);
			objRepoProp = new Properties();
			objRepoProp.load(fio);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return objRepoProp.getProperty(key);

	}

	public void enterText_xpath(By xpath, String data) {

		WebElement element = null;
		try {

			WebDriverWait wait = new WebDriverWait(driver, 80);
			element = wait.until(ExpectedConditions.visibilityOfElementLocated((xpath)));
			highlight(element);

			element.clear();
			element.sendKeys(data);
			// driver.findElement(xpath).clear();
			// driver.findElement( xpath).sendKeys(data);

			unhighlight(element);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean verifObjectPresent(By xpath) {
		boolean result = false;
		WebElement element = null;
		try {

			WebDriverWait wait = new WebDriverWait(driver, 120);
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
			highlight(element);
			unhighlight(element);
			Thread.sleep(2000);
			try {
				if (driver.findElement((xpath)).isDisplayed()) {
					return result = true;
				} else {

					captureScreenshot();
					return result = false;
				}
			} catch (Exception e) {
				result = false;
				captureScreenshot();
				e.printStackTrace();
			}

		} catch (Exception e) {
			result = false;
			captureScreenshot();
			e.printStackTrace();
		}

		return result;
	}

	public boolean verifText(By showcodepage, String data) {
		boolean result = true;
		WebElement element = null;

		try {

			WebDriverWait wait = new WebDriverWait(driver, 80);
			element = wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated((showcodepage))));
			highlight(element);
			unhighlight(element);
			Thread.sleep(2000);
			// Assert.assertEquals(element.getText().trim(),data);
			Assert.assertEquals(element.getText().toLowerCase().trim().contains(data.toLowerCase()), true);
		
		} catch (Exception e) {
			result = false;
			captureScreenshot();
			e.printStackTrace();
		}

		return result;
	}

	public void enterText_javascriptExecutor(String id, String data) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("document.getElementById('" + id + "').value='" + data + "'");
	}
		
	public void selectItem_Xpath(By xpath, String itemToSelect) {
		try {
			Select s = new Select(driver.findElement((xpath)));
			// s.selectByValue(itemToSelect);
			s.selectByVisibleText(itemToSelect);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void click_xpath(By xpath)  {
		
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 120);
		WebElement element = wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable((xpath))));

		highlight(element);
		unhighlight(element);	
		element.click();
		
	}

	public void doubleClick_Xpath(By xpath) {
		
		Actions action = new Actions(driver);
		WebElement element = driver.findElement((xpath));
		// Mouse over
		action.moveToElement(element).build().perform();
		// Double click
		action.doubleClick(element).build().perform();
	}

	public void mouseover(By xpath) {
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(xpath);
		// Mouse over
		action.moveToElement(element).build().perform();
	}

	public String getText_xpath(By xpath) {
		String text = null;
		try {
			text = driver.findElement((xpath)).getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return text;
	}

	public void switchIfWindowsAre(WebDriver driver, int num) throws Exception {

		if (driver.getWindowHandles().size() == num) {
			for (String handle : driver.getWindowHandles()) {
				driver.switchTo().window(handle);
				Thread.sleep(1000);				
			}

		} else {
			Thread.sleep(1000);
		}
	}

	public String captureScreenshot() {

		try {

			TakesScreenshot ts = (TakesScreenshot) driver;

			File source = ts.getScreenshotAs(OutputType.FILE);

			String des = System.getProperty("user.dir") + ("\\ScreenShots\\")+System.currentTimeMillis()+".png";

			File destination = new File(des);

			logger.log(LogStatus.FAIL, logger.addScreenCapture(des));

			Files.copy(source, destination);

//			System.out.println("TestCase Failed: " + ApplicationMethods.excelsheet.getCellData("DP Test Cases",
//					Testlistener.activitycol, TCExecution.row));
			System.out.println("Screenshot taken");

			return des;

		} catch (Exception e) {

			System.out.println("Exception while taking Screenshot " + e.getMessage());
			return e.getMessage();
		}
	}

	public static void drawBorder(WebDriver driver, String xpath) {

		System.out.println(driver);
		System.out.println("Xpath" + xpath);

		WebElement element_node = driver.findElement(By.xpath(xpath));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].style.border='3px solid red'", element_node);
	}

	// The below method will check for errors on page.
	public Boolean VerifyErrorOnPage() {
		boolean result = true;

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		try {

			Assert.assertFalse(driver.getTitle().toLowerCase().contains("403"), "Page shows 403 Error");
			Assert.assertFalse(driver.getTitle().toLowerCase().contains("error"), "Page shows Error");
			Assert.assertFalse(driver.getCurrentUrl().toLowerCase().contains("404"), "Page shows 404 Error");
			Assert.assertFalse(driver.getCurrentUrl().toLowerCase().contains("The resource cannot be found"), "");
			Assert.assertFalse(driver.getCurrentUrl().toLowerCase().contains("error"), "Page shows Error");
			// Assert.assertFalse(driver.findElements(By.xpath("//*[contains(.,'error')]")).size()
			// > 0,"Page shows Error");

		} catch (AssertionError ex) {
			result = false;

			// logger.log(LogStatus.FAIL, "Tes cases failed");
			captureScreenshot();
			driver.navigate().back();
		}

		return result;
	}

	// Switch to tab
	public void switchToTab() {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "\t");
		driver.switchTo().defaultContent();
	}

	public void highlight(WebElement Ele) {

		((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", Ele);
	}

	public void unhighlight(WebElement Ele) {

		((JavascriptExecutor) driver).executeScript("arguments[0].style.border=''", Ele);
	}

	public WebElement findElement(WebDriver driver, By obje) {
		return new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(obje));
	}

	public void scrollingToElementofAPage(By xapth) {

		WebElement element = null;

		element = driver.findElement(xapth);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
	}

	public void scrollingToBottomofAPage() {

		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public void scrollingToTopofAPage() {

		((JavascriptExecutor) driver).executeScript("scroll(0,-250);");
	}
}
