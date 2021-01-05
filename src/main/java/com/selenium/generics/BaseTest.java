package com.selenium.generics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	public static WebDriver driver;
	public static Properties prop;

	public static String chromeKey = "webdriver.chrome.driver";
	public static String chromeValue = "./drivers/chromedriver.exe";

	// Base Test Constructor
	public BaseTest() {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(
					"D:\\Abdulla Suhail\\work\\SuhailWorkSpace\\src\\Work\\src\\main\\java\\com\\selenium\\config\\config.properties");
			try {
				prop.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	// Method to initialize driver using before method
	@BeforeMethod
	public static void initialization() {
		System.setProperty(chromeKey, chromeValue);
		driver = new ChromeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Method to close the driver using After method
	@AfterMethod
	public static void tearDown() {
		driver.close();
	}

	/**
	 * Check for the title
	 * 
	 * @param title
	 */
	public static void verifyTitle(String title) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleIs(title));
	}

	/**
	 * Verify Element
	 * 
	 * @param element
	 */
	public static void verifyElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
		if (!element.isDisplayed()) {
			System.out.println("Element " + element.getText() + " is not found");
		}
	}

}
