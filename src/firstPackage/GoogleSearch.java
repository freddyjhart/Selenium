package firstPackage;

//import java.util.regex.Pattern;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
//import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

//import org.openqa.selenium.support.ui.Select;

public class GoogleSearch {
	private WebDriver driver;
	private String baseUrl;
	// private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "/Users/freddy/Downloads/geckodriver16.1");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		driver = new FirefoxDriver(capabilities);
		baseUrl = "https://www.google.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testGoogleSearch() throws Exception {
		driver.get(baseUrl + "/");
		driver.findElement(By.id("gbqfq")).clear();
		driver.findElement(By.id("gbqfq")).sendKeys("Google");
		driver.findElement(By.id("gbqfb")).click();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
	/*
	 * private boolean isElementPresent(By by) { try { driver.findElement(by);
	 * return true; } catch (NoSuchElementException e) { return false; } }
	 * 
	 * private String closeAlertAndGetItsText() { try { Alert alert =
	 * driver.switchTo().alert(); if (acceptNextAlert) { alert.accept(); } else
	 * { alert.dismiss(); } return alert.getText(); } finally { acceptNextAlert
	 * = true; } }
	 */
}