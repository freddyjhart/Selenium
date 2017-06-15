package firstPackage;

//import java.util.regex.Pattern;
import static org.junit.Assert.fail;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
//import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import org.openqa.selenium.support.ui.Select;
// Install geckodriver using "brew install geckodriver"

public class GoogleSearch {
	private WebDriver driver;
	private String baseUrl;
	// private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
		driver = new FirefoxDriver();
		baseUrl = "https://www.google.com";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testGoogleSearch() throws Exception {
		driver.get(baseUrl);
		WebElement element = driver.findElement(By.name("q"));
		element.clear();
		element.sendKeys("Google");
		System.out.println("Sent Google search");
		element.submit();
		System.out.println("Submitted Google search");

		// wait until the google page shows the result
		WebElement myDynamicElement = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.id("resultStats")));

		List<WebElement> findElements = driver.findElements(By.xpath("//*[@id='rso']//h3/a"));

		// this are all the links you like to visit
		for (WebElement webElement : findElements)
		{
			System.out.println(webElement.getAttribute("href"));
		}
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